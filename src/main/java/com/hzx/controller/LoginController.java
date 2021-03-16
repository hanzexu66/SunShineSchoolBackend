package com.hzx.controller;

import com.hzx.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginController {

    @Autowired
    AccountService accountService;

    @PostMapping(value = "/login")
    public Integer login(@RequestParam("name") String name, @RequestParam("password") String password) {
        return accountService.hasUser(name, password);
    }
}
