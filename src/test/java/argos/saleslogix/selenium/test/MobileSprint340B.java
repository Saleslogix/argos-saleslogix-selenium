package argos.saleslogix.selenium.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.List;


/**
 * @author Kathy Lockyer-Bratton
 * Class: MobileSprint340B
 * Desc.: Test class for some defects or features in Mobile 3.4.0
 */
public class MobileSprint340B extends BaseTest {

    public String TEST_ACCOUNT2_RECORD = "Bank of the Sun";
    public String TEST_CONTACT_RECORD2 = "Aceti, Janet";
    public String TEST_LEAD_RECORD = "Beck, John";
    public String TEST_OPPORTUNITY_RECORD = "Vegas Vision-Phase1";
    public String TEST_TICKET_RECORD = "001-00-000014";
	
	//Test Methods Set
	//================


    @Test(enabled = true)
    // OFFLINE ... briefcase items, view detail of items, clear offline data
    public void test01_OFFLINE() throws Exception {
        String methodID = "test01_OFFLINE";

        CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
        HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);
        CommonViewsElements commView = PageFactory.initElements(driver, CommonViewsElements.class);
        MyActivityViewsElements activityEditView = PageFactory.initElements(driver, MyActivityViewsElements.class);
        MyBriefcaseViewsElements briefcaseListView = PageFactory.initElements(driver, MyBriefcaseViewsElements.class);
        MyScheduleViewsElements scheduleListView = PageFactory.initElements(driver, MyScheduleViewsElements.class);
        RecentlyViewedViewsElements recentlyViewedListView = PageFactory.initElements(driver, RecentlyViewedViewsElements.class);


