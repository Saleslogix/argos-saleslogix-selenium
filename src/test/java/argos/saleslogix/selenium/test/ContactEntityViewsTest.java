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
	
	//Test Methods Set
	//================
	@Test(enabled = true)
	public void test01_SeTestTCContactListView() throws Exception {
		String methodID = "test01_SeTestTCContactListView";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerbutton = PageFactory.initElements(driver, HeaderButton.class);
		
		// Test Params:
		String entityType = "Contacts";
		String entityRecord = "Adi, Douglas";
	
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
		String resultMsg = "VP: scrolling down the Contacts List view loaded more records";
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
	@Test(enabled = true)
	public void test03_SeTestTCContactListViewSearch() throws Exception {
		String methodID = "test03_SeTestTCContactListViewSearch";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
		
		//Step: search for an existing Account record
		commNav.entityListViewSearch("Contacts", "Adi, Douglas");
		//commNav.entityListViewSearch("Contacts", "Non-Existent Account");		//debug test
		
		System.out.println(ENDLINE);
	}

	//TODO: complete test04_SeTestTCContactListViewNegativeSearch for Contacts
	@Test(enabled = true)
	public void test04_SeTestTCContactListViewNegativeSearch() throws Exception {
		String methodID = "test04_SeTestTCContactListViewNegativeSearch";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
		
		//Step: search for non-existent Contact record to confirm it's non-existence
		commNav.entityListViewNegativeSearch("Contacts", "Non-Existent Contact");		
		
		System.out.println(ENDLINE);
	}

	//TODO: complete test05_SeTestTCContactListViewClearSearch for Contacts
	@Test(enabled = true)
	public void test05_SeTestTCContactListViewClearSearch() throws Exception {
		String methodID = "test05_SeTestTCContactListViewClearSearch";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);
	
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
	
		commNav.entityListViewSearch("Contacts", "Adi, Douglas");
			
		//Step: check for matching results...
		ContactViewsElements contactsListView = PageFactory.initElements(driver, ContactViewsElements.class);
		String topAccountListItemName = contactsListView.topContactsListItemName.getText();
				
		//Step: click the clear Search input field button
		headerButton.showRightContextMenu();
		contactsListView.contactsSearchClearBtn.click();
				
		//Step: click the Lookup button to reload the full Contacts list
		contactsListView.contactsSearchLookupBtn.click();
		Thread.sleep(3000);
				
		//Step: check if the previous search results were cleared
		String currTopContactsListViewName = driver.findElement(By.xpath("//*[@id='contact_list']/ul/li[1]/div/h3")).getText();
		try {
			AssertJUnit.assertEquals(topAccountListItemName, currTopContactsListViewName);
		} catch (Error e) {
			verificationErrors.append(e.toString());
			System.out.println(methodID + ": clear previous Contacts search results action failed");
			return;
		}
		
		System.out.println(methodID + ": clear previous Contacts search results action was successful");
		System.out.println(ENDLINE);
	}


	//TODO: complete test06_SeTestTCContactListViewOpenRecord for Contacts
	@Test(enabled = true)
	public void test06_SeTestTCContactListViewOpenRecord() throws Exception {
		String methodID = "test06_SeTestTCContactListViewOpenRecord";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
		
		//Step: search for Contact entity, then open it's Detail view
		commNav.entityRecordOpenDetailView("Contacts", "Adi, Douglas");
		
		//Step: go back to previous screen
		headerButton.goBack();
		Thread.sleep(3000);
		
		System.out.println(ENDLINE);
	}

	//TODO: complete test07_SeTestTCContactDetailView for Contacts
	@Test(enabled = true)
	public void test07_SeTestTCContactDetailView() throws Exception {
		String methodID = "test07_SeTestTCContactDetailView";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);
		
		//Test Parameters:
		String contactRecord = "Adi, Douglas";
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
		
		//Step: search for Account entity, then open it's Detail view
		if (commNav.entityRecordOpenDetailView("Contacts", contactRecord)) {
			
			ContactViewsElements contactDetailView = PageFactory.initElements(driver, ContactViewsElements.class);
			
			//Step: check each item under the Contact Detail View, Quick Actions section
			commNav.isWebElementPresent("Contact Detail view, 'Quick Actions' section header", contactDetailView.contactsDetailViewQuickActionsHdr);
			commNav.isWebElementPresent("Contact Detail view, 'Call main number'", contactDetailView.contactsDetailViewCallMainNumberLnk);
			commNav.isWebElementPresent("Contact Detail view, 'Call mobile'", contactDetailView.contactsDetailViewCallMobileLnk);
			commNav.isWebElementPresent("Contact Detail view, 'Send email'", contactDetailView.contactsDetailViewSendEmailLnk);
			commNav.verifyEntityViewElementClick("Contact Detail view, 'Schedule activity'", contactDetailView.contactsDetailViewScheduleActivityLnk, "Schedule...");
			commNav.isWebElementPresent("Contact Detail view, 'Add note'", contactDetailView.contactsDetailViewAddNoteLnk);
			commNav.isWebElementPresent("Contact Detail view, 'View address'", contactDetailView.contactsDetailViewViewAddressLnk);
			
			//Step: check each item under the Contact Detail View, Details section
			commNav.isWebElementPresent("Contact Detail view, 'Details' section header", contactDetailView.contactsDetailViewDetailsHdr);
			commNav.isWebElementPresent("Contact Detail view, 'contact'", contactDetailView.contactsDetailViewContactFld);
			commNav.isWebElementPresent("Contact Detail view, 'account'", contactDetailView.contactsDetailViewAccountFld);
			commNav.isWebElementPresent("Contact Detail view, 'web'", contactDetailView.contactsDetailViewWebFld);
			commNav.isWebElementPresent("Contact Detail view, 'title'", contactDetailView.contactsDetailViewTitleFld);
	
			//Step: check each item under the Contact Detail View, More Details section
			commNav.isWebElementPresent("Contact Detail view, 'More Details' section header", contactDetailView.contactsDetailViewMoreDetailsHdr);
			//SubStep: conditionally expand the More Details section
			if (contactDetailView.contactsDetailViewMoreDetailsFields.getSize().height < 1) {
				contactDetailView.contactsDetailViewMoreDetailsHdr.click();
				Thread.sleep(1000);
			}
			commNav.isWebElementPresent("Contact Detail view, 'home phone'", contactDetailView.contactsDetailViewHomePhoneFld);
			commNav.isWebElementPresent("Contact Detail view, 'fax'", contactDetailView.contactsDetailViewFaxFld);
			commNav.isWebElementPresent("Contact Detail view, 'acct mgr'", contactDetailView.contactsDetailViewAcctMgrFld);
			commNav.isWebElementPresent("Contact Detail view, 'owner'", contactDetailView.contactsDetailViewOwnerFld);
			commNav.isWebElementPresent("Contact Detail view, 'cuisine'", contactDetailView.contactsDetailViewCuisineFld);
	
			//Step: check each item under the Contact Detail View, Related Items section
			commNav.isWebElementPresent("Contact Detail view, 'Related Items' section header", contactDetailView.contactsDetailViewRelatedItemsHdr);
			commNav.verifyEntityViewElementClick("Contact Detail view, 'Activities'", contactDetailView.contactsDetailViewActivitiesLnk, "Activities");
			commNav.verifyEntityViewElementClick("Contact Detail view, 'Opportunities'", contactDetailView.contactsDetailViewOpportunitiesLnk, "Opportunities");
			commNav.verifyEntityViewElementClick("Contact Detail view, 'Tickets'", contactDetailView.contactsDetailViewTicketsLnk, "Tickets");
			commNav.verifyEntityViewElementClick("Contact Detail view, 'Notes/History'", contactDetailView.contactsDetailViewNotesHistoryLnk, "Notes/History");
			commNav.verifyEntityViewElementClick("Contact Detail view, 'Addresses'", contactDetailView.contactsDetailViewAddressesLnk, "Addresses");
			commNav.verifyEntityViewElementClick("Contact Detail view, 'Attachments'", contactDetailView.contactsDetailViewAttachmentsLnk, "Attachments");
		}
		else {
			System.out.println(methodID + ": the Contact Detail view for the '" + contactRecord + "' Contact record; test aborted.");
		}
				
		//Step: go back to previous screen
		headerButton.goBack();
		commNav.waitForPage("Contacts");
		
		System.out.println(ENDLINE);
	}

	//TODO: complete test08_SeTestTCContactEditView for Contacts
	@Test(enabled = true)
	public void test08_SeTestTCContactEditView() throws Exception {
		String methodID = "test08_SeTestTCContactEditView";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);
		
		//Test Parameters:
		String contactRecord = "Adi, Douglas";
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
		
		//Step: search for Account entity, then open it's Detail view
		try {
			AssertJUnit.assertTrue(commNav.entityRecordEditView("Contact", contactRecord));
			
			//Step: check each input field and if applicable, its related list item selection view
			//TODO: complete this section by adding calls to verify each field and selection view (if applicable)
			
			//end of test
			headerButton.clickHeaderButton("cancel");
		
			//Step: go back to previous screen
			headerButton.goBack();
			Thread.sleep(2000);
		}
		catch (Exception e) {
			System.out.println(e.toString());
		}
		
		System.out.println(ENDLINE);
	}

	//TODO: complete test09_SeTestTCContactAddEditView for Contacts
	@Test(enabled = true)
	public void test09_SeTestTCContactAddEditView() throws Exception {
		String methodID = "test09_SeTestTCContactAddEditView";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);	
		
		// Test Params:
		String entityType = "Contact";
	
		//Step: enter the Contact Add Edit view...
		commNav.entityRecordAdd(entityType);
				
		//Step: go back to previous screens
		headerButton.clickHeaderButton("cancel");
		headerButton.goBack();
		Thread.sleep(2000);
		
		System.out.println(ENDLINE);
	}

	//TODO: complete test10_SeTestTCContactListViewHashTags for Contacts
	@Test(enabled = true)
	public void test10_SeTestTCContactListViewHashTags() throws Exception {
		String methodID = "test10_SeTestTCContactListViewHashTags";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);
		
		// Test Params:
		String entityType = "Contacts";
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
		
	    //Step: navigate to Contacts list view...
		commNav.clickGlobalMenuItem(entityType);
		
		ContactViewsElements contactsListView = PageFactory.initElements(driver, ContactViewsElements.class);
		
		//Step: reveal Right Context Menu panel
		headerButton.showRightContextMenu();
		
	    //Step: test the Hash Tags header
		//expand the Hash Tags sub-panel if it's currently collapsed
		if (!contactsListView.contactsHashTagsPnl.isDisplayed()) {
			contactsListView.contactsHashTagsHdr.click();
			
			//confirm the the panel was indeed expanded
			try {
				AssertJUnit.assertTrue(contactsListView.contactsHashTagsPnl.isDisplayed());
			}
			catch (Error e) {
				System.out.println(e.toString());
				System.out.println(methodID + ": Hash Tags panel failed to expand on panel header click; test aborted.");
				return;
			}
		}
		//collapase the Hash Tags sub-panel
		contactsListView.contactsHashTagsHdr.click();
		try {
			AssertJUnit.assertFalse(contactsListView.contactsHashTagsPnl.isDisplayed());
			System.out.println("VP: Hash Tags sub-panel collapse check - Passed");
			
			//re-expand the Hash Tags sub-panel
			contactsListView.contactsHashTagsHdr.click();
			try {
				AssertJUnit.assertTrue(contactsListView.contactsHashTagsPnl.isDisplayed());
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
	@Test(enabled = true)
	public void test11_SeTestTCContactListViewKPI() throws Exception {
		String methodID = "test11_SeTestTCContactListViewKPI";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);
		
		// Test Params:
		String entityType = "Contacts";
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
		
	    //Step: navigate to Contacts list view...
		commNav.clickGlobalMenuItem(entityType);
		
		ContactViewsElements contactsListView = PageFactory.initElements(driver, ContactViewsElements.class);
		
		//Step: reveal Right Context Menu panel
		headerButton.showRightContextMenu();
		
	    //Step: test the KPI header
		//expand the KPI sub-panel if it's currently collapsed
		if (!contactsListView.contactsKPIPnl.isDisplayed()) {
			contactsListView.contactsKPIHdr.click();
			
			//confirm the the panel was indeed expanded
			try {
				AssertJUnit.assertTrue(contactsListView.contactsHashTagsPnl.isDisplayed());
			}
			catch (Error e) {
				System.out.println(e.toString());
				System.out.println(methodID + ": Hash Tags panel failed to expand on panel header click; test aborted.");
				return;
			}
		}
		//collapse Hash Tags sub-panel check
		contactsListView.contactsKPIHdr.click();
		try {
			AssertJUnit.assertFalse(contactsListView.contactsKPIPnl.isDisplayed());
			System.out.println("VP: KPI sub-panel collapse check - Passed");
			
			//re-expand the Hash Tags sub-panel
			contactsListView.contactsKPIHdr.click();
			try {
				AssertJUnit.assertTrue(contactsListView.contactsKPIPnl.isDisplayed());
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
	@Test(enabled = true)
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
		String entityRecord = "Adi, Douglas";
	
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
	
	    //Step: navigate to Contacts list view...
		commNav.entityListViewSearch(entityType, entityRecord);
		
		//Step: test Contacts, List View page elements
		// SubStep: check the Page Title
		if (commNav.isPageDisplayed(entityType)) {
			
			ContactViewsElements contactsListView = PageFactory.initElements(driver, ContactViewsElements.class);			
			
			//Step: check the Contacts list view format
			commNav.checkIfWebElementPresent("Contacts List View", contactsListView.contactsListView);
			
			//Step: check an Account list view item record
			commNav.checkIfWebElementPresent("Contacts List View, Notes Box", contactsListView.contactsListViewNotesBox1stItem);			
			commNav.checkIfWebElementPresent("Contacts List View, Notes Box item, Initials box", contactsListView.contactsListViewNotesBox1stItemInitialsBox);			
			commNav.checkIfWebElementPresent("Contacts List View, Notes Box item, Regarding header", contactsListView.contactsListViewNotesBox1stItemRegarding);			
			commNav.checkIfWebElementPresent("Contacts List View, Notes Box item, Last Activity note", contactsListView.contactsListViewNotesBox1stItemLastActivity);			
			commNav.checkIfWebElementPresent("Contacts List View, Notes Box item, note item", contactsListView.contactsListViewNotesBox1stItemNotes);			
			commNav.checkIfWebElementPresent("Contacts List View, Notes Box item, see list link", contactsListView.contactsListViewNotesBoxSeeListLink);
			
			//Step: check the Notes Box list item click navigation
			String expPgTitle = "Meeting";
			String resultsMsg = "VP: Clicking Notes Box item navigated to the expected page";
			try {
				//click the 1st Notes Box item
				contactsListView.contactsListViewNotesBox1stItem.click();
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
			
			contactsListView = PageFactory.initElements(driver, ContactViewsElements.class);
			
			//Step: check the Notes Box 'see list' link click navigation
			expPgTitle = "Notes";
			resultsMsg = "VP: Clicking Notes Box 'see list' link navigated to the expected page";
			try {
				//click the Notes Box 'see list' link
				contactsListView.contactsListViewNotesBoxSeeListLink.click();
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
