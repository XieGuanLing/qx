package com.ws.cache;

import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionSynchronizationAdapter;
import org.springframework.transaction.support.TransactionSynchronizationManager;

/**
 * create by gl
 * on 2019/4/4
 */
@Service
public class LockService {

    @Autowired
    private RedissonClient redissonClient;

    public void lockOnWrite(Object key, Runnable callback) {

        RLock rLock = redissonClient.getLock(key.toString());

        if (rLock.isHeldByCurrentThread()) {
            callback.run();
            return;
        }

        try {
            rLock.lock();
            callback.run();
        } catch (Exception e) {
            throw e;
        } finally {
            rLock.unlock();
        }
    }

    public void lockWithinCurrentTransaction(Object key) {
        TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronizationAdapter() {
            @Override
            public void afterCompletion(int status) {
                unLock(key);
            }
        });

        lock(key);
    }

    private void lock(Object key) {

        RLock rlock = redissonClient.getLock(key.toString());
        if (!rlock.isHeldByCurrentThread()) {
            rlock.lock();
        }

    }

    private void unLock(Object key) {

        RLock rlock = redissonClient.getLock(key.toString());
        if (rlock.isHeldByCurrentThread())
            rlock.unlock();

    }


}