        System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);


        try {


            //Step: logout & log back in (to clear cookies)
            LogOutThenLogBackIn(userName, userPwd);

            //Step: go to settings, then Offline Options ... ready to clear all offline data
            commNav.clickGlobalMenuItem("Settings");
            commNav.waitForPage("Settings");
            commView.settingsOfflineOptions.click();
            commNav.waitForPage("Offline Options");

            //Step: Offline Options ... choose to clear all offline data older than 0 days (ie: ALL offline data)
            commView.offlineDataOlderField.click();
            commView.offlineDataOlderZeroDays.click();
            commView.offlineDataClearBtn.click();
            WebDriverWait wait = new WebDriverWait(driver, 120);
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(), 'Total Storage Usage')]")));

            //Briefcase Account
            String entityType = "Accounts";
            String entityRecord = TEST_ACCOUNT2_RECORD;

            commNav.entityRecordOpenDetailView(entityType, entityRecord);
            headerButton.clickHeaderButton("Briefcase");
            System.out.println("VP: Account " + TEST_ACCOUNT2_RECORD + " is being briefcased");

            Thread.sleep(5000);
            driver.switchTo().activeElement();
            commView.briefcaseCompleteCancelBtn.click();
            Thread.sleep(1000);
            driver.switchTo().activeElement();
            commNav.waitForPage(TEST_ACCOUNT2_RECORD);


            //Briefcase Contact
            entityType = "Contacts";
            entityRecord = TEST_CONTACT_RECORD2;

            commNav.entityRecordOpenDetailView(entityType, entityRecord);
            headerButton.clickHeaderButton("Briefcase");
            System.out.println("VP: Contact " + TEST_CONTACT_RECORD2 + " is being briefcased");

            Thread.sleep(5000);
            driver.switchTo().activeElement();
            commView = PageFactory.initElements(driver, CommonViewsElements.class);
            commView.briefcaseCompleteCancelBtn.click();
            Thread.sleep(1000);
            driver.switchTo().activeElement();
            commNav.waitForPage(TEST_CONTACT_RECORD2);


            //Briefcase Lead
            entityType = "Leads";
            entityRecord = TEST_LEAD_RECORD;

            commNav.entityRecordOpenDetailView(entityType, entityRecord);
            headerButton.clickHeaderButton("Briefcase");
            System.out.println("VP: Lead " + TEST_LEAD_RECORD + " is being briefcased");

            Thread.sleep(5000);
            driver.switchTo().activeElement();
            commView = PageFactory.initElements(driver, CommonViewsElements.class);
            commView.briefcaseCompleteCancelBtn.click();
            Thread.sleep(1000);
            driver.switchTo().activeElement();
            commNav.waitForPage(TEST_LEAD_RECORD);


            //Briefcase Opportunity
            entityType = "Opportunities";
            entityRecord = TEST_OPPORTUNITY_RECORD;

            commNav.entityRecordOpenDetailView(entityType, entityRecord);
            headerButton.clickHeaderButton("Briefcase");
            System.out.println("VP: Opportunity " + TEST_OPPORTUNITY_RECORD + " is being briefcased");

            Thread.sleep(5000);
            driver.switchTo().activeElement();
            commView = PageFactory.initElements(driver, CommonViewsElements.class);
            commView.briefcaseCompleteCancelBtn.click();
            Thread.sleep(1000);
            driver.switchTo().activeElement();
            commNav.waitForPage(TEST_OPPORTUNITY_RECORD);


            //Briefcase Ticket
            entityType = "Tickets";
            entityRecord = TEST_TICKET_RECORD;

            commNav.entityRecordOpenDetailView(entityType, entityRecord);
            headerButton.clickHeaderButton("Briefcase");
            System.out.println("VP: Ticket " + TEST_TICKET_RECORD + " is being briefcased");

            Thread.sleep(5000);
            driver.switchTo().activeElement();
            commView = PageFactory.initElements(driver, CommonViewsElements.class);
            commView.briefcaseCompleteCancelBtn.click();
            Thread.sleep(1000);
            driver.switchTo().activeElement();
            commNav.waitForPage(TEST_TICKET_RECORD);


            //Step: go to 'My Schedule'
            commNav.clickGlobalMenuItem("My Schedule");
            commNav.waitForPage("My Schedule");

            //Step: click the Add header button to open Activity schedule view
            headerButton.clickHeaderButton("Add");

            //Step: wait for page Schedule... to open
            commNav.waitForPage("Schedule...");

            //Step: select Meeting for activity type
            activityEditView.activityScheduleMeetingBtn.click();

            //Step: wait for page Meeting to open
            commNav.waitForPage("Meeting");

            //Step: add an Activity record with a random value for 'regarding'
            String newActivityRegarding = "SeAutoTestActivity-" + new SimpleDateFormat("yyMMddHHmmss").format(new GregorianCalendar().getTime());
            System.out.println("Activity regarding field will be - " + newActivityRegarding);
            String fullActivityRegarding = "Meeting - Regarding: " + newActivityRegarding;

            activityEditView.activityEditViewRegardingFld.sendKeys(newActivityRegarding);

            //Step: save activity
            headerButton.clickHeaderButton("Save");

            //Step: wait for page My Schedule
            commNav.waitForPage("My Schedule");

            //Step: open first activity in the list, which may or may not be the one just created, and briefcase
            String activityTitle = scheduleListView.myScheduleListItem1.getAttribute("data-descriptor");
            scheduleListView.myScheduleListItem1.click();
            commNav.waitForPage(activityTitle);
            Thread.sleep(1000);

            headerButton.clickHeaderButton("Briefcase");
            System.out.println("VP: Activity " + activityTitle + " is being briefcased");

            Thread.sleep(5000);
            driver.switchTo().activeElement();
            commView = PageFactory.initElements(driver, CommonViewsElements.class);
            commView.briefcaseCompleteCancelBtn.click();
            Thread.sleep(1000);
            driver.switchTo().activeElement();
            commNav.waitForPage(activityTitle);

            //Step: go to My Briefcase
            System.out.println("VP: go to My Briefcase ...");
            commNav.clickGlobalMenuItem("My Briefcase");
            commNav.waitForPage("My Briefcase");

            //Step: validate the items currently in the briefcase
            AssertJUnit.assertEquals("VP: 'briefcased' activity " + activityTitle + " added to My Briefcase - FAILED", activityTitle, briefcaseListView.myBriefcaseDescriptionItem1.getText());
            System.out.println("VP: 'briefcased' activity " + activityTitle + " added to My Briefcase - PASSED");
            AssertJUnit.assertEquals("VP: 'briefcased' ticket " + TEST_TICKET_RECORD + " added to My Briefcase - FAILED", TEST_TICKET_RECORD, briefcaseListView.myBriefcaseDescriptionItem2.getText());
            System.out.println("VP: 'briefcased' ticket " + TEST_TICKET_RECORD + " added to My Briefcase - PASSED");
            AssertJUnit.assertEquals("VP: 'briefcased' opportunity " + TEST_OPPORTUNITY_RECORD + " added to My Briefcase - FAILED", TEST_OPPORTUNITY_RECORD, briefcaseListView.myBriefcaseDescriptionItem3.getText());
            System.out.println("VP: 'briefcased' opportunity " + TEST_OPPORTUNITY_RECORD + " added to My Briefcase - PASSED");
            AssertJUnit.assertEquals("VP: 'briefcased' lead " + TEST_LEAD_RECORD + " added to My Briefcase - FAILED", TEST_LEAD_RECORD, briefcaseListView.myBriefcaseDescriptionItem4.getText());
            System.out.println("VP: 'briefcased' lead " + TEST_LEAD_RECORD + " added to My Briefcase - PASSED");
            AssertJUnit.assertEquals("VP: 'briefcased' contact " + TEST_CONTACT_RECORD2 + " added to My Briefcase - FAILED", TEST_CONTACT_RECORD2, briefcaseListView.myBriefcaseDescriptionItem5.getText());
            System.out.println("VP: 'briefcased' contact " + TEST_CONTACT_RECORD2 + " added to My Briefcase - PASSED");
            AssertJUnit.assertEquals("VP: 'briefcased' account " + TEST_ACCOUNT2_RECORD + " added to My Briefcase - FAILED", TEST_ACCOUNT2_RECORD, briefcaseListView.myBriefcaseDescriptionItem6.getText());
            System.out.println("VP: 'briefcased' account " + TEST_ACCOUNT2_RECORD + " added to My Briefcase - PASSED");


            //Step: go to 'Recently Viewed'
            System.out.println("VP: go to Recently Viewed ...");
            commNav.clickGlobalMenuItem("Recently Viewed");
            commNav.waitForPage("Recently Viewed");

            //Step: validate the items currently under Recently Viewed
            AssertJUnit.assertEquals("VP: 'viewed' activity detail " + activityTitle + " added to Recently Viewed - FAILED", activityTitle, recentlyViewedListView.recentlyViewedDescriptionItem1.getText());
            System.out.println("VP: 'viewed' activity detail " + activityTitle + " added to Recently Viewed - PASSED");
            AssertJUnit.assertEquals("VP: 'viewed' ticket " + TEST_TICKET_RECORD + " added to Recently Viewed - FAILED", TEST_TICKET_RECORD, recentlyViewedListView.recentlyViewedDescriptionItem2.getText());
            System.out.println("VP: 'viewed' ticket " + TEST_TICKET_RECORD + " added to Recently Viewed - PASSED");
            AssertJUnit.assertEquals("VP: 'viewed' opportunity " + TEST_OPPORTUNITY_RECORD + " added to Recently Viewed - FAILED", TEST_OPPORTUNITY_RECORD, recentlyViewedListView.recentlyViewedDescriptionItem3.getText());
            System.out.println("VP: 'viewed' opportunity " + TEST_OPPORTUNITY_RECORD + " added to Recently Viewed - PASSED");
            AssertJUnit.assertEquals("VP: 'viewed' lead " + TEST_LEAD_RECORD + " added to Recently Viewed - FAILED", TEST_LEAD_RECORD, recentlyViewedListView.recentlyViewedDescriptionItem4.getText());
            System.out.println("VP: 'viewed' lead " + TEST_LEAD_RECORD + " added to Recently Viewed - PASSED");
            AssertJUnit.assertEquals("VP: 'viewed' contact " + TEST_CONTACT_RECORD2 + " added to Recently Viewed - FAILED", TEST_CONTACT_RECORD2, recentlyViewedListView.recentlyViewedDescriptionItem5.getText());
            System.out.println("VP: 'viewed' contact " + TEST_CONTACT_RECORD2 + " added to Recently Viewed - PASSED");
            AssertJUnit.assertEquals("VP: 'viewed' account " + TEST_ACCOUNT2_RECORD + " added to Recently Viewed - FAILED", TEST_ACCOUNT2_RECORD, recentlyViewedListView.recentlyViewedDescriptionItem6.getText());
            System.out.println("VP: 'viewed' account " + TEST_ACCOUNT2_RECORD + " added to Recently Viewed - PASSED");


            //Step: go to settings, then Offline Options ... ready to clear all offline data again
            commNav.clickGlobalMenuItem("Settings");
            commNav.waitForPage("Settings");
            commView.settingsOfflineOptions.click();
            commNav.waitForPage("Offline Options");

            //Step: Offline Options ... choose to clear all offline data older than 0 days (ie: ALL offline data)
            commView.offlineDataOlderField.click();
            commView.offlineDataOlderZeroDays.click();
            commView.offlineDataClearBtn.click();
            element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(), 'Total Storage Usage')]")));

            //Step: verify that My Briefcase now has 'no records'
            commNav.clickGlobalMenuItem("My Briefcase");
            commNav.waitForPage("My Briefcase");
            AssertJUnit.assertEquals("VP: after clearing all offline data, no records appear under My Briefcase - FAILED", "no records", briefcaseListView.briefcaseNoRecords.getText());
            System.out.println("VP: after clearing all offline data, no records appear under My Briefcase - PASSED");

            //Step: verify that Recently Viewed now has 'no records'
            commNav.clickGlobalMenuItem("Recently Viewed");
            commNav.waitForPage("Recently Viewed");
            AssertJUnit.assertEquals("VP: after clearing all offline data, no records appear under Recently Viewed - FAILED", "no records", recentlyViewedListView.recentlyViewedNoRecords.getText());
            System.out.println("VP: after clearing all offline data, no records appear under Recently Viewed - PASSED");


            System.out.println("VP: OFFLINE features for briefcase, recently viewed, clearing offline data - PASSED");

        }


        catch (Exception e) {
            verificationErrors.append(methodID + "(): " + e.toString());
            System.out.println("VP: OFFLINE features for briefcase, recently viewed, clearing offline data - FAILED");
            AssertJUnit.fail("test failed");
        }


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
