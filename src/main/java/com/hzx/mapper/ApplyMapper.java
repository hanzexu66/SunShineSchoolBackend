package com.hzx.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzx.pojo.Apply;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplyMapper extends BaseMapper<Apply> {
    @Override
    int insert(Apply entity);

    @Select("select * from apply where uid = #{uid} and bid = #{bid}")
    List<Apply> selectById(int uid, int bid);
}
