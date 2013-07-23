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
		
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
		
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
		
		commNav.searchListView("notes/history", regardingFldSearchVal);
		try {
			AssertJUnit.assertTrue(commNav.isTextPresentOnPage(regardingFldSearchVal));
			System.out.println(resultMsg + "' - Passed");
		}
		catch (Error e) {
			System.out.println(e.toString());
			System.out.println(resultMsg + "' - FAILED");
		}
				
		System.out.println(ENDLINE);
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
	
}
