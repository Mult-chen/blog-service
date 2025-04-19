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
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

/**
 * @author Martin
 * @date 2022/8/15
 */
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/article")
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class TestEndpoint {
    PostsMapper postsMapper;



    @GetMapping("/list")
    public List<Posts> getUserInfo(String type,String title) {
        return postsMapper.selectByTypeAndTitle(type,title);
    }

    @GetMapping("/detail")
    public Posts detail(Long  id    ) {
        return postsMapper.selectPostById(id);
    }

    @PostMapping("save")
    public void save(@RequestBody Posts posts) {
        postsMapper.insert(posts);
    }




}
