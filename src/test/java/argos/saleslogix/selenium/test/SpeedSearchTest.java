package argos.saleslogix.selenium.test;

import argos.saleslogix.selenium.CommonNavigation;
import argos.saleslogix.selenium.HeaderButton;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;

public class SpeedSearchTest extends BrowserSetup {
	
CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);


	@Test(enabled = true)
	public void test01_SeTestTCSpeedSearchGeneral() throws Exception {
		// SE Test: SETest-TC-SpeedSearch-General
	    // Version: 2.3
	    // Desc: performs general searches to validate Global Search functionality
	    // Required Entity: TYPE - NAME
	    // ====================================
		String methodID = "test01_SeTestTCSpeedSearchGeneral";
		
		HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);
				
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
		
	    //Step: click Top-Left button to reveal Global Menu...
		headerButton.showGlobalMenu();
		
	    //Step: UI element check
	    AssertJUnit.assertTrue(isElementPresent(By.cssSelector("#Mobile_SalesLogix_SpeedSearchWidget_0 > div.table-layout > div > input[name=\"query\"]")));
	    AssertJUnit.assertTrue(isElementPresent(By.cssSelector("#Mobile_SalesLogix_SpeedSearchWidget_0 > div.table-layout > div.hasButton > button.subHeaderButton.searchButton")));
	    
		//click the Page Title (forces closure of any blocking panels)
		driver.findElement(By.id("pageTitle")).click();
		Thread.sleep(1000);
	    
	    //-- Section: Execute some global searches in the mobile client
	    //Step: perform 1st global search...
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
	    String firstSearchItem = "blackberry";
	    
	    commNav.searchListView("speedsearch", firstSearchItem);
	
	    //Step: check search results... 
	    try {
	      AssertJUnit.assertFalse(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*no records[\\s\\S]*$"));
	    } catch (Error e) {
	      verificationErrors.append(methodID + "(): " + e.toString());
	    }
	    try {
	      AssertJUnit.assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*" + firstSearchItem + "[\\s\\S]*$"));
	    } catch (Error e) {
	      verificationErrors.append(methodID + "(): " + e.toString());
	    }
	    
	    //Step: click to open the top Search Results link...
	    driver.findElement(By.xpath(".//*[@id='speedsearch_list']/ul/li[1]")).click();
	    Thread.sleep(3000);
	    commNav.waitForNotPage("SpeedSearch");	    
	    
	    //Step: navigate back...
	    headerButton.goBack();
	    
	    
	    //Step: perform 2nd global search...
		commNav = PageFactory.initElements(driver, CommonNavigation.class);
	    String secondSearchItem = "blackberri";
	    
	    commNav.searchListView("speedsearch", secondSearchItem);
	
	    //Step: check search results... 
	    try {
	      AssertJUnit.assertFalse(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*no records[\\s\\S]*$"));
	    } catch (Error e) {
	      verificationErrors.append(methodID + "(): " + e.toString());
	    }
	    try {
	      AssertJUnit.assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*" + secondSearchItem + "[\\s\\S]*$"));
	    } catch (Error e) {
	      verificationErrors.append(methodID + "(): " + e.toString());
	    }
	    
	    //Step: click to open the top Search Results link...
	    driver.findElement(By.xpath(".//*[@id='speedsearch_list']/ul/li[1]")).click();
	    Thread.sleep(3000);
	    commNav.waitForNotPage("SpeedSearch");	    
	    
	    //Step: navigate back...
	    headerButton.goBack();
	    
	    
	    // Step: perform 3rd global search...
		commNav = PageFactory.initElements(driver, CommonNavigation.class);
	    String thirdSearchItem = "blackbarry";
	    
	    commNav.searchListView("speedsearch", thirdSearchItem);
	
	    //Step: check search results... 
	    try {
	      AssertJUnit.assertFalse(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*no records[\\s\\S]*$"));
	    } catch (Error e) {
	      verificationErrors.append(methodID + "(): " + e.toString());
	    }
	    try {
	      AssertJUnit.assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*" + thirdSearchItem + "[\\s\\S]*$"));
	    } catch (Error e) {
	      verificationErrors.append(methodID + "(): " + e.toString());
	    }
	    
	    //Step: click to open the top Search Results link...
	    driver.findElement(By.xpath(".//*[@id='speedsearch_list']/ul/li[1]")).click();
	    Thread.sleep(3000);
	    commNav.waitForNotPage("SpeedSearch");	    
	    
	    //Step: navigate back...
	    headerButton.goBack();
	
	    
	    // Step: perform 4th global search...
		commNav = PageFactory.initElements(driver, CommonNavigation.class);
	    String fourthSearchItem = "black berry";
	    
	    commNav.searchListView("speedsearch", fourthSearchItem);
	
	    //Step: check search results... 
	    try {
	      AssertJUnit.assertFalse(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*no records[\\s\\S]*$"));
	    } catch (Error e) {
	      verificationErrors.append(methodID + "(): " + e.toString());
	    }
	    try {
	      AssertJUnit.assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*" + fourthSearchItem + "[\\s\\S]*$"));
	    } catch (Error e) {
	      verificationErrors.append(methodID + "(): " + e.toString());
	    }
	    
	    //Step: click to open the top Search Results link...
	    driver.findElement(By.xpath(".//*[@id='speedsearch_list']/ul/li[1]")).click();
	    Thread.sleep(3000);
	    commNav.waitForNotPage("SpeedSearch");	    
	    
	    //Step: navigate back...
	    headerButton.goBack();
	    
	    
	    // Step: perform 5th global search...
		commNav = PageFactory.initElements(driver, CommonNavigation.class);
	    String fifthSearchItem = "advisinh";
	    
	    commNav.searchListView("speedsearch", fifthSearchItem);
	
	    //Step: check search results... 
	    try {
	      AssertJUnit.assertFalse(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*no records[\\s\\S]*$"));
	    } catch (Error e) {
	      verificationErrors.append(methodID + "(): " + e.toString());
	    }
	    try {
	      AssertJUnit.assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*" + fifthSearchItem + "[\\s\\S]*$"));
	    } catch (Error e) {
	      verificationErrors.append(methodID + "(): " + e.toString());
	    }
	    
	    //Step: click to open the top Search Results link...
	    driver.findElement(By.xpath(".//*[@id='speedsearch_list']/ul/li[1]")).click();
	    Thread.sleep(3000);
	    commNav.waitForNotPage("SpeedSearch");	    
	    
	    //Step: navigate back...
	    headerButton.goBack();
	    
	    
	    // Step: perform 6th global search...
		commNav = PageFactory.initElements(driver, CommonNavigation.class);
	    String sixthSearchItem = "world";
	    
	    commNav.searchListView("speedsearch", sixthSearchItem);
	
	    //Step: check search results... 
	    try {
	      AssertJUnit.assertFalse(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*no records[\\s\\S]*$"));
	    } catch (Error e) {
	      verificationErrors.append(methodID + "(): " + e.toString());
	    }
	    try {
	      AssertJUnit.assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*" + sixthSearchItem + "[\\s\\S]*$"));
	    } catch (Error e) {
	      verificationErrors.append(methodID + "(): " + e.toString());
	    }
	    
	    //Step: click to open the top Search Results link...
	    driver.findElement(By.xpath(".//*[@id='speedsearch_list']/ul/li[1]")).click();
	    Thread.sleep(3000);
	    commNav.waitForNotPage("SpeedSearch");	    
	    
	    //Step: navigate back...
	    headerButton.goBack();
	    
	    
	    // Step: perform 7th global search...
		commNav = PageFactory.initElements(driver, CommonNavigation.class);
	    String seventhSearchItem = "sophia";
	    
	    commNav.searchListView("speedsearch", seventhSearchItem);
	
	    //Step: check search results... 
	    try {
	      AssertJUnit.assertFalse(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*no records[\\s\\S]*$"));
	    } catch (Error e) {
	      verificationErrors.append(methodID + "(): " + e.toString());
	    }
	    try {
	      AssertJUnit.assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*" + seventhSearchItem + "[\\s\\S]*$"));
	    } catch (Error e) {
	      verificationErrors.append(methodID + "(): " + e.toString());
	    }
	    
	    //Step: click to open the top Search Results link...
	    driver.findElement(By.xpath(".//*[@id='speedsearch_list']/ul/li[1]")).click();
	    Thread.sleep(3000);
	    commNav.waitForNotPage("SpeedSearch");	    
	    
	    //Step: navigate back...
	    headerButton.goBack();
	    
	    
	    // Step: perform 8th global search...
		commNav = PageFactory.initElements(driver, CommonNavigation.class);
	    String eigthSearchItem = "sophia perez";
	    
	    commNav.searchListView("speedsearch", eigthSearchItem);
	
	    //Step: check search results... 
	    try {
	      AssertJUnit.assertFalse(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*no records[\\s\\S]*$"));
	    } catch (Error e) {
	      verificationErrors.append(methodID + "(): " + e.toString());
	    }
	    try {
	      AssertJUnit.assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*" + eigthSearchItem + "[\\s\\S]*$"));
	    } catch (Error e) {
	      verificationErrors.append(methodID + "(): " + e.toString());
	    }
	    
	    //Step: click to open the top Search Results link...
	    driver.findElement(By.xpath(".//*[@id='speedsearch_list']/ul/li[1]")).click();
	    Thread.sleep(3000);
	    commNav.waitForNotPage("SpeedSearch");	    
	    
	    //Step: navigate back...
	    headerButton.goBack();	    
	    // -- End Section
	    
		System.out.println(ENDLINE);
	}

	
	
	//TODO: complete re-factoring test02_SeTestTCSpeedSearchLeads()
	@Test(enabled = false)
	public void test02_SeTestTCSpeedSearchLeads() throws Exception {
/*		
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
	      verificationErrors.append(methodID + "(): " + e.toString());
	    }
	    try {
	      assertTrue(isElementPresent(By.cssSelector("#Mobile_SalesLogix_SpeedSearchWidget_0 > div.table-layout > div.hasButton > button.subHeaderButton.searchButton")));
	    } catch (Error e) {
	      verificationErrors.append(methodID + "(): " + e.toString());
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
	      verificationErrors.append(methodID + "(): " + e.toString());
	    }
	    // Warning: verifyTextPresent may require manual changes
	    try {
	      assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*James Sibr[\\s\\S]*$"));
	    } catch (Error e) {
	      verificationErrors.append(methodID + "(): " + e.toString());
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
	      verificationErrors.append(methodID + "(): " + e.toString());
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
	     * 
*/
	}
	
	
	//TODO: complete re-factoring test03_SeTestTCSpeedSearchAccConActOppNtsHis()	
	@Test(enabled = false)
	public void test03_SeTestTCSpeedSearchAccConActOppNtsHis() throws Exception {
/*		
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
	      verificationErrors.append(methodID + "(): " + e.toString());
	    }
	    try {
	      assertTrue(isElementPresent(By.cssSelector("#Mobile_SalesLogix_SpeedSearchWidget_0 > div.table-layout > div.hasButton > button.subHeaderButton.searchButton")));
	    } catch (Error e) {
	      verificationErrors.append(methodID + "(): " + e.toString());
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
	      verificationErrors.append(methodID + "(): " + e.toString());
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
	      verificationErrors.append(methodID + "(): " + e.toString());
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
	      verificationErrors.append(methodID + "(): " + e.toString());
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
	      verificationErrors.append(methodID + "(): " + e.toString());
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
	      verificationErrors.append(methodID + "(): " + e.toString());
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
	      verificationErrors.append(methodID + "(): " + e.toString());
	    }
	    try {
	      assertEquals("Wurst, Hans", driver.findElement(By.xpath(".//*[@id='contact_detail']/div[2]/div[1]/div[1]/span")).getText());
	    } catch (Error e) {
	      verificationErrors.append(methodID + "(): " + e.toString());
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
	      verificationErrors.append(methodID + "(): " + e.toString());
	    }
	    try {
	      assertEquals("Referred from Abbott Ltd.", driver.findElement(By.xpath(".//*[@id='activity_detail']/div[2]/div[1]/div[2]/span")).getText());
	    } catch (Error e) {
	      verificationErrors.append(methodID + "(): " + e.toString());
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
	      verificationErrors.append(methodID + "(): " + e.toString());
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
	      verificationErrors.append(methodID + "(): " + e.toString());
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
	      verificationErrors.append(methodID + "(): " + e.toString());
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
	      verificationErrors.append(methodID + "(): " + e.toString());
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
	     *
*/
	}
	

	//TODO: complete re-factoring test04_SeTestTCSpeedSearchTickets()
	@Test(enabled = false)
	public void test04_SeTestTCSpeedSearchTickets() throws Exception {
/*		
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
	      verificationErrors.append(methodID + "(): " + e.toString());
	    }
	    try {
	      assertTrue(isElementPresent(By.cssSelector("#Mobile_SalesLogix_SpeedSearchWidget_0 > div.table-layout > div.hasButton > button.subHeaderButton.searchButton")));
	    } catch (Error e) {
	      verificationErrors.append(methodID + "(): " + e.toString());
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
	      verificationErrors.append(methodID + "(): " + e.toString());
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
	      verificationErrors.append(methodID + "(): " + e.toString());
	    }
	    try {
	      assertEquals("001-00-000004", driver.findElement(By.xpath(".//*[@id='ticket_detail']/div[2]/ul[1]/li/a/span")).getText());
	    } catch (Error e) {
	      verificationErrors.append(methodID + "(): " + e.toString());
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

	//MBL10115 - Index filtering Selection in Contextual menu
	@Test(enabled = true)
	public void test05_MBL10115() throws Exception {
		String methodID = "test05_MBL10115";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		
		// Test Params:
		String searchItem = "software";
		String indexFilter = "";
		String resultsMsg = "";
		String[] indexFilters = {"Account", "Activity", "Contact", "History", "Lead", "Opportunity", "Ticket"};
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
		
	    //Step: perform SpeedSearch
		commNav.searchListView("SpeedSearch", searchItem);
		
		//Step: select index filter
		for (int iCount = 0;iCount<indexFilters.length;iCount++) {
			indexFilter = indexFilters[iCount];
			resultsMsg = "VP: Index filter - " + indexFilter + " succesfully filtered the SpeedSearch results";
			commNav.rightClickContextMenuItem(indexFilter);
			if (commNav.isTextPresentOnPage(indexFilter)) {
				System.out.println(resultsMsg + " - Passed");
				commNav.rightClickContextMenuItem(indexFilter);
			}
			else {
				System.out.println(resultsMsg + " - FAILED");
			}
		}
				
		//Step: go back to previous screen
		commNav.clickGlobalMenuItem("My Activities");
		Thread.sleep(3000);
		
		System.out.println(ENDLINE);
*/
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
	
  
  
}
