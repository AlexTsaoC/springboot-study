package com.tsao.blog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@MapperScan("com.tsao.blog.dao")
public class SpringbootSutdyApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootSutdyApplication.class, args);
	}
}
