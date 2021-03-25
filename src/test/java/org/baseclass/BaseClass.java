
package org.baseclass;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import javax.swing.text.Element;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;
	public static Robot r;
	public static Actions a;
	public static JavascriptExecutor js;
	public static Select s;

//--------------------------------EXCELREAD------------------------------------	
	public static String readExcel(int rowNo, int cellNo) throws IOException {
		File f = new File("C:\\Users\\vimalrajan\\eclipse-workspace\\ProjectMvnAmt\\AmtExcel\\Facebook.xlsx");
		FileInputStream input = new FileInputStream(f);
		Workbook book = new XSSFWorkbook(input);
		Sheet sh = book.getSheet("Facebook");
		Row r = sh.getRow(rowNo);
		Cell c = r.getCell(cellNo);
		int type = c.getCellType();
		String name = "";
		if (type == 1) {
			name = c.getStringCellValue();
		} else if (DateUtil.isCellDateFormatted(c)) {
			Date d = c.getDateCellValue();
			SimpleDateFormat form = new SimpleDateFormat();
			name = form.format(d);
		} else {
			double d = c.getNumericCellValue();
			long l = (long) d;
			name = String.valueOf(l);
		}
		return name;

	}
	
//--------------------------------EXCELREAD ALLDATA--------------------------------------------
	
	public static String readExcelAllData() throws IOException {
		File f = new File("C:\\Users\\vimalrajan\\eclipse-workspace\\ProjectMvnAmt\\AmtExcel\\Facebook.xlsx");
		FileInputStream input = new FileInputStream(f);
		Workbook book = new XSSFWorkbook(input);
		Sheet sh = book.getSheet("Facebook");
		String name=null;
		int noOfRows = sh.getPhysicalNumberOfRows();
		
		for (int i = 0; i < noOfRows; i++) {
			
			Row row = sh.getRow(i);
			
			int noOfCells = row.getPhysicalNumberOfCells();
			name = null;
			for (int j = 0; j < noOfCells; j++) {

				Cell cell = row.getCell(j);
				int cellType = cell.getCellType();
				
				if (cellType == 1) {
					name = cell.getStringCellValue();
				} else if (DateUtil.isCellDateFormatted(cell)) {
					Date d = cell.getDateCellValue();
					SimpleDateFormat form = new SimpleDateFormat();
					name = form.format(d);
				} else {
					double d = cell.getNumericCellValue();
					long l = (long) d;
					name = String.valueOf(l);
					
				}
				
				System.out.println(name);
				
			}
			
		}
		
	//System.out.println(name);
		return name;

	}
	

//----------------------------EXCELWRITE----------------------------------------
	public static void writeExcel(int rowNo, int cellNo, String value) throws IOException {
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

//--------------------BROWSERLAUNCH--------------------------------------------------------------
	public static  WebDriver browserlaunch() {
		// WebDriverManager.chromedriver().setup();
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		return driver;

	}

	public static void launchUrl(String url) {
		driver.get(url);

	}

	public static void maxWindow() {
		driver.manage().window().maximize();
		

	}

	public static void pageTitle() {
		String title = driver.getTitle();
		System.out.println(title);
	}

	public static void PageUrl() {
		String current = driver.getCurrentUrl();
		System.out.println(current);
	}

	public static void fillTextBox(WebElement element, String value) {
		element.sendKeys(value);

	}

	public static void btnClick(WebElement element) {
		element.click();

	}

	public static void toSleep(long ms) throws InterruptedException {
		Thread.sleep(ms);

	}

	public static void toGetText(WebElement element) {
		element.getText();
	}

//----------------ACTIONS CLASS---------------------------------
	public static void toActionsSwitching() {
		a = new Actions(driver);

	}

	public static void toMoveElement(WebElement element) {
		a.moveToElement(element).perform();

	}

	public static void toDropDrag(WebElement src, WebElement des) {
		a.dragAndDrop(src, des).perform();

	}

	public void rightClick(WebElement element) {
		a = new Actions(driver);
		a.contextClick(element).perform();

	}

	public static void toDoubleClick(WebElement element) {
		a.doubleClick(element).perform();

	}

	public static void toKeyUpDown(WebElement element, String keys) {
		a.keyDown(element, Keys.SHIFT).sendKeys(keys).keyUp(element, Keys.SHIFT).perform();

	}

//--------------ROBOT CLASS--------------------------------------------
	public static void copy() throws AWTException {
		r = new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_C);
		r.keyRelease(KeyEvent.VK_C);

	}

	public static void paste() throws AWTException {
		r = new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_V);
	}

	public static void backSpace() throws AWTException {
		r = new Robot();
		r.keyPress(KeyEvent.VK_BACK_SPACE);
		r.keyRelease(KeyEvent.VK_BACK_SPACE);

	}

	public static void toTab() throws AWTException {
		r = new Robot();
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);

	}

