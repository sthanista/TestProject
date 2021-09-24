package com.php.base;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class HelperClass {

    public static String readTestCredential(String type,String fieldName) throws IOException {
        File f = new File("C:\\Users\\466682\\IdeaProjects\\PHPPracticeProject\\TestData\\phpTravels.xlsx");
        FileInputStream fp =new FileInputStream(f);
        XSSFWorkbook inputTemplate = new XSSFWorkbook(fp);
        Sheet dataSheet = inputTemplate.getSheet("Sheet1");
        String value = "";
        for (int i =0; i<dataSheet.getLastRowNum();i++){
            String rowValue =dataSheet.getRow(i).getCell(0).toString();
            if(rowValue.equals(type)){
                for(int k = 1; k<dataSheet.getRow(0).getLastCellNum(); k++){
                    if (dataSheet.getRow(0).getCell(k).getStringCellValue().equals(fieldName)){
                        value = dataSheet.getRow(i).getCell(k).toString();

                    }
                }

            }
        }
        System.out.print(value);

        return value;

    }
}
