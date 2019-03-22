package com.ws.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * create by gl
 * on 2019/3/21
 */
@ApiModel("登录参数")
public class LoginCommand {

    @ApiModelProperty("名称")
    private String name;

    @ApiModelProperty("密码")
    private String password;

    @Override
    public String toString() {
        return "LoginCommand{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
