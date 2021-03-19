package com.hzx.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzx.pojo.Chat;
import com.hzx.pojo.Chat2;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface ChatMapper extends BaseMapper<Chat> {
    @Override
    int insert(Chat entity);

    @Select("select * from chat where ((send_user=#{uid1} and receive_user=#{uid2}) or (send_user=#{uid2} and receive_user=#{uid1})) order by time")
    List<Chat2> selectByMap(int uid1, int uid2);
}
