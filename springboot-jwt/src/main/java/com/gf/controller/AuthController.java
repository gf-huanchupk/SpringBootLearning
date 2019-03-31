package com.gf.controller;

import com.gf.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    private AuthService authService;


    /**
     * 登录
     */
    @PostMapping(value = "/auth/login")
    public String login( String username,String password ) throws AuthenticationException {
        // 登录成功会返回Token给用户
        return authService.login( username, password );
    }

    @PostMapping(value = "/user/hi")
    public String userHi( String name ) throws AuthenticationException {
        return "hi " + name + " , you have 'user' role";
    }

    @PostMapping(value = "/admin/hi")
    public String adminHi( String name ) throws AuthenticationException {
        return "hi " + name + " , you have 'admin' role";
    }


}
