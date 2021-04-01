package com.hzx.service;

import com.hzx.mapper.FriendMapper;
import com.hzx.pojo.User;
import com.hzx.pojo.UserItem;
import com.hzx.utils.FinalString;
import com.hzx.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FriendService {

    @Autowired
    FriendMapper friendMapper;

    public List<UserItem> searchFriend(int uid) {
        List<UserItem> items = new ArrayList<>();
        for (User user : friendMapper.searchFriend(uid)) {
            UserItem item = new UserItem();
            item.setImage(StringUtil.isEmpty(user.getImage()) ? FinalString.DEFAULT_HEAD_IMAGE : user.getImage());
            item.setUserName(user.getUserName());
            item.setSecondTitle(user.getSchool());
            item.setUserId(user.getUserId());
            items.add(item);
        }
        return items;
    }

    public boolean deleteFriend(int uid1, int uid2) {
        if(uid2==1) return false;
        return friendMapper.deleteFriend(uid1, uid2);
    }
}
