package org.practice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

import org.apache.poi.ss.formula.functions.Value;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataDrivenPrac {
	public static void main(String[] args) throws IOException {
		 
		File f = new File("C:\\Users\\vimalrajan\\eclipse-workspace\\ProjectMvnAmt\\AmtExcel\\AmtExcelPrac1.xlsx");
		FileInputStream input = new FileInputStream(f);
		Workbook w = new XSSFWorkbook(input);
		Sheet s = w.getSheet("Sheet1");
		Row row2 = s.getRow(0);
		Cell c1 = row2.getCell(1);
		String cellValue = c1.getStringCellValue();
		System.out.println(cellValue);
		int row = s.getPhysicalNumberOfRows();
		System.out.println("No of Rows"+row);
		int numberOfCells = row2.getPhysicalNumberOfCells();
		System.out.println("no.of cells"+numberOfCells);
		
		for (int i = 0; i <s.getPhysicalNumberOfRows(); i++) {
			Row r = s.getRow(i);
			for (int j = 0; j < r.getPhysicalNumberOfCells(); j++) {
				Cell c = r.getCell(j);
				int celltype = c.getCellType();
				String value;
				if (celltype == 1) {
					value = c.getStringCellValue();
					
					//System.out.println(value);
//				
				}

				else if (DateUtil.isCellDateFormatted(c)) {
					Date date = c.getDateCellValue();
					SimpleDateFormat sim = new SimpleDateFormat("dd-MMM-yyyy");
					value = sim.format(date);
					//System.out.println(value);
				} else {
					double d = c.getNumericCellValue();
					long l = (long) d;
					value = String.valueOf(l);
					//System.out.println(value);
				}
				System.out.println(value);

			}
			
		}

	
		
	}
}
