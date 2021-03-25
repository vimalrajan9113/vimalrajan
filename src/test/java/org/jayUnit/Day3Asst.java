package org.jayUnit;

import java.util.List;

import org.baseclass.BaseClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.pojoC.FacebookPojoClass;

public class Day3Asst extends BaseClass {
//public static WebDriver driver;
@BeforeClass
public static void launch() {
	browserlaunch();
	launchUrl("https://www.facebook.com/");
	maxWindow();
	PageUrl();

}
@Test
public void tc2() {
String url = driver.getCurrentUrl();
Assert.assertTrue("verify url...", url.startsWith("htt"));
System.out.println("url of the page:"+url);
}
@Test
public void tc3() {
	FacebookPojoClass p1 = new FacebookPojoClass();
	WebElement usr = p1.getTxtUsername();
	fillTextBox(usr, "vimalrajan");
	String atttriuser = usr.getAttribute("value");
	Assert.assertEquals("vimalrajan", atttriuser);
	
	WebElement pass = p1.getTxtPassword();
	fillTextBox(pass, "rajan002");
	String attripass = pass.getAttribute("value");
	Assert.assertEquals("rajan002", attripass);
	
	List<WebElement> btn = p1.getBtnlogin();
	btnClick(btn.get(0));
	}
@Test
public void tc1() {
	String name = driver.getTitle();
	boolean b = name.contains("Facebook");
	Assert.assertTrue("verify title.....", b);
	System.out.println("title of the page:"+name);

}
}