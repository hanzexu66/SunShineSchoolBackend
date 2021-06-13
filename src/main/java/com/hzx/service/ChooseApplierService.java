package com.hzx.service;

import com.hzx.mapper.ActivityMapper;
import com.hzx.mapper.ChatMapper;
import com.hzx.mapper.FriendMapper;
import com.hzx.pojo.Chat;
import com.hzx.pojo.Friend;
import com.hzx.pojo.UserItem;
import com.hzx.utils.FinalString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ChooseApplierService {

    @Autowired
    ActivityMapper activityMapper;
    @Autowired
    FriendMapper friendMapper;
    @Autowired
    ChatService chatService;
    @Autowired
    FriendService friendService;

    public boolean isChoose(int owner, int uid, int bid) {
        if (activityMapper.isDone(bid) == 0) {
            activityMapper.chooseUser(bid, uid);
            boolean isFriend=false;
            List<UserItem> items= friendService.searchFriend(owner);
            for (UserItem item:items){
                if(item.getUserId()==uid){
                    isFriend=true;
                    break;
                }
            }
            if(!isFriend){
                friendMapper.insert(new Friend(uid, owner, null, null));
            }
            chatService.sendMessage(owner, uid, FinalString.HELLO_FROM_FRIEND);
            return true;
        } else {
            return false;
        }
    }
}
