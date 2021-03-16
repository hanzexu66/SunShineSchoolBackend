package com.hzx.mapper;

import com.hzx.pojo.Activity;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityListMapper {

    Page<Activity> selectActivities(Page<Activity> page, String text, String school, Integer type, Integer sort);

}
