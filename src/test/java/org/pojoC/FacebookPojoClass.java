package org.pojoC;

import java.sql.Driver;
import java.util.List;

import org.baseclass.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class FacebookPojoClass extends BaseClass {
	public FacebookPojoClass() {
		PageFactory.initElements(driver, this);
	}
    @CacheLookup
	@FindAll({
		@FindBy(name = "email"),
		@FindBy(id = "email"),
		@FindBy(xpath = "//input[@id='email']")
	})
   
    
	private WebElement txtUsername;
   
	@FindAll({
		@FindBy(name="password"),
		@FindBy(id = "pass")
	})
	private WebElement txtPassword;

	@FindBy(name = "login")
	private List<WebElement> btnlogin;

	public WebElement getTxtUsername() {
		return txtUsername;
	}

	public WebElement getTxtPassword() {
		return txtPassword;
	}

	public List<WebElement> getBtnlogin() {
		return btnlogin;
	}

	
	}

	

	


