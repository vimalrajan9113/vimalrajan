package org.practice;

import java.io.IOException;

import org.baseclass.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Facebook extends BaseClass {
	public static void main(String[] args) throws IOException, InterruptedException {
		browserlaunch();
		launchUrl("https://www.facebook.com/");
		maxWindow();
		pageTitle();
		PageUrl();
		WebElement username = driver.findElement(By.name("email"));
		toSleep(2000);
		fillTextBox(username, readExcel(1, 1));
		WebElement password = driver.findElement(By.name("pass"));
		fillTextBox(password, readExcel(2, 1));
		WebElement loginbutton = driver.findElement(By.name("login"));
		btnClick(loginbutton);
		
		
	}
}
