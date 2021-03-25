package org.pojoC;

import org.baseclass.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HotelPojo3rd extends BaseClass {
	public HotelPojo3rd() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "radiobutton_3")
	private WebElement radio;
	@FindBy(name = "continue")
	private WebElement btnContinue;

	public WebElement getRadio() {
		return radio;
	}

	public WebElement getBtnContinue() {
		return btnContinue;
	}
}
