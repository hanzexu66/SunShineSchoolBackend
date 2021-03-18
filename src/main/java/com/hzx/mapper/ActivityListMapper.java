package com.hzx.mapper;

import com.hzx.pojo.Activity;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActivityListMapper {

    Page<Activity> selectActivities(Page<Activity> page, String text, String school, Integer type, Integer sort);

    @Select("select user_id,user_name,image,type,title,state,bid from user,activity where activity.create_user = user.user_id" +
            " and user_id=#{uid}")
    List<Activity> selectActivityById(Integer uid);
}
