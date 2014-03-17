package argos.saleslogix.selenium.test;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

import argos.saleslogix.selenium.CommonNavigation;
import argos.saleslogix.selenium.HeaderButton;
import argos.saleslogix.selenium.OpportunityViewsElements;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;


/**
 * Class: AccountEntityViewsTest
 * Desc.: Test class for the Opportunity entity views
 */
public class OpportunityViewsTest extends BaseTest {
	
	public String TEST_OPPORTUNITY_RECORD = "Vegas Vision-Phase1";
	
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

	
	//Test Methods Set
	//================
	@Test(enabled = true)
	public void test01_SeTestTCOpportunityListView() throws Exception {
		//Reference: MBL-10049
		String methodID = "test01_SeTestTCOpportunityListView";
		
		// Test Params:
		String entityType = "Opportunities";
		String expEntityPgTitle = "Opportunities";
		String oppRecord = TEST_OPPORTUNITY_RECORD;
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerbutton = PageFactory.initElements(driver, HeaderButton.class);

		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
	    //Step: click Top-Left button to reveal Global Menu...
		headerbutton.showGlobalMenu();
	
	    //Step: navigate to Opportunity list view...
		commNav.entityListViewSearch(entityType, oppRecord);
		
		//Step: test Opportunity, List View page elements
		// SubStep: check the Page Title
		if (commNav.isPageDisplayed(entityType)) {
			
			OpportunityViewsElements opportunitiesListView = PageFactory.initElements(driver, OpportunityViewsElements.class);			
			
			//Step: check the Opportunity list view format
			commNav.checkIfWebElementPresent("Opportunity List View", opportunitiesListView.opportunityListViewRecords);
			
			//Step: check an Opportunity list view item record
			commNav.checkIfWebElementPresent("Opportunity List View, item record", opportunitiesListView.topOpportunityListItem);
			commNav.checkIfWebElementPresent("Opportunity List View, item record Tab", opportunitiesListView.topOpportunityListItemTab);
			commNav.checkIfWebElementPresent("Opportunity List View, item record Icon", opportunitiesListView.topOpportunityListItemIcon);
			commNav.checkIfWebElementPresent("Opportunity List View, item record Opportunity Name", opportunitiesListView.topOpportunityListItemName);
			commNav.checkIfWebElementPresent("Opportunity List View, item record Account", opportunitiesListView.topOpportunityListItemAccount);
			commNav.checkIfWebElementPresent("Opportunity List View, item record Account Manager Info", opportunitiesListView.topOpportunityListItemAcctMgrInfo);
			commNav.checkIfWebElementPresent("Opportunity List View, item record Status Info", opportunitiesListView.topOpportunityListItemStatusInfo);
			commNav.checkIfWebElementPresent("Opportunity List View, item record Sales Potential Opp. Rate", opportunitiesListView.topOpportunityListItemSalesPotOppRate);
			commNav.checkIfWebElementPresent("Opportunity List View, item record Touch Icon", opportunitiesListView.topOpportunityListItemTouch);
			//TODO: add coverage for ToDo icon check after figuring out the css id
			
			//Step: check the Quick Action button and items
			try {
				//click Quick Action button to reveal Quick Action items
				commNav.checkIfWebElementPresent("Opportunity List View, Quick Action button", opportunitiesListView.topOpportunityListItemQuickActionsBtn);
				opportunitiesListView.topOpportunityListItemQuickActionsBtn.click();
				
				//click the Quick Action button, then check each of the Quick Action items
				commNav.checkIfWebElementPresent("Opportunity, Quick Action Add Attachment button", opportunitiesListView.topOpportunityListItemQuickActionsAddAttachmentBtn);
				commNav.checkIfWebElementPresent("Opportunity, Quick Action Add Activity button", opportunitiesListView.topOpportunityListItemQuickActionsAddActivityBtn);
				commNav.checkIfWebElementPresent("Opportunity, Quick Action Add Note button", opportunitiesListView.topOpportunityListItemQuickActionsAddNoteBtn);
				commNav.checkIfWebElementPresent("Opportunity, Quick Action Products button", opportunitiesListView.topOpportunityListItemQuickActionsProductsBtn);
				commNav.checkIfWebElementPresent("Opportunity, Quick Action Contacts button", opportunitiesListView.topOpportunityListItemQuickActionsContactsBtn);
				commNav.checkIfWebElementPresent("Opportunity, Quick Action Accounts button", opportunitiesListView.topOpportunityListItemQuickActionsAccountBtn);
				commNav.checkIfWebElementPresent("Opportunity, Quick Action Edit button", opportunitiesListView.topOpportunityListItemQuickActionsEditBtn);
				
				//click Quick Action button to hide the Quick Action items
				opportunitiesListView.topOpportunityListItemQuickActionsBtn.click();
			}
			catch (Exception e) {
				System.out.println(methodID + "(): " + e.toString());				
			}
			
			//Step: check the "X records remaining" item box at the bottom of the list view
			//commNav.checkIfWebElementPresent("Opportunity List View, 'x remaining records' item", accountListView.recordsRemainingListItem);
		}
		else {
			System.out.println(methodID + ": required '" + expEntityPgTitle + "' not loaded; test aborted");
		}
		System.out.println(ENDLINE);
	}

	
	@Test(enabled = true)
	public void test02_SeTestTCOpportunityListViewLoadMoreResults() throws Exception {
		String methodID = "test02_SeTestTCOpportunityListViewLoadMoreResults";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerbutton = PageFactory.initElements(driver, HeaderButton.class);
	
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
		
		//Step: login & log back in (to clear cookies)
		LogOutThenLogBackIn(userName, userPwd);
		
	    //Step: click Top-Left button to reveal Global Menu...
		headerbutton.showGlobalMenu();
	
	    //Step: navigate to Opportunities list view...
		commNav.clickGlobalMenuItemOpportunities();
	
		//capture the initial Opportunities List view info
		OpportunityViewsElements opportunitiesListView = PageFactory.initElements(driver, OpportunityViewsElements.class);
		String initListInfo = opportunitiesListView.getOpportunityListViewTxt();
		
	    //Step: load more results (click on 'x remaining records' item)
		for (int count = 1; count<3; count++) {			
			JavascriptExecutor jsx = (JavascriptExecutor)driver;
			jsx.executeScript("window.scrollBy(0,450)", "");
		}
		
		//capture the expanded Opportunities List view
		String expandedListInfo = opportunitiesListView.getOpportunityListViewTxt();
		
		//VP: confirm that the Opportunities List view is indeed expanded with more record data
		String resultMsg = "VP: scrolling down the Opportunities List view loaded more records";
		try {
			AssertJUnit.assertFalse(initListInfo.matches(expandedListInfo));
			System.out.println(resultMsg + " - Passed");
		}
		catch (Error e) {
			verificationErrors.append(methodID + "(): " + e.toString());
			System.out.println(resultMsg + " - Failed");
		}
		
		System.out.println(ENDLINE);
	}


