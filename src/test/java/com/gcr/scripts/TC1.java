package com.gcr.scripts;

import org.testng.annotations.Test;

import com.gcr.config.StartBrowser;
import com.gcr.listeners.RetryAnalyzer;
import com.gcr.reuse.Commonfunctions;

public class TC1 extends StartBrowser{
  @Test(retryAnalyzer = RetryAnalyzer.class)//this will retry
  public void SauceLogin_Logut() throws Exception {
	  Commonfunctions cf = new Commonfunctions();
	  cf.login();
	  cf.assertText("PRODUCTS");
	  cf.logout();
  }
}
