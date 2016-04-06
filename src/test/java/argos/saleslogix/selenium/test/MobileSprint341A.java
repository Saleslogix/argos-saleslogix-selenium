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
    public String TEST_CONTACT_RECORD2 = "Aceti, Janet";
    public String TEST_ACCOUNT_RECORD = "Abbott Ltd.";
    public String TEST_OPPORTUNITY_RECORD = "Vegas Vision-Phase1";
    public String TEST_OPPORTUNITY_RECORD3 = "Abbott Ltd.-Phase3";
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


    @Test(enabled = true)
    //INFORCRM-5299 ... My Schedule - online : after completing an activity, listview is not always reflecting this until one does an explicit refresh
    public void test13_INFORCRM5299() throws Exception {
        String methodID = "test13_INFORCRM5299";

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

            //Step: open the activity and complete it
            activityItemLnk.click();
            activityEditView.activityDetailViewCompleteActivityLnk.click();
            commNav.waitForPage("Complete Activity");
            headerButton.clickHeaderButton("save");
            commNav.waitForPage("My Schedule");

            //Step: validate that the activity no longer displays under My Schedule listview
            List elements = driver.findElements(By.xpath("//*[@id='myday_list']//h3/span[text() = '" + newActivityRegarding + "']"));

            if(elements.size() == 0) {
                System.out.println("VP: My Schedule - online : after completing an activity, listview is not always reflecting this until one does an explicit refresh - PASSED");
            } else {
                System.out.println("VP: My Schedule - online : after completing an activity, listview is not always reflecting this until one does an explicit refresh - FAILED");
                AssertJUnit.fail("test failed");
            }

            System.out.println(methodID + "- PASSED");

        }
        catch (Exception e) {
            verificationErrors.append(methodID + "(): " + e.toString());
            System.out.println("VP: My Schedule - online : after completing an activity, listview is not always reflecting this until one does an explicit refresh - FAILED");
            AssertJUnit.fail("test failed");
        }

        System.out.println(ENDLINE);
    }


    @Test(enabled = true)
    // INFORCRM-4950 ... Calendar/ time control - where date/ time value is confirmed, then date/ time value is cancelled, the saved date has the incorrect month and year
    public void test14_INFORCRM4950() throws Exception {
        String methodID = "test14_INFORCRM4950";

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

            //Step: Open Start Time calendar, and wait for modal calendar control to open
            activityEditView.activityEditViewStartTimeFldBtn.click();
            Thread.sleep(1000);
            driver.switchTo().activeElement();

            //Step: Press Advanced button to open Calendar view
            calendarView.calendarModalAdvanced.click();

            //Step: on the calendar modal control, set the date/time to ... 8/16/2015 9:30 AM/PM, press Confirm and save 'start time' value on the activity insert screen
            calendarView.calendarModalDay16CurrMonth.click();
            calendarView.calendarModalCurrMonthValue.click();
            calendarView.calendarModalMonthAug.click();
            calendarView.calendarModalCurrYearValue.click();
            calendarView.calendarModalYearTen.click();
            calendarView.calendarHourField.click();
            calendarView.calendarHourNine.click();
            calendarView.calendarMinuteField.click();
            calendarView.calendarMinute30.click();
            calendarView.calendarModalConfirm.click();
            Thread.sleep(1000);
            driver.switchTo().activeElement();
            commNav.waitForPage("Meeting");
            String originalStartTime = activityEditView.activityEditViewStartTimeFld.getAttribute("value");
            System.out.println("VP: original activity 'start time' that has been confirmed is ... " + originalStartTime);


            //Step: Re-open Start Time calendar, and wait for modal calendar control to open
            activityEditView.activityEditViewStartTimeFldBtn.click();
            Thread.sleep(1000);
            driver.switchTo().activeElement();

            //Step: Press Advanced button to open Calendar view
            calendarView = PageFactory.initElements(driver, CalendarViewsElements.class);
            calendarView.calendarModalAdvanced.click();

            //Step: on the calendar modal control, set the date/time to ... 9/18/2016 7:15 AM/PM, and press Cancel
            calendarView.calendarModalDay18CurrMonth.click();
            calendarView.calendarModalCurrMonthValue.click();
            calendarView.calendarModalMonthSep.click();
            calendarView.calendarModalCurrYearValue.click();
            calendarView.calendarModalYearEleven.click();
            calendarView.calendarHourField.click();
            calendarView.calendarHourSeven.click();
            calendarView.calendarMinuteField.click();
            calendarView.calendarMinute15.click();
            calendarView.calendarModalCancel.click();
            Thread.sleep(1000);
            driver.switchTo().activeElement();
            commNav.waitForPage("Meeting");

            //Step: on the activity insert screen, validate that start time displays as 8/16/2015 9:30 AM/PM as expected
            System.out.println("VP: activity 'start time' was changed on the modal calendar control, then that value was cancelled");
            AssertJUnit.assertEquals("VP: current activity 'start time' equals original 'start time' that was confirmed - FAILED", originalStartTime, activityEditView.activityEditViewStartTimeFld.getAttribute("value"));
            System.out.println("VP: current activity 'start time' equals original 'start time' that was confirmed - PASSED");

            //Step: save the activity
            headerButton.clickHeaderButton("save");
            commNav.waitForPage("Calendar");

            //Step: place focus on calendar for 8/16/2015
            calendarView = PageFactory.initElements(driver, CalendarViewsElements.class);
            calendarView.calendarDay16CurrMonth.click();
            calendarView.calendarMonthField.click();
            calendarView.calendarMonthAug.click();
            calendarView.calendarYearField.click();
            calendarView.calendarYearTen.click();

            //Step: validate that the activity displays as expected for 8/16/2015
            WebElement activityItemLnk = driver.findElement(By.xpath("//*[@id='calendar_view']//h3[text() = '" + newActivityRegarding + "']"));
            if(commNav.isWebElementPresent(viewName + ", Activity Added ", activityItemLnk)) {
                System.out.println("VP: activity " + newActivityRegarding + " added appearing under the correct day/ month/ year - PASSED");
            } else {
                System.out.println("VP: activity " + newActivityRegarding + " added appearing under the correct day/ month/ year - FAILED");
                AssertJUnit.fail("test failed");
            }

            //Step: open the activity detail view and confirm that the start time displays as the original value of 8/16/2015 9:30 AM/PM
            activityItemLnk.click();
            commNav.waitForPage(newActivityRegarding);
            activityEditView.activityDetailViewMoreDetailsTab.click();
            String originalStartTimePlusMins = originalStartTime.replace("30", "30:00");
            System.out.println("VP: activity detail 'start time' value is ... " + activityEditView.activityDetailViewStartTimeFld.getText());
            AssertJUnit.assertEquals("VP: activity detail view 'start time' equals original 'start time' that was confirmed - FAILED", originalStartTimePlusMins, activityEditView.activityDetailViewStartTimeFld.getText());
            System.out.println("VP: activity detail view 'start time' equals original 'start time' that was confirmed - PASSED");

            System.out.println("VP: Calendar/ time control - where date/ time value is confirmed, then date/ time value is cancelled, the saved date has the incorrect month and year - PASSED");

        }

        catch (Exception e) {
            verificationErrors.append(methodID + "(): " + e.toString());
            System.out.println("VP: Calendar/ time control - where date/ time value is confirmed, then date/ time value is cancelled, the saved date has the incorrect month and year - FAILED");
            AssertJUnit.fail("test failed");
        }

        System.out.println(ENDLINE);
    }


    @Test(enabled = true)
    // INFORCRM-4948 ... Calendar/ time control - date/ time displayed on opening control is not the value of the field from which it was opened
    public void test15_INFORCRM4948() throws Exception {
        String methodID = "test15_INFORCRM4948";

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

            //Step: Open Start Time calendar, and wait for modal calendar control to open
            activityEditView.activityEditViewStartTimeFldBtn.click();
            Thread.sleep(1000);
            driver.switchTo().activeElement();

            //Step: Press Advanced button to open Calendar view
            calendarView.calendarModalAdvanced.click();

            //Step: on the calendar modal control, set the date/time to ... 8/16/2015 9:30 AM/PM
            //Set day to 16 and save that value from the calendar control
            calendarView.calendarModalDay16CurrMonth.click();
            String activityDay1 = calendarView.calendarModalDay16CurrMonth.getText();
            System.out.println("VP: activity - on creation in calendar control, day has a value of ... " + activityDay1);

            //Set month to August and save that value from the calendar control
            calendarView.calendarModalCurrMonthValue.click();
            calendarView.calendarModalMonthAug.click();
            String activityMonth1 = calendarView.calendarModalCurrMonthValue.getAttribute("value");
            System.out.println("VP: activity - on creation in calendar control, month has a value of ... " + activityMonth1);

            //Set year to Year 10 (2015) and save that value from the calendar control
            calendarView.calendarModalCurrYearValue.click();
            calendarView.calendarModalYearTen.click();
            String activityYear1 = calendarView.calendarModalCurrYearValue.getAttribute("value");
            System.out.println("VP: activity - on creation in calendar control, year has a value of ... " + activityYear1);

            //Set hours to 9 and save that value from the calendar control
            calendarView.calendarHourField.click();
            calendarView.calendarHourNine.click();
            String activityHour1 = calendarView.calendarHourField.getAttribute("value");
            System.out.println("VP: activity - on creation in calendar control, hour has a value of ... " + activityHour1);

            //Set minutes to 30 and save that value from the calendar control
            calendarView.calendarMinuteField.click();
            calendarView.calendarMinute30.click();
            String activityMins1 = calendarView.calendarMinuteField.getAttribute("value");
            System.out.println("VP: activity - on creation in calendar control, minutes has a value of ... " + activityMins1);

            //Confirm the date/ time value chosen
            calendarView.calendarModalConfirm.click();
            Thread.sleep(1000);
            driver.switchTo().activeElement();
            commNav.waitForPage("Meeting");

            //Step: save the activity
            headerButton.clickHeaderButton("save");
            commNav.waitForPage("Calendar");

            //Step: place focus on calendar for 8/16/2015
            calendarView = PageFactory.initElements(driver, CalendarViewsElements.class);
            calendarView.calendarDay16CurrMonth.click();
            calendarView.calendarMonthField.click();
            calendarView.calendarMonthAug.click();
            calendarView.calendarYearField.click();
            calendarView.calendarYearTen.click();

            //Step: validate that the activity displays as expected for 8/16/2015
            WebElement activityItemLnk = driver.findElement(By.xpath("//*[@id='calendar_view']//h3[text() = '" + newActivityRegarding + "']"));
            if(commNav.isWebElementPresent(viewName + ", Activity Added ", activityItemLnk)) {
                System.out.println("VP: activity " + newActivityRegarding + " added appearing under the correct day/ month/ year - PASSED");
            } else {
                System.out.println("VP: activity " + newActivityRegarding + " added appearing under the correct day/ month/ year - FAILED");
                AssertJUnit.fail("test failed");
            }

            //Step: re-open the activity detail view and choose to edit
            activityItemLnk.click();
            commNav.waitForPage(newActivityRegarding);
            headerButton.clickHeaderButton("edit");
            commNav.waitForPage("Meeting");

            //Step: for 'start time' open the calendar control
            activityEditView.activityEditViewStartTimeFldBtn.click();
            Thread.sleep(1000);
            driver.switchTo().activeElement();

            //Step: Press Advanced button to open Calendar view, and verify that the expected values are displaying for day, month, year, hours and minutes
            calendarView = PageFactory.initElements(driver, CalendarViewsElements.class);
            calendarView.calendarModalAdvanced.click();
            System.out.println("VP: activity - on editing in calendar control, day has a value of ... " + calendarView.calendarModalDaySelected.getText());
            System.out.println("VP: activity - on editing in calendar control, month has a value of ... " + calendarView.calendarModalCurrMonthValue.getAttribute("value"));
            System.out.println("VP: activity - on editing in calendar control, year has a value of ... " + calendarView.calendarModalCurrYearValue.getAttribute("value"));
            System.out.println("VP: activity - on editing in calendar control, hour has a value of ... " + calendarView.calendarHourField.getAttribute("value"));
            System.out.println("VP: activity - on editing in calendar control, minutes has a value of ... " + calendarView.calendarMinuteField.getAttribute("value"));

            AssertJUnit.assertEquals("VP: activity 'start time' day selected is as expected - FAILED", activityDay1, calendarView.calendarModalDaySelected.getText());
            System.out.println("VP: activity 'start time' day selected is as expected - PASSED");
            AssertJUnit.assertEquals("VP: activity 'start time' month selected is as expected - FAILED", activityMonth1, calendarView.calendarModalCurrMonthValue.getAttribute("value"));
            System.out.println("VP: activity 'start time' month selected is as expected - PASSED");
            AssertJUnit.assertEquals("VP: activity 'start time' year selected is as expected - FAILED", activityYear1, calendarView.calendarModalCurrYearValue.getAttribute("value"));
            System.out.println("VP: activity 'start time' year selected is as expected - PASSED");
            AssertJUnit.assertEquals("VP: activity 'start time' hour selected is as expected - FAILED", activityHour1, calendarView.calendarHourField.getAttribute("value"));
            System.out.println("VP: activity 'start time' hour selected is as expected - PASSED");
            AssertJUnit.assertEquals("VP: activity 'start time' minutes selected is as expected - FAILED", activityMins1, calendarView.calendarMinuteField.getAttribute("value"));
            System.out.println("VP: activity 'start time' minutes selected is as expected - PASSED");


            System.out.println("VP: Calendar/ time control - date/ time displayed on opening control is not the value of the field from which it was opened - PASSED");

        }

        catch (Exception e) {
            verificationErrors.append(methodID + "(): " + e.toString());
            System.out.println("VP: Calendar/ time control- date/ time displayed on opening control is not the value of the field from which it was opened - FAILED");
            AssertJUnit.fail("test failed");
        }

        System.out.println(ENDLINE);
    }


    @Test(enabled = true)
    // INFORCRM-6527 ... Calendar screen - month and year dropdowns stop working after modal calendar opened
    public void test16_INFORCRM6527() throws Exception {
        String methodID = "test16_INFORCRM6527";

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

            //Step: Press Advanced button to open modal Calendar control
            calendarView.calendarModalAdvanced.click();

            //Cancel out of the modal calendar control
            calendarView.calendarModalCancel.click();
            Thread.sleep(1000);
            driver.switchTo().activeElement();
            commNav.waitForPage("Meeting");

            //Step: cancel the new activity, to return to the Calendar screen
            headerButton.clickHeaderButton("cancel");
            commNav.waitForPage("Calendar");

            //Step: check to see if the month dropdown is working on the Calendar screen
            calendarView.calendarMonthField.click();
            calendarView.calendarMonthJan.click();
            String currentMonth = "January";
            System.out.println("Month value is ... " + calendarView.calendarMonthField.getAttribute("value"));
            AssertJUnit.assertEquals("VP: Pressing 'January' month from dropdown displays that value in the month field - FAILED", currentMonth, calendarView.calendarMonthField.getAttribute("value"));
            System.out.println("VP: Pressing 'January' month from dropdown displays that value in the month field - PASSED");

            //Step: check to see if the year dropdown is working on the Calendar screen
            calendarView.calendarYearField.click();
            calendarView.calendarYearTopItem.click();
            String topYear = calendarView.calendarYearTopItem.getAttribute("data-value");
            System.out.println("Top year value is ... " + calendarView.calendarYearField.getAttribute("value"));
            AssertJUnit.assertEquals("VP: Pressing top year from dropdown displays that value in the year field - FAILED", topYear, calendarView.calendarYearField.getAttribute("value"));
            System.out.println("VP: Pressing top year from dropdown displays that value in the year field - PASSED");

            System.out.println("VP: Calendar screen - month and year dropdowns stop working after modal calendar opened  - PASSED");

        }

        catch (Exception e) {
            verificationErrors.append(methodID + "(): " + e.toString());
            System.out.println("VP: Calendar screen - month and year dropdowns stop working after modal calendar opened  - FAILED");
            AssertJUnit.fail("test failed");
        }

        System.out.println(ENDLINE);
    }


    @Test(enabled = true)
    // NOTE : this method covers both INFORCRM-6887 and INFORCRM-6888

    // INFORCRM-6887 ... Add Recurring Activity problems - contact and opportunity display as ID's, 'repeats' as [object Object], and may not save
    public void test17_INFORCRM6887_6888() throws Exception {
        String methodID = "test17_INFORCRM-6887_6888";

        CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
        CommonViewsElements commView = PageFactory.initElements(driver, CommonViewsElements.class);
        HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);
        MyActivityViewsElements activityEditView = PageFactory.initElements(driver, MyActivityViewsElements.class);
        AccountViewsElements accountsListView = PageFactory.initElements(driver, AccountViewsElements.class);
        ContactViewsElements contactsListView = PageFactory.initElements(driver, ContactViewsElements.class);
        OpportunityViewsElements opportunitiesListView = PageFactory.initElements(driver, OpportunityViewsElements.class);


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

            //Step: press button for the 'repeats' field, then choose 'Daily'
            activityEditView.activityEditViewRepeatsFldBtn.click();
            commNav.waitForPage("Recurring");
            activityEditView.activityRecurringDailyFld.click();
            commNav.waitForPage("Meeting");

            //Step: choose an account for the activity
            activityEditView.activityEditViewAccountBtn.click();
            commNav.waitForPage("Accounts");
            commView.lookupTxtBox.sendKeys(TEST_ACCOUNT_RECORD);
            commView.lookupTxtBox.sendKeys(Keys.RETURN);
            Thread.sleep(500);
            accountsListView.relatedAccountsListViewTopItem.click();
            commNav.waitForPage("Meeting");

            //Step: choose a contact for the activity
            activityEditView.activityEditViewContactBtn.click();
            commNav.waitForPage("Contacts");
            commView = PageFactory.initElements(driver, CommonViewsElements.class);
            commView.lookupTxtBox.sendKeys(TEST_CONTACT_RECORD);
            commView.lookupTxtBox.sendKeys(Keys.RETURN);
            Thread.sleep(500);
            contactsListView.relatedContactsListViewTopItem.click();
            commNav.waitForPage("Meeting");

            //Step: choose an opportunity for the activity
            activityEditView.activityEditViewOpportunityBtn.click();
            commNav.waitForPage("Opportunities");
            commView = PageFactory.initElements(driver, CommonViewsElements.class);
            commView.lookupTxtBox.sendKeys(TEST_OPPORTUNITY_RECORD3);
            commView.lookupTxtBox.sendKeys(Keys.RETURN);
            Thread.sleep(500);
            opportunitiesListView.topRelatedOpportunitiesListItem.click();
            commNav.waitForPage("Meeting");

            //Step: verify that 'repeats' on the insert activity screen displays as 'Daily'
            String activityRepeatsValue = activityEditView.activityEditViewRepeatsFld.getAttribute("value");
            System.out.println("VP: on activity insert screen, 'repeats' has a value of ... " + activityRepeatsValue);
            AssertJUnit.assertEquals("VP: Insert Activity 'repeats' field displays with chosen value of 'Daily' - FAILED","Daily",activityRepeatsValue);
            System.out.println("VP: Insert Activity 'repeats' field displays with chosen value of 'Daily' - PASSED");

            //Step: verify that contact on the insert activity screen displays as expected
            String activityContactValue = activityEditView.activityEditViewContactFld.getAttribute("value");
            System.out.println("VP: on activity insert screen, 'contact' has a value of ... " + activityContactValue);
            AssertJUnit.assertEquals("VP: Insert Activity 'contact' field displays with chosen value of " + TEST_CONTACT_RECORD + " - FAILED",TEST_CONTACT_RECORD,activityContactValue);
            System.out.println("VP: Insert Activity 'contact' field displays with chosen value of " + TEST_CONTACT_RECORD + " - PASSED");

            //Step: verify that opportunity on the insert activity screen displays as expected
            String activityOpportunityValue = activityEditView.activityEditViewOpportunityFld.getAttribute("value");
            System.out.println("VP: on activity insert screen, 'opportunity' has a value of ... " + activityOpportunityValue);
            AssertJUnit.assertEquals("VP: Insert Activity 'opportunity' field displays with chosen value of " + TEST_OPPORTUNITY_RECORD3 + " - FAILED",TEST_OPPORTUNITY_RECORD3,activityOpportunityValue);
            System.out.println("VP: Insert Activity 'opportunity' field displays with chosen value of " + TEST_OPPORTUNITY_RECORD3 + " - PASSED");

            //Step: save the activity
            headerButton.clickHeaderButton("Save");
            commNav.waitForPage("Calendar");

            //Step: verify that save of recurring activity worked, and one is positioned back on the Calendar screen
            AssertJUnit.assertEquals("VP: Recurring Activity saved as expected - FAILED", "Calendar", driver.findElement(By.id("pageTitle")).getText());
            System.out.println("VP: Recurring Activity saved as expected - PASSED");

            System.out.println("VP: Add Recurring Activity problems (INFORCRM-6887) - contact and opportunity display as ID's, 'repeats' as [object Object], and may not save - PASSED");


            // INFORCRM-6888 ... Activity - for Complete Occurrence/ Series screen, contact and opportunity display as ID's, 'follow-up' as [object Object], and completion won't save

            //Step: locate the activity for the currently selected day of the month
            WebElement activityItemLnk = driver.findElement(By.xpath("//*[@id='calendar_view']//h3[text() = '" + newActivityRegarding + "']"));
            activityItemLnk.click();
            commNav.waitForPage(newActivityRegarding);

            //Step: press link on detail view to complete the activity series
            activityEditView.activityDetailViewCompleteSeriesLnk.click();
            commNav.waitForPage("Complete Series");
            activityEditView.activityCompleteViewFollowUpBtn.click();
            commNav.waitForPage("Follow-up type");
            activityEditView.activityFollowUpSchedulePhoneCallBtn.click();
            commNav.waitForPage("Complete Series");

            //Step: verify that 'follow-up' on the complete series screen displays as 'Phone Call'
            String activityFollowUpValue = activityEditView.activityCompleteViewFollowUpFld.getAttribute("value");
            System.out.println("VP: on activity Complete Series screen, 'follow-up' has a value of ... " + activityFollowUpValue);
            AssertJUnit.assertEquals("VP: Complete Series Activity 'follow-up' field displays with chosen value of 'Phone Call' - FAILED","Phone Call",activityFollowUpValue);
            System.out.println("VP: Complete Series Activity 'follow-up' field displays with chosen value of 'Phone Call' - PASSED");

            //Step: verify that contact on the activity Complete Series screen displays as expected
            activityContactValue = activityEditView.activityCompleteViewContactFld.getAttribute("value");
            System.out.println("VP: on activity Complete Series screen, 'contact' has a value of ... " + activityContactValue);
            AssertJUnit.assertEquals("VP: activity Complete Series 'contact' field displays with chosen value of " + TEST_CONTACT_RECORD + " - FAILED",TEST_CONTACT_RECORD,activityContactValue);
            System.out.println("VP: activity Complete Series 'contact' field displays with chosen value of " + TEST_CONTACT_RECORD + " - PASSED");

            //Step: verify that opportunity on the activity Complete Series screen displays as expected
            activityOpportunityValue = activityEditView.activityCompleteViewOpportunityFld.getAttribute("value");
            System.out.println("VP: on activity Complete Series screen, 'opportunity' has a value of ... " + activityOpportunityValue);
            AssertJUnit.assertEquals("VP: activity Complete Series 'opportunity' field displays with chosen value of " + TEST_OPPORTUNITY_RECORD3 + " - FAILED",TEST_OPPORTUNITY_RECORD3,activityOpportunityValue);
            System.out.println("VP: activity Complete Series 'opportunity' field displays with chosen value of " + TEST_OPPORTUNITY_RECORD3 + " - PASSED");

            headerButton.clickHeaderButton("Save");
            commNav.waitForPage("Phone Call");

            //Step: verify that save of completion worked, and one is positioned on the Phone Call screen, ready for the follow-up activity
            AssertJUnit.assertEquals("VP: Activity Completion - completion saved as expected - FAILED", "Phone Call", driver.findElement(By.id("pageTitle")).getText());
            System.out.println("VP: Activity Completion - completion saved as expected - PASSED");

            System.out.println("VP: Activity - for Complete Occurrence/ Series screen (INFORCRM-6888), contact and opportunity display as ID's, 'follow-up' as [object Object], and completion won't save - PASSED");

        }

        catch (Exception e) {
            verificationErrors.append(methodID + "(): " + e.toString());
            System.out.println("VP: insert recurring activity/ complete recurring activity - contact and opportunity display as ID's, 'repeats'/ 'follow-up' as [object Object] - FAILED");
            AssertJUnit.fail("test failed");
        }

        System.out.println(ENDLINE);
    }


    @Test(enabled = true)
    // INFORCRM-7247 ... Calendar select control - incorrect year may display on control per scenario ... on confirm does appear correctly on edit view
    public void test18_INFORCRM7247_1() throws Exception {
        String methodID = "test18_INFORCRM7247_1";

        CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
        HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);
        MyActivityViewsElements activityEditView = PageFactory.initElements(driver, MyActivityViewsElements.class);
        CalendarViewsElements calendarView = PageFactory.initElements(driver, CalendarViewsElements.class);


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

            //Step: save the current value for the 'start time' ... will be 'today' with an appropriate time
            String activityInitialStartTimeToday = activityEditView.activityEditViewStartTimeFld.getAttribute("value");
            System.out.println("VP: initial value for the activity 'start time' (defaults to 'today') is ... " + activityInitialStartTimeToday);

            //Step: Open Start Time calendar, then press Advanced, and wait for modal calendar control to open
            activityEditView.activityEditViewStartTimeFldBtn.click();
            Thread.sleep(1000);
            driver.switchTo().activeElement();
            calendarView.calendarModalAdvanced.click();

            //Step: save the currently selected values for month and year, which has defaulted to 'today'
            String activityMonthForToday = calendarView.calendarModalCurrMonthValue.getAttribute("value");
            String activityYearForToday = calendarView.calendarModalCurrYearValue.getAttribute("value");

            //Step: set day to 16, month to January, year to one year following the current one
            calendarView.calendarModalDay16CurrMonth.click();
            calendarView.calendarModalCurrMonthValue.click();
            calendarView.calendarModalMonthJan.click();
            calendarView.calendarModalCurrYearValue.click();
            calendarView.calendarModalYearFollowingSelectedYear.click();

            //Step: save and display month and year set for the activity being added
            String activityMonthSet = calendarView.calendarModalCurrMonthValue.getAttribute("value");
            String activityYearSet = calendarView.calendarModalCurrYearValue.getAttribute("value");
            System.out.println("VP: activity start month changed to ... " + activityMonthSet);
            System.out.println("VP: activity start year changed to ... " + activityYearSet);

            //Step: Confirm the date/ time value chosen
            calendarView.calendarModalConfirm.click();
            Thread.sleep(1000);
            driver.switchTo().activeElement();
            commNav.waitForPage("Meeting");

            //Step: save and display the 'start time' for the new activity
            String activityChangedStartTime = activityEditView.activityEditViewStartTimeFld.getAttribute("value");
            System.out.println("VP: changed value for the activity 'start time' is ...  " + activityChangedStartTime);


            //Step: save the activity
            headerButton.clickHeaderButton("Save");
            commNav.waitForPage("Calendar");

            //Step: on the Calendar screen (defaults to today's date) select day 16, month of January and one year following the current year
            calendarView.calendarDay16CurrMonth.click();
            calendarView.calendarMonthField.click();
            calendarView.calendarMonthJan.click();
            calendarView.calendarYearField.click();
            calendarView.calendarYearFollowingSelectedYear.click();

            //Step: locate the activity for the currently selected day of the month
            WebElement activityItemLnk = driver.findElement(By.xpath("//*[@id='calendar_view']//h3[text() = '" + newActivityRegarding + "']"));
            activityItemLnk.click();
            commNav.waitForPage(newActivityRegarding);

            //Step: choose to edit the activity
            headerButton.clickHeaderButton("edit");
            commNav.waitForPage("Meeting");

            //Step: Open Start Time calendar ... relative calendar
            activityEditView.activityEditViewStartTimeFldBtn.click();
            Thread.sleep(1000);
            driver.switchTo().activeElement();

            //Step: Press Advanced button to open Calendar control
            calendarView = PageFactory.initElements(driver, CalendarViewsElements.class);
            calendarView.calendarModalAdvanced.click();

            //Step: set year to one year past the current activity year (equals two years past the current year)
            activityYearSet = calendarView.calendarModalCurrYearValue.getAttribute("value");
            System.out.println("VP: activity start year was previously set to ... " + activityYearSet);
            calendarView.calendarModalCurrYearValue.click();
            calendarView.calendarModalYearFollowingSelectedYear.click();
            String activityYearEdited = calendarView.calendarModalCurrYearValue.getAttribute("value");
            System.out.println("VP: activity start year has been changed to ... " + activityYearEdited);

            //Step: press 'TODAY' button, and save values for month and year
            calendarView.calendarModalTodayBtn.click();
            String activityMonthFinal = calendarView.calendarModalCurrMonthValue.getAttribute("value");
            String activityYearFinal = calendarView.calendarModalCurrYearValue.getAttribute("value");
            System.out.println("VP: on pressing 'TODAY' button, activity year has been reset to ... " + activityYearFinal);
            System.out.println("VP: on pressing 'TODAY' button, activity month has been reset to ... " + activityMonthFinal);

            //Step: verify that the year and month display as expected for 'today'
            AssertJUnit.assertEquals("VP: on pressing calendar control 'TODAY button, activity year value on calendar has been reset to that for 'today'... " + activityYearFinal + " - FAILED", activityYearForToday, activityYearFinal);
            System.out.println("VP: on pressing calendar control 'TODAY button, activity year value on calendar has been reset to that for 'today'... " + activityYearFinal + " - PASSED");
            AssertJUnit.assertEquals("VP: on pressing calendar control 'TODAY button, activity month value on calendar has been reset to that for 'today'... " + activityMonthFinal + " - FAILED", activityMonthForToday, activityMonthFinal);
            System.out.println("VP: on pressing calendar control 'TODAY button, activity month value on calendar has been reset to that for 'today'... " + activityMonthFinal + " - PASSED");

            //Step: press Confirm for the date/time
            calendarView.calendarModalConfirm.click();
            Thread.sleep(1000);
            driver.switchTo().activeElement();
            commNav.waitForPage("Meeting");

            //Step: verify the the date/time on the edit view is the same as it was initially on the insert view, where today's date was being used
            String activityFinalStartTime = activityEditView.activityEditViewStartTimeFld.getAttribute("value");
            System.out.println("VP: after resetting 'start time' to TODAY, value for the activity 'start time' on the edit view is  ... " + activityFinalStartTime);
            AssertJUnit.assertEquals("VP: on pressing calendar control 'TODAY button, activity 'start time' value on the edit view has been reset to that for 'today' - FAILED", activityInitialStartTimeToday, activityFinalStartTime);
            System.out.println("VP: on pressing calendar control 'TODAY button, activity 'start time' value on the edit view has been reset to that for 'today' - PASSED");

            System.out.println("VP: Calendar select control - incorrect year may display on control per scenario ... on confirm does appear correctly on edit view - PASSED");

        }

        catch (Exception e) {
            verificationErrors.append(methodID + "(): " + e.toString());
            System.out.println("VP: Calendar select control - incorrect year may display on control per scenario ... on confirm does appear correctly on edit view - FAILED");
            AssertJUnit.fail("test failed");
        }

        System.out.println(ENDLINE);
    }



    @Test(enabled = true)
    // INFORCRM-7247 ... Calendar select control - incorrect month may display on control per scenarios ... on confirm does appear correctly on edit view
    public void test19_INFORCRM7247_2() throws Exception {
        String methodID = "test19_INFORCRM7247_2";

        CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
        HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);
        MyActivityViewsElements activityEditView = PageFactory.initElements(driver, MyActivityViewsElements.class);
        CalendarViewsElements calendarView = PageFactory.initElements(driver, CalendarViewsElements.class);


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

            //Step: save the current value for the 'start time' ... will be 'today' with an appropriate time
            String activityInitialStartTimeToday = activityEditView.activityEditViewStartTimeFld.getAttribute("value");
            System.out.println("VP: initial value for the activity 'start time' (defaults to 'today') is ... " + activityInitialStartTimeToday);

            //Step: Open Start Time calendar, then press Advanced, and wait for modal calendar control to open
            activityEditView.activityEditViewStartTimeFldBtn.click();
            Thread.sleep(1000);
            driver.switchTo().activeElement();
            calendarView.calendarModalAdvanced.click();

            //Step: save the currently selected values for month and year, which has defaulted to 'today'
            String activityMonthForToday = calendarView.calendarModalCurrMonthValue.getAttribute("value");
            String activityYearForToday = calendarView.calendarModalCurrYearValue.getAttribute("value");

            //Step: set day to 16, month to January, year to one year following the current one
            calendarView.calendarModalDay16CurrMonth.click();
            calendarView.calendarModalCurrMonthValue.click();
            calendarView.calendarModalMonthJan.click();
            calendarView.calendarModalCurrYearValue.click();
            calendarView.calendarModalYearFollowingSelectedYear.click();

            //Step: save and display month and year set for the activity being added
            String activityMonthSet = calendarView.calendarModalCurrMonthValue.getAttribute("value");
            String activityYearSet = calendarView.calendarModalCurrYearValue.getAttribute("value");
            System.out.println("VP: activity start month changed to ... " + activityMonthSet);
            System.out.println("VP: activity start year changed to ... " + activityYearSet);

            //Step: Confirm the date/ time value chosen
            calendarView.calendarModalConfirm.click();
            Thread.sleep(1000);
            driver.switchTo().activeElement();
            commNav.waitForPage("Meeting");

            //Step: save and display the 'start time' for the new activity
            String activityChangedStartTime = activityEditView.activityEditViewStartTimeFld.getAttribute("value");
            System.out.println("VP: changed value for the activity 'start time' is ...  " + activityChangedStartTime);


            //Step: save the activity
            headerButton.clickHeaderButton("Save");
            commNav.waitForPage("Calendar");

            //Step: on the Calendar screen (defaults to today's date) select day 16, month of January and one year following the current year
            calendarView.calendarDay16CurrMonth.click();
            calendarView.calendarMonthField.click();
            calendarView.calendarMonthJan.click();
            calendarView.calendarYearField.click();
            calendarView.calendarYearFollowingSelectedYear.click();

            //Step: locate the activity for the currently selected day of the month
            WebElement activityItemLnk = driver.findElement(By.xpath("//*[@id='calendar_view']//h3[text() = '" + newActivityRegarding + "']"));
            activityItemLnk.click();
            commNav.waitForPage(newActivityRegarding);

            //Step: choose to edit the activity
            headerButton.clickHeaderButton("edit");
            commNav.waitForPage("Meeting");

            //Step: Open Start Time calendar ... relative calendar
            activityEditView.activityEditViewStartTimeFldBtn.click();
            Thread.sleep(1000);
            driver.switchTo().activeElement();

            //Step: Press Advanced button to open Calendar control
            calendarView = PageFactory.initElements(driver, CalendarViewsElements.class);
            calendarView.calendarModalAdvanced.click();

            //Step: set month to February
            activityMonthSet = calendarView.calendarModalCurrMonthValue.getAttribute("value");
            System.out.println("VP: activity start month was previously set to ... " + activityMonthSet);
            calendarView.calendarModalCurrMonthValue.click();
            calendarView.calendarModalMonthFeb.click();
            String activityMonthEdited = calendarView.calendarModalCurrMonthValue.getAttribute("value");
            System.out.println("VP: activity start month has been changed to ... " + activityMonthEdited);

            //Step: press 'TODAY' button, and save values for month and year
            calendarView.calendarModalTodayBtn.click();
            String activityMonthFinal = calendarView.calendarModalCurrMonthValue.getAttribute("value");
            String activityYearFinal = calendarView.calendarModalCurrYearValue.getAttribute("value");
            System.out.println("VP: on pressing 'TODAY' button, activity year has been reset to ... " + activityYearFinal);
            System.out.println("VP: on pressing 'TODAY' button, activity month has been reset to ... " + activityMonthFinal);

            //Step: verify that the year and month display as expected for 'today'
            AssertJUnit.assertEquals("VP: on pressing calendar control 'TODAY button, activity year value on calendar has been reset to that for 'today'... " + activityYearFinal + " - FAILED", activityYearForToday, activityYearFinal);
            System.out.println("VP: on pressing calendar control 'TODAY button, activity year value on calendar has been reset to that for 'today'... " + activityYearFinal + " - PASSED");
            AssertJUnit.assertEquals("VP: on pressing calendar control 'TODAY button, activity month value on calendar has been reset to that for 'today'... " + activityMonthFinal + " - FAILED", activityMonthForToday, activityMonthFinal);
            System.out.println("VP: on pressing calendar control 'TODAY button, activity month value on calendar has been reset to that for 'today'... " + activityMonthFinal + " - PASSED");

            //Step: press Confirm for the date/time
            calendarView.calendarModalConfirm.click();
            Thread.sleep(1000);
            driver.switchTo().activeElement();
            commNav.waitForPage("Meeting");

            //Step: verify the the date/time on the edit view is the same as it was initially on the insert view, where today's date was being used
            String activityFinalStartTime = activityEditView.activityEditViewStartTimeFld.getAttribute("value");
            System.out.println("VP: after resetting 'start time' to TODAY, value for the activity 'start time' on the edit view is  ... " + activityFinalStartTime);
            AssertJUnit.assertEquals("VP: on pressing calendar control 'TODAY button, activity 'start time' value on the edit view has been reset to that for 'today' - FAILED", activityInitialStartTimeToday, activityFinalStartTime);
            System.out.println("VP: on pressing calendar control 'TODAY button, activity 'start time' value on the edit view has been reset to that for 'today' - PASSED");

            System.out.println("VP: Calendar select control - incorrect month may display on control per scenario ... on confirm does appear correctly on edit view - PASSED");

        }

        catch (Exception e) {
            verificationErrors.append(methodID + "(): " + e.toString());
            System.out.println("VP: Calendar select control - incorrect month may display on control per scenario ... on confirm does appear correctly on edit view - FAILED");
            AssertJUnit.fail("test failed");
        }

        System.out.println(ENDLINE);
    }


    @Test(enabled = true)
    // INFORCRM-7168 ... Activities - on saving the edited occurrence of a recurring activity, there is no error
    public void test20_INFORCRM7168() throws Exception {
        String methodID = "test20_INFORCRM7168";

        // Test Params:
        String entityType = "Accounts";
        String entityRecord = TEST_ACCOUNT_RECORD;

        CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
        HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);
        MyActivityViewsElements activityEditView = PageFactory.initElements(driver, MyActivityViewsElements.class);

        System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);


        try {

            //Step: login & log back in (to clear cookies)
            LogOutThenLogBackIn(userName, userPwd);

            //Step: search for Account entity, then open it's Detail view
            commNav.entityRecordOpenDetailView(entityType, entityRecord);

            AccountViewsElements accountDetailView = PageFactory.initElements(driver, AccountViewsElements.class);

            //Step: check each item under the Account Detail View, Related Items section
            commNav.highlightNClick(accountDetailView.accountDetailViewRelatedItemsTab);
            commNav.highlightNClick(accountDetailView.accountDetailViewActivitiesLnk);
            commNav.waitForPage("Activities");

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

            //Step: open the repeats screen, and choose Daily ... 3 occurrences
            activityEditView.activityEditViewRepeatsFldBtn.click();
            commNav.waitForPage("Recurring");
            activityEditView.activityRecurringDailyFld.click();
            commNav.waitForPage("Meeting");
            activityEditView.activityEditViewRecurringFldBtn.click();
            commNav.waitForPage("Recurrence");
            activityEditView.activityRecurrenceOccurencesFld.clear();
            activityEditView.activityRecurrenceOccurencesFld.sendKeys("3");
            headerButton.clickHeaderButton("accept");
            commNav.waitForPage("Meeting");

            //Step: save the recurring activity
            headerButton.clickHeaderButton("Save");
            commNav.waitForPage("Activities");

            //Step: verify that 3 occurrences of the recurring activity display under account Activities view
            List elements = driver.findElements(By.xpath("//*[@id='activity_related']//h3//span[text() = '" + newActivityRegarding + "']"));

            if(elements.size() == 3) {
                System.out.println("VP: there are 3 occurrences of activity " + newActivityRegarding + " on the account Activities' list - PASSED");
            } else {
                System.out.println("VP: there are 3 occurrences of activity " + newActivityRegarding + " on the account Activities' list - FAILED");
                AssertJUnit.fail("test failed");
            }

            //Step: locate and open the first activity occurrence that has been created
            WebElement activityItemLnk1 = driver.findElement(By.xpath("(//*[@id='activity_related']//h3//span[text() = '" + newActivityRegarding + "'])[1]"));
            activityItemLnk1.click();
            String fullActivityRegarding = "Meeting - Regarding: " + newActivityRegarding;
            commNav.waitForPage(fullActivityRegarding);

            //Step: choose to edit the activity ... for the popup window, press Cancel to edit a single occurrence
            headerButton.clickHeaderButton("edit");
            driver.switchTo().alert().dismiss();
            commNav.waitForPage("Meeting");

            //Step: edit the regarding field, then save the activity
            activityEditView = PageFactory.initElements(driver, MyActivityViewsElements.class);
            activityEditView.activityEditViewRegardingFld.click();
            activityEditView.activityEditViewRegardingFld.sendKeys("-1");
            headerButton.clickHeaderButton("save");
            String editedFullActivityRegarding = fullActivityRegarding + "-1";
            String editedActivityRegarding = newActivityRegarding + "-1";
            commNav.waitForPage(editedFullActivityRegarding);

            //Step: verify that the activity occurrence saved successfully, and that one is now positioned on the activity detail view
            AssertJUnit.assertEquals("VP: on saving the edited occurrence of a recurring activity, there is no error, and activity detail view displays - FAILED", editedActivityRegarding, activityEditView.activityDetailViewRegardingFld.getText());
            System.out.println("VP: on saving the edited occurrence of a recurring activity, there is no error and activity detail view displays - PASSED");


        }
        catch (Exception e) {
            verificationErrors.append(methodID + "(): " + e.toString());
            System.out.println(methodID + ": on saving the edited occurrence of a recurring activity, there is no error and activity detail view displays - FAILED");
            AssertJUnit.fail("test failed");
        }


        System.out.println(ENDLINE);
    }


    @Test(enabled = true)
    // Add My Activities as a menu item
    public void test21_AddMyActivities() throws Exception {
        String methodID = "test21_AddMyActivities";

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
    // INFORCRM-7170 ... Activities - editing/ saving an occurrence of a recurring activity from My Activities incorrectly changes all occurrences
    public void test21_INFORCRM7170() throws Exception {
        String methodID = "test21_INFORCRM7170";

        // Test Params:
        String entityType = "Contacts";
        String contactRecord = TEST_CONTACT_RECORD2;

        CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
        CommonViewsElements commView = PageFactory.initElements(driver, CommonViewsElements.class);
        HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);
        MyActivityViewsElements activityEditView = PageFactory.initElements(driver, MyActivityViewsElements.class);
        ContactViewsElements contactDetailView = PageFactory.initElements(driver, ContactViewsElements.class);

        System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);


        try {

            //Step: login & log back in (to clear cookies)
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

            //Step: add an Activity record with a random value for 'regarding'
            String newActivityRegarding = "SeAutoTestActivity-" + new SimpleDateFormat("yyMMddHHmmss").format(new GregorianCalendar().getTime());
            System.out.println("Activity regarding field will be - " + newActivityRegarding);

            activityEditView.activityEditViewRegardingFld.sendKeys(newActivityRegarding);

            //Step: open the repeats screen, and choose Daily ... 3 occurrences
            activityEditView.activityEditViewRepeatsFldBtn.click();
            commNav.waitForPage("Recurring");
            activityEditView.activityRecurringDailyFld.click();
            commNav.waitForPage("Meeting");
            activityEditView.activityEditViewRecurringFldBtn.click();
            commNav.waitForPage("Recurrence");
            activityEditView.activityRecurrenceOccurencesFld.clear();
            activityEditView.activityRecurrenceOccurencesFld.sendKeys("3");
            headerButton.clickHeaderButton("accept");
            commNav.waitForPage("Meeting");

            //Step: choose contact Janet Aceti
            activityEditView.activityEditViewContactBtn.click();
            commNav.waitForPage("Contacts");
            ContactViewsElements contactsListView = PageFactory.initElements(driver, ContactViewsElements.class);
            commView = PageFactory.initElements(driver, CommonViewsElements.class);
            commView.lookupTxtBox.click();
            Thread.sleep(500);
            commView.lookupTxtBox.sendKeys(Keys.BACK_SPACE);
            Thread.sleep(500);
            commView.lookupTxtBox.sendKeys(TEST_CONTACT_RECORD2);
            commView.lookupTxtBox.sendKeys(Keys.RETURN);
            Thread.sleep(3000);
            contactsListView.relatedContactsListViewTopItem.click();
            System.out.println("VP: contact chosen was : " + TEST_CONTACT_RECORD2);
            commNav.waitForPage("Meeting");

            //Step: save the recurring activity
            headerButton.clickHeaderButton("Save");
            commNav.waitForPage("My Activities");

            //Step: search for this activity under My Activities listview
            commView = PageFactory.initElements(driver, CommonViewsElements.class);
            commView.lookupTxtBox.click();
            Thread.sleep(500);
            commView.lookupTxtBox.sendKeys(Keys.BACK_SPACE);
            Thread.sleep(500);
            commView.lookupTxtBox.sendKeys(newActivityRegarding);
            commView.lookupTxtBox.sendKeys(Keys.RETURN);
            Thread.sleep(3000);

            //Step: verify that one occurrence of the recurring activity display under My Activities view
            List elements = driver.findElements(By.xpath("//*[@id='myactivity_list']//ul/li"));

            if(elements.size() == 1) {
                System.out.println("VP: should see one occurrences of activity " + newActivityRegarding + " on the My Activities' listview - PASSED");
            } else {
                System.out.println("VP: should see one occurrences of activity " + newActivityRegarding + " on the My Activities' listview  - FAILED");
                AssertJUnit.fail("test failed");
            }

            //Step: open the activity occurrence that displays under My Activities
            activityEditView.topMyActivitiesListItem.click();
            String fullActivityRegarding = "Meeting - Regarding: " + newActivityRegarding;
            commNav.waitForPage(fullActivityRegarding);

            //Step: choose to edit the activity ... for the popup window, press Cancel to edit a single occurrence
            headerButton.clickHeaderButton("edit");
            driver.switchTo().alert().dismiss();
            commNav.waitForPage("Meeting");

            //Step: edit the regarding field, then save the activity
            activityEditView = PageFactory.initElements(driver, MyActivityViewsElements.class);
            activityEditView.activityEditViewRegardingFld.click();
            activityEditView.activityEditViewRegardingFld.sendKeys("-1");
            headerButton.clickHeaderButton("save");
            String editedFullActivityRegarding = fullActivityRegarding + "-1";
            String editedActivityRegarding = newActivityRegarding + "-1";
            commNav.waitForPage(editedFullActivityRegarding);

            //Step: search for Contact entity, then open it's Detail view
            commNav.entityRecordOpenDetailView(entityType, contactRecord);
            contactDetailView.contactDetailViewRelatedItemsTab.click();
            contactDetailView.contactsDetailViewActivitiesLnk.click();
            commNav.waitForPage("Activities");

            //Step: verify that the 3 activity occurrences display under the contact, with only one of the occurrences having been edited
            //      verify that one sees two occurrences of activity with regarding field unedited
            List elements2 = driver.findElements(By.xpath("//*[@id='activity_related']//span[text() = '" + newActivityRegarding + "']"));

            if(elements2.size() == 2) {
                System.out.println("VP: should see two occurrences of activity with regarding field unedited (" + newActivityRegarding + ") on the contact Activities' listview - PASSED");
            } else {
                System.out.println("VP: should see two occurrences of activity with regarding field unedited (" + newActivityRegarding + ") on the contact Activities' listview  - FAILED");
                AssertJUnit.fail("test failed");
            }

            //      verify that one sees one occurrence of activity with regarding field edited
            List elements3 = driver.findElements(By.xpath("//*[@id='activity_related']//span[text() = '" + editedActivityRegarding + "']"));

            if(elements3.size() == 1) {
                System.out.println("VP: should see one occurrence of activity with regarding field edited (" + editedActivityRegarding + ") on the contact Activities' listview - PASSED");
            } else {
                System.out.println("VP: should see one occurrence of activity with regarding field edited (" + editedActivityRegarding + ") on the contact Activities' listview  - FAILED");
                AssertJUnit.fail("test failed");
            }


        }
        catch (Exception e) {
            verificationErrors.append(methodID + "(): " + e.toString());
            System.out.println(methodID + ": Activities - editing/ saving an occurrence of a recurring activity from My Activities incorrectly changes all occurrences - FAILED");
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
