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
public class AccountEntityViewsTest extends BaseTest {
	
	public String TEST_ACCOUNT_RECORD = "Abbott Ltd.";
	
	//Test Methods Set
	//================
	@Test(enabled = true)
	public void test01_SeTestTCAccountListView() throws Exception {
		//Reference: MBL-10069
		String methodID = "test01_SeTestTCAccountListView";
		
		// Test Params:
		String entityType = "Accounts";
		String expEntityPgTitle = "Accounts";
		String entityRecord = TEST_ACCOUNT_RECORD;
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerbutton = PageFactory.initElements(driver, HeaderButton.class);

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
				//click list item icon to reveal Quick Action items
				accountListView.topAccountsListItemIcon.click();
				
				//click the Quick Action button, then check each of the Quick Action items
				commNav.checkIfWebElementPresent("Account, Quick Action button", accountListView.topAccountsListItemQuickActionsAddAttachmentBtn);
				commNav.checkIfWebElementPresent("Account, Quick Action button", accountListView.topAccountsListItemQuickActionsAddActivityBtn);
				commNav.checkIfWebElementPresent("Account, Quick Action button", accountListView.topAccountsListItemQuickActionsAddNoteBtn);
				commNav.checkIfWebElementPresent("Account, Quick Action button", accountListView.topAccountsListItemQuickActionsContactsBtn);
				commNav.checkIfWebElementPresent("Account, Quick Action button", accountListView.topAccountsListItemQuickActionsCallMainBtn);
				commNav.checkIfWebElementPresent("Account, Quick Action button", accountListView.topAccountsListItemQuickActionsEditBtn);
				commNav.checkIfWebElementPresent("Account, Quick Action button", accountListView.topAccountsListItemQuickActionsEditBtn);
				
				//click list item icon to hide the Quick Action items
				accountListView.topAccountsListItemIcon.click();
			}
			catch (Exception e) {
				verificationErrors.append(methodID + "(): " + e.toString());				
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
		
		//Test Params:
		String entityType = "accounts";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerbutton = PageFactory.initElements(driver, HeaderButton.class);
        AccountViewsElements accountsListView = PageFactory.initElements(driver, AccountViewsElements.class);
			
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
		
		//Step: login & log back in (to clear cookies)
		LogOutThenLogBackIn(userName, userPwd);

        //Step: click Top-Left button to reveal Global Menu...
        headerbutton.showGlobalMenu();

        //Step: navigate to Accounts list view... wait for page to open
        commNav.clickGlobalMenuItem(entityType);
        commNav.waitForPage("Accounts");

        //Step: Clear search button and search on all records
        accountsListView.accountsSearchClearBtn.click();
        accountsListView.accountsSearchLookupBtn.click();
        Thread.sleep(3000);

        //capture the initial Accounts List view info

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
			System.out.println(resultMsg + " - PASSED");
		}
		catch (Error e) {
			verificationErrors.append(methodID + "(): " + e.toString());
			System.out.println(resultMsg + " - FAILED");
		}
		
