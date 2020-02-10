package com.imf.qa.base;

import java.util.Hashtable;
import java.util.List;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Recordset;


public class BaseTest extends Driver  {	
	
	protected static String TESTDATA_SHEET_PATH = "src/test/resources/Test.xlsx";

	

	/**
	 * This function is to assertEquals using TestNG Assert
	 * 
	 * @param actual      : actual value captured on the Page
	 * @param description : Description For the logger
	 */
	protected synchronized static <T extends Comparable<T>> void assertEquals(T actual, T expected,
			String description) {
		try {
			Assert.assertEquals(actual, expected);
		} catch (AssertionError e) {
			throw e;
		}
	}

	/**
	 * This function is to assertFalse using TestNG Assert
	 * 
	 * @param condition   : <b>True</b> or <b>False</b> conditions
	 * @param description : Description For the logger
	 */
	protected synchronized static void assertFalse(boolean condition, String description) {
		try {
			Assert.assertFalse(condition);
		} catch (AssertionError e) {
			throw e;
		}
	}

	/**
	 * This function is to assertTrue using TestNG Assert
	 * 
	 * @param condition   : <b>True</b> or <b>False</b> conditions
	 * @param description : Description For the logger
	 * @param softAssert  : Object specific to @test
	 */
	protected synchronized static void assertTrue(boolean condition, String description) {
		try {
			Assert.assertTrue(condition, description);
		} catch (AssertionError e) {
			throw e;
		}
	}

	/**
	 * This function is to assertEquals using TestNG SoftAssert
	 * 
	 * @param actual      : actual value captured on the Page
	 * @param expected    : expected value captured from TestData
	 * @param description : Description For the logger
	 * @param softAssert  : Object specific to @test
	 */
	protected synchronized static <T extends Comparable<T>> void assertSoftEquals(T actual, T expected,
			String description, SoftAssert softAssert) {

		try {
			if (!actual.equals(expected)) {
			}
			softAssert.assertEquals(actual, expected, description);

		} catch (Exception e) {
		}
	}

	/**
	 * This function is to assertAll using TestNG SoftAssert
	 * 
	 * @param softAssert : Object specific to @test
	 */
	protected synchronized static void assertSoftAll(SoftAssert softAssert) {
		try {
			softAssert.assertAll();
		} catch (AssertionError e) {
			throw e;
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * This function is to assertTrue using TestNG SoftAssert
	 * 
	 * @param condition   : <b>True</b> or <b>False</b> conditions
	 * @param description : Description For the logger
	 * @param softAssert  : Object specific to @test
	 */
	protected synchronized static void assertSoftTrue(boolean condition, String description, SoftAssert softAssert) {
		try {
			if (condition == false) {
			}
			softAssert.assertTrue(condition, description);
		} catch (Exception e) {
		}
	}

	/**
	 * This function is to assertFalse using TestNG SoftAssert
	 * 
	 * @param condition   : <b>True</b> or <b>False</b> conditions
	 * @param description : Description For the logger
	 * @param softAssert  : Object specific to @test
	 */
	protected synchronized static void assertSoftFalse(boolean condition, String description, SoftAssert softAssert) {
		try {
			if (condition == true) {
			}
			softAssert.assertFalse(condition, description);
		} catch (Exception e) {
		}

	}

	/**
	 * This function is to verify tabs on a page
	 * 
	 * @param expected : expected List of expected values of Page tabs
	 * @param actual   : actual List of actual values of Page tabs
	 */
	protected synchronized static void verifyColumnsButtonsTabs(List<String> expected, List<String> actual) {
		try {
			expected.forEach(e -> {
				String actualString = actual.stream().filter(a -> a.equals(e)).findFirst().orElse("Not Present");
				assertEquals(actualString, e, "Check whether [" + e + "] is present");
			});
		} catch (Exception e) {
		}
	}

}
