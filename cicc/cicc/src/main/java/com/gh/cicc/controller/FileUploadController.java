package com.gh.cicc.controller;

import com.gh.cicc.utils.ExcelUtil1;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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

    @RequestMapping("/fileUpload")
    @ResponseBody
    public String fileUpload(@RequestParam("fileName")MultipartFile file, Model model)throws Exception{
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



   /* @RequestMapping(value = "check")
    public void checkFile(File file, Model model){

        try {
            ExcelUtil1.checkExcelVaild(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/



}
