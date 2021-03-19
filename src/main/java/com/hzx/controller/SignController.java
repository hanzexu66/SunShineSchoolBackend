package com.hzx.controller;

import com.hzx.service.ApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SignController {

    @Autowired
    ApplyService applyService;

    @GetMapping(value = "/sign")
    public boolean isApply(@RequestParam("uid") Integer uid, @RequestParam("bid") Integer bid, @RequestParam("reason") String reason) {
        return applyService.applyActivity(uid, bid, reason);
    }
}
