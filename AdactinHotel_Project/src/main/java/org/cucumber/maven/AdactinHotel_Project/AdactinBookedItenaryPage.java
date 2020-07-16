package org.cucumber.maven.AdactinHotel_Project;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdactinBookedItenaryPage {

	public WebDriver driver;
	
	@FindBy(id="order_id_text")
	private WebElement searchInputField;
	
	@FindBy(id="search_hotel_id")
	private WebElement goButton;
	
	@FindBy(linkText="Booked Itinerary")
	private WebElement itineraryLink;
	
	@FindBy(id="order_id_291427")
	private WebElement orderIDno;
	
	@FindBy(xpath="//form[@id='booked_form']/table[@class='login']//tbody/tr[2]/td/table/tbody/tr[2]")
	private WebElement adactinWebtable;

	public WebElement getAdactinWebtable() {
		return adactinWebtable;
	}

	public WebElement getOrderIDno() {
		return orderIDno;
	}

	public WebElement getItineraryLink() {
		return itineraryLink;
	}

	public WebElement getSearchInputField() {
		return searchInputField;
	}

	public WebElement getGoButton() {
		return goButton;
	}
	
	public AdactinBookedItenaryPage(WebDriver idriver) {
		this.driver = idriver;
		PageFactory.initElements(driver, this);
	}
	
}
