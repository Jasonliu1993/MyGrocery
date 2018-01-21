package com.grocery;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableJms
@SpringBootApplication
@EnableTransactionManagement
@MapperScan(value = "com.grocery.dao")
public class GroceryApplication {

    public static void main(String[] args) {
        SpringApplication.run(GroceryApplication.class, args);
    }
}
