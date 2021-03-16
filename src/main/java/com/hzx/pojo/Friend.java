package com.hzx.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Friend {
    int person1;
    int person2;
    String latestText;
    LocalDateTime latestTime;
}
