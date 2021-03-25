package org.pojoC;

import org.baseclass.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HotelPojo2nd extends BaseClass {
	public HotelPojo2nd() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "location")
	private WebElement forLocation;

	@FindBy(name = "room_nos")
	private WebElement noOfRooms;

//@FindBy(name = "datepick_in")
//private WebElement checkIn;
//
//@FindBy(name= "datepick_out")
//private WebElement checkOut;

	@FindBy(name = "adult_room")
	private WebElement noOfAdults;

	@FindBy(name = "Submit")
	private WebElement btnSearch;

	public WebElement getForLocation() {
		return forLocation;
	}

	public WebElement getNoOfRooms() {
		return noOfRooms;
	}

	public WebElement getNoOfAdults() {
		return noOfAdults;
	}

	public WebElement getBtnSearch() {
		return btnSearch;
	}

}
