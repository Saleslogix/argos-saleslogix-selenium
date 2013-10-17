/**
 * .
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
		try {
			WebElement currHashTag = notesHistoryListView.notesHistorysListView1stHashTagFilter;
			AssertJUnit.assertTrue(commNav.isWebElementPresent("default Notes/History hash-tag/filter", currHashTag));
			System.out.println("Current Notes/History hash-tags/filter: '" + currHashTag.getText() + "'");
			System.out.println(resultsMsg + " - Passed");
		}
		catch (Error e) {
			System.out.println(resultsMsg + " - Failed");
		}
		
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
		notesHistoryListView = PageFactory.initElements(driver, NotesHistoryViewsElements.class);
		resultsMsg = "VP: 'no search applied' label displayed above list view for cleared hash-tags/filters";
		WebElement currHashTag = notesHistoryListView.notesHistorysListView1stHashTagFilter;
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
		WebElement totalHistoryKPI = driver.findElement(By.xpath(".//*[@id='right_drawer']/descendant::*[text() = 'Total History']"));
		WebElement totalDurationKPI = driver.findElement(By.xpath(".//*[@id='right_drawer']/descendant::*[text() = 'Total Duration']"));
		try {
			AssertJUnit.assertTrue(commNav.isWebElementPresent("1st KPI header label", totalHistoryKPI));
			AssertJUnit.assertTrue(commNav.isWebElementPresent("2nd KPI header label", totalDurationKPI));
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
		notesHistoryListView = PageFactory.initElements(driver, NotesHistoryViewsElements.class);
		try {
			WebElement kpiTotalHistoryCard = notesHistoryListView.notesHistorysListView1stKPICard;
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
		headerButton.closeRightContextMenu();
		Thread.sleep(5000);
		
		//Section 4: Total Duration KPI metric selection
		//----------
		headerButton.showRightContextMenu();
		
		totalHistoryKPI = driver.findElement(By.xpath(".//*[@id='right_drawer']/descendant::*[text() = 'Total History']"));
		totalDurationKPI = driver.findElement(By.xpath(".//*[@id='right_drawer']/descendant::*[text() = 'Total Duration']"));
				
		//Step: select the Total Duration KPI metric
		commNav.highlightNClick(totalDurationKPI);
		headerButton.closeRightContextMenu();
		Thread.sleep(5000);
		resultsMsg = "VP: Total Duration KPI metric button is displayed above the list view";
		notesHistoryListView = PageFactory.initElements(driver, NotesHistoryViewsElements.class);
		try {
			WebElement kpiTotalDurationCard = notesHistoryListView.notesHistorysListView2ndKPICard; 
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
		
		//Step: select all default KPI metrics (Total Duration should already be pre-selected from previous test)
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
		
		//Prep: clear the previously selected KPI metrics
		headerButton.showRightContextMenu();
		commNav.rightClickContextMenuItem("Total History");
		Thread.sleep(1000);
		commNav.rightClickContextMenuItem("Total Duration");
		Thread.sleep(1000);
		headerButton.closeRightContextMenu();
		Thread.sleep(3000);
		
		//Section: Notes/History List view KPI metric & filters 
		//--------		
		//Step: KPI filter selection loop
		String selectedKpiMetric = "";
		String[] kpiMetrics = {"Total History", "Total Duration"};
		for (int iKPICount = 0;iKPICount<kpiMetrics.length;iKPICount++) {
			selectedKpiMetric = kpiMetrics[iKPICount];
			
			NotesHistoryViewsElements notesHistoryListView = PageFactory.initElements(driver, NotesHistoryViewsElements.class);
			
			//select the KPI card
			commNav.rightClickContextMenuItem(selectedKpiMetric);
			Thread.sleep(3000);
			
			//KPI filter + hashtag filter selection loop
			String hSelectedFilter = "";
			String[] hTagFilters = {"my-history", "note", "phonecall", "meeting", "personal", "email"};
			for (int iCount = 0;iCount<hTagFilters.length;iCount++) {
				hSelectedFilter = hTagFilters[iCount];
				
				//select the hash-tag filter item
				commNav.rightClickContextMenuItem(hSelectedFilter);
				Thread.sleep(5000);		
				String resultsMsg = "VP: " + selectedKpiMetric + " KPI metric card is displayed above the list view";
				
				//check the selected KPI card + hash tag filter items on the List view
				notesHistoryListView = PageFactory.initElements(driver, NotesHistoryViewsElements.class);
				try {
					WebElement selectedKPICard = notesHistoryListView.notesHistorysListView1stKPICard; 
					AssertJUnit.assertTrue(commNav.isWebElementPresent("KPI header label", selectedKPICard));
					System.out.println(resultsMsg + " - Passed");
					
					resultsMsg = "VP: selected '" + selectedKpiMetric + "' KPI card title check";
					try {
						String selectedKPICardTitle = selectedKPICard.getText();
						String regExp = "^[\\s\\S]*" + selectedKpiMetric + "[\\s\\S]*$";
						AssertJUnit.assertTrue(selectedKPICardTitle.matches(regExp));
						System.out.println(resultsMsg + " - Passed");
						
						String selectedKPICardVal = getKPICardValue(selectedKPICardTitle);
						System.out.println("'" + selectedKpiMetric + "' & #" + hSelectedFilter + " card value: " + selectedKPICardVal);
					}
					catch (Error e) {
						System.out.println(resultsMsg + " - Failed");
					}
					
					resultsMsg = "VP: selected '#" + hSelectedFilter + "' hash tag filter label check";
					try {
						WebElement hTagFilter = notesHistoryListView.notesHistorysListView1stHashTagFilter;
						AssertJUnit.assertTrue(commNav.isWebElementPresent("Hash-tag filter label", hTagFilter));
						String selectedHTagFilterLbl = "#" + hTagFilter.getText();
						String regExp = "^[\\s\\S]*" + hSelectedFilter + "[\\s\\S]*$";
						AssertJUnit.assertTrue(selectedHTagFilterLbl.matches(regExp));
						System.out.println(resultsMsg + " - Passed");
						
						System.out.println("select hash tag filter applied: '#" + hSelectedFilter + "'");
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
			
			//Step: un-select previously-selected KPI metric (test cleanup)
			headerButton.showRightContextMenu();
			commNav.rightClickContextMenuItem(selectedKpiMetric);
			Thread.sleep(3000);
			
			//Step: remove any current hash-tags/filters then perform an empty Lookup
			notesHistoryListView = PageFactory.initElements(driver, NotesHistoryViewsElements.class);
			notesHistoryListView.notesHistorysSearchTxtBox.click();
			Thread.sleep(500);
			notesHistoryListView.notesHistorysSearchClearBtn.click();
			Thread.sleep(1000);
			notesHistoryListView.notesHistorysSearchLookupBtn.click();
			Thread.sleep(5000);
			
			System.out.println("");
		}
		
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
		WebElement currHashTag = accountsListView.accountsListView1stHashTagFilter;
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
		accountsListView = PageFactory.initElements(driver, AccountViewsElements.class);
		resultsMsg = "VP: 'no search applied' label displayed above list view for cleared hash-tags/filters";
		currHashTag = accountsListView.accountsListView1stHashTagFilter;
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
		
		//Step: select the Total Revenue KPI metric
		headerButton.showRightContextMenu();
		commNav.rightClickContextMenuItem("Total Revenue");
		headerButton.closeRightContextMenu();
		Thread.sleep(5000);
		resultsMsg = "VP: Total Revenue KPI metric button is displayed above the list view";
		accountsListView = PageFactory.initElements(driver, AccountViewsElements.class);
		try {
			WebElement kpiTotalRevenueCard = accountsListView.accountsListView1stKPICard; 
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
				
		//Step: select the Total Duration KPI metric
		commNav.scrollDownPage();
		commNav.rightClickContextMenuItem("Avg Time as Customer");
		headerButton.closeRightContextMenu();
		Thread.sleep(5000);
		resultsMsg = "VP: Avg Time as Customer KPI metric button is displayed above the list view";
		try {
			WebElement kpiAvgTimeAsCustomerCard = accountsListView.accountsListView2ndKPICard;
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
		commNav.scrollDownPage();
		commNav.rightClickContextMenuItem("Avg Time as Customer");
		Thread.sleep(5000);
		
		//Section 5: Total Accounts KPI metric selection
		//----------
				
		//Step: select the Total Accounts KPI metric
		commNav.scrollDownPage();
		commNav.rightClickContextMenuItem("Total Accounts");
		headerButton.closeRightContextMenu();
		Thread.sleep(5000);
		resultsMsg = "VP: Total Accounts KPI metric button is displayed above the list view";
		try {
			WebElement kpiTotalAccountsCard = accountsListView.accountsListView3rdKPICard; 
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
			commNav.scrollDownPage();
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
		commNav.scrollDownPage();
		commNav.rightClickContextMenuItem("Avg Time as Customer");
		Thread.sleep(5000);	
			
		//END
		//---
		//Step: go back to start screen
		headerButton.closeRightContextMenu();
		commNav.clickGlobalMenuItem("My Activities");
		Thread.sleep(3000);
		
		System.out.println(ENDLINE);
	}

	//MBL10112 - KPI widgets need to work for listviews under an entity - Accounts (filtering by hash tags)
	@Test(enabled = true)
	public void test07_MBL10112_Accounts_Filtering() throws InterruptedException {
		String methodID = "test07_MBL10112_Accounts_Filtering";
		
		SLXMobileLogin slxmobilelogin = PageFactory.initElements(driver, SLXMobileLogin.class);	
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);		
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
		
		// Test Params:
		String entityType = "Accounts";
		
	    //Step: navigate to Accounts list view...
		commNav.clickGlobalMenuItem(entityType);
		
		//Prep: clear the previously selected KPI metrics
		headerButton.showRightContextMenu();
		commNav.rightClickContextMenuItem("Total Revenue");
		Thread.sleep(1000);
		commNav.rightClickContextMenuItem("Avg Time as Customer");
		Thread.sleep(1000);
		commNav.rightClickContextMenuItem("Total Accounts");
		Thread.sleep(1000);
		headerButton.closeRightContextMenu();
		Thread.sleep(3000);
	
		//Section: Accounts List view KPI metric & filters 
		//--------		
		//Step: KPI filter selection loop
		String selectedKpiMetric = "";
		String[] kpiMetrics = {"Total Revenue", "Avg Time as Customer", "Total Accounts"};
		for (int iKPICount = 0;iKPICount<kpiMetrics.length;iKPICount++) {
			selectedKpiMetric = kpiMetrics[iKPICount];
			
			AccountViewsElements accountsListView = PageFactory.initElements(driver, AccountViewsElements.class);
			
			//select the KPI card
			commNav.rightClickContextMenuItem(selectedKpiMetric);
			Thread.sleep(3000);
			
			//KPI filter + hashtag filter selection loop
			String hSelectedFilter = "";
			String[] hTagFilters = {"my-accounts", "active", "inactive", "suspect", "lead", "prospect", "customer", "partner", "vendor", "influencer", "competitor"};
			for (int iCount = 0;iCount<hTagFilters.length;iCount++) {
				hSelectedFilter = hTagFilters[iCount];
				
				//select the hash-tag filter item
				commNav.rightClickContextMenuItem(hSelectedFilter);
				Thread.sleep(5000);		
				String resultsMsg = "VP: " + selectedKpiMetric + " KPI metric card is displayed above the list view";
				try {
					WebElement selectedKPICard = accountsListView.accountsListView1stKPICard; 
					AssertJUnit.assertTrue(commNav.isWebElementPresent("KPI header label", selectedKPICard));
					System.out.println(resultsMsg + " - Passed");
					
					resultsMsg = "VP: " + selectedKpiMetric + " KPI card title check";
					accountsListView = PageFactory.initElements(driver, AccountViewsElements.class);
					try {
						String selectedKPICardTitle = selectedKPICard.getText();
						String regExp = "^[\\s\\S]*" + selectedKpiMetric + "[\\s\\S]*$";
						AssertJUnit.assertTrue(selectedKPICardTitle.matches(regExp));
						System.out.println(resultsMsg + " - Passed");
						
						String selectedKPICardVal = getKPICardValue(selectedKPICardTitle);
						System.out.println("'" + selectedKpiMetric + "' & #" + hSelectedFilter + " card value: " + selectedKPICardVal);
					}
					catch (Error e) {
						System.out.println(resultsMsg + " - Failed");
					}
					
					resultsMsg = "VP: selected '#" + hSelectedFilter + "' hash tag filter label check";
					try {
						WebElement hTagFilter = accountsListView.accountsListView1stHashTagFilter;
						AssertJUnit.assertTrue(commNav.isWebElementPresent("Hash-tag filter label", hTagFilter));
						String selectedHTagFilterLbl = "#" + hTagFilter.getText();
						String regExp = "^[\\s\\S]*" + hSelectedFilter + "[\\s\\S]*$";
						AssertJUnit.assertTrue(selectedHTagFilterLbl.matches(regExp));
						System.out.println(resultsMsg + " - Passed");
						
						System.out.println("select hash tag filter applied: '#" + hSelectedFilter + "'");
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
			commNav.rightClickContextMenuItem(selectedKpiMetric);
			Thread.sleep(3000);
			
			//Step: remove any current hash-tags/filters then perform an empty Lookup
			accountsListView = PageFactory.initElements(driver, AccountViewsElements.class);
			accountsListView.accountsSearchTxtBox.click();
			Thread.sleep(500);
			accountsListView.accountsSearchClearBtn.click();
			Thread.sleep(1000);
			accountsListView.accountsSearchLookupBtn.click();
			Thread.sleep(3000);
			
			System.out.println("");
		}
		
		//END
		//---
		//Step: go back to start screen
		commNav.clickGlobalMenuItem("My Activities");
		Thread.sleep(3000);
		
		System.out.println(ENDLINE);
	}

	//MBL10112 - KPI widgets need to work for listviews under an entity - Contacts (no filtering by hash tags)
	@Test(enabled = true)
	public void test08_MBL10112_Contacts_NoFiltering() throws InterruptedException {
		String methodID = "test08_MBL10112_Contacts_NoFiltering";
		
		SLXMobileLogin slxmobilelogin = PageFactory.initElements(driver, SLXMobileLogin.class);	
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);		
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
		
		// Test Params:
		String entityType = "Contacts";
		
	    //Step: navigate to Contacts list view...
		commNav.clickGlobalMenuItem(entityType);
		
		ContactViewsElements contactsListView = PageFactory.initElements(driver, ContactViewsElements.class);
		
		//VP: confirm that current hash-tag/filter appears above the list view
		String resultsMsg = "VP: current hash-tag/filter is displayed above the Contacts list view";
		WebElement currHashTag = contactsListView.contactsListView1stHashTagFilter;
		try {
			AssertJUnit.assertTrue(commNav.isWebElementPresent("default Contacts hash-tag/filter", currHashTag));
			System.out.println("Current Contacts hash-tags/filter: '" + currHashTag.getText() + "'");
			System.out.println(resultsMsg + " - Passed");
		}
		catch (Error e) {
			System.out.println(resultsMsg + " - Failed");
		}
		
		//Section 1: clear the default hash-tag/filter
		//----------		
		//Step: remove any current hash-tags/filters then perform a Lookup		
		headerButton.showRightContextMenu();
		contactsListView.contactsSearchTxtBox.click();
		Thread.sleep(500);
		contactsListView.contactsSearchClearBtn.click();
		Thread.sleep(1000);
		contactsListView.contactsSearchLookupBtn.click();
		Thread.sleep(1000);
		
		//VP: check that the 'no search applied' label is displayed above the list view
		contactsListView = PageFactory.initElements(driver, ContactViewsElements.class);
		resultsMsg = "VP: 'no search applied' label displayed above list view for cleared hash-tags/filters";
		currHashTag = contactsListView.contactsListView1stHashTagFilter;
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
		WebElement selectedKPI = driver.findElement(By.xpath(".//*[@id='right_drawer']/descendant::*[text() = 'Total Contacts']"));
		try {
			AssertJUnit.assertTrue(commNav.isWebElementPresent("Total Contacts KPI header label", selectedKPI));
			System.out.println(resultsMsg + " - Passed");
		}
		catch (Error e) {
			System.out.println(resultsMsg + " - Failed");
		}
		headerButton.closeRightContextMenu();
		
		//Section 3: Total Contacts KPI metric selection
		//----------
		headerButton.showRightContextMenu();
		
		//Step: select the Total Contacts KPI metric (should already be selected by default)
		String testedKPI = "Total Contacts";
		headerButton.closeRightContextMenu();
		Thread.sleep(5000);
		resultsMsg = "VP: '" + testedKPI + "' KPI metric button is displayed above the list view";
		contactsListView = PageFactory.initElements(driver, ContactViewsElements.class);
		try {
			WebElement kpiCard = contactsListView.contactsListView1stKPICard; 
			AssertJUnit.assertTrue(commNav.isWebElementPresent("KPI header label", kpiCard));
			System.out.println(resultsMsg + " - Passed");
			
			resultsMsg = "VP: '" + testedKPI + "' KPI card title check";
			try {
				String kpiCardTitle = kpiCard.getText();
				String regExp = "^[\\s\\S]*" + testedKPI + "[\\s\\S]*$";
				AssertJUnit.assertTrue(kpiCardTitle.matches(regExp));
				System.out.println(resultsMsg + " - Passed");
			}
			catch (Error e) {
				System.out.println(resultsMsg + " - Failed");
			}
			
			resultsMsg = "VP: '" + testedKPI + "' KPI Chart page check";
			commNav.highlightNClick(kpiCard);
			try {
				commNav.waitForPage(testedKPI);
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
			
		//END
		//---
		//Step: go back to start screen
		headerButton.closeRightContextMenu();
		commNav.clickGlobalMenuItem("My Activities");
		Thread.sleep(3000);
		
		System.out.println(ENDLINE);
	}

	//MBL10112 - KPI widgets need to work for listviews under an entity - Contacts (filtering by hash tags)
	@Test(enabled = true)
	public void test09_MBL10112_Contacts_Filtering() throws InterruptedException {
		String methodID = "test09_MBL10112_Contacts_Filtering";
		
		SLXMobileLogin slxmobilelogin = PageFactory.initElements(driver, SLXMobileLogin.class);	
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);		
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
		
		// Test Params:
		String entityType = "Contacts";
		
	    //Step: navigate to Contacts list view...
		commNav.clickGlobalMenuItem(entityType);
	
		//Section: Contacs List view KPI metric & filters 
		//--------		
		//Step: KPI filter selection loop
		String selectedKpiMetric = "";
		String[] kpiMetrics = {"Total Contacts"};
		for (int iKPICount = 0;iKPICount<kpiMetrics.length;iKPICount++) {
			selectedKpiMetric = kpiMetrics[iKPICount];
			
			ContactViewsElements contactsListView = PageFactory.initElements(driver, ContactViewsElements.class);
			
			//KPI filter + hashtag filter selection loop
			String hSelectedFilter = "";
			String[] hTagFilters = {"my-contacts", "primary", "not-primary", "can-email", "can-phone", "can-fax", "can-mail", "can-solicit"};
			for (int iCount = 0;iCount<hTagFilters.length;iCount++) {
				hSelectedFilter = hTagFilters[iCount];
				
				//select the hash-tag filter item
				commNav.rightClickContextMenuItem(hSelectedFilter);
				Thread.sleep(5000);		
				String resultsMsg = "VP: " + selectedKpiMetric + " KPI metric card is displayed above the list view";
				try {
					WebElement selectedKPICard = contactsListView.contactsListView1stKPICard; 
					AssertJUnit.assertTrue(commNav.isWebElementPresent("KPI header label", selectedKPICard));
					System.out.println(resultsMsg + " - Passed");
					
					resultsMsg = "VP: " + selectedKpiMetric + " KPI card title check";
					contactsListView = PageFactory.initElements(driver, ContactViewsElements.class);
					try {
						String selectedKPICardTitle = selectedKPICard.getText();
						String regExp = "^[\\s\\S]*" + selectedKpiMetric + "[\\s\\S]*$";
						AssertJUnit.assertTrue(selectedKPICardTitle.matches(regExp));
						System.out.println(resultsMsg + " - Passed");
						
						String selectedKPICardVal = getKPICardValue(selectedKPICardTitle);
						System.out.println("'" + selectedKpiMetric + "' & #" + hSelectedFilter + " card value: " + selectedKPICardVal);
					}
					catch (Error e) {
						System.out.println(resultsMsg + " - Failed");
					}
					
					resultsMsg = "VP: selected '#" + hSelectedFilter + "' hash tag filter label check";
					try {
						WebElement hTagFilter = contactsListView.contactsListView1stHashTagFilter;
						AssertJUnit.assertTrue(commNav.isWebElementPresent("Hash-tag filter label", hTagFilter));
						String selectedHTagFilterLbl = "#" + hTagFilter.getText();
						String regExp = "^[\\s\\S]*" + hSelectedFilter + "[\\s\\S]*$";
						AssertJUnit.assertTrue(selectedHTagFilterLbl.matches(regExp));
						System.out.println(resultsMsg + " - Passed");
						
						System.out.println("select hash tag filter applied: '#" + hSelectedFilter + "'");
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
			
			//Step: remove any current hash-tags/filters then perform an empty Lookup
			headerButton.showRightContextMenu();
			contactsListView.contactsSearchTxtBox.click();
			Thread.sleep(500);
			contactsListView.contactsSearchClearBtn.click();
			Thread.sleep(1000);
			contactsListView.contactsSearchLookupBtn.click();
			Thread.sleep(3000);
			
			System.out.println("");
		}
		
		//END
		//---
		//Step: go back to start screen
		commNav.clickGlobalMenuItem("My Activities");
		Thread.sleep(3000);
		
		System.out.println(ENDLINE);
	}

	//MBL10112 - KPI widgets need to work for listviews under an entity - Leads (no filtering by hash tags)
	@Test(enabled = true)
	public void test10_MBL10112_Leads_NoFiltering() throws InterruptedException {
		String methodID = "test10_MBL10112_Leads_NoFiltering";
		
		SLXMobileLogin slxmobilelogin = PageFactory.initElements(driver, SLXMobileLogin.class);	
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);		
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
		
		// Test Params:
		String entityType = "Leads";
		
	    //Step: navigate to Leads list view...
		commNav.clickGlobalMenuItem(entityType);
		
		LeadViewsElements leadsListView = PageFactory.initElements(driver, LeadViewsElements.class);
		
		//VP: confirm that current hash-tag/filter appears above the list view
		String resultsMsg = "VP: current hash-tag/filter is displayed above the Leads list view";
		WebElement currHashTag = leadsListView.leadsListView1stHashTagFilter;
		try {
			AssertJUnit.assertTrue(commNav.isWebElementPresent("default Leads hash-tag/filter", currHashTag));
			System.out.println("Current Leads hash-tags/filter: '" + currHashTag.getText() + "'");
			System.out.println(resultsMsg + " - Passed");
		}
		catch (Error e) {
			System.out.println(resultsMsg + " - Failed");
		}
		
		//Section 1: clear the default hash-tag/filter
		//----------		
		//Step: remove any current hash-tags/filters then perform a Lookup		
		headerButton.showRightContextMenu();
		leadsListView.leadsSearchTxtBox.click();
		Thread.sleep(500);
		leadsListView.leadsSearchClearBtn.click();
		Thread.sleep(1000);
		leadsListView.leadsSearchLookupBtn.click();
		Thread.sleep(1000);
		
		//VP: check that the 'no search applied' label is displayed above the list view
		leadsListView = PageFactory.initElements(driver, LeadViewsElements.class);
		resultsMsg = "VP: 'no search applied' label displayed above list view for cleared hash-tags/filters";
		currHashTag = 		leadsListView.leadsListView1stHashTagFilter;
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
		WebElement selectedKPI = driver.findElement(By.xpath(".//*[@id='right_drawer']/descendant::*[text() = 'Total Leads']"));
		try {
			AssertJUnit.assertTrue(commNav.isWebElementPresent("Total Leads KPI header label", selectedKPI));
			System.out.println(resultsMsg + " - Passed");
		}
		catch (Error e) {
			System.out.println(resultsMsg + " - Failed");
		}
		headerButton.closeRightContextMenu();
		
		//Section 3: Total Leads KPI metric selection
		//----------
		headerButton.showRightContextMenu();
		
		//Step: select the Total Leads KPI metric (should already be selected by default)
		String testedKPI = "Total Leads";
		commNav.rightClickContextMenuItem(testedKPI);
		headerButton.closeRightContextMenu();
		Thread.sleep(5000);
		resultsMsg = "VP: '" + testedKPI + "' KPI metric button is displayed above the list view";
		leadsListView = PageFactory.initElements(driver, LeadViewsElements.class);
		try {
			WebElement kpiCard = leadsListView.leadsListView1stKPICard; 
			AssertJUnit.assertTrue(commNav.isWebElementPresent("KPI header label", kpiCard));
			System.out.println(resultsMsg + " - Passed");
			
			resultsMsg = "VP: '" + testedKPI + "' KPI card title check";
			try {
				String kpiCardTitle = kpiCard.getText();
				String regExp = "^[\\s\\S]*" + testedKPI + "[\\s\\S]*$";
				AssertJUnit.assertTrue(kpiCardTitle.matches(regExp));
				System.out.println(resultsMsg + " - Passed");
			}
			catch (Error e) {
				System.out.println(resultsMsg + " - Failed");
			}
			
			resultsMsg = "VP: '" + testedKPI + "' KPI Chart page check";
			commNav.highlightNClick(kpiCard);
			try {
				commNav.waitForPage(testedKPI);
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
			
		//END
		//---
		//Step: go back to start screen
		headerButton.closeRightContextMenu();
		commNav.clickGlobalMenuItem("My Activities");
		Thread.sleep(3000);
		
		System.out.println(ENDLINE);
	}

	//MBL10112 - KPI widgets need to work for listviews under an entity - Leads (filtering by hash tags)
	@Test(enabled = true)
	public void test11_MBL10112_Leads_Filtering() throws InterruptedException {
		String methodID = "test11_MBL10112_Leads_Filtering";
		
		SLXMobileLogin slxmobilelogin = PageFactory.initElements(driver, SLXMobileLogin.class);	
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);		
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
		
		// Test Params:
		String entityType = "Leads";
		
	    //Step: navigate to Leads list view...
		commNav.clickGlobalMenuItem(entityType);
	
		//Section: Leads List view KPI metric & filters 
		//--------		
		//Step: KPI filter selection loop
		String selectedKpiMetric = "";
		String[] kpiMetrics = {"Total Leads"};
		for (int iKPICount = 0;iKPICount<kpiMetrics.length;iKPICount++) {
			selectedKpiMetric = kpiMetrics[iKPICount];
			
			LeadViewsElements leadsListView = PageFactory.initElements(driver, LeadViewsElements.class);
			
			commNav.rightClickContextMenuItem(selectedKpiMetric);
			
			//KPI filter + hashtag filter selection loop
			String hSelectedFilter = "";
			String[] hTagFilters = {"my-leads", "can-email", "can-phone", "can-fax", "can-mail", "can-solicit"};
			for (int iCount = 0;iCount<hTagFilters.length;iCount++) {
				hSelectedFilter = hTagFilters[iCount];
				
				//select the hash-tag filter item
				commNav.rightClickContextMenuItem(hSelectedFilter);
				Thread.sleep(5000);		
				String resultsMsg = "VP: " + selectedKpiMetric + " KPI metric card is displayed above the list view";
				try {
					WebElement selectedKPICard = leadsListView.leadsListView1stKPICard; 
					AssertJUnit.assertTrue(commNav.isWebElementPresent("KPI header label", selectedKPICard));
					System.out.println(resultsMsg + " - Passed");
					
					resultsMsg = "VP: " + selectedKpiMetric + " KPI card title check";
					leadsListView = PageFactory.initElements(driver, LeadViewsElements.class);
					try {
						String selectedKPICardTitle = selectedKPICard.getText();
						String regExp = "^[\\s\\S]*" + selectedKpiMetric + "[\\s\\S]*$";
						AssertJUnit.assertTrue(selectedKPICardTitle.matches(regExp));
						System.out.println(resultsMsg + " - Passed");
						
						String selectedKPICardVal = getKPICardValue(selectedKPICardTitle);
						System.out.println("'" + selectedKpiMetric + "' & #" + hSelectedFilter + " card value: " + selectedKPICardVal);
					}
					catch (Error e) {
						System.out.println(resultsMsg + " - Failed");
					}
					
					resultsMsg = "VP: selected '#" + hSelectedFilter + "' hash tag filter label check";
					try {
						WebElement hTagFilter = leadsListView.leadsListView1stHashTagFilter;
						AssertJUnit.assertTrue(commNav.isWebElementPresent("Hash-tag filter label", hTagFilter));
						String selectedHTagFilterLbl = "#" + hTagFilter.getText();
						String regExp = "^[\\s\\S]*" + hSelectedFilter + "[\\s\\S]*$";
						AssertJUnit.assertTrue(selectedHTagFilterLbl.matches(regExp));
						System.out.println(resultsMsg + " - Passed");
						
						System.out.println("select hash tag filter applied: '#" + hSelectedFilter + "'");
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
			
			//Step: remove any current hash-tags/filters then perform an empty Lookup
			headerButton.showRightContextMenu();
			leadsListView.leadsSearchTxtBox.click();
			Thread.sleep(500);
			leadsListView.leadsSearchClearBtn.click();
			Thread.sleep(1000);
			leadsListView.leadsSearchLookupBtn.click();
			Thread.sleep(3000);
			
			System.out.println("");
		}
		
		//END
		//---
		//Step: go back to start screen
		commNav.clickGlobalMenuItem("My Activities");
		Thread.sleep(3000);
		
		System.out.println(ENDLINE);
	}

	//MBL10112 - KPI widgets need to work for listviews under an entity - Opportunities (no filtering by hash tags)
	@Test(enabled = true)
	public void test12_MBL10112_Opportunities_NoFiltering() throws InterruptedException {
		String methodID = "test12_MBL10112_Opportunities_NoFiltering";
		
		SLXMobileLogin slxmobilelogin = PageFactory.initElements(driver, SLXMobileLogin.class);	
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);		
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
		
		// Test Params:
		String entityType = "Opportunities";
		int KPIIndex = 5;
		
	    //Step: navigate to Opportunities list view...
		commNav.clickGlobalMenuItem(entityType);
		
		OpportunityViewsElements opportunitiesListView = PageFactory.initElements(driver, OpportunityViewsElements.class);
		
		//VP: confirm that current hash-tag/filter appears above the list view
		String resultsMsg = "VP: current hash-tag/filter is displayed above the Opportunities list view";
		WebElement currHashTag = opportunitiesListView.opportunityListView1stHashTagFilter;
		try {
			AssertJUnit.assertTrue(commNav.isWebElementPresent("default Leads hash-tag/filter", currHashTag));
			System.out.println("Current Leads hash-tags/filter: '" + currHashTag.getText() + "'");
			System.out.println(resultsMsg + " - Passed");
		}
		catch (Error e) {
			System.out.println(resultsMsg + " - Failed");
		}
		
		//Section 1: clear the default hash-tag/filter
		//----------		
		//Step: remove any current hash-tags/filters then perform a Lookup		
		headerButton.showRightContextMenu();
		opportunitiesListView.opportunitySearchTxtBox.click();
		Thread.sleep(500);
		opportunitiesListView.opportunitySearchClearBtn.click();
		Thread.sleep(1000);
		opportunitiesListView.opportunitySearchLookupBtn.click();
		Thread.sleep(1000);
		
		//VP: check that the 'no search applied' label is displayed above the list view
		opportunitiesListView = PageFactory.initElements(driver, OpportunityViewsElements.class);
		resultsMsg = "VP: 'no search applied' label displayed above list view for cleared hash-tags/filters";
		currHashTag = 		opportunitiesListView.opportunityListView1stHashTagFilter;
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
		WebElement totalOppsKPI = driver.findElement(By.xpath(".//*[@id='right_drawer']/descendant::*[text() = 'Total Opportunities']"));
		WebElement salesPotentialKPI = driver.findElement(By.xpath(".//*[@id='right_drawer']/descendant::*[text() = 'Sales Potential']"));
		try {
			AssertJUnit.assertTrue(commNav.isWebElementPresent("Total Opportunties KPI header label", totalOppsKPI));
			AssertJUnit.assertTrue(commNav.isWebElementPresent("Sales Potential KPI header label", salesPotentialKPI));
			System.out.println(resultsMsg + " - Passed");
		}
		catch (Error e) {
			System.out.println(resultsMsg + " - Failed");
		}
		headerButton.closeRightContextMenu();
		
		//Section 3: Total Opportunities KPI metric selection
		//----------
		String selectedKpiMetric = "";
		String[] kpiMetrics = {"Total Opportunities", "Sales Potential"};
		for (int iKPICount = 0;iKPICount<kpiMetrics.length;iKPICount++) {
			selectedKpiMetric = kpiMetrics[iKPICount];		
		
			//Step: select the KPI metric (should be un-selected by default)
			commNav.rightClickContextMenuItem(selectedKpiMetric);
			headerButton.closeRightContextMenu();
			Thread.sleep(5000);
			resultsMsg = "VP: '" + selectedKpiMetric + "' KPI metric button is displayed above the list view";
			opportunitiesListView = PageFactory.initElements(driver, OpportunityViewsElements.class);
			String kpiCardXpath = "//div[" + (KPIIndex + iKPICount) + "]/div[2]/div/button";
			try {
				WebElement kpiCard = driver.findElement(By.xpath(kpiCardXpath));
				AssertJUnit.assertTrue(commNav.isWebElementPresent("KPI header label", kpiCard));
				System.out.println(resultsMsg + " - Passed");
				
				resultsMsg = "VP: '" + selectedKpiMetric + "' KPI card title check";
				try {
					String kpiCardTitle = kpiCard.getText();
					String regExp = "^[\\s\\S]*" + selectedKpiMetric + "[\\s\\S]*$";
					AssertJUnit.assertTrue(kpiCardTitle.matches(regExp));
					System.out.println(resultsMsg + " - Passed");
				}
				catch (Error e) {
					System.out.println(resultsMsg + " - Failed");
				}
				
				resultsMsg = "VP: '" + selectedKpiMetric + "' KPI Chart page check";
				commNav.highlightNClick(kpiCard);
				try {
					commNav.waitForPage(selectedKpiMetric);
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
			
			//Step: un-select the KPI item
			headerButton.showRightContextMenu();
			commNav.rightClickContextMenuItem(selectedKpiMetric);
			headerButton.closeRightContextMenu();
			Thread.sleep(5000);
		}
		
		//END
		//---
		//Step: go back to start screen
		headerButton.closeRightContextMenu();
		commNav.clickGlobalMenuItem("My Activities");
		Thread.sleep(3000);
		
		System.out.println(ENDLINE);
	}

	//MBL10112 - KPI widgets need to work for listviews under an entity - Opportunities (filtering by hash tags)
	@Test(enabled = true)
	public void test13_MBL10112_Opportunities_Filtering() throws InterruptedException {
		String methodID = "test13_MBL10112_Opportunities_Filtering";
		
		SLXMobileLogin slxmobilelogin = PageFactory.initElements(driver, SLXMobileLogin.class);	
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);		
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
		
		// Test Params:
		String entityType = "Opportunities";
		int KPIIndex = 5;
		
	    //Step: navigate to Opportunities list view...
		commNav.clickGlobalMenuItem(entityType);
	
		//Section: Opportunities List view KPI metric & filters 
		//--------		
		//Step: KPI filter selection loop
		String selectedKpiMetric = "";
		String[] kpiMetrics = {"Total Opportunities", "Sales Potential"};
		for (int iKPICount = 0;iKPICount<kpiMetrics.length;iKPICount++) {
			selectedKpiMetric = kpiMetrics[iKPICount];
			
			OpportunityViewsElements opportunitiesListView = PageFactory.initElements(driver, OpportunityViewsElements.class);
			
			commNav.rightClickContextMenuItem(selectedKpiMetric);
			
			//KPI filter + hashtag filter selection loop
			String hSelectedFilter = "";
			String[] hTagFilters = {"my-opportunities", "open", "won", "lost", "inactive", "prospect", "qualification", "needs-analysis", "demonstration", "negotiation", "decision"};
			for (int iCount = 0;iCount<hTagFilters.length;iCount++) {
				hSelectedFilter = hTagFilters[iCount];
				
				//select the hash-tag filter item
				commNav.rightClickContextMenuItem(hSelectedFilter);
				Thread.sleep(5000);		
				String resultsMsg = "VP: " + selectedKpiMetric + " KPI metric card is displayed above the list view";
				String kpiCardXpath = "//div[" + (KPIIndex + iKPICount) + "]/div[2]/div/button";
				try {
					//WebElement selectedKPICard = driver.findElement(By.xpath(kpiCardXpath));
					WebElement selectedKPICard = opportunitiesListView.opportunityListView1stKPICard; 
					AssertJUnit.assertTrue(commNav.isWebElementPresent("KPI header label", selectedKPICard));
					System.out.println(resultsMsg + " - Passed");
					
					resultsMsg = "VP: " + selectedKpiMetric + " KPI card title check";
					opportunitiesListView = PageFactory.initElements(driver, OpportunityViewsElements.class);
					try {
						String selectedKPICardTitle = selectedKPICard.getText();
						String regExp = "^[\\s\\S]*" + selectedKpiMetric + "[\\s\\S]*$";
						AssertJUnit.assertTrue(selectedKPICardTitle.matches(regExp));
						System.out.println(resultsMsg + " - Passed");
						
						String selectedKPICardVal = getKPICardValue(selectedKPICardTitle);
						System.out.println("'" + selectedKpiMetric + "' & #" + hSelectedFilter + " card value: " + selectedKPICardVal);
					}
					catch (Error e) {
						System.out.println(resultsMsg + " - Failed");
					}
					
					resultsMsg = "VP: selected '#" + hSelectedFilter + "' hash tag filter label check";
					try {
						WebElement hTagFilter = opportunitiesListView.opportunityListView1stHashTagFilter;
						AssertJUnit.assertTrue(commNav.isWebElementPresent("Hash-tag filter label", hTagFilter));
						String selectedHTagFilterLbl = "#" + hTagFilter.getText();
						String regExp = "^[\\s\\S]*" + hSelectedFilter + "[\\s\\S]*$";
						AssertJUnit.assertTrue(selectedHTagFilterLbl.matches(regExp));
						System.out.println(resultsMsg + " - Passed");
						
						System.out.println("select hash tag filter applied: '#" + hSelectedFilter + "'");
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
			
			//Step: remove any current hash-tags/filters then perform an empty Lookup
			headerButton.showRightContextMenu();
			commNav.rightClickContextMenuItem(selectedKpiMetric);
			opportunitiesListView.opportunitySearchTxtBox.click();
			Thread.sleep(500);
			opportunitiesListView.opportunitySearchClearBtn.click();
			Thread.sleep(1000);
			opportunitiesListView.opportunitySearchLookupBtn.click();
			Thread.sleep(3000);
			
			System.out.println("");
		}
		
		//END
		//---
		//Step: go back to start screen
		commNav.clickGlobalMenuItem("My Activities");
		Thread.sleep(3000);
		
		System.out.println(ENDLINE);
	}

	//MBL10112 - KPI widgets need to work for listviews under an entity - Tickets (no filtering by hash tags)
	@Test(enabled = false)
	public void test14_MBL10112_Tickets_NoFiltering() throws InterruptedException {
		String methodID = "test14_MBL10112_Tickets_NoFiltering";
		
		SLXMobileLogin slxmobilelogin = PageFactory.initElements(driver, SLXMobileLogin.class);	
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);		
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
		
		// Test Params:
		String entityType = "Tickets";
		int KPIIndex = 4;
		
	    //Step: navigate to Tickets list view...
		commNav.clickGlobalMenuItem(entityType);
		
		TicketViewsElements ticketsListView = PageFactory.initElements(driver, TicketViewsElements.class);
		
		//VP: confirm that current hash-tag/filter appears above the list view
		String resultsMsg = "VP: current hash-tag/filter is displayed above the Tickets list view";
		WebElement currHashTag = ticketsListView.ticketsListView1stHashTagFilter;
		try {
			AssertJUnit.assertTrue(commNav.isWebElementPresent("default Leads hash-tag/filter", currHashTag));
			System.out.println("Current Leads hash-tags/filter: '" + currHashTag.getText() + "'");
			System.out.println(resultsMsg + " - Passed");
		}
		catch (Error e) {
			System.out.println(resultsMsg + " - Failed");
		}
		
		//Section 1: clear the default hash-tag/filter
		//----------		
		//Step: remove any current hash-tags/filters then perform a Lookup		
		headerButton.showRightContextMenu();
		ticketsListView.ticketsSearchTxtBox.click();
		Thread.sleep(500);
		ticketsListView.ticketsSearchClearBtn.click();
		Thread.sleep(1000);
		ticketsListView.ticketsSearchLookupBtn.click();
		Thread.sleep(1000);
		
		//VP: check that the 'no search applied' label is displayed above the list view
		ticketsListView = PageFactory.initElements(driver, TicketViewsElements.class);
		resultsMsg = "VP: 'no search applied' label displayed above list view for cleared hash-tags/filters";
		currHashTag = 		ticketsListView.ticketsListView1stHashTagFilter;
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
		WebElement totalTicktsKPI = driver.findElement(By.xpath(".//*[@id='right_drawer']/descendant::*[text() = 'Total Tickets']"));
		WebElement openAgeAvgKPI = driver.findElement(By.xpath(".//*[@id='right_drawer']/descendant::*[text() = 'Open Age Average']"));
		try {
			AssertJUnit.assertTrue(commNav.isWebElementPresent("Total Opportunties KPI header label", totalTicktsKPI));
			AssertJUnit.assertTrue(commNav.isWebElementPresent("Sales Potential KPI header label", openAgeAvgKPI));
			System.out.println(resultsMsg + " - Passed");
		}
		catch (Error e) {
			System.out.println(resultsMsg + " - Failed");
		}
		headerButton.closeRightContextMenu();
		
		//Section 3: Total Tickets KPI metric selection
		//----------
		String selectedKpiMetric = "";
		String[] kpiMetrics = {"Total Tickets", "Open Age Average"};
		for (int iKPICount = 0;iKPICount<kpiMetrics.length;iKPICount++) {
			selectedKpiMetric = kpiMetrics[iKPICount];		
		
			//Step: select the KPI metric (should be un-selected by default)
			commNav.rightClickContextMenuItem(selectedKpiMetric);
			headerButton.closeRightContextMenu();
			Thread.sleep(5000);
			resultsMsg = "VP: '" + selectedKpiMetric + "' KPI metric button is displayed above the list view";
			ticketsListView = PageFactory.initElements(driver, TicketViewsElements.class);
			String kpiCardXpath = "//div[" + (KPIIndex + iKPICount) + "]/div[2]/div/button";
			try {
				WebElement kpiCard = driver.findElement(By.xpath(kpiCardXpath));
				AssertJUnit.assertTrue(commNav.isWebElementPresent("KPI header label", kpiCard));
				System.out.println(resultsMsg + " - Passed");
				
				resultsMsg = "VP: '" + selectedKpiMetric + "' KPI card title check";
				try {
					String kpiCardTitle = kpiCard.getText();
					String regExp = "^[\\s\\S]*" + selectedKpiMetric + "[\\s\\S]*$";
					AssertJUnit.assertTrue(kpiCardTitle.matches(regExp));
					System.out.println(resultsMsg + " - Passed");
				}
				catch (Error e) {
					System.out.println(resultsMsg + " - Failed");
				}
				
				resultsMsg = "VP: '" + selectedKpiMetric + "' KPI Chart page check";
				commNav.highlightNClick(kpiCard);
				try {
					commNav.waitForPage(selectedKpiMetric);
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
			
			//Step: un-select the KPI item
			headerButton.showRightContextMenu();
			commNav.rightClickContextMenuItem(selectedKpiMetric);
			headerButton.closeRightContextMenu();
			Thread.sleep(5000);
		}
		
		//END
		//---
		//Step: go back to start screen
		headerButton.closeRightContextMenu();
		commNav.clickGlobalMenuItem("My Activities");
		Thread.sleep(3000);
		
		System.out.println(ENDLINE);
	}

	//MBL10112 - KPI widgets need to work for listviews under an entity - Tickets (filtering by hash tags)
	@Test(enabled = true)
	public void test15_MBL10112_Tickets_Filtering() throws InterruptedException {
		String methodID = "test15_MBL10112_Tickets_Filtering";
		
		SLXMobileLogin slxmobilelogin = PageFactory.initElements(driver, SLXMobileLogin.class);	
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);		
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
		
		// Test Params:
		String entityType = "Tickets";
		int KPIIndex = 4;
		
	    //Step: navigate to Tickets list view...
		commNav.clickGlobalMenuItem(entityType);
	
		//Section: Tickets List view KPI metric & filters 
		//--------		
		//Step: KPI filter selection loop
		String selectedKpiMetric = "";
		String[] kpiMetrics = {"Total Tickets", "Open Age Average"};
		for (int iKPICount = 0;iKPICount<kpiMetrics.length;iKPICount++) {
			selectedKpiMetric = kpiMetrics[iKPICount];
			
			TicketViewsElements ticketsListView = PageFactory.initElements(driver, TicketViewsElements.class);
			
			commNav.rightClickContextMenuItem(selectedKpiMetric);
			
			//KPI filter + hashtag filter selection loop
			String hSelectedFilter = "";
			String[] hTagFilters = {"assigned-to-me", "completed-by-me"};
			for (int iCount = 0;iCount<hTagFilters.length;iCount++) {
				hSelectedFilter = hTagFilters[iCount];
				
				//select the hash-tag filter item
				commNav.rightClickContextMenuItem(hSelectedFilter);
				Thread.sleep(5000);		
				String resultsMsg = "VP: " + selectedKpiMetric + " KPI metric card is displayed above the list view";
				//String kpiCardXpath = "//div[" + (KPIIndex + iKPICount) + "]/div[2]/div/button";
				try {
					//WebElement selectedKPICard = driver.findElement(By.xpath(kpiCardXpath));
					WebElement selectedKPICard = ticketsListView.ticketsListView1stKPICard; 
					AssertJUnit.assertTrue(commNav.isWebElementPresent("KPI header label", selectedKPICard));
					System.out.println(resultsMsg + " - Passed");
					
					resultsMsg = "VP: " + selectedKpiMetric + " KPI card title check";
					ticketsListView = PageFactory.initElements(driver, TicketViewsElements.class);
					try {
						String selectedKPICardTitle = selectedKPICard.getText();
						String regExp = "^[\\s\\S]*" + selectedKpiMetric + "[\\s\\S]*$";
						AssertJUnit.assertTrue(selectedKPICardTitle.matches(regExp));
						System.out.println(resultsMsg + " - Passed");
						
						String selectedKPICardVal = getKPICardValue(selectedKPICardTitle);
						System.out.println("'" + selectedKpiMetric + "' & #" + hSelectedFilter + " card value: " + selectedKPICardVal);
					}
					catch (Error e) {
						System.out.println(resultsMsg + " - Failed");
					}
					
					resultsMsg = "VP: selected '#" + hSelectedFilter + "' hash tag filter label check";
					try {
						WebElement hTagFilter = ticketsListView.ticketsListView1stHashTagFilter;
						AssertJUnit.assertTrue(commNav.isWebElementPresent("Hash-tag filter label", hTagFilter));
						String selectedHTagFilterLbl = "#" + hTagFilter.getText();
						String regExp = "^[\\s\\S]*" + hSelectedFilter + "[\\s\\S]*$";
						AssertJUnit.assertTrue(selectedHTagFilterLbl.matches(regExp));
						System.out.println(resultsMsg + " - Passed");
						
						System.out.println("select hash tag filter applied: '#" + hSelectedFilter + "'");
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
			
			//Step: remove any current hash-tags/filters then perform an empty Lookup
			headerButton.showRightContextMenu();
			commNav.rightClickContextMenuItem(selectedKpiMetric);
			ticketsListView.ticketsSearchTxtBox.click();
			Thread.sleep(500);
			ticketsListView.ticketsSearchClearBtn.click();
			Thread.sleep(1000);
			ticketsListView.ticketsSearchLookupBtn.click();
			Thread.sleep(3000);
			
			System.out.println("");
		}
		
		//END
		//---
		//Step: go back to start screen
		commNav.clickGlobalMenuItem("My Activities");
		Thread.sleep(3000);
		
		System.out.println(ENDLINE);
	}
}
