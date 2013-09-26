/**
 * 
 */
package argos.saleslogix.selenium.test;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.AssertJUnit;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;


/**
 * @author mllena
 *
 */
public class MobileSprint233Test extends BrowserSetup {

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

	//MBL10006 - After opening widget and pressing back arrow, not taken to expected listview per scenario
	@Test(enabled = true)
	public void test01_MBL10006() throws Exception {
		String methodID = "test01_MBL10006";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);
				
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
		
		//Section 1:
		String entityType = "accounts";
		
	    //Step: navigate to Accounts list view...
		commNav.clickGlobalMenuItem(entityType);		
		AccountViewsElements accountsListView = PageFactory.initElements(driver, AccountViewsElements.class);
		
		//Step: select Total Revenue KPI
		String KPI1 = "Total Revenue";
		commNav.rightClickContextMenuItem(KPI1);
		headerButton.closeRightContextMenu();
		/*
		String resultMsg = "VP: Accounts - " + KPI1 + " KPI was selected";
		try {
			AssertJUnit.assertEquals(KPI1, driver.findElement(By.xpath("//*[@id='Mobile_SalesLogix_Views_MetricWidget_0']/button/div[1]")).getText());
			System.out.println(resultMsg + " - Passed");
		}
		catch (Error e){
			System.out.println(e.toString());
			System.out.println(resultMsg + " - Failed");
		}
		*/
		
		//Step: select Total Accounts KPI
		String KPI2 = "Total Accounts";
		commNav.rightClickContextMenuItem(KPI2);
		headerButton.closeRightContextMenu();
		/*
		resultMsg = "VP: Accounts - " + KPI2 + " KPI was selected";
		try {
			AssertJUnit.assertEquals(KPI2, driver.findElement(By.xpath("//*[@id='Mobile_SalesLogix_Views_MetricWidget_2']/button/div[1]")).getText());
			System.out.println(resultMsg + " - Passed");
		}
		catch (Error e){
			System.out.println(e.toString());
			System.out.println(resultMsg + " - Failed");
		}
		*/
		
		//Section 2:
		entityType = "contacts";
		
	    //Step: navigate to Contacts list view...
		commNav.clickGlobalMenuItem(entityType);
		ContactViewsElements contactsListView = PageFactory.initElements(driver, ContactViewsElements.class);
	
		//Step: select Total Contacts KPI
		String KPI3 = "Total Contacts";
		commNav.rightClickContextMenuItem(KPI3);
		headerButton.closeRightContextMenu();
		/*
		resultMsg = "VP: Contacts - " + KPI3 + " KPI was selected";
		try {
			AssertJUnit.assertEquals(KPI1, driver.findElement(By.xpath("//*[@id='Mobile_SalesLogix_Views_MetricWidget_3']/button/div[1]")).getText());
			System.out.println(resultMsg + " - Passed");
		}
		catch (Error e){
			System.out.println(e.toString());
			System.out.println(resultMsg + " - Failed");
		}
		*/
		
		//Step: confirm that Contacts List view is still displayed
		String resultMsg = "VP: Contacts List view was displayed";
		try {
			AssertJUnit.assertTrue(driver.findElement(By.id("contact_list")).isDisplayed());
			System.out.println(resultMsg + " - Passed");
		}
		catch (Error e){
			System.out.println(e.toString());
			System.out.println(resultMsg + " - Failed");
		}
		
		//Step: go back to My Activities view
		commNav.clickGlobalMenuItem("My Activities");
		
