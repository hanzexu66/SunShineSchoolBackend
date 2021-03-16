package com.hzx.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Activity {
    String userName;
    Integer type;
    String title;
    String image;
    int state;
    int bid;
    int userId;
}
