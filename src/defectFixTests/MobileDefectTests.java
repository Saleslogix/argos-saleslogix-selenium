package defectFixTests;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import screenobject.CommonNavigation;
import screenobject.HeaderButton;
import screenobject.NavButton;
import screenobject.SLXMobileLogin;
import setupTest.BrowserSetup;

public class MobileDefectTests extends BrowserSetup {
  
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
	public void test01_MobileDefect12091019() throws Exception {
		// SE Test: SETest-Defect_12091019
		// Version: 2.2
		// Desc: validates that 'elapsed hours' field is used in Ticket Activity - More Details details view
		// Required Entity: Ticket 000-00-000011
		// ====================================
		// Step: click Top-Left button to reveal Global Menu...
		driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[1]")).click();
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if (isElementPresent(By.cssSelector("#Mobile_SalesLogix_SpeedSearchWidget_0 > div.table-layout > div > input[name=\"query\"]"))) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}
		
		// Step: navigate to Tickets list view...
		driver.findElement(By.xpath(".//*[@id='left_drawer']/descendant::*[text() = \"Tickets\"]")).click();
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if (isElementPresent(By.xpath(".//*[@id='ticket_list']/ul/li[1]"))) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}
		
		// Step: perform ticket search...
		driver.findElement(By.cssSelector("#Sage_Platform_Mobile_SearchWidget_18 > div.table-layout > div > input[name=\"query\"]")).clear();
		driver.findElement(By.cssSelector("#Sage_Platform_Mobile_SearchWidget_18 > div.table-layout > div > input[name=\"query\"]")).sendKeys("000-00-000011");
		driver.findElement(By.cssSelector("#Sage_Platform_Mobile_SearchWidget_18 > div.table-layout > div.hasButton > button.subHeaderButton.searchButton")).click();
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if (isElementPresent(By.xpath(".//*[@id='ticket_list']/ul/li"))) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}
		
		// Step: navigate to target Ticket record...
		driver.findElement(By.xpath(".//*[@id='ticket_list']/ul/li/div/h3")).click();
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if ("000-00-000011".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}
		
		// Step: expand Ticket Details - Mote Details section then open Ticket Activities view...
		driver.findElement(By.xpath("//div[@id='ticket_detail']/div[2]/ul[2]/li[2]/a/span")).click();
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if ("Ticket Activities".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}
		
		// Step: click the top Ticket Activity item to open the details view...
		driver.findElement(By.xpath(".//*[@id='ticketactivity_related']/ul/li[1]/div/h3")).click();
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if (isElementPresent(By.xpath(".//*[@id='ticketactivity_detail']/div[2]/div[1]/div[1]"))) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}
		
		// VP: check that "elapsed hours" field is available in the Ticket Activity details view...
		driver.findElement(By.xpath(".//*[@id='ticketactivity_detail']/div[2]/h2[2]/button")).click();
		assertEquals("elapsed hours", driver.findElement(By.xpath(".//*[@id='ticketactivity_detail']/div[2]/div[2]/div[2]/label")).getText());
		// 'Step: navigate back to My Activities...
		driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if ("Ticket Activities".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
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
		// - END
	}
	
	@Test
	public void test02_MobileDefect13091230() throws Exception {
	    // SE Test: SETest-Defect_13091230
	    // Version: 2.2
	    // Desc: validates that a comma is inserted between a city & state within an entity address field
	    // ====================================
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

	    // Step: click "+" button to add a new Contact record...
	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[2]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Contact".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: click the "address" field edit button...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Fields_AddressField_3']/button")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Address".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: click Address - city field selection button...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Fields_PicklistField_8']/button")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("City".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: select city from list...
	    driver.findElement(By.xpath(".//*[@id='pick_list_0']/ul/li[14]/div/h3")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Address".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: click Address - state field selection button...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Fields_PicklistField_9']/button")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("State".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: select state from list...
	    driver.findElement(By.xpath(".//*[@id='pick_list_1']/ul/li[3]/div/h3")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Address".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: click Address - description field selection button...
	    driver.findElement(By.cssSelector("#Mobile_SalesLogix_Fields_PicklistField_7 > button.button.simpleSubHeaderButton")).click();
	    assertEquals("Description", driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText());
	    // Step: select description item...
	    driver.findElement(By.xpath(".//*[@id='pick_list_2']/ul/li[1]/div/h3")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Address".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }	    
	    // Step: click Top - Check button...
	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[2]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Contact".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // VP: check that comma is present within address field value...
	    // Warning: verifyTextPresent may require manual changes
	    try {
	      assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*, [\\s\\S]*$"));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    
	    // 'End: navigate back to Home...
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
	    // -- End
  }	

  @Test
  public void test03_MobileDefect13091433() throws Exception {
	  // SE Test: SETest-Defect_13091433
      // Version: 2.2
      // Desc: validates that the Add Notes view does not initialize  the Notes field with 'null'
      // ====================================
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

      // Step: click "+" button to add a new Note record...
      driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[2]")).click();
      for (int second = 0;; second++) {
    	  if (second >= 60) fail("timeout");
    	  try { if ("Note".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
    	  Thread.sleep(1000);
      }

      // VP: check that 'null' is not pre-populating the Notes field...
      // Warning: verifyTextNotPresent may require manual changes
      try {
        assertFalse(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*null[\\s\\S]*$"));
      } catch (Error e) {
        verificationErrors.append(e.toString());
      }
      // 'End: navigate back to Home...
      driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
      for (int second = 0;; second++) {
          if (second >= 60) fail("timeout");
    	  try { if ("Notes/History".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
    	  Thread.sleep(1000);
      }
      // -- End
  }
  
  @Test
  public void test04_MobileDefect13091665() throws Exception {
	  // SE Test: SETest-Defect_13091665
	  // Version: 2.2
	  // Desc: validates that with multi-currency enabled, no validation that code has been chosen or exchange rate entered, and no way to subsequently edit code/ exch rate/ rate date
	  // Pre-Run Steps: Logoff, then Log back in as 'Lee'...
	  // Required Entity: TBD
	  // ====================================
	  // Step: click Top-Left button to reveal Global Menu...
	  driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[1]")).click();
	  for (int second = 0;; second++) {
	  	  if (second >= 60) fail("timeout");
	      try { if (isElementPresent(By.cssSelector("#Mobile_SalesLogix_SpeedSearchWidget_0 > div.table-layout > div > input[name=\"query\"]"))) break; } catch (Exception e) {}
	      Thread.sleep(1000);
	  }

	  // Step: navigate to Opportunities list view...
	  driver.findElement(By.xpath(".//*[@id='left_drawer']/descendant::*[text() = \"Opportunities\"]")).click();
	  for (int second = 0;; second++) {
	      if (second >= 60) fail("timeout");
	      try { if (isElementPresent(By.xpath(".//*[@id='opportunity_list']/ul/li[1]"))) break; } catch (Exception e) {}
	      Thread.sleep(1000);
	  }

	  // Step: click the Top "+" (Add) button...
	  driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[2]")).click();
	  for (int second = 0;; second++) {
	      if (second >= 60) fail("timeout");
	      try { if ("Opportunity".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	      Thread.sleep(1000);
	  }

	  // Step: setup the opportunity field...
	  driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_Fields_TextField_19']/input")).click();
	  driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_Fields_TextField_19']/input")).clear();
	  driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_Fields_TextField_19']/input")).sendKeys("Advising Group Test Opp 100-1");
	  // Step: click the acct selection button to search for and select an Account...
	  driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_Fields_LookupField_6']/button")).click();
	  for (int second = 0;; second++) {
	      if (second >= 60) fail("timeout");
	      try { if ("Accounts".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	      Thread.sleep(1000);
	  }

	  driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_SearchWidget_4']/div/div[1]/input")).click();
	  driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_SearchWidget_4']/div/div[1]/input")).clear();
	  driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_SearchWidget_4']/div/div[1]/input")).sendKeys("Advising Group");
	  driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_SearchWidget_4']/div/div[3]/button")).click();
	  driver.findElement(By.xpath(".//*[@id='account_related']/ul/li/div/h3")).click();
	  for (int second = 0;; second++) {
	      if (second >= 60) fail("timeout");
	      try { if ("Opportunity".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	      Thread.sleep(1000);
	  }

	  // Step: set the sales potential field value...
	  driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Fields_MultiCurrencyField_0']/input")).clear();
	  driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Fields_MultiCurrencyField_0']/input")).sendKeys("300.00");
	  // Step: click the Top Save button...(without setting Currency code or exchane rate)
	  driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[2]")).click();
	  for (int second = 0;; second++) {
	      if (second >= 60) fail("timeout");
	      try { if ("Opportunities".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	      Thread.sleep(1000);
	  }

	  // Step: perform search for newly-added Opportunity...
	  driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_SearchWidget_11']/div/div[1]/input")).click();
	  driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_SearchWidget_11']/div/div[1]/input")).clear();
	  driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_SearchWidget_11']/div/div[1]/input")).sendKeys("Advising Group Test Opp 100-1");
	  driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_SearchWidget_11']/div/div[3]/button")).click();
	  // Warning: waitForTextPresent may require manual changes
	  for (int second = 0;; second++) {
	      if (second >= 60) fail("timeout");
	      try { if (driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Advising Group Test Opp 100-1[\\s\\S]*$")) break; } catch (Exception e) {}
	      Thread.sleep(1000);
	  }

	  // Step: select and click the Opportunity link...
	  driver.findElement(By.xpath(".//*[@id='opportunity_list']/ul/li/div/h3")).click();
	  for (int second = 0;; second++) {
	      if (second >= 60) fail("timeout");
	      try { if ("Advising Group Test Opp 100-1".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	      Thread.sleep(1000);
	  }

	  // Verify: verify each of the base rate field values...
	  try {
	    assertEquals("300.00 USD", driver.findElement(By.xpath(".//*[@id='opportunity_detail']/div[2]/div[1]/div[8]/span")).getText());
	  } catch (Error e) {
	    verificationErrors.append(e.toString());
	  }
	  try {
	    assertEquals("300.00 USD", driver.findElement(By.xpath(".//*[@id='opportunity_detail']/div[2]/div[1]/div[9]/span")).getText());
	  } catch (Error e) {
	    verificationErrors.append(e.toString());
	  }
	  try {
	    assertEquals("300.00 EUR", driver.findElement(By.xpath(".//*[@id='opportunity_detail']/div[2]/div[1]/div[10]/span")).getText());
	  } catch (Error e) {
	    verificationErrors.append(e.toString());
	  }
	  // Step: click the Top Edit button to view Opportunity Edit view...
	  driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[2]")).click();
	  for (int second = 0;; second++) {
	      if (second >= 60) fail("timeout");
	      try { if (isElementPresent(By.cssSelector("#opportunity_edit > div.panel-content > fieldset > div.row.row-edit"))) break; } catch (Exception e) {}
	      Thread.sleep(1000);
	  }

	  // Verify: validate a few Multi-Currency field values...
	  try {
	    assertEquals("1", driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_Fields_TextField_20']/input")).getAttribute("value"));
	  } catch (Error e) {
	    verificationErrors.append(e.toString());
	  }
	  try {
	    assertEquals("EUR", driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_Fields_LookupField_11']/input")).getAttribute("value"));
	  } catch (Error e) {
	    verificationErrors.append(e.toString());
	  }
	  try {
	    assertEquals("OFF", driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_Fields_BooleanField_3']/div/span[3]")).getText());
	  } catch (Error e) {
	    verificationErrors.append(e.toString());
	  }
	  try {
	    assertThat("", is(not(driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_Fields_DateField_3']/input")).getText())));
	  } catch (Error e) {
	    verificationErrors.append(e.toString());
	  }
	  // 'End: navigate back to Home...
	  driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	  for (int second = 0;; second++) {
	      if (second >= 60) fail("timeout");
	      try { if ("Advising Group Test Opp 100-1".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
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
	  // -- End
  }
  	
  @Test
  public void test05_MobileDefect13091666() throws Exception {
	  // SE Test: SETest-Defect_13091666
      // Version: 2.2
      // Desc: validates that the Opportunity - rate date field is disabled in Edit view.
      // ====================================
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

      // Step: click "+" button to add a new Opportunity record...
      driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[2]")).click();
      for (int second = 0;; second++) {
    	  if (second >= 60) fail("timeout");
    	  try { if ("Opportunity".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
    	  Thread.sleep(1000);
      }

      assertEquals("Opportunity", driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText());
      // VP: check that the "rate date" field is not editable...
      // ERROR: Caught exception [ERROR: Unsupported command [isEditable | XPath=.//*[@id='Sage_Platform_Mobile_Fields_DateField_3']/input | ]]
      // 'End: navigate back to Home...
      driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
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
      // -- End
  }      

  @Test
  public void test06_MobileDefect13091669() throws Exception {
    // SE Test: SETest-Defect_13091669
    // Version: 2.2
    // Desc: validates that where multi currency is enabled, on adding product to opportunity, 2 of the 3 'extended price' fields do not change value when the 1st one does
    // Pre-Run Steps: Logoff, then Log back in as 'Lee'...
    // Required Entity: Opportunity - Abbott WorldWide-Phase I
    // ====================================
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

    // Step: perform a search of a target Opportunity...
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if ("Opportunities".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_SearchWidget_11']/div/div[1]/input")).click();
    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_SearchWidget_11']/div/div[1]/input")).clear();
    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_SearchWidget_11']/div/div[1]/input")).sendKeys("Advising Group Test Opp 100");
    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_SearchWidget_11']/div/div[3]/button")).click();
    // Warning: waitForTextPresent may require manual changes
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Advising Group Test Opp 100 \\(Advising Group\\)[\\s\\S]*$")) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    // Step: click the Opportunity list item for editing...
    driver.findElement(By.xpath(".//*[@id='opportunity_list']/ul/li[2]/div/h3")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText().matches("^Advising Group Test Opp[\\s\\S]*$")) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    // Step: click the Products link...
    driver.findElement(By.xpath(".//*[@id='opportunity_detail']/div[2]/ul[2]/li[1]/a/span")).click();
    try {
      assertEquals("Products", driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    // Step: click the '+' button to add a new Product...
    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[2]")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if ("Opportunity Product".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    // Step: click Product lookup button to select a product...
    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_Fields_LookupField_14']/button")).click();
    try {
      assertEquals("Products", driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    // Step: search and select a Product...
    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_SearchWidget_31']/div/div[1]/input")).clear();
    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_SearchWidget_31']/div/div[1]/input")).sendKeys("Blackberry");
    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_SearchWidget_31']/div/div[3]/button")).click();
    // Warning: waitForTextPresent may require manual changes
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*BlackBerry[\\s\\S]*$")) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    driver.findElement(By.xpath(".//*[@id='product_related']/ul/li/div/h3")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if ("Opportunity Product".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    // Step: set the Price Level...
    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_Fields_LookupField_15']/button")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if ("Product Programs".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    driver.findElement(By.xpath(".//*[@id='productprogram_related']/ul/li[1]/div/h3")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if ("Opportunity Product".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    // Verify: check the values of the product and price fields...
    try {
      assertEquals("BlackBerry", driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_Fields_LookupField_14']/input")).getAttribute("value"));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertEquals("399.00", driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Fields_MultiCurrencyField_1']/input")).getAttribute("value"));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    // Verify: check the value of the 1st extended price
    try {
      assertEquals("399.00", driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Fields_MultiCurrencyField_4']/input")).getAttribute("value"));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    // Step: enter a discount field value...
    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_Fields_DecimalField_0']/input")).clear();
    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_Fields_DecimalField_0']/input")).sendKeys("15.00");
    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Fields_MultiCurrencyField_1']/label")).click();
    // Verify: updated adjusprice fields...
    try {
      assertEquals("339.15", driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Fields_MultiCurrencyField_2']/input")).getAttribute("value"));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    // Verify: updated extended price fields...
    try {
      assertEquals("339.15", driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Fields_MultiCurrencyField_4']/input")).getAttribute("value"));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    // Step: click the Top Cancel button...
    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[2]")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if ("Products".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    // 'End: navigate back to Home...
    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText().matches("^Advising Group Test Opp[\\s\\S]*$")) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if ("Opportunities".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if ("My Activities".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    // -- END
  }
  
	@Test
	public void test07_MobileDefect13091670() throws Exception {
			// SE Test: SETest-Defect_13091670
		// Version: 2.2
		// Desc: validates that the Opportunity Product - discount field denotes a percentage value
		// Required Entity: Opportunity - Abbott WorldWide-Phase I
		// ====================================
		// Step: click Top-Left button to reveal Global Menu...
		driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[1]")).click();
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if (isElementPresent(By.xpath(".//*[@id='Mobile_SalesLogix_SpeedSearchWidget_0']/label"))) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}
		
		// Step: navigate to Opportunity list view...
		driver.findElement(By.xpath(".//*[@id='left_drawer']/descendant::*[text() = \"Opportunities\"]")).click();
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if (isElementPresent(By.xpath(".//*[@id='opportunity_list']/ul/li[1]"))) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}
		
		// Step: perform a search of a target Opportunity...
		driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_SearchWidget_11']/div/div[1]/input")).clear();
		driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_SearchWidget_11']/div/div[1]/input")).sendKeys("Abbott WorldWide-Phase I");
		driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_SearchWidget_11']/div/div[3]/button")).click();
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if (isElementPresent(By.cssSelector("#opportunity_list > ul.list-content > li"))) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}
		
		// Warning: verifyTextPresent may require manual changes
		try {
		  assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*\\(Abbott WorldWide\\)[\\s\\S]*$"));
		} catch (Error e) {
		  verificationErrors.append(e.toString());
		}
		// Step: click the Opportunity list item for editing...
		driver.findElement(By.xpath(".//*[@id='opportunity_list']/ul/li/div/h3")).click();
		try {
		  assertEquals("Abbott WorldWide-Phase I", driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText());
		} catch (Error e) {
		  verificationErrors.append(e.toString());
		}
		// Step: click the Products link...
		driver.findElement(By.xpath(".//*[@id='opportunity_detail']/div[2]/ul[2]/li[1]/a/span")).click();
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if ("Products".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}
		
		// Step: click the '+' button to add a new Product...
		driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[2]")).click();
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if ("Opportunity Product".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}
		
		// VP: check that the "discount %" field is available...
		// Warning: verifyTextPresent may require manual changes
		try {
		  assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*discount %[\\s\\S]*$"));
		} catch (Error e) {
		  verificationErrors.append(e.toString());
		}
		// 'End: navigate back to Home...
		driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if ("Products".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}
		
		driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if ("Abbott WorldWide-Phase I".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}
		
		driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if ("Opportunities".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}
		
		driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if ("My Activities".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}		
		// -- End
	}

	@Test
	public void test08_MobileDefect13091671() throws Exception {
	    // SE Test: SETest-Defect_13091671
	    // Version: 2.2
	    // Desc: validates that where multi currency is enabled, on adding product to opportunity, seeing slight inconsistencies for sales potential value within mobile and in the web client
	    // Pre-Run Steps: Logoff, then Log back in as 'Lee'...
	    // Required Entity: Opportunity - Abbott WorldWide-Phase I
	    // ====================================
	    // -- Start Section
	    // Step: click Top-Left button to reveal Global Menu...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[1]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if (isElementPresent(By.xpath(".//*[@id='Mobile_SalesLogix_SpeedSearchWidget_0']/label"))) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: navigate to Opportunity list view...
	    driver.findElement(By.xpath(".//*[@id='left_drawer']/descendant::*[text() = \"Opportunities\"]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if (isElementPresent(By.xpath(".//*[@id='opportunity_list']/ul/li[1]"))) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: add a new Opportunit...
	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[2]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Opportunity".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // NOTE: Need to append new MDDYY identifier to new Opportunity name
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_Fields_TextField_19']/input")).clear();
	    String uniqueID = new SimpleDateFormat("MM-dd-yyyy_HH-ss").format(new GregorianCalendar().getTime());
	    String newOppName = "Call Color Thurs Test-" + uniqueID;
	    //driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_Fields_TextField_19']/input")).sendKeys("Call Color Thurs Test-52513");
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_Fields_TextField_19']/input")).sendKeys(newOppName);
	    // Step: select an Account value...
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_Fields_LookupField_6']/button")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Accounts".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: search for an Account for selection...
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_SearchWidget_4']/div/div[1]/input")).clear();
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_SearchWidget_4']/div/div[1]/input")).sendKeys("Call Color");
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_SearchWidget_4']/div/div[3]/button")).click();
	    // Warning: waitForTextPresent may require manual changes
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if (driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Call Color[\\s\\S]*$")) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    driver.findElement(By.xpath(".//*[@id='account_related']/ul/li/div/h3")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Opportunity".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: select a Type value...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Fields_PicklistField_17']/button")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Opportunity Type".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    driver.findElement(By.xpath(".//*[@id='pick_list_0']/ul/li[2]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Opportunity".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: setup the Multi-Currency field values...
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_Fields_LookupField_11']/button")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Exchange Rates".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    driver.findElement(By.xpath(".//*[@id='exchangerate_lookup']/ul/li[6]/div/h3")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Opportunity".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    try {
	      assertEquals("GBP", driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_Fields_LookupField_11']/input")).getAttribute("value"));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_Fields_TextField_20']/input")).clear();
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_Fields_TextField_20']/input")).sendKeys("0.5");
	    // Step: click the Top Save button...
	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[2]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Opportunities".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	    // -- End Section

	    // -- Start Section
	    // Step: search for and re-open the new Opportunity record...
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_SearchWidget_11']/div/div[1]/input")).clear();
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_SearchWidget_11']/div/div[1]/input")).sendKeys(newOppName);
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_SearchWidget_11']/div/div[3]/button")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Opportunities".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    driver.findElement(By.xpath(".//*[@id='opportunity_list']/ul/li/div/h3")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if (driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText().matches("^Call Color Thurs Test[\\s\\S]*$")) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: click the Products link...
	    driver.findElement(By.xpath(".//*[@id='opportunity_detail']/div[2]/ul[2]/li[1]/a/span")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Products".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: click the '+' button to add a new Product...
	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[2]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Opportunity Product".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: click Product lookup button to select a product...
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_Fields_LookupField_14']/button")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Products".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: search and select a Product...
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_SearchWidget_31']/div/div[1]/input")).clear();
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_SearchWidget_31']/div/div[1]/input")).sendKeys("Blackberry");
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_SearchWidget_31']/div/div[3]/button")).click();
	    // Warning: waitForTextPresent may require manual changes
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if (driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*BlackBerry[\\s\\S]*$")) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    driver.findElement(By.xpath(".//*[@id='product_related']/ul/li/div/h3")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Opportunity Product".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Verify: check the values of the product and price fields...
	    try {
	      assertEquals("BlackBerry", driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_Fields_LookupField_14']/input")).getAttribute("value"));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    try {
	      assertEquals("399.00", driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Fields_MultiCurrencyField_1']/input")).getAttribute("value"));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: select a Price Level field value...
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_Fields_LookupField_15']/button")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Product Programs".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    driver.findElement(By.xpath(".//*[@id='productprogram_related']/ul/li[2]/div/h3")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Opportunity Product".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: setup the discount field value...
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_Fields_DecimalField_0']/input")).clear();
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_Fields_DecimalField_0']/input")).sendKeys("15");
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_Fields_DecimalField_1']/label")).click();
	    // Verify: check the price level, base, adjusted and extended price field values...
	    try {
	      assertEquals("Wholesale", driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_Fields_LookupField_15']/input")).getAttribute("value"));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    try {
	      assertEquals("279.65", driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Fields_MultiCurrencyField_2']/input")).getAttribute("value"));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    try {
	      assertEquals("279.65", driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Fields_MultiCurrencyField_3']/input")).getAttribute("value"));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    try {
	      assertEquals("279.65", driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Fields_MultiCurrencyField_4']/input")).getAttribute("value"));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: modify the quanity field value...
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_Fields_DecimalField_1']/input")).clear();
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_Fields_DecimalField_1']/input")).sendKeys("2");
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Fields_MultiCurrencyField_2']/label")).click();
	    // Verify: updated extended price field value...
	    try {
	      assertEquals("559.30", driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Fields_MultiCurrencyField_4']/input")).getAttribute("value"));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: click the Top Cancel button...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[2]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Products".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // 'End: navigate back to Home...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if (driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText().matches("^Call Color Thurs Test[\\s\\S]*$")) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Opportunities".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	    // --END
	}
	
	@Test
	  public void test09_MobileDefect13091672() throws Exception {
	    // SE Test: SETest-Defect_13091672
	    // Version: 2.2
	    // Desc: validates that a Validation Summary error is displayed if a Product record is attempted to be saved w/o a Product Program set
	    // Required Entity: Opportunity - Abbott WorldWide-Phase I
	    // ====================================
	    // Step: click Top-Left button to reveal Global Menu...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[1]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if (isElementPresent(By.cssSelector("#Mobile_SalesLogix_SpeedSearchWidget_0 > div.table-layout > div > input[name=\"query\"]"))) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: navigate to Opportunities list view...
	    driver.findElement(By.xpath(".//*[@id='left_drawer']/descendant::*[text() = \"Opportunities\"]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if (isElementPresent(By.xpath(".//*[@id='opportunity_list']/ul/li[1]"))) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: perform a search of a target Opportunity...
	    assertEquals("Opportunities", driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText());
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_SearchWidget_11']/div/div[1]/input")).clear();
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_SearchWidget_11']/div/div[1]/input")).sendKeys("Abbott WorldWide-Phase I");
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_SearchWidget_11']/div/div[3]/button")).click();
	    // Warning: waitForTextPresent may require manual changes
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if (driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Abbott WorldWide-Phase I \\(Abbott WorldWide\\)[\\s\\S]*$")) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Warning: assertTextPresent may require manual changes
	    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Abbott WorldWide-Phase I \\(Abbott WorldWide\\)[\\s\\S]*$"));
	    // Step: click the Opportunity list item for editing...
	    driver.findElement(By.xpath(".//*[@id='opportunity_list']/ul/li/div/h3")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Abbott WorldWide-Phase I".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: click the Products link...
	    driver.findElement(By.xpath(".//*[@id='opportunity_detail']/div[2]/ul[2]/li[1]/a/span")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if (!"".equals(driver.findElement(By.xpath(".//*[@id='opportunityproduct_related']/ul/li[1]/div/h3")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    assertEquals("Products", driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText());
	    // Step: click the '+' button to add a new Product...
	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[2]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Abbott WorldWide-Phase I".equals(driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_Fields_LookupField_13']/input")).getAttribute("value"))) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    try {
	      assertEquals("Opportunity Product", driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText());
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: click Product lookup button to select a product...
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_Fields_LookupField_14']/button")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if (!"".equals(driver.findElement(By.xpath(".//*[@id='product_related']/ul/li[1]/div/h3")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    try {
	      assertEquals("Products", driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText());
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: select a product from the list...
	    driver.findElement(By.xpath(".//*[@id='product_related']/ul/li[2]/div/h3")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Abbott WorldWide-Phase I".equals(driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_Fields_LookupField_13']/input")).getAttribute("value"))) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    try {
	      assertEquals("Opportunity Product", driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText());
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: click the Top Save button...
	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[2]")).click();
	    // Validate: check that the Validation Summary error is displayed...
	    // Warning: assertTextPresent may require manual changes
	    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Validation Summary[\\s\\S]*$"));
	    // Warning: assertTextPresent may require manual changes
	    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*The field 'price level' must have a value\\.[\\s\\S]*$"));
	    // Step: click the Price Level lookup to select a value...
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_Fields_LookupField_15']/button")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Product Programs".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: select a Product Programs item...
	    driver.findElement(By.xpath(".//*[@id='productprogram_related']/ul/li[1]/div/h3")).click();
	    // Warning: verifyTextPresent may require manual changes
	    try {
	      assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Retail[\\s\\S]*$"));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: click the Top Save button...
	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[2]")).click();
	    // VP: check that the save is successful and that Validation Summary error is not displayed...
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Products".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Warning: verifyTextNotPresent may require manual changes
	    try {
	      assertFalse(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*The field 'price level' must have a value\\.[\\s\\S]*$"));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // 'End: navigate back to Home...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Abbott WorldWide-Phase I".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

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

	    // -- End
	  }

	  @Test
	  public void test10_MobileDefect13091678() throws Exception {
		  // SE Test: SETest-Defect_13091678
		  // Version: 2.2
		  // Desc: validates that a Multi Currency field section is not available when editing an Opportunity Edit for non-Multi-Currency site
		  // Required Environment: non-Multi-Currency Mobile Client site
		  // Required Entity: Opportunity - Abbott WorldWide-Phase I
		  // ====================================
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

		  // Step: perform a search of a target Opportunity...
		  assertEquals("Opportunities", driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText());
		  driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_SearchWidget_11']/div/div[1]/input")).click();
		  driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_SearchWidget_11']/div/div[1]/input")).clear();
		  driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_SearchWidget_11']/div/div[1]/input")).sendKeys("Abbott WorldWide-Phase I");
		  driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_SearchWidget_11']/div/div[3]/button")).click();
		  // Warning: waitForTextPresent may require manual changes
		  for (int second = 0;; second++) {
			  if (second >= 60) fail("timeout");
			  try { if (driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*\\(Abbott WorldWide\\)[\\s\\S]*$")) break; } catch (Exception e) {}
			  Thread.sleep(1000);
		  }

		  // Warning: assertTextPresent may require manual changes
		  assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*\\(Abbott WorldWide\\)[\\s\\S]*$"));
		  // Step: click the Opportunity list item for editing...
		  driver.findElement(By.xpath(".//*[@id='opportunity_list']/ul/li/div/h3")).click();
		  try {
			  assertEquals("Abbott WorldWide-Phase I", driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText());
		  } catch (Error e) {
			  verificationErrors.append(e.toString());
		  }
		  // VP: check that the Multi Currency section & fields are not displayed...
		  // Warning: verifyTextNotPresent may require manual changes
		  try {
			  assertFalse(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Multi Currency[\\s\\S]*$"));
		  } catch (Error e) {
			  verificationErrors.append(e.toString());
		  }
		  // Warning: verifyTextNotPresent may require manual changes
		  try {
			  assertFalse(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*locked[\\s\\S]*$"));
		  } catch (Error e) {
			  verificationErrors.append(e.toString());
		  }
		  //'End: navigate back to Home...
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
		  // -- End
	  }

	  @Test
	  public void test11_MobileDefect13091679() throws Exception {
		  // SE Test: SETest-Defect_13091679
		  // Desc: validates that a Multi Currency field section is not available when adding a new Opportunity for non-Multi-Currency site
		  // Required Environment: non-Multi-Currency Mobile Client site
		  // Required Entity: Opportunity - Abbott WorldWide-Phase I
		  // ====================================
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

		  assertEquals("Opportunities", driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText());
		  // Step: click the Top Add button to setup a new Opportunity...
		  driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[2]")).click();
		  assertEquals("Opportunity", driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText());
		  // VP: check that the Multi Currency section & fields are not displayed...
		  // Warning: verifyTextNotPresent may require manual changes
		  try {
			  assertFalse(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Multi Currency[\\s\\S]*$"));
		  } catch (Error e) {
			  verificationErrors.append(e.toString());
		  }
		  // Warning: verifyTextNotPresent may require manual changes
		  try {
			  assertFalse(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*locked[\\s\\S]*$"));
		  } catch (Error e) {
			  verificationErrors.append(e.toString());
		  }
		  // 'End: navigate back to Home...
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
	  public void test12_MobileDefect13091717() throws Exception {
		//*** TO-DO ***: fix possible timing issue at line 694
		  
	    // SE Test: SETest-Defect_13091717
	    // Desc: validates that a completed Activity no longer appears in the My Activity list 
	    // Pre-Run Steps: Logoff, then Log back in as 'Lee'...
	    // Required Login: 'Lee' (non-Admin)
	    // ====================================
	    // Step: click Top-Left button to reveal Global Menu...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[1]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if (isElementPresent(By.xpath(".//*[@id='Mobile_SalesLogix_SpeedSearchWidget_0']/div/div[1]/input"))) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: navigate to Calendar view...
	    driver.findElement(By.xpath(".//*[@id='left_drawer']/descendant::*[text() = \"Calendar\"]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Calendar".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    assertEquals("Calendar", driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText());
	    // Step: click "+" to schedule a new Activity...
	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[2]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Schedule...".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: select an Activity type...(Personal Activity)
	    driver.findElement(By.xpath(".//*[@id='activity_types_list']/ul/li[2]/div[2]/h3")).click();
	    Thread.sleep(3000);
	    assertEquals("Personal Activity", driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText());
	    
	    // Step: select a Regarding value...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Fields_PicklistField_28']/button")).click();
	    Thread.sleep(3000);
	    assertEquals("Activity Description", driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText());
	    driver.findElement(By.xpath(".//*[@id='pick_list_0']/ul/li[16]/div/h3")).click();
	    Thread.sleep(3000);
	    assertEquals("Personal Activity", driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText());
	    
	    // Step: select a Category value...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Fields_PicklistField_30']/button")).click();
	    Thread.sleep(3000);
	    assertEquals("Activity Category", driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText());
	    driver.findElement(By.xpath(".//*[@id='pick_list_0']/ul/li[7]/div/h3")).click();
	    Thread.sleep(3000);
	    assertEquals("Personal Activity", driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText());
	    
	    // Step: click the Notes edit button and enter notes text...
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_Fields_NoteField_6']/button")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Notes".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_Fields_TextAreaField_0']/textarea")).clear();
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_Fields_TextAreaField_0']/textarea")).sendKeys("activity test note for SETest-Defect_1309171...");
	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[2]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Personal Activity".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: click the Top Save button...
	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[2]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Calendar".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: navigate back to Home...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("My Activities".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: click the newly-scheduled Activity from the My Activities list...
	    driver.findElement(By.xpath(".//*[@id='myactivity_list']/ul/li[1]/div[2]/h3")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Activity".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: click the Complete Activity link...
	    driver.findElement(By.xpath(".//*[@id='activity_detail']/div[2]/ul/li/a/label")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Complete Activity".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: cick the Top Save button..
	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[2]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("My Activities".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // VP: check that the completed Activity is no longer available in the My Activities list...
	    assertThat("Staff Meeting", is(not(driver.findElement(By.cssSelector("span.p-description")).getText())));
	    // -- End
	  }

	
	@Test
	public void test13_MobileDefect13091723() throws Exception {
	    // SE Test: SETest-Defect_13091723
	    // Version: 2.2
	    // Desc: validates that any Activity (immediately scheduled after an initial one) will show up in the My Activities list...
	    // Pre-Run Steps: Logoff, then Log back in as 'Lee'...
	    // Required Login: 'Lee' (non-Admin)
	    // ====================================
	    // Step: click Top-Left button to reveal Global Menu...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[1]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if (isElementPresent(By.xpath(".//*[@id='Mobile_SalesLogix_SpeedSearchWidget_0']/div/div[1]/input"))) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: navigate to Calendar view...
	    driver.findElement(By.xpath(".//*[@id='left_drawer']/descendant::*[text() = \"Calendar\"]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if (isElementPresent(By.xpath(".//*[@id='calendar_daylist']/div[3]/h3"))) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    assertEquals("Calendar", driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText());
	    // -- Start Section: Schedule 1st Activity...
	    // Step: click "+" to schedule a new Activity...
	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[2]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Schedule...".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: select an Activity type...(To-Do)
	    driver.findElement(By.xpath(".//*[@id='activity_types_list']/ul/li[4]/div[2]/h3")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("To-Do".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: select a Regarding value...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Fields_PicklistField_28']/button")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Activity Description".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    driver.findElement(By.xpath(".//*[@id='pick_list_0']/ul/li[1]/div/h3")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("To-Do".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: select a Category value...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Fields_PicklistField_30']/button")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Activity Category".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    driver.findElement(By.xpath(".//*[@id='pick_list_0']/ul/li[6]/div/h3")).click();
	    // Step: click the Notes edit button and enter notes text...
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_Fields_NoteField_6']/button")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Notes".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_Fields_TextAreaField_0']/textarea")).clear();
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_Fields_TextAreaField_0']/textarea")).sendKeys("1st scheduled activity note for SETest-Defect_13091723...");
	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[2]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("To-Do".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: click the Top Save button...
	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[2]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Calendar".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // TEMP: disabled for debugging
	    //assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Send e-mail message[\\s\\S]*$"));
	    
	    // -- End Section
	    // -- Start Section: Schedule 2nd Activity...
	    // Step: click "+" to schedule a new Activity...
	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[2]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Schedule...".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: select an Activity type...(Phone Call)
	    driver.findElement(By.xpath(".//*[@id='activity_types_list']/ul/li[3]/div[2]/h3")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Phone Call".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: select a Regarding value...(Follow up)
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Fields_PicklistField_28']/button")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Activity Description".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    driver.findElement(By.xpath(".//*[@id='pick_list_0']/ul/li[7]/div/h3")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Phone Call".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: select a Category value...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Fields_PicklistField_30']/button")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Activity Category".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    driver.findElement(By.xpath(".//*[@id='pick_list_0']/ul/li[2]/div/h3")).click();
	    // Step: click the Notes edit button and enter notes text...
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_Fields_NoteField_6']/button")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Notes".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_Fields_TextAreaField_0']/textarea")).clear();
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_Fields_TextAreaField_0']/textarea")).sendKeys("2nd scheduled activity note for SETest-Defect_13091723...");
	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[2]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Phone Call".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: click the Top Save button...
	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[2]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Calendar".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // TEMP: disabled for debugging
	    //assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Follow-up[\\s\\S]*$"));
	    
	    // -- End Section
	    // Step: navigate back to Home...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("My Activities".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // VP: check that the completed Activity is no longer available in the My Activities list...
	    // Warning: verifyTextPresent may require manual changes
	    try {
	      assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Send e-mail message[\\s\\S]*$"));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Warning: verifyTextPresent may require manual changes
	    try {
	      assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Follow-up[\\s\\S]*$"));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // --End
	}
		
	@Test
	public void test14_MobileDefect13091724() throws Exception {
	    // SE Test: SETest-Defect_13091724
	    // Version: 2.2
	    // Desc: validates that any Activity (immediately scheduled after an initial one) will show up in the My Activities list...
	    // Pre-Run Steps: Logoff, then Log back in as 'Lee'...
	    // Required Login: 'Lee' (non-Admin)
	    // ====================================
	    // Step: click Top-Left button to reveal Global Menu...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[1]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if (isElementPresent(By.xpath(".//*[@id='Mobile_SalesLogix_SpeedSearchWidget_0']/div/div[1]/input"))) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: navigate to Calendar view...
	    driver.findElement(By.xpath(".//*[@id='left_drawer']/descendant::*[text() = \"Calendar\"]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if (isElementPresent(By.xpath(".//*[@id='calendar_daylist']/div[3]/h3"))) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    assertEquals("Calendar", driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText());
	    // -- Start Section: Schedule 1st Activity...
	    // Step: click "+" to schedule a new Activity...
	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[2]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Schedule...".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: select an Activity type...(To-Do)
	    driver.findElement(By.xpath(".//*[@id='activity_types_list']/ul/li[4]/div[2]/h3")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("To-Do".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: select a Regarding value...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Fields_PicklistField_28']/button")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Activity Description".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    driver.findElement(By.xpath(".//*[@id='pick_list_0']/ul/li[1]/div/h3")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("To-Do".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: select a Category value...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Fields_PicklistField_30']/button")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Activity Category".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    driver.findElement(By.xpath(".//*[@id='pick_list_0']/ul/li[6]/div/h3")).click();
	    // Step: click the Notes edit button and enter notes text...
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_Fields_NoteField_6']/button")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Notes".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_Fields_TextAreaField_0']/textarea")).clear();
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_Fields_TextAreaField_0']/textarea")).sendKeys("1st scheduled activity note for SETest-Defect_13091723...");
	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[2]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("To-Do".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: click the Top Save button...
	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[2]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Calendar".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // TEMP: disabled for debugging
	    //assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Send e-mail message[\\s\\S]*$"));
	    
	    // -- End Section
	    // -- Start Section: Schedule 2nd Activity...
	    // Step: click "+" to schedule a new Activity...
	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[2]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Schedule...".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: select an Activity type...(Phone Call)
	    driver.findElement(By.xpath(".//*[@id='activity_types_list']/ul/li[3]/div[2]/h3")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Phone Call".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: select a Regarding value...(Follow up)
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Fields_PicklistField_28']/button")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Activity Description".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    driver.findElement(By.xpath(".//*[@id='pick_list_0']/ul/li[7]/div/h3")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Phone Call".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: select a Category value...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Fields_PicklistField_30']/button")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Activity Category".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    driver.findElement(By.xpath(".//*[@id='pick_list_0']/ul/li[2]/div/h3")).click();
	    // Step: click the Notes edit button and enter notes text...
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_Fields_NoteField_6']/button")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Notes".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_Fields_TextAreaField_0']/textarea")).clear();
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_Fields_TextAreaField_0']/textarea")).sendKeys("2nd scheduled activity note for SETest-Defect_13091723...");
	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[2]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Phone Call".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: click the Top Save button...
	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[2]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Calendar".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // TEMP: disabled for debugging
	    //assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Follow-up[\\s\\S]*$"));
	    
	    // -- End Section
	    // Step: navigate back to Home...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("My Activities".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // VP: check that the completed Activity is no longer available in the My Activities list...
	    // Warning: verifyTextPresent may require manual changes
	    try {
	      assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Send e-mail message[\\s\\S]*$"));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Warning: verifyTextPresent may require manual changes
	    try {
	      assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Follow-up[\\s\\S]*$"));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // --End
	}
	
	@Test
	public void test15_MobileDefect13091725() throws Exception {
	    // SE Test: SETest-Defect_13091725
	    // Version: 2.2
	    // Desc: validates that discount price & adjusted price fields are not re-set after selecting Price Level value
	    // Pre-Run Steps: Logoff, then Log back in as 'Lee'...
	    // Required Entity: Opportunity - Abbott WorldWide-Phase I
	    // ====================================
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

	    // Step: perform a search of a target Opportunity...
	    assertEquals("Opportunities", driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText());
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_SearchWidget_11']/div/div[1]/input")).click();
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_SearchWidget_11']/div/div[1]/input")).clear();
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_SearchWidget_11']/div/div[1]/input")).sendKeys("Abbott WorldWide-Phase I");
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_SearchWidget_11']/div/div[3]/button")).click();
	    // Warning: waitForTextPresent may require manual changes
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if (driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*\\(Abbott WorldWide\\)[\\s\\S]*$")) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: click the Opportunity list item for editing...
	    driver.findElement(By.xpath(".//*[@id='opportunity_list']/ul/li/div/h3")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Abbott WorldWide-Phase I".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: click the Products link...
	    driver.findElement(By.xpath(".//*[@id='opportunity_detail']/div[2]/ul[2]/li[1]/a/span")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Products".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: click the '+' button to add a new Product...
	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[2]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Opportunity Product".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: click Product lookup button to select a product...
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_Fields_LookupField_14']/button")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Products".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: select a product from the list...
	    driver.findElement(By.xpath(".//*[@id='product_related']/ul/li[2]/div/h3")).click();
	    // NOTE: fields are no longer editable until a Price Level value is selected
	    // Verify: the auto-filled field values for price and all three extended price fields...
	    try {
	      assertEquals("200.00", driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Fields_MultiCurrencyField_1']/input")).getAttribute("value"));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    try {
	      assertEquals("200.00", driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Fields_MultiCurrencyField_2']/input")).getAttribute("value"));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    try {
	      assertEquals("200.00", driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Fields_MultiCurrencyField_3']/input")).getAttribute("value"));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    try {
	      assertEquals("200.00", driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Fields_MultiCurrencyField_4']/input")).getAttribute("value"));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // NOTE: fields under Price Level are no longer editable until a Price Level is selected
	    // Step: click the Price Level lookup to select a value...
	    driver.findElement(By.cssSelector("#Sage_Platform_Mobile_Fields_LookupField_15 > button.button.simpleSubHeaderButton")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Product Programs".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: select a Product Programs item...
	    driver.findElement(By.xpath(".//*[@id='productprogram_related']/ul/li[1]/div/h3")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Opportunity Product".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Warning: verifyTextPresent may require manual changes
	    try {
	      assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Retail[\\s\\S]*$"));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Verify: set discount % field value...
	    driver.findElement(By.cssSelector("input[name=\"Discount\"]")).clear();
	    driver.findElement(By.cssSelector("input[name=\"Discount\"]")).sendKeys("15.00");
	    driver.findElement(By.cssSelector("input[name=\"CalculatedPrice\"]")).click();
	    // Verify: updated adjusprice fields...
	    try {
	      assertEquals("200.00", driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Fields_MultiCurrencyField_1']/input")).getAttribute("value"));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    try {
	      assertEquals("170.00", driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Fields_MultiCurrencyField_2']/input")).getAttribute("value"));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    try {
	      assertEquals("170.00", driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Fields_MultiCurrencyField_3']/input")).getAttribute("value"));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Verify: updated extended price fields...
	    try {
	      assertEquals("170.00", driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Fields_MultiCurrencyField_4']/input")).getAttribute("value"));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: click the Top Cancel button...
	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[2]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Products".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // 'End: navigate back to Home...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Abbott WorldWide-Phase I".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

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
	    // -- End
	}

	@Test
	public void test16_MobileDefect13091765() throws Exception {
	    // SE Test: SETest-Defect_13091765
	    // Version: 2.2
	    // Desc: validates adjusted and extended price for opportunity rate display as 0.00  undefined per scenario
	    // Pre-Run Steps: Logoff, then Log back in as 'Lee'...
	    // Required Entity: Opportunity - Abbott WorldWide-Phase I
	    // ====================================
	    // Step: click Top-Left button to reveal Global Menu...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[1]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if (isElementPresent(By.xpath(".//*[@id='Mobile_SalesLogix_SpeedSearchWidget_0']/label"))) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: navigate to Opportunity list view...
	    driver.findElement(By.xpath(".//*[@id='left_drawer']/descendant::*[text() = \"Opportunities\"]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if (isElementPresent(By.xpath(".//*[@id='opportunity_list']/ul/li[1]"))) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: add a new Opportunit...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[2]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Opportunity".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_Fields_TextField_19']/input")).clear();
	    String uniqueID = new SimpleDateFormat("MM-dd-yyyy_HH-ss").format(new GregorianCalendar().getTime());
	    String newOppName = "Test Allied Corp 100-" + uniqueID;	    
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_Fields_TextField_19']/input")).sendKeys(newOppName);
	    // Step: select an Account value...
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_Fields_LookupField_6']/button")).click();
	    try {
	      assertEquals("Accounts", driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText());
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: search for an Account for selection...
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_SearchWidget_4']/div/div[1]/input")).clear();
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_SearchWidget_4']/div/div[1]/input")).sendKeys("Allied Corp");
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_SearchWidget_4']/div/div[3]/button")).click();
	    // Warning: verifyTextPresent may require manual changes
	    try {
	      assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Allied Corp[\\s\\S]*$"));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    driver.findElement(By.xpath(".//*[@id='account_related']/ul/li/div/h3")).click();
	    try {
	      assertEquals("Opportunity", driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText());
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: setup the Multi-Currency field values...
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_Fields_LookupField_11']/button")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Exchange Rates".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    driver.findElement(By.xpath(".//*[@id='exchangerate_lookup']/ul/li[6]/div/h3")).click();
	    try {
	      assertEquals("Opportunity", driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText());
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    try {
	      assertEquals("GBP", driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_Fields_LookupField_11']/input")).getAttribute("value"));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_Fields_TextField_20']/input")).clear();
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_Fields_TextField_20']/input")).sendKeys("0.25");
	    // Step: click the Top Save button...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[2]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Opportunities".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // -- End Section
	    // -- Start Section
	    // Step: search for and re-open the new Opportunity record...
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_SearchWidget_11']/div/div[1]/input")).clear();
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_SearchWidget_11']/div/div[1]/input")).sendKeys(newOppName);
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_SearchWidget_11']/div/div[3]/button")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Opportunities".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    driver.findElement(By.xpath(".//*[@id='opportunity_list']/ul/li/div/h3")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if (driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText().matches("^Test Allied Corp 100[\\s\\S]*$")) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: click the Products link...
	    driver.findElement(By.xpath(".//*[@id='opportunity_detail']/div[2]/ul[2]/li[1]/a/span")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Products".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Warning: verifyTextPresent may require manual changes
	    try {
	      assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*no records[\\s\\S]*$"));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: click the '+' button to add a new Product...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[2]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Opportunity Product".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: click Product lookup button to select a product...
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_Fields_LookupField_14']/button")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Products".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: search and select a Product...
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_SearchWidget_31']/div/div[1]/input")).clear();
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_SearchWidget_31']/div/div[1]/input")).sendKeys("Dell Latitude");
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_SearchWidget_31']/div/div[3]/button")).click();
	    // Warning: verifyTextPresent may require manual changes
	    try {
	      assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Dell Latitude[\\s\\S]*$"));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    driver.findElement(By.xpath(".//*[@id='product_related']/ul/li/div/h3")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Opportunity Product".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Verify: check the values of the product and price fields...
	    try {
	      assertEquals("Dell Latitude", driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_Fields_LookupField_14']/input")).getAttribute("value"));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: select a Price Level field value...
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_Fields_LookupField_15']/button")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Product Programs".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    driver.findElement(By.xpath(".//*[@id='productprogram_related']/ul/li[2]/div/h3")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Opportunity Product".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: setup the discount field value...
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_Fields_DecimalField_0']/input")).clear();
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_Fields_DecimalField_0']/input")).sendKeys("10.0");
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_Fields_DecimalField_1']/label")).click();
	    // Verify: check the price level, base, adjusted and extended price field values...
	    try {
	      assertEquals("Wholesale", driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_Fields_LookupField_15']/input")).getAttribute("value"));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    try {
	      assertEquals("2159.10", driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Fields_MultiCurrencyField_2']/input")).getAttribute("value"));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    try {
	      assertEquals("2159.10", driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Fields_MultiCurrencyField_3']/input")).getAttribute("value"));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    try {
	      assertEquals("2159.10", driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Fields_MultiCurrencyField_4']/input")).getAttribute("value"));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: click the Top Savel button...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[2]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Products".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Verify: product info in Products list view...
	    // Warning: verifyTextPresent may require manual changes
	    try {
	      assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Dell Latitude[\\s\\S]*$"));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // -- End Section
	    // -- Start Section
	    // Step: click Product link from Products list view...
	    driver.findElement(By.xpath(".//*[@id='opportunityproduct_related']/ul/li/div/h3")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Dell Latitude".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Verify: check the Extended Price field value...
	    try {
	      assertEquals("2,159.10 USD", driver.findElement(By.xpath(".//*[@id='opportunityproduct_detail']/div[2]/div[3]/div/span")).getText());
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: click the Top Edit button to load the Opportunity Edit view...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[2]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Opportunity Product".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Verify: check the adjusted and extended price field values...
	    try {
	      assertEquals("2159.10", driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Fields_MultiCurrencyField_2']/input")).getAttribute("value"));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    try {
	      assertEquals("2159.10", driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Fields_MultiCurrencyField_4']/input")).getAttribute("value"));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: click Top Cancel to return to Product Detail view...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    // Step: click the Top Back button a few times to return to Opportunities list view....
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Dell Latitude".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[4]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Products".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if (driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText().matches("^Test Allied Corp[\\s\\S]*$")) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Opportunities".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: search for and re-open the Opportunit...
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_SearchWidget_11']/div/div[1]/input")).clear();
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_SearchWidget_11']/div/div[1]/input")).sendKeys(newOppName);
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_SearchWidget_11']/div/div[3]/button")).click();
	    // Warning: verifyTextPresent may require manual changes
	    try {
	      assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Test Allied Corp[\\s\\S]*$"));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    driver.findElement(By.xpath(".//*[@id='opportunity_list']/ul/li/div/h3")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if (driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText().matches("^Test Allied Corp[\\s\\S]*$")) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: click the Products link and re-open the Product...
	    driver.findElement(By.xpath(".//*[@id='opportunity_detail']/div[2]/ul[2]/li[1]/a/span")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Products".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Warning: verifyTextPresent may require manual changes
	    try {
	      assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Dell Latitude[\\s\\S]*$"));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    driver.findElement(By.xpath(".//*[@id='opportunityproduct_related']/ul/li/div/h3")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Dell Latitude".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Verify: check the Extended Price field value...
	    try {
	      assertEquals("2,159.10 USD", driver.findElement(By.xpath(".//*[@id='opportunityproduct_detail']/div[2]/div[3]/div/span")).getText());
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: click the Top Edit button...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[2]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Opportunity Product".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Verify: check the Adjusted and Extended Price field values...
	    try {
	      assertEquals("2159.10", driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Fields_MultiCurrencyField_2']/input")).getAttribute("value"));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    try {
	      assertEquals("2159.10", driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Fields_MultiCurrencyField_3']/input")).getAttribute("value"));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    try {
	      assertThat("0.00", is(not(driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Fields_MultiCurrencyField_4']/input")).getAttribute("value"))));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // -- End Section
	    // 'End: navigate back to Home...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Dell Latitude".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[4]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Products".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if (driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText().matches("^Test Allied Corp[\\s\\S]*$")) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Opportunities".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	    // -- END
	}

	@Test
	public void test17_MobileDefect13091774() throws Exception {
	    // SE Test: SETest-Defect_13091774
	    // Desc: validates that My Activities searces support wildcards...
	    // Pre-Run Steps: Logoff, then Log back in as 'Lee'...
	    // Required Entity: TBD
	    // ====================================
	    // Step: click Top-Left button to reveal Global Menu...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[1]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if (isElementPresent(By.xpath(".//*[@id='Mobile_SalesLogix_SpeedSearchWidget_0']/label"))) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: navigate to My Activities list view...
	    driver.findElement(By.xpath(".//*[@id='left_drawer']/descendant::*[text() = \"My Activities\"]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if (isElementPresent(By.xpath(".//*[@id='myactivity_list']/ul/li[1]"))) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // -- Start Section: Activity Regarding field values
	    // Step: search on "Prop*"...
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_SearchWidget_26']/div/div[1]/input")).clear();
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_SearchWidget_26']/div/div[1]/input")).sendKeys("Prop*");
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_SearchWidget_26']/div/div[3]/button")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if (isElementPresent(By.xpath(".//*[@id='myactivity_list']/ul/li[1]"))) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Warning: verifyTextPresent may require manual changes
	    try {
	      assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*no records[\\s\\S]*$"));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: search on "*Prop"...
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_SearchWidget_26']/div/div[1]/input")).clear();
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_SearchWidget_26']/div/div[1]/input")).sendKeys("*Prop");
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_SearchWidget_26']/div/div[3]/button")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if (isElementPresent(By.xpath(".//*[@id='myactivity_list']/ul/li[1]"))) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Warning: verifyTextPresent may require manual changes
	    try {
	      assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*no records[\\s\\S]*$"));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: search on "Prop"...
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_SearchWidget_26']/div/div[1]/input")).clear();
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_SearchWidget_26']/div/div[1]/input")).sendKeys("Prop");
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_SearchWidget_26']/div/div[3]/button")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if (isElementPresent(By.xpath(".//*[@id='myactivity_list']/ul/li[1]"))) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Warning: verifyTextPresent may require manual changes
	    try {
	      assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Send proposal[\\s\\S]*$"));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // -- End Section
	    // -- Start Section: Account name string values
	    // Step: search on "*invest"...
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_SearchWidget_26']/div/div[1]/input")).clear();
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_SearchWidget_26']/div/div[1]/input")).sendKeys("*invest");
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_SearchWidget_26']/div/div[3]/button")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if (isElementPresent(By.xpath(".//*[@id='myactivity_list']/ul/li[1]"))) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Warning: verifyTextPresent may require manual changes
	    try {
	      assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*no records[\\s\\S]*$"));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: search on "Ab*"...
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_SearchWidget_26']/div/div[1]/input")).clear();
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_SearchWidget_26']/div/div[1]/input")).sendKeys("Ab*");
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_SearchWidget_26']/div/div[3]/button")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if (isElementPresent(By.xpath(".//*[@id='myactivity_list']/ul/li[1]"))) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Warning: verifyTextPresent may require manual changes
	    try {
	      assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*no records[\\s\\S]*$"));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: search on "Ab"...
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_SearchWidget_26']/div/div[1]/input")).clear();
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_SearchWidget_26']/div/div[1]/input")).sendKeys("Ab");
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_SearchWidget_26']/div/div[3]/button")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if (isElementPresent(By.xpath(".//*[@id='myactivity_list']/ul/li[1]"))) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Warning: verifyTextPresent may require manual changes
	    try {
	      assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Abbott Ltd[\\s\\S]*$"));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // -- End Section
	    // -- Start Section: Products name string values
	    // Step: search on "*dell"...
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_SearchWidget_26']/div/div[1]/input")).clear();
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_SearchWidget_26']/div/div[1]/input")).sendKeys("*dell");
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_SearchWidget_26']/div/div[3]/button")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if (isElementPresent(By.xpath(".//*[@id='myactivity_list']/ul/li[1]"))) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Warning: verifyTextPresent may require manual changes
	    try {
	      assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*no records[\\s\\S]*$"));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: search on "dell*"...
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_SearchWidget_26']/div/div[1]/input")).clear();
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_SearchWidget_26']/div/div[1]/input")).sendKeys("dell*");
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_SearchWidget_26']/div/div[3]/button")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if (isElementPresent(By.xpath(".//*[@id='myactivity_list']/ul/li[1]"))) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Warning: verifyTextPresent may require manual changes
	    try {
	      assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*no records[\\s\\S]*$"));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: search on "dell"...
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_SearchWidget_26']/div/div[1]/input")).clear();
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_SearchWidget_26']/div/div[1]/input")).sendKeys("dell");
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_SearchWidget_26']/div/div[3]/button")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if (isElementPresent(By.xpath(".//*[@id='myactivity_list']/ul/li[1]"))) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Warning: verifyTextPresent may require manual changes
	    try {
	      assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*no records[\\s\\S]*$"));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // -- End Section
	    // 'End: reset the My Activities search...
	    driver.findElement(By.cssSelector("#Sage_Platform_Mobile_SearchWidget_26 > div.table-layout > div.hasButton > button.clear-button")).click();
	    driver.findElement(By.cssSelector("#Sage_Platform_Mobile_SearchWidget_26 > div.table-layout > div.hasButton > button.subHeaderButton.searchButton")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if (isElementPresent(By.xpath(".//*[@id='myactivity_list']/ul/li[1]"))) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	    // -- END
	}
	
	@Test
	public void test18_MobileDefect13091784() throws Exception {
	    // SE Test: SETest-Defect_13091784
	    // Version: 2.2
	    // Desc: validates that Speedsearch can find Lead records where there is no Company info...
	    // Required Entities: Frank Benson, Pete Best & Andrews
	    // ====================================
	    // -- Section: search for 'Frank Benson'
	    // Step: click Top-Left button to reveal Global Menu...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[1]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if (isElementPresent(By.xpath(".//*[@id='Mobile_SalesLogix_SpeedSearchWidget_0']/div/div[1]/input"))) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: perform a search of a target Opportunity...
	    driver.findElement(By.cssSelector("#Mobile_SalesLogix_SpeedSearchWidget_0 > div.table-layout > div > input[name=\"query\"]")).clear();
	    driver.findElement(By.cssSelector("#Mobile_SalesLogix_SpeedSearchWidget_0 > div.table-layout > div > input[name=\"query\"]")).sendKeys("Frank");
	    driver.findElement(By.cssSelector("#Mobile_SalesLogix_SpeedSearchWidget_0 > div.table-layout > div.hasButton > button.subHeaderButton.searchButton")).click();
	    try {
	      assertEquals("Search Results", driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText());
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if (isElementPresent(By.xpath(".//*[@id='speedsearch_list']/ul/li[1]"))) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // VP: check that the save is successful and that Validation Summary error is not displayed...
	    try {
		      AssertJUnit.assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]Frank Benson*[\\s\\S]*$"));
		    } catch (Error e) {
		      verificationErrors.append(e.toString());
		}    
	    // -- End Section
	    
	    // -- Section: search for 'Pete Best'
	    // Step: click Top-Left button to reveal Global Menu...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[1]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if (isElementPresent(By.xpath(".//*[@id='Mobile_SalesLogix_SpeedSearchWidget_0']/div/div[1]/input"))) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: perform a search of a target Opportunity...
	    driver.findElement(By.cssSelector("#Mobile_SalesLogix_SpeedSearchWidget_0 > div.table-layout > div > input[name=\"query\"]")).clear();
	    driver.findElement(By.cssSelector("#Mobile_SalesLogix_SpeedSearchWidget_0 > div.table-layout > div > input[name=\"query\"]")).sendKeys("Pete Best");
	    driver.findElement(By.cssSelector("#Mobile_SalesLogix_SpeedSearchWidget_0 > div.table-layout > div.hasButton > button.subHeaderButton.searchButton")).click();
	    try {
	      assertEquals("Search Results", driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText());
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if (isElementPresent(By.xpath(".//*[@id='speedsearch_list']/ul/li[1]"))) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // VP: check that the save is successful and that Validation Summary error is not displayed...
	    try {
		      AssertJUnit.assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Pete Best [\\s\\S]*$"));
		    } catch (Error e) {
		      verificationErrors.append(e.toString());
		}	    
	    // -- End Section
	    
	    // -- Section: search for 'Andrea Lee'
	    // Step: click Top-Left button to reveal Global Menu...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[1]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if (isElementPresent(By.xpath(".//*[@id='Mobile_SalesLogix_SpeedSearchWidget_0']/div/div[1]/input"))) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: perform a search of a target Opportunity...
	    driver.findElement(By.cssSelector("#Mobile_SalesLogix_SpeedSearchWidget_0 > div.table-layout > div > input[name=\"query\"]")).clear();
	    driver.findElement(By.cssSelector("#Mobile_SalesLogix_SpeedSearchWidget_0 > div.table-layout > div > input[name=\"query\"]")).sendKeys("Andrea Lee");
	    driver.findElement(By.cssSelector("#Mobile_SalesLogix_SpeedSearchWidget_0 > div.table-layout > div.hasButton > button.subHeaderButton.searchButton")).click();
	    try {
	      assertEquals("Search Results", driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText());
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if (isElementPresent(By.xpath(".//*[@id='speedsearch_list']/ul/li[1]"))) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // VP: check that the save is successful and that Validation Summary error is not displayed...
	    try {
		      AssertJUnit.assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Andrea Lee [\\s\\S]*$"));
		    } catch (Error e) {
		      verificationErrors.append(e.toString());
		}	    
	    
	    // End: navigate back to My Activities..
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[2]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("My Activities".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // -- End Section
	}
	
	
	@Test
	public void test19_MobileDefect13091788() throws Exception {
	    // SE Test: SETest-Defect_13091788
	    // Version: 2.2
	    // Desc: validates that it's possible to set Discount back to 0 %
	    // Pre-Run Steps: Logoff, then Log back in as 'Lee'...
	    // Required Entity: Opportunity - Advising Group Test Opp 200
	    // ====================================
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

	    // Step: perform a search of a target Opportunity...
	    assertEquals("Opportunities", driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText());
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_SearchWidget_11']/div/div[1]/input")).clear();
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_SearchWidget_11']/div/div[1]/input")).sendKeys("Abbott Ltd.-Phase-9");
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_SearchWidget_11']/div/div[3]/button")).click();
	    // Warning: verifyTextPresent may require manual changes
	    try {
	      assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Abbott Ltd\\.-Phase-9[\\s\\S]*$"));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: click the Opportunity list item for editing...
	    driver.findElement(By.xpath(".//*[@id='opportunity_list']/ul/li/div/h3")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Abbott Ltd.-Phase-9".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: click the Products link...
	    driver.findElement(By.xpath(".//*[@id='opportunity_detail']/div[2]/ul[2]/li[1]/a/span")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Products".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: click the Product link...
	    driver.findElement(By.xpath(".//*[@id='opportunityproduct_related']/ul/li[1]/div/h3")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Dell Optiplex".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: click Top Edit button to edit Product fields...
	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[2]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Opportunity Product".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: set the discount % field to 0.00
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_Fields_DecimalField_0']/input")).clear();
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_Fields_DecimalField_0']/input")).sendKeys("0.00");
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_Fields_DecimalField_1']/input")).click();
	    // Verify: check the values of the product and price fields...
	    try {
	      assertEquals("2200.00", driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Fields_MultiCurrencyField_2']/input")).getAttribute("value"));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    try {
	      assertEquals("2200.00", driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Fields_MultiCurrencyField_4']/input")).getAttribute("value"));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: click the Top Save button...
	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[2]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Dell Optiplex".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Verify: check the saved Price field values...
	    try {
	      assertEquals("0.00%", driver.findElement(By.xpath(".//*[@id='opportunityproduct_detail']/div[2]/div[1]/div[6]/span")).getText());
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    try {
	      assertEquals("2,200.00 USD", driver.findElement(By.xpath(".//*[@id='opportunityproduct_detail']/div[2]/div[2]/div[1]/span")).getText());
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    try {
	      assertEquals("2,200.00 USD", driver.findElement(By.xpath(".//*[@id='opportunityproduct_detail']/div[2]/div[2]/div[2]/span")).getText());
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    try {
	      assertEquals("2,200.00 USD", driver.findElement(By.xpath(".//*[@id='opportunityproduct_detail']/div[2]/div[3]/div/span")).getText());
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: navigate back...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[4]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Products".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Abbott Ltd.-Phase-9".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Opportunities".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // -- END
	}
	
	@Test
	public void test20_MobileDefect13091789() throws Exception {
	    // SE Test: SETest-Defect_13091789
	    // Version: 2.2
	    // Desc: validates that it's setting a Product's discount to 100% will set the Extended Price to 0.00
	    // Pre-Run Steps: Logoff, then Log back in as 'Lee'...
	    // Required Entity: Opportunity - Abbott Ltd.-Phase-9
	    // ====================================
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

	    // Step: perform a search of a target Opportunity...
	    assertEquals("Opportunities", driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText());
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_SearchWidget_11']/div/div[1]/input")).clear();
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_SearchWidget_11']/div/div[1]/input")).sendKeys("Abbott Ltd.-Phase-9");
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_SearchWidget_11']/div/div[3]/button")).click();
	    // Warning: verifyTextPresent may require manual changes
	    try {
	      assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Abbott Ltd\\.-Phase-9[\\s\\S]*$"));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: click the Opportunity list item for editing...
	    driver.findElement(By.xpath(".//*[@id='opportunity_list']/ul/li/div/h3")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Abbott Ltd.-Phase-9".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: click the Products link...
	    driver.findElement(By.xpath(".//*[@id='opportunity_detail']/div[2]/ul[2]/li[1]/a/span")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Products".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: click the Product link...
	    driver.findElement(By.xpath(".//*[@id='opportunityproduct_related']/ul/li[1]/div/h3")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Dell Optiplex".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: click Top Edit button to edit Product fields...
	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[2]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Opportunity Product".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: set the discount % field to 0.00
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_Fields_DecimalField_0']/input")).clear();
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_Fields_DecimalField_0']/input")).sendKeys("100.00");
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_Fields_DecimalField_1']/input")).click();
	    // Verify: check the values of the product and price fields...
	    try {
	      assertEquals("0.00", driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Fields_MultiCurrencyField_2']/input")).getAttribute("value"));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    try {
	      assertEquals("0.00", driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Fields_MultiCurrencyField_4']/input")).getAttribute("value"));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: click the Top Save button...
	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[2]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Dell Optiplex".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Verify: check the saved Price field values...
	    try {
	      assertEquals("100.00%", driver.findElement(By.xpath(".//*[@id='opportunityproduct_detail']/div[2]/div[1]/div[6]/span")).getText());
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    try {
	      assertEquals("0.00 USD", driver.findElement(By.xpath(".//*[@id='opportunityproduct_detail']/div[2]/div[2]/div[1]/span")).getText());
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    try {
	      assertEquals("0.00 USD", driver.findElement(By.xpath(".//*[@id='opportunityproduct_detail']/div[2]/div[2]/div[2]/span")).getText());
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    try {
	      assertEquals("0.00 USD", driver.findElement(By.xpath(".//*[@id='opportunityproduct_detail']/div[2]/div[3]/div/span")).getText());
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: navigate back...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[4]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Products".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Abbott Ltd.-Phase-9".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Opportunities".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // -- END
	}
	
	@Test
	public void test21_MobileDefect13091799() throws Exception {
	    // SE Test: SETest-Defect_13091799
	    // Version: 2.2
	    // Desc: validates that discount should consistently display with 2 decimal places as it does in the web client
	    // Pre-Run Steps: Logoff, then Log back in as 'Lee'...
	    // Required Entity: Opportunity - Abbott Ltd.-Phase-9
	    // ====================================
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

	    // Step: perform a search of a target Opportunity...
	    assertEquals("Opportunities", driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText());
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_SearchWidget_11']/div/div[1]/input")).clear();
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_SearchWidget_11']/div/div[1]/input")).sendKeys("Abbott Ltd.-Phase-9");
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_SearchWidget_11']/div/div[3]/button")).click();
	    // Warning: verifyTextPresent may require manual changes
	    try {
	      assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Abbott Ltd\\.-Phase-9[\\s\\S]*$"));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: click the Opportunity list item for editing...
	    driver.findElement(By.xpath(".//*[@id='opportunity_list']/ul/li/div/h3")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Abbott Ltd.-Phase-9".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: click the Products link...
	    driver.findElement(By.xpath(".//*[@id='opportunity_detail']/div[2]/ul[2]/li[1]/a/span")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Products".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: click the '+' button to add a new Product...
	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[2]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Opportunity Product".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: click Product lookup button to select a product...
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_Fields_LookupField_14']/button")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Products".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: search and select a Product...
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_SearchWidget_31']/div/div[1]/input")).clear();
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_SearchWidget_31']/div/div[1]/input")).sendKeys("10/100/1000 NIC");
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_SearchWidget_31']/div/div[3]/button")).click();
	    // Warning: waitForTextPresent may require manual changes
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if (driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*10/100/1000 NIC[\\s\\S]*$")) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    driver.findElement(By.xpath(".//*[@id='product_related']/ul/li/div/h3")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Opportunity Product".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Verify: check the values of the product and price fields...
	    try {
	      assertEquals("10/100/1000 NIC", driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_Fields_LookupField_14']/input")).getAttribute("value"));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    try {
	      assertEquals("200.00", driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Fields_MultiCurrencyField_1']/input")).getAttribute("value"));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: select a Price Level selection...
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_Fields_LookupField_15']/button")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Product Programs".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    driver.findElement(By.xpath(".//*[@id='productprogram_related']/ul/li[1]/div/h3")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Opportunity Product".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Verify: check the value of the 1st extended price
	    try {
	      assertEquals("Retail", driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_Fields_LookupField_15']/input")).getAttribute("value"));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    try {
	      assertEquals("200.00", driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Fields_MultiCurrencyField_4']/input")).getAttribute("value"));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: enter a discount with a two-decimal value...
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_Fields_DecimalField_0']/input")).clear();
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_Fields_DecimalField_0']/input")).sendKeys("25.45");
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_Fields_DecimalField_1']/input")).click();
	    // Step: click the Top Save button...
	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[2]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Products".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Warning: verifyTextPresent may require manual changes
	    try {
	      assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*10/100/1000 NIC[\\s\\S]*$"));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: click the Product link to view the detail view...
	    driver.findElement(By.xpath(".//*[@id='opportunityproduct_related']/descendant::*[text() = '10/100/1000 NIC']")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("10/100/1000 NIC".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Verify: the saved Price field values...
	    try {
	      assertEquals("25.45%", driver.findElement(By.xpath(".//*[@id='opportunityproduct_detail']/div[2]/div[1]/div[6]/span")).getText());
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    try {
	      assertEquals("149.10 USD", driver.findElement(By.xpath(".//*[@id='opportunityproduct_detail']/div[2]/div[2]/div[1]/span")).getText());
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    try {
	      assertEquals("149.10 USD", driver.findElement(By.xpath(".//*[@id='opportunityproduct_detail']/div[2]/div[2]/div[2]/span")).getText());
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    try {
	      assertEquals("149.10 USD", driver.findElement(By.xpath(".//*[@id='opportunityproduct_detail']/div[2]/div[3]/div/span")).getText());
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: navigate back...
	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[4]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Products".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Abbott Ltd.-Phase-9".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Opportunities".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // -- END
	}
	
	@Test
	public void test22_MobileDefect13091801() throws Exception {
	    // SE Test: SETest-Defect_13091801
	    // Version: 2.2
	    // Desc: validates that completing an occurrence of a Recurring Activity will not complete the entire series
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

	    // Step: navigate to Calendar view to add a new Recurring Activity...
	    driver.findElement(By.xpath(".//*[@id='left_drawer']/descendant::*[text() = \"Calendar\"]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Calendar".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: click the "+" to add a new Calendar event...
	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[2]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Schedule...".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: select the Meeting link...
	    driver.findElement(By.cssSelector("#activity_types_list > ul.list-content > li > div.list-item-content > h3")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Meeting".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: setup the new Activity fields...
	    driver.findElement(By.cssSelector("#Mobile_SalesLogix_Fields_PicklistField_28 > button.button.simpleSubHeaderButton")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Activity Description".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    driver.findElement(By.xpath(".//*[@id='pick_list_0']/ul/li[5]/div/h3")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Meeting".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    driver.findElement(By.cssSelector("input[name=\"Location\"]")).clear();
	    driver.findElement(By.cssSelector("input[name=\"Location\"]")).sendKeys("Arriba");
	    driver.findElement(By.cssSelector("#Mobile_SalesLogix_Fields_PicklistField_30 > button.button.simpleSubHeaderButton")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Activity Category".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    driver.findElement(By.xpath(".//*[@id='pick_list_0']/ul/li[5]/div/h3")).click();
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

	    driver.findElement(By.cssSelector("tr.plus > td > button.button")).click();
	    driver.findElement(By.cssSelector("tr.plus > td > button.button")).click();
	    new Select(driver.findElement(By.id("day-field"))).selectByVisibleText("29");
	    new Select(driver.findElement(By.id("hour-field"))).selectByVisibleText("11");
	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[2]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Meeting".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    driver.findElement(By.cssSelector("#Sage_Platform_Mobile_Fields_SelectField_1 > button.button.simpleSubHeaderButton")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Recurring".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    driver.findElement(By.xpath(".//*[@id='select_list']/ul/li[3]/div/h3")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Meeting".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    driver.findElement(By.cssSelector("#Mobile_SalesLogix_Fields_RecurrencesField_0 > button.button.simpleSubHeaderButton")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Recurrence".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    driver.findElement(By.cssSelector("input[name=\"RecurIterations\"]")).clear();
	    driver.findElement(By.cssSelector("input[name=\"RecurIterations\"]")).sendKeys("5");
	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[2]")).click();
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

	    driver.findElement(By.xpath(".//*[@id='select_list']/ul/li[6]/div/h3")).click();
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
	    driver.findElement(By.cssSelector("textarea[name=\"Notes\"]")).sendKeys("Recurring test activity for Defect# 13091801");
	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[2]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Meeting".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    driver.findElement(By.cssSelector("#Sage_Platform_Mobile_Fields_LookupField_29 > button.button.simpleSubHeaderButton")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Contacts".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    driver.findElement(By.cssSelector("#Sage_Platform_Mobile_SearchWidget_7 > div.table-layout > div > input[name=\"query\"]")).clear();
	    driver.findElement(By.cssSelector("#Sage_Platform_Mobile_SearchWidget_7 > div.table-layout > div > input[name=\"query\"]")).sendKeys("Adi");
	    driver.findElement(By.cssSelector("#Sage_Platform_Mobile_SearchWidget_7 > div.table-layout > div.hasButton > button.subHeaderButton.searchButton")).click();
	    driver.findElement(By.xpath(".//*[@id='contact_related']/ul/li/div/h3")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Meeting".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: click top Save button to save the new Activity...
	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[2]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Calendar".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: navigate to Contacts detail page to view the Activity list...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("My Activities".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: click Top-Left button to reveal Global Menu...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[1]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if (isElementPresent(By.xpath(".//*[@id='Mobile_SalesLogix_SpeedSearchWidget_0']/div/div[1]/input"))) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }	    
	    driver.findElement(By.xpath(".//*[@id='left_drawer']/descendant::*[text() = \"Contacts\"]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Contacts".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_SearchWidget_6']/div/div[1]/input")).clear();
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_SearchWidget_6']/div/div[1]/input")).sendKeys("Adi");
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_SearchWidget_6']/div/div[3]/button")).click();
	    Thread.sleep(3000);
	    driver.findElement(By.xpath(".//*[@id='contact_list']/descendant::*[text() = 'Adi, Douglas']")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Adi, Douglas".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    driver.findElement(By.xpath("//div[@id='contact_detail']/div[2]/ul[2]/li/a/span")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Activities".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    try {
	      assertTrue(driver.findElement(By.xpath(".//*[@id='activity_related']/ul/li[1]/div[2]/h3/span[3]")).getText().matches("^[\\s\\S]*Lunch meeting$"));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    try {
	      assertTrue(driver.findElement(By.xpath(".//*[@id='activity_related']/ul/li[2]/div[2]/h3/span[3]")).getText().matches("^[\\s\\S]*Lunch meeting$"));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    try {
	      assertTrue(driver.findElement(By.xpath(".//*[@id='activity_related']/ul/li[3]/div[2]/h3/span[3]")).getText().matches("^[\\s\\S]*Lunch meeting$"));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    try {
	      assertTrue(driver.findElement(By.xpath(".//*[@id='activity_related']/ul/li[4]/div[2]/h3/span[3]")).getText().matches("^[\\s\\S]*Lunch meeting$"));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    try {
	      assertTrue(driver.findElement(By.xpath(".//*[@id='activity_related']/ul/li[5]/div[2]/h3/span[3]")).getText().matches("^[\\s\\S]*Lunch meeting$"));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: re-open one of the Activity occurrences to complete it...
	    driver.findElement(By.xpath(".//*[@id='activity_related']/ul/li[1]/div[2]/h3/span[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Meeting - Regarding: Lunch meeting".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    driver.findElement(By.xpath(".//*[@id='activity_detail']/descendant::*[text() = 'Complete Series']")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Complete Series".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    driver.findElement(By.xpath("//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[2]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Activities".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Verify: remaining Recurring Activities are still listed in the Activities list view...
	    try {
	      assertTrue(driver.findElement(By.xpath(".//*[@id='activity_related']/ul/li[1]/div[2]/h3/span[3]")).getText().matches("^[\\s\\S]*Lunch meeting$"));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    try {
	      assertTrue(driver.findElement(By.xpath(".//*[@id='activity_related']/ul/li[2]/div[2]/h3/span[3]")).getText().matches("^[\\s\\S]*Lunch meeting$"));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    try {
	      assertTrue(driver.findElement(By.xpath(".//*[@id='activity_related']/ul/li[3]/div[2]/h3/span[3]")).getText().matches("^[\\s\\S]*Lunch meeting$"));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    try {
	      assertTrue(driver.findElement(By.xpath(".//*[@id='activity_related']/ul/li[4]/div[2]/h3/span[3]")).getText().matches("^[\\s\\S]*Lunch meeting$"));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    try {
	      assertFalse(driver.findElement(By.xpath(".//*[@id='activity_related']/ul/li[5]/div[2]/h3/span[3]")).getText().matches("^[\\s\\S]*Lunch meeting$"));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: Navigate back to the Home screen...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[1]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if (isElementPresent(By.xpath(".//*[@id='Mobile_SalesLogix_SpeedSearchWidget_0']/div/div[1]/input"))) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    driver.findElement(By.xpath(".//*[@id='left_drawer']/descendant::*[text() = \"My Activities\"]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("My Activities".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // -- END
	}
	
	@Test
	public void test23_MobileDefect13091804() throws Exception {
	    // SE Test: SETest-Defect_13091804
	    // Version: 2.2
	    // Desc: validates that can empty Quantity before saving and empty value saved in database
	    // Pre-Run Steps: Logoff, then Log back in as 'Lee'...
	    // Required Entity: Opportunity - Abbott Ltd.-Phase-9
	    // ====================================
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

	    // Step: perform a search of a target Opportunity...
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Opportunities".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_SearchWidget_11']/div/div[1]/input")).clear();
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_SearchWidget_11']/div/div[1]/input")).sendKeys("Abbott Ltd.-Phase-9");
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_SearchWidget_11']/div/div[3]/button")).click();
	    // Warning: verifyTextPresent may require manual changes
	    try {
	      assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Abbott Ltd\\.-Phase-9[\\s\\S]*$"));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: click the Opportunity list item for editing...
	    driver.findElement(By.xpath(".//*[@id='opportunity_list']/ul/li/div/h3")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Abbott Ltd.-Phase-9".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: click the Products link...
	    driver.findElement(By.xpath(".//*[@id='opportunity_detail']/div[2]/ul[2]/li[1]/a/span")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Products".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: click the '+' button to add a new Product...
	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[2]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Opportunity Product".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: click Product lookup button to select a product...
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_Fields_LookupField_14']/button")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Products".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: search and select a Product...
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_SearchWidget_31']/div/div[1]/input")).clear();
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_SearchWidget_31']/div/div[1]/input")).sendKeys("BlackBerry");
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_SearchWidget_31']/div/div[3]/button")).click();
	    // Warning: verifyTextPresent may require manual changes
	    try {
	      assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*BlackBerry[\\s\\S]*$"));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    driver.findElement(By.xpath(".//*[@id='product_related']/ul/li/div/h3")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Opportunity Product".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Verify: check the values of the product and price fields...
	    try {
	      assertEquals("BlackBerry", driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_Fields_LookupField_14']/input")).getAttribute("value"));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    try {
	      assertEquals("399.00", driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Fields_MultiCurrencyField_1']/input")).getAttribute("value"));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    try {
	      assertEquals("399.00", driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Fields_MultiCurrencyField_4']/input")).getAttribute("value"));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: select a Price level field value...
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_Fields_LookupField_15']/button")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Product Programs".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    driver.findElement(By.xpath(".//*[@id='productprogram_related']/ul/li[1]/div/h3")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Opportunity Product".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: blank-out the Quantity field value...
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_Fields_DecimalField_1']/input")).clear();
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_Fields_DecimalField_1']/input")).sendKeys("0.00");
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Fields_MultiCurrencyField_2']/input")).click();
	    // Verify: check the value of the 1st extended price
	    try {
	      assertEquals("0.00", driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Fields_MultiCurrencyField_4']/input")).getAttribute("value"));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: click the Top Save button...
	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[2]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Products".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Warning: verifyTextPresent may require manual changes
	    try {
	      assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*BlackBerry[\\s\\S]*$"));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: click the Product link to view the detail view...
	    driver.findElement(By.xpath(".//*[@id='opportunityproduct_related']/descendant::*[text()=\"BlackBerry\"]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("BlackBerry".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Verify: the saved Quantity and Extended Price field values...
	    try {
	      assertEquals("0", driver.findElement(By.xpath(".//*[@id='opportunityproduct_detail']/div[2]/div[1]/div[7]/span")).getText());
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    try {
	      assertEquals("0.00 USD", driver.findElement(By.xpath(".//*[@id='opportunityproduct_detail']/div[2]/div[3]/div/span")).getText());
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: navigate back to the Home screen...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[4]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Products".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Abbott Ltd.-Phase-9".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Opportunities".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // -- END
	}
	
	@Test
	public void test24_MobileDefect13091805() throws Exception {
	    // SE Test: SETest-Defect_13091805
	    // Version: 2.2
	    // Desc: validates that on changing Quantity to 0, extended price is updated correctly
	    // Pre-Run Steps: Logoff, then Log back in as 'Lee'...
	    // Required Entity: Opportunity - Abbott Ltd.-Phase-9
	    // ====================================
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

	    // Step: perform a search of a target Opportunity...
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Opportunities".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_SearchWidget_11']/div/div[1]/input")).clear();
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_SearchWidget_11']/div/div[1]/input")).sendKeys("Abbott Ltd.-Phase-9");
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_SearchWidget_11']/div/div[3]/button")).click();
	    // Warning: verifyTextPresent may require manual changes
	    try {
	      assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Abbott Ltd\\.-Phase-9[\\s\\S]*$"));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: click the Opportunity list item for editing...
	    driver.findElement(By.xpath(".//*[@id='opportunity_list']/ul/li/div/h3")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Abbott Ltd.-Phase-9".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: click the Products link...
	    driver.findElement(By.xpath(".//*[@id='opportunity_detail']/div[2]/ul[2]/li[1]/a/span")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Products".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: click the '+' button to add a new Product...
	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[2]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Opportunity Product".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: click Product lookup button to select a product...
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_Fields_LookupField_14']/button")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Products".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: search and select a Product...
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_SearchWidget_31']/div/div[1]/input")).clear();
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_SearchWidget_31']/div/div[1]/input")).sendKeys("GoStore 200GB");
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_SearchWidget_31']/div/div[3]/button")).click();
	    // Warning: verifyTextPresent may require manual changes
	    try {
	      assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*GoStore 200GB[\\s\\S]*$"));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    driver.findElement(By.xpath(".//*[@id='product_related']/ul/li/div/h3")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Opportunity Product".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Verify: check the values of the product and price fields...
	    try {
	      assertEquals("GoStore 200GB", driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_Fields_LookupField_14']/input")).getAttribute("value"));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: select a Price level field value...
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_Fields_LookupField_15']/button")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Product Programs".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    driver.findElement(By.xpath(".//*[@id='productprogram_related']/ul/li[1]/div/h3")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Opportunity Product".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Verify: check the initial Quanity and Price field values...
	    try {
	      assertEquals("199.00", driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Fields_MultiCurrencyField_1']/input")).getAttribute("value"));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    try {
	      assertEquals("1.00", driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_Fields_DecimalField_1']/input")).getAttribute("value"));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    try {
	      assertEquals("199.00", driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Fields_MultiCurrencyField_4']/input")).getAttribute("value"));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: blank-out the Quantity field value...
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_Fields_DecimalField_1']/input")).clear();
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_Fields_DecimalField_1']/input")).sendKeys("0.00");
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Fields_MultiCurrencyField_2']/input")).click();
	    // Verify: check the value of the 1st extended price
	    try {
	      assertEquals("0.00", driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Fields_MultiCurrencyField_4']/input")).getAttribute("value"));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: click the Top Save button...
	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[2]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Products".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Warning: verifyTextPresent may require manual changes
	    try {
	      assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*BlackBerry[\\s\\S]*$"));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: click the Product link to view the detail view...
	    driver.findElement(By.xpath(".//*[@id='opportunityproduct_related']/descendant::*[text()=\"GoStore 200GB\"]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("GoStore 200GB".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Verify: the saved Quantity and Extended Price field values...
	    try {
	      assertEquals("0", driver.findElement(By.xpath(".//*[@id='opportunityproduct_detail']/div[2]/div[1]/div[7]/span")).getText());
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    try {
	      assertEquals("0.00 USD", driver.findElement(By.xpath(".//*[@id='opportunityproduct_detail']/div[2]/div[3]/div/span")).getText());
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: navigate back to the Home screen...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[4]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Products".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Abbott Ltd.-Phase-9".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Opportunities".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // -- END
	}
	
	@Test
	public void test25_MobileDefect13091808() throws Exception {
	    // SE Test: SETest-Defect_13091808
	    // Version: 2.2
	    // Desc: validates that where base price is 0, on setting adj price to value other than 0, seeing discount display NaN.ty
	    // Pre-Run Steps: Logoff, then Log back in as 'Lee'...
	    // Required Entity: Opportunity - Abbott Ltd.-Phase-9
	    // ====================================
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

	    // Step: perform a search of a target Opportunity...
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Opportunities".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_SearchWidget_11']/div/div[1]/input")).clear();
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_SearchWidget_11']/div/div[1]/input")).sendKeys("Abbott Ltd.-Phase-9");
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_SearchWidget_11']/div/div[3]/button")).click();
	    // Warning: verifyTextPresent may require manual changes
	    try {
	      assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Abbott Ltd\\.-Phase-9[\\s\\S]*$"));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: click the Opportunity list item for editing...
	    driver.findElement(By.xpath(".//*[@id='opportunity_list']/ul/li/div/h3")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Abbott Ltd.-Phase-9".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: click the Products link...
	    driver.findElement(By.xpath(".//*[@id='opportunity_detail']/div[2]/ul[2]/li[1]/a/span")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Products".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: click the '+' button to add a new Product...
	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[2]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Opportunity Product".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: click Product lookup button to select a product...
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_Fields_LookupField_14']/button")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Products".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: search and select a Product...
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_SearchWidget_31']/div/div[1]/input")).clear();
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_SearchWidget_31']/div/div[1]/input")).sendKeys("55 Gallon Drum");
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_SearchWidget_31']/div/div[3]/button")).click();
	    // Warning: waitForTextPresent may require manual changes
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if (driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*55 Gallon Drum[\\s\\S]*$")) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    driver.findElement(By.xpath(".//*[@id='product_related']/ul/li/div/h3")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Opportunity Product".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Verify: check the values of the product and price fields...
	    try {
	      assertEquals("55 Gallon Drum", driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_Fields_LookupField_14']/input")).getAttribute("value"));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: select a Price level field value...
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_Fields_LookupField_15']/button")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Product Programs".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    driver.findElement(By.xpath(".//*[@id='productprogram_related']/descendant::*[text()=\"MSRP\"]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Opportunity Product".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Verify: check the initial Quanity and Price field values...
	    try {
	      assertEquals("0.00", driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Fields_MultiCurrencyField_1']/input")).getAttribute("value"));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    try {
	      assertEquals("1.00", driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_Fields_DecimalField_1']/input")).getAttribute("value"));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    try {
	      assertEquals("0.00", driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Fields_MultiCurrencyField_4']/input")).getAttribute("value"));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: modify the Adjusted Price field value...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Fields_MultiCurrencyField_2']/input")).clear();
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Fields_MultiCurrencyField_2']/input")).sendKeys("300.00");
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Fields_MultiCurrencyField_4']/input")).click();
	    // Verify: check the updated Extended Price field value
	    try {
	      assertEquals("300.00", driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Fields_MultiCurrencyField_4']/input")).getAttribute("value"));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: click the Top Save button...
	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[2]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Products".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Warning: verifyTextPresent may require manual changes
	    try {
	      assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*55 Gallon Drum[\\s\\S]*$"));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: click the Product link to view the detail view...
	    driver.findElement(By.xpath(".//*[@id='opportunityproduct_related']/descendant::*[text()='55 Gallon Drum ']")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("55 Gallon Drum".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Verify: the saved Quantity and Extended Price field values...
	    try {
	      assertEquals("1", driver.findElement(By.xpath(".//*[@id='opportunityproduct_detail']/div[2]/div[1]/div[7]/span")).getText());
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    try {
	      assertEquals("300.00 USD", driver.findElement(By.xpath(".//*[@id='opportunityproduct_detail']/div[2]/div[3]/div/span")).getText());
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: navigate back to the Home screen...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[4]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Products".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Abbott Ltd.-Phase-9".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Opportunities".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // -- END
	}
	
	@Test
	//POSS. BUG: no results returned during SpeedSearch operations...just 'loading' indicator
	public void test26_MobileDefect13091809() throws Exception {
	    // SE Test: SETest-Defect_13091809
	    // Version: 2.2
	    // Desc: validates that no debug error is returned
	    // Required Entity: N/A
	    // ====================================
	    // - Start Section: search for "and*"
	    // Step: click Top-Left button to reveal Global Menu...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[1]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if (isElementPresent(By.xpath(".//*[@id='Mobile_SalesLogix_SpeedSearchWidget_0']/div/div[1]/input"))) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: perform a SpeedSearch for a special-char case...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_SpeedSearchWidget_0']/div/div[1]/input")).clear();
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_SpeedSearchWidget_0']/div/div[1]/input")).sendKeys("and*");
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_SpeedSearchWidget_0']/div/div[3]/button")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Search Results".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // VP: check that search results are returned
	    try {
	      assertTrue(isElementPresent(By.xpath("//div[@id='speedsearch_list']/ul/li[1]")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: click and open the 1st result link...
	    driver.findElement(By.cssSelector("li > h3")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Contact".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: navigate back...
	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    // - End Section
	    // - Start Section: search for "mimi"
	    // Step: click Top-Left button to reveal Global Menu...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[1]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if (isElementPresent(By.cssSelector("div.group-content > ul.list-content. > li"))) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: perform a SpeedSearch for a special-char case...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_SpeedSearchWidget_0']/div/div[1]/input")).clear();
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_SpeedSearchWidget_0']/div/div[1]/input")).sendKeys("mimi");
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_SpeedSearchWidget_0']/div/div[3]/button")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Search Results".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // VP: check that search results are returned
	    try {
	      assertEquals("Mimi's Test Note - add an attachment (2012_10_26)", driver.findElement(By.cssSelector("li > h3")).getText());
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: click and open the 1st result link...
	    driver.findElement(By.cssSelector("li > h3")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("History".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    try {
	      assertEquals("The requested entry is not available.", driver.findElement(By.cssSelector("div.not-available")).getText());
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: navigate back...
	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    // - End Section
	    // - Start Section: search for "philanthropic"
	    // Step: click Top-Left button to reveal Global Menu...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[1]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if (isElementPresent(By.cssSelector("div.group-content > ul.list-content. > li"))) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: perform a SpeedSearch for a special-char case...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_SpeedSearchWidget_0']/div/div[1]/input")).clear();
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_SpeedSearchWidget_0']/div/div[1]/input")).sendKeys("philanthropic");
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_SpeedSearchWidget_0']/div/div[3]/button")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Search Results".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // VP: check that search results are returned
	    try {
	      assertTrue(isElementPresent(By.cssSelector("#speedsearch_list > ul.list-content > li")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: click and open the 1st result link...
	    driver.findElement(By.cssSelector("li > h3")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Contact".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: navigate back...
	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    // - End Section
	    // Step: reset the Search Results...
	    driver.findElement(By.cssSelector("#Mobile_SalesLogix_SpeedSearchWidget_1 > div.table-layout > div.hasButton > button.clear-button")).click();
	    // -- END
	}
	
	@Test
	//POSS. BUG: no results returned during SpeedSearch operations...just 'loading' indicator
	public void test27_MobileDefect13091813() throws Exception {
	    // SE Test: SETest-Defect_13091813
	    // Version: 2.2
	    // Desc: validates that no error is returned on spcial case scenario
	    // Required Entity: N/A
	    // ====================================
	    // Step: click Top-Left button to reveal Global Menu...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[1]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if (isElementPresent(By.xpath(".//*[@id='Mobile_SalesLogix_SpeedSearchWidget_0']/div/div[1]/input"))) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: perform a SpeedSearch for a special-char case...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_SpeedSearchWidget_0']/div/div[1]/input")).clear();
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_SpeedSearchWidget_0']/div/div[1]/input")).sendKeys("sophia perez");
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_SpeedSearchWidget_0']/div/div[3]/button")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Search Results".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // VP: check that search results are returned
	    try {
	      assertTrue(isElementPresent(By.xpath("//div[@id='speedsearch_list']/ul/li[1]")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: click to open a specific results link...
	    // Warning: verifyTextNotPresent may require manual changes
	    try {
	      assertFalse(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*no records[\\s\\S]*$"));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Warning: verifyTextPresent may require manual changes
	    try {
	      assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Database Change[\\s\\S]*$"));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    driver.findElement(By.xpath(".//*[@id='speedsearch_list']/ul/li[1]/h3")).click();
	    try {
	      assertEquals("History", driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText());
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // End: navigate back to Home...
	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Search Results".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    driver.findElement(By.cssSelector("#Mobile_SalesLogix_SpeedSearchWidget_1 > div.table-layout > div.hasButton > button.clear-button")).click();
	    // -- END
	}
	
	@Test
	public void test28_MobileDefect13091819() throws Exception {
	    // SE Test: SETest-Defect_13091819
	    // Version: 2.2
	    // Desc: validates that when opening an activity occurrence detail view from My Activities, completing occurrence completes the entire series, whereas same does not happen when opening the activity occurrence detail view from the contact activity list
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

	    driver.findElement(By.cssSelector("#activity_types_list > ul.list-content > li > div.list-item-content > h3")).click();
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

	    driver.findElement(By.xpath(".//*[@id='pick_list_0']/ul/li[5]/div/h3")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Meeting".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    driver.findElement(By.cssSelector("input[name=\"Location\"]")).clear();
	    driver.findElement(By.cssSelector("input[name=\"Location\"]")).sendKeys("Arriba");
	    driver.findElement(By.cssSelector("#Mobile_SalesLogix_Fields_PicklistField_30 > button.button.simpleSubHeaderButton")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Activity Category".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    driver.findElement(By.xpath(".//*[@id='pick_list_0']/ul/li[5]/div/h3")).click();
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

	    driver.findElement(By.cssSelector("td > button.button")).click();
	    driver.findElement(By.cssSelector("td > button.button")).click();
	    driver.findElement(By.cssSelector("td > button.button")).click();
	    new Select(driver.findElement(By.id("day-field"))).selectByVisibleText("30");
	    new Select(driver.findElement(By.id("hour-field"))).selectByVisibleText("11");
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[2]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Meeting".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    driver.findElement(By.cssSelector("#Sage_Platform_Mobile_Fields_SelectField_1 > button.button.simpleSubHeaderButton")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Recurring".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    driver.findElement(By.xpath(".//*[@id='select_list']/ul/li[3]/div/h3")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Meeting".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    driver.findElement(By.cssSelector("#Mobile_SalesLogix_Fields_RecurrencesField_0 > button.button.simpleSubHeaderButton")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Recurrence".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    driver.findElement(By.cssSelector("input[name=\"RecurIterations\"]")).clear();
	    driver.findElement(By.cssSelector("input[name=\"RecurIterations\"]")).sendKeys("5");
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

	    driver.findElement(By.xpath(".//*[@id='select_list']/descendant::*[text() = '30 minutes']")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Meeting".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_Fields_NoteField_6']/button")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Notes".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    driver.findElement(By.cssSelector("textarea[name=\"Notes\"]")).clear();
	    driver.findElement(By.cssSelector("textarea[name=\"Notes\"]")).sendKeys("Recurring test activity for Defect# 13091819");
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

	    driver.findElement(By.cssSelector("#Sage_Platform_Mobile_SearchWidget_7 > div.table-layout > div > input[name=\"query\"]")).clear();
	    driver.findElement(By.cssSelector("#Sage_Platform_Mobile_SearchWidget_7 > div.table-layout > div > input[name=\"query\"]")).sendKeys("Adi");
	    driver.findElement(By.cssSelector("#Sage_Platform_Mobile_SearchWidget_7 > div.table-layout > div.hasButton > button.subHeaderButton.searchButton")).click();
	    driver.findElement(By.xpath(".//*[@id='contact_related']/ul/li/div/h3")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Meeting".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[2]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("My Activities".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: navigate to Contacts detail page to view the Activity list...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[1]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if (isElementPresent(By.xpath(".//*[@id='Mobile_SalesLogix_SpeedSearchWidget_0']/div/div[1]/input"))) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    driver.findElement(By.xpath(".//*[@id='left_drawer']/descendant::*[text() = \"Contacts\"]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Contacts".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_SearchWidget_6']/div/div[1]/input")).clear();
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_SearchWidget_6']/div/div[1]/input")).sendKeys("Adi");
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_SearchWidget_6']/div/div[3]/button")).click();
	    driver.findElement(By.xpath(".//*[@id='contact_list']/ul/li/div/h3")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Adi, Douglas".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    driver.findElement(By.xpath("//div[@id='contact_detail']/div[2]/ul[2]/li/a/span")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Activities".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    try {
	      assertTrue(driver.findElement(By.xpath(".//*[@id='activity_related']/ul/li[1]/div[2]/h3/span[3]")).getText().matches("^[\\s\\S]*Lunch meeting$"));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    try {
	      assertTrue(driver.findElement(By.xpath(".//*[@id='activity_related']/ul/li[2]/div[2]/h3/span[3]")).getText().matches("^[\\s\\S]*Lunch meeting$"));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    try {
	      assertTrue(driver.findElement(By.xpath(".//*[@id='activity_related']/ul/li[3]/div[2]/h3/span[3]")).getText().matches("^[\\s\\S]*Lunch meeting$"));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    try {
	      assertTrue(driver.findElement(By.xpath(".//*[@id='activity_related']/ul/li[4]/div[2]/h3/span[3]")).getText().matches("^[\\s\\S]*Lunch meeting$"));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    try {
	      assertTrue(driver.findElement(By.xpath(".//*[@id='activity_related']/ul/li[5]/div[2]/h3/span[3]")).getText().matches("^[\\s\\S]*Lunch meeting$"));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: navigate back to the Home Screen then navigate to the My Activities list view...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[1]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if (isElementPresent(By.xpath(".//*[@id='Mobile_SalesLogix_SpeedSearchWidget_0']/div/div[1]/input"))) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    driver.findElement(By.xpath(".//*[@id='left_drawer']/descendant::*[text() = \"My Activities\"]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("My Activities".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: re-open one of the Activity occurrences to complete it...
	    driver.findElement(By.xpath(".//*[@id='myactivity_list']/ul/li[1]/div[2]/h3/span[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Activity".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: Complete this occurrency of the Activity...
	    try {
	      assertEquals("Complete Occurrence", driver.findElement(By.xpath(".//*[@id='activity_detail']/div[2]/ul/li[1]/a/label")).getText());
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    try {
	      assertEquals("Complete Series", driver.findElement(By.xpath(".//*[@id='activity_detail']/div[2]/ul/li[2]/a/label")).getText());
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    driver.findElement(By.xpath(".//*[@id='activity_detail']/div[2]/ul[1]/li[2]/a/label")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Complete Series".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[2]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("My Activities".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Verify: remaining Recurring Activities are still listed in the Activities list view...
	    try {
	      assertFalse(driver.findElement(By.xpath(".//*[@id='myactivity_list']/ul/li[1]/div[2]/h3/span[3]")).getText().matches("^[\\s\\S]*Lunch meeting$"));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // -- END
	}
	
	@Test
	public void test29_MobileDefect13091841() throws Exception {
	    // SE Test: SETest-Defect_13091841
	    // Version: 2.2
	    // Desc: checks to see that the default Opportunity does not have 'null' for it's name field value
	    // Pre-Run Steps: Logoff, then Log back in as 'Lee'...
	    // Required Entity: TBD
	    // ====================================
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

	    // Step: click the Top "+" (Add) button...
	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[2]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Opportunity".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Verify: check that the Opportunity field value is not 'null'...
	    try {
	      assertThat("null", is(not(driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_Fields_TextField_19']/input")).getAttribute("value"))));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // 'End: navigate back to Home...
	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Opportunities".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("My Activities".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // -- END
	}

	@Test
	public void test30_MobileDefect13091842() throws Exception {
	    // SE Test: SETest-Defect_13091842
	    // Version: 2.2
	    // Desc: checks that there is no error when a new Opportunity record is saved...
	    // Pre-Run Steps: Logoff, then Log back in as 'Lee'...
	    // Required Entity: TBD
	    // ====================================
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

	    // Step: click the Top "+" (Add) button...
	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[2]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Opportunity".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Step: setup the required fields of the new Opportunity...
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_Fields_TextField_19']/input")).clear();
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_Fields_TextField_19']/input")).sendKeys("Test Opp for Defect Fix Test-13091842");
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_Fields_LookupField_6']/button")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Accounts".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    driver.findElement(By.xpath(".//*[@id='account_related']/descendant::*[text()=\"Abbott WorldWide\"]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Opportunity".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Verify: save the Opportunity and confirm that there is no error message...
	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[2]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Opportunities".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    // Warning: assertTextPresent may require manual changes
	    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Test Opp for Defect Fix Test-13091842[\\s\\S]*$"));
	    // 'End: navigate back to Home...
	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("My Activities".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
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
