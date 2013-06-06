package argos.saleslogix.selenium.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.testng.AssertJUnit;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
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

public class UnitTestX extends BrowserSetup {
	
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
		Thread.sleep(1000);
		assertEquals("SalesLogix", driver.getTitle());
		
		//VP: Login Page Name
		Thread.sleep(1000);
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
		Thread.sleep(3000);
		try {
			AssertJUnit.assertEquals("My Activities", driver.findElement(By.id("pageTitle")).getAttribute("text"));
			AssertJUnit.assertTrue(driver.findElement(By.id("css=#myactivity_list > ul.list-content > li")).isDisplayed());
		} catch (Error e) {     
			System.out.println("Verify 'My Activities' screen Displays" + e.toString());
		}
	}
	
	@Test
	  public void test34_MobileDefect13092056() throws Exception {
	    // SETest-Defect_13092056
	    // Version: 2.2
	    // Desc: Confirms that the Attachments feature is functional from Notes screens...
	    // Required Entities: Contact - Adi, Douglas; Account - TriCom International
	    // Condition(s): Test user 'Dan' is logged in.    
	    // ==================================================================
	    // - Start Section
	    // Step: click Top-Left button to reveal Global Menu...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[1]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if (isElementPresent(By.xpath(".//*[@id='Mobile_SalesLogix_SpeedSearchWidget_0']/div/div[1]/input"))) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	    Thread.sleep(1000);
	
	    // Step: navigate to Contacts list view...
	    driver.findElement(By.xpath(".//*[@id='left_drawer']/descendant::*[text() = 'Contacts']")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if (isElementPresent(By.xpath(".//*[@id='contact_list']/ul/li[1]"))) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // Step: perform search for Contact item...
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_SearchWidget_6']/div/div[1]/input")).clear();
	    Thread.sleep(1000);
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_SearchWidget_6']/div/div[1]/input")).sendKeys("Adi");
	    Thread.sleep(1000);
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_SearchWidget_6']/div/div[3]/button")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if (isElementPresent(By.xpath(".//*[@id='contact_list']/ul/li[1]"))) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // Warning: verifyTextPresent may require manual changes
	    try {
	      assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Adi, Douglas[\\s\\S]*$"));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: navigate to top Contact record...
	    driver.findElement(By.xpath(".//*[@id='contact_list']/ul/li/div/h3")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Adi, Douglas".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // VP: confirm that Attachments is available under the Related Items section...
	    try {
	      assertTrue(isElementPresent(By.xpath(".//*[@id='contact_detail']/div[2]/ul[2]/li[6]/a/img")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    try {
	      assertEquals("Attachments", driver.findElement(By.xpath(".//*[@id='contact_detail']/div[2]/ul[2]/li[6]/a/span")).getText());
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: click the Attachments link...
	    driver.findElement(By.xpath(".//*[@id='contact_detail']/div[2]/ul[2]/li[6]/a/span")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Contact Attachments".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
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
	    
	    // Step: click the 'add a file' section of the screen...
	    String filepath = "C://uploadtest.txt";
	    driver.findElement(By.xpath(".//*[@id='attachment_Add']/div[1]/div/div/input")).sendKeys(filepath);
	    Thread.sleep(2000);	    
	    
	    // Step: setup a unique, time-based file name for the uploaded file...
	    String newfilename = "upload." + new SimpleDateFormat("yyMMddHHmm").format(new GregorianCalendar().getTime()) + ".txt";
	    driver.findElement(By.id("File_0")).clear();
	    Thread.sleep(1000);
	    driver.findElement(By.id("File_0")).sendKeys(newfilename);
	    Thread.sleep(1000);
	    
	    // Step: proceed with file upload...
	    driver.findElement(By.id("fileSelect-btn-upload")).click();
	    
	    // Verify: upload progress indicator is displayed...
	    /*
	    try {
	        assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Uploading[\\s\\S]*$"));
	      } catch (Error e) {
	        verificationErrors.append(e.toString());
	    }
	    */
	    
	    // Step: verify that new attachment appears in the Contact Attachments list view...
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Contact Attachments".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // Warning: verifyTextPresent may require manual changes
	    try {
	      assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*" + newfilename + "[\\s\\S]*$"));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // -- End Section
	    
	    // - Start Section
	    // Step: navigate back to Contact detail view...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Adi, Douglas".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // Step: navigate to associated Account detail view..
	    driver.findElement(By.xpath(".//*[@id='contact_detail']/div[2]/div[1]/div[2]/span/a")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("TriCom International".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // Step: navigate to the Account Attachments list view...
	    driver.findElement(By.xpath(".//*[@id='account_detail']/div[2]/ul[2]/li[7]/a/span")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Account Attachments".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // Step: perform search of Attachment added from associated Contact detail view...
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_SearchWidget_36']/div/div[1]/input")).clear();
	    Thread.sleep(1000);
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_SearchWidget_36']/div/div[1]/input")).sendKeys(newfilename);
	    Thread.sleep(1000);
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_SearchWidget_36']/div/div[1]/input")).click();
	    
	    // VP: verify that the Attachment item is found
	    // Warning: verifyTextPresent may require manual changes
	    try {
	      assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*" + newfilename + "[\\s\\S]*$"));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    
	    // Step: navigate back to My Activities view...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[1]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if (isElementPresent(By.xpath(".//*[@id='Mobile_SalesLogix_SpeedSearchWidget_0']/div/div[1]/input"))) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // Step: navigate to Contacts list view...
	    driver.findElement(By.xpath(".//*[@id='left_drawer']/descendant::*[text() = 'My Activities']")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if (isElementPresent(By.xpath(".//*[@id='myactivity_list']/ul/li[1]"))) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // - End Section
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
