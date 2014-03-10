/**
 * 
 */
package argos.saleslogix.selenium.test;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

import argos.saleslogix.selenium.*;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.AssertJUnit;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;

public class MobileDefectTest extends BaseTest {

	//Test Methods		
	//============
	//TODO: test41_MobileDefect13092144 mysteriously fails to run on Jenkins server
	@Test(enabled = true)
	public void test41_MobileDefect13092144()  throws InterruptedException {
		//tags: download attachment, jpg image
		String methodID = "test41_MobileDefect13092144";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerbutton = PageFactory.initElements(driver, HeaderButton.class);
		
		// test params
		String attachmentName = "saleslogix";
				
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
		// Step: click the Top-Left, Global Menu button...
		headerbutton.showGlobalMenu();
	
		// Step: click the My Attachments link
		commNav.clickGlobalMenuItem("My Attachments");
		
		// Step: perform search for Attachment record
		commNav.searchListView("attachment", attachmentName);
		
		// Step: click to download and view the attachment
		try {
			driver.findElement(By.xpath("//*[@id='myattachment_list']/ul/li")).click();
			AssertJUnit.assertTrue(commNav.isTextPresentOnPage("loading..."));
			AssertJUnit.assertTrue(commNav.isTextPresentOnPage("Downloading attachment..."));
			AssertJUnit.assertTrue(commNav.isTextNotPresentOnPage("Downloading attachment..."));
			Thread.sleep(3000);
			String resultMsg = "VP: initial successful Attachment downloaded check";
			try {
				WebElement attachedImg = driver.findElement(By.xpath("//*[@id='attachment-image']"));
				AssertJUnit.assertTrue(commNav.isWebElementPresent("attachment image", attachedImg));
				System.out.println(resultMsg + " - Passed");
			}
			catch (Exception e) {
				System.out.println(methodID + "(): " + e.toString());
				System.out.println(resultMsg + " - FAILED");
			}
		} 
		catch (Exception e) {
			System.out.println("The '" + attachmentName + "' attachment was not available for the test.");
		}
		
		// Step: click the Top-Left, Global Menu button...
		headerbutton.showGlobalMenu();
		Thread.sleep(2000);
		
		// Step: click the Top-Left, Global Menu button again to close...
		headerbutton.clickHeaderButton("global");
		Thread.sleep(2000);
		
		// VP: confirm that attachment is still displayed correctly after Global Menu display/non-display
		String resultMsg = "VP: fix check on Attachments view on Global Menu display/non-display";
		try {
			WebElement attachedImg = driver.findElement(By.xpath("//*[@id='attachment-image']"));
			AssertJUnit.assertTrue(commNav.isWebElementPresent("attachment image", attachedImg));
			System.out.println(" - Passed");
		}
		catch (Error e) {
			System.out.println(methodID + "(): " + e.toString());
			System.out.println(resultMsg + " - FAILED");
		}
		
		// Step: navigate back to the My Activities list view
		headerbutton.goBack();
		headerbutton.showGlobalMenu();
		commNav.clickGlobalMenuItem("My Activities");
		
		// End Tests
		System.out.println(ENDLINE);
	}
	
