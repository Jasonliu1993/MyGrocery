package com.grocery;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value = "com.grocery.dao")
public class GroceryApplication {

	public static void main(String[] args) {
        System.out.println("run here!");
        SpringApplication.run(GroceryApplication.class, args);
	}
}
