package com.imf.qa.util;


import java.util.*;
import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

public class Xls_Reader {
	

	protected final static String RESOURCES_FOLDER_PATH = "./src/test/resources/";
	protected final static String PROJECT_TESTCASES_EXCEL_PATH = "./src/test/resources/Test.xlsx";
	protected static Fillo fillo = null;
	protected static Connection connection = null;
	protected static ThreadLocal<Fillo> filloThreadSafe = new ThreadLocal<Fillo>();
	protected static ThreadLocal<Connection> connectionThreadSafe = new ThreadLocal<Connection>();
	protected static String strCheckTestToRunbyMethodName = "Select *  from TestCases where TestName =";
	protected static String strReadTestDataByMethodName = "Select * from TestData where TestName =";
	protected static Recordset recordset;
	protected static Recordset recordsettwo;
	protected static Hashtable<String, String> testData;
	
	

	/**
	 * This function is to initialize threadSafe fillo connection
	 */
	protected static synchronized void initExcelConnection() {

		try {
			setThreadSafeFilo();
			setThreadSafeFilloConn();

		} catch (FilloException e) {

			e.printStackTrace();
		}
	}

	/**
	 * This function is a setter for threadSafe fillo instance
	 */
	protected static synchronized void setThreadSafeFilo() {
		fillo = new Fillo();
		filloThreadSafe.set(fillo);
	}

	/**
	 * This function is a getter for threadSafe fillo instance
	 * 
	 * @return threadSafe fillo instance
	 */
	protected static synchronized Fillo getThreadSafeFilo() {
		try {

			if (!(filloThreadSafe.get() == null)) {
				return filloThreadSafe.get();
			} else
				throw new Exception();
		} catch (Exception e) {
			return null;
		}

	}

	/**
	 * This function is a setter for threadSafe fillo connection
	 * 
	 * @throws FilloException
	 */
	protected static synchronized void setThreadSafeFilloConn() throws FilloException {
		connectionThreadSafe.set(getThreadSafeFilo().getConnection(PROJECT_TESTCASES_EXCEL_PATH));
	}

	/**
	 * This function is a getter for threadSafe fillo connection
	 * 
	 * @return
	 */
	protected static synchronized Connection getThreadSafeFilloConn() {
		try {
			if (!(connectionThreadSafe.get() == null)) {
				return connectionThreadSafe.get();
			} else
				throw new Exception();
		} catch (Exception e) {
			return null;
		}

	}


	/**
	 * This function is to read test data for the testCases through Excel
	 * 
	 * @param methodname - methodname of @test
	 * @return testdata - Hashtable
	 * @throws FilloException
	 */
	protected static synchronized Hashtable<String, String> readTestDataByMethodName(String methodname) {
		try {
			recordset = getThreadSafeFilloConn().executeQuery(strReadTestDataByMethodName + "'" + methodname + "'");
			// data = new Object[recordset.getCount()][1];
			// System.out.println(data.toString());
			// int cell = 0;
			while (recordset.next()) {
				testData = new Hashtable<String, String>();
				for (String strColumns : recordset.getFieldNames()) {

					if (!(recordset.getField(strColumns.toString()).isEmpty())) {
						testData.put(strColumns, recordset.getField(strColumns.toString()));
					}
				}
				// data[cell][0] = testData;
				// System.out.println(data[cell][0]);
				// cell++;
			}
		} catch (FilloException e) {
			e.printStackTrace();
		}

		return testData;
	}

	/**
	 * This function is to check flag TestToRun for the testCases through Excel
	 * 
	 * @param methodname - methodname of @test
	 * @return boolean - <b>True</b> for TestToRun equals 'Y' else return
	 *         <b>False<b>
	 * @throws FilloException
	 */
	protected static synchronized boolean checkTestToRunbyMethodName(String methodname) throws FilloException {
		try {
			recordsettwo = getThreadSafeFilloConn()
					.executeQuery(strCheckTestToRunbyMethodName + "'" + methodname + "'");

			if (!recordsettwo.getField("TestTorun").isEmpty()) {
				if (recordsettwo.getField("TestTorun").equalsIgnoreCase("Y")) {
					return true;
				}
			} else {
			}
		} catch (FilloException e) {
		} catch (Exception e) {
		}
		return false;
	}

	/**
	 * This function is to close the fillo connection for excel
	 */
	protected static synchronized void closeExcelConnection() {

		getThreadSafeFilloConn().close();

	}
	
	


}
