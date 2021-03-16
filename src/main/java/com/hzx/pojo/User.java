package com.hzx.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @TableId(value = "userId", type = IdType.AUTO)
    private Integer userId;
    private String userName;
    private String password;
    private String image;
    private String realName;
    private String profile;
    private String sid;
    private String school;
}