		System.out.println(ENDLINE);
	}

	
	@Test(enabled = true)
	public void test03_SeTestTCAccountListViewSearch() throws Exception {
		String methodID = "test03_SeTestTCAccountListViewSearch";
		
		// Test Params:
		String entityType = "Accounts";
		String entityRecord = TEST_ACCOUNT_RECORD;	
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
				
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
		
		//Step: search for an existing Account record
		commNav.entityListViewSearch(entityType, entityRecord);
		
		System.out.println(ENDLINE);
	}
	
	
	@Test(enabled = true)
	public void test04_SeTestTCAccountListViewNegativeSearch() throws Exception {
		String methodID = "test04_SeTestTCAccountListViewNegativeSearch";
		
		//Test Params:
		String entityType = "accounts";
				
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
				
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
		
		//Step: search for non-existent Account record to confirm it's non-existence
		commNav.entityListViewNegativeSearch(entityType, "Non-Existent Account");		
		
		System.out.println(ENDLINE);
	}

	
	@Test(enabled = true)
	public void test05_SeTestTCAccountListViewClearSearch() throws Exception {
		String methodID = "test05_SeTestTCAccountListViewClearSearch";
		
		// Test Params:
		String entityType = "Accounts";
		String entityRecord = TEST_ACCOUNT_RECORD;
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);
        AccountViewsElements accountListView = PageFactory.initElements(driver, AccountViewsElements.class);
	
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
	
		commNav.entityListViewSearch(entityType, entityRecord);
			
		//Step: check for matching results...

        String initAccountsListInfo = accountListView.getAccountsListViewTxt();
				
		//Step: click the clear Search input field button
		headerButton.showRightContextMenu();
		accountListView.accountsSearchClearBtn.click();
				
		//Step: click the Lookup button to reload the full Accounts list
		accountListView.accountsSearchLookupBtn.click();
		Thread.sleep(7000);
				
		//Step: check if the previous search results were cleared
        String expandedAccountsListInfo = accountListView.getAccountsListViewTxt();
		try {
            AssertJUnit.assertFalse(initAccountsListInfo.matches(expandedAccountsListInfo));
			System.out.println(methodID + ": clear previous Accounts search results action PASSED");
		} catch (Error e) {
			verificationErrors.append(methodID + "(): " + e.toString());
			System.out.println(methodID + ": clear previous Accounts search results action FAILED");
		}
		
		System.out.println(ENDLINE);
	}
	
	
	@Test(enabled = true)
	public void test06_SeTestTCAccountListViewOpenRecord() throws Exception {
		String methodID = "test06_SeTestTCAccountListViewOpenRecord";
		
		// Test Params:
		String entityType = "Accounts";
		String entityRecord = TEST_ACCOUNT_RECORD;
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);

        //Step: login & log back in (to clear cookies)
        LogOutThenLogBackIn(userName, userPwd);
		
		try {
			//Step: search for Account entity, then open it's Detail view
			commNav.entityRecordOpenDetailView(entityType, entityRecord);
			
			//Step: go back to previous screen
			headerButton.goBack();
			Thread.sleep(3000);
		}
		catch (Exception e) {
			verificationErrors.append(methodID + "(): " + e.toString());
		}
		
		System.out.println(ENDLINE);
	}

	
	@Test(enabled = true)
	public void test07_SeTestTCAccountDetailView() throws Exception {
		String methodID = "test07_SeTestTCAccountDetailView";
		
		// Test Params:
		String entityType = "Accounts";
		String entityRecord = TEST_ACCOUNT_RECORD;
		String viewName = "Account Detail view";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);
				
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
		
		//Step: login & log back in (to clear cookies)
		LogOutThenLogBackIn(userName, userPwd);
		
		try {
            //Step: search for Account entity, then open it's Detail view
            commNav.entityRecordOpenDetailView(entityType, entityRecord);

            AccountViewsElements accountDetailView = PageFactory.initElements(driver, AccountViewsElements.class);

            //Step: check each item under the Account Detail View, Details section
            commNav.isWebElementPresent(viewName + ",'Details' section header", accountDetailView.accountDetailViewDetailsHdr);
            commNav.isFieldValueEmpty(viewName + ",'account'", accountDetailView.accountDetailViewAccountFld);
            commNav.isFieldValueEmpty(viewName + ",'web'", accountDetailView.accountDetailViewWebFld);
            commNav.isFieldValueEmpty(viewName + ",'phone'", accountDetailView.accountDetailViewCallMainNumberLnk);
            commNav.isFieldValueEmpty(viewName + ",'address'", accountDetailView.accountDetailViewViewAddressLnk);
            commNav.isFieldValueEmpty(viewName + ",'fax'", accountDetailView.accountDetailViewFaxFld);
            commNav.isFieldValueEmpty(viewName + ",'type'", accountDetailView.accountDetailViewTypeFld);
            commNav.isFieldValueEmpty(viewName + ",'subtype'", accountDetailView.accountDetailViewSubTypeFld);
            commNav.isFieldValueEmpty(viewName + ",'status'", accountDetailView.accountDetailViewStatusFld);
            commNav.isFieldValueEmpty(viewName + ",'industry'", accountDetailView.accountDetailViewIndustryFld);
            commNav.isFieldValueEmpty(viewName + ",'bus desc'", accountDetailView.accountDetailViewBusDescFld);
            commNav.isFieldValueEmpty(viewName + ",'acct mgr'", accountDetailView.accountDetailViewAcctMgrFld);
            commNav.isFieldValueEmpty(viewName + ",'owner'", accountDetailView.accountDetailViewOwnerFld);
            commNav.isFieldValueEmpty(viewName + ",'lead source'", accountDetailView.accountDetailViewLeadSourceFld);

            //Step: check each item under the Account Detail View, Actions section
            commNav.isWebElementPresent(viewName + ",'Actions' section header", accountDetailView.accountDetailViewQuickActionsHdr);
            commNav.verifyEntityViewElementClick(viewName + ",'Schedule activity'", accountDetailView.accountDetailViewScheduleActivityLnk, "Schedule...");
            commNav.verifyEntityViewElementClick(viewName + ",'Add note'", accountDetailView.accountDetailViewAddNoteLnk, "Note");

            //Step: check each item under the Account Detail View, Related Items section
            commNav.isWebElementPresent(viewName + ",'Related Items' section header", accountDetailView.accountDetailViewRelatedItemsHdr);
            commNav.verifyEntityViewElementClick(viewName + ",'Activities'", accountDetailView.accountDetailViewActivitiesLnk, "Activities");
            commNav.verifyEntityViewElementClick(viewName + ",'Contacts'", accountDetailView.accountDetailViewContactsLnk, "Contacts");
            commNav.verifyEntityViewElementClick(viewName + ",'Opportunities'", accountDetailView.accountDetailViewOpportunitiesLnk, "Opportunities");
            commNav.verifyEntityViewElementClick(viewName + ",'Tickets'", accountDetailView.accountDetailViewTicketsLnk, "Tickets");
            commNav.verifyEntityViewElementClick(viewName + ",'Notes/History'", accountDetailView.accountDetailViewNotesHistoryLnk, "Notes/History");
            commNav.verifyEntityViewElementClick(viewName + ",'Addresses'", accountDetailView.accountDetailViewAddressesLnk, "Addresses");
            commNav.verifyEntityViewElementClick(viewName + ",'Attachments'", accountDetailView.accountDetailViewAttachmentsLnk, "Account Attachments");
		}
		catch (Exception e) {
			verificationErrors.append(methodID + "(): " + e.toString());
			System.out.println(methodID + ": the Account Detail view for the '" + entityRecord + "' Account record; test aborted.");
		}
				
		//Step: go back to previous screen
		headerButton.goBack();
		commNav.waitForPage("Accounts");
		
		System.out.println(ENDLINE);
	}
	
	
	@Test(enabled = true)
	public void test08_SeTestTCAccountEditView() throws Exception {
		String methodID = "test08_SeTestTCAccountEditView";
		
		// Test Params:
		String entityType = "Account";
		String entityRecord = TEST_ACCOUNT_RECORD;
		String viewName = "Account Edit view";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
		
		//Step: login & log back in (to clear cookies)
		LogOutThenLogBackIn(userName, userPwd);
		
		try {
			//Step: search for Account entity, then open it's Edit view
			AssertJUnit.assertTrue(commNav.entityRecordEditView(entityType, entityRecord));
			
			AccountViewsElements accountEditView = PageFactory.initElements(driver, AccountViewsElements.class);
			
			//Step: check each input field and if applicable, its related list item selection view
			commNav.isWebElementPresent(viewName + ", 'Details' section header", accountEditView.accountEditViewDetailsHdr);
			commNav.isFieldValueEmpty(viewName + ", account field", accountEditView.accountEditViewAccountInputFld);
			commNav.isFieldValueEmpty(viewName + ", web field", accountEditView.accountEditViewWebInputFld);
			commNav.isFieldValueEmpty(viewName + ", phone field", accountEditView.accountEditViewPhoneInputFld);
			commNav.verifyEntityViewElementClick(viewName + ",'address field'", accountEditView.accountEditViewAddressFldBtn, "Address");
			commNav.isFieldValueEmpty(viewName + ", fax field", accountEditView.accountEditViewFaxInputFld);
			commNav.verifyEntityViewElementClick(viewName + ",'type field'", accountEditView.accountEditViewTypeFldBtn, "Account Type");
			commNav.verifyEntityViewElementClick(viewName + ",'subtype field'", accountEditView.accountEditViewSubTypeFldBtn, "Account Subtype");
			commNav.verifyEntityViewElementClick(viewName + ",'status field'", accountEditView.accountEditViewStatusFldBtn, "Account Status");
			commNav.verifyEntityViewElementClick(viewName + ",'industry field'", accountEditView.accountEditViewIndustryFldBtn, "Industry");
			commNav.isFieldValueEmpty(viewName + ", business description text area", accountEditView.accountEditViewBusDescFld);
			commNav.verifyEntityViewElementClick(viewName + ",'account manager field'", accountEditView.accountEditViewAcctMgrFldBtn, "Users");
			commNav.verifyEntityViewElementClick(viewName + ",'owner field'", accountEditView.accountEditViewOwnerFldBtn, "Owners");
			commNav.verifyEntityViewElementClick(viewName + ",'lead source field'", accountEditView.accountEditViewLeadSourceFldBtn, "Lead Sources");
			
			//end of test
			headerButton.clickHeaderButton("cancel");
		
			//Step: go back to previous screen
			headerButton.goBack();
			Thread.sleep(2000);
		} catch (Error e) {
			verificationErrors.append(methodID + "(): " + e.toString());
			System.out.println(methodID + ": unable to open locate the '" + entityRecord + "' " + entityType);		
		}
		
		System.out.println(ENDLINE);
	}
	
	
	@Test(enabled = true)
	public void test09_SeTestTCAccountAddEditView() throws Exception {
		String methodID = "test09_SeTestTCAccountAddEditView";
		
		// Test Params:
		String entityType = "account";
		String viewName = "Account Add Edit view";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);	
		
		//Step: login & log back in (to clear cookies)
		LogOutThenLogBackIn(userName, userPwd);
		
		try {
			//Step: enter the Account Add Edit view...
			commNav.entityRecordAdd(entityType);
					
			AccountViewsElements accountEditView = PageFactory.initElements(driver, AccountViewsElements.class);
			
			//Step: check each input field and if applicable, its related list item selection view
			commNav.isWebElementPresent(viewName + ", 'Details' section header", accountEditView.accountEditViewDetailsHdr);
			commNav.isWebElementPresent(viewName + ", account field", accountEditView.accountEditViewAccountInputFld);
			commNav.isWebElementPresent(viewName + ", web field", accountEditView.accountEditViewWebInputFld);
			commNav.isWebElementPresent(viewName + ", phone field", accountEditView.accountEditViewPhoneInputFld);
			commNav.verifyEntityViewElementClick(viewName + ",'address field'", accountEditView.accountEditViewAddressFldBtn, "Address");
			commNav.isWebElementPresent(viewName + ", fax field", accountEditView.accountEditViewFaxInputFld);
			commNav.verifyEntityViewElementClick(viewName + ",'type field'", accountEditView.accountEditViewTypeFldBtn, "Account Type");
			commNav.verifyEntityViewElementClick(viewName + ",'subtype field'", accountEditView.accountEditViewSubTypeFldBtn, "Account Subtype");
			commNav.verifyEntityViewElementClick(viewName + ",'status field'", accountEditView.accountEditViewStatusFldBtn, "Account Status");
			commNav.verifyEntityViewElementClick(viewName + ",'industry field'", accountEditView.accountEditViewIndustryFldBtn, "Industry");
			accountEditView = PageFactory.initElements(driver, AccountViewsElements.class);
			commNav.isWebElementPresent(viewName + ", business description text area", accountEditView.accountEditViewBusDescFld);
			commNav.verifyEntityViewElementClick(viewName + ",'account manager field'", accountEditView.accountEditViewAcctMgrFldBtn, "Users");
			commNav.verifyEntityViewElementClick(viewName + ",'owner field'", accountEditView.accountEditViewOwnerFldBtn, "Owners");
			commNav.verifyEntityViewElementClick(viewName + ",'lead source field'", accountEditView.accountEditViewLeadSourceFldBtn, "Lead Sources");
			
			//end of test
			headerButton.clickHeaderButton("cancel");
		
			//Step: go back to previous screen
			headerButton.goBack();
			Thread.sleep(2000);
		}
		catch (Exception e) {
			verificationErrors.append(methodID + "(): " + e.toString());
			System.out.println(methodID + ": unable to open the Account Edit Add view.");			
		}
		
		System.out.println(ENDLINE);
	}
	
	
	@Test(enabled = true)
	public void test10_SeTestTCAccountListViewHashTags() throws Exception {
		String methodID = "test10_SeTestTCAccountListViewHashTags";
		
		// Test Params:
		String entityType = "accounts";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
		
		//Step: login & log back in (to clear cookies)
		LogOutThenLogBackIn(userName, userPwd);
		
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
				verificationErrors.append(methodID + "(): " + e.toString());
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
				verificationErrors.append(methodID + "(): " + e.toString());
				System.out.println("VP: Hash Tags sub-panel expand check - FAILED");
			}
		}
		catch (Error e) {
			verificationErrors.append(methodID + "(): " + e.toString());
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
		
		// Test Params:
		String entityType = "accounts";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
		
		//Step: login & log back in (to clear cookies)
		LogOutThenLogBackIn(userName, userPwd);
		
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
				verificationErrors.append(methodID + "(): " + e.toString());
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
				verificationErrors.append(methodID + "(): " + e.toString());
				System.out.println("VP: KPI sub-panel e check - FAILED");
			}
		}
		catch (Error e) {
			verificationErrors.append(methodID + "(): " + e.toString());
			System.out.println("VP: KPI sub-panel collapse check - FAILED");
		}
		
		//Step: re-enabled each of the KPI items		
		commNav.rightClickContextMenuItem("Total Revenue");
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
        WebElement entityListItem = commNav.entityListViewSearch("Account", newAcctName);
        if (entityListItem.isDisplayed())  {
			System.out.println(strResultsMsg + " - PASSED");
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
		
		// Test Params:
		String entityType = "Accounts";
		String expEntityPgTitle = "Accounts";
		String entityRecord = TEST_ACCOUNT_RECORD;
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);
	
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
		
		//Step: login & log back in (to clear cookies)
		LogOutThenLogBackIn(userName, userPwd);
	
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
				verificationErrors.append(methodID + "(): " + e.toString());
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
				verificationErrors.append(methodID + "(): " + e.toString());
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
