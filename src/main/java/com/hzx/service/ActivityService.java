package com.hzx.service;

import com.hzx.mapper.ActivityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ActivityService {
    @Autowired
    ActivityMapper activityMapper;

    public boolean setUpActivity(int type, int uid, String title, String text) {
        activityMapper.insert(type, LocalDateTime.now(), uid, title, text);
        return true;
    }
}
