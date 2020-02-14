package com.imf.qa.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.testng.annotations.Test;

public class mysqldbtest {

	String host = "localhost";
	String port = "3306";

	@Test(enabled = true, priority = 0, description = "imf home page")
	public void mysqltest() throws Exception {

		/*
		 * Connection URL : "jdbc:mysql://"+host+":"+port+"/databasename";
		 * url="jdbc:mysql://"+localhost+":"+3306+"/Qadbt"; user=root;
		 * password=debashish123; DriverManager.getConnection(url, user, password);
		 */

		Connection con = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/Qadbt", "root",
				"debashish123");

		Statement s = con.createStatement();
		ResultSet res = s.executeQuery("Select * from Employeeinfo where name='ram'");

		while (res.next()) {

			System.out.println(res.getString("id"));
			System.out.println(res.getString("location"));
			System.out.println(res.getString("age"));

		}

	}

}
