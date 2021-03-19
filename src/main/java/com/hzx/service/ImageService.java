package com.hzx.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Service
public class ImageService {
    public boolean loadImage(MultipartFile part){
        try {
            part.transferTo(new File("d:/"));
        }catch (Exception e){
            return false;
        }
        return true;
    }
}
