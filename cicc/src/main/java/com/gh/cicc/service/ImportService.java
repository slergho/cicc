package com.gh.cicc.service;

public class ImportService {

    /*public static void main(String[] args) {
    File file = new File("C:/Users/Administrator/Desktop/new.xls");
    {
        HSSFWorkbook wb = null;
        try {
            wb = new HSSFWorkbook(new FileInputStream(file));
        } catch (IOException e) {
            e.printStackTrace();
        }
        HSSFSheet sheet = wb.getSheetAt(0);
            int firstRowNum = 1;
            int lastRowNum = sheet.getLastRowNum();
            for (int i = firstRowNum; i <= lastRowNum; i++){
                HSSFRow row = sheet.getRow(i);
                int lastCellNum = row.getLastCellNum();
                for (int j = 0; j < lastCellNum; j ++){

                    HSSFCell cell = row.getCell(j);
                    cell.setCellType(CellType.STRING);
                    String value = cell.getStringCellValue();
                    System.out.println(value+"");
                }
                System.out.println();
            }
    }
    }*/


}
