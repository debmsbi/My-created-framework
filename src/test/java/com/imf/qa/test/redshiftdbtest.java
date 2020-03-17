package com.imf.qa.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.testng.annotations.Test;

public class redshiftdbtest extends Loginredshift {

	@Test(enabled = true, priority = 0, description = "redshiftdbtest")
	public void redshifttest() throws Exception {

		Connection con = DriverManager.getConnection(url, user, pass);

		String sql = "select activity_week_start," + "       count(*),"
				+ "       sum(cy_to_sold_dollars_booked) as sold_dollars_booked,"
				+ "       sum(cy_variance_sold_dollars_booked) as variance_sold_dollars_booked,"
				+ "       sum(cy_variance_new_money_sold_dollars_booked),"
				+ "       sum(cy_variance_orig_ratecard_rate_booked),"
				+ "       sum(cy_variance_guaranteed_impressions_booked)," 
				+ "       sum(cy_from_sold_dollars_working),"
				+ "       sum(cy_to_sold_dollars_working) as sold_dollars_working, " 
				+ "       sum(cy_variance_sold_dollars_working),"
				+ "       sum(cy_variance_new_money_sold_dollars_working),"
				+ "       sum(cy_variance_orig_ratecard_rate_working)," 
				+ "       sum(py_to_sold_dollars_booked),  "
				+ "       sum(py_variance_sold_dollars_booked),"
				+ "       sum(py_variance_new_money_sold_dollars_booked),"
				+ "       sum(py_variance_orig_ratecard_rate_booked)," 
				+ "       sum(py_booked_total)  "
				+ "from fox_ai_instrumentation.v_ft_cpw_sales_activity_fact " 
				+ "where activity_week_start='2020-02-20'"
				+ "group by 1" + "order by 1 desc;";

		Statement s = con.createStatement();
		ResultSet res = s.executeQuery(sql);

		while (res.next()) {

			System.out.println(
					"Value for sum(cy_to_sold_dollars_booked) column in tablename fox_ai_instrumentation.v_ft_cpw_sales_activity_fact  :  "
							+ res.getString("sold_dollars_booked"));
			System.out.println(
					"Value for sum(cy_variance_sold_dollars_booked) column in tablename fox_ai_instrumentation.v_ft_cpw_sales_activity_fact  :  "
							+ res.getString("variance_sold_dollars_booked"));
			System.out.println(
					"Value for sum(cy_to_sold_dollars_working)  column in tablename fox_ai_instrumentation.v_ft_cpw_sales_activity_fact  :  "
							+ res.getString("sold_dollars_working"));

		}

	}

}
