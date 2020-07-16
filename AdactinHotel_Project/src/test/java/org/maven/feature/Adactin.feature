@TC
Feature: Login functionality for Adactin web application
Contains 2 test scenario with login details

Background: User launch the browser
Given User should launch the browser
And User hold for '3' seconds

@TC1
Scenario: User verify for valid login credentials
Then User should verify the Welcome to AdactIn Group of Hotels is displayed in the login page
When User enters the username in the login page
And User enters the password in the login page 
And User clicks the Login button in the login page
And User hold for '3' seconds
And User clicks the Logout button in home page

@TC2
Scenario: User to verify whether the check-out date field accepts a later date than checkin date
Then User should verify the Welcome to AdactIn Group of Hotels is displayed in the login page
When User enters the username in the login page
And User enters the password in the login page 
And User clicks the Login button in the login page
And User hold for '3' seconds
When User select the location using drop down
And User select the hotel using drop down
And User select the room type using drop down
And User select the no of rooms using drop down
And User enter the check-in date
And User enter the check-out date
And User select the adult per room using drop down
And User select the children per room using drop down
And User clicks the search button
Then User should verify the error message is displayed
When User waits for '3' seconds
And User clicks the Logout button in home page

@TC3
Scenario: User to check if error is reported if check-out date field is in the past
Then User should verify the Welcome to AdactIn Group of Hotels is displayed in the login page
When User enters the username in the login page
And User enters the password in the login page 
And User clicks the Login button in the login page
And User hold for '3' seconds
When User select the location using drop down
And User select the hotel using drop down
And User select the room type using drop down
And User select the no of rooms using drop down
And User enter the check-in date past 5 days
And User enter the check-out date past 3 days
And User select the adult per room using drop down
And User select the children per room using drop down
And User clicks the search button
Then User should verify the error message as enter valid dates
When User waits for '3' seconds
And User clicks the Logout button in home page

@TC4
Scenario: User to verify whether locations in Select Hotel page are displayed according to the location selected in Search Hotel
Then User should verify the Welcome to AdactIn Group of Hotels is displayed in the login page
When User enters the username in the login page
And User enters the password in the login page 
And User clicks the Login button in the login page
And User hold for '3' seconds
When User select the location using drop down
And User select the hotel creep using drop down
And User select the room type using drop down
And User select the no of rooms using drop down
And User enter the today check-in date
And User enter the tomorrow check-out date
And User select the adult per room using drop down
And User select no children per room using drop down
And User clicks the search button
And User waits for '3' seconds
Then User verify the hotel displayed is same as selected in the hotel form
When User waits for '3' seconds
And User clicks the Logout button in home page

@TC5
Scenario: User to verify whether Check-in date and Check Out date are being displayed in Select Hotel page according to the dates selected in search Hotel.
Then User should verify the Welcome to AdactIn Group of Hotels is displayed in the login page
When User enters the username in the login page
And User enters the password in the login page 
And User clicks the Login button in the login page
And User hold for '3' seconds
When User select the location using drop down
And User select the hotel creep using drop down
And User select the room type using drop down
And User select the no of rooms using drop down
And User enter the today check-in date
And User enter the tomorrow check-out date
And User select the adult per room using drop down
And User select no children per room using drop down
And User clicks the search button
And User waits for '3' seconds
Then User verify the check-in date is same as selected in the search hotel form
Then User verify the check-out date is same as selected in the search hotel form
When User waits for '3' seconds
And User clicks the Logout button in home page

@TC6
Scenario Outline: User to verify whether no. of rooms entry in Select Hotel page is same as the Number of rooms selected in search hotel page
Then User should verify the Welcome to AdactIn Group of Hotels is displayed in the login page
When User enters the username in the login page
And User enters the password in the login page 
And User clicks the Login button in the login page
And User hold for '3' seconds
When User select the location using drop down
And User select the hotel creep using drop down
And User select the room type using drop down
And User select the no of rooms using drop down '<Room No>'
And User enter the today check-in date
And User enter the tomorrow check-out date
And User select the adult per room using drop down
And User select no children per room using drop down
And User clicks the search button
And User waits for '3' seconds
Then User to verify that no of rooms is reflected according to the no of rooms selected in search hotel page '<Room No>'
When User waits for '3' seconds
And User clicks the Logout button in home page