		System.out.println(ENDLINE);
	}

	//MBL10115 - Index filtering Selection in Contextual menu
	@Test(enabled = true)
	public void test02_MBL10115() throws Exception {
		String methodID = "test02_MBL10115";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);
		
		// Test Params:
		String searchItem = "software";
		String indexFilter = "";
		String resultsMsg = "";
		String[] indexFilters = {"Account", "Activity", "Contact", "History", "Lead", "Opportunity", "Ticket"};
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
		
	    //Step: perform SpeedSearch
		commNav.searchListView("SpeedSearch", searchItem);
		
		//Step: select index filter
		for (int iCount = 0;iCount<indexFilters.length;iCount++) {
			indexFilter = indexFilters[iCount];
			resultsMsg = "VP: Index filter - " + indexFilter + " succesfully filtered the SpeedSearch results";
			commNav.rightClickContextMenuItem(indexFilter);
			if (commNav.isTextPresentOnPage(indexFilter)) {
				System.out.println(resultsMsg + " - Passed");
				commNav.rightClickContextMenuItem(indexFilter);
			}
			else {
				System.out.println(resultsMsg + " - FAILED");
			}
		}
				
		//Step: go back to previous screen
		commNav.clickGlobalMenuItem("My Activities");
		Thread.sleep(3000);
		
		System.out.println(ENDLINE);
	}

	//MBL10222 - Update Login Screen to include Logo
	@Test(enabled = true)
	public void test03_MBL10222() throws InterruptedException {
		String methodID = "test03_MBL10222";
		
		SLXMobileLogin slxmobilelogin = PageFactory.initElements(driver, SLXMobileLogin.class);	
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
					
		//VP: Login Page Name
		Thread.sleep(1000);	
		try {
			AssertJUnit.assertTrue(commNav.isPageDisplayed(fullProdName));
			System.out.println("VP: Login Page Name check - Passed");
		} 
		catch (Error e) {
			System.out.println("Error: Login Page Name check - FAILED");
			verificationErrors.append(e.toString());
		}
		
		//VP: product logo
		try {
			AssertJUnit.assertTrue(commNav.isElementDisplayed(By.xpath(".//*[@id='login']/p/img")));
			System.out.println("VP: 'saleslog!x' logo check  - Passed");
		}
		catch (Error e) {
			System.out.println("Error: product logo check - FAILED");
			verificationErrors.append(e.toString());
		}		
		
		// Step: Enter username and password then click the logon button		
		slxmobilelogin.doLogin(userName, userPwd, true);
			
		System.out.println(ENDLINE);
	}

	//MBL10222 - KPI widgets need to work for listviews under an entity - Notes/History
	@Test(enabled = false)
	public void test04_MBL10112_NotesHistory() throws InterruptedException {
		String methodID = "test04_MBL10112_NotesHistory";
		
		SLXMobileLogin slxmobilelogin = PageFactory.initElements(driver, SLXMobileLogin.class);	
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);		
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
		
		// Test Params:
		String entityType = "Notes/History";
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
		
	    //Step: navigate to Notes/History list view...
		commNav.clickGlobalMenuItem(entityType);
		
		NotesHistoryViewsElements notesHistoryListView = PageFactory.initElements(driver, NotesHistoryViewsElements.class);
		
		//VP: confirm that current hash-tag/filter appears above the list view
		String resultsMsg = "VP: current hash-tag/filter is displayed above the Notes/History list view";
		WebElement currHashTag = driver.findElement(By.xpath(".//*[@id='history_list_search-expression']/div"));
		try {
			AssertJUnit.assertTrue(commNav.isWebElementPresent("default Notes/History hash-tag/filter", currHashTag));
			System.out.println("Current Notes/History hash-tags/filter: '" + currHashTag.getText() + "'");
			System.out.println(resultsMsg + " - Passed");
		}
		catch (Error e) {
			System.out.println(resultsMsg + " - Failed");
		}
		
		//Step: remove any current hash-tags/filters then perform a Lookup		
		headerButton.showRightContextMenu();
		notesHistoryListView.notesHistorysSearchTxtBox.click();
		Thread.sleep(500);
		notesHistoryListView.notesHistorysSearchClearBtn.click();
		Thread.sleep(1000);
		notesHistoryListView.notesHistorysSearchLookupBtn.click();
		Thread.sleep(1000);
		
		//VP: check that the 'no search applied' label is displayed above the list view
		//.//*[@id='history_list_search-expression']/div
		resultsMsg = "VP: 'no search applied' label displayed above list view for cleared hash-tags/filters";
		String expLblTxt = currHashTag.getText();
		try {
			AssertJUnit.assertTrue(expLblTxt.equals("no search applied"));
			System.out.println(resultsMsg + " - Passed");
		}
		catch (Error e) {
			System.out.println(resultsMsg + " - Failed");
		}
			
		System.out.println(ENDLINE);
	}
}
