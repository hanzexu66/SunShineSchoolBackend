package com.hzx;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hzx.mapper.ChatMapper;
import com.hzx.mapper.FriendMapper;
import com.hzx.mapper.UserMapper;
import com.hzx.pojo.Activity;
import com.hzx.pojo.ActivityContainer;
import com.hzx.pojo.ActivityDetail;
import com.hzx.pojo.User;
import com.hzx.service.ActivityDetailService;
import com.hzx.service.SearchActivityService;
import com.hzx.utils.RedisUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@SpringBootTest
class SunSchool01ApplicationTests {

    @Autowired
    DataSource dataSource;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    SearchActivityService searchActivityService;

    @Autowired
    ActivityDetailService activityDetailService;

    @Autowired
    RedisUtil redisUtil;

    @Autowired
    FriendMapper friendMapper;

    @Autowired
    ChatMapper chatMapper;

    @Test
    void contextLoads() throws SQLException {

    }

}