Examples:
|Room No|
|3|

@TC7
Scenario: User to verify whether Room Type in Select Hotel page is same as Room type selected in search hotel page
Then User should verify the Welcome to AdactIn Group of Hotels is displayed in the login page
When User enters the username in the login page
And User enters the password in the login page 
And User clicks the Login button in the login page
And User hold for '3' seconds
When User select the location using drop down
And User select the hotel creep using drop down
And User select the room type deluxe using drop down
And User select the no of rooms using drop down
And User enter the today check-in date
And User enter the tomorrow check-out date
And User select the adult per room using drop down
And User select no children per room using drop down
And User clicks the search button
And User waits for '3' seconds
Then User verify that room type reflected is the same as selected in search hotel page
When User waits for '3' seconds
And User clicks the Logout button in home page

@TC8
Scenario Outline: To verify whether the total price (excl.GST) is calculated as “price per night * no. of nights* no of rooms”.
Then User should verify the Welcome to AdactIn Group of Hotels is displayed in the login page
When User enters the username in the login page
And User enters the password in the login page 
And User clicks the Login button in the login page
And User hold for '3' seconds
When User select the location using drop down
And User select the hotel creep using drop down
And User select the room type using drop down
And User select the no of rooms using drop down '<No of Rooms>'
And User enter the today check-in date
And User enter the tomorrow check-out date
And User select the adult per room using drop down
And User select no children per room using drop down
And User clicks the search button
And User waits for '3' seconds
When User clicks the radio button in the hotel search page
And User clicks the continue button in the hotel search page
And User waits for '3' seconds
Then User verify the total price excluding gst '<No of Rooms>'
When User waits for '3' seconds
And User clicks the Logout button in home page

Examples:
|No of Rooms|
|2|

@TC9
Scenario Outline: To verify when pressed, logout button logs out from the application
Then User should verify the Welcome to AdactIn Group of Hotels is displayed in the login page
When User enters the username in the login page
And User enters the password in the login page 
And User clicks the Login button in the login page
And User hold for '3' seconds
When User select the location using drop down
And User select the hotel creep using drop down
And User select the room type using drop down
And User select the no of rooms using drop down '<No of Rooms>'
And User enter the today check-in date
And User enter the tomorrow check-out date
And User select the adult per room using drop down
And User select no children per room using drop down
And User clicks the search button
And User waits for '3' seconds
When User clicks the radio button in the hotel search page
And User clicks the continue button in the hotel search page
And User waits for '3' seconds
When User enters first name
And User enters last name
And User enters billing address
And User enters 16 digit credit card number
And User selects the card type
And User selects the expiry month
And User selects the expiry year
And User enters the cvv number
And User clicks the book now button
And User waits for '3' seconds
When User clicks the logout button in the booking confirmation page

Examples:
|No of Rooms|
|2|

@TC10
Scenario Outline: User to check correct total price is being calculated as “price per night*no of days*no of rooms in Book a hotel page
Then User should verify the Welcome to AdactIn Group of Hotels is displayed in the login page
When User enters the username in the login page
And User enters the password in the login page 
And User clicks the Login button in the login page
And User hold for '3' seconds
When User select the location using drop down
And User select the hotel creep using drop down
And User select the room type using drop down
And User select the no of rooms using drop down '<No of Rooms>'
And User enter the today check-in date
And User enter the tomorrow check-out date
And User select the adult per room using drop down
And User select no children per room using drop down
And User clicks the search button
And User waits for '3' seconds
When User clicks the radio button in the hotel search page
And User clicks the continue button in the hotel search page
And User waits for '3' seconds
Then User verify the total price including gst '<No of Rooms>'
When User waits for '3' seconds
And User clicks the Logout button in home page

