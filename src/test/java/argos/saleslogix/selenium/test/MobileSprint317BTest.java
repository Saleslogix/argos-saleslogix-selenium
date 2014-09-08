package argos.saleslogix.selenium.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;


/**
 * Test class that defines test methods for the SLX Mobile Defect (v3.1 sprint 7) fixes
 * 
 * @author kathleen.lockyer-bratton@swiftpage.com
 * @version	1.0
 */
public class MobileSprint317BTest extends BaseTest {

    public String TEST_LEAD_RECORD = "Beck, John";
    public String TEST_OPPORTUNITY_RECORD = "Vegas Vision-Phase1";

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
    // MBL-10552 ... New activity defaults to 'repeats' of 'Daily' ... expecting blank or 'Never' ; 'Never' used

    public void test01_MBL10552() throws Exception {
        String methodID = "test01_MBL10552";

        CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
        HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);
        MyActivityViewsElements activityEditView = PageFactory.initElements(driver, MyActivityViewsElements.class);


        System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);

        try {


            //Step: logout & log back in (to clear cookies)
            LogOutThenLogBackIn(userName, userPwd);


            //Step: go to "My Activities" view, if not already there ... wait for page My Activities
            if (!commNav.isPageDisplayed("My Activities"))   {
                commNav.clickGlobalMenuItem("My Activities");
                commNav.waitForPage("My Activities");
            }


            //Step: click the Add header button to open Activity schedule view
            headerButton.clickHeaderButton("Add");

            //Step: wait for page Schedule... to open
            commNav.waitForPage("Schedule...");

            //Step: select Meeting for activity type
            activityEditView.activityScheduleMeetingBtn.click();

            //Step: wait for page Meeting to open
            commNav.waitForPage("Meeting");

            //Step: verify that the 'repeats' field defaults to 'Never'
            String repeatsFieldValue = activityEditView.activityEditViewRepeatsFld.getAttribute("value");
            AssertJUnit.assertEquals("VP: activity 'repeats' field does not default to 'Never' - FAILED", "Never", repeatsFieldValue);
            System.out.println("VP: activity 'repeats' field does default to 'Never' - PASSED");


        }

        catch (Exception e) {
            verificationErrors.append(methodID + "(): " + e.toString());
            System.out.println("VP: activity 'repeats' field does not default to 'Never' " + " - FAILED");
            AssertJUnit.fail("test failed");
        }

        System.out.println(ENDLINE);
    }


    @Test(enabled = true)
    // MBL-10501 ... Lead web address may be entered with prefix of 'http://', but on trying to then access web site, it fails ... should open site as expected

    public void test02_MBL10501() throws Exception {
        String methodID = "test02_MBL10501";

        // Test Params:
        String entityType = "Lead";
        String entityRecord = TEST_LEAD_RECORD;
        String viewName = "Lead Edit view";

        CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
        HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);

        System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);

        //Step: logout & log back in (to clear cookies)
        LogOutThenLogBackIn(userName, userPwd);

        try {
            //Step: search for Lead entity, then open it's Edit view
            AssertJUnit.assertTrue(commNav.entityRecordEditView(entityType, entityRecord));

            LeadViewsElements leadEditView = PageFactory.initElements(driver, LeadViewsElements.class);
            commNav.isFieldValueEmpty(viewName + ", web field", leadEditView.leadsEditViewWebInputFld);

            //Step: clear, then enter "http://www.microsoft.com" for web address
            leadEditView.leadsEditViewWebInputFld.clear();
            leadEditView.leadsEditViewWebInputFld.sendKeys("http://www.microsoft.com");

            //Step: save lead, and wait for lead detail to load
            headerButton.clickHeaderButton("save");
            commNav.waitForPage("Beck, John");
            leadEditView = PageFactory.initElements(driver, LeadViewsElements.class);

            //Store the current window handle for the mobile window
            String winHandleBefore = driver.getWindowHandle();

            //Step: click on the lead detail view web link ... should open expected web page
            leadEditView.leadsDetailViewWebFldLnk.click();
            Thread.sleep(7000);

            //Switch to new window opened for the lead web site
            for(String winHandle : driver.getWindowHandles()){
                driver.switchTo().window(winHandle);
            }

            AssertJUnit.assertTrue("VP: lead web address with prefix of 'http://' not opening web page - FAILED", driver.getPageSource().contains("Microsoft"));
            System.out.println("VP: lead web address with prefix of 'http://' is opening web page - PASSED");

            //Close the new window (lead web site)
            driver.close();

            //Switch back to original browser (first window - mobile)
            driver.switchTo().window(winHandleBefore);

        } catch (Exception e) {
            verificationErrors.append(methodID + "(): " + e.toString());
            System.out.println("VP: lead web address with prefix of 'http://' not opening web page - FAILED");
            AssertJUnit.fail("test failed");
        }

        System.out.println(ENDLINE);
    }


    @Test(enabled = true)
    // MBL-10509 ... Create a logoff view

    public void test03_MBL10509() throws Exception {
        String methodID = "test03_MBL10509";

        CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
        SLXMobileLogin slxmobilelogin = PageFactory.initElements(driver, SLXMobileLogin.class);

        System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);

        //Step: Log out of Mobile Client
        commNav.clickGlobalMenuItem("log out");
        Thread.sleep(2000);
        closeAlert();
        Thread.sleep(1000);

        //Step: verify that one sees the logoff view
        AssertJUnit.assertTrue("VP: Logoff View title not 'Logged Out' - FAILED", driver.getPageSource().contains("Logged Out"));
        AssertJUnit.assertTrue("VP: Logoff View message not as expected - FAILED", driver.getPageSource().contains("You have been logged out. Please close your browser window."));
        System.out.println("Logoff View title and message is as expected - PASSED");

        driver.navigate().refresh();
        Thread.sleep(2000);
        System.out.println("Logging back in to Mobile client");

        //Step: Clear cookies
        driver.manage().deleteAllCookies();

        //Step: Redo login using valid credentials
        slxmobilelogin.doLogin(userName, userPwd, true);

        System.out.println(ENDLINE);

    }


    @Test(enabled = true)
    // MBL-10504 ... End user should not be able to edit the notes of any other user [submittal 14096396]

    public void test04_MBL10504() throws Exception {
        String methodID = "test04_MBL10504";

        CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
        HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);
        NotesHistoryViewsElements notesHistoryAddView = PageFactory.initElements(driver, NotesHistoryViewsElements.class);
        SLXMobileLogin slxmobilelogin = PageFactory.initElements(driver, SLXMobileLogin.class);

        System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);

        //Step: Log out of Mobile Client
        commNav.clickGlobalMenuItem("log out");
        Thread.sleep(2000);
        closeAlert();
        Thread.sleep(1000);

        //Step: refresh mobile client URL
        driver.navigate().refresh();
        Thread.sleep(2000);
        System.out.println("Logging back in to Mobile client as user lee");

        //Step: Clear cookies
        driver.manage().deleteAllCookies();

        //Step: Redo login using valid credentials ... login as user lee
        userName = "lee";
        slxmobilelogin.doLogin(userName, userPwd, true);

        //Step: navigate to Notes/History list view as user lee
        commNav.clickGlobalMenuItem("Notes/History");

        //Step: click the Add header button to enter Notes/History edit view
        headerButton.clickHeaderButton("Add");

        //setup Regarding fields
        String strRegardingVal = "Note added by lee";
        notesHistoryAddView.notesHistoryEditViewRegardingInputFld.sendKeys(strRegardingVal);

        //set Account field
        notesHistoryAddView.notesHistoryEditViewAccountFldBtn.click();
        commNav.highlightNClick(commNav.entityListViewSelect("Accounts", "Abbott Ltd."));

        //Step: save the new Note added by user lee
        headerButton.clickHeaderButton("save");
        commNav.waitForPage("Notes/History");
        System.out.println("VP: a new note with regarding value of 'Note added by Lee' has been added by user lee - NOTE ADDED BY LEE");
        System.out.println("VP: now login as user loup and verify that loup may not edit the note ...");

        //Step: reset userName to "loup" for subsequent login
        userName = "loup";

        //Step: logout & log back in (to clear cookies)
        LogOutThenLogBackIn(userName, userPwd);

        commNav = PageFactory.initElements(driver, CommonNavigation.class);
        headerButton = PageFactory.initElements(driver, HeaderButton.class);
        notesHistoryAddView = PageFactory.initElements(driver, NotesHistoryViewsElements.class);

        //Step: navigate to Notes/History list view as loup
        //commNav.clickGlobalMenuItem("Notes/History");

        //Step: search for note added by user lee ... 'Note added by lee'
        String strResultsMsg = "VP: Note added by user lee ... '" + strRegardingVal + "' ... found by user loup";
        WebElement entityListItem = commNav.entityListViewSearch("Notes/History", strRegardingVal);
        if (entityListItem.isDisplayed())  {
            System.out.println(strResultsMsg + " - PASSED");
            entityListItem.click();
            commNav.waitForPage("Note");
            headerButton.clickHeaderButton("Edit");
            notesHistoryAddView.notesHistoryEditViewContactFldBtn.click();
            commNav.waitForPage("Note");
            AssertJUnit.assertEquals("VP: it appears that user loup can edit user lee's note - FAILED","Note", driver.findElement(By.id("pageTitle")).getText());
            System.out.println("VP: it appears that user loup cannot edit user lee's note - PASSED");
        }
        else {
            System.out.println(strResultsMsg + " - FAILED");
            AssertJUnit.fail("test failed");
        }

        System.out.println(ENDLINE);

    }

    @Test(enabled = true)
    // MBL-10505 ... When product name contains quote (10"KSE-100-6T) on Opportunity Product screen, receive error trying to open the 'price level' lookup
    //               Pre-requisite ... product 10"KSE-100-6T has been added in admin's web client as follows ... Administration - New Product
    //               - Add product 10"KSE-100-6T, and assign it some price levels (MSRP and Wholesale)

    public void test05_MBL10505() throws Exception {
        String methodID = "test05_MBL10505";

        System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);

        // Test Params:
        String entityType = "Opportunity";
        String entityRecord = TEST_OPPORTUNITY_RECORD;
        String viewName = "Opportunity Detail view";

        CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
        HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);

        //Step: login & log back in (to clear cookies)
        LogOutThenLogBackIn(userName, userPwd);

        try {
            //Step: search for Opportunity entity, then open it's Detail view
            commNav.entityRecordOpenDetailView(entityType, entityRecord);

            OpportunityViewsElements opportunityDetailView = PageFactory.initElements(driver, OpportunityViewsElements.class);

            //Step: open the Products list for the opportunity, and choose to add a product
            opportunityDetailView.opportunityDetailViewProductsLnk.click();
            commNav.waitForPage("Products");
            headerButton.clickHeaderButton("Add");
            commNav.waitForPage("Opportunity Product");
            opportunityDetailView.opportunityProductViewProductBtn.click();
            commNav.waitForPage("Products");

            //Step: search and select product that has double quotes in the product name
            String productValtoSelect = "10\"KSE-100-6T";
            opportunityDetailView.opportunityProductsSearchValue.sendKeys(productValtoSelect);
            opportunityDetailView.opportunityProductsSearchBtn.click();
            opportunityDetailView.opportunityProductsTopProduct.click();
            commNav.waitForPage("Opportunity Product");

            //Step: verify that 'price level' lookup button opens the expected view, with no error
            opportunityDetailView.opportunityProductViewPriceLevelBtn.click();
            commNav.waitForPage("Product Programs");
            AssertJUnit.assertEquals("VP: where product name contains double quotes, 'price level' lookup opens - FAILED","Product Programs", driver.findElement(By.id("pageTitle")).getText());
            System.out.println("VP: where product name contains double quotes, 'price level' lookup opens - PASSED");

        }
        catch (Exception e) {
            verificationErrors.append(methodID + "(): " + e.toString());
            System.out.println("VP: where product name contains double quotes, 'price level' lookup opens - FAILED");
            AssertJUnit.fail("test failed");
        }

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
