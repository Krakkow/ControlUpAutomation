package utils;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelReader {
    String filePath;

    public ExcelReader(String filePath) {
        this.filePath = filePath;
    }

    private String getCellValue(int index){
        return null;
    }

    public static String getCredentialsFromExcel(String filePath, int cellIndex){
            File file = new File(filePath);
            String myCredValue = "";
            try {
                FileInputStream inputStream = new FileInputStream(file);
                Workbook myWorkBook = new XSSFWorkbook(inputStream);
                if (myWorkBook != null){
                    int numOfSheets = myWorkBook.getNumberOfSheets();
                    System.out.println(numOfSheets);
                    Sheet mySheet = myWorkBook.getSheetAt(0);

                    if (mySheet != null){
                        Row myRow = mySheet.getRow(1);
                        if (myRow != null){
                            Cell myCreds = myRow.getCell(cellIndex);
                            if (myCreds != null){
                                myCredValue = myCreds.getStringCellValue();
                            }
                        }
                    }
                }
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return myCredValue;
        }

    }
