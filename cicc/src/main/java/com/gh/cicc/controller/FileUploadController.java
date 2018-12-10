package com.gh.cicc.controller;

import com.gh.cicc.model.Insurance;
import com.gh.cicc.service.InsuranceService;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class FileUploadController {

    @Autowired
    InsuranceService insuranceService;

    Logger log = LoggerFactory.getLogger(FileUploadController.class);

    @RequestMapping("/file")
    public String file(){
        return "upload";
    }

    @RequestMapping("/fileUpload")
    @ResponseBody
    public String fileUpload(@RequestParam("fileName")MultipartFile file)throws Exception {

//        Workbook workbook = new  HSSFWorkbook(file.getInputStream());
        //List<String> list = new ArrayList<>();
        List<Insurance> list = new ArrayList<Insurance>();
        Workbook wb = new XSSFWorkbook(file.getInputStream());
        Sheet sheet = wb.getSheetAt(0);
        for (int i = 0; i < sheet.getLastRowNum(); i++) {
            if (i == 0) {
                continue;
            }
            Row row = sheet.getRow(i);
            Map<String, Object> m = new HashMap<String, Object>();
            for (int j = 0; j < sheet.getLastRowNum();j++ ) {
                if (row.getCell(j) == null) {
                    continue;
                }
                Cell cell = row.getCell(j);
                cell.setCellType(CellType.STRING);
                System.out.println(row.getCell(j).getStringCellValue() + ">>");
            }
        }
        return null;
    }


    public String importExcel(String fileName) {
        if (fileName == null && "".equals(fileName)) {
            return "文件名不能为空！";
        } else {
            if (fileName.endsWith("xls") || fileName.endsWith("xlsx")) {
                Boolean isOk = insuranceService.importExcel(fileName);
                if (isOk) {
                    return "导入成功！";
                } else {
                    return "导入失败！";
                }
            }
            return "文件格式错误！";
        }
    }
}