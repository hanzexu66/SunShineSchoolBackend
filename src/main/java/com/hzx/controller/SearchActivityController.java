package com.hzx.controller;

import com.hzx.service.SearchActivityService;
import com.hzx.utils.GsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SearchActivityController {

    @Autowired
    SearchActivityService searchActivityService;

    @GetMapping(value = "/searchAll")
    public String searchById(@RequestParam("uid") Integer uid, @RequestParam("text") String text,
                             @RequestParam("school") String school, @RequestParam("type") Integer type,
                             @RequestParam("sort") Integer sort, @RequestParam("page") int page) {
        return GsonUtil.objectToJson(searchActivityService.searchActivity(uid, text, school, type, sort, page));
    }

}
