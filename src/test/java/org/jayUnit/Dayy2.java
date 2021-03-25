package org.jayUnit;

import org.baseclass.BaseClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.pojoC.FacebookPojoClass;

public class Dayy2 extends BaseClass{
//public static WebDriver driver=null;
FacebookPojoClass p1 = new FacebookPojoClass();
@BeforeClass
public static void browser() {
browserlaunch();
launchUrl("http://www.facebook.com");
maxWindow();
}

@Test
public void locate() {

	fillTextBox(p1.getTxtUsername(), "Test");
	fillTextBox(p1.getTxtPassword(), "test");
}

}
