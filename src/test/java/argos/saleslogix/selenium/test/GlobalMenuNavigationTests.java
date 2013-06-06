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

public class GlobalMenuNavigationTests extends BrowserSetup {

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
	public void test01_SeTestTCGlobalMenuAddAccountContactScreens() throws Exception {
	    // SE Test: SETest-GlobalMenu-AddAccountContact_Screens
	    // Version: 2.2
	    // Desc: Confirms that the toggle button (left and right) for Global screen access is visible on screens accessible under the Add Account/Contact main screen...
	    // Note: This test script can be used as a template for creating new entity records from Add Account/Contact edit screens.
	    // Condition(s): Test user is logged in.    
	    // ==================================================================
	    // Step: click Top-Left button to reveal Global Menu...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[1]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if (isElementPresent(By.xpath(".//*[@id='Mobile_SalesLogix_SpeedSearchWidget_0']/div/div[1]/input"))) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: click the Add Account/Contact link...
	    driver.findElement(By.xpath(".//*[@id='left_drawer']/descendant::*[text() = 'Add Account/Contact']")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Add Account / Contact".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // VP: confirm that Global Menu button is available...
	    try {
	      assertTrue(isElementPresent(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: click the Name edit button...
	    driver.findElement(By.cssSelector("#Mobile_SalesLogix_Fields_NameField_0 > button.button.simpleSubHeaderButton")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Edit Name".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // VP: confirm that Global Menu button is available...
	    try {
	      assertTrue(isElementPresent(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: click Prefix edit button...
	    driver.findElement(By.cssSelector("#Mobile_SalesLogix_Fields_PicklistField_5 > button.button.simpleSubHeaderButton")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Name Prefix".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // VP: confirm that Global Menu button is available...
	    try {
	      assertTrue(isElementPresent(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    // Step: click Suffix edit button...
	    driver.findElement(By.cssSelector("#Mobile_SalesLogix_Fields_PicklistField_6 > button.button.simpleSubHeaderButton")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Name Suffix".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // VP: confirm that Global Menu button is available...
	    try {
	      assertTrue(isElementPresent(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    // Step: navigate back to the Name edit screen...
	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Add Account / Contact".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: click the Title edit button...
	    driver.findElement(By.cssSelector("#Mobile_SalesLogix_Fields_PicklistField_0 > button.button.simpleSubHeaderButton")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Title".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // VP: confirm that Global Menu button is available...
	    try {
	      assertTrue(isElementPresent(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: navigate back to the Name edit screen...
	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Add Account / Contact".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: click the Address edit button...
	    driver.findElement(By.cssSelector("#Mobile_SalesLogix_Fields_AddressField_0 > button.button.simpleSubHeaderButton")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Address".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // VP: confirm that Global Menu button is available...
	    try {
	      assertTrue(isElementPresent(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: click the Description edit button...
	    driver.findElement(By.cssSelector("#Mobile_SalesLogix_Fields_PicklistField_7 > button.button.simpleSubHeaderButton")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Description".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // VP: confirm that Global Menu button is available...
	    try {
	      assertTrue(isElementPresent(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: navigate back to the Name edit screen...
	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Address".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: click the City edit button...
	    driver.findElement(By.cssSelector("#Mobile_SalesLogix_Fields_PicklistField_8 > button.button.simpleSubHeaderButton")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("City".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // VP: confirm that Global Menu button is available...
	    try {
	      assertTrue(isElementPresent(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: navigate back to the Name edit screen...
	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Address".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: click the State edit button...
	    driver.findElement(By.cssSelector("#Mobile_SalesLogix_Fields_PicklistField_9 > button.button.simpleSubHeaderButton")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("State".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // VP: confirm that Global Menu button is available...
	    try {
	      assertTrue(isElementPresent(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: navigate back to the Name edit screen...
	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Address".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: click the Country edit button...
	    driver.findElement(By.cssSelector("#Mobile_SalesLogix_Fields_PicklistField_10 > button.button.simpleSubHeaderButton")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Country".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // VP: confirm that Global Menu button is available...
	    try {
	      assertTrue(isElementPresent(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: navigate back to the Address edit screen...
	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Address".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: navigate back to the Add Account / Contact screen...
	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Add Account / Contact".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: click the Type edit button to open the Account Type screen...
	    driver.findElement(By.cssSelector("#Mobile_SalesLogix_Fields_PicklistField_1 > button.button.simpleSubHeaderButton")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Account Type".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // VP: confirm that Global Menu button is available...
	    try {
	      assertTrue(isElementPresent(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: navigate back to the Add Account / Contact screen...
	    driver.findElement(By.cssSelector("#pick_list_7 > ul.list-content > li > div.list-item-content > h3")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Add Account / Contact".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: click the Sub-Type edit button to open the Account Sub-Type screen...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Fields_PicklistField_1']/button")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Account Type".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // VP: confirm that Global Menu button is available...
	    try {
	      assertTrue(isElementPresent(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: navigate back to the Add Account / Contact screen...
	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Add Account / Contact".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: click the Status edit button to open the Account Status screen...
	    driver.findElement(By.cssSelector("#Mobile_SalesLogix_Fields_PicklistField_3 > button.button.simpleSubHeaderButton")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Account Status".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // VP: confirm that Global Menu button is available...
	    try {
	      assertTrue(isElementPresent(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: navigate back to the Add Account / Contact screen...
	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Add Account / Contact".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: click the Industry edit button to open the Account Status screen...
	    driver.findElement(By.cssSelector("#Mobile_SalesLogix_Fields_PicklistField_4 > button.button.simpleSubHeaderButton")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Industry".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // VP: confirm that Global Menu button is available...
	    try {
	      assertTrue(isElementPresent(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: navigate back to the Add Account / Contact screen...
	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Add Account / Contact".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: click the Top Cancel button...
	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("My Activities".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // -- END
	}
	
	@Test
	public void test02_SeTestTCGlobalMenuCompleteActivityScreens() throws Exception {
	    // SETest-GlobalMenu_CompleteActivity_Screens
	    // Version: 2.2
	    // Desc: Confirms that the toggle button (left and right) for Global screen access is visible on screens accessible under the Complete Activity screens...
	    // Note: This test script can be used as a template for completing/editing an Activity.
	    // Condition(s): Test user is logged in.    
	    // ==================================================================
	    // Step: search for then click an Activity link from the My Activities screen...
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("My Activities".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_SearchWidget_26']/div/div[1]/input")).clear();
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_SearchWidget_26']/div/div[1]/input")).sendKeys("Demonstration");
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_SearchWidget_26']/div/div[3]/button")).click();
	    driver.findElement(By.xpath(".//*[@id='myactivity_list']/ul/li[1]/div[2]/h3/span[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Activity".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    assertTrue(driver.findElement(By.cssSelector("a > label")).getText().matches("^Complete[\\s\\S]*$"));
	    // Step: click the Complete Activity link...
	    driver.findElement(By.cssSelector("a > label")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if (driver.findElement(By.id("pageTitle")).getText().matches("^Complete[\\s\\S]*$")) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // VP: confirm that Global Menu button is available...
	    try {
	      assertTrue(isElementPresent(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: click the Regarding edit button...
	    driver.findElement(By.cssSelector("#Mobile_SalesLogix_Fields_PicklistField_31 > button.button.simpleSubHeaderButton")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Activity Regarding".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // VP: confirm that Global Menu button is available...
	    try {
	      assertTrue(isElementPresent(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: navigate back to Complete Activity screen...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if (driver.findElement(By.id("pageTitle")).getText().matches("^Complete[\\s\\S]*$")) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: click Start Date edit button...
	    driver.findElement(By.cssSelector("#Sage_Platform_Mobile_Fields_DateField_10 > button.button.whiteButton")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Calendar".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // VP: confirm that Global Menu button is available...
	    try {
	      assertTrue(isElementPresent(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: navigate back to Complete Activity screen...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if (driver.findElement(By.id("pageTitle")).getText().matches("^Complete[\\s\\S]*$")) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: click Duration edit button...
	    driver.findElement(By.cssSelector("#Sage_Platform_Mobile_Fields_DurationField_2 > button.button.simpleSubHeaderButton")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("List".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // VP: confirm that Global Menu button is available...
	    try {
	      assertTrue(isElementPresent(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: navigate back to the Name edit screen...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if (driver.findElement(By.id("pageTitle")).getText().matches("^Complete[\\s\\S]*$")) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: click the Result edit button...
	    driver.findElement(By.cssSelector("#Mobile_SalesLogix_Fields_PicklistField_32 > button.button.simpleSubHeaderButton")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Result".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // VP: confirm that Global Menu button is available...
	    try {
	      assertTrue(isElementPresent(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: navigate back to the Name edit screen...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if (driver.findElement(By.id("pageTitle")).getText().matches("^Complete[\\s\\S]*$")) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: click the Follow-up edit button...
	    driver.findElement(By.cssSelector("#Sage_Platform_Mobile_Fields_SelectField_2 > button.button.simpleSubHeaderButton")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Follow-up type".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // VP: confirm that Global Menu button is available...
	    try {
	      assertTrue(isElementPresent(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: navigate back to the Name edit screen...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if (driver.findElement(By.id("pageTitle")).getText().matches("^Complete[\\s\\S]*$")) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: click the Notes edit button...
	    driver.findElement(By.cssSelector("#Sage_Platform_Mobile_Fields_NoteField_7 > button.button.simpleSubHeaderButton")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Notes".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // VP: confirm that Global Menu button is available...
	    try {
	      assertTrue(isElementPresent(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: navigate back to the Name edit screen...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if (driver.findElement(By.id("pageTitle")).getText().matches("^Complete[\\s\\S]*$")) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: click the Priority edit button...
	    driver.findElement(By.cssSelector("#Mobile_SalesLogix_Fields_PicklistField_33 > button.button.simpleSubHeaderButton")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Priority".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // VP: confirm that Global Menu button is available...
	    try {
	      assertTrue(isElementPresent(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: navigate back to the Name edit screen...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if (driver.findElement(By.id("pageTitle")).getText().matches("^Complete[\\s\\S]*$")) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: click the Category edit button...
	    driver.findElement(By.cssSelector("#Mobile_SalesLogix_Fields_PicklistField_34 > button.button.simpleSubHeaderButton")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Activity Category".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // VP: confirm that Global Menu button is available...
	    try {
	      assertTrue(isElementPresent(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: navigate back to the Name edit screen...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if (driver.findElement(By.id("pageTitle")).getText().matches("^Complete[\\s\\S]*$")) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: click the Leader edit button...
	    driver.findElement(By.cssSelector("#Sage_Platform_Mobile_Fields_LookupField_33 > button.button.simpleSubHeaderButton")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Users".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // VP: confirm that Global Menu button is available...
	    try {
	      assertTrue(isElementPresent(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: navigate back to the Address edit screen...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if (driver.findElement(By.id("pageTitle")).getText().matches("^Complete[\\s\\S]*$")) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: click the Account edit button...
	    driver.findElement(By.cssSelector("#Sage_Platform_Mobile_Fields_LookupField_34 > button.button.simpleSubHeaderButton")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Accounts".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // VP: confirm that Global Menu button is available...
	    try {
	      assertTrue(isElementPresent(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: navigate back to the Address edit screen...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if (driver.findElement(By.id("pageTitle")).getText().matches("^Complete[\\s\\S]*$")) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: click the Contact edit button...
	    driver.findElement(By.cssSelector("#Sage_Platform_Mobile_Fields_LookupField_35 > button.button.simpleSubHeaderButton")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Contacts".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // VP: confirm that Global Menu button is available...
	    try {
	      assertTrue(isElementPresent(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: navigate back to the Address edit screen...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if (driver.findElement(By.id("pageTitle")).getText().matches("^Complete[\\s\\S]*$")) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: click the Opportunity edit button...
	    driver.findElement(By.cssSelector("#Sage_Platform_Mobile_Fields_LookupField_36 > button.button.simpleSubHeaderButton")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Opportunities".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // VP: confirm that Global Menu button is available...
	    try {
	      assertTrue(isElementPresent(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: navigate back to the Address edit screen...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if (driver.findElement(By.id("pageTitle")).getText().matches("^Complete[\\s\\S]*$")) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: click the Tickets edit button...
	    driver.findElement(By.cssSelector("#Sage_Platform_Mobile_Fields_LookupField_37 > button.button.simpleSubHeaderButton")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Tickets".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // VP: confirm that Global Menu button is available...
	    try {
	      assertTrue(isElementPresent(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: navigate back to the Address edit screen...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if (driver.findElement(By.id("pageTitle")).getText().matches("^Complete[\\s\\S]*$")) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: navigate back to the Add Account / Contact screen...
	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("My Activities".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // -- END
	}
		
	
	@Test
	public void test03_SeTestTCGlobalMenuDoSpeedSearch() throws Exception {
	    // SE Test: SETest-GlobalMenu_DoSpeedSearch
	    // Version: 2.2
	    // Desc: Opens the Global Menu and then performs a simple SpeedSearch..
	    // Condition(s): Test user is logged in.    
	    // ==================================================================
	    // Step: click Top-Left button to reveal Global Menu...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[1]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if (isElementPresent(By.xpath(".//*[@id='Mobile_SalesLogix_SpeedSearchWidget_0']/div/div[1]/input"))) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // VP: check  the SpeedSearch bar...
	    try {
	      assertTrue(isElementPresent(By.cssSelector("#Mobile_SalesLogix_SpeedSearchWidget_0 > label")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    try {
	      assertTrue(isElementPresent(By.cssSelector("#Mobile_SalesLogix_SpeedSearchWidget_0 > div.table-layout > div.hasButton > button.subHeaderButton.searchButton")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: enter an item in the search field then click the SpeedSearch button...
	    driver.findElement(By.cssSelector("#Mobile_SalesLogix_SpeedSearchWidget_0 > div.table-layout > div > input[name=\"query\"]")).clear();
	    driver.findElement(By.cssSelector("#Mobile_SalesLogix_SpeedSearchWidget_0 > div.table-layout > div > input[name=\"query\"]")).sendKeys("abbott");
	    driver.findElement(By.cssSelector("#Mobile_SalesLogix_SpeedSearchWidget_0 > div.table-layout > div.hasButton > button.subHeaderButton.searchButton")).click();
	    // Warning: waitForTextPresent may require manual changes
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if (driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Search Results[\\s\\S]*$")) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if (isElementPresent(By.xpath(".//*[@id='speedsearch_list']/ul/li[1]"))) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: click a specific SpeedSearch test result
	    driver.findElement(By.xpath(".//*[@id='speedsearch_list']/descendant::*[text() = 'Won the deal (2012_08_22)']")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("History".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    try {
	      assertEquals("Won the deal", driver.findElement(By.xpath("//div[@id='history_detail']/div[2]/div/div[3]/span")).getText());
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: click Top Blue Arrow button to navigate back...
	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Search Results".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[2]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("My Activities".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // -- END
	}
	
	@Test
	public void test04_SeTestTCGlobalMenuEditAccountScreens() throws Exception {
	    // SETest-GlobalMenu_EditAccount_Screens
	    // Version: 2.2
	    // Desc: Confirms that the toggle button (left and right) for Global Menu access is visible on screens accessible under the Edit Account screens...
	    // Note: This test script can be used as a template for completing/editing an Account.
	    // Condition(s): Test user is logged in.    
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
	    driver.findElement(By.cssSelector("#Sage_Platform_Mobile_SearchWidget_3 > div.table-layout > div > input[name=\"query\"]")).sendKeys("Big Systems");
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
	    	try { if ("Big Systems".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // VP: confirm that Global Menu button is available...
	    try {
	      assertTrue(isElementPresent(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: click the top Edit button...
	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[2]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if (isElementPresent(By.cssSelector("#Sage_Platform_Mobile_Fields_TextField_14 > input[name=\"AccountName\"]"))) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: click the Business Description edit buton...
	    driver.findElement(By.cssSelector("#Sage_Platform_Mobile_Fields_NoteField_0 > button.button.simpleSubHeaderButton")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Business Description".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // VP: confirm that Global Menu button is available...
	    try {
	      assertTrue(isElementPresent(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: navigate back to Account screen...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Account".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: click the For Owners toggle to ON...
	    driver.findElement(By.cssSelector("#Sage_Platform_Mobile_Fields_LookupField_1 > button.button.simpleSubHeaderButton")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Owners".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // VP: confirm that Global Menu button is available...
	    try {
	      assertTrue(isElementPresent(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: navigate back to Account screen...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Account".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: click the Lead Sources edit button...
	    driver.findElement(By.cssSelector("#Sage_Platform_Mobile_Fields_LookupField_2 > button.button.simpleSubHeaderButton")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Lead Sources".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // VP: confirm that Global Menu button is available...
	    try {
	      assertTrue(isElementPresent(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: navigate back to Account screen...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Account".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: navigate back...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Big Systems".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
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
	public void test05_SeTestTCGlobalMenuEditActivityScreens() throws Exception {
	    // SETest-GlobalMenu_EditActivity_Screens
	    // Version: 2.2
	    // Desc: Confirms that the toggle button (left and right) for Global Menu access is visible on screens accessible under the Edit Activity screens...
	    // Note: This test script can be used as a template for completing/editing an Activity.
	    // Condition(s): Test user is logged in.    
	    // ==================================================================
	    // Step: click top Activity link from the My Activities screen...
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("My Activities".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    driver.findElement(By.cssSelector("span.p-description")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Activity".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    assertEquals("Complete Activity", driver.findElement(By.cssSelector("a > label")).getText());
	    // Step: click the Top cEdit Activity button...
	    driver.findElement(By.xpath(".//*[@id='activity_detail']/div[2]/ul[1]/li/a")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Complete Activity".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // VP: confirm that Global Menu button is available...
	    try {
	      assertTrue(isElementPresent(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: click the Regarding edit button...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Fields_PicklistField_31']/button")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Activity Regarding".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // VP: confirm that Global Menu button is available...
	    try {
	      assertTrue(isElementPresent(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: navigate back to Activity screen...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Complete Activity".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: click Start Date edit button...
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_Fields_DateField_10']/button")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Calendar".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // VP: confirm that Global Menu button is available...
	    try {
	      assertTrue(isElementPresent(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: navigate back to Activity screen...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Complete Activity".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: click Duration edit button...
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_Fields_DurationField_2']/button")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("List".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // VP: confirm that Global Menu button is available...
	    try {
	      assertTrue(isElementPresent(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: navigate back to the Activity screen...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Complete Activity".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: click the Result edit button...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Fields_PicklistField_32']/button")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Result".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // VP: confirm that Global Menu button is available...
	    try {
	      assertTrue(isElementPresent(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: navigate back to the Activity screen...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Complete Activity".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: click the Follow-up edit button...
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_Fields_SelectField_2']/button")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Follow-up type".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // VP: confirm that Global Menu button is available...
	    try {
	      assertTrue(isElementPresent(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: navigate back to the Activity screen...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Complete Activity".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: click the Notes edit button...
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_Fields_NoteField_7']/button")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Notes".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // VP: confirm that Global Menu button is available...
	    try {
	      assertTrue(isElementPresent(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: navigate back to the Activity screen...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Complete Activity".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: click the Priority edit button...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Fields_PicklistField_33']/button")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Priority".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // VP: confirm that Global Menu button is available...
	    try {
	      assertTrue(isElementPresent(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: navigate back to the Activity screen...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Complete Activity".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: click the Category edit button...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Fields_PicklistField_34']/button")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Activity Category".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // VP: confirm that Global Menu button is available...
	    try {
	      assertTrue(isElementPresent(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: navigate back to the Activity screen...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Complete Activity".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: click the Leader edit button...
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_Fields_LookupField_33']/button")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Users".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // VP: confirm that Global Menu button is available...
	    try {
	      assertTrue(isElementPresent(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: navigate back to the Activity screen...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Complete Activity".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: click the Account edit button...
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_Fields_LookupField_34']/button")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Accounts".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // VP: confirm that Global Menu button is available...
	    try {
	      assertTrue(isElementPresent(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: navigate back to the Activity screen...
	    driver.findElement(By.xpath(".//*[@id='account_related']/ul/li[1]/div/h3")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Complete Activity".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: click the Contact edit button...
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_Fields_LookupField_35']/button")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Contacts".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // VP: confirm that Global Menu button is available...
	    try {
	      assertTrue(isElementPresent(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: navigate back to the Activity screen...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Complete Activity".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: click the Opportunity edit button...
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_Fields_LookupField_36']/button")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Opportunities".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // VP: confirm that Global Menu button is available...
	    try {
	      assertTrue(isElementPresent(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: navigate back to the Activity screen...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Complete Activity".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: click the Tickets edit button...
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_Fields_LookupField_37']/button")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Tickets".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // VP: confirm that Global Menu button is available...
	    try {
	      assertTrue(isElementPresent(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: navigate back to the Activity screen...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Complete Activity".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: navigate back to the Activity screen...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("My Activities".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // -- END
	}	
	
	@Test
	public void test06_SeTestTCGlobalMenuEditContactScreens() throws Exception {
	    // SETest-GlobalMenu_EditContact_Screens
	    // Version: 2.2
	    // Desc: Confirms that the toggle button (left and right) for Global Menu access is visible on screens accessible under the Edit Contact screens...
	    // Note: This test script can be used as a template for completing/editing a Contact.
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

	    // Step: perform search for Contact items...
	    driver.findElement(By.cssSelector("#Sage_Platform_Mobile_SearchWidget_6 > div.table-layout > div > input[name=\"query\"]")).clear();
	    driver.findElement(By.cssSelector("#Sage_Platform_Mobile_SearchWidget_6 > div.table-layout > div > input[name=\"query\"]")).sendKeys("Alfred");
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
	    	try { if ("Alfred, John".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // VP: confirm that Global Menu button is available...
	    try {
	      assertTrue(isElementPresent(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: click the top Edit button...
	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[2]")).click();
	    try {
	      assertTrue(isElementPresent(By.xpath("//div[@id='contact_edit']/div[2]/fieldset/div[2]")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: click the Cuisine edit buton...
	    driver.findElement(By.cssSelector("#Mobile_SalesLogix_Fields_PicklistField_16 > button.button.simpleSubHeaderButton")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Cuisine".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // VP: confirm that Global Menu button is available...
	    try {
	      assertTrue(isElementPresent(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: navigate back to Contact screen...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Contact".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: click the top Cancel button...
	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Alfred, John".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: navigate back to Contacts screen...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
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
	public void test07_SeTestTCGlobalMenuEditLeadScreens() throws Exception {
	    // SETest-GlobalMenu_EditLead_Screens
	    // Version: 2.2
	    // Desc: Confirms that the toggle button (left and right) for Global Menu access is visible on screens accessible under the Edit Lead screens...
	    // Note: This test script can be used as a template for completing/editing a Lead.
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

	    // Step: perform search for Lead items...
	    driver.findElement(By.cssSelector("#Sage_Platform_Mobile_SearchWidget_16 > div.table-layout > div > input[name=\"query\"]")).clear();
	    driver.findElement(By.cssSelector("#Sage_Platform_Mobile_SearchWidget_16 > div.table-layout > div > input[name=\"query\"]")).sendKeys("Day");
	    driver.findElement(By.cssSelector("#Sage_Platform_Mobile_SearchWidget_16 > div.table-layout > div.hasButton > button.subHeaderButton.searchButton")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if (isElementPresent(By.xpath(".//*[@id='lead_list']/ul/li[1]"))) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: perform Lead search then navigate to top result record...
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_SearchWidget_16']/div/div[1]/input")).clear();
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_SearchWidget_16']/div/div[1]/input")).sendKeys("Day");
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_SearchWidget_16']/div/div[3]/button")).click();
	    driver.findElement(By.xpath(".//*[@id='lead_list']/ul/li/div/h3")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Day, Bob".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // VP: confirm that Global Menu button is available...
	    try {
	      assertTrue(isElementPresent(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: click the top Edit button...
	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[2]")).click();
	    try {
	      assertTrue(isElementPresent(By.xpath("//div[@id='lead_edit']/div[2]/fieldset/div[2]")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: click the Comments edit buton...
	    driver.findElement(By.cssSelector("#Sage_Platform_Mobile_Fields_NoteField_2 > button.button.simpleSubHeaderButton")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Comments".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // VP: confirm that Global Menu button is available...
	    try {
	      assertTrue(isElementPresent(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: navigate back to Lead screen...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Lead".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: click the top Cancel button...
	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Day, Bob".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: navigate back to the Leads screen...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
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
	public void test08_SeTestTCGlobalMenuEditNoteScreens() throws Exception {
	    // SETest-GlobalMenu_EditNote_Screens
	    // Version: 2.2
	    // Desc: Confirms that the toggle button (left and right) for Global Menu access is visible on screens accessible under the Edit Note screens...
	    // Note: This test script can be used as a template for adding/editing a Note.
	    // Condition(s): Test user is logged in.    
	    // ==================================================================
	    // Step: click Top-Left button to reveal Global Menu...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[1]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if (isElementPresent(By.xpath(".//*[@id='Mobile_SalesLogix_SpeedSearchWidget_0']/div/div[1]/input"))) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: navigate to Notes list view...
	    driver.findElement(By.xpath(".//*[@id='left_drawer']/descendant::*[text() = \"Notes/History\"]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if (isElementPresent(By.xpath(".//*[@id='history_list']/ul/li[1]"))) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: perform search for Note items...
	    driver.findElement(By.cssSelector("#Sage_Platform_Mobile_SearchWidget_27 > div.table-layout > div > input[name=\"query\"]")).clear();
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_SearchWidget_27']/div/div[1]/input")).sendKeys("notes");
	    Thread.sleep(2000);
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_SearchWidget_27']/div/div[3]/button")).click();
	    Thread.sleep(5000);
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if (isElementPresent(By.xpath(".//*[@id='history_list']/ul/li[1]"))) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: navigate to top Notes/History record...
	    driver.findElement(By.xpath(".//*[@id='history_list']/ul/li[1]/div/h3/span[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Note".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // VP: confirm that Global Menu button is available...
	    try {
	      assertTrue(isElementPresent(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: click the top Edit button...
	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[2]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if (isElementPresent(By.cssSelector("div.row.row-edit"))) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: click the Regarding edit buton...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Fields_PicklistField_35']/button")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Note Description".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // VP: confirm that Global Menu button is available...
	    try {
	      assertTrue(isElementPresent(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: navigate back to Note screen...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Note".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: click the For Lead toggle to ON...
	    driver.findElement(By.cssSelector("span.thumb")).click();
	    // Step: click the Lead edit button...
	    driver.findElement(By.cssSelector("#Sage_Platform_Mobile_Fields_LookupField_43 > button.button.simpleSubHeaderButton")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Leads".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // VP: confirm that Global Menu button is available...
	    try {
	      assertTrue(isElementPresent(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: navigate back to Note screen...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Note".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Note".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
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
	public void test09_SeTestTCGlobalMenuEditOppContactScreens() throws Exception {
	    // SETest-GlobalMenu_EditOppContact_Screens
	    // Version: 2.2
	    // Desc: Confirms that the toggle button (left and right) for Global Menu access is visible on screens accessible under the Edit Opportunity-Contact screens...
	    // Note: This test script can be used as a template for completing/editing an Opportunity-Contact.
	    // Condition(s): Test user is logged in.    
	    // ==================================================================
	    // Step: click Top-Left button to reveal Global Menu...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[1]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if (isElementPresent(By.xpath(".//*[@id='Mobile_SalesLogix_SpeedSearchWidget_0']/div/div[1]/input"))) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: navigate to Opportunity list view...
	    driver.findElement(By.xpath(".//*[@id='left_drawer']/descendant::*[text() = \"Opportunities\"]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if (isElementPresent(By.xpath(".//*[@id='opportunity_list']/ul/li[1]"))) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: perform search for Opportunity records...
	    driver.findElement(By.cssSelector("#Sage_Platform_Mobile_SearchWidget_11 > div.table-layout > div > input[name=\"query\"]")).clear();
	    driver.findElement(By.cssSelector("#Sage_Platform_Mobile_SearchWidget_11 > div.table-layout > div > input[name=\"query\"]")).sendKeys("Abbott WorldWide");
	    driver.findElement(By.cssSelector("#Sage_Platform_Mobile_SearchWidget_11 > div.table-layout > div.hasButton > button.subHeaderButton.searchButton")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if (isElementPresent(By.xpath(".//*[@id='opportunity_list']/ul/li[1]"))) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: navigate to top Opportunity record...
	    driver.findElement(By.xpath(".//*[@id='opportunity_list']/ul/li[1]/div/h3")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if (!"Opportunities".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // VP: confirm that Global Menu button is available...
	    try {
	      assertTrue(isElementPresent(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: click the Opportunity Contacts link...
	    driver.findElement(By.xpath("//div[@id='opportunity_detail']/div[2]/ul[2]/li[3]/a/span")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Opportunity Contacts".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: click the top Add buton...
	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[2]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Select Contact".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // VP: confirm that Global Menu button is available...
	    try {
	      assertTrue(isElementPresent(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: click the top Contact record...
	    driver.findElement(By.cssSelector("#contact_related > ul.list-content > li > div.list-item-content > h3")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Edit Opp. Contact".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // VP: confirm that Global Menu button is available...
	    try {
	      assertTrue(isElementPresent(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: click the Role edit button...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Fields_PicklistField_20']/button")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Role".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // VP: confirm that Global Menu button is available...
	    try {
	      assertTrue(isElementPresent(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: navigate back...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Edit Opp. Contact".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: click the Standing edit button...
	    driver.findElement(By.cssSelector("#Mobile_SalesLogix_Fields_PicklistField_21 > button.button.simpleSubHeaderButton")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Standing".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // VP: confirm that Global Menu button is available...
	    try {
	      assertTrue(isElementPresent(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: navigate back...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Edit Opp. Contact".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: click the Competitor Pref edit button...
	    driver.findElement(By.cssSelector("#Sage_Platform_Mobile_Fields_LookupField_12 > button.button.simpleSubHeaderButton")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Competitors".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // VP: confirm that Global Menu button is available...
	    try {
	      assertTrue(isElementPresent(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: navigate back...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Edit Opp. Contact".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: click the top Cancel button...
	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Opportunity Contacts".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: click the top Back button...
	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if (!"Opportunity Contacts".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: navigate back...
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
	public void test10_SeTestTCGlobalMenuEditOpportunityScreens() throws Exception {
	    // SETest-GlobalMenu_EditOpportunity_Screens
	    // Version: 2.2
	    // Desc: Confirms that the toggle button (left and right) for Global Menu access is visible on screens accessible under the Edit Opportunity screens...
	    // Note: This test script can be used as a template for completing/editing an Opportunity-Contact.
	    // Condition(s): Test user is logged in.    
	    // ==================================================================
	    // Step: click Top-Left button to reveal Global Menu...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[1]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if (isElementPresent(By.xpath(".//*[@id='Mobile_SalesLogix_SpeedSearchWidget_0']/div/div[1]/input"))) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: navigate to Opportunity list view...
	    driver.findElement(By.xpath(".//*[@id='left_drawer']/descendant::*[text() = \"Opportunities\"]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if (isElementPresent(By.xpath(".//*[@id='opportunity_list']/ul/li[1]"))) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: perform search for Opportunity records...
	    driver.findElement(By.cssSelector("#Sage_Platform_Mobile_SearchWidget_11 > div.table-layout > div > input[name=\"query\"]")).clear();
	    driver.findElement(By.cssSelector("#Sage_Platform_Mobile_SearchWidget_11 > div.table-layout > div > input[name=\"query\"]")).sendKeys("Abbott WorldWide");
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
	    	try { if (!"Opportunities".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // VP: confirm that Global Menu button is available...
	    try {
	      assertTrue(isElementPresent(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: click the top Edit button...
	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[2]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Opportunity".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: click the Account Manager edit button...
	    driver.findElement(By.cssSelector("#Sage_Platform_Mobile_Fields_LookupField_7 > button.button.simpleSubHeaderButton")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Users".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // VP: confirm that Global Menu button is available...
	    try {
	      assertTrue(isElementPresent(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: navigate back to the Opportunity view...
	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Opportunity".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: click the Reseller edit button...
	    driver.findElement(By.cssSelector("#Sage_Platform_Mobile_Fields_LookupField_8 > button.button.simpleSubHeaderButton")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Accounts".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // VP: confirm that Global Menu button is available...
	    try {
	      assertTrue(isElementPresent(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: navigate back to the Opportunity view...
	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Opportunity".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: click the Type edit button...
	    driver.findElement(By.cssSelector("#Mobile_SalesLogix_Fields_PicklistField_17 > button.button.simpleSubHeaderButton")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Opportunity Type".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // VP: confirm that Global Menu button is available...
	    try {
	      assertTrue(isElementPresent(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: navigate back to the Opportunity view...
	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Opportunity".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: click the Status edit button...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Fields_PicklistField_18']/button")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Opportunity Status".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // VP: confirm that Global Menu button is available...
	    try {
	      assertTrue(isElementPresent(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: navigate back to the Opportunity view...
	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Opportunity".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: click the Lead Source edit button...
	    driver.findElement(By.cssSelector("#Sage_Platform_Mobile_Fields_LookupField_9 > button.button.simpleSubHeaderButton")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Lead Sources".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // VP: confirm that Global Menu button is available...
	    try {
	      assertTrue(isElementPresent(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: navigate back to the Opportunity view...
	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Opportunity".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: click the Owner edit button...
	    driver.findElement(By.cssSelector("#Sage_Platform_Mobile_Fields_LookupField_10 > button.button.simpleSubHeaderButton")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Owners".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // VP: confirm that Global Menu button is available...
	    try {
	      assertTrue(isElementPresent(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: navigate back to the Opportunity view...
	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Opportunity".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: click the Close Prob edit button...
	    driver.findElement(By.cssSelector("#Mobile_SalesLogix_Fields_PicklistField_19 > button.button.simpleSubHeaderButton")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Opportunity Probability".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // VP: confirm that Global Menu button is available...
	    try {
	      assertTrue(isElementPresent(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: navigate back to the Opportunity view...
	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Opportunity".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: click the Code edit button...
	    driver.findElement(By.cssSelector("#Sage_Platform_Mobile_Fields_LookupField_11 > button.button.simpleSubHeaderButton")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Exchange Rates".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // VP: confirm that Global Menu button is available...
	    try {
	      assertTrue(isElementPresent(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: navigate back to the Opportunity view...
	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Opportunity".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: click the top Cancel button...
	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if (!"Opportunity".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: navigate back...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Opportunities".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("My Activities".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // -- END
	}
	
	@Test
	public void test11_SeTestTCGlobalMenuEditOppProductScreens() throws Exception {
	    // SETest-GlobalMenu_EditOppProduct_Screens
	    // Version: 2.2
	    // Desc: Confirms that the toggle button (left and right) for Global Menu access is visible on screens accessible under the Edit Opportunity-Product screens...
	    // Note: This test script can be used as a template for completing/editing an Opportunity-Product.
	    // Condition(s): Test user is logged in.    
	    // ==================================================================
	    // Step: click Top-Left button to reveal Global Menu...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[1]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if (isElementPresent(By.xpath(".//*[@id='Mobile_SalesLogix_SpeedSearchWidget_0']/div/div[1]/input"))) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: navigate to Opportunity list view...
	    driver.findElement(By.xpath(".//*[@id='left_drawer']/descendant::*[text() = \"Opportunities\"]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if (isElementPresent(By.xpath(".//*[@id='opportunity_list']/ul/li[1]"))) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: perform search for Opportunity records...
	    driver.findElement(By.cssSelector("#Sage_Platform_Mobile_SearchWidget_11 > div.table-layout > div > input[name=\"query\"]")).clear();
	    driver.findElement(By.cssSelector("#Sage_Platform_Mobile_SearchWidget_11 > div.table-layout > div > input[name=\"query\"]")).sendKeys("Abbott WorldWide");
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
	    	try { if (!"Opportunities".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // VP: confirm that Global Menu button is available...
	    try {
	      assertTrue(isElementPresent(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: click the Products link...
	    driver.findElement(By.xpath("//div[@id='opportunity_detail']/div[2]/ul[2]/li/a/span")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Products".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: click the top Add buton...
	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[2]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Opportunity Product".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // VP: confirm that Global Menu button is available...
	    try {
	      assertTrue(isElementPresent(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: click the Product edit button...
	    driver.findElement(By.cssSelector("#Sage_Platform_Mobile_Fields_LookupField_14 > button.button.simpleSubHeaderButton")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Products".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // VP: confirm that Global Menu button is available...
	    try {
	      assertTrue(isElementPresent(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: click and select the top Product item...
	    driver.findElement(By.cssSelector("#product_related > ul.list-content > li > div.list-item-content > h3")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Opportunity Product".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: click the Price Level edit button...
	    driver.findElement(By.cssSelector("#Sage_Platform_Mobile_Fields_LookupField_15 > button.button.simpleSubHeaderButton")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Product Programs".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // VP: confirm that Global Menu button is available...
	    try {
	      assertTrue(isElementPresent(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: click the top Cancel button...
	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Opportunity Product".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: click the top Cancel button...
	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Products".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: navigate back...
	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if (!"Products".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
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
	public void test12_SeTestTCGlobalMenuEditTicketScreens() throws Exception {
	    // SETest-GlobalMenu_EditTicket_Screens
	    // Version: 2.2
	    // Desc: Confirms that the toggle button (left and right) for Global Menu access is visible on screens accessible under the Ticket edit screens...
	    // Note: This test script can be used as a template for completing/editing an Ticket.
	    // Condition(s): Test user is logged in.    
	    // ==================================================================
	    // Step: click Top-Left button to reveal Global Menu...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[1]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if (isElementPresent(By.xpath(".//*[@id='myactivity_list']/ul/li[1]/div[2]/h3/span[3]"))) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: navigate to Tickets list view...
	    driver.findElement(By.xpath(".//*[@id='left_drawer']/descendant::*[text() = \"Tickets\"]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if (isElementPresent(By.xpath(".//*[@id='ticket_list']/ul/li[1]"))) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: perform search for Opportunity records...
	    driver.findElement(By.cssSelector("#Sage_Platform_Mobile_SearchWidget_18 > div.table-layout > div > input[name=\"query\"]")).clear();
	    driver.findElement(By.cssSelector("#Sage_Platform_Mobile_SearchWidget_18 > div.table-layout > div > input[name=\"query\"]")).sendKeys("000-00-000011");
	    driver.findElement(By.cssSelector("#Sage_Platform_Mobile_SearchWidget_18 > div.table-layout > div.hasButton > button.subHeaderButton.searchButton")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if (isElementPresent(By.xpath(".//*[@id='ticket_list']/ul/li[1]"))) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: navigate to top Opportunity record...
	    driver.findElement(By.cssSelector("#ticket_list > ul.list-content > li > div.list-item-content > h3")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if (!"Tickets".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // VP: confirm that Global Menu button is available...
	    try {
	      assertTrue(isElementPresent(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: click the top Edit button...
	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[2]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Ticket".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: click the Contract edit button...
	    driver.findElement(By.cssSelector("#Sage_Platform_Mobile_Fields_LookupField_20 > button.button.simpleSubHeaderButton")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Contracts".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // VP: confirm that Global Menu button is available...
	    try {
	      assertTrue(isElementPresent(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: navigate back to the Opportunity view...
	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Ticket".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: click the Area edit button...
	    driver.findElement(By.cssSelector("#Sage_Platform_Mobile_Fields_LookupField_21 > button.button.simpleSubHeaderButton")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Ticket Area".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // VP: confirm that Global Menu button is available...
	    try {
	      assertTrue(isElementPresent(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: navigate back to the Opportunity view...
	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Ticket".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: click the Category edit button...
	    driver.findElement(By.cssSelector("#Sage_Platform_Mobile_Fields_LookupField_22 > button.button.simpleSubHeaderButton")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Ticket Category".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // VP: confirm that Global Menu button is available...
	    try {
	      assertTrue(isElementPresent(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: navigate back to the Opportunity view...
	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Ticket".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: click the Issue edit button...
	    driver.findElement(By.cssSelector("#Sage_Platform_Mobile_Fields_LookupField_23 > button.button.simpleSubHeaderButton")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Ticket Issue".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // VP: confirm that Global Menu button is available...
	    try {
	      assertTrue(isElementPresent(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: navigate back to the Opportunity view...
	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Ticket".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: click the Source edit button...
	    driver.findElement(By.cssSelector("#Mobile_SalesLogix_Fields_PicklistField_24 > button.button.simpleSubHeaderButton")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Source".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // VP: confirm that Global Menu button is available...
	    try {
	      assertTrue(isElementPresent(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: navigate back to the Opportunity view...
	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Ticket".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: click the Status edit button...
	    driver.findElement(By.cssSelector("#Mobile_SalesLogix_Fields_PicklistField_25 > button.button.simpleSubHeaderButton")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Ticket Status".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // VP: confirm that Global Menu button is available...
	    try {
	      assertTrue(isElementPresent(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: navigate back to the Opportunity view...
	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Ticket".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: click the Urgency edit button...
	    driver.findElement(By.cssSelector("#Sage_Platform_Mobile_Fields_LookupField_24 > button.button.simpleSubHeaderButton")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Ticket Urgency".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // VP: confirm that Global Menu button is available...
	    try {
	      assertTrue(isElementPresent(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: navigate back to the Opportunity view...
	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Ticket".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: click the Description edit button...
	    driver.findElement(By.cssSelector("#Sage_Platform_Mobile_Fields_NoteField_3 > button.button.simpleSubHeaderButton")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Description".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // VP: confirm that Global Menu button is available...
	    try {
	      assertTrue(isElementPresent(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: navigate back to the Opportunity view...
	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Ticket".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: click the Resolution edit button...
	    driver.findElement(By.cssSelector("#Sage_Platform_Mobile_Fields_NoteField_4 > button.button.simpleSubHeaderButton")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Resolution".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // VP: confirm that Global Menu button is available...
	    try {
	      assertTrue(isElementPresent(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: navigate back to the Opportunity view...
	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Ticket".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: click the Comments edit button...
	    driver.findElement(By.cssSelector("#Sage_Platform_Mobile_Fields_NoteField_5 > button.button.simpleSubHeaderButton")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Comments".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // VP: confirm that Global Menu button is available...
	    try {
	      assertTrue(isElementPresent(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: navigate back to the Opportunity view...
	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Ticket".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: click the top Cancel button...
	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if (!"Ticket".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: navigate back...
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
	
	@Test
	public void test13_SeTestTCGlobalMenuItemCheck() throws Exception {
	    // SETest-GlobalMenu_ItemCheck
	    // Version: 2.2
	    // Desc: Opens the Global Menu and verifies each of the expected menu items.
	    // Condition(s): Test user is logged in.    
	    // ==================================================================
	    // Step: click Top-Left button to reveal Global Menu...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[1]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if (isElementPresent(By.xpath(".//*[@id='myactivity_list']/ul/li[1]/div[2]/h3/span[3]"))) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // VP: check  the SpeedSearch bar...
	    try {
	      assertTrue(isElementPresent(By.cssSelector("#Mobile_SalesLogix_SpeedSearchWidget_0 > label")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    try {
	      assertTrue(isElementPresent(By.cssSelector("#Mobile_SalesLogix_SpeedSearchWidget_0 > div.table-layout > div.hasButton > button.subHeaderButton.searchButton")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // VP: check the Quick Actions section and items...
	    try {
	      assertTrue(isElementPresent(By.cssSelector("div.group-content > h2")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    try {
	      assertTrue(isElementPresent(By.cssSelector("div.group-content > h2 > button.collapsed-indicator")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    try {
	      assertTrue(isElementPresent(By.cssSelector("div.group-content > ul.list-content. > li > div.list-item-static-selector > img.icon")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    try {
	      assertTrue(isElementPresent(By.cssSelector("div.group-content > ul.list-content. > li > div.list-item-content > h3")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // VP: check the Go To section and items...
	    try {
	      assertTrue(isElementPresent(By.xpath("//div[@id='left_drawer']/div[3]/h2[2]")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    try {
	      assertTrue(isElementPresent(By.xpath("//div[@id='left_drawer']/div[3]/ul[2]/li/div[2]/h3")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    try {
	      assertTrue(isElementPresent(By.xpath("(//img[@alt='icon'])[4]")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    try {
	      assertTrue(isElementPresent(By.xpath("//div[@id='left_drawer']/div[3]/ul[2]/li[2]/div[2]/h3")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    try {
	      assertTrue(isElementPresent(By.xpath("(//img[@alt='icon'])[5]")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    try {
	      assertTrue(isElementPresent(By.xpath("//div[@id='left_drawer']/div[3]/ul[2]/li[3]/div[2]/h3")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    try {
	      assertTrue(isElementPresent(By.xpath("(//img[@alt='icon'])[6]")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    try {
	      assertTrue(isElementPresent(By.xpath("//div[@id='left_drawer']/div[3]/ul[2]/li[4]/div[2]/h3")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    try {
	      assertTrue(isElementPresent(By.xpath("(//img[@alt='icon'])[7]")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    try {
	      assertTrue(isElementPresent(By.xpath("//div[@id='left_drawer']/div[3]/ul[2]/li[5]/div[2]/h3")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    try {
	      assertTrue(isElementPresent(By.xpath("(//img[@alt='icon'])[8]")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    try {
	      assertTrue(isElementPresent(By.xpath("//div[@id='left_drawer']/div[3]/ul[2]/li[6]/div[2]/h3")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    try {
	      assertTrue(isElementPresent(By.xpath("(//img[@alt='icon'])[9]")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    try {
	      assertTrue(isElementPresent(By.xpath("//div[@id='left_drawer']/div[3]/ul[2]/li[7]/div[2]/h3")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    try {
	      assertTrue(isElementPresent(By.xpath("(//img[@alt='icon'])[10]")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    try {
	      assertTrue(isElementPresent(By.xpath("//div[@id='left_drawer']/div[3]/ul[2]/li[8]/div[2]/h3")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // VP: check the Quick Actions section and items...
	    try {
	      assertTrue(isElementPresent(By.xpath("//div[@id='left_drawer']/div[3]/h2[3]")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    try {
	      assertTrue(isElementPresent(By.xpath("//div[@id='left_drawer']/div[3]/h2[3]/button")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    try {
	      assertTrue(isElementPresent(By.xpath("(//img[@alt='icon'])[11]")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    try {
	      assertTrue(isElementPresent(By.xpath("//div[@id='left_drawer']/div[3]/ul[3]/li/div[2]/h3")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    try {
	      assertTrue(isElementPresent(By.xpath("(//img[@alt='icon'])[12]")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    try {
	      assertTrue(isElementPresent(By.xpath("//div[@id='left_drawer']/div[3]/ul[3]/li[2]/div[2]/h3")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    try {
	      assertTrue(isElementPresent(By.xpath("(//img[@alt='icon'])[13]")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    try {
	      assertTrue(isElementPresent(By.xpath("//div[@id='left_drawer']/div[3]/ul[3]/li[3]/div[2]/h3")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    try {
	      assertTrue(isElementPresent(By.xpath("(//img[@alt='icon'])[14]")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    try {
	      assertTrue(isElementPresent(By.xpath("//div[@id='left_drawer']/div[3]/ul[3]/li[4]/div[2]/h3")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: click the Top-Left button to close the Global Menu...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[1]")).click();
	    // -- END
	}

	@Test
	public void test14_SeTestTCGlobalMenuOpenAttachments() throws Exception {
	    // SE Test: SETest-GlobalMenu_OpenAttachments
	    // Version: 2.2
	    // Desc: Opens various Attachment file types from the My Attachments list view..
	    // Setup: Configure browser to automatically save downloaded items instead of using any viewers.
	    // Condition(s): Test user is logged in.    
	    // ==================================================================
	    // Step: click Top-Left button to reveal Global Menu...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[1]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if (isElementPresent(By.xpath(".//*[@id='myactivity_list']/ul/li[1]/div[2]/h3/span[3]"))) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: navigate to Attachments list view...
	    driver.findElement(By.xpath(".//*[@id='left_drawer']/descendant::*[text() = \"My Attachments\"]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if (isElementPresent(By.xpath(".//*[@id='myattachment_list']/ul/li[1]"))) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: open a .jpg Attachment...
	    driver.findElement(By.linkText("bluepencil")).click();
	    // Step: open a .log Attachment...
	    driver.findElement(By.linkText("DtcInstall")).click();
	    // Step: open an .ini Attachment...
	    driver.findElement(By.linkText("win")).click();
	    // Step: open an .xlsx Attachment...
	    driver.findElement(By.linkText("AttachmentsMatrix2")).click();
	    // Step: open an .xml Attachment...
	    driver.findElement(By.linkText("Enterprise")).click();
	    // Step: open an .rtf Attachment...
	    driver.findElement(By.linkText("WeirdChar")).click();
	    // Step: open an .pdf Attachment...
	    driver.findElement(By.linkText("Sage SalesLogix Client OLE DB Provider Installation")).click();
	    // Step: open an .doc Attachment...
	    driver.findElement(By.linkText("ComboBoxRows")).click();
	    // Step: open an .pptx Attachment...
	    driver.findElement(By.linkText("Trinity - Mobile v2_1 - What's New")).click();
	    // Step: open an .wav Attachment...
	    driver.findElement(By.linkText("lightsaber_01")).click();
	    // Step: navigate back...
	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("My Activities".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // -- END
	}
	
	@Test
	public void test15_SeTestTCGlobalMenuSearchAttachments() throws Exception {
	    // SE Test: SETest-GlobalMenu_SearchAttachments
	    // Version: 2.2
	    // Desc: Opens the Global Menu, accesses the My Attachments list view then performs an Attachment search...
	    // Condition(s): Test user is logged in.    
	    // ==================================================================
	    // Step: click Top-Left button to reveal Global Menu...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[1]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if (isElementPresent(By.xpath(".//*[@id='Mobile_SalesLogix_SpeedSearchWidget_0']/div/div[1]/input"))) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: navigate to Attachments list view...
	    driver.findElement(By.xpath(".//*[@id='left_drawer']/descendant::*[text() = \"My Attachments\"]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if (isElementPresent(By.xpath(".//*[@id='myattachment_list']/ul/li[1]"))) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: perform search for Attachment records...
	    driver.findElement(By.cssSelector("#Sage_Platform_Mobile_SearchWidget_35 > div.table-layout > div > input[name=\"query\"]")).clear();
	    driver.findElement(By.cssSelector("#Sage_Platform_Mobile_SearchWidget_35 > div.table-layout > div > input[name=\"query\"]")).sendKeys("Plate");
	    driver.findElement(By.cssSelector("#Sage_Platform_Mobile_SearchWidget_35 > div.table-layout > div.hasButton > button.subHeaderButton.searchButton")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if (isElementPresent(By.xpath(".//*[@id='myattachment_list']/ul/li[1]"))) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: navigate to top Attachment record...
	    // Warning: verifyTextPresent may require manual changes
	    try {
	      assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Plate[\\s\\S]*$"));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: navigate back...
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
