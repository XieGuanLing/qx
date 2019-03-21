package com.ws.user;

import com.ws.advice.JsonResponse;
import com.ws.misc.BaseController;
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
    public JsonResponse userIndex() {
        return responseVoid(()->userService.findByUserName());
    }


    @RequestMapping("/user/findByGroupName")
    public JsonResponse findByGroupName() {
        return responseVoid(()->userService.findByGroupName());
    }


}
