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
public class MobileSprint304Test extends BrowserSetup {

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

	//MBL-10191 - Remove configure option
	@Test(enabled = true)
	public void test01_MBL10191_RemoveConfigureOption() throws InterruptedException {
		String methodID = "test01_MBL10191_RemoveConfigureOption";
			
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);		
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
		
		// Test Params:
		String selectedEntity = "";
		String[] entityList = {"My Activities", "Notes/History", "meeting", "personal", "email"};
		for (int iCount = 1;iCount<entityList.length;iCount++) {
		    //Step: navigate to entity list view...
			selectedEntity = entityList[iCount];
			commNav.clickGlobalMenuItem(selectedEntity);
			
			//Step: verify the removal of KPI Configure link
			headerButton.showRightContextMenu();
			String resultsMsg = "VP: KPI Configure link is correctly not displayed in right-context menu for the '" + selectedEntity + "' entity.";
			try {
				AssertJUnit.assertTrue(driver.findElements(By.xpath(".//*[@id='right_drawer']/descendant::*[text() = 'Configure']")).size() == 0);			
				System.out.println(resultsMsg + " - Passed");
			}
			catch (Error e) {
				System.out.println(resultsMsg + " - Failed");
			}
			
			headerButton.closeRightContextMenu();
		}
			
		//END
		//---
		//Step: go back to start screen
		commNav.clickGlobalMenuItem("My Activities");
		Thread.sleep(3000);
		
