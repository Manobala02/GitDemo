package org.cucumber.maven.AdactinHotel_Project;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdactinLoginPage {

	public WebDriver driver;
	
	@FindBy(xpath="//td[@class='content_left']//p[text()='Welcome to AdactIn Group of Hotels']")
	private WebElement validateText;
	
	@FindBy(id="username")
	private WebElement userInputField;
	
	@FindBy(id="password")
	private WebElement passwordInputField;
	
	@FindBy(id="login")
	private WebElement loginBtn;
	
	@FindBy(id="username_show")
	private WebElement usernameValidText;
	
	@FindBy(xpath = "//a[text()='Logout']")
	private WebElement logOut;

	public WebElement getUsernameValidText() {
		return usernameValidText;
	}

	public WebElement getLogOut() {
		return logOut;
	}

	public WebElement getValidateText() {
		return validateText;
	}

	public WebElement getUserInputField() {
		return userInputField;
	}

	public WebElement getPasswordInputField() {
		return passwordInputField;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	public AdactinLoginPage(WebDriver ldriver) {
		this.driver = ldriver;
		PageFactory.initElements(driver, this);

	
	
	}
	
}
