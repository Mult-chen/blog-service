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
 * 图片文件表
 */
@Data
@TableName(value = "image_file")
public class ImageFile {

    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 图片文件
     */
    @TableField(value = "image_file")
    private byte[] imageFile;

    /**
     * 图片名称
     */
    @TableField(value = "image_name")
    private String imageName;

    /**
     * 图片类型
     */
    @TableField(value = "image_type")
    private String imageType;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    @TableField(value = "update_time")
    private LocalDateTime updateTime;
}