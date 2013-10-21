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
public class OpportunityViewsTest extends BrowserSetup {
	
	//Test Methods Set
	//================
	@Test(enabled = true)
	public void test01_SeTestTCOpportunityListView() throws Exception {
		//Reference: MBL-10049
		String methodID = "test01_SeTestTCOpportunityListView";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerbutton = PageFactory.initElements(driver, HeaderButton.class);
		
		// Test Params:
		String entityType = "Opportunities";
		String expEntityPgTitle = "Opportunities";
		String oppRecord = "Abbott WorldWide-Phase I";

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
	public void test13_SeTestTCOpportunityListViewNotesBox() throws Exception {
		//Reference: MBL-10042
		String methodID = "test13_SeTestTCOpportunityListViewNotesBox";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);
		
		// Test Params:
		String entityType = "Opportunities";
		String expEntityPgTitle = "Opportunities";
		String entityRecord = "Abbott WorldWide-Phase I";
	
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
	
	    //Step: navigate to Opportunities list view...
		commNav.entityListViewSearch(entityType, entityRecord);
		
		//Step: test Opportunities, List View page elements
		// SubStep: check the Page Title
		if (commNav.isPageDisplayed(entityType)) {
			
			OpportunityViewsElements opportunityListView = PageFactory.initElements(driver, OpportunityViewsElements.class);			
			
			//Step: check the Opportunities list view format
			commNav.checkIfWebElementPresent("Opportunities List View", opportunityListView.opportunityListViewPnl);
			
			//Step: check an Account list view item record
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
				System.out.println(e.toString());
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
