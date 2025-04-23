package com.mult.blog.service.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mult.blog.service.bean.Posts;
import org.apache.ibatis.annotations.Param;

import java.util.List;

// Created on 2025-04-23


/**
 * @author Mult
 * @since 1.0.0
 */
public interface PostsMapper extends BaseMapper<Posts> {

    Posts selectPostById(Long postId);

    List<Posts> selectByTypeAndTitle(@Param("type") String type, @Param("title") String title);
}