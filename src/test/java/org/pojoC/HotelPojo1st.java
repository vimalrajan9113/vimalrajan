package org.pojoC;

import java.util.List;

import org.baseclass.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HotelPojo1st extends BaseClass {
	public HotelPojo1st() {
		PageFactory.initElements(driver, this);

	}

	@FindBy(name = "username")
	private WebElement txtUserName;

	@FindBy(name = "password")
	private WebElement txtUserPassword;

	@FindBy(name = "login")
	private WebElement btnLogin;
	
	
	public WebElement getTxtUserName() {
		return txtUserName;
	}

	public WebElement getTxtUserPassword() {
		return txtUserPassword;
	}

	public WebElement getBtnLogin() {
		return btnLogin;
	}

	
	}


