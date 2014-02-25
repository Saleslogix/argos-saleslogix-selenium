package argos.saleslogix.selenium.test;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;


/**
 * Test class that defines test methods for the SLX Mobile Defect (v3.05) fixes.
 * 
 * @author mike.llena@swiftpage.com
 * @version	1.0
 */
public class MobileSprint305Test extends BrowserSetup {
	
	//Login & Logout
	//==============
	@Test(enabled = true)
	public void test00_MobileClient_Login() throws InterruptedException {
		String methodID = "test00_MobileClient_Login";
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
		
		doVerificationLogin();
		
		System.out.println(ENDLINE);	
	}

	@Test(enabled = true)
	public void test99_Mobile_LogOut()  throws InterruptedException {				
		String methodID = "test99_Mobile_LogOut";
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
		
		doVerificationLogout();
		
		System.out.println(ENDLINE);
	}
	
	
	//Test Methods
	//============
	@Test(enabled = true)
	public void test01_MobileDefect_MBL10267()  throws InterruptedException {
		//Reference: MBL-10267
		String methodID = "test01_MobileDefect_MBL10267";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);
		
		// test params
		String entityView = "My Activities";
		String actType = "Personal Activity";
		String regardingVal = "Birthday Reminder";
		
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
	
		//Step: click the My Activities link
		commNav.clickGlobalMenuItem("My Activities");
		
		//Section 1: click the top-right + button to schedule a new activity
		headerButton.clickHeaderButton("add");
		try {
			AssertJUnit.assertTrue(commNav.waitForPage("Schedule..."));
			
			//TODO: create a separate class for scheduling activities...
			//SubStep: set the Activity Type...
			driver.findElement(By.xpath("//*[@id='activity_types_list']/descendant::*[text() = '" + actType + "']")).click();
			commNav.waitForPage(actType);
		    
			//SubStep: setup and confirm the Regarding field val...
			//NOTE: here we just set the value of the input text field; selecting a Regarding value is not supported by Se WebDriver
			String regardingFldXPath = "//div[@id='Mobile_SalesLogix_Fields_PicklistField_0']/input";
			driver.findElement(By.xpath(regardingFldXPath)).clear();
			driver.findElement(By.xpath(regardingFldXPath)).sendKeys(regardingVal);		    
		    //VP: check the modified Regarding field val...
		    try {
		    	  AssertJUnit.assertEquals(regardingVal, driver.findElement(By.xpath(regardingFldXPath)).getAttribute("value"));
		    	  System.out.println("VP: Regarding field value set to '" + regardingVal + "' - Passed");
		    	} 
		    catch (Error e) {
		    	  System.out.println("VP: Regarding field value set to '" + regardingVal + "' - FAILED");
		    	  verificationErrors.append(methodID + "(): " + e.toString());
		    }
		    
		    //VP: check that the For Lead button is set to OFF (default)
		    String forLeadTglCSS = "#Sage_Platform_Mobile_Fields_BooleanField_4 > div.toggle > span.toggleOff";
		    String resultsMsg = "VP: the For Lead toggle button was set to default value of 'NO'";
		    try {
		    	AssertJUnit.assertEquals("NO", driver.findElement(By.cssSelector(forLeadTglCSS)).getText());
		    	System.out.println(resultsMsg + " - Passed");
		    }
		    catch (Error e) {
		    	System.out.println(resultsMsg + " - Failed");
		    }
		    
		    //VP: check that both the Account & Contact field values are blank (default)
		    String accountFldCSS = "#Sage_Platform_Mobile_Fields_LookupField_1 > input[type='text']";
		    String contactFldCSS = "#Sage_Platform_Mobile_Fields_LookupField_2 > input[type='text']";
		    resultsMsg = "VP: the Account & Contact field values are un-set";
		    try {
		    	AssertJUnit.assertEquals("", driver.findElement(By.cssSelector(accountFldCSS)).getText());
		    	AssertJUnit.assertEquals("", driver.findElement(By.cssSelector(contactFldCSS)).getText());
		    	System.out.println(resultsMsg + " - Passed");
		    }
		    catch (Error e) {
		    	System.out.println(resultsMsg + " - Failed");
		    }
		    
		    //SubStep: leave all other Activity fields set to their defaults...
			
		    //Step: click the Header, Save button to return to Contact detail view...
		    headerButton.clickHeaderButton("save");
		    Thread.sleep(5000);
		    commNav.waitForPage("My Activities");
		}
		catch (Exception e) {
			System.out.println("VP: The Schedule view was not displayed; test aborted.");
		}
		
		//Section 2: find and complete the Activity
		//TODO: write a method to complete an activity
		//Step: find and open the activity Detail view
		commNav.searchListView(entityView, regardingVal);
		commNav.clickListViewItemN(entityView, 1);
		commNav.waitForPage("Activity");
		
		//Step: complete the activity
	    String completeActyIconXPath = "//*[@id='activity_detail']/div[2]/ul[1]";
	    driver.findElement(By.xpath(completeActyIconXPath)).click();
	    commNav.waitForPage("Complete Activity");
		headerButton.clickHeaderButton("save");
	    Thread.sleep(5000);
	    commNav.waitForPage("My Activities");
	    
		//Section 3: navigate to Notes/History
	    
	    //Step: find and re-open the completed activity
	    entityView = "Notes/History";	    
		commNav.clickGlobalMenuItem(entityView);
		commNav.searchListView(entityView, regardingVal);
		commNav.clickListViewItemN(entityView, 1);
		commNav.waitForPage(actType);
		
		//Step: modify the Notes field
		headerButton.clickHeaderButton("edit");
		commNav.waitForPage("Note");
		