//-----------------ALERT--------------------------------------------
	public static void toSimpleAlert() {
		Alert a = driver.switchTo().alert();
		a.accept();

	}

	public static void toConfirmAlertAccept() {
		Alert a = driver.switchTo().alert();
		a.dismiss();
	}

	public static void toConfirmAlertDismiss() {
		Alert a = driver.switchTo().alert();
		a.dismiss();
	}

	public static void toPromptAlert(String value) {
		Alert a = driver.switchTo().alert();
		System.out.println(a.getText());
		a.sendKeys(value);
		a.accept();

	}

//------------------TAKESCREENSHOT---------------------------------
	public static void takeSnap(String picname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File s = ts.getScreenshotAs(OutputType.FILE);
		File d = new File("C:\\Users\\vimalrajan\\eclipse-workspace\\ProjectMvnAmt\\ScreenShots\\" + picname + ".png");
		FileUtils.copyFile(s, d);

	}

//------------------FRAMES------------------------------------------
	public static void toFrameId(String id) {
		driver.switchTo().frame(id);
	}

	public static void toFrameName(String name) {
		driver.switchTo().frame(name);
	}

	public static void toFrameIndex(int index) {
		driver.switchTo().frame(index);

	}

	public static void toWebelementRef(WebElement element) {
		driver.switchTo().frame(element);

	}

	public static void toCountFr(List<WebElement> number) {
		int s = number.size();
		System.out.println(s);

	}

	public static void toDefaultFrame() {
		driver.switchTo().defaultContent();

	}

	public static void toParentFrame() {
		driver.switchTo().parentFrame();

	}

//-------------JAVASCRIPT-------------------------------------------

	public static void toScrollDown(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].scrollIntoView(true)", element);

	}

	public static void toScrollUp(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].scrollIntoView(false)", element);

	}

	public static void toHorizontalScroll() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
	}

	public static void toBottomScroll() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("js.executeScript(\"window.scrollTo(0, document.body.scrollHeight)\")");
	}

	public static void toJavaScriptSet(WebElement element, String value) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('value1','" + value + "')", element);

	}

	public static void toJavaScriptGet(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("return arguments[0].getAttribute('value')", element);

	}

	public static void toJavaScriptClick(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", element);

	}

//------------------SELECT----------------------------------

	public static void toDropDownMultipleTrue(WebElement element, int index, String value) {
		s = new Select(element);
		boolean multiple = s.isMultiple();
		if (multiple == true) {
			System.out.println("Multiple Options Can Be Selected");
		} else {
			System.out.println("One option Can Alone Be selected");
		}
		s.selectByIndex(index);
		s.selectByVisibleText(value);
	}

	public static void toDropDownIndex(WebElement element, int index) {
		s = new Select(element);
		s.selectByIndex(index);

	}

	public static void toDropDownFirstSelectedOption(WebElement element, String value) {
		s = new Select(element);
		WebElement fso = s.getFirstSelectedOption();
		System.out.println(fso.getText());
		System.out.println(fso.getAttribute(value));

	}

	public static void toDropDownAllOptions(WebElement element) {
		s = new Select(element);
		List<WebElement> options = s.getOptions();
		for (WebElement alloptions : options) {
			System.out.println(alloptions.getText());
		}
	}

	public static void toDropDownAllSelectedOptions(WebElement element) {
		s = new Select(element);
		List<WebElement> aso = s.getAllSelectedOptions();
		for (int i = 0; i < aso.size(); i++) {
			WebElement selected = aso.get(i);
			System.out.println(selected.getText());
		}

	}

//------------------WINDOWS-----------------------------
	public static void toWindowParentId() {
		String parentId = driver.getWindowHandle();
		System.out.println(parentId);
	}

	public static void toAllWindowId() {

		Set<String> allWindowId = driver.getWindowHandles();
		System.out.println(allWindowId);

	}

	public static void toIterateEach() {
		String parentId = driver.getWindowHandle();
		System.out.println(parentId);
		Set<String> allWindowId = driver.getWindowHandles();
		System.out.println(allWindowId);
		for (String eachId : allWindowId) {
			if (!eachId.equals(parentId));
			driver.switchTo().window(eachId);
		}

	}
//type 3
//	public static void toMoveParticularWindow(int index) {
//		Set<String> allWindowId = driver.getWindowHandles();
//		System.out.println(allWindowId);
//
//		List<String> all = new LinkedList<String>();
//		all.addAll(allWindowId);
//		driver.switchTo().window(all.get(index));
//
//	}
//-----------------WAITS-----------------------------------
	public static void toWaits(int seconds) {
		WebDriverWait w = new WebDriverWait(driver, seconds);
		w.until(ExpectedConditions.alertIsPresent());
		Alert a = driver.switchTo().alert();
		a.accept();
		}

//------------------WEBTABLE------------------------
	public static void toWebTableParticularRowAndElelment() {

	}

}
