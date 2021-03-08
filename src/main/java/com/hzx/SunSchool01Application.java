package com.hzx;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.hzx.mapper")
public class SunSchool01Application {

    public static void main(String[] args) {
        SpringApplication.run(SunSchool01Application.class, args);
    }

}
