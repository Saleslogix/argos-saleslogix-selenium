package argos.saleslogix.selenium.test;


import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.AssertJUnit;

import org.junit.After;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;

import argos.saleslogix.selenium.test.CommonNavigation;
import argos.saleslogix.selenium.test.HeaderButton;
import argos.saleslogix.selenium.test.SLXMobileLogin;
import argos.saleslogix.selenium.test.BrowserSetup;

public class SmokeTest_Navigation extends BrowserSetup {
	
	CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
	
	@Test
	public void test01_Mobile_Login() throws InterruptedException {
		SLXMobileLogin slxmobilelogin = PageFactory.initElements(driver, SLXMobileLogin.class);		

		// Verify the Mobile Login screen displays
		try {
			AssertJUnit.assertEquals("Sage SalesLogix", driver.findElement(By.id("pageTitle")).getAttribute("text"));
		} catch (Error e) {     
			System.out.println("Verify Mobile Login screen Displays" + e.toString());
		}
		
		// Enter username and password then click the logon button
		Thread.sleep(1000);
		slxmobilelogin.enterUserName(userName);
		slxmobilelogin.enterPassword("");
		slxmobilelogin.toggleRemember();
		slxmobilelogin.logonButton();
		
		// Verify the 'My Activities' screen displays
		try {
			AssertJUnit.assertEquals("My Activities", driver.findElement(By.id("pageTitle")).getAttribute("text"));
			AssertJUnit.assertTrue(driver.findElement(By.id("css=#myactivity_list > ul.list-content > li")).isDisplayed());
		} catch (Error e) {     
			System.out.println("Verify 'My Activities' screen Displays" + e.toString());
		}
	}
	// *******
	
