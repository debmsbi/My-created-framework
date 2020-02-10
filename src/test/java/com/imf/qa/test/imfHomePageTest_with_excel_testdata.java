package com.imf.qa.test;

import java.lang.reflect.Method;
import java.util.Hashtable;
import java.util.List;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.imf.qa.base.BaseTest;
import com.imf.qa.pages.imfHomePage;
import com.imf.qa.util.Xls_Reader;


public class imfHomePageTest_with_excel_testdata extends BaseTest {
	

	imfHomePage imfhomepage;
	Xls_Reader reader;
 

	@BeforeClass
	public void setup() throws Exception {

		initExcelConnection();
		initialization();
		 

	}

	@Test(enabled = true, priority = 0 ,dataProvider= "ExcelTestData",description = "imf home page")
	public void imfpagetitletest(Hashtable<String, String> mainTabs) throws Exception {

		
		imfhomepage = new imfHomePage();
		assertEquals(driver.getTitle(),mainTabs.get("TestData1"), "International Monetary Fund - Homepage");
		assertEquals(imfhomepage.gettext_about(),mainTabs.get("TestData2"), "gettextabout");
		imfhomepage.click_country();
		
		List<String> li =imfhomepage.List_Countries_I();
		assertEquals(li.get(0), mainTabs.get("TestData3") , "Iceland");
		assertEquals(li.get(1),mainTabs.get("TestData4")  , "India");
		assertEquals(li.get(2), mainTabs.get("TestData5") , "Indonesia");
		assertEquals(li.get(3), mainTabs.get("TestData6") , "Iran, Islamic Republic of");
	}
	

	@AfterClass
	public void teardown() {

		driver.close();
	}
	
	 @DataProvider(name="ExcelTestData")
     public Object[][] hashdata(Method m) {


           return new Object[][]{  
                 {readTestDataByMethodName(m.getName())}
           };

     } 
	
	
	
	
	
	
}

	

