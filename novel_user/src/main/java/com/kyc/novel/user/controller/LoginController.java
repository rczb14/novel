package com.kyc.novel.user.controller;

import cn.dev33.satoken.stp.StpUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/login")
public class LoginController {

    @GetMapping("/in")
    public void loginIn(){
        StpUtil.login(10001);
    }
}
