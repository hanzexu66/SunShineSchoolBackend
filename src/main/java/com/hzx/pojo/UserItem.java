package com.hzx.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserItem {
    Integer userId;
    String image;
    String userName;
    String secondTitle;
    String time;
}
