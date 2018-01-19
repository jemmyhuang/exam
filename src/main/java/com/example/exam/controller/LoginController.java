package com.example.exam.controller;

import com.example.exam.constans.ModelResult;
import com.example.exam.domain.User;
import com.example.exam.service.UserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/main")
public class LoginController {

    @Resource(name = "userService")
    UserService userService;

    @ApiOperation(value = "登陆", notes = "根据username和password登陆用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名", required = true, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "password", value = "密码", required = true, paramType = "query", dataType = "String"),
    })
    @PostMapping(value = "/login", produces = "application/json; charset=UTF-8")
    public ModelResult login(String username, String password) {
        User user = userService.queryUserByName(username, password);
        return new ModelResult<User>(user);
    }
}
