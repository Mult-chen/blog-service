package com.mult.blog.service.endpoint;

import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.fastjson2.JSON;
import com.mult.blog.service.bean.Posts;
import com.mult.blog.service.dao.PostsMapper;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

/**
 * @author Martin
 * @date 2022/8/15
 */
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class TestEndpoint {
    PostsMapper postsMapper;



    @GetMapping("/hello")
    public List<Posts> getUserInfo(String type) {
        if(!type.equals("生活") && !type.equals("首页")){
            return Collections.emptyList();
        }
        Posts posts = postsMapper.selectPostById(1L);
        return Collections.singletonList(posts);
    }
    //新增消费记录




}
