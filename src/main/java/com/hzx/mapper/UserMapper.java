package com.hzx.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzx.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Repository
public interface UserMapper extends BaseMapper<User> {

    @Select("SELECT * FROM user WHERE user_id = #{id}")
    List<User> selectById(int id);

    @Override
    List<User> selectByMap(Map<String, Object> columnMap);

    @Select("SELECT * FROM user WHERE user_name = #{user_name} and password=#{password}")
    User selectByNameAndPwd(String user_name, String password);

    @Select("SELECT * FROM user WHERE user_name = #{user_name}")
    List<User> selectByName(String user_name);

    @Override
    int insert(User entity);
}
