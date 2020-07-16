package org.cucumber.maven.AdactinHotel_Project;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdactinHomePage {

	public WebDriver driver;
	
	@FindBy(id="location")
	private WebElement locationDD;
	
	@FindBy(id="hotels")
	private WebElement hotelDD;
	
	@FindBy(id="room_type")
	private WebElement roomtypeDD;
	
	@FindBy(id="room_nos")
	private WebElement noOfRoomsDD;
	
	@FindBy(id="datepick_in")
	private WebElement checkInDate;
	
	@FindBy(id="datepick_out")
	private WebElement checkOutDate;
	
	@FindBy(id="adult_room")
	private WebElement adultsPerRoomDD;
	
	@FindBy(id="child_room")
	private WebElement childrenPerRoomDD;
	
	@FindBy(id="Submit")
	private WebElement submitBtn;
	
	@FindBy(id="checkin_span")
	private WebElement errorMessage;
	
	@FindBy(xpath="//span[text()='Check-Out Date shall be after than Check-In Date']")
	private WebElement errorMessageCheckout;

	public WebElement getErrorMessageCheckout() {
		return errorMessageCheckout;
	}

	public WebElement getLocationDD() {
		return locationDD;
	}

	public WebElement getHotelDD() {
		return hotelDD;
	}

	public WebElement getRoomtypeDD() {
		return roomtypeDD;
	}

	public WebElement getNoOfRoomsDD() {
		return noOfRoomsDD;
	}

	public WebElement getCheckInDate() {
		return checkInDate;
	}

	public WebElement getCheckOutDate() {
		return checkOutDate;
	}

	public WebElement getAdultsPerRoomDD() {
		return adultsPerRoomDD;
	}

	public WebElement getChildrenPerRoomDD() {
		return childrenPerRoomDD;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}

	public WebElement getErrorMessage() {
		return errorMessage;
	}
	
	public AdactinHomePage(WebDriver hdriver) {
		this.driver = hdriver;
		PageFactory.initElements(driver, this);
	}
	

}
