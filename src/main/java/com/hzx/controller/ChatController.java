package com.hzx.controller;

import com.hzx.service.ChatItemService;
import com.hzx.utils.GsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatController {

    @Autowired
    ChatItemService chatItemService;

    @GetMapping("chat")
    public String search(@RequestParam("uid") int uid) {
        return GsonUtil.objectToJson(chatItemService.searchChatItem(uid));
    }

}
