package com.hzx.controller;

import com.hzx.service.FriendService;
import com.hzx.utils.GsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FriendController {
    @Autowired
    FriendService searchFriendService;

    @GetMapping("searchFriend")
    public String searchFriend(@RequestParam("uid") int uid) {
        return GsonUtil.objectToJson(searchFriendService.searchFriend(uid));
    }

    @GetMapping("deleteFriend")
    public Boolean deleteFriend(@RequestParam("uid1") int uid1, @RequestParam("uid2") int uid2) {
        return searchFriendService.deleteFriend(uid1, uid2);
    }
}
