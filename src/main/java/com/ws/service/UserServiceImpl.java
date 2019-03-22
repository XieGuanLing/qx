package com.ws.service;

import com.ws.bean.UserEntry;
import com.ws.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by gl on 2017/9/16.
 */
@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    HttpServletRequest request;

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

    @Override
    public void login(){
        HttpSession session = request.getSession(true);
    }


}
