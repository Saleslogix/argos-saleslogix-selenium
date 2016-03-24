package argos.saleslogix.selenium.test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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
 * Class: MobileSprint341A
 * Desc.: Test class for some defects or features in Mobile 3.4.1
 */
public class MobileSprint341A extends BaseTest {

    public String TEST_CONTACT_RECORD = "Abbott, John";
    public String TEST_OPPORTUNITY_RECORD = "Vegas Vision-Phase1";
    public String TEST_TICKET_RECORD = "001-00-000014";
	
	//Test Methods Set
	//================


    @Test(enabled = true)
    // INFORCRM-8810 ... Calendar modal control ... unable to set minutes to 00 or 05 from the Advanced view
    // Add additional checking to verify that all hours and minutes selected from the dropdowns display in the hour/ minute fields respectively
    public void test01_INFORCRM8810() throws Exception {
        String methodID = "test01_INFORCRM8810";

        CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
        HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);
        MyActivityViewsElements activityEditView = PageFactory.initElements(driver, MyActivityViewsElements.class);
        CalendarViewsElements calendarView = PageFactory.initElements(driver, CalendarViewsElements.class);

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


            //Verify that the HOUR value chosen from the dropdown displays in the field
            calendarView.calendarHourField.click();
            calendarView.calendarHourOne.click();
            String currentHour = "1";
            System.out.println("Hours value is ... " + calendarView.calendarHourField.getAttribute("value"));
            AssertJUnit.assertEquals("VP: Pressing '1' hour from dropdown displays that value in the hours field - FAILED", currentHour, calendarView.calendarHourField.getAttribute("value"));
            System.out.println("VP: Pressing '1' hour from dropdown displays that value in the hours field - PASSED");

            calendarView.calendarHourField.click();
            calendarView.calendarHourTwo.click();
            currentHour = "2";
            System.out.println("Hours value is ... " + calendarView.calendarHourField.getAttribute("value"));
            AssertJUnit.assertEquals("VP: Pressing '2' hours from dropdown displays that value in the hours field - FAILED", currentHour, calendarView.calendarHourField.getAttribute("value"));
            System.out.println("VP: Pressing '2' hours from dropdown displays that value in the hours field - PASSED");

            calendarView.calendarHourField.click();
            calendarView.calendarHourThree.click();
            currentHour = "3";
            System.out.println("Hours value is ... " + calendarView.calendarHourField.getAttribute("value"));
            AssertJUnit.assertEquals("VP: Pressing '3' hours from dropdown displays that value in the hours field - FAILED", currentHour, calendarView.calendarHourField.getAttribute("value"));
            System.out.println("VP: Pressing '3' hours from dropdown displays that value in the hours field - PASSED");

            calendarView.calendarHourField.click();
            calendarView.calendarHourFour.click();
            currentHour = "4";
            System.out.println("Hours value is ... " + calendarView.calendarHourField.getAttribute("value"));
            AssertJUnit.assertEquals("VP: Pressing '4' hours from dropdown displays that value in the hours field - FAILED", currentHour, calendarView.calendarHourField.getAttribute("value"));
            System.out.println("VP: Pressing '4' hours from dropdown displays that value in the hours field - PASSED");

            calendarView.calendarHourField.click();
            calendarView.calendarHourFive.click();
            currentHour = "5";
            System.out.println("Hours value is ... " + calendarView.calendarHourField.getAttribute("value"));
            AssertJUnit.assertEquals("VP: Pressing '5' hours from dropdown displays that value in the hours field - FAILED", currentHour, calendarView.calendarHourField.getAttribute("value"));
            System.out.println("VP: Pressing '5' hours from dropdown displays that value in the hours field - PASSED");

            calendarView.calendarHourField.click();
            calendarView.calendarHourSix.click();
            currentHour = "6";
            System.out.println("Hours value is ... " + calendarView.calendarHourField.getAttribute("value"));
            AssertJUnit.assertEquals("VP: Pressing '6' hours from dropdown displays that value in the hours field - FAILED", currentHour, calendarView.calendarHourField.getAttribute("value"));
            System.out.println("VP: Pressing '6' hours from dropdown displays that value in the hours field - PASSED");

            calendarView.calendarHourField.click();
            calendarView.calendarHourSeven.click();
            currentHour = "7";
            System.out.println("Hours value is ... " + calendarView.calendarHourField.getAttribute("value"));
            AssertJUnit.assertEquals("VP: Pressing '7' hours from dropdown displays that value in the hours field - FAILED", currentHour, calendarView.calendarHourField.getAttribute("value"));
            System.out.println("VP: Pressing '7' hours from dropdown displays that value in the hours field - PASSED");

            calendarView.calendarHourField.click();
            calendarView.calendarHourEight.click();
            currentHour = "8";
            System.out.println("Hours value is ... " + calendarView.calendarHourField.getAttribute("value"));
            AssertJUnit.assertEquals("VP: Pressing '8' hours from dropdown displays that value in the hours field - FAILED", currentHour, calendarView.calendarHourField.getAttribute("value"));
            System.out.println("VP: Pressing '8' hours from dropdown displays that value in the hours field - PASSED");

            calendarView.calendarHourField.click();
            calendarView.calendarHourNine.click();
            currentHour = "9";
            System.out.println("Hours value is ... " + calendarView.calendarHourField.getAttribute("value"));
            AssertJUnit.assertEquals("VP: Pressing '9' hours from dropdown displays that value in the hours field - FAILED", currentHour, calendarView.calendarHourField.getAttribute("value"));
            System.out.println("VP: Pressing '9' hours from dropdown displays that value in the hours field - PASSED");

            calendarView.calendarHourField.click();
            calendarView.calendarHourTen.click();
            currentHour = "10";
            System.out.println("Hours value is ... " + calendarView.calendarHourField.getAttribute("value"));
            AssertJUnit.assertEquals("VP: Pressing '10' hours from dropdown displays that value in the hours field - FAILED", currentHour, calendarView.calendarHourField.getAttribute("value"));
            System.out.println("VP: Pressing '10' hours from dropdown displays that value in the hours field - PASSED");

            calendarView.calendarHourField.click();
            calendarView.calendarHourEleven.click();
            currentHour = "11";
            System.out.println("Hours value is ... " + calendarView.calendarHourField.getAttribute("value"));
            AssertJUnit.assertEquals("VP: Pressing '11' hours from dropdown displays that value in the hours field - FAILED", currentHour, calendarView.calendarHourField.getAttribute("value"));
            System.out.println("VP: Pressing '11' hours from dropdown displays that value in the hours field - PASSED");

