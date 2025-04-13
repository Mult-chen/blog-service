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
@TableName(value = "comments")
public class Comments {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @TableField(value = "post_id")
    private Long postId;

    @TableField(value = "commenter_name")
    private String commenterName;

    @TableField(value = "commenter_email")
    private String commenterEmail;

    @TableField(value = "content")
    private String content;

    @TableField(value = "parent_id")
    private Long parentId;

    @TableField(value = "created_at")
    private LocalDateTime createdAt;

    @TableField(value = "updated_at")
    private LocalDateTime updatedAt;
}