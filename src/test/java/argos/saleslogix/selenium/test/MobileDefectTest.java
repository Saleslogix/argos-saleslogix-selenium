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
public class MobileDefectTest extends BrowserSetup {

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
		try { assertEquals("My Activities", driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText());
			assertTrue(driver.findElement(By.xpath(".//*[@id='myactivity_list']")).isDisplayed());
			System.out.println("VP: Successfully logged in to Mobile Client.");
		} catch (Error e) {
			closeAlert();
			System.out.println("Error: Unable to login to Mobile Client.");
			System.out.println(e.toString());
		}
		System.out.println(ENDLINE);	
	}

	@Test (enabled = true)
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

	//Test Methods		
	//============
	//TODO: document functional areas for each test method
	@Test (enabled = true)
	public void test41_MobileDefect13092144()  throws InterruptedException {				
		String methodID = "test41_MobileDefect13092144";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerbutton = PageFactory.initElements(driver, HeaderButton.class);
		
		// test params
		String attachmentName = "bluepencil";
				
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
			AssertJUnit.assertTrue(commNav.isTextPresentOnPage("loading..."));
			AssertJUnit.assertTrue(commNav.isTextPresentOnPage("Downloading attachment..."));
			AssertJUnit.assertTrue(commNav.isTextNotPresentOnPage("Downloading attachment..."));
			Thread.sleep(3000);
			try {
				AssertJUnit.assertTrue(isElementPresent(By.xpath("//*[@id='attachment-image']")));
				System.out.println("Verify: initial successful Attachment downloaded check - Passed");
			}
			catch (Error e) {
				System.out.println(e.toString());
				System.out.println("Verify: initial successful Attachment downloaded check - FAILED");
			}
		} catch (Exception e) {
			System.out.println("The '" + attachmentName + "' attachment was not available for the test.");
		};			
		
		// Step: click the Top-Left, Global Menu button...
		headerbutton.showGlobalMenu();
		Thread.sleep(5000);
		
		// Step: click the Top-Left, Global Menu button again to close...
		headerbutton.clickHeaderButton("global");
		Thread.sleep(5000);
		
		// VP: confirm that attachment is still displayed correctly after Global Menu display/non-display
		try {
			AssertJUnit.assertTrue(isElementPresent(By.xpath("//*[@id='attachment-image']")));
			System.out.println("Verify: fix check on Attachments view on Global Menu display/non-display - Passed");
		}
		catch (Error e) {
			System.out.println(e.toString());
			AssertJUnit.fail("Verify: fix check on Attachments view on Global Menu display/non-display - FAILED");
		}
		
		// Step: navigate back to the My Activities list view
		headerbutton.showGlobalMenu();
		commNav.clickGlobalMenuItem("My Activities");
		
		// End Tests
		System.out.println(ENDLINE);
	}

	
	@Test (enabled = true)
	public void test42_MobileDefect13092160()  throws InterruptedException {				
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
			driver.findElement(By.xpath("//*[@id='myattachment_list']/ul/li/div/div[2]/h3/span")).click();
		} catch (Exception e) {
			System.out.println("The '" + attachmentName + "' attachment was not available for the test.");
		};
		Thread.sleep(7000);
				
		// VP: confirm that URL attachment is loaded and displayed correctly
		AssertJUnit.assertTrue(isElementPresent(By.xpath("//*[@id='attachment-Iframe']")));
		
		// Step: click the Top-Left, Global Menu button...
		headerbutton.showGlobalMenu();
		Thread.sleep(3000);
		
		// Step: click the Top-Left, Global Menu button again to close...
		headerbutton.showGlobalMenu();
		
		// VP: confirm that attachment is downloaded and displayed correctly
		AssertJUnit.assertTrue(isElementPresent(By.xpath("//*[@id='attachment-Iframe']")));
		
		// Step: navigate back to the My Activities list view
		headerbutton.showGlobalMenu();
		commNav.clickGlobalMenuItem("My Activities");
		
		// End Tests
		System.out.println(ENDLINE);
	}

	
	@Test (enabled = true)
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
			verificationErrors.append(e.toString());
		}
	
		// VP: confirm that "F: null" is not present in the Accounts, List View		
		try {
			AssertJUnit.assertFalse(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*"+ strCheck2 +"[\\s\\S]*$"));
			System.out.println("Verify: '" + strCheck2 + "' fix check on Accounts, List View - Passed");
		} catch (Error e) {
			System.out.println("Verify: '" + strCheck2 + "' fix check on Accounts, List View - FAILED");
			verificationErrors.append(e.toString());
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
			verificationErrors.append(e.toString());
		}
	
		// VP: confirm that "F: null" is not present in the Accounts, List View		
		try {
			AssertJUnit.assertFalse(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*"+ strCheck2 +"[\\s\\S]*$"));
			System.out.println("Verify: '" + strCheck2 + "' fix check on Accounts, List View - Passed");
		} catch (Error e) {
			System.out.println("Verify: '" + strCheck2 + "' fix check on Accounts, List View - FAILED");
			verificationErrors.append(e.toString());
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
			verificationErrors.append(e.toString());
		}
	
		// VP: confirm that "F: null" is not present in the Accounts, List View		
		try {
			AssertJUnit.assertFalse(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*"+ strCheck2 +"[\\s\\S]*$"));
			System.out.println("Verify: '" + strCheck2 + "' fix check on Accounts, List View - Passed");
		} catch (Error e) {
			System.out.println("Verify: '" + strCheck2 + "' fix check on Accounts, List View - FAILED");
			verificationErrors.append(e.toString());
		}
		
		// End Section
		// Step: click the Top-Left, Global Menu button...
		headerbutton.showGlobalMenu();
		commNav.clickGlobalMenuItem("My Activities");
		
		System.out.println(ENDLINE);
	}

	@Test (enabled = true)
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
			verificationErrors.append(e.toString());
		}
		
		// End Tests
		// Step: click the Top-Left, Global Menu button...
		headerbutton.showGlobalMenu();
		commNav.clickGlobalMenuItem("My Activities");
		
		System.out.println(ENDLINE);
	}

	@Test (enabled = true)
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
			verificationErrors.append(e.toString());
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
				verificationErrors.append(e.toString());
				break;
			}
		}
		
		// Step: click the top-search results item to go to the Detail view
		driver.findElement(By.xpath("//*[@id='speedsearch_list']/ul/li[1]/h3")).click();
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
				verificationErrors.append(e.toString());
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

	
	@Test (enabled = true)
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

	@Test (enabled = true)
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
			verificationErrors.append(e.toString());
		}
		
		// End Tests
		// Step: click the Top-Left, Global Menu button...
		headerbutton.showGlobalMenu();
		commNav.clickGlobalMenuItem("My Activities");
		
		System.out.println(ENDLINE);
	}

	@Test (enabled = false)
	//TODO: need to update test48_MobileDefect13092154() for 2.3
	  public void test48_MobileDefect13092154() throws Exception {
		String methodID = "test48_MobileDefect13092154";
	
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
	
	    // Step: perform search for a Lead item...
	    driver.findElement(By.xpath("//*[@id='Sage_Platform_Mobile_SearchWidget_16']/div/div[1]/input")).clear();
	    Thread.sleep(500);
	    driver.findElement(By.xpath("//*[@id='Sage_Platform_Mobile_SearchWidget_16']/div/div[1]/input")).sendKeys("Aaron");
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("//*[@id='Sage_Platform_Mobile_SearchWidget_16']/div/div[3]/button")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) AssertJUnit.fail("timeout");
	    	try { if (isElementPresent(By.xpath("//*[@id='lead_list']/ul/li[1]"))) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	    try {
	      assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Aaron, John[\\s\\S]*$"));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    
	    // Step: navigate to top Lead record...
	    driver.findElement(By.xpath("//*[@id='lead_list']/ul/li/div/h3")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) AssertJUnit.fail("timeout");
	    	try { if ("Aaron, John".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // Step: click the Notes/History link...
	    driver.findElement(By.xpath("//*[@id='lead_detail']/descendant::*[text() = 'Notes/History']")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) AssertJUnit.fail("timeout");
	    	try { if ("Notes/History".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	    
	    // Step: click the top Notes/History record...
	    driver.findElement(By.xpath("//*[@id='history_related']/ul/li/div/h3")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) AssertJUnit.fail("timeout");
	    	try { if ("Note".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	    
	    // Step: click the Attachments link...
	    driver.findElement(By.xpath("//*[@id='history_detail']/descendant::*[text() = 'Attachments']")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) AssertJUnit.fail("timeout");
	    	try { if ("History Attachments".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // Step: click the top Add buton...
	    driver.findElement(By.xpath("//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[2]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) AssertJUnit.fail("timeout");
	    	try { if ("Add Attachments".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // VP: confirm the elements of the Add Attachments screen...
	    try {
	      assertTrue(isElementPresent(By.cssSelector("input[type=\"file\"]")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    try {
	      assertTrue(isElementPresent(By.cssSelector("button.button.inline")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    try {
	      assertTrue(isElementPresent(By.xpath("//div[@id='attachment_Add']/div[2]/div/button[2]")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
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
	    	try { if ("History Attachments".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	    try {
	      assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*" + newfilename + "[\\s\\S]*$"));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // -- End Section
	    
	    // - Start Section
	    // Step: navigate back to Lead detail view...
	    driver.findElement(By.xpath("//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) AssertJUnit.fail("timeout");
	    	try { if ("Note".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	    driver.findElement(By.xpath("//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) AssertJUnit.fail("timeout");
	    	try { if ("Notes/History".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	    driver.findElement(By.xpath("//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) AssertJUnit.fail("timeout");
	    	try { if ("Aaron, John".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // Step: navigate to the Lead Attachments list view...
	    driver.findElement(By.xpath("//*[@id='lead_detail']/descendant::*[text() = 'Attachments']")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) AssertJUnit.fail("timeout");
	    	try { if ("Lead Attachments".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // Step: perform search of Attachment added from associated Contact detail view...
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_SearchWidget_38']/div/div[1]/input")).clear();
	    Thread.sleep(1000);
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_SearchWidget_38']/div/div[1]/input")).sendKeys(newfilename);
	    Thread.sleep(1000);
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_SearchWidget_38']/div/div[1]/input")).click();
	    
	    // VP: verify that the Attachment item is found
	    try {
	      assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*" + newfilename + "[\\s\\S]*$"));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
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

	@Test (enabled = true)
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
		    	  verificationErrors.append(e.toString());
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
		    	  verificationErrors.append(e.toString());
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
			verificationErrors.append(e.toString());
		}
		
		// End Tests
		// Step: click the Top-Left, Global Menu button...
		headerbutton.showGlobalMenu();
		commNav.clickGlobalMenuItem("My Activities");
		
		System.out.println(ENDLINE);
	}

	@Test(enabled = false)
	//TODO: need to update test50_MobileDefect13092146() for 2.3
	public void test50_MobileDefect13092146()  throws InterruptedException {				
		String methodID = "test50_MobileDefect13092146";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerbutton = PageFactory.initElements(driver, HeaderButton.class);
		
		// test params
		String contactSrch = "Alexander";
		String contactName = "Alexander, Mark";
		String actType = "To-Do";
		String regardingVal = "Send quote";
		String repeatVal = "Daily";
		
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
		// Step: click the Top-Left, Global Menu button...
		headerbutton.showGlobalMenu();
	
		// Step: click the Contacts link
		commNav.clickGlobalMenuItem("Contacts");
	
		// Step: perform search for Contact record
		commNav.searchListView("contact", contactSrch);
		Thread.sleep(3000);
		try {
			AssertJUnit.assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*"+ contactName +"[\\s\\S]*$"));
			System.out.println("Step: '" + contactName + "' check on Contacts, List View - Passed");
			
			//Step: open the Contact record's Detail View...
			driver.findElement(By.xpath("//*[@id='contact_list']/descendant::*[text() = '" + contactName + "']")).click();
			commNav.waitForPage(contactName);		    
		    		    
		    //Step: click the Schedule Activity link...
			driver.findElement(By.xpath("//*[@id='contact_detail']/descendant::*[text() = 'Schedule activity']")).click();
			commNav.waitForPage("Schedule...");
			
			//TODO: create a separate class for scheduling activities...
			//SubStep: set the To-Do Activity Type...(do not select, just enter the value in the input field)
			driver.findElement(By.xpath("//*[@id='activity_types_list']/descendant::*[text() = '" + actType + "']")).click();
			commNav.waitForPage(actType);
		    
			//SubStep: setup and confirm the Regarding field val...
			//NOTE: here we just set the value of the input text field; selecting a Regarding value is not supported by Se WebDriver
			driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Fields_PicklistField_28']/input")).clear();
			driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Fields_PicklistField_28']/input")).sendKeys(regardingVal);		    
		    //VP: check the modified Regarding field val...
		    try {
		    	  AssertJUnit.assertEquals(actType, driver.findElement(By.xpath("//*[@id='Mobile_SalesLogix_Fields_PicklistField_28']/input")).getAttribute("value"));
		    	  System.out.println("VP: Regarding field value set to '" + regardingVal + "' - Passed");
		    	} catch (Error e) {
		    	  System.out.println("VP: Regarding field value set to '" + regardingVal + "' - FAILED");
		    	  verificationErrors.append(e.toString());
		    }
		    
		    //SubStep: setup and confirm the Start Time field val...
		    String oldStartTime = driver.findElement(By.xpath("//*[@id='Sage_Platform_Mobile_Fields_DateField_8']/input")).getAttribute("value");
			driver.findElement(By.xpath("//*[@id='Sage_Platform_Mobile_Fields_DateField_8']/button")).click();
			commNav.waitForPage("Calendar");
			//TODO: create a separate class for the Calendar Date view
			//set Start Time = +1 Month
			driver.findElement(By.xpath("//*[@id='datetime-picker-date']/tbody/tr[1]/td[1]/button")).click();
			headerbutton.clickHeaderButton("check");
			commNav.waitForPage(actType);
		    //VP: check the modified Start Time field val...
			String newStartTime = driver.findElement(By.xpath("//*[@id='Sage_Platform_Mobile_Fields_DateField_8']/input")).getAttribute("value");
		    try {
		    	  AssertJUnit.assertNotSame(oldStartTime, newStartTime);
		    	  System.out.println("VP: Start Time field value set to '" + newStartTime + "' - Passed");
		    	} catch (Error e) {
		    	  System.out.println("VP: Regarding field value set to '" + newStartTime + "' - FAILED");
		    	  verificationErrors.append(e.toString());
		    }
		    
		    //SubStep: setup and confirm the Repeats field val...
			driver.findElement(By.xpath("//*[@id='Sage_Platform_Mobile_Fields_SelectField_1']/button")).click();
			commNav.waitForPage("Recurring");		    
			driver.findElement(By.xpath("//*[@id='select_list']/descendant::*[text() = '" + repeatVal + "']")).click();
			commNav.waitForPage(actType);
		    try {
		    	  AssertJUnit.assertEquals(repeatVal, driver.findElement(By.xpath("//*[@id='Sage_Platform_Mobile_Fields_SelectField_1']/input")).getAttribute("value"));
		    	  System.out.println("VP: Repeats field value set to '" + repeatVal + "' - Passed");
		    	} catch (Error e) {
		    	  System.out.println("VP: Repeats field value set to '" + repeatVal + "' - FAILED");
		    	  verificationErrors.append(e.toString());
		    }
		    
		    //SubStep: setup and confirm the Recurring Until field val...
			driver.findElement(By.xpath("//*[@id='Mobile_SalesLogix_Fields_RecurrencesField_0']/button")).click();
			commNav.waitForPage("Recurrence");
			//Note: here we just open the Recurrence page, then click the Header, Check button (no changes)
			headerbutton.clickHeaderButton("check");
			
		    //Step: click the Header, Save button to return to Contact detail view...
		    headerbutton.clickHeaderButton("save");
		    commNav.waitForPage(contactName);
		    
		    //Step: click the Attachments link from the Contact detail view...
			driver.findElement(By.xpath("//*[@id='contact_detail']/div[2]/ul[2]/li[6]/a/span")).click();
			commNav.waitForPage("Recurrence");
			
			// Step: click the top Add buton...
		    driver.findElement(By.xpath("//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[2]")).click();
		    for (int second = 0;; second++) {
		    	if (second >= 60) AssertJUnit.fail("timeout");
		    	try { if ("Add Attachments".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
		    	Thread.sleep(1000);
		    }
		
		    // VP: confirm the elements of the Add Attachments screen...
		    try {
		      assertTrue(isElementPresent(By.cssSelector("input[type=\"file\"]")));
		    } catch (Error e) {
		      verificationErrors.append(e.toString());
		    }
		    try {
		      assertTrue(isElementPresent(By.cssSelector("button.button.inline")));
		    } catch (Error e) {
		      verificationErrors.append(e.toString());
		    }
		    try {
		      assertTrue(isElementPresent(By.xpath("//div[@id='attachment_Add']/div[2]/div/button[2]")));
		    } catch (Error e) {
		      verificationErrors.append(e.toString());
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
		    
		    // Step: verify that new attachment appears in the Contact Attachments list view...
		    for (int second = 0;; second++) {
		    	if (second >= 60) AssertJUnit.fail("timeout");
		    	try { if ("Contact Attachments".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
		    	Thread.sleep(1000);
		    }
		    try {
		      assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*" + newfilename + "[\\s\\S]*$"));
		      System.out.println("VP: the '" + newfilename + "' attachmment upload check - Passed");
		    } catch (Error e) {
		      System.out.println("VP: the '" + newfilename + "' attachmment upload check - FAILED");
		      verificationErrors.append(e.toString());
		    }
		    
		} catch (Error e) {
			System.out.println("Step: '" + contactName + "' check on Contacts, List View - FAILED");
			verificationErrors.append(e.toString());
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

	@Test (enabled = false)
	//TODO: need to update test52_MobileDefect13092102() for 2.3
	  public void test52_MobileDefect13092102() throws Exception {
		String methodID = "test52_MobileDefect13092102";
	
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
	    driver.findElement(By.xpath("//*[@id='Sage_Platform_Mobile_SearchWidget_16']/div/div[1]/input")).sendKeys("Aaron");
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("//*[@id='Sage_Platform_Mobile_SearchWidget_16']/div/div[3]/button")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) AssertJUnit.fail("timeout");
	    	try { if (isElementPresent(By.xpath("//*[@id='lead_list']/ul/li[1]"))) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	    try {
	      assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Aaron, John[\\s\\S]*$"));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    
	    // Step: navigate to top Lead record...
	    driver.findElement(By.xpath("//*[@id='lead_list']/ul/li/div/h3")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) AssertJUnit.fail("timeout");
	    	try { if ("Aaron, John".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // Step: click the Attachments link...
	    driver.findElement(By.xpath("//*[@id='lead_detail']/descendant::*[text() = 'Attachments']")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) AssertJUnit.fail("timeout");
	    	try { if ("Lead Attachments".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
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
	    	try { if ("Lead Attachments".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	    try {
	      assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*" + newfilename + "[\\s\\S]*$"));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // -- End Section
	    
	    // - Start Section
	    // Step: add the same attachment a 2nd-time...
	    // Step: click the top Add buton...
	    driver.findElement(By.xpath("//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[2]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) AssertJUnit.fail("timeout");
	    	try { if ("Add Attachments".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	    
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
	      assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*" + newfilename + "[\\s\\S]*$"));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // -- End Section
	    
	    // -- Start Section
	    // Step: add the same attachment to a 2nd-Lead record...
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
	
	    // Step: perform search for the 2nd-Lead record...
	    driver.findElement(By.xpath("//*[@id='Sage_Platform_Mobile_SearchWidget_16']/div/div[1]/input")).clear();
	    Thread.sleep(500);
	    driver.findElement(By.xpath("//*[@id='Sage_Platform_Mobile_SearchWidget_16']/div/div[1]/input")).sendKeys("Achew");
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("//*[@id='Sage_Platform_Mobile_SearchWidget_16']/div/div[3]/button")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) AssertJUnit.fail("timeout");
	    	try { if (isElementPresent(By.xpath("//*[@id='lead_list']/ul/li[1]"))) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	    try {
	      assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Achew, Pete[\\s\\S]*$"));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    
	    // Step: navigate to top Lead record...
	    driver.findElement(By.xpath("//*[@id='lead_list']/ul/li/div/h3")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) AssertJUnit.fail("timeout");
	    	try { if ("Achew, Pete".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // Step: click the Attachments link...
	    driver.findElement(By.xpath("//*[@id='lead_detail']/descendant::*[text() = 'Attachments']")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) AssertJUnit.fail("timeout");
	    	try { if ("Lead Attachments".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	    	
	    // Step: click the top Add buton...
	    driver.findElement(By.xpath("//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[2]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) AssertJUnit.fail("timeout");
	    	try { if ("Add Attachments".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	    
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
	      assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*" + newfilename + "[\\s\\S]*$"));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // -- End Section    
	    
	    // -- Start Section
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
	//TODO: need to update test53_MobileDefect13092153() for 2.3
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
	      verificationErrors.append(e.toString());
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
	      verificationErrors.append(e.toString());
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
	      verificationErrors.append(e.toString());
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

	@Test (enabled = true)
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
					System.out.println(e.toString());
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
				System.out.println(e.toString());
				System.out.println(resultsMsg + "FAILED");
			}			
		}
		catch (Error e) {
			System.out.println(e.toString());
			return;
		}
		
		// End Tests
		// Step: click the Top-Left, Global Menu button...
		headerButton.showGlobalMenu();
		commNav.clickGlobalMenuItem("My Activities");
		
		System.out.println(ENDLINE);
	}

	@Test (enabled = true)
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
				System.out.println(e.toString());
				System.out.println(resultMsg + " - FAILED");
			}
		}
		catch (Error e) {
			System.out.println(e.toString());
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
				System.out.println(e.toString());
				System.out.println(resultMsg + " - FAILED");
			}
		}
		catch (Error e) {
			System.out.println(e.toString());
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
				System.out.println(e.toString());
				System.out.println(resultMsg + " - FAILED");
			}
		}
		catch (Error e) {
			System.out.println(e.toString());
			return;
		}
		
		
		// End Tests
		commNav.clickGlobalMenuItem("My Activities");
		
		System.out.println(ENDLINE);
	}

	@Test (enabled = true)
	public void test56_MobileDefect13092300()  throws InterruptedException {				
		String methodID = "test42_MobileDefect13092300";
		
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
		AssertJUnit.assertTrue(isElementPresent(By.xpath("//*[@id='attachment-Iframe']")));
				
		// Step: navigate back to the My Activities list view
		headerbutton.showGlobalMenu();
		commNav.clickGlobalMenuItem("My Activities");
		commNav.waitForPage("Activities");
		
		// End Tests
		System.out.println(ENDLINE);
	}

	@Test (enabled = true)
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
			headerButton.goBack();
			
			//setup Category field
			driver.findElement(By.xpath("//*[@id='Mobile_SalesLogix_Fields_PicklistField_30']/input")).click();
			driver.findElement(By.xpath("//*[@id='Mobile_SalesLogix_Fields_PicklistField_30']/input")).sendKeys("Training");
			driver.findElement(By.xpath("//*[@id='Mobile_SalesLogix_Fields_PicklistField_30']/input")).sendKeys(Keys.RETURN);
			Thread.sleep(1000);
			
			//click Category field selection button
			driver.findElement(By.xpath("//*[@id='Mobile_SalesLogix_Fields_PicklistField_30']/button")).click();
			commNav.waitForPage("Activity Category");
			String activityCatListInitTxt = driver.findElement(By.xpath("//*[@id='pick_list_0']/ul")).getText();
			headerButton.goBack();
			
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
				System.out.println(e.toString());
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
				System.out.println(e.toString());
				System.out.println(resultsMsg + "- FAILED");
			}
			headerButton.goBack();
			
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
				System.out.println(e.toString());
				System.out.println(resultsMsg + "- FAILED");
			}
			headerButton.goBack();
		}
		catch (Error e) {
			System.out.println(e.toString());
			return;
		}		
		
		// End Tests
		headerButton.clickHeaderButton("cancel");
		commNav.clickGlobalMenuItem("My Activities");
		
		System.out.println(ENDLINE);
	}
}
