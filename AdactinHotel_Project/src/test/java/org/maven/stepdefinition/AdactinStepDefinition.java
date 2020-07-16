package org.maven.stepdefinition;

import java.io.File;
import java.util.List;

import org.cucumber.maven.AdactinHotel_Project.PageObjectManager;
import org.junit.Assert;
import org.maven.helper.FileReaderManager;
import org.maven.runner.TestRunner;
import org.maven.test.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.cucumber.listener.Reporter;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AdactinStepDefinition extends BaseClass {

	public static WebDriver driver = TestRunner.driver;
	public static PageObjectManager pm = new PageObjectManager(driver);
	public static String hotelName;
	public static String checkInDate;
	public static String checkOutDate;
	public static String roomType;
	public static String bconOrderid;

	@Given("^User should launch the browser$")
	public void user_should_launch_the_browser() throws Exception, Throwable {
		//String bn = FileReaderManager.getInstance().getConfigReader().getbrowserName();
		//getBrowser(bn);
		String url = FileReaderManager.getInstance().getConfigReader().getURL();
		getUrl(url);

	}

	@Given("^User hold for '(.*)' seconds$")
	public void user_hold_for_seconds(int arg1) throws Throwable {
		Thread.sleep(arg1 * 1000);

	}

	@Then("^User should verify the Welcome to AdactIn Group of Hotels is displayed in the login page$")
	public void user_should_verify_the_Welcome_to_AdactIn_Group_of_Hotels_is_displayed_in_the_login_page() {
		String actual = getText(pm.getLp().getValidateText());
		Assert.assertEquals("Welcome to AdactIn Group of Hotels", actual);
	}

	@When("^User enters the username in the login page$")
	public void user_enters_the_username_in_the_login_page() throws Exception {
		inputValue(pm.getLp().getUserInputField(), "LakshmiSri");

	}

	@When("^User enters the password in the login page$")
	public void user_enters_the_password_in_the_login_page() throws Exception {
		inputValue(pm.getLp().getPasswordInputField(), "password");

	}

	@When("^User clicks the Login button in the login page$")
	public void user_clicks_the_Login_button_in_the_login_page() {
		elementClick(pm.getLp().getLoginBtn());

	}

	@When("^User hold for '(.*)' seconds1$")
	public void user_hold_for_seconds1(int arg1) throws Throwable {
		Thread.sleep(arg1 * 1000);

	}

	@When("^User clicks the Logout button in home page$")
	public void user_clicks_the_Logout_button_in_home_page() {
		elementClick(pm.getLp().getLogOut());
	}

	@When("^User select the location using drop down$")
	public void user_select_the_location_using_drop_down() throws Throwable {
		elementClick(pm.getHp().getLocationDD());
		selectValuesfromDD(pm.getHp().getLocationDD(), "index", "1");
	}

	@When("^User select the hotel using drop down$")
	public void user_select_the_hotel_using_drop_down() throws Throwable {
		elementClick(pm.getHp().getHotelDD());
		selectValuesfromDD(pm.getHp().getHotelDD(), "index", "1");

	}

	@When("^User select the room type using drop down$")
	public void user_select_the_room_type_using_drop_down() throws Throwable {
		elementClick(pm.getHp().getRoomtypeDD());
		selectValuesfromDD(pm.getHp().getRoomtypeDD(), "index", "1");

	}

	@When("^User select the no of rooms using drop down$")
	public void user_select_the_no_of_rooms_using_drop_down() throws Throwable {
		selectValuesfromDD(pm.getHp().getNoOfRoomsDD(), "index", "1");

	}

	@When("^User enter the check-in date$")
	public void user_enter_the_check_in_date() throws Throwable {
		inputValue(pm.getHp().getCheckInDate(), "19/03/2019");
	}

	@When("^User enter the check-out date$")
	public void user_enter_the_check_out_date() throws Throwable {
		inputValue(pm.getHp().getCheckOutDate(), "17/03/2019");
	}

	@When("^User select the adult per room using drop down$")
	public void user_select_the_adult_per_room_using_drop_down() throws Throwable {
		elementClick(pm.getHp().getAdultsPerRoomDD());
		selectValuesfromDD(pm.getHp().getAdultsPerRoomDD(), "index", "1");
	}

	@When("^User select the children per room using drop down$")
	public void user_select_the_children_per_room_using_drop_down() throws Throwable {
		elementClick(pm.getHp().getChildrenPerRoomDD());
		selectValuesfromDD(pm.getHp().getChildrenPerRoomDD(), "index", "1");
	}

	@When("^User clicks the search button$")
	public void user_clicks_the_search_button() throws Throwable {
		elementClick(pm.getHp().getSubmitBtn());

	}

	@Then("^User should verify the error message is displayed$")
	public void user_should_verify_the_error_message_is_displayed() throws Throwable {
		String text = getText(pm.getHp().getErrorMessage());
		Assert.assertEquals("Check-In Date shall be before than Check-Out Date", text.trim());

	}

	@When("^User waits for '(.*)' seconds$")
	public void user_waits_for_seconds(int arg1) throws Throwable {
		Thread.sleep(arg1 * 1000);

	}

	@When("^User enter the check-in date past (\\d+) days$")
	public void user_enter_the_check_in_date_past_days(int arg1) throws Throwable {
		inputValue(pm.getHp().getCheckInDate(), "11/03/2019");

	}

	@When("^User enter the check-out date past (\\d+) days$")
	public void user_enter_the_check_out_date_past_days(int arg1) throws Throwable {
		inputValue(pm.getHp().getCheckOutDate(), "09/03/2019");

	}

	@Then("^User should verify the error message as enter valid dates$")
	public void user_should_verify_the_error_message_as_enter_valid_dates() throws Throwable {
		String text = getText(pm.getHp().getErrorMessageCheckout());
		Assert.assertEquals("Check-Out Date shall be after than Check-In Date", text.trim());
	}

	@When("^User select no children per room using drop down$")
	public void user_select_no_children_per_room_using_drop_down() throws Throwable {
		selectValuesfromDD(pm.getHp().getChildrenPerRoomDD(), "index", "0");
	}

	@When("^User enter the today check-in date$")
	public void user_enter_the_today_check_in_date() throws Throwable {
		inputValue(pm.getHp().getCheckInDate(), "18/04/2019");
		checkInDate = getAttribute(pm.getHp().getCheckInDate());
		System.out.println(checkInDate);
	}

	@When("^User enter the tomorrow check-out date$")
	public void user_enter_the_tomorrow_check_out_date() throws Throwable {
		elementClick(pm.getHp().getCheckOutDate());
		inputValue(pm.getHp().getCheckOutDate(), "19/04/2019");
		checkOutDate = getAttribute(pm.getHp().getCheckOutDate());
		System.out.println(checkOutDate);
	}

	@When("^User select the hotel creep using drop down$")
	public void user_select_the_hotel_creep_using_drop_down() throws Throwable {
		selectValuesfromDD(pm.getHp().getHotelDD(), "index", "1");
		hotelName = getAttribute(pm.getHp().getHotelDD());
		System.out.println(hotelName);
	}

	@Then("^User verify the hotel displayed is same as selected in the hotel form$")
	public void user_verify_the_hotel_displayed_is_same_as_selected_in_the_hotel_form() throws Throwable {
		String hotelNameValidate = getAttribute(pm.getHop().getHotelNameValidate());
		System.out.println(hotelNameValidate);
		Assert.assertEquals(hotelName, hotelNameValidate);
	}

	@Then("^User verify the check-in date is same as selected in the search hotel form$")
	public void user_verify_the_check_in_date_is_same_as_selected_in_the_search_hotel_form() throws Throwable {
		String arrivalDateValidate = getAttribute(pm.getHop().getArrivalDate());
		System.out.println(arrivalDateValidate);
		Assert.assertEquals(checkInDate, arrivalDateValidate);
	}

	@Then("^User verify the check-out date is same as selected in the search hotel form$")
	public void user_verify_the_check_out_date_is_same_as_selected_in_the_search_hotel_form() throws Throwable {
		String departureDateValidate = getAttribute(pm.getHop().getDepartureDate());
		System.out.println(departureDateValidate);
		Assert.assertEquals(checkOutDate, departureDateValidate);
	}

	@When("^User select the no of rooms using drop down '(\\d+)'$")
	public void user_select_the_no_of_rooms_using_drop_down(String arg1) throws Throwable {
		elementClick(pm.getHp().getNoOfRoomsDD());
		selectValuesfromDD(pm.getHp().getNoOfRoomsDD(), "index", arg1);
	}

	@Then("^User to verify that no of rooms is reflected according to the no of rooms selected in search hotel page '(\\d+)'$")
	public void user_to_verify_that_no_of_rooms_is_reflected_according_to_the_no_of_rooms_selected_in_search_hotel_page(
			String arg1) throws Throwable {
		String roomsValidate = getAttribute(pm.getHop().getRoomsValidate());
		if (roomsValidate.contains(arg1)) {
			System.out.println("Room number is same");
		} else {
			System.out.println("Room number is not same");
		}
	}

	@When("^User select the room type deluxe using drop down$")
	public void user_select_the_room_type_deluxe_using_drop_down() throws Throwable {
		elementClick(pm.getHp().getRoomtypeDD());
		selectValuesfromDD(pm.getHp().getRoomtypeDD(), "index", "3");
		roomType = getAttribute(pm.getHp().getRoomtypeDD());
	}

	@Then("^User verify that room type reflected is the same as selected in search hotel page$")
	public void user_verify_that_room_type_reflected_is_the_same_as_selected_in_search_hotel_page() throws Throwable {
		String roomTypeValidate = getAttribute(pm.getHop().getRoomTypeValidate());
		Assert.assertEquals(roomType, roomTypeValidate);

	}

	@When("^User select the no of rooms using drop down1 '(\\d+)'$")
	public void user_select_the_no_of_rooms_using_drop_down1(String arg1) throws Throwable {
		elementClick(pm.getHp().getNoOfRoomsDD());
		selectValuesfromDD(pm.getHp().getNoOfRoomsDD(), "index", arg1);
	}

	@When("^User clicks the radio button in the hotel search page$")
	public void user_clicks_the_radio_button_in_the_hotel_search_page() throws Throwable {
		elementClick(pm.getHop().getRadioBtnSelect());
	}

	@When("^User clicks the continue button in the hotel search page$")
	public void user_clicks_the_continue_button_in_the_hotel_search_page() throws Throwable {
		elementClick(pm.getHop().getContinueButton());
	}

	@Then("^User verify the total price excluding gst '(\\d+)'$")
	public void user_verify_the_total_price_excluding_gst(String arg1) throws Throwable {
		String totalDaysDisplay = getAttribute(pm.getBhp().getTotalDaysDisplay());
		String pricePerNightDisplay = getAttribute(pm.getBhp().getPricePerNightDisplay());
		String totalPriceDisplay = getAttribute(pm.getBhp().getTotalPriceDisplay());
		String totdaytrim = totalDaysDisplay.substring(0, 1).trim();
		System.out.println(totdaytrim);
		String pricetrim = pricePerNightDisplay.substring(5).trim();
		System.out.println(pricetrim);
		int totalPrice = Integer.parseInt(arg1) * Integer.parseInt(totdaytrim) * Integer.parseInt(pricetrim);
		System.out.println(totalPrice);
		String tprice = String.valueOf(totalPrice);
		if (totalPriceDisplay.contains(tprice)) {
			System.out.println("Total price is same as calculated");
		} else {
			System.out.println("Total price is not same");

		}
	}

	@When("^User enters first name$")
	public void user_enters_first_name() throws Throwable {
		inputValue(pm.getBhp().getFirstName(), "Lakshmi");
		Reporter.addScenarioLog("Lakshmi");
	}

	@When("^User enters last name$")
	public void user_enters_last_name() throws Throwable {
		inputValue(pm.getBhp().getLastName(), "Sri");
	}

	@When("^User enters billing address$")
	public void user_enters_billing_address() throws Throwable {
		inputValue(pm.getBhp().getAddress(), "Anna nagar");
	}

	@When("^User enters (\\d+) digit credit card number$")
	public void user_enters_digit_credit_card_number(int arg1) throws Throwable {
		inputValue(pm.getBhp().getCcNumber(), "1234567890987654");
	}

	@When("^User selects the card type$")
	public void user_selects_the_card_type() throws Throwable {
		elementClick(pm.getBhp().getCcTypeDD());
		selectValuesfromDD(pm.getBhp().getCcTypeDD(), "index", "3");
	}

	@When("^User selects the expiry month$")
	public void user_selects_the_expiry_month() throws Throwable {
		elementClick(pm.getBhp().getExpiryMonthDD());
		selectValuesfromDD(pm.getBhp().getExpiryMonthDD(), "index", "3");
	}

	@When("^User selects the expiry year$")
	public void user_selects_the_expiry_year() throws Throwable {
		elementClick(pm.getBhp().getExpiryYearDD());
		selectValuesfromDD(pm.getBhp().getExpiryYearDD(), "visible text", "2020");
	}

	@When("^User enters the cvv number$")
	public void user_enters_the_cvv_number() throws Throwable {
		inputValue(pm.getBhp().getCvvNumber(), "123");
	}

	@When("^User clicks the book now button$")
	public void user_clicks_the_book_now_button() throws Throwable {
		elementClick(pm.getBhp().getBookNowBtn());
	}

	@When("^User clicks the logout button in the booking confirmation page$")
	public void user_clicks_the_logout_button_in_the_booking_confirmation_page() throws Throwable {
		elementClick(pm.getBcp().getLogoutButton());
	}

	@Then("^User verify the total price including gst '(\\d+)'$")
	public void user_verify_the_total_price_including_gst(String arg1) throws Throwable {
		String pricePerNightDisplay = getAttribute(pm.getBhp().getPricePerNightDisplay());
		String totalDaysDisplay = getAttribute(pm.getBhp().getTotalDaysDisplay());
		String finalPriceDisplay = getAttribute(pm.getBhp().getFinalPrice());
		String pricetrim = pricePerNightDisplay.substring(5).trim();
		String totalDaystrim = totalDaysDisplay.substring(0, 1).trim();
		int finalPrice = (Integer.parseInt(arg1) * Integer.parseInt(totalDaystrim) * Integer.parseInt(pricetrim));
		int gst = finalPrice / 10;
		System.out.println("GST = " + gst);
		int price = gst + finalPrice;
		String fPrice = String.valueOf(price);
		if (finalPriceDisplay.contains(fPrice)) {
			System.out.println("Final price is same as calculated");
		} else {
			System.out.println("Final price is not same");
		}
	}

	@When("^User select the location using drop down '\"([^\"]*)\"'$")
	public void user_select_the_location_using_drop_down(String arg1) throws Throwable {
		elementClick(pm.getHp().getLocationDD());
		selectValuesfromDD(pm.getHp().getLocationDD(), "visible text", arg1);
	}

	@When("^User select the hotel creep using drop down '\"([^\"]*)\"'$")
	public void user_select_the_hotel_creep_using_drop_down(String arg1) throws Throwable {
		elementClick(pm.getHp().getHotelDD());
		selectValuesfromDD(pm.getHp().getHotelDD(), "visible text", arg1);
	}

	@When("^User select the room type using drop down '\"([^\"]*)\"'$")
	public void user_select_the_room_type_using_drop_down(String arg1) throws Throwable {
		elementClick(pm.getHp().getRoomtypeDD());
		selectValuesfromDD(pm.getHp().getRoomtypeDD(), "visible text", arg1);
	}

	@Then("^User verify the total data are same in booking confirmation page '\"([^\"]*)\"' '\"([^\"]*)\"' '\"([^\"]*)\"' '\"([^\"]*)\"' '(\\d+)'$")
	public void user_verify_the_total_data_are_same_in_booking_confirmation_page(String arg1, String arg2, String arg3,
			String arg4, String arg5) throws Throwable {
		String bookHotel = getAttribute(pm.getBhp().getHotelNameDisplay());
		System.out.println(bookHotel);
		String bookLocation = getAttribute(pm.getBhp().getLocationDisplay());
		System.out.println(bookLocation);
		String bookRoomType = getAttribute(pm.getBhp().getRoomTypeDisplay());
		System.out.println(bookRoomType);
		String bookTotalDays = getAttribute(pm.getBhp().getTotalDaysDisplay());
		System.out.println(bookTotalDays);
		String booktotdaystrim = bookTotalDays.substring(0, 1).trim();
		String ppNightDisplay = getAttribute(pm.getBhp().getPricePerNightDisplay());
		System.out.println(ppNightDisplay);
		Assert.assertEquals(arg2, bookHotel);
		Assert.assertEquals(arg1, bookLocation);
		Assert.assertEquals(arg3, bookRoomType);
		Assert.assertEquals(arg4, ppNightDisplay);
		String valueOf = String.valueOf(arg5);
		if (booktotdaystrim.contains(valueOf)) {
			System.out.println("Total day display is same as in booking confirmation page");
		} else {
			System.out.println("Total day display is not same");
		}
	}

	@Then("^User verify the total price in float including gst '(\\d+)'$")
	public void user_verify_the_total_price_in_float_including_gst(String arg1) throws Throwable {
		String pricePerNightDisplay = getAttribute(pm.getBhp().getPricePerNightDisplay());
		String totalDaysDisplay = getAttribute(pm.getBhp().getTotalDaysDisplay());
		String finalPriceDisplay = getAttribute(pm.getBhp().getFinalPrice());
		String pricetrim = pricePerNightDisplay.substring(5).trim();
		String totalDaystrim = totalDaysDisplay.substring(0, 1).trim();
		float finalPrice = Float.parseFloat(arg1) * Float.parseFloat(totalDaystrim) * Float.parseFloat(pricetrim);
		float gst = finalPrice / 10;
		System.out.println("GST = " + gst);
		float price = gst + finalPrice;
		System.out.println(price);
		String fPrice = String.valueOf(price);
		if (finalPriceDisplay.contains(fPrice)) {
			System.out.println("Final price is same as calculated");
		} else {
			System.out.println("Final price is not same");
		}
	}

	@Then("^User verifys all data are same in booking confirmation page '\"([^\"]*)\"' '\"([^\"]*)\"' '\"([^\"]*)\"' '\"([^\"]*)\"' '\"([^\"]*)\"' '(\\d+)' '(\\d+)' '\"([^\"]*)\"'$")
	public void user_verifys_all_data_are_same_in_booking_confirmation_page(String arg1, String arg2, String arg3,
			String arg4, String arg5, String arg6, String arg7, String arg8) throws Throwable {

		String bconHotel = getAttribute(pm.getBcp().getBconfirmHotel());
		String bconLocation = getAttribute(pm.getBcp().getBconfirmLocation());
		String bconRoomType = getAttribute(pm.getBcp().getBconfirmRoomType());
		String bconCheckin = getAttribute(pm.getBcp().getBconfirmCheckin());
		String bconCheckout = getAttribute(pm.getBcp().getBconfirmCheckout());
		String bconNoofRooms = getAttribute(pm.getBcp().getBconfirmNoofRooms());
		String bconAdults = getAttribute(pm.getBcp().getBconfirmAdult());
		String bconChildren = getAttribute(pm.getBcp().getBconfirmChildren());
		Assert.assertEquals(arg1, bconHotel);
		Assert.assertEquals(arg2, bconLocation);
		Assert.assertEquals(arg3, bconRoomType);
		Assert.assertEquals(arg4, bconCheckin);
		Assert.assertEquals(arg5, bconCheckout);
		
		if (bconNoofRooms.contains(arg6)) {
			System.out.println("No of rooms is same as selected");
		} else {
			System.out.println("No of rooms is not same as selected");
		}
		if (bconAdults.contains(arg7)) {
			System.out.println("No of adults is same as selected");
		} else {
			System.out.println("No of adults is not same as selected");
		}
		if (arg8.contains(bconChildren)) {
			System.out.println("No of childeren is same as selected");
		} else {
			System.out.println("No of childeren is not same as selected");
		}
	}

	@When("^User enter the today check-in date '\"([^\"]*)\"'$")
	public void user_enter_the_today_check_in_date(String arg1) throws Throwable {
		inputValue(pm.getHp().getCheckInDate(), arg1);
	}

	@When("^User enter the tomorrow check-out date '\"([^\"]*)\"'$")
	public void user_enter_the_tomorrow_check_out_date(String arg1) throws Throwable {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style','background: yellow;border:solid 2px green');",
				pm.getHp().getCheckOutDate());
		inputValue(pm.getHp().getCheckOutDate(), arg1);

	}

	@When("^User select the adult per room using drop down '(\\d+)'$")
	public void user_select_the_adult_per_room_using_drop_down(String arg1) throws Throwable {
		elementClick(pm.getHp().getAdultsPerRoomDD());
		selectValuesfromDD(pm.getHp().getAdultsPerRoomDD(), "index", arg1);
	}

	@Then("^User confirms that order no is generated or not$")
	public void user_confirms_that_order_no_is_generated_or_not() throws Throwable {
		String bconOrderno = getAttribute(pm.getBcp().getOrderNo());
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style','background: green;border:solid 2px red');",
				pm.getBcp().getOrderNo());
		if (bconOrderno != null) {
			System.out.println("Order no is generated : " + bconOrderno);
		} else {
			System.out.println("Order no is not generated : " + bconOrderno);
		}
	}

	@When("^User click on Book Itinerary link$")
	public void user_click_on_Book_Itinerary_link() throws Throwable {
		elementClick(pm.getBip().getItineraryLink());
	}

	@Then("^User to verify with existing order id '\"([^\"]*)\"'$")
	public void user_to_verify_with_existing_order_id(String arg1) throws Throwable {
		/*
		 * inputValue(pm.getBip().getSearchInputField(), arg1);
		 * elementClick(pm.getBip().getGoButton()); String orderno =
		 * getAttribute(pm.getBip().getOrderIDno()); Assert.assertEquals(arg1, orderno);
		 */
		List<WebElement> datas = driver.findElements(
				By.xpath("//form[@id='booked_form']/table[@class='login']//tbody/tr[2]/td/table/tbody/tr/td/input"));
		for (int i = 0; i < 14; i++) {
			for (int j = 1; j <= 15; j++) {
				String values = getAttribute(datas.get(i));
				int length = values.length();
				// System.out.println(length);
				setValuetoExcel("AdactinBookingItenary", "AllDatas", j, i, values);
				Thread.sleep(2000);
			}
		}
		System.out.println("All values are copied to excel");
	}

	@When("^User gets the order id no$")
	public void user_gets_the_order_id_no() throws Throwable {
		bconOrderid = getAttribute(pm.getBcp().getOrderNo()); 
		System.out.println(bconOrderid);
		File takeScreenShot = BaseClass.takeScreenShot(bconOrderid);
		Reporter.addScreenCaptureFromPath(takeScreenShot.getAbsolutePath());
		Reporter.addStepLog(bconOrderid);
		// setValuetoExcel("AdactinBookingItenary", "OrderNos", 2, 1, bconOrderid);
	}

	@When("^User clicks the My Itinerary button$")
	public void user_clicks_the_My_Itinerary_button() throws Throwable {
		List<WebElement> datas = driver.findElements(By.xpath("//form[@id='booking_form']/table//tr/td/input"));
		for (int i = 0; i < 15; i++) {
			String values = getAttribute(datas.get(i));
			System.out.println(values);
			setValuetoExcel("AdactinBookingItenary", "BookingConfirmation", 1, i, values);
		}
		elementClick(pm.getBcp().getItineraryButton());
		inputValue(pm.getBip().getSearchInputField(), bconOrderid);
		elementClick(pm.getBip().getGoButton());
	}

	@When("^User fetch datas from webtable to excel$")
	public void user_fetch_datas_from_webtable_to_excel() throws Throwable {

		List<WebElement> values = driver.findElements(
				By.xpath("//form[@id='booked_form']/table[@class='login']//tbody/tr[2]/td/table/tbody/tr[2]/td/input"));
		for (int i = 0; i < values.size(); i++) {
			String value = getAttribute(values.get(i));
			System.out.println(value);
			setValuetoExcel("AdactinBookingItenary", "AdactinOrders", 1, i, value);
		}
		// getValuesfromWebtable("//form[@id='booked_form']/table[@class='login']//tbody/tr[2]/td/table/tbody/tr[2]",i);
		// setValuetoExcel("AdactinBookingItenary", "AdactinOrders", 1, 0, "");
	}

	@Then("^User confirms that order no is generated is same as in the booking confirmation page$")
	public void user_confirms_that_order_no_is_generated_is_same_as_in_the_booking_confirmation_page()
			throws Throwable {

	}

}