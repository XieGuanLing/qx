package com.ws.user;

import com.ws.advice.JsonResponse;
import com.ws.misc.BaseController;
import com.ws.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by gl on 2017/9/18.
 */
@Controller
@ResponseBody
@Api("用户管理")
public class UserController extends BaseController {


    @Autowired
    private UserService userService;


    @RequestMapping("/")
    public JsonResponse home() {
        return response(()->"Hello World!");
    }

    @ApiOperation("用户登录")
    @RequestMapping("/login")
    public JsonResponse login(@RequestBody LoginCommand command) {
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
