package com.hzx.controller;

import com.hzx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChangeInfoController {
    @Autowired
    UserService userService;

    @PostMapping("changePassword")
    public boolean changePassword(@RequestParam("uid") int uid, @RequestParam("oldPassword") String oldPassword, @RequestParam("newPassword") String newPassword) {
        return userService.changePassword(uid, oldPassword, newPassword);
    }

    @PostMapping("changeInfo")
    public boolean changeInfo(@RequestParam("realName") String realName, @RequestParam("school") String school,
                              @RequestParam("userName") String userName, @RequestParam("sid") String sid,
                              @RequestParam("profile") String profile, @RequestParam("uid") int uid) {
        return userService.changeInfo(uid, realName, school, userName, sid, profile);
    }
}
