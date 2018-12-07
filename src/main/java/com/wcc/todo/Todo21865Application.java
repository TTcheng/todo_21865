package com.wcc.todo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
@MapperScan("com.wcc.todo.mapper")
public class Todo21865Application {

    public static void main(String[] args) {
        SpringApplication.run(Todo21865Application.class, args);
    }
}
