package com.hzx.mapper;

import com.hzx.pojo.Activity;
import com.hzx.pojo.UserForActivity;
import com.hzx.pojo.UserItem;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActivityDetailMapper {

    @Select("select image,user_id,user_name,school from apply,user where apply.uid=user.user_id and bid = #{bid}")
    List<UserForActivity> searchUserByActivity(int bid);

    @Select("select count(*) from apply where bid = #{bid}")
    Integer searchUserNumByActivity(int bid);

    @Select("select create_user from activity where bid = #{bid}")
    Integer searchOwner(int bid);

    @Select("select text from activity where bid = #{bid}")
    String searchText(int bid);

    @Update("update activity set hot = hot+1 where bid = #{bid}")
    void addHot(int bid);
}
