package com.hzx.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzx.pojo.User;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

@Repository
public interface UserMapper  {

    @Select("SELECT * FROM user WHERE user_id = #{id}")
    List<User> selectById(int id);



}