            calendarView.calendarHourField.click();
            calendarView.calendarHourTwelve.click();
            currentHour = "12";
            System.out.println("Hours value is ... " + calendarView.calendarHourField.getAttribute("value"));
            AssertJUnit.assertEquals("VP: Pressing '12' hours from dropdown displays that value in the hours field - FAILED", currentHour, calendarView.calendarHourField.getAttribute("value"));
            System.out.println("VP: Pressing '12' hours from dropdown displays that value in the hours field - PASSED");


            //Verify that the MINUTE value chosen from the dropdown displays in the field
            calendarView.calendarMinuteField.click();
            calendarView.calendarMinute00.click();
            String currentMinute = "00";
            System.out.println("Minutes value is ... " + calendarView.calendarMinuteField.getAttribute("value"));
            AssertJUnit.assertEquals("VP: Pressing '00' minutes from dropdown displays that value in the minutes field - FAILED", currentMinute, calendarView.calendarMinuteField.getAttribute("value"));
            System.out.println("VP: Pressing '00' minutes from dropdown displays that value in the minutes field - PASSED");

            calendarView.calendarMinuteField.click();
            calendarView.calendarMinute05.click();
            currentMinute = "05";
            System.out.println("Minutes value is ... " + calendarView.calendarMinuteField.getAttribute("value"));
            AssertJUnit.assertEquals("VP: Pressing '05' minutes from dropdown displays that value in the minutes field - FAILED", currentMinute, calendarView.calendarMinuteField.getAttribute("value"));
            System.out.println("VP: Pressing '05' minutes from dropdown displays that value in the minutes field - PASSED");

            calendarView.calendarMinuteField.click();
            calendarView.calendarMinute10.click();
            currentMinute = "10";
            System.out.println("Minutes value is ... " + calendarView.calendarMinuteField.getAttribute("value"));
            AssertJUnit.assertEquals("VP: Pressing '10' minutes from dropdown displays that value in the minutes field - FAILED", currentMinute, calendarView.calendarMinuteField.getAttribute("value"));
            System.out.println("VP: Pressing '10' minutes from dropdown displays that value in the minutes field - PASSED");

            calendarView.calendarMinuteField.click();
            calendarView.calendarMinute15.click();
            currentMinute = "15";
            System.out.println("Minutes value is ... " + calendarView.calendarMinuteField.getAttribute("value"));
            AssertJUnit.assertEquals("VP: Pressing '15' minutes from dropdown displays that value in the minutes field - FAILED", currentMinute, calendarView.calendarMinuteField.getAttribute("value"));
            System.out.println("VP: Pressing '15' minutes from dropdown displays that value in the minutes field - PASSED");

            calendarView.calendarMinuteField.click();
            calendarView.calendarMinute20.click();
            currentMinute = "20";
            System.out.println("Minutes value is ... " + calendarView.calendarMinuteField.getAttribute("value"));
            AssertJUnit.assertEquals("VP: Pressing '20' minutes from dropdown displays that value in the minutes field - FAILED", currentMinute, calendarView.calendarMinuteField.getAttribute("value"));
            System.out.println("VP: Pressing '20' minutes from dropdown displays that value in the minutes field - PASSED");

            calendarView.calendarMinuteField.click();
            calendarView.calendarMinute25.click();
            currentMinute = "25";
            System.out.println("Minutes value is ... " + calendarView.calendarMinuteField.getAttribute("value"));
            AssertJUnit.assertEquals("VP: Pressing '25' minutes from dropdown displays that value in the minutes field - FAILED", currentMinute, calendarView.calendarMinuteField.getAttribute("value"));
            System.out.println("VP: Pressing '25' minutes from dropdown displays that value in the minutes field - PASSED");

            calendarView.calendarMinuteField.click();
            calendarView.calendarMinute30.click();
            currentMinute = "30";
            System.out.println("Minutes value is ... " + calendarView.calendarMinuteField.getAttribute("value"));
            AssertJUnit.assertEquals("VP: Pressing '30' minutes from dropdown displays that value in the minutes field - FAILED", currentMinute, calendarView.calendarMinuteField.getAttribute("value"));
            System.out.println("VP: Pressing '30' minutes from dropdown displays that value in the minutes field - PASSED");

            calendarView.calendarMinuteField.click();
            calendarView.calendarMinute35.click();
            currentMinute = "35";
            System.out.println("Minutes value is ... " + calendarView.calendarMinuteField.getAttribute("value"));
            AssertJUnit.assertEquals("VP: Pressing '35' minutes from dropdown displays that value in the minutes field - FAILED", currentMinute, calendarView.calendarMinuteField.getAttribute("value"));
            System.out.println("VP: Pressing '35' minutes from dropdown displays that value in the minutes field - PASSED");

            calendarView.calendarMinuteField.click();
            calendarView.calendarMinute40.click();
            currentMinute = "40";
            System.out.println("Minutes value is ... " + calendarView.calendarMinuteField.getAttribute("value"));
            AssertJUnit.assertEquals("VP: Pressing '40' minutes from dropdown displays that value in the minutes field - FAILED", currentMinute, calendarView.calendarMinuteField.getAttribute("value"));
            System.out.println("VP: Pressing '40' minutes from dropdown displays that value in the minutes field - PASSED");

            calendarView.calendarMinuteField.click();
            calendarView.calendarMinute45.click();
            currentMinute = "45";
            System.out.println("Minutes value is ... " + calendarView.calendarMinuteField.getAttribute("value"));
            AssertJUnit.assertEquals("VP: Pressing '45' minutes from dropdown displays that value in the minutes field - FAILED", currentMinute, calendarView.calendarMinuteField.getAttribute("value"));
            System.out.println("VP: Pressing '45' minutes from dropdown displays that value in the minutes field - PASSED");

            calendarView.calendarMinuteField.click();
            calendarView.calendarMinute50.click();
            currentMinute = "50";
            System.out.println("Minutes value is ... " + calendarView.calendarMinuteField.getAttribute("value"));
            AssertJUnit.assertEquals("VP: Pressing '50' minutes from dropdown displays that value in the minutes field - FAILED", currentMinute, calendarView.calendarMinuteField.getAttribute("value"));
            System.out.println("VP: Pressing '50' minutes from dropdown displays that value in the minutes field - PASSED");

            calendarView.calendarMinuteField.click();
            calendarView.calendarMinute55.click();
            currentMinute = "55";
            System.out.println("Minutes value is ... " + calendarView.calendarMinuteField.getAttribute("value"));
            AssertJUnit.assertEquals("VP: Pressing '55' minutes from dropdown displays that value in the minutes field - FAILED", currentMinute, calendarView.calendarMinuteField.getAttribute("value"));
            System.out.println("VP: Pressing '55' minutes from dropdown displays that value in the minutes field - PASSED");





            //Step: cancel to close the calendar modal control
            //calendarView.calendarModalCancel.click();

