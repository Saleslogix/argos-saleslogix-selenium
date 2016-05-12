package argos.saleslogix.selenium.test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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
    public String TEST_ACCOUNT2_RECORD = "Bank of the Sun";

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
    // Add My Activities as a menu item
    public void test01_AddMyActivities() throws Exception {
        String methodID = "test01_AddMyActivities";

        CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
        HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);
        MiscEntityItemViewsElements miscView = PageFactory.initElements(driver, MiscEntityItemViewsElements.class);


        System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);

        try {


            //Step: logout & log back in (to clear cookies)
            LogOutThenLogBackIn(userName, userPwd);

            //Step: enable 'My Activities' under Configure view ... needed with 'My Activities' no longer displaying by default in 3.4
            commNav.clickGlobalMenuItem("Configure Menu");
            commNav.waitForPage("Configure");
            miscView.configureMyActivities.click();
            headerButton.clickHeaderButton("Save");
            commNav.waitForPage("My Schedule");

            System.out.println("VP: added My Activities back as a menu item - PASSED");

        }

        catch (Exception e) {
            verificationErrors.append(methodID + "(): " + e.toString());
            System.out.println("VP: added My Activities back as a menu item - FAILED");
            AssertJUnit.fail("test failed");
        }

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
            Thread.sleep(1000);

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

            // Step: expand the More Details section if collapsed ... it will be in Mobile 3.2
            //if (leadEditView.leadsDetailViewMoreDetailsFields.getSize().height < 1) {
            //    leadEditView.leadsDetailViewMoreDetailsHdr.click();
            //    Thread.sleep(1000);
            //}

            //Store the current window handle for the mobile window
            String winHandleBefore = driver.getWindowHandle();

            //Step: click on the lead detail view web link ... should open expected web page
            commNav.highlightNClick(leadEditView.leadsDetailViewMoreDetailsTab);
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
        CommonViewsElements commView = PageFactory.initElements(driver, CommonViewsElements.class);

        //Step: login & log back in (to clear cookies)
        LogOutThenLogBackIn(userName, userPwd);

        try {
            //Step: search for Opportunity entity, then open it's Detail view
            commNav.entityRecordOpenDetailView(entityType, entityRecord);

            OpportunityViewsElements opportunityDetailView = PageFactory.initElements(driver, OpportunityViewsElements.class);

            //Step: open the Products list for the opportunity, and choose to add a product
            commNav.highlightNClick(opportunityDetailView.opportunityDetailViewRelatedItemsTab);
            opportunityDetailView.opportunityDetailViewProductsLnk.click();
            commNav.waitForPage("Products");
            headerButton.clickHeaderButton("Add");
            commNav.waitForPage("Opportunity Product");
            opportunityDetailView.opportunityProductViewProductBtn.click();
            commNav.waitForPage("Products");

            //Step: search and select product that has double quotes in the product name
            String productValtoSelect = "10\"KSE-100-6T";
            //opportunityDetailView.opportunityProductsSearchValue.sendKeys(productValtoSelect);
            commView.lookupTxtBox.sendKeys(productValtoSelect);
            //opportunityDetailView.opportunityProductsSearchBtn.click();
            commView.lookupTxtBox.sendKeys(Keys.RETURN);

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
    // MBL-10543 ... Recurring Activities - on editing all occurrences, changing repeats from Daily to 'Never' has no effect
    public void test06_MBL10543() throws Exception {
        String methodID = "test06_MBL10543";

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
            Thread.sleep(1000);

            //Step: add an Activity record with a random value for 'regarding'
            String newActivityRegarding = "SeAutoTestActivity-" + new SimpleDateFormat("yyMMddHHmmss").format(new GregorianCalendar().getTime());
            System.out.println("Activity regarding field will be - " + newActivityRegarding);

            activityEditView.activityEditViewRegardingFld.sendKeys(newActivityRegarding);

            //Step: set meeting to be recurring Daily, then retrieve the default value for 'recurring'
            activityEditView.activityEditViewRepeatsFldBtn.click();
            commNav.waitForPage("Recurring");
            activityEditView.activityRecurringDailyFld.click();
            commNav.waitForPage("Meeting");
            Thread.sleep(1000);


            String recurringValue = activityEditView.activityEditViewRecurringFld.getText();
            System.out.println("VP: for recurring activity, value of 'recurring' is ... " + recurringValue);

            //Step: save activity
            headerButton.clickHeaderButton("Save");

            //Step: wait for page My Activities
            commNav.waitForPage("My Activities");

            //Step: search for activity created ... and re-open
            activityEditView = PageFactory.initElements(driver, MyActivityViewsElements.class);
            activityEditView.performMyActivitiesSearch(newActivityRegarding);
            WebElement activityItemLnk = driver.findElement(By.xpath("//*[@id='myactivity_list']//ul/li[1]/descendant::*[text() = '" + newActivityRegarding + "']"));
            commNav.highlightNClick(activityItemLnk);
            commNav.waitForPage("Activity");
            Thread.sleep(1000);


            //Step: open the activity created in edit mode ... close alert, should default to 'OK' being chosen
            headerButton.clickHeaderButton("Edit");
            Thread.sleep(2000);
            closeAlert();
            Thread.sleep(1000);


            //Step: wait for page Activity
            commNav.waitForPage("Meeting");
            Thread.sleep(1000);

            //Step: change 'repeats' to 'Never', then check value of recurring ... should be blank
            activityEditView.activityEditViewRepeatsFldBtn.click();
            commNav.waitForPage("Recurring");
            activityEditView.activityRecurringNeverFld.click();
            commNav.waitForPage("Meeting");
            Thread.sleep(1000);
            recurringValue = activityEditView.activityEditViewRecurringFld.getText();
            AssertJUnit.assertEquals("VP: after setting 'repeats' to Never, 'recurring' field on activity edit view is not blank - FAILED", "", recurringValue);
            System.out.println("VP: after setting 'repeats' to Never, 'recurring' field on activity edit view is now blank - PASSED");

            //Step: resave activity, then open in edit mode again, and re-check value of recurring ... should still be blank
            activityEditView = PageFactory.initElements(driver, MyActivityViewsElements.class);
            headerButton.clickHeaderButton("Save");
            commNav.waitForNotPage("Meeting");
            headerButton.clickHeaderButton("Edit");
            commNav.waitForPage("Meeting");
            Thread.sleep(1000);
            recurringValue = activityEditView.activityEditViewRecurringFld.getText();
            AssertJUnit.assertEquals("VP: after setting 'repeats' to Never, and re-opening in edit mode, 'recurring' field on activity edit view is not blank - FAILED", "", recurringValue);
            System.out.println("VP: after setting 'repeats' to Never, and re-opening in edit mode, 'recurring' field on activity edit view is still blank - PASSED");


        }

        catch (Exception e) {
            verificationErrors.append(methodID + "(): " + e.toString());
            System.out.println("VP: after setting activity 'repeats' to Never, recurring field is not blank - FAILED");
            AssertJUnit.fail("test failed");
        }

        System.out.println(ENDLINE);
    }


    @Test(enabled = true)
    // MBL-10557 ... Non-Group listview : after lookup specific value, then edit record, on returning to listview see lookup value, but all records are actually
    public void test07_MBL10557() throws Exception {
        String methodID = "test07_MBL10557";

        // Test Params:
        String entityType = "Account";
        String entityRecord = TEST_ACCOUNT2_RECORD;
        String viewName = "Account Edit view";

        CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
        HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);

        System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);

        //Step: logout & log back in (to clear cookies)
        LogOutThenLogBackIn(userName, userPwd);

        try {
            //Step: search for Account entity, then open it's Edit view
            AssertJUnit.assertTrue(commNav.entityRecordEditView(entityType, entityRecord));

            AccountViewsElements accountEditView = PageFactory.initElements(driver, AccountViewsElements.class);

            //Step: edit the account and save
            accountEditView.accountEditViewBusDescFld.clear();
            accountEditView.accountEditViewBusDescFld.sendKeys("Business Description");
            headerButton.clickHeaderButton("save");
            commNav.waitForPage(TEST_ACCOUNT2_RECORD);

            //Step: go back to previous screen, Accounts, and verify that the searched for account is still the one displaying (all accounts should not display) <+++++++++
            headerButton = PageFactory.initElements(driver, HeaderButton.class);
            accountEditView = PageFactory.initElements(driver, AccountViewsElements.class);
            headerButton.clickHeaderButton("back");
            Thread.sleep(3000);
            String topAccountDisplayed = accountEditView.topAccountsListItemName.getText();
            System.out.println("topAccountDisplayed is ... " + topAccountDisplayed );
            AssertJUnit.assertEquals("VP: after an Account lookup, then edit and save of account, filtered lookup no longer in effect - FAILED", TEST_ACCOUNT2_RECORD, topAccountDisplayed);
            System.out.println("VP: after an Account lookup, then edit and save of account, filtered lookup is still in effect - PASSED");

        } catch (Error e) {
            verificationErrors.append(methodID + "(): " + e.toString());
            System.out.println("VP: after an Account lookup, then edit and save of account, filtered lookup not remaining in effect - FAILED");
            AssertJUnit.fail("test failed");
        }

        System.out.println(ENDLINE);
    }


    @Test(enabled = true)
    // MBL-10578 ... Mobile 3.0.x work phone field added via 'Add Account / Contact' does not populate for a contact
    public void test08_MBL10578() throws Exception {
        String methodID = "test08_MBL10578";

        CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
        HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);
        CommonViewsElements commView = PageFactory.initElements(driver, CommonViewsElements.class);

        System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);

        //Step: logout & log back in (to clear cookies)
        LogOutThenLogBackIn(userName, userPwd);

        AddAccountContactEditViewElements addAcctCntctView = PageFactory.initElements(driver, AddAccountContactEditViewElements.class);

        //Step: add a random test Account & Contact record
        String newAcctName = "SeAutoTestAddAcctCntct-" + new SimpleDateFormat("yyMMddHHmm").format(new GregorianCalendar().getTime());
        String newConLastName = "Smith-" + new SimpleDateFormat("yyMMddHHmm").format(new GregorianCalendar().getTime());

        //Step: navigate to Add Account/Contact view
        commNav.clickGlobalMenuItem("Add Account/Contact");

        try {
            //Setup the Contact/Account Info section fields:
            //set the name field
            addAcctCntctView.addAcctCntctNameInputBtn.click();
            try {
                commView.nameFirstInputFld.sendKeys("Andrew");
                commView.nameLastInputFld.sendKeys(newConLastName);
                headerButton.clickHeaderButton("check");
            }
            catch (Exception e0) {
                System.out.println(methodID + "(): " + e0.toString());
                headerButton.goBack();
                AssertJUnit.fail("test failed adding contact name");

            }

            //set the account field
            addAcctCntctView.addAcctCntctAccountInputFld.sendKeys(newAcctName);

            //Setup the Contact Info section:
            //set the work phone field
            addAcctCntctView.addAcctCntContactWorkPhoneInputFld.sendKeys("602.555.1313");
            System.out.println("VP: contact work phone entered on Add Account / Contact screen is (602)-555-1313");

        }
        catch (Exception e) {
            System.out.println(methodID + "(): " + e.toString());
            AssertJUnit.fail("test failed adding account/ contact");
        }

        //Step: save the new Account/Contact field values
        headerButton.clickHeaderButton("save");
        commNav.waitForNotPage("Add Account / Contact");

        System.out.println(methodID + ": Auto-test new Account - " +  newAcctName + " with new Contact - " + newConLastName + "records were created.");


        //Step: find the newly-added test Contact record using Contact NameLF lookup ... MBL-10587
        ContactViewsElements contactsListView = PageFactory.initElements(driver, ContactViewsElements.class);
        commNav.clickGlobalMenuItem("Contacts");
        commNav.waitForPage("My Contacts");

        commView.lookupTxtBox.click();
        Thread.sleep(500);
        commView.lookupTxtBox.sendKeys(Keys.BACK_SPACE);
        Thread.sleep(500);
        //contactsListView.contactsSearchTxtBox.sendKeys(newConLastName + ", Andrew");
        commView.lookupTxtBox.sendKeys(newConLastName + ", Andrew");
        //contactsListView.contactsSearchTxtBox.sendKeys(Keys.RETURN);
        commView.lookupTxtBox.sendKeys(Keys.RETURN);

        commNav.waitForPage("Contacts");
        System.out.println("VP: able to lookup a contact using lastname, firstname (NameLF) ... defect MBL-10587");


        //Step: verify that the work phone entered for the contact on the Add Account / Contact screen is displaying for the contact
        String contactWorkPhone = contactsListView.topContactsListItemWorkPhone.getText();
        System.out.println("Work Phone on contact list view has a value of ... " + contactWorkPhone);
        AssertJUnit.assertEquals("VP: work phone entered for contact on Add Account/ Contact screen has not been retained for the contact - FAILED", "(602)-555-1313", contactWorkPhone);
        System.out.println("VP: work phone entered for contact on Add Account/ Contact screen has been retained for the contact - PASSED");

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
