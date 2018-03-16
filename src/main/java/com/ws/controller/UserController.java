package com.ws.controller;

import com.ws.interceptor.JsonResponse;
import com.ws.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by gl on 2017/9/18.
 */
@Controller
@ResponseBody
public class UserController extends BaseController {


    @Autowired
    private UserService userService;


    @RequestMapping("/")
    public JsonResponse home() {
        return response(()->"Hello World!");
    }

    @RequestMapping("/login")
    public JsonResponse login() {
        return response(()->"login");
    }


    @RequestMapping("/user/index")
    public String userIndex() {
        return "user index";
    }



}
