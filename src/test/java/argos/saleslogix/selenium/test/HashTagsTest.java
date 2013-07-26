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
		
	    //Step: select the 'note' hash tag
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
		String hTagComboTxt = "#note#meeting";
		String resultsMsg = "VP: invalid combo Hash Tag search '" + hTagComboTxt + "'returned 'no results'";
		commNav.searchListView(entityType, hTagComboTxt);
		try {
			AssertJUnit.assertTrue(commNav.isTextPresentOnPage("no records"));
			System.out.println(resultsMsg + " - Passed");
		}
		catch (Error e) {
			System.out.println(resultsMsg + " - FAILED");
		}
		
		//Step: perform invalid Hash Tag combo search B: "#phonecall#personal"
		hTagComboTxt = "#phonecall#personal";
		commNav.searchListView(entityType, hTagComboTxt);
		try {
			AssertJUnit.assertTrue(commNav.isTextPresentOnPage("no records"));
			System.out.println(resultsMsg + " - Passed");
		}
		catch (Error e) {
			System.out.println(resultsMsg + " - FAILED");
		}
		
		//Step: perform invalid Hash Tag combo search C: "#meeting#email"
		hTagComboTxt = "#meeting#email";
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

	//Test Methods
	//============
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
		
	    //Step: select the 'note' hash tag
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
		String hTagComboTxt = "#won#open";
		String resultsMsg = "VP: invalid combo Hash Tag search '" + hTagComboTxt + "'returned 'no results'";
		commNav.searchListView(entityType, hTagComboTxt);
		try {
			AssertJUnit.assertTrue(commNav.isTextPresentOnPage("no records"));
			System.out.println(resultsMsg + " - Passed");
		}
		catch (Error e) {
			System.out.println(resultsMsg + " - FAILED");
		}
		
		//Step: perform invalid Hash Tag combo search B: "#open#lost"
		hTagComboTxt = "#open#lost";
		commNav.searchListView(entityType, hTagComboTxt);
		try {
			AssertJUnit.assertTrue(commNav.isTextPresentOnPage("no records"));
			System.out.println(resultsMsg + " - Passed");
		}
		catch (Error e) {
			System.out.println(resultsMsg + " - FAILED");
		}
		
		//Step: perform invalid Hash Tag combo search C: "#open#inactive"
		hTagComboTxt = "#open#inactive";
		commNav.searchListView(entityType, hTagComboTxt);
		try {
			AssertJUnit.assertTrue(commNav.isTextPresentOnPage("no records"));
			System.out.println(resultsMsg + " - Passed");
		}
		catch (Error e) {
			System.out.println(resultsMsg + " - FAILED");
		}
		
		//Step: perform invalid Hash Tag combo search C: "#won#lost"
		hTagComboTxt = "#won#lost";
		commNav.searchListView(entityType, hTagComboTxt);
		try {
			AssertJUnit.assertTrue(commNav.isTextPresentOnPage("no records"));
			System.out.println(resultsMsg + " - Passed");
		}
		catch (Error e) {
			System.out.println(resultsMsg + " - FAILED");
		}
		
		//Step: perform invalid Hash Tag combo search C: "#won#inactive"
		hTagComboTxt = "#won#inactive";
		commNav.searchListView(entityType, hTagComboTxt);
		try {
			AssertJUnit.assertTrue(commNav.isTextPresentOnPage("no records"));
			System.out.println(resultsMsg + " - Passed");
		}
		catch (Error e) {
			System.out.println(resultsMsg + " - FAILED");
		}
		
		//Step: perform invalid Hash Tag combo search C: "#lost#inactive"
		hTagComboTxt = "#lost#inactive";
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
		
	    //Step: select the 'note' hash tag
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
		String hTagComboTxt = "#open#prospect";
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
		hTagComboTxt = "#open#qualification";
		commNav.searchListView(entityType, hTagComboTxt);
		try {
			AssertJUnit.assertFalse(commNav.isTextPresentOnPage("no records"));
			System.out.println(resultsMsg + " - Passed");
		}
		catch (Error e) {
			System.out.println(resultsMsg + " - FAILED");
		}
		
		//Step: perform invalid Hash Tag combo search C: "#open#needs-analysis"
		hTagComboTxt = "#open#needs-analysis";
		commNav.searchListView(entityType, hTagComboTxt);
		try {
			AssertJUnit.assertFalse(commNav.isTextPresentOnPage("no records"));
			System.out.println(resultsMsg + " - Passed");
		}
		catch (Error e) {
			System.out.println(resultsMsg + " - FAILED");
		}
		
		//Step: perform invalid Hash Tag combo search C: "#open#demonstration"
		hTagComboTxt = "#open#demonstration";
		commNav.searchListView(entityType, hTagComboTxt);
		try {
			AssertJUnit.assertFalse(commNav.isTextPresentOnPage("no records"));
			System.out.println(resultsMsg + " - Passed");
		}
		catch (Error e) {
			System.out.println(resultsMsg + " - FAILED");
		}
		
		//Step: perform invalid Hash Tag combo search C: "#open#negotiation"
		hTagComboTxt = "#open#negotiation";
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
		
	    //Step: select the 'note' hash tag
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
		String hTagComboTxt = "#won#prospect";
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
		hTagComboTxt = "#won#qualification";
		commNav.searchListView(entityType, hTagComboTxt);
		try {
			AssertJUnit.assertFalse(commNav.isTextPresentOnPage("no records"));
			System.out.println(resultsMsg + " - Passed");
		}
		catch (Error e) {
			System.out.println(resultsMsg + " - Warning");
		}
		
		//Step: perform invalid Hash Tag combo search C: "#won#needs-analysis"
		hTagComboTxt = "#won#needs-analysis";
		commNav.searchListView(entityType, hTagComboTxt);
		try {
			AssertJUnit.assertFalse(commNav.isTextPresentOnPage("no records"));
			System.out.println(resultsMsg + " - Passed");
		}
		catch (Error e) {
			System.out.println(resultsMsg + " - Warning");
		}
		
		//Step: perform invalid Hash Tag combo search C: "#won#demonstration"
		hTagComboTxt = "#won#demonstration";
		commNav.searchListView(entityType, hTagComboTxt);
		try {
			AssertJUnit.assertFalse(commNav.isTextPresentOnPage("no records"));
			System.out.println(resultsMsg + " - Passed");
		}
		catch (Error e) {
			System.out.println(resultsMsg + " - Warning");
		}
		
		//Step: perform invalid Hash Tag combo search C: "#won#negotiation"
		hTagComboTxt = "#won#negotiation";
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
		
	    //Step: select the 'note' hash tag
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
		String hTagComboTxt = "#lost#prospect";
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
		hTagComboTxt = "#lost#qualification";
		commNav.searchListView(entityType, hTagComboTxt);
		try {
			AssertJUnit.assertFalse(commNav.isTextPresentOnPage("no records"));
			System.out.println(resultsMsg + " - Passed");
		}
		catch (Error e) {
			System.out.println(resultsMsg + " - Warning");
		}
		
		//Step: perform invalid Hash Tag combo search C: "#lost#needs-analysis"
		hTagComboTxt = "#lost#needs-analysis";
		commNav.searchListView(entityType, hTagComboTxt);
		try {
			AssertJUnit.assertFalse(commNav.isTextPresentOnPage("no records"));
			System.out.println(resultsMsg + " - Passed");
		}
		catch (Error e) {
			System.out.println(resultsMsg + " - Warning");
		}
		
		//Step: perform invalid Hash Tag combo search C: "#lost#demonstration"
		hTagComboTxt = "#lost#demonstration";
		commNav.searchListView(entityType, hTagComboTxt);
		try {
			AssertJUnit.assertFalse(commNav.isTextPresentOnPage("no records"));
			System.out.println(resultsMsg + " - Passed");
		}
		catch (Error e) {
			System.out.println(resultsMsg + " - Warning");
		}
		
		//Step: perform invalid Hash Tag combo search C: "#lost#negotiation"
		hTagComboTxt = "#lost#negotiation";
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
		
	    //Step: select the 'note' hash tag
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
		String hTagComboTxt = "#inactive#prospect";
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
		hTagComboTxt = "#inactive#qualification";
		commNav.searchListView(entityType, hTagComboTxt);
		try {
			AssertJUnit.assertFalse(commNav.isTextPresentOnPage("no records"));
			System.out.println(resultsMsg + " - Passed");
		}
		catch (Error e) {
			System.out.println(resultsMsg + " - Warning");
		}
		
		//Step: perform invalid Hash Tag combo search C: "#inactive#needs-analysis"
		hTagComboTxt = "#inactive#needs-analysis";
		commNav.searchListView(entityType, hTagComboTxt);
		try {
			AssertJUnit.assertFalse(commNav.isTextPresentOnPage("no records"));
			System.out.println(resultsMsg + " - Passed");
		}
		catch (Error e) {
			System.out.println(resultsMsg + " - Warning");
		}
		
		//Step: perform invalid Hash Tag combo search C: "#inactive#demonstration"
		hTagComboTxt = "#inactive#demonstration";
		commNav.searchListView(entityType, hTagComboTxt);
		try {
			AssertJUnit.assertFalse(commNav.isTextPresentOnPage("no records"));
			System.out.println(resultsMsg + " - Passed");
		}
		catch (Error e) {
			System.out.println(resultsMsg + " - Warning");
		}
		
		//Step: perform invalid Hash Tag combo search C: "#inactive#negotiation"
		hTagComboTxt = "#inactive#negotiation";
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
	
}
