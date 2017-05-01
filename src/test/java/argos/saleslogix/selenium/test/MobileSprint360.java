package argos.saleslogix.selenium.test;

import argos.saleslogix.selenium.pages.*;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import java.util.List;


/**
 * @author Kathy Lockyer-Bratton
 *         Class: MobileSprint360
 *         Desc.: Test class for some defects or features in Mobile 3.6.0
 */
public class MobileSprint360 extends BaseTest {

    private String TEST_ACCOUNT_RECORD = "Abbott Ltd.";
    private String TEST_ACCOUNT2_RECORD = "Bank of the Sun";
    public String TEST_CONTACT_RECORD = "Abbott, John";
    private String TEST_CONTACT_RECORD2 = "Aceti, Janet";

    @Test
    // INFORCRM-10474 ... Calendar modal control ... allow 24-hour clock option
    public void test01_INFORCRM10474() throws Exception {
        String methodID = "test01_INFORCRM10474";
        String viewName = "Modal Calendar";

        System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);

        //Step: logout & log back in (to clear cookies)
        LogOutThenLogBackIn(userName, userPwd);
        CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
        CommonViewsElements commView = PageFactory.initElements(driver, CommonViewsElements.class);
        HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);
        MyActivityViewsElements activityEditView = PageFactory.initElements(driver, MyActivityViewsElements.class);
        CalendarViewsElements calendarView = PageFactory.initElements(driver, CalendarViewsElements.class);


        //Step: go to settings, then choose to switch to a 24-hour clock
        commNav.clickGlobalMenuItem("Settings");
        commNav.waitForPage("Settings");

        //Step: perform the following if Settings displays 'Using 12-hour Clock' .... and therefore need to switch to 24-hour clock
        if (commView.settingsUse24HourClock.getText().equals("Using 12-hour Clock")) {
            commView.settingsUse24HourClock.click();

            //Step: verify the message on the alert for switching to 24-hour clock, and press OK
            String clockMessage = "Changing the clock to 24-hour format will require an application restart. Continue?";
            Alert alert = driver.switchTo().alert();
            AssertJUnit.assertEquals("VP: message on changing from 12 hour clock to 24 hour clock of : '" + alert.getText() + "' - FAILED", clockMessage, alert.getText());
            System.out.println("VP: message on changing from 12 hour clock to 24 hour clock of : '" + alert.getText() + "' - PASSED");
            alert.accept();
        } else {
            System.out.println("VP: 24-hour clock is already in effect ");
        }

        LogOutThenLogBackIn(userName, userPwd);

        //Step: go to Calendar view ... wait for page Calendar
        commNav.clickGlobalMenuItem("Calendar");
        commNav.waitForPage("Calendar");


        //Step: click the Add header button to open Activity schedule view
        headerButton.clickHeaderButton("Add");

        //Step: wait for page Schedule... to open
        commNav.waitForPage("Schedule...");

        //Step: select Meeting for activity type
        activityEditView.activityScheduleMeetingBtn.click();

        //Step: wait for page Meeting to open
        commNav.waitForPage("Meeting");

        //Step: Open Start Time calendar, and wait for modal calendar control to open
        activityEditView.activityEditViewStartTimeFldBtn.click();
        commNav.waitForAnimation();

        //Press Advanced button to open Calendar view
        calendarView.openAdvanced();

        //Verify the hour dropdown is as expected for the 24 hour clock ... hours 0 through 23
        calendarView.calendarHourField.click();
        commNav.isWebElementPresent(viewName + ", Hour - 0 of 24-hour clock", calendarView.calendarHourOne);
        commNav.isWebElementPresent(viewName + ", Hour - 1 of 24-hour clock", calendarView.calendarHourTwo);
        commNav.isWebElementPresent(viewName + ", Hour - 2 of 24-hour clock", calendarView.calendarHourThree);
        commNav.isWebElementPresent(viewName + ", Hour - 3 of 24-hour clock", calendarView.calendarHourFour);
        commNav.isWebElementPresent(viewName + ", Hour - 4 of 24-hour clock", calendarView.calendarHourFive);
        commNav.isWebElementPresent(viewName + ", Hour - 5 of 24-hour clock", calendarView.calendarHourSix);
        commNav.isWebElementPresent(viewName + ", Hour - 6 of 24-hour clock", calendarView.calendarHourSeven);
        commNav.isWebElementPresent(viewName + ", Hour - 7 of 24-hour clock", calendarView.calendarHourEight);
        commNav.isWebElementPresent(viewName + ", Hour - 8 of 24-hour clock", calendarView.calendarHourNine);
        commNav.isWebElementPresent(viewName + ", Hour - 9 of 24-hour clock", calendarView.calendarHourTen);
        commNav.isWebElementPresent(viewName + ", Hour - 10 of 24-hour clock", calendarView.calendarHourEleven);
        commNav.isWebElementPresent(viewName + ", Hour - 11 of 24-hour clock", calendarView.calendarHourTwelve);
        commNav.isWebElementPresent(viewName + ", Hour - 12 of 24-hour clock", calendarView.calendarHourThirteen);
        commNav.isWebElementPresent(viewName + ", Hour - 13 of 24-hour clock", calendarView.calendarHourFourteen);
        commNav.isWebElementPresent(viewName + ", Hour - 14 of 24-hour clock", calendarView.calendarHourFifteen);
        commNav.isWebElementPresent(viewName + ", Hour - 15 of 24-hour clock", calendarView.calendarHourSixteen);
        commNav.isWebElementPresent(viewName + ", Hour - 16 of 24-hour clock", calendarView.calendarHourSeventeen);
        commNav.isWebElementPresent(viewName + ", Hour - 17 of 24-hour clock", calendarView.calendarHourEighteen);
        commNav.isWebElementPresent(viewName + ", Hour - 18 of 24-hour clock", calendarView.calendarHourNineteen);
        commNav.isWebElementPresent(viewName + ", Hour - 19 of 24-hour clock", calendarView.calendarHourTwenty);
        commNav.isWebElementPresent(viewName + ", Hour - 20 of 24-hour clock", calendarView.calendarHourTwentyOne);
        commNav.isWebElementPresent(viewName + ", Hour - 21 of 24-hour clock", calendarView.calendarHourTwentyTwo);
        commNav.isWebElementPresent(viewName + ", Hour - 22 of 24-hour clock", calendarView.calendarHourTwentyThree);
        commNav.isWebElementPresent(viewName + ", Hour - 23 of 24-hour clock", calendarView.calendarHourTwentyFour);

        //Step: choose a time of 9:00 in the morning  (the 10th hour has a value of 9 for 24-hour clock)
        calendarView.calendarHourTen.click();
        System.out.println("Hour of 9 clicked");
        calendarView.calendarMinuteField.click();
        calendarView.calendarMinute00.click();
        System.out.println("Minute of 00 clicked");

        //Step : extract the time portion of the date/time ... characters following the space after the date
        calendarView.confirm();
        driver.switchTo().activeElement();
        commNav.waitForPage("Meeting");
        String editedStartTime = activityEditView.activityEditViewStartTimeFld.getAttribute("value");
        System.out.println("VP: start time has been set to a morning time of ... " + editedStartTime);
        String activityTime = editedStartTime.substring(editedStartTime.indexOf(' ') + 1);

        //Step : verify that the selected time is displaying in 24-hour clock format
        AssertJUnit.assertEquals("VP: selected time of '" + activityTime + "' displays with 24-hour clock - FAILED", "9:00", activityTime);
        System.out.println("VP: selected time of '" + activityTime + "' displays with 24-hour clock - PASSED");

        //Step: Re-open Start Time calendar, and wait for modal calendar control to open
        activityEditView.activityEditViewStartTimeFldBtn.click();
        commNav.waitForAnimation();

        //Step: Press Advanced button to open Calendar view
        calendarView = PageFactory.initElements(driver, CalendarViewsElements.class);
        calendarView.openAdvanced();

        //Step: choose a time of 14:00 in the afternoon
        calendarView.calendarHourField.click();
        commNav.waitForAnimation();
        calendarView.calendarHourFifteen.click();
        calendarView.calendarMinuteField.click();
        commNav.waitForAnimation();
        calendarView.calendarMinute00.click();

        //Step : extract the time portion of the date/time ... characters following the space after the date
        calendarView.confirm();
        driver.switchTo().activeElement();
        commNav.waitForPage("Meeting");
        editedStartTime = activityEditView.activityEditViewStartTimeFld.getAttribute("value");
        System.out.println("VP: start time has been set to an afternoon time of ... " + editedStartTime);
        activityTime = editedStartTime.substring(editedStartTime.indexOf(' ') + 1);

        //Step : verify that the selected time is displaying in 24-hour clock format
        AssertJUnit.assertEquals("VP: selected time of '" + activityTime + "' displays with 24-hour clock - FAILED", "14:00", activityTime);
        System.out.println("VP: selected time of '" + activityTime + "' displays with 24-hour clock - PASSED");
        headerButton.clickHeaderButton("cancel");

        //Step: go to Settings, then choose to switch back to a 12-hour clock
        commNav = PageFactory.initElements(driver, CommonNavigation.class);
        commView = PageFactory.initElements(driver, CommonViewsElements.class);
        commNav.clickGlobalMenuItem("Settings");
        commNav.waitForPage("Settings");
        commView.settingsUse24HourClock.click();

        //Step: verify the message on the alert for switching back to a 12-hour clock, and press OK
        String clockMessage = "Changing the clock to 12-hour format will require an application restart. Continue?";
        Alert alert = driver.switchTo().alert();
        AssertJUnit.assertEquals("VP: message on changing from 24 hour clock to 12 hour clock of : '" + alert.getText() + "' - FAILED", clockMessage, alert.getText());
        System.out.println("VP: message on changing from 24 hour clock to 12 hour clock of : '" + alert.getText() + "' - PASSED");
        alert.accept();

        LogOutThenLogBackIn(userName, userPwd);

        //Step: client should refresh after changing the clock ... as 'remember me' is set for automation, will not see login screen, it auto refreshes
        //Step: go to Settings and ensure that 12-hour clock is in effect again
        commNav = PageFactory.initElements(driver, CommonNavigation.class);
        commView = PageFactory.initElements(driver, CommonViewsElements.class);
        commNav.clickGlobalMenuItem("Settings");
        commNav.waitForPage("Settings");
        AssertJUnit.assertEquals("VP: verify that 12-hour clock is in effect again, Settings displays ... '" + commView.settingsUse24HourClock.getText() + "' - FAILED", "Using 12-hour Clock", commView.settingsUse24HourClock.getText());
        System.out.println("VP: verify that 12-hour clock is in effect again, Settings displays ... '" + commView.settingsUse24HourClock.getText() + "' - PASSED");


        System.out.println("VP: 24-hour clock available and working - PASSED");

        System.out.println(ENDLINE);
    }


    @Test
    // INFORCRM-13623 ... one may now clear My Briefcase and Recently Viewed separately
    public void test02_INFORCRM13623() throws Exception {
        String methodID = "test02_INFORCRM13623";
        System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);

        //Step: logout & log back in (to clear cookies)
        LogOutThenLogBackIn(userName, userPwd);
        CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
        HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);
        CommonViewsElements commView = PageFactory.initElements(driver, CommonViewsElements.class);
        MyBriefcaseViewsElements briefcaseListView = PageFactory.initElements(driver, MyBriefcaseViewsElements.class);
        RecentlyViewedViewsElements recentlyViewedListView = PageFactory.initElements(driver, RecentlyViewedViewsElements.class);

        //Step: go to settings, then Offline Options ... ready to clear all offline data
        commNav.clickGlobalMenuItem("Settings");
        commNav.waitForPage("Settings");
        commView.settingsOfflineOptions.click();
        commNav.waitForPage("Offline Options");

        //Step: Offline Options ... choose to clear all offline data older than 0 days (ie: ALL offline data)
        commView.offlineDataOlderField.click();
        commNav.waitForAnimation();
        commView.offlineDataOlderZeroDays.click();
        commView.offlineDataClearBtn.click();
        WebDriverWait wait = new WebDriverWait(driver, 120);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id='busyIndicator__offlineusage']")));

        //Briefcase Account
        String entityType = "Accounts";
        String entityRecord = TEST_ACCOUNT2_RECORD;

        commNav.entityRecordOpenDetailView(entityType, entityRecord);
        headerButton.clickHeaderButton("Briefcase");
        System.out.println("VP: Account " + TEST_ACCOUNT2_RECORD + " is being briefcased");

        Thread.sleep(5000);
        driver.switchTo().activeElement();
        commView.briefcaseCompleteCancelBtn.click();
        commNav.waitForAnimation();
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
        commNav.waitForAnimation();
        driver.switchTo().activeElement();
        commNav.waitForPage(TEST_CONTACT_RECORD2);


        //Step: go to My Briefcase
        System.out.println("VP: go to My Briefcase ...");
        commNav.clickGlobalMenuItem("My Briefcase");
        commNav.waitForPage("My Briefcase");

        //Step: validate the items currently in the briefcase
        AssertJUnit.assertEquals("VP: 'briefcased' contact " + TEST_CONTACT_RECORD2 + " added to My Briefcase - FAILED", TEST_CONTACT_RECORD2, briefcaseListView.myBriefcaseDescriptionItem1.getText());
        System.out.println("VP: 'briefcased' contact " + TEST_CONTACT_RECORD2 + " added to My Briefcase - PASSED");
        AssertJUnit.assertEquals("VP: 'briefcased' account " + TEST_ACCOUNT2_RECORD + " added to My Briefcase - FAILED", TEST_ACCOUNT2_RECORD, briefcaseListView.myBriefcaseDescriptionItem2.getText());
        System.out.println("VP: 'briefcased' account " + TEST_ACCOUNT2_RECORD + " added to My Briefcase - PASSED");


        //Step: go to 'Recently Viewed'
        System.out.println("VP: go to Recently Viewed ...");
        commNav.clickGlobalMenuItem("Recently Viewed");
        commNav.waitForPage("Recently Viewed");
        commNav.waitForAnimation();

        //Step: validate the items currently under Recently Viewed
        AssertJUnit.assertEquals("VP: 'viewed' contact " + TEST_CONTACT_RECORD2 + " added to Recently Viewed - FAILED", TEST_CONTACT_RECORD2, recentlyViewedListView.recentlyViewedDescriptionItem1.getText());
        System.out.println("VP: 'viewed' contact " + TEST_CONTACT_RECORD2 + " added to Recently Viewed - PASSED");
        AssertJUnit.assertEquals("VP: 'viewed' account " + TEST_ACCOUNT2_RECORD + " added to Recently Viewed - FAILED", TEST_ACCOUNT2_RECORD, recentlyViewedListView.recentlyViewedDescriptionItem2.getText());
        System.out.println("VP: 'viewed' account " + TEST_ACCOUNT2_RECORD + " added to Recently Viewed - PASSED");


        //Step: go to settings, then Offline Options ... ready to clear all offline data from My Briefcase
        commNav.clickGlobalMenuItem("Settings");
        commNav.waitForPage("Settings");
        commView.settingsOfflineOptions.click();
        commNav.waitForPage("Offline Options");

        //Step: Offline Options ... choose to clear all offline data older than 0 days from My Briefcase
        commView.offlineDataOlderField.click();
        commNav.waitForAnimation();
        commView.offlineDataOlderZeroDays.click();
        commNav.waitForAnimation();
        System.out.println("VP: for all data older than 0 days, press Clear Briefcase");
        commView.offlineDataClearBriefcaseBtn.click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id='busyIndicator__offlineusage']")));

        //Step: verify that My Briefcase now has 'no records'
        commNav.clickGlobalMenuItem("My Briefcase");
        commNav.waitForPage("My Briefcase");
        AssertJUnit.assertEquals("VP: after clearing My Briefcase, no records appear under My Briefcase - FAILED", "no records", briefcaseListView.briefcaseNoRecords.getText());
        System.out.println("VP: after clearing My Briefcase, no records appear under My Briefcase - PASSED");

        //Step: verify that Recently Viewed still retains its items  <<<<< FAILS HERE
        recentlyViewedListView = PageFactory.initElements(driver, RecentlyViewedViewsElements.class);
        System.out.println("VP: go to Recently Viewed again ...");
        commNav.clickGlobalMenuItem("Recently Viewed");
        commNav.waitForPage("Recently Viewed");
        AssertJUnit.assertEquals("VP: 'viewed' contact " + TEST_CONTACT_RECORD2 + " still appears under Recently Viewed - FAILED", TEST_CONTACT_RECORD2, recentlyViewedListView.recentlyViewedDescriptionItem1.getText());
        System.out.println("VP: 'viewed' contact " + TEST_CONTACT_RECORD2 + " still appears under Recently Viewed - PASSED");
        AssertJUnit.assertEquals("VP: 'viewed' account " + TEST_ACCOUNT2_RECORD + " still appears under Recently Viewed - FAILED", TEST_ACCOUNT2_RECORD, recentlyViewedListView.recentlyViewedDescriptionItem2.getText());
        System.out.println("VP: 'viewed' account " + TEST_ACCOUNT2_RECORD + " still appears under Recently Viewed - PASSED");


        //Step: go to settings, then Offline Options ... ready to clear all offline data from Recently Viewed
        commView = PageFactory.initElements(driver, CommonViewsElements.class);
        commNav.clickGlobalMenuItem("Settings");
        commNav.waitForPage("Settings");
        commView.settingsOfflineOptions.click();
        commNav.waitForPage("Offline Options");

        //Step: Offline Options ... choose to clear all offline data older than 0 days from Recently Viewed
        commView.offlineDataOlderField.click();
        commNav.waitForAnimation();
        commView.offlineDataOlderZeroDays.click();
        System.out.println("VP: for all data older than 0 days, press Clear Recently Viewed");
        commNav.waitForAnimation();
        commView.offlineDataClearRecViewedBtn.click();

        //Step: verify that Recently Viewed now has 'no records'
        commNav.clickGlobalMenuItem("Recently Viewed");
        commNav.waitForPage("Recently Viewed");
        AssertJUnit.assertEquals("VP: after clearing Recently Viewed, no records appear under Recently Viewed - FAILED", "no records", recentlyViewedListView.recentlyViewedNoRecords.getText());
        System.out.println("VP: after clearing Recently Viewed, no records appear under Recently Viewed - PASSED");


        System.out.println("VP: ability to clear My Briefcase and Recently Viewed separately - PASSED");


        System.out.println(ENDLINE);
    }


    @Test
    // INFORCRM-14057 ... Mobile 3.6 - on the edit activity screen, should not see lead and company fields when 'for lead' is off
    public void test03_INFORCRM14057() throws Exception {
        String methodID = "test03_INFORCRM14057";

        System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);

        //Step: logout & log back in (to clear cookies)
        LogOutThenLogBackIn(userName, userPwd);
        CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
        HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);
        MyActivityViewsElements activityEditView = PageFactory.initElements(driver, MyActivityViewsElements.class);


        //Step: go to Calendar view ... wait for page Calendar
        commNav.clickGlobalMenuItem("Calendar");
        commNav.waitForPage("Calendar");


        //Step: click the Add header button to open Activity schedule view
        headerButton.clickHeaderButton("Add");

        //Step: wait for page Schedule... to open
        commNav.waitForPage("Schedule...");

        //Step: select Meeting for activity type
        activityEditView.activityScheduleMeetingBtn.click();

        //Step: wait for page Meeting to open
        commNav.waitForPage("Meeting");

        //Step: Lead defaults to off, toggle it on and back off
        activityEditView.activityEditViewForLeadTgl.click();
        commNav.waitForAnimation();
        activityEditView.activityEditViewForLeadTgl.click();
        commNav.waitForAnimation();

        //Step: verify that field lead do not display where 'for lead' is off
        if (activityEditView.activityEditViewLeadFld.isDisplayed()) {
            System.out.println("VP: on the edit activity screen, should not see lead and company fields when 'for lead' is off - FAILED");
            AssertJUnit.fail("test failed");
        } else {
            System.out.println("VP: on the edit activity screen, should not see lead field when 'for lead' is off - PASSED");
        }

        //Step: verify that field company do not display where 'for lead' is off
        if (activityEditView.activityEditViewCompanyFld.isDisplayed()) {
            System.out.println("VP: on the edit activity screen, should not see company fields when 'for lead' is off - FAILED");
            AssertJUnit.fail("test failed");
        } else {
            System.out.println("VP: on the edit activity screen, should not see lead and company field when 'for lead' is off - PASSED");
        }

        System.out.println(ENDLINE);
    }


    @Test(enabled = false)
    // INFORCRM-4262 ... Field Level Security
    //
    // requires manual setup ...
    // - new security profile 'Test Profile' with
    //   Account : Industry, MainPhone, WebAddress set to 'Read Only'
    //   Contact : Email and WorkPhone set to 'No Access'
    // - new user 'penny' (copy of loup), with no password
    //   each associated team has security set to 'Test Profile'
    //   Roles set to 'Standard User'

    public void test04_INFORCRM4262() throws Exception {
        String methodID = "test04_INFORCRM4262";

        System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
        LogOutThenLogBackIn("penny", userPwd);
        CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
        HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);

        String entityType = "Accounts";
        String entityRecord = TEST_ACCOUNT_RECORD;

        //Step: search for Account entity, then open it's Detail view
        commNav.entityRecordOpenDetailView(entityType, entityRecord);

        AccountViewsElements accountDetailView = PageFactory.initElements(driver, AccountViewsElements.class);

        //Step: verify that 'phone' (Read Only security) does display under the Details section
        commNav.highlightNClick(accountDetailView.accountDetailViewDetailsTab);

        if (accountDetailView.accountDetailViewCallMainNumberLnk.isDisplayed()) {
            System.out.println("VP: 'phone' which has 'Read Only' security should display on Account detail view - PASSED");
        } else {
            System.out.println("VP: 'phone' which has 'Read Only' security should display on Account detail view - FAILED");
            AssertJUnit.fail("test failed");
        }


        // Step: verify that 'web' (Read Only security) does display under the More Details section
        commNav.highlightNClick(accountDetailView.accountDetailViewMoreDetailsTab);

        if (accountDetailView.accountDetailViewWebFld.isDisplayed()) {
            System.out.println("VP: 'web' which has 'Read Only' security should display on Account detail view - PASSED");
        } else {
            System.out.println("VP: 'web' which has 'Read Only' security should display on Account detail view - FAILED");
            AssertJUnit.fail("test failed");
        }

        // Step: verify that 'industry' (Read Only security) does display under the More Details section
        if (accountDetailView.accountDetailViewIndustryFld.isDisplayed()) {
            System.out.println("VP: 'industry' which has 'Read Only' security should display on Account detail view - PASSED");
        } else {
            System.out.println("VP: 'industry' which has 'Read Only' security should display on Account detail view - FAILED");
            AssertJUnit.fail("test failed");
        }

        //Step: open the Account edit view, to verify that phone, web and industry fields (Read Only security) are disabled
        headerButton.clickHeaderButton("edit");
        commNav.waitForPage("Account");

        AccountViewsElements accountEditView = PageFactory.initElements(driver, AccountViewsElements.class);

        if (accountEditView.accountEditViewWebInputFld.isEnabled()) {
            System.out.println("VP: 'web' which has 'Read Only' security should be disabled on Account edit view - FAILED");
            AssertJUnit.fail("test failed");
        } else {
            System.out.println("VP: 'web' which has 'Read Only' security should be disabled on Account edit view - PASSED");
        }

        if (accountEditView.accountEditViewPhoneInputFld.isEnabled()) {
            System.out.println("VP: 'phone' which has 'Read Only' security should be disabled on Account edit view - FAILED");
            AssertJUnit.fail("test failed");
        } else {
            System.out.println("VP: 'phone' which has 'Read Only' security should be disabled on Account edit view - PASSED");
        }

        if (accountEditView.accountEditViewIndustryFld.isEnabled()) {
            System.out.println("VP: 'industry' which has 'Read Only' security should be disabled on Account edit view - FAILED");
            AssertJUnit.fail("test failed");
        } else {
            System.out.println("VP: 'industry' which has 'Read Only' security should be disabled on Account edit view - PASSED");
        }


        //Step: search for Contact entity, then open its Detail view
        entityType = "Contacts";
        String contactRecord = TEST_CONTACT_RECORD;
        commNav.entityRecordOpenDetailView(entityType, contactRecord);

        ContactViewsElements contactDetailView = PageFactory.initElements(driver, ContactViewsElements.class);

        //Step: on the Contact Detail View, verify that the 'Call work' and 'Send email' Quick Actions do not display

        if (!contactDetailView.contactsDetailViewCallMainNumberLnk.isDisplayed() && !contactDetailView.contactsDetailViewSendEmailLnk.isDisplayed()) {
            System.out.println("VP: 'Call work' and 'Send email' ('No Access' security) quick actions should not display on Contact detail view - PASSED");
        } else {
            System.out.println("VP: 'Call work' and 'Send email' ('No Access' security) quick actions should not display on Contact detail view - FAILED");
            AssertJUnit.fail("test failed");
        }


        //Step: verify that 'work phone' (No Access security) does not display under the Contact Details section
        commNav.highlightNClick(contactDetailView.contactDetailViewDetailsTab);

        if (!contactDetailView.contactsDetailViewWorkPhoneFld.isDisplayed()) {
            System.out.println("VP: 'work phone' which has 'No Access' security should not display on Contact detail view - PASSED");
        } else {
            System.out.println("VP: 'work phone' which has 'No Access' security should not display on Contact detail view - FAILED");
            AssertJUnit.fail("test failed");
        }


        //Step: open the Contact edit view, to verify that work phone and email fields (No Access security) do not display
        headerButton.clickHeaderButton("edit");
        commNav.waitForPage("Contact");

        ContactViewsElements contactEditView = PageFactory.initElements(driver, ContactViewsElements.class);

        if (!contactEditView.contactsEditViewPhoneInputFld.isDisplayed()) {
            System.out.println("VP: 'work phone' which has 'No Access' security should not display on Contact edit view - PASSED");
        } else {
            System.out.println("VP: 'work phone' which has 'No Access' security should not display on Contact edit view - FAILED");
            AssertJUnit.fail("test failed");
        }

        if (!contactEditView.contactsEditViewEmailInputFld.isDisplayed()) {
            System.out.println("VP: 'email' which has 'No Access' security should not display on Contact edit view - PASSED");
        } else {
            System.out.println("VP: 'email' which has 'No Access' security should not display on Contact edit view - FAILED");
            AssertJUnit.fail("test failed");
        }

        System.out.println(ENDLINE);

    }
}