	//TODO: test42_MobileDefect13092160 mysteriously fails on Jenkins server
	@Test(enabled = true)
	public void test42_MobileDefect13092160()  throws InterruptedException {
		//tags: download attachment, url
		String methodID = "test42_MobileDefect13092160";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerbutton = PageFactory.initElements(driver, HeaderButton.class);
		
		// test params
		String attachmentName = "ibm";
		
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
		// Step: click the Top-Left, Global Menu button...
		headerbutton.showGlobalMenu();
	
		// Step: click the My Attachments link
		commNav.clickGlobalMenuItem("My Attachments");
		
		// Step: perform search for Attachment record
		commNav.searchListView("attachment", attachmentName);
		
		// Step: click to download and view the attachment
		try {
			driver.findElement(By.xpath("//*[@id='myattachment_list']/ul/li")).click();
		} catch (Exception e) {
			System.out.println(methodID + "(): " + e.toString());
			System.out.println("The '" + attachmentName + "' attachment was not available for the test.");
		};
		Thread.sleep(7000);
				
		// VP: confirm that URL attachment is loaded and displayed correctly
		String resultMsg = "VP: initial URL attachment download and display check";
		try {
			AssertJUnit.assertTrue(isElementPresent(By.xpath("//*[@id='attachment-Iframe']")));
			System.out.println(resultMsg + " - Passed");
		}
		catch (Error e) {
			System.out.println(methodID + "(): " + e.toString());
			System.out.println(resultMsg + " - FAILED");
		}
		
		// Step: click the Top-Left, Global Menu button...
		headerbutton.showGlobalMenu();
		Thread.sleep(3000);
		
		// Step: click the Top-Left, Global Menu button again to close...
		headerbutton.showGlobalMenu();
		
		// VP: confirm that attachment is still displayed correctly
		resultMsg = "VP: consistent URL attachment display check";
		try {
			AssertJUnit.assertTrue(isElementPresent(By.xpath("//*[@id='attachment-Iframe']")));
			System.out.println(resultMsg + " - Passed");
		}
		catch (Error e) {
			System.out.println(methodID + "(): " + e.toString());
			System.out.println(resultMsg + " - FAILED");
		}
		
		// Step: navigate back to the My Activities list view
		headerbutton.goBack();
		headerbutton.showGlobalMenu();
		commNav.clickGlobalMenuItem("My Activities");
		
		// End Tests
		System.out.println(ENDLINE);
	}

	
	@Test(enabled = true)
	public void test43_MobileDefect13092222()  throws InterruptedException {				
		String methodID = "test43_MobileDefect13092222";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerbutton = PageFactory.initElements(driver, HeaderButton.class);
		
		// test params
		String strCheck1 = "P: null";
		String strCheck2 = "F: null";
		String accountName1 = "~Doctor List";
		String accountName2 = "Acm";	//sub-string
		
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
		// Step: click the Top-Left, Global Menu button...
		headerbutton.showGlobalMenu();
	
		// Section 1: check Accounts, List View
		// Step: click the Accounts link
		commNav.clickGlobalMenuItem("Accounts");
	
		// VP: confirm that "P: null" is not present in the Accounts, List View		
		try {
			AssertJUnit.assertFalse(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*"+ strCheck1 +"[\\s\\S]*$"));
			System.out.println("Verify: '" + strCheck1 + "' fix check on Accounts, List View - Passed");
		} catch (Error e) {
			System.out.println("Verify: '" + strCheck1 + "' fix check on Accounts, List View - FAILED");
			verificationErrors.append(methodID + "(): " + e.toString());
		}
	
		// VP: confirm that "F: null" is not present in the Accounts, List View		
		try {
			AssertJUnit.assertFalse(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*"+ strCheck2 +"[\\s\\S]*$"));
			System.out.println("Verify: '" + strCheck2 + "' fix check on Accounts, List View - Passed");
		} catch (Error e) {
			System.out.println("Verify: '" + strCheck2 + "' fix check on Accounts, List View - FAILED");
			verificationErrors.append(methodID + "(): " + e.toString());
		}
	
		// Section 2: check Accounts, List View for "~Doctors List" account record
		// Step: perform search for Account record
		commNav.searchListView("account", accountName1);
		
		// VP: confirm that "P: null" is not present in the Accounts, List View		
		try {
			AssertJUnit.assertFalse(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*"+ strCheck1 +"[\\s\\S]*$"));
			System.out.println("Verify: '" + strCheck1 + "' fix check on Accounts, List View - Passed");
		} catch (Error e) {
			System.out.println("Verify: '" + strCheck1 + "' fix check on Accounts, List View - FAILED");
			verificationErrors.append(methodID + "(): " + e.toString());
		}
	
		// VP: confirm that "F: null" is not present in the Accounts, List View		
		try {
			AssertJUnit.assertFalse(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*"+ strCheck2 +"[\\s\\S]*$"));
			System.out.println("Verify: '" + strCheck2 + "' fix check on Accounts, List View - Passed");
		} catch (Error e) {
			System.out.println("Verify: '" + strCheck2 + "' fix check on Accounts, List View - FAILED");
			verificationErrors.append(methodID + "(): " + e.toString());
		}		
	
		// Section 3: check Accounts, List View for "Acmaoe Mfg" account record
		// Step: perform search for Account record
		commNav.searchListView("account", accountName2);
		
		// VP: confirm that "P: null" is not present in the Accounts, List View		
		try {
			AssertJUnit.assertFalse(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*"+ strCheck1 +"[\\s\\S]*$"));
			System.out.println("Verify: '" + strCheck1 + "' fix check on Accounts, List View - Passed");
		} catch (Error e) {
			System.out.println("Verify: '" + strCheck1 + "' fix check on Accounts, List View - FAILED");
			verificationErrors.append(methodID + "(): " + e.toString());
		}
	
		// VP: confirm that "F: null" is not present in the Accounts, List View		
		try {
			AssertJUnit.assertFalse(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*"+ strCheck2 +"[\\s\\S]*$"));
			System.out.println("Verify: '" + strCheck2 + "' fix check on Accounts, List View - Passed");
		} catch (Error e) {
			System.out.println("Verify: '" + strCheck2 + "' fix check on Accounts, List View - FAILED");
			verificationErrors.append(methodID + "(): " + e.toString());
		}
		
		// End Section
		// Step: click the Top-Left, Global Menu button...
		headerbutton.showGlobalMenu();
		commNav.clickGlobalMenuItem("My Activities");
		
		System.out.println(ENDLINE);
	}

	@Test(enabled = true)
	public void test44_MobileDefect13092239()  throws InterruptedException {				
		String methodID = "test44_MobileDefect13092239";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerbutton = PageFactory.initElements(driver, HeaderButton.class);
		
		// test params
		String accountName1 = "ABC Materials";
		String strCheck1 = "Customer|";
		
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
		// Step: click the Top-Left, Global Menu button...
		headerbutton.showGlobalMenu();
	
		// Step: click the Accounts link
		commNav.clickGlobalMenuItem("Accounts");
	
		// Step: perform search for Account record
		commNav.searchListView("account", accountName1);
		
		// VP: confirm that "Customer|" is not present in the Accounts, List View		
		try {
			AssertJUnit.assertFalse(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*"+ strCheck1 +"[\\s\\S]*$"));
			System.out.println("Verify: '" + strCheck1 + "' fix check on Accounts, List View - Passed");
		} catch (Error e) {
			System.out.println("Verify: '" + strCheck1 + "' fix check on Accounts, List View - FAILED");
			verificationErrors.append(methodID + "(): " + e.toString());
		}
		
		// End Tests
		// Step: click the Top-Left, Global Menu button...
		headerbutton.showGlobalMenu();
		commNav.clickGlobalMenuItem("My Activities");
		
		System.out.println(ENDLINE);
	}

	//TODO: test45_MobileDefect13092219 mysteriously fails on Jenkins server
	@Test(enabled = true)
	public void test45_MobileDefect13092219()  throws InterruptedException {				
		String methodID = "test45_MobileDefect13092219";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerbutton = PageFactory.initElements(driver, HeaderButton.class);
		
		// test params
		String searchItem = "Abbott";
		String strCheck1 = "records remaining";
		String strCheck2 = "no records";
		
				
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
		
		// Step: perform search for Account record
		commNav.searchListView("speedsearch", searchItem);
	
		// VP: check for 'records remaining' label being displayed
		try {
			AssertJUnit.assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*"+ strCheck1 +"[\\s\\S]*$"));
			System.out.println("Verify: '" + strCheck1 + "' check on SpeedSearch, List View - Passed");
		} catch (Error e) {
			System.out.println("Verify: '" + strCheck1 + "' check on SpeedSearch, List View - FAILED");
			verificationErrors.append(methodID + "(): " + e.toString());
		}
		
		// Step: perform page-down scroll (2x) to load more results
		for (int counter = 0;; counter++) {
			if (counter >= 3) {
				break;
			}
			driver.findElement(By.xpath("//*[@id='speedsearch_list']")).sendKeys(Keys.PAGE_DOWN);
			System.out.println("SpeedSearch ListView browser page was scrolled down");
			Thread.sleep(5000);
			
			// VP: check for any 'no records' results being displayed
			try {
				AssertJUnit.assertFalse(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*"+ strCheck2 +"[\\s\\S]*$"));
				System.out.println("Verify: '" + strCheck2 + "' fix check on SpeedSearch, List View - Passed");
			} catch (Error e) {
				System.out.println("Verify: '" + strCheck2 + "' fix check on SpeedSearch, List View - FAILED");
				verificationErrors.append(methodID + "(): " + e.toString());
				break;
			}
		}
		
		// Step: click the top-search results item to go to the Detail view
		driver.findElement(By.xpath("//*[@id='speedsearch_list']/ul/li[1]/div[3]/h4")).click();
		for (int second = 0;; second++) {
			if (second >= 30) Assert.fail("timeout");
			try { if (!"SpeedSearch".equals(driver.findElement(By.xpath("//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}
		
		// Step: click the Header, Back button to return to the SpeedSearch List View...
		headerbutton.clickHeaderButton("back");
		for (int second = 0;; second++) {
			if (second >= 30) Assert.fail("timeout");
			try { if ("SpeedSearch".equals(driver.findElement(By.xpath("//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}
		
		// Step: perform page-down scroll () to load more results
		for (int seconds = 0;; seconds++) {
			if (seconds >= 30) {
				break;
			}
			driver.findElement(By.xpath("//*[@id='speedsearch_list']")).sendKeys(Keys.PAGE_DOWN);
			System.out.println("SpeedSearch ListView browser page was scrolled down");
			Thread.sleep(1000);
			
			// VP: check for any 'no records' results being displayed
			try {
				AssertJUnit.assertFalse(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*"+ strCheck2 +"[\\s\\S]*$"));
				System.out.println("Verify: '" + strCheck2 + "' fix check on SpeedSearch, List View - Passed");
			} catch (Error e) {
				System.out.println("Verify: '" + strCheck2 + "' fix check on SpeedSearch, List View - FAILED");
				verificationErrors.append(methodID + "(): " + e.toString());
				break;
			}
			Thread.sleep(1000);
		}		
				
		// End Tests
		// Step: click the Top-Left, Global Menu button...
		headerbutton.showGlobalMenu();
		commNav.clickGlobalMenuItem("My Activities");
		
		System.out.println(ENDLINE);
	}

	
	@Test(enabled = true)
	public void test46_MobileDefect13092249()  throws InterruptedException {				
		String methodID = "test46_MobileDefect13092249";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerbutton = PageFactory.initElements(driver, HeaderButton.class);
		
		// test params
		String attachmentName = "pdf";
		
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
		// Step: click the Top-Left, Global Menu button...
		headerbutton.showGlobalMenu();
	
		// Step: click the My Attachments link
		commNav.clickGlobalMenuItem("My Attachments");
		
		// Step: perform search for Attachment record
		commNav.searchListView("attachment", attachmentName);
		
		// Step: click to download and view the attachment
		try {
			driver.findElement(By.xpath("//*[@id='myattachment_list']/ul/li/div/div[2]/h3/span")).click();
		} catch (Exception e) {
			System.out.println("The '" + attachmentName + "' attachment was not available for the test.");
		};
				
		// VP: confirm that attachment is downloaded and displayed correctly
		Thread.sleep(5000);
		try {
			AssertJUnit.assertTrue(isElementPresent(By.xpath("//*[@id='viewer']")));
			System.out.println("Verify: non-image attachment downloaded and displayed check - Passed");
		} catch (Error e) {
			System.out.println("Verify: non-image attachment downloaded and displayed check - FAILED");
			
		}
		
		// Step: click the Top-Left, Global Menu button...
		headerbutton.showGlobalMenu();
		Thread.sleep(3000);
		
		// Step: click the Top-Left, Global Menu button again to close...
		headerbutton.showGlobalMenu();
		
		// VP: confirm that attachment is still displayed correctly
		try {
			AssertJUnit.assertTrue(isElementPresent(By.xpath("//*[@id='viewer']")));
			System.out.println("Verify: non-image attachment downloaded and displayed check - Passed");
		} catch (Error e) {
			System.out.println("Verify: non-image attachment downloaded and displayed check - FAILED");
			
		}
		
		// Step: navigate back to the My Activities list view
		headerbutton.showGlobalMenu();
		commNav.clickGlobalMenuItem("My Activities");
		
		// End Tests
		System.out.println(ENDLINE);
	}

	@Test(enabled = true)
	public void test47_MobileDefect13092260()  throws InterruptedException {				
		String methodID = "test47_MobileDefect13092260";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerbutton = PageFactory.initElements(driver, HeaderButton.class);
		
		// test params
		String leadName = "Benson";
		String strCheck = "Owner|";
		
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
		// Step: click the Top-Left, Global Menu button...
		headerbutton.showGlobalMenu();
	
		// Step: click the Leads link
		commNav.clickGlobalMenuItem("Leads");
	
		// Step: perform search for Lead record
		commNav.searchListView("lead", leadName);
		
		// VP: confirm that "Ownmer|" is not present in the Leads, List View		
		try {
			AssertJUnit.assertFalse(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*"+ strCheck +"[\\s\\S]*$"));
			System.out.println("Verify: '" + strCheck + "' fix check on Leads, List View - Passed");
		} catch (Error e) {
			System.out.println("Verify: '" + strCheck + "' fix check on Leads, List View - FAILED");
			verificationErrors.append(methodID + "(): " + e.toString());
		}
		
		// End Tests
		// Step: click the Top-Left, Global Menu button...
		headerbutton.showGlobalMenu();
		commNav.clickGlobalMenuItem("My Activities");
		
		System.out.println(ENDLINE);
	}

	@Test (enabled = true)
	  public void test48_MobileDefect13092154() throws Exception {
		String methodID = "test48_MobileDefect13092154";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);
	
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE); 

		//Test Params
		String leadRecord = "Aaron, John";
		
		if (browsername.toLowerCase().equals("cr")) {
				
		    //Section 1 - select and open a Lead Detail view
			//----------------------------------------------
			commNav.entityRecordOpenDetailView("Leads", leadRecord);
			try {
				AssertJUnit.assertTrue(commNav.isPageDisplayed(leadRecord));
				
				LeadViewsElements leadDetailView = PageFactory.initElements(driver, LeadViewsElements.class);
				
			    // Step: click the Notes/History link...
				leadDetailView.leadsDetailViewNotesHistoryLnk.click();
				commNav.waitForPage("Notes/History");
			    
			    // Step: click the top Notes/History record...
			    driver.findElement(By.xpath("//*[@id='history_related']/ul[2]/li[1]/div[3]/h3")).click();
			    commNav.waitForPage("Meeting");
			    
			    // Step: click the Attachments link...
			    driver.findElement(By.xpath("//*[@id='history_detail']/descendant::*[text() = 'Attachments']")).click();
			    commNav.waitForPage("History Attachments");
			
			    // Step: click the top Add buton...
			    headerButton.clickHeaderButton("add");
			    commNav.waitForPage("Add Attachments");
			    
			    // Step: click the 'add a file' section of the screen...
			    //TODO: the sendKeys() action doesn't work correctly on FF browser; works only on Chrome
			    String filepath = "C://uploadtest.txt";
			    driver.findElement(By.xpath(".//*[@id='attachment_Add']/div[1]/div/div/input")).sendKeys(filepath);
			    Thread.sleep(2000);	    
			    
			    // Step: setup a unique, time-based file name for the uploaded file...
			    String newfilename = "upload." + new SimpleDateFormat("yyMMddHHmm").format(new GregorianCalendar().getTime()) + ".txt";
			    driver.findElement(By.id("File_0")).clear();
			    Thread.sleep(1000);
			    driver.findElement(By.id("File_0")).sendKeys(newfilename);
			    Thread.sleep(1000);
			    
			    // Step: proceed with file upload...
			    driver.findElement(By.id("fileSelect-btn-upload")).click();
			    Thread.sleep(3000);
			    commNav.waitForPage("History Attachments");
			    
			    // VP: verify that new attachment appears in the Lead Attachments list view...		   
			    try {
			      assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*" + newfilename + "[\\s\\S]*$"));
			    } catch (Error e) {
			      verificationErrors.append(methodID + "(): " + e.toString());
			    }
			    
			    //Section 2 - 
			    //-----------
			    // Step: navigate back to Lead detail view...
			    headerButton.goBack();
			    commNav.waitForNotPage("History Attachments");
	
			    headerButton.goBack();
			    commNav.waitForPage("Notes/History");
	
			    headerButton.goBack();
			    commNav.waitForPage(leadRecord);
			
			    // Step: navigate to the Lead Attachments list view...
			    leadDetailView.leadsDetailViewAttachmentsLnk.click();
			    commNav.waitForPage("Lead Attachments");
			
			    // Step: perform search of Attachment added from associated Contact detail view...
			    headerButton.showRightContextMenu();
			    driver.findElement(By.xpath("//*[@id='Sage_Platform_Mobile_SearchWidget_38']/div/div[1]/input")).clear();
			    Thread.sleep(1000);
			    driver.findElement(By.xpath("//*[@id='Sage_Platform_Mobile_SearchWidget_38']/div/div[1]/input")).sendKeys(newfilename);
			    Thread.sleep(1000);
			    driver.findElement(By.xpath("//*[@id='Sage_Platform_Mobile_SearchWidget_38']/div/div[3]/button")).click();
			    Thread.sleep(3000);
			    
			    // VP: verify that the Attachment item is found
			    try {
			      assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*" + newfilename + "[\\s\\S]*$"));
			    } catch (Error e) {
			      verificationErrors.append(methodID + "(): " + e.toString());
			    }
			}
			catch (Error e) {
				System.out.println(methodID + "(): " + e.toString());
				return;
			}		
			
			// End Tests
		    headerButton.goBack();
		    Thread.sleep(1000);
		    headerButton.goBack();
		    Thread.sleep(1000); 
			commNav.clickGlobalMenuItem("My Activities");
		}		
		else {
			System.out.println(methodID + ": this test can only be run on the Chromedriver browser; skipping...");
		}
		
		System.out.println(ENDLINE);
	}

	@Test(enabled = false)
	public void test49_MobileDefect13091564()  throws InterruptedException {				
		String methodID = "test49_MobileDefect13091564";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerbutton = PageFactory.initElements(driver, HeaderButton.class);
		
		// test params
		String contactName = "Abbott";
		String contactCheck = "Abbott, John";
		String cuisineSel1 = "French";
		String cuisineSel2 = "American Grill";
		
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
		// Step: click the Top-Left, Global Menu button...
		headerbutton.showGlobalMenu();
	
		// Step: click the Contacts link
		commNav.clickGlobalMenuItem("Contacts");
	
		// Step: perform search for required Contact record...
		commNav.searchListView("contact", contactName);
		Thread.sleep(3000);
		try {
			AssertJUnit.assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*"+ contactCheck +"[\\s\\S]*$"));
			System.out.println("Step: '" + contactCheck + "' check on Contacts, List View - Passed");
			
			//Step: open the Contact record's Detail View...
			driver.findElement(By.xpath("//*[@id='contact_list']/descendant::*[text() = '" + contactCheck + "']")).click();
		    for (int second = 0;; second++) {
		    	if (second >= 60) AssertJUnit.fail("timeout");
		    	try { if (contactCheck.equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
		    	Thread.sleep(1000);
		    }
		    
		    //Step: click the Header, Edit button...
		    headerbutton.clickHeaderButton("edit");
		    for (int second = 0;; second++) {
		    	if (second >= 60) AssertJUnit.fail("timeout");
		    	try { if ("Contact".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
		    	Thread.sleep(1000);
		    }
		    
		    //Step: check to see if the Cuisine selection is empty or not...
		    String cuisineVal = driver.findElement(By.xpath("//*[@id='Mobile_SalesLogix_Fields_PicklistField_16']/input")).getAttribute("value");
		    if (!"".equals(cuisineVal)) {
			    //Step: clear any previous Cuisine selections...
				driver.findElement(By.xpath("//*[@id='Mobile_SalesLogix_Fields_PicklistField_16']/button")).click();
			    for (int second = 0;; second++) {
			    	if (second >= 60) AssertJUnit.fail("timeout");
			    	try { if ("Cuisine".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
			    	Thread.sleep(1000);
			    }
			    
			    //Step: from Cuisine list, click the None button then Check button
			    driver.findElement(By.xpath("//*[@id='pick_list_0']/div[2]/button")).click();
			    Thread.sleep(1000);
			    for (int second = 0;; second++) {
			    	if (second >= 60) AssertJUnit.fail("timeout");
			    	try { if ("Contact".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
			    	Thread.sleep(1000);
			    }			    
		    }
		    		    
		    //Step: make 1st Cuisine selection...
			driver.findElement(By.xpath("//*[@id='Mobile_SalesLogix_Fields_PicklistField_16']/button")).click();
		    for (int second = 0;; second++) {
		    	if (second >= 60) AssertJUnit.fail("timeout");
		    	try { if ("Cuisine".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
		    	Thread.sleep(1000);
		    }
		    
		    //Step: from Cuisine list, make 1st selection then click Header, Check button
		    driver.findElement(By.xpath("//*[@id='pick_list_0']/descendant::*[text() = '" + cuisineSel1 + "']")).click();
		    Thread.sleep(1000);
		    headerbutton.clickHeaderButton("check");
		    for (int second = 0;; second++) {
		    	if (second >= 60) AssertJUnit.fail("timeout");
		    	try { if ("Contact".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
		    	Thread.sleep(1000);
		    }
		    
		    //VP: check the modified Cuisine field value
		    try {
		    	  AssertJUnit.assertEquals(cuisineSel1, driver.findElement(By.xpath("//*[@id='Mobile_SalesLogix_Fields_PicklistField_16']/input")).getAttribute("value"));
		    	  System.out.println("VP: Cuisine field value set to '" + cuisineSel1 + "' - Passed");
		    	} catch (Error e) {
		    	  System.out.println("VP: Cuisine field value set to '" + cuisineSel1 + "' - FAILED");
		    	  verificationErrors.append(methodID + "(): " + e.toString());
		    }
		    
		    //Step: make 2nd Cuisine selection...
			driver.findElement(By.xpath("//*[@id='Mobile_SalesLogix_Fields_PicklistField_16']/button")).click();
		    for (int second = 0;; second++) {
		    	if (second >= 60) AssertJUnit.fail("timeout");
		    	try { if ("Cuisine".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
		    	Thread.sleep(1000);
		    }
		    
		    //Step: from Cuisine list, make 2nd selection then click Header, Check button
		    driver.findElement(By.xpath("//*[@id='pick_list_0']/descendant::*[text() = '" + cuisineSel2 + "']")).click();
		    Thread.sleep(1000);
		    headerbutton.clickHeaderButton("check");
		    for (int second = 0;; second++) {
		    	if (second >= 60) AssertJUnit.fail("timeout");
		    	try { if ("Contact".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
		    	Thread.sleep(1000);
		    }
		    
		    //VP: check the final modified Cuisine field value
		    try {
		    	  AssertJUnit.assertEquals(cuisineSel1 + ", " + cuisineSel2, driver.findElement(By.xpath("//*[@id='Mobile_SalesLogix_Fields_PicklistField_16']/input")).getAttribute("value"));
		    	  System.out.println("VP: Cuisine field value set to '" + cuisineSel1 + ", " + cuisineSel2 + "' - Passed");
		    	} catch (Error e) {
		    	  System.out.println("VP: Cuisine field value set to '" + cuisineSel1 + ", " + cuisineSel2 + "' - FAILED");
		    	  verificationErrors.append(methodID + "(): " + e.toString());
		    }		    
			
		    //Step: click the Header, Cancel button...
		    headerbutton.clickHeaderButton("cancel");
		    for (int second = 0;; second++) {
		    	if (second >= 60) AssertJUnit.fail("timeout");
		    	try { if (contactCheck.equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
		    	Thread.sleep(1000);
		    }		    
		    
		} catch (Error e) {
			System.out.println("Step: '" + contactCheck + "' check on Contacts, List View - FAILED");
			verificationErrors.append(methodID + "(): " + e.toString());
		}
		
		// End Tests
		// Step: click the Top-Left, Global Menu button...
		headerbutton.showGlobalMenu();
		commNav.clickGlobalMenuItem("My Activities");
		
		System.out.println(ENDLINE);
	}
	

	@Test(enabled = true)
	public void test50_MobileDefect13092146()  throws Exception {				
		String methodID = "test50_MobileDefect13092146";		
		
		// test params
		String entityType = "Contacts";
		String contactName = "Alexander, Mark";
		String actType = "To-Do";
		String regardingVal = "Send quote";
		String repeatVal = "Daily";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerbutton = PageFactory.initElements(driver, HeaderButton.class);
				
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
		
		// Step: click the Top-Left, Global Menu button...
		headerbutton.showGlobalMenu();
	
		// Step: click the Contacts link
		commNav.clickGlobalMenuItem(entityType);
	
		// Step: perform search for Contact record
		commNav.searchListView("contact", contactName);
		Thread.sleep(3000);
		try {
			AssertJUnit.assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*"+ contactName +"[\\s\\S]*$"));
			System.out.println("Step: '" + contactName + "' check on Contacts, List View - Passed");
			
			//Step: open the Contact record's Detail View...			
			commNav.entityRecordOpenDetailView(entityType, contactName);
			
			ContactViewsElements contactDetailView = PageFactory.initElements(driver, ContactViewsElements.class);
		    		    
		    //Step: click the Schedule Activity link...
			contactDetailView.contactsDetailViewScheduleActivityLnk.click();
			commNav.waitForPage("Schedule...");
			
			//TODO: create a separate class for scheduling activities...
			//SubStep: set the To-Do Activity Type...(do not select, just enter the value in the input field)
			driver.findElement(By.xpath("//*[@id='activity_types_list']/descendant::*[text() = '" + actType + "']")).click();
			commNav.waitForPage(actType);
			
			MyActivityViewsElements activityEditView = PageFactory.initElements(driver, MyActivityViewsElements.class);
		    
			//SubStep: setup and confirm the Regarding field val...
			//NOTE: here we just set the value of the input text field; selecting a Regarding value is not supported by Se WebDriver
			activityEditView.activityEditViewRegardingFld.clear();
			activityEditView.activityEditViewRegardingFld.sendKeys(regardingVal);		    
		    //VP: check the modified Regarding field val...
		    try {
		    	  AssertJUnit.assertEquals(actType, activityEditView.activityEditViewRegardingFld.getAttribute("value"));
		    	  System.out.println("VP: Regarding field value set to '" + regardingVal + "' - Passed");
		    	} catch (Error e) {
		    	  System.out.println("VP: Regarding field value set to '" + regardingVal + "' - FAILED");
		    	  verificationErrors.append(methodID + "(): " + e.toString());
		    }
		    
		    //SubStep: setup and confirm the Start Time field val...
		    String oldStartTime = activityEditView.activityEditViewStartTimeFld.getAttribute("value");
		    activityEditView.activityEditViewStartTimeFldBtn.click();
			commNav.waitForPage("Calendar");
			//TODO: create a separate class for the Calendar Date view
			//set Start Time = +1 Month
			driver.findElement(By.xpath("//*[@id='datetime-picker-date']/tbody/tr[1]/td[1]/button")).click();
			headerbutton.clickHeaderButton("check");
			commNav.waitForPage(actType);
			
		    //VP: check the modified Start Time field val...
			activityEditView = PageFactory.initElements(driver, MyActivityViewsElements.class);
			String newStartTime = activityEditView.activityEditViewStartTimeFld.getAttribute("value");
		    try {
		    	  AssertJUnit.assertNotSame(oldStartTime, newStartTime);
		    	  System.out.println("VP: Start Time field value set to '" + newStartTime + "' - Passed");
		    	} catch (Error e) {
		    	  System.out.println("VP: Regarding field value set to '" + newStartTime + "' - FAILED");
		    	  verificationErrors.append(methodID + "(): " + e.toString());
		    }
		    
		    //SubStep: setup and confirm the Repeats field val...
		    activityEditView.activityEditViewRepeatsFldBtn.click();
			commNav.waitForPage("Recurring");		    
			driver.findElement(By.xpath("//*[@id='select_list']/descendant::*[text() = '" + repeatVal + "']")).click();
			commNav.waitForPage(actType);
		    try {
		    	  AssertJUnit.assertEquals(repeatVal, activityEditView.activityEditViewRepeatsFld.getAttribute("value"));
		    	  System.out.println("VP: Repeats field value set to '" + repeatVal + "' - Passed");
		    	} catch (Error e) {
		    	  System.out.println("VP: Repeats field value set to '" + repeatVal + "' - FAILED");
		    	  verificationErrors.append(methodID + "(): " + e.toString());
		    }
		    
		    //SubStep: setup and confirm the Recurring Until field val...
		    activityEditView = PageFactory.initElements(driver, MyActivityViewsElements.class);
		    activityEditView.activityEditViewRecurringFldBtn.click();
			commNav.waitForPage("Recurrence");
			//Note: here we just open the Recurrence page, then click the Header, Check button (no changes)
			headerbutton.clickHeaderButton("check");
			
		    //Step: click the Header, Save button to return to Contact detail view...
		    headerbutton.clickHeaderButton("save");
		    Thread.sleep(3000);
		    if (commNav.waitForPage(contactName)) {
			    System.out.println(methodID + ": successfully scheduled an '" + actType + " - " + regardingVal + "' activity for " + entityType + " - " + contactName);
		    }
		    
		    //Step: click the Attachments link from the Contact detail view...
		    contactDetailView = PageFactory.initElements(driver, ContactViewsElements.class);
		    contactDetailView.contactsDetailViewAttachmentsLnk.click();
			commNav.waitForPage("Contact Attachments");
			
			// Step: click the top Add buton...
		    headerbutton.addButton.click();
		    commNav.waitForPage("Add Attachments");
		
		    // VP: confirm the elements of the Add Attachments screen...
		    try {
		      AssertJUnit.assertTrue(isElementPresent(By.cssSelector("input[type=\"file\"]")));
		    } catch (Error e) {
		      verificationErrors.append(methodID + "(): " + e.toString());
		    }
		    try {
		    	AssertJUnit.assertTrue(isElementPresent(By.cssSelector("button.button.inline")));
		    } catch (Error e) {
		      verificationErrors.append(methodID + "(): " + e.toString());
		    }
		    try {
		    	AssertJUnit.assertTrue(isElementPresent(By.xpath("//div[@id='attachment_Add']/div[2]/div/button[2]")));
		    } catch (Error e) {
		      verificationErrors.append(methodID + "(): " + e.toString());
		    }
		    
		    // Step: click the 'add a file' section of the screen...
		    String filepath = "C://uploadtest.txt";
		    driver.findElement(By.xpath(".//*[@id='attachment_Add']/div[1]/div/div/input")).sendKeys(filepath);
		    Thread.sleep(2000);	    
		    
		    // Step: setup a unique, time-based file name for the uploaded file...
		    String newfilename = "upload." + new SimpleDateFormat("yyMMddHHmm").format(new GregorianCalendar().getTime()) + ".txt";
		    try {
			    driver.findElement(By.id("File_0")).clear();
			    Thread.sleep(1000);
			    driver.findElement(By.id("File_0")).sendKeys(newfilename);
			    Thread.sleep(1000);
			    
			    // Step: proceed with file upload...
			    driver.findElement(By.id("fileSelect-btn-upload")).click();
			    
			    // Step: verify that new attachment appears in the Contact Attachments list view...
			    commNav.waitForPage("Contact Attachments");
			    try {
			    	AssertJUnit.assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*" + newfilename + "[\\s\\S]*$"));
			    	System.out.println("VP: the '" + newfilename + "' attachmment upload check - Passed");
			    } 
			    catch (Error e) {
			    	System.out.println("VP: the '" + newfilename + "' attachmment upload check - FAILED");
			    	verificationErrors.append(methodID + "(): " + e.toString());
			    }
		    }
		    catch (Exception e) {
		    	//System.out.println(methodID + "(): " + e.toString());
		    	System.out.println(methodID + ": unable to upload the file due to a system issue; step skipped");
		    }
		    
		} catch (Error e) {
			System.out.println("Step: '" + contactName + "' check on Contacts, List View - FAILED");
			verificationErrors.append(methodID + "(): " + e.toString());
		}
		
		// End Tests
		// Step: click the Top-Left, Global Menu button...
		headerbutton.showGlobalMenu();
		commNav.clickGlobalMenuItem("My Activities");
		
		System.out.println(ENDLINE);		
	}
	
	
	@Test(enabled = true)
	public void test51_MobileDefect13092282()  throws InterruptedException {				
		String methodID = "test51_MobileDefect13092282";
				
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
		
		System.out.println("NOTE: Please run the 'test50_MobileDefect13092146' test method instead.");
		
		System.out.println(ENDLINE);		
	}
	

	@Test (enabled = true)
	public void test52_MobileDefect13092102() throws Exception {
		String methodID = "test52_MobileDefect13092102";
	
		//Test Params:
		String entityType = "Leads";
		String leadRecord1 = "Abell, Abbie";
		String leadRecord2 = "Achew, Pete";
		String uploadFilePath = "C:\\uploadtest.txt";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
		
		if (browsername.toLowerCase().equals("cr")) {
			try {
			    // - Start Section
			    //Step: navigate to specific Leads list view...
				commNav.entityRecordOpenDetailView(entityType, leadRecord1);
			    
				LeadViewsElements leadDetailView = PageFactory.initElements(driver, LeadViewsElements.class);
			
			    // Step: click the Attachments link...
				leadDetailView.leadsDetailViewAttachmentsLnk.click();
			    	
			    // Step: click the top Add button...
				headerButton.addButton.click();
			    commNav.waitForPage("Add Attachments");
			    
			    // Step: click the 'add a file' section of the screen...
			    String filepath = uploadFilePath;
			    driver.findElement(By.xpath(".//*[@id='attachment_Add']/div[1]/div/div/input")).sendKeys(filepath);
			    Thread.sleep(2000);	    
			    
			    // Step: setup a unique, time-based file name for the uploaded file...
			    String newfilename = "upload." + new SimpleDateFormat("yyMMddHHmm").format(new GregorianCalendar().getTime()) + ".txt";
			    driver.findElement(By.id("File_0")).clear();
			    Thread.sleep(1000);
			    driver.findElement(By.id("File_0")).sendKeys(newfilename);
			    Thread.sleep(1000);
			    
			    // Step: proceed with file upload...
			    driver.findElement(By.id("fileSelect-btn-upload")).click();
			    
			    // Step: verify that new attachment appears in the Lead Attachments list view...
			    for (int second = 0;; second++) {
			    	if (second >= 60) AssertJUnit.fail("timeout");
			    	try { if ("Lead Attachments".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
			    	Thread.sleep(1000);
			    }
			    try {
			      AssertJUnit.assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*" + newfilename + "[\\s\\S]*$"));
			    } catch (Error e) {
			      verificationErrors.append(e.toString());
			    }
			    // -- End Section
			    
			    // - Start Section
			    // Step: add the same attachment a 2nd-time...
			    // Step: click the top Add buton...
			    headerButton = PageFactory.initElements(driver, HeaderButton.class);
			    
			    headerButton.addButton.click();
			    commNav.waitForPage("Lead Attachments");
			    
			    // Step: click the 'add a file' section of the screen...
			    driver.findElement(By.xpath(".//*[@id='attachment_Add']/div[1]/div/div/input")).sendKeys(filepath);
			    Thread.sleep(2000);	    
			    
			    // Step: re-use the same file name for the uploaded file...
			    driver.findElement(By.id("File_0")).clear();
			    Thread.sleep(1000);
			    driver.findElement(By.id("File_0")).sendKeys(newfilename);
			    Thread.sleep(1000);
			    
			    // Step: proceed with file upload...
			    driver.findElement(By.id("fileSelect-btn-upload")).click();
			    
			    // Step: verify that new attachment appears in the Lead Attachments list view...
			    for (int second = 0;; second++) {
			    	if (second >= 60) AssertJUnit.fail("timeout");
			    	try { if ("Lead Attachments".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
			    	Thread.sleep(1000);
			    }
			    try {
			      AssertJUnit.assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*" + newfilename + "[\\s\\S]*$"));
			    } catch (Error e) {
			      verificationErrors.append(e.toString());
			    }
			    // -- End Section
			    
			    // -- Start Section
			    // Step: add the same attachment to a 2nd-Lead record...
			    //Step: navigate to specific Leads list view...
				commNav.entityRecordOpenDetailView(entityType, leadRecord2);
			    
				leadDetailView = PageFactory.initElements(driver, LeadViewsElements.class);
			
			    // Step: click the Attachments link...
				leadDetailView.leadsDetailViewAttachmentsLnk.click();
			    	
			    // Step: click the top Add button...
				headerButton.addButton.click();
			    commNav.waitForPage("Add Attachments");
			    
			    // Step: click the 'add a file' section of the screen...
			    driver.findElement(By.xpath(".//*[@id='attachment_Add']/div[1]/div/div/input")).sendKeys(filepath);
			    Thread.sleep(2000);	    
			    
			    // Step: re-use the same file name for the uploaded file...
			    driver.findElement(By.id("File_0")).clear();
			    Thread.sleep(1000);
			    driver.findElement(By.id("File_0")).sendKeys(newfilename);
			    Thread.sleep(1000);
			    
			    // Step: proceed with file upload...
			    driver.findElement(By.id("fileSelect-btn-upload")).click();
			    
			    // Step: verify that new attachment appears in the Lead Attachments list view...
			    for (int second = 0;; second++) {
			    	if (second >= 60) AssertJUnit.fail("timeout");
			    	try { if ("Lead Attachments".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
			    	Thread.sleep(1000);
			    }
			    try {
			      AssertJUnit.assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*" + newfilename + "[\\s\\S]*$"));
			    } catch (Error e) {
			      verificationErrors.append(e.toString());
			    }
			    // -- End Section    
			    
			    // -- Start Section
			    // Step: navigate back to My Activities view...
			    headerButton.backButton.click();
			    leadDetailView.leadsDetailViewAttachmentsLnk.click();
			}
			catch (Exception e) {
				System.out.println(methodID + ": " + e.toString());
			}
		}
		else {
			System.out.println(methodID + ": this test can only be run on the Chromedriver browser; skipping...");
		}
	    
	    System.out.println(ENDLINE);	
	    // - End Section
	    // -- END
	}
	

	//TODO: need to update test53_MobileDefect13092153() needs an update for 2.3
	@Test (enabled = false)
	  public void test53_MobileDefect13092153() throws Exception {
		String methodID = "test53_MobileDefect13092153";
	
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
	    // - Start Section
	    // Step: click Top-Left button to reveal Global Menu...
	    driver.findElement(By.xpath("//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[1]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) AssertJUnit.fail("timeout");
	    	try { if (isElementPresent(By.xpath("//*[@id='Mobile_SalesLogix_SpeedSearchWidget_0']/div/div[1]/input"))) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	    Thread.sleep(1000);
	
	    // Step: navigate to Leads list view...
	    driver.findElement(By.xpath("//*[@id='left_drawer']/descendant::*[text() = 'Leads']")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) AssertJUnit.fail("timeout");
	    	try { if (isElementPresent(By.xpath("//*[@id='lead_list']/ul/li[1]"))) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // Step: perform search for the 1st-Lead record...
	    driver.findElement(By.xpath("//*[@id='Sage_Platform_Mobile_SearchWidget_16']/div/div[1]/input")).clear();
	    Thread.sleep(500);
	    driver.findElement(By.xpath("//*[@id='Sage_Platform_Mobile_SearchWidget_16']/div/div[1]/input")).sendKeys("Ballard");
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("//*[@id='Sage_Platform_Mobile_SearchWidget_16']/div/div[3]/button")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) AssertJUnit.fail("timeout");
	    	try { if (isElementPresent(By.xpath("//*[@id='lead_list']/ul/li[1]"))) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	    try {
	      assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Ballard, Matt[\\s\\S]*$"));
	    } catch (Error e) {
	      verificationErrors.append(methodID + "(): " + e.toString());
	    }
	    
	    // Step: navigate to top Lead record...
	    driver.findElement(By.xpath("//*[@id='lead_list']/ul/li/div/h3")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) AssertJUnit.fail("timeout");
	    	try { if ("Ballard, Matt".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	    
	    // Step: click the Activities link...
	    driver.findElement(By.xpath("//*[@id='lead_detail']/descendant::*[text() = 'Activities']")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) AssertJUnit.fail("timeout");
	    	try { if ("Activities".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	    
	    // Step: click to open the top Activities item...
	    driver.findElement(By.xpath("//*[@id='activity_related']/ul/li/div[2]/h3/span")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) AssertJUnit.fail("timeout");
	    	try { if (!"Activities".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }	    
	    
	    // Step: click the Attachments link...
	    driver.findElement(By.xpath("//*[@id='activity_detail']/div[2]/ul[2]/li/a/span")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) AssertJUnit.fail("timeout");
	    	try { if ("Activity Attachments".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	    	
	    // Step: click the top Add button...
	    driver.findElement(By.xpath("//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[2]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) AssertJUnit.fail("timeout");
	    	try { if ("Add Attachments".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	    
	    // Step: click the 'add a file' section of the screen...
	    String filepath = "C://uploadtest.txt";
	    driver.findElement(By.xpath(".//*[@id='attachment_Add']/div[1]/div/div/input")).sendKeys(filepath);
	    Thread.sleep(2000);	    
	    
	    // Step: setup a unique, time-based file name for the uploaded file...
	    String newfilename = "upload." + new SimpleDateFormat("yyMMddHHmm").format(new GregorianCalendar().getTime()) + ".txt";
	    driver.findElement(By.id("File_0")).clear();
	    Thread.sleep(1000);
	    driver.findElement(By.id("File_0")).sendKeys(newfilename);
	    Thread.sleep(1000);
	    
	    // Step: proceed with file upload...
	    driver.findElement(By.id("fileSelect-btn-upload")).click();
	    
	    // Step: verify that new attachment appears in the Lead Attachments list view...
	    for (int second = 0;; second++) {
	    	if (second >= 60) AssertJUnit.fail("timeout");
	    	try { if ("Activity Attachments".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	    try {
	      assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*" + newfilename + "[\\s\\S]*$"));
	    } catch (Error e) {
	      verificationErrors.append(methodID + "(): " + e.toString());
	    }
	    // -- End Section
	    
	    // Step: navigate back to Lead detail view...
	    driver.findElement(By.xpath("//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) AssertJUnit.fail("timeout");
	    	try { if (!"Activity Attachments".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	    driver.findElement(By.xpath("//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) AssertJUnit.fail("timeout");
	    	try { if ("Activities".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	    driver.findElement(By.xpath("//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) AssertJUnit.fail("timeout");
	    	try { if ("Ballard, Matt".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // Step: navigate to the Lead Attachments list view...
	    driver.findElement(By.xpath("//*[@id='lead_detail']/descendant::*[text() = 'Attachments']")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) AssertJUnit.fail("timeout");
	    	try { if ("Lead Attachments".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	    
	    // VP: verify that the Attachment item is found
	    try {
	      assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*" + newfilename + "[\\s\\S]*$"));
	    } catch (Error e) {
	      verificationErrors.append(methodID + "(): " + e.toString());
	    }
	    
	    // Step: navigate back to My Activities view...
	    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[1]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) AssertJUnit.fail("timeout");
	    	try { if (isElementPresent(By.xpath(".//*[@id='Mobile_SalesLogix_SpeedSearchWidget_0']/div/div[1]/input"))) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	    driver.findElement(By.xpath(".//*[@id='left_drawer']/descendant::*[text() = 'My Activities']")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) AssertJUnit.fail("timeout");
	    	try { if (isElementPresent(By.xpath(".//*[@id='myactivity_list']/ul/li[1]"))) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	    System.out.println(ENDLINE);	
	    // - End Section
	    // -- END
	  }

	@Test (enabled = false)
	public void test54_MobileDefect13091934()  throws InterruptedException {				
		String methodID = "test54_MobileDefect13091934";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);
		
				
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
		// Step: click the Top-Left, Global Menu button...
		headerButton.showGlobalMenu();
	
		// Step: click the Calendar link
		commNav.clickGlobalMenuItem("Calendar");		
		try {
			AssertJUnit.assertTrue(commNav.isPageDisplayed("Calendar"));
			
			//Step: setup 21 new Activity events for the current day
			String regardingFldVal = "Test To-Do Activity - ";
			for (int iCount = 0;iCount<22;iCount++ ) {
			// click the Add Header button to setup a new Activity
				headerButton.clickHeaderButton("add");
				try {
					AssertJUnit.assertTrue(commNav.waitForPage("Schedule..."));
					
					// select the To-Do activity type
					//TODO: re-factor the following to use ActivityViewsElements def.
					driver.findElement(By.xpath("//*[@id='activity_types_list']/descendant::*[text() = 'To-Do']")).click();
					AssertJUnit.assertTrue(commNav.waitForPage("To-Do"));
					Thread.sleep(1000);
					
					// setup the Regarding field value
					//TODO: re-factor the following to use ActivityViewsElements def.
					driver.findElement(By.xpath("//*[@id='Mobile_SalesLogix_Fields_PicklistField_28']/input")).sendKeys(regardingFldVal + iCount);
					driver.findElement(By.xpath("//*[@id='Sage_Platform_Mobile_Fields_TextField_102']/input")).click();
					Thread.sleep(500);
					
					// click the top Save button
					headerButton.clickHeaderButton("save");
					AssertJUnit.assertTrue(commNav.waitForPage("Calendar"));
					System.out.println(methodID + ": '" + regardingFldVal + "' was scheduled");
					Thread.sleep(1000);
				}
				catch (Error e) {
					System.out.println(methodID + "(): " + e.toString());
					return;
				}
			}
						
			//Step: confirm that the Retrieve More Records button is available
			String resultsMsg = "VP: Retrieve More Records button is displayed - ";
			try {
				//TODO: re-factor the following to use CalendarViewsElements def.
				AssertJUnit.assertTrue(driver.findElement(By.xpath("//*[@id='calendar_daylist']/div[6]/button")).isDisplayed());
				System.out.println(resultsMsg + "Passed");
			}
			catch (Error e) {
				System.out.println(methodID + "(): " + e.toString());
				System.out.println(resultsMsg + "FAILED");
			}			
		}
		catch (Error e) {
			System.out.println(methodID + "(): " + e.toString());
			return;
		}
		
		// End Tests
		// Step: click the Top-Left, Global Menu button...
		headerButton.showGlobalMenu();
		commNav.clickGlobalMenuItem("My Activities");
		
		System.out.println(ENDLINE);
	}

	@Test(enabled = false)
	public void test55_MobileDefect13092411()  throws Exception {				
		String methodID = "test55_MobileDefect13092411";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);					
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
		
		//Section 1 - schedule an activity under a Contact
		//------------------------------------------------
		//Test Params
		String contactFullName1 = "Alexander, Mark";
		
		//Step: click and open the the Contact record
		commNav.entityRecordOpenDetailView("Contacts", contactFullName1);		
		try {
			AssertJUnit.assertTrue(commNav.isPageDisplayed(contactFullName1));
			
			ContactViewsElements contactDetail = PageFactory.initElements(driver, ContactViewsElements.class);
			
			//Step: open the Activities view
			contactDetail.contactsDetailViewActivitiesLnk.click();
			commNav.waitForPage("Activities");
				
			//schedule a new Activity
			headerButton.clickHeaderButton("add");
			commNav.waitForPage("Schedule...");
			
			//select Meeting type
			driver.findElement(By.xpath("//*[@id='activity_types_list']/descendant::*[text() = 'Meeting']")).click();
			commNav.waitForPage("Meeting");
			
			//setup Regarding field
			driver.findElement(By.xpath("//*[@id='Mobile_SalesLogix_Fields_PicklistField_28']/input")).click();
			driver.findElement(By.xpath("//*[@id='Mobile_SalesLogix_Fields_PicklistField_28']/input")).sendKeys("Dinner meeting");
			driver.findElement(By.xpath("//*[@id='Mobile_SalesLogix_Fields_PicklistField_28']/input")).sendKeys(Keys.RETURN);
			Thread.sleep(1000);
			
			//keep remaining default field vals then save the activity
			headerButton.clickHeaderButton("save");
			commNav.waitForPage("Activities");
			
			//VP: check to see the Contact's scheduled activity is listed
			String resultMsg = "VP: Contact's scheduled activity listed under the Contact's Activities view";
			try {
				AssertJUnit.assertTrue(commNav.isTextPresentOnPage("Dinner meeting"));
				System.out.println(resultMsg + " - Passed");
			}
			catch (Error e) {
				System.out.println(methodID + "(): " + e.toString());
				System.out.println(resultMsg + " - FAILED");
			}
		}
		catch (Error e) {
			System.out.println(methodID + "(): " + e.toString());
			return;
		}
		
		//Section 2 - schedule an activity under a Lead
		//---------------------------------------------
		//Test Params
		String leadFullName1 = "Bass, Stuart";
		
		//Step: click and open the the Contact record
		commNav.entityRecordOpenDetailView("Leads", leadFullName1);
		try {
			AssertJUnit.assertTrue(commNav.isPageDisplayed(leadFullName1));
			
			LeadViewsElements leadDetail = PageFactory.initElements(driver, LeadViewsElements.class);
			
			//Step: open the Activities view
			leadDetail.leadsDetailViewActivitiesLnk.click();
			commNav.waitForPage("Activities");
				
			//schedule a new Activity
			headerButton.clickHeaderButton("add");
			commNav.waitForPage("Schedule...");
			
			//select Meeting type
			driver.findElement(By.xpath("//*[@id='activity_types_list']/descendant::*[text() = 'Personal Activity']")).click();
			commNav.waitForPage("Personal Activity");
			
			//setup Regarding field
			driver.findElement(By.xpath("//*[@id='Mobile_SalesLogix_Fields_PicklistField_28']/input")).click();
			driver.findElement(By.xpath("//*[@id='Mobile_SalesLogix_Fields_PicklistField_28']/input")).sendKeys("Buy Gift");
			driver.findElement(By.xpath("//*[@id='Mobile_SalesLogix_Fields_PicklistField_28']/input")).sendKeys(Keys.RETURN);
			Thread.sleep(1000);
			
			//keep remaining default field vals then save the activity
			headerButton.clickHeaderButton("save");
			commNav.waitForPage("Activities");
			
			//VP: check to see the Lead's scheduled activity is listed
			String resultMsg = "VP: Lead's scheduled activity listed under the Lead's Activities view";
			try {
				AssertJUnit.assertTrue(commNav.isTextPresentOnPage("Buy Gift"));
				System.out.println(resultMsg + " - Passed");
			}
			catch (Error e) {
				System.out.println(methodID + "(): " + e.toString());
				System.out.println(resultMsg + " - FAILED");
			}
		}
		catch (Error e) {
			System.out.println(methodID + "(): " + e.toString());
			return;
		}
		
		//Section 3 - check to see that the Lead's activity is not listed under the Contact
		//---------------------------------------------------------------------------------
		//Step: click and re-open the the Contact record
		commNav.entityRecordOpenDetailView("Contacts", contactFullName1);		
		try {
			AssertJUnit.assertTrue(commNav.isPageDisplayed(contactFullName1));
			
			ContactViewsElements contactDetail = PageFactory.initElements(driver, ContactViewsElements.class);
			
			//Step: open the Activities view
			contactDetail.contactsDetailViewActivitiesLnk.click();
			commNav.waitForPage("Activities");
			
			//VP: check to see that the Lead's activity is NOT listed under the Contact
			String resultMsg = "VP: Lead's activity is NOT listed under the Contact record";
			try {
				AssertJUnit.assertTrue(commNav.isTextNotPresentOnPage("Buy Gift"));
				System.out.println(resultMsg + " - Passed");
			}
			catch (Error e) {
				System.out.println(methodID + "(): " + e.toString());
				System.out.println(resultMsg + " - FAILED");
			}
		}
		catch (Error e) {
			System.out.println(methodID + "(): " + e.toString());
			return;
		}
		
		
		// End Tests
		commNav.clickGlobalMenuItem("My Activities");
		
		System.out.println(ENDLINE);
	}

	@Test(enabled = true)
	public void test56_MobileDefect13092300()  throws InterruptedException {
		//tags: my attachments, download view attachment
		String methodID = "test56_MobileDefect13092300";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerbutton = PageFactory.initElements(driver, HeaderButton.class);
		
		// test params
		String attachmentName = "ibm";
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
		// Step: click the Top-Left, Global Menu button...
		headerbutton.showGlobalMenu();
	
		// Step: click the My Attachments link
		commNav.clickGlobalMenuItem("My Attachments");
		
		// Step: perform search for Attachment record
		commNav.searchListView("attachment", attachmentName);
		
		// Step: click to download and view the attachment
		try {
			driver.findElement(By.xpath("//*[@id='myattachment_list']/ul/li/div/div[2]/h3/span")).click();
		} catch (Exception e) {
			System.out.println("The '" + attachmentName + "' attachment was not available for the test.");
		};
		Thread.sleep(7000);
				
		// VP: confirm that URL attachment is loaded and displayed correctly
		try {
			AssertJUnit.assertTrue(isElementPresent(By.xpath("//*[@id='attachment-Iframe']")));
		}
		catch (Error e) {
			System.out.println(methodID + "(): " + e.toString());
		}
				
		// Step: navigate back to the My Activities list view
		headerbutton.showGlobalMenu();
		commNav.clickGlobalMenuItem("My Activities");
		commNav.waitForPage("My Activities");
		
		// End Tests
		System.out.println(ENDLINE);
	}
	
	@Test(enabled = false)
	public void test57_MobileDefect13092329()  throws Exception {				
		String methodID = "test57_MobileDefect13092329";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);					
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
		
		//Section 1 - schedule an activity under an Account
		//-------------------------------------------------
		//Test Params
		String accountName1 = "Abbott WorldWide";
		
		//Step: click and open the the Account record
		commNav.entityRecordOpenDetailView("Accounts", accountName1);		
		try {
			AssertJUnit.assertTrue(commNav.isPageDisplayed(accountName1));
			
			AccountViewsElements accountDetail = PageFactory.initElements(driver, AccountViewsElements.class);
			
			//Step: open the Activities view
			accountDetail.accountDetailViewActivitiesLnk.click();
			commNav.waitForPage("Activities");
				
			//schedule a new Activity
			headerButton.clickHeaderButton("add");
			commNav.waitForPage("Schedule...");
			
			//select Meeting type
			driver.findElement(By.xpath("//*[@id='activity_types_list']/descendant::*[text() = 'Meeting']")).click();
			Thread.sleep(2000);
			commNav.waitForPage("Meeting");
			
			//setup Regarding field
			driver.findElement(By.xpath("//*[@id='Mobile_SalesLogix_Fields_PicklistField_28']/input")).click();
			driver.findElement(By.xpath("//*[@id='Mobile_SalesLogix_Fields_PicklistField_28']/input")).sendKeys("Training");
			driver.findElement(By.xpath("//*[@id='Mobile_SalesLogix_Fields_PicklistField_28']/input")).sendKeys(Keys.RETURN);
			Thread.sleep(1000);
			
			//click Regarding field selection button
			driver.findElement(By.xpath("//*[@id='Mobile_SalesLogix_Fields_PicklistField_28']/button")).click();
			commNav.waitForPage("Activity Description");
			String activityDescListInitTxt = driver.findElement(By.xpath("//*[@id='pick_list_0']/ul")).getText();
			headerButton.clickHeaderButton("cancel");
			
			//setup Category field
			driver.findElement(By.xpath("//*[@id='Mobile_SalesLogix_Fields_PicklistField_30']/input")).click();
			driver.findElement(By.xpath("//*[@id='Mobile_SalesLogix_Fields_PicklistField_30']/input")).sendKeys("Training");
			driver.findElement(By.xpath("//*[@id='Mobile_SalesLogix_Fields_PicklistField_30']/input")).sendKeys(Keys.RETURN);
			Thread.sleep(1000);
			
			//click Category field selection button
			driver.findElement(By.xpath("//*[@id='Mobile_SalesLogix_Fields_PicklistField_30']/button")).click();
			commNav.waitForPage("Activity Category");
			String activityCatListInitTxt = driver.findElement(By.xpath("//*[@id='pick_list_0']/ul")).getText();
			headerButton.clickHeaderButton("cancel");
			
			//keep remaining default field vals then save the activity
			headerButton.clickHeaderButton("save");
			commNav.waitForPage("Activities");
			
			//VP: check to see the Contact's scheduled activity is listed
			String resultMsg = "VP: Contact's scheduled activity listed under the Contact's Activities view";
			try {
				AssertJUnit.assertTrue(commNav.isTextPresentOnPage("Training"));
				System.out.println(resultMsg + " - Passed");
			}
			catch (Error e) {
				System.out.println(methodID + "(): " + e.toString());
				System.out.println(resultMsg + " - FAILED");
			}
						
			//Section 2 - schedule another activity under the same Contact
			//------------------------------------------------------------
			//start to schedule a new Activity
			headerButton.clickHeaderButton("add");
			commNav.waitForPage("Schedule...");
			
			//select Meeting type
			driver.findElement(By.xpath("//*[@id='activity_types_list']/descendant::*[text() = 'Meeting']")).click();
			Thread.sleep(2000);
			commNav.waitForPage("Meeting");
			
			//click Regarding field selection button
			driver.findElement(By.xpath("//*[@id='Mobile_SalesLogix_Fields_PicklistField_28']/button")).click();
			commNav.waitForPage("Activity Description");
			
			//VP: check to see that Activity Description list is un-changed (i.e. no duplicate items)
			String resultsMsg = "VP: Activity Description list view consistency check";
			String activityDescListTxt = driver.findElement(By.xpath("//*[@id='pick_list_0']/ul")).getText();
			try {
				AssertJUnit.assertFalse(activityDescListTxt.equals(activityDescListInitTxt));
				System.out.println(resultsMsg + "- Passed");
			}
			catch (Error e) {
				System.out.println(methodID + "(): " + e.toString());
				System.out.println(resultsMsg + "- FAILED");
			}
			headerButton.clickHeaderButton("cancel");
			
			//click Category field selection button
			driver.findElement(By.xpath("//*[@id='Mobile_SalesLogix_Fields_PicklistField_30']/button")).click();
			commNav.waitForPage("Activity Category");
			
			//VP: check to see that Activity Category list is un-changed (i.e. no duplicate items)
			resultsMsg = "VP: Activity Category list view consistency check";
			String activityCatListTxt = driver.findElement(By.xpath("//*[@id='pick_list_0']/ul")).getText();
			try {
				AssertJUnit.assertFalse(activityCatListTxt.equals(activityCatListInitTxt));
				System.out.println(resultsMsg + "- Passed");
			}
			catch (Error e) {
				System.out.println(methodID + "(): " + e.toString());
				System.out.println(resultsMsg + "- FAILED");
			}
			headerButton.clickHeaderButton("cancel");
		}
		catch (Error e) {
			System.out.println(methodID + "(): " + e.toString());
			return;
		}		
		
		// End Tests
		headerButton.clickHeaderButton("cancel");
		commNav.clickGlobalMenuItem("My Activities");
		
		System.out.println(ENDLINE);
	}

	@Test(enabled = false)
	public void test58_MobileDefect13092338()  throws Exception {	
		//tags: schedule, ticket activity, public access
		String methodID = "test58_MobileDefect13092338";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);					
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
		
		//Test Params
		String ticketRecord = "000-00-000017";
		
		
		//Step: click and open the the Ticket record
		commNav.entityRecordOpenDetailView("Tickets", ticketRecord);		
		try {
			AssertJUnit.assertTrue(commNav.isPageDisplayed(ticketRecord));
			
			TicketViewsElements ticketDetail = PageFactory.initElements(driver, TicketViewsElements.class);
			
			//Step: open the Ticket Activities view
			ticketDetail.ticketsDetailViewTicketsActivitiesLnk.click();
			commNav.waitForPage("Ticket Activities");
				
			//schedule a new Activity
			headerButton.clickHeaderButton("add");
			commNav.waitForPage("Edit Ticket Activity");
			
			//VP: check the default value of the Public Access field
			String publicAccessFldVal = driver.findElement(By.xpath("//*[@id='Mobile_SalesLogix_Fields_PicklistField_27']/input")).getAttribute("value");
			String expectedPublicAccessFldVal = "1-Customer";
			String resultMsg = "VP: Default 'public access' field value set to '1-Customer'";
			try {
				AssertJUnit.assertTrue(publicAccessFldVal.matches(expectedPublicAccessFldVal));
				System.out.println(resultMsg + " - Passed");
			}
			catch (Error e) {
				System.out.println(methodID + "(): " + e.toString());
				System.out.println(resultMsg + " - FAILED");
			}
			
			//set User field value
			driver.findElement(By.xpath("//*[@id='Sage_Platform_Mobile_Fields_LookupField_48']/button")).click();
			commNav.waitForPage("Users");
			driver.findElement(By.xpath("//*[@id='user_list']/descendant::*[text() = 'Administrator, ']")).click();
			commNav.waitForPage("Edit Ticket Activity");
			
			//set Start Date (use default)
			driver.findElement(By.xpath("//*[@id='Sage_Platform_Mobile_Fields_DateField_6']/button")).click();
			commNav.waitForPage("Calendar");
			Thread.sleep(1000);
			headerButton.clickHeaderButton("check");
			commNav.waitForPage("Edit Ticket Activity");
			
			//set End Date (use default)
			driver.findElement(By.xpath("//*[@id='Sage_Platform_Mobile_Fields_DateField_7']/button")).click();
			commNav.waitForPage("Calendar");
			Thread.sleep(1000);
			headerButton.clickHeaderButton("check");
			commNav.waitForPage("Edit Ticket Activity");
			
			//set Comments text (for record identification)
			String commentsTxt = "Test Ticket Activity for Mobile Defect Fix 13092338";
			driver.findElement(By.xpath("//*[@id='Sage_Platform_Mobile_Fields_TextAreaField_3']/textarea")).click();
			driver.findElement(By.xpath("//*[@id='Sage_Platform_Mobile_Fields_TextAreaField_3']/textarea")).sendKeys(commentsTxt);
			driver.findElement(By.xpath("//*[@id='Sage_Platform_Mobile_Fields_TextAreaField_3']/textarea")).sendKeys(Keys.RETURN);
			Thread.sleep(1000);
			
			//keep remaining default field vals then save the activity
			headerButton.clickHeaderButton("save");
			commNav.waitForPage("Ticket Activities");
			
			//VP: check to see that the scheduled Ticket Activity is listed
			resultMsg = "VP: Scheduled Ticket Activity is listed under the Ticket Activities view";
			try {
				AssertJUnit.assertTrue(commNav.isTextPresentOnPage(commentsTxt));
				System.out.println(resultMsg + " - Passed");
				
				//re-open the Ticket Activity
				driver.findElement(By.xpath("//*[@id='ticketactivity_related']/descendant::*[text() = '" + ticketRecord + "']")).click();
				commNav.waitForNotPage("Ticket Activities");
				
				//VP: check to see that Public Access field value is correct
				String actualPublicAccessFldVal = driver.findElement(By.xpath("//*[@id='ticketactivity_detail']/div[2]/div[1]/div[6]/span")).getText();
				resultMsg = "VP: Ticket Activity, Public Access field value check";
				try {
					AssertJUnit.assertTrue(actualPublicAccessFldVal.matches(expectedPublicAccessFldVal));
					System.out.println(resultMsg + " - Passed");
				}
				catch (Error e) {
					System.out.println(methodID + "(): " + e.toString());
					System.out.println(resultMsg + " - FAILED");
				}
				
				headerButton.goBack();
				commNav.waitForNotPage("Ticket Activities");
			}
			catch (Error e) {
				System.out.println(methodID + "(): " + e.toString());
				System.out.println(resultMsg + " - FAILED");
			}
		}
		catch (Error e) {
			System.out.println(methodID + "(): " + e.toString());
			return;
		}		
		
		// End Tests
		commNav.clickGlobalMenuItem("My Activities");
		
		System.out.println(ENDLINE);
	}

	@Test(enabled = false)
	public void test59_MobileDefect13092339()  throws Exception {
		//tags: schedule, ticket activity, public access, type, null
		String methodID = "test59_MobileDefect13092339";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);					
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
		
		//Test Params
		String ticketRecord = "000-00-000022";
		
		
		//Step: click and open the the Ticket record
		commNav.entityRecordOpenDetailView("Tickets", ticketRecord);	
		try {
			AssertJUnit.assertTrue(commNav.isPageDisplayed(ticketRecord));
			
			TicketViewsElements ticketDetail = PageFactory.initElements(driver, TicketViewsElements.class);
			
			//Step: open the Ticket Activities view
			ticketDetail.ticketsDetailViewTicketsActivitiesLnk.click();
			commNav.waitForPage("Ticket Activities");
				
			//schedule a new Activity
			headerButton.clickHeaderButton("add");
			commNav.waitForPage("Edit Ticket Activity");			
			
			//set User field value
			driver.findElement(By.xpath("//*[@id='Sage_Platform_Mobile_Fields_LookupField_48']/button")).click();
			commNav.waitForPage("Users");
			driver.findElement(By.xpath("//*[@id='user_list']/descendant::*[text() = 'Barret, Dan']")).click();
			commNav.waitForPage("Edit Ticket Activity");
			
			//set Start Date (use default)
			driver.findElement(By.xpath("//*[@id='Sage_Platform_Mobile_Fields_DateField_6']/button")).click();
			commNav.waitForPage("Calendar");
			Thread.sleep(1000);
			headerButton.clickHeaderButton("check");
			commNav.waitForPage("Edit Ticket Activity");
			
			//set End Date (use default)
			driver.findElement(By.xpath("//*[@id='Sage_Platform_Mobile_Fields_DateField_7']/button")).click();
			commNav.waitForPage("Calendar");
			Thread.sleep(1000);
			headerButton.clickHeaderButton("check");
			commNav.waitForPage("Edit Ticket Activity");
			
			//set Comments text (for record identification)
			String commentsTxt = "Test Ticket Activity for Mobile Defect Fix 13092338";
			driver.findElement(By.xpath("//*[@id='Sage_Platform_Mobile_Fields_TextAreaField_3']/textarea")).click();
			driver.findElement(By.xpath("//*[@id='Sage_Platform_Mobile_Fields_TextAreaField_3']/textarea")).sendKeys(commentsTxt);
			driver.findElement(By.xpath("//*[@id='Sage_Platform_Mobile_Fields_TextAreaField_3']/textarea")).sendKeys(Keys.RETURN);
			Thread.sleep(1000);
			
			//keep remaining default field vals then save the activity
			headerButton.clickHeaderButton("save");
			commNav.waitForPage("Ticket Activities");
			
			//VP: check to see that the scheduled Ticket Activity is listed
			String resultMsg = "VP: Scheduled Ticket Activity is listed under the Ticket Activities view";
			try {
				AssertJUnit.assertTrue(commNav.isTextPresentOnPage(commentsTxt));
				System.out.println(resultMsg + " - Passed");
				
				//re-open the Ticket Activity
				driver.findElement(By.xpath("//*[@id='ticketactivity_related']/descendant::*[text() = '" + ticketRecord + "']")).click();
				commNav.waitForNotPage("Ticket Activities");
				
				//VP: check to see that Type field value is non-null
				String actualTypeFldVal = driver.findElement(By.xpath("//*[@id='ticketactivity_detail']/div[2]/div[1]/div[5]/span")).getText();
				resultMsg = "VP: Ticket Activity, Public Access field non-null value check";
				try {
					AssertJUnit.assertFalse(actualTypeFldVal.matches("null"));
					System.out.println(resultMsg + " - Passed");
				}
				catch (Error e) {
					System.out.println(methodID + "(): " + e.toString());
					System.out.println(resultMsg + " - FAILED");
				}
				
				//VP: check to see that Public Access field value is correct
				String actualPublicAccessFldVal = driver.findElement(By.xpath("//*[@id='ticketactivity_detail']/div[2]/div[1]/div[6]/span")).getText();
				resultMsg = "VP: Ticket Activity, Public Access field non-null value check";
				try {
					AssertJUnit.assertFalse(actualPublicAccessFldVal.matches("null"));
					System.out.println(resultMsg + " - Passed");
				}
				catch (Error e) {
					System.out.println(methodID + "(): " + e.toString());
					System.out.println(resultMsg + " - FAILED");
				}
				
				headerButton.goBack();
				commNav.waitForNotPage("Ticket Activities");
			}
			catch (Error e) {
				System.out.println(methodID + "(): " + e.toString());
				System.out.println(resultMsg + " - FAILED");
			}
		}
		catch (Error e) {
			System.out.println(methodID + "(): " + e.toString());
			return;
		}		
		
		// End Tests
		commNav.clickGlobalMenuItem("My Activities");
		
		System.out.println(ENDLINE);
	}

	//TODO: test60_MobileDefect13092370 needs a fix
	@Test(enabled = false)
	public void test60_MobileDefect13092370()  throws Exception {
		//tags: add account/contact, account manager, account owner
		String methodID = "test60_MobileDefect13092370";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);					
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
		
		//Test Params
		String firstNameTestVal = "Teddy";
		String lastNameTestVal = "Tester-" + new SimpleDateFormat("yyMMddHHmm").format(new GregorianCalendar().getTime());
		String accountNameTestVal = "TestAccount-" + new SimpleDateFormat("yyMMddHHmm").format(new GregorianCalendar().getTime());
		
		
		//Step: click and open the the Ticket record
		commNav.clickGlobalMenuItem("add account/contact");		
		try {
			AssertJUnit.assertTrue(commNav.waitForPage("Add Account / Contact"));
						
			//setup Name field
			driver.findElement(By.xpath("//*[@id='Mobile_SalesLogix_Fields_NameField_0']/input")).click();
			commNav.waitForPage("Edit Name");
			WebElement firstNameFld = driver.findElement(By.xpath("//*[@id='Sage_Platform_Mobile_Fields_TextField_66']/input"));
			commNav.setupInputFieldValue(firstNameFld, firstNameTestVal);
			WebElement lastNameFld = driver.findElement(By.xpath("//*[@id='Sage_Platform_Mobile_Fields_TextField_68']/input"));
			commNav.setupInputFieldValue(lastNameFld, lastNameTestVal);
			headerButton.clickHeaderButton("check");
			commNav.waitForPage("Add Account / Contact");
			
			//setup Account field
			WebElement accountFld = driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_Fields_TextField_62']/input"));
			commNav.setupInputFieldValue(accountFld, accountNameTestVal);
			
			//setup the Account Manager field
			driver.findElement(By.xpath("//*[@id='Sage_Platform_Mobile_Fields_LookupField_20']/input")).click();
			commNav.waitForPage("Users");
			//driver.findElement(By.xpath("//*[@id='user_list']/descendant::*[text() = 'Administrator, ']")).click();
			headerButton.clickHeaderButton("cancel");
			commNav.waitForPage("Add Account / Contact");
			
			//setup the Owner field
			driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_Fields_LookupField_21']/input")).click();
			commNav.waitForPage("Owners");
			headerButton.clickHeaderButton("cancel");
			commNav.waitForPage("Add Account / Contact");
			
			//save the new Account/Contact record
			headerButton.clickHeaderButton("save");
	
			//VP: check to see that new Account/Contact record is saved
			String resultMsg = "VP: Account/Contact record successfully added";
			try {
				AssertJUnit.assertTrue(commNav.waitForPage(accountNameTestVal));
				System.out.println(resultMsg + " - Passed");
			}
			catch (Error e) {
				System.out.println(methodID + "(): " + e.toString());
				System.out.println(resultMsg + " - FAILED");
			}
		}
		catch (Error e) {
			System.out.println(methodID + "(): " + e.toString());
			return;
		}		
		
		// End Tests
		commNav.clickGlobalMenuItem("My Activities");		
		System.out.println(ENDLINE);
	}

	@Test(enabled = false)
	public void test61_MobileDefect13092371()  throws Exception {
		//tags: add account/contact, account manager, account owner
		String methodID = "test61_MobileDefect13092371";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);					
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
		
		//Test Params
		String accountRecord = "Abbott Ltd.";
		
		
		//Step: click and open the the Account record
		commNav.entityRecordOpenDetailView("Accounts", accountRecord);	
		try {
			AssertJUnit.assertTrue(commNav.waitForPage("Abbott Ltd."));
			
			AccountViewsElements accountDetailView = PageFactory.initElements(driver, AccountViewsElements.class);
			
			//open the Opportunities list
			accountDetailView.accountDetailViewOpportunitiesLnk.click();
			commNav.waitForPage("Opportunities");
			
			//Step 2: click and open the top Opportunity record
			driver.findElement(By.xpath("//*[@id='opportunity_related']/ul/li[1]/div[3]/h3")).click();
			commNav.waitForNotPage("Opportunities");			
			
			//click top Edit button
			headerButton.clickHeaderButton("edit");
			commNav.waitForPage("Opportunity");
			
			OpportunityViewsElements opportunityDetailView = PageFactory.initElements(driver, OpportunityViewsElements.class);
			
			//click the Reseller field selection button
			opportunityDetailView.opportunityEditViewResellerFldBtn.click();
			commNav.waitForPage("Accounts");
			
			//VP: confirm that accessible Account records are listed
			String resultMsg = "VP: Accounts List view displays accessible Account records";
			try {
				AssertJUnit.assertTrue(commNav.isTextNotPresentOnPage("no records"));
				System.out.println(resultMsg + " - Passed");
			}
			catch (Error e) {
				System.out.println(methodID + "(): " + e.toString());
				System.out.println(resultMsg + " - Failed");
			}			
		}
		catch (Error e) {
			System.out.println(methodID + "(): " + e.toString());
			return;
		}		
		
		// End Tests
		headerButton.clickHeaderButton("cancel");
		headerButton.clickHeaderButton("cancel");
		headerButton.clickHeaderButton("back");
		commNav.clickGlobalMenuItem("My Activities");		
		System.out.println(ENDLINE);
	}

	@Test (enabled = false)
	public void test62_MobileDefect13092375()  throws Exception {
		//tags: edit account, note, server error
		String methodID = "test62_MobileDefect13092375";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);					
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
		
		//Test Params
		String accountRecord = "ABM Industries Incorporated";
		
		
		//Step: click and open the the Account record
		commNav.entityRecordOpenDetailView("Accounts", accountRecord);
		try {
			AssertJUnit.assertTrue(commNav.waitForPage(accountRecord));
			
			AccountViewsElements accountDetailView = PageFactory.initElements(driver, AccountViewsElements.class);
			
			//click the Add Note link
			accountDetailView.accountDetailViewAddNoteLnk.click();
			commNav.waitForPage("Note");
			
			//setup the Note fields then save
			WebElement noteRegardingFld = driver.findElement(By.xpath("//*[@id='Mobile_SalesLogix_Fields_PicklistField_35']/input"));
			commNav.setupInputFieldValue(noteRegardingFld, "Test Note");
			
			WebElement noteNotesFld = driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_Fields_TextAreaField_5']/textarea"));
			commNav.setupInputFieldValue(noteNotesFld, "Test Notes for Defect Fix 13092375");
			
			headerButton.clickHeaderButton("save");
			commNav.waitForNotPage("Note");
			
			//Step 2: edit and save the Account record
			//----------------------------------------
			headerButton.clickHeaderButton("edit");
			commNav.waitForNotPage("Account");
			
			//edit the Account Phone number (800) 944-5709
			WebElement accountPhoneFld = driver.findElement(By.xpath("//*[@id='Sage_Platform_Mobile_Fields_PhoneField_5']/input"));
			commNav.setupInputFieldValue(accountPhoneFld, "800-944-5709");
			
			//save the changes
			headerButton.clickHeaderButton("save");
			
			//VP: confirm that accessible Account records are listed
			String resultMsg = "VP: Account changes successfully saved after add note and field value edit";
			try {
				AssertJUnit.assertTrue(commNav.isElementPresent(By.xpath("//*[@id='account_detail']")));
				System.out.println(resultMsg + " - Passed");
			}
			catch (Error e) {
				System.out.println(methodID + "(): " + e.toString());
				System.out.println(resultMsg + " - Failed");
			}			
		}
		catch (Error e) {
			System.out.println(methodID + "(): " + e.toString());
			return;
		}		
		
		// End Tests
		headerButton.clickHeaderButton("back");
		commNav.clickGlobalMenuItem("My Activities");		
		System.out.println(ENDLINE);
	}

	@Test(enabled = true)
	public void test63_MobileDefect13092387()  throws Exception {
		//tags: notes/history, hashtag, #phonecall
		String methodID = "test63_MobileDefect13092387";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);					
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
		
		//navigate to the Notes/History List view then click the phonecall hashtag
		commNav.clickGlobalMenuItem("Notes/History");
		commNav.rightClickContextMenuItem("phonecall");
		
		//VP: check that Regarding field value of top record is not null
		WebElement topRegardingFld = driver.findElement(By.xpath("//*[@id='history_list']/ul/li[1]/div[3]/h4[2]"));		
		String resultMsg = "VP: Notes/History List record's Regarding value is non-null";
		try {
			AssertJUnit.assertFalse(topRegardingFld.getText().equals(null));
			System.out.println(resultMsg + " - Passed");
		}
		catch (Error e) {
			System.out.println(methodID + "(): " + e.toString());
			System.out.println(resultMsg + " - Failed");
		}
		
		//click the Notes/History record to open the Detail view
		topRegardingFld.click();
		commNav.waitForNotPage("Notes/History");
		
		//VP: check the Regarding field value in the Notes/History detail view
		WebElement regardingFld = driver.findElement(By.xpath("//*[@id='history_detail']/div[2]/div[1]/div[3]/span"));
		resultMsg = "VP: Notes/History record's Detail view Regarding field value is non-null";
		try {
			AssertJUnit.assertFalse(regardingFld.getText().equals(null));
			System.out.println(resultMsg + " - Passed");
		}
		catch (Error e) {
			System.out.println(methodID + "(): " + e.toString());
			System.out.println(resultMsg + " - Failed");
		}		
		
		// End Tests
		headerButton.clickHeaderButton("back");
		commNav.clickGlobalMenuItem("My Activities");		
		System.out.println(ENDLINE);
	}
	//TODO: test64_MobileDefect13092410 needs a bug fix
	@Test(enabled = true)
	public void test64_MobileDefect13092410()  throws Exception {
		//tags: accounts, list view, no records
		String methodID = "test64_MobileDefect13092410";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);					
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
		
		//Test Params
		String accountRecord = "Agilent Technologies, Inc.";
		
		
		//Step: click and open the the Account record
		commNav.entityRecordOpenDetailView("Accounts", accountRecord);
		
		AccountViewsElements accountDetailView = PageFactory.initElements(driver, AccountViewsElements.class);
		
		//click the Activities link
		accountDetailView.accountDetailViewActivitiesLnk.click();
		commNav.waitForNotPage("Activities");
		
		//VP: check that 'no records' is displayed if there are no Activities listed 	
		String resultMsg = "VP: 'no records' is displayed for empty Activities list view";
		try {
			AssertJUnit.assertTrue(commNav.isTextPresentOnPage("no records"));
			System.out.println(resultMsg + " - Passed");
		}
		catch (Error e) {
			System.out.println(methodID + "(): " + e.toString());
			System.out.println(resultMsg + " - Failed");
		}
			
		// End Tests
		headerButton.clickHeaderButton("back");
		commNav.clickGlobalMenuItem("My Activities");		
		System.out.println(ENDLINE);
	}

	@Test (enabled = true)
	public void test65_MobileDefect13092422()  throws Exception {
		//tags: My Activities, list view, Unknown
		String methodID = "test65_MobileDefect13092422";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);				
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
				
		//Step: click and open the the My Activities List view
		commNav.clickGlobalMenuItem("My Activities");
		
		//VP: check that 'no records' is displayed if there are no Activities listed 	
		String resultMsg = "VP: 'Unknown' is not displayed as a grouping within the My Activities list view";
		try {
			AssertJUnit.assertTrue(commNav.isTextNotPresentOnPage("Unknown"));
			System.out.println(resultMsg + " - Passed");
		}
		catch (Error e) {
			System.out.println(methodID + "(): " + e.toString());
			System.out.println(resultMsg + " - Failed");
		}
			
		// End Tests
		commNav.clickGlobalMenuItem("My Activities");		
		System.out.println(ENDLINE);
	}

	@Test(enabled = true)
	public void test66_MobileDefect13092494()  throws Exception {
		//tags: accounts, detail view, lookup, #active hashtag
		String methodID = "test66_MobileDefect13092494";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);					
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
				
		//Test Params
		String accountRecord = "A1 Enterprises";
		
		
		//Step: click and open the the Accounts List view
		commNav.clickGlobalMenuItem("Accounts");
		
		//Step: select the #active hashtag
		commNav.rightClickContextMenuItem("active");
		
		//Step: click and open the the Account record
		commNav.entityRecordOpenDetailView("Accounts", accountRecord);
		
		//Step: click top Back button to return to the Acounts List view
		headerButton.clickHeaderButton("back");
		commNav.waitForPage("Accounts");
		
		//VP: check that old Lookup control is not displayed in the Accounts List view... 	
		String resultMsg = "VP: previous-version Lookup control is not displayed in the Accounts List view";
		try {
			WebElement oldLookupFld = driver.findElement(By.xpath("//*[@id='Sage_Platform_Mobile_SearchWidget_3']"));
			AssertJUnit.assertFalse(oldLookupFld.isDisplayed());
			System.out.println(resultMsg + " - Passed");
		}
		catch (Error e) {
			System.out.println(methodID + "(): " + e.toString());
			System.out.println(resultMsg + " - Failed");
		}
			
		// End Tests
		commNav.clickGlobalMenuItem("My Activities");		
		System.out.println(ENDLINE);
	}

	@Test(enabled = true)
	public void test67_MobileDefect13092497()  throws Exception {
		//tags: accounts, my activities, right context menu, browser back button
		String methodID = "test67_MobileDefect13092497";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
		
		//Step: click and open the the Accounts List view
		commNav.clickGlobalMenuItem("Accounts");
		
		//Step: reveal the Right-Context menu
		headerButton.showRightContextMenu();
		
		//Step: click browser Back button
		driver.navigate().back();
		Thread.sleep(1000);
		
		//VP: check that Right-Context menu is still open 	
		String resultMsg = "VP: Right-Context menu is displayed while navigating back a page";
		try {
			AssertJUnit.assertTrue(commNav.rmenu_panel.isDisplayed());
			System.out.println(resultMsg + " - Passed");
		}
		catch (Error e) {
			System.out.println(methodID + "(): " + e.toString());
			System.out.println(resultMsg + " - Failed");
		}
			
		// End Tests
		commNav.clickGlobalMenuItem("My Activities");		
		System.out.println(ENDLINE);
	}

	@Test (enabled = false)
	public void test68_MobileDefect13092506()  throws Exception {
		//tags: accounts list view, kpi, Avg Time as Customer 
		String methodID = "test68_MobileDefect13092506";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);					
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
		
		//Step: click and open the the Accounts List view
		commNav.clickGlobalMenuItem("Accounts");
		
		//Step: select the 'Avg Time as Customer' KPI item
		commNav.rightClickContextMenuItem("Avg Time as Customer");
		headerButton.closeRightContextMenu();
		Thread.sleep(3000);
		
		AccountViewsElements accountsListView = PageFactory.initElements(driver, AccountViewsElements.class);
		
		//VP: check that 'Avg Time as Customer' KPI value is rounded up
		String resultMsg = "VP: Accounts 'Avg Time as Customer' KPI decimal value is rounded up";
		try {
			//TODO: need to figure out how to get a stable KPI control 
			AssertJUnit.assertTrue(accountsListView.accountsListViewKPIBox1.isDisplayed());
			String kpiVal = accountsListView.accountsListViewKPIBox1.getAttribute("metric-value");
			AssertJUnit.assertTrue(kpiVal.contains("K"));
			System.out.println(resultMsg + " - Passed");
		}
		catch (Error e) {
			System.out.println(methodID + "(): " + e.toString());
			System.out.println(resultMsg + " - Failed");
		}
			
		// End Tests
		commNav.clickGlobalMenuItem("My Activities");		
		System.out.println(ENDLINE);
	}

	//TODO: test70_MobileDefect13093076 cannot be run on Jenkins server
	@Test(enabled = true)
	public void test70_MobileDefect13093076()  throws Exception {
		//tags: accounts list view, kpi, Avg Time as Customer 
		String methodID = "test70_MobileDefect13093076";
		
		String userName = "Lou";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		SLXMobileLogin slxmobilelogin = PageFactory.initElements(driver, SLXMobileLogin.class);
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
		
		//Step: Log out of Mobile Client
		commNav.clickGlobalMenuItem("log out");
		Thread.sleep(2000);
		closeAlert();
		Thread.sleep(1000);
		
		//Step: Attempt invalid login 
		slxmobilelogin.enterUserName(userName);
		Thread.sleep(1000);
		slxmobilelogin.enterPassword("bogus");
		Thread.sleep(1000);
		slxmobilelogin.logonButton();
		Thread.sleep(5000);
		
		closeAlertAndGetItsText();
		
		//Step: Redo login using valid credentials
		slxmobilelogin.doLogin(userName, "", true);
		
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
			System.out.println(methodID + "(): " + e.toString());
		}		
		
		// End Tests
		System.out.println(ENDLINE);
	}

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
}