            //Thread.sleep(1000);
            //driver.switchTo().activeElement();
            //commNav.waitForPage("Meeting");

            System.out.println("VP: Calendar control ability to set minutes to 00 or 05 (as well as all other minutes and all hours) from Advanced view - PASSED");

        }

        catch (Exception e) {
            verificationErrors.append(methodID + "(): " + e.toString());
            System.out.println("VP: Calendar control ability to set minutes to 00 or 05 (as well as all other minutes and all hours) from Advanced view - FAILED");
            AssertJUnit.fail("test failed");
        }

        System.out.println(ENDLINE);
    }


    @Test(enabled = true)
    // INFORCRM-8810 ... Calendar modal control ... unable to set minutes to 00 or 05 from the Advanced view
    // Add additional checking to verify that all months selected from the dropdown, as well as the top and bottom year, display in the month/ year fields respectively
    public void test02_INFORCRM8810() throws Exception {
        String methodID = "test02_INFORCRM8810";

        CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
        HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);
        MyActivityViewsElements activityEditView = PageFactory.initElements(driver, MyActivityViewsElements.class);
        CalendarViewsElements calendarView = PageFactory.initElements(driver, CalendarViewsElements.class);


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

            //Verify that the month value chosen from the dropdown displays in the field
            calendarView.calendarModalCurrMonthValue.click();
            calendarView.calendarModalMonthJan.click();
            String currentMonth = "January";
            System.out.println("Month value is ... " + calendarView.calendarModalCurrMonthValue.getAttribute("value"));
            AssertJUnit.assertEquals("VP: Pressing 'January' month from dropdown displays that value in the month field - FAILED", currentMonth, calendarView.calendarModalCurrMonthValue.getAttribute("value"));
            System.out.println("VP: Pressing 'January' month from dropdown displays that value in the month field - PASSED");

            calendarView.calendarModalCurrMonthValue.click();
            calendarView.calendarModalMonthFeb.click();
            currentMonth = "February";
            System.out.println("Month value is ... " + calendarView.calendarModalCurrMonthValue.getAttribute("value"));
            AssertJUnit.assertEquals("VP: Pressing 'February' month from dropdown displays that value in the month field - FAILED", currentMonth, calendarView.calendarModalCurrMonthValue.getAttribute("value"));
            System.out.println("VP: Pressing 'February' month from dropdown displays that value in the month field - PASSED");

            calendarView.calendarModalCurrMonthValue.click();
            calendarView.calendarModalMonthMar.click();
            currentMonth = "March";
            System.out.println("Month value is ... " + calendarView.calendarModalCurrMonthValue.getAttribute("value"));
            AssertJUnit.assertEquals("VP: Pressing 'March' month from dropdown displays that value in the month field - FAILED", currentMonth, calendarView.calendarModalCurrMonthValue.getAttribute("value"));
            System.out.println("VP: Pressing 'March' month from dropdown displays that value in the month field - PASSED");

            calendarView.calendarModalCurrMonthValue.click();
            calendarView.calendarModalMonthApr.click();
            currentMonth = "April";
            System.out.println("Month value is ... " + calendarView.calendarModalCurrMonthValue.getAttribute("value"));
            AssertJUnit.assertEquals("VP: Pressing 'April' month from dropdown displays that value in the month field - FAILED", currentMonth, calendarView.calendarModalCurrMonthValue.getAttribute("value"));
            System.out.println("VP: Pressing 'April' month from dropdown displays that value in the month field - PASSED");

            calendarView.calendarModalCurrMonthValue.click();
            calendarView.calendarModalMonthMay.click();
            currentMonth = "May";
            System.out.println("Month value is ... " + calendarView.calendarModalCurrMonthValue.getAttribute("value"));
            AssertJUnit.assertEquals("VP: Pressing 'May' month from dropdown displays that value in the month field - FAILED", currentMonth, calendarView.calendarModalCurrMonthValue.getAttribute("value"));
            System.out.println("VP: Pressing 'May' month from dropdown displays that value in the month field - PASSED");

            calendarView.calendarModalCurrMonthValue.click();
            calendarView.calendarModalMonthJun.click();
            currentMonth = "June";
            System.out.println("Month value is ... " + calendarView.calendarModalCurrMonthValue.getAttribute("value"));
            AssertJUnit.assertEquals("VP: Pressing 'June' month from dropdown displays that value in the month field - FAILED", currentMonth, calendarView.calendarModalCurrMonthValue.getAttribute("value"));
            System.out.println("VP: Pressing 'June' month from dropdown displays that value in the month field - PASSED");

            calendarView.calendarModalCurrMonthValue.click();
            calendarView.calendarModalMonthJul.click();
            currentMonth = "July";
            System.out.println("Month value is ... " + calendarView.calendarModalCurrMonthValue.getAttribute("value"));
            AssertJUnit.assertEquals("VP: Pressing 'July' month from dropdown displays that value in the month field - FAILED", currentMonth, calendarView.calendarModalCurrMonthValue.getAttribute("value"));
            System.out.println("VP: Pressing 'July' month from dropdown displays that value in the month field - PASSED");

            calendarView.calendarModalCurrMonthValue.click();
            calendarView.calendarModalMonthAug.click();
            currentMonth = "August";
            System.out.println("Month value is ... " + calendarView.calendarModalCurrMonthValue.getAttribute("value"));
            AssertJUnit.assertEquals("VP: Pressing 'August' month from dropdown displays that value in the month field - FAILED", currentMonth, calendarView.calendarModalCurrMonthValue.getAttribute("value"));
            System.out.println("VP: Pressing 'August' month from dropdown displays that value in the month field - PASSED");

            calendarView.calendarModalCurrMonthValue.click();
            calendarView.calendarModalMonthSep.click();
            currentMonth = "September";
            System.out.println("Month value is ... " + calendarView.calendarModalCurrMonthValue.getAttribute("value"));
            AssertJUnit.assertEquals("VP: Pressing 'September' month from dropdown displays that value in the month field - FAILED", currentMonth, calendarView.calendarModalCurrMonthValue.getAttribute("value"));
            System.out.println("VP: Pressing 'September' month from dropdown displays that value in the month field - PASSED");

            calendarView.calendarModalCurrMonthValue.click();
            calendarView.calendarModalMonthOct.click();
            currentMonth = "October";
            System.out.println("Month value is ... " + calendarView.calendarModalCurrMonthValue.getAttribute("value"));
            AssertJUnit.assertEquals("VP: Pressing 'October' month from dropdown displays that value in the month field - FAILED", currentMonth, calendarView.calendarModalCurrMonthValue.getAttribute("value"));
            System.out.println("VP: Pressing 'October' month from dropdown displays that value in the month field - PASSED");

            calendarView.calendarModalCurrMonthValue.click();
            calendarView.calendarModalMonthNov.click();
            currentMonth = "November";
            System.out.println("Month value is ... " + calendarView.calendarModalCurrMonthValue.getAttribute("value"));
            AssertJUnit.assertEquals("VP: Pressing 'November' month from dropdown displays that value in the month field - FAILED", currentMonth, calendarView.calendarModalCurrMonthValue.getAttribute("value"));
            System.out.println("VP: Pressing 'November' month from dropdown displays that value in the month field - PASSED");

            calendarView.calendarModalCurrMonthValue.click();
            calendarView.calendarModalMonthDec.click();
            currentMonth = "December";
            System.out.println("Month value is ... " + calendarView.calendarModalCurrMonthValue.getAttribute("value"));
            AssertJUnit.assertEquals("VP: Pressing 'December' month from dropdown displays that value in the month field - FAILED", currentMonth, calendarView.calendarModalCurrMonthValue.getAttribute("value"));
            System.out.println("VP: Pressing 'December' month from dropdown displays that value in the month field - PASSED");

            //Verify that the top and bottom year values chosen from the dropdown displays in the field
            calendarView.calendarModalCurrYearValue.click();
            calendarView.calendarModalYearTopItem.click();
            String topYear = calendarView.calendarModalYearTopItem.getAttribute("data-value");
            System.out.println("Top year value is ... " + calendarView.calendarModalCurrYearValue.getAttribute("value"));
            AssertJUnit.assertEquals("VP: Pressing top year from dropdown displays that value in the year field - FAILED", topYear, calendarView.calendarModalCurrYearValue.getAttribute("value"));
            System.out.println("VP: Pressing top year from dropdown displays that value in the year field - PASSED");

            calendarView.calendarModalCurrYearValue.click();
            calendarView.calendarModalYearBottomItem.click();
            String bottomYear = calendarView.calendarModalYearBottomItem.getAttribute("data-value");
            System.out.println("Bottom year value is ... " + calendarView.calendarModalCurrYearValue.getAttribute("value"));
            AssertJUnit.assertEquals("VP: Pressing bottom year from dropdown displays that value in the year field - FAILED", bottomYear, calendarView.calendarModalCurrYearValue.getAttribute("value"));
            System.out.println("VP: Pressing bottom year from dropdown displays that value in the year field - PASSED");


            //Step: cancel to close the calendar modal control
            //calendarView.calendarModalCancel.click();

            //Thread.sleep(1000);
            //driver.switchTo().activeElement();
            //commNav.waitForPage("Meeting");

            System.out.println("VP: Calendar control ability to set months and years from Advanced view - PASSED");

        }

        catch (Exception e) {
            verificationErrors.append(methodID + "(): " + e.toString());
            System.out.println("VP: Calendar control ability to set months and years from Advanced view - FAILED");
            AssertJUnit.fail("test failed");
        }

        System.out.println(ENDLINE);
    }


    @Test(enabled = true)
    // INFORCRM-8390 ... Calendar : not seeing 'Event' as an option when opening an activity
    public void test03_INFORCRM8390() throws Exception {
        String methodID = "test03_INFORCRM8390";

        CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
        HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);
        MyActivityViewsElements activityEditView = PageFactory.initElements(driver, MyActivityViewsElements.class);
        CalendarViewsElements calendarView = PageFactory.initElements(driver, CalendarViewsElements.class);

        String viewName = "Schedule Activity screen";


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

            //Verify that Event is an option for an activity
            List elements = driver.findElements(By.xpath("//*[@id='activity_types_list']//ul/li[5]/div[2]"));

            if(elements.size() > 0) {
                commNav.isWebElementPresent(viewName + ", Event Option ", activityEditView.activityScheduleEventBtn);
                System.out.println("VP: from Calendar, on adding an activity, see Event as an option - PASSED");
            } else {
                System.out.println("VP: from Calendar, on adding an activity, see Event as an option - FAILED");
                AssertJUnit.fail("test failed");
            }

            System.out.println(methodID + "- PASSED");
        }

        catch (Exception e) {
            verificationErrors.append(methodID + "(): " + e.toString());
            System.out.println(methodID + "- FAILED");
            AssertJUnit.fail("test failed");
        }

        System.out.println(ENDLINE);
    }


    @Test(enabled = true)
    // INFORCRM-8139 ... on editing Ticket dates should not see the Relative date view before calendar control view
    public void test04_INFORCRM8139() throws Exception {
        String methodID = "test04_INFORCRM8139";

        // Test Params:
        String entityType = "Ticket";
        String entityRecord = TEST_TICKET_RECORD;
        String viewName = "Ticket Edit view";

        CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
        HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);
        CalendarViewsElements calendarView = PageFactory.initElements(driver, CalendarViewsElements.class);

        System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);

        //Step: logout & log back in (to clear cookies)
        LogOutThenLogBackIn(userName, userPwd);

        try {
            //Step: search for Ticket entity, then open it's Edit view
            AssertJUnit.assertTrue(commNav.entityRecordEditView(entityType, entityRecord));

            TicketViewsElements ticketEditView = PageFactory.initElements(driver, TicketViewsElements.class);

            //Step: press Icon for 'needed date'
            commNav.isWebElementPresent(viewName + ",'needed date icon'", ticketEditView.ticketsEditViewNeededDateFldBtn);
            ticketEditView.ticketsEditViewNeededDateFldBtn.click();

            //Check whether or not 'Next Week' on Relative date view displays ... it should not display
            List elements = driver.findElements(By.xpath("//ul//li//div[contains(., 'Next Week')]"));

            if(elements.size() > 0) {
                commNav.isWebElementPresent(viewName + ", Next Week title", calendarView.calendarModalNextWeekTitle);
                System.out.println("VP: on editing Ticket dates should not see the relative date view before calendar view - FAILED");
                AssertJUnit.fail("test failed");
            }
            System.out.println("VP: on editing Ticket dates should not see the relative date view before calendar view - PASSED");
            System.out.println(methodID + "- PASSED");

        } catch (Error e) {
            verificationErrors.append(e.toString());
            System.out.println(methodID + "- FAILED");
            AssertJUnit.fail("test failed");
        }

        System.out.println(ENDLINE);
    }


    @Test(enabled = true)
    // INFORCRM-8380 ... Calendar : all day activities not appearing as expected on the calendar for the first day of a month
    public void test05_INFORCRM8380() throws Exception {
        String methodID = "test05_INFORCRM8380";

        CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
        HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);
        MyActivityViewsElements activityEditView = PageFactory.initElements(driver, MyActivityViewsElements.class);
        CalendarViewsElements calendarView = PageFactory.initElements(driver, CalendarViewsElements.class);

        String viewName = "Calendar screen";


        System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);

        try {


            //Step: logout & log back in (to clear cookies)
            LogOutThenLogBackIn(userName, userPwd);


            //Step: go to Calendar view ... wait for page Calendar
            commNav.clickGlobalMenuItem("Calendar");
            commNav.waitForPage("Calendar");

            //Step: select the first day of that month
            calendarView.calendarDayOneCurrMonth.click();

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

            activityEditView.activityEditViewRegardingFld.sendKeys(newActivityRegarding);

            //Step: set the activity to be timeless, and save activity
            activityEditView.activityEditViewTimelessTgl.click();
            headerButton.clickHeaderButton("Save");
            commNav.waitForPage("Calendar");

            //Step: verify that the activity created displays for the currently selected first day of the month
            WebElement activityItemLnk = driver.findElement(By.xpath("//*[@id='calendar_view']//h3[text() = '" + newActivityRegarding + "']"));
            if(commNav.isWebElementPresent(viewName + ", ActivityAdded ", activityItemLnk)) {
                System.out.println("VP: all day activities not appearing as expected on the calendar for the first day of a month - PASSED");
            } else {
                System.out.println("VP: all day activities not appearing as expected on the calendar for the first day of a month - FAILED");
                AssertJUnit.fail("test failed");
            }

            System.out.println(methodID + "- PASSED");
        }

        catch (Exception e) {
            verificationErrors.append(methodID + "(): " + e.toString());
            System.out.println(methodID + "- FAILED");
            AssertJUnit.fail("test failed");
        }

        System.out.println(ENDLINE);
    }


    @Test(enabled = true)
    //INFORCRM-6889 ... Opportunity - unable to change the value of the 'close prob' field
    public void test06_INFORCRM6889() throws Exception {
        String methodID = "test06_INFORCRM6889";

        // Test Params:
        String entityType = "Opportunity";
        String entityRecord = TEST_OPPORTUNITY_RECORD;

        CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
        HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);

        System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);

        try {

            //Step: login & log back in (to clear cookies)
            LogOutThenLogBackIn(userName, userPwd);

            //Step: search for Opportunity entity, then open it's Edit view
            AssertJUnit.assertTrue(commNav.entityRecordEditView(entityType, entityRecord));

            OpportunityViewsElements opportunityEditView = PageFactory.initElements(driver, OpportunityViewsElements.class);

            //Step: click on 'close prob' button to open Opportunity Probability list
            opportunityEditView.opportunityEditViewCloseProbFldBtn.click();
            commNav.waitForPage("Opportunity Probability");
            opportunityEditView.opportunityProbability10.click();
            headerButton.clickHeaderButton("save");
            commNav.waitForPage(TEST_OPPORTUNITY_RECORD);
            AssertJUnit.assertEquals("VP: for opportunity, unable to change the value of the 'close prob' field - FAILED", TEST_OPPORTUNITY_RECORD, driver.findElement(By.id("pageTitle")).getText());
            System.out.println("VP: for opportunity, unable to change the value of the 'close prob' field - PASSED");

        }

        catch (Exception e) {
            verificationErrors.append(methodID + "(): " + e.toString());
            System.out.println("VP: for opportunity, unable to change the value of the 'close prob' field - FAILED");
            AssertJUnit.fail("test failed");
        }

        System.out.println(ENDLINE);
    }


    @Test(enabled = true)
    // INFORCRM-6722 ... Activity Detail - complete activity quick action opens relevant screen, but unable to save completion
    public void test07_INFORCRM6722() throws Exception {
        String methodID = "test07_INFORCRM-6722";

        CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
        HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);
        MyActivityViewsElements activityEditView = PageFactory.initElements(driver, MyActivityViewsElements.class);


        System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);

        try {


            //Step: logout & log back in (to clear cookies)
            LogOutThenLogBackIn(userName, userPwd);


            //Step: go to Calendar view ... wait for page Calendar (use currently selected day)
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

            //Step: add an Activity record with a random value for 'regarding'
            String newActivityRegarding = "SeAutoTestActivity-" + new SimpleDateFormat("yyMMddHHmmss").format(new GregorianCalendar().getTime());
            System.out.println("Activity regarding field will be - " + newActivityRegarding);

            activityEditView.activityEditViewRegardingFld.sendKeys(newActivityRegarding);

            //Step: save the activity
            headerButton.clickHeaderButton("Save");
            commNav.waitForPage("Calendar");

            //Step: locate the activity for the currently selected day of the month
            WebElement activityItemLnk = driver.findElement(By.xpath("//*[@id='calendar_view']//h3[text() = '" + newActivityRegarding + "']"));
            activityItemLnk.click();
            commNav.waitForPage(newActivityRegarding);

            //Step: complete the activity from the detail view
            activityEditView.activityDetailViewCompleteActivityLnk.click();
            commNav.waitForPage("Complete Activity");
            headerButton.clickHeaderButton("Save");
            commNav.waitForPage("Calendar");

            //Step: verify that save of completion worked, and one is positioned back on the Calendar screen
            AssertJUnit.assertEquals("VP: Activity Detail - complete activity quick action opens relevant screen, but unable to save completion - FAILED", "Calendar", driver.findElement(By.id("pageTitle")).getText());
            System.out.println("VP: Activity Detail - complete activity quick action opens relevant screen, but unable to save completion - PASSED");

        }

        catch (Exception e) {
            verificationErrors.append(methodID + "(): " + e.toString());
            System.out.println("VP: Activity Detail - complete activity quick action opens relevant screen, but unable to save completion - FAILED");
            AssertJUnit.fail("test failed");
        }

        System.out.println(ENDLINE);
    }


    @Test(enabled = true)
    //INFORCRM-6401 ... Calendar/ time control : where there is no default date/ time assigned to a field, unable to open the 'Advanced' calendar/ time control
    public void test08_INFORCRM6401() throws Exception {
        String methodID = "test08_INFORCRM6401";

        // Test Params:
        String entityType = "Tickets";
        String entityRecord = TEST_TICKET_RECORD;

        CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
        HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);
        CalendarViewsElements calendarView = PageFactory.initElements(driver, CalendarViewsElements.class);

        System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);

        //Step: logout & log back in (to clear cookies)
        LogOutThenLogBackIn(userName, userPwd);

        try {
            //Step: search for Ticket entity, then open it's Detail view
            commNav.entityRecordOpenDetailView(entityType, entityRecord);

            TicketViewsElements ticketDetailView = PageFactory.initElements(driver, TicketViewsElements.class);

            //Step: under the Related Items section, open Ticket Activities
            commNav.highlightNClick(ticketDetailView.ticketDetailViewRelatedItemsTab);
            commNav.highlightNClick(ticketDetailView.ticketsDetailViewTicketsActivitiesLnk);
            commNav.waitForPage("Ticket Activities");

            //Step: add a new ticket activity
            headerButton.clickHeaderButton("add");
            commNav.waitForPage("Edit Ticket Activity");

            //Step: press icon for start date to open Calendar view
            ticketDetailView.ticketActivityStartDateBtn.click();
            Thread.sleep(1000);
            driver.switchTo().activeElement();

            //Step: cancel out of Calendar control view
            calendarView.calendarModalCancel.click();
            Thread.sleep(1000);
            driver.switchTo().activeElement();

            //Step: press icon for end date to open Calendar view
            ticketDetailView.ticketActivityStartDateBtn.click();

            //Step: verify that the calendar control has again opened as expected ... try to select month of January from month dropdown as a check
            calendarView.calendarModalCurrMonthValue.click();
            calendarView.calendarMonthJan.click();
            String currentMonth = "January";
            AssertJUnit.assertEquals("VP: Calendar/ time control : where there is no default date/ time assigned to a field, unable to open the 'Advanced' calendar/ time control - FAILED", currentMonth, calendarView.calendarModalCurrMonthValue.getAttribute("value"));
            System.out.println("VP: Calendar/ time control : where there is no default date/ time assigned to a field, unable to open the 'Advanced' calendar/ time control - PASSED");


        }
        catch (Exception e) {
            verificationErrors.append(methodID + "(): " + e.toString());
            System.out.println("VP: Calendar/ time control : where there is no default date/ time assigned to a field, unable to open the 'Advanced' calendar/ time control - FAILED");
            AssertJUnit.fail("test failed");
        }

        System.out.println(ENDLINE);
    }


    @Test(enabled = true)
    //INFORCRM-5710 ... My Schedule - online : after adding an activity, listview not always being automatically refreshed
    public void test09_INFORCRM5710() throws Exception {
        String methodID = "test09_INFORCRM5710";

        String viewName = "My Schedule view";

        CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
        HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);
        MyActivityViewsElements activityEditView = PageFactory.initElements(driver, MyActivityViewsElements.class);

        System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);

        //Step: logout & log back in (to clear cookies)
        LogOutThenLogBackIn(userName, userPwd);

        try {

            //Step: go to "My Schedule" view, if not already there
            if (!commNav.isPageDisplayed("My Schedule"))   {
                commNav.clickGlobalMenuItem("My Schedule");
                commNav.waitForPage("My Schedule");
            }


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

            activityEditView.activityEditViewRegardingFld.sendKeys(newActivityRegarding);

            //Step: save the activity
            headerButton.clickHeaderButton("Save");
            commNav.waitForPage("My Schedule");

            //Step: locate the activity added
            WebElement activityItemLnk = driver.findElement(By.xpath("//*[@id='myday_list']//h3/span[text() = '" + newActivityRegarding + "']"));
            if(commNav.isWebElementPresent(viewName + ", Activity Added ", activityItemLnk)) {
                System.out.println("VP: My Schedule - online : after adding an activity, listview not always being automatically refreshed - PASSED");
            } else {
                System.out.println("VP: My Schedule - online : after adding an activity, listview not always being automatically refreshed - FAILED");
                AssertJUnit.fail("test failed");
            }

            System.out.println(methodID + "- PASSED");

        }
        catch (Exception e) {
            verificationErrors.append(methodID + "(): " + e.toString());
            System.out.println("VP: My Schedule - online : after adding an activity, listview not always being automatically refreshed - FAILED");
            AssertJUnit.fail("test failed");
        }

        System.out.println(ENDLINE);
    }



    @Test(enabled = true)
    //INFORCRM-5301 ... My Schedule - online : activity listview quick actions for Contact and Opportunity open screen with expected title, then see continuous loading and no detail
    public void test10_INFORCRM5301() throws Exception {
        String methodID = "test10_INFORCRM5301";

        String viewName = "My Schedule view";

        CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
        CommonViewsElements commView = PageFactory.initElements(driver, CommonViewsElements.class);
        HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);
        MyActivityViewsElements activityEditView = PageFactory.initElements(driver, MyActivityViewsElements.class);
        ContactViewsElements contactsListView = PageFactory.initElements(driver, ContactViewsElements.class);
        AccountViewsElements accountDetailView = PageFactory.initElements(driver, AccountViewsElements.class);
        OpportunityViewsElements opportunitiesListView = PageFactory.initElements(driver, OpportunityViewsElements.class);
        MyScheduleViewsElements myScheduleListView = PageFactory.initElements(driver, MyScheduleViewsElements.class);

        System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);

        //Step: logout & log back in (to clear cookies)
        LogOutThenLogBackIn(userName, userPwd);

        try {

            //Step: go to "My Schedule" view, if not already there
            if (!commNav.isPageDisplayed("My Schedule"))   {
                commNav.clickGlobalMenuItem("My Schedule");
                commNav.waitForPage("My Schedule");
            }


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

            activityEditView.activityEditViewRegardingFld.sendKeys(newActivityRegarding);

            //Step: choose an opportunity for the activity, which also auto-fills the account
            activityEditView.activityEditViewOpportunityBtn.click();
            commNav.waitForPage("Opportunities");
            commView.lookupTxtBox.click();
            Thread.sleep(500);
            commView.lookupTxtBox.sendKeys(Keys.BACK_SPACE);
            Thread.sleep(500);
            commView.lookupTxtBox.sendKeys(TEST_OPPORTUNITY_RECORD);
            Thread.sleep(500);
            commView.lookupTxtBox.sendKeys(Keys.RETURN);
            opportunitiesListView.topRelatedOpportunitiesListItem.click();
            commNav.waitForPage("Meeting");

            //Step: select the contact for the opportunity
            activityEditView.activityEditViewContactBtn.click();
            commNav.waitForPage("Contacts");
            contactsListView.relatedContactsListViewTopItem.click();
            commNav.waitForPage("Meeting");

            //Step: save the values for each of account, contact and opportunity
            String activityAccountValue = activityEditView.activityEditViewAccountFld.getAttribute("value");
            String activityContactValue = activityEditView.activityEditViewContactFld.getAttribute("value");
            String activityOpportunityValue = activityEditView.activityEditViewOpportunityFld.getAttribute("value");
            System.out.println("VP: account chosen for activity is ... " + activityAccountValue);
            System.out.println("VP: contact chosen for activity is ... " + activityContactValue);
            System.out.println("VP: opportunity chosen for activity is ... " + activityOpportunityValue);

            //Step: save the activity
            headerButton.clickHeaderButton("Save");
            commNav.waitForPage("My Schedule");

            //Step: locate the activity added under My Schedule listview
            WebElement activityItemLnk = driver.findElement(By.xpath("//*[@id='myday_list']//h3/span[text() = '" + newActivityRegarding + "']"));
            if(commNav.isWebElementPresent(viewName + ", Activity Added ", activityItemLnk)) {
                System.out.println("VP: activity added has been located in My Schedule listview - PASSED");
            } else {
                System.out.println("VP: activity added has been located in My Schedule listview - FAILED");
                AssertJUnit.fail("test failed");
            }

            //Step: display the quick actions for this activity
            String fullActivityRegarding = "Meeting - Regarding: " + newActivityRegarding;
            WebElement myScheduleQuickActionsIcon = driver.findElement(By.xpath("//*[@id='myday_list']//li[@data-descriptor = '" + fullActivityRegarding + "']//button"));
            myScheduleQuickActionsIcon.click();

            //Step: press the Account quick action to open the relevant account ... check page title and a field on the account detail view
            myScheduleListView.myScheduleQuickActionAccount.click();
            commNav.waitForPage(activityAccountValue);
            if(commNav.isWebElementPresent("Account Detail, account field ", accountDetailView.accountDetailViewAccountFld)) {
                System.out.println("VP: navigated to account ... " + accountDetailView.accountDetailViewAccountFld.getText());
                AssertJUnit.assertEquals("VP: navigated to expected account - FAILED", activityAccountValue, accountDetailView.accountDetailViewAccountFld.getText());
                System.out.println("VP: activity link to account opened detail view as expected - PASSED");
            } else {
                System.out.println("VP: activity link to account opened detail view as expected - FAILED");
                AssertJUnit.fail("test failed");
            }
            headerButton.clickHeaderButton("back");
            commNav.waitForPage("My Schedule");

            //Step: with quick actions still displaying for the activity in listview, press the Contact quick action to open the relevant contact ... check page title and a field on the contact detail view
            myScheduleListView.myScheduleQuickActionContact.click();
            commNav.waitForPage(activityContactValue);
            if(commNav.isWebElementPresent("Contact Detail, contact field ", contactsListView.contactsDetailViewContactFld)) {
                System.out.println("VP: navigated to contact ... " + contactsListView.contactsDetailViewContactFld.getText());
                AssertJUnit.assertEquals("VP: navigated to expected contact - FAILED", activityContactValue, contactsListView.contactsDetailViewContactFld.getText());
                System.out.println("VP: activity link to contact opened detail view as expected - PASSED");
            } else {
                System.out.println("VP: activity link to contact opened detail view as expected - FAILED");
                AssertJUnit.fail("test failed");
            }
            headerButton.clickHeaderButton("back");
            commNav.waitForPage("My Schedule");

            //Step: with quick actions still displaying for the activity in listview, press the Opportunity quick action to open the relevant contact ... check page title and a field on the opportunity detail view
            myScheduleListView.myScheduleQuickActionOpportunity.click();
            commNav.waitForPage("Opportunity");
            if(commNav.isWebElementPresent("Opportunity Detail, opportunity field ", opportunitiesListView.opportunityDetailViewOpportunityFld)) {
                System.out.println("VP: navigated to opportunity ... " + opportunitiesListView.opportunityDetailViewOpportunityFld.getText());
                AssertJUnit.assertEquals("VP: navigated to expected opportunity - FAILED", activityOpportunityValue, opportunitiesListView.opportunityDetailViewOpportunityFld.getText());
                System.out.println("VP: activity link to opportunity opened detail view as expected - PASSED");
            } else {
                System.out.println("VP: activity link to opportunity opened detail view as expected - FAILED");
                AssertJUnit.fail("test failed");
            }
            headerButton.clickHeaderButton("back");
            commNav.waitForPage("My Schedule");


            System.out.println(methodID + "- PASSED");

        }
        catch (Exception e) {
            verificationErrors.append(methodID + "(): " + e.toString());
            System.out.println("VP: My Schedule - online : activity listview quick actions for Contact and Opportunity open screen with expected title, then see continuous loading and no detail - FAILED");
            AssertJUnit.fail("test failed");
        }

        System.out.println(ENDLINE);
    }


    @Test(enabled = true)
    //INFORCRM-5302 ... My Schedule - online : activity listview quick action for 'Call' does nothing
    public void test11_INFORCRM5302() throws Exception {
        String methodID = "test11_INFORCRM5302";

        String viewName = "My Schedule view";

        CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
        CommonViewsElements commView = PageFactory.initElements(driver, CommonViewsElements.class);
        HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);
        MyActivityViewsElements activityEditView = PageFactory.initElements(driver, MyActivityViewsElements.class);
        ContactViewsElements contactsListView = PageFactory.initElements(driver, ContactViewsElements.class);
        MyScheduleViewsElements myScheduleListView = PageFactory.initElements(driver, MyScheduleViewsElements.class);

        System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);

        //Step: logout & log back in (to clear cookies)
        LogOutThenLogBackIn(userName, userPwd);

        try {

            //Step: go to "My Schedule" view, if not already there
            if (!commNav.isPageDisplayed("My Schedule"))   {
                commNav.clickGlobalMenuItem("My Schedule");
                commNav.waitForPage("My Schedule");
            }


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

            activityEditView.activityEditViewRegardingFld.sendKeys(newActivityRegarding);

            //Step: choose a contact for the activity, which also auto-fills the account and the phone
            activityEditView.activityEditViewContactBtn.click();
            commNav.waitForPage("Contacts");
            commView.lookupTxtBox.click();
            Thread.sleep(500);
            commView.lookupTxtBox.sendKeys(Keys.BACK_SPACE);
            Thread.sleep(500);
            commView.lookupTxtBox.sendKeys(TEST_CONTACT_RECORD);
            Thread.sleep(500);
            commView.lookupTxtBox.sendKeys(Keys.RETURN);
            contactsListView.relatedContactsListViewTopItem.click();
            commNav.waitForPage("Meeting");

            //Step: save the value of the activity's work phone number
            String activityWorkPhone = activityEditView.activityEditViewPhoneFld.getAttribute("value");
            String activityWorkPhoneEdited  = activityWorkPhone.replace("(","");
            activityWorkPhoneEdited = activityWorkPhoneEdited.replace(")","");
            activityWorkPhoneEdited = activityWorkPhoneEdited.replace("-","");
            System.out.println("VP: Activity detail Work Phone value to be clicked is ... " + activityWorkPhone + " / " + activityWorkPhoneEdited);

            //Step: save the activity
            headerButton.clickHeaderButton("Save");
            commNav.waitForPage("My Schedule");

            //Step: locate the activity added under My Schedule listview
            WebElement activityItemLnk = driver.findElement(By.xpath("//*[@id='myday_list']//h3/span[text() = '" + newActivityRegarding + "']"));
            if(commNav.isWebElementPresent(viewName + ", Activity Added ", activityItemLnk)) {
                System.out.println("VP: activity added has been located in My Schedule listview - PASSED");
            } else {
                System.out.println("VP: activity added has been located in My Schedule listview - FAILED");
                AssertJUnit.fail("test failed");
            }

            //Step: display the quick actions for this activity
            String fullActivityRegarding = "Meeting - Regarding: " + newActivityRegarding;
            WebElement myScheduleQuickActionsIcon = driver.findElement(By.xpath("//*[@id='myday_list']//li[@data-descriptor = '" + fullActivityRegarding + "']//button"));
            myScheduleQuickActionsIcon.click();

            //Step: press the Call quick action to make a call to the activity's work phone
            myScheduleListView.myScheduleQuickActionCall.click();
            Thread.sleep(3000);
            String urlTelephone = driver.getCurrentUrl().substring(4);
            System.out.println("VP: Value of activity's Work Phone in browser address bar (would be called) is ... " + urlTelephone);

            //Step: verify that clicking the activity Call quick action in My Schedule listview results in a call attempt to the activity's work phone
            AssertJUnit.assertEquals("VP: My Schedule - clicking the activity Call quick action in listview did not try to call the activity's work phone - FAILED",activityWorkPhoneEdited,urlTelephone);
            System.out.println("VP: My Schedule - clicking the activity Call quick action in listview did not try to call the activity's work phone  - PASSED");


            closeBrowser();
            launchBrowser();
            //driver.navigate().back();
            //driver.navigate().refresh();
            //if (commNav.isTextNotPresentOnPage("Copyright")) {
            //   driver.navigate().refresh();
            //}
            doVerificationLogin();

            System.out.println(methodID + "- PASSED");

        }
        catch (Exception e) {
            verificationErrors.append(methodID + "(): " + e.toString());
            System.out.println("VP: My Schedule - clicking the activity Call quick action in listview did not try to call the activity's work phone - FAILED");
            AssertJUnit.fail("test failed");
        }

        System.out.println(ENDLINE);
    }



    @Test(enabled = true)
    //INFORCRM-5303 ... My Schedule - online : online : clicking on the listview phone link does nothing
    public void test12_INFORCRM5303() throws Exception {
        String methodID = "test12_INFORCRM5303";

        String viewName = "My Schedule view";

        CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
        CommonViewsElements commView = PageFactory.initElements(driver, CommonViewsElements.class);
        HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);
        MyActivityViewsElements activityEditView = PageFactory.initElements(driver, MyActivityViewsElements.class);
        ContactViewsElements contactsListView = PageFactory.initElements(driver, ContactViewsElements.class);
        MyScheduleViewsElements myScheduleListView = PageFactory.initElements(driver, MyScheduleViewsElements.class);

        System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);

        //Step: logout & log back in (to clear cookies)
        LogOutThenLogBackIn(userName, userPwd);

        try {

            //Step: go to "My Schedule" view, if not already there
            if (!commNav.isPageDisplayed("My Schedule"))   {
                commNav.clickGlobalMenuItem("My Schedule");
                commNav.waitForPage("My Schedule");
            }


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

            activityEditView.activityEditViewRegardingFld.sendKeys(newActivityRegarding);

            //Step: choose a contact for the activity, which also auto-fills the account and the phone
            activityEditView.activityEditViewContactBtn.click();
            commNav.waitForPage("Contacts");
            commView.lookupTxtBox.click();
            Thread.sleep(500);
            commView.lookupTxtBox.sendKeys(Keys.BACK_SPACE);
            Thread.sleep(500);
            commView.lookupTxtBox.sendKeys(TEST_CONTACT_RECORD);
            Thread.sleep(500);
            commView.lookupTxtBox.sendKeys(Keys.RETURN);
            contactsListView.relatedContactsListViewTopItem.click();
            commNav.waitForPage("Meeting");

            //Step: save the value of the activity's work phone number
            String activityWorkPhone = activityEditView.activityEditViewPhoneFld.getAttribute("value");
            String activityWorkPhoneEdited  = activityWorkPhone.replace("(","");
            activityWorkPhoneEdited = activityWorkPhoneEdited.replace(")","");
            activityWorkPhoneEdited = activityWorkPhoneEdited.replace("-","");
            System.out.println("VP: Activity detail Work Phone value to be clicked is ... " + activityWorkPhone + " / " + activityWorkPhoneEdited);

            //Step: save the activity
            headerButton.clickHeaderButton("Save");
            commNav.waitForPage("My Schedule");

            //Step: locate the activity added under My Schedule listview
            WebElement activityItemLnk = driver.findElement(By.xpath("//*[@id='myday_list']//h3/span[text() = '" + newActivityRegarding + "']"));
            if(commNav.isWebElementPresent(viewName + ", Activity Added ", activityItemLnk)) {
                System.out.println("VP: activity added has been located in My Schedule listview - PASSED");
            } else {
                System.out.println("VP: activity added has been located in My Schedule listview - FAILED");
                AssertJUnit.fail("test failed");
            }

            //Step: press the listview phone link to make a call to the activity's work phone
            String fullActivityRegarding = "Meeting - Regarding: " + newActivityRegarding;
            WebElement myScheduleListViewPhoneLink = driver.findElement(By.xpath("//*[@id='myday_list']//li[@data-descriptor = '" + fullActivityRegarding + "']//h4/span[@data-action = '_callPhone']"));
            myScheduleListViewPhoneLink.click();
            Thread.sleep(3000);
            String urlTelephone = driver.getCurrentUrl().substring(4);
            System.out.println("VP: Value of activity's Work Phone in browser address bar (would be called) is ... " + urlTelephone);

            //Step: verify that clicking the activity phone link in My Schedule listview results in a call attempt to the activity's phone number
            AssertJUnit.assertEquals("VP: My Schedule - clicking the activity phone link in listview did not try to call the activity's work phone - FAILED",activityWorkPhoneEdited,urlTelephone);
            System.out.println("VP: My Schedule - clicking the activity phone link in listview did not try to call the activity's work phone  - PASSED");


            closeBrowser();
            launchBrowser();
            //driver.navigate().back();
            //driver.navigate().refresh();
            //if (commNav.isTextNotPresentOnPage("Copyright")) {
            //   driver.navigate().refresh();
            //}
            doVerificationLogin();

            System.out.println(methodID + "- PASSED");

        }
        catch (Exception e) {
            verificationErrors.append(methodID + "(): " + e.toString());
            System.out.println("VP: My Schedule - clicking the activity Call quick action in listview did not try to call the activity's work phone - FAILED");
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
