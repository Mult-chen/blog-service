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
        String originalName = imageFile.getImageName();
        String asciiFallback = "download";
        String ext = "";
        int dot = originalName.lastIndexOf('.');
        if (dot >= 0) {
            ext = originalName.substring(dot);
        }
        String safeAscii = asciiFallback + ext;
        String encodedUtf8;
        try {
            // RFC 5987: filename*=UTF-8''<percent-encoded-utf8>
            encodedUtf8 = java.net.URLEncoder.encode(originalName, java.nio.charset.StandardCharsets.UTF_8)
                    .replace("+", "%20");
        } catch (Exception e) {
            encodedUtf8 = safeAscii;
        }
        String contentDisposition = "attachment; filename=\"" + safeAscii + "\"; filename*=UTF-8''" + encodedUtf8;
        response.setHeader(org.springframework.http.HttpHeaders.CONTENT_DISPOSITION, contentDisposition);
        return imageFile.getImageFile();
    }


    @PostMapping("/update")
    public void update(@RequestBody Posts posts) {
        postsMapper.updateById(posts);
    }



}
