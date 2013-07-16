package argos.saleslogix.selenium.test;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class AccountEntityViewsTest extends BrowserSetup {
	
	//Test Set
	//========
	@Test(enabled = false)
	public void test01_SeTestTCAccountListView() throws Exception {
		String methodID = "test01_SeTestTCAccountListView";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerbutton = PageFactory.initElements(driver, HeaderButton.class);
		
		// Test Params:
		String entityType = "accounts";
		String expEntityPgTitle = "Accounts";

		System.out.println(STARTLINE);
	    //Step: click Top-Left button to reveal Global Menu...
		headerbutton.showGlobalMenu();
	
	    //Step: navigate to Accounts list view...
		commNav.clickGlobalMenuItem(entityType);
		
		//Step: test Accounts, List View page elements
		// SubStep: check the Page Title
		if (commNav.isPageDisplayed(expEntityPgTitle)) {
			
			AccountViewsElements accountListView = PageFactory.initElements(driver, AccountViewsElements.class);
			
			//Step: check the Accounts Search widget elements
			commNav.checkIfWebElementPresent("Accounts List View, Search - input text box", accountListView.accountsSearchTxtBox);
			accountListView.accountsSearchTxtBox.click();
			commNav.checkIfWebElementPresent("Accounts List View, Search - input clear button", accountListView.accountsSearchClearBtn);
			commNav.checkIfWebElementPresent("Accounts List View, Search - Lookup button", accountListView.accountsSearchLookupBtn);
			
			//Step: check the Accounts list view format
			commNav.checkIfWebElementPresent("Accounts List View", accountListView.accountsListView);
			
			//Step: check an Account list view item record
			commNav.checkIfWebElementPresent("Accounts List View, item record", accountListView.topAccountsListItem);
			commNav.checkIfWebElementPresent("Accounts List View, item record icon", accountListView.topAccountsListItemIcon);
			commNav.checkIfWebElementPresent("Accounts List View, item record name", accountListView.topAccountsListItemName);
			commNav.checkIfWebElementPresent("Accounts List View, item record line 2", accountListView.topAccountsListItemLine2);
			commNav.checkIfWebElementPresent("Accounts List View, item record line 3", accountListView.topAccountsListItemLine3);
			commNav.checkIfWebElementPresent("Accounts List View, item record line 4", accountListView.topAccountsListItemLine4);
			commNav.checkIfWebElementPresent("Accounts List View, item record line 5", accountListView.topAccountsListItemLine5);
			
			//Step: check the "X records remaining" item box at the bottom of the list view
			commNav.checkIfWebElementPresent("Accounts List View, 'x remaining records' item", accountListView.recordsRemainingListItem);
		}
		else {
			System.out.println(methodID + ": required '" + expEntityPgTitle + "' not loaded; test aborted");
		}
		System.out.println(ENDLINE);
	}

	
	@Test(enabled = false)
	public void test02_SeTestTCAccountListViewLoadMoreResults() throws Exception {
		String methodID = "test02_SeTestTCAccountListViewLoadMoreResults";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerbutton = PageFactory.initElements(driver, HeaderButton.class);
		
		//Test Params:
		String entityType = "accounts";

		System.out.println(STARTLINE);
	    //Step: click Top-Left button to reveal Global Menu...
		headerbutton.showGlobalMenu();
	
	    //Step: navigate to Accounts list view...
		commNav.clickGlobalMenuItem(entityType);
	
	    //Step: load more results (click on 'x remaining records' item)
		for (int count = 0; count<=2; count++) {
			WebElement remainingRecordsItem = driver.findElement(By.xpath("//*[@id='account_list']/div[3]"));
			commNav.highlightElement(remainingRecordsItem);
			remainingRecordsItem.click();
			Thread.sleep(3000);		
		}
		
		//Step: check if the 31th record item is present
		WebElement thirtyfirstRecordItem = driver.findElement(By.xpath("//*[@id='account_list']/ul/li[31]"));
		commNav.checkIfWebElementPresent("31st Account List View record available after load more records", thirtyfirstRecordItem);
		
		System.out.println(ENDLINE);
	}

	
	@Test(enabled = false)
	public void test03_SeTestTCAccountListViewSearch() throws Exception {
		String methodID = "test03_SeTestTCAccountListViewSearch";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		
		System.out.println(STARTLINE);
		
		//Step: search for an existing Account record
		commNav.entityListViewSearch("Accounts", "Abbott Ltd.");
		//commNav.entityListViewSearch("Accounts", "Non-Existent Account");		//debug test
		
		System.out.println(ENDLINE);
	}
	
	
	@Test(enabled = false)
	public void test04_SeTestTCAccountListViewNegativeSearch() throws Exception {
		String methodID = "test04_SeTestTCAccountListViewNegativeSearch";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		System.out.println(STARTLINE);
		
		//Step: search for non-existent Account record to confirm it's non-existence
		commNav.entityListViewNegativeSearch("Accounts", "Non-Existent Account");		
		
		System.out.println(ENDLINE);
	}

	
	@Test(enabled = false)
	public void test05_SeTestTCAccountListViewClearSearch() throws Exception {
		String methodID = "test05_SeTestTCAccountListViewClearSearch";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);	

		System.out.println(STARTLINE);

		commNav.entityListViewSearch("Accounts", "Big Systems");
			
		//Step: check for matching results...
		AccountViewsElements accountListView = PageFactory.initElements(driver, AccountViewsElements.class);
		String topAccountListItemName = accountListView.topAccountsListItemName.getText();
				
		//Step: click the clear Search input field button
		accountListView.accountsSearchClearBtn.click();
				
		//Step: click the Lookup button to reload the full Accounts list
		accountListView.accountsSearchLookupBtn.click();
		Thread.sleep(3000);
				
		//Step: check if the previous search results were cleared
		String currTopAccountsListViewName = driver.findElement(By.xpath("//*[@id='account_list']/ul/li[1]/div/h3")).getText();
		try {
			AssertJUnit.assertEquals(topAccountListItemName, currTopAccountsListViewName);
		} catch (Error e) {
			verificationErrors.append(e.toString());
			System.out.println(methodID + ": clear previous Accounts search results action failed");
			return;
		}
		
		System.out.println(methodID + ": clear previous Accounts search results action was successful");
		System.out.println(ENDLINE);
	}

	
	@Test(enabled = true)
	public void test06_SeTestTCAccountListViewOpenRecord() throws Exception {
		String methodID = "test06_SeTestTCAccountListViewOpenRecord";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);
		
		System.out.println(STARTLINE);
		
		//Step: search for Account entity, then open it's Detail view
		commNav.entityRecordOpenDetailView("Accounts", "Call Color");
		
		//Step: go back to previous screen
		headerButton.goBack();
		Thread.sleep(3000);
		
		System.out.println(ENDLINE);
	}
	
	@Test(enabled = false)
	public void test07_SeTestTCAccountDetailView() throws Exception {
		String methodID = "test07_SeTestTCAccountDetailView";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);
		
		//Test Parameters:
		String accountRecord = "Call Color";
		
		System.out.println(STARTLINE);
		
		//Step: search for Account entity, then open it's Detail view
		if (commNav.entityRecordOpenDetailView("Accounts", accountRecord)) {
			
			AccountViewsElements accountDetailView = PageFactory.initElements(driver, AccountViewsElements.class);
			
			//Step: check each item under the Account Detail View, Quick Actions section
			commNav.isWebElementPresent("Account Detail view, 'Quick Actions' section header", accountDetailView.accountDetailViewQuickActionsHdr);
			commNav.isWebElementPresent("Account Detail view, 'Call main number'", accountDetailView.accountDetailViewCallMainNumberLnk);			
			verifyAccountDetailViewLink("Account Detail view, 'Schedule activity'", accountDetailView.accountDetailViewScheduleActivityLnk, "Schedule...");
			verifyAccountDetailViewLink("Account Detail view, 'Add note'", accountDetailView.accountDetailViewScheduleActivityLnk, "Note");
			commNav.isWebElementPresent("Account Detail view, 'View address'", accountDetailView.accountDetailViewViewAddressLnk);
			
			//Step: check each item under the Account Detail View, Details section
			commNav.isWebElementPresent("Account Detail view, 'Details' section header", accountDetailView.accountDetailViewDetailsHdr);
			commNav.isWebElementPresent("Account Detail view, 'account'", accountDetailView.accountDetailViewAccountFld);
			commNav.isWebElementPresent("Account Detail view, 'web'", accountDetailView.accountDetailViewWebFld);
			commNav.isWebElementPresent("Account Detail view, 'fax'", accountDetailView.accountDetailViewFaxFld);
			commNav.isWebElementPresent("Account Detail view, 'type'", accountDetailView.accountDetailViewTypeFld);
			commNav.isWebElementPresent("Account Detail view, 'subtype'", accountDetailView.accountDetailViewSubTypeFld);
			commNav.isWebElementPresent("Account Detail view, 'status'", accountDetailView.accountDetailViewStatusFld);

			//Step: check each item under the Account Detail View, More Details section
			commNav.isWebElementPresent("Account Detail view, 'More Details' section header", accountDetailView.accountDetailViewMoreDetailsHdr);
			//SubStep: conditionally expand the More Details section
			if (accountDetailView.accountDetailViewMoreDetailsFields.getSize().height < 1) {
				accountDetailView.accountDetailViewMoreDetailsHdr.click();
				Thread.sleep(1000);
			}
			commNav.isWebElementPresent("Account Detail view, 'industry'", accountDetailView.accountDetailViewIndustryFld);
			commNav.isWebElementPresent("Account Detail view, 'bus desc'", accountDetailView.accountDetailViewBusDescFld);
			commNav.isWebElementPresent("Account Detail view, 'acct mgr'", accountDetailView.accountDetailViewAcctMgrFld);
			commNav.isWebElementPresent("Account Detail view, 'owner'", accountDetailView.accountDetailViewOwnerFld);
			commNav.isWebElementPresent("Account Detail view, 'lead source'", accountDetailView.accountDetailViewLeadSourceFld);

			//Step: check each item under the Account Detail View, Related Items section
			commNav.isWebElementPresent("Account Detail view, 'Related Items' section header", accountDetailView.accountDetailViewRelatedItemsHdr);
			verifyAccountDetailViewLink("Account Detail view, 'Activities'", accountDetailView.accountDetailViewActivitiesLnk, "Activities");
			verifyAccountDetailViewLink("Account Detail view, 'Contacts'", accountDetailView.accountDetailViewContactsLnk, "Contacts");
			verifyAccountDetailViewLink("Account Detail view, 'Opportunities'", accountDetailView.accountDetailViewOpportunitiesLnk, "Opportunities");
			verifyAccountDetailViewLink("Account Detail view, 'Tickets'", accountDetailView.accountDetailViewTicketsLnk, "Tickets");
			verifyAccountDetailViewLink("Account Detail view, 'Notes/History'", accountDetailView.accountDetailViewNotesHistoryLnk, "Notes/History");
			verifyAccountDetailViewLink("Account Detail view, 'Addresses'", accountDetailView.accountDetailViewAddressesLnk, "Addresses");
			verifyAccountDetailViewLink("Account Detail view, 'Attachments'", accountDetailView.accountDetailViewAttachmentsLnk, "Attachments");
		}
		else {
			System.out.println(methodID + ": the Account Detail view for the '" + accountRecord + "' Account record; test aborted.");
		}
				
		//Step: go back to previous screen
		headerButton.goBack();
		commNav.waitForPage("Accounts");
		
		System.out.println(ENDLINE);
	}

	@Test(enabled = false)
	public void test97_SeTestDEBUG() throws Exception {
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		commNav.entityRecordOpenDetailView("Accounts", "Abbott Ltd.");
	}
	
	@Test(enabled = false)
	public void test98_SeTestTCAttachAccountScreens() throws Exception {
	    // SETest-Attachments_Account_Screens
	    // Version: 2.2
	    // Desc: Confirms that the Attachments feature is functional from Account screens...
	    // Condition(s): Test user is logged in.    
	    // Required Entities: Account - Abbott Ltd.
	    // ==================================================================
		String methodID = "test01_SeTestTCAttachAccountScreens";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerbutton = PageFactory.initElements(driver, HeaderButton.class);
		
		// Test Params:
		String entityType = "accounts";
		String entityRecordName = "Abbott Ltd.";

		System.out.println(STARTLINE);
	    // Step: click Top-Left button to reveal Global Menu...
		headerbutton.showGlobalMenu();
	
	    // Step: navigate to Accounts list view...
		commNav.clickGlobalMenuItem(entityType);
	
	    // Step: perform search for Account items...
		commNav.searchListView(entityType, entityRecordName);
	
	    // Step: navigate to top Account record...
	    commNav.clickListViewItemN(entityType, 1);
	    commNav.waitForPage(entityRecordName);
	
		//TODO: Left-off routine refactoring here (6/13/13)
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
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if ("Account Attachments".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // Step: click to open an Attachment item...
	    try {
	      assertTrue(isElementPresent(By.xpath(".//*[@id='account_attachment_related']/ul/li[1]")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    
	    // Step: search for a specific attachment item
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_SearchWidget_36']/div/div[1]/input")).clear();
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_SearchWidget_36']/div/div[1]/input")).sendKeys("Test123");
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_SearchWidget_36']/div/div[3]/button")).click();
	    Thread.sleep(5000);
	    try {
		      assertTrue(isElementPresent(By.linkText("Test123")));
		    } catch (Error e) {
		      verificationErrors.append(e.toString());
		    }
	    driver.findElement(By.linkText("Test123")).click();
	    
	    // Step: click the top Add buton...
	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[2]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
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
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if ("Account Attachments".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if ("Abbott Ltd.".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
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

	
	//Login & Logout
	//==============
	@Test
	public void test00_Mobile_Login() throws InterruptedException {
		String methodID = "test00_Mobile_Login";
		
		SLXMobileLogin slxmobilelogin = PageFactory.initElements(driver, SLXMobileLogin.class);	
		
		System.out.println(STARTLINE);	
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
		try { assertEquals("My Activities", driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText());
			assertTrue(driver.findElement(By.xpath(".//*[@id='myactivity_list']/ul/li[1]")).isDisplayed());
			System.out.println("VP: Successfully logged in to Mobile Client.");
		} catch (Error e) {
			closeAlert();
			System.out.println("Error: Unable to login to Mobile Client.");
			System.out.println(e.toString());
		}
		System.out.println(ENDLINE);	
	}

	//MARKER		
	// *******
	@Test
	public void test99_Mobile_LogOut()  throws InterruptedException {				
		String methodID = "test99_Mobile_LogOut";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerbutton = PageFactory.initElements(driver, HeaderButton.class);
		
		System.out.println(STARTLINE);
		// Click the Top-Left, Global Menu button...
		headerbutton.showGlobalMenu();
	
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
	
	//Custom Test Methods:
	//===================
	protected boolean verifyAccountDetailViewLink(String elementDesc, WebElement wElement, String pageTitle) throws InterruptedException {
		String methodID = "verifyAccountDetailViewLink";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);
		
		try { commNav.clickWebElementToPage(elementDesc, wElement, pageTitle);
			headerButton.goBack();
			return true;
		} catch (Error e) {
			System.out.println(e.toString());
			return false;
		}
		
	}

}
