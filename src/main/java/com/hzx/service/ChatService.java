package com.hzx.service;

import com.hzx.mapper.ChatMapper;
import com.hzx.mapper.FriendMapper;
import com.hzx.pojo.Chat;
import com.hzx.pojo.Chat2;
import com.hzx.pojo.ChatItem;
import com.hzx.pojo.MsgItem;
import com.hzx.utils.FinalString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ChatService {
    @Autowired
    ChatMapper chatMapper;

    @Autowired
    FriendMapper friendMapper;

    @Transactional(rollbackFor = {RuntimeException.class, Error.class})
    public void sendMessage(Integer sendUser, Integer receiveUser, String text) {
        chatMapper.insert(new Chat(sendUser, receiveUser, LocalDateTime.now(), text));
        friendMapper.update(sendUser, receiveUser, text, LocalDateTime.now());
    }

    public List<MsgItem> receive(int uid1, int uid2) {
        List<Chat2> chats = chatMapper.selectByMap(uid1, uid2);
        List<MsgItem> items = new ArrayList<>();
        for (Chat2 chat : chats) {
            MsgItem item = new MsgItem(chat.getSendUser() == uid1, chat.getText(), chat.getTime());
            items.add(item);
        }
        return items;
    }
}