	@Test(enabled = true)
	public void test03_SeTestTCOpportunityViewSearch() throws Exception {
		String methodID = "test03_SeTestTCOpportunityViewSearch";
		
		// Test Params:
		String entityType = "Opportunity";
		String entityRecord = TEST_OPPORTUNITY_RECORD;
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
		
		//Step: search for an existing Opportunity record
		commNav.entityListViewSearch(entityType, entityRecord);
		
		System.out.println(ENDLINE);
	}
	
	
	@Test(enabled = true)
	public void test04_SeTestTCOpportunityListViewNegativeSearch() throws Exception {
		String methodID = "test04_SeTestTCOpportunityListViewNegativeSearch";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
		
		//Step: search for non-existent Opportunity record to confirm it's non-existence
		commNav.entityListViewNegativeSearch("Opportunities", "Non-Existent Opportunity");		
		
		System.out.println(ENDLINE);
	}


	@Test(enabled = true)
	public void test05_SeTestTCOpportunityListViewClearSearch() throws Exception {
		String methodID = "test05_SeTestTCOpportunityListViewClearSearch";
		
		// Test Params:
		String entityType = "Opportunities";
		String entityRecord = TEST_OPPORTUNITY_RECORD;
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);
	
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
	
		commNav.entityListViewSearch(entityType, entityRecord);
			
