package argos.saleslogix.selenium.test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;


/**
 * Test class that defines test methods for the SLX Mobile Defect (v3.2.0) fixes.
 * 
 * @author kathleen.lockyer-bratton@swiftpage.com
 * @version	1.0
 */
public class GroupsTest2 extends BaseTest {


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
    // MBL-10727 ... addition of Summary and Detail layout options for groups

    public void test05_MBL10727() throws Exception {
        String methodID = "test05_MBL10727";

        // Account Groups
        // Test Params:
        String entityType = "accounts";

        CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
        HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);

        System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);

        //Step: logout & log back in (to clear cookies)
        LogOutThenLogBackIn(userName, userPwd);

        //Step: navigate to Accounts list view...
        commNav.clickGlobalMenuItem(entityType);
        commNav.waitForPage("All Accounts");

        //Step: verify that 'Summary' layout is in effect ... should not see a second column with 'Sub-Type' in group listview
        AssertJUnit.assertFalse("VP: Account Group List View is not displaying Summary layout by default - FAILED", driver.getPageSource().contains("Sub-Type"));
        System.out.println("VP: Account Group List View is displaying Summary layout by default - PASSED");

        //Step: reveal Right Context Menu panel, and verify that both 'Summary' and 'Detail' layout options appear
        headerButton.showRightContextMenu();
        AssertJUnit.assertTrue("Accounts : Right Menu Group Summary layout option is not present", commNav.checkIfWebElementPresent("Accounts ... Right Menu Group Summary layout option",commNav.rmenu_GroupSummary));
        AssertJUnit.assertTrue("Accounts : Right Menu Group Detail layout option is not present", commNav.checkIfWebElementPresent("Accounts ... Right Menu Group Detail layout option",commNav.rmenu_GroupDetail));

        //Step: choose 'Detail' layout ... should see a second column with 'Sub-Type' in group listview
        commNav.rmenu_GroupDetail.click();
        commNav.waitForPage("All Accounts");
        Thread.sleep(3000);
        AssertJUnit.assertTrue("VP: Account Group List View is not displaying Detail layout when chosen - FAILED", driver.getPageSource().contains("Sub-Type"));
        System.out.println("VP: Account Group List View is displaying Detail layout when chosen - PASSED");

        //Step: open right menu and choose 'Summary' layout ... should not see a second column with 'Sub-Type' in group listview
        headerButton.showRightContextMenu();
        commNav.rmenu_GroupSummary.click();
        commNav.waitForPage("All Accounts");
        Thread.sleep(3000);
        AssertJUnit.assertFalse("VP: Account Group List View is not displaying Summary layout when chosen - FAILED", driver.getPageSource().contains("Sub-Type"));
        System.out.println("VP: Account Group List View is displaying Summary layout when chosen - PASSED");

        System.out.println("VP: Account group layouts functioning as expected - PASSED");


        // Contact Groups
        // Test Params:
        entityType = "contacts";

        commNav = PageFactory.initElements(driver, CommonNavigation.class);
        headerButton = PageFactory.initElements(driver, HeaderButton.class);

        //Step: navigate to Contacts list view...
        commNav.clickGlobalMenuItem(entityType);
        commNav.waitForPage("All Contacts");

        //Step: verify that 'Summary' layout is in effect ... should not see a second column with 'Work Phone' in group listview
        AssertJUnit.assertFalse("VP: Contact Group List View is not displaying Summary layout by default - FAILED", driver.getPageSource().contains("Work Phone"));
        System.out.println("VP: Contact Group List View is displaying Summary layout by default - PASSED");

        //Step: reveal Right Context Menu panel, and verify that both 'Summary' and 'Detail' layout options appear
        headerButton.showRightContextMenu();
        AssertJUnit.assertTrue("Contacts : Right Menu Group Summary layout option is not present", commNav.checkIfWebElementPresent("Contacts ... Right Menu Group Summary layout option",commNav.rmenu_GroupSummary));
        AssertJUnit.assertTrue("Contacts : Right Menu Group Detail layout option is not present", commNav.checkIfWebElementPresent("Contacts ... Right Menu Group Detail layout option",commNav.rmenu_GroupDetail));

        //Step: choose 'Detail' layout ... should see a second column with 'Work Phone' in group listview
        commNav.rmenu_GroupDetail.click();
        commNav.waitForPage("All Contacts");
        Thread.sleep(3000);
        AssertJUnit.assertTrue("VP: Contact Group List View is not displaying Detail layout when chosen - FAILED", driver.getPageSource().contains("Work Phone"));
        System.out.println("VP: Contact Group List View is displaying Detail layout when chosen - PASSED");

        //Step: open right menu and choose 'Summary' layout ... should not see a second column with 'Work Phone' in group listview
        headerButton.showRightContextMenu();
        commNav.rmenu_GroupSummary.click();
        commNav.waitForPage("All Contacts");
        Thread.sleep(3000);
        AssertJUnit.assertFalse("VP: Contact Group List View is not displaying Summary layout when chosen - FAILED", driver.getPageSource().contains("Work Phone"));
        System.out.println("VP: Contact Group List View is displaying Summary layout when chosen - PASSED");

        System.out.println("VP: Contact group layouts functioning as expected - PASSED");


        // Lead Groups
        // Test Params:
        entityType = "leads";

        commNav = PageFactory.initElements(driver, CommonNavigation.class);
        headerButton = PageFactory.initElements(driver, HeaderButton.class);

        //Step: navigate to Leads list view...
        commNav.clickGlobalMenuItem(entityType);
        commNav.waitForPage("Leads");

        LeadViewsElements leadsListView = PageFactory.initElements(driver, LeadViewsElements.class);

        //Step: reveal Right Context Menu panel
        headerButton.showRightContextMenu();

        //Step: click on Configure button to open 'Groups Lookup' and select 'All Leads' for loup
        commNav.rmenu_GroupConfigure.click();
        commNav.waitForPage("Groups Lookup");
        leadsListView.groupsConfigureAllLeads.click();
        headerButton.checkButton.click();
        commNav.waitForPage("All Leads");
        Thread.sleep(3000);

        //Step: open right menu and select 'All Leads' group to display   ... NO LONGER NEEDED
        //headerButton.showRightContextMenu();
        //leadsListView.rmenu_groupAllLeads.click();
        //commNav.waitForPage("All Leads");
        //Thread.sleep(3000);

        //Step: verify that 'Summary' layout is in effect ... should not see a second column with 'Work Phone' in group listview
        AssertJUnit.assertFalse("VP: Lead Group List View is not displaying Summary layout by default - FAILED", driver.getPageSource().contains("Work Phone"));
        System.out.println("VP: Lead Group List View is displaying Summary layout by default - PASSED");

        //Step: reveal Right Context Menu panel, and verify that both 'Summary' and 'Detail' layout options appear
        headerButton.showRightContextMenu();
        AssertJUnit.assertTrue("Leads : Right Menu Group Summary layout option is not present", commNav.checkIfWebElementPresent("Leads ... Right Menu Group Summary layout option",commNav.rmenu_GroupSummary));
        AssertJUnit.assertTrue("Leads : Right Menu Group Detail layout option is not present", commNav.checkIfWebElementPresent("Leads ... Right Menu Group Detail layout option",commNav.rmenu_GroupDetail));

        //Step: choose 'Detail' layout ... should see a second column with 'Work Phone' in group listview
        commNav.rmenu_GroupDetail.click();
        commNav.waitForPage("All Leads");
        Thread.sleep(3000);
        AssertJUnit.assertTrue("VP: Lead Group List View is not displaying Detail layout when chosen - FAILED", driver.getPageSource().contains("Work Phone"));
        System.out.println("VP: Lead Group List View is displaying Detail layout when chosen - PASSED");

        //Step: open right menu and choose 'Summary' layout ... should not see a second column with 'Work Phone' in group listview
        headerButton.showRightContextMenu();
        commNav.rmenu_GroupSummary.click();
        commNav.waitForPage("All Leads");
        Thread.sleep(3000);
        AssertJUnit.assertFalse("VP: Lead Group List View is not displaying Summary layout when chosen - FAILED", driver.getPageSource().contains("Work Phone"));
        System.out.println("VP: Lead Group List View is displaying Summary layout when chosen - PASSED");

        System.out.println("VP: Lead group layouts functioning as expected - PASSED");


        // Opportunity Groups
        // Test Params:
        entityType = "opportunities";

        commNav = PageFactory.initElements(driver, CommonNavigation.class);
        headerButton = PageFactory.initElements(driver, HeaderButton.class);

        //Step: navigate to Opportunities list view...
        commNav.clickGlobalMenuItem(entityType);
        commNav.waitForPage("All Opportunities");

        //Step: verify that 'Summary' layout is in effect ... should not see a second column with 'Weighted' in group listview
        AssertJUnit.assertFalse("VP: Opportunity Group List View is not displaying Summary layout by default - FAILED", driver.getPageSource().contains("Weighted"));
        System.out.println("VP: Opportunity Group List View is displaying Summary layout by default - PASSED");

        //Step: reveal Right Context Menu panel, and verify that both 'Summary' and 'Detail' layout options appear
        headerButton.showRightContextMenu();
        AssertJUnit.assertTrue("Opportunities : Right Menu Group Summary layout option is not present", commNav.checkIfWebElementPresent("Opportunities ... Right Menu Group Summary layout option",commNav.rmenu_GroupSummary));
        AssertJUnit.assertTrue("Opportunities : Right Menu Group Detail layout option is not present", commNav.checkIfWebElementPresent("Opportunities ... Right Menu Group Detail layout option",commNav.rmenu_GroupDetail));

        //Step: choose 'Detail' layout ... should see a second column with 'Weighted' in group listview
        commNav.rmenu_GroupDetail.click();
        commNav.waitForPage("All Opportunities");
        Thread.sleep(3000);
        AssertJUnit.assertTrue("VP: Opportunity Group List View is not displaying Detail layout when chosen - FAILED", driver.getPageSource().contains("Weighted"));
        System.out.println("VP: Opportunity Group List View is displaying Detail layout when chosen - PASSED");

        //Step: open right menu and choose 'Summary' layout ... should not see a second column with 'Weighted' in group listview
        headerButton.showRightContextMenu();
        commNav.rmenu_GroupSummary.click();
        commNav.waitForPage("All Opportunities");
        Thread.sleep(3000);
        AssertJUnit.assertFalse("VP: Opportunity Group List View is not displaying Summary layout when chosen - FAILED", driver.getPageSource().contains("Weighted"));
        System.out.println("VP: Opportunity Group List View is displaying Summary layout when chosen - PASSED");

        System.out.println("VP: Opportunity group layouts functioning as expected - PASSED");


        // Ticket Groups
        // Test Params:
        entityType = "tickets";

        commNav = PageFactory.initElements(driver, CommonNavigation.class);
        headerButton = PageFactory.initElements(driver, HeaderButton.class);

        //Step: navigate to Tickets list view...
        commNav.clickGlobalMenuItem(entityType);
        commNav.waitForPage("All Open");

        //Step: verify that 'Summary' layout is in effect ... should not see a second column with 'Received Date' in group listview
        AssertJUnit.assertFalse("VP: Ticket Group List View is not displaying Summary layout by default - FAILED", driver.getPageSource().contains("Received Date"));
        System.out.println("VP: Ticket Group List View is displaying Summary layout by default - PASSED");

        //Step: reveal Right Context Menu panel, and verify that both 'Summary' and 'Detail' layout options appear
        headerButton.showRightContextMenu();
        AssertJUnit.assertTrue("Tickets : Right Menu Group Summary layout option is not present", commNav.checkIfWebElementPresent("Tickets ... Right Menu Group Summary layout option",commNav.rmenu_GroupSummary));
        AssertJUnit.assertTrue("Tickets : Right Menu Group Detail layout option is not present", commNav.checkIfWebElementPresent("Tickets ... Right Menu Group Detail layout option",commNav.rmenu_GroupDetail));

        //Step: choose 'Detail' layout ... should see a second column with 'Received Date' in group listview
        commNav.rmenu_GroupDetail.click();
        commNav.waitForPage("All Open");
        Thread.sleep(3000);
        AssertJUnit.assertTrue("VP: Ticket Group List View is not displaying Detail layout when chosen - FAILED", driver.getPageSource().contains("Received Date"));
        System.out.println("VP: Ticket Group List View is displaying Detail layout when chosen - PASSED");

        //Step: open right menu and choose 'Summary' layout ... should not see a second column with 'Received Date' in group listview
        headerButton.showRightContextMenu();
        commNav.rmenu_GroupSummary.click();
        commNav.waitForPage("All Open");
        Thread.sleep(3000);
        AssertJUnit.assertFalse("VP: Ticket Group List View is not displaying Summary layout when chosen - FAILED", driver.getPageSource().contains("Received Date"));
        System.out.println("VP: Ticket Group List View is displaying Summary layout when chosen - PASSED");

        System.out.println("VP: Ticket group layouts functioning as expected - PASSED");

        System.out.println(ENDLINE);
    }


    @Test(enabled = true)
    // MBL-10785 ... Ticket groups : phone hyperlink is not working

    public void test06_MBL10785() throws Exception {
        String methodID = "test06_MBL10785";

        // Test Params:
        String entityType = "tickets";

        CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
        HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);
        TicketViewsElements ticketsListView = PageFactory.initElements(driver, TicketViewsElements.class);

        System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);


        //Step: logout & log back in (to clear cookies)
        LogOutThenLogBackIn(userName, userPwd);

        //Step: navigate to Tickets list view ...the 'All Open' group should be displaying in Summary layout
        commNav.clickGlobalMenuItem(entityType);

        //Step: Click on the Work Phone hyperlink ... some action should be taken to call the number
        String ticketWorkPhone = ticketsListView.ticketGroupViewWorkPhoneFld.getText();
        String ticketWorkPhoneEdited  = ticketWorkPhone.replace("(","");
        ticketWorkPhoneEdited = ticketWorkPhoneEdited.replace(")","");
        ticketWorkPhoneEdited = ticketWorkPhoneEdited.replace("-","");
        System.out.println("VP: Ticket group view Work Phone value to be clicked is ... " + ticketWorkPhone + " / " + ticketWorkPhoneEdited);
        ticketsListView.ticketGroupViewWorkPhoneFld.click();
        //commNav.waitForPage("Note");
        Thread.sleep(3000);
        String urlTelephone = driver.getCurrentUrl().substring(4);
        System.out.println("VP: Value of Work Phone in browser address bar (would be called) is ... " + urlTelephone);

        //Step: verify that the work phone number clicked results in a call attempt to the same number
        AssertJUnit.assertEquals("VP: clicking the ticket group Work Phone did not try to call that number - FAILED",ticketWorkPhoneEdited,urlTelephone);
        System.out.println("VP: clicking the ticket group Work Phone did try to call that number - PASSED");


        closeBrowser();
        launchBrowser();
        //driver.navigate().back();
        //driver.navigate().refresh();
        //if (commNav.isTextNotPresentOnPage("Copyright")) {
        //   driver.navigate().refresh();
        //}
        doVerificationLogin();

        System.out.println(ENDLINE);
    }


    @Test(enabled = true)
    // MBL-10772 ... Need to hyperlink for Phone in group list ... Accounts, Contacts, Leads (Tickets covered in test06_MBL10785)

    public void test07_MBL10772() throws Exception {
        String methodID = "test07_MBL10772";

        //Accounts group view phone hyperlink
        // Test Params:
        String entityType = "accounts";

        CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
        AccountViewsElements accountsListView = PageFactory.initElements(driver, AccountViewsElements.class);

        System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);


        //Step: logout & log back in (to clear cookies)
        //LogOutThenLogBackIn(userName, userPwd);

        //Step: navigate to Accounts list view ...the 'All Accounts' group should be displaying in Summary layout
        commNav.clickGlobalMenuItem(entityType);

        //Step: Click on the Main Phone hyperlink ... some action should be taken to call the number
        String accountMainPhone = accountsListView.accountGroupViewMainPhoneFld.getText();
        String accountMainPhoneEdited  = accountMainPhone.replace("(","");
        accountMainPhoneEdited = accountMainPhoneEdited.replace(")","");
        accountMainPhoneEdited = accountMainPhoneEdited.replace("-","");
        System.out.println("VP: Account group view Main Phone value to be clicked is ... " + accountMainPhone + " / " + accountMainPhoneEdited);
        accountsListView.accountGroupViewMainPhoneFld.click();
        commNav.waitForPage("Note");
        Thread.sleep(3000);
        String urlTelephone = driver.getCurrentUrl().substring(4);
        System.out.println("VP: Value of Main Phone in browser address bar (would be called) is ... " + urlTelephone);

        //Step: verify that the main phone number clicked results in a call attempt to the same number
        AssertJUnit.assertEquals("VP: clicking the Account group Main Phone did not try to call that number - FAILED",accountMainPhoneEdited,urlTelephone);
        System.out.println("VP: clicking the Account group Main Phone did try to call that number - PASSED");

        closeBrowser();
        launchBrowser();
        //driver.navigate().back();
        //driver.navigate().refresh();
        //if (commNav.isTextNotPresentOnPage("Copyright")) {
        //    driver.navigate().refresh();
        //}
        doVerificationLogin();

        Thread.sleep(3000);
        //commNav.waitForPage("My Schedule");

        //Contacts group view phone hyperlinks
        // Test Params:
        entityType = "contacts";

        commNav = PageFactory.initElements(driver, CommonNavigation.class);
        ContactViewsElements contactsListView = PageFactory.initElements(driver, ContactViewsElements.class);
        HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);

        //Step: navigate to Contacts list view ...the 'All Contacts' group should be displaying in Summary layout, switch to Detail layout
        commNav.clickGlobalMenuItem(entityType);
        headerButton.rightCntxtMnuButton.click();
        commNav.rmenu_GroupDetail.click();
        commNav.waitForPage("All Contacts");
        Thread.sleep(3000);


        //Step: Click on the Work Phone hyperlink ... some action should be taken to call the number
        String contactWorkPhone = contactsListView.contactGroupViewWorkPhoneFld.getText();
        String contactWorkPhoneEdited  = contactWorkPhone.replace("(","");
        contactWorkPhoneEdited = contactWorkPhoneEdited.replace(")","");
        contactWorkPhoneEdited = contactWorkPhoneEdited.replace("-","");
        System.out.println("VP: Contact group view Work Phone value to be clicked is ... " + contactWorkPhone + " / " + contactWorkPhoneEdited);
        contactsListView.contactGroupViewWorkPhoneFld.click();
        commNav.waitForPage("President");
        Thread.sleep(3000);
        urlTelephone = driver.getCurrentUrl().substring(4);
        System.out.println("VP: Value of Work Phone in browser address bar (would be called) is ... " + urlTelephone);

        //Step: verify that the work phone number clicked results in a call attempt to the same number
        AssertJUnit.assertEquals("VP: clicking the Contact group Work Phone did not try to call that number - FAILED",contactWorkPhoneEdited,urlTelephone);
        System.out.println("VP: clicking the Contact group Work Phone did try to call that number - PASSED");

        driver.navigate().back();
        //driver.navigate().refresh();
        //if (commNav.isTextNotPresentOnPage("Copyright")) {
        //    driver.navigate().refresh();
        //}
        //doVerificationLogin();

        Thread.sleep(3000);
        //commNav.waitForPage("My Schedule");

        commNav = PageFactory.initElements(driver, CommonNavigation.class);
        contactsListView = PageFactory.initElements(driver, ContactViewsElements.class);
        headerButton = PageFactory.initElements(driver, HeaderButton.class);

        //Step: navigate to Contacts list view ...the 'All Contacts' group should still be displaying in Detail layout
        commNav.clickGlobalMenuItem(entityType);


        //Step: Click on the Mobile hyperlink ... some action should be taken to call the number
        String contactMobilePhone = contactsListView.contactGroupViewMobileFld.getText();
        String contactMobileEdited  = contactMobilePhone.replace("(","");
        contactMobileEdited = contactMobileEdited.replace(")","");
        contactMobileEdited = contactMobileEdited.replace("-","");
        System.out.println("VP: Contact group view Mobile Phone value to be clicked is ... " + contactMobilePhone + " / " + contactMobileEdited);
        contactsListView.contactGroupViewMobileFld.click();
        commNav.waitForPage("President");
        Thread.sleep(3000);
        urlTelephone = driver.getCurrentUrl().substring(4);
        System.out.println("VP: Value of Mobile Phone in browser address bar (would be called) is ... " + urlTelephone);

        //Step: verify that the mobile phone number clicked results in a call attempt to the same number
        AssertJUnit.assertEquals("VP: clicking the Contact group Mobile Phone did not try to call that number - FAILED",contactMobileEdited,urlTelephone);
        System.out.println("VP: clicking the Contact group Mobile Phone did try to call that number - PASSED");

        driver.navigate().back();
        //driver.navigate().refresh();
        //if (commNav.isTextNotPresentOnPage("Copyright")) {
        //    driver.navigate().refresh();
        //}
        //doVerificationLogin();

        Thread.sleep(3000);
        //commNav.waitForPage("My Schedule");

        //Step: reset the Contact group layout to 'Summary' again
        commNav = PageFactory.initElements(driver, CommonNavigation.class);
        headerButton = PageFactory.initElements(driver, HeaderButton.class);

        commNav.clickGlobalMenuItem(entityType);
        headerButton.rightCntxtMnuButton.click();
        commNav.rmenu_GroupSummary.click();
        commNav.waitForPage("All Contacts");
        Thread.sleep(3000);


        //Leads group view phone hyperlink
        // Test Params:
        entityType = "Leads";

        commNav = PageFactory.initElements(driver, CommonNavigation.class);
        LeadViewsElements leadsListView = PageFactory.initElements(driver, LeadViewsElements.class);
        headerButton = PageFactory.initElements(driver, HeaderButton.class);

        //Step: navigate to Leads list view ... since the web browser was closed and re-opened since step 05, need to re-instate the 'All Leads' group and switch to Detail layout
        commNav.clickGlobalMenuItem(entityType);
        commNav.waitForPage("Leads");

        //Step: reveal Right Context Menu panel
        headerButton.showRightContextMenu();

        //Step: click on Configure button to open 'Groups Lookup' and select 'All Leads' for loup
        commNav.rmenu_GroupConfigure.click();
        commNav.waitForPage("Groups Lookup");
        leadsListView.groupsConfigureAllLeads.click();
        headerButton.checkButton.click();
        commNav.waitForPage("All Leads");
        Thread.sleep(3000);

        headerButton.rightCntxtMnuButton.click();
        commNav.rmenu_GroupDetail.click();
        commNav.waitForPage("All Leads");
        Thread.sleep(3000);


        //Step: Click on the Work Phone hyperlink ... some action should be taken to call the number
        String leadWorkPhone = leadsListView.leadGroupViewWorkPhoneFld.getText();
        String leadWorkPhoneEdited  = leadWorkPhone.replace("(","");
        leadWorkPhoneEdited = leadWorkPhoneEdited.replace(")","");
        leadWorkPhoneEdited = leadWorkPhoneEdited.replace("-","");
        System.out.println("VP: Lead group view Work Phone value to be clicked is ... " + leadWorkPhone + " / " + leadWorkPhoneEdited);
        leadsListView.leadGroupViewWorkPhoneFld.click();
        commNav.waitForPage("IT Director");
        Thread.sleep(3000);
        urlTelephone = driver.getCurrentUrl().substring(4);
        System.out.println("VP: Value of Work Phone in browser address bar (would be called) is ... " + urlTelephone);

        //Step: verify that the work phone number clicked results in a call attempt to the same number
        AssertJUnit.assertEquals("VP: clicking the Lead group Work Phone did not try to call that number - FAILED",leadWorkPhoneEdited,urlTelephone);
        System.out.println("VP: clicking the Lead group Work Phone did try to call that number - PASSED");

        driver.navigate().back();
        //driver.navigate().refresh();
        //if (commNav.isTextNotPresentOnPage("Copyright")) {
        //    driver.navigate().refresh();
        //}
        //doVerificationLogin();

        Thread.sleep(3000);
        //commNav.waitForPage("My Schedule");


        //Step: reset the Lead group layout to 'Summary' again
        commNav = PageFactory.initElements(driver, CommonNavigation.class);
        headerButton = PageFactory.initElements(driver, HeaderButton.class);

        commNav.clickGlobalMenuItem(entityType);
        headerButton.rightCntxtMnuButton.click();
        commNav.rmenu_GroupSummary.click();
        commNav.waitForPage("All Leads");
        Thread.sleep(3000);


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
