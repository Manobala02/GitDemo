package org.maven.runner;

import java.io.File;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.Random;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.maven.helper.FileReaderManager;
import org.maven.test.BaseClass;
import org.openqa.selenium.WebDriver;

import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = { "pretty",
		"com.cucumber.listener.ExtentCucumberFormatter:src\\resource\\test\\org\\maven\\reports\\extentreport\\report.html",
		"html:src\\resource\\test\\org\\maven\\reports", 
		"junit:src\\resource\\test\\org\\maven\\reports\\cucumber.xml",
		"json:src\\resource\\test\\org\\maven\\reports\\cucumber.json" },

		features = "src\\test\\java\\org\\maven\\feature\\", 
		tags = {"@TC1" },
		dryRun = false,
		glue = "org.maven.stepdefinition",
		monochrome = true)

public class TestRunner {

	public static WebDriver driver;

	@BeforeClass

	public static void browserLaunch() throws Throwable {
		 String getbrowserName = FileReaderManager.getInstance().getConfigReader().getbrowserName();
		//driver = BaseClass.getBrowser("node-chrome");
		 driver=BaseClass.getBrowser(getbrowserName);				 
		
	}

	@AfterClass
	public static void browserQuit() {
		driver.quit();
		Reporter.loadXMLConfig(new File(System.getProperty("user.dir") + 
				"\\src\\resource\\test\\org\\maven\\lib\\extent-config.xml"));

	}
	
}