	@Test
	  public void test02_testSeTestTCSpeedSearchGeneral() throws Exception {
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerbutton = PageFactory.initElements(driver, HeaderButton.class);
		
	    // SE Test: SETest-TC-SpeedSearch-General
	    // Version: 2.2
	    // Desc: performs general searches to validate Global Search functionality
	    // Required Entity: TYPE - NAME
	    // ====================================
		
	    // Step: click Top-Left button to reveal Global Menu...
        headerbutton.showGlobalMenu();
        Thread.sleep(1000);       
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if (isElementPresent(By.cssSelector("#Mobile_SalesLogix_SpeedSearchWidget_0 > div.table-layout > div > input[name=\"query\"]"))) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	    // Step: UI element check
	    AssertJUnit.assertTrue(isElementPresent(By.cssSelector("#Mobile_SalesLogix_SpeedSearchWidget_0 > div.table-layout > div > input[name=\"query\"]")));
	    AssertJUnit.assertTrue(isElementPresent(By.cssSelector("#Mobile_SalesLogix_SpeedSearchWidget_0 > div.table-layout > div.hasButton > button.subHeaderButton.searchButton")));
	    
	    // -- Section: Execute some global searches in the mobile client
	    // Step: perform 1st global search...
	    driver.findElement(By.cssSelector("#Mobile_SalesLogix_SpeedSearchWidget_0 > div.table-layout > div > input[name=\"query\"]")).clear();
	    driver.findElement(By.cssSelector("#Mobile_SalesLogix_SpeedSearchWidget_0 > div.table-layout > div > input[name=\"query\"]")).sendKeys("blackberry");
	    Thread.sleep(1000);
	    driver.findElement(By.cssSelector("#Mobile_SalesLogix_SpeedSearchWidget_0 > div.table-layout > div.hasButton > button.subHeaderButton.searchButton")).click();
	    Thread.sleep(5000);
	    AssertJUnit.assertEquals("Search Results", driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText());
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if (isElementPresent(By.xpath(".//*[@id='speedsearch_list']/ul/li[1]"))) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: check search results...
	    try {
	      AssertJUnit.assertFalse(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*no records[\\s\\S]*$"));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    try {
	      AssertJUnit.assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Training[\\s\\S]*$"));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    try {
	      AssertJUnit.assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Ticket[\\s\\S]*$"));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    try {
	      AssertJUnit.assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Reu[\\s\\S]*$"));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    
	    // Step: click to open the top Search Results link...
	    driver.findElement(By.xpath(".//*[@id='speedsearch_list']/ul/li[1]/h3")).click();
	    Thread.sleep(5000);
	    try {
	      AssertJUnit.assertFalse(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*SearchResults[\\s\\S]*$"));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    try {
	      AssertJUnit.assertEquals("History", driver.findElement(By.id("pageTitle")).getText());
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    try {
	      AssertJUnit.assertEquals("Training", driver.findElement(By.xpath("//div[@id='history_detail']/div[2]/div/div[3]/span")).getText());
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: navigate back...
	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if ("Search Results".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: reset the Search then nav back to Home...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_SpeedSearchWidget_1']/div/div[2]/button")).click();
	    Thread.sleep(3000);
	    
	    // Step: perform 2nd global search...
	    driver.findElement(By.cssSelector("#Mobile_SalesLogix_SpeedSearchWidget_1 > div.table-layout > div > input[name=\"query\"]")).clear();
	    driver.findElement(By.cssSelector("#Mobile_SalesLogix_SpeedSearchWidget_1 > div.table-layout > div > input[name=\"query\"]")).sendKeys("blackberri");
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_SpeedSearchWidget_1']/div/div[3]/button")).click();
	    Thread.sleep(5000);
	    AssertJUnit.assertEquals("Search Results", driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText());
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if (isElementPresent(By.cssSelector("#speedsearch_list > ul.list-content > li"))) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: check search results...
	    try {
	      AssertJUnit.assertFalse(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*no records[\\s\\S]*$"));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Warning: verifyTextPresent may require manual changes
	    try {
	      AssertJUnit.assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Training[\\s\\S]*$"));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Warning: verifyTextPresent may require manual changes
	    try {
	      AssertJUnit.assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Ticket[\\s\\S]*$"));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Warning: verifyTextPresent may require manual changes
	    try {
	      AssertJUnit.assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Reu[\\s\\S]*$"));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: reset the Search the nav back to Home...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_SpeedSearchWidget_1']/div/div[2]/button")).click();
	    Thread.sleep(3000);
	    
	    // Step: perform 3rd global search...
	    driver.findElement(By.cssSelector("#Mobile_SalesLogix_SpeedSearchWidget_1 > div.table-layout > div > input[name=\"query\"]")).clear();
	    driver.findElement(By.cssSelector("#Mobile_SalesLogix_SpeedSearchWidget_1 > div.table-layout > div > input[name=\"query\"]")).sendKeys("blackbarry");
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_SpeedSearchWidget_1']/div/div[3]/button")).click();
	    Thread.sleep(5000);
	    AssertJUnit.assertEquals("Search Results", driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText());
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if (isElementPresent(By.cssSelector("#speedsearch_list > ul.list-content > li"))) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: check search results...
	    try {
	      AssertJUnit.assertFalse(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*no records[\\s\\S]*$"));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    try {
	      AssertJUnit.assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Training[\\s\\S]*$"));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    try {
	      AssertJUnit.assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Ticket[\\s\\S]*$"));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    try {
	      AssertJUnit.assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Reu[\\s\\S]*$"));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: reset the Search the nav back to Home...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_SpeedSearchWidget_1']/div/div[2]/button")).click();
	    Thread.sleep(3000);
	    
	    // Step: perform 4th global search...
	    driver.findElement(By.cssSelector("#Mobile_SalesLogix_SpeedSearchWidget_1 > div.table-layout > div > input[name=\"query\"]")).clear();
	    driver.findElement(By.cssSelector("#Mobile_SalesLogix_SpeedSearchWidget_1 > div.table-layout > div > input[name=\"query\"]")).sendKeys("black berry");
	    Thread.sleep(1000);
	    driver.findElement(By.cssSelector("#Mobile_SalesLogix_SpeedSearchWidget_1 > div.table-layout > div.hasButton > button.subHeaderButton.searchButton")).click();
	    Thread.sleep(5000);	    
	    AssertJUnit.assertEquals("Search Results", driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText());
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if (isElementPresent(By.cssSelector("#speedsearch_list > ul.list-content > li"))) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: check search results...
	    try {
	      AssertJUnit.assertFalse(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*no records[\\s\\S]*$"));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    try {
	      AssertJUnit.assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Al Bahar[\\s\\S]*$"));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    try {
	      AssertJUnit.assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Jennifer Blake[\\s\\S]*$"));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    try {
	      AssertJUnit.assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Bass Beer and Wine Co[\\s\\S]*$"));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: reset the Search the nav back to Home...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_SpeedSearchWidget_1']/div/div[2]/button")).click();
	    Thread.sleep(3000);
	    
	    // Step: perform 5th global search...
	    driver.findElement(By.cssSelector("#Mobile_SalesLogix_SpeedSearchWidget_1 > div.table-layout > div > input[name=\"query\"]")).clear();
	    driver.findElement(By.cssSelector("#Mobile_SalesLogix_SpeedSearchWidget_1 > div.table-layout > div > input[name=\"query\"]")).sendKeys("advisinh");
	    Thread.sleep(1000);
	    driver.findElement(By.cssSelector("#Mobile_SalesLogix_SpeedSearchWidget_1 > div.table-layout > div.hasButton > button.subHeaderButton.searchButton")).click();
	    Thread.sleep(5000);
	    AssertJUnit.assertEquals("Search Results", driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText());
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if (isElementPresent(By.cssSelector("#speedsearch_list > ul.list-content > li"))) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: check search results...
	    try {
	      AssertJUnit.assertFalse(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*no records[\\s\\S]*$"));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    try {
	      AssertJUnit.assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Advising Group[\\s\\S]*$"));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    try {
	      AssertJUnit.assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Jurgenson Advisory[\\s\\S]*$"));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    try {
	      AssertJUnit.assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Advising Group Test Opp[\\s\\S]*$"));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: reset the Search the nav back to Home...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_SpeedSearchWidget_1']/div/div[2]/button")).click();
	    Thread.sleep(3000);
	    
	    // Step: perform 6th global search...
	    driver.findElement(By.cssSelector("#Mobile_SalesLogix_SpeedSearchWidget_1 > div.table-layout > div > input[name=\"query\"]")).clear();
	    driver.findElement(By.cssSelector("#Mobile_SalesLogix_SpeedSearchWidget_1 > div.table-layout > div > input[name=\"query\"]")).sendKeys("world");
	    Thread.sleep(1000);
	    driver.findElement(By.cssSelector("#Mobile_SalesLogix_SpeedSearchWidget_1 > div.table-layout > div.hasButton > button.subHeaderButton.searchButton")).click();
	    Thread.sleep(5000);
	    AssertJUnit.assertEquals("Search Results", driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText());
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if (isElementPresent(By.cssSelector("#speedsearch_list > ul.list-content > li"))) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: check search results...
	    try {
	      AssertJUnit.assertFalse(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*no records[\\s\\S]*$"));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    try {
	      AssertJUnit.assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*World Electrical[\\s\\S]*$"));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    try {
	      AssertJUnit.assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*World Beers[\\s\\S]*$"));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    try {
	      AssertJUnit.assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Abbott WorldWide-Phase[\\s\\S]*$"));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: reset the Search the nav back to Home...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_SpeedSearchWidget_1']/div/div[2]/button")).click();
	    Thread.sleep(3000);
	    
	    // Step: perform 7th global search...
	    driver.findElement(By.cssSelector("#Mobile_SalesLogix_SpeedSearchWidget_1 > div.table-layout > div > input[name=\"query\"]")).clear();
	    driver.findElement(By.cssSelector("#Mobile_SalesLogix_SpeedSearchWidget_1 > div.table-layout > div > input[name=\"query\"]")).sendKeys("sophia");
	    Thread.sleep(1000);
	    driver.findElement(By.cssSelector("#Mobile_SalesLogix_SpeedSearchWidget_1 > div.table-layout > div.hasButton > button.subHeaderButton.searchButton")).click();
	    Thread.sleep(5000);
	    AssertJUnit.assertEquals("Search Results", driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText());
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if (isElementPresent(By.cssSelector("#speedsearch_list > ul.list-content > li"))) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: check search results...
	    try {
	      AssertJUnit.assertFalse(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*no records[\\s\\S]*$"));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    try {
	      AssertJUnit.assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Drakes Cycle Shop -Phase-1[\\s\\S]*$"));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    try {
	      AssertJUnit.assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Neil Shiff[\\s\\S]*$"));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    try {
	      AssertJUnit.assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Drakes Cycle Shop[\\s\\S]*$"));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: reset the Search the nav back to Home...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_SpeedSearchWidget_1']/div/div[2]/button")).click();
	    Thread.sleep(3000);
	    
	    // Step: perform 8th global search...
	    driver.findElement(By.cssSelector("#Mobile_SalesLogix_SpeedSearchWidget_1 > div.table-layout > div > input[name=\"query\"]")).clear();
	    driver.findElement(By.cssSelector("#Mobile_SalesLogix_SpeedSearchWidget_1 > div.table-layout > div > input[name=\"query\"]")).sendKeys("sophia perez");
	    Thread.sleep(1000);
	    driver.findElement(By.cssSelector("#Mobile_SalesLogix_SpeedSearchWidget_1 > div.table-layout > div.hasButton > button.subHeaderButton.searchButton")).click();
	    Thread.sleep(5000);
	    AssertJUnit.assertEquals("Search Results", driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText());
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if (isElementPresent(By.cssSelector("#speedsearch_list > ul.list-content > li"))) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: check search results...
	    try {
	      AssertJUnit.assertFalse(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*no records[\\s\\S]*$"));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    try {
	      AssertJUnit.assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Database Change[\\s\\S]*$"));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    try {
	      AssertJUnit.assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*status[\\s\\S]*$"));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    try {
	      AssertJUnit.assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Sophia Perez[\\s\\S]*$"));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: reset the Search the nav back to Home...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_SpeedSearchWidget_1']/div/div[2]/button")).click();
	    Thread.sleep(3000);
	    
	    // -- End Section
	    // Step: navigate back to Home...
	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[2]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if ("My Activities".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // -- End
	  }

	
	// *******
	@Test
	public void test03_Mobile_LogOff()  throws InterruptedException {				
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerbutton = PageFactory.initElements(driver, HeaderButton.class);
		
		// Click the Top-Left, Global Menu button...
        headerbutton.showGlobalMenu();
		
		// Click the Log Off button
        commNav.clickGlobalMenuItem("log out");
	    Thread.sleep(3000);
	    closeAlert();
	    Thread.sleep(5000);
						
		// Verify the Mobile Login screen displays
		try {
			AssertJUnit.assertEquals("Sage SalesLogix", driver.findElement(By.id("pageTitle")).getAttribute("text"));
		} catch (Error e) {     
			System.out.println("Verify Mobile Login screen Displays" + e.toString());
		}
	}
}

