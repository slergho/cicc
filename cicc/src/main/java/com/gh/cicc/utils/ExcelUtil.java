package com.gh.cicc.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class ExcelUtil {
    public static List<Object[]> importExcel(String fileName) {

        log.info("导入解析开始，fileName:{}",fileName);
        try {
            List<Object[]> list = new ArrayList<Object[]>();
            InputStream inputStream = new FileInputStream(fileName);
            log.info(fileName);
            Workbook workbook = WorkbookFactory.create(inputStream);
            Sheet sheet = workbook.getSheetAt(0);
            //获取sheet的行数
            int rows = sheet.getPhysicalNumberOfRows();
            System.out.println(rows);
            for (int i = 0; i < rows; i++) {
                //过滤表头行
                if (i == 0) {
                    continue;
                }
                //获取当前行的数据
                Row row = sheet.getRow(i);
              /*  Object[] objects = new Object[row.getPhysicalNumberOfCells()];
                int index = 0;
                for (Cell cell : row) {
                    if (cell.getCellType().equals(NUMERIC)) {
                        objects[index] = (int) cell.getNumericCellValue();
                    }
                    if (cell.getCellType().equals(STRING)) {
                        objects[index] = cell.getStringCellValue();
                    }
                    if (cell.getCellType().equals(BOOLEAN)) {
                        objects[index] = cell.getBooleanCellValue();
                    }
                    if (cell.getCellType().equals(ERROR)) {
                        objects[index] = cell.getErrorCellValue();
                    }
                    index++;
                }
                list.add(objects);*/
            }
            workbook.close();
            log.info("导入文件解析成功！");
            return list;
        }catch (Exception e){
            log.info("导入文件解析失败！");
            e.printStackTrace();
        }
        return null;
    }

    //测试导入
   /* public static void main(String[] args) {
        try {
            String fileName = "f:/test.xlsx";
            List<Object[]> list = importExcel(fileName);
            for (int i = 0; i < list.size(); i++) {
                Insurance insurance = new Insurance();
                insurance.setInsuredName((String) list.get(i)[0]);
                insurance.setInsuredIDNumber((String) list.get(i)[1]);
                insurance.setPlateNumber((String) list.get(i)[2]);
                insurance.setVin((String) list.get(i)[3]);
                insurance.setFrameNumber((String) list.get(i)[4]);
                insurance.setAddress((String) list.get(i)[5]);
                insurance.setInsuredPhone((String) list.get(i)[6]);
                insurance.setVehicleBrand((String) list.get(i)[7]);
                insurance.setColors((String) list.get(i)[8]);
                insurance.setBuyCarDate((Date) list.get(i)[9]);
                insurance.setAllRiskScenarioName((String) list.get(i)[10]);
                insurance.setTheftScenarioName((String) list.get(i)[11]);
                insurance.setAllRiskPremium((String) list.get(i)[12]);
                insurance.setAllRiskDuration((String) list.get(i)[13]);
                insurance.setAllRiskInsuredDate((Date) list.get(i)[14]);
                insurance.setTheftPremium((String) list.get(i)[15]);
                insurance.setTheftDuration((String) list.get(i)[16]);
                insurance.setTheftInsuredDate((Date) list.get(i)[17]);
                System.out.println(insurance.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/

}
