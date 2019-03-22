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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by gl on 2017/9/18.
 */
@Controller
@ResponseBody
@Api("用户管理")
@RequestMapping("/user")
public class UserController extends BaseController {


    @Autowired
    private UserService userService;


    @ApiOperation("用户登录")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public JsonResponse login(@RequestBody LoginCommand command) {
        return responseVoid(()->userService.login());
    }


    @RequestMapping("/index")
    public JsonResponse userIndex() {
        return responseVoid(()->userService.findByUserName());
    }


    @RequestMapping("/findByGroupName")
    public JsonResponse findByGroupName() {
        return responseVoid(()->userService.findByGroupName());
    }


}
