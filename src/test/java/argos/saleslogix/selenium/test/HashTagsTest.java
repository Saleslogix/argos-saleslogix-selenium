package argos.saleslogix.selenium.test;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;


public class HashTagsTest extends BrowserSetup {
	
	CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);

	//Login & Logout
	//==============
	@Test(enabled = true)
	public void test00_Mobile_Login() throws InterruptedException {
		String methodID = "test00_Mobile_Login";
		
		SLXMobileLogin slxmobilelogin = PageFactory.initElements(driver, SLXMobileLogin.class);	
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);	
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
			assertTrue(driver.findElement(By.xpath(".//*[@id='myactivity_list']")).isDisplayed());
			System.out.println("VP: Successfully logged in to Mobile Client.");
		} catch (Error e) {
			closeAlert();
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
	
	
	public void accountHashTagSelectNSearchCheck(String hashTagName, String searchVal) throws Exception {
		String methodID = "accountHashTagSelectNSearchCheck";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);
		
		
	    //Step: navigate to Opportunity list view...
		commNav.clickGlobalMenuItem("Accounts");
		
		AccountViewsElements accountsListView = PageFactory.initElements(driver, AccountViewsElements.class);		
		
		//Step: reveal Right Context Menu panel
		headerButton.showRightContextMenu();
		prepHashTagsSubPanel();
		
		
		//SECTION 1:		
		//Step: test the Hash Tag item
		String hashTagVal = hashTagName.toLowerCase();
		String hashTagSearchVal = "#" + hashTagVal;
		
		//capture the initial Accounts List view text
		String beforeAccountListViewTxt = accountsListView.getAccountsListViewTxt();		
		
		//click the Hash Tag
		commNav.rightClickContextMenuItem(hashTagVal);
		String afterAccountListViewTxt = accountsListView.getAccountsListViewTxt();
		
		//compare the Account List
		String resultsMsg = "VP: '" + hashTagVal + "' Hash Tag successful load check";
		try {
			AssertJUnit.assertNotSame(beforeAccountListViewTxt, afterAccountListViewTxt);
			System.out.println(resultsMsg + " - Passed");
		}
		catch (Error e) {
			System.out.println(e.toString());
			System.out.println(resultsMsg + " - FAILED");
		}
		
		//SECTION 2:
		//Step: check the filled-in search input field value
		String resulstMsg = "VP: right-context menu search field value set to " + hashTagSearchVal;
		
		String accountSearchVal = accountsListView.accountsSearchTxtBox.getAttribute("value");
		try {
			AssertJUnit.assertEquals(hashTagSearchVal, accountSearchVal);
			System.out.println(resulstMsg + " - Passed");
		}
		catch (Error e) {
			System.out.println(e.toString());
			System.out.println(resulstMsg + " - FAILED; the actual value is '" + accountSearchVal + "'");
		}
		
		
		//SECTION 3:
		//Step: perform a account record search on the name fields
		String regardingFldSearchVal = searchVal;
		String resultMsg = "VP: account record search for account field with '" + regardingFldSearchVal;
		String hashTagRecSrch = hashTagSearchVal + " " + regardingFldSearchVal;
		
		commNav.searchListView("account", hashTagRecSrch);
		try {
			AssertJUnit.assertTrue(commNav.isTextPresentOnPage(regardingFldSearchVal));
			System.out.println(resultMsg + "' - Passed");
		}
		catch (Error e) {
			System.out.println(e.toString());
			System.out.println(resultMsg + "' - FAILED");
		}
	}

	
	public void contactHashTagSelectNSearchCheck(String hashTagName, String searchVal) throws Exception {
		String methodID = "contactHashTagSelectNSearchCheck";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);
		
		
	    //Step: navigate to Contacts list view...
		commNav.clickGlobalMenuItem("Contacts");
		
		ContactViewsElements contactsListView = PageFactory.initElements(driver, ContactViewsElements.class);		
		
		//Step: reveal Right Context Menu panel
		headerButton.showRightContextMenu();
		prepHashTagsSubPanel();
		
		
		//SECTION 1:		
		//Step: test the Hash Tag item
		String hashTagVal = hashTagName.toLowerCase();
		String hashTagSearchVal = "#" + hashTagVal;
		
		//capture the initial Contacts List view text
		String beforeContactListViewTxt = contactsListView.getContactsListViewTxt();		
		
		//click the Hash Tag
		commNav.rightClickContextMenuItem(hashTagVal);
		Thread.sleep(3000);
		String afterContactListViewTxt = contactsListView.getContactsListViewTxt();
		
		//compare the Contact List
		String resultsMsg = "VP: '" + hashTagVal + "' Hash Tag successful load check";
		try {
			AssertJUnit.assertNotSame(beforeContactListViewTxt, afterContactListViewTxt);
			System.out.println(resultsMsg + " - Passed");
		}
		catch (Error e) {
			System.out.println(e.toString());
			System.out.println(resultsMsg + " - FAILED");
		}
		
		//SECTION 2:
		//Step: check the filled-in search input field value
		String resulstMsg = "VP: right-context menu search field value set to " + hashTagSearchVal;
		
		String contactSearchVal = contactsListView.contactsSearchTxtBox.getAttribute("value");
		try {
			AssertJUnit.assertEquals(hashTagSearchVal, contactSearchVal);
			System.out.println(resulstMsg + " - Passed");
		}
		catch (Error e) {
			System.out.println(e.toString());
			System.out.println(resulstMsg + " - FAILED; the actual value is '" + contactSearchVal + "'");
		}
		
		
		//SECTION 3:
		//Step: perform a contact record search on a possible matching field value
		String fldSearchVal = searchVal;
		String resultMsg = "VP: contact record search for contact field with '" + fldSearchVal;
		String hashTagRecSrch = hashTagSearchVal + " " + fldSearchVal;
		
		commNav.searchListView("contact", hashTagRecSrch);
		try {
			AssertJUnit.assertTrue(commNav.isTextPresentOnPage(fldSearchVal));
			System.out.println(resultMsg + "' - Passed");
		}
		catch (Error e) {
			System.out.println(e.toString());
			System.out.println(resultMsg + "' - FAILED");
		}
	}
	
	
	public void leadHashTagSelectNSearchCheck(String hashTagName, String searchVal) throws Exception {
		String methodID = "leadHashTagSelectNSearchCheck";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);
		
		
	    //Step: navigate to Lead list view...
		commNav.clickGlobalMenuItem("Leads");
		
		LeadViewsElements leadsListView = PageFactory.initElements(driver, LeadViewsElements.class);		
		
		//Step: reveal Right Context Menu panel
		headerButton.showRightContextMenu();
		prepHashTagsSubPanel();
		
		
		//SECTION 1:		
		//Step: test the Hash Tag item
		String hashTagVal = hashTagName.toLowerCase();
		String hashTagSearchVal = "#" + hashTagVal;
		
		//capture the initial Lead List view text
		String beforeLeadListViewTxt = leadsListView.getLeadsListViewTxt();		
		
		//click the Hash Tag
		commNav.rightClickContextMenuItem(hashTagVal);
		Thread.sleep(3000);
		String afterLeadListViewTxt = leadsListView.getLeadsListViewTxt();
		
		//compare the Contact List
		String resultsMsg = "VP: '" + hashTagVal + "' Hash Tag successful load check";
		try {
			AssertJUnit.assertNotSame(beforeLeadListViewTxt, afterLeadListViewTxt);
			System.out.println(resultsMsg + " - Passed");
		}
		catch (Error e) {
			System.out.println(e.toString());
			System.out.println(resultsMsg + " - FAILED");
		}
		
		//SECTION 2:
		//Step: check the filled-in search input field value
		String resulstMsg = "VP: right-context menu search field value set to " + hashTagSearchVal;
		
		String leadSearchVal = leadsListView.leadsSearchTxtBox.getAttribute("value");
		try {
			AssertJUnit.assertEquals(hashTagSearchVal, leadSearchVal);
			System.out.println(resulstMsg + " - Passed");
		}
		catch (Error e) {
			System.out.println(e.toString());
			System.out.println(resulstMsg + " - FAILED; the actual value is '" + leadSearchVal + "'");
		}
		
		
		//SECTION 3:
		//Step: perform a lead record search on a possible matching field value
		String fldSearchVal = searchVal;
		String resultMsg = "VP: contact record search for lead field with '" + fldSearchVal;
		String hashTagRecSrch = hashTagSearchVal + " " + fldSearchVal;
		
		commNav.searchListView("lead", hashTagRecSrch);
		try {
			AssertJUnit.assertTrue(commNav.isTextPresentOnPage(fldSearchVal));
			System.out.println(resultMsg + "' - Passed");
		}
		catch (Error e) {
			System.out.println(e.toString());
			System.out.println(resultMsg + "' - FAILED");
		}
	}

		
	public void notesHistoryHashTagSelectNSearchCheck(String hashTagName, String searchVal) throws Exception {
		String methodID = "notesHistoryHashTagSelectNSearchCheck";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);
		
		
	    //Step: navigate to Notes/History list view...
		commNav.clickGlobalMenuItem("Notes/History");
		
		NotesHistoryViewsElements notesHistoryListView = PageFactory.initElements(driver, NotesHistoryViewsElements.class);		
		
		//Step: reveal Right Context Menu panel
		headerButton.showRightContextMenu();
		prepHashTagsSubPanel();
		
		
		//SECTION 1:		
		//Step: test the Hash Tag item
		String hashTagVal = hashTagName.toLowerCase();
		String hashTagSearchVal = "#" + hashTagVal;
		
		//capture the initial Notes/History List view text
		String beforeNotesHistoryListViewTxt = notesHistoryListView.getNotesHistoryListViewTxt();		
		
		//click the Hash Tag
		commNav.rightClickContextMenuItem(hashTagVal);
		String afterNotesHistoryListViewTxt = notesHistoryListView.getNotesHistoryListViewTxt();
		
		//compare the Notes History List
		String resultsMsg = "VP: '" + hashTagVal + "' Hash Tag successful load check";
		try {
			AssertJUnit.assertNotSame(beforeNotesHistoryListViewTxt, afterNotesHistoryListViewTxt);
			System.out.println(resultsMsg + " - Passed");
		}
		catch (Error e) {
			System.out.println(e.toString());
			System.out.println(resultsMsg + " - FAILED");
		}
		
		//SECTION 2:
		//Step: check the filled-in search input field value
		String resulstMsg = "VP: right-context menu search field value set to " + hashTagSearchVal;
		
		String notesHistorySearchVal = notesHistoryListView.notesHistorysSearchTxtBox.getAttribute("value");
		try {
			AssertJUnit.assertEquals(hashTagSearchVal, notesHistorySearchVal);
			System.out.println(resulstMsg + " - Passed");
		}
		catch (Error e) {
			System.out.println(e.toString());
			System.out.println(resulstMsg + " - FAILED; the actual value is '" + notesHistorySearchVal + "'");
		}
		
		
		//SECTION 3:
		//Step: perform a notes/history record search on the Regarding field
		String regardingFldSearchVal = searchVal;
		String resultMsg = "VP: notes/history note search for Regarding field with '" + regardingFldSearchVal;
		String hashTagRecSrch = hashTagSearchVal + " " + regardingFldSearchVal;
		
		commNav.searchListView("notes/history", hashTagRecSrch);
		try {
			AssertJUnit.assertTrue(commNav.isTextPresentOnPage(regardingFldSearchVal));
			System.out.println(resultMsg + "' - Passed");
		}
		catch (Error e) {
			System.out.println(e.toString());
			System.out.println(resultMsg + "' - FAILED");
		}
	}

	
	public void opportunityHashTagSelectNSearchCheck(String hashTagName, String searchVal) throws Exception {
		String methodID = "opportunityHashTagSelectNSearchCheck";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);
		
		
	    //Step: navigate to Opportunity list view...
		commNav.clickGlobalMenuItem("Opportunity");
		
		OpportunityViewsElements opportunityListView = PageFactory.initElements(driver, OpportunityViewsElements.class);		
		
		//Step: reveal Right Context Menu panel
		headerButton.showRightContextMenu();
		prepHashTagsSubPanel();
		
		
		//SECTION 1:		
		//Step: test the Hash Tag item
		String hashTagVal = hashTagName.toLowerCase();
		String hashTagSearchVal = "#" + hashTagVal;
		
		//capture the initial Notes/History List view text
		String beforeOpportunityListViewTxt = opportunityListView.getOpportunityListViewTxt();		
		
		//click the Hash Tag
		commNav.rightClickContextMenuItem(hashTagVal);
		String afterOpportunityListViewTxt = opportunityListView.getOpportunityListViewTxt();
		
		//compare the Opportunity List
		String resultsMsg = "VP: '" + hashTagVal + "' Hash Tag successful load check";
		try {
			AssertJUnit.assertNotSame(beforeOpportunityListViewTxt, afterOpportunityListViewTxt);
			System.out.println(resultsMsg + " - Passed");
		}
		catch (Error e) {
			System.out.println(e.toString());
			System.out.println(resultsMsg + " - FAILED");
		}
		
		//SECTION 2:
		//Step: check the filled-in search input field value
		String resulstMsg = "VP: right-context menu search field value set to " + hashTagSearchVal;
		
		String opportunitySearchVal = opportunityListView.opportunitySearchTxtBox.getAttribute("value");
		try {
			AssertJUnit.assertEquals(hashTagSearchVal, opportunitySearchVal);
			System.out.println(resulstMsg + " - Passed");
		}
		catch (Error e) {
			System.out.println(e.toString());
			System.out.println(resulstMsg + " - FAILED; the actual value is '" + opportunitySearchVal + "'");
		}
		
		
		//SECTION 3:
		//Step: perform a opportunity record search on the Regarding field
		String regardingFldSearchVal = searchVal;
		String resultMsg = "VP: opportunity record search for Regarding field with '" + regardingFldSearchVal;
		String hashTagRecSrch = hashTagSearchVal + " " + regardingFldSearchVal;
		
		commNav.searchListView("opportunity", hashTagRecSrch);
		try {
			AssertJUnit.assertTrue(commNav.isTextPresentOnPage(regardingFldSearchVal));
			System.out.println(resultMsg + "' - Passed");
		}
		catch (Error e) {
			System.out.println(e.toString());
			System.out.println(resultMsg + "' - FAILED");
		}
	}

	
	public void prepHashTagsSubPanel() {
		String methodID = "prepHashTagsSubPanel";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		
		//expand the Hash Tags sub-panel if it's currently collapsed
		if (!commNav.rmenu_HashTagsSubPnl.isDisplayed()) {
			System.out.println(methodID + ": Hash Tags panel was initially collapsed; expanding panel for test...");
			commNav.rmenu_HashTagsHdr.click();
			
			//confirm the the sub-panel was indeed expanded
			try {
				AssertJUnit.assertTrue(commNav.rmenu_HashTagsSubPnl.isDisplayed());
			}
			catch (Error e) {
				System.out.println(e.toString());
				System.out.println(methodID + ": Hash Tags panel failed to expand on panel header click; test aborted.");
				return;
			}
		}
	}

	
	
	//Test Methods
	//============
	@Test(enabled = true)
	public void test01_SeTestTCHashTagsNotesHistoryGeneral() throws Exception {
		String methodID = "test01_SeTestTCHashTagsNotesHistoryGeneral";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);
		
		// Test Params:
		String entityType = "Notes/History";
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
		
	    //Step: navigate to Notes/History list view...
		commNav.clickGlobalMenuItem(entityType);
		
		NotesHistoryViewsElements notesHistoryListView = PageFactory.initElements(driver, NotesHistoryViewsElements.class);
		
		//Step: reveal Right Context Menu panel
		headerButton.showRightContextMenu();
		prepHashTagsSubPanel();
		
		
		//SECTION 1:
	    //Step: test the Hash Tags header
		//collapse the Hash Tags sub-panel
		String resultsMsg = "VP: Hash Tags sub-panel collapse check";
		
		notesHistoryListView.notesHistoryHashTagsHdr.click();
		try {
			AssertJUnit.assertFalse(notesHistoryListView.notesHistoryHashTagsPnl.isDisplayed());
			System.out.println(resultsMsg + " - Passed");
			
			//re-expand the Hash Tags sub-panel
			resultsMsg = "VP: Hash Tags sub-panel expand check";
			
			notesHistoryListView.notesHistoryHashTagsHdr.click();
			try {
				AssertJUnit.assertTrue(notesHistoryListView.notesHistoryHashTagsPnl.isDisplayed());
				System.out.println(resultsMsg + " - Passed");
			}
			catch (Error e) {
				System.out.println(e.toString());
				System.out.println(resultsMsg + " - FAILED");
			}
		}
		catch (Error e) {
			System.out.println(e.toString());
			System.out.println(resultsMsg + " - FAILED");
		}
		
		
		//SECTION 2:
		//Step: close Right-Context Menu
		headerButton.clickHeaderButton("right");
	
		//check to see that the Right-Context Menu is indeed closed
		// Verify the 'Right-Context Menu' left-screen displays...
		resultsMsg = "VP: Right-Context Menu panel expand check";
		
		try {
			AssertJUnit.assertFalse(driver.findElement(By.xpath(".//*[@id='right_drawer']/div")).isDisplayed());
			System.out.println(resultsMsg + " - Passed");
		} catch (Error e) {     
			System.out.println(e.toString());
			System.out.println(resultsMsg + " - FAILED");
		}
		
		//Step: re-open Right-Context Menu (confirmation is handled in the method)
		headerButton.showRightContextMenu();
				
		//SECTION 3:
		//Step: test each of the pre-set Hash Tag items
		commNav.rightClickContextMenuItem("note");
		commNav.rightClickContextMenuItem("phonecall");
		commNav.rightClickContextMenuItem("meeting");
		commNav.rightClickContextMenuItem("personal");
		commNav.rightClickContextMenuItem("email");
				
		System.out.println(ENDLINE);
	}

	@Test(enabled = true)
	public void test02_SeTestTCHashTagsNotesHistoryNotesHT() throws Exception {
		String methodID = "test02_SeTestTCHashTagsNotesHistoryNotesHT";
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
		
	    //Step: select and search on 'note' hash tag
		notesHistoryHashTagSelectNSearchCheck("note", "Proposal");
				
		System.out.println(ENDLINE);
	}
	

	@Test(enabled = true)
	public void test03_SeTestTCHashTagsNotesHistoryPhonecallHT() throws Exception {
		String methodID = "test03_SeTestTCHashTagsNotesHistoryPhonecallHT";
				
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
		
	    //Step: select and search on 'phonecall' hash tag
		notesHistoryHashTagSelectNSearchCheck("phonecall", "Confirm Meeting");
		
		System.out.println(ENDLINE);
	}
	
	
	@Test(enabled = true)
	public void test04_SeTestTCHashTagsNotesHistoryMeetinglHT() throws Exception {
		String methodID = "test04_SeTestTCHashTagsNotesHistoryMeetinglHT";
				
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
		
	    //Step: select and search on 'phonecall' hash tag
		notesHistoryHashTagSelectNSearchCheck("meeting", "Lunch");
		
		System.out.println(ENDLINE);
	}
	
	
	@Test(enabled = true)
	public void test05_SeTestTCHashTagsNotesHistoryMeetingHT() throws Exception {
		String methodID = "test05_SeTestTCHashTagsNotesHistoryMeetingHT";
				
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
		
	    //Step: select and search on 'phonecall' hash tag
		notesHistoryHashTagSelectNSearchCheck("meeting", "Lunch");
		
		System.out.println(ENDLINE);
	}


	@Test(enabled = true)
	public void test06_SeTestTCHashTagsNotesHistoryPersonalHT() throws Exception {
		String methodID = "test06_SeTestTCHashTagsNotesHistoryPersonalHT";
				
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
		
	    //Step: select and search on 'personal' hash tag
		notesHistoryHashTagSelectNSearchCheck("personal", "Staff meeting");
		
		System.out.println(ENDLINE);
	}
	
	
	@Test(enabled = true)
	public void test07_SeTestTCHashTagsNotesHistoryEmailHT() throws Exception {
		String methodID = "test07_SeTestTCHashTagsNotesHistoryEmailHT";
				
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
		
	    //Step: select and search on 'personal' hash tag
		notesHistoryHashTagSelectNSearchCheck("email", "purchase");
		
		System.out.println(ENDLINE);
	}

	@Test(enabled = true)
	public void test08_SeTestTCHashTagsNotesHistoryStateRetention() throws Exception {
		String methodID = "test08_SeTestTCHashTagsNotesHistoryStateRetention";			
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);
		
		// Test Params:
		String entityType = "Notes/History";
		String hashTag = "email";		
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
		
	    //Step: navigate to Notes/History list view...
		commNav.clickGlobalMenuItem(entityType);
		
		NotesHistoryViewsElements notesHistoryListView = PageFactory.initElements(driver, NotesHistoryViewsElements.class);
		
	    //Step: select the 'email' hash tag
		commNav.rightClickContextMenuItem(hashTag);
		
		//Step: check the filled-in search input field value
		String resulstMsg = "VP: right-context menu search field value set to " + hashTag;		
		String notesHistorySearchVal = notesHistoryListView.notesHistorysSearchTxtBox.getAttribute("value");
		try {
			AssertJUnit.assertEquals(hashTag, notesHistorySearchVal);
			System.out.println(resulstMsg + " - Passed");
		}
		catch (Error e) {
			System.out.println(e.toString());
			System.out.println(resulstMsg + " - FAILED; the actual value is '" + notesHistorySearchVal + "'");
		}
		
		//Step: navigate back to the My Activities List view
		headerButton.goBack();
		
		//Step: navigate to Contacts List view...
		commNav.clickGlobalMenuItem("Contacts");
		
	    //Step: navigate back to Notes/History list view...
		//commNav.clickGlobalMenuItem(entityType);
		headerButton.showGlobalMenu();
		WebElement notesHistoryItem = driver.findElement(By.xpath(".//*[@id='left_drawer']/descendant::*[text() = 'Notes/History']"));
		//notesHistoryItem.click();
		commNav.highlightNClick(notesHistoryItem);
				
		//Step: re-open the Right-Context Menu
		headerButton.showRightContextMenu();
		
		notesHistoryListView = PageFactory.initElements(driver, NotesHistoryViewsElements.class);
		
		//Step: check the filled-in search input field value
		resulstMsg = "VP: right-context menu search field persistent value set to " + hashTag;		
		notesHistorySearchVal = notesHistoryListView.notesHistorysSearchTxtBox.getAttribute("value");
		try {
			AssertJUnit.assertEquals(hashTag, notesHistorySearchVal);
			System.out.println(resulstMsg + " - Passed");
		}
		catch (Error e) {
			System.out.println(e.toString());
			System.out.println(resulstMsg + " - FAILED; the actual value is '" + notesHistorySearchVal + "'");
		}
		headerButton.rightCntxtMnuButton.click();
		
		System.out.println(ENDLINE);
	}

	@Test(enabled = true)
	public void test09_SeTestTCHashTagsNotesHistoryMutalExclusivity() throws Exception {
		String methodID = "test09_SeTestTCHashTagsNotesHistoryMutalExclusivity";			
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		
		
		// Test Params:
		String entityType = "Notes/History";
		String hashTag = "note";
				
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
		
	    //Step: navigate to Notes/History list view...
		commNav.clickGlobalMenuItem(entityType);
		
		NotesHistoryViewsElements notesHistoryListView = PageFactory.initElements(driver, NotesHistoryViewsElements.class);
		
	    //Step: select the hash tag
		commNav.rightClickContextMenuItem(hashTag);
		
		//Step: check the filled-in search input field value
		String resulstMsg = "VP: right-context menu search field value set to " + hashTag;		
		String notesHistorySearchVal = notesHistoryListView.notesHistorysSearchTxtBox.getAttribute("value");
		try {
			AssertJUnit.assertEquals("#" + hashTag, notesHistorySearchVal);
			System.out.println(resulstMsg + " - Passed");
		}
		catch (Error e) {
			System.out.println(e.toString());
			System.out.println(resulstMsg + " - FAILED; the actual value is '" + notesHistorySearchVal + "'");
		}
		
		//Step: perform invalid Hash Tag combo search A: "#note#meeting"
		String hTagComboTxt = "#note #meeting";
		String resultsMsg = "VP: invalid combo Hash Tag search '" + hTagComboTxt + "'returned 'no records'";
		commNav.searchListView(entityType, hTagComboTxt);
		try {
			AssertJUnit.assertTrue(commNav.isTextPresentOnPage("no records"));
			System.out.println(resultsMsg + " - Passed");
		}
		catch (Error e) {
			System.out.println(resultsMsg + " - FAILED");
		}
		
		//Step: perform invalid Hash Tag combo search B: "#phonecall#personal"
		hTagComboTxt = "#phonecall #personal";
		commNav.searchListView(entityType, hTagComboTxt);
		try {
			AssertJUnit.assertTrue(commNav.isTextPresentOnPage("no records"));
			System.out.println(resultsMsg + " - Passed");
		}
		catch (Error e) {
			System.out.println(resultsMsg + " - FAILED");
		}
		
		//Step: perform invalid Hash Tag combo search C: "#meeting#email"
		hTagComboTxt = "#meeting #email";
		commNav.searchListView(entityType, hTagComboTxt);
		try {
			AssertJUnit.assertTrue(commNav.isTextPresentOnPage("no records"));
			System.out.println(resultsMsg + " - Passed");
		}
		catch (Error e) {
			System.out.println(resultsMsg + " - FAILED");
		}
		
		System.out.println(ENDLINE);
	}

	
	@Test(enabled = true)
	public void test10_SeTestTCHashTagsOpportunityGeneral() throws Exception {
		String methodID = "test10_SeTestTCHashTagsOpportunityGeneral";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);
		
		// Test Params:
		String entityType = "Opportunities";
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
		
	    //Step: navigate to Opportunities list view...
		commNav.clickGlobalMenuItem(entityType);
		
		OpportunityViewsElements opportunityListView = PageFactory.initElements(driver, OpportunityViewsElements.class);
		
		//Step: reveal Right Context Menu panel
		headerButton.showRightContextMenu();
		prepHashTagsSubPanel();
		
		
		//SECTION 1:
	    //Step: test the Hash Tags header
		//collapse the Hash Tags sub-panel
		String resultsMsg = "VP: Hash Tags sub-panel collapse check";		
		opportunityListView.opportunityHashTagsHdr.click();
		try {
			AssertJUnit.assertFalse(opportunityListView.opportunityHashTagsPnl.isDisplayed());
			System.out.println(resultsMsg + " - Passed");
			
			//re-expand the Hash Tags sub-panel
			resultsMsg = "VP: Hash Tags sub-panel expand check";
			
			opportunityListView.opportunityHashTagsHdr.click();
			try {
				AssertJUnit.assertTrue(opportunityListView.opportunityHashTagsPnl.isDisplayed());
				System.out.println(resultsMsg + " - Passed");
			}
			catch (Error e) {
				System.out.println(e.toString());
				System.out.println(resultsMsg + " - FAILED");
			}
		}
		catch (Error e) {
			System.out.println(e.toString());
			System.out.println(resultsMsg + " - FAILED");
		}
		
		
		//SECTION 2:
		//Step: close Right-Context Menu
		headerButton.clickHeaderButton("right");
	
		//check to see that the Right-Context Menu is indeed closed
		// Verify the 'Right-Context Menu' left-screen displays...
		resultsMsg = "VP: Right-Context Menu panel expand check";		
		try {
			AssertJUnit.assertFalse(driver.findElement(By.xpath(".//*[@id='right_drawer']/div")).isDisplayed());
			System.out.println(resultsMsg + " - Passed");
		} catch (Error e) {     
			System.out.println(e.toString());
			System.out.println(resultsMsg + " - FAILED");
		}
		
		//Step: re-open Right-Context Menu (confirmation is handled in the method)
		headerButton.showRightContextMenu();
				
		//SECTION 3:
		//Step: test each of the pre-set Hash Tag items
		commNav.rightClickContextMenuItem("open");
		commNav.rightClickContextMenuItem("won");
		commNav.rightClickContextMenuItem("lost");
		commNav.rightClickContextMenuItem("inactive");
		commNav.rightClickContextMenuItem("prospect");
		commNav.rightClickContextMenuItem("qualification");
		commNav.rightClickContextMenuItem("needs-analysis");
		commNav.rightClickContextMenuItem("demonstration");
		commNav.rightClickContextMenuItem("negotiation");
				
		System.out.println(ENDLINE);
	}

	@Test(enabled = true)
	public void test11_SeTestTCHashTagsOpportunityOpenHT() throws Exception {
		String methodID = "test11_SeTestTCHashTagsOpportunityOpenHT";
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);

	    //Step: select and search on 'open' hash tag for specific Opportunity
		opportunityHashTagSelectNSearchCheck("open", "Defect Test");
		
	    //Step: select and search on 'open' hash tag for specific Account
		opportunityHashTagSelectNSearchCheck("open", "Abbott Ltd.");
				
		System.out.println(ENDLINE);
	}
	
	
	@Test(enabled = true)
	public void test12_SeTestTCHashTagsOpportunityWonHT() throws Exception {
		String methodID = "test12_SeTestTCHashTagsOpportunityWonHT";
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);

	    //Step: select and search on 'won' hash tag for specific Opportunity
		opportunityHashTagSelectNSearchCheck("won", "Abbott WorldWide-Phase I");
		
	    //Step: select and search on 'won' hash tag for specific Account
		opportunityHashTagSelectNSearchCheck("won", "Big Systems");
				
		System.out.println(ENDLINE);
	}
	
	
	@Test(enabled = true)
	public void test13_SeTestTCHashTagsOpportunityLostHT() throws Exception {
		String methodID = "test13_SeTestTCHashTagsOpportunityLostHT";
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);

	    //Step: select and search on 'lost' hash tag for specific Opportunity
		opportunityHashTagSelectNSearchCheck("lost", "Advising Group Test Opp");
		
	    //Step: select and search on 'lost' hash tag for specific Account
		opportunityHashTagSelectNSearchCheck("lost", "Coca-Cola");
				
		System.out.println(ENDLINE);
	}
	
	
	@Test(enabled = true)
	public void test14_SeTestTCHashTagsOpportunityInactiveHT() throws Exception {
		String methodID = "test14_SeTestTCHashTagsOpportunityInactiveHT";
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);

	    //Step: select and search on 'open' hash tag for specific Opportunity
		opportunityHashTagSelectNSearchCheck("inactive", "Best Software-Phase1");
		
	    //Step: select and search on 'open' hash tag for specific Account
		opportunityHashTagSelectNSearchCheck("inactive", "Equity Residential");
				
		System.out.println(ENDLINE);
	}
	
	
	@Test(enabled = true)
	public void test15_SeTestTCHashTagsOpportunityProspectHT() throws Exception {
		String methodID = "test15_SeTestTCHashTagsOpportunityProspectHT";
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);

	    //Step: select and search on 'prospect' hash tag for specific Opportunity
		opportunityHashTagSelectNSearchCheck("prospect", "Wells Apparel Company-Phase1");
		
	    //Step: select and search on 'prospect' hash tag for specific Account
		opportunityHashTagSelectNSearchCheck("prospect", "Interconnect International");
				
		System.out.println(ENDLINE);
	}
	
	
	@Test(enabled = true)
	public void test16_SeTestTCHashTagsOpportunityQualificationHT() throws Exception {
		String methodID = "test16_SeTestTCHashTagsOpportunityQualificationHT";
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);

	    //Step: select and search on 'qualification' hash tag for specific Opportunity
		opportunityHashTagSelectNSearchCheck("qualification", "Farmco Industries-Phase I");
		
	    //Step: select and search on 'qualification' hash tag for specific Account
		opportunityHashTagSelectNSearchCheck("qualification", "Horizon Acceptance Corporation");
				
		System.out.println(ENDLINE);
	}
	
	
	@Test(enabled = true)
	public void test17_SeTestTCHashTagsOpportunityNeedsAnalysisHT() throws Exception {
		String methodID = "test17_SeTestTCHashTagsOpportunityNeedsAnalysisHT";
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);

	    //Step: select and search on 'needs-analysis' hash tag for specific Opportunity
		opportunityHashTagSelectNSearchCheck("needs-analysis", "Mobile Relief-Phase1");
		
	    //Step: select and search on 'needs-analysis' hash tag for specific Account
		opportunityHashTagSelectNSearchCheck("needs-analysis", "Sage Software");
				
		System.out.println(ENDLINE);
	}
	
	
	@Test(enabled = true)
	public void test18_SeTestTCHashTagsOpportunityDemonstrationHT() throws Exception {
		String methodID = "test18_SeTestTCHashTagsOpportunityDemonstrationHT";
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);

	    //Step: select and search on 'demonstration' hash tag for specific Opportunity
		opportunityHashTagSelectNSearchCheck("demonstration", "University of Oregon-Phase2-Chemistry Department");
		
	    //Step: select and search on 'demonstration' hash tag for specific Account
		opportunityHashTagSelectNSearchCheck("demonstration", "Fleet Group");
				
		System.out.println(ENDLINE);
	}
	
	
	@Test(enabled = true)
	public void test19_SeTestTCHashTagsOpportunityNegotiationHT() throws Exception {
		String methodID = "test19_SeTestTCHashTagsOpportunityNegotiationHT";
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);

	    //Step: select and search on 'negotiation' hash tag for specific Opportunity
		opportunityHashTagSelectNSearchCheck("negotiation", "Nova King Goode-Phase-1");
		
	    //Step: select and search on 'negotiation' hash tag for specific Account
		opportunityHashTagSelectNSearchCheck("negotiation", "GMAC Insurance");
				
		System.out.println(ENDLINE);
	}
	
	
	@Test(enabled = true)
	public void test20_SeTestTCHashTagsOpportunityDecisionHT() throws Exception {
		String methodID = "test20_SeTestTCHashTagsOpportunityDecisionHT";
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);

	    //Step: select and search on 'decision' hash tag for specific Opportunity
		opportunityHashTagSelectNSearchCheck("decision", "Advising Group-Phase1");
		
	    //Step: select and search on 'decision' hash tag for specific Account
		opportunityHashTagSelectNSearchCheck("decision", "AmSher Research Co.");
				
		System.out.println(ENDLINE);
	}

	@Test(enabled = true)
	public void test21_SeTestTCHashTagsOpportunityStateRetention() throws Exception {
		String methodID = "test21_SeTestTCHashTagsOpportunityStateRetention";			
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);
		
		// Test Params:
		String entityType = "Opportunity";
		String hashTag = "negotiation";		
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
		
	    //Step: navigate to Opportunity list view...
		commNav.clickGlobalMenuItem(entityType);
		
		OpportunityViewsElements opportunityListView = PageFactory.initElements(driver, OpportunityViewsElements.class);
		
	    //Step: select the 'negotiation' hash tag
		commNav.rightClickContextMenuItem(hashTag);
		
		//Step: check the filled-in search input field value
		String resulstMsg = "VP: right-context menu search field value set to " + hashTag;		
		String opportunitySearchVal = opportunityListView.opportunitySearchTxtBox.getAttribute("value");
		try {
			AssertJUnit.assertEquals(hashTag, opportunitySearchVal);
			System.out.println(resulstMsg + " - Passed");
		}
		catch (Error e) {
			System.out.println(e.toString());
			System.out.println(resulstMsg + " - FAILED; the actual value is '" + opportunitySearchVal + "'");
		}
		
		//Step: navigate back to the My Activities List view
		headerButton.goBack();
		
		//Step: navigate to Contacts List view...
		commNav.clickGlobalMenuItem("Contacts");
		
	    //Step: navigate back to Opportunity list view...
		headerButton.showGlobalMenu();
		WebElement opportunityItem = driver.findElement(By.xpath(".//*[@id='left_drawer']/descendant::*[text() = 'Opportunities']"));
		commNav.highlightNClick(opportunityItem);
				
		//Step: re-open the Right-Context Menu
		headerButton.showRightContextMenu();
		
		opportunityListView = PageFactory.initElements(driver, OpportunityViewsElements.class);
		
		//Step: check the filled-in search input field value
		resulstMsg = "VP: right-context menu search field persistent value set to " + hashTag;		
		opportunitySearchVal = opportunityListView.opportunitySearchTxtBox.getAttribute("value");
		try {
			AssertJUnit.assertEquals("#" + hashTag, opportunitySearchVal);
			System.out.println(resulstMsg + " - Passed");
		}
		catch (Error e) {
			System.out.println(e.toString());
			System.out.println(resulstMsg + " - FAILED; the actual value is '" + opportunitySearchVal + "'");
		}
		headerButton.rightCntxtMnuButton.click();
		
		System.out.println(ENDLINE);
	}

	@Test(enabled = true)
	public void test22_SeTestTCHashTagsOpportunityMutalExclusivity() throws Exception {
		String methodID = "test22_SeTestTCHashTagsOpportunityMutalExclusivity";			
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		
		// Test Params:
		String entityType = "Opportunity";
		String hashTag = "open";
				
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
		
	    //Step: navigate to Opportunity list view...
		commNav.clickGlobalMenuItem(entityType);
		
		OpportunityViewsElements opportunityListView = PageFactory.initElements(driver, OpportunityViewsElements.class);
		
	    //Step: select the hash tag
		commNav.rightClickContextMenuItem(hashTag);
		
		//Step: check the filled-in search input field value
		String resulstMsg = "VP: right-context menu search field value set to " + hashTag;		
		String opportunitySearchVal = opportunityListView.opportunitySearchTxtBox.getAttribute("value");
		try {
			AssertJUnit.assertEquals("#" + hashTag, opportunitySearchVal);
			System.out.println(resulstMsg + " - Passed");
		}
		catch (Error e) {
			System.out.println(e.toString());
			System.out.println(resulstMsg + " - FAILED; the actual value is '" + opportunitySearchVal + "'");
		}
		
		//Step: perform invalid Hash Tag combo search A: "#won#open"
		String hTagComboTxt = "#won #open";
		String resultsMsg = "VP: invalid combo Hash Tag search '" + hTagComboTxt + "'returned 'no records'";
		commNav.searchListView(entityType, hTagComboTxt);
		try {
			AssertJUnit.assertTrue(commNav.isTextPresentOnPage("no records"));
			System.out.println(resultsMsg + " - Passed");
		}
		catch (Error e) {
			System.out.println(resultsMsg + " - FAILED");
		}
		
		//Step: perform invalid Hash Tag combo search B: "#open#lost"
		hTagComboTxt = "#open #lost";
		commNav.searchListView(entityType, hTagComboTxt);
		try {
			AssertJUnit.assertTrue(commNav.isTextPresentOnPage("no records"));
			System.out.println(resultsMsg + " - Passed");
		}
		catch (Error e) {
			System.out.println(resultsMsg + " - FAILED");
		}
		
		//Step: perform invalid Hash Tag combo search C: "#open#inactive"
		hTagComboTxt = "#open #inactive";
		commNav.searchListView(entityType, hTagComboTxt);
		try {
			AssertJUnit.assertTrue(commNav.isTextPresentOnPage("no records"));
			System.out.println(resultsMsg + " - Passed");
		}
		catch (Error e) {
			System.out.println(resultsMsg + " - FAILED");
		}
		
		//Step: perform invalid Hash Tag combo search C: "#won#lost"
		hTagComboTxt = "#won #lost";
		commNav.searchListView(entityType, hTagComboTxt);
		try {
			AssertJUnit.assertTrue(commNav.isTextPresentOnPage("no records"));
			System.out.println(resultsMsg + " - Passed");
		}
		catch (Error e) {
			System.out.println(resultsMsg + " - FAILED");
		}
		
		//Step: perform invalid Hash Tag combo search C: "#won#inactive"
		hTagComboTxt = "#won #inactive";
		commNav.searchListView(entityType, hTagComboTxt);
		try {
			AssertJUnit.assertTrue(commNav.isTextPresentOnPage("no records"));
			System.out.println(resultsMsg + " - Passed");
		}
		catch (Error e) {
			System.out.println(resultsMsg + " - FAILED");
		}
		
		//Step: perform invalid Hash Tag combo search C: "#lost#inactive"
		hTagComboTxt = "#lost #inactive";
		commNav.searchListView(entityType, hTagComboTxt);
		try {
			AssertJUnit.assertTrue(commNav.isTextPresentOnPage("no records"));
			System.out.println(resultsMsg + " - Passed");
		}
		catch (Error e) {
			System.out.println(resultsMsg + " - FAILED");
		}
		
		System.out.println(ENDLINE);
	}

	@Test(enabled = false)
	public void test23_SeTestTCHashTagsOpportunityOpenCombos() throws Exception {
		String methodID = "test23_SeTestTCHashTagsOpportunityOpenCombos";			
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		
		
		// Test Params:
		String entityType = "Opportunity";
		String hashTag = "open";
				
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
		
	    //Step: navigate to Opportunity list view...
		commNav.clickGlobalMenuItem(entityType);
		
		OpportunityViewsElements opportunityListView = PageFactory.initElements(driver, OpportunityViewsElements.class);
		
	    //Step: select the hash tag
		commNav.rightClickContextMenuItem(hashTag);
		
		//Step: check the filled-in search input field value
		String resulstMsg = "VP: right-context menu search field value set to " + hashTag;		
		String opportunitySearchVal = opportunityListView.opportunitySearchTxtBox.getAttribute("value");
		try {
			AssertJUnit.assertEquals("#" + hashTag, opportunitySearchVal);
			System.out.println(resulstMsg + " - Passed");
		}
		catch (Error e) {
			System.out.println(e.toString());
			System.out.println(resulstMsg + " - FAILED; the actual value is '" + opportunitySearchVal + "'");
		}
		
		//Step: perform invalid Hash Tag combo search A: "#open#prospect"
		String hTagComboTxt = "#open #prospect";
		String resultsMsg = "VP: valid combo Hash Tag search '" + hTagComboTxt + "'returned results";
		commNav.searchListView(entityType, hTagComboTxt);
		try {
			AssertJUnit.assertFalse(commNav.isTextPresentOnPage("no records"));
			System.out.println(resultsMsg + " - Passed");
		}
		catch (Error e) {
			System.out.println(resultsMsg + " - FAILED");
		}
		
		//Step: perform invalid Hash Tag combo search B: "#open#qualification"
		hTagComboTxt = "#open #qualification";
		commNav.searchListView(entityType, hTagComboTxt);
		try {
			AssertJUnit.assertFalse(commNav.isTextPresentOnPage("no records"));
			System.out.println(resultsMsg + " - Passed");
		}
		catch (Error e) {
			System.out.println(resultsMsg + " - FAILED");
		}
		
		//Step: perform invalid Hash Tag combo search C: "#open#needs-analysis"
		hTagComboTxt = "#open #needs-analysis";
		commNav.searchListView(entityType, hTagComboTxt);
		try {
			AssertJUnit.assertFalse(commNav.isTextPresentOnPage("no records"));
			System.out.println(resultsMsg + " - Passed");
		}
		catch (Error e) {
			System.out.println(resultsMsg + " - FAILED");
		}
		
		//Step: perform invalid Hash Tag combo search C: "#open#demonstration"
		hTagComboTxt = "#open #demonstration";
		commNav.searchListView(entityType, hTagComboTxt);
		try {
			AssertJUnit.assertFalse(commNav.isTextPresentOnPage("no records"));
			System.out.println(resultsMsg + " - Passed");
		}
		catch (Error e) {
			System.out.println(resultsMsg + " - FAILED");
		}
		
		//Step: perform invalid Hash Tag combo search C: "#open#negotiation"
		hTagComboTxt = "#open #negotiation";
		commNav.searchListView(entityType, hTagComboTxt);
		try {
			AssertJUnit.assertFalse(commNav.isTextPresentOnPage("no records"));
			System.out.println(resultsMsg + " - Passed");
		}
		catch (Error e) {
			System.out.println(resultsMsg + " - FAILED");
		}
				
		System.out.println(ENDLINE);
	}

	@Test(enabled = true)
	public void test24_SeTestTCHashTagsOpportunityWonCombos() throws Exception {
		String methodID = "test24_SeTestTCHashTagsOpportunityWonCombos";			
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);

		
		// Test Params:
		String entityType = "Opportunity";
		String hashTag = "won";
				
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
		
	    //Step: navigate to Opportunity list view...
		commNav.clickGlobalMenuItem(entityType);
		
		OpportunityViewsElements opportunityListView = PageFactory.initElements(driver, OpportunityViewsElements.class);
		
	    //Step: select the hash tag
		commNav.rightClickContextMenuItem(hashTag);
		
		//Step: check the filled-in search input field value
		String resulstMsg = "VP: right-context menu search field value set to " + hashTag;		
		String opportunitySearchVal = opportunityListView.opportunitySearchTxtBox.getAttribute("value");
		try {
			AssertJUnit.assertEquals("#" + hashTag, opportunitySearchVal);
			System.out.println(resulstMsg + " - Passed");
		}
		catch (Error e) {
			System.out.println(e.toString());
			System.out.println(resulstMsg + " - FAILED; the actual value is '" + opportunitySearchVal + "'");
		}
		
		//Step: perform invalid Hash Tag combo search A: "#won#prospect"
		String hTagComboTxt = "#won #prospect";
		String resultsMsg = "VP: valid combo Hash Tag search '" + hTagComboTxt + "'returned results";
		commNav.searchListView(entityType, hTagComboTxt);
		try {
			AssertJUnit.assertFalse(commNav.isTextPresentOnPage("no records"));
			System.out.println(resultsMsg + " - Passed");
		}
		catch (Error e) {
			System.out.println(resultsMsg + " - Warning");
		}
		
		//Step: perform invalid Hash Tag combo search B: "#won#qualification"
		hTagComboTxt = "#won #qualification";
		commNav.searchListView(entityType, hTagComboTxt);
		try {
			AssertJUnit.assertFalse(commNav.isTextPresentOnPage("no records"));
			System.out.println(resultsMsg + " - Passed");
		}
		catch (Error e) {
			System.out.println(resultsMsg + " - Warning");
		}
		
		//Step: perform invalid Hash Tag combo search C: "#won#needs-analysis"
		hTagComboTxt = "#won #needs-analysis";
		commNav.searchListView(entityType, hTagComboTxt);
		try {
			AssertJUnit.assertFalse(commNav.isTextPresentOnPage("no records"));
			System.out.println(resultsMsg + " - Passed");
		}
		catch (Error e) {
			System.out.println(resultsMsg + " - Warning");
		}
		
		//Step: perform invalid Hash Tag combo search C: "#won#demonstration"
		hTagComboTxt = "#won #demonstration";
		commNav.searchListView(entityType, hTagComboTxt);
		try {
			AssertJUnit.assertFalse(commNav.isTextPresentOnPage("no records"));
			System.out.println(resultsMsg + " - Passed");
		}
		catch (Error e) {
			System.out.println(resultsMsg + " - Warning");
		}
		
		//Step: perform invalid Hash Tag combo search C: "#won#negotiation"
		hTagComboTxt = "#won #negotiation";
		commNav.searchListView(entityType, hTagComboTxt);
		try {
			AssertJUnit.assertFalse(commNav.isTextPresentOnPage("no records"));
			System.out.println(resultsMsg + " - Passed");
		}
		catch (Error e) {
			System.out.println(resultsMsg + " - Warning");
		}
				
		System.out.println(ENDLINE);
	}

	@Test(enabled = true)
	public void test25_SeTestTCHashTagsOpportunityLostCombos() throws Exception {
		String methodID = "test25_SeTestTCHashTagsOpportunityLostCombos";			
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);

		
		// Test Params:
		String entityType = "Opportunity";
		String hashTag = "lost";
				
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
		
	    //Step: navigate to Opportunity list view...
		commNav.clickGlobalMenuItem(entityType);
		
		OpportunityViewsElements opportunityListView = PageFactory.initElements(driver, OpportunityViewsElements.class);
		
	    //Step: select the 'hash tag
		commNav.rightClickContextMenuItem(hashTag);
		
		//Step: check the filled-in search input field value
		String resulstMsg = "VP: right-context menu search field value set to " + hashTag;		
		String opportunitySearchVal = opportunityListView.opportunitySearchTxtBox.getAttribute("value");
		try {
			AssertJUnit.assertEquals("#" + hashTag, opportunitySearchVal);
			System.out.println(resulstMsg + " - Passed");
		}
		catch (Error e) {
			System.out.println(e.toString());
			System.out.println(resulstMsg + " - FAILED; the actual value is '" + opportunitySearchVal + "'");
		}
		
		//Step: perform invalid Hash Tag combo search A: "#lost#prospect"
		String hTagComboTxt = "#lost #prospect";
		String resultsMsg = "VP: valid combo Hash Tag search '" + hTagComboTxt + "'returned results";
		commNav.searchListView(entityType, hTagComboTxt);
		try {
			AssertJUnit.assertFalse(commNav.isTextPresentOnPage("no records"));
			System.out.println(resultsMsg + " - Passed");
		}
		catch (Error e) {
			System.out.println(resultsMsg + " - Warning");
		}
		
		//Step: perform invalid Hash Tag combo search B: "#lost#qualification"
		hTagComboTxt = "#lost #qualification";
		commNav.searchListView(entityType, hTagComboTxt);
		try {
			AssertJUnit.assertFalse(commNav.isTextPresentOnPage("no records"));
			System.out.println(resultsMsg + " - Passed");
		}
		catch (Error e) {
			System.out.println(resultsMsg + " - Warning");
		}
		
		//Step: perform invalid Hash Tag combo search C: "#lost#needs-analysis"
		hTagComboTxt = "#lost #needs-analysis";
		commNav.searchListView(entityType, hTagComboTxt);
		try {
			AssertJUnit.assertFalse(commNav.isTextPresentOnPage("no records"));
			System.out.println(resultsMsg + " - Passed");
		}
		catch (Error e) {
			System.out.println(resultsMsg + " - Warning");
		}
		
		//Step: perform invalid Hash Tag combo search C: "#lost#demonstration"
		hTagComboTxt = "#lost #demonstration";
		commNav.searchListView(entityType, hTagComboTxt);
		try {
			AssertJUnit.assertFalse(commNav.isTextPresentOnPage("no records"));
			System.out.println(resultsMsg + " - Passed");
		}
		catch (Error e) {
			System.out.println(resultsMsg + " - Warning");
		}
		
		//Step: perform invalid Hash Tag combo search C: "#lost#negotiation"
		hTagComboTxt = "#lost #negotiation";
		commNav.searchListView(entityType, hTagComboTxt);
		try {
			AssertJUnit.assertFalse(commNav.isTextPresentOnPage("no records"));
			System.out.println(resultsMsg + " - Passed");
		}
		catch (Error e) {
			System.out.println(resultsMsg + " - Warning");
		}
				
		System.out.println(ENDLINE);
	}

	@Test(enabled = true)
	public void test26_SeTestTCHashTagsOpportunityInactiveCombos() throws Exception {
		String methodID = "test26_SeTestTCHashTagsOpportunityInactiveCombos";			
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);

		
		// Test Params:
		String entityType = "Opportunity";
		String hashTag = "inactive";
				
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
		
	    //Step: navigate to Opportunity list view...
		commNav.clickGlobalMenuItem(entityType);
		
		OpportunityViewsElements opportunityListView = PageFactory.initElements(driver, OpportunityViewsElements.class);
		
	    //Step: select the hash tag
		commNav.rightClickContextMenuItem(hashTag);
		
		//Step: check the filled-in search input field value
		String resulstMsg = "VP: right-context menu search field value set to " + hashTag;		
		String opportunitySearchVal = opportunityListView.opportunitySearchTxtBox.getAttribute("value");
		try {
			AssertJUnit.assertEquals("#" + hashTag, opportunitySearchVal);
			System.out.println(resulstMsg + " - Passed");
		}
		catch (Error e) {
			System.out.println(e.toString());
			System.out.println(resulstMsg + " - FAILED; the actual value is '" + opportunitySearchVal + "'");
		}
		
		//Step: perform invalid Hash Tag combo search A: "#inactive#prospect"
		String hTagComboTxt = "#inactive #prospect";
		String resultsMsg = "VP: valid combo Hash Tag search '" + hTagComboTxt + "'returned results";
		commNav.searchListView(entityType, hTagComboTxt);
		try {
			AssertJUnit.assertFalse(commNav.isTextPresentOnPage("no records"));
			System.out.println(resultsMsg + " - Passed");
		}
		catch (Error e) {
			System.out.println(resultsMsg + " - Warning");
		}
		
		//Step: perform invalid Hash Tag combo search B: "#inactive#qualification"
		hTagComboTxt = "#inactive #qualification";
		commNav.searchListView(entityType, hTagComboTxt);
		try {
			AssertJUnit.assertFalse(commNav.isTextPresentOnPage("no records"));
			System.out.println(resultsMsg + " - Passed");
		}
		catch (Error e) {
			System.out.println(resultsMsg + " - Warning");
		}
		
		//Step: perform invalid Hash Tag combo search C: "#inactive#needs-analysis"
		hTagComboTxt = "#inactive #needs-analysis";
		commNav.searchListView(entityType, hTagComboTxt);
		try {
			AssertJUnit.assertFalse(commNav.isTextPresentOnPage("no records"));
			System.out.println(resultsMsg + " - Passed");
		}
		catch (Error e) {
			System.out.println(resultsMsg + " - Warning");
		}
		
		//Step: perform invalid Hash Tag combo search C: "#inactive#demonstration"
		hTagComboTxt = "#inactive #demonstration";
		commNav.searchListView(entityType, hTagComboTxt);
		try {
			AssertJUnit.assertFalse(commNav.isTextPresentOnPage("no records"));
			System.out.println(resultsMsg + " - Passed");
		}
		catch (Error e) {
			System.out.println(resultsMsg + " - Warning");
		}
		
		//Step: perform invalid Hash Tag combo search C: "#inactive#negotiation"
		hTagComboTxt = "#inactive #negotiation";
		commNav.searchListView(entityType, hTagComboTxt);
		try {
			AssertJUnit.assertFalse(commNav.isTextPresentOnPage("no records"));
			System.out.println(resultsMsg + " - Passed");
		}
		catch (Error e) {
			System.out.println(resultsMsg + " - Warning");
		}
				
		System.out.println(ENDLINE);
	}

	@Test(enabled = true)
	public void test27_SeTestTCHashTagsAccountGeneral() throws Exception {
		String methodID = "test27_SeTestTCHashTagsAccountGeneral";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);
		
		// Test Params:
		String entityType = "Accounts";
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
		
	    //Step: navigate to Opportunities list view...
		commNav.clickGlobalMenuItem(entityType);
		
		AccountViewsElements accountListView = PageFactory.initElements(driver, AccountViewsElements.class);
		
		//Step: reveal Right Context Menu panel
		headerButton.showRightContextMenu();
		prepHashTagsSubPanel();
		
		
		//SECTION 1:
	    //Step: test the Hash Tags header
		//collapse the Hash Tags sub-panel
		String resultsMsg = "VP: Hash Tags sub-panel collapse check";
		
		accountListView.accountHashTagsHdr.click();
		try {
			AssertJUnit.assertFalse(accountListView.accountHashTagsPnl.isDisplayed());
			System.out.println(resultsMsg + " - Passed");
			
			//re-expand the Hash Tags sub-panel
			resultsMsg = "VP: Hash Tags sub-panel expand check";
			
			accountListView.accountHashTagsHdr.click();
			try {
				AssertJUnit.assertTrue(accountListView.accountHashTagsPnl.isDisplayed());
				System.out.println(resultsMsg + " - Passed");
			}
			catch (Error e) {
				System.out.println(e.toString());
				System.out.println(resultsMsg + " - FAILED");
			}
		}
		catch (Error e) {
			System.out.println(e.toString());
			System.out.println(resultsMsg + " - FAILED");
		}
		
		
		//SECTION 2:
		//Step: close Right-Context Menu
		headerButton.clickHeaderButton("right");
	
		//check to see that the Right-Context Menu is indeed closed
		// Verify the 'Right-Context Menu' left-screen displays...
		resultsMsg = "VP: Right-Context Menu panel expand check";
		
		try {
			AssertJUnit.assertFalse(driver.findElement(By.xpath(".//*[@id='right_drawer']/div")).isDisplayed());
			System.out.println(resultsMsg + " - Passed");
		} catch (Error e) {     
			System.out.println(e.toString());
			System.out.println(resultsMsg + " - FAILED");
		}
		
		//Step: re-open Right-Context Menu (confirmation is handled in the method)
		headerButton.showRightContextMenu();
				
		//SECTION 3:
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
				
		System.out.println(ENDLINE);
	}

	
	@Test(enabled = true)
	public void test28_SeTestTCHashTagsAccountActiveHT() throws Exception {
		String methodID = "test28_SeTestTCHashTagsAccountActiveHT";
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
			
	    //Step: select and search on 'active' hash tag for specific Account
		accountHashTagSelectNSearchCheck("active", "");
				
		System.out.println(ENDLINE);
	}

	@Test(enabled = true)
	public void test29_SeTestTCHashTagsAccountInactiveHT() throws Exception {
		String methodID = "test29_SeTestTCHashTagsAccountInactiveHT";
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
	
	    //Step: select and search on 'inactive' hash tag for specific Account
		accountHashTagSelectNSearchCheck("inactive", "");
		
	    //Step: select and search on 'inactive' hash tag for specific Account
		accountHashTagSelectNSearchCheck("inactive", "Alcoa");
				
		System.out.println(ENDLINE);
	}

	@Test(enabled = true)
	public void test30_SeTestTCHashTagsAccountSuspectHT() throws Exception {
		String methodID = "test30_SeTestTCHashTagsAccountSuspectHT";
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
	
	    //Step: select and search on 'suspect' hash tag for specific Account
		accountHashTagSelectNSearchCheck("suspect", "");
		
	    //Step: select and search on 'suspect' hash tag for specific Account
		accountHashTagSelectNSearchCheck("suspect", "Campbell");
				
		System.out.println(ENDLINE);
	}

	@Test(enabled = true)
	public void test31_SeTestTCHashTagsAccountLeadHT() throws Exception {
		String methodID = "test31_SeTestTCHashTagsAccountLeadHT";
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
	
	    //Step: select and search on 'lead' hash tag for specific Account
		accountHashTagSelectNSearchCheck("lead", "");
		
	    //Step: select and search on 'lead' hash tag for specific Account
		accountHashTagSelectNSearchCheck("lead", "Big");
				
		System.out.println(ENDLINE);
	}

	@Test(enabled = true)
	public void test32_SeTestTCHashTagsAccountProspectHT() throws Exception {
		String methodID = "test32_SeTestTCHashTagsAccountProspectHT";
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
	
	    //Step: select and search on 'prospect' hash tag for specific Account
		accountHashTagSelectNSearchCheck("prospect", "");
		
	    //Step: select and search on 'prospect' hash tag for specific Account
		accountHashTagSelectNSearchCheck("prospect", "Artistic");
				
		System.out.println(ENDLINE);
	}

	@Test(enabled = true)
	public void test33_SeTestTCHashTagsAccountCustomerHT() throws Exception {
		String methodID = "test33_SeTestTCHashTagsAccountCustomerHT";
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
	
	    //Step: select and search on 'customer' hash tag for specific Account
		accountHashTagSelectNSearchCheck("customer", "");
		
	    //Step: select and search on 'customer' hash tag for specific Account
		accountHashTagSelectNSearchCheck("customer", "Bell");
				
		System.out.println(ENDLINE);
	}

	@Test(enabled = true)
	public void test34_SeTestTCHashTagsAccountPartnerHT() throws Exception {
		String methodID = "test34_SeTestTCHashTagsAccountPartnerHT";
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
	
	    //Step: select and search on 'partner' hash tag for specific Account
		accountHashTagSelectNSearchCheck("partner", "");
		
	    //Step: select and search on 'partner' hash tag for specific Account
		accountHashTagSelectNSearchCheck("partner", "Energy");
				
		System.out.println(ENDLINE);
	}

	@Test(enabled = true)
	public void test35_SeTestTCHashTagsAccountVendorHT() throws Exception {
		String methodID = "test35_SeTestTCHashTagsAccountVendorHT";
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
	
	    //Step: select and search on 'vendor' hash tag for specific Account
		accountHashTagSelectNSearchCheck("vendor", "");
		
	    //Step: select and search on 'vendor' hash tag for specific Account
		accountHashTagSelectNSearchCheck("vendor", "FedEx");
				
		System.out.println(ENDLINE);
	}

	@Test(enabled = true)
	public void test36_SeTestTCHashTagsAccountInfluencerHT() throws Exception {
		String methodID = "test36_SeTestTCHashTagsAccountInfluencerHT";
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
	
	    //Step: select and search on 'influencer' hash tag for specific Account
		accountHashTagSelectNSearchCheck("influencer", "");
		
	    //Step: select and search on 'influencer' hash tag for specific Account
		accountHashTagSelectNSearchCheck("influencer", "EMC");
				
		System.out.println(ENDLINE);
	}

	@Test(enabled = true)
	public void test37_SeTestTCHashTagsAccountCompetitorHT() throws Exception {
		String methodID = "test37_SeTestTCHashTagsAccountCompetitorHT";
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
	
	    //Step: select and search on 'competitor' hash tag for specific Account
		accountHashTagSelectNSearchCheck("competitor", "");
		
	    //Step: select and search on 'competitor' hash tag for specific Account
		accountHashTagSelectNSearchCheck("competitor", "Johnson");
				
		System.out.println(ENDLINE);
	}

	@Test(enabled = true)
	public void test38_SeTestTCHashTagsAccountStateRetention() throws Exception {
		String methodID = "test38_SeTestTCHashTagsAccountStateRetention";			
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);
		
		// Test Params:
		String entityType = "Accounts";
		String hashTag = "competitor";		
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
		
	    //Step: navigate to Accounts list view...
		commNav.clickGlobalMenuItem(entityType);
		
		AccountViewsElements accountListView = PageFactory.initElements(driver, AccountViewsElements.class);
		
	    //Step: select the 'negotiation' hash tag
		commNav.rightClickContextMenuItem(hashTag);
		
		//Step: check the filled-in search input field value
		String resulstMsg = "VP: right-context menu search field value set to " + hashTag;		
		String accountSearchVal = accountListView.accountsSearchTxtBox.getAttribute("value");
		try {
			AssertJUnit.assertEquals(hashTag, accountSearchVal);
			System.out.println(resulstMsg + " - Passed");
		}
		catch (Error e) {
			System.out.println(e.toString());
			System.out.println(resulstMsg + " - FAILED; the actual value is '" + accountSearchVal + "'");
		}
		
		//Step: navigate back to the My Activities List view
		headerButton.goBack();
		
		//Step: navigate to Contacts List view...
		commNav.clickGlobalMenuItem("Contacts");
		
	    //Step: navigate back to Accounts list view...
		headerButton.showGlobalMenu();
		WebElement opportunityItem = driver.findElement(By.xpath(".//*[@id='left_drawer']/descendant::*[text() = 'Accounts']"));
		commNav.highlightNClick(opportunityItem);
				
		//Step: re-open the Right-Context Menu
		headerButton.showRightContextMenu();
		
		accountListView = PageFactory.initElements(driver, AccountViewsElements.class);
		
		//Step: check the filled-in search input field value
		resulstMsg = "VP: right-context menu search field persistent value set to " + hashTag;		
		accountSearchVal = accountListView.accountsSearchTxtBox.getAttribute("value");
		try {
			AssertJUnit.assertEquals("#" + hashTag, accountSearchVal);
			System.out.println(resulstMsg + " - Passed");
		}
		catch (Error e) {
			System.out.println(e.toString());
			System.out.println(resulstMsg + " - FAILED; the actual value is '" + accountSearchVal + "'");
		}
		headerButton.rightCntxtMnuButton.click();
		
		System.out.println(ENDLINE);
	}

	@Test(enabled = true)
	public void test39_SeTestTCHashTagsAccountMutalExclusivity() throws Exception {
		String methodID = "test39_SeTestTCHashTagsAccountMutalExclusivity";			
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		
		// Test Params:
		String entityType = "Accounts";
		String hashTag = "active";
				
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
		
	    //Step: navigate to Accounts list view...
		commNav.clickGlobalMenuItem(entityType);
		
		AccountViewsElements accountListView = PageFactory.initElements(driver, AccountViewsElements.class);
		
	    //Step: select the hash tag
		commNav.rightClickContextMenuItem(hashTag);
		
		//Step: check the filled-in search input field value
		String resulstMsg = "VP: right-context menu search field value set to " + hashTag;		
		String accountSearchVal = accountListView.accountsSearchTxtBox.getAttribute("value");
		try {
			AssertJUnit.assertEquals("#" + hashTag, accountSearchVal);
			System.out.println(resulstMsg + " - Passed");
		}
		catch (Error e) {
			System.out.println(e.toString());
			System.out.println(resulstMsg + " - FAILED; the actual value is '" + accountSearchVal + "'");
		}
		
		//Step: perform invalid Hash Tag combo search A: "#inactive#active"
		String hTagComboTxt = "#inactive #active";
		String resultsMsg = "VP: invalid combo Hash Tag search '" + hTagComboTxt + "'returned 'no records'";
		commNav.searchListView(entityType, hTagComboTxt);
		try {
			AssertJUnit.assertTrue(commNav.isTextPresentOnPage("no records"));
			System.out.println(resultsMsg + " - Passed");
		}
		catch (Error e) {
			System.out.println(resultsMsg + " - FAILED");
		}
		
		System.out.println(ENDLINE);
	}

	@Test(enabled = true)
	public void test40_SeTestTCHashTagsAccountTypeUnique() throws Exception {
		String methodID = "test40_SeTestTCHashTagsAccountTypeUnique";			
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		
		// Test Params:
		String entityType = "Accounts";
		String hashTag = "suspect";
		String[] hTagTypeList = {"#suspect", "#lead", "#prospect", "#customer", "#partner", "#vendor", "#influencer", "#competitor"};
		String hTagComboTxt = hTagTypeList[0];
		String resultsMsg = "VP: Account Types combo Hash Tag search returned 'no records'";
				
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
		
	    //Step: navigate to Accounts list view...
		commNav.clickGlobalMenuItem(entityType);
		
		AccountViewsElements accountListView = PageFactory.initElements(driver, AccountViewsElements.class);
		
	    //Step: select the hash tag
		commNav.rightClickContextMenuItem(hashTag);
		
		//Step: check the filled-in search input field value
		String resulstMsg = "VP: right-context menu search field value set to " + hashTag;		
		String accountSearchVal = accountListView.accountsSearchTxtBox.getAttribute("value");
		try {
			AssertJUnit.assertEquals("#" + hashTag, accountSearchVal);
			System.out.println(resulstMsg + " - Passed");
		}
		catch (Error e) {
			System.out.println(e.toString());
			System.out.println(resulstMsg + " - FAILED; the actual value is '" + accountSearchVal + "'");
		}
		System.out.println(" ");
		
		//Step: perform Hash Tag combo search using #suspect and other types
		System.out.println(methodID + ": perform Hash Tag combo search using #suspect and other types...");
		hTagComboTxt = hTagTypeList[0];
		for (int iCount = 1;iCount<hTagTypeList.length;iCount++) {
			hTagComboTxt = hTagTypeList[0];
			hTagComboTxt = hTagComboTxt + " " + hTagTypeList[iCount];
			commNav.searchListView(entityType, hTagComboTxt);
			try {
				AssertJUnit.assertTrue(commNav.isTextPresentOnPage("no records"));
				System.out.println(resultsMsg + " - Passed");
			}
			catch (Error e) {
				System.out.println(resultsMsg + " - FAILED");
			}
		}
		System.out.println(" ");
		
		//Step: perform Hash Tag combo search using #lead and other types
		System.out.println(methodID + ": perform Hash Tag combo search using #lead and other types...");
		for (int iCount = 2;iCount<hTagTypeList.length;iCount++) {
			hTagComboTxt = hTagTypeList[1];
			hTagComboTxt = hTagComboTxt + " " + hTagTypeList[iCount];
			commNav.searchListView(entityType, hTagComboTxt);
			try {
				AssertJUnit.assertTrue(commNav.isTextPresentOnPage("no records"));
				System.out.println(resultsMsg + " - Passed");
			}
			catch (Error e) {
				System.out.println(resultsMsg + " - FAILED");
			}
		}
		System.out.println(" ");
		
		//Step: perform Hash Tag combo search using #prospect and other types
		System.out.println(methodID + ": perform Hash Tag combo search using #prospect and other types...");
		for (int iCount = 3;iCount<hTagTypeList.length;iCount++) {
			hTagComboTxt = hTagTypeList[2];
			hTagComboTxt = hTagComboTxt + " " + hTagTypeList[iCount];
			commNav.searchListView(entityType, hTagComboTxt);
			try {
				AssertJUnit.assertTrue(commNav.isTextPresentOnPage("no records"));
				System.out.println(resultsMsg + " - Passed");
			}
			catch (Error e) {
				System.out.println(resultsMsg + " - FAILED");
			}
		}
		System.out.println(" ");
		
		//Step: perform Hash Tag combo search using #customer and other types
		System.out.println(methodID + ": perform Hash Tag combo search using #customer and other types...");
		for (int iCount = 4;iCount<hTagTypeList.length;iCount++) {
			hTagComboTxt = hTagTypeList[3];
			hTagComboTxt = hTagComboTxt + " " + hTagTypeList[iCount];
			commNav.searchListView(entityType, hTagComboTxt);
			try {
				AssertJUnit.assertTrue(commNav.isTextPresentOnPage("no records"));
				System.out.println(resultsMsg + " - Passed");
			}
			catch (Error e) {
				System.out.println(resultsMsg + " - FAILED");
			}
		}
		System.out.println(" ");
		
		//Step: perform Hash Tag combo search using #partner and other types
		System.out.println(methodID + ": perform Hash Tag combo search using #partner and other types...");
		for (int iCount = 5;iCount<hTagTypeList.length;iCount++) {
			hTagComboTxt = hTagTypeList[4];
			hTagComboTxt = hTagComboTxt + " " + hTagTypeList[iCount];
			commNav.searchListView(entityType, hTagComboTxt);
			try {
				AssertJUnit.assertTrue(commNav.isTextPresentOnPage("no records"));
				System.out.println(resultsMsg + " - Passed");
			}
			catch (Error e) {
				System.out.println(resultsMsg + " - FAILED");
			}
		}
		System.out.println(" ");
		
		//Step: perform Hash Tag combo search using #vendor and other types
		System.out.println(methodID + ": perform Hash Tag combo search using #vendor and other types...");
		for (int iCount = 6;iCount<hTagTypeList.length;iCount++) {
			hTagComboTxt = hTagTypeList[5];
			hTagComboTxt = hTagComboTxt + " " + hTagTypeList[iCount];
			commNav.searchListView(entityType, hTagComboTxt);
			try {
				AssertJUnit.assertTrue(commNav.isTextPresentOnPage("no records"));
				System.out.println(resultsMsg + " - Passed");
			}
			catch (Error e) {
				System.out.println(resultsMsg + " - FAILED");
			}
		}
		System.out.println(" ");
		
		//Step: perform Hash Tag combo search using #influencer and other types
		System.out.println(methodID + ": perform Hash Tag combo search using #influencer and other types...");
		for (int iCount = 7;iCount<hTagTypeList.length;iCount++) {
			hTagComboTxt = hTagTypeList[6];
			hTagComboTxt = hTagComboTxt + " " + hTagTypeList[iCount];
			commNav.searchListView(entityType, hTagComboTxt);
			try {
				AssertJUnit.assertTrue(commNav.isTextPresentOnPage("no records"));
				System.out.println(resultsMsg + " - Passed");
			}
			catch (Error e) {
				System.out.println(resultsMsg + " - FAILED");
			}
		}
		System.out.println(" ");
		
		System.out.println(ENDLINE);
	}

	@Test(enabled = false)
	public void test41_SeTestTCHashTagsAccountActiveStatusType() throws Exception {
		String methodID = "test41_SeTestTCHashTagsAccountActiveStatusType";			
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		
		// Test Params:
		String entityType = "Accounts";
		String hashTag = "active";
		String[] hTagTypeList = {"#suspect", "#lead", "#prospect", "#customer", "#partner", "#vendor", "#influencer", "#competitor"};
		String hTagComboTxt = "#" + hashTag;
		String resultsMsg = "VP: Account #active Status + Type combo Hash Tag search returned records";
				
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
		
	    //Step: navigate to Accounts list view...
		commNav.clickGlobalMenuItem(entityType);
		
		AccountViewsElements accountListView = PageFactory.initElements(driver, AccountViewsElements.class);
		
	    //Step: select the hash tag
		commNav.rightClickContextMenuItem(hashTag);
		
		//Step: check the filled-in search input field value
		String resulstMsg = "VP: right-context menu search field value set to " + hashTag;		
		String accountSearchVal = accountListView.accountsSearchTxtBox.getAttribute("value");
		try {
			AssertJUnit.assertEquals("#" + hashTag, accountSearchVal);
			System.out.println(resulstMsg + " - Passed");
		}
		catch (Error e) {
			System.out.println(e.toString());
			System.out.println(resulstMsg + " - FAILED; the actual value is '" + accountSearchVal + "'");
		}
		System.out.println(" ");
		
		//Step: perform Hash Tag combo search using #active and other types
		System.out.println(methodID + ": perform Hash Tag combo search using #active and other types...");
		for (int iCount = 0;iCount<hTagTypeList.length;iCount++) {
			hTagComboTxt = "#" + hashTag;
			hTagComboTxt = hTagComboTxt + " " + hTagTypeList[iCount];
			String accountListViewTxt = accountListView.getAccountsListViewTxt();
			commNav.searchListView(entityType, hTagComboTxt);
			Thread.sleep(2000);
			String searchResultsTxt = accountListView.getAccountsListViewTxt();
			try {
				AssertJUnit.assertTrue(!searchResultsTxt.equals(accountListViewTxt));
				System.out.println(resultsMsg + " - Passed");
			}
			catch (Error e) {
				System.out.println(e.toString());
				System.out.println(resultsMsg + " - FAILED");
			}
		}
		System.out.println(" ");
				
		System.out.println(ENDLINE);
	}

	@Test(enabled = true)
	public void test42_SeTestTCHashTagsAccountInactiveStatusType() throws Exception {
		String methodID = "test42_SeTestTCHashTagsAccountInactiveStatusType";			
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		
		// Test Params:
		String entityType = "Accounts";
		String hashTag = "inactive";
		String[] hTagTypeList = {"#suspect", "#lead", "#prospect", "#customer", "#partner", "#vendor", "#influencer", "#competitor"};
		String hTagComboTxt = "#" + hashTag;
		String resultsMsg = "VP: Account #inactive Status + Type combo Hash Tag search returned records";
				
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
		
	    //Step: navigate to Accounts list view...
		commNav.clickGlobalMenuItem(entityType);
		
		AccountViewsElements accountListView = PageFactory.initElements(driver, AccountViewsElements.class);
		
	    //Step: select the hash tag
		commNav.rightClickContextMenuItem(hashTag);
		
		//Step: check the filled-in search input field value
		String resulstMsg = "VP: right-context menu search field value set to " + hashTag;		
		String accountSearchVal = accountListView.accountsSearchTxtBox.getAttribute("value");
		try {
			AssertJUnit.assertEquals("#" + hashTag, accountSearchVal);
			System.out.println(resulstMsg + " - Passed");
		}
		catch (Error e) {
			System.out.println(e.toString());
			System.out.println(resulstMsg + " - FAILED; the actual value is '" + accountSearchVal + "'");
		}
		System.out.println(" ");
		
		//Step: perform Hash Tag combo search using #active and other types
		System.out.println(methodID + ": perform Hash Tag combo search using #active and other types...");
		for (int iCount = 0;iCount<hTagTypeList.length;iCount++) {
			hTagComboTxt = "#" + hashTag;
			hTagComboTxt = hTagComboTxt + " " + hTagTypeList[iCount];
			String accountListViewTxt = accountListView.getAccountsListViewTxt();
			commNav.searchListView(entityType, hTagComboTxt);
			Thread.sleep(2000);
			String searchResultsTxt = accountListView.getAccountsListViewTxt();
			try {
				AssertJUnit.assertTrue(!searchResultsTxt.equals(accountListViewTxt));
				System.out.println(resultsMsg + " - Passed");
			}
			catch (Error e) {
				System.out.println(e.toString());
				System.out.println(resultsMsg + " - FAILED");
			}
		}
		System.out.println(" ");
				
		System.out.println(ENDLINE);
	}

	@Test(enabled = true)
	public void test43_SeTestTCHashTagsContactGeneral() throws Exception {
		String methodID = "test43_SeTestTCHashTagsContactGeneral";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);
		
		// Test Params:
		String entityType = "Contacts";
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
		
	    //Step: navigate to Contacts list view...
		commNav.clickGlobalMenuItem(entityType);
		
		ContactViewsElements contactListView = PageFactory.initElements(driver, ContactViewsElements.class);
		
		//Step: reveal Right Context Menu panel
		headerButton.showRightContextMenu();
		prepHashTagsSubPanel();
		
		
		//SECTION 1:
	    //Step: test the Hash Tags header
		//collapse the Hash Tags sub-panel
		String resultsMsg = "VP: Hash Tags sub-panel collapse check";		
		contactListView.contactsHashTagsHdr.click();
		try {
			AssertJUnit.assertFalse(contactListView.contactsHashTagsPnl.isDisplayed());
			System.out.println(resultsMsg + " - Passed");
			
			//re-expand the Hash Tags sub-panel
			resultsMsg = "VP: Hash Tags sub-panel expand check";
			
			contactListView.contactsHashTagsHdr.click();
			try {
				AssertJUnit.assertTrue(contactListView.contactsHashTagsPnl.isDisplayed());
				System.out.println(resultsMsg + " - Passed");
			}
			catch (Error e) {
				System.out.println(e.toString());
				System.out.println(resultsMsg + " - FAILED");
			}
		}
		catch (Error e) {
			System.out.println(e.toString());
			System.out.println(resultsMsg + " - FAILED");
		}
		
		
		//SECTION 2:
		//Step: close Right-Context Menu
		headerButton.clickHeaderButton("right");
	
		//check to see that the Right-Context Menu is indeed closed
		// Verify the 'Right-Context Menu' left-screen displays...
		resultsMsg = "VP: Right-Context Menu panel expand check";		
		try {
			AssertJUnit.assertFalse(driver.findElement(By.xpath(".//*[@id='right_drawer']/div")).isDisplayed());
			System.out.println(resultsMsg + " - Passed");
		} catch (Error e) {     
			System.out.println(e.toString());
			System.out.println(resultsMsg + " - FAILED");
		}
		
		//Step: re-open Right-Context Menu (confirmation is handled in the method)
		headerButton.showRightContextMenu();
				
		//SECTION 3:
		//Step: test each of the pre-set Hash Tag items
		commNav.rightClickContextMenuItem("primary");
		commNav.rightClickContextMenuItem("not-primary");
		commNav.rightClickContextMenuItem("can-email");
		commNav.rightClickContextMenuItem("can-phone");
		commNav.rightClickContextMenuItem("can-fax");
		commNav.rightClickContextMenuItem("can-mail");
		commNav.rightClickContextMenuItem("can-solicit");
				
		System.out.println(ENDLINE);
	}

	@Test(enabled = true)
	public void test44_SeTestTCHashTagsContactPrimaryHT() throws Exception {
		String methodID = "test44_SeTestTCHashTagsContactPrimaryHT";
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
			
	    //Step: select and search on 'primary' hash tag
		contactHashTagSelectNSearchCheck("primary", "");
		
	    //Step: select and search on 'primary' hash tag for specific Contact Name
		contactHashTagSelectNSearchCheck("primary", "Douglas");
				
		System.out.println(ENDLINE);
	}

	@Test(enabled = true)
	public void test45_SeTestTCHashTagsContactNotPrimaryHT() throws Exception {
		String methodID = "test45_SeTestTCHashTagsContactNotPrimaryHT";
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
			
	    //Step: select and search on 'not-primary' hash tag
		contactHashTagSelectNSearchCheck("not-primary", "");
		
	    //Step: select and search on 'not-primary' hash tag for specific Contact Name
		contactHashTagSelectNSearchCheck("not-primary", "Blow");
				
		System.out.println(ENDLINE);
	}

	@Test(enabled = true)
	public void test46_SeTestTCHashTagsContactCanEmailHT() throws Exception {
		String methodID = "test46_SeTestTCHashTagsContactCanEmailHT";
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
			
	    //Step: select and search on 'can-email' hash tag
		contactHashTagSelectNSearchCheck("can-email", "");
		
	    //Step: select and search on 'can-email' hash tag for specific Contact Name
		contactHashTagSelectNSearchCheck("can-email", "Alvarez");
				
		System.out.println(ENDLINE);
	}

	@Test(enabled = true)
	public void test47_SeTestTCHashTagsContactCanPhoneHT() throws Exception {
		String methodID = "test47_SeTestTCHashTagsContactCanPhoneHT";
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
			
	    //Step: select and search on 'can-phone' hash tag
		contactHashTagSelectNSearchCheck("can-phone", "");
		
	    //Step: select and search on 'can-phone' hash tag for specific Contact Name
		contactHashTagSelectNSearchCheck("can-phone", "Aiken");
				
		System.out.println(ENDLINE);
	}

	@Test(enabled = true)
	public void test48_SeTestTCHashTagsContactCanFaxHT() throws Exception {
		String methodID = "test48_SeTestTCHashTagsContactCanFaxHT";
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
			
	    //Step: select and search on 'can-fax' hash tag
		contactHashTagSelectNSearchCheck("can-fax", "");
		
	    //Step: select and search on 'can-fax' hash tag for specific Contact Name
		contactHashTagSelectNSearchCheck("can-fax", "Chuck");
				
		System.out.println(ENDLINE);
	}

	@Test(enabled = true)
	public void test49_SeTestTCHashTagsContactCanMailHT() throws Exception {
		String methodID = "test49_SeTestTCHashTagsContactCanMailHT";
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
			
	    //Step: select and search on 'can-mail' hash tag
		contactHashTagSelectNSearchCheck("can-mail", "");
		
	    //Step: select and search on 'can-mail' hash tag for specific Contact Name
		contactHashTagSelectNSearchCheck("can-mail", "Linda");
				
		System.out.println(ENDLINE);
	}

	@Test(enabled = true)
	public void test50_SeTestTCHashTagsContactCanSolicitHT() throws Exception {
		String methodID = "test50_SeTestTCHashTagsContactCanSolicitHT";
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
			
	    //Step: select and search on 'can-solicit' hash tag
		contactHashTagSelectNSearchCheck("can-solicit", "");
		
	    //Step: select and search on 'can-solicit' hash tag for specific Contact Name
		contactHashTagSelectNSearchCheck("can-solicit", "Lars");
				
		System.out.println(ENDLINE);
	}

	@Test(enabled = true)
	public void test51_SeTestTCHashTagsContactStateRetention() throws Exception {
		String methodID = "test51_SeTestTCHashTagsContactStateRetention";			
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);
		
		// Test Params:
		String entityType = "Contacts";
		String hashTag = "can-solicit";		
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
		
	    //Step: navigate to Contacts list view...
		commNav.clickGlobalMenuItem(entityType);
		
		ContactViewsElements contactListView = PageFactory.initElements(driver, ContactViewsElements.class);
		
	    //Step: select the 'negotiation' hash tag
		commNav.rightClickContextMenuItem(hashTag);
		
		//Step: check the filled-in search input field value
		String resulstMsg = "VP: right-context menu search field value set to " + hashTag;		
		String contactSearchVal = contactListView.contactsSearchTxtBox.getAttribute("value");
		try {
			AssertJUnit.assertEquals(hashTag, contactSearchVal);
			System.out.println(resulstMsg + " - Passed");
		}
		catch (Error e) {
			System.out.println(e.toString());
			System.out.println(resulstMsg + " - FAILED; the actual value is '" + contactSearchVal + "'");
		}
		
		//Step: navigate back to the My Activities List view
		headerButton.goBack();
		
		//Step: navigate to Accounts List view...
		commNav.clickGlobalMenuItem("Accounts");
		
	    //Step: navigate back to Contacts list view...
		headerButton.showGlobalMenu();
		WebElement opportunityItem = driver.findElement(By.xpath(".//*[@id='left_drawer']/descendant::*[text() = 'Contacts']"));
		commNav.highlightNClick(opportunityItem);
				
		//Step: re-open the Right-Context Menu
		headerButton.showRightContextMenu();
		
		contactListView = PageFactory.initElements(driver, ContactViewsElements.class);
		
		//Step: check the filled-in search input field value
		resulstMsg = "VP: right-context menu search field persistent value set to " + hashTag;		
		contactSearchVal = contactListView.contactsSearchTxtBox.getAttribute("value");
		try {
			AssertJUnit.assertEquals("#" + hashTag, contactSearchVal);
			System.out.println(resulstMsg + " - Passed");
		}
		catch (Error e) {
			System.out.println(e.toString());
			System.out.println(resulstMsg + " - FAILED; the actual value is '" + contactSearchVal + "'");
		}
		headerButton.rightCntxtMnuButton.click();
		
		System.out.println(ENDLINE);
	}

	@Test(enabled = true)
	public void test52_SeTestTCHashTagsContactMutalExclusivity() throws Exception {
		String methodID = "test52_SeTestTCHashTagsContactMutalExclusivity";			
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		
		// Test Params:
		String entityType = "Contacts";
		String hashTag = "primary";
				
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
		
	    //Step: navigate to Contacts list view...
		commNav.clickGlobalMenuItem(entityType);
		
		ContactViewsElements contactListView = PageFactory.initElements(driver, ContactViewsElements.class);
		
	    //Step: select the hash tag
		commNav.rightClickContextMenuItem(hashTag);
		
		//Step: check the filled-in search input field value
		String resulstMsg = "VP: right-context menu search field value set to " + hashTag;		
		String contactSearchVal = contactListView.contactsSearchTxtBox.getAttribute("value");
		try {
			AssertJUnit.assertEquals("#" + hashTag, contactSearchVal);
			System.out.println(resulstMsg + " - Passed");
		}
		catch (Error e) {
			System.out.println(e.toString());
			System.out.println(resulstMsg + " - FAILED; the actual value is '" + contactSearchVal + "'");
		}
		
		//Step: perform invalid Hash Tag combo search A: "#not-primary #primary"
		String hTagComboTxt = "#not-primary #primary";
		String resultsMsg = "VP: invalid combo Hash Tag search '" + hTagComboTxt + "'returned 'no records'";
		commNav.searchListView(entityType, hTagComboTxt);
		try {
			AssertJUnit.assertTrue(commNav.isTextPresentOnPage("no records"));
			System.out.println(resultsMsg + " - Passed");
		}
		catch (Error e) {
			System.out.println(resultsMsg + " - FAILED");
		}
		
		System.out.println(ENDLINE);
	}

	@Test(enabled = true)
	public void test53_SeTestTCHashTagsContactPrimaryHTCombos() throws Exception {
		String methodID = "test53_SeTestTCHashTagsContactPrimaryHTCombos";			
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		
		// Test Params:
		String entityType = "Contacts";
		String hashTag = "primary";
		String[] hTagTypeList = {"#can-email", "#can-phone", "#can-fax", "#can-mail", "#can-solicit"};
		String hTagComboTxt = "#" + hashTag;
		String resultsMsg = "VP: Contact #primary indicator + donot combo Hash Tag search returned records";
				
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
		
	    //Step: navigate to Contacts list view...
		commNav.clickGlobalMenuItem(entityType);
		
		ContactViewsElements contactListView = PageFactory.initElements(driver, ContactViewsElements.class);
		
	    //Step: select the hash tag
		commNav.rightClickContextMenuItem(hashTag);
		
		//Step: check the filled-in search input field value
		String resulstMsg = "VP: right-context menu search field value set to " + hashTag;		
		String contactSearchVal = contactListView.contactsSearchTxtBox.getAttribute("value");
		try {
			AssertJUnit.assertEquals("#" + hashTag, contactSearchVal);
			System.out.println(resulstMsg + " - Passed");
		}
		catch (Error e) {
			System.out.println(e.toString());
			System.out.println(resulstMsg + " - FAILED; the actual value is '" + contactSearchVal + "'");
		}
		System.out.println(" ");
		
		//Step: perform Hash Tag combo search using #active and other types
		System.out.println(methodID + ": perform Hash Tag combo search using #primary and donot flags...");
		for (int iCount = 0;iCount<hTagTypeList.length;iCount++) {
			hTagComboTxt = "#" + hashTag;
			hTagComboTxt = hTagComboTxt + " " + hTagTypeList[iCount];
			String contactListViewTxt = contactListView.getContactsListViewTxt();
			commNav.searchListView(entityType, hTagComboTxt);
			Thread.sleep(2000);
			String searchResultsTxt = contactListView.getContactsListViewTxt();
			try {
				AssertJUnit.assertTrue(!searchResultsTxt.equals(contactListViewTxt));
				System.out.println(resultsMsg + " - Passed");
			}
			catch (Error e) {
				System.out.println(e.toString());
				System.out.println(resultsMsg + " - FAILED");
			}
		}
		System.out.println(" ");
				
		System.out.println(ENDLINE);
	}

	@Test(enabled = true)
	public void test54_SeTestTCHashTagsContactNotPrimaryHTCombos() throws Exception {
		String methodID = "test54_SeTestTCHashTagsContactNotPrimaryHTCombos";			
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		
		// Test Params:
		String entityType = "Contacts";
		String hashTag = "not-primary";
		String[] hTagTypeList = {"#can-email", "#can-phone", "#can-fax", "#can-mail", "#can-solicit"};
		String hTagComboTxt = "#" + hashTag;
		String resultsMsg = "VP: Contact #primary indicator + donot combo Hash Tag search returned records";
				
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
		
	    //Step: navigate to Contacts list view...
		commNav.clickGlobalMenuItem(entityType);
		
		ContactViewsElements contactListView = PageFactory.initElements(driver, ContactViewsElements.class);
		
	    //Step: select the hash tag
		commNav.rightClickContextMenuItem(hashTag);
		
		//Step: check the filled-in search input field value
		String resulstMsg = "VP: right-context menu search field value set to " + hashTag;		
		String contactSearchVal = contactListView.contactsSearchTxtBox.getAttribute("value");
		try {
			AssertJUnit.assertEquals("#" + hashTag, contactSearchVal);
			System.out.println(resulstMsg + " - Passed");
		}
		catch (Error e) {
			System.out.println(e.toString());
			System.out.println(resulstMsg + " - FAILED; the actual value is '" + contactSearchVal + "'");
		}
		System.out.println(" ");
		
		//Step: perform Hash Tag combo search using #active and other types
		System.out.println(methodID + ": perform Hash Tag combo search using #not-primary and donot flags...");
		for (int iCount = 0;iCount<hTagTypeList.length;iCount++) {
			hTagComboTxt = "#" + hashTag;
			hTagComboTxt = hTagComboTxt + " " + hTagTypeList[iCount];
			String contactListViewTxt = contactListView.getContactsListViewTxt();
			commNav.searchListView(entityType, hTagComboTxt);
			Thread.sleep(2000);
			String searchResultsTxt = contactListView.getContactsListViewTxt();
			try {
				AssertJUnit.assertTrue(!searchResultsTxt.equals(contactListViewTxt));
				System.out.println(resultsMsg + " - Passed");
			}
			catch (Error e) {
				System.out.println(e.toString());
				System.out.println(resultsMsg + " - FAILED");
			}
		}
		System.out.println(" ");
				
		System.out.println(ENDLINE);
	}

	@Test(enabled = true)
	public void test55_SeTestTCHashTagsLeadGeneral() throws Exception {
		String methodID = "test55_SeTestTCHashTagsLeadGeneral";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);
		
		// Test Params:
		String entityType = "Leads";
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
		
	    //Step: navigate to Contacts list view...
		commNav.clickGlobalMenuItem(entityType);
		
		LeadViewsElements leadListView = PageFactory.initElements(driver, LeadViewsElements.class);
		
		//Step: reveal Right Context Menu panel
		headerButton.showRightContextMenu();
		prepHashTagsSubPanel();
		
		
		//SECTION 1:
	    //Step: test the Hash Tags header
		//collapse the Hash Tags sub-panel
		String resultsMsg = "VP: Hash Tags sub-panel collapse check";		
		leadListView.leadsHashTagsHdr.click();
		try {
			AssertJUnit.assertFalse(leadListView.leadsHashTagsPnl.isDisplayed());
			System.out.println(resultsMsg + " - Passed");
			
			//re-expand the Hash Tags sub-panel
			resultsMsg = "VP: Hash Tags sub-panel expand check";
			
			leadListView.leadsHashTagsHdr.click();
			try {
				AssertJUnit.assertTrue(leadListView.leadsHashTagsPnl.isDisplayed());
				System.out.println(resultsMsg + " - Passed");
			}
			catch (Error e) {
				System.out.println(e.toString());
				System.out.println(resultsMsg + " - FAILED");
			}
		}
		catch (Error e) {
			System.out.println(e.toString());
			System.out.println(resultsMsg + " - FAILED");
		}
		
		
		//SECTION 2:
		//Step: close Right-Context Menu
		headerButton.clickHeaderButton("right");
	
		//check to see that the Right-Context Menu is indeed closed
		// Verify the 'Right-Context Menu' left-screen displays...
		resultsMsg = "VP: Right-Context Menu panel expand check";		
		try {
			AssertJUnit.assertFalse(driver.findElement(By.xpath(".//*[@id='right_drawer']/div")).isDisplayed());
			System.out.println(resultsMsg + " - Passed");
		} catch (Error e) {     
			System.out.println(e.toString());
			System.out.println(resultsMsg + " - FAILED");
		}
		
		//Step: re-open Right-Context Menu (confirmation is handled in the method)
		headerButton.showRightContextMenu();
				
		//SECTION 3:
		//Step: test each of the pre-set Hash Tag items
		commNav.rightClickContextMenuItem("can-email");
		commNav.rightClickContextMenuItem("can-phone");
		commNav.rightClickContextMenuItem("can-fax");
		commNav.rightClickContextMenuItem("can-mail");
		commNav.rightClickContextMenuItem("can-solicit");
				
		System.out.println(ENDLINE);
	}

	@Test(enabled = true)
	public void test56_SeTestTCHashTagsLeadCanEmailHT() throws Exception {
		String methodID = "test56_SeTestTCHashTagsLeadCanEmailHT";
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
			
	    //Step: select and search on 'can-email' hash tag
		leadHashTagSelectNSearchCheck("can-email", "");
		
	    //Step: select and search on 'can-email' hash tag for specific Lead Name
		leadHashTagSelectNSearchCheck("can-email", "Achew");
				
		System.out.println(ENDLINE);
	}

	@Test(enabled = true)
	public void test57_SeTestTCHashTagsLeadCanPhoneHT() throws Exception {
		String methodID = "test57_SeTestTCHashTagsLeadCanPhoneHT";
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
			
	    //Step: select and search on 'can-phone' hash tag
		leadHashTagSelectNSearchCheck("can-phone", "");
		
	    //Step: select and search on 'can-phone' hash tag for specific Lead Name
		leadHashTagSelectNSearchCheck("can-phone", "Banks");
				
		System.out.println(ENDLINE);
	}

	@Test(enabled = true)
	public void test58_SeTestTCHashTagsLeadCanFaxHT() throws Exception {
		String methodID = "test58_SeTestTCHashTagsLeadCanFaxHT";
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
			
	    //Step: select and search on 'can-fax' hash tag
		leadHashTagSelectNSearchCheck("can-fax", "");
		
	    //Step: select and search on 'can-fax' hash tag for specific Lead Name
		leadHashTagSelectNSearchCheck("can-fax", "Aaron");
				
		System.out.println(ENDLINE);
	}

	@Test(enabled = true)
	public void test59_SeTestTCHashTagsLeadCanMailHT() throws Exception {
		String methodID = "test59_SeTestTCHashTagsLeadCanMailHT";
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
			
	    //Step: select and search on 'can-mail' hash tag
		leadHashTagSelectNSearchCheck("can-mail", "");
		
	    //Step: select and search on 'can-mail' hash tag for specific Lead Name
		leadHashTagSelectNSearchCheck("can-mail", "Barkley");
				
		System.out.println(ENDLINE);
	}

	@Test(enabled = true)
	public void test60_SeTestTCHashTagsLeadCanSolicitHT() throws Exception {
		String methodID = "test60_SeTestTCHashTagsLeadCanSolicitHT";
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
			
	    //Step: select and search on 'can-solicit' hash tag
		leadHashTagSelectNSearchCheck("can-solicit", "");
		
	    //Step: select and search on 'can-solicit' hash tag for specific Lead Name
		leadHashTagSelectNSearchCheck("can-solicit", "John");
				
		System.out.println(ENDLINE);
	}

	@Test(enabled = true)
	public void test61_SeTestTCHashTagsLeadStateRetention() throws Exception {
		String methodID = "test61_SeTestTCHashTagsLeadStateRetention";			
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);
		
		// Test Params:
		String entityType = "Leads";
		String hashTag = "can-solicit";		
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
		
	    //Step: navigate to Contacts list view...
		commNav.clickGlobalMenuItem(entityType);
		
		ContactViewsElements contactListView = PageFactory.initElements(driver, ContactViewsElements.class);
		
	    //Step: select the 'negotiation' hash tag
		commNav.rightClickContextMenuItem(hashTag);
		
		//Step: check the filled-in search input field value
		String resulstMsg = "VP: right-context menu search field value set to " + hashTag;		
		String contactSearchVal = contactListView.contactsSearchTxtBox.getAttribute("value");
		try {
			AssertJUnit.assertEquals(hashTag, contactSearchVal);
			System.out.println(resulstMsg + " - Passed");
		}
		catch (Error e) {
			System.out.println(e.toString());
			System.out.println(resulstMsg + " - FAILED; the actual value is '" + contactSearchVal + "'");
		}
		
		//Step: navigate back to the My Activities List view
		headerButton.goBack();
		
		//Step: navigate to Accounts List view...
		commNav.clickGlobalMenuItem("Accounts");
		
	    //Step: navigate back to Contacts list view...
		headerButton.showGlobalMenu();
		WebElement opportunityItem = driver.findElement(By.xpath(".//*[@id='left_drawer']/descendant::*[text() = 'Contacts']"));
		commNav.highlightNClick(opportunityItem);
				
		//Step: re-open the Right-Context Menu
		headerButton.showRightContextMenu();
		
		contactListView = PageFactory.initElements(driver, ContactViewsElements.class);
		
		//Step: check the filled-in search input field value
		resulstMsg = "VP: right-context menu search field persistent value set to " + hashTag;		
		contactSearchVal = contactListView.contactsSearchTxtBox.getAttribute("value");
		try {
			AssertJUnit.assertEquals("#" + hashTag, contactSearchVal);
			System.out.println(resulstMsg + " - Passed");
		}
		catch (Error e) {
			System.out.println(e.toString());
			System.out.println(resulstMsg + " - FAILED; the actual value is '" + contactSearchVal + "'");
		}
		headerButton.rightCntxtMnuButton.click();
		
		System.out.println(ENDLINE);
	}

	@Test(enabled = true)
	public void test62_SeTestTCHashTagsLeadCombos() throws Exception {
		String methodID = "test62_SeTestTCHashTagsLeadCombos";			
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		
		// Test Params:
		String entityType = "Leads";
		String hashTag = "can-email";
		String resultsMsg = "VP: Lead Types combo Hash Tag search returned results";
				
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
		
	    //Step: navigate to Leads list view...
		commNav.clickGlobalMenuItem(entityType);
		
		LeadViewsElements leadListView = PageFactory.initElements(driver, LeadViewsElements.class);
		
	    //Step: select the hash tag
		commNav.rightClickContextMenuItem(hashTag);
		
		//Step: check the filled-in search input field value
		String resulstMsg = "VP: right-context menu search field value set to " + hashTag;		
		String leadSearchVal = leadListView.leadsSearchTxtBox.getAttribute("value");
		try {
			AssertJUnit.assertEquals("#" + hashTag, leadSearchVal);
			System.out.println(resulstMsg + " - Passed");
		}
		catch (Error e) {
			System.out.println(e.toString());
			System.out.println(resulstMsg + " - FAILED; the actual value is '" + leadSearchVal + "'");
		}
		System.out.println(" ");
		
		//Step: perform Hash Tag combo search using #can-email and other types
		String[] hTagTypeList1 = {"#can-email", "#can-phone", "#can-fax", "#can-mail", "#can-solicit"};
		String hTagComboTxt1 = hTagTypeList1[0];
		System.out.println(methodID + ": perform Hash Tag combo search using #can-email and other types...");
		for (int iCount = 1;iCount<hTagTypeList1.length;iCount++) {
			hTagComboTxt1 = hTagTypeList1[0];
			hTagComboTxt1 = hTagComboTxt1 + " " + hTagTypeList1[iCount];
			commNav.searchListView(entityType, hTagComboTxt1);
			try {
				AssertJUnit.assertFalse(commNav.isTextPresentOnPage("no records"));
				System.out.println(resultsMsg + " - Passed");
			}
			catch (Error e) {
				System.out.println(resultsMsg + " - FAILED");
			}
		}
		System.out.println(" ");
		
		//Step: perform Hash Tag combo search using #can-phone and other types
		String[] hTagTypeList2 = {"#can-phone", "#can-email", "#can-fax", "#can-mail", "#can-solicit"};
		String hTagComboTxt2 = hTagTypeList2[0];
		System.out.println(methodID + ": perform Hash Tag combo search using #can-phone and other types...");
		for (int iCount = 1;iCount<hTagTypeList2.length;iCount++) {
			hTagComboTxt2 = hTagTypeList2[0];
			hTagComboTxt2 = hTagComboTxt2 + " " + hTagTypeList2[iCount];
			commNav.searchListView(entityType, hTagComboTxt2);
			try {
				AssertJUnit.assertFalse(commNav.isTextPresentOnPage("no records"));
				System.out.println(resultsMsg + " - Passed");
			}
			catch (Error e) {
				System.out.println(resultsMsg + " - FAILED");
			}
		}
		System.out.println(" ");
		
		//Step: perform Hash Tag combo search using #can-fax and other types
		String[] hTagTypeList3 = {"#can-fax", "#can-phone", "#can-email", "#can-mail", "#can-solicit"};
		String hTagComboTxt3 = hTagTypeList3[0];
		System.out.println(methodID + ": perform Hash Tag combo search using #can-phone and other types...");
		for (int iCount = 1;iCount<hTagTypeList3.length;iCount++) {
			hTagComboTxt3 = hTagTypeList3[0];
			hTagComboTxt3 = hTagComboTxt3 + " " + hTagTypeList3[iCount];
			commNav.searchListView(entityType, hTagComboTxt3);
			try {
				AssertJUnit.assertFalse(commNav.isTextPresentOnPage("no records"));
				System.out.println(resultsMsg + " - Passed");
			}
			catch (Error e) {
				System.out.println(resultsMsg + " - FAILED");
			}
		}
		System.out.println(" ");
		
		//Step: perform Hash Tag combo search using #can-mail and other types
		String[] hTagTypeList4 = {"#can-mail", "#can-fax", "#can-phone", "#can-email", "#can-solicit"};
		String hTagComboTxt4 = hTagTypeList4[0];
		System.out.println(methodID + ": perform Hash Tag combo search using #can-mail and other types...");
		for (int iCount = 1;iCount<hTagTypeList4.length;iCount++) {
			hTagComboTxt4 = hTagTypeList4[0];
			hTagComboTxt4 = hTagComboTxt4 + " " + hTagTypeList4[iCount];
			commNav.searchListView(entityType, hTagComboTxt4);
			try {
				AssertJUnit.assertFalse(commNav.isTextPresentOnPage("no records"));
				System.out.println(resultsMsg + " - Passed");
			}
			catch (Error e) {
				System.out.println(resultsMsg + " - FAILED");
			}
		}
		System.out.println(" ");
		
		//Step: perform Hash Tag combo search using #can-solicit and other types
		String[] hTagTypeList5 = {"#can-solicit", "#can-mail", "#can-fax", "#can-phone", "#can-email"};
		String hTagComboTxt5 = hTagTypeList5[0];
		System.out.println(methodID + ": perform Hash Tag combo search using #can-solicit and other types...");
		for (int iCount = 1;iCount<hTagTypeList5.length;iCount++) {
			hTagComboTxt5 = hTagTypeList5[0];
			hTagComboTxt5 = hTagComboTxt5 + " " + hTagTypeList5[iCount];
			commNav.searchListView(entityType, hTagComboTxt5);
			try {
				AssertJUnit.assertFalse(commNav.isTextPresentOnPage("no records"));
				System.out.println(resultsMsg + " - Passed");
			}
			catch (Error e) {
				System.out.println(resultsMsg + " - FAILED");
			}
		}
		System.out.println(" ");
				
		System.out.println(ENDLINE);
	}
	
}
