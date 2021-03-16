package com.hzx.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzx.pojo.Friend;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.time.LocalDateTime;

@Repository
public interface FriendMapper extends BaseMapper<Friend> {
    @Override
    int insert(Friend entity);

    @Update("update friend set latest_text=#{text},latest_time=#{date} where " +
            "((person1=#{person1} and person2=#{person2}) or (person1=#{person2} and person2=#{person1}))")
    int update(int person1, int person2, String text, LocalDateTime date);
}
