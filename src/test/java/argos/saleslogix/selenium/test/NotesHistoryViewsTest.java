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
 * @author mllena
 * Class: NotesHistoryViewsTest
 * Desc.: Test class for the Notes/History views
 */
public class NotesHistoryViewsTest extends BaseTest {
	
	public String TEST_NOTE_RECORD = "Research the prospect";
	
	//Test Methods Set
	//================
	@Test(enabled = true)
	public void test01_SeTestTCNotesHistoryListView() throws Exception {
		//Reference: MBL-10068
		String methodID = "test01_SeTestTCNotesHistoryListView";
		
		// Test Params:
		String entityType = "Notes/History";
		String expEntityPgTitle = "Notes/History";
		String regardingRecord = TEST_NOTE_RECORD;
		
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
			commNav.checkIfWebElementPresent("Notes/History List View, item record touch icon", notesHistoryListView.topNotesHistoryListItemTouch);

			//TODO: add coverage for ToDo icon check after figuring out the css id
			
			//Step: check the Quick Action button and items
			try {
				//click list item icon to reveal Quick Action items
				notesHistoryListView.topNotesHistoryListItemIcon.click();
				
				//click the Quick Action button, then check each of the Quick Action items
				commNav.checkIfWebElementPresent("Notes/History, Quick Action Add Attachment button", notesHistoryListView.topNotesHistoryListItemQuickActionsAddAttachmentBtn);
				commNav.checkIfWebElementPresent("Notes/History, Quick Action Contact button", notesHistoryListView.topNotesHistoryListItemQuickActionsContactsBtn);
				commNav.checkIfWebElementPresent("Notes/History, Quick Action Opportunity button", notesHistoryListView.topNotesHistoryListItemQuickActionsOpportunityBtn);
				commNav.checkIfWebElementPresent("Notes/History, Quick Action Account button", notesHistoryListView.topNotesHistoryListItemQuickActionsAccountBtn);
				
				//click list item icon to hide the Quick Action items
				notesHistoryListView.topNotesHistoryListItemIcon.click();
			}
			catch (Exception e) {
				System.out.println(methodID + "(): " + e.toString());				
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
        CommonViewsElements commView = PageFactory.initElements(driver, CommonViewsElements.class);
        NotesHistoryViewsElements noteshistoryListView = PageFactory.initElements(driver, NotesHistoryViewsElements.class);
	
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
		
		//Step: logout & log back in (to clear cookies)
		LogOutThenLogBackIn(userName, userPwd);
		
	    //Step: click Top-Left button to reveal Global Menu...
		headerbutton.showGlobalMenu();
	
	    //Step: navigate to Notes/History list view...
		commNav.clickGlobalMenuItem(entityType);
        commNav.waitForPage("Notes/History");

        //Step: perform a lookup on all Notes/History records
        //noteshistoryListView.notesHistorysSearchClearBtn.click();
        commView.lookupTxtBox.click();
        Thread.sleep(500);
        commView.lookupTxtBox.sendKeys(Keys.BACK_SPACE);
        Thread.sleep(500);
        //noteshistoryListView.notesHistorysSearchLookupBtn.click();
        commView.lookupTxtBox.sendKeys(Keys.RETURN);
        Thread.sleep(3000);

		//capture the initial Notes/History List view info
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
			System.out.println(resultMsg + " - PASSED");
		}
		catch (Error e) {
			verificationErrors.append(methodID + "(): " + e.toString());
			System.out.println(resultMsg + " - FAILED");
		}
		
		System.out.println(ENDLINE);
	}
	

	@Test(enabled = true)
	public void test03_SeTestTCNotesHistoryViewSearch() throws Exception {
		String methodID = "test03_SeTestTCNotesHistoryViewSearch";
		
		// Test Params:
		String entityType = "Notes/History";
		String entityRecord = TEST_NOTE_RECORD;
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
		
		//Step: search for an existing Notes/History record
		commNav.entityListViewSearch(entityType, entityRecord);
		
		System.out.println(ENDLINE);
	}
	

