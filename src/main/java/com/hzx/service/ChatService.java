package com.hzx.service;

import com.hzx.mapper.ChatMapper;
import com.hzx.mapper.FriendMapper;
import com.hzx.pojo.Chat;
import com.hzx.utils.FinalString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDateTime;

@Service
public class ChatService {
    @Autowired
    ChatMapper chatMapper;

    @Autowired
    FriendMapper friendMapper;

    public void sendMessage(Integer sendUser,Integer receiveUser,String text){
        chatMapper.insert(new Chat(sendUser,receiveUser,LocalDateTime.now(), text));
        friendMapper.update(sendUser,receiveUser,text,LocalDateTime.now());
    }
}
