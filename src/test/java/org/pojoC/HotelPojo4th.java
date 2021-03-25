package org.pojoC;

import org.baseclass.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HotelPojo4th extends BaseClass {
	public HotelPojo4th() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "first_name")
	private WebElement firstName;

	@FindBy(name = "last_name")
	private WebElement lastName;

	@FindBy(name = "address")
	private WebElement address;

	@FindBy(name = "cc_num")
	private WebElement cardNumber;

	@FindBy(name = "cc_type")
	private WebElement cardType;

	@FindBy(name = "cc_exp_month")
	private WebElement expireMonth;

	@FindBy(name = "cc_exp_year")
	private WebElement expireYear;

	@FindBy(name = "cc_cvv")
	private WebElement cvvNumber;

	@FindBy(name = "book_now")
	private WebElement btnBookNow;

	public WebElement getFirstName() {
		return firstName;
	}

	public WebElement getLastName() {
		return lastName;
	}

	public WebElement getAddress() {
		return address;
	}

	public WebElement getCardNumber() {
		return cardNumber;
	}

	public WebElement getCardType() {
		return cardType;
	}

	public WebElement getExpireMonth() {
		return expireMonth;
	}

	public WebElement getExpireYear() {
		return expireYear;
	}

	public WebElement getCvvNumber() {
		return cvvNumber;
	}

	public WebElement getBtnBookNow() {
		return btnBookNow;
	}
}