		String notesFldCSS = "textarea[name='Text']";
	    WebElement notesFld = driver.findElement(By.cssSelector(notesFldCSS));
	    notesFld.click();
	    notesFld.clear();
	    notesFld.sendKeys("Modified activity note.");
	    
	    headerButton.clickHeaderButton("save");
	    Thread.sleep(5000);
	    String resultsMsg = "VP: No un-expected error message on Activity edit save";
	    try {
	    	AssertJUnit.assertTrue(commNav.waitForPage(actType));
	    	System.out.println(resultsMsg + " - Passed");
	    }
	    catch (Error e) {
	    	System.out.println(resultsMsg + " - Failed");
	    }
	    headerButton.clickHeaderButton("back");
	    
	    //VP: 
		
		// End Tests
		// Step: navigate back to the default startup view
		//commNav.clickGlobalMenuItem("My Activities");
		
		System.out.println(ENDLINE);		
	}

	@Test(enabled = true)
	public void test02_MobileDefect_MBL10268()  throws InterruptedException {
		//Reference: MBL-10268
		String methodID = "test02_MobileDefect_MBL10268";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);
		
		// test params
		String entityView = "Tickets";
	
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
	
		//Step: open the entities List view from the Global Menu
		commNav.clickGlobalMenuItem(entityView);
		commNav.waitForPage(entityView);
	
		//Step: open the Ticket Detail view  
		commNav.clickListViewItemN(entityView, 1);
		
		//Step: click the Ticket Activities link
		String tcktActivitiesLnkXPath = "//*[@id='ticket_detail']/descendant::*[text() = 'Ticket Activities']";
		driver.findElement(By.xpath(tcktActivitiesLnkXPath)).click();
		commNav.waitForPage("Ticket Activities");
		
		//Step: click header Add button 
		headerButton.clickHeaderButton("add");
		commNav.waitForPage("Edit Ticket Activity");
		
		//VP: check that User field default value is not empty 
		String userFldXPath = "(//input[@type='text'])[3]";
		String userFldVal = driver.findElement(By.xpath(userFldXPath)).getAttribute("value");
		String resultsMsg = "VP: Edit Ticket Activity, User field default value is not blank";
		try {
			AssertJUnit.assertTrue(!"".equals(userFldVal));
			System.out.println(resultsMsg + " - Passed");
		}
		catch (Exception e) {
			System.out.println("VP: The Edit Ticket Activity, User field default value was blank.");
			System.out.println(resultsMsg + " - Failed");
		}
		finally {
			// End Tests
			// Step: navigate back to the default startup view
			headerButton.clickHeaderButton("cancel");
			commNav.waitForPage("Ticket Activities");
			headerButton.clickHeaderButton("back");
			commNav.waitForNotPage("Ticket Activities");
			headerButton.clickHeaderButton("back");
			commNav.waitForPage("Tickets");
			
			System.out.println(ENDLINE);	
		}
						
	}

	@Test(enabled = false)
	public void test03_MobileDefect_MBL10269() throws Exception {
		String methodID = "test03_MobileDefect_MBL10269";
		
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
		//NOTE: Jenkins Server gets stuck at this point
		
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
			catch (Error e) {
				verificationErrors.append(methodID + "(): " + e.toString());
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
				catch (Error e) {
					verificationErrors.append(methodID + "(): " + e.toString());
					System.out.println(resultsMsg + " - Failed");
				}
			}				
		}
		
		//END
		System.out.println(ENDLINE);
	}

	@Test(enabled = true)
	public void test04_MobileDefect_MBL10086() throws Exception {
		String methodID = "test04_MobileDefect_MBL10086";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);	
		
		//Test Params:
		String entityType1 = "Accounts";
		String entityType2 = "My Activities";
		String recordItem = "A1 Enterprises";
	
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);		
	
	    //Step: navigate to the Accounts list view then perform record search
		commNav.clickGlobalMenuItem(entityType1);
		commNav.searchListView(entityType1, recordItem);
		
		//Step: navigate to My Activities list view
		commNav.clickGlobalMenuItem(entityType2);
		
		MyActivityViewsElements activitiesListView = PageFactory.initElements(driver, MyActivityViewsElements.class);	
		
		//Step: execute a filter-free search
		headerButton.showRightContextMenu();
		activitiesListView.myActivitiesSearchTxtBox.click();
		Thread.sleep(500);
		activitiesListView.myActivitiesSearchClearBtn.click();
		Thread.sleep(1000);
		activitiesListView.myActivitiesSearchLookupBtn.click();
		Thread.sleep(3000);
		
		//Step: retrieve more records loop
		String remainingLblTxtA = "";
		String remainingLblTxtB = "";
		String recsRemainLblXPath = "//*[@id='myactivity_list']/div[3]/div";
		String resultsMsg = "VP: Records Remaining label text is correctly updated on scroll-down ";
		try {
			WebElement recsRemainingLbl = driver.findElement(By.xpath(recsRemainLblXPath));
			for (int count = 1; count<3; count++) {
				remainingLblTxtA = recsRemainingLbl.getText();
				driver.findElement(By.xpath(recsRemainLblXPath)).click();
				Thread.sleep(1000);
				driver.findElement(By.xpath("//*[@id='myactivity_list']")).sendKeys(Keys.PAGE_DOWN);
				Thread.sleep(3000);
				remainingLblTxtB = recsRemainingLbl.getText();
				try {
					AssertJUnit.assertFalse(remainingLblTxtA.equals(remainingLblTxtB));
					System.out.println(resultsMsg + count + " - Passed");
				}
				catch (Error e) {
					System.out.println(resultsMsg + count + " - Failed");
				}
			}
		}
		catch (Exception e) {
			verificationErrors.append(methodID + "(): " + e.toString());
		}
			
		//END
		commNav.clickGlobalMenuItem(entityType2);
		System.out.println(ENDLINE);
	}
}
