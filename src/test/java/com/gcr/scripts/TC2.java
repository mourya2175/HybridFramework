package com.gcr.scripts;

import org.testng.annotations.Test;

import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;
import com.gcr.config.StartBrowser;
import com.gcr.reuse.Commonfunctions;
import com.gcr.listeners.RetryAnalyzer;

public class TC2 extends StartBrowser{
	@Test(retryAnalyzer = RetryAnalyzer.class)
  public void SauceLogin_Logut_Excel() throws Exception {
	  Commonfunctions cf = new Commonfunctions();
	  Fillo f = new Fillo();
		Connection con = f.getConnection("TestData/Data.xlsx");
		String query = "select * from LoginData";
		Recordset rs = con.executeQuery(query);
		while (rs.next()) {
			cf.login(rs.getField("UserName"),rs.getField("Password"));
		}
	  cf.assertText("PRODUCTS");
	  cf.logout();
  }
}
