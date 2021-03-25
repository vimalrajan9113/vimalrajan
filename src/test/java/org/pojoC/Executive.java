package org.pojoC;

import java.util.List;

import org.baseclass.BaseClass;
import org.openqa.selenium.WebElement;

public class Executive extends BaseClass {
	public static void main(String[] args) throws InterruptedException {
		browserlaunch();
		launchUrl("http://adactinhotelapp.com/");
		maxWindow();
		PageObjectMana pageObjectMana2;
		HotelPojo1st hotelPojo1st;
	
		
		pageObjectMana2 = PageObjectMana.getPageObjectMana();
		hotelPojo1st = pageObjectMana2.getHotelPojo1st();
		
		//HotelPojo1st p1 = new HotelPojo1st();
		WebElement user = hotelPojo1st.getTxtUserName();
		fillTextBox(user, "vimalTheRajan");
		WebElement pass = hotelPojo1st.getTxtUserPassword();
		fillTextBox(pass, "Vimal@12");
		WebElement allBtn = hotelPojo1st.getBtnLogin();
		btnClick(allBtn);
		

		HotelPojo2nd p2 = new HotelPojo2nd();
		WebElement Location = p2.getForLocation();
		toDropDownIndex(Location, 2);
		WebElement noOfRooms = p2.getNoOfRooms();
		toDropDownIndex(noOfRooms, 3);
		WebElement noOfAdults = p2.getNoOfAdults();
		toDropDownIndex(noOfAdults, 3);
		WebElement btnSearch = p2.getBtnSearch();
		btnClick(btnSearch);

		HotelPojo3rd p3 = new HotelPojo3rd();
		WebElement radio = p3.getRadio();
		btnClick(radio);
		WebElement btnContinue = p3.getBtnContinue();
		btnClick(btnContinue);

		HotelPojo4th p4 = new HotelPojo4th();
		WebElement firstName = p4.getFirstName();
		fillTextBox(firstName, "vimalrajan");
		WebElement lastName = p4.getLastName();
		fillTextBox(lastName, "vajravel");
		WebElement address = p4.getAddress();
		fillTextBox(address, "dharmapuri");
		WebElement cardNumber = p4.getCardNumber();
		fillTextBox(cardNumber, "98765432107894456");
		WebElement cardType = p4.getCardType();
		toDropDownIndex(cardType, 2);
		WebElement expireMonth = p4.getExpireMonth();
		toDropDownIndex(expireMonth, 3);
		WebElement expireYear = p4.getExpireYear();
		toDropDownIndex(expireYear, 4);
		WebElement cvvNumber = p4.getCvvNumber();
		fillTextBox(cvvNumber, "333");
		WebElement btnBookNow = p4.getBtnBookNow();
		btnClick(btnBookNow);
		

		HotelPojo5th p5 = new HotelPojo5th();
		WebElement orderNumber = p5.getOrderNumber();
		toSleep(5000);
		String attribute = orderNumber.getAttribute("value");
		System.out.println("order Number:"+attribute);

	}
}



//FacebookPojoClass p1 = new FacebookPojoClass();
//WebElement username = p1.getTxtUsername();
//fillTextBox(username, "vimalrajan");
//WebElement password = p1.getTxtPassword();
//fillTextBox(password, "vimbar");
//List<WebElement> btnlogin = p1.getBtnlogin();
//driver.navigate().refresh();
//fillTextBox(username, "done");
//btnClick(btnlogin.get(0));