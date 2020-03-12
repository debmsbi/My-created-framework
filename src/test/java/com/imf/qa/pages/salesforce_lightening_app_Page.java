package com.imf.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.imf.qa.base.BasePage;

public class salesforce_lightening_app_Page extends BasePage {

	public salesforce_lightening_app_Page() throws Exception {
		super();
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}

	// Page Factory - Object Repository
	@FindBy(id = "username")
	WebElement salesforce_entertext_username;

	@FindBy(id = "password")
	WebElement salesforce_entertext_password;

	@FindBy(id = "Login")
	WebElement salesforce_clickbutton_login;

	@FindBy(xpath = "//div[@class='slds-icon-waffle']")
	WebElement click_applauncher;

	@FindBy(xpath = "(//p[@class='slds-truncate'])[1]")
	WebElement click_service;

	@FindBy(xpath = "//*[@id='calendar-88']/div[1]/div[2]/h2")
	WebElement gettext_calender_date;

	// Actions or Methods

	public String gettext_calender_date() {

		waitForElementToBePresent("gettext_calender_date", gettext_calender_date);
		return getText("gettext_calender_date", gettext_calender_date);
	}

	public void click_service() {

		waitForElementToBePresent("click_service", click_service);
		clickOnElement("click_service", click_service);
	}

	public void click_applauncher() {

		waitForElementToBePresent("click_applauncher", click_applauncher);
		clickOnElement("click_applauncher", click_applauncher);
	}

	public void salesforce_clickbutton_login() {

		waitForElementToBePresent("salesforce_clickbutton_login", salesforce_clickbutton_login);
		clickOnElement("salesforce_clickbutton_login", salesforce_clickbutton_login);
	}

	public void salesforce_entertext_username(String username) {

		waitForElementToBePresent("salesforce_entertext_username", salesforce_entertext_username);
		enterText("salesforce_entertext_username", salesforce_entertext_username, username);

	}

	public void salesforce_entertext_password(String password) {

		waitForElementToBePresent("salesforce_entertext_password", salesforce_entertext_password);
		enterText("salesforce_entertext_password", salesforce_entertext_password, password);

	}

}
