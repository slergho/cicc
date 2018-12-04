package com.gh.cicc.utils;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;

import javax.persistence.PersistenceUnit;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class ExcelUtil {

    private final static String EXCEL_XLS ="xls";
    private final static String EXCEL_XLSX = "xlsx";

    /**
     * 判断EXCEL版本 获取workbook
     * @param in
     * @param file
     * @return
     * @throws IOException
     */
    public static Workbook getWorkbook(InputStream in, File file) throws IOException{
        Workbook wb = null;
        if (file.getName().endsWith(EXCEL_XLS)){
            wb = new HSSFWorkbook(in);
        }else if(file.getName().endsWith(EXCEL_XLSX)){
            wb = new HSSFWorkbook(in);
        }
        return wb;
    }
    /**
     * 判断是否为excek
     */
    public static void checkExcelVaild(File file) throws Exception{
        if (file.exists()){
            throw new Exception("文件不存在");
        }
        if (!file.isFile()&&(file.getName().endsWith(EXCEL_XLS) || file.getName().endsWith(EXCEL_XLSX))){
            throw new Exception("文件不是EXCEL");
        }
    }

    private static Object getValue(Cell cell){
        Object obj = null;
        switch (cell.getCellType()){
            case BOOLEAN:
                obj = cell.getBooleanCellValue();
                break;
            case ERROR:
                obj = cell.getErrorCellValue();
                break;
            case NUMERIC:
                obj = cell.getNumericCellValue();
                break;
            case STRING:
                obj = cell.getStringCellValue();
                break;
            default:
                break;
        }
        return obj;

    }
}
