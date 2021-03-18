package com.hzx.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hzx.mapper.ActivityListMapper;
import com.hzx.pojo.Activity;
import com.hzx.pojo.ActivityContainer;
import com.hzx.pojo.ActivityItem;
import com.hzx.utils.FinalString;
import com.hzx.utils.RedisUtil;
import com.hzx.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SearchActivityService {

    @Autowired
    ActivityListMapper activityListMapper;

    @Autowired
    RedisUtil redisUtil;

    public ActivityContainer searchActivity(Integer uid, String text, String school, Integer type, Integer sort, Integer page) {

        Page<Activity> activityPage;
        String key = text + '&' + school + '&' + type + '&' + sort + '&' + page;
        activityPage = (Page<Activity>) redisUtil.get(key);
        if (activityPage == null) {
            activityPage = new Page<>(page, 6);
            activityListMapper.selectActivities(activityPage, "%" + text + "%", school, type, sort);
            redisUtil.set(key, activityPage, 600);
        }

        List<ActivityItem> items = new ArrayList<>();
        for (Activity activity : activityPage.getRecords()) {
            generateItem(uid, items, activity);
        }
        ActivityContainer container = new ActivityContainer(items, activityPage.hasNext());
        return container;
    }

    public ActivityContainer searchActivityById(Integer uid){
        List<Activity> activityList=activityListMapper.selectActivityById(uid);
        List<ActivityItem> items = new ArrayList<>();
        for (Activity activity : activityList) {
            generateItem(uid, items, activity);
        }
        return new ActivityContainer(items,false);
    }

    private void generateItem(Integer uid, List<ActivityItem> items, Activity activity) {
        ActivityItem item = new ActivityItem(activity.getUserName(), activity.getType(), activity.getTitle(), StringUtil.isEmpty(activity.getImage()) ? FinalString.DEFAULT_HEAD_IMAGE : activity.getImage(), (activity.getState() == 0 && activity.getUserId() == uid) ? -1 : activity.getState(), activity.getBid());
        items.add(item);
    }
}
