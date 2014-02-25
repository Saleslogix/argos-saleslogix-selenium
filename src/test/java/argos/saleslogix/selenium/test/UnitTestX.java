package argos.saleslogix.selenium.test;

import static org.testng.AssertJUnit.assertEquals;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.testng.AssertJUnit;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import argos.saleslogix.selenium.test.CommonNavigation;
import argos.saleslogix.selenium.test.HeaderButton;
import argos.saleslogix.selenium.test.SLXMobileLogin;
import argos.saleslogix.selenium.test.BrowserSetup;

public class UnitTestX extends BrowserSetup {
	
	CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
	
	public String getKPICardValue(String fullKPICardVal) {
		
		String[] segStrArray = fullKPICardVal.split("\n");
		String cardValue = segStrArray[1];
	
		return cardValue;
	}


	public void checkGlobalMenuStatus(String resultMsg) {
		HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);
		
	    try {
	    	AssertJUnit.assertTrue(headerButton.globalMenuButton.isDisplayed());
	    	System.out.println(resultMsg + " - Passed");
	    } catch (Error e) {
	    	verificationErrors.append(e.toString());
	    	System.out.println(resultMsg + " - Failed");
	    }
	}


	//Login & Logout
	//==============
	@Test(enabled = true)
	public void test00_MobileClient_Login() throws InterruptedException {
		String methodID = "test00_MobileClient_Login";
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
		
		doVerificationLogin();
		
		System.out.println(ENDLINE);	
	}
	

	@Test(enabled = true)
	public void test99_Mobile_LogOut()  throws InterruptedException {				
		String methodID = "test99_Mobile_LogOut";
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
		
		doVerificationLogout();
		
		System.out.println(ENDLINE);
	}


	//TODO: need to update test53_MobileDefect13092153() needs an update for 2.3
	@Test (enabled = false)
	public void test53_MobileDefect13092153() throws Exception {
		String methodID = "test53_MobileDefect13092153";
	
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
		
	    // - Start Section
	    // Step: click Top-Left button to reveal Global Menu...
	    driver.findElement(By.xpath("//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[1]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) AssertJUnit.fail("timeout");
	    	try { if (isElementPresent(By.xpath("//*[@id='Mobile_SalesLogix_SpeedSearchWidget_0']/div/div[1]/input"))) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	    Thread.sleep(1000);
	
	    // Step: navigate to Leads list view...
	    driver.findElement(By.xpath("//*[@id='left_drawer']/descendant::*[text() = 'Leads']")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) AssertJUnit.fail("timeout");
	    	try { if (isElementPresent(By.xpath("//*[@id='lead_list']/ul/li[1]"))) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // Step: perform search for the 1st-Lead record...
	    driver.findElement(By.xpath("//*[@id='Sage_Platform_Mobile_SearchWidget_16']/div/div[1]/input")).clear();
	    Thread.sleep(500);
	    driver.findElement(By.xpath("//*[@id='Sage_Platform_Mobile_SearchWidget_16']/div/div[1]/input")).sendKeys("Ballard");
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("//*[@id='Sage_Platform_Mobile_SearchWidget_16']/div/div[3]/button")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) AssertJUnit.fail("timeout");
	    	try { if (isElementPresent(By.xpath("//*[@id='lead_list']/ul/li[1]"))) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	    try {
	      AssertJUnit.assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Ballard, Matt[\\s\\S]*$"));
	    } catch (Error e) {
	      verificationErrors.append(methodID + "(): " + e.toString());
	    }
	    
	    // Step: navigate to top Lead record...
	    driver.findElement(By.xpath("//*[@id='lead_list']/ul/li/div/h3")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) AssertJUnit.fail("timeout");
	    	try { if ("Ballard, Matt".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	    
	    // Step: click the Activities link...
	    driver.findElement(By.xpath("//*[@id='lead_detail']/descendant::*[text() = 'Activities']")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) AssertJUnit.fail("timeout");
	    	try { if ("Activities".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	    
	    // Step: click to open the top Activities item...
	    driver.findElement(By.xpath("//*[@id='activity_related']/ul/li/div[2]/h3/span")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) AssertJUnit.fail("timeout");
	    	try { if (!"Activities".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }	    
	    
	    // Step: click the Attachments link...
	    driver.findElement(By.xpath("//*[@id='activity_detail']/div[2]/ul[2]/li/a/span")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) AssertJUnit.fail("timeout");
	    	try { if ("Activity Attachments".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	    	
	    // Step: click the top Add button...
	    driver.findElement(By.xpath("//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[2]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) AssertJUnit.fail("timeout");
	    	try { if ("Add Attachments".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
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
	    
	    // Step: verify that new attachment appears in the Lead Attachments list view...
	    for (int second = 0;; second++) {
	    	if (second >= 60) AssertJUnit.fail("timeout");
	    	try { if ("Activity Attachments".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	    try {
	    	AssertJUnit.assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*" + newfilename + "[\\s\\S]*$"));
	    } catch (Error e) {
	      verificationErrors.append(methodID + "(): " + e.toString());
	    }
	    // -- End Section
	    
	    // Step: navigate back to Lead detail view...
	    driver.findElement(By.xpath("//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) AssertJUnit.fail("timeout");
	    	try { if (!"Activity Attachments".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	    driver.findElement(By.xpath("//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) AssertJUnit.fail("timeout");
	    	try { if ("Activities".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	    driver.findElement(By.xpath("//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) AssertJUnit.fail("timeout");
	    	try { if ("Ballard, Matt".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // Step: navigate to the Lead Attachments list view...
	    driver.findElement(By.xpath("//*[@id='lead_detail']/descendant::*[text() = 'Attachments']")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) AssertJUnit.fail("timeout");
	    	try { if ("Lead Attachments".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	    
	    // VP: verify that the Attachment item is found
	    try {
	    	AssertJUnit.assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*" + newfilename + "[\\s\\S]*$"));
	    } catch (Error e) {
	      verificationErrors.append(methodID + "(): " + e.toString());
	    }
	    
	    // Step: navigate back to My Activities view...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[1]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) AssertJUnit.fail("timeout");
	    	try { if (isElementPresent(By.xpath(".//*[@id='Mobile_SalesLogix_SpeedSearchWidget_0']/div/div[1]/input"))) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	    driver.findElement(By.xpath(".//*[@id='left_drawer']/descendant::*[text() = 'My Activities']")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) AssertJUnit.fail("timeout");
	    	try { if (isElementPresent(By.xpath(".//*[@id='myactivity_list']/ul/li[1]"))) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	    System.out.println(ENDLINE);	
	    // - End Section
	    // -- END
	}

}
