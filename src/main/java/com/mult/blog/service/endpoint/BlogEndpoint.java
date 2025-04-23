package com.mult.blog.service.endpoint;

import com.mult.blog.service.bean.ImageFile;
import com.mult.blog.service.bean.Posts;
import com.mult.blog.service.dao.ImageFileMapper;
import com.mult.blog.service.dao.PostsMapper;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.stream.FileImageInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.List;

/**
 * @author Martin
 * @date 2022/8/15
 */
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/article")
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class BlogEndpoint {
    PostsMapper postsMapper;
    ImageFileMapper imageFileMapper;



    @GetMapping("/list")
    public List<Posts> getUserInfo(String type,String title) {
        return postsMapper.selectByTypeAndTitle(type,title);
    }

    @GetMapping("/detail")
    public Posts detail(Long  id    ) {
        return postsMapper.selectPostById(id);
    }

    @PostMapping("/save")
    public void save(@RequestBody Posts posts) {
        postsMapper.insert(posts);
    }

    @SneakyThrows
    @PostMapping("/image")
    public Long image(MultipartFile file) {
        String name = file.getOriginalFilename();
        String type = file.getContentType();
        byte[] bytes = file.getBytes();
        ImageFile imageFile = new ImageFile();
        imageFile.setImageName(name);
        imageFile.setImageType(type);
        imageFile.setImageFile(bytes);
        imageFileMapper.insert(imageFile);
        return imageFile.getId();
    }

    @GetMapping("/image")
    public byte[] image(Long id, HttpServletResponse response) {
        ImageFile imageFile = imageFileMapper.selectById(id);
        if (imageFile == null) {
            return null;
        }
        response.setContentType(imageFile.getImageType());
        response.setHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + imageFile.getImageName() + "\"");
        return imageFile.getImageFile();
    }




}
