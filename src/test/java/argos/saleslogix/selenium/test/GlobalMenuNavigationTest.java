package argos.saleslogix.selenium.test;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.AssertJUnit;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;


public class GlobalMenuNavigationTest extends BrowserSetup {

	CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);

	@Test(enabled = true)
	public void test00_Mobile_Login() throws InterruptedException {
		String methodID = "test00_Mobile_Login";
		
		SLXMobileLogin slxmobilelogin = PageFactory.initElements(driver, SLXMobileLogin.class);	
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);	
		//VP: the Mobile Login screen is loaded from base URL
		for (int second = 0;; second++) {
			if (second >= 60) AssertJUnit.fail("timeout");
			try { if (fullProdName.equals(driver.findElement(By.id("pageTitle")).getText()))
				System.out.println("VP: " + fullProdName + " - Mobile Client load check - Passed");
				break; 
			} catch (Exception e) {
			System.out.println("Error: " + fullProdName + " - Mobile Client load check - FAILED");
			}
			Thread.sleep(1000);
		}
		
		//VP: Page Title
		Thread.sleep(1000);
		try { assertEquals(shortProdName, driver.getTitle());
			System.out.println("VP: Login Screen Title check - Passed");
			} catch (Error e) {
			System.out.println("Error: Login Screen Title check - FAILED");
			verificationErrors.append(e.toString());
		}
		
		//VP: Login Page Name
		Thread.sleep(1000);
		for (int second = 0;; second++) {
			if (second >= 60) AssertJUnit.fail("timeout");
			try { if (fullProdName.equals(driver.findElement(By.xpath("//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}		
		try {
			assertEquals(fullProdName, driver.findElement(By.xpath("//*[@id='pageTitle']")).getText());
			System.out.println("VP: Login Page Name check - Passed");
			} catch (Error e) {
			System.out.println("Error: Login Page Name check - FAILED");
			verificationErrors.append(e.toString());
		}
		
		//VP: Copyright Info...
		try {
			assertEquals(copyrightLabel, driver.findElement(By.xpath(".//*[@id='login']/span[1]")).getText());
			System.out.println("VP: Copyright check - Passed");
			} catch (Error e) {
			System.out.println("Error: Copyright check - FAILED");
			verificationErrors.append(e.toString());
		}
		try {
			assertEquals(versionLabel, driver.findElement(By.xpath(".//*[@id='login']/span[2]")).getText());
			System.out.println("VP: Version Label check - Passed");
			} catch (Error e) {
			System.out.println("Error: Version Label check - FAILED");
			verificationErrors.append(e.toString());
		}
		
		// Step: Enter username and password then click the logon button		
		slxmobilelogin.doLogin(userName, userPwd, true);
		
		// VP: confirm that the 'My Activities' screen displays after login
		Thread.sleep(3000);
		try {
			assertTrue(driver.findElement(By.xpath(".//*[@id='myactivity_list']")).isDisplayed());
			System.out.println("VP: Successfully logged in to Mobile Client.");
		} catch (Error e) {
			closeAlert();
			System.out.println("Error: Unable to login to Mobile Client.");
			System.out.println(e.toString());
		}
		System.out.println(ENDLINE);	
	}


	@Test(enabled = true)
	public void test99_Mobile_LogOut()  throws InterruptedException {				
		String methodID = "test99_Mobile_LogOut";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerbutton = PageFactory.initElements(driver, HeaderButton.class);
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
	
		// Click the Log Off button
		commNav.clickGlobalMenuItem("log out");
		Thread.sleep(2000);
		closeAlert();
		Thread.sleep(1000);
					
		// Verify the Mobile Login screen displays
		try {
			AssertJUnit.assertEquals(fullProdName, driver.findElement(By.id("pageTitle")).getText());
			System.out.println("VP: Mobile Client Logout Check - Passed");
		} catch (Error e) {     
			System.out.println("Error: Mobile Client Logout Check - FAILED");
			System.out.println(e.toString());
		}
		System.out.println(ENDLINE);
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

	@Test (enabled = true)
	public void test01_SeTestTCGlobalMenuAddAccountContactScreens() throws Exception {
		// SE Test: SETest-GlobalMenu-AddAccountContact_Screens
	    // Version: 2.3
	    // Desc: Confirms that the toggle button (left and right) for Global screen access is visible on screens accessible under the Add Account/Contact main screen...
	    // Note: This test script can be used as a template for creating new entity records from Add Account/Contact edit screens.
	    // Condition(s): Test user is logged in.    
	    // ==================================================================
		//tags: global menu, add account/contact
		String methodID = "test01_SeTestTCGlobalMenuAddAccountContactScreens";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
		
	    // Step: navigate to the Add Account/Contact Edit view...
		commNav.clickGlobalMenuItem("Add Account/Contact");
		AddAccountContactEditViewElements addAccConEditView = PageFactory.initElements(driver, AddAccountContactEditViewElements.class);
		
	    // VP: confirm that Global Menu button is available...
		String pageName = "Add Account / Contact";
		String resultMsg = "Global Menu button is available in the '" + pageName + "' view";
		checkGlobalMenuStatus(resultMsg);
	    
	    //click the Name edit button...
	    addAccConEditView.addAcctCntctNameInputBtn.click();
	    pageName = "Edit Name";
	    commNav.waitForPage(pageName);
	    resultMsg = "Global Menu button is available in the '" + pageName + "' view";
	    // VP: confirm that Global Menu button is available...	    
	    checkGlobalMenuStatus(resultMsg);
		    
			MiscEntityItemViewsElements nameItemViews = PageFactory.initElements(driver, MiscEntityItemViewsElements.class);
		    
		    //click Name - Prefix edit button...
			nameItemViews.nameEditPrefixInputBtn.click();
		    pageName = "Name Prefix";
		    commNav.waitForPage(pageName);
		    resultMsg = "Global Menu button is available in the '" + pageName + "' view";
		    // VP: confirm that Global Menu button is available...
		    checkGlobalMenuStatus(resultMsg);
		    headerButton.clickHeaderButton("cancel");
		    commNav.waitForPage("Edit Name");
		    
		    //click Name - Suffix edit button...
		    nameItemViews.nameEditSuffixInputBtn.click();
		    pageName = "Name Suffix";
		    commNav.waitForPage(pageName);
		    resultMsg = "Global Menu button is available in the '" + pageName + "' view";
		    // VP: confirm that Global Menu button is available...
		    checkGlobalMenuStatus(resultMsg);
		    headerButton.clickHeaderButton("cancel");
		    commNav.waitForPage("Edit Name");
		    
		    //navigate back to the Add Account / Contact edit screen...
		    headerButton.clickHeaderButton("cancel");
		    commNav.waitForPage("Add Account / Contact");
	
	    // Step: click the Title edit button...
	    addAccConEditView.addAcctCntctTitleInputBtn.click();
	    pageName = "Title";
	    commNav.waitForPage(pageName);
	    resultMsg = "Global Menu button is available in the '" + pageName + "' view";
	    // VP: confirm that Global Menu button is available...	    
	    checkGlobalMenuStatus(resultMsg);
	    headerButton.clickHeaderButton("cancel");
	    commNav.waitForPage("Add Account / Contact");
	
	    // Step: click the Address edit button...
	    addAccConEditView.addAcctCntctAddressInputBtn.click();
	    pageName = "Address";
	    commNav.waitForPage(pageName);
	    resultMsg = "Global Menu button is available in the '" + pageName + "' view";
	    // VP: confirm that Global Menu button is available...	    
	    checkGlobalMenuStatus(resultMsg);
	    
	    	MiscEntityItemViewsElements addressItemViews = PageFactory.initElements(driver, MiscEntityItemViewsElements.class);
	    
		    //click the Address - Description edit button...
	    	addressItemViews.addressEditDescriptionInputBtn.click();
		    pageName = "Description";
		    commNav.waitForPage(pageName);
		    resultMsg = "Global Menu button is available in the '" + pageName + "' view";
		    // VP: confirm that Global Menu button is available...
		    checkGlobalMenuStatus(resultMsg);
		    headerButton.clickHeaderButton("cancel");
		    commNav.waitForPage("Address");
		    
		    //click the Address - City edit button...
	    	addressItemViews.addressEditCityInputBtn.click();
		    pageName = "City";
		    commNav.waitForPage(pageName);
		    resultMsg = "Global Menu button is available in the '" + pageName + "' view";
		    // VP: confirm that Global Menu button is available...
		    checkGlobalMenuStatus(resultMsg);
		    headerButton.clickHeaderButton("cancel");
		    commNav.waitForPage("Address");
		    
		    //click the Address - State edit button...
	    	addressItemViews.addressEditStateInputBtn.click();
		    pageName = "State";
		    commNav.waitForPage(pageName);
		    resultMsg = "Global Menu button is available in the '" + pageName + "' view";
		    // VP: confirm that Global Menu button is available...
		    checkGlobalMenuStatus(resultMsg);
		    headerButton.clickHeaderButton("cancel");
		    commNav.waitForPage("Address");
		    
		    //click the Address - Country edit button...
	    	addressItemViews.addressEditCountryInputBtn.click();
		    pageName = "Country";
		    commNav.waitForPage(pageName);
		    resultMsg = "Global Menu button is available in the '" + pageName + "' view";
		    // VP: confirm that Global Menu button is available...
		    checkGlobalMenuStatus(resultMsg);
		    headerButton.clickHeaderButton("cancel");
		    commNav.waitForPage("Address");
	
		    //navigate back to the Add Account / Contact edit screen...
		    headerButton.clickHeaderButton("cancel");
		    commNav.waitForPage("Add Account / Contact");
	
	    //Step: click the Type edit button to open the Account Type screen...
	    addAccConEditView.addAcctCntctTypeInputBtn.click();
	    pageName = "Account Type";
	    commNav.waitForPage(pageName);
	    resultMsg = "Global Menu button is available in the '" + pageName + "' view";
	    // VP: confirm that Global Menu button is available...	    
	    checkGlobalMenuStatus(resultMsg);
	    headerButton.clickHeaderButton("cancel");
	    commNav.waitForPage("Add Account / Contact");
	
	    //Step: click the Sub-Type edit button to open the Account Sub-Type screen...
	    addAccConEditView.addAcctCntctSubTypeInputBtn.click();
	    pageName = "Account SubType";
	    commNav.waitForPage(pageName);
	    resultMsg = "Global Menu button is available in the '" + pageName + "' view";
	    // VP: confirm that Global Menu button is available...	    
	    checkGlobalMenuStatus(resultMsg);
	    headerButton.clickHeaderButton("cancel");
	    commNav.waitForPage("Add Account / Contact");
	
	    //Step: click the Status edit button to open the Account Status screen...
	    addAccConEditView.addAcctCntctStatusFldBtn.click();
	    pageName = "Account Status";
	    commNav.waitForPage(pageName);
	    resultMsg = "Global Menu button is available in the '" + pageName + "' view";
	    // VP: confirm that Global Menu button is available...	    
	    checkGlobalMenuStatus(resultMsg);
	    headerButton.clickHeaderButton("cancel");
	    commNav.waitForPage("Add Account / Contact");
	
	    //Step: click the Industry edit button to open the Industry screen...
	    addAccConEditView.addAcctCntctIndustryFldBtn.click();
	    pageName = "Industry";
	    commNav.waitForPage(pageName);
	    resultMsg = "Global Menu button is available in the '" + pageName + "' view";
	    // VP: confirm that Global Menu button is available...	    
	    checkGlobalMenuStatus(resultMsg);
	    headerButton.clickHeaderButton("cancel");
	    commNav.waitForPage("Add Account / Contact");
	    
	    //Step: click the Owner edit button to open the Owners screen...
	    addAccConEditView.addAcctCntctOwnerFldBtn.click();
	    pageName = "Owners";
	    commNav.waitForPage(pageName);
	    resultMsg = "Global Menu button is available in the '" + pageName + "' view";
	    // VP: confirm that Global Menu button is available...	    
	    checkGlobalMenuStatus(resultMsg);
	    headerButton.clickHeaderButton("cancel");
	    commNav.waitForPage("Add Account / Contact");
	
	    //Step: click the Top Cancel button...
	    headerButton.clickHeaderButton("cancel");
	    commNav.waitForPage("My Activities");
	    
	    // -- END
	    System.out.println(ENDLINE);
	}
	
	@Test(enabled = false)
	public void test02_SeTestTCGlobalMenuCompleteActivityScreens() throws Exception {
	    // SETest-GlobalMenu_CompleteActivity_Screens
	    // Version: 2.2
	    // Desc: Confirms that the toggle button (left and right) for Global screen access is visible on screens accessible under the Complete Activity screens...
	    // Note: This test script can be used as a template for completing/editing an Activity.
	    // Condition(s): Test user is logged in.    
	    // ==================================================================
		String methodID = "test02_SeTestTCGlobalMenuCompleteActivityScreens";
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
	    // Step: search for then click an Activity link from the My Activities screen...
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if ("My Activities".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_SearchWidget_26']/div/div[1]/input")).clear();
	    Thread.sleep(500);
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_SearchWidget_26']/div/div[1]/input")).sendKeys("demonstration");
	    Thread.sleep(1000);
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_SearchWidget_26']/div/div[3]/button")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if (isElementPresent(By.xpath(".//*[@id='myactivity_list']/ul/li[1]"))) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	    
	    try {driver.findElement(By.xpath(".//*[@id='myactivity_list']/ul/li[1]/div[2]/h3/span")).click(); } catch (Exception e) {}
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if ("Activity".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	    AssertJUnit.assertTrue(driver.findElement(By.xpath("//*[@id='activity_detail']/div[2]/ul[1]/li/a/label")).getText().matches("^Complete[\\s\\S]*$"));
	    
	    // Step: click the Complete Activity link...
	    driver.findElement(By.xpath("//*[@id='activity_detail']/div[2]/ul[1]/li/a/label")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if (driver.findElement(By.id("pageTitle")).getText().matches("^Complete[\\s\\S]*$")) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // VP: confirm that Global Menu button is available...
	    try {
	      AssertJUnit.assertTrue(isElementPresent(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    
	    // Step: click the Regarding edit button...
	    driver.findElement(By.cssSelector("#Mobile_SalesLogix_Fields_PicklistField_31 > button.button.simpleSubHeaderButton")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if ("Activity Regarding".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // VP: confirm that Global Menu button is available...
	    try {
	      AssertJUnit.assertTrue(isElementPresent(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: navigate back to Complete Activity screen...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if (driver.findElement(By.id("pageTitle")).getText().matches("^Complete[\\s\\S]*$")) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // Step: click Start Date edit button...
	    driver.findElement(By.cssSelector("#Sage_Platform_Mobile_Fields_DateField_10 > button.button.whiteButton")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if ("Calendar".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // VP: confirm that Global Menu button is available...
	    try {
	      AssertJUnit.assertTrue(isElementPresent(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: navigate back to Complete Activity screen...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if (driver.findElement(By.id("pageTitle")).getText().matches("^Complete[\\s\\S]*$")) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // Step: click Duration edit button...
	    driver.findElement(By.cssSelector("#Sage_Platform_Mobile_Fields_DurationField_2 > button.button.simpleSubHeaderButton")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if ("List".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // VP: confirm that Global Menu button is available...
	    try {
	      AssertJUnit.assertTrue(isElementPresent(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: navigate back to the Name edit screen...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if (driver.findElement(By.id("pageTitle")).getText().matches("^Complete[\\s\\S]*$")) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // Step: click the Result edit button...
	    driver.findElement(By.cssSelector("#Mobile_SalesLogix_Fields_PicklistField_32 > button.button.simpleSubHeaderButton")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if ("Result".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // VP: confirm that Global Menu button is available...
	    try {
	      AssertJUnit.assertTrue(isElementPresent(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: navigate back to the Name edit screen...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if (driver.findElement(By.id("pageTitle")).getText().matches("^Complete[\\s\\S]*$")) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // Step: click the Follow-up edit button...
	    driver.findElement(By.cssSelector("#Sage_Platform_Mobile_Fields_SelectField_2 > button.button.simpleSubHeaderButton")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if ("Follow-up type".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // VP: confirm that Global Menu button is available...
	    try {
	      AssertJUnit.assertTrue(isElementPresent(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: navigate back to the Name edit screen...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if (driver.findElement(By.id("pageTitle")).getText().matches("^Complete[\\s\\S]*$")) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // Step: click the Notes edit button...
	    driver.findElement(By.cssSelector("#Sage_Platform_Mobile_Fields_NoteField_7 > button.button.simpleSubHeaderButton")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if ("Notes".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // VP: confirm that Global Menu button is available...
	    try {
	      AssertJUnit.assertTrue(isElementPresent(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: navigate back to the Name edit screen...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if (driver.findElement(By.id("pageTitle")).getText().matches("^Complete[\\s\\S]*$")) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // Step: click the Priority edit button...
	    driver.findElement(By.cssSelector("#Mobile_SalesLogix_Fields_PicklistField_33 > button.button.simpleSubHeaderButton")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if ("Priority".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // VP: confirm that Global Menu button is available...
	    try {
	      AssertJUnit.assertTrue(isElementPresent(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: navigate back to the Name edit screen...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if (driver.findElement(By.id("pageTitle")).getText().matches("^Complete[\\s\\S]*$")) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // Step: click the Category edit button...
	    driver.findElement(By.cssSelector("#Mobile_SalesLogix_Fields_PicklistField_34 > button.button.simpleSubHeaderButton")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if ("Activity Category".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // VP: confirm that Global Menu button is available...
	    try {
	      AssertJUnit.assertTrue(isElementPresent(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: navigate back to the Name edit screen...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if (driver.findElement(By.id("pageTitle")).getText().matches("^Complete[\\s\\S]*$")) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // Step: click the Leader edit button...
	    driver.findElement(By.cssSelector("#Sage_Platform_Mobile_Fields_LookupField_33 > button.button.simpleSubHeaderButton")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if ("Users".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // VP: confirm that Global Menu button is available...
	    try {
	      AssertJUnit.assertTrue(isElementPresent(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: navigate back to the Address edit screen...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if (driver.findElement(By.id("pageTitle")).getText().matches("^Complete[\\s\\S]*$")) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // Step: click the Account edit button...
	    driver.findElement(By.cssSelector("#Sage_Platform_Mobile_Fields_LookupField_34 > button.button.simpleSubHeaderButton")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if ("Accounts".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // VP: confirm that Global Menu button is available...
	    try {
	      AssertJUnit.assertTrue(isElementPresent(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: navigate back to the Address edit screen...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if (driver.findElement(By.id("pageTitle")).getText().matches("^Complete[\\s\\S]*$")) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // Step: click the Contact edit button...
	    driver.findElement(By.cssSelector("#Sage_Platform_Mobile_Fields_LookupField_35 > button.button.simpleSubHeaderButton")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if ("Contacts".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // VP: confirm that Global Menu button is available...
	    try {
	      AssertJUnit.assertTrue(isElementPresent(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: navigate back to the Address edit screen...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if (driver.findElement(By.id("pageTitle")).getText().matches("^Complete[\\s\\S]*$")) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // Step: click the Opportunity edit button...
	    driver.findElement(By.cssSelector("#Sage_Platform_Mobile_Fields_LookupField_36 > button.button.simpleSubHeaderButton")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if ("Opportunities".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // VP: confirm that Global Menu button is available...
	    try {
	      AssertJUnit.assertTrue(isElementPresent(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: navigate back to the Address edit screen...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if (driver.findElement(By.id("pageTitle")).getText().matches("^Complete[\\s\\S]*$")) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // Step: click the Tickets edit button...
	    driver.findElement(By.cssSelector("#Sage_Platform_Mobile_Fields_LookupField_37 > button.button.simpleSubHeaderButton")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if ("Tickets".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // VP: confirm that Global Menu button is available...
	    try {
	      AssertJUnit.assertTrue(isElementPresent(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: navigate back to the Address edit screen...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if (driver.findElement(By.id("pageTitle")).getText().matches("^Complete[\\s\\S]*$")) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // Step: navigate back to the Add Account / Contact screen...
	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if ("My Activities".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	    // -- END
	    System.out.println(ENDLINE);
	}

	@Test (enabled = false)
	  public void test03_SeTestTCGlobalMenuDoSpeedSearch() throws Exception {
	    // SE Test: SETest-GlobalMenu_DoSpeedSearch
	    // Version: 2.2
	    // Desc: Opens the Global Menu, navigates to the SpeedSearch view then performs a simple SpeedSearch..
	    // Condition(s): Test user is logged in.    
	    // ==================================================================
		String methodID = "test03_SeTestTCGlobalMenuDoSpeedSearch";
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
	    // Step: click Top-Left button to reveal Global Menu...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[1]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if (isElementPresent(By.xpath(".//*[@id='Mobile_SalesLogix_SpeedSearchWidget_0']/div/div[1]/input"))) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // VP: check  the SpeedSearch bar...
	    try {
	      AssertJUnit.assertTrue(isElementPresent(By.cssSelector("#Mobile_SalesLogix_SpeedSearchWidget_0 > label")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    try {
	      AssertJUnit.assertTrue(isElementPresent(By.cssSelector("#Mobile_SalesLogix_SpeedSearchWidget_0 > div.table-layout > div.hasButton > button.subHeaderButton.searchButton")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: click the SpeedSearch menu item...
	    driver.findElement(By.xpath(".//*[@id='left_drawer']/descendant::*[text() = 'SpeedSearch']")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if (isElementPresent(By.xpath(".//*[@id='speedsearch_list']"))) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // Step: enter an item in the search field then click the SpeedSearch button...
	    driver.findElement(By.cssSelector("#Mobile_SalesLogix_SpeedSearchWidget_0 > div.table-layout > div > input[name=\"query\"]")).clear();
	    Thread.sleep(500);
	    driver.findElement(By.cssSelector("#Mobile_SalesLogix_SpeedSearchWidget_0 > div.table-layout > div > input[name=\"query\"]")).sendKeys("abbott");
	    Thread.sleep(1000);
	    driver.findElement(By.cssSelector("#Mobile_SalesLogix_SpeedSearchWidget_0 > div.table-layout > div.hasButton > button.subHeaderButton.searchButton")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if (isElementPresent(By.xpath(".//*[@id='speedsearch_list']/ul/li[1]"))) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // Step: click a specific SpeedSearch test result
	    driver.findElement(By.xpath(".//*[@id='speedsearch_list']/descendant::*[text() = 'Won the deal (2012_08_22)']")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if ("History".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    try {
	      AssertJUnit.assertEquals("Won the deal", driver.findElement(By.xpath("//div[@id='history_detail']/div[2]/div/div[3]/span")).getText());
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    
	    // Step: click Top Blue Arrow button to navigate back...
	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if ("SpeedSearch".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[2]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if ("My Activities".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	    // -- END
	    System.out.println(ENDLINE);
	  }

	@Test (enabled = false)
	  public void test04_SeTestTCGlobalMenuEditAccount() throws Exception {
	    // SETest-GlobalMenu_EditAccount_Screens
	    // Version: 2.2
	    // Desc: Confirms that the toggle button (left and right) for Global Menu access is visible on screens accessible under the Edit Account screens...
	    // Note: This test script can be used as a template for completing/editing an Account.
	    // Condition(s): Test user is logged in.    
	    // ==================================================================
		String methodID = "test04_SeTestTCGlobalMenuEditAccount";
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);	
	    // Step: click Top-Left button to reveal Global Menu...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[1]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if (isElementPresent(By.xpath(".//*[@id='Mobile_SalesLogix_SpeedSearchWidget_0']/div/div[1]/input"))) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // Step: navigate to Accounts list view...
	    driver.findElement(By.xpath(".//*[@id='left_drawer']/descendant::*[text() = \"Accounts\"]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if (isElementPresent(By.xpath(".//*[@id='account_list']/ul/li[1]"))) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // Step: perform search for Account items...
	    driver.findElement(By.cssSelector("#Sage_Platform_Mobile_SearchWidget_3 > div.table-layout > div > input[name=\"query\"]")).clear();
	    Thread.sleep(500);
	    driver.findElement(By.cssSelector("#Sage_Platform_Mobile_SearchWidget_3 > div.table-layout > div > input[name=\"query\"]")).sendKeys("Big Systems");
	    Thread.sleep(1000);
	    driver.findElement(By.cssSelector("#Sage_Platform_Mobile_SearchWidget_3 > div.table-layout > div.hasButton > button.subHeaderButton.searchButton")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if (isElementPresent(By.xpath(".//*[@id='account_list']/ul/li[1]"))) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // Step: navigate to top Account record...
	    //driver.findElement(By.cssSelector("#account_list > ul.list-content > li > div.list-item-content > h3")).click();
	    driver.findElement(By.xpath(".//*[@id='account_list']/descendant::*[text() = 'Big Systems']")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if ("Big Systems".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // VP: confirm that Global Menu button is available...
	    try {
	      AssertJUnit.assertTrue(isElementPresent(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: click the top Edit button...
	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[2]")).click();
	    Thread.sleep(1000);
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if (isElementPresent(By.cssSelector("#Sage_Platform_Mobile_Fields_TextField_14 > input[name=\"AccountName\"]"))) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // Step: click the Business Description edit buton...
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_Fields_NoteField_0']/button")).click();
	    Thread.sleep(1000);
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if ("Business Description".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // VP: confirm that Global Menu button is available...
	    try {
	      AssertJUnit.assertTrue(isElementPresent(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: navigate back to Account screen...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if ("Account".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // Step: click the For Owners toggle to ON...
	    driver.findElement(By.cssSelector("#Sage_Platform_Mobile_Fields_LookupField_1 > button.button.simpleSubHeaderButton")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if ("Owners".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // VP: confirm that Global Menu button is available...
	    try {
	      AssertJUnit.assertTrue(isElementPresent(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: navigate back to Account screen...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if ("Account".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // Step: click the Lead Sources edit button...
	    driver.findElement(By.cssSelector("#Sage_Platform_Mobile_Fields_LookupField_2 > button.button.simpleSubHeaderButton")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if ("Lead Sources".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // VP: confirm that Global Menu button is available...
	    try {
	      AssertJUnit.assertTrue(isElementPresent(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: navigate back to Account screen...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if ("Account".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // Step: navigate back...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if ("Big Systems".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if ("Accounts".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if ("My Activities".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	    // -- END
	    System.out.println(ENDLINE);
	  }

	@Test (enabled = false)
	  public void test05_SeTestTCGlobalMenuEditActivity() throws Exception {
	    // SETest-GlobalMenu_EditActivity_Screens
	    // Version: 2.2
	    // Desc: Confirms that the toggle button (left and right) for Global Menu access is visible on screens accessible under the Edit Activity screens...
	    // Note: This test script can be used as a template for completing/editing an Activity.
	    // Condition(s): Test user is logged in.    
	    // ==================================================================
		String methodID = "test05_SeTestTCGlobalMenuEditActivity";
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
	    // Step: click top Activity link from the My Activities screen...
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if ("My Activities".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    driver.findElement(By.cssSelector("span.p-description")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if ("Activity".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    AssertJUnit.assertEquals("Complete Activity", driver.findElement(By.xpath("//*[@id='activity_detail']/div[2]/ul[1]/li/a/label")).getText());
	    // Step: click the Top cEdit Activity button...
	    driver.findElement(By.xpath(".//*[@id='activity_detail']/div[2]/ul[1]/li/a")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if ("Complete Activity".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // VP: confirm that Global Menu button is available...
	    try {
	      AssertJUnit.assertTrue(isElementPresent(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: click the Regarding edit button...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Fields_PicklistField_31']/button")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if ("Activity Regarding".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // VP: confirm that Global Menu button is available...
	    try {
	      AssertJUnit.assertTrue(isElementPresent(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: navigate back to Activity screen...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if ("Complete Activity".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // Step: click Start Date edit button...
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_Fields_DateField_10']/button")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if ("Calendar".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // VP: confirm that Global Menu button is available...
	    try {
	      AssertJUnit.assertTrue(isElementPresent(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: navigate back to Activity screen...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if ("Complete Activity".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // Step: click Duration edit button...
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_Fields_DurationField_2']/button")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if ("List".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // VP: confirm that Global Menu button is available...
	    try {
	      AssertJUnit.assertTrue(isElementPresent(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: navigate back to the Activity screen...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if ("Complete Activity".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // Step: click the Result edit button...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Fields_PicklistField_32']/button")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if ("Result".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // VP: confirm that Global Menu button is available...
	    try {
	      AssertJUnit.assertTrue(isElementPresent(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: navigate back to the Activity screen...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if ("Complete Activity".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // Step: click the Follow-up edit button...
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_Fields_SelectField_2']/button")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if ("Follow-up type".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // VP: confirm that Global Menu button is available...
	    try {
	      AssertJUnit.assertTrue(isElementPresent(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: navigate back to the Activity screen...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if ("Complete Activity".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // Step: click the Notes edit button...
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_Fields_NoteField_7']/button")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if ("Notes".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // VP: confirm that Global Menu button is available...
	    try {
	      AssertJUnit.assertTrue(isElementPresent(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: navigate back to the Activity screen...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if ("Complete Activity".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // Step: click the Priority edit button...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Fields_PicklistField_33']/button")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if ("Priority".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // VP: confirm that Global Menu button is available...
	    try {
	      AssertJUnit.assertTrue(isElementPresent(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: navigate back to the Activity screen...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if ("Complete Activity".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // Step: click the Category edit button...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Fields_PicklistField_34']/button")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if ("Activity Category".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // VP: confirm that Global Menu button is available...
	    try {
	      AssertJUnit.assertTrue(isElementPresent(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: navigate back to the Activity screen...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if ("Complete Activity".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // Step: click the Leader edit button...
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_Fields_LookupField_33']/button")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if ("Users".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // VP: confirm that Global Menu button is available...
	    try {
	      AssertJUnit.assertTrue(isElementPresent(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: navigate back to the Activity screen...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if ("Complete Activity".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // Step: click the Account edit button...
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_Fields_LookupField_34']/button")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if ("Accounts".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // VP: confirm that Global Menu button is available...
	    try {
	      AssertJUnit.assertTrue(isElementPresent(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: navigate back to the Activity screen...
	    driver.findElement(By.xpath(".//*[@id='account_related']/ul/li[1]/div/h3")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if ("Complete Activity".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // Step: click the Contact edit button...
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_Fields_LookupField_35']/button")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if ("Contacts".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // VP: confirm that Global Menu button is available...
	    try {
	      AssertJUnit.assertTrue(isElementPresent(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: navigate back to the Activity screen...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if ("Complete Activity".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // Step: click the Opportunity edit button...
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_Fields_LookupField_36']/button")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if ("Opportunities".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // VP: confirm that Global Menu button is available...
	    try {
	      AssertJUnit.assertTrue(isElementPresent(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: navigate back to the Activity screen...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if ("Complete Activity".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // Step: click the Tickets edit button...
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_Fields_LookupField_37']/button")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if ("Tickets".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // VP: confirm that Global Menu button is available...
	    try {
	      AssertJUnit.assertTrue(isElementPresent(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: navigate back to the Activity screen...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if ("Complete Activity".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // Step: navigate back to the Activity screen...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if ("My Activities".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	    // -- END
	    System.out.println(ENDLINE);
	  }

	@Test (enabled = false)
	  public void test06_SeTestTCGlobalMenuEditContact() throws Exception {
	    // SETest-GlobalMenu_EditContact_Screens
	    // Version: 2.2
	    // Desc: Confirms that the toggle button (left and right) for Global Menu access is visible on screens accessible under the Edit Contact screens...
	    // Note: This test script can be used as a template for completing/editing a Contact.
	    // Condition(s): Test user is logged in.    
	    // ==================================================================
		String methodID = "test06_SeTestTCGlobalMenuEditContact";
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
	    // Step: click Top-Left button to reveal Global Menu...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[1]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if (isElementPresent(By.xpath(".//*[@id='Mobile_SalesLogix_SpeedSearchWidget_0']/div/div[1]/input"))) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // Step: navigate to Contacts list view...
	    driver.findElement(By.xpath(".//*[@id='left_drawer']/descendant::*[text() = \"Contacts\"]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if (isElementPresent(By.xpath(".//*[@id='contact_list']/ul/li[1]"))) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // Step: perform search for Contact items...
	    driver.findElement(By.cssSelector("#Sage_Platform_Mobile_SearchWidget_6 > div.table-layout > div > input[name=\"query\"]")).clear();
	    Thread.sleep(500);
	    driver.findElement(By.cssSelector("#Sage_Platform_Mobile_SearchWidget_6 > div.table-layout > div > input[name=\"query\"]")).sendKeys("Alfred");
	    Thread.sleep(1000);
	    driver.findElement(By.cssSelector("#Sage_Platform_Mobile_SearchWidget_6 > div.table-layout > div.hasButton > button.subHeaderButton.searchButton")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if (isElementPresent(By.xpath(".//*[@id='contact_list']/ul/li[1]"))) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	    Thread.sleep(1000);
	
	    // Step: navigate to top Contact record...
	    driver.findElement(By.xpath(".//*[@id='contact_list']/ul/li/div/h3")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if ("Alfred, John".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	    Thread.sleep(1000);
	
	    // VP: confirm that Global Menu button is available...
	    try {
	      AssertJUnit.assertTrue(isElementPresent(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    
	    // Step: click the top Edit button...
	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[2]")).click();
	    try {
	      AssertJUnit.assertTrue(isElementPresent(By.xpath("//div[@id='contact_edit']/div[2]/fieldset/div[2]")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    Thread.sleep(1000);
	    
	    // Step: click the Cuisine edit buton...
	    driver.findElement(By.cssSelector("#Mobile_SalesLogix_Fields_PicklistField_16 > button.button.simpleSubHeaderButton")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if ("Cuisine".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	    Thread.sleep(1000);
	
	    // VP: confirm that Global Menu button is available...
	    try {
	      AssertJUnit.assertTrue(isElementPresent(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    
	    // Step: navigate back to Contact screen...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if ("Contact".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // Step: click the top Cancel button...
	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if ("Alfred, John".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // Step: navigate back to Contacts screen...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if ("Contacts".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if ("My Activities".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	    // -- END
	    System.out.println(ENDLINE);
	  }

	@Test (enabled = false)
	  public void test07_SeTestTCGlobalMenuEditLead() throws Exception {
	    // SETest-GlobalMenu_EditLead_Screens
	    // Version: 2.2
	    // Desc: Confirms that the toggle button (left and right) for Global Menu access is visible on screens accessible under the Edit Lead screens...
	    // Note: This test script can be used as a template for completing/editing a Lead.
	    // Condition(s): Test user is logged in.    
	    // ==================================================================
		String methodID = "test07_SeTestTCGlobalMenuEditLead";
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
	    // Step: click Top-Left button to reveal Global Menu...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[1]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if (isElementPresent(By.xpath(".//*[@id='Mobile_SalesLogix_SpeedSearchWidget_0']/div/div[1]/input"))) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // Step: navigate to Leads list view...
	    driver.findElement(By.xpath(".//*[@id='left_drawer']/descendant::*[text() = \"Leads\"]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if (isElementPresent(By.xpath(".//*[@id='lead_list']/ul/li[1]"))) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // Step: perform Lead search then navigate to top result record...
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_SearchWidget_16']/div/div[1]/input")).clear();
	    Thread.sleep(500);
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_SearchWidget_16']/div/div[1]/input")).sendKeys("Day");
	    Thread.sleep(1000);
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_SearchWidget_16']/div/div[3]/button")).click();
	    Thread.sleep(5000);
	    driver.findElement(By.xpath(".//*[@id='lead_list']/ul/li/div/h3")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if ("Day, Bob".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // VP: confirm that Global Menu button is available...
	    try {
	      AssertJUnit.assertTrue(isElementPresent(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    Thread.sleep(1000);
	    
	    // Step: click the top Edit button...
	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[2]")).click();
	    try {
	      AssertJUnit.assertTrue(isElementPresent(By.xpath("//div[@id='lead_edit']/div[2]/fieldset/div[2]")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    Thread.sleep(1000);
	    
	    // Step: click the Comments edit buton...
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_Fields_NoteField_2']/button")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if ("Comments".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // VP: confirm that Global Menu button is available...
	    try {
	      AssertJUnit.assertTrue(isElementPresent(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    
	    // Step: navigate back to Lead screen...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if ("Lead".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // Step: click the top Cancel button...
	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if ("Day, Bob".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // Step: navigate back to the Leads screen...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if ("Leads".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if ("My Activities".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }	
	    // -- END
	    System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
	  }

	@Test (enabled = false)
	  public void test08_SeTestTCGlobalMenuEditNote() throws Exception {
	    // SETest-GlobalMenu_EditNote_Screens
	    // Version: 2.2
	    // Desc: Confirms that the toggle button (left and right) for Global Menu access is visible on screens accessible under the Edit Note screens...
	    // Note: This test script can be used as a template for adding/editing a Note.
	    // Condition(s): Test user is logged in.    
	    // ==================================================================
		String methodID = "test08_SeTestTCGlobalMenuEditNote";
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
	    // Step: click Top-Left button to reveal Global Menu...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[1]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if (isElementPresent(By.xpath(".//*[@id='Mobile_SalesLogix_SpeedSearchWidget_0']/div/div[1]/input"))) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // Step: navigate to Notes list view...
	    driver.findElement(By.xpath(".//*[@id='left_drawer']/descendant::*[text() = \"Notes/History\"]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if (isElementPresent(By.xpath(".//*[@id='history_list']/ul/li[1]"))) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // Step: perform search for Note items...
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_SearchWidget_27']/div/div[1]/input")).clear();
	    Thread.sleep(500);
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_SearchWidget_27']/div/div[1]/input")).sendKeys("notes");
	    Thread.sleep(1000);
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_SearchWidget_27']/div/div[3]/button")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if (isElementPresent(By.xpath(".//*[@id='history_list']/ul/li[1]"))) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	    Thread.sleep(1000);
	
	    // Step: navigate to top Notes/History record...
	    driver.findElement(By.xpath("//*[@id='history_list']/ul/li[1]/div/h3")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if ("Note".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // VP: confirm that Global Menu button is available...
	    try {
	      AssertJUnit.assertTrue(isElementPresent(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: click the top Edit button...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[2]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if (isElementPresent(By.xpath(".//*[@id='history_edit']/div[2]/fieldset[1]/div[4]"))) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	    Thread.sleep(1000);
	
	    // Step: click the Regarding edit buton...
	    // NOTE: this section seems to only work for Chrome; Note Description fails to open on button click for IE and FF
	    if (browsername.equals("chrome")) {
	    	driver.findElement(By.xpath("//*[@id='Mobile_SalesLogix_Fields_PicklistField_35']/button")).click();
	    	for (int second = 0;; second++) {
	    		if (second >= 60) Assert.fail("timeout");
	    		try { if ("Note Description".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    		Thread.sleep(1000);
	    	}
	
	    	// VP: confirm that Global Menu button is available...
	    	try {
	    		AssertJUnit.assertTrue(isElementPresent(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button")));
	    	} catch (Error e) {
	    		verificationErrors.append(e.toString());
	    	}
	    	// Step: navigate back to Note screen...
	    	driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    	for (int second = 0;; second++) {
	    		if (second >= 60) Assert.fail("timeout");
	    		try { if ("Note".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    		Thread.sleep(1000);
	    	}
	    }
	
	    // Step: click the For Lead toggle to ON...
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_Fields_BooleanField_12']/div/span[1]")).click();
	    // Step: click the Lead edit button...
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_Fields_LookupField_43']/button")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if ("Leads".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // VP: confirm that Global Menu button is available...
	    try {
	      AssertJUnit.assertTrue(isElementPresent(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: navigate back to Note screen...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if ("Note".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if ("Note".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if ("Notes/History".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if ("My Activities".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }	
	    // -- END
	    System.out.println(ENDLINE);
	  }

	@Test (enabled = false)
	  public void test09_SeTestTCGlobalMenuEditOppContactScreens() throws Exception {
	    // SETest-GlobalMenu_EditOppContact_Screens
	    // Version: 2.2
	    // Desc: Confirms that the toggle button (left and right) for Global Menu access is visible on screens accessible under the Edit Opportunity-Contact screens...
	    // Note: This test script can be used as a template for completing/editing an Opportunity-Contact.
	    // Condition(s): Test user is logged in.    
	    // ==================================================================
		String methodID = "test09_SeTestTCGlobalMenuEditOppContactScreens";
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
	    // Step: click Top-Left button to reveal Global Menu...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[1]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if (isElementPresent(By.xpath(".//*[@id='Mobile_SalesLogix_SpeedSearchWidget_0']/div/div[1]/input"))) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // Step: navigate to Opportunity list view...
	    driver.findElement(By.xpath(".//*[@id='left_drawer']/descendant::*[text() = \"Opportunities\"]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if (isElementPresent(By.xpath(".//*[@id='opportunity_list']/ul/li[1]"))) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // Step: perform search for Opportunity records...
	    driver.findElement(By.cssSelector("#Sage_Platform_Mobile_SearchWidget_11 > div.table-layout > div > input[name=\"query\"]")).clear();
	    Thread.sleep(500);
	    driver.findElement(By.cssSelector("#Sage_Platform_Mobile_SearchWidget_11 > div.table-layout > div > input[name=\"query\"]")).sendKeys("Abbott WorldWide");
	    Thread.sleep(1000);
	    driver.findElement(By.cssSelector("#Sage_Platform_Mobile_SearchWidget_11 > div.table-layout > div.hasButton > button.subHeaderButton.searchButton")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if (isElementPresent(By.xpath(".//*[@id='opportunity_list']/ul/li[1]"))) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	    Thread.sleep(1000);
	
	    // Step: navigate to top Opportunity record...
	    driver.findElement(By.xpath(".//*[@id='opportunity_list']/ul/li[1]/div/h3")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if (!"Opportunities".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // VP: confirm that Global Menu button is available...
	    try {
	      AssertJUnit.assertTrue(isElementPresent(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    
	    // Step: click the Opportunity Contacts link...
	    driver.findElement(By.xpath("//div[@id='opportunity_detail']/div[2]/ul[2]/li[3]/a/span")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if ("Opportunity Contacts".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	    Thread.sleep(1000);
	
	    // Step: click the top Add buton...
	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[2]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if ("Select Contact".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	    Thread.sleep(1000);
	
	    // VP: confirm that Global Menu button is available...
	    try {
	      AssertJUnit.assertTrue(isElementPresent(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    
	    // Step: click the top Contact record...
	    driver.findElement(By.xpath("//*[@id='contact_related']/ul/li[1]/div/h3")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if ("Edit Opp. Contact".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // VP: confirm that Global Menu button is available...
	    try {
	      AssertJUnit.assertTrue(isElementPresent(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    
	    // Step: click the Role edit button...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Fields_PicklistField_20']/button")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if ("Role".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	    Thread.sleep(1000);
	
	    // VP: confirm that Global Menu button is available...
	    try {
	      AssertJUnit.assertTrue(isElementPresent(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    
	    // Step: click and select the None button...
	    //driver.findElement(By.xpath(".//*[@id='pick_list_4']/div[2]/button")).click();
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if ("Edit Opp. Contact".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // Step: click the Standing edit button...
	    driver.findElement(By.xpath("//*[@id='Mobile_SalesLogix_Fields_PicklistField_21']/button")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if ("Standing".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // VP: confirm that Global Menu button is available...
	    try {
	      AssertJUnit.assertTrue(isElementPresent(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    
	    // Step: click and select the None button...
	    //driver.findElement(By.xpath(".//*[@id='pick_list_5']/div[2]/button")).click();
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if ("Edit Opp. Contact".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // Step: click the Competitor Pref edit button...
	    driver.findElement(By.xpath("//*[@id='Sage_Platform_Mobile_Fields_LookupField_12']/button")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if ("Competitors".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // VP: confirm that Global Menu button is available...
	    try {
	      AssertJUnit.assertTrue(isElementPresent(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    
	    // Step: click and select the top Competitor item...
	    //driver.findElement(By.xpath("//*[@id='competitor_related']/ul/li[1]/div/h3")).click();
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if ("Edit Opp. Contact".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // Step: click the top Cancel button...
	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if ("Opportunity Contacts".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // Step: click the top Back button...
	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if (!"Opportunity Contacts".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // Step: navigate back...
	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if ("Opportunities".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if ("My Activities".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }	
	    // -- END
	    System.out.println(ENDLINE);
	  }

	@Test (enabled = false)
	  public void test10_SeTestTCGlobalMenuEditOpportunityScreens() throws Exception {
	    // SETest-GlobalMenu_EditOpportunity_Screens
	    // Version: 2.2
	    // Desc: Confirms that the toggle button (left and right) for Global Menu access is visible on screens accessible under the Edit Opportunity screens...
	    // Note: This test script can be used as a template for completing/editing an Opportunity-Contact.
	    // Condition(s): Test user is logged in.    
	    // ==================================================================
		String methodID = "test10_SeTestTCGlobalMenuEditOpportunityScreens";
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
	    // Step: click Top-Left button to reveal Global Menu...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[1]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if (isElementPresent(By.xpath(".//*[@id='Mobile_SalesLogix_SpeedSearchWidget_0']/div/div[1]/input"))) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // Step: navigate to Opportunity list view...
	    driver.findElement(By.xpath(".//*[@id='left_drawer']/descendant::*[text() = \"Opportunities\"]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if (isElementPresent(By.xpath(".//*[@id='opportunity_list']/ul/li[1]"))) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // Step: perform search for Opportunity records...
	    driver.findElement(By.cssSelector("#Sage_Platform_Mobile_SearchWidget_11 > div.table-layout > div > input[name=\"query\"]")).clear();
	    driver.findElement(By.cssSelector("#Sage_Platform_Mobile_SearchWidget_11 > div.table-layout > div > input[name=\"query\"]")).sendKeys("Abbott WorldWide");
	    driver.findElement(By.cssSelector("#Sage_Platform_Mobile_SearchWidget_11 > div.table-layout > div.hasButton > button.subHeaderButton.searchButton")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if (isElementPresent(By.xpath(".//*[@id='opportunity_list']/ul/li[1]"))) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // Step: navigate to top Opportunity record...
	    driver.findElement(By.xpath("//*[@id='opportunity_list']/ul/li[1]/div/h3")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if (!"Opportunities".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // VP: confirm that Global Menu button is available...
	    try {
	      AssertJUnit.assertTrue(isElementPresent(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: click the top Edit button...
	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[2]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if ("Opportunity".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // Step: click the Account Manager edit button...
	    driver.findElement(By.xpath("//*[@id='Sage_Platform_Mobile_Fields_LookupField_6']/button")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if ("Accounts".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // VP: confirm that Global Menu button is available...
	    try {
	      AssertJUnit.assertTrue(isElementPresent(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: navigate back to the Opportunity view...
	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if ("Opportunity".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // Step: click the Reseller edit button...
	    driver.findElement(By.xpath("//*[@id='Sage_Platform_Mobile_Fields_LookupField_8']/button")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if ("Accounts".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // VP: confirm that Global Menu button is available...
	    try {
	      AssertJUnit.assertTrue(isElementPresent(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: navigate back to the Opportunity view...
	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if ("Opportunity".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // Step: click the Type edit button...
	    driver.findElement(By.xpath("//*[@id='Mobile_SalesLogix_Fields_PicklistField_17']/button")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if ("Opportunity Type".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // VP: confirm that Global Menu button is available...
	    try {
	      AssertJUnit.assertTrue(isElementPresent(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: navigate back to the Opportunity view...
	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if ("Opportunity".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // Step: click the Status edit button...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Fields_PicklistField_18']/button")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if ("Opportunity Status".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // VP: confirm that Global Menu button is available...
	    try {
	      AssertJUnit.assertTrue(isElementPresent(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: navigate back to the Opportunity view...
	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if ("Opportunity".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // Step: click the Lead Source edit button...
	    driver.findElement(By.xpath("//*[@id='Sage_Platform_Mobile_Fields_LookupField_9']/button")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if ("Lead Sources".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // VP: confirm that Global Menu button is available...
	    try {
	      AssertJUnit.assertTrue(isElementPresent(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: navigate back to the Opportunity view...
	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if ("Opportunity".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // Step: click the Owner edit button...
	    driver.findElement(By.xpath("//*[@id='Sage_Platform_Mobile_Fields_LookupField_10']/button")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if ("Owners".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // VP: confirm that Global Menu button is available...
	    try {
	      AssertJUnit.assertTrue(isElementPresent(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: navigate back to the Opportunity view...
	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if ("Opportunity".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // Step: click the Close Prob edit button...
	    driver.findElement(By.xpath("//*[@id='Mobile_SalesLogix_Fields_PicklistField_19']/button")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if ("Opportunity Probability".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // VP: confirm that Global Menu button is available...
	    try {
	      AssertJUnit.assertTrue(isElementPresent(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: navigate back to the Opportunity view...
	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if ("Opportunity".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // Step: click the Code edit button...
	    driver.findElement(By.xpath("//*[@id='Sage_Platform_Mobile_Fields_LookupField_11']/button")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if ("Exchange Rates".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // VP: confirm that Global Menu button is available...
	    try {
	      AssertJUnit.assertTrue(isElementPresent(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: navigate back to the Opportunity view...
	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if ("Opportunity".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // Step: click the top Cancel button...
	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if (!"Opportunity".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // Step: navigate back...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if ("Opportunities".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if ("My Activities".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	    // -- END
	    System.out.println(ENDLINE);
	  }

	@Test (enabled = false)
	  public void test11_SeTestTCGlobalMenuEditOppProductScreens() throws Exception {
	    // SETest-GlobalMenu_EditOppProduct_Screens
	    // Version: 2.2
	    // Desc: Confirms that the toggle button (left and right) for Global Menu access is visible on screens accessible under the Edit Opportunity-Product screens...
	    // Note: This test script can be used as a template for completing/editing an Opportunity-Product.
	    // Condition(s): Test user is logged in.    
	    // ==================================================================
		String methodID = "test11_SeTestTCGlobalMenuEditOppProductScreens";
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
	    // Step: click Top-Left button to reveal Global Menu...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[1]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if (isElementPresent(By.xpath(".//*[@id='Mobile_SalesLogix_SpeedSearchWidget_0']/div/div[1]/input"))) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // Step: navigate to Opportunity list view...
	    driver.findElement(By.xpath(".//*[@id='left_drawer']/descendant::*[text() = \"Opportunities\"]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if (isElementPresent(By.xpath(".//*[@id='opportunity_list']/ul/li[1]"))) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // Step: perform search for Opportunity records...
	    driver.findElement(By.cssSelector("#Sage_Platform_Mobile_SearchWidget_11 > div.table-layout > div > input[name=\"query\"]")).clear();
	    driver.findElement(By.cssSelector("#Sage_Platform_Mobile_SearchWidget_11 > div.table-layout > div > input[name=\"query\"]")).sendKeys("Abbott WorldWide");
	    driver.findElement(By.cssSelector("#Sage_Platform_Mobile_SearchWidget_11 > div.table-layout > div.hasButton > button.subHeaderButton.searchButton")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if (isElementPresent(By.xpath(".//*[@id='opportunity_list']/ul/li[1]"))) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // Step: navigate to top Opportunity record...
	    driver.findElement(By.xpath("//*[@id='opportunity_list']/ul/li[1]/div/h3")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if (!"Opportunities".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // VP: confirm that Global Menu button is available...
	    try {
	      AssertJUnit.assertTrue(isElementPresent(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: click the Products link...
	    driver.findElement(By.xpath("//div[@id='opportunity_detail']/div[2]/ul[2]/li/a/span")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if ("Products".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // Step: click the top Add buton...
	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[2]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if ("Opportunity Product".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // VP: confirm that Global Menu button is available...
	    try {
	      AssertJUnit.assertTrue(isElementPresent(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: click the Product edit button...
	    driver.findElement(By.xpath("//*[@id='Sage_Platform_Mobile_Fields_LookupField_14']/button")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if ("Products".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // VP: confirm that Global Menu button is available...
	    try {
	      AssertJUnit.assertTrue(isElementPresent(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: click and select the top Product item...
	    driver.findElement(By.xpath("//*[@id='product_related']/ul/li[1]/div/h3")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if ("Opportunity Product".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // Step: click the Price Level edit button...
	    driver.findElement(By.xpath("//*[@id='Sage_Platform_Mobile_Fields_LookupField_15']/button")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if ("Product Programs".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // VP: confirm that Global Menu button is available...
	    try {
	      AssertJUnit.assertTrue(isElementPresent(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: click the top Cancel button...
	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if ("Opportunity Product".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // Step: click the top Cancel button...
	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if ("Products".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // Step: navigate back...
	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if (!"Products".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if ("Opportunities".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if ("My Activities".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	    // -- END
	    System.out.println(ENDLINE);
	  }

	@Test (enabled = false)
	  public void test12_SeTestTCGlobalMenuEditOppTicketScreens() throws Exception {
	    // SETest-GlobalMenu_EditTicket_Screens
	    // Version: 2.2
	    // Desc: Confirms that the toggle button (left and right) for Global Menu access is visible on screens accessible under the Ticket edit screens...
	    // Note: This test script can be used as a template for completing/editing an Ticket.
	    // Condition(s): Test user is logged in.    
	    // ==================================================================
		String methodID = "test12_SeTestTCGlobalMenuEditOppTicketScreens";
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
	    // Step: click Top-Left button to reveal Global Menu...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[1]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if (isElementPresent(By.xpath("//*[@id='left_drawer']/div[3]/ul[1]"))) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // Step: navigate to Tickets list view...
	    driver.findElement(By.xpath(".//*[@id='left_drawer']/descendant::*[text() = \"Tickets\"]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if (isElementPresent(By.xpath(".//*[@id='ticket_list']/ul/li[1]"))) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // Step: perform search for Tickets records...
	    driver.findElement(By.cssSelector("#Sage_Platform_Mobile_SearchWidget_18 > div.table-layout > div > input[name=\"query\"]")).clear();
	    driver.findElement(By.cssSelector("#Sage_Platform_Mobile_SearchWidget_18 > div.table-layout > div > input[name=\"query\"]")).sendKeys("000-00-000011");
	    driver.findElement(By.cssSelector("#Sage_Platform_Mobile_SearchWidget_18 > div.table-layout > div.hasButton > button.subHeaderButton.searchButton")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if (isElementPresent(By.xpath(".//*[@id='ticket_list']/ul/li[1]"))) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // Step: navigate to top Ticket record...
	    driver.findElement(By.xpath("//*[@id='ticket_list']/ul/li/div/h3")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if (!"Tickets".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // VP: confirm that Global Menu button is available...
	    try {
	      AssertJUnit.assertTrue(isElementPresent(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: click the top Edit button...
	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[2]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if ("Ticket".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // Step: click the Contract edit button...
	    driver.findElement(By.xpath("//*[@id='Sage_Platform_Mobile_Fields_LookupField_19']/button")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if ("Contacts".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // VP: confirm that Global Menu button is available...
	    try {
	      AssertJUnit.assertTrue(isElementPresent(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: navigate back to the Ticket view...
	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if ("Ticket".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // Step: click the Area edit button...
	    driver.findElement(By.xpath("//*[@id='Sage_Platform_Mobile_Fields_LookupField_21']/button")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if ("Ticket Area".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // VP: confirm that Global Menu button is available...
	    try {
	      AssertJUnit.assertTrue(isElementPresent(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: select the top list item to return to the Ticket view...
	    driver.findElement(By.xpath("//*[@id='areacategoryissue_lookup']/ul/li[1]/div/h3")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if ("Ticket".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // Step: click the Category edit button...
	    driver.findElement(By.xpath("//*[@id='Sage_Platform_Mobile_Fields_LookupField_22']/button")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if ("Ticket Category".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // VP: confirm that Global Menu button is available...
	    try {
	      AssertJUnit.assertTrue(isElementPresent(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: select the top list item to return to the Ticket view...
	    driver.findElement(By.xpath("//*[@id='areacategoryissue_lookup']/ul/li/div/h3")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if ("Ticket".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // Step: click the Issue edit button...
	    driver.findElement(By.xpath("//*[@id='Sage_Platform_Mobile_Fields_LookupField_23']/button")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if ("Ticket Issue".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // VP: confirm that Global Menu button is available...
	    try {
	      AssertJUnit.assertTrue(isElementPresent(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: navigate back to the Ticket view...
	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if ("Ticket".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // Step: click the Source edit button...
	    driver.findElement(By.xpath("//*[@id='Mobile_SalesLogix_Fields_PicklistField_24']/button")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if ("Source".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // VP: confirm that Global Menu button is available...
	    try {
	      AssertJUnit.assertTrue(isElementPresent(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: navigate back to the Ticket view...
	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if ("Ticket".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // Step: click the Status edit button...
	    driver.findElement(By.xpath("//*[@id='Mobile_SalesLogix_Fields_PicklistField_25']/button")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if ("Ticket Status".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // VP: confirm that Global Menu button is available...
	    try {
	      AssertJUnit.assertTrue(isElementPresent(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: navigate back to the Ticket view...
	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if ("Ticket".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // Step: click the Urgency edit button...
	    driver.findElement(By.xpath("//*[@id='Sage_Platform_Mobile_Fields_LookupField_24']/button")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if ("Ticket Urgency".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // VP: confirm that Global Menu button is available...
	    try {
	      AssertJUnit.assertTrue(isElementPresent(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: navigate back to the Ticket view...
	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if ("Ticket".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // Step: click the Description edit button...
	    driver.findElement(By.xpath("//*[@id='Sage_Platform_Mobile_Fields_NoteField_3']/button")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if ("Description".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // VP: confirm that Global Menu button is available...
	    try {
	      AssertJUnit.assertTrue(isElementPresent(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: navigate back to the Ticket view...
	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if ("Ticket".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // Step: click the Resolution edit button...
	    driver.findElement(By.xpath("//*[@id='Sage_Platform_Mobile_Fields_NoteField_4']/button")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if ("Resolution".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // VP: confirm that Global Menu button is available...
	    try {
	      AssertJUnit.assertTrue(isElementPresent(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: navigate back to the Ticket view...
	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if ("Ticket".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // Step: click the Comments edit button...
	    driver.findElement(By.xpath("//*[@id='Sage_Platform_Mobile_Fields_NoteField_5']/button")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if ("Comments".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // VP: confirm that Global Menu button is available...
	    try {
	      AssertJUnit.assertTrue(isElementPresent(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: navigate back to the Ticket view...
	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if ("Ticket".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // Step: click the top Cancel button...
	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if (!"Ticket".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // Step: navigate back...
	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if ("Tickets".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if ("My Activities".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	    // -- END
	    System.out.println(ENDLINE);
	  }

	@Test (enabled = false)
	  public void test13_SeTestTCGlobalMenuEditTicketActivitiesScreens() throws Exception {
	    // SETest-GlobalMenu_EditTicketActivities_Screens
	    // Version: 2.2
	    // Desc: Confirms that the toggle button (left and right) for Global Menu access is visible on screens accessible under the Ticket Activities screens...
	    // Note: This test script can be used as a template for completing/editing an Ticket-Activity.
	    // Condition(s): Test user is logged in.    
	    // ==================================================================
		String methodID = "test13_SeTestTCGlobalMenuEditTicketActivitiesScreens";
		 
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);	
	    // Step: click Top-Left button to reveal Global Menu...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[1]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if (isElementPresent(By.xpath("//*[@id='left_drawer']/div[3]/ul[1]"))) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // Step: navigate to Tickets list view...
	    driver.findElement(By.xpath(".//*[@id='left_drawer']/descendant::*[text() = \"Tickets\"]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if (isElementPresent(By.xpath(".//*[@id='ticket_list']/ul/li[1]"))) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // Step: perform search for Ticket records...
	    driver.findElement(By.cssSelector("#Sage_Platform_Mobile_SearchWidget_18 > div.table-layout > div > input[name=\"query\"]")).clear();
	    driver.findElement(By.cssSelector("#Sage_Platform_Mobile_SearchWidget_18 > div.table-layout > div > input[name=\"query\"]")).sendKeys("000-00-000011");
	    driver.findElement(By.cssSelector("#Sage_Platform_Mobile_SearchWidget_18 > div.table-layout > div.hasButton > button.subHeaderButton.searchButton")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if (isElementPresent(By.xpath(".//*[@id='ticket_list']/ul/li[1]"))) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // Step: navigate to top Ticket record...
	    driver.findElement(By.xpath("//*[@id='ticket_list']/ul/li/div/h3")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if (!"Tickets".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // VP: confirm that Global Menu button is available...
	    try {
	      AssertJUnit.assertTrue(isElementPresent(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	
	    // Step: click the Ticket Activities...
	    driver.findElement(By.xpath("//div[@id='ticket_detail']/div[2]/ul[2]/li[2]/a/span")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if ("Ticket Activities".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // VP: confirm that Global Menu button is available...
	    try {
	      AssertJUnit.assertTrue(isElementPresent(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: click the top Ticket Activity list item...
	    driver.findElement(By.xpath("//*[@id='ticketactivity_related']/ul/li[1]/div/h3")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if (!"Ticket Activities".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // Step: click the top Edit button...
	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[2]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if ("Edit Ticket Activity".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // VP: confirm that Global Menu button is available...
	    try {
	      AssertJUnit.assertTrue(isElementPresent(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: click the Type edit button...
	    driver.findElement(By.xpath("//*[@id='Mobile_SalesLogix_Fields_PicklistField_26']/button")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if ("Type".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // VP: confirm that Global Menu button is available...
	    try {
	      AssertJUnit.assertTrue(isElementPresent(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: navigate back to the Edit Ticket Activity view...
	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if ("Edit Ticket Activity".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // Step: click the Public Access edit button...
	    driver.findElement(By.xpath("//*[@id='Mobile_SalesLogix_Fields_PicklistField_27']/button")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if ("Public Access".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // VP: confirm that Global Menu button is available...
	    try {
	      AssertJUnit.assertTrue(isElementPresent(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: navigate back to the Edit Ticket Activity view...
	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if ("Edit Ticket Activity".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // Step: navigate back to the Ticket view...
	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if (!"Edit Ticket Activity".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // Step: navigate back...
	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if (!"Ticket Activities".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    Thread.sleep(1000);	    
	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if ("My Activities".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }	
	    // -- END
	    System.out.println(ENDLINE);	
	  }

	@Test (enabled = false)
	  public void test14_SeTestTCGlobalMenuItemCheck() throws Exception {
	    // SETest-GlobalMenu_ItemCheck
	    // Version: 2.2
	    // Desc: Opens the Global Menu and verifies each of the expected menu items.
	    // Condition(s): Test user is logged in.    
	    // ==================================================================
		String methodID = "test14_SeTestTCGlobalMenuItemCheck";
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
	    // Step: click Top-Left button to reveal Global Menu...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[1]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if (isElementPresent(By.xpath("//*[@id='left_drawer']/div[3]/ul[1]"))) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // VP: check the Quick Actions section and items...
	    try {
	      AssertJUnit.assertEquals("Quick Actions", driver.findElement(By.xpath("//*[@id='left_drawer']/div[3]/h2[1]")).getText());
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    try {
	      AssertJUnit.assertTrue(isElementPresent(By.xpath("//*[@id='left_drawer']/div[3]/h2[1]/button")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    try {
	      AssertJUnit.assertTrue(isElementPresent(By.xpath("//*[@id='left_drawer']/div[3]/ul[1]/li/div[1]/img")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    try {
	      AssertJUnit.assertEquals("Add Account/Contact", driver.findElement(By.xpath("//*[@id='left_drawer']/div[3]/ul[1]/li/div[2]/h3")).getText());
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // VP: check the Go To section and items...
	    try {
	      AssertJUnit.assertEquals("Go To", driver.findElement(By.xpath("//*[@id='left_drawer']/div[3]/h2[2]")).getText());
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    try {
	      AssertJUnit.assertTrue(isElementPresent(By.xpath("//*[@id='left_drawer']/div[3]/h2[2]/button")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    try {
	      AssertJUnit.assertTrue(isElementPresent(By.xpath("//*[@id='left_drawer']/div[3]/ul[2]/li[1]/div[1]/img")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    try {
	      AssertJUnit.assertEquals("SpeedSearch", driver.findElement(By.xpath("//*[@id='left_drawer']/div[3]/ul[2]/li/div[2]/h3")).getText());
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    try {
	      AssertJUnit.assertTrue(isElementPresent(By.xpath("//*[@id='left_drawer']/div[3]/ul[2]/li[2]/div[1]/img")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    try {
	      AssertJUnit.assertEquals("My Activities", driver.findElement(By.xpath("//*[@id='left_drawer']/div[3]/ul[2]/li[2]/div[2]/h3")).getText());
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    try {
	      AssertJUnit.assertTrue(isElementPresent(By.xpath("//*[@id='left_drawer']/div[3]/ul[2]/li[3]/div[1]/img")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    try {
	      AssertJUnit.assertEquals("Calendar", driver.findElement(By.xpath("//*[@id='left_drawer']/div[3]/ul[2]/li[3]/div[2]/h3")).getText());
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    try {
	      AssertJUnit.assertTrue(isElementPresent(By.xpath("//*[@id='left_drawer']/div[3]/ul[2]/li[4]/div[1]/img")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    try {
	      AssertJUnit.assertEquals("Notes/History", driver.findElement(By.xpath("//*[@id='left_drawer']/div[3]/ul[2]/li[4]/div[2]/h3")).getText());
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    try {
	      AssertJUnit.assertTrue(isElementPresent(By.xpath("//*[@id='left_drawer']/div[3]/ul[2]/li[5]/div[1]")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    try {
	      AssertJUnit.assertEquals("Accounts", driver.findElement(By.xpath("//*[@id='left_drawer']/div[3]/ul[2]/li[5]/div[2]/h3")).getText());
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    try {
	      AssertJUnit.assertTrue(isElementPresent(By.xpath("//*[@id='left_drawer']/div[3]/ul[2]/li[6]/div[1]/img")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    try {
	      AssertJUnit.assertEquals("Contacts", driver.findElement(By.xpath("//*[@id='left_drawer']/div[3]/ul[2]/li[6]/div[2]/h3")).getText());
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    try {
	      AssertJUnit.assertTrue(isElementPresent(By.xpath("//*[@id='left_drawer']/div[3]/ul[2]/li[7]/div[1]/img")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    try {
	      AssertJUnit.assertEquals("Leads", driver.findElement(By.xpath("//*[@id='left_drawer']/div[3]/ul[2]/li[7]/div[2]/h3")).getText());
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    try {
	      AssertJUnit.assertTrue(isElementPresent(By.xpath("//*[@id='left_drawer']/div[3]/ul[2]/li[8]/div[1]/img")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    try {
	      AssertJUnit.assertEquals("Opportunities", driver.findElement(By.xpath("//*[@id='left_drawer']/div[3]/ul[2]/li[8]/div[2]/h3")).getText());
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    try {
	      AssertJUnit.assertTrue(isElementPresent(By.xpath("//*[@id='left_drawer']/div[3]/ul[2]/li[9]/div[1]/img")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    try {
	      AssertJUnit.assertEquals("Tickets", driver.findElement(By.xpath("//*[@id='left_drawer']/div[3]/ul[2]/li[9]/div[2]/h3")).getText());
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    try {
	      AssertJUnit.assertTrue(isElementPresent(By.xpath("//*[@id='left_drawer']/div[3]/ul[2]/li[10]/div[1]/img")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    try {
	      AssertJUnit.assertEquals("My Attachments", driver.findElement(By.xpath("//*[@id='left_drawer']/div[3]/ul[2]/li[10]/div[2]/h3")).getText());
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // VP: check the Other section and items...
	    try {
	      AssertJUnit.assertEquals("Other", driver.findElement(By.xpath("//*[@id='left_drawer']/div[3]/h2[3]")).getText());
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    try {
	      AssertJUnit.assertTrue(isElementPresent(By.xpath("//*[@id='left_drawer']/div[3]/h2[3]/button")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    try {
	      AssertJUnit.assertTrue(isElementPresent(By.xpath("//*[@id='left_drawer']/div[3]/ul[3]/li[1]/div[1]/img")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    try {
	      AssertJUnit.assertEquals("Configure Menu", driver.findElement(By.xpath("//*[@id='left_drawer']/div[3]/ul[3]/li[1]/div[2]/h3")).getText());
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    try {
	      AssertJUnit.assertTrue(isElementPresent(By.xpath("//*[@id='left_drawer']/div[3]/ul[3]/li[2]/div[1]/img")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    try {
	      AssertJUnit.assertEquals("Settings", driver.findElement(By.xpath("//*[@id='left_drawer']/div[3]/ul[3]/li[2]/div[2]/h3")).getText());
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    try {
	      AssertJUnit.assertTrue(isElementPresent(By.xpath("//*[@id='left_drawer']/div[3]/ul[3]/li[3]/div[1]/img")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    try {
	      AssertJUnit.assertEquals("Help", driver.findElement(By.xpath("//*[@id='left_drawer']/div[3]/ul[3]/li[3]/div[2]/h3")).getText());
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    try {
	      AssertJUnit.assertTrue(isElementPresent(By.xpath("//*[@id='left_drawer']/div[3]/ul[3]/li[4]/div[1]/img")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    try {
	      AssertJUnit.assertEquals("Log Out", driver.findElement(By.xpath("//*[@id='left_drawer']/div[3]/ul[3]/li[4]/div[2]/h3")).getText());
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: click the Top-Left button to close the Global Menu...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[1]")).click();
	    // -- END
	    System.out.println(ENDLINE);
	  }

	@Test (enabled = false)
	  public void test15_SeTestTCGlobalMenuSearchAttachments() throws Exception {
	    // SE Test: SETest-GlobalMenu_SearchAttachments
	    // Version: 2.2
	    // Desc: Opens the Global Menu, accesses the My Attachments list view then performs an Attachment search...
	    // Condition(s): Test user is logged in.    
	    // ==================================================================
		String methodID = "test15_SeTestTCGlobalMenuSearchAttachments";
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
	    // Step: click Top-Left button to reveal Global Menu...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[1]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if (isElementPresent(By.xpath("//*[@id='left_drawer']/div[3]/ul[1]"))) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // Step: navigate to Attachments list view...
	    driver.findElement(By.xpath(".//*[@id='left_drawer']/descendant::*[text() = \"My Attachments\"]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if (isElementPresent(By.xpath(".//*[@id='myattachment_list']/ul/li[1]"))) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // Step: perform search for Attachment records...
	    driver.findElement(By.cssSelector("#Sage_Platform_Mobile_SearchWidget_35 > div.table-layout > div > input[name=\"query\"]")).clear();
	    driver.findElement(By.cssSelector("#Sage_Platform_Mobile_SearchWidget_35 > div.table-layout > div > input[name=\"query\"]")).sendKeys("Plate");
	    driver.findElement(By.cssSelector("#Sage_Platform_Mobile_SearchWidget_35 > div.table-layout > div.hasButton > button.subHeaderButton.searchButton")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if (isElementPresent(By.xpath(".//*[@id='myattachment_list']/ul/li[1]"))) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // Step: navigate to top Attachment record...
	    // Warning: verifyTextPresent may require manual changes
	    try {
	      AssertJUnit.assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Plate[\\s\\S]*$"));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // Step: navigate back...
	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if ("My Activities".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }	
	    // -- END
	    System.out.println(ENDLINE);
	  }


  
}
