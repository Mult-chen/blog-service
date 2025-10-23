package com.mult.blog.service.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")  // 对所有路径应用CORS
            .allowedOriginPatterns("*")  // 允许的源
            .allowedMethods("GET", "POST", "PUT", "DELETE")  // 允许的方法
            .allowedHeaders("*")  // 允许的头部
            .allowCredentials(true)  // 是否发送Cookies
            .maxAge(3600);  // OPTIONS预检请求的缓存时间
    }
}