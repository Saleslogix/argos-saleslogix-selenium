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


/**
 * Test class that defines test methods for the Account entity views on the Mobile Client.
 * *
 * @author mike.llena@swiftpage.com
 * @version	1.0
 */
public class AccountEntityViewsTest extends BrowserSetup {
	
	//Test Methods Set
	//================
	@Test(enabled = true)
	public void test01_SeTestTCAccountListView() throws Exception {
		//Reference: MBL-10069
		String methodID = "test01_SeTestTCAccountListView";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerbutton = PageFactory.initElements(driver, HeaderButton.class);
		
		// Test Params:
		String entityType = "Accounts";
		String expEntityPgTitle = "Accounts";
		String entityRecord = "Abbott Ltd.";

		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
	    //Step: click Top-Left button to reveal Global Menu...
		headerbutton.showGlobalMenu();
	
	    //Step: navigate to Accounts list view...
		commNav.entityListViewSearch(entityType, entityRecord);
		
		//Step: test Accounts, List View page elements
		// SubStep: check the Page Title
		if (commNav.isPageDisplayed(entityType)) {
			
			AccountViewsElements accountListView = PageFactory.initElements(driver, AccountViewsElements.class);			
			
			//Step: check the Accounts list view format
			commNav.checkIfWebElementPresent("Accounts List View", accountListView.accountsListView);
			
			//Step: check an Account list view item record
			commNav.checkIfWebElementPresent("Accounts List View, item record", accountListView.topAccountsListItem);
			commNav.checkIfWebElementPresent("Accounts List View, item record Icon", accountListView.topAccountsListItemIcon);
			commNav.checkIfWebElementPresent("Accounts List View, item record Name", accountListView.topAccountsListItemName);
			commNav.checkIfWebElementPresent("Accounts List View, item record Industry", accountListView.topAccountsListItemLine2);
			commNav.checkIfWebElementPresent("Accounts List View, item record Type & Sub-Type", accountListView.topAccountsListItemLine3);
			commNav.checkIfWebElementPresent("Accounts List View, item record Acct. Mgr & Owner", accountListView.topAccountsListItemLine4);
			commNav.checkIfWebElementPresent("Accounts List View, item record Web", accountListView.topAccountsListItemLine5);
			commNav.checkIfWebElementPresent("Accounts List View, item record Phone", accountListView.topAccountsListItemLine6);
			commNav.checkIfWebElementPresent("Accounts List View, item record Fax", accountListView.topAccountsListItemLine7);
			commNav.checkIfWebElementPresent("Accounts List View, item record touch widget", accountListView.topAccountsListItemTouch);
			
			//Step: check the Quick Action button and items
			try {
				//click Quick Action button to reveal Quick Action items
				commNav.checkIfWebElementPresent("Accounts List View, Quick Action button", accountListView.topAccountsListItemQuickActionsBtn);
				accountListView.topAccountsListItemQuickActionsBtn.click();
				
				//click the Quick Action button, then check each of the Quick Action items
				commNav.checkIfWebElementPresent("Account, Quick Action button", accountListView.topAccountsListItemQuickActionsAddAttachmentBtn);
				commNav.checkIfWebElementPresent("Account, Quick Action button", accountListView.topAccountsListItemQuickActionsAddActivityBtn);
				commNav.checkIfWebElementPresent("Account, Quick Action button", accountListView.topAccountsListItemQuickActionsAddNoteBtn);
				commNav.checkIfWebElementPresent("Account, Quick Action button", accountListView.topAccountsListItemQuickActionsContactsBtn);
				commNav.checkIfWebElementPresent("Account, Quick Action button", accountListView.topAccountsListItemQuickActionsCallMainBtn);
				commNav.checkIfWebElementPresent("Account, Quick Action button", accountListView.topAccountsListItemQuickActionsEditBtn);
				commNav.checkIfWebElementPresent("Account, Quick Action button", accountListView.topAccountsListItemQuickActionsEditBtn);
				
				//click Quick Action button to hide the Quick Action items
				accountListView.topAccountsListItemQuickActionsBtn.click();
			}
			catch (Exception e) {
				System.out.println(e.toString());				
			}
			
			//Step: check the "X records remaining" item box at the bottom of the list view
			//commNav.checkIfWebElementPresent("Accounts List View, 'x remaining records' item", accountListView.recordsRemainingListItem);
		}
		else {
			System.out.println(methodID + ": required '" + expEntityPgTitle + "' not loaded; test aborted");
		}
		System.out.println(ENDLINE);
	}

	
	@Test(enabled = true)
	public void test02_SeTestTCAccountListViewLoadMoreResults() throws Exception {
		String methodID = "test02_SeTestTCAccountListViewLoadMoreResults";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerbutton = PageFactory.initElements(driver, HeaderButton.class);
		
		//Test Params:
		String entityType = "accounts";
	
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
	    //Step: click Top-Left button to reveal Global Menu...
		headerbutton.showGlobalMenu();
	
	    //Step: navigate to Accounts list view...
		commNav.clickGlobalMenuItem(entityType);

		//capture the initial Accounts List view info
		AccountViewsElements accountsListView = PageFactory.initElements(driver, AccountViewsElements.class);
		String initAccountsListInfo = accountsListView.getAccountsListViewTxt();
		
	    //Step: load more results (click on 'x remaining records' item)
		for (int count = 1; count<3; count++) {			
			//driver.findElement(By.xpath("//*[@id='account_list']")).sendKeys(Keys.PAGE_DOWN);
			//Thread.sleep(3000);
			JavascriptExecutor jsx = (JavascriptExecutor)driver;
			jsx.executeScript("window.scrollBy(0,450)", "");
		}
		
		//capture the expanded Accounts List view
		String expandedAccountsListInfo = accountsListView.getAccountsListViewTxt();
		
		//VP: confirm that the Accounts List view is indeed expanded with more record data
		String resultMsg = "VP: scrolling down the Accounts List view loaded more records";
		try {
			AssertJUnit.assertFalse(initAccountsListInfo.matches(expandedAccountsListInfo));
			System.out.println(resultMsg + " - Passed");
		}
		catch (Error e) {
			System.out.println(e.toString());
			System.out.println(resultMsg + " - Failed");
		}
		
		System.out.println(ENDLINE);
	}

	
	@Test(enabled = true)
	public void test03_SeTestTCAccountListViewSearch() throws Exception {
		String methodID = "test03_SeTestTCAccountListViewSearch";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
		
		//Step: search for an existing Account record
		commNav.entityListViewSearch("Accounts", "Abbott Ltd.");
		//commNav.entityListViewSearch("Accounts", "Non-Existent Account");		//debug test
		
		System.out.println(ENDLINE);
	}
	
	
	@Test(enabled = true)
	public void test04_SeTestTCAccountListViewNegativeSearch() throws Exception {
		String methodID = "test04_SeTestTCAccountListViewNegativeSearch";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
		
		//Step: search for non-existent Account record to confirm it's non-existence
		commNav.entityListViewNegativeSearch("Accounts", "Non-Existent Account");		
		
		System.out.println(ENDLINE);
	}

	
	@Test(enabled = true)
	public void test05_SeTestTCAccountListViewClearSearch() throws Exception {
		String methodID = "test05_SeTestTCAccountListViewClearSearch";
		
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
		Thread.sleep(7000);
				
		//Step: check if the previous search results were cleared
		String currTopAccountsListViewName = driver.findElement(By.xpath("//*[@id='account_list']/ul/li[1]/div/h3")).getText();
		accountListView = PageFactory.initElements(driver, AccountViewsElements.class);
		topAccountListItemName = accountListView.topAccountsListItemName.getText();
		try {
			AssertJUnit.assertEquals(topAccountListItemName, currTopAccountsListViewName);
			System.out.println(methodID + ": clear previous Accounts search results action was successful");
		} catch (Error e) {
			verificationErrors.append(e.toString());
			System.out.println(methodID + ": clear previous Accounts search results action failed");
			return;
		}
		
		System.out.println(ENDLINE);
	}
	
	
	@Test(enabled = true)
	public void test06_SeTestTCAccountListViewOpenRecord() throws Exception {
		String methodID = "test06_SeTestTCAccountListViewOpenRecord";
		
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

	
	@Test(enabled = true)
	public void test07_SeTestTCAccountDetailView() throws Exception {
		String methodID = "test07_SeTestTCAccountDetailView";
		
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
	
	
	//TODO: find out why this test mysteriously fails on Jenkins server
	@Test(enabled = true)
	public void test08_SeTestTCAccountEditView() throws Exception {
		String methodID = "test08_SeTestTCAccountEditView";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
		
		//Step: search for Account entity, then open it's Detail view
		String accountName = "Allied Corp.";
		try {
			AssertJUnit.assertTrue(commNav.entityRecordEditView("Account", accountName));
			
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
	
	
	@Test(enabled = true)
	public void test09_SeTestTCAccountAddEditView() throws Exception {
		String methodID = "test09_SeTestTCAccountAddEditView";
		
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
	
	
	@Test(enabled = true)
	public void test10_SeTestTCAccountListViewHashTags() throws Exception {
		String methodID = "test10_SeTestTCAccountListViewHashTags";
		
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

	@Test(enabled = true)
	public void test11_SeTestTCAccountListViewKPI() throws Exception {
		String methodID = "test11_SeTestTCAccountListViewKPI";
		
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
		
		//Step: re-enabled each of the KPI items		
		commNav.rightClickContextMenuItem("Total Revenue");
		//TODO: see why this next step fails on Jenkins; disabling for now...
		commNav.scrollDownPage();
		commNav.rightClickContextMenuItem("Avg Time as Customer");
		commNav.scrollDownPage();
		commNav.rightClickContextMenuItem("Total Accounts");
		headerButton.closeRightContextMenu();
		Thread.sleep(500);
		
		//Step: go back to previous screen
		headerButton.goBack();
		Thread.sleep(5000);
		
		System.out.println(ENDLINE);
	}
	
	//TODO: need to update the Account Edit field selector ids' in AccountViewsElements.java
	@Test(enabled = true)
	public void test12_SeTestTCAccountListViewAddAccount() throws Exception {
		String methodID = "test12_SeTestTCAccountListViewAddAccount";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		//HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
		
		//Step: login & log back in (to clear cookies)
		LogOutThenLogBackIn(userName, userPwd);
		
		//Step: add a random test Account record
		String newAcctName = "SeAutoTestAcct-" + new SimpleDateFormat("yyMMddHHmm").format(new GregorianCalendar().getTime());
		AccountViewsElements accountsListView = PageFactory.initElements(driver, AccountViewsElements.class);
		accountsListView.doAddRandTestAccount(newAcctName);
		
		//Step: find the newly-added test Account record
		String strResultsMsg = "VP: recently added test Account '" + newAcctName + "' was found.";
		if (accountsListView.doSearchAccount(newAcctName)) {
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
	public void test13_SeTestTCAccountListViewNotesBox() throws Exception {
		//Reference: MBL-10042
		String methodID = "test13_SeTestTCAccountListViewNotesBox";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);
		
		// Test Params:
		String entityType = "Accounts";
		String expEntityPgTitle = "Accounts";
		String entityRecord = "Abbott Ltd.";
	
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
	
	    //Step: navigate to Accounts list view...
		commNav.entityListViewSearch(entityType, entityRecord);
		
		//Step: test Accounts, List View page elements
		// SubStep: check the Page Title
		if (commNav.isPageDisplayed(entityType)) {
			
			AccountViewsElements accountListView = PageFactory.initElements(driver, AccountViewsElements.class);			
			
			//Step: check the Accounts list view format
			commNav.checkIfWebElementPresent("Accounts List View", accountListView.accountsListView);
			
			//Step: check an Account list view item record
			commNav.checkIfWebElementPresent("Accounts List View, Notes Box", accountListView.accountsListViewNotesBox1stItem);			
			commNav.checkIfWebElementPresent("Accounts List View, Notes Box item, Initials box", accountListView.accountsListViewNotesBox1stItemInitialsBox);			
			commNav.checkIfWebElementPresent("Accounts List View, Notes Box item, Regarding header", accountListView.accountsListViewNotesBox1stItemRegarding);			
			commNav.checkIfWebElementPresent("Accounts List View, Notes Box item, Last Activity note", accountListView.accountsListViewNotesBox1stItemLastActivity);			
			commNav.checkIfWebElementPresent("Accounts List View, Notes Box item, note item", accountListView.accountsListViewNotesBox1stItemNotes);			
			commNav.checkIfWebElementPresent("Accounts List View, Notes Box item, see list link", accountListView.accountsListViewNotesBoxSeeListLink);
			
			//Step: check the Notes Box list item click navigation
			String expPgTitle = "Meeting";
			String resultsMsg = "VP: Clicking Notes Box item navigated to the expected page";
			try {
				//click the 1st Notes Box item
				accountListView.accountsListViewNotesBox1stItem.click();
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
			
			accountListView = PageFactory.initElements(driver, AccountViewsElements.class);
			
			//Step: check the Notes Box 'see list' link click navigation
			expPgTitle = "Notes";
			resultsMsg = "VP: Clicking Notes Box 'see list' link navigated to the expected page";
			try {
				//click the Notes Box 'see list' link
				accountListView.accountsListViewNotesBoxSeeListLink.click();
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
