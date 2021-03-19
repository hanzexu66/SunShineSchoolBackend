package com.hzx.controller;

import com.hzx.service.ApplyDetailService;
import com.hzx.utils.GsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApplyDetailController {
    @Autowired
    ApplyDetailService applyDetailService;

    @GetMapping(value = "/applyDetail")
    public String applyDetail(@RequestParam("uid") int uid, @RequestParam("bid") int bid) {
        return GsonUtil.objectToJson(applyDetailService.searchApplyDetail(uid, bid));
    }

}
