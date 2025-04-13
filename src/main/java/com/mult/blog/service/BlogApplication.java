package com.mult.blog.service;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
@MapperScan("com.mult.blog.service.dao")
public class BlogApplication {

	public static void main(String[] args) {
		try {
			SpringApplication.run(BlogApplication.class, args);

		}catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			System.out.println("BlogApplication.main");
		}
	}

}
