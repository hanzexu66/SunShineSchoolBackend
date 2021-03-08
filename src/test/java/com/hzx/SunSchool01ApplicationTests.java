package com.hzx;

import com.hzx.mapper.UserMapper;
import com.hzx.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

@SpringBootTest
class SunSchool01ApplicationTests {

    @Autowired
    DataSource dataSource;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    private UserMapper userMapper;

    @Test
    void contextLoads() throws SQLException {
        List<User> userList = userMapper.selectById(1);
        userList.forEach(System.out::println);
    }

}
