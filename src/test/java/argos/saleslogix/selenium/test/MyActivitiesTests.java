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

public class MyActivitiesTests extends BrowserSetup {

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
	public void test01_SeTestTCMyActivitiesAddNew() throws Exception {
	    // SE Test: SETest-TC-MyActivities-AddNew
	    // Version: 2.2
	    // Desc: validates that a new Activity can be scheduled from the My Activities list view...
	    // Pre-Run Steps: Logoff, then Log back in as 'Lee'...
	    // Required Entity: Contact - Douglas Adi
	    // ====================================
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
	    	try { if ("My Activities".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[2]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Schedule...".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    driver.findElement(By.xpath(".//*[@id='activity_types_list']/descendant::*[text()=\"Meeting\"]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Meeting".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    driver.findElement(By.cssSelector("#Mobile_SalesLogix_Fields_PicklistField_28 > button.button.simpleSubHeaderButton")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Activity Description".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    driver.findElement(By.xpath(".//*[@id='pick_list_0']/descendant::*[text()=\"Lunch meeting\"]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Meeting".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    driver.findElement(By.cssSelector("input[name=\"Location\"]")).clear();
	    driver.findElement(By.cssSelector("input[name=\"Location\"]")).sendKeys("TSR Resort");
	    driver.findElement(By.cssSelector("#Mobile_SalesLogix_Fields_PicklistField_30 > button.button.simpleSubHeaderButton")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Activity Category".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    driver.findElement(By.xpath(".//*[@id='pick_list_0']/descendant::*[text()=\"Other Visit\"]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Meeting".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    driver.findElement(By.cssSelector("#Sage_Platform_Mobile_Fields_DateField_8 > button.button.whiteButton")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Calendar".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    driver.findElement(By.xpath(".//*[@id='datetime-picker-date']/tbody/tr[1]/td[1]/button")).click();
	    new Select(driver.findElement(By.id("day-field"))).selectByVisibleText("15");
	    new Select(driver.findElement(By.id("hour-field"))).selectByVisibleText("12");
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[2]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Meeting".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    driver.findElement(By.cssSelector("#Sage_Platform_Mobile_Fields_DurationField_0 > button.button.simpleSubHeaderButton")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Duration".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    driver.findElement(By.xpath(".//*[@id='select_list']/descendant::*[text()=\"1 hour\"]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Meeting".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    driver.findElement(By.cssSelector("#Sage_Platform_Mobile_Fields_NoteField_6 > button.button.simpleSubHeaderButton")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Notes".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    driver.findElement(By.cssSelector("textarea[name=\"Notes\"]")).clear();
	    driver.findElement(By.cssSelector("textarea[name=\"Notes\"]")).sendKeys("test activity for SETest-TC-MyActivities-AddNew");
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[2]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Meeting".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_Fields_LookupField_29']/button")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Contacts".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_SearchWidget_7']/div/div[1]/input")).clear();
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_SearchWidget_7']/div/div[1]/input")).sendKeys("Adi");
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_SearchWidget_7']/div/div[3]/button")).click();
	    driver.findElement(By.xpath(".//*[@id='contact_related']/ul/li/div/h3")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Meeting".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // Step: click top right Save button...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[2]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("My Activities".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // VP: check to see that newly-scheduled Activity is listed...
	    assertEquals(" Lunch meeting", driver.findElement(By.xpath(".//*[@id='myactivity_list']/ul/li[1]/div[2]/h3/span[3]")).getText());
	    // Verify: click the Activity icon to see that the Complete & Call actions are available in the actions panel...
	    driver.findElement(By.xpath(".//*[@id='myactivity_list']/ul/li[1]/div[1]/img")).click();
	    try {
	      assertTrue(isElementPresent(By.xpath(".//*[@id='myactivity_list']/ul/li[2]")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    try {
	      assertTrue(isElementPresent(By.xpath(".//*[@id='myactivity_list']/ul/li[2]/button[1]")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    try {
	      assertTrue(isElementPresent(By.xpath(".//*[@id='myactivity_list']/ul/li[2]/button[4]")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: click the Activity icon to close the available actions panel...
	    driver.findElement(By.xpath(".//*[@id='myactivity_list']/ul/li[1]/div[1]/img")).click();
	    // -- END
	}
	
	@Test
	public void test02_SeTestTCMyActivitiesComplete() throws Exception {
	    // SE Test: SETest-TC-MyActivities-Complete
	    // Version: 2.2
	    // Desc: validates that an Activity can be completed from the My Activities list view...
	    // Pre-Run Steps: Logoff, then Log back in as 'Lee'...
	    // Required Entity: Contact - Douglas Adi
	    // ====================================
	    // - Start Section
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
	    	try { if (isElementPresent(By.xpath(".//*[@id='myactivity_list']/ul"))) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[2]")).click();
	    assertEquals("Schedule...", driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText());
	    driver.findElement(By.xpath(".//*[@id='activity_types_list']/descendant::*[text()=\"Meeting\"]")).click();
	    assertEquals("Meeting", driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText());
	    driver.findElement(By.cssSelector("#Mobile_SalesLogix_Fields_PicklistField_28 > button.button.simpleSubHeaderButton")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Activity Description".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    driver.findElement(By.xpath(".//*[@id='pick_list_0']/descendant::*[text()=\"Breakfast meeting\"]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Meeting".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    driver.findElement(By.cssSelector("input[name=\"Location\"]")).clear();
	    driver.findElement(By.cssSelector("input[name=\"Location\"]")).sendKeys("The Cafe");
	    driver.findElement(By.cssSelector("#Mobile_SalesLogix_Fields_PicklistField_30 > button.button.simpleSubHeaderButton")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Activity Category".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    driver.findElement(By.xpath(".//*[@id='pick_list_0']/descendant::*[text()=\"Other Visit\"]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Meeting".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    driver.findElement(By.cssSelector("#Sage_Platform_Mobile_Fields_DateField_8 > button.button.whiteButton")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Calendar".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    driver.findElement(By.xpath(".//*[@id='datetime-picker-date']/tbody/tr[1]/td[1]/button")).click();
	    driver.findElement(By.xpath(".//*[@id='datetime-picker-date']/tbody/tr[1]/td[1]/button")).click();
	    new Select(driver.findElement(By.id("day-field"))).selectByVisibleText("15");
	    new Select(driver.findElement(By.id("hour-field"))).selectByVisibleText("07");
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[2]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Meeting".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    driver.findElement(By.cssSelector("#Sage_Platform_Mobile_Fields_DurationField_0 > button.button.simpleSubHeaderButton")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Duration".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    driver.findElement(By.xpath(".//*[@id='select_list']/descendant::*[text()=\"1 hour\"]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Meeting".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    driver.findElement(By.cssSelector("#Sage_Platform_Mobile_Fields_NoteField_6 > button.button.simpleSubHeaderButton")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Notes".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    driver.findElement(By.cssSelector("textarea[name=\"Notes\"]")).clear();
	    driver.findElement(By.cssSelector("textarea[name=\"Notes\"]")).sendKeys("test activity for SETest-TC-MyActivities-Complete");
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[2]")).click();
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_Fields_LookupField_29']/button")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Contacts".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_SearchWidget_7']/div/div[1]/input")).clear();
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_SearchWidget_7']/div/div[1]/input")).sendKeys("Adi");
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_SearchWidget_7']/div/div[3]/button")).click();
	    driver.findElement(By.xpath(".//*[@id='contact_related']/ul/li/div/h3")).click();
	    
	    // Step: click the top-right Save button...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[2]")).click();
	    Thread.sleep(3000);
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("My Activities".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // VP: verify that newly-scheduled Activity is listed...
	    try {
	      assertEquals("Breakfast meeting", driver.findElement(By.xpath(".//*[@id='myactivity_list']/ul/li[1]/div[2]/h3/span[3]")).getText());
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Verify: click the Activity icon to see that the Complete & Call actions are available in the actions panel...
	    driver.findElement(By.xpath(".//*[@id='myactivity_list']/ul/li[1]/div[1]/img")).click();
	    try {
	      assertTrue(isElementPresent(By.xpath(".//*[@id='myactivity_list']/ul/li[2]")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    try {
	      assertTrue(isElementPresent(By.xpath(".//*[@id='myactivity_list']/ul/li[2]/button[1]")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: click the Complete action icon...
	    driver.findElement(By.xpath(".//*[@id='myactivity_list']/ul/li[1]/div[2]/h3/span[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Activity".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // Step: complete the Activity...
	    driver.findElement(By.xpath(".//*[@id='activity_detail']/div[2]/ul/li/a/label")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Complete Activity".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[2]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("My Activities".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // Warning: verifyTextNotPresent may require manual changes
	    try {
	      assertFalse(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*XPath=\\.//[\\s\\S]*\\[@id='myactivity_list'\\]/ul/li\\[1\\]/div\\[2\\]/h3/span\\[3\\][\\s\\S]*$"));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // - End Section
	    // - Start Section
	    // Step: click Top-Left button to reveal Global Menu...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[1]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if (isElementPresent(By.xpath(".//*[@id='Mobile_SalesLogix_SpeedSearchWidget_0']/div/div[1]/input"))) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // Step: navigate to My Activities list view...
	    driver.findElement(By.xpath(".//*[@id='left_drawer']/descendant::*[text() = \"Contacts\"]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if (isElementPresent(By.xpath(".//*[@id='contact_list']/ul/li[1]"))) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // Step: navigate to the History list view of the Contact associated with the completed Activity...
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Contacts".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_SearchWidget_6']/div/div[1]/input")).clear();
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_SearchWidget_6']/div/div[1]/input")).sendKeys("Adi");
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_SearchWidget_6']/div/div[3]/button")).click();
	    // Warning: verifyTextPresent may require manual changes
	    try {
	      assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Adi, Douglas[\\s\\S]*$"));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    driver.findElement(By.xpath(".//*[@id='contact_list']/descendant::*[text()=\"Adi, Douglas\"]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Adi, Douglas".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    driver.findElement(By.xpath(".//*[@id='contact_detail']/div[2]/ul[2]/li[4]/a/span")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Notes/History".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // Step: search for the completed Activity in the Notes/History list view...
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_SearchWidget_28']/div/div[1]/input")).clear();
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_SearchWidget_28']/div/div[1]/input")).sendKeys("breakfast meeting");
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_SearchWidget_28']/div/div[3]/button")).click();
	    try {
	      assertEquals("Breakfast meeting", driver.findElement(By.xpath(".//*[@id='history_related']/ul/li[1]/div/h4")).getText());
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    try {
	      assertEquals("test activity for SETest-TC-MyActivities-Complete", driver.findElement(By.xpath(".//*[@id='history_related']/ul/li[1]/div/div/div[1]")).getText());
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // - End Section
	    // Step: go back to My Activities list view...
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
	    	try { if (isElementPresent(By.xpath(".//*[@id='myactivity_list']/ul"))) break; } catch (Exception e) {}
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
