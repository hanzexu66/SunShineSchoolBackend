package com.hzx.controller;

import com.hzx.service.ActivityDetailService;
import com.hzx.utils.GsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ActivityDetailController {
    @Autowired
    ActivityDetailService activityDetailService;

    @GetMapping(value = "/searchActivityDetail")
    public String searchOneActivity(@RequestParam("uid") Integer uid, @RequestParam("bid") Integer bid) {
        return GsonUtil.objectToJson(activityDetailService.searchOneActivity(uid, bid));
    }
}
