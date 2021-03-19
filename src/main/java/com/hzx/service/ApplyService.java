package com.hzx.service;

import com.hzx.mapper.ApplyMapper;
import com.hzx.pojo.Apply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApplyService {
    @Autowired
    ApplyMapper applyMapper;

    public boolean applyActivity(int uid, int bid, String reason) {
        if (applyMapper.selectById(uid, bid).isEmpty()) {
            applyMapper.insert(new Apply(uid, bid, reason));
            return true;
        } else {
            return false;
        }
    }
}
