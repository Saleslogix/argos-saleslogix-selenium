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
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerbutton = PageFactory.initElements(driver, HeaderButton.class);
		
		// Test Params:
		String entityType = "Notes/History";
		String expEntityPgTitle = "Notes/History";
		String regardingRecord = "Research";

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
}
