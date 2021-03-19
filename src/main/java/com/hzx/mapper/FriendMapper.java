package com.hzx.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzx.pojo.ChatItem;
import com.hzx.pojo.Friend;
import com.hzx.pojo.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface FriendMapper extends BaseMapper<Friend> {
    @Override
    int insert(Friend entity);

    @Update("update friend set latest_text=#{text},latest_time=#{date} where " +
            "((person1=#{person1} and person2=#{person2}) or (person1=#{person2} and person2=#{person1}))")
    int update(int person1, int person2, String text, LocalDateTime date);

    @Select("select image,user_name,user_id,school from user where user_id in ((select person1 from friend where person2 = #{uid}) union (" +
            "    select person2 from friend where person1 = #{uid}))")
    List<User> searchFriend(int uid);

    @Delete("delete from friend where ((person1=#{uid1} and person2=#{uid2})or(person1=#{uid2} and person2=#{uid1}))")
    Boolean deleteFriend(int uid1, int uid2);

    @Select("select user_id,user_name,image,latest_text,latest_time from user,friend" +
            " where ((user.user_id=friend.person1 and person2=#{uid}) or " +
            "(user.user_id=friend.person2 and person1=#{uid}))")
    List<ChatItem> selectChat(int uid);
}