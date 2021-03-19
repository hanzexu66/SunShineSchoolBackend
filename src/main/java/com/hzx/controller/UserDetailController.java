package com.hzx.controller;

import com.hzx.pojo.User;
import com.hzx.service.UserService;
import com.hzx.utils.GsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserDetailController {
    @Autowired
    UserService userService;

    @GetMapping("userDetail")
    public String searchUserDetail(@RequestParam("uid") int uid) {
        return GsonUtil.objectToJson(userService.searchUserById(uid));
    }
}
