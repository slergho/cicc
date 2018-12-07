package com.gh.cicc.controller;

import com.gh.cicc.model.Insurance;
import com.gh.cicc.service.InsuranceService;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
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
    public String fileUpload(@RequestParam("fileName")MultipartFile file)throws Exception{

//        Workbook workbook = new  HSSFWorkbook(file.getInputStream());
        //List<String> list = new ArrayList<>();
        List<Insurance> list = new ArrayList<Insurance>();
                Workbook wb = new XSSFWorkbook(file.getInputStream());
        Sheet sheet = wb.getSheetAt(0);
        for (int i = 0; i < sheet.getLastRowNum(); i++) {
            if (i == 0){
                continue;
            }
            Row row = sheet.getRow(i);
            Map<String, Object> m = new HashMap<String, Object>();
            //System.out.println(row.getCell(i).getStringCellValue());
            for (int j = 0; j < sheet.getLastRowNum(); j ++){
                if (row.getCell(j) == null){
                    continue;
                }
              /*  Insurance insurance = new Insurance();
                Cell cell = row.getCell(j);
                cell.setCellType(CellType.STRING);
                Cell insuranceName = row.getCell(0);
                Cell IDNumber = row.getCell(1);
                Cell carNumber = row.getCell(2);
                Cell plateNumber = row.getCell(3);
                Cell vin = row.getCell(4);
                Cell frameNumber = row.getCell(5);
                Cell address = row.getCell(6);
                Cell insuredPhone = row.getCell(7);
                Cell vehicleBrand = row.getCell(8);
                Cell colors = row.getCell(9);
                Cell buyCarDate = row.getCell(10);
                Cell allRiskScenarioName = row.getCell(11);
                Cell theftScenarioName = row.getCell(12);
                Cell allRiskPremium = row.getCell(13);
                Cell allRiskDuration = row.getCell(14);
                Cell allRiskInsuredDate = row.getCell(15);
                Cell theftPremium = row.getCell(16);
                Cell theftDuration = row.getCell(17);
                Cell theftInsuredDate = row.getCell(18);
                insurance.setInsuredName(insuranceName.toString());
                insurance.setTheftInsuredDate(new Date(theftInsuredDate));*/

                System.out.print(row.getCell(j).getStringCellValue()+">>" );
            }

        }
        return null;


//        if (file.isEmpty()){
//            return "false";
//        }
//        String fileName = file.getOriginalFilename();
//        int size = (int) file.getSize();
//        log.info(fileName+">>>>；"+size+">>>；");
//        String path = "C:/Users/Administrator/Desktop";
//        File file1 = new File(path+"/"+fileName);
//        if (!file1.getParentFile().exists()){
//            file1.getParentFile().mkdir();
//        }
//        try {
//            file.transferTo(file1);
//            return importExcel(fileName);
//
//        } catch (IOException e) {
//            e.printStackTrace();
//            return "false";
//        }

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
