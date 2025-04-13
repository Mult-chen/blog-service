package com.mult.blog.service.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mult.blog.service.bean.Posts;

// Created on 2025-04-13


/**
 * @author Mult
 * @since 1.0.0
 */
public interface PostsMapper extends BaseMapper<Posts> {

    Posts selectPostById(Long postId);

}