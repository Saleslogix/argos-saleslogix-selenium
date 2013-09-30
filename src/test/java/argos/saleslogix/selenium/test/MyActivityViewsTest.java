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
public class MyActivityViewsTest extends BrowserSetup {
	
	//Test Methods Set
	//================
	@Test(enabled = true)
	public void test01_SeTestTCMyActivitiesListView() throws Exception {
		//Reference: MBL-10071
		String methodID = "test01_SeTestTCMyActivitiesListView";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerbutton = PageFactory.initElements(driver, HeaderButton.class);
		
		// Test Params:
		String entityType = "My Activities";
		String expEntityPgTitle = "My Activities";
		String regardingRecord = "Staff Meeting";
	
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
	    //Step: click Top-Left button to reveal Global Menu...
		headerbutton.showGlobalMenu();
	
	    //Step: navigate to Opportunity list view...
		commNav.entityListViewSearch(entityType, regardingRecord);
		
		//Step: test the My Activities, List View page elements
		// SubStep: check the Page Title
		if (commNav.isPageDisplayed(entityType)) {
			
			MyActivityViewsElements myActivitiesListView = PageFactory.initElements(driver, MyActivityViewsElements.class);			
			
			//Step: check the My Activities List view, Card Layout
			commNav.checkIfWebElementPresent("My Activites List View, Card Layout", myActivitiesListView.myActivitiesListView);
						
			//Step: check an Opportunity list view item record
			commNav.checkIfWebElementPresent("My Activites List View Card Layout, item record", myActivitiesListView.topMyActivitiesListItem);
			commNav.checkIfWebElementPresent("My Activites List View Card Layout, item record Tab", myActivitiesListView.topMyActivitiesListItemTab);
			commNav.checkIfWebElementPresent("My Activites List View Card Layout, item record Icon", myActivitiesListView.topMyActivitiesListItemIcon);
			commNav.checkIfWebElementPresent("My Activites List View Card Layout, item record Regarding", myActivitiesListView.topMyActivitiesListItemRegarding);
			commNav.checkIfWebElementPresent("My Activites List View Card Layout, item record Start Time", myActivitiesListView.topMyActivitiesListItemStartTime);
			commNav.checkIfWebElementPresent("My Activites List View Card Layout, item record Contact & Account", myActivitiesListView.topMyActivitiesListItemContactAccount);
			commNav.checkIfWebElementPresent("My Activites List View Card Layout, item record Phone", myActivitiesListView.topMyActivitiesListItemPhone);
			commNav.checkIfWebElementPresent("My Activites List View Card Layout, item record Alarm Icon", myActivitiesListView.topMyActivitiesListItemAlarm);
			commNav.checkIfWebElementPresent("My Activites List View Card Layout, item record Touch Icon", myActivitiesListView.topMyActivitiesListItemTouch);
			commNav.checkIfWebElementPresent("My Activites List View Card Layout, item record Touch Bang", myActivitiesListView.topMyActivitiesListItemBang);
			commNav.checkIfWebElementPresent("My Activites List View Card Layout, item record Touch Recurring", myActivitiesListView.topMyActivitiesListItemRecurring);
			commNav.checkIfWebElementPresent("My Activites List View Card Layout, item record Touch Type", myActivitiesListView.topMyActivitiesListItemType);
			
			//Step: check the Quick Action button and items
			try {
				//click Quick Action button to reveal Quick Action items
				commNav.checkIfWebElementPresent("My Activites List View, Card Layout, Quick Action button", myActivitiesListView.topMyActivitiesListItemQuickActionsBtn);
				myActivitiesListView.topMyActivitiesListItemQuickActionsBtn.click();
				
				//click the Quick Action button, then check each of the Quick Action items
				commNav.checkIfWebElementPresent("My Activites List View Card Layout, Quick Action Add Attachment button", myActivitiesListView.topMyActivitiesListItemQuickActionsAddAttachmentBtn);
				commNav.checkIfWebElementPresent("My Activites List View Card Layout, Quick Action Call button", myActivitiesListView.topMyActivitiesListItemQuickActionsCallBtn);
				commNav.checkIfWebElementPresent("My Activites List View Card Layout, Quick Action Decline button", myActivitiesListView.topMyActivitiesListItemQuickActionsDeclineBtn);
				commNav.checkIfWebElementPresent("My Activites List View Card Layout, Quick Action Accept button", myActivitiesListView.topMyActivitiesListItemQuickActionsAcceptBtn);
				commNav.checkIfWebElementPresent("My Activites List View Card Layout, Quick Action Complete button", myActivitiesListView.topMyActivitiesListItemQuickActionsCompleteBtn);
				commNav.checkIfWebElementPresent("My Activites List View Card Layout, Quick Action Contact button", myActivitiesListView.topMyActivitiesListItemQuickActionsContactBtn);
				commNav.checkIfWebElementPresent("My Activites List View Card Layout, Quick Action Oportunity button", myActivitiesListView.topMyActivitiesListItemQuickActionsOpportunityBtn);
				commNav.checkIfWebElementPresent("My Activites List View Card Layout, Quick Action Account button", myActivitiesListView.topMyActivitiesListItemQuickActionsAccountBtn);
				
				//click Quick Action button to hide the Quick Action items
				myActivitiesListView.topMyActivitiesListItemQuickActionsBtn.click();
			}
			catch (Exception e) {
				System.out.println(e.toString());				
			}
			
			//Step: check the "X records remaining" item box at the bottom of the list view
			//commNav.checkIfWebElementPresent("My Activites List View, Card Layout, 'x remaining records' item", accountListView.recordsRemainingListItem);
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
}
