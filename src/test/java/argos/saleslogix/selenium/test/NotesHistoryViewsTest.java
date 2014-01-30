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


/**
 * @author mllena
 * Class: AccountEntityViewsTest
 * Desc.: Test class for the Account entity views
 */
public class NotesHistoryViewsTest extends BrowserSetup {
	
	//Test Methods Set
	//================
	@Test(enabled = true)
	public void test01_SeTestTCNotesHistoryListView() throws Exception {
		//Reference: MBL-10068
		String methodID = "test01_SeTestTCNotesHistoryListView";
		
		// Test Params:
		String entityType = "Notes/History";
		String expEntityPgTitle = "Notes/History";
		String regardingRecord = "Research";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerbutton = PageFactory.initElements(driver, HeaderButton.class);
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
		
	    //Step: click Top-Left button to reveal Global Menu...
		headerbutton.showGlobalMenu();
	
	    //Step: navigate to Notes/History list view...
		commNav.entityListViewSearchContains(entityType, regardingRecord);
		
		//Step: test Notes/History, List View page elements
		// SubStep: check the Page Title
		if (commNav.isPageDisplayed(entityType)) {
			
			NotesHistoryViewsElements notesHistoryListView = PageFactory.initElements(driver, NotesHistoryViewsElements.class);			
			
			//Step: check the Notes/History list view format
			commNav.checkIfWebElementPresent("Notes/History List View", notesHistoryListView.notesHistorysListView);
			
			//Step: check an Notes/History list view item record
			commNav.checkIfWebElementPresent("Notes/History List View, item record", notesHistoryListView.topNotesHistoryListItem);
			commNav.checkIfWebElementPresent("Notes/History List View, item record Icon", notesHistoryListView.topNotesHistoryListItemIcon);
			commNav.checkIfWebElementPresent("Notes/History List View, item record Scheduled Time", notesHistoryListView.topNotesHistoryListItemScheduledTime);
			commNav.checkIfWebElementPresent("Notes/History List View, item record Contact & Account", notesHistoryListView.topNotesHistoryListItemContactAccount);
			commNav.checkIfWebElementPresent("Notes/History List View, item record Regarding", notesHistoryListView.topNotesHistoryListItemRegarding);
			commNav.checkIfWebElementPresent("Notes/History List View, item record Notes", notesHistoryListView.topNotesHistoryListItemNotes);
			commNav.checkIfWebElementPresent("Notes/History List View, item record touch widget", notesHistoryListView.topNotesHistoryListItemTouch);
			//TODO: add coverage for ToDo icon check after figuring out the css id
			
			//Step: check the Quick Action button and items
			try {
				//click Quick Action button to reveal Quick Action items
				commNav.checkIfWebElementPresent("Notes/History List View, Quick Action button", notesHistoryListView.topNotesHistoryListItemQuickActionsBtn);
				notesHistoryListView.topNotesHistoryListItemQuickActionsBtn.click();
				
				//click the Quick Action button, then check each of the Quick Action items
				commNav.checkIfWebElementPresent("Notes/History, Quick Action Add Attachment button", notesHistoryListView.topNotesHistoryListItemQuickActionsAddAttachmentBtn);
				commNav.checkIfWebElementPresent("Notes/History, Quick Action Contact button", notesHistoryListView.topNotesHistoryListItemQuickActionsContactsBtn);
				commNav.checkIfWebElementPresent("Notes/History, Quick Action Opportunity button", notesHistoryListView.topNotesHistoryListItemQuickActionsOpportunityBtn);
				commNav.checkIfWebElementPresent("Notes/History, Quick Action Account button", notesHistoryListView.topNotesHistoryListItemQuickActionsAccountBtn);
				
				//click Quick Action button to hide the Quick Action items
				notesHistoryListView.topNotesHistoryListItemQuickActionsBtn.click();
			}
			catch (Exception e) {
				System.out.println(e.toString());				
			}
			
			//Step: check the "X records remaining" item box at the bottom of the list view
			//commNav.checkIfWebElementPresent("Notes/History List View, 'x remaining records' item", accountListView.recordsRemainingListItem);
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

	@Test(enabled = true)
	public void test02_SeTestTCNotesHistoryListViewLoadMoreResults() throws Exception {
		String methodID = "test02_SeTestTCNotesHistoryListViewLoadMoreResults";
		
		//Test Params:
		String entityType = "notes/history";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerbutton = PageFactory.initElements(driver, HeaderButton.class);
	
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
		
		//Step: login & log back in (to clear cookies)
		LogOutThenLogBackIn(userName, userPwd);
		
	    //Step: click Top-Left button to reveal Global Menu...
		headerbutton.showGlobalMenu();
	
	    //Step: navigate to Notes/History list view...
		commNav.clickGlobalMenuItem(entityType);
	
		//capture the initial Notes/History List view info
		NotesHistoryViewsElements noteshistoryListView = PageFactory.initElements(driver, NotesHistoryViewsElements.class);
		String initListInfo = noteshistoryListView.getNotesHistoryListViewTxt();
		
	    //Step: load more results (click on 'x remaining records' item)
		for (int count = 1; count<3; count++) {			
			JavascriptExecutor jsx = (JavascriptExecutor)driver;
			jsx.executeScript("window.scrollBy(0,450)", "");
		}
		
		//capture the expanded Notes/History List view
		String expandedListInfo = noteshistoryListView.getNotesHistoryListViewTxt();
		
		//VP: confirm that the Notes/History List view is indeed expanded with more record data
		String resultMsg = "VP: scrolling down the Notes/History List view loaded more records";
		try {
			AssertJUnit.assertFalse(initListInfo.matches(expandedListInfo));
			System.out.println(resultMsg + " - Passed");
		}
		catch (Error e) {
			verificationErrors.append(e.toString());
			System.out.println(resultMsg + " - Failed");
		}
		
		System.out.println(ENDLINE);
	}

	@Test(enabled = true)
	public void test03_SeTestTCNotesHistoryViewSearch() throws Exception {
		String methodID = "test03_SeTestTCNotesHistoryViewSearch";
		
		// Test Params:
		String entityType = "Notes/History";
		String entityRecord = "Research the prospect";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
		
		//Step: search for an existing Notes/History record
		commNav.entityListViewSearch(entityType, entityRecord);
		
		System.out.println(ENDLINE);
	}

	@Test(enabled = true)
	public void test04_SeTestTCNotesHistoryListViewNegativeSearch() throws Exception {
		String methodID = "test04_SeTestTCNotesHistoryListViewNegativeSearch";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
		
		//Step: search for non-existent Notes/History record to confirm it's non-existence
		commNav.entityListViewNegativeSearch("Notes/History", "Non-Existent Note History Record");		
		
		System.out.println(ENDLINE);
	}

	@Test(enabled = true)
	public void test05_SeTestTCNotesHistoryListViewClearSearch() throws Exception {
		String methodID = "test05_SeTestTCNotesHistoryListViewClearSearch";
		
		// Test Params:
		String entityType = "Notes/History";
		String entityRecord = "Research the prospect";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);
	
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
	
		commNav.entityListViewSearch(entityType, entityRecord);
			
		//Step: check for matching results...
		NotesHistoryViewsElements noteshistoryListView = PageFactory.initElements(driver, NotesHistoryViewsElements.class);
		String topNotesHistListItemName = noteshistoryListView.topNotesHistoryListItem.getText();
				
		//Step: click the clear Search input field button
		headerButton.showRightContextMenu();
		noteshistoryListView.notesHistorysSearchClearBtn.click();
				
		//Step: click the Lookup button to reload the full Notes/History list
		noteshistoryListView.notesHistorysSearchLookupBtn.click();
		Thread.sleep(3000);
				
		//Step: check if the previous search results were cleared
		String currTopNotesHistListViewName = driver.findElement(By.xpath("//*[@id='history_list']/ul/li[1]/div/h3")).getText();
		try {
			AssertJUnit.assertEquals(topNotesHistListItemName, currTopNotesHistListViewName);
		} catch (Error e) {
			verificationErrors.append(e.toString());
			System.out.println(methodID + ": clear previous Notes/History search results action failed");
			return;
		}
		
		System.out.println(methodID + ": clear previous Notes/History search results action was successful");
		System.out.println(ENDLINE);
	}

	@Test(enabled = true)
	public void test06_SeTestTCNotesHistoryListViewOpenRecord() throws Exception {
		String methodID = "test06_SeTestTCNotesHistoryListViewOpenRecord";
		
		// Test Params:
		String entityType = "Notes/History";
		String entityRecord = "Research the prospect";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
		
		//Step: search for Notes/History record, then open it's Detail view
		commNav.entityRecordOpenDetailView(entityType, entityRecord);
		
		//Step: go back to previous screen
		headerButton.goBack();
		Thread.sleep(3000);
		
		System.out.println(ENDLINE);
	}
}
