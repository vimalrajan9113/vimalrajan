package org.practice;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DDTask1 {
public static void main(String[] args) throws IOException {
	File f = new File("C:\\Users\\vimalrajan\\eclipse-workspace\\ProjectMvnAmt\\AmtExcel\\AmtExcelPrac1.xlsx");
	FileInputStream input = new FileInputStream(f);
	Workbook book = new XSSFWorkbook(input);
	Sheet sh = book.getSheet("Sheet1");
	Row r1 = sh.getRow(0);
	Cell c1 = r1.getCell(1);
	int rows = sh.getPhysicalNumberOfRows();
	System.out.println("no of rows:"+rows);
	int cells = r1.getPhysicalNumberOfCells();
	System.out.println("no of cells:"+cells);
	for (int i = 0; i <sh.getPhysicalNumberOfRows(); i++) {
		Row r = sh.getRow(i);
		for (int j = 0; j < r.getPhysicalNumberOfCells(); j++) {
			Cell c = r.getCell(j);
			int cellType = c.getCellType();
			if (cellType==1) {
				String value = c.getStringCellValue();
			}
			else if (DateUtil.isCellDateFormatted(c)) {
				Date date = c.getDateCellValue();
			}
		}
	}
	
	}
}
