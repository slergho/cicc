package com.gh.cicc.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
public class FileUploadController {

    Logger log = LoggerFactory.getLogger(FileUploadController.class);

    @RequestMapping("/file")
    public String file(){
        return "upload";
    }

    @RequestMapping("fileUpload")
    @ResponseBody
    public String fileUpload(@RequestParam("fileName")MultipartFile file){
        if (file.isEmpty()){
            return "false";
        }
        String fileName = file.getOriginalFilename();
        int size = (int) file.getSize();
        log.info(fileName+">>>>；"+size+">>>；");
        String path = "C:/Users/Administrator/Downloads/cicc";
        File file1 = new File(path+"/"+fileName);
        if (!file1.getParentFile().exists()){
            file1.getParentFile().mkdir();
        }
        try {
            file.transferTo(file1);
            return "true";
        } catch (IOException e) {
            e.printStackTrace();
            return "false";
        }
    }
}
