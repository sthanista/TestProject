package com.php.testcases;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ReadExcelFile {

    public static void main(String [] args) throws IOException {
        File f = new File("C:\\Users\\466682\\IdeaProjects\\PHPPracticeProject\\TestData\\phpTravels.xlsx");
        FileInputStream fp =new FileInputStream(f);
        XSSFWorkbook inputTemplate = new XSSFWorkbook(fp);
        Sheet dataSheet = inputTemplate.getSheet("Sheet1");
        for (int i =0; i<dataSheet.getLastRowNum();i++){
            String value =dataSheet.getRow(i).getCell(1).getStringCellValue();
            System.out.print(value);
        }


    }
}
