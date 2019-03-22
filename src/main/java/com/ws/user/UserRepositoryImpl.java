package com.ws.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.persistence.EntityManager;

/**
 * create by gl
 * on 2019/3/20
 */
public class UserRepositoryImpl implements UserRepositoryCustom {

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public UserEntity findByGroupName() {
        jdbcTemplate.execute("SELECT * FROM sm_user where user_id = 1");
        return null;
    }
}
