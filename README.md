# blog-service

个人博客服务端信息

## 更新内容

1. 项目框架搭建 2025-04-11
    - 使用 Spring Boot 3.0.0 版本
    - 使用 MySQL 数据库
    - 使用 ORM 框架进行数据持久化
2. 数据库表结构创建 2025-04-11

```sql
CREATE TABLE posts
(
    id           BIGINT(25)    not null PRIMARY KEY AUTO_INCREMENT comment '主键id',
    title        VARCHAR(200)  NOT NULL comment '标题',
    img_id       BIGINT(25)    NOT NULL comment '主图id',
    digest       VARCHAR(1250) NOT NULL comment '摘要',
    content      TEXT          NOT NULL comment '正文',
    type         VARCHAR(50)   NOT NULL comment '文章类型',
    created_time DATETIME      NOT NULL DEFAULT CURRENT_TIMESTAMP comment '创建时间',
    updated_time DATETIME      not null DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '更新时间'
) engine = innodb
  default charset = utf8mb4 comment '博客文章列表';

CREATE TABLE comments
(
    id              BIGINT(25)   not null PRIMARY KEY AUTO_INCREMENT comment '主键id',
    post_id         BIGINT(25)   NOT NULL comment '文章id',
    commenter_name  VARCHAR(50)  NOT NULL DEFAULT '' comment '评论者姓名',
    commenter_email VARCHAR(100) not null default '' comment '评论者邮箱',
    content         TEXT         NOT NULL comment '评论内容',
    created_at      DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at      DATETIME              DEFAULT NULL
) engine = innodb
  default charset = utf8mb4 comment '评论记录表';

create table image_file
(
    id          bigint(25)   not null primary key auto_increment comment '主键id',
    image_file  longblob     not null comment '图片文件',
    image_name  varchar(255) not null comment '图片名称',
    image_type  varchar(255) not null comment '图片类型',
    create_time datetime     not null default current_timestamp comment '创建时间',
    update_time datetime     not null default current_timestamp on update current_timestamp comment '更新时间'
) engine = innodb
  default charset = utf8mb4 comment '图片文件表';
```

3. 更新表的创建内容，增加图片文件保存的表。
4. 新增获取图片信息和保存图片信息的接口。