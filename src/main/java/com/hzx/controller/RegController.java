package com.hzx.controller;

import com.hzx.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegController {

    @Autowired
    AccountService accountService;

    @PostMapping(value = "/register")
    public Boolean register(@RequestParam("realName") String realName, @RequestParam("userName") String userName, @RequestParam("password") String password, @RequestParam("school") String school, @RequestParam("sid") String sid) {
        return accountService.register(userName, school, realName, password, sid);
    }

}
