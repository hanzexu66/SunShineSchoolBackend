package com.hzx.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzx.pojo.Chat;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatMapper extends BaseMapper<Chat> {
    @Override
    int insert(Chat entity);
}
