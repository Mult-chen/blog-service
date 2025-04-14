package com.mult.blog.service.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import lombok.Data;

// Created on 2025-04-13


/**
 * @author Mult
 * @since 1.0.0
 */
@Data
@TableName(value = "posts")
public class Posts {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @TableField(value = "title")
    private String title;

    @TableField(value = "content")
    private String content;

    @TableField(value = "`type`")
    private String type;

    @TableField(value = "created_at")
    private LocalDateTime createdAt;

    @TableField(value = "updated_at")
    private LocalDateTime updatedAt;

}