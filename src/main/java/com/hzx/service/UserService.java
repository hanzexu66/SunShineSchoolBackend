package com.hzx.service;

import com.hzx.mapper.UserMapper;
import com.hzx.pojo.User;
import com.hzx.utils.FinalString;
import com.hzx.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;

    public User searchUserById(int uid) {
        User user = userMapper.selectById(uid);
        if (StringUtil.isEmpty(user.getImage())) {
            user.setImage(FinalString.DEFAULT_HEAD_IMAGE);
        }
        user.setPassword("");
        return user;
    }

    public boolean changePassword(int uid, String oldPassword, String newPassword) {
        if (userMapper.selectByPasswordAndId(uid, oldPassword) > 0) {
            userMapper.updatePassword(uid, newPassword);
            return true;
        } else {
            return false;
        }
    }

    public boolean changeInfo(int uid, String realName, String school, String userName, String sid, String profile) {
        return userMapper.updateInfo(uid, realName, school, userName, sid, profile);
    }
}