	@Test(enabled = true)
	public void test04_SeTestTCNotesHistoryListViewNegativeSearch() throws Exception {
		String methodID = "test04_SeTestTCNotesHistoryListViewNegativeSearch";

        // Test Params:
        String entityType = "Notes/History";

		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
		
		//Step: search for non-existent Notes/History record to confirm it's non-existence
		commNav.entityListViewNegativeSearch(entityType, "Non-Existent Note History Record");
		
		System.out.println(ENDLINE);
	}
	

	@Test(enabled = true)
	public void test05_SeTestTCNotesHistoryListViewClearSearch() throws Exception {
		String methodID = "test05_SeTestTCNotesHistoryListViewClearSearch";
		
		// Test Params:
		String entityType = "Notes/History";
		String entityRecord = TEST_NOTE_RECORD;
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);
        CommonViewsElements commView = PageFactory.initElements(driver, CommonViewsElements.class);
        NotesHistoryViewsElements noteshistoryListView = PageFactory.initElements(driver, NotesHistoryViewsElements.class);
	
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
	
		commNav.entityListViewSearch(entityType, entityRecord);
			
		//Step: check for matching results...
        String initNotesHistoryListInfo = noteshistoryListView.getNotesHistoryListViewTxt();

		//Step: click the clear Search input field button
        //In Mobile 3.2 the clear and lookup buttons have been removed ... for lookup text box, just backspace and enter instead/
		//headerButton.showRightContextMenu();
		//noteshistoryListView.notesHistorysSearchClearBtn.click();
        commView.lookupTxtBox.click();
        Thread.sleep(500);
        commView.lookupTxtBox.sendKeys(Keys.BACK_SPACE);
        Thread.sleep(500);
				
		//Step: click the Lookup button to reload the full Notes/History list
		//noteshistoryListView.notesHistorysSearchLookupBtn.click();
        commView.lookupTxtBox.sendKeys(Keys.RETURN);
		Thread.sleep(7000);
				
		//Step: check if the previous search results were cleared
        String expandedNotesHistoryListInfo = noteshistoryListView.getNotesHistoryListViewTxt();

		try {
			AssertJUnit.assertFalse(initNotesHistoryListInfo.matches(expandedNotesHistoryListInfo));
            System.out.println(methodID + ": clear previous Notes/History search results action PASSED");
		} catch (Error e) {
			verificationErrors.append(methodID + "(): " + e.toString());
			System.out.println(methodID + ": clear previous Notes/History search results action FAILED");
		}

