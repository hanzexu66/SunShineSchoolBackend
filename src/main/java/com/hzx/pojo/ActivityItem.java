package com.hzx.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ActivityItem {
    String userName;
    Integer type;
    String title;
    String image;
    int state;
    int bid;
}
