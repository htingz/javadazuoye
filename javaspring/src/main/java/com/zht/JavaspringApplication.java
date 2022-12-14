package com.zht;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.zht.mapper")
public class JavaspringApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaspringApplication.class, args);
    }

}
