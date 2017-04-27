package argos.saleslogix.selenium.test;

import argos.saleslogix.selenium.pages.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import java.util.List;


/**
 * @author Kathy Lockyer-Bratton
 *         Class: MobileSprint340
 *         Desc.: Test class for some defects or features in Mobile 3.4.0
 */
public class MobileSprint340 extends BaseTest {


    //Test Methods Set
    //================


    @Test(enabled = true)
    // INFORCRM-4569 ... My Activities : on creating an activity, without first selecting an account, press the Contact lookup to ensure that this may be opened correctly

    public void test01_INFORCRM4569() throws Exception {
        String methodID = "test01_INFORCRM4569";

        CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
        CommonViewsElements commView = PageFactory.initElements(driver, CommonViewsElements.class);
        HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);
        MyActivityViewsElements activityEditView = PageFactory.initElements(driver, MyActivityViewsElements.class);
        MiscEntityItemViewsElements miscView = PageFactory.initElements(driver, MiscEntityItemViewsElements.class);
        AccountViewsElements accountListView = PageFactory.initElements(driver, AccountViewsElements.class);


        System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);

        try {


            //Step: logout & log back in (to clear cookies)
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

            //Step: press the Contact lookup to ensure that this may be opened correctly without first selecting an account
            activityEditView.activityEditViewContactBtn.click();
            commNav.waitForPage("Contacts");

            //Step: verify that the Contacts screen is displaying
            AssertJUnit.assertEquals("VP: able to open Contacts lookup with no account chosen first - FAILED", "Contacts", driver.findElement(By.id("pageTitle")).getText());
            System.out.println("VP: able to open Contacts lookup with no account chosen first - PASSED");

        } catch (Exception e) {
            verificationErrors.append(methodID + "(): " + e.toString());
            System.out.println("VP: able to open Contacts lookup with no account chosen first - FAILED");
            AssertJUnit.fail("test failed");
        }

        System.out.println(ENDLINE);
    }


    @Test(enabled = true)
    // INFORCRM-4861 ... Calendar modal control ... relative dates
    public void test02_INFORCRM4861() throws Exception {
        String methodID = "test02_INFORCRM4861";

        CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
        HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);
        MyActivityViewsElements activityEditView = PageFactory.initElements(driver, MyActivityViewsElements.class);
        CalendarViewsElements calendarView = PageFactory.initElements(driver, CalendarViewsElements.class);

        String viewName = "Modal Calendar";


        System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);

        try {


            //Step: logout & log back in (to clear cookies)
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

            //Step: wait for page Meeting to open, and store default value of 'start time'
            commNav.waitForPage("Meeting");
            String defaultStartTime = activityEditView.activityEditViewStartTimeFld.getAttribute("value");

            //Step: Open Start Time calendar, and wait for modal calendar control to open
            activityEditView.activityEditViewStartTimeFldBtn.click();
            Thread.sleep(1000);
            driver.switchTo().activeElement();

            //Verify that the relative date elements on the modal Calendar control are present
            commNav.isWebElementPresent(viewName + ",Relative Date title", calendarView.calendarModalRelativeDateTitle);

            //First check if 'This Evening' displays ... it will not after a certain time of day
            List elements = driver.findElements(By.xpath("//ul//li//div[contains(., 'This Evening')]"));

            if (elements.size() > 0) {
                commNav.isWebElementPresent(viewName + ",This Evening title", calendarView.calendarModalThisEveningTitle);
                commNav.isWebElementPresent(viewName + ",This Evening value", calendarView.calendarModalThisEveningValue);
            }

            commNav.isWebElementPresent(viewName + ",Tomorrow Morning title", calendarView.calendarModalTomorrowMorningTitle);
            commNav.isWebElementPresent(viewName + ",Tomorrow Morning value", calendarView.calendarModalTomorrowMorningValue);
            commNav.isWebElementPresent(viewName + ",Tomorrow Evening title", calendarView.calendarModalTomorrowEveningTitle);
            commNav.isWebElementPresent(viewName + ",Tomorrow Evening value", calendarView.calendarModalTomorrowEveningValue);
            commNav.isWebElementPresent(viewName + ",Next Week title", calendarView.calendarModalNextWeekTitle);
            commNav.isWebElementPresent(viewName + ",Next Week value", calendarView.calendarModalNextWeekValue);
            commNav.isWebElementPresent(viewName + ",Next Month title", calendarView.calendarModalNextMonthTitle);
            commNav.isWebElementPresent(viewName + ",Next Month value", calendarView.calendarModalNextMonthValue);
            commNav.isWebElementPresent(viewName + ",Cancel button", calendarView.calendarModalCancel);
            commNav.isWebElementPresent(viewName + ",Advanced button", calendarView.calendarModalAdvanced);

            //Choose Relative date of 'This Evening', if it is displaying, and display the date/ time
            if (elements.size() > 0) {
                calendarView.calendarModalThisEveningTitle.click();
                Thread.sleep(1000);
                driver.switchTo().activeElement();
                commNav.waitForPage("Meeting");
                String thisEveningStartTime = activityEditView.activityEditViewStartTimeFld.getAttribute("value");
                System.out.println("VP: default value for 'start time' is ... " + defaultStartTime + " and for 'This Evening' is ... " + thisEveningStartTime);
            }

            //Step: Open Start Time calendar, and wait for modal calendar control to open
            activityEditView.activityEditViewStartTimeFldBtn.click();
            Thread.sleep(1000);
            driver.switchTo().activeElement();

            //Choose Relative date of 'Tomorrow Morning' and display the date/ time
            calendarView = PageFactory.initElements(driver, CalendarViewsElements.class);
            calendarView.calendarModalTomorrowMorningTitle.click();
            Thread.sleep(1000);
            driver.switchTo().activeElement();
            commNav.waitForPage("Meeting");
            String tomorrowMorningStartTime = activityEditView.activityEditViewStartTimeFld.getAttribute("value");
            System.out.println("VP: default value for 'start time' is ... " + defaultStartTime + " and for 'Tomorrow Morning' is ... " + tomorrowMorningStartTime);

            //Step: Open Start Time calendar, and wait for modal calendar control to open
            activityEditView.activityEditViewStartTimeFldBtn.click();
            Thread.sleep(1000);
            driver.switchTo().activeElement();

            //Choose Relative date of 'Tomorrow Evening' and display the date/ time
            calendarView.calendarModalTomorrowEveningTitle.click();
            Thread.sleep(1000);
            driver.switchTo().activeElement();
            commNav.waitForPage("Meeting");
            String tomorrowEveningStartTime = activityEditView.activityEditViewStartTimeFld.getAttribute("value");
            System.out.println("VP: default value for 'start time' is ... " + defaultStartTime + " and for 'Tomorrow Evening' is ... " + tomorrowEveningStartTime);

            //Step: Open Start Time calendar, and wait for modal calendar control to open
            activityEditView.activityEditViewStartTimeFldBtn.click();
            Thread.sleep(1000);
            driver.switchTo().activeElement();

            //Choose Relative date of 'Next Week' and display the date/ time
            calendarView.calendarModalNextWeekTitle.click();
            Thread.sleep(1000);
            driver.switchTo().activeElement();
            commNav.waitForPage("Meeting");
            String nextWeekStartTime = activityEditView.activityEditViewStartTimeFld.getAttribute("value");
            System.out.println("VP: default value for 'start time' is ... " + defaultStartTime + " and for 'Next Week' is ... " + nextWeekStartTime);

            //Step: Open Start Time calendar, and wait for modal calendar control to open
            activityEditView.activityEditViewStartTimeFldBtn.click();
            Thread.sleep(1000);
            driver.switchTo().activeElement();

            //Choose Relative date of 'Next Month' and display the date/ time
            calendarView.calendarModalNextMonthTitle.click();
            Thread.sleep(1000);
            driver.switchTo().activeElement();
            commNav.waitForPage("Meeting");
            String nextMonthStartTime = activityEditView.activityEditViewStartTimeFld.getAttribute("value");
            System.out.println("VP: default value for 'start time' is ... " + defaultStartTime + " and for 'Next Month' is ... " + nextMonthStartTime);

            System.out.println("VP: Modal Calendar relative date/time functionality - PASSED");

        } catch (Exception e) {
            verificationErrors.append(methodID + "(): " + e.toString());
            System.out.println("VP: Modal Calendar relative date/time functionality - FAILED");
            AssertJUnit.fail("test failed");
        }

        System.out.println(ENDLINE);
    }


    @Test(enabled = true)
    // INFORCRM-4861 ... Calendar modal control ... calendar/ time selection
    public void test03_INFORCRM4861() throws Exception {
        String methodID = "test03_INFORCRM4861";

        CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
        HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);
        MyActivityViewsElements activityEditView = PageFactory.initElements(driver, MyActivityViewsElements.class);
        CalendarViewsElements calendarView = PageFactory.initElements(driver, CalendarViewsElements.class);

        String viewName = "Modal Calendar";


        System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);

        try {


            //Step: logout & log back in (to clear cookies)
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
            Thread.sleep(1000);
            driver.switchTo().activeElement();

            //Press Advanced button to open Calendar view
            calendarView.calendarModalAdvanced.click();

            // Verify that the current month and year are present and display their values
            String currentMonth = calendarView.calendarModalCurrMonthValue.getAttribute("value");
            commNav.isWebElementPresent(viewName + ", Current Month value", calendarView.calendarModalCurrMonthValue);
            commNav.isWebElementPresent(viewName + ", Current Year value", calendarView.calendarModalCurrYearValue);
            System.out.println("VP: value for current Month is ... " + calendarView.calendarModalCurrMonthValue.getAttribute("value"));
            System.out.println("VP: value for current Year is ... " + calendarView.calendarModalCurrYearValue.getAttribute("value"));

            //Click the month forward button and check next month
            calendarView.calendarModalIncrMonth.click();
            calendarView = PageFactory.initElements(driver, CalendarViewsElements.class);
            System.out.println("VP: value for next Month is ... " + calendarView.calendarModalCurrMonthValue.getAttribute("value"));
            System.out.println("VP: value for associated Year is ... " + calendarView.calendarModalCurrYearValue.getAttribute("value"));

            //Click the Today button to again display the current month
            calendarView.calendarModalTodayBtn.click();
            AssertJUnit.assertEquals("VP: Pressing Today button to return to current month - FAILED", currentMonth, calendarView.calendarModalCurrMonthValue.getAttribute("value"));
            System.out.println("VP: Pressing Today button to return to current month - PASSED");

            //Click the month back button and check the previous month
            calendarView.calendarModalDecrMonth.click();
            System.out.println("VP: value for previous Month is ... " + calendarView.calendarModalCurrMonthValue.getAttribute("value"));
            System.out.println("VP: value for associated Year is ... " + calendarView.calendarModalCurrYearValue.getAttribute("value"));


            //Verify that the days of the week are displaying
            commNav.isWebElementPresent(viewName + ", Day of Week - Sunday", calendarView.calendarModalDayOfWeekSunday);
            commNav.isWebElementPresent(viewName + ", Day of Week - Monday", calendarView.calendarModalDayOfWeekMonday);
            commNav.isWebElementPresent(viewName + ", Day of Week - Tuesday", calendarView.calendarModalDayOfWeekTuesday);
            commNav.isWebElementPresent(viewName + ", Day of Week - Wednesday", calendarView.calendarModalDayOfWeekWednesday);
            commNav.isWebElementPresent(viewName + ", Day of Week - Thursday", calendarView.calendarModalDayOfWeekThursday);
            commNav.isWebElementPresent(viewName + ", Day of Week - Friday", calendarView.calendarModalDayOfWeekFriday);
            commNav.isWebElementPresent(viewName + ", Day of Week - Saturday", calendarView.calendarModalDayOfWeekSaturday);

            //Verify the month dropdown is as expected
            calendarView.calendarModalCurrMonthValue.click();
            commNav.isWebElementPresent(viewName + ", Month - January", calendarView.calendarModalMonthJan);
            commNav.isWebElementPresent(viewName + ", Month - February", calendarView.calendarModalMonthFeb);
            commNav.isWebElementPresent(viewName + ", Month - March", calendarView.calendarModalMonthMar);
            commNav.isWebElementPresent(viewName + ", Month - April", calendarView.calendarModalMonthApr);
            commNav.isWebElementPresent(viewName + ", Month - May", calendarView.calendarModalMonthMay);
            commNav.isWebElementPresent(viewName + ", Month - June", calendarView.calendarModalMonthJun);
            commNav.isWebElementPresent(viewName + ", Month - July", calendarView.calendarModalMonthJul);
            commNav.isWebElementPresent(viewName + ", Month - August", calendarView.calendarModalMonthAug);
            commNav.isWebElementPresent(viewName + ", Month - September", calendarView.calendarModalMonthSep);
            commNav.isWebElementPresent(viewName + ", Month - October", calendarView.calendarModalMonthOct);
            commNav.isWebElementPresent(viewName + ", Month - November", calendarView.calendarModalMonthNov);
            commNav.isWebElementPresent(viewName + ", Month - December", calendarView.calendarModalMonthDec);

            //Verify the year dropdown is as expected
            String calendarCurrentYear = calendarView.calendarModalCurrYearValue.getAttribute("value");
            calendarView.calendarModalCurrYearValue.click();
            String calendarYearLowRange = calendarView.calendarModalYearTopItem.getText();
            String calendarYearHighRange = calendarView.calendarModalYearBottomItem.getText();
            System.out.println("VP: Current Year is ... " + calendarCurrentYear + " : Year Range is from ... " + calendarYearLowRange + " to " + calendarYearHighRange);

            //Verify the hour dropdown is as expected
            calendarView.calendarHourField.click();
            commNav.isWebElementPresent(viewName + ", Hour - 1", calendarView.calendarHourOne);
            commNav.isWebElementPresent(viewName + ", Hour - 2", calendarView.calendarHourTwo);
            commNav.isWebElementPresent(viewName + ", Hour - 3", calendarView.calendarHourThree);
            commNav.isWebElementPresent(viewName + ", Hour - 4", calendarView.calendarHourFour);
            commNav.isWebElementPresent(viewName + ", Hour - 5", calendarView.calendarHourFive);
            commNav.isWebElementPresent(viewName + ", Hour - 6", calendarView.calendarHourSix);
            commNav.isWebElementPresent(viewName + ", Hour - 7", calendarView.calendarHourSeven);
            commNav.isWebElementPresent(viewName + ", Hour - 8", calendarView.calendarHourEight);
            commNav.isWebElementPresent(viewName + ", Hour - 9", calendarView.calendarHourNine);
            commNav.isWebElementPresent(viewName + ", Hour - 10", calendarView.calendarHourTen);
            commNav.isWebElementPresent(viewName + ", Hour - 11", calendarView.calendarHourEleven);
            commNav.isWebElementPresent(viewName + ", Hour - 12", calendarView.calendarHourTwelve);

            //Verify the minute dropdown is as expected
            calendarView.calendarMinuteField.click();
            commNav.isWebElementPresent(viewName + ", Minutes - 00", calendarView.calendarMinute00);
            commNav.isWebElementPresent(viewName + ", Minutes - 05", calendarView.calendarMinute05);
            commNav.isWebElementPresent(viewName + ", Minutes - 10", calendarView.calendarMinute10);
            commNav.isWebElementPresent(viewName + ", Minutes - 15", calendarView.calendarMinute15);
            commNav.isWebElementPresent(viewName + ", Minutes - 20", calendarView.calendarMinute20);
            commNav.isWebElementPresent(viewName + ", Minutes - 25", calendarView.calendarMinute25);
            commNav.isWebElementPresent(viewName + ", Minutes - 30", calendarView.calendarMinute30);
            commNav.isWebElementPresent(viewName + ", Minutes - 35", calendarView.calendarMinute35);
            commNav.isWebElementPresent(viewName + ", Minutes - 40", calendarView.calendarMinute40);
            commNav.isWebElementPresent(viewName + ", Minutes - 45", calendarView.calendarMinute45);
            commNav.isWebElementPresent(viewName + ", Minutes - 50", calendarView.calendarMinute50);
            commNav.isWebElementPresent(viewName + ", Minutes - 55", calendarView.calendarMinute55);


            //Step: cancel to close the calendar modal control
            //calendarView.calendarModalCancel.click();

            //Thread.sleep(1000);
            //driver.switchTo().activeElement();
            //commNav.waitForPage("Meeting");

            System.out.println("VP: Modal Calendar/ time select control functionality - PASSED");

        } catch (Exception e) {
            verificationErrors.append(methodID + "(): " + e.toString());
            System.out.println("VP: Modal Calendar/ time select control functionality - FAILED");
            AssertJUnit.fail("test failed");
        }

        System.out.println(ENDLINE);
    }


    @Test(enabled = true)
    // INFORCRM-4861 ... Calendar screen
    public void test04_INFORCRM4861() throws Exception {
        String methodID = "test04_INFORCRM4861";

        CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
        HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);
        MyActivityViewsElements activityEditView = PageFactory.initElements(driver, MyActivityViewsElements.class);
        CalendarViewsElements calendarView = PageFactory.initElements(driver, CalendarViewsElements.class);

        String viewName = "Calendar Screen";


        System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);

        try {


            //Step: logout & log back in (to clear cookies)
            LogOutThenLogBackIn(userName, userPwd);


            //Step: go to Calendar view ... wait for page Calendar
            commNav.clickGlobalMenuItem("Calendar");
            commNav.waitForPage("Calendar");

            // Verify that the current month and year are present and display their values
            String currentMonth = calendarView.calendarMonthField.getAttribute("value");
            commNav.isWebElementPresent(viewName + ",Current Month value", calendarView.calendarMonthField);
            commNav.isWebElementPresent(viewName + ",Current Year value", calendarView.calendarYearField);
            System.out.println("VP: value for current Month is ... " + calendarView.calendarMonthField.getAttribute("value"));
            System.out.println("VP: value for current Year is ... " + calendarView.calendarYearField.getAttribute("value"));

            //Click the month forward button and check next month
            calendarView.calendarIncrementMonthBtn.click();
            calendarView = PageFactory.initElements(driver, CalendarViewsElements.class);
            System.out.println("VP: value for next Month is ... " + calendarView.calendarMonthField.getAttribute("value"));
            System.out.println("VP: value for associated Year is ... " + calendarView.calendarYearField.getAttribute("value"));

            //Click the Today button to again display the current month
            calendarView.calendarTodayBtn.click();
            AssertJUnit.assertEquals("VP: Pressing Today button to return to current month - FAILED", currentMonth, calendarView.calendarMonthField.getAttribute("value"));
            System.out.println("VP: Pressing Today button to return to current month - PASSED");

            //Click the month back button and check the previous month
            calendarView.calendarDecrementMonthBtn.click();
            System.out.println("VP: value for previous Month is ... " + calendarView.calendarMonthField.getAttribute("value"));
            System.out.println("VP: value for associated Year is ... " + calendarView.calendarYearField.getAttribute("value"));


            //Verify that the days of the week are displaying
            commNav.isWebElementPresent(viewName + ",Day of Week - Sunday", calendarView.calendarDayOfWeekSunday);
            commNav.isWebElementPresent(viewName + ",Day of Week - Monday", calendarView.calendarDayOfWeekMonday);
            commNav.isWebElementPresent(viewName + ",Day of Week - Tuesday", calendarView.calendarDayOfWeekTuesday);
            commNav.isWebElementPresent(viewName + ",Day of Week - Wednesday", calendarView.calendarDayOfWeekWednesday);
            commNav.isWebElementPresent(viewName + ",Day of Week - Thursday", calendarView.calendarDayOfWeekThursday);
            commNav.isWebElementPresent(viewName + ",Day of Week - Friday", calendarView.calendarDayOfWeekFriday);
            commNav.isWebElementPresent(viewName + ",Day of Week - Saturday", calendarView.calendarDayOfWeekSaturday);

            //Verify the month dropdown is as expected
            calendarView.calendarMonthField.click();
            commNav.isWebElementPresent(viewName + ",Month - January", calendarView.calendarMonthJan);
            commNav.isWebElementPresent(viewName + ",Month - February", calendarView.calendarMonthFeb);
            commNav.isWebElementPresent(viewName + ",Month - March", calendarView.calendarMonthMar);
            commNav.isWebElementPresent(viewName + ",Month - April", calendarView.calendarMonthApr);
            commNav.isWebElementPresent(viewName + ",Month - May", calendarView.calendarMonthMay);
            commNav.isWebElementPresent(viewName + ",Month - June", calendarView.calendarMonthJun);
            commNav.isWebElementPresent(viewName + ",Month - July", calendarView.calendarMonthJul);
            commNav.isWebElementPresent(viewName + ",Month - August", calendarView.calendarMonthAug);
            commNav.isWebElementPresent(viewName + ",Month - September", calendarView.calendarMonthSep);
            commNav.isWebElementPresent(viewName + ",Month - October", calendarView.calendarMonthOct);
            commNav.isWebElementPresent(viewName + ",Month - November", calendarView.calendarMonthNov);
            commNav.isWebElementPresent(viewName + ",Month - December", calendarView.calendarMonthDec);

            //Verify the year dropdown is as expected
            String calendarCurrentYear = calendarView.calendarYearField.getAttribute("value");
            calendarView.calendarYearField.click();
            String calendarYearLowRange = calendarView.calendarYearTopItem.getText();
            String calendarYearHighRange = calendarView.calendarYearBottomItem.getText();
            System.out.println("VP: Current Year is ... " + calendarCurrentYear + " : Year Range is from ... " + calendarYearLowRange + " to " + calendarYearHighRange);


            //Step: check the day/ week toggle
            calendarView.calendarWeekToggle.click();
            List<WebElement> allElements = driver.findElements(By.xpath("//tr[@class='calendar-week']//td[contains(@class, 'selected')]"));
            AssertJUnit.assertEquals("VP: Calendar - pressing the week toggle should select 7 days of the week - FAILED", 7, allElements.size());
            System.out.println("VP: Calendar - pressing the week toggle should select 7 days of the week - PASSED");

            for (WebElement element : allElements) {
                System.out.println("Day of month selected - " + element.getText() + " " + calendarView.calendarMonthField.getAttribute("value") + " " + calendarView.calendarYearField.getAttribute("value"));
            }


            System.out.println("VP: Calendar screen functionality - PASSED");


        } catch (Exception e) {
            verificationErrors.append(methodID + "(): " + e.toString());
            System.out.println("VP: Calendar screen functionality - FAILED");
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
    public void test99_Mobile_LogOut() throws InterruptedException {
        String methodID = "test99_Mobile_LogOut";

        System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);

        doVerificationLogout();

        System.out.println(ENDLINE);
    }
}
