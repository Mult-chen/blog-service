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
 * 博客文章列表
 */
@Data
@TableName(value = "posts")
public class Posts {

    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 标题
     */
    @TableField(value = "title")
    private String title;

    /**
     * 主图id
     */
    @TableField(value = "img_id")
    private Long imgId;

    /**
     * 摘要
     */
    @TableField(value = "digest")
    private String digest;

    /**
     * 正文
     */
    @TableField(value = "content")
    private String content;

    /**
     * 文章类型
     */
    @TableField(value = "`type`")
    private String type;

    /**
     * 创建时间
     */
    @TableField(value = "created_time")
    private LocalDateTime createdTime;

    /**
     * 更新时间
     */
    @TableField(value = "updated_time")
    private LocalDateTime updatedTime;
}