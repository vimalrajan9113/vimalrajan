package org.practice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataDrivenPrac2 {
	public static void main(String[] args) throws IOException {
		File f = new File("C:\\Users\\vimalrajan\\eclipse-workspace\\ProjectMvnAmt\\AmtExcel\\AmtExcelPrac1.xlsx");
		FileInputStream input = new FileInputStream(f);
		Workbook w = new XSSFWorkbook(input);
		Sheet s = w.getSheet("Sheet1");
		for (int i = 0; i < s.getPhysicalNumberOfRows(); i++) {
			Row r = s.getRow(i);
			for (int j = 0; j < r.getPhysicalNumberOfCells(); j++) {
				Cell c = r.getCell(j);
				int cellType = c.getCellType();
				String value;
				if (cellType == 1) {
					value = c.getStringCellValue();

				} else if (DateUtil.isCellDateFormatted(c)) {
					Date date = c.getDateCellValue();
					SimpleDateFormat sim = new SimpleDateFormat("dd-MMM-yyyy");
					value = sim.format(date);

				} else {
					double d = c.getNumericCellValue();
					long l = (long) d;
					value = String.valueOf(l);

				}
				System.out.println(value);	
			}

		}
	}
}
