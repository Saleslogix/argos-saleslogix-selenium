package argos.saleslogix.selenium.test;

import static org.testng.AssertJUnit.assertEquals;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.testng.AssertJUnit;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import argos.saleslogix.selenium.test.CommonNavigation;
import argos.saleslogix.selenium.test.HeaderButton;
import argos.saleslogix.selenium.test.SLXMobileLogin;
import argos.saleslogix.selenium.test.BrowserSetup;

public class UnitTestX extends BrowserSetup {
	
	CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);

	//Login & Logout
	//==============
	@Test(enabled = true)
	public void test00_MobileClient_Login() throws InterruptedException {
		String methodID = "test00_MobileClient_Login";
		
		SLXMobileLogin slxmobilelogin = PageFactory.initElements(driver, SLXMobileLogin.class);	
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
		
		//VP: the Mobile Login screen is loaded from base URL
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		commNav.waitForPage(fullProdName);
		
		//VP: Page Title (header text - not pagetitle property)
		Thread.sleep(1000);
		try { 
			AssertJUnit.assertEquals(shortProdName, driver.getTitle());
			System.out.println("VP: Login Screen Title check - Passed");
		} 
		catch (Error e) {
			System.out.println("Error: Login Screen Title check - FAILED");
			verificationErrors.append(e.toString());
		}
		
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
		
		//VP: Copyright Info
		try {
			AssertJUnit.assertEquals(copyrightLabel, driver.findElement(By.xpath(".//*[@id='login']/span[1]")).getText());
			System.out.println("VP: Copyright check - Passed");
		} 
		catch (Error e) {
			System.out.println("Error: Copyright check - FAILED");
			verificationErrors.append(e.toString());
		}
		try {
			AssertJUnit.assertEquals(versionLabel, driver.findElement(By.xpath(".//*[@id='login']/span[2]")).getText());
			System.out.println("VP: Version Label check - Passed");
		} 
		catch (Error e) {
			System.out.println("Error: Version Label check - FAILED");
			verificationErrors.append(e.toString());
		}
		
		// Step: Enter username and password then click the logon button		
		slxmobilelogin.doLogin(userName, userPwd, true);
		
		// VP: confirm that the 'My Activities' screen displays after login
		Thread.sleep(3000);
		try {
			AssertJUnit.assertTrue(driver.findElement(By.xpath(".//*[@id='myactivity_list']")).isDisplayed());
			System.out.println("VP: Successfully logged in to Mobile Client.");
		} catch (UnhandledAlertException e) {
			//closeAlert();
			closeModal();
			//assertEquals("The user name or password is invalid.", closeAlertAndGetItsText());
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


	public void checkGlobalMenuStatus(String resultMsg) {
		HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);
		
	    try {
	    	AssertJUnit.assertTrue(headerButton.globalMenuButton.isDisplayed());
	    	System.out.println(resultMsg + " - Passed");
	    } catch (Error e) {
	    	verificationErrors.append(e.toString());
	    	System.out.println(resultMsg + " - Failed");
	    }
	}


	//MBL10112 - KPI widgets need to work for listviews under an entity - Accounts (filtering by hash tags)
	@Test(enabled = false)
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
		
		AccountViewsElements accountsListView = PageFactory.initElements(driver, AccountViewsElements.class);
	
		//Section 1: Total Revenue KPI metric & filters 
		//----------
		//Step: un-select the Total Avg Time as Customer & Total Accounts KPI metric (this should leave Total Revenue KPI selected)
		commNav.rightClickContextMenuItem("Avg Time as Customer");
		Thread.sleep(3000);
		commNav.rightClickContextMenuItem("Total Accounts");
		Thread.sleep(3000);
		
		//Step: select each filter
		String kpiMetric = "Total Revenue";
		String hSelectedFilter = "";
		String[] hTagFilters = {"my-accounts", "active", "inactive", "suspect", "lead", "prospect", "customer", "partner", "vendor", "influencer", "competitor"};
		for (int iCount = 1;iCount<hTagFilters.length;iCount++) {
			hSelectedFilter = hTagFilters[iCount];
			commNav.rightClickContextMenuItem(hSelectedFilter);
			Thread.sleep(3000);		
			String resultsMsg = "VP: " + kpiMetric + " KPI metric card is displayed above the list view with #'" + hSelectedFilter + " filter";
			try {
				WebElement selectedKPICard = driver.findElement(By.xpath("//div[19]/div[2]/div/button")); 
				AssertJUnit.assertTrue(commNav.isWebElementPresent("KPI header label", selectedKPICard));
				System.out.println(resultsMsg + " - Passed");
				
				resultsMsg = "VP: " + kpiMetric + " KPI card title check";
				try {
					String selectedKPICardTitle = selectedKPICard.getText();
					String regExp = "^[\\s\\S]*" + kpiMetric + "[\\s\\S]*$";
					AssertJUnit.assertTrue(selectedKPICardTitle.matches(regExp));
					System.out.println(resultsMsg + " - Passed");
					
					String selectedKPICardVal = getKPICardValue(selectedKPICardTitle);
					System.out.println("KPI Total History & #" + hSelectedFilter + " card value: " + selectedKPICardVal);
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
		commNav.rightClickContextMenuItem(kpiMetric);
		Thread.sleep(3000);
		
		//Step: remove any current hash-tags/filters then perform a Lookup
		accountsListView = PageFactory.initElements(driver, AccountViewsElements.class);
		accountsListView.accountsSearchTxtBox.click();
		Thread.sleep(500);
		accountsListView.accountsSearchClearBtn.click();
		Thread.sleep(1000);
		accountsListView.accountsSearchLookupBtn.click();
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
		accountsListView = PageFactory.initElements(driver, AccountViewsElements.class);
		accountsListView.accountsSearchTxtBox.click();
		Thread.sleep(500);
		accountsListView.accountsSearchClearBtn.click();
		Thread.sleep(1000);
		accountsListView.accountsSearchLookupBtn.click();
		Thread.sleep(3000);
		
		//END
		//---
		//Step: go back to start screen
		commNav.clickGlobalMenuItem("My Activities");
		Thread.sleep(3000);
		
		System.out.println(ENDLINE);
	}
	
}
