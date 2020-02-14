package com.imf.qa.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.testng.annotations.Test;

public class redshiftdbtest extends Login {

	@Test(enabled = true, priority = 0, description = "redshift")
	public void mysqltest() throws Exception {

		// Connection con =DriverManager.getConnection(url, user, password);

		Connection con = DriverManager.getConnection(url, user, pass);

		String sql = "select  program_group,  sum(cy_to_sold_dollars_booked) booked,  sum(cy_to_sold_dollars_working) working,"
				+ "sum(cy_variance_sold_dollars_booked) activity from fox_ai_instrumentation.v_ft_cpw_sales_activity_fact "
				+ "where activity_week_start = '2020-01-30' " + "and program_group='WWE'"
				+ "and business in ('Sports', 'Entertainment') group by 1";

		Statement s = con.createStatement();
		ResultSet res = s.executeQuery(sql);

		while (res.next()) {

			System.out.println(
					"Value for program_group column in tablename fox_ai_instrumentation.v_ft_cpw_sales_activity_fact  :  "
							+ res.getString("program_group"));
			System.out.println(
					"Value for booked column in tablename fox_ai_instrumentation.v_ft_cpw_sales_activity_fact  :  "
							+ res.getString("booked"));
			System.out.println(
					"Value for working column in tablename fox_ai_instrumentation.v_ft_cpw_sales_activity_fact  :  "
							+ res.getString("working"));
			System.out.println(
					"Value for activity column in tablename fox_ai_instrumentation.v_ft_cpw_sales_activity_fact  :  "
							+ res.getString("activity"));

		}

	}

}
