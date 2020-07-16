package org.maven.runner;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.Random;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.maven.test.BaseClass;
import org.openqa.selenium.WebDriver;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src\\test\\java\\org\\maven\\feature\\",
		tags = {"@TC16"},
		
		dryRun = true,
		glue = "org.maven.stepdefinition",
		monochrome = true
		)

public class TestRunner2 {

	public static WebDriver driver;
	
	@BeforeClass
	
	public static void browserLaunch() throws Exception {
		driver = BaseClass.getBrowser("chrome");
	}
	
	@AfterClass
	public static void browserQuit() {
		driver.quit();
	}
	public static void main(String[] args) {


		LocalTime now = LocalTime.now();
		System.out.println(now);
		
		LocalDate now2 = LocalDate.now();
		System.out.println(now2);
		
		
	}
}
