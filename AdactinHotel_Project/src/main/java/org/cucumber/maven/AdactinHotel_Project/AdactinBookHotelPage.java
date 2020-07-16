package org.cucumber.maven.AdactinHotel_Project;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdactinBookHotelPage {

	public WebDriver driver;
	
	@FindBy(id="room_num_dis")
	private WebElement noOfRoomsDisplay;
	
	@FindBy(id="total_days_dis")
	private WebElement totalDaysDisplay;
	
	@FindBy(id="price_night_dis")
	private WebElement pricePerNightDisplay;
	
	@FindBy(id="total_price_dis")
	private WebElement totalPriceDisplay;
	
	@FindBy(id="gst_dis")
	private WebElement gst;
	
	@FindBy(id="final_price_dis")
	private WebElement finalPrice;
	
	@FindBy(id="hotel_name_dis")
	private WebElement hotelNameDisplay;
	
	@FindBy(id="location_dis")
	private WebElement locationDisplay;
	
	@FindBy(id="room_type_dis")
	private WebElement roomTypeDisplay;
	
	
	@FindBy(id="first_name")
	private WebElement firstName;
	
	@FindBy(id="last_name")
	private WebElement lastName;
	
	@FindBy(id="address")
	private WebElement address;
	
	@FindBy(id="cc_num")
	private WebElement ccNumber;
	
	@FindBy(id="cc_type")
	private WebElement ccTypeDD;
	
	@FindBy(id="cc_exp_month")
	private WebElement expiryMonthDD;
	
	@FindBy(id="cc_exp_year")
	private WebElement expiryYearDD;
	
	@FindBy(id="cc_cvv")
	private WebElement cvvNumber;
	
	@FindBy(id="book_now")
	private WebElement bookNowBtn;
	
	public WebElement getNoOfRoomsDisplay() {
		return noOfRoomsDisplay;
	}

	public WebElement getFirstName() {
		return firstName;
	}

	public WebElement getLastName() {
		return lastName;
	}

	public WebElement getAddress() {
		return address;
	}

	public WebElement getCcNumber() {
		return ccNumber;
	}

	public WebElement getCcTypeDD() {
		return ccTypeDD;
	}

	public WebElement getExpiryMonthDD() {
		return expiryMonthDD;
	}

	public WebElement getExpiryYearDD() {
		return expiryYearDD;
	}

	public WebElement getCvvNumber() {
		return cvvNumber;
	}

	public WebElement getBookNowBtn() {
		return bookNowBtn;
	}

	public WebElement getTotalDaysDisplay() {
		return totalDaysDisplay;
	}

	public WebElement getPricePerNightDisplay() {
		return pricePerNightDisplay;
	}

	public WebElement getTotalPriceDisplay() {
		return totalPriceDisplay;
	}
	
	public WebElement getHotelNameDisplay() {
		return hotelNameDisplay;
	}

	public WebElement getLocationDisplay() {
		return locationDisplay;
	}

	public WebElement getRoomTypeDisplay() {
		return roomTypeDisplay;
	}

	public WebElement getGst() {
		return gst;
	}

	public WebElement getFinalPrice() {
		return finalPrice;
	}
	
	public AdactinBookHotelPage(WebDriver bookdriver) {
		this.driver = bookdriver;
		PageFactory.initElements(driver, this);
	}
}
