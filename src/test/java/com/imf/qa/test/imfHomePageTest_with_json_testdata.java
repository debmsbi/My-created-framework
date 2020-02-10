package com.imf.qa.test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.imf.qa.base.BaseTest;
import com.imf.qa.pages.imfHomePage;
import com.imf.qa.util.JsonReader;


public class imfHomePageTest_with_json_testdata extends BaseTest {
	

	imfHomePage imfhomepage;
 

	@BeforeClass
	public void setup() throws IOException {

		initialization();

	}

	@Test(enabled = true, priority = 0 , dataProvider="data", description = "imf home page")
	public void imfpagetitletest(String getTitle ,  String gettext_about , String I_Country_one ,  String I_Country_two,String I_Country_three, String I_Country_four) throws Exception {

		
		imfhomepage = new imfHomePage();
		assertEquals(driver.getTitle(),getTitle, "International Monetary Fund - Homepage");
		assertEquals(imfhomepage.gettext_about(),gettext_about, "gettextabout");
		imfhomepage.click_country();
		
		List<String> li =imfhomepage.List_Countries_I();
		assertEquals(li.get(0), I_Country_one  , "Iceland");
		assertEquals(li.get(1), I_Country_two  , "India");
		assertEquals(li.get(2), I_Country_three  , "Indonesia");
		assertEquals(li.get(3), I_Country_four  , "Iran, Islamic Republic of");
	}
	

	@AfterClass
	public void teardown() {

		driver.close();
	}
	
	
	@DataProvider(name="data")
	public Object[][] passData() throws JsonIOException, JsonSyntaxException, FileNotFoundException
	{
		
		return JsonReader.getdata(prop.getProperty("JsonPath")+"imfHomePageTest_data.json","Test Data" , 1,6);
		
	}
	
	
	
	
}

	

