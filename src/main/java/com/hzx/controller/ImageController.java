package com.hzx.controller;

import com.hzx.pojo.UploadRequestBody;
import com.hzx.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
public class ImageController {

    @Autowired
    ImageService imageService;

    @PostMapping("uploadImage")
    public Boolean upload(@RequestParam("image") MultipartFile part) throws IOException {
        imageService.loadImage(part);
        return true;
    }
}
