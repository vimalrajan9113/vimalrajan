package org.jayUnit;

import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Day2 {
public static WebDriver driver;
@BeforeClass
public static void browser() {
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	driver.get("https://www.facebook.com/");
	driver.manage().window().maximize();
}
@AfterClass
public static void close() {
	driver.quit();
}
@Test
public void url() {
	String currentUrl = driver.getCurrentUrl();
	System.out.println("current url:"+ currentUrl);
}
@Test
public void locate() {
	WebElement username = driver.findElement(By.name("email"));
	username.sendKeys("vimalrajan");
	
	WebElement password = driver.findElement(By.name("pass"
			+ ""));
	password.sendKeys("rajan");
	
	WebElement log = driver.findElement(By.name("login"));
	log.click();

}
@Test
public void title() {
String title1 = driver.getTitle();
System.out.println(title1);
}
@Before
public void start() {
	System.out.println("test case starts");
	Date d = new Date();
	System.out.println(d);
	
}
@After
public  void end() {
	System.out.println("test case ends");
	Date d = new Date();
	System.out.println(d);
}
}
