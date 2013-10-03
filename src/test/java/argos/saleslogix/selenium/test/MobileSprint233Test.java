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
	
	public String getKPICardValue(String fullKPICardVal) {
		
		String[] segStrArray = fullKPICardVal.split("\n");
		String cardValue = segStrArray[1];

		return cardValue;
	}

	//MBL10006 - After opening widget and pressing back arrow, not taken to expected listview per scenario
	@Test(enabled = false)
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
		// del this line later
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

	//MBL10112 - KPI widgets need to work for listviews under an entity - Notes/History (no filtering by hash tags)
	@Test(enabled = true)
	public void test04_MBL10112_NotesHistory_NoFiltering() throws InterruptedException {
		String methodID = "test04_MBL10112_NotesHistory_NoFiltering";
		
		SLXMobileLogin slxmobilelogin = PageFactory.initElements(driver, SLXMobileLogin.class);	
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);		
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
		
		// Test Params:
		String entityType = "Notes/History";
		
	    //Step: navigate to Notes/History list view...
		commNav.clickGlobalMenuItem(entityType);
		
		NotesHistoryViewsElements notesHistoryListView = PageFactory.initElements(driver, NotesHistoryViewsElements.class);
		
		//VP: confirm that current hash-tag/filter appears above the list view
		String resultsMsg = "VP: current hash-tag/filter is displayed above the Notes/History list view";
		/*
		WebElement currHashTag = driver.findElement(By.xpath(".//*[@id='history_list_search-expression']/div"));
		try {
			AssertJUnit.assertTrue(commNav.isWebElementPresent("default Notes/History hash-tag/filter", currHashTag));
			System.out.println("Current Notes/History hash-tags/filter: '" + currHashTag.getText() + "'");
			System.out.println(resultsMsg + " - Passed");
		}
		catch (Error e) {
			System.out.println(resultsMsg + " - Failed");
		}
		*/
		
		//Section 1: clear the default hash-tag/filter
		//----------		
		//Step: remove any current hash-tags/filters then perform a Lookup		
		headerButton.showRightContextMenu();
		notesHistoryListView.notesHistorysSearchTxtBox.click();
		Thread.sleep(500);
		notesHistoryListView.notesHistorysSearchClearBtn.click();
		Thread.sleep(1000);
		notesHistoryListView.notesHistorysSearchLookupBtn.click();
		Thread.sleep(1000);
		
		//VP: check that the 'no search applied' label is displayed above the list view
		/*
		resultsMsg = "VP: 'no search applied' label displayed above list view for cleared hash-tags/filters";
		WebElement currHashTag = driver.findElement(By.xpath(".//*[@id='history_list_search-expression']/div"));
		String expLblTxt = currHashTag.getText();
		try {
			AssertJUnit.assertTrue(expLblTxt.equals("no search applied"));
			System.out.println(resultsMsg + " - Passed");
		}
		catch (Error e) {
			System.out.println(resultsMsg + " - Failed");
		}
		*/
		
		//Section 2: KPI metrics
		//----------
		headerButton.showRightContextMenu();
		
		//Step: verify the KPI section header
		resultsMsg = "VP: KPI header label is displayed in right-context menu";
		WebElement KPIHeaderXPath = driver.findElement(By.xpath(".//*[@id='right_drawer']/descendant::*[text() = 'KPI']"));
		String headerLbl = KPIHeaderXPath.getText();
		try {
			AssertJUnit.assertTrue(commNav.isWebElementPresent("KPI header label", KPIHeaderXPath));			
			System.out.println(resultsMsg + " - Passed");
		}
		catch (Error e) {
			System.out.println(resultsMsg + " - Failed");
		}
		
		//Step: verify the removal of KPI Configure link
		resultsMsg = "VP: KPI Configure link is not displayed in right-context menu";
		try {
			AssertJUnit.assertTrue(driver.findElements(By.xpath(".//*[@id='right_drawer']/descendant::*[text() = 'Configure']")).size() == 0);			
			System.out.println(resultsMsg + " - Passed");
		}
		catch (Error e) {
			System.out.println(resultsMsg + " - Failed");
		}
		
		//Step: verify the KPI metric items
		resultsMsg = "VP: KPI metric items are available in right-context menu";
		WebElement totalHistoryKPI = driver.findElement(By.xpath(".//*[@id='right_drawer']/descendant::*[text() = 'Total History']"));
		WebElement totalDurationKPI = driver.findElement(By.xpath(".//*[@id='right_drawer']/descendant::*[text() = 'Total Duration']"));
		try {
			AssertJUnit.assertTrue(commNav.isWebElementPresent("KPI header label", totalHistoryKPI));
			AssertJUnit.assertTrue(commNav.isWebElementPresent("KPI header label", totalDurationKPI));
			System.out.println(resultsMsg + " - Passed");
		}
		catch (Error e) {
			System.out.println(resultsMsg + " - Failed");
		}
		headerButton.closeRightContextMenu();
		
		//Section 3: Total History KPI metric selection
		//----------
		headerButton.showRightContextMenu();
		
		totalHistoryKPI = driver.findElement(By.xpath(".//*[@id='right_drawer']/descendant::*[text() = 'Total History']"));
		totalDurationKPI = driver.findElement(By.xpath(".//*[@id='right_drawer']/descendant::*[text() = 'Total Duration']"));
		
		//Step: un-select all KPI metrics (test prep)
		commNav.highlightNClick(totalHistoryKPI);
		commNav.highlightNClick(totalDurationKPI);
		headerButton.closeRightContextMenu();
		Thread.sleep(5000);
		
		//Step: select the Total History KPI metric
		headerButton.showRightContextMenu();
		commNav.highlightNClick(totalHistoryKPI);
		headerButton.closeRightContextMenu();
		Thread.sleep(5000);
		resultsMsg = "VP: Total History KPI metric button is displayed above the list view";
		try {
			WebElement kpiTotalHistoryCard = driver.findElement(By.xpath("//div[19]/div[2]/div/button")); 
			AssertJUnit.assertTrue(commNav.isWebElementPresent("KPI header label", kpiTotalHistoryCard));
			System.out.println(resultsMsg + " - Passed");
			
			resultsMsg = "VP: Total History KPI card title check";
			try {
				String kpiTotalHistoryCardTitle = kpiTotalHistoryCard.getText();
				String regExp = "^[\\s\\S]*" + "Total History" + "[\\s\\S]*$";
				AssertJUnit.assertTrue(kpiTotalHistoryCardTitle.matches(regExp));
				System.out.println(resultsMsg + " - Passed");
			}
			catch (Error e) {
				System.out.println(resultsMsg + " - Failed");
			}
			
			resultsMsg = "VP: Total History KPI Chart page check";
			commNav.highlightNClick(kpiTotalHistoryCard);
			try {
				commNav.waitForPage("Total History");
				WebElement kpiTotalHistoryChart = driver.findElement(By.id("chart_generic_bar"));
				System.out.println(resultsMsg + " - Passed");
			}
			catch (NoSuchElementException e) {
				System.out.println(resultsMsg + " - Failed");
			}
			headerButton.clickHeaderButton("back");
		}
		catch (NoSuchElementException e) {
			System.out.println(e.toString());
			System.out.println(resultsMsg + " - Failed");
		}
		
		//Step: un-select all KPI metrics (test cleanup)
		commNav.rightClickContextMenuItem("Total History");
		Thread.sleep(5000);
		
		//Section 4: Total Duration KPI metric selection
		//----------
		headerButton.showRightContextMenu();
		
		totalHistoryKPI = driver.findElement(By.xpath(".//*[@id='right_drawer']/descendant::*[text() = 'Total History']"));
		totalDurationKPI = driver.findElement(By.xpath(".//*[@id='right_drawer']/descendant::*[text() = 'Total Duration']"));
				
		//Step: select the Total Duration KPI metric
		headerButton.showRightContextMenu();
		commNav.highlightNClick(totalDurationKPI);
		headerButton.closeRightContextMenu();
		Thread.sleep(5000);
		resultsMsg = "VP: Total Duration KPI metric button is displayed above the list view";
		try {
			WebElement kpiTotalDurationCard = driver.findElement(By.xpath("//div[19]/div[2]/div/button")); 
			AssertJUnit.assertTrue(commNav.isWebElementPresent("KPI header label", kpiTotalDurationCard));
			System.out.println(resultsMsg + " - Passed");
			
			resultsMsg = "VP: Total Duration KPI card title check";
			try {
				String kpiTotalHistoryCardTitle = kpiTotalDurationCard.getText();
				String regExp = "^[\\s\\S]*" + "Total Duration" + "[\\s\\S]*$";
				AssertJUnit.assertTrue(kpiTotalHistoryCardTitle.matches(regExp));
				System.out.println(resultsMsg + " - Passed");
			}
			catch (Error e) {
				System.out.println(resultsMsg + " - Failed");
			}
			
			resultsMsg = "VP: Total Duration KPI Chart page check";
			commNav.highlightNClick(kpiTotalDurationCard);
			try {
				commNav.waitForPage("Total Duration");
				WebElement kpiTotalHistoryChart = driver.findElement(By.id("chart_generic_bar"));
				System.out.println(resultsMsg + " - Passed");
			}
			catch (NoSuchElementException e) {
				System.out.println(resultsMsg + " - Failed");
			}
			headerButton.clickHeaderButton("back");
		}
		catch (NoSuchElementException e) {
			System.out.println(e.toString());
			System.out.println(resultsMsg + " - Failed");
		}
		
		//Step: select all default KPI metrics (test cleanup)
		commNav.rightClickContextMenuItem("Total History");
		Thread.sleep(5000);	
			
		//END
		//---
		//Step: go back to start screen
		commNav.clickGlobalMenuItem("My Activities");
		Thread.sleep(3000);
		
		System.out.println(ENDLINE);
	}
	//MBL10112 - KPI widgets need to work for listviews under an entity - Notes/History (filtering by hash tags)
	@Test(enabled = true)
	public void test05_MBL10112_NotesHistory_Filtering() throws InterruptedException {
		String methodID = "test04_MBL10112_NotesHistory_Filtering";
		
		SLXMobileLogin slxmobilelogin = PageFactory.initElements(driver, SLXMobileLogin.class);	
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);		
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
		
		// Test Params:
		String entityType = "Notes/History";
		
	    //Step: navigate to Notes/History list view...
		commNav.clickGlobalMenuItem(entityType);
		
		NotesHistoryViewsElements notesHistoryListView = PageFactory.initElements(driver, NotesHistoryViewsElements.class);
	
		//Section 1: Total History KPI metric & filters 
		//----------
		//Step: un-select only the Total Duration KPI metric (this should leave Total History KPI selected)
		commNav.rightClickContextMenuItem("Total Duration");
		Thread.sleep(5000);
		
		//Step: select each filter
		String hSelectedFilter = "";
		String[] hTagFilters = {"note", "phonecall", "meeting", "personal", "email"};
		for (int iCount = 1;iCount<hTagFilters.length;iCount++) {
			hSelectedFilter = hTagFilters[iCount];
			commNav.rightClickContextMenuItem(hSelectedFilter);
			Thread.sleep(3000);		
			String resultsMsg = "VP: Total History KPI metric card is displayed above the list view with #'" + hSelectedFilter + " filter";
			try {
				WebElement kpiTotalHistoryCard = driver.findElement(By.xpath("//div[19]/div[2]/div/button")); 
				AssertJUnit.assertTrue(commNav.isWebElementPresent("KPI header label", kpiTotalHistoryCard));
				System.out.println(resultsMsg + " - Passed");
				
				resultsMsg = "VP: Total History KPI card title check";
				try {
					String kpiTotalHistoryCardTitle = kpiTotalHistoryCard.getText();
					String regExp = "^[\\s\\S]*" + "Total History" + "[\\s\\S]*$";
					AssertJUnit.assertTrue(kpiTotalHistoryCardTitle.matches(regExp));
					System.out.println(resultsMsg + " - Passed");
					
					String kpiTotalHistoryCardVal = getKPICardValue(kpiTotalHistoryCardTitle);
					System.out.println("KPI Total History & #" + hSelectedFilter + " card value: " + kpiTotalHistoryCardVal);
				}
				catch (Error e) {
					System.out.println(resultsMsg + " - Failed");
				}
			}
			catch (NoSuchElementException e) {
				System.out.println(e.toString());
				System.out.println(resultsMsg + " - Failed");
			}
		}
		
		//Step: un-select all KPI metrics (test cleanup)
		headerButton.showRightContextMenu();
		commNav.rightClickContextMenuItem("Total History");
		Thread.sleep(3000);
		
		//Step: remove any current hash-tags/filters then perform a Lookup
		notesHistoryListView = PageFactory.initElements(driver, NotesHistoryViewsElements.class);
		notesHistoryListView.notesHistorysSearchTxtBox.click();
		Thread.sleep(500);
		notesHistoryListView.notesHistorysSearchClearBtn.click();
		Thread.sleep(1000);
		notesHistoryListView.notesHistorysSearchLookupBtn.click();
		Thread.sleep(3000);
		
		System.out.println("");
		
		//Section 2: Total Duration KPI metric & filters 
		//----------
		//Step: select the Total Duration KPI metric		
		commNav.rightClickContextMenuItem("Total Duration");
		Thread.sleep(5000);
		
		//Step: select each filter
		hSelectedFilter = "";
		for (int iCount = 1;iCount<hTagFilters.length;iCount++) {
			hSelectedFilter = hTagFilters[iCount];
			commNav.rightClickContextMenuItem(hSelectedFilter);
			Thread.sleep(3000);		
			String resultsMsg = "VP: Total Duration KPI metric card is displayed above the list view with #'" + hSelectedFilter + " filter";
			try {
				WebElement kpiTotalDurationCard = driver.findElement(By.xpath("//div[19]/div[2]/div/button")); 
				AssertJUnit.assertTrue(commNav.isWebElementPresent("KPI header label", kpiTotalDurationCard));
				System.out.println(resultsMsg + " - Passed");
				
				resultsMsg = "VP: Total Duration KPI card title check";
				try {
					String kpiTotalDurationCardTitle = kpiTotalDurationCard.getText();
					String regExp = "^[\\s\\S]*" + "Total Duration" + "[\\s\\S]*$";
					AssertJUnit.assertTrue(kpiTotalDurationCardTitle.matches(regExp));
					System.out.println(resultsMsg + " - Passed");
					
					String kpiTotalHistoryCardVal = getKPICardValue(kpiTotalDurationCardTitle);
					System.out.println("KPI Total Duration & #" + hSelectedFilter + " card value: " + kpiTotalHistoryCardVal);
				}
				catch (Error e) {
					System.out.println(resultsMsg + " - Failed");
				}
			}
			catch (NoSuchElementException e) {
				System.out.println(e.toString());
				System.out.println(resultsMsg + " - Failed");
			}
		}
		
		//Step: re-select all KPI metrics (test cleanup)
		headerButton.showRightContextMenu();
		commNav.rightClickContextMenuItem("Total History");
		Thread.sleep(3000);
		
		//Step: remove any current hash-tags/filters then perform a Lookup
		notesHistoryListView = PageFactory.initElements(driver, NotesHistoryViewsElements.class);
		notesHistoryListView.notesHistorysSearchTxtBox.click();
		Thread.sleep(500);
		notesHistoryListView.notesHistorysSearchClearBtn.click();
		Thread.sleep(1000);
		notesHistoryListView.notesHistorysSearchLookupBtn.click();
		Thread.sleep(3000);
		
		//END
		//---
		//Step: go back to start screen
		commNav.clickGlobalMenuItem("My Activities");
		Thread.sleep(3000);
		
		System.out.println(ENDLINE);
	}

	//MBL10112 - KPI widgets need to work for listviews under an entity - Accounts (no filtering by hash tags)
	@Test(enabled = true)
	public void test06_MBL10112_Accounts_NoFiltering() throws InterruptedException {
		String methodID = "test06_MBL10112_Accounts_NoFiltering";
		
		SLXMobileLogin slxmobilelogin = PageFactory.initElements(driver, SLXMobileLogin.class);	
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);		
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
		
		// Test Params:
		String entityType = "Accounts";
		
	    //Step: navigate to Accounts list view...
		commNav.clickGlobalMenuItem(entityType);
		
		AccountViewsElements accountsListView = PageFactory.initElements(driver, AccountViewsElements.class);
		
		//VP: confirm that current hash-tag/filter appears above the list view
		String resultsMsg = "VP: current hash-tag/filter is displayed above the Accounts list view";
		WebElement currHashTag = driver.findElement(By.xpath(".//*[@id='account_list_search-expression']/div"));
		try {
			AssertJUnit.assertTrue(commNav.isWebElementPresent("default Accounts hash-tag/filter", currHashTag));
			System.out.println("Current Accounts hash-tags/filter: '" + currHashTag.getText() + "'");
			System.out.println(resultsMsg + " - Passed");
		}
		catch (Error e) {
			System.out.println(resultsMsg + " - Failed");
		}
		
		//Section 1: clear the default hash-tag/filter
		//----------		
		//Step: remove any current hash-tags/filters then perform a Lookup		
		headerButton.showRightContextMenu();
		accountsListView.accountsSearchTxtBox.click();
		Thread.sleep(500);
		accountsListView.accountsSearchClearBtn.click();
		Thread.sleep(1000);
		accountsListView.accountsSearchLookupBtn.click();
		Thread.sleep(1000);
		
		//VP: check that the 'no search applied' label is displayed above the list view
		resultsMsg = "VP: 'no search applied' label displayed above list view for cleared hash-tags/filters";
		currHashTag = driver.findElement(By.xpath(".//*[@id='account_list_search-expression']/div"));
		String expLblTxt = currHashTag.getText();
		try {
			AssertJUnit.assertTrue(expLblTxt.equals("no search applied"));
			System.out.println(resultsMsg + " - Passed");
		}
		catch (Error e) {
			System.out.println(resultsMsg + " - Failed");
		}
		
		//Section 2: KPI metrics
		//----------
		headerButton.showRightContextMenu();
		
		//Step: verify the KPI section header
		resultsMsg = "VP: KPI header label is displayed in right-context menu";
		WebElement KPIHeaderXPath = driver.findElement(By.xpath(".//*[@id='right_drawer']/descendant::*[text() = 'KPI']"));
		String headerLbl = KPIHeaderXPath.getText();
		try {
			AssertJUnit.assertTrue(commNav.isWebElementPresent("KPI header label", KPIHeaderXPath));			
			System.out.println(resultsMsg + " - Passed");
		}
		catch (Error e) {
			System.out.println(resultsMsg + " - Failed");
		}
		
		//Step: verify the removal of KPI Configure link
		resultsMsg = "VP: KPI Configure link is not displayed in right-context menu";
		try {
			AssertJUnit.assertTrue(driver.findElements(By.xpath(".//*[@id='right_drawer']/descendant::*[text() = 'Configure']")).size() == 0);			
			System.out.println(resultsMsg + " - Passed");
		}
		catch (Error e) {
			System.out.println(resultsMsg + " - Failed");
		}
		
		//Step: verify the KPI metric items
		resultsMsg = "VP: KPI metric items are available in right-context menu";
		WebElement totalRevenuKPI = driver.findElement(By.xpath(".//*[@id='right_drawer']/descendant::*[text() = 'Total Revenue']"));
		WebElement avgTimeAsCustomerKPI = driver.findElement(By.xpath(".//*[@id='right_drawer']/descendant::*[text() = 'Avg Time as Customer']"));
		WebElement totalAccountsKPI = driver.findElement(By.xpath(".//*[@id='right_drawer']/descendant::*[text() = 'Total Accounts']"));
		try {
			AssertJUnit.assertTrue(commNav.isWebElementPresent("Total Revenue KPI header label", totalRevenuKPI));
			AssertJUnit.assertTrue(commNav.isWebElementPresent("Avg Time as Customer KPI header label", avgTimeAsCustomerKPI));
			AssertJUnit.assertTrue(commNav.isWebElementPresent("Total Accounts KPI header label", totalAccountsKPI));
			System.out.println(resultsMsg + " - Passed");
		}
		catch (Error e) {
			System.out.println(resultsMsg + " - Failed");
		}
		headerButton.closeRightContextMenu();
		
		//Section 3: Total Revenue KPI metric selection
		//----------
		headerButton.showRightContextMenu();
		
		totalRevenuKPI = driver.findElement(By.xpath(".//*[@id='right_drawer']/descendant::*[text() = 'Total Revenue']"));
		
		//Step: un-select all KPI metrics (test prep)
		commNav.rightClickContextMenuItem("Total Revenue");
		commNav.rightClickContextMenuItem("Avg Time as Customer");
		commNav.rightClickContextMenuItem("Total Accounts");
		headerButton.closeRightContextMenu();
		Thread.sleep(5000);
		
		//Step: select the Total Revenue KPI metric
		headerButton.showRightContextMenu();
		commNav.highlightNClick(totalRevenuKPI);
		headerButton.closeRightContextMenu();
		Thread.sleep(5000);
		resultsMsg = "VP: Total Revenue KPI metric button is displayed above the list view";
		try {
			WebElement kpiTotalRevenueCard = driver.findElement(By.xpath("//div[75]/div[2]/div/button")); 
			AssertJUnit.assertTrue(commNav.isWebElementPresent("KPI header label", kpiTotalRevenueCard));
			System.out.println(resultsMsg + " - Passed");
			
			resultsMsg = "VP: Total Revenue KPI card title check";
			try {
				String kpiTotalRevenueCardTitle = kpiTotalRevenueCard.getText();
				String regExp = "^[\\s\\S]*" + "Total Revenue" + "[\\s\\S]*$";
				AssertJUnit.assertTrue(kpiTotalRevenueCardTitle.matches(regExp));
				System.out.println(resultsMsg + " - Passed");
			}
			catch (Error e) {
				System.out.println(resultsMsg + " - Failed");
			}
			
			resultsMsg = "VP: Total Revenue KPI Chart page check";
			commNav.highlightNClick(kpiTotalRevenueCard);
			try {
				commNav.waitForPage("Total Revenue");
				WebElement kpiChart = driver.findElement(By.id("chart_generic_bar"));
				System.out.println(resultsMsg + " - Passed");
			}
			catch (NoSuchElementException e) {
				System.out.println(resultsMsg + " - Failed");
			}
			headerButton.clickHeaderButton("back");
		}
		catch (NoSuchElementException e) {
			System.out.println(e.toString());
			System.out.println(resultsMsg + " - Failed");
		}
		
		//Step: un-select KPI metric (test cleanup)
		commNav.rightClickContextMenuItem("Total Revenue");
		Thread.sleep(5000);
		
		//Section 4: Avg Time as Customer KPI metric selection
		//----------
		headerButton.showRightContextMenu();
		
		avgTimeAsCustomerKPI = driver.findElement(By.xpath(".//*[@id='right_drawer']/descendant::*[text() = 'Avg Time as Customer']"));
				
		//Step: select the Total Duration KPI metric
		headerButton.showRightContextMenu();
		commNav.highlightNClick(avgTimeAsCustomerKPI);
		headerButton.closeRightContextMenu();
		Thread.sleep(5000);
		resultsMsg = "VP: Avg Time as Customer KPI metric button is displayed above the list view";
		try {
			WebElement kpiAvgTimeAsCustomerCard = driver.findElement(By.xpath("//div[75]/div[2]/div/button")); 
			AssertJUnit.assertTrue(commNav.isWebElementPresent("KPI header label", kpiAvgTimeAsCustomerCard));
			System.out.println(resultsMsg + " - Passed");
			
			resultsMsg = "VP: Avg Time as Customer KPI card title check";
			try {
				String kpiAvgTimeAsCustomerTitle = kpiAvgTimeAsCustomerCard.getText();
				String regExp = "^[\\s\\S]*" + "Avg Time as Customer" + "[\\s\\S]*$";
				AssertJUnit.assertTrue(kpiAvgTimeAsCustomerTitle.matches(regExp));
				System.out.println(resultsMsg + " - Passed");
			}
			catch (Error e) {
				System.out.println(resultsMsg + " - Failed");
			}
			
			resultsMsg = "VP: Avg Time as Customer KPI Chart page check";
			commNav.highlightNClick(kpiAvgTimeAsCustomerCard);
			try {
				commNav.waitForPage("Avg Time as Customer");
				WebElement kpiChart = driver.findElement(By.id("chart_generic_bar"));
				System.out.println(resultsMsg + " - Passed");
			}
			catch (NoSuchElementException e) {
				System.out.println(resultsMsg + " - Failed");
			}
			headerButton.clickHeaderButton("back");
		}
		catch (NoSuchElementException e) {
			System.out.println(e.toString());
			System.out.println(resultsMsg + " - Failed");
		}
		
		//Step: un-select KPI metric (test cleanup)
		commNav.rightClickContextMenuItem("Avg Time as Customer");
		Thread.sleep(5000);
		
		//Section 5: Total Accounts KPI metric selection
		//----------
		headerButton.showRightContextMenu();
		
		totalAccountsKPI = driver.findElement(By.xpath(".//*[@id='right_drawer']/descendant::*[text() = 'Total Accounts']"));
				
		//Step: select the Total Accounts KPI metric
		headerButton.showRightContextMenu();
		commNav.highlightNClick(totalAccountsKPI);
		headerButton.closeRightContextMenu();
		Thread.sleep(5000);
		resultsMsg = "VP: Total Accounts KPI metric button is displayed above the list view";
		try {
			WebElement kpiTotalAccountsCard = driver.findElement(By.xpath("//div[75]/div[2]/div/button")); 
			AssertJUnit.assertTrue(commNav.isWebElementPresent("KPI header label", kpiTotalAccountsCard));
			System.out.println(resultsMsg + " - Passed");
			
			resultsMsg = "VP: Total Accounts KPI card title check";
			try {
				String kpiTotalAccountsTitle = kpiTotalAccountsCard.getText();
				String regExp = "^[\\s\\S]*" + "Total Accounts" + "[\\s\\S]*$";
				AssertJUnit.assertTrue(kpiTotalAccountsTitle.matches(regExp));
				System.out.println(resultsMsg + " - Passed");
			}
			catch (Error e) {
				System.out.println(resultsMsg + " - Failed");
			}
			
			resultsMsg = "VP: Total Accounts KPI Chart page check";
			commNav.highlightNClick(kpiTotalAccountsCard);
			try {
				commNav.waitForPage("Total Accounts");
				WebElement kpiChart = driver.findElement(By.id("chart_generic_bar"));
				System.out.println(resultsMsg + " - Passed");
			}
			catch (NoSuchElementException e) {
				System.out.println(resultsMsg + " - Failed");
			}
			headerButton.clickHeaderButton("back");
		}
		catch (NoSuchElementException e) {
			System.out.println(e.toString());
			System.out.println(resultsMsg + " - Failed");
		}
		
		//Step: select all default KPI metrics (test cleanup)
		commNav.rightClickContextMenuItem("Total Revenue");
		commNav.rightClickContextMenuItem("Avg Time as Customer");
		commNav.rightClickContextMenuItem("Total Accounts");
		Thread.sleep(5000);	
			
		//END
		//---
		//Step: go back to start screen
		commNav.clickGlobalMenuItem("My Activities");
		Thread.sleep(3000);
		
		System.out.println(ENDLINE);
	}
}
