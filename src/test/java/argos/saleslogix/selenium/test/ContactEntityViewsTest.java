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


public class ContactEntityViewsTest extends BrowserSetup {
	
	//Test Set
	//========
	//TODO: complete conversion & unit-testing
	@Test(enabled = true)
	public void test01_SeTestTCContactListView() throws Exception {
		String methodID = "test01_SeTestTCContactListView";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerbutton = PageFactory.initElements(driver, HeaderButton.class);
		
		// Test Params:
		String entityType = "Contacts";
		String expEntityPgTitle = "Contacts";

		System.out.println(STARTLINE);
	    //Step: click Top-Left button to reveal Global Menu...
		headerbutton.showGlobalMenu();
	
	    //Step: navigate to Accounts list view...
		commNav.clickGlobalMenuItem(entityType);
		
		//Step: test Accounts, List View page elements
		// SubStep: check the Page Title
		if (commNav.isPageDisplayed(expEntityPgTitle)) {
			
			AccountViewsElements accountListView = PageFactory.initElements(driver, AccountViewsElements.class);
			
			//Step: check the Accounts Search widget elements
			commNav.checkIfWebElementPresent("Accounts List View, Search - input text box", accountListView.accountsSearchTxtBox);
			accountListView.accountsSearchTxtBox.click();
			commNav.checkIfWebElementPresent("Accounts List View, Search - input clear button", accountListView.accountsSearchClearBtn);
			commNav.checkIfWebElementPresent("Accounts List View, Search - Lookup button", accountListView.accountsSearchLookupBtn);
			
			//Step: check the Accounts list view format
			commNav.checkIfWebElementPresent("Accounts List View", accountListView.accountsListView);
			
			//Step: check an Account list view item record
			commNav.checkIfWebElementPresent("Accounts List View, item record", accountListView.topAccountsListItem);
			commNav.checkIfWebElementPresent("Accounts List View, item record icon", accountListView.topAccountsListItemIcon);
			commNav.checkIfWebElementPresent("Accounts List View, item record name", accountListView.topAccountsListItemName);
			commNav.checkIfWebElementPresent("Accounts List View, item record line 2", accountListView.topAccountsListItemLine2);
			commNav.checkIfWebElementPresent("Accounts List View, item record line 3", accountListView.topAccountsListItemLine3);
			commNav.checkIfWebElementPresent("Accounts List View, item record line 4", accountListView.topAccountsListItemLine4);
			commNav.checkIfWebElementPresent("Accounts List View, item record line 5", accountListView.topAccountsListItemLine5);
			
			//Step: check the "X records remaining" item box at the bottom of the list view
			commNav.checkIfWebElementPresent("Accounts List View, 'x remaining records' item", accountListView.recordsRemainingListItem);
		}
		else {
			System.out.println(methodID + ": required '" + expEntityPgTitle + "' not loaded; test aborted");
		}
		System.out.println(ENDLINE);
	}

	
	@Test(enabled = true)
	public void test02_SeTestTCContactListViewLoadMoreResults() throws Exception {
		String methodID = "test02_SeTestTCContactListViewLoadMoreResults";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerbutton = PageFactory.initElements(driver, HeaderButton.class);
		
		//Test Params:
		String entityType = "Contacts";

		System.out.println(STARTLINE);
	    //Step: click Top-Left button to reveal Global Menu...
		headerbutton.showGlobalMenu();
	
	    //Step: navigate to Accounts list view...
		commNav.clickGlobalMenuItem(entityType);
	
	    //Step: load more results (click on 'x remaining records' item)
		for (int count = 0; count<=2; count++) {
			WebElement remainingRecordsItem = driver.findElement(By.xpath("//*[@id='account_list']/div[3]"));
			commNav.highlightElement(remainingRecordsItem);
			remainingRecordsItem.click();
			Thread.sleep(3000);		
		}
		
		//Step: check if the 31th record item is present
		WebElement thirtyfirstRecordItem = driver.findElement(By.xpath("//*[@id='account_list']/ul/li[31]"));
		commNav.checkIfWebElementPresent("31st Account List View record available after load more records", thirtyfirstRecordItem);
		
		System.out.println(ENDLINE);
	}

	
	@Test(enabled = true)
	public void test03_SeTestTCContactListViewSearch() throws Exception {
		String methodID = "test03_SeTestTCContactListViewSearch";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		
		System.out.println(STARTLINE);
		
		//Step: search for an existing Account record
		commNav.entityListViewSearch("Contacts", "Abbott Ltd.");		
		
		System.out.println(ENDLINE);
	}
	
	
	@Test(enabled = true)
	public void test04_SeTestTCContactListViewNegativeSearch() throws Exception {
		String methodID = "test04_SeTestTCContactListViewNegativeSearch";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		System.out.println(STARTLINE);
		
		//Step: search for non-existent Account record to confirm it's non-existence
		commNav.entityListViewNegativeSearch("Contacts", "Non-Existent Account");		
		
		System.out.println(ENDLINE);
	}

	
	@Test(enabled = true)
	public void test05_SeTestTCContactListViewClearSearch() throws Exception {
		String methodID = "test05_SeTestTCContactListViewClearSearch";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);	

