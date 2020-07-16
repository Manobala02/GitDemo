package org.cucumber.maven.AdactinHotel_Project;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdactinBookingConfirmationPage {

	public WebDriver driver;
	
	@FindBy(id="hotel_name")
	private WebElement bconfirmHotel;
	
	@FindBy(id="location")
	private WebElement bconfirmLocation;
	
	@FindBy(id="room_type")
	private WebElement bconfirmRoomType;
	
	@FindBy(id="arrival_date")
	private WebElement bconfirmCheckin;
	
	@FindBy(id="departure_text")
	private WebElement bconfirmCheckout;
	
	@FindBy(id="total_rooms")
	private WebElement bconfirmNoofRooms;
	
	@FindBy(id="adults_room")
	private WebElement bconfirmAdult;
	
	@FindBy(id="children_room")
	private WebElement bconfirmChildren;
	
	@FindBy(id="logout")
	private WebElement logoutButton;
	
	@FindBy(id="my_itinerary")
	private WebElement itineraryButton;
	
	@FindBy(id="search_hotel")
	private WebElement searchHotelBtn;
	
	@FindBy(id="order_no")
	private WebElement orderNo;

	public WebElement getOrderNo() {
		return orderNo;
	}

	public WebElement getLogoutButton() {
		return logoutButton;
	}

	public WebElement getItineraryButton() {
		return itineraryButton;
	}

	public WebElement getSearchHotelBtn() {
		return searchHotelBtn;
	}
	
	public WebElement getBconfirmHotel() {
		return bconfirmHotel;
	}

	public WebElement getBconfirmLocation() {
		return bconfirmLocation;
	}

	public WebElement getBconfirmRoomType() {
		return bconfirmRoomType;
	}

	public WebElement getBconfirmCheckin() {
		return bconfirmCheckin;
	}

	public WebElement getBconfirmCheckout() {
		return bconfirmCheckout;
	}

	public WebElement getBconfirmNoofRooms() {
		return bconfirmNoofRooms;
	}

	public WebElement getBconfirmAdult() {
		return bconfirmAdult;
	}

	public WebElement getBconfirmChildren() {
		return bconfirmChildren;
	}

	public AdactinBookingConfirmationPage(WebDriver confirmdriver) {
		this.driver = confirmdriver;
		PageFactory.initElements(confirmdriver, this);		
	}
	
}
