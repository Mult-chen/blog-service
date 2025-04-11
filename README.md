# blog-service

个人博客服务端信息

## 更新内容

1. 项目框架搭建 2025-04-11
   - 使用 Spring Boot 3.0.0 版本
   - 使用 MySQL 数据库
   - 使用 ORM 框架进行数据持久化
2. 数据库表结构创建 2025-04-11

```sql
CREATE TABLE Posts
(
    id         BIGINT(25)   not null PRIMARY KEY AUTO_INCREMENT,
    title      VARCHAR(200) NOT NULL,
    content    TEXT         NOT NULL,
    type       VARCHAR(50)  NOT NULL,
    created_at DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at DATETIME              DEFAULT NULL
) engine = InnoDB
  DEFAULT CHARSET = utf8mb4;

CREATE TABLE Comments
(
    id              BIGINT(25)  not null PRIMARY KEY AUTO_INCREMENT,
    post_id         BIGINT(25)  NOT NULL,
    commenter_name  VARCHAR(50) NOT NULL,
    commenter_email VARCHAR(100)         DEFAULT NULL,
    content         TEXT        NOT NULL,
    parent_id       BIGINT               DEFAULT NULL,
    created_at      DATETIME    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at      DATETIME             DEFAULT NULL
);
```
