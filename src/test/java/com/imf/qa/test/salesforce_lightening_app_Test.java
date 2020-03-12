package com.imf.qa.test;

import java.lang.reflect.Method;
import java.util.Hashtable;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.imf.qa.base.BaseTest;
import com.imf.qa.pages.salesforce_lightening_app_Page;

public class salesforce_lightening_app_Test extends BaseTest {

	salesforce_lightening_app_Page salesforce_lightening_app_page;

	@BeforeClass
	public void setup() throws Exception {

		initExcelConnection();
		initialization();

	}

	@Test(enabled = true, priority = 0, dataProvider = "ExcelTestData", description = "salesforce_lightening_app_Test")
	public void salesforce_lightening_app_Test1(Hashtable<String, String> mainTabs) throws Exception {

		salesforce_lightening_app_page = new salesforce_lightening_app_Page();
		salesforce_lightening_app_page.salesforce_entertext_username(mainTabs.get("TestData1"));
		salesforce_lightening_app_page.salesforce_entertext_password(mainTabs.get("TestData2"));
		salesforce_lightening_app_page.salesforce_clickbutton_login();
		salesforce_lightening_app_page.click_applauncher();
		salesforce_lightening_app_page.click_service();
		salesforce_lightening_app_page.gettext_calender_date();
	}

	@AfterClass
	public void teardown() {

		driver.close();
	}

	@DataProvider(name = "ExcelTestData")
	public Object[][] hashdata(Method m) {

		return new Object[][] { { readTestDataByMethodName(m.getName()) } };

	}

}
