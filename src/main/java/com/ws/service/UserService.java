package com.ws.service;

import com.ws.bean.UserEntry;

/**
 * Created by gl on 2019/4/1.
 */
public interface UserService {

    void save(UserEntry userEntry);

    void findByUserName();

    void findByGroupName();

    void login();

}
