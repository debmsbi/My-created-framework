package com.imf.qa.base;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FilenameFilter;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

public class BasePage extends Driver {

	protected static Robot robot;
	protected final static String RESOURCES_FOLDER_PATH = "./src/test/resources/";

	/**
	 * The function is used to maximize the browser window
	 */
	protected static synchronized void maximize() {
		driver.manage().window().maximize();
	}

	/**
	 * This function is to Accept Alert
	 * 
	 * @return Boolean value True if Alert is Present else return False
	 * @exception NoAlertPresentException, Exception
	 */
	protected static synchronized void acceptAlertDialog() {
		try {
			driver.switchTo().alert().accept();

		} catch (NoAlertPresentException e) {
		} catch (WebDriverException e) {
		} catch (Exception e) {
		}
	}

	/**
	 * This function is to get text from Alert window
	 * 
	 * @return String Text Value of alert
	 */
	protected synchronized static String alertGetText() {
		try {
			return driver.switchTo().alert().getText();
		} catch (WebDriverException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * This function is to tick the checkbox
	 * 
	 * @param description : Description for the logger
	 * @param checkbox    : WebElement as a parameter
	 */
	protected synchronized static void checkboxCheck(String description, WebElement checkbox) {
		try {
			if (checkbox.isSelected()) {
			} else {
				checkbox.click();
			}
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * This function is to untick the checkbox
	 * 
	 * @param description : Description for the logger
	 * @param checkbox    : WebElement as a parameter
	 */
	protected synchronized static void checkboxUncheck(String description, WebElement checkbox) {
		try {
			if (checkbox.isSelected()) {
				checkbox.click();
			} else {
			}

		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * This function is to get list of values from the Dropdown
	 * 
	 * @param description : Description for the logger
	 * @param dropdown    : WebElement as a parameter
	 */
	protected static synchronized List<String> getAllOptionsFromDropDown(String description, WebElement dropdown) {
		try {
			return new Select(dropdown).getOptions().stream().map(WebElement::getText).collect(Collectors.toList());
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * This function is to select the dropdown value through visible text
	 * 
	 * @param description : Description for the logger
	 * @param dropdown    : WebElement as a parameter
	 * @param visibleText : Value to be selected in a dropdown
	 */
	protected synchronized static void selectDropDownByVisibleText(String description, WebElement dropdown,
			String visibleText) {
		try {
			new Select(dropdown).selectByVisibleText(visibleText);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * This function is to select the dropdown value through value
	 * 
	 * @param description : Description for the logger
	 * @param checkbox    : WebElement as a parameter
	 * @param value       : Value to be selected in a dropdown
	 */
	protected synchronized static void selectDropDownByValue(String description, WebElement dropdown, String value) {

		try {
			new Select(dropdown).selectByValue(value);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * This function is to select the dropdown value through index
	 * 
	 * @param description : Description for the logger
	 * @param dropdown    : WebElement as a parameter
	 * @param index       : Value to be selected in a dropdown
	 */
	protected synchronized static void selectDropDownByIndex(String description, WebElement dropdown, String index) {
		try {
			new Select(dropdown).selectByIndex(Integer.parseInt(index));
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * This function is to get the selected option/Default option from the dropdown
	 * 
	 * @param description : Description for the logger
	 * @param dropdown    : WebElement as a parameter
	 * 
	 */
	protected static synchronized String getDefaultDropDownValue(String description, WebElement dropdown) {
		try {
			return new Select(dropdown).getFirstSelectedOption().getText();
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * This function is to get the size of WebElements
	 * 
	 * @param description : Description for the logger
	 * @param elements    : WebElement as a parameter
	 * 
	 */
	protected synchronized int sizeOfWebElements(String description, List<WebElement> elements) {
		try {
			return elements.size();
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * This function is to open the mentioned URL
	 * 
	 * @param url
	 */
	protected static synchronized void openUrl(String url) {
		try {
			driver.get(url);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * This function is to get the current page URL
	 * 
	 * @return : Current URL
	 */
	protected static synchronized String getCurrentUrl() {
		String url = "";
		try {
			url = driver.getCurrentUrl();
			return url;
		}

		catch (Exception e) {
			throw e;
		}

	}

	/**
	 * This function is to refresh the browser
	 */
	protected static synchronized void refreshBrowser() {
		try {
			driver.navigate().refresh();
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * This function is to click on a particular WebElement
	 * 
	 * @param description Description for the logger
	 * @param element     WebElement
	 * 
	 */
	protected static synchronized void clickOnElement(String description, WebElement element) {
		try {
			element.click();
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * This function is to clear the field and then enters the text in the field
	 * 
	 * @param description Description for the logger
	 * @param element     WebElement
	 * @param texToEnter  Text to enter
	 * 
	 */
	protected static synchronized void enterText(String description, WebElement element, String texToEnter) {
		try {
			element.clear();
			element.sendKeys(texToEnter);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * This function is to get the Text value from the Page WebElement
	 * 
	 * @param description : Description For the logger
	 * @param element     : WebElement
	 * @return Text of the Webelement
	 */
	protected static synchronized String getText(String description, WebElement element) {
		String text = "";
		try {
			text = element.getText();
		} catch (Exception e) {
			throw e;
		}
		return text;
	}

	/**
	 * To get the list of text from all the elements
	 * 
	 * @param description : Description For the logger
	 * @param elements    : List of WebElements
	 * @return List of WebElements
	 */
	protected static synchronized List<String> getTextFromAllElements(String description, List<WebElement> elements) {
		try {
			return elements.stream().map(WebElement::getText).collect(Collectors.toList());
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * This function is to switch to Window that contains the urlText.
	 * 
	 * @param description : Description For the logger
	 * @param urlText     : url text of the new window
	 */
	protected static synchronized void switchToWindowWithUrlText(String description, String urlText) {
		try {
			Optional<WebDriver> window = driver.getWindowHandles().stream().map(driver.switchTo()::window)
					.filter(driver -> driver.getCurrentUrl().contains(urlText)).findFirst();
			if (window.isPresent()) {
			} else {
			}
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * This function is to switch to new window that contains the title.
	 * 
	 * @param description : Description For the logger
	 * @param title       : title text of the new window
	 */
	protected static synchronized void switchToWindowWithTitle(String description, String titleText) {
		try {
			Optional<WebDriver> window = driver.getWindowHandles().stream().map(driver.switchTo()::window)
					.filter(driver -> driver.getTitle().contains(titleText)).findFirst();
			if (window.isPresent()) {
			} else {
			}
		} catch (Exception e) {
			throw e;
		}

	}

	/**
	 * This function is to switch to Parent window
	 * 
	 * @param description : Description For the logger
	 */
	protected synchronized static void switchToParentWindow(String description) {
		try {
			Optional<String> window = driver.getWindowHandles().stream().findFirst();
			if (window.isPresent()) {
				driver.switchTo().window(window.get());
			} else {
			}
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * This function is to switch to new window
	 * 
	 * @param description : Description For the logger
	 */
	protected synchronized static void switchToWindow(String description) {
		try {
			String currentWindow = getCurrentWindow();
			Optional<String> window = driver.getWindowHandles().stream().filter(handle -> !handle.equals(currentWindow))
					.findFirst();
			if (window.isPresent()) {
				driver.switchTo().window(window.get());
			} else {
				driver.switchTo().window(currentWindow);
			}
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * This method is used to get the handle of the web-page
	 * 
	 * @return The current window handle
	 */
	protected static synchronized String getCurrentWindow() {
		try {
			return driver.getWindowHandle();
		} catch (Exception e) {
			throw e;
		}

	}

	/**
	 * This method is to switch to frame using weblement
	 * 
	 * @param description : description
	 * @param element     : Webelement
	 */
	protected synchronized static void switchToFrameByWebelement(String description, WebElement element) {

		try {
			driver.switchTo().frame(element);
		} catch (NoSuchFrameException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * This method is to switch to frame using index
	 * 
	 * @param description : description
	 * @param index       : Index
	 */
	protected synchronized static void switchToFrameByIndex(String description, int index) {

		try {
			driver.switchTo().frame(index);
		} catch (NoSuchFrameException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * This method is to switch to default frame
	 * 
	 * @param description : Description
	 */
	protected synchronized static void switchToDefaultFrame(String description) {
		try {
			driver.switchTo().defaultContent();
		} catch (NoSuchFrameException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * This function is to move to element using Actions utility
	 * 
	 * @param description : Description For the logger
	 * @param element     : WebElement
	 * @return
	 */
	protected static synchronized Actions movetoElement(String description, WebElement element) {

		try {
			return new Actions(driver).moveToElement(element);
		} catch (Exception e) {
			throw e;
		}

	}

	/**
	 * This method is used to wait for a particular element to appear in the
	 * web-page
	 * 
	 * @param description : Description For the logger
	 * @param element     : WebElement
	 */
	protected static synchronized void waitForElementToBePresent(String description, WebElement element) {
		try {
			Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(60))
					.pollingEvery(Duration.ofMillis(250)).ignoring(NoSuchElementException.class);
			wait.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * This method is used to wait for a particular element to appear in the
	 * web-page
	 * 
	 * @param description : Description For the logger
	 * @param element     : WebElement
	 * @param seconds     : Time in seconds
	 */
	protected static synchronized void waitForElementToBePresent(String description, WebElement element, long seconds) {
		try {
			Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(seconds))
					.pollingEvery(Duration.ofMillis(250)).ignoring(NoSuchElementException.class);
			wait.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * The function is to check if the alert is present
	 * 
	 * @param description : Description For the logger
	 * @return <b>true</b> if alert is present, <b>false</b> otherwise
	 */
	protected static synchronized boolean checkIsAlertPresent(String description) {
		try {
			Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(60))
					.pollingEvery(Duration.ofMillis(250)).ignoring(NoSuchElementException.class);
			wait.until(ExpectedConditions.alertIsPresent());
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * The function is to manage the Alert basis on boolean condition
	 * 
	 * @param description : Description For the logger
	 * @param condition   : <b>true</b> to accept alert, <b>false</b> to dismiss
	 *                    alert
	 */
	protected static synchronized void acceptRejectAlert(String description, boolean condition) {
		try {
			if (condition) {
				driver.switchTo().alert().accept();
			} else {
				driver.switchTo().alert().dismiss();
			}
		} catch (Exception e) {

		}
	}

	/**
	 * The function uses Robot class to save PDF(displayed on Web page) on given
	 * path
	 * 
	 * @param description   : PDF details
	 * @param pathToSavePDF : Path to save PDF
	 * @throws Exception Generic Exception
	 */
	protected static synchronized void savePDFfromWebPage(String description, String pathToSavePDF) {
		try {
			robot = new Robot();
			Thread.sleep(10000);
			((JavascriptExecutor) driver).executeScript("window.focus();");
			maximize();
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_SHIFT);
			robot.keyPress(KeyEvent.VK_S);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyRelease(KeyEvent.VK_SHIFT);
			robot.keyRelease(KeyEvent.VK_S);
			Thread.sleep(3000);
			StringSelection stringSelection = new StringSelection(pathToSavePDF);
			Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
			clipboard.setContents(stringSelection, stringSelection);
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(5000);
		} catch (Exception e) {
		}
	}

	/**
	 * The function deletes file from resources folder (Maven projet) through input
	 * parameter of file extension
	 * 
	 * @param extension : File extension to delete the file from resources folder
	 */
	protected void deleteFilefromResources(String extension) {

		String[] list = new File(RESOURCES_FOLDER_PATH).list(new GenericExtFilter(extension));

		if (new File(RESOURCES_FOLDER_PATH).list(new GenericExtFilter(extension)).length > 0) {

			for (String file : list) {
				String temp = new StringBuffer(RESOURCES_FOLDER_PATH).append(File.separator).append(file).toString();

				boolean isdeleted = new File(
						new StringBuffer(RESOURCES_FOLDER_PATH).append(File.separator).append(file).toString())
								.delete();

			}
		} else

			return;
	}

	/**
	 * Instances of classes that implement this interface are used to filter
	 * filenames. These instances are used to filter directory listings in the
	 * <code>list</code> method of class <code>File</code>, and by the Abstract
	 * Window Toolkit's file dialog component.
	 */
	private class GenericExtFilter implements FilenameFilter {

		private String ext;

		public GenericExtFilter(String ext) {
			this.ext = ext;
		}

		public boolean accept(File dir, String name) {
			return (name.endsWith(ext));
		}
	}

	/**
	 * @param description   : PDF description
	 * @param textToCompare : Text to search in the PDF
	 * @param pathToReadPDF : Path to read PDF
	 * @return String : Text to compare and occurrences
	 * @throws Exception Generic exception
	 */
	protected static synchronized String readtextFromPDF(String description, String textToCompare,
			String pathToReadPDF) {
		try {

			PDDocument document = PDDocument.load(new File(pathToReadPDF));

			PDFTextStripper pdfStripper = new PDFTextStripper();
			String lines[] = pdfStripper.getText(document).split("\\r?\\n");
			List<String> pdfLines = new ArrayList<>();
			int counter = 0;
			Boolean textFound = false;
			for (String line : lines) {
				pdfLines.add(line);
				if (line.contains(textToCompare)) {
					textFound = true;
					counter++;
				}
			}
			if (textFound == true) {
				return textToCompare + counter;
			} else {
				return "Expected value cannot be found in the PDF";
			}
		} catch (Exception e) {
			return textToCompare + 0;
		}

	}
}
