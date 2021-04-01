package com.hzx.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzx.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Repository
public interface UserMapper extends BaseMapper<User> {

    @Select("SELECT * FROM user WHERE user_id = #{id}")
    User selectById(int id);

    @Override
    List<User> selectByMap(Map<String, Object> columnMap);

    @Select("SELECT * FROM user WHERE user_name = #{user_name} and password=#{password}")
    User selectByNameAndPwd(String user_name, String password);

    @Select("SELECT * FROM user WHERE user_name = #{user_name}")
    List<User> selectByName(String user_name);

    @Override
    int insert(User entity);

    @Update("update user set image=#{image} where user_id=#{uid}")
    int updateById(int uid, String image);

    @Update("update user set password=#{newPassword} where user_id=#{uid}")
    boolean updatePassword(int uid, String newPassword);

    @Select("select count(*) from user where user_id=#{uid} and password=#{oldPassword}")
    Integer selectByPasswordAndId(int uid, String oldPassword);

    @Update("update user set real_name=#{realName},school=#{school},user_name=#{userName}," +
            "sid=#{sid},profile=#{profile} where user_id=#{uid}")
    boolean updateInfo(int uid, String realName, String school, String userName, String sid, String profile);
}
