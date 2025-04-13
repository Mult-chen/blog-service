package com.example.demo;

import com.mult.blog.service.bean.Posts;
import com.mult.blog.service.dao.PostsMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class DemoApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	private PostsMapper postsMapper;

	@Test
	public void testSelect() {
		System.out.println(("----- selectAll method test ------"));
		List<Posts> userList = postsMapper.selectList(null);
		userList.forEach(System.out::println);
	}

}
