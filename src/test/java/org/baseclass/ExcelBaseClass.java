package org.baseclass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelBaseClass {
public static String readExcel(int rowNo,int cellNo) throws IOException {
	File f = new File("C:\\Users\\vimalrajan\\eclipse-workspace\\ProjectMvnAmt\\AmtExcel\\Hotel.xlsx");
	FileInputStream input = new FileInputStream(f);
	Workbook book = new XSSFWorkbook(input);
	Sheet sh = book.getSheet("Hotel");
	Row r = sh.getRow(rowNo);
	Cell c = r.getCell(cellNo);
	int type = c.getCellType();
	String name="";
	if (type==1) {
		 name = c.getStringCellValue();
	}
	else if (DateUtil.isCellDateFormatted(c)) {
		Date d = c.getDateCellValue();
		SimpleDateFormat form = new SimpleDateFormat();
		 name = form.format(d);
	}
	else {
		double d = c.getNumericCellValue();
		long l = (long)d;
		 name = String.valueOf(l);
	}
	return name;

}

public static void writeExcel(int rowNo,int cellNo,String value) throws IOException {
	File f = new File("C:\\Users\\vimalrajan\\eclipse-workspace\\ProjectMvnAmt\\AmtExcel\\Hotel.xlsx");
	FileInputStream input = new FileInputStream(f);
	Workbook book = new XSSFWorkbook(input);
	Sheet sh = book.getSheet("Hotel");
	Row r = sh.getRow(rowNo);
	Cell c = r.createCell(cellNo);
	c.setCellValue(value);
	FileOutputStream output = new FileOutputStream(f);
	book.write(output);
}
}


