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
public class TicketViewsTest extends BrowserSetup {
	
	//Test Methods Set
	//================
	@Test(enabled = true)
	public void test01_SeTestTCTicketListView() throws Exception {
		//Reference: MBL-10049
		String methodID = "test01_SeTestTCTicketListView";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerbutton = PageFactory.initElements(driver, HeaderButton.class);
		
		// Test Params:
		String entityType = "Tickets";
		String expEntityPgTitle = "Tickets";
		String ticketRecord = "000-00-000011";
	
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
			commNav.checkIfWebElementPresent("Ticket List View, item record Tab", ticketsListView.topTicketsListItemTab);
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
				//click Quick Action button to reveal Quick Action items
				commNav.checkIfWebElementPresent("Ticket List View, Quick Action button", ticketsListView.topTicketsListItemQuickActionsBtn);
				ticketsListView.topTicketsListItemQuickActionsBtn.click();
				
				//click the Quick Action button, then check each of the Quick Action items
				commNav.checkIfWebElementPresent("Ticket, Quick Action Add Attachment button", ticketsListView.topTicketsListItemQuickActionsAddAttachmentBtn);
				commNav.checkIfWebElementPresent("Ticket, Quick Action Add Activity button", ticketsListView.topTicketsListItemQuickActionsAddActivityBtn);
				commNav.checkIfWebElementPresent("Ticket, Quick Action Add Note button", ticketsListView.topTicketsListItemQuickActionsAddNoteBtn);
				commNav.checkIfWebElementPresent("Ticket, Quick Action Contacts button", ticketsListView.topTicketsListItemQuickActionsContactBtn);
				commNav.checkIfWebElementPresent("Ticket, Quick Action Accounts button", ticketsListView.topTicketsListItemQuickActionsAccountBtn);
				commNav.checkIfWebElementPresent("Ticket, Quick Action Edit button", ticketsListView.topTicketsListItemQuickActionsEditBtn);
				
				//click Quick Action button to hide the Quick Action items
				ticketsListView.topTicketsListItemQuickActionsBtn.click();
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
		try {
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


	@Test(enabled = true)
	public void test13_SeTestTCTicketListViewNotesBox() throws Exception {
		//Reference: MBL-10042
		String methodID = "test13_SeTestTCTicketListViewNotesBox";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);
		
		// Test Params:
		String entityType = "Tickets";
		String expEntityPgTitle = "Tickets";
		String entityRecord = "001-00-000026";
	
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
	
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
}
