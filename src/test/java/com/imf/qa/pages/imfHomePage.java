package com.imf.qa.pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.imf.qa.base.BasePage;

public class imfHomePage extends BasePage {

	

	public imfHomePage() throws Exception {
		super();
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}


	// Page Factory - Object Repository
	@FindBy(xpath = "//img[contains(@src,'IMF_logo_ENG.png')]")
	WebElement imflogo;

	@FindBy(xpath = "(//a[contains(@href,'/en/countries')])[1]")
	WebElement click_country;

	@FindBy(xpath = "(//a[@href='/en/About'])[1]")
	WebElement gettext_about;
	
	@FindBy(xpath = "//a[@name='I']//following-sibling::ul/li")	List<WebElement> List_Countries_I;
	
	@FindBy(xpath = "//section[9]/h3") WebElement gettext_I_COuntry;

	

	

	// Actions or Methods

	public String gettext_about() {

		waitForElementToBePresent("gettext_about", gettext_about);
		return getText("gettext_about", gettext_about);
	}

	public String validateimflogoimage() {

		waitForElementToBePresent("imflogo", imflogo);
		return getText("validateimflogoimage", imflogo);
	}

	public void click_country() {

		clickOnElement("click_country", click_country);
	}
	
	
	public List<String> List_Countries_I() {
		
		waitForElementToBePresent("gettext_I_COuntry", gettext_I_COuntry);
		 return getTextFromAllElements ("List_Countries_I", List_Countries_I);
	}
	
	
	
	
	
	
}


