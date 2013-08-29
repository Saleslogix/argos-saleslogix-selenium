package argos.saleslogix.selenium.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.testng.AssertJUnit;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import argos.saleslogix.selenium.test.CommonNavigation;
import argos.saleslogix.selenium.test.HeaderButton;
import argos.saleslogix.selenium.test.NavButton;
import argos.saleslogix.selenium.test.SLXMobileLogin;
import argos.saleslogix.selenium.test.BrowserSetup;

public class SpeedSearchTests extends BrowserSetup {
	
NavButton navbutton = PageFactory.initElements(driver, NavButton.class);
CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);


@Test
public void test00_Mobile_Login() throws InterruptedException {
	SLXMobileLogin slxmobilelogin = PageFactory.initElements(driver, SLXMobileLogin.class);		

	//VP: the Mobile Login screen displays
	for (int second = 0;; second++) {
		if (second >= 60) fail("timeout");
		try { if ("Sage SalesLogix".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
		Thread.sleep(1000);
	}
	
	//VP: Page Title
	assertEquals("SalesLogix", driver.getTitle());
	//VP: Login Page Name
	for (int second = 0;; second++) {
		if (second >= 60) fail("timeout");
		try { if ("Sage SalesLogix".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
		Thread.sleep(1000);
	}
	
	try {
		assertEquals("Sage SalesLogix", driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText());
		} catch (Error e) {
		verificationErrors.append(e.toString());
	}
	//VP: Copyright Info...
	try {
		assertEquals("© 2013 Sage Software, Inc. All rights reserved.", driver.findElement(By.xpath(".//*[@id='login']/span[1]")).getText());
		} catch (Error e) {
		verificationErrors.append(e.toString());
	}
	try {
		assertEquals("Mobile V2.2.0 / SalesLogix V8.0.0", driver.findElement(By.xpath(".//*[@id='login']/span[2]")).getText());
		} catch (Error e) {
		verificationErrors.append(e.toString());
	}
	
	// Enter username and password then click the logon button
	Thread.sleep(1000);
	slxmobilelogin.enterUserName(userName);
	slxmobilelogin.enterPassword("");
	slxmobilelogin.toggleRemember();
	slxmobilelogin.logonButton();
	
	// Verify the 'My Activities' screen displays after login
	try {
		AssertJUnit.assertEquals("My Activities", driver.findElement(By.id("pageTitle")).getAttribute("text"));
		AssertJUnit.assertTrue(driver.findElement(By.id("css=#myactivity_list > ul.list-content > li")).isDisplayed());
	} catch (Error e) {     
		System.out.println("Verify 'My Activities' screen Displays" + e.toString());
	}
}
// *******


	@Test
	public void test01_SeTestTCSpeedSearchGeneral() throws Exception {
		// SE Test: SETest-TC-SpeedSearch-General
	    // Version: 2.2
	    // Desc: performs general searches to validate Global Search functionality
	    // Required Entity: TYPE - NAME
	    // ====================================
		
	    // Step: click Top-Left button to reveal Global Menu...
		driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button")).click();
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
	
	@Test
	public void test02_SeTestTCSpeedSearchLeads() throws Exception {
	    // SE Test: SETest-TC-SpeedSearch-Leads
	    // Version: 2.2
	    // Desc: Search on Leads
	    // Required Entity: TYPE - NAME
	    // ====================================
	    // Step: click Top-Left button to reveal Global Menu...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[1]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if (isElementPresent(By.xpath(".//*[@id='Mobile_SalesLogix_SpeedSearchWidget_0']/div/div[1]/input"))) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: UI element check
	    try {
	      assertTrue(isElementPresent(By.cssSelector("#Mobile_SalesLogix_SpeedSearchWidget_0 > div.table-layout > div > input[name=\"query\"]")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    try {
	      assertTrue(isElementPresent(By.cssSelector("#Mobile_SalesLogix_SpeedSearchWidget_0 > div.table-layout > div.hasButton > button.subHeaderButton.searchButton")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // -- Section: Execute some global searches in the mobile client
	    // Step: perform 1st SpeedSearch on Leads...
	    driver.findElement(By.cssSelector("#Mobile_SalesLogix_SpeedSearchWidget_0 > div.table-layout > div > input[name=\"query\"]")).clear();
	    driver.findElement(By.cssSelector("#Mobile_SalesLogix_SpeedSearchWidget_0 > div.table-layout > div > input[name=\"query\"]")).sendKeys("Pacific");
	    driver.findElement(By.cssSelector("#Mobile_SalesLogix_SpeedSearchWidget_0 > div.table-layout > div.hasButton > button.subHeaderButton.searchButton")).click();
	    assertEquals("Search Results", driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText());
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if (isElementPresent(By.xpath(".//*[@id='speedsearch_list']/ul/li[1]"))) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: check search results...
	    // Warning: verifyTextNotPresent may require manual changes
	    try {
	      assertFalse(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*no records[\\s\\S]*$"));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Warning: verifyTextPresent may require manual changes
	    try {
	      assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*James Sibr[\\s\\S]*$"));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: click to open the 1st matching Account link...
	    driver.findElement(By.xpath(".//*[@id='speedsearch_list']/ul/li[1]/h3")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Account".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Verify: confirm that the correct Account Detail View was opened...
	    try {
	      assertEquals("Pacific Bearing Corp", driver.findElement(By.xpath(".//*[@id='account_detail']/div[2]/div[1]/div[1]/span")).getText());
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Search Results".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: navigate back to Home...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[2]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("My Activities".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // -- END
	}
	
	@Test
	public void test03_SeTestTCSpeedSearchAccConActOppNtsHis() throws Exception {
	    // SE Test: SETest-TC-SpeedSearch-AccConActOppNtsHis
	    // Version: 2.2
	    // Desc: Search on accounts, contacts, activities, opportunities, notes/history
	    // Required Entity: TYPE - NAME
	    // ====================================
	    // Step: click Top-Left button to reveal Global Menu...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[1]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if (isElementPresent(By.xpath(".//*[@id='Mobile_SalesLogix_SpeedSearchWidget_0']/div/div[1]/input"))) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: UI element check
	    try {
	      assertTrue(isElementPresent(By.cssSelector("#Mobile_SalesLogix_SpeedSearchWidget_0 > div.table-layout > div > input[name=\"query\"]")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    try {
	      assertTrue(isElementPresent(By.cssSelector("#Mobile_SalesLogix_SpeedSearchWidget_0 > div.table-layout > div.hasButton > button.subHeaderButton.searchButton")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // -- Section: Accounts
	    // Step: perform 1st SpeedSearch on Accounts...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_SpeedSearchWidget_0']/div/div[1]/input")).click();
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_SpeedSearchWidget_0']/div/div[1]/input")).clear();
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_SpeedSearchWidget_0']/div/div[1]/input")).sendKeys("Abbott");
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_SpeedSearchWidget_0']/div/div[3]/button")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Search Results".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: check search results...
	    // Warning: verifyTextNotPresent may require manual changes
	    try {
	      assertFalse(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*no records[\\s\\S]*$"));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Warning: assertTextPresent may require manual changes
	    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Abbott Ltd\\.[\\s\\S]*$"));
	    // Step: click to open the 1st matching Account link...
	    driver.findElement(By.xpath(".//*[@id='speedsearch_list']/ul/li[1]/h3")).click();
	    // Verify: confirm that the correct Account Detail View was opened...
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Account".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    try {
	      assertEquals("Abbott Ltd.", driver.findElement(By.xpath(".//*[@id='account_detail']/div[2]/div[1]/div[1]/span")).getText());
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Search Results".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: click to open the 2nd matching Account link...
	    // Warning: assertTextPresent may require manual changes
	    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Abbott WorldWide[\\s\\S]*$"));
	    driver.findElement(By.xpath(".//*[@id='speedsearch_list']/ul/li[2]/h3")).click();
	    // Verify: confirm that the correct Account Detail View was opened...
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Account".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    try {
	      assertEquals("Abbott WorldWide", driver.findElement(By.xpath(".//*[@id='account_detail']/div[2]/div[1]/div[1]/span")).getText());
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Search Results".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	    // -- End Section
	    
	    // -- Section: Contacts
	    // Step: click to open the 1st matching Contact link...
	    // Warning: verifyTextPresent may require manual changes
	    try {
	      assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*John Abbott \\(Abbott Ltd\\.\\)[\\s\\S]*$"));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    driver.findElement(By.xpath(".//*[@id='speedsearch_list']/ul/li[3]/h3")).click();
	    // Verify: confirm that the correct Account Detail View was opened...
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Contact".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    try {
	      assertEquals("Abbott, John", driver.findElement(By.xpath(".//*[@id='contact_detail']/div[2]/div[1]/div[1]/span")).getText());
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Search Results".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: click to open a 2nd matching Contact link...
	    // Warning: assertTextPresent may require manual changes
	    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Hans Wurst \\(Abbot\\)[\\s\\S]*$"));
	    driver.findElement(By.xpath(".//*[@id='speedsearch_list']/ul/li[11]/h3")).click();
	    // Verify: confirm that the correct Account Detail View was opened...
	    try {
	      assertEquals("Contact", driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText());
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    try {
	      assertEquals("Wurst, Hans", driver.findElement(By.xpath(".//*[@id='contact_detail']/div[2]/div[1]/div[1]/span")).getText());
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Search Results".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	    // -- End Section
	    
	    // -- Section: Activities
	    // Step: click to open a matching Activity link...
	    // Warning: assertTextPresent may require manual changes
	    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Referred from Abbott Ltd\\.[\\s\\S]*$"));
	    driver.findElement(By.xpath(".//*[@id='speedsearch_list']/ul/li[4]/h3")).click();
	    // Verify: confirm that the correct Account Detail View was opened...
	    try {
	      assertEquals("Activity", driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText());
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    try {
	      assertEquals("Referred from Abbott Ltd.", driver.findElement(By.xpath(".//*[@id='activity_detail']/div[2]/div[1]/div[2]/span")).getText());
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Search Results".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	    // -- End Section
	    
	    // -- Section: Opportunities
	    // Step: click to open a matching Opportunity link...
	    // Warning: verifyTextPresent may require manual changes
	    try {
	      assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Abbott Ltd\\.-Phase[\\s\\S]*$"));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    driver.findElement(By.xpath(".//*[@id='speedsearch_list']/ul/li[20]/h3")).click();
	    // Verify: confirm that the correct Account Detail View was opened...
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Opportunity".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    try {
	      assertEquals("Abbott Ltd.-Phase-9", driver.findElement(By.xpath(".//*[@id='opportunity_detail']/div[2]/div[1]/div[1]/span")).getText());
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Search Results".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	    // -- End Section
	    
	    // -- Section: Notes/History
	    // Step: click to open a matching Notes/History link...
	    // Warning: verifyTextPresent may require manual changes
	    try {
	      assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Proposal for Abbott Ltd\\.[\\s\\S]*$"));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    driver.findElement(By.xpath(".//*[@id='speedsearch_list']/ul/li[5]/h3")).click();
	    // Verify: confirm that the correct Account Detail View was opened...
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("History".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    try {
	      assertEquals("Proposal for Abbott Ltd.", driver.findElement(By.xpath(".//*[@id='history_detail']/div[2]/div[1]/div[3]/span")).getText());
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Search Results".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	    // -- End Section
	    
	    // Step: navigate back to Home...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[2]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("My Activities".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // -- END
	}

	@Test
	public void test04_SeTestTCSpeedSearchTickets() throws Exception {
	    // SE Test: SETest-TC-SpeedSearch-Leads
	    // Version: 2.2
	    // Desc: Search on Tickets
	    // Required Entity: TYPE - NAME
	    // ====================================
	    // Step: click Top-Left button to reveal Global Menu...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[1]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if (isElementPresent(By.xpath(".//*[@id='Mobile_SalesLogix_SpeedSearchWidget_0']/div/div[1]/input"))) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: UI element check
	    try {
	      assertTrue(isElementPresent(By.cssSelector("#Mobile_SalesLogix_SpeedSearchWidget_0 > div.table-layout > div > input[name=\"query\"]")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    try {
	      assertTrue(isElementPresent(By.cssSelector("#Mobile_SalesLogix_SpeedSearchWidget_0 > div.table-layout > div.hasButton > button.subHeaderButton.searchButton")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: perform 1st SpeedSearch on Tickets...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_SpeedSearchWidget_0']/div/div[1]/input")).click();
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_SpeedSearchWidget_0']/div/div[1]/input")).clear();
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_SpeedSearchWidget_0']/div/div[1]/input")).sendKeys("001-00-000004");
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_SpeedSearchWidget_0']/div/div[3]/button")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Search Results".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: check search results...
	    // Warning: verifyTextNotPresent may require manual changes
	    try {
	      assertFalse(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*no records[\\s\\S]*$"));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Warning: waitForTextPresent may require manual changes
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if (driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Ticket: 001-00-000004[\\s\\S]*$")) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: click to open the 1st matching Account link...
	    driver.findElement(By.xpath(".//*[@id='speedsearch_list']/ul/li[18]/h3")).click();
	    // Verify: confirm that the correct Account Detail View was opened...
	    try {
	      assertEquals("Ticket", driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText());
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    try {
	      assertEquals("001-00-000004", driver.findElement(By.xpath(".//*[@id='ticket_detail']/div[2]/ul[1]/li/a/span")).getText());
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Search Results".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: navigate back to Home...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[2]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Tickets".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // -- END
	}
	
	
	// *******
	@Test
	public void test99_Mobile_LogOff()  throws InterruptedException {				
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
