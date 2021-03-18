package com.hzx.service;

import com.hzx.mapper.ActivityDetailMapper;
import com.hzx.pojo.ActivityDetail;
import com.hzx.pojo.User;
import com.hzx.pojo.UserForActivity;
import com.hzx.pojo.UserItem;
import com.hzx.utils.FinalString;
import com.hzx.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Service
public class ActivityDetailService {

    @Autowired
    ActivityDetailMapper activityDetailMapper;

    @GetMapping(value = "/viewDetail")
    public ActivityDetail searchOneActivity(int uid, int bid) {
        activityDetailMapper.addHot(bid);
        List<UserItem> items = new ArrayList<>();
        int num = -1;
        if (activityDetailMapper.searchOwner(bid) == uid) {
            List<UserForActivity> users = activityDetailMapper.searchUserByActivity(bid);
            for (UserForActivity user : users) {
                UserItem userItem = new UserItem();
                userItem.setImage(StringUtil.isEmpty(user.getImage()) ? FinalString.DEFAULT_HEAD_IMAGE : user.getImage());
                userItem.setUserName(user.getUserName());
                userItem.setSecondTitle(user.getSchool());
                userItem.setUserId(user.getUserId());
                items.add(userItem);
            }
        } else {
            num = activityDetailMapper.searchUserNumByActivity(bid);
        }
        return new ActivityDetail(items, num, activityDetailMapper.searchText(bid));
    }
}
