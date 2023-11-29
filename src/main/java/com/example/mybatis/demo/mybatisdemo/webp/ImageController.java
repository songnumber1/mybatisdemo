package com.example.mybatis.demo.mybatisdemo.webp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ImageController {
    @Autowired
    private final ImageService webpService;

    public ImageController(ImageService webpService) {
        this.webpService = webpService;
    }

    @GetMapping("/api/v1/image/webp")
    public String webpJpgConvertBase64(ImageDrawVo vo) {
        return webpService.webpDrawRectConvertBase64(vo);
    }

    @GetMapping("/api/v1/image/jpg")
    public String webpConvertBase64(ImageDrawVo vo) {
        return webpService.jpgDrawRectConvertBase64(vo);
    }
}
