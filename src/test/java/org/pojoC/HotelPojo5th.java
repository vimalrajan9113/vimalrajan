package org.pojoC;

import org.baseclass.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HotelPojo5th extends BaseClass {
	public HotelPojo5th() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "order_no")
	private WebElement orderNumber;

	public WebElement getOrderNumber() {
		return orderNumber;
	}
}
