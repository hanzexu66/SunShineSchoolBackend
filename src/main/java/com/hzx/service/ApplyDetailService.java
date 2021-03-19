package com.hzx.service;

import com.hzx.mapper.ApplyMapper;
import com.hzx.mapper.UserMapper;
import com.hzx.pojo.ApplyDetail;
import com.hzx.pojo.User;
import com.hzx.pojo.UserItem;
import com.hzx.utils.FinalString;
import com.hzx.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApplyDetailService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    ApplyMapper applyMapper;

    public ApplyDetail searchApplyDetail(int uid, int bid) {
        User user = userMapper.selectById(uid);
        UserItem item = new UserItem();
        item.setUserId(user.getUserId());
        item.setSecondTitle(user.getSchool());
        item.setUserName(user.getUserName());
        item.setImage(StringUtil.isEmpty(user.getImage()) ? FinalString.DEFAULT_HEAD_IMAGE : user.getImage());
        String reason = applyMapper.selectById(uid, bid).get(0).getReason();
        return new ApplyDetail(item, reason);
    }

}
