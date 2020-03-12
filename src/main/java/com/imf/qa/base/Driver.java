package com.imf.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.imf.qa.util.WebEventListener;
import com.imf.qa.util.Xls_Reader;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class Driver extends Xls_Reader {

	protected static WebDriver driver;
	protected static Properties prop;
	public static EventFiringWebDriver e_driver; // class available with Selenium
	public static WebEventListener eventListener;
	public static long PAGE_LOAD_TIMEOUT = 60;
	public static long IMPLICIT_WAIT = 60;

	/*
	 * static ExtentReports extent = new ExtentReports("/target/Report", true);
	 * static ExtentTest suiteName = null; static ExtentTest testName = null;
	 */

	public ExtentReports report;
	public ExtentTest test;
	String reportPath = new File("").getAbsolutePath().toString().trim() + "/Reports/";

	public void reportinit() {

		report = new ExtentReports(reportPath + this.getClass().getSimpleName() + ".html", false);
		test = report.startTest("Extent Report Example Project");

	}

	public static void initialization() throws IOException {

		prop = new Properties();
		FileInputStream ip = new FileInputStream("src/test/resources/Config.properties");
		prop.load(ip);

		String browserName = prop.getProperty("browser");

		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
			driver = new ChromeDriver();
		}

		else if (browserName.equals("ie")) {
			System.setProperty("webdriver.ie.driver", "src/test/resources/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}

		// Add Web Driver fire event
		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with
		// EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT, TimeUnit.SECONDS);

		driver.get(prop.getProperty("url"));

	}

	public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(scrFile,
				new File(currentDir + "/target/screenshots/" + System.currentTimeMillis() + ".png"));

	}

}
