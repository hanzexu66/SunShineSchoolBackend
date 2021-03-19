package com.hzx.controller;

import com.hzx.service.ChooseApplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChooseApplierController {
    @Autowired
    ChooseApplierService chooseApplierService;

    @GetMapping("choosePerson")
    public Boolean isChoose(@RequestParam("owner") int owner, @RequestParam("uid") int uid, @RequestParam("bid") int bid) {
        return chooseApplierService.isChoose(owner, uid, bid);
    }
}
