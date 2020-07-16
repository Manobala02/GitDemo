package org.cucumber.maven.AdactinHotel_Project;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdactinHotelPage {

	public WebDriver driver;
	
	public WebElement getHotelNameValidate() {
		return hotelNameValidate;
	}

	@FindBy(xpath="(//input[@value='Hotel Creek'])[1]")
	private WebElement hotelNameValidate;
	
	@FindBy(id="arr_date_0")
	private WebElement arrivalDate;
	
	@FindBy(id="dep_date_0")
	private WebElement departureDate;
	
	@FindBy(id="rooms_0")
	private WebElement roomsValidate;
	
	@FindBy(id="room_type_0")
	private WebElement roomTypeValidate;
	
	@FindBy(id="radiobutton_0")
	private WebElement radioBtnSelect;
	
	@FindBy(id="continue")
	private WebElement continueButton;
	
	@FindBy(id="no_days_0")
	private WebElement noDaysInSelectPage;
	
	@FindBy(id="price_night_0")
	private WebElement pricePerNightInSelectPage;
	
	@FindBy(id="location_0")
	private WebElement locationInSelectPage;
	
	public WebElement getLocationInSelectPage() {
		return locationInSelectPage;
	}

	public WebElement getNoDaysInSelectPage() {
		return noDaysInSelectPage;
	}

	public WebElement getPricePerNightInSelectPage() {
		return pricePerNightInSelectPage;
	}

	public WebElement getContinueButton() {
		return continueButton;
	}

	public WebElement getRadioBtnSelect() {
		return radioBtnSelect;
	}

	public WebElement getRoomTypeValidate() {
		return roomTypeValidate;
	}

	public WebElement getRoomsValidate() {
		return roomsValidate;
	}

	public WebElement getArrivalDate() {
		return arrivalDate;
	}

	public WebElement getDepartureDate() {
		return departureDate;
	}

	public AdactinHotelPage(WebDriver hoteldriver) {
		this.driver = hoteldriver;
		PageFactory.initElements(driver, this);
				
	}
	
}
