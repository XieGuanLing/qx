package com.ws.misc;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.hibernate.Filter;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import javax.persistence.EntityManager;

/**
 *
 */
//@Aspect
//@Component
public class NotSoftDeleteAspect {

    private static final Logger logger = Logger.getLogger(NotSoftDeleteAspect.class);


    // this is a shared entityManager!
    @Autowired
    private EntityManager entityManager;
//    @Autowired
//    private JpaTransactionManager jpaTransactionManager;


    @Pointcut("execution(public * org.springframework.data.jpa.repository.JpaRepository+.find*(..))"
            + " || execution(public * org.springframework.data.jpa.repository.JpaRepository+.read*(..))"
            + " || execution(public * org.springframework.data.jpa.repository.JpaRepository.query*(..))"
            + " || execution(public * org.springframework.data.jpa.repository.JpaRepository+.list*(..))"
            + " || execution(public * org.springframework.data.jpa.repository.JpaRepository+.count*(..))"
            + " || execution(public * org.springframework.data.jpa.repository.JpaRepository+.get*(..))")
    private void repositoryQueryMethod() {

    }

    @Around("repositoryQueryMethod()")
    public Object repositoryQueryMethod(ProceedingJoinPoint pjp) throws Throwable {
        return wrapInFilter(pjp);
    }

    private Object wrapInFilter(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        boolean enabled = false;
        boolean readOnly = false;
        Session session;
        try {
            session = entityManager.unwrap(Session.class);
        } catch (Exception e) {// from transactionTemplate?
            logger.debug("TransactionSynchronizationManager.getResource 。。。 ");
            session = (Session) TransactionSynchronizationManager.getResource(entityManager.getEntityManagerFactory());
//            EntityManagerHolder holder = (EntityManagerHolder) TransactionSynchronizationManager.getResource(jpaTransactionManager.getEntityManagerFactory());
//            session = holder.getEntityManager().unwrap(Session.class);
        }

        if ( session.isOpen()) {
            Filter filter = session.getEnabledFilter(DataFilterConstants.NOT_SOFT_DELETE_FILTER_NAME);
            if (filter == null) {
                session.enableFilter(DataFilterConstants.NOT_SOFT_DELETE_FILTER_NAME);
                enabled = true;
            }
        }

        MethodSignature signature = (MethodSignature) proceedingJoinPoint.getSignature();
        if (signature.getMethod().getName().startsWith("read")){
            session.setDefaultReadOnly(true);
            readOnly = true;
        }

        Object object = proceedingJoinPoint.proceed();

        if (enabled)
            session.disableFilter(DataFilterConstants.NOT_SOFT_DELETE_FILTER_NAME);

        if (readOnly)
            session.setDefaultReadOnly(false);

        return object;
    }



}
