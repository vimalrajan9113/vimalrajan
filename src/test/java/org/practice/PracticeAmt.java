package org.practice;

import java.awt.AWTException;
import java.io.IOException;
import java.util.List;

import org.baseclass.BaseClass;
import org.baseclass.ExcelBaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class PracticeAmt extends BaseClass {
public static void main(String[] args) throws IOException, AWTException, InterruptedException {
	
	browserlaunch();
	launchUrl("http://adactinhotelapp.com/index.php");
	maxWindow();
	pageTitle();
	PageUrl();
	WebElement username = driver.findElement(By.name("username"));
	fillTextBox(username,"vimalTheRajan");
	WebElement pass = driver.findElement(By.name("password"));
	fillTextBox(pass, "Vimal@12");
	WebElement btnLogin = driver.findElement(By.xpath("//input[@type='Submit']"));
	btnClick(btnLogin);
	WebElement location = driver.findElement(By.name("location"));
	toDropDownIndex(location, 2);
	WebElement noOfRooms = driver.findElement(By.name("room_nos"));
	toDropDownIndex(noOfRooms, 3);
	WebElement adultRoom = driver.findElement(By.name("adult_room"));
	toDropDownIndex(adultRoom, 3);
	WebElement search = driver.findElement(By.xpath("//input[@type='submit']"));
	btnClick(search);
	WebElement radio = driver.findElement(By.xpath("//input[@name='radiobutton_3']"));
	btnClick(radio);
	WebElement continues = driver.findElement(By.name("continue"));
    btnClick(continues);
    WebElement name = driver.findElement(By.name("first_name"));
    fillTextBox(name, "vimalrajan");
    WebElement lastName = driver.findElement(By.name("last_name"));
    fillTextBox(lastName, "vajravel");
    WebElement address = driver.findElement(By.name("address"));
    fillTextBox(address, "chennai");
    WebElement cardNumber = driver.findElement(By.name("cc_num"));
    fillTextBox(cardNumber, "9677479423654321");
    WebElement cardType = driver.findElement(By.name("cc_type"));
    toDropDownIndex(cardType, 2);
    WebElement month = driver.findElement(By.name("cc_exp_month"));
    toDropDownIndex(month, 3);
    WebElement year = driver.findElement(By.name("cc_exp_year"));
    toDropDownIndex(year, 3);
    WebElement cvv = driver.findElement(By.name("cc_cvv"));
    fillTextBox(cvv, "333");
    WebElement bookNow = driver.findElement(By.name("book_now"));
    btnClick(bookNow);
    toSleep(5000);
    WebElement orderNO = driver.findElement(By.name("order_no"));
    System.out.println(orderNO.getText());
    System.out.println("booking completed");
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
}

//WebElement checkIN = driver.findElement(By.name("datepick_in"));
//btnClick(checkIN);
//toSleep(2000);
//toDoubleClick(checkIN);
//toDelete();
//fillTextBox(checkIN, "10/03/2021");
//WebElement checkOut = driver.findElement(By.name("datepick_out"));
//btnClick(checkOut);
//backSpace();
//fillTextBox(checkOut, "12/03/2021");