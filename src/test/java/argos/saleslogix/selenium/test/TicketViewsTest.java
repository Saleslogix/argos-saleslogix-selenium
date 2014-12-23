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
 * Class: TicketViewsTest
 * Desc.: Test class for the Ticket record views
 */
public class TicketViewsTest extends BaseTest {
	
	public String TEST_TICKET_RECORD = "001-00-000014";
	
	//Test Methods Set
	//================
	@Test(enabled = true)
	public void test01_SeTestTCTicketListView() throws Exception {
		//Reference: MBL-10049
		String methodID = "test01_SeTestTCTicketListView";
		
		// Test Params:
		String entityType = "Tickets";
		String expEntityPgTitle = "Tickets";
		String ticketRecord = TEST_TICKET_RECORD;
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerbutton = PageFactory.initElements(driver, HeaderButton.class);
	
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
		
	    //Step: click Top-Left button to reveal Global Menu...
		headerbutton.showGlobalMenu();
	
	    //Step: navigate to Ticket list view...
		commNav.entityListViewSearch(entityType, ticketRecord);
		
		//Step: test Ticket, List View page elements
		if (commNav.isPageDisplayed(entityType)) {
			
			TicketViewsElements ticketsListView = PageFactory.initElements(driver, TicketViewsElements.class);			
			
			//Step: check the Ticket list view format
			commNav.checkIfWebElementPresent("Ticket List View", ticketsListView.ticketsListView);
			
			//Step: check an Opportunity list view item record
			commNav.checkIfWebElementPresent("Ticket List View, item record", ticketsListView.topTicketsListItem);
			commNav.checkIfWebElementPresent("Ticket List View, item record Icon", ticketsListView.topTicketsListItemIcon);
			commNav.checkIfWebElementPresent("Ticket List View, item record Number", ticketsListView.topTicketsListItemNumber);
			commNav.checkIfWebElementPresent("Ticket List View, item record Contact & Account", ticketsListView.topTicketsListItemLine2);
			commNav.checkIfWebElementPresent("Ticket List View, item record Assigned To", ticketsListView.topTicketsListItemLine3);
			commNav.checkIfWebElementPresent("Ticket List View, item record Status Info", ticketsListView.topTicketsListItemLine4);
			commNav.checkIfWebElementPresent("Ticket List View, item record Area, Cateogry & Issue", ticketsListView.topTicketsListItemLine5);
            commNav.checkIfWebElementPresent("Ticket List View, item record Touch Icon", ticketsListView.topTicketsListItemTouch);
			//TODO: add coverage for ToDo icon check after figuring out the css id
			
			//Step: check the Quick Action button and items
			try {
				//click list item icon to reveal Quick Action items
				ticketsListView.topTicketsListItemIcon.click();
				
				//click the Quick Action button, then check each of the Quick Action items
				commNav.checkIfWebElementPresent("Ticket, Quick Action Add Attachment button", ticketsListView.topTicketsListItemQuickActionsAddAttachmentBtn);
				commNav.checkIfWebElementPresent("Ticket, Quick Action Add Activity button", ticketsListView.topTicketsListItemQuickActionsAddActivityBtn);
				commNav.checkIfWebElementPresent("Ticket, Quick Action Add Note button", ticketsListView.topTicketsListItemQuickActionsAddNoteBtn);
				commNav.checkIfWebElementPresent("Ticket, Quick Action Contacts button", ticketsListView.topTicketsListItemQuickActionsContactBtn);
				commNav.checkIfWebElementPresent("Ticket, Quick Action Accounts button", ticketsListView.topTicketsListItemQuickActionsAccountBtn);
				commNav.checkIfWebElementPresent("Ticket, Quick Action Edit button", ticketsListView.topTicketsListItemQuickActionsEditBtn);
				
				//click list item icon to hide the Quick Action items
				ticketsListView.topTicketsListItemIcon.click();
			}
			catch (Exception e) {
				System.out.println(e.toString());				
			}
			
			//Step: check the "X records remaining" item box at the bottom of the list view
			//commNav.checkIfWebElementPresent("Opportunity List View, 'x remaining records' item", accountListView.recordsRemainingListItem);
		}
		else {
			System.out.println(methodID + ": required '" + expEntityPgTitle + "' not loaded; test aborted");
		}
		System.out.println(ENDLINE);
	}

	
	@Test(enabled = false)
	public void test13_SeTestTCTicketListViewNotesBox() throws Exception {
		//Reference: MBL-10042
		String methodID = "test13_SeTestTCTicketListViewNotesBox";
		
		// Test Params:
		String entityType = "Tickets";
		String expEntityPgTitle = "Tickets";
		String entityRecord = TEST_TICKET_RECORD;
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);
	
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);

        //Step: logout & log back in (to clear cookies)
        LogOutThenLogBackIn(userName, userPwd);
	
	    //Step: navigate to Tickets list view...
		commNav.entityListViewSearch(entityType, entityRecord);
		
		//Step: test Tickets, List View page elements
		// SubStep: check the Page Title
		if (commNav.isPageDisplayed(entityType)) {
			
			TicketViewsElements ticketsListView = PageFactory.initElements(driver, TicketViewsElements.class);			
			
			//Step: check the Tickets list view format
			commNav.checkIfWebElementPresent("Tickets List View", ticketsListView.ticketsListViewPnl);
			
			//Step: check an Account list view item record
			commNav.checkIfWebElementPresent("Tickets List View, Notes Box", ticketsListView.ticketsListViewNotesBox1stItem);			
			commNav.checkIfWebElementPresent("Tickets List View, Notes Box item, Initials box", ticketsListView.ticketsListViewNotesBox1stItemInitialsBox);			
			commNav.checkIfWebElementPresent("Tickets List View, Notes Box item, Regarding header", ticketsListView.ticketsListViewNotesBox1stItemRegarding);			
			commNav.checkIfWebElementPresent("Tickets List View, Notes Box item, Last Activity note", ticketsListView.ticketsListViewNotesBox1stItemLastActivity);			
			commNav.checkIfWebElementPresent("Tickets List View, Notes Box item, note item", ticketsListView.ticketsListViewNotesBox1stItemNotes);			
			commNav.checkIfWebElementPresent("Tickets List View, Notes Box item, see list link", ticketsListView.ticketsListViewNotesBoxSeeListLink);
			
			//Step: check the Notes Box list item click navigation
			String expPgTitle = "Meeting";
			String resultsMsg = "VP: Clicking Notes Box item navigated to the expected page";
			try {
				//click the 1st Notes Box item
				ticketsListView.ticketsListViewNotesBox1stItem.click();
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
			
			ticketsListView = PageFactory.initElements(driver, TicketViewsElements.class);
			
			//Step: check the Notes Box 'see list' link click navigation
			expPgTitle = "Notes";
			resultsMsg = "VP: Clicking Notes Box 'see list' link navigated to the expected page";
			try {
				//click the Notes Box 'see list' link
				ticketsListView.ticketsListViewNotesBoxSeeListLink.click();
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


	@Test(enabled = true)
	public void test02_SeTestTCTicketListViewLoadMoreResults() throws Exception {
		String methodID = "test02_SeTestTCTickettListViewLoadMoreResults";
		
		//Test Params:
		String entityType = "tickets";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerbutton = PageFactory.initElements(driver, HeaderButton.class);
        CommonViewsElements commView = PageFactory.initElements(driver, CommonViewsElements.class);
		TicketViewsElements ticketListView = PageFactory.initElements(driver, TicketViewsElements.class);
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
		
		//Step: logout & log back in (to clear cookies)
		LogOutThenLogBackIn(userName, userPwd);
		
	    //Step: click Top-Left button to reveal Global Menu...
		headerbutton.showGlobalMenu();
	
	    //Step: navigate to Tickets list view... and wait for page to open
		commNav.clickGlobalMenuItem(entityType);
        commNav.waitForPage("Tickets");
	
		//Step: click the clear Search input field button
		//ticketListView.ticketsSearchClearBtn.click();
        commView.lookupTxtBox.click();
        Thread.sleep(500);
        commView.lookupTxtBox.sendKeys(Keys.BACK_SPACE);
        Thread.sleep(500);
						
		//Step: click the Lookup button to reload the full Tickets list
		//ticketListView.ticketsSearchLookupBtn.click();
        commView.lookupTxtBox.sendKeys(Keys.RETURN);
		Thread.sleep(3000);
		
		//capture the initial Tickets List view info
		String initTicketsListInfo = ticketListView.getTicketsListViewTxt();
		
	    //Step: load more results (click on 'x remaining records' item)
		for (int count = 1; count<3; count++) {
			JavascriptExecutor jsx = (JavascriptExecutor)driver;
			jsx.executeScript("window.scrollBy(0,450)", "");
		}
		
		//capture the expanded Tickets List view
		String expandedTicketsListInfo = ticketListView.getTicketsListViewTxt();
		
		//VP: confirm that the Tickets List view is indeed expanded with more record data
		String resultMsg = "VP: scrolling down the Tickets List view loaded more records";
		try {
			AssertJUnit.assertFalse(initTicketsListInfo.matches(expandedTicketsListInfo));
			System.out.println(resultMsg + " - PASSED");
		}
		catch (Error e) {
			verificationErrors.append(e.toString());
			System.out.println(resultMsg + " - FAILED");
		}
		
		System.out.println(ENDLINE);
	}


	@Test(enabled = true)
	public void test03_SeTestTCTicketListViewSearch() throws Exception {
		String methodID = "test03_SeTestTCTicketListViewSearch";
		
		// Test Params:
		String entityType = "Tickets";
		String entityRecord = TEST_TICKET_RECORD;	
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
				
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
		
		//Step: search for an existing Ticket record
		commNav.entityListViewSearch(entityType, entityRecord);
		
		System.out.println(ENDLINE);
	}


	@Test(enabled = true)
	public void test04_SeTestTCTicketListViewNegativeSearch() throws Exception {
		String methodID = "test04_SeTestTCTicketListViewNegativeSearch";
		
		//Test Params:
		String entityType = "tickets";
				
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
				
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
		
		//Step: search for non-existent Ticket record to confirm it's non-existence
		commNav.entityListViewNegativeSearch(entityType, "Non-Existent Ticket");		
		
		System.out.println(ENDLINE);
	}


	@Test(enabled = true)
	public void test05_SeTestTCTicketListViewClearSearch() throws Exception {
		String methodID = "test05_SeTestTCTicketListViewClearSearch";
		
		// Test Params:
		String entityType = "Tickets";
		String entityRecord = TEST_TICKET_RECORD;
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);
        CommonViewsElements commView = PageFactory.initElements(driver, CommonViewsElements.class);
        TicketViewsElements ticketListView = PageFactory.initElements(driver, TicketViewsElements.class);
	
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
	
		commNav.entityListViewSearch(entityType, entityRecord);
			
		//Step: check for matching results...
        String initTicketsListInfo = ticketListView.getTicketsListViewTxt();
				
		//Step: click the clear Search input field button
		//headerButton.showRightContextMenu();
		//ticketListView.ticketsSearchClearBtn.click();
        commView.lookupTxtBox.click();
        Thread.sleep(500);
        commView.lookupTxtBox.sendKeys(Keys.BACK_SPACE);
        Thread.sleep(500);
				
		//Step: click the Lookup button to reload the full Tickets list
		//ticketListView.ticketsSearchLookupBtn.click();
        commView.lookupTxtBox.sendKeys(Keys.RETURN);
		Thread.sleep(7000);
				
		//Step: check if the previous search results were cleared
        String expandedTicketsListInfo = ticketListView.getTicketsListViewTxt();

        try {
            AssertJUnit.assertFalse(initTicketsListInfo.matches(expandedTicketsListInfo));
            System.out.println(methodID + ": clear previous Tickets search results action PASSED");
        } catch (Error e) {
            verificationErrors.append(methodID + "(): " + e.toString());
            System.out.println(methodID + ": clear previous Tickets search results action FAILED");
        }
		
		System.out.println(ENDLINE);
	}


	@Test(enabled = true)
	public void test06_SeTestTCTicketListViewOpenRecord() throws Exception {
		String methodID = "test06_SeTestTCTicketListViewOpenRecord";
		
		// Test Params:
		String entityType = "Tickets";
		String entityRecord = TEST_TICKET_RECORD;
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);

        //Step: logout & log back in (to clear cookies)
        LogOutThenLogBackIn(userName, userPwd);
		
		try {
			//Step: search for Ticket entity, then open it's Detail view
			commNav.entityRecordOpenDetailView(entityType, entityRecord);
			
			//Step: go back to previous screen
			headerButton.goBack();
			Thread.sleep(3000);
		}
		catch (Exception e) {
			verificationErrors.append(e.toString());
		}
		
		System.out.println(ENDLINE);
	}


	@Test(enabled = true)
	public void test07_SeTestTCTicketDetailView() throws Exception {
		String methodID = "test07_SeTestTCTicketDetailView";
		
		// Test Params:
		String entityType = "Tickets";
		String entityRecord = TEST_TICKET_RECORD;
		String viewName = "Ticket Detail view";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);
				
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
		
		//Step: logout & log back in (to clear cookies)
		LogOutThenLogBackIn(userName, userPwd);
		
		try {
			//Step: search for Ticket entity, then open it's Detail view
			commNav.entityRecordOpenDetailView(entityType, entityRecord);
			
			TicketViewsElements ticketDetailView = PageFactory.initElements(driver, TicketViewsElements.class);
			
			//Step: check each item under the Ticket Detail View, Quick Actions section
			commNav.isWebElementPresent(viewName + ",'Quick Actions' section header", ticketDetailView.ticketsDetailViewQuickActionsHdr);			
			commNav.verifyEntityViewElementClick(viewName + ",'Schedule activity'", ticketDetailView.ticketsDetailViewScheduleActivityLnk, "Schedule...");

            //Step: conditionally expand the More Details section
            if (ticketDetailView.ticketsDetailViewMoreDetailsFields.getSize().height < 1) {
                ticketDetailView.ticketsDetailViewMoreDetailsHdr.click();
                Thread.sleep(1000);
            }

			//Step: check each item under the Ticket Detail View, Details section
			commNav.isWebElementPresent(viewName + ",'Details' section header", ticketDetailView.ticketsDetailViewDetailsHdr);
			commNav.isFieldValueEmpty(viewName + ",'account'", ticketDetailView.ticketsDetailViewAccountFld);
			commNav.isFieldValueEmpty(viewName + ",'contact'", ticketDetailView.ticketsDetailViewContactFld);
            commNav.isFieldValueEmpty(viewName + ",'assigned to'", ticketDetailView.ticketsDetailViewAssignedToFld);
            commNav.isFieldValueEmpty(viewName + ",'urgency'", ticketDetailView.ticketsDetailViewUrgencyFld);
            commNav.isFieldValueEmpty(viewName + ",'needed date'", ticketDetailView.ticketsDetailViewNeededDateFld);

	
			//Step: check each item under the Ticket Detail View, More Details section
			commNav.isWebElementPresent(viewName + ",'More Details' section header", ticketDetailView.ticketsDetailViewMoreDetailsHdr);
            commNav.isFieldValueEmpty(viewName + ",'area'", ticketDetailView.ticketsDetailViewAreaFld);
            commNav.isFieldValueEmpty(viewName + ",'category'", ticketDetailView.ticketsDetailViewCategoryFld);
            commNav.isFieldValueEmpty(viewName + ",'issue'", ticketDetailView.ticketsDetailViewIssueFld);
            commNav.isFieldValueEmpty(viewName + ",'subject'", ticketDetailView.ticketsDetailViewSubjectFld);
            commNav.isFieldValueEmpty(viewName + ",'description'", ticketDetailView.ticketsDetailViewDescriptionFld);
            commNav.isFieldValueEmpty(viewName + ",'status'", ticketDetailView.ticketsDetailViewStatusFld);
            commNav.isFieldValueEmpty(viewName + ",'completed by'", ticketDetailView.ticketsDetailViewCompletedByFld);
			commNav.isFieldValueEmpty(viewName + ",'contract'", ticketDetailView.ticketsDetailViewContractFld);
			commNav.isFieldValueEmpty(viewName + ",'source'", ticketDetailView.ticketsDetailViewSourceFld);
			commNav.isFieldValueEmpty(viewName + ",'assigned date'", ticketDetailView.ticketsDetailViewAssignedDateFld);
			commNav.isFieldValueEmpty(viewName + ",'resolution'", ticketDetailView.ticketsDetailViewResolutionFld);
			commNav.isFieldValueEmpty(viewName + ",'comments'", ticketDetailView.ticketsDetailViewCommentsFld);
	
			//Step: check each item under the Ticket Detail View, Related Items section
			commNav.isWebElementPresent(viewName + ",'Related Items' section header", ticketDetailView.ticketsDetailViewRelatedItemsHdr);
			commNav.verifyEntityViewElementClick(viewName + ",'Activities'", ticketDetailView.ticketsDetailViewActivitiesLnk, "Activities");
			commNav.verifyEntityViewElementClick(viewName + ",'Ticket Activities'", ticketDetailView.ticketsDetailViewTicketsActivitiesLnk, "Ticket Activities");
			commNav.verifyEntityViewElementClick(viewName + ",'Attachments'", ticketDetailView.ticketsDetailViewAttachmentsLnk, "Ticket Attachments");
		}
		catch (Exception e) {
			verificationErrors.append(e.toString());
			System.out.println(methodID + ": the Ticket Detail view for the '" + entityRecord + "' Ticket record; test aborted.");
		}
				
		//Step: go back to previous screen
		headerButton.goBack();
		commNav.waitForPage("Tickets");
		
		System.out.println(ENDLINE);
	}


	@Test(enabled = true)
	public void test08_SeTestTCTicketEditView() throws Exception {
		String methodID = "test08_SeTestTCTicketEditView";
		
		// Test Params:
		String entityType = "Ticket";
		String entityRecord = TEST_TICKET_RECORD;
		String viewName = "Ticket Edit view";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
		
		//Step: logout & log back in (to clear cookies)
		LogOutThenLogBackIn(userName, userPwd);
		
		try {
			//Step: search for Ticket entity, then open it's Edit view
			AssertJUnit.assertTrue(commNav.entityRecordEditView(entityType, entityRecord));
			
			TicketViewsElements ticketEditView = PageFactory.initElements(driver, TicketViewsElements.class);
			
			//Step: check each input field and if applicable, its related list item selection view
			commNav.isWebElementPresent(viewName + ", 'Details' section header", ticketEditView.ticketsEditViewDetailsHdr);
			commNav.verifyEntityViewElementClick(viewName + ",'account field'", ticketEditView.ticketsEditViewAccountFldBtn, "Accounts");
			commNav.verifyEntityViewElementClick(viewName + ",'contact field'", ticketEditView.ticketsEditViewContactFldBtn, "Contacts");
			commNav.verifyEntityViewElementClick(viewName + ",'contract field'", ticketEditView.ticketsEditViewContractFldBtn, "Contracts");			
			commNav.verifyEntityViewElementClick(viewName + ",'area field'", ticketEditView.ticketsEditViewAreaFldBtn, "Ticket Area");
			commNav.verifyEntityViewElementClick(viewName + ",'category field'", ticketEditView.ticketsEditViewCategoryFldBtn, "Ticket Category");
			commNav.verifyEntityViewElementClick(viewName + ",'issue field'", ticketEditView.ticketsEditViewIssueFldBtn, "Ticket Issue");
			commNav.verifyEntityViewElementClick(viewName + ",'source field'", ticketEditView.ticketsEditViewSourceFldBtn, "Source");
			commNav.verifyEntityViewElementClick(viewName + ",'status field'", ticketEditView.ticketsEditViewStatusFldBtn, "Ticket Status");
			commNav.verifyEntityViewElementClick(viewName + ",'urgency field'", ticketEditView.ticketsEditViewUrgencyFldBtn, "Ticket Urgency");
			commNav.verifyEntityViewElementClick(viewName + ",'needed date field'", ticketEditView.ticketsEditViewNeededDateFldBtn, "Calendar");
			commNav.verifyEntityViewElementClick(viewName + ",'assigned date field'", ticketEditView.ticketsEditViewAssignedDateFldBtn, "Calendar");
			commNav.verifyEntityViewElementClick(viewName + ",'assigned to field'", ticketEditView.ticketsEditViewAssignedToFldBtn, "Owners");
			
			
			commNav.isFieldValueEmpty(viewName + ", subject ", ticketEditView.ticketsEditViewSubjectInputFld);
			commNav.isFieldValueEmpty(viewName + ", description ", ticketEditView.ticketsEditViewDescInputFld);
			commNav.isFieldValueEmpty(viewName + ", resolution ", ticketEditView.ticketsEditViewResolutionInputFld);
			commNav.isFieldValueEmpty(viewName + ", comments ", ticketEditView.ticketsEditViewCommentsInputFld);
			
			
			//end of test
			headerButton.clickHeaderButton("cancel");
		
			//Step: go back to previous screen
			headerButton.goBack();
			Thread.sleep(2000);
		} catch (Error e) {
			verificationErrors.append(e.toString());
			System.out.println(methodID + ": unable to open locate the '" + entityRecord + "' " + entityType);		
		}
		
		System.out.println(ENDLINE);
	}


	@Test(enabled = true)
	public void test09_SeTestTCTicketAddEditView() throws Exception {
		String methodID = "test09_SeTestTCTicketAddEditView";
		
		// Test Params:
		String entityType = "ticket";
		String viewName = "Ticket Add Edit view";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);	
		
		//Step: logout & log back in (to clear cookies)
		LogOutThenLogBackIn(userName, userPwd);
		
		try {
			//Step: enter the Ticket Add Edit view...
			commNav.entityRecordAdd(entityType);
					
			TicketViewsElements ticketEditView = PageFactory.initElements(driver, TicketViewsElements.class);
			
			//Step: check each input field and if applicable, its related list item selection view
			commNav.isWebElementPresent(viewName + ", 'Details' section header", ticketEditView.ticketsEditViewDetailsHdr);
			commNav.verifyEntityViewElementClick(viewName + ",'account field'", ticketEditView.ticketsEditViewAccountFldBtn, "Accounts");
			commNav.verifyEntityViewElementClick(viewName + ",'contact field'", ticketEditView.ticketsEditViewContactFldBtn, "Contacts");
			commNav.verifyEntityViewElementClick(viewName + ",'contract field'", ticketEditView.ticketsEditViewContractFldBtn, "Contracts");
			
			//the following will fail for Area, Category, Issue
			//commNav.verifyEntityViewElementClick(viewName + ",'area field'", ticketEditView.ticketsEditViewAreaFldBtn, "Ticket Area");
			//commNav.verifyEntityViewElementClick(viewName + ",'category field'", ticketEditView.ticketsEditViewCategoryFldBtn, "Ticket Category");
			//commNav.verifyEntityViewElementClick(viewName + ",'issue field'", ticketEditView.ticketsEditViewIssueFldBtn, "Ticket Issue");
			
		    // the following checks the area, category, and issue fields without navigating to the associated selection listview
			// possibly change in the future to also open the listview
			commNav.isFieldValueEmpty(viewName + ",'area'", ticketEditView.ticketsEditViewAreaFld);
			commNav.isFieldValueEmpty(viewName + ",'category'", ticketEditView.ticketsEditViewCategoryFld);
			commNav.isFieldValueEmpty(viewName + ",'issue'", ticketEditView.ticketsEditViewIssueFld);
						
			
			commNav.verifyEntityViewElementClick(viewName + ",'source field'", ticketEditView.ticketsEditViewSourceFldBtn, "Source");
			commNav.verifyEntityViewElementClick(viewName + ",'status field'", ticketEditView.ticketsEditViewStatusFldBtn, "Ticket Status");
			commNav.verifyEntityViewElementClick(viewName + ",'urgency field'", ticketEditView.ticketsEditViewUrgencyFldBtn, "Ticket Urgency");
			commNav.verifyEntityViewElementClick(viewName + ",'needed date field'", ticketEditView.ticketsEditViewNeededDateFldBtn, "Calendar");
			commNav.verifyEntityViewElementClick(viewName + ",'assigned date field'", ticketEditView.ticketsEditViewAssignedDateFldBtn, "Calendar");
			commNav.verifyEntityViewElementClick(viewName + ",'assigned to field'", ticketEditView.ticketsEditViewAssignedToFldBtn, "Owners");
	
			commNav.isWebElementPresent(viewName + ", subject ", ticketEditView.ticketsEditViewSubjectInputFld);
			commNav.isWebElementPresent(viewName + ", description ", ticketEditView.ticketsEditViewDescInputFld);
			commNav.isWebElementPresent(viewName + ", resolution ", ticketEditView.ticketsEditViewResolutionInputFld);
			commNav.isWebElementPresent(viewName + ", comments ", ticketEditView.ticketsEditViewCommentsInputFld);
	
			
			//end of test
			headerButton.clickHeaderButton("cancel");
		
			//Step: go back to previous screen
			headerButton.goBack();
			Thread.sleep(2000);
		}
		catch (Exception e) {
			verificationErrors.append(e.toString());
			System.out.println(methodID + ": unable to open the Ticket Edit Add view.");			
		}
		
		System.out.println(ENDLINE);
	}


	@Test(enabled = false)
	public void test10_SeTestTCTicketListViewHashTags() throws Exception {
		String methodID = "test10_SeTestTCTicketListViewHashTags";
		
		// Test Params:
		String entityType = "tickets";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
		
		//Step: logout & log back in (to clear cookies)
		LogOutThenLogBackIn(userName, userPwd);
		
	    //Step: navigate to Tickets list view...
		commNav.clickGlobalMenuItem(entityType);
		
		TicketViewsElements ticketsListView = PageFactory.initElements(driver, TicketViewsElements.class);
		
		//Step: reveal Right Context Menu panel
		headerButton.showRightContextMenu();
		
	    //Step: test the Hash Tags header
		//expand the Hash Tags sub-panel if it's currently collapsed
		if (!ticketsListView.ticketsHashTagsPnl.isDisplayed()) {
			ticketsListView.ticketsHashTagsHdr.click();
			
			//confirm the the panel was indeed expanded
			try {
				AssertJUnit.assertTrue(ticketsListView.ticketsHashTagsPnl.isDisplayed());
			}
			catch (Error e) {
				verificationErrors.append(e.toString());
				System.out.println(methodID + ": Hash Tags panel failed to expand on panel header click; test aborted.");
				return;
			}
		}
		//collapase the Hash Tags sub-panel
		ticketsListView.ticketsHashTagsHdr.click();
		try {
			AssertJUnit.assertFalse(ticketsListView.ticketsHashTagsPnl.isDisplayed());
			System.out.println("VP: Hash Tags sub-panel collapse check - Passed");
			
			//re-expand the Hash Tags sub-panel
			ticketsListView.ticketsHashTagsHdr.click();
			try {
				AssertJUnit.assertTrue(ticketsListView.ticketsHashTagsPnl.isDisplayed());
				System.out.println("VP: Hash Tags sub-panel expand check - Passed");
			}
			catch (Error e) {
				verificationErrors.append(e.toString());
				System.out.println("VP: Hash Tags sub-panel expand check - FAILED");
			}
		}
		catch (Error e) {
			verificationErrors.append(e.toString());
			System.out.println("VP: Hash Tags sub-panel collapse check - FAILED");
		}
		
		//Step: test each of the pre-set Hash Tag items
		commNav.rightClickContextMenuItem("assigned-to-me");
		commNav.rightClickContextMenuItem("completed-by-me");
		
		
		//Step: go back to previous screen
		headerButton.goBack();
		Thread.sleep(3000);
		
		System.out.println(ENDLINE);
	}


	@Test(enabled = true)
	public void test11_SeTestTCTicketListViewKPI() throws Exception {
		String methodID = "test11_SeTestTCTicketListViewKPI";
		
		// Test Params:
		String entityType = "tickets";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
		
		//Step: logout & log back in (to clear cookies)
		LogOutThenLogBackIn(userName, userPwd);
		
	    //Step: navigate to Tickets list view...
		commNav.clickGlobalMenuItem(entityType);
		
		TicketViewsElements ticketsListView = PageFactory.initElements(driver, TicketViewsElements.class);
		
		//Step: reveal Right Context Menu panel
		headerButton.showRightContextMenu();
		
	    //Step: test the KPI header
		//expand the KPI sub-panel if it's currently collapsed
		if (!ticketsListView.ticketsKPIPnl.isDisplayed()) {
			ticketsListView.ticketsKPIHdr.click();
			
			//confirm the the panel was indeed expanded
			try {
				AssertJUnit.assertTrue(ticketsListView.ticketsKPIPnl.isDisplayed());
			}
			catch (Error e) {
				verificationErrors.append(e.toString());
				System.out.println(methodID + ": KPI panel failed to expand on panel header click; test aborted.");
				return;
			}
		}
		//collapse KPI sub-panel check
		ticketsListView.ticketsKPIHdr.click();
		try {
			AssertJUnit.assertFalse(ticketsListView.ticketsKPIPnl.isDisplayed());
			System.out.println("VP: KPI sub-panel collapse check - Passed");
			
			//re-expand the KPI sub-panel
			ticketsListView.ticketsKPIHdr.click();
			try {
				AssertJUnit.assertTrue(ticketsListView.ticketsKPIPnl.isDisplayed());
				System.out.println("VP: KPI sub-panel expand check - Passed");
			}
			catch (Error e) {
				verificationErrors.append(e.toString());
				System.out.println("VP: KPI sub-panel e check - FAILED");
			}
		}
		catch (Error e) {
			verificationErrors.append(e.toString());
			System.out.println("VP: KPI sub-panel collapse check - FAILED");
		}
		
		//Step: re-enabled each of the KPI items		
		commNav.rightClickContextMenuItem("Total Tickets");
		commNav.scrollDownPage();
		commNav.rightClickContextMenuItem("Open Age Average");
		headerButton.closeRightContextMenu();
		Thread.sleep(500);
		
		//Step: go back to previous screen
		headerButton.goBack();
		Thread.sleep(5000);
		
		System.out.println(ENDLINE);
	}
}