Examples:
|No of Rooms|
|2|

@TC11
Scenario Outline: User to check Hotel name, Location, room type, Total Day, price per night are same in Booking confirmation page as they were selected in previous screen
Then User should verify the Welcome to AdactIn Group of Hotels is displayed in the login page
When User enters the username in the login page
And User enters the password in the login page 
And User clicks the Login button in the login page
And User hold for '3' seconds
When User select the location using drop down '<Location>'
And User select the hotel creep using drop down '<Hotel Name>'
And User select the room type using drop down '<Room Type>'
And User select the no of rooms using drop down '<No of Rooms>'
And User enter the today check-in date
And User enter the tomorrow check-out date
And User select the adult per room using drop down
And User select no children per room using drop down
And User clicks the search button
And User waits for '3' seconds
When User clicks the radio button in the hotel search page
And User clicks the continue button in the hotel search page
And User waits for '3' seconds
Then User verify the total data are same in booking confirmation page '<Location>' '<Hotel Name>' '<Room Type>' '<Price Per Night>' '<No Of Days>' 
When User waits for '3' seconds
And User clicks the Logout button in home page

Examples:
|No of Rooms|Hotel Name   |Location|Room Type	|Price Per Night|No Of Days|
|2					|"Hotel Creek"|"Sydney"|"Standard"|"AUD $ 125"		|1				 |

@TC12
Scenario Outline: User to check correct total price is being calculated as “price per night*no of days*no of rooms in Book a hotel page
Then User should verify the Welcome to AdactIn Group of Hotels is displayed in the login page
When User enters the username in the login page
And User enters the password in the login page 
And User clicks the Login button in the login page
And User hold for '3' seconds
When User select the location using drop down
And User select the hotel creep using drop down
And User select the room type using drop down
And User select the no of rooms using drop down '<No of Rooms>'
And User enter the today check-in date
And User enter the tomorrow check-out date
And User select the adult per room using drop down
And User select no children per room using drop down
And User clicks the search button
And User waits for '3' seconds
When User clicks the radio button in the hotel search page
And User clicks the continue button in the hotel search page
And User waits for '3' seconds
Then User verify the total price in float including gst '<No of Rooms>'
When User waits for '3' seconds
And User clicks the Logout button in home page

Examples:
|No of Rooms|
|1|

@TC13
Scenario Outline: User to check Hotel name, Location, room type, no of rooms, checkin date and checkout date are same in Booking confirmation page as they were selected in previous screen
Then User should verify the Welcome to AdactIn Group of Hotels is displayed in the login page
When User enters the username in the login page
And User enters the password in the login page 
And User clicks the Login button in the login page
And User hold for '3' seconds
When User select the location using drop down '<Location>'
And User select the hotel creep using drop down '<Hotel Name>'
And User select the room type using drop down '<Room Type>'
And User select the no of rooms using drop down '<No of Rooms>'
And User enter the today check-in date '<Checkin Date>'
And User enter the tomorrow check-out date '<Checkout Date>'
And User select the adult per room using drop down '<No of Adults>'
And User select no children per room using drop down
And User clicks the search button
And User waits for '3' seconds
When User clicks the radio button in the hotel search page
And User clicks the continue button in the hotel search page
And User waits for '3' seconds
When User enters first name
And User enters last name
And User enters billing address
And User enters 16 digit credit card number
And User selects the card type
And User selects the expiry month
And User selects the expiry year
And User enters the cvv number
And User clicks the book now button
And User waits for '3' seconds
Then User verifys all data are same in booking confirmation page '<Hotel Name>' '<Location>' '<Room Type>' '<Checkin Date>' '<Checkout Date>' '<No of Rooms>' '<No of Adults>' '<No of Children>'
When User waits for '3' seconds
And User clicks the Logout button in home page

