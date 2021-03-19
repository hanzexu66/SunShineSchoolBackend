package com.hzx.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChatItem {
    String image;
    int userId;
    String userName;
    String latestText;
    Date latestTime;
}