		System.out.println(ENDLINE);
	}

	//MBL-10191 - Right Contextual menu - where SpeedSearch is executed...
	@Test(enabled = true)
	public void test02_MBL10190_HideRightContextMenuAfter2ndSpeedSearch() throws InterruptedException {
		String methodID = "test02_MBL10190_HideRightContextMenuAfter2ndSpeedSearch";
			
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);		
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
		
	    //Step: perform speed search...
	    String firstSearchItem = "abbott";	    
	    commNav.searchListView("speedsearch", firstSearchItem);
	
	    String secondSearchItem = "abc";	    
	    commNav.searchListView("speedsearch", secondSearchItem);
	    
		//VP: confirm that Right-context menu is not automatically displayed after 2nd Speed Search
	    String resultsMsg = "VP: Right-context menu is not displayed after 2nd Speed Search ";
	    try {
	    	AssertJUnit.assertTrue(driver.findElements(By.xpath(".//*[@id='right_drawer']")).size() == 0);
			System.out.println(resultsMsg + "- Passed");
		}
	    catch (Error e) {
			// Click Header Right-Context Menu button...
	    	headerButton.clickHeaderButton("right context menu");
	    	System.out.println(resultsMsg + "- False");
	    }
	    
		//END
		//---
		//Step: go back to start screen
		commNav.clickGlobalMenuItem("My Activities");
		Thread.sleep(3000);
		
		System.out.println(ENDLINE);
	}

	@Test(enabled = true)
	public void test03_MBL10015_NoXtraRetMoreRecs() throws Exception {
		String methodID = "test03_MBL10015_NoXtraRetMoreRecs";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		
		//Test Params:
		String entityType = "My Activities";
		String hashTag = "alarm";
	
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);		
	
	    //Step: navigate to My Activities list view...
		commNav.clickGlobalMenuItem(entityType);
		
		//Step: select the alarm hash-tag filter item
		commNav.rightClickContextMenuItem(hashTag);
		Thread.sleep(3000);
		
		//Step: scroll-down to the "x records remaining" label
		String recsRemainLblXPath = "//*[@id='myactivity_list']/div[3]/div";
		String resultsMsg = "VP: Invalid 'Retrieve More Records' label not found after loading more records";
		try {
			driver.findElement(By.xpath(recsRemainLblXPath)).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@id='myactivity_list']")).sendKeys(Keys.PAGE_DOWN);
			Thread.sleep(3000);			
			try {
				AssertJUnit.assertFalse(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Retrieve More Records[\\s\\S]*$"));
				System.out.println(resultsMsg + " - Passed");
			} 
			catch (Error er) {
				verificationErrors.append(er.toString());
				System.out.println(resultsMsg + " - Failed");
			}
		}
		catch (Exception exp) {
		    //Step: load more results (click on 'x remaining records' item)
			for (int count = 1; count<3; count++) {			
				driver.findElement(By.xpath("//*[@id='myactivity_list']")).sendKeys(Keys.PAGE_DOWN);
				Thread.sleep(3000);
				//JavascriptExecutor jsx = (JavascriptExecutor)driver;
				//jsx.executeScript("window.scrollBy(0,450)", "");
				
				try {
					AssertJUnit.assertFalse(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Retrieve More Records[\\s\\S]*$"));
					System.out.println(resultsMsg + " - Passed");
				} 
				catch (Error er) {
					verificationErrors.append(er.toString());
					System.out.println(resultsMsg + " - Failed");
				}
			}				
		}
		
		//END
		System.out.println(ENDLINE);
	}

	@Test(enabled = true)
	public void test04_MBL10127_MobilePhoneFieldCheck() throws Exception {
		String methodID = "test04_MBL10127_MobilePhoneFieldCheck";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);	
		
		//Test Params:
		String entityType = "Leads";
	
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);		
	
	    //Step: navigate to the Leads list view
		commNav.clickGlobalMenuItem(entityType);
		
		//Step: click and open the top Leads record
		commNav.clickListViewItemN(entityType, 1);
		commNav.waitForNotPage("Leads");
		
		//VP: check to see that the Mobile Phone field is available in the Detail view
		String mobilePhoneDtlViewFldXPath = "//*[@id='lead_detail']/descendant::*[text() = 'mobile phone']";
		String resultsMsg = "VP: the Mobile Phone field is available in the Lead Detail view";
		try {
			AssertJUnit.assertTrue(driver.findElement(By.xpath(mobilePhoneDtlViewFldXPath)).isDisplayed());
			System.out.println(resultsMsg + " - Passed");
		}
		catch (Error e) {
			System.out.println(resultsMsg + " - Failed");
		}
		
		//Step: navigate to Lead Edit view
		headerButton.clickHeaderButton("edit");
		commNav.waitForPage("Lead");
		
		//VP: check to see that the Mobile Phone field is available in the Edit view
		String mobilePhoneEdtViewFldCSS = "input[name='Mobile']";
		resultsMsg = "VP: the Mobile Phone field is available in the Lead Edit view";
		try {
			AssertJUnit.assertTrue(driver.findElement(By.cssSelector(mobilePhoneEdtViewFldCSS)).isDisplayed());
			System.out.println(resultsMsg + " - Passed");
		}
		catch (Error e) {
			System.out.println(resultsMsg + " - Failed");
		}
			
		//END
		commNav.clickGlobalMenuItem("My Activities");
		System.out.println(ENDLINE);
	}

	@Test(enabled = true)
	public void test05_MobileDefect_MBL10137() throws Exception {
		String methodID = "test05_MobileDefect_MBL10137";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);	
		
		//Test Params:
		String entityType = "My Activities";
	
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);		
	
	    //Step: navigate to the My Activities list view
		commNav.clickGlobalMenuItem(entityType);
		
		MyActivityViewsElements activitiesListView = PageFactory.initElements(driver, MyActivityViewsElements.class);
		
		//Step: execute a filter-free search
		activitiesListView.performNoFilterSearch();
		
		//Step: scroll-down the list a few times
		for (int count = 1; count<4; count++) {			
			driver.findElement(By.xpath("//*[@id='myactivity_list']")).sendKeys(Keys.PAGE_DOWN);
			Thread.sleep(3000);
		}
		
		//Step: open any activity record
		commNav.clickListViewItemN(entityType, 5);
		commNav.waitForPage("Activity");
		
		//Step: navigate back to the Activities List view
		headerButton.clickHeaderButton("back");
		commNav.waitForPage(entityType);
		
		//Step: open the Right-context menu
		headerButton.showRightContextMenu();
		
		//VP: check to see if '#this-week' populates the Lookup input field
		String filter2Check = "#this-week";
		String lookupFldVal = activitiesListView.myActivitiesSearchTxtBox.getText();
		String resultsMsg = "VP: Lookup search field is not set to '" + filter2Check + "'";
		try {
			AssertJUnit.assertFalse(lookupFldVal.equals(filter2Check));
			System.out.println(resultsMsg + " - Passed");
		}
		catch (Error e) {
			System.out.println(e.toString());
			System.out.println(resultsMsg + " - False");
		}
		finally {
			headerButton.closeRightContextMenu();
		}
		
		//Step: scroll-down the list a few times (again)
		for (int count = 1; count<4; count++) {			
			driver.findElement(By.xpath("//*[@id='myactivity_list']")).sendKeys(Keys.PAGE_DOWN);
			Thread.sleep(3000);
		}
		
		//Step: click the title bar to jump to the top of the list
		driver.findElement(By.xpath(".//*[@id='pageTitle']")).click();
		Thread.sleep(1000);
		
		//VP: check to see that '#this-week' filter is not displayed on the page
		resultsMsg = "VP: the '" + filter2Check + "' hash-tag filter was not present";
		try { if (!driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*" + filter2Check + "[\\s\\S]*$"))
			System.out.println(resultsMsg + " - Passed");
		}
		catch (Error e) {
			System.out.println(e.toString());
			System.out.println(resultsMsg + " - Failed");
		}
		
		
		//END
		System.out.println(ENDLINE);
	}
}
