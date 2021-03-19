package com.hzx.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface ActivityMapper {

    @Update("update activity set state=1,choose_user=#{choose_user} where bid =#{bid}")
    void chooseUser(int bid, int choose_user);

    @Select("select state from activity where bid = #{bid}")
    int isDone(int bid);

    @Insert("insert into activity(type,time,hot,create_user,title,text,state) " +
            "VALUES (#{type},#{time},0,#{uid},#{title},#{text},0)")
    boolean insert(int type, LocalDateTime time, Integer uid, String title, String text);
}