		//Step: check for matching results...
		OpportunityViewsElements opportunitiesListView = PageFactory.initElements(driver, OpportunityViewsElements.class);
		String topEntityListItemName = opportunitiesListView.topOpportunityListItemName.getText();
				
		//Step: click the clear Search input field button
		headerButton.showRightContextMenu();
		opportunitiesListView.opportunitySearchClearBtn.click();
				
		//Step: click the Lookup button to reload the full Opportunities list
		opportunitiesListView.opportunitySearchLookupBtn.click();
		Thread.sleep(3000);
				
		//Step: check if the previous search results were cleared
		String currTopOpportunitiesListViewName = driver.findElement(By.xpath("//*[@id='opportunity_list']/ul/li[1]/div/h3")).getText();
		try {
			AssertJUnit.assertEquals(topEntityListItemName, currTopOpportunitiesListViewName);
		} catch (Error e) {
			verificationErrors.append(methodID + "(): " + e.toString());
			System.out.println(methodID + ": clear previous Opportunities search results action failed");
			return;
		}
		
		System.out.println(methodID + ": clear previous Opportunities search results action was successful");
		System.out.println(ENDLINE);
	}


	@Test(enabled = true)
	public void test06_SeTestTCOpportunityListViewOpenRecord() throws Exception {
		String methodID = "test06_SeTestTCOpportunityListViewOpenRecord";
		
		// Test Params:
		String entityType = "Opportunities";
		String entityRecord = TEST_OPPORTUNITY_RECORD;
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
		
		//Step: search for Opportunity entity, then open it's Detail view
		commNav.entityRecordOpenDetailView(entityType, entityRecord);
		
		//Step: go back to previous screen
		headerButton.goBack();
		Thread.sleep(3000);
		
		System.out.println(ENDLINE);
	}


	@Test(enabled = true)
	public void test07_SeTestTCOpportunityDetailView() throws Exception {
		String methodID = "test07_SeTestTCOpportunityDetailView";
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
		
		// Test Params:
		String entityType = "Opportunity";
		String entityRecord = TEST_OPPORTUNITY_RECORD;
		String viewName = "Opportunity Detail view";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);
		
		try {
			//Step: search for Opportunity entity, then open it's Detail view
			commNav.entityRecordOpenDetailView(entityType, entityRecord);
			
			OpportunityViewsElements opportunityDetailView = PageFactory.initElements(driver, OpportunityViewsElements.class);
			
			//Step: check each item under the Opportunity Detail View, Quick Actions section
			commNav.isWebElementPresent(viewName + ",'Quick Actions' section header", opportunityDetailView.opportunityDetailViewQuickActionsHdr);
			commNav.isWebElementPresent(viewName + ",'Schedule activity'", opportunityDetailView.opportunityDetailViewScheduleActivityLnk);
			commNav.isWebElementPresent(viewName + ",'Add note'", opportunityDetailView.opportunityDetailViewAddNoteLnk);
			
			//Step: check each item under the Opportunity Detail View, Details section
			commNav.isWebElementPresent(viewName + ",'Details' section header", opportunityDetailView.opportunityDetailViewDetailsHdr);
			commNav.isFieldValueEmpty(viewName + ",'opportunity'", opportunityDetailView.opportunityDetailViewOpportunityFld);			
			commNav.isFieldValueEmpty(viewName + ",'acct'", opportunityDetailView.opportunityDetailViewAcctFld);			
			commNav.isFieldValueEmpty(viewName + ",'reseller'", opportunityDetailView.opportunityDetailViewResellerFld);			
			commNav.isFieldValueEmpty(viewName + ",'est close'", opportunityDetailView.opportunityDetailViewEstCloseFld);			
			commNav.isFieldValueEmpty(viewName + ",'status'", opportunityDetailView.opportunityDetailViewStatusFld);			
			commNav.isFieldValueEmpty(viewName + ",'type'", opportunityDetailView.opportunityDetailViewTypeFld);			
			commNav.isFieldValueEmpty(viewName + ",'close prob'", opportunityDetailView.opportunityDetailViewCloseProbFld);
			commNav.isFieldValueEmpty(viewName + ",'sales potential (base rate)'", opportunityDetailView.opportunityDetailViewSalesPotentialBaseRateFld);
			commNav.isFieldValueEmpty(viewName + ",'sales potential (my rate)'", opportunityDetailView.opportunityDetailViewSalesPotentialMyRateFld);
			commNav.isFieldValueEmpty(viewName + ",'sales potential (opp rate)'", opportunityDetailView.opportunityDetailViewSalesPotentialOppRateFld);
	
			//Step: check each item under the Opportunity Detail View, Multi Currency section
			commNav.isWebElementPresent(viewName + ",'Multi Currency' section header", opportunityDetailView.opportunityDetailViewMultiCurrencyHdr);
			//SubStep: conditionally expand the Multi Currency section
			if (opportunityDetailView.opportunityDetailViewMultiCurrencyFields.getSize().height < 1) {
				opportunityDetailView.opportunityDetailViewMultiCurrencyHdr.click();
				Thread.sleep(1000);
			}
			commNav.isFieldValueEmpty(viewName + ",'exchange rate'", opportunityDetailView.opportunityDetailViewExchangeRateFld);
			commNav.isFieldValueEmpty(viewName + ",'code'", opportunityDetailView.opportunityDetailViewCodeFld);
			commNav.isFieldValueEmpty(viewName + ",'rate date'", opportunityDetailView.opportunityDetailViewRateDateFld);
			commNav.isFieldValueEmpty(viewName + ",'rate locked'", opportunityDetailView.opportunityDetailViewRateLockedFld);
	
			//Step: check each item under the Opportunity Detail View, More Details section
			commNav.isWebElementPresent(viewName + ",'More Details' section header", opportunityDetailView.opportunityDetailViewMoreDetailsHdr);
			//SubStep: conditionally expand the More Details section
			if (opportunityDetailView.opportunityDetailViewMoreDetailsFields.getSize().height < 1) {
				opportunityDetailView.opportunityDetailViewMoreDetailsHdr.click();
				Thread.sleep(1000);
			}
			commNav.isFieldValueEmpty(viewName + ",'acct mgr'", opportunityDetailView.opportunityDetailViewAcctMgrFld);
			commNav.isFieldValueEmpty(viewName + ",'lead source'", opportunityDetailView.opportunityDetailViewLeadSourceFld);
			
			//Step: check each item under the Opportunity Detail View, Related Items section
			commNav.isWebElementPresent(viewName + ",'Related Items' section header", opportunityDetailView.opportunityDetailViewRelatedItemsHdr);
			commNav.verifyEntityViewElementClick(viewName + ",'Products'", opportunityDetailView.opportunityDetailViewProductsLnk, "Products");
			commNav.verifyEntityViewElementClick(viewName + ",'Activities'", opportunityDetailView.opportunityDetailViewActivitiesLnk, "Activities");
			commNav.verifyEntityViewElementClick(viewName + ",'Opportunity Contacts'", opportunityDetailView.opportunityDetailViewOpportunityContactsLnk, "Opportunity Contacts");
			commNav.verifyEntityViewElementClick(viewName + ",'Notes/History'", opportunityDetailView.opportunityDetailViewNotesHistoryLnk, "Notes/History");
			commNav.verifyEntityViewElementClick(viewName + ",'Attachments'", opportunityDetailView.opportunityDetailViewAttachmentsLnk, "Opportunity Attachments");
			
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
	public void test08_SeTestTCOpportunityEditView() throws Exception {
		String methodID = "test08_SeTestTCOpportunityEditView";
		
		// Test Params:
		String entityType = "Opportunity";
		String entityRecord = TEST_OPPORTUNITY_RECORD;
		String viewName = "Opportunity Detail Edit view";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
		
		//Step: login & log back in (to clear cookies)
		LogOutThenLogBackIn(userName, userPwd);
		
		try {
			//Step: search for Opportunity entity, then open it's Edit view
			AssertJUnit.assertTrue(commNav.entityRecordEditView(entityType, entityRecord));
			
			OpportunityViewsElements opportunityEditView = PageFactory.initElements(driver, OpportunityViewsElements.class);
		
			//Step: check each input field and if applicable, its related list item selection view
			commNav.isFieldValueEmpty(viewName + ",'opportunity'", opportunityEditView.opportunityEditViewOpportunityInputFld);			
			commNav.verifyEntityViewElementClick(viewName + ", acct", opportunityEditView.opportunityEditViewAcctFldBtn, "Accounts");			
			commNav.verifyEntityViewElementClick(viewName + ",acct mgr", opportunityEditView.opportunityEditViewAcctMgrFldBtn, "Users");			
			commNav.verifyEntityViewElementClick(viewName + ",reseller", opportunityEditView.opportunityEditViewResellerFldBtn, "Accounts");
			commNav.verifyEntityViewElementClick(viewName + ",est close", opportunityEditView.opportunityEditViewEstCloseFldBtn, "Calendar");
			commNav.isFieldValueEmpty(viewName + ",'sales potential", opportunityEditView.opportunityEditViewSalesPotentialInputFld);
			commNav.verifyEntityViewElementClick(viewName + ",type", opportunityEditView.opportunityEditViewTypeFldBtn, "Opportunity Type");
			commNav.verifyEntityViewElementClick(viewName + ",status", opportunityEditView.opportunityEditViewStatusFldBtn, "Opportunity Status");
			commNav.verifyEntityViewElementClick(viewName + ",lead source", opportunityEditView.opportunityEditViewLeadSourceFldBtn, "Lead Sources");
			commNav.verifyEntityViewElementClick(viewName + ",owner", opportunityEditView.opportunityEditViewOwnerFldBtn, "Owners");
			commNav.verifyEntityViewElementClick(viewName + ",close prob", opportunityEditView.opportunityEditViewCloseProbFldBtn, "Opportunity Probability");
			commNav.isWebElementPresent(viewName + ",exchange rate", opportunityEditView.opportunityEditViewExchangeRateFld);
			commNav.isWebElementPresent(viewName + ",code", opportunityEditView.opportunityEditViewCodeFld);
			commNav.isWebElementPresent(viewName + ",rate locked", opportunityEditView.opportunityEditViewRateLockedFld);
			commNav.isWebElementPresent(viewName + ",rate date", opportunityEditView.opportunityEditViewRateDateFld);
				
			//end of test
            headerButton.clickCancel();
		
			//Step: go back to previous screen
			headerButton.goBack();
			Thread.sleep(2000);
		} catch (Exception e) {
			verificationErrors.append(methodID + "(): " + e.toString());
			System.out.println(methodID + ": unable to open locate the '" + entityRecord + "' " + entityType);		
		}
		
		System.out.println(ENDLINE);
	}


	@Test(enabled = true)
	public void test09_SeTestTCOpportunityAddEditView() throws Exception {
		String methodID = "test09_SeTestTCOpportunityAddEditView";
		
		// Test Params:
		String entityType = "Opportunity";
		String viewName = "Opportunity Add Edit view";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);	
		
		try {
			//Step: enter the Opportunity Add Edit view...
			commNav.entityRecordAdd(entityType);
			
			OpportunityViewsElements opportunityEditView = PageFactory.initElements(driver, OpportunityViewsElements.class);
			
			//Step: check each input field and if applicable, its related list item selection view
			commNav.isWebElementPresent(viewName + ",'opportunity'", opportunityEditView.opportunityEditViewOpportunityInputFld);			
			commNav.verifyEntityViewElementClick(viewName + ", acct", opportunityEditView.opportunityEditViewAcctFldBtn, "Accounts");			
			commNav.verifyEntityViewElementClick(viewName + ",acct mgr", opportunityEditView.opportunityEditViewAcctMgrFldBtn, "Users");			
			commNav.verifyEntityViewElementClick(viewName + ",reseller", opportunityEditView.opportunityEditViewResellerFldBtn, "Accounts");
			commNav.verifyEntityViewElementClick(viewName + ",est close", opportunityEditView.opportunityEditViewEstCloseFldBtn, "Calendar");
			commNav.isFieldValueEmpty(viewName + ",'sales potential", opportunityEditView.opportunityEditViewSalesPotentialInputFld);
			commNav.verifyEntityViewElementClick(viewName + ",type", opportunityEditView.opportunityEditViewTypeFldBtn, "Opportunity Type");
			commNav.verifyEntityViewElementClick(viewName + ",status", opportunityEditView.opportunityEditViewStatusFldBtn, "Opportunity Status");
			commNav.verifyEntityViewElementClick(viewName + ",lead source", opportunityEditView.opportunityEditViewLeadSourceFldBtn, "Lead Sources");
			commNav.verifyEntityViewElementClick(viewName + ",owner", opportunityEditView.opportunityEditViewOwnerFldBtn, "Owners");
			commNav.verifyEntityViewElementClick(viewName + ",close prob", opportunityEditView.opportunityEditViewCloseProbFldBtn, "Opportunity Probability");
			commNav.isFieldValueEmpty(viewName + ",exchange rate", opportunityEditView.opportunityEditViewExchangeRateFld);
			commNav.verifyEntityViewElementClick(viewName + ",code", opportunityEditView.opportunityEditViewCodeFldBtn, "Exchange Rates");
			commNav.isWebElementPresent(viewName + ",rate locked", opportunityEditView.opportunityEditViewRateLockedFld);
			commNav.isWebElementPresent(viewName + ",rate date", opportunityEditView.opportunityEditViewRateDateFld);
			
			//end of test
			headerButton.clickCancel();
		
			//Step: go back to previous screen
			headerButton.goBack();
			Thread.sleep(2000);
		}
		catch (Exception e) {
			verificationErrors.append(methodID + "(): " + e.toString());
			System.out.println(methodID + ": unable to open the Opportunity Add Edit view.");
		}
		
		System.out.println(ENDLINE);
	}

	
	@Test(enabled = true)
	public void test10_SeTestTCOpportunityListViewHashTags() throws Exception {
		String methodID = "test10_SeTestTCOpportunityListViewHashTags";
		
		// Test Params:
		String entityType = "Opportunities";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
		
	    //Step: navigate to Opportunities list view...
		commNav.clickGlobalMenuItemOpportunities();
		
		OpportunityViewsElements oppsListView = PageFactory.initElements(driver, OpportunityViewsElements.class);
		
		//Step: reveal Right Context Menu panel
		headerButton.showRightContextMenu();
		
	    //Step: test the Hash Tags header
		//expand the Hash Tags sub-panel if it's currently collapsed
		if (!oppsListView.opportunityHashTagsPnl.isDisplayed()) {
			oppsListView.opportunityHashTagsHdr.click();
			
			//confirm the the panel was indeed expanded
			try {
				AssertJUnit.assertTrue(oppsListView.opportunityHashTagsPnl.isDisplayed());
			}
			catch (Error e) {
				verificationErrors.append(methodID + "(): " + e.toString());
				System.out.println(methodID + ": Hash Tags panel failed to expand on panel header click; test aborted.");
				return;
			}
		}
		//collapase the Hash Tags sub-panel
		oppsListView.opportunityHashTagsHdr.click();
		try {
			AssertJUnit.assertFalse(oppsListView.opportunityHashTagsPnl.isDisplayed());
			System.out.println("VP: Hash Tags sub-panel collapse check - Passed");
			
			//re-expand the Hash Tags sub-panel
			oppsListView.opportunityHashTagsHdr.click();
			try {
				AssertJUnit.assertTrue(oppsListView.opportunityHashTagsPnl.isDisplayed());
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
		commNav.rightClickContextMenuItem("my-opportunities");
		commNav.rightClickContextMenuItem("open");
		commNav.rightClickContextMenuItem("won");
		commNav.rightClickContextMenuItem("lost");
		commNav.rightClickContextMenuItem("inactive");
		commNav.rightClickContextMenuItem("prospect");
		commNav.rightClickContextMenuItem("qualification");
		commNav.rightClickContextMenuItem("needs-analysis");
		commNav.rightClickContextMenuItem("demonstration");
		commNav.rightClickContextMenuItem("negotiation");
		commNav.rightClickContextMenuItem("decision");
		
		//Step: go back to previous screen
		headerButton.goBack();
		Thread.sleep(3000);
		
		System.out.println(ENDLINE);
	}
	

	@Test(enabled = true)
	public void test11_SeTestTCOpportunityListViewKPI() throws Exception {
		String methodID = "test11_SeTestTCOpportunityListViewKPI";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
		
	    //Step: navigate to Opportunities list view...
		commNav.clickGlobalMenuItemOpportunities();
		
		OpportunityViewsElements oppsListView = PageFactory.initElements(driver, OpportunityViewsElements.class);
		
		//Step: reveal Right Context Menu panel
		headerButton.showRightContextMenu();
		
	    //Step: test the KPI header
		//expand the KPI sub-panel if it's currently collapsed
		if (!oppsListView.opportunityKPIPnl.isDisplayed()) {
			oppsListView.opportunityKPIHdr.click();
			
			//confirm the the panel was indeed expanded
			try {
				AssertJUnit.assertTrue(oppsListView.opportunityKPIPnl.isDisplayed());
			}
			catch (Error e) {
				verificationErrors.append(methodID + "(): " + e.toString());
				System.out.println(methodID + ": Hash Tags panel failed to expand on panel header click; test aborted.");
				return;
			}
		}
		
		//collapse KPI Tags sub-panel check
		oppsListView.opportunityKPIHdr.click();
		try {
			AssertJUnit.assertFalse(oppsListView.opportunityKPIPnl.isDisplayed());
			System.out.println("VP: KPI sub-panel collapse check - Passed");
			
			//re-expand the KPI Tags sub-panel
			oppsListView.opportunityKPIHdr.click();
			try {
				AssertJUnit.assertTrue(oppsListView.opportunityKPIPnl.isDisplayed());
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
		
		//Step: test each of the pre-set KPI items		
		commNav.scrollDownPage();
		commNav.rightClickContextMenuItem("Total Opportunities");
		commNav.rightClickContextMenuItem("Sales Potential");
		
		//Step: go back to previous screen
		headerButton.closeRightContextMenu();
		headerButton.goBack();
		Thread.sleep(3000);
		
		System.out.println(ENDLINE);
	}


	@Test(enabled = true)
	public void test12_SeTestTCOpportunityListViewAddOpportunity() throws Exception {
		String methodID = "test12_SeTestTCOpportunityListViewAddOpportunity";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		//HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
		
		//Step: login & log back in (to clear cookies)
		LogOutThenLogBackIn(userName, userPwd);
				
		OpportunityViewsElements oppsListView = PageFactory.initElements(driver, OpportunityViewsElements.class);
		
		//Step: add a random test Opportunity record
		String newOpportunityName = "AutoTestOpportunity-" + new SimpleDateFormat("yyMMddHHmm").format(new GregorianCalendar().getTime());
		oppsListView.doAddRandTestOpportunity(newOpportunityName, "Above Marine");
		
		//Step: find the newly-added test Opportunity record
		String strResultsMsg = "VP: recently added test Opportunity '" + newOpportunityName + "' was found.";
		if (oppsListView.doSearchOpportunity(newOpportunityName)) {
			System.out.println(strResultsMsg + " - Passed");
		}
		else {
			System.out.println(strResultsMsg + " - FAILED");
		}
		
		//Step: go back to My Activities view
		commNav.clickGlobalMenuItemMyActivities();
		
		System.out.println(ENDLINE);
	}


	@Test(enabled = true)
	public void test13_SeTestTCOpportunityListViewNotesBox() throws Exception {
		//Reference: MBL-10042
		String methodID = "test13_SeTestTCOpportunityListViewNotesBox";
		
		// Test Params:
		String entityType = "Opportunities";
		String expEntityPgTitle = "Opportunities";
		String oppRecord = "International Hampton - Phase 3";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);
	
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
	
	    //Step: navigate to Opportunities list view...
		commNav.entityListViewSearch(entityType, oppRecord);
		
		//Step: test Opportunities, List View page elements
		// SubStep: check the Page Title
		if (commNav.isPageDisplayed(entityType)) {
			try {
				OpportunityViewsElements opportunityListView = PageFactory.initElements(driver, OpportunityViewsElements.class);			
				
				//Step: check the Opportunities list view format
				commNav.checkIfWebElementPresent("Opportunities List View", opportunityListView.opportunityListViewPnl);
				
				//Step: check an Opportunity list view item record
				commNav.checkIfWebElementPresent("Opportunities List View, Notes Box", opportunityListView.opportunityListViewNotesBox1stItem);			
				commNav.checkIfWebElementPresent("Opportunities List View, Notes Box item, Initials box", opportunityListView.opportunityListViewNotesBox1stItemInitialsBox);			
				commNav.checkIfWebElementPresent("Opportunities List View, Notes Box item, Regarding header", opportunityListView.opportunityListViewNotesBox1stItemRegarding);			
				commNav.checkIfWebElementPresent("Opportunities List View, Notes Box item, Last Activity note", opportunityListView.opportunityListViewNotesBox1stItemLastActivity);			
				commNav.checkIfWebElementPresent("Opportunities List View, Notes Box item, note item", opportunityListView.opportunityListViewNotesBox1stItemNotes);			
				commNav.checkIfWebElementPresent("Opportunities List View, Notes Box item, see list link", opportunityListView.opportunityListViewNotesBoxSeeListLink);
				
				//Step: check the Notes Box list item click navigation
				String expPgTitle = "Meeting";
				String resultsMsg = "VP: Clicking Notes Box item navigated to the expected page";
				try {
					//click the 1st Notes Box item
					opportunityListView.opportunityListViewNotesBox1stItem.click();
					Thread.sleep(5000);
					commNav.isPageDisplayed(expPgTitle);
					AssertJUnit.assertTrue(driver.findElement(By.xpath("//*[@id='history_detail']")).isDisplayed());
					headerButton.goBack();
					Thread.sleep(2000);
					System.out.println(resultsMsg + " - Passed");
					
				}
				catch (Exception e) {
					System.out.println(methodID + "(): " + e.toString());
					System.out.println(resultsMsg + " - Failed");
				}
				
				opportunityListView = PageFactory.initElements(driver, OpportunityViewsElements.class);
				
				//Step: check the Notes Box 'see list' link click navigation
				expPgTitle = "Notes";
				resultsMsg = "VP: Clicking Notes Box 'see list' link navigated to the expected page";
				try {
					//click the Notes Box 'see list' link
					opportunityListView.opportunityListViewNotesBoxSeeListLink.click();
					Thread.sleep(5000);
					commNav.isPageDisplayed(expPgTitle);
					AssertJUnit.assertTrue(driver.findElement(By.xpath("//*[@id='history_related']")).isDisplayed());
					headerButton.goBack();
					Thread.sleep(2000);
					System.out.println(resultsMsg + " - Passed");
					
				}
				catch (Exception e) {
					System.out.println(methodID + "(): " + e.toString());
					System.out.println(resultsMsg + " - Failed");
				}
			}
			catch (Exception e) {
				verificationErrors.append(methodID + "(): " + e.toString());
			}
		}
		else {
			System.out.println(methodID + ": required '" + expEntityPgTitle + "' not loaded; test aborted");
		}
		
		System.out.println(ENDLINE);
	}




}
