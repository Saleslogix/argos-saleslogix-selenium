package functionalTests;

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

import screenobject.CommonNavigation;
import screenobject.HeaderButton;
import screenobject.NavButton;
import screenobject.SLXMobileLogin;
import setupTest.BrowserSetup;

public class AttachmentTests extends BrowserSetup {
	
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
	public void test01_SeTestTCAttachAccountScreens() throws Exception {
	    // SETest-Attachments_Account_Screens
	    // Version: 2.2
	    // Desc: Confirms that the Attachments feature is functional from Account screens...
	    // Condition(s): Test user is logged in.    
	    // Required Entities: Account - Abbott Ltd.
	    // ==================================================================
	    // Step: click Top-Left button to reveal Global Menu...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[1]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if (isElementPresent(By.xpath(".//*[@id='Mobile_SalesLogix_SpeedSearchWidget_0']/div/div[1]/input"))) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // Step: navigate to Accounts list view...
	    driver.findElement(By.xpath(".//*[@id='left_drawer']/descendant::*[text() = \"Accounts\"]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if (isElementPresent(By.xpath(".//*[@id='account_list']/ul/li[1]"))) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // Step: perform search for Account items...
	    driver.findElement(By.cssSelector("#Sage_Platform_Mobile_SearchWidget_3 > div.table-layout > div > input[name=\"query\"]")).clear();
	    driver.findElement(By.cssSelector("#Sage_Platform_Mobile_SearchWidget_3 > div.table-layout > div > input[name=\"query\"]")).sendKeys("Abbott Ltd.");
	    driver.findElement(By.cssSelector("#Sage_Platform_Mobile_SearchWidget_3 > div.table-layout > div.hasButton > button.subHeaderButton.searchButton")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if (isElementPresent(By.xpath(".//*[@id='account_list']/ul/li[1]"))) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // Step: navigate to top Account record...
	    driver.findElement(By.cssSelector("#account_list > ul.list-content > li > div.list-item-content > h3")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Abbott Ltd.".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // VP: confirm that Attachments is available under the Related Items section...
	    try {
	      assertTrue(isElementPresent(By.xpath("(//img[@alt='icon'])[11]")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    try {
	      assertEquals("Attachments", driver.findElement(By.xpath("//div[@id='account_detail']/div[2]/ul[2]/li[7]/a/span")).getText());
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: click the Attachments link...
	    driver.findElement(By.xpath("//div[@id='account_detail']/div[2]/ul[2]/li[7]/a/span")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Account Attachments".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // Step: click to open an Attachment item...
	    try {
	      assertTrue(isElementPresent(By.xpath(".//*[@id='account_attachment_related']/ul/li[1]")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    driver.findElement(By.linkText("Test123")).click();
	    // Step: click the top Add buton...
	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[2]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Add Attachments".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // VP: confirm the elements of the Add Attachments screen...
	    try {
	      assertTrue(isElementPresent(By.cssSelector("input[type=\"file\"]")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    try {
	      assertTrue(isElementPresent(By.cssSelector("button.button.inline")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    try {
	      assertTrue(isElementPresent(By.xpath("//div[@id='attachment_Add']/div[2]/div/button[2]")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: navigate back to Account screen...
	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[2]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Account Attachments".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Abbott Ltd.".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Accounts".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("My Activities".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // -- END
	}

	@Test
	public void test02_SeTestTCAttachActivityScreens() throws Exception {
	    // SETest-Attachments_Activity_Screens
	    // Version: 2.2
	    // Desc: Confirms that the Attachments feature is functional from Activity screens...
	    // Required Entities: Activity - 3:15pm, Follow-up ...
	    // Condition(s): Test user is logged in.    
	    // ==================================================================
	    // Step: click Top-Left button to reveal Global Menu...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[1]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if (isElementPresent(By.xpath(".//*[@id='Mobile_SalesLogix_SpeedSearchWidget_0']/div/div[1]/input"))) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: navigate to My Activities list view...
	    driver.findElement(By.xpath(".//*[@id='left_drawer']/descendant::*[text() = \"My Activities\"]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if (isElementPresent(By.xpath(".//*[@id='myactivity_list']/ul/li[1]"))) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: perform search for Activity item...
	    driver.findElement(By.cssSelector("#Sage_Platform_Mobile_SearchWidget_26 > div.table-layout > div > input[name=\"query\"]")).clear();
	    driver.findElement(By.cssSelector("#Sage_Platform_Mobile_SearchWidget_26 > div.table-layout > div > input[name=\"query\"]")).sendKeys("Follow-up");
	    driver.findElement(By.cssSelector("#Sage_Platform_Mobile_SearchWidget_26 > div.table-layout > div.hasButton > button.subHeaderButton.searchButton")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if (isElementPresent(By.xpath(".//*[@id='myactivity_list']/ul/li[1]"))) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: navigate to top results record...
	    driver.findElement(By.xpath(".//*[@id='myactivity_list']/ul/li[1]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Activity".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // VP: confirm that Attachments is available under the Related Items section...
	    try {
	      assertTrue(isElementPresent(By.xpath("(//img[@alt='icon'])[2]")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    try {
	      assertEquals("Attachments", driver.findElement(By.xpath("//div[@id='activity_detail']/div[2]/ul[2]/li/a/span")).getText());
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: click the Attachments link...
	    driver.findElement(By.xpath("//div[@id='activity_detail']/div[2]/ul[2]/li/a/span")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Activity Attachments".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Warning: assertTextNotPresent may require manual changes
	    assertFalse(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*no records[\\s\\S]*$"));
	    // Step: click to open an Attachment item...
	    try {
	      assertTrue(isElementPresent(By.xpath("//div[@id='attachment_related']/ul/li")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    driver.findElement(By.linkText("1368571469189")).click();
	    // Step: click the top Add buton...
	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[2]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Add Attachments".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // VP: confirm the elements of the Add Attachments screen...
	    try {
	      assertTrue(isElementPresent(By.cssSelector("input[type=\"file\"]")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    try {
	      assertTrue(isElementPresent(By.cssSelector("button.button.inline")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    try {
	      assertTrue(isElementPresent(By.xpath("//div[@id='attachment_Add']/div[2]/div/button[2]")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: navigate back screen...
	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[2]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Activity Attachments".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Activity".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("My Activities".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // -- END
	}
	
	@Test
	public void test03_SeTestTCAttachContactScreens() throws Exception {
	    // SETest-Attachments_Contact_Screens
	    // Version: 2.2
	    // Desc: Confirms that the Attachments feature is functional from Contact screens...
	    // Required Entities: Contact - John Abbott...
	    // Condition(s): Test user is logged in.    
	    // ==================================================================
	    // Step: click Top-Left button to reveal Global Menu...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[1]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if (isElementPresent(By.xpath(".//*[@id='Mobile_SalesLogix_SpeedSearchWidget_0']/div/div[1]/input"))) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: navigate to Contacts list view...
	    driver.findElement(By.xpath(".//*[@id='left_drawer']/descendant::*[text() = \"Contacts\"]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if (isElementPresent(By.xpath(".//*[@id='contact_list']/ul/li[1]"))) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: perform search for Contact item...
	    driver.findElement(By.cssSelector("#Sage_Platform_Mobile_SearchWidget_6 > div.table-layout > div > input[name=\"query\"]")).clear();
	    driver.findElement(By.cssSelector("#Sage_Platform_Mobile_SearchWidget_6 > div.table-layout > div > input[name=\"query\"]")).sendKeys("Abbott");
	    driver.findElement(By.cssSelector("#Sage_Platform_Mobile_SearchWidget_6 > div.table-layout > div.hasButton > button.subHeaderButton.searchButton")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if (isElementPresent(By.xpath(".//*[@id='contact_list']/ul/li[1]"))) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: navigate to top Contact record...
	    driver.findElement(By.cssSelector("#contact_list > ul.list-content > li > div.list-item-content > h3")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Abbott, John".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // VP: confirm that Attachments is available under the Related Items section...
	    try {
	      assertTrue(isElementPresent(By.xpath("(//img[@alt='icon'])[11]")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    try {
	      assertEquals("Attachments", driver.findElement(By.xpath("//div[@id='contact_detail']/div[2]/ul[2]/li[6]/a/span")).getText());
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: click the Attachments link...
	    driver.findElement(By.xpath("//div[@id='contact_detail']/div[2]/ul[2]/li[6]/a/span")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Contact Attachments".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: click to open an Attachment item...
	    try {
	      assertTrue(isElementPresent(By.xpath(".//*[@id='contact_attachment_related']/ul/li[1]")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    driver.findElement(By.linkText("image")).click();
	    // Step: click the top Add buton...
	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[2]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Add Attachments".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // VP: confirm the elements of the Add Attachments screen...
	    try {
	      assertTrue(isElementPresent(By.cssSelector("input[type=\"file\"]")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    try {
	      assertTrue(isElementPresent(By.cssSelector("button.button.inline")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    try {
	      assertTrue(isElementPresent(By.xpath("//div[@id='attachment_Add']/div[2]/div/button[2]")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: navigate back to Account screen...
	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[2]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Contact Attachments".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Abbott, John".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Contacts".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("My Activities".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // -- END
	}
	
	@Test
	public void test04_SeTestTCAttachLeadScreens() throws Exception {
	    // SETest-Attachments_Lead_Screens
	    // Version: 2.2
	    // Desc: Confirms that the Attachments feature is functional from Lead screens...
	    // Required Entities: Lead - John Aaron...
	    // Condition(s): Test user is logged in.    
	    // ==================================================================
	    // Step: click Top-Left button to reveal Global Menu...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[1]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if (isElementPresent(By.xpath(".//*[@id='Mobile_SalesLogix_SpeedSearchWidget_0']/div/div[1]/input"))) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: navigate to Leads list view...
	    driver.findElement(By.xpath(".//*[@id='left_drawer']/descendant::*[text() = \"Leads\"]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if (isElementPresent(By.xpath(".//*[@id='lead_list']/ul/li[1]"))) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: perform search for Lead item...
	    driver.findElement(By.cssSelector("#Sage_Platform_Mobile_SearchWidget_16 > div.table-layout > div > input[name=\"query\"]")).clear();
	    driver.findElement(By.cssSelector("#Sage_Platform_Mobile_SearchWidget_16 > div.table-layout > div > input[name=\"query\"]")).sendKeys("Aaron");
	    driver.findElement(By.cssSelector("#Sage_Platform_Mobile_SearchWidget_16 > div.table-layout > div.hasButton > button.subHeaderButton.searchButton")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if (isElementPresent(By.xpath(".//*[@id='lead_list']/ul/li[1]"))) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: navigate to top Contact record...
	    driver.findElement(By.cssSelector("#lead_list > ul.list-content > li > div.list-item-content > h3")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Aaron, John".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // VP: confirm that Attachments is available under the Related Items section...
	    try {
	      assertTrue(isElementPresent(By.xpath("(//img[@alt='icon'])[8]")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    try {
	      assertEquals("Attachments", driver.findElement(By.xpath("//div[@id='lead_detail']/div[2]/ul[2]/li[3]/a/span")).getText());
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: click the Attachments link...
	    driver.findElement(By.xpath("//div[@id='lead_detail']/div[2]/ul[2]/li[3]/a/span")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Lead Attachments".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: click to open an Attachment item...
	    try {
	      assertTrue(isElementPresent(By.xpath(".//*[@id='myactivity_list']/ul/li[1]")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    driver.findElement(By.linkText("WeirdChar")).click();
	    // Step: click the top Add buton...
	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[2]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Add Attachments".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // VP: confirm the elements of the Add Attachments screen...
	    try {
	      assertTrue(isElementPresent(By.cssSelector("input[type=\"file\"]")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    try {
	      assertTrue(isElementPresent(By.cssSelector("button.button.inline")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    try {
	      assertTrue(isElementPresent(By.xpath("//div[@id='attachment_Add']/div[2]/div/button[2]")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: navigate back screen...
	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[2]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Lead Attachments".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Aaron, John".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Leads".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("My Activities".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // -- END
	}
	
	@Test
	public void test05_SeTestTCAttachNoteScreens() throws Exception {
	    // SETest-Attachments_Note_Screens
	    // Version: 2.2
	    // Desc: Confirms that the Attachments feature is functional from Note screens...
	    // Required Entities: Note - Colonna, Krista / Sage
	    // Condition(s): Test user is logged in.    
	    // ==================================================================
	    // Step: click Top-Left button to reveal Global Menu...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[1]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if (isElementPresent(By.xpath(".//*[@id='Mobile_SalesLogix_SpeedSearchWidget_0']/div/div[1]/input"))) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: navigate to Notes/History list view...
	    driver.findElement(By.xpath(".//*[@id='left_drawer']/descendant::*[text() = \"Notes/History\"]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if (isElementPresent(By.xpath(".//*[@id='myactivity_list']/ul/li[1]"))) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: perform search for Notes/History item...
	    driver.findElement(By.cssSelector("#Sage_Platform_Mobile_SearchWidget_27 > div.table-layout > div > input[name=\"query\"]")).clear();
	    driver.findElement(By.cssSelector("#Sage_Platform_Mobile_SearchWidget_27 > div.table-layout > div > input[name=\"query\"]")).sendKeys("Proposal");
	    driver.findElement(By.cssSelector("#Sage_Platform_Mobile_SearchWidget_27 > div.table-layout > div.hasButton > button.subHeaderButton.searchButton")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if (isElementPresent(By.xpath(".//*[@id='history_list']/ul/li[1]"))) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: navigate to top Notes/History record...
	    driver.findElement(By.xpath(".//*[@id='history_list']/ul/li[1]/div/h3/span[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("E-mail".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // VP: confirm that Attachments is available under the Related Items section...
	    try {
	      assertTrue(isElementPresent(By.cssSelector("a > img.icon")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    try {
	      assertEquals("Attachments", driver.findElement(By.cssSelector("a > span")).getText());
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: click the Attachments link...
	    driver.findElement(By.cssSelector("a > span")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("History Attachments".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: click to open an Attachment item...
	    // NOTE: Attachment click has been disabled due to a 404 Error...
	    try {
	      assertTrue(isElementPresent(By.xpath(".//*[@id='history_attachment_related']/ul/li")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: click the top Add buton...
	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[2]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Add Attachments".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // VP: confirm the elements of the Add Attachments screen...
	    try {
	      assertTrue(isElementPresent(By.cssSelector("input[type=\"file\"]")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    try {
	      assertTrue(isElementPresent(By.cssSelector("button.button.inline")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    try {
	      assertTrue(isElementPresent(By.xpath("//div[@id='attachment_Add']/div[2]/div/button[2]")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: navigate back screen...
	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[2]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("History Attachments".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("E-mail".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Notes/History".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("My Activities".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // -- END
	}
	
	@Test
	public void test06_SeTestTCAttachOpportunityScreens() throws Exception {
	    // SETest-Attachments_Opportunity_Screens
	    // Version: 2.2
	    // Desc: Confirms that the Attachments feature is functional from Opportunity screens...
	    // Required Entities: Opportunity - Abbott Ltd.-Phase I ...
	    // Condition(s): Test user is logged in.    
	    // ==================================================================
	    // Step: click Top-Left button to reveal Global Menu...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[1]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if (isElementPresent(By.xpath(".//*[@id='Mobile_SalesLogix_SpeedSearchWidget_0']/div/div[1]/input"))) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: navigate to Opportunities list view...
	    driver.findElement(By.xpath(".//*[@id='left_drawer']/descendant::*[text() = \"Opportunities\"]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if (isElementPresent(By.xpath(".//*[@id='opportunity_list']/ul/li[1]"))) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: perform search for Opportunity item...
	    driver.findElement(By.cssSelector("#Sage_Platform_Mobile_SearchWidget_11 > div.table-layout > div > input[name=\"query\"]")).clear();
	    driver.findElement(By.cssSelector("#Sage_Platform_Mobile_SearchWidget_11 > div.table-layout > div > input[name=\"query\"]")).sendKeys("Abbott Ltd.-Phase I");
	    driver.findElement(By.cssSelector("#Sage_Platform_Mobile_SearchWidget_11 > div.table-layout > div.hasButton > button.subHeaderButton.searchButton")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if (isElementPresent(By.xpath(".//*[@id='opportunity_list']/ul/li[1]"))) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: navigate to top Opportunity record...
	    driver.findElement(By.cssSelector("#opportunity_list > ul.list-content > li > div.list-item-content > h3")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Abbott Ltd.-Phase I".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // VP: confirm that Attachments is available under the Related Items section...
	    try {
	      assertTrue(isElementPresent(By.xpath("(//img[@alt='icon'])[15]")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    try {
	      assertEquals("Attachments", driver.findElement(By.xpath("//div[@id='opportunity_detail']/div[2]/ul[2]/li[5]/a/span")).getText());
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: click the Attachments link...
	    driver.findElement(By.xpath("//div[@id='opportunity_detail']/div[2]/ul[2]/li[5]/a/span")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Opportunity Attachments".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: click to open an Attachment item...
	    try {
	      assertTrue(isElementPresent(By.xpath(".//*[@id='opportunity_attachment_related']/ul/li[1]/div/div[2]/a")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    driver.findElement(By.linkText("Proposal")).click();
	    // Step: click the top Add buton...
	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[2]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Add Attachments".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // VP: confirm the elements of the Add Attachments screen...
	    try {
	      assertTrue(isElementPresent(By.cssSelector("input[type=\"file\"]")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    try {
	      assertTrue(isElementPresent(By.cssSelector("button.button.inline")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    try {
	      assertTrue(isElementPresent(By.xpath("//div[@id='attachment_Add']/div[2]/div/button[2]")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: navigate back screen...
	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[2]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Opportunity Attachments".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Abbott Ltd.-Phase I".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Opportunities".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("My Activities".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // -- END
	}
	
	@Test
	public void test07_SeTestTCAttachTicketScreens() throws Exception {
	    // SETest-Attachments_Ticket_Screens
	    // Version: 2.2
	    // Desc: Confirms that the Attachments feature is functional from Ticket screens...
	    // Required Entities: Ticket - 000-00-000011 ...
	    // Condition(s): Test user is logged in.    
	    // ==================================================================
	    // Step: click Top-Left button to reveal Global Menu...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[1]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if (isElementPresent(By.xpath(".//*[@id='Mobile_SalesLogix_SpeedSearchWidget_0']/div/div[1]/input"))) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: navigate to Tickets list view...
	    driver.findElement(By.xpath(".//*[@id='left_drawer']/descendant::*[text() = \"Tickets\"]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if (isElementPresent(By.xpath(".//*[@id='ticket_list']/ul/li[1]"))) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: perform search for Ticket item...
	    driver.findElement(By.cssSelector("#Sage_Platform_Mobile_SearchWidget_18 > div.table-layout > div > input[name=\"query\"]")).clear();
	    driver.findElement(By.cssSelector("#Sage_Platform_Mobile_SearchWidget_18 > div.table-layout > div > input[name=\"query\"]")).sendKeys("000-00-000011");
	    driver.findElement(By.cssSelector("#Sage_Platform_Mobile_SearchWidget_18 > div.table-layout > div.hasButton > button.subHeaderButton.searchButton")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if (isElementPresent(By.xpath(".//*[@id='ticket_list']/ul/li[1]"))) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: navigate to top Ticket record...
	    driver.findElement(By.xpath(".//*[@id='ticket_list']/ul/li/div/h3")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("000-00-000011".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // VP: confirm that Attachments is available under the Related Items section...
	    try {
	      assertTrue(isElementPresent(By.xpath("(//img[@alt='icon'])[4]")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    try {
	      assertEquals("Attachments", driver.findElement(By.xpath("//div[@id='ticket_detail']/div[2]/ul[2]/li[3]/a/span")).getText());
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: click the Attachments link...
	    driver.findElement(By.xpath("//div[@id='ticket_detail']/div[2]/ul[2]/li[3]/a/span")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Ticket Attachments".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: click to open an Attachment item...
	    try {
	      assertTrue(isElementPresent(By.xpath(".//*[@id='ticket_attachment_related']/ul/li[3]/div/div[2]/a")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    driver.findElement(By.linkText("image")).click();
	    // Step: click the top Add buton...
	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[2]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Add Attachments".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // VP: confirm the elements of the Add Attachments screen...
	    try {
	      assertTrue(isElementPresent(By.cssSelector("input[type=\"file\"]")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    try {
	      assertTrue(isElementPresent(By.cssSelector("button.button.inline")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    try {
	      assertTrue(isElementPresent(By.xpath("//div[@id='attachment_Add']/div[2]/div/button[2]")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: navigate back screen...
	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[2]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Ticket Attachments".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("000-00-000011".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Tickets".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("My Activities".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // -- END
	}
	

	//MARKER		
	// *******
	@Test
	public void test99_Mobile_LogOut()  throws InterruptedException {				
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerbutton = PageFactory.initElements(driver, HeaderButton.class);
	
		// Click the Top-Left, Global Menu button...
		headerbutton.showGlobalMenu();
	
		// Click the Log Off button
		commNav.logOut();
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
