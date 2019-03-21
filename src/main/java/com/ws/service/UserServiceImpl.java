package com.ws.service;

import com.ws.bean.UserEntry;
import com.ws.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by gl on 2017/9/16.
 */
@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserRepository userRepository;

    @Override
    public void save(UserEntry userEntry) {
        System.out.println("v1");
    }

    @Override
    public void findByUserName(){
        System.out.println(userRepository.findByUserName("a"));
    }

    @Transactional
    @Override
    public void findByGroupName(){
        userRepository.findByGroupName();
    }



}