		System.out.println(ENDLINE);
	}
	

	@Test(enabled = true)
	public void test06_SeTestTCNotesHistoryListViewOpenRecord() throws Exception {
		String methodID = "test06_SeTestTCNotesHistoryListViewOpenRecord";
		
		// Test Params:
		String entityType = "Notes/History";
		String entityRecord = TEST_NOTE_RECORD;
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);

        //Step: logout & log back in (to clear cookies)
        LogOutThenLogBackIn(userName, userPwd);

        try {
		   //Step: search for Notes/History record, then open it's Detail view
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
	public void test07_SeTestTCNotesHistoryDetailView() throws Exception {
		String methodID = "test07_SeTestTCNotesHistoryDetailView";
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
		
		// Test Params:
		String entityType = "Notes/History";
		String entityRecord = TEST_NOTE_RECORD;
		String viewName = "History Detail view";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);

        //Step: logout & log back in (to clear cookies)
        LogOutThenLogBackIn(userName, userPwd);

		try {
			//Step: search for Notes/History entity, then open it's Detail view
			commNav.entityRecordOpenDetailView(entityType, entityRecord);
			
			NotesHistoryViewsElements notesHistoryDetailView = PageFactory.initElements(driver, NotesHistoryViewsElements.class);

            //Step: check each item under the History Detail View, Details section
            commNav.isWebElementPresent(viewName + ",'Notes' section header", notesHistoryDetailView.notesHistoryDetailViewNotesHdr);
            commNav.isFieldValueEmpty(viewName + ",'notes field'", notesHistoryDetailView.notesHistoryDetailViewNotesFld);
			
			//Step: check each item under the History Detail View, Quick Actions section
			commNav.isWebElementPresent(viewName + ",'Details' section header", notesHistoryDetailView.notesHistoryDetailViewDetailsHdr);
			commNav.isFieldValueEmpty(viewName + ",'scheduled'", notesHistoryDetailView.notesHistoryDetailViewScheduledFld);
			commNav.isFieldValueEmpty(viewName + ",'completed'", notesHistoryDetailView.notesHistoryDetailViewCompletedFld);
			commNav.isFieldValueEmpty(viewName + ",'regarding'", notesHistoryDetailView.notesHistoryDetailViewRegardingFld);
			commNav.isFieldValueEmpty(viewName + ",'completed by'", notesHistoryDetailView.notesHistoryDetailViewCompletedByFld);
            commNav.isFieldValueEmpty(viewName + ",'account'", notesHistoryDetailView.notesHistoryDetailViewAccountFld);
            commNav.isFieldValueEmpty(viewName + ",'contact'", notesHistoryDetailView.notesHistoryDetailViewContactFld);
            commNav.isFieldValueEmpty(viewName + ",'opportunity'", notesHistoryDetailView.notesHistoryDetailViewOpportunityFld);
            commNav.isFieldValueEmpty(viewName + ",'ticket'", notesHistoryDetailView.notesHistoryDetailViewTicketFld);

			//Step: check each item under the History Detail View, Related Items section
			commNav.isWebElementPresent(viewName + ",'Related Items' section header", notesHistoryDetailView.notesHistoryDetailRelatedItems1Hdr);
			commNav.verifyEntityViewElementClick(viewName + ",'Attachments'", notesHistoryDetailView.notesHistoryDetailViewAttachmentsLnk, "History Attachments");
			
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
    // This test searches on 'Research the prospect', then edits that item ... now that loup may only edit his own notes, this will fail unless loup adds
    //  a note for 'Research the prospect' manually : later - automate this note creation
	public void test08_SeTestTCNotesHistoryEditView() throws Exception {
		String methodID = "test08_SeTestTCNotesHistoryEditView";
		
		// Test Params:
		String entityType = "Notes/History";
		String entityRecord = "Research the prospect";
		String viewName = "History Detail Edit view";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
		
		//Step: logout & log back in (to clear cookies)
		LogOutThenLogBackIn(userName, userPwd);
		
		try {
			//Step: search for Notes/History entity, then open it's Edit view
			AssertJUnit.assertTrue(commNav.entityRecordEditView(entityType, entityRecord));
			
			NotesHistoryViewsElements notesHistoryEditView = PageFactory.initElements(driver, NotesHistoryViewsElements.class);
		
			//Step: check each input field and if applicable, its related list item selection view			
			commNav.verifyEntityViewElementClick(viewName + ", time", notesHistoryEditView.notesHistoryEditViewTimeFldBtn, "Calendar");			
			commNav.verifyEntityViewElementClick(viewName + ", regarding", notesHistoryEditView.notesHistoryEditViewRegardingFldBtn, "Note Description");			
			commNav.isFieldValueEmpty(viewName + ", notes", notesHistoryEditView.notesHistoryEditViewNotesInputFld);
			commNav.isWebElementPresent(viewName + ", for lead", notesHistoryEditView.notesHistoryEditViewForLeadToggleBtn);
			commNav.verifyEntityViewElementClick(viewName + ", account", notesHistoryEditView.notesHistoryEditViewAccountFldBtn, "Accounts");
			commNav.verifyEntityViewElementClick(viewName + " contact", notesHistoryEditView.notesHistoryEditViewContactFldBtn, "Contacts");
			commNav.verifyEntityViewElementClick(viewName + ", opportunity", notesHistoryEditView.notesHistoryEditViewOpportunityFldBtn, "Opportunities");
			commNav.verifyEntityViewElementClick(viewName + " ticket", notesHistoryEditView.notesHistoryEditViewTicketFldBtn, "Tickets");
				
			//end of test
			headerButton.clickHeaderButton("cancel");
		
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
	public void test10_SeTestTCNotesHistoryListViewHashTags() throws Exception {
		String methodID = "test10_SeTestTCNotesHistoryListViewHashTags";
		
		// Test Params:
		String entityType = "Notes/History";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);

        //Step: logout & log back in (to clear cookies)
        LogOutThenLogBackIn(userName, userPwd);
		
	    //Step: navigate to Notes/History list view...
		commNav.clickGlobalMenuItem(entityType);
		
		NotesHistoryViewsElements noteshistoryListView = PageFactory.initElements(driver, NotesHistoryViewsElements.class);
		
		//Step: reveal Right Context Menu panel
		headerButton.showRightContextMenu();
		
	    //Step: test the Hash Tags header
		//expand the Hash Tags sub-panel if it's currently collapsed
		if (!noteshistoryListView.notesHistoryHashTagsPnl.isDisplayed()) {
			noteshistoryListView.notesHistoryHashTagsHdr.click();
			
			//confirm the the panel was indeed expanded
			try {
				AssertJUnit.assertTrue(noteshistoryListView.notesHistoryHashTagsPnl.isDisplayed());
			}
			catch (Error e) {
				verificationErrors.append(methodID + "(): " + e.toString());
				System.out.println(methodID + ": Hash Tags panel failed to expand on panel header click; test aborted.");
				return;
			}
		}
		//collapse the Hash Tags sub-panel
		noteshistoryListView.notesHistoryHashTagsHdr.click();
		try {
			AssertJUnit.assertFalse(noteshistoryListView.notesHistoryHashTagsPnl.isDisplayed());
			System.out.println("VP: Hash Tags sub-panel collapse check - Passed");
			
			//re-expand the Hash Tags sub-panel
			noteshistoryListView.notesHistoryHashTagsHdr.click();
			try {
				AssertJUnit.assertTrue(noteshistoryListView.notesHistoryHashTagsPnl.isDisplayed());
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
		commNav.rightClickContextMenuItem("my-history");
		commNav.rightClickContextMenuItem("note");
		commNav.rightClickContextMenuItem("phonecall");
		commNav.rightClickContextMenuItem("meeting");
		commNav.rightClickContextMenuItem("personal");
		commNav.rightClickContextMenuItem("email");
		
		//Step: go back to previous screen
		headerButton.goBack();
		Thread.sleep(3000);
		
		System.out.println(ENDLINE);
	}

	@Test(enabled = true)
	public void test11_SeTestTCNotesHistoryListViewKPI() throws Exception {
		String methodID = "test11_SeTestTCNotesHistoryListViewKPI";
		
		// Test Params:
		String entityType = "Notes/History";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);

        //Step: logout & log back in (to clear cookies)
        LogOutThenLogBackIn(userName, userPwd);
		
	    //Step: navigate to Notes/History list view...
		commNav.clickGlobalMenuItem(entityType);
		
		NotesHistoryViewsElements notesHistoryListView = PageFactory.initElements(driver, NotesHistoryViewsElements.class);
		
		//Step: reveal Right Context Menu panel
		headerButton.showRightContextMenu();
		
	    //Step: test the KPI header
		//expand the KPI sub-panel if it's currently collapsed
		if (!notesHistoryListView.notesHistoryKPIPnl.isDisplayed()) {
			notesHistoryListView.notesHistoryKPIHdr.click();
			
			//confirm the the panel was indeed expanded
			try {
				AssertJUnit.assertTrue(notesHistoryListView.notesHistoryKPIPnl.isDisplayed());
			}
			catch (Error e) {
				verificationErrors.append(methodID + "(): " + e.toString());
				System.out.println(methodID + ": Hash Tags panel failed to expand on panel header click; test aborted.");
				return;
			}
		}
		
		//collapse KPI Tags sub-panel check
		notesHistoryListView.notesHistoryKPIHdr.click();
		try {
			AssertJUnit.assertFalse(notesHistoryListView.notesHistoryKPIPnl.isDisplayed());
			System.out.println("VP: KPI sub-panel collapse check - Passed");
			
			//re-expand the KPI Tags sub-panel
			notesHistoryListView.notesHistoryKPIHdr.click();
			try {
				AssertJUnit.assertTrue(notesHistoryListView.notesHistoryKPIPnl.isDisplayed());
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
		commNav.rightClickContextMenuItem("Total History");
		commNav.rightClickContextMenuItem("Total Duration");
		
		//Step: go back to previous screen
		headerButton.closeRightContextMenu();
		headerButton.goBack();
		Thread.sleep(3000);
		
		System.out.println(ENDLINE);
	}

	@Test(enabled = true)
	public void test09_SeTestTCNotesHistoryAddEditView() throws Exception {
		String methodID = "test09_SeTestTCNotesHistoryAddEditView";
		
		// Test Params:
		String entityType = "Notes/History";
		String viewName = "Notes Add Edit view";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);

        //Step: logout & log back in (to clear cookies)
        LogOutThenLogBackIn(userName, userPwd);
		
		try {
			//Step: enter the Notes Add Edit view...
			commNav.entityRecordAdd(entityType);
			
			NotesHistoryViewsElements notesHistoryEditView = PageFactory.initElements(driver, NotesHistoryViewsElements.class);
			
			//Step: check each input field and if applicable, its related list item selection view
            commNav.isWebElementPresent(viewName + ", notes", notesHistoryEditView.notesHistoryEditViewNotesInputFld);
			commNav.isFieldValueEmpty(viewName + ", time", notesHistoryEditView.notesHistoryEditViewTimeInputFld);
			commNav.verifyEntityViewElementClick(viewName + ", regarding", notesHistoryEditView.notesHistoryEditViewRegardingFldBtn, "Note Description");			

			commNav.isWebElementPresent(viewName + ", for lead", notesHistoryEditView.notesHistoryEditViewForLeadToggleBtn);
			commNav.isFieldValueEmpty(viewName + ", account", notesHistoryEditView.notesHistoryEditViewAccountInputFld);			
			commNav.isFieldValueEmpty(viewName + " contact", notesHistoryEditView.notesHistoryEditViewContactInputFld);
			commNav.isWebElementPresent(viewName + ", opportunity", notesHistoryEditView.notesHistoryEditViewOpportunityInputFld);
			commNav.isWebElementPresent(viewName + " ticket", notesHistoryEditView.notesHistoryEditViewTicketInputFld);
			
			//end of test
			headerButton.clickHeaderButton("cancel");
		
			//Step: go back to previous screen
			headerButton.goBack();
			Thread.sleep(2000);
					
			
		}
		catch (Exception e) {
			verificationErrors.append(methodID + "(): " + e.toString());
			System.out.println(methodID + ": unable to open the Contact Add Edit view.");
		}
		
		System.out.println(ENDLINE);
	}

	@Test(enabled = true)
	public void test12_SeTestTCNotesHistoryListViewAddNote() throws Exception {
		String methodID = "test12_SeTestTCNotesHistoryListViewAddNote";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		//HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
		
		//Step: logout & log back in (to clear cookies)
		LogOutThenLogBackIn(userName, userPwd);
				
		NotesHistoryViewsElements notesHistoryListView = PageFactory.initElements(driver, NotesHistoryViewsElements.class);
		
		//Step: add a random test Note/History record
		String newNoteName = "AutoTestNote-" + new SimpleDateFormat("yyMMddHHmm").format(new GregorianCalendar().getTime());
		String strRegardingVal = "Technical notes";
		notesHistoryListView.doAddRandTestNote(strRegardingVal, newNoteName, false, "Above Marine");
		
		//Step: find the newly-added test Note record
		String strResultsMsg = "VP: recently added test Note '" + newNoteName + "' was found.";
        WebElement entityListItem = commNav.entityListViewSearch("Notes/History", strRegardingVal);
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
}
