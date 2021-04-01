package com.hzx.service;

import com.hzx.mapper.ChatMapper;
import com.hzx.mapper.FriendMapper;
import com.hzx.mapper.UserMapper;
import com.hzx.pojo.Chat;
import com.hzx.pojo.Friend;
import com.hzx.pojo.User;
import com.hzx.utils.FinalString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.Random;

@Service
public class AccountService {
    @Autowired
    UserMapper userMapper;

    @Autowired
    FriendMapper friendMapper;

    @Autowired
    ChatMapper chatMapper;

    @Autowired
    ChatService chatService;

    public Integer hasUser(String user_name, String password) {
        User user = userMapper.selectByNameAndPwd(user_name, password);
        return user != null ? user.getUserId() : -1;
    }

    public Boolean register(String userName, String school, String realName, String password, String sid) {
        if (userMapper.selectByName(userName).isEmpty()) {
            User user = new User();
            user.setPassword(password);
            user.setRealName(realName);
            user.setSchool(school);
            user.setSid(sid);
            user.setUserName(userName);
            userMapper.insert(user);
            userMapper.updateById(user.getUserId(), FinalString.IMAGE_ROOT + (user.getUserId()) % 10 + ".jpg");
            //添加好友
            friendMapper.insert(new Friend(1, user.getUserId(), null, null));
            chatService.sendMessage(1, user.getUserId(), FinalString.HELLO_FROM_SYSTEM);
            return true;
        }
        return false;
    }


}
