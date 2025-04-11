package com.mult.blog.service.endpoint;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Martin
 * @date 2022/8/15
 */
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class UserEndpoint {



    @GetMapping("/hello")
    public String getUserInfo() {
        return  "hello";
    }
    //新增消费记录




}
