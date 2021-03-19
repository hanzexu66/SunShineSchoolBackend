package com.hzx.service;

import com.hzx.mapper.ChatMapper;
import com.hzx.mapper.FriendMapper;
import com.hzx.pojo.ChatItem;
import com.hzx.utils.FinalString;
import com.hzx.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatItemService {
    @Autowired
    FriendMapper friendMapper;

    public List<ChatItem> searchChatItem(int uid) {
        List<ChatItem> items = friendMapper.selectChat(uid);
        for (ChatItem item : items) {
            if (StringUtil.isEmpty(item.getImage())) {
                item.setImage(FinalString.DEFAULT_HEAD_IMAGE);
            }
        }
        return items;
    }
}
