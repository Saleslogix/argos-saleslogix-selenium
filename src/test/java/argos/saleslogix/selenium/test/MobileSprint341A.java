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


/**
 * @author Kathy Lockyer-Bratton
 * Class: MobileSprint341A
 * Desc.: Test class for some defects or features in Mobile 3.4.1
 */
public class MobileSprint341A extends BaseTest {

    public String TEST_ACCOUNT2_RECORD = "Bank of the Sun";
    public String TEST_CONTACT_RECORD2 = "Aceti, Janet";
    public String TEST_LEAD_RECORD = "Beck, John";
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
