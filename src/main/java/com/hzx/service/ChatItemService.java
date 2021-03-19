package com.hzx.service;

import com.hzx.mapper.ChatMapper;
import com.hzx.mapper.FriendMapper;
import com.hzx.pojo.ChatItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatItemService {
    @Autowired
    FriendMapper friendMapper;

    public List<ChatItem> searchChatItem(int uid) {
        return friendMapper.selectChat(uid);
    }
}
