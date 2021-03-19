package com.hzx.controller;

import com.hzx.service.ChatItemService;
import com.hzx.service.ChatService;
import com.hzx.utils.GsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatController {

    @Autowired
    ChatItemService chatItemService;

    @Autowired
    ChatService chatService;

    @GetMapping("searchChat")
    public String searchAllChat(@RequestParam("uid") int uid) {
        return GsonUtil.objectToJson(chatItemService.searchChatItem(uid));
    }

    @GetMapping("receive")
    public String searchOneChat(@RequestParam("uid1") int uid1, @RequestParam("uid2") int uid2) {
        return GsonUtil.objectToJson(chatService.receive(uid1, uid2));
    }

    @GetMapping("send")
    public boolean sendChat(@RequestParam("uid1") int uid1, @RequestParam("uid2") int uid2, @RequestParam("text") String text) {
        chatService.sendMessage(uid1, uid2, text);
        return true;
    }
}
