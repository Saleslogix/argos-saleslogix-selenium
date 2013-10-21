package argos.saleslogix.selenium.test;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ContactEntityViewsTest extends BrowserSetup {
	
	//Login & Logout
	//==============
	@Test(enabled = true)
	public void test00_MobileClient_Login() throws InterruptedException {
		String methodID = "test00_MobileClient_Login";
		
		SLXMobileLogin slxmobilelogin = PageFactory.initElements(driver, SLXMobileLogin.class);	
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
		
		//VP: the Mobile Login screen is loaded from base URL
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		commNav.waitForPage(fullProdName);
		
		//VP: Page Title (header text - not pagetitle property)
		Thread.sleep(1000);
		try { 
			AssertJUnit.assertEquals(shortProdName, driver.getTitle());
			System.out.println("VP: Login Screen Title check - Passed");
		} 
		catch (Error e) {
			System.out.println("Error: Login Screen Title check - FAILED");
			verificationErrors.append(e.toString());
		}
		
		//VP: Login Page Name
		Thread.sleep(1000);	
		try {
			AssertJUnit.assertTrue(commNav.isPageDisplayed(fullProdName));
			System.out.println("VP: Login Page Name check - Passed");
		} 
		catch (Error e) {
			System.out.println("Error: Login Page Name check - FAILED");
			verificationErrors.append(e.toString());
		}
		
		//VP: product logo
		try {
			AssertJUnit.assertTrue(commNav.isElementDisplayed(By.xpath(".//*[@id='login']/p/img")));
			System.out.println("VP: 'saleslog!x' logo check  - Passed");
		}
		catch (Error e) {
			System.out.println("Error: product logo check - FAILED");
			verificationErrors.append(e.toString());
		}		
		
		//VP: Copyright Info
		try {
			AssertJUnit.assertEquals(copyrightLabel, driver.findElement(By.xpath(".//*[@id='login']/span[1]")).getText());
			System.out.println("VP: Copyright check - Passed");
		} 
		catch (Error e) {
			System.out.println("Error: Copyright check - FAILED");
			verificationErrors.append(e.toString());
		}
		try {
			AssertJUnit.assertEquals(versionLabel, driver.findElement(By.xpath(".//*[@id='login']/span[2]")).getText());
			System.out.println("VP: Version Label check - Passed");
		} 
		catch (Error e) {
			System.out.println("Error: Version Label check - FAILED");
			verificationErrors.append(e.toString());
		}
		
		// Step: Enter username and password then click the logon button		
		slxmobilelogin.doLogin(userName, userPwd, true);
		
		// VP: confirm that the 'My Activities' screen displays after login
		Thread.sleep(3000);
		try {
			AssertJUnit.assertTrue(driver.findElement(By.xpath(".//*[@id='myactivity_list']")).isDisplayed());
			System.out.println("VP: Successfully logged in to Mobile Client.");
		} catch (UnhandledAlertException e) {
			//closeAlert();
			closeModal();
			//assertEquals("The user name or password is invalid.", closeAlertAndGetItsText());
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



	//Test Methods Set
	//================
	@Test(enabled = true)
	public void test01_SeTestTCContactListView() throws Exception {
		String methodID = "test01_SeTestTCContactListView";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerbutton = PageFactory.initElements(driver, HeaderButton.class);
		
		// Test Params:
		String entityType = "Contacts";
		String entityRecord = "Adi";
	
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
		
	    //Step: click Top-Left button to reveal Global Menu...
		headerbutton.showGlobalMenu();
	
	    //Step: navigate to Contacts list view...
		commNav.entityListViewSearchContains(entityType, entityRecord);
		
		//Step: test Contacts, List View page elements
		// SubStep: check the Page Title
		try {
			AssertJUnit.assertTrue(commNav.isPageDisplayed(entityType));
			
			ContactViewsElements contactsListView = PageFactory.initElements(driver, ContactViewsElements.class);
						
			//Step: check the Contacts list view format
			commNav.checkIfWebElementPresent("Contacts List View", contactsListView.contactsListView);
			
			//Step: check elements of a Contacts list view item record
			commNav.checkIfWebElementPresent("Contacts List View, item record", contactsListView.topContactsListItem);
			commNav.checkIfWebElementPresent("Contacts List View, item record icon", contactsListView.topContactsListItemIcon);
			commNav.checkIfWebElementPresent("Contacts List View, item record name", contactsListView.topContactsListItemName);
			commNav.checkIfWebElementPresent("Contacts List View, item record title & Account name", contactsListView.topContactsListItemLine2);
			commNav.checkIfWebElementPresent("Contacts List View, item record Work Phone", contactsListView.topContactsListItemLine3);
			commNav.checkIfWebElementPresent("Contacts List View, item record Mobile Phone", contactsListView.topContactsListItemLine4);
			commNav.checkIfWebElementPresent("Contacts List View, item record Email", contactsListView.topContactsListItemLine5);
			commNav.checkIfWebElementPresent("Contacts List View, item record touch widget", contactsListView.topContactsListItemTouch);
			
			//Step: check the Quick Action button and items
			try {
				//click Quick Action button to reveal Quick Action items
				commNav.checkIfWebElementPresent("Contacts List View, Quick Action button", contactsListView.topContactsListItemQuickActionsBtn);
				contactsListView.topContactsListItemQuickActionsBtn.click();
				
				//click the Quick Action button, then check each of the Quick Action items
				commNav.checkIfWebElementPresent("Contact, Quick Action button", contactsListView.topContactsListItemQuickActionsAddAttachmentBtn);
				commNav.checkIfWebElementPresent("Contact, Quick Action button", contactsListView.topContactsListItemQuickActionsAddActivityBtn);
				commNav.checkIfWebElementPresent("Contact, Quick Action button", contactsListView.topContactsListItemQuickActionsAddNoteBtn);
				commNav.checkIfWebElementPresent("Contact, Quick Action button", contactsListView.topContactsListItemQuickActionsEmailBtn);
				commNav.checkIfWebElementPresent("Contact, Quick Action button", contactsListView.topContactsListItemQuickActionsAccountBtn);
				commNav.checkIfWebElementPresent("Contact, Quick Action button", contactsListView.topContactsListItemQuickActionsCallMobileBtn);
				commNav.checkIfWebElementPresent("Contact, Quick Action button", contactsListView.topContactsListItemQuickActionsCallWorkBtn);
				commNav.checkIfWebElementPresent("Contact, Quick Action button", contactsListView.topContactsListItemQuickActionsEditBtn);
				
				//click Quick Action button to hide the Quick Action items
				contactsListView.topContactsListItemQuickActionsBtn.click();
			}
			catch (Exception e) {
				System.out.println(e.toString());				
			}
				
			//Step: check the "X records remaining" item box at the bottom of the list view
			//commNav.checkIfWebElementPresent("Contacts List View, 'x remaining records' item", contactsListView.recordsRemainingListItem);
		}
		catch (Error e){
			System.out.println(e.toString());
			System.out.println(methodID + ": required '" + entityType + "' not loaded; test aborted");
		}
		System.out.println(ENDLINE);
	}

	//TODO: complete test02_SeTestTCContactListViewLoadMoreResults for Contacts
	@Test(enabled = true)
	public void test02_SeTestTCContactListViewLoadMoreResults() throws Exception {
		String methodID = "test02_SeTestTCContactListViewLoadMoreResults";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerbutton = PageFactory.initElements(driver, HeaderButton.class);
		
		//Test Params:
		String entityType = "contacts";
	
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
		
	    //Step: click Top-Left button to reveal Global Menu...
		headerbutton.showGlobalMenu();
	
	    //Step: navigate to Contacts list view...
		commNav.clickGlobalMenuItem(entityType);
	
		//capture the initial Contacts List view info
		ContactViewsElements contactsListView = PageFactory.initElements(driver, ContactViewsElements.class);
		String initListInfo = contactsListView.getContactsListViewTxt();
		
	    //Step: load more results (click on 'x remaining records' item)
		for (int count = 1; count<3; count++) {			
			//driver.findElement(By.xpath("//*[@id='account_list']")).sendKeys(Keys.PAGE_DOWN);
			//Thread.sleep(3000);
			JavascriptExecutor jsx = (JavascriptExecutor)driver;
			jsx.executeScript("window.scrollBy(0,450)", "");
		}
		
		//capture the expanded Contacts List view
		String expandedListInfo = contactsListView.getContactsListViewTxt();
		
		//VP: confirm that the Contacts List view is indeed expanded with more record data
		String resultMsg = "VP: scrolling down the Accounts List view loaded more records";
		try {
			AssertJUnit.assertFalse(initListInfo.matches(expandedListInfo));
			System.out.println(resultMsg + " - Passed");
		}
		catch (Error e) {
			System.out.println(e.toString());
			System.out.println(resultMsg + " - Failed");
		}
		
		System.out.println(ENDLINE);
	}

	//TODO: complete test03_SeTestTCContactListViewSearch for Contacts
	@Test(enabled = false)
	public void test03_SeTestTCContactListViewSearch() throws Exception {
		String methodID = "test03_SeTestTCContactListViewSearch";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
		
		//Step: search for an existing Account record
		commNav.entityListViewSearch("Accounts", "Abbott Ltd.");
		//commNav.entityListViewSearch("Accounts", "Non-Existent Account");		//debug test
		
		System.out.println(ENDLINE);
	}

	//TODO: complete test04_SeTestTCContactListViewNegativeSearch for Contacts
	@Test(enabled = false)
	public void test04_SeTestTCContactListViewNegativeSearch() throws Exception {
		String methodID = "test04_SeTestTCContactListViewNegativeSearch";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
		
		//Step: search for non-existent Account record to confirm it's non-existence
		commNav.entityListViewNegativeSearch("Accounts", "Non-Existent Account");		
		
		System.out.println(ENDLINE);
	}

	//TODO: complete test05_SeTestTCContactListViewClearSearch for Contacts
	@Test(enabled = false)
	public void test05_SeTestTCContactListViewClearSearch() throws Exception {
		String methodID = "test05_SeTestTCContactListViewClearSearch";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);
	
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
	
		commNav.entityListViewSearch("Accounts", "Big Systems");
			
		//Step: check for matching results...
		AccountViewsElements accountListView = PageFactory.initElements(driver, AccountViewsElements.class);
		String topAccountListItemName = accountListView.topAccountsListItemName.getText();
				
		//Step: click the clear Search input field button
		headerButton.showRightContextMenu();
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


	//TODO: complete test06_SeTestTCContactListViewOpenRecord for Contacts
	@Test(enabled = false)
	public void test06_SeTestTCContactListViewOpenRecord() throws Exception {
		String methodID = "test06_SeTestTCContactListViewOpenRecord";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
		
		//Step: search for Account entity, then open it's Detail view
		commNav.entityRecordOpenDetailView("Accounts", "Call Color");
		
		//Step: go back to previous screen
		headerButton.goBack();
		Thread.sleep(3000);
		
		System.out.println(ENDLINE);
	}

	//TODO: complete test07_SeTestTCContactDetailView for Contacts
	@Test(enabled = false)
	public void test07_SeTestTCContactDetailView() throws Exception {
		String methodID = "test07_SeTestTCContactDetailView";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);
		
		//Test Parameters:
		String accountRecord = "Call Color";
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
		
		//Step: search for Account entity, then open it's Detail view
		if (commNav.entityRecordOpenDetailView("Accounts", accountRecord)) {
			
			AccountViewsElements accountDetailView = PageFactory.initElements(driver, AccountViewsElements.class);
			
			//Step: check each item under the Account Detail View, Quick Actions section
			commNav.isWebElementPresent("Account Detail view, 'Quick Actions' section header", accountDetailView.accountDetailViewQuickActionsHdr);
			commNav.isWebElementPresent("Account Detail view, 'Call main number'", accountDetailView.accountDetailViewCallMainNumberLnk);			
			commNav.verifyEntityViewElementClick("Account Detail view, 'Schedule activity'", accountDetailView.accountDetailViewScheduleActivityLnk, "Schedule...");
			commNav.isWebElementPresent("Account Detail view, 'Add note'", accountDetailView.accountDetailViewAddNoteLnk);
			//TODO: figure out why there is a failure for this step; reverting to 
			//commNav.verifyEntityViewElementClick("Account Detail view, 'Add note'", accountDetailView.accountDetailViewAddNoteLnk, "Note");
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
			commNav.verifyEntityViewElementClick("Account Detail view, 'Activities'", accountDetailView.accountDetailViewActivitiesLnk, "Activities");
			commNav.verifyEntityViewElementClick("Account Detail view, 'Contacts'", accountDetailView.accountDetailViewContactsLnk, "Contacts");
			commNav.verifyEntityViewElementClick("Account Detail view, 'Opportunities'", accountDetailView.accountDetailViewOpportunitiesLnk, "Opportunities");
			commNav.verifyEntityViewElementClick("Account Detail view, 'Tickets'", accountDetailView.accountDetailViewTicketsLnk, "Tickets");
			commNav.verifyEntityViewElementClick("Account Detail view, 'Notes/History'", accountDetailView.accountDetailViewNotesHistoryLnk, "Notes/History");
			commNav.verifyEntityViewElementClick("Account Detail view, 'Addresses'", accountDetailView.accountDetailViewAddressesLnk, "Addresses");
			commNav.verifyEntityViewElementClick("Account Detail view, 'Attachments'", accountDetailView.accountDetailViewAttachmentsLnk, "Attachments");
		}
		else {
			System.out.println(methodID + ": the Account Detail view for the '" + accountRecord + "' Account record; test aborted.");
		}
				
		//Step: go back to previous screen
		headerButton.goBack();
		commNav.waitForPage("Accounts");
		
		System.out.println(ENDLINE);
	}

	//TODO: complete test08_SeTestTCContactEditView for Contacts
	@Test(enabled = false)
	public void test08_SeTestTCContactEditView() throws Exception {
		String methodID = "test08_SeTestTCContactEditView";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
		
		//Step: search for Account entity, then open it's Detail view
		try {
			AssertJUnit.assertTrue(commNav.entityRecordEditView("Account", "Initech"));
			
			//Step: check each input field and if applicable, its related list item selection view
			//TODO: complete this section by adding calls to verify each field and selection view (if applicable)
			
			//end of test
			headerButton.clickHeaderButton("cancel");
		
			//Step: go back to previous screen
			headerButton.goBack();
			Thread.sleep(2000);
		}
		finally {
			
		}
		
		System.out.println(ENDLINE);
	}

	//TODO: complete test09_SeTestTCContactAddEditView for Contacts
	@Test(enabled = false)
	public void test09_SeTestTCContactAddEditView() throws Exception {
		String methodID = "test09_SeTestTCContactAddEditView";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);	
		
		// Test Params:
		String entityType = "account";
	
		//Step: enter the Account Add Edit view...
		commNav.entityRecordAdd(entityType);
				
		//Step: go back to previous screens
		headerButton.clickHeaderButton("cancel");
		headerButton.goBack();
		Thread.sleep(2000);
		
		System.out.println(ENDLINE);
	}

	//TODO: complete test10_SeTestTCContactListViewHashTags for Contacts
	@Test(enabled = false)
	public void test10_SeTestTCContactListViewHashTags() throws Exception {
		String methodID = "test10_SeTestTCContactListViewHashTags";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);
		
		// Test Params:
		String entityType = "accounts";
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
		
	    //Step: navigate to Accounts list view...
		commNav.clickGlobalMenuItem(entityType);
		
		AccountViewsElements accountsListView = PageFactory.initElements(driver, AccountViewsElements.class);
		
		//Step: reveal Right Context Menu panel
		headerButton.showRightContextMenu();
		
	    //Step: test the Hash Tags header
		//expand the Hash Tags sub-panel if it's currently collapsed
		if (!accountsListView.accountHashTagsPnl.isDisplayed()) {
			accountsListView.accountHashTagsHdr.click();
			
			//confirm the the panel was indeed expanded
			try {
				AssertJUnit.assertTrue(accountsListView.accountHashTagsPnl.isDisplayed());
			}
			catch (Error e) {
				System.out.println(e.toString());
				System.out.println(methodID + ": Hash Tags panel failed to expand on panel header click; test aborted.");
				return;
			}
		}
		//collapase the Hash Tags sub-panel
		accountsListView.accountHashTagsHdr.click();
		try {
			AssertJUnit.assertFalse(accountsListView.accountHashTagsPnl.isDisplayed());
			System.out.println("VP: Hash Tags sub-panel collapse check - Passed");
			
			//re-expand the Hash Tags sub-panel
			accountsListView.accountHashTagsHdr.click();
			try {
				AssertJUnit.assertTrue(accountsListView.accountHashTagsPnl.isDisplayed());
				System.out.println("VP: Hash Tags sub-panel expand check - Passed");
			}
			catch (Error e) {
				System.out.println(e.toString());
				System.out.println("VP: Hash Tags sub-panel expand check - FAILED");
			}
		}
		catch (Error e) {
			System.out.println(e.toString());
			System.out.println("VP: Hash Tags sub-panel collapse check - FAILED");
		}
		
		//Step: test each of the pre-set Hash Tag items
		commNav.rightClickContextMenuItem("active");
		commNav.rightClickContextMenuItem("inactive");
		commNav.rightClickContextMenuItem("suspect");
		commNav.rightClickContextMenuItem("lead");
		commNav.rightClickContextMenuItem("prospect");
		commNav.rightClickContextMenuItem("customer");
		commNav.rightClickContextMenuItem("partner");
		commNav.rightClickContextMenuItem("vendor");
		commNav.rightClickContextMenuItem("influencer");
		commNav.rightClickContextMenuItem("competitor");
		
		//Step: go back to previous screen
		headerButton.goBack();
		Thread.sleep(3000);
		
		System.out.println(ENDLINE);
	}


	
	//TODO: complete test11_SeTestTCContactListViewKPI for Contacts
	@Test(enabled = false)
	public void test11_SeTestTCContactListViewKPI() throws Exception {
		String methodID = "test11_SeTestTCContactListViewKPI";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);
		
		// Test Params:
		String entityType = "contacts";
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
		
	    //Step: navigate to Contacts list view...
		commNav.clickGlobalMenuItem(entityType);
		
		AccountViewsElements accountsListView = PageFactory.initElements(driver, AccountViewsElements.class);
		
		//Step: reveal Right Context Menu panel
		headerButton.showRightContextMenu();
		
	    //Step: test the KPI header
		//expand the KPI sub-panel if it's currently collapsed
		if (!accountsListView.accountKPIPnl.isDisplayed()) {
			accountsListView.accountKPIHdr.click();
			
			//confirm the the panel was indeed expanded
			try {
				AssertJUnit.assertTrue(accountsListView.accountHashTagsPnl.isDisplayed());
			}
			catch (Error e) {
				System.out.println(e.toString());
				System.out.println(methodID + ": Hash Tags panel failed to expand on panel header click; test aborted.");
				return;
			}
		}
		//collapse Hash Tags sub-panel check
		accountsListView.accountKPIHdr.click();
		try {
			AssertJUnit.assertFalse(accountsListView.accountKPIPnl.isDisplayed());
			System.out.println("VP: KPI sub-panel collapse check - Passed");
			
			//re-expand the Hash Tags sub-panel
			accountsListView.accountKPIHdr.click();
			try {
				AssertJUnit.assertTrue(accountsListView.accountKPIPnl.isDisplayed());
				System.out.println("VP: KPI sub-panel expand check - Passed");
			}
			catch (Error e) {
				System.out.println(e.toString());
				System.out.println("VP: KPI sub-panel e check - FAILED");
			}
		}
		catch (Error e) {
			System.out.println(e.toString());
			System.out.println("VP: KPI sub-panel collapse check - FAILED");
		}
		
		//Step: test each of the pre-set KPI items		
		commNav.scrollDownPage();
		commNav.rightClickContextMenuItem("Total Contacts");
		
		//Step: go back to previous screen
		headerButton.closeRightContextMenu();
		headerButton.goBack();
		Thread.sleep(3000);
		
		System.out.println(ENDLINE);
	}
	
	//TODO: need to update the Contact Edit field selector ids' in ContactViewsElements.java
	@Test(enabled = false)
	public void test12_SeTestTCContactListViewAddContact() throws Exception {
		String methodID = "test12_SeTestTCContactListViewAddContact";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		//HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
		
		//Step: login & log back in (to clear cookies)
		LogOutThenLogBackIn(userName, userPwd);
				
		ContactViewsElements contactsListView = PageFactory.initElements(driver, ContactViewsElements.class);
		
		//Step: add a random test Contact record
		String newConLastName = "Andersen-" + new SimpleDateFormat("yyMMddHHmm").format(new GregorianCalendar().getTime());
		contactsListView.doAddRandTestContact(newConLastName, "Thomas", "AECOM");
		
		//Step: find the newly-added test Contact record
		String strResultsMsg = "VP: recently added test Contact '" + newConLastName + "' was found.";
		if (contactsListView.doSearchContact(newConLastName)) {
			System.out.println(strResultsMsg + " - Passed");
		}
		else {
			System.out.println(strResultsMsg + " - FAILED");
		}
		
		//Step: go back to My Activities view
		commNav.clickGlobalMenuItem("My Activities");
		
		System.out.println(ENDLINE);
	}


	@Test(enabled = true)
	public void test13_SeTestTCContactListViewNotesBox() throws Exception {
		//Reference: MBL-10042
		String methodID = "test13_SeTestTCContactListViewNotesBox";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);
		
		// Test Params:
		String entityType = "Contacts";
		String expEntityPgTitle = "Contacts";
		String entityRecord = "Adi";	//Adi, Douglas
	
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
	
	    //Step: navigate to Contacts list view...
		commNav.entityListViewSearch(entityType, entityRecord);
		
		//Step: test Contacts, List View page elements
		// SubStep: check the Page Title
		if (commNav.isPageDisplayed(entityType)) {
			
			ContactViewsElements contactListView = PageFactory.initElements(driver, ContactViewsElements.class);			
			
			//Step: check the Contacts list view format
			commNav.checkIfWebElementPresent("Contacts List View", contactListView.contactsListView);
			
			//Step: check an Account list view item record
			commNav.checkIfWebElementPresent("Contacts List View, Notes Box", contactListView.contactsListViewNotesBox1stItem);			
			commNav.checkIfWebElementPresent("Contacts List View, Notes Box item, Initials box", contactListView.contactsListViewNotesBox1stItemInitialsBox);			
			commNav.checkIfWebElementPresent("Contacts List View, Notes Box item, Regarding header", contactListView.contactsListViewNotesBox1stItemRegarding);			
			commNav.checkIfWebElementPresent("Contacts List View, Notes Box item, Last Activity note", contactListView.contactsListViewNotesBox1stItemLastActivity);			
			commNav.checkIfWebElementPresent("Contacts List View, Notes Box item, note item", contactListView.contactsListViewNotesBox1stItemNotes);			
			commNav.checkIfWebElementPresent("Contacts List View, Notes Box item, see list link", contactListView.contactsListViewNotesBoxSeeListLink);
			
			//Step: check the Notes Box list item click navigation
			String expPgTitle = "Meeting";
			String resultsMsg = "VP: Clicking Notes Box item navigated to the expected page";
			try {
				//click the 1st Notes Box item
				contactListView.contactsListViewNotesBox1stItem.click();
				Thread.sleep(5000);
				commNav.isPageDisplayed(expPgTitle);
				AssertJUnit.assertTrue(driver.findElement(By.xpath("//*[@id='history_detail']")).isDisplayed());
				headerButton.goBack();
				Thread.sleep(2000);
				System.out.println(resultsMsg + " - Passed");
				
			}
			catch (Exception e) {
				System.out.println(e.toString());
				System.out.println(resultsMsg + " - Failed");
			}
			
			contactListView = PageFactory.initElements(driver, ContactViewsElements.class);
			
			//Step: check the Notes Box 'see list' link click navigation
			expPgTitle = "Notes";
			resultsMsg = "VP: Clicking Notes Box 'see list' link navigated to the expected page";
			try {
				//click the Notes Box 'see list' link
				contactListView.contactsListViewNotesBoxSeeListLink.click();
				Thread.sleep(5000);
				commNav.isPageDisplayed(expPgTitle);
				AssertJUnit.assertTrue(driver.findElement(By.xpath("//*[@id='history_related']")).isDisplayed());
				headerButton.goBack();
				Thread.sleep(2000);
				System.out.println(resultsMsg + " - Passed");
				
			}
			catch (Exception e) {
				System.out.println(e.toString());
				System.out.println(resultsMsg + " - Failed");
			}
		}
		else {
			System.out.println(methodID + ": required '" + expEntityPgTitle + "' not loaded; test aborted");
		}
		
		System.out.println(ENDLINE);
	}

}