Examples:
|Hotel Name   |Location|Room Type	|Checkin Date|Checkout Date|No of Rooms	|No of Adults|No of Children|
|"Hotel Creek"|"Sydney"|"Standard"|"18/04/2019"|"19/04/2019" |2 					|1					 |"No Children" |

@TC14
Scenario Outline: Verify Order number is generated in booking confirmation page
Then User should verify the Welcome to AdactIn Group of Hotels is displayed in the login page
When User enters the username in the login page
And User enters the password in the login page 
And User clicks the Login button in the login page
And User hold for '3' seconds
When User select the location using drop down '<Location>'
And User select the hotel creep using drop down '<Hotel Name>'
And User select the room type using drop down '<Room Type>'
And User select the no of rooms using drop down '<No of Rooms>'
And User enter the today check-in date '<Checkin Date>'
And User enter the tomorrow check-out date '<Checkout Date>'
And User select the adult per room using drop down '<No of Adults>'
And User select no children per room using drop down
And User clicks the search button
And User waits for '3' seconds
When User clicks the radio button in the hotel search page
And User clicks the continue button in the hotel search page
And User waits for '3' seconds
When User enters first name
And User enters last name
And User enters billing address
And User enters 16 digit credit card number
And User selects the card type
And User selects the expiry month
And User selects the expiry year
And User enters the cvv number
And User clicks the book now button
And User waits for '3' seconds
Then User confirms that order no is generated or not
When User waits for '3' seconds
And User clicks the Logout button in home page

Examples:
|Hotel Name   |Location|Room Type	|Checkin Date|Checkout Date|No of Rooms	|No of Adults|
|"Hotel Creek"|"Sydney"|"Standard"|"18/04/2019"|"19/04/2019" |2 					|1					 |

@TC17
Scenario Outline: User to verify that search order id is working or not
Then User should verify the Welcome to AdactIn Group of Hotels is displayed in the login page
When User enters the username in the login page
And User enters the password in the login page 
And User clicks the Login button in the login page
And User hold for '3' seconds
And User click on Book Itinerary link
Then User to verify with existing order id '<Order ID>'

Examples:
|Order ID	 	 |
|"6Y6Y0NV6X0"|

@TC16
Scenario Outline: Verify booking itinerary is reflecting the correct information in booking confirmation page
Then User should verify the Welcome to AdactIn Group of Hotels is displayed in the login page
When User enters the username in the login page
And User enters the password in the login page 
And User clicks the Login button in the login page
And User hold for '3' seconds
When User select the location using drop down '<Location>'
And User select the hotel creep using drop down '<Hotel Name>'
And User select the room type using drop down '<Room Type>'
And User select the no of rooms using drop down '<No of Rooms>'
And User enter the today check-in date '<Checkin Date>'
And User enter the tomorrow check-out date '<Checkout Date>'
And User select the adult per room using drop down '<No of Adults>'
And User select no children per room using drop down
And User clicks the search button
And User waits for '3' seconds
When User clicks the radio button in the hotel search page
And User clicks the continue button in the hotel search page
And User waits for '3' seconds
When User enters first name
And User enters last name
And User enters billing address
And User enters 16 digit credit card number
And User selects the card type
And User selects the expiry month
And User selects the expiry year
And User enters the cvv number
And User clicks the book now button
And User waits for '3' seconds
And User gets the order id no
Then User confirms that order no is generated or not
And User waits for '3' seconds
And User clicks the My Itinerary button 
And User fetch datas from webtable to excel
Then User confirms that order no is generated is same as in the booking confirmation page
When User waits for '3' seconds
And User clicks the Logout button in home page

Examples:
|Hotel Name   |Location|Room Type	|Checkin Date|Checkout Date|No of Rooms	|No of Adults|
|"Hotel Creek"|"Sydney"|"Standard"|"18/04/2019"|"19/04/2019" |2 					|1					 |
