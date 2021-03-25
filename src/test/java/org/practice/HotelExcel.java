package org.practice;

import java.io.IOException;

import org.baseclass.BaseClass;
import org.baseclass.ExcelBaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HotelExcel extends BaseClass {
	public static void main(String[] args) throws IOException, InterruptedException {

		browserlaunch();
		launchUrl("http://adactinhotelapp.com/index.php");
		maxWindow();
		pageTitle();
		PageUrl();
		WebElement username = driver.findElement(By.name("username"));
		fillTextBox(username, "vimalTheRajan");
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
		fillTextBox(name, readExcel(1, 0));
		WebElement lastName = driver.findElement(By.name("last_name"));
		fillTextBox(lastName, readExcel(1, 1));
		WebElement address = driver.findElement(By.name("address"));
		fillTextBox(address, readExcel(1, 2));
		WebElement cardNumber = driver.findElement(By.name("cc_num"));
		fillTextBox(cardNumber, readExcel(1, 3));
		WebElement cardType = driver.findElement(By.name("cc_type"));
		toDropDownIndex(cardType, 2);
		WebElement month = driver.findElement(By.name("cc_exp_month"));
		toDropDownIndex(month, 3);
		WebElement year = driver.findElement(By.name("cc_exp_year"));
		toDropDownIndex(year, 3);
		WebElement cvv = driver.findElement(By.name("cc_cvv"));
		fillTextBox(cvv, readExcel(1, 4));
		WebElement bookNow = driver.findElement(By.name("book_now"));
		btnClick(bookNow);
		toSleep(5000);
		WebElement orderNO = driver.findElement(By.name("order_no"));
		toSleep(4000);
		String attribute = orderNO.getAttribute("value");
		System.out.println(attribute);
		System.out.println("booking completed");
		writeExcel(1, 5, attribute);

	}

}
