package com.hzx.controller;

import com.hzx.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SetUpActivityController {
    @Autowired
    ActivityService activityService;

    @GetMapping("setUpActivity")
    public Boolean setUpActivity(@RequestParam("type") int type, @RequestParam("uid") int uid, @RequestParam("title") String title, @RequestParam("text") String text) {
        return activityService.setUpActivity(type, uid, title, text);
    }
}
