package org.maven.test;

import java.util.List;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {

	public static WebDriver driver;

	public static WebDriver getBrowser(String s) throws Exception {

		try {
			if (s.equals("chrome")) {

				System.setProperty("webdriver.chrome.driver","F:\\oxygen workspace\\mvn\\Hotel\\WedDriver\\chromedriver.exe");
				driver = new ChromeDriver();

			} else if (s.equals("node-chrome")) {

				DesiredCapabilities chrome = DesiredCapabilities.chrome();
				chrome.setPlatform(Platform.WIN10);
				driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), chrome);
				 
			} else if (s.equals("firefox")) {

				System.setProperty("webdriver.gecko.driver",
						System.getProperty("user.dir") + "\\WebDrivers\\geckodriver.exe");
				driver = new FirefoxDriver();
			} else {
				throw new Exception("Invalid browser name in else");
			}
			return driver;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Invalid broweser name in catch");

		}
	}

	public static void waitForVisiblity(WebElement element) {

		try {
			WebDriverWait w = new WebDriverWait(driver, 90);
			w.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	public static boolean elementIsDisplayed(WebElement element) {

		try {
			boolean displayed = element.isDisplayed();
			return displayed;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	public static boolean elementIsEnabled(WebElement element) {

		try {
			boolean enabled = element.isEnabled();
			return enabled;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	public static boolean elementIsSelected(WebElement element) throws Exception {

		try {
			boolean selected = element.isSelected();
			return selected;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception();
		}
	}

	public static void elementClear(WebElement element) {

		try {
			element.clear();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	public static void inputValue(WebElement element, String value) throws Exception {

		try {
			waitForVisiblity(element);
			if (elementIsDisplayed(element) && elementIsEnabled(element)) {

				element.clear();
				element.sendKeys(value);

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception();
		}
	}

	public static File takeScreenShot(String fileName) throws IOException {

		try {
			File f = new File(System.getProperty("user.dir")
					+ "/src/resource/test/org/maven/reports/extentreport/screenshots/" + 
					fileName + ".png");
			TakesScreenshot ts = (TakesScreenshot) driver;
			File temp = ts.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(temp, f);
			return f;
		} catch (WebDriverException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	public static void moveToElement(WebElement element) {

		try {
			waitForVisiblity(element);
			Actions a = new Actions(driver);
			a.moveToElement(element).build().perform();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	public static void actionsClick(WebElement element) {

		try {
			waitForVisiblity(element);
			Actions a = new Actions(driver);
			a.click(element).build().perform();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	public static void elementClick(WebElement element) {

		try {
			waitForVisiblity(element);
			element.click();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	public static void selectValuesfromDD(WebElement element, String options, String value) throws Exception {

		try {
			// waitForVisiblity(element);
			Select s = new Select(element);
			if (options.equalsIgnoreCase("index")) {

				s.selectByIndex(Integer.parseInt(value));

			} else if (options.equalsIgnoreCase("value")) {

				s.selectByValue(value);

			} else if (options.equalsIgnoreCase("visible text")) {

				s.selectByVisibleText(value);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception();
		}
	}

	public static void getUrl(String url) {

		try {
			driver.get(url);
			driver.manage().window().maximize();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	public static String getText(WebElement element) {

		try {
			waitForVisiblity(element);
			String value = element.getText();
			return value;

		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	public static String getAttribute(WebElement element) {

		try {
			waitForVisiblity(element);
			String value = element.getAttribute("value");
			return value;

		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	public static String getTitle() {

		try {
			String title = driver.getTitle();
			return title;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	public static void dragAndDrop(WebElement element, String options, String value) throws Exception {

		try {
			Select s = new Select(element);
			if (options.equalsIgnoreCase("index")) {

				s.selectByIndex(Integer.parseInt(value));

			} else if (options.equalsIgnoreCase("value")) {

				s.selectByValue(value);

			} else if (options.equalsIgnoreCase("visible text")) {

				s.selectByVisibleText(value);
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
			throw new Exception();
		}

	}

	public static void doubleClick(WebElement element) throws Exception {

		try {
			waitForVisiblity(element);
			Actions a = new Actions(driver);
			a.doubleClick(element).build().perform();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	public static void contextClick(WebElement element) {

		try {
			Actions a = new Actions(driver);
			a.contextClick(element).build().perform();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	public static void inputValueusingActions(WebElement element, String value) throws Exception {

		try {
			waitForVisiblity(element);
			Actions a = new Actions(driver);
			a.sendKeys(element, value).build().perform();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	public static void scrollUpandScrollDownusingElement(WebElement element) throws Exception {

		try {
			// waitForVisiblity(element);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", element);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	public static void scrollUpandScrollDownusingCoordinates(WebElement element, String width, String height)
			throws Exception {

		try {
			waitForVisiblity(element);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(" + width + ", " + height + ")");
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception();
		}
	}

	public static void scrollToBottomPage(WebElement element) throws Exception {

		try {
			waitForVisiblity(element);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception();
		}
	}

	public static void waitforAlertisPresent() throws Exception {

		try {
			WebDriverWait wb = new WebDriverWait(driver, 30);
			wb.until(ExpectedConditions.alertIsPresent());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception();
		}
	}

	public static void simpleAlert() throws Exception {

		try {
			waitforAlertisPresent();
			Alert alert = driver.switchTo().alert();
			alert.accept();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception();
		}
	}

	public static void confirmAlert(String options) throws Exception {

		try {
			Alert alert = driver.switchTo().alert();
			if (options.equalsIgnoreCase("ok")) {
				alert.accept();
			} else if (options.equalsIgnoreCase("cancel")) {
				alert.dismiss();
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception();
		}
	}

	public static void promptAlert(String options, String values) throws Exception {

		try {
			waitforAlertisPresent();
			Alert alert = driver.switchTo().alert();
			if (options.equalsIgnoreCase("ok")) {
				alert.sendKeys(values);
				alert.accept();
			} else if (options.equalsIgnoreCase("cancel")) {
				alert.dismiss();
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception();
		}
	}

	public static void driverQuit() throws Exception {

		try {
			driver.quit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new Exception();
		}
	}

	public static void navigateToUrl(String url) throws Exception {

		try {
			driver.navigate().to(url);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new Exception();
		}

	}

	public static void navigationCommands(String options) {

		if (options.equalsIgnoreCase("back")) {
			driver.navigate().back();

		} else if (options.equalsIgnoreCase("forward")) {
			driver.navigate().forward();
		} else if (options.equalsIgnoreCase("refresh")) {
			driver.navigate().refresh();
		}
	}

	public static void getValuesfromWebtable(String element, int i) {
		try {
			WebElement table = driver.findElement(By.xpath(element));
			List<WebElement> findElements = table.findElements(By.xpath("//tr[3]//td[" + i + "]"));
			for (WebElement x : findElements) {
				System.out.println(x.getText());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	public static String getValuesfromExcel(String fileName, String sheetname, int rownum, int cellnum)
			throws Throwable {

		try {
			File f = new File(System.getProperty("user.dir") + "\\Resources\\" + fileName + ".xlsx");
			FileInputStream fin = new FileInputStream(f);
			Workbook wb = new XSSFWorkbook(fin);
			Sheet sheet = wb.getSheet(sheetname);
			Cell cell = sheet.getRow(rownum).getCell(cellnum);
			CellType cellType = cell.getCellType();
			String string = null;
			if (cellType.equals(CellType.STRING)) {
				string = cell.getStringCellValue();
			} else if (cellType.equals(CellType.NUMERIC)) {
				double numericCellValue = cell.getNumericCellValue();
				long l = (long) numericCellValue;
				string = String.valueOf(l);
			}
			return string;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();

		}

	}

	public static void main(String[] args) throws Throwable {
		setValuetoExcel("AdactinBookingItenary", "Sheet1", 1, 2, "Test");
	}

	public static void setValuetoExcel(String fileName, String sheetname, int rownum, int cellnum, String value)
			throws Exception {

		try {
			File f = new File(System.getProperty("user.dir") + "\\Resources\\" + fileName + ".xlsx");
			FileInputStream fin = new FileInputStream(f);
			Workbook wb = new XSSFWorkbook(fin);
			Sheet sheet = wb.getSheet(sheetname);
			// System.out.println(f.exists());
			Row row = sheet.getRow(rownum);
			if (row == null) {
				row = sheet.createRow(rownum);
			}
			Cell cell = row.getCell(cellnum, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
			if (cell == null) {
				Cell createCell = sheet.getRow(rownum).createCell(cellnum);
				createCell.setCellValue(value);
			} else {
				cell.setCellValue(value);
			}
			FileOutputStream fout = new FileOutputStream(f);
			wb.write(fout);
			fout.close();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new Exception();

		}

	}

}
