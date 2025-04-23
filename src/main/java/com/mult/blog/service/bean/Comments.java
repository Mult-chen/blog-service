package com.mult.blog.service.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import lombok.Data;

// Created on 2025-04-23


/**
* @author Mult
* @since 1.0.0
*/

/**
 * 评论记录表
 */
@Data
@TableName(value = "comments")
public class Comments {

    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 文章id
     */
    @TableField(value = "post_id")
    private Long postId;

    /**
     * 评论者姓名
     */
    @TableField(value = "commenter_name")
    private String commenterName;

    /**
     * 评论者邮箱
     */
    @TableField(value = "commenter_email")
    private String commenterEmail;

    /**
     * 评论内容
     */
    @TableField(value = "content")
    private String content;

    @TableField(value = "created_at")
    private LocalDateTime createdAt;

    @TableField(value = "updated_at")
    private LocalDateTime updatedAt;
}