		System.out.println(STARTLINE);

		commNav.entityListViewSearch("Contacts", "Big Systems");
			
		//Step: check for matching results...
		AccountViewsElements accountListView = PageFactory.initElements(driver, AccountViewsElements.class);
		String topAccountListItemName = accountListView.topAccountsListItemName.getText();
				
		//Step: click the clear Search input field button
		accountListView.accountsSearchClearBtn.click();
				
		//Step: click the Lookup button to reload the full Accounts list
		accountListView.accountsSearchLookupBtn.click();
		Thread.sleep(3000);
				
		//Step: check if the previous search results were cleared
		String currTopAccountsListViewName = driver.findElement(By.xpath("//*[@id='account_list']/ul/li[1]/div/h3")).getText();
		try {
			AssertJUnit.assertEquals(topAccountListItemName, currTopAccountsListViewName);
		} catch (Error e) {
			verificationErrors.append(e.toString());
			System.out.println(methodID + ": clear previous Accounts search results action failed");
			return;
		}
		
		System.out.println(methodID + ": clear previous Accounts search results action was successful");
		System.out.println(ENDLINE);
	}

	
	@Test(enabled = true)
	public void test06_SeTestTCContactListViewOpenRecord() throws Exception {
		String methodID = "test06_SeTestTCContactListViewOpenRecord";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);
		
		System.out.println(STARTLINE);
		
		//Step: search for Account entity, then open it's Detail view
		commNav.entityRecordOpenDetailView("Contacts", "Call Color");
		
		//Step: go back to previous screen
		headerButton.goBack();
		Thread.sleep(3000);
		
		System.out.println(ENDLINE);
	}
	
	@Test(enabled = true)
	public void test07_SeTestTCContactDetailView() throws Exception {
		String methodID = "test07_SeTestTCContactDetailView";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);
		
		System.out.println(STARTLINE);
		
		//Step: search for Account entity, then open it's Detail view
		if (commNav.entityRecordOpenDetailView("Contacts", "Call Color")) {
			
		}
		else {
			
		}
		
		
		//Step: go back to previous screen
		headerButton.goBack();
		Thread.sleep(3000);
		
		System.out.println(ENDLINE);
	}

	@Test(enabled = false)
	public void test97_SeTestDEBUG() throws Exception {
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		commNav.entityRecordOpenDetailView("Contacts", "Abbott Ltd.");
	}
	
	//Login & Logout
	//==============
	@Test
	public void test00_Mobile_Login() throws InterruptedException {
		String methodID = "test00_Mobile_Login";
		
		SLXMobileLogin slxmobilelogin = PageFactory.initElements(driver, SLXMobileLogin.class);	
		
		System.out.println(STARTLINE);	
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
			assertTrue(driver.findElement(By.xpath(".//*[@id='myactivity_list']/ul/li[1]")).isDisplayed());
			System.out.println("VP: Successfully logged in to Mobile Client.");
		} catch (Error e) {
			closeAlert();
			System.out.println("Error: Unable to login to Mobile Client.");
			System.out.println(e.toString());
		}
		System.out.println(ENDLINE);	
	}

	//MARKER		
	// *******
	@Test
	public void test99_Mobile_LogOut()  throws InterruptedException {				
		String methodID = "test99_Mobile_LogOut";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerbutton = PageFactory.initElements(driver, HeaderButton.class);
		
		System.out.println(STARTLINE);
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
