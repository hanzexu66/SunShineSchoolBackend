package com.hzx.controller;

import com.hzx.mapper.UserMapper;
import com.hzx.pojo.User;
import com.hzx.utils.GsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserMapper userMapper;

    @GetMapping(value = "/search")
    public String searchById(@RequestParam int id){

        System.out.println(id);
        return GsonUtil.objectToJson(userMapper.selectById(id));
    }

}
