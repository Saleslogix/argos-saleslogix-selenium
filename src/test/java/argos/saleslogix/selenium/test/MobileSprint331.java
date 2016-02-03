package argos.saleslogix.selenium.test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;


/**
 * @author Kathy Lockyer-Bratton
 * Class: MobileSprint331
 * Desc.: Test class for some defects or features in Mobile 3.3.1
 */
public class MobileSprint331 extends BaseTest {

	
	//Test Methods Set
	//================

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
    // INFORCRM-3395 ... Calendar - unable to add more than one activity under 'Month' view ... Schedule page not opening
    //                   Requires that Month view, first day on third row, has no activities
    public void test01_INFORCRM3395() throws Exception {
        String methodID = "test01_INFORCRM3395";

        CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
        HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);
        MyActivityViewsElements activityEditView = PageFactory.initElements(driver, MyActivityViewsElements.class);
        CalendarViewsElements calendarView = PageFactory.initElements(driver, CalendarViewsElements.class);

        System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);


        try {


            //Step: logout & log back in (to clear cookies)
            LogOutThenLogBackIn(userName, userPwd);


            //Step: go to Calendar view ... wait for page Calendar ... already on 'Month' view
            commNav.clickGlobalMenuItem("Calendar");
            commNav.waitForPage("Calendar");

            //Step: click on the Sunday at the start of the 3rd row of days for the month
            calendarView.calendarMonthFirstDayThirdRow.click();


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


            //Step: save activity
            headerButton.clickHeaderButton("Save");


            //Step: wait for page Calendar ... should still be positioned on Month view
            commNav.waitForPage("Calendar");
            calendarView = PageFactory.initElements(driver, CalendarViewsElements.class);


            //Step: focus should still be on the Sunday at the start of the 3rd row of days for the month
            //      ensure that pressing the Add header button opens the 'Schedule' page
            headerButton.clickHeaderButton("Add");
            commNav.waitForPage("Schedule...");
            String pageTitle = "Schedule...";
            AssertJUnit.assertEquals("VP: after creating an activity under Calendar Month view, again pressing Add header button opens the Schedule page - FAILED",pageTitle, driver.findElement(By.id("pageTitle")).getText());
            System.out.println("VP: after creating an activity under Calendar Month view, again pressing Add header button opens the Schedule page - PASSED");

        }


        catch (Exception e) {
            verificationErrors.append(methodID + "(): " + e.toString());
            System.out.println("VP: after creating an activity under Calendar Month view, again pressing Add header button opens the Schedule page - FAILED");
            AssertJUnit.fail("test failed");
        }


        System.out.println(ENDLINE);
    }


    @Test(enabled = true)
    // INFORCRM-3594 ... Date picker off by one month when setting up a Timeless Activity on the first day of the month
    public void test02_INFORCRM3594() throws Exception {
        String methodID = "test02_INFORCRM3594";

        CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
        HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);
        MyActivityViewsElements activityEditView = PageFactory.initElements(driver, MyActivityViewsElements.class);
        CalendarViewsElements calendarView = PageFactory.initElements(driver, CalendarViewsElements.class);


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

            //Step: add an Activity record with a random value for 'regarding'
            String newActivityRegarding = "SeAutoTestActivity-" + new SimpleDateFormat("yyMMddHHmmss").format(new GregorianCalendar().getTime());
            System.out.println("Activity regarding field will be - " + newActivityRegarding);

            activityEditView.activityEditViewRegardingFld.sendKeys(newActivityRegarding);

            //Step: Open Start Time calendar, and wait for page Calendar
            activityEditView.activityEditViewStartTimeFldBtn.click();
            Thread.sleep(1000);
            driver.switchTo().activeElement();

            //Press Advanced button to open Calendar view, and choose 1st day of current month
            calendarView.calendarModalAdvanced.click();
            calendarView.calendarModalDayOneCurrMonth.click();

            System.out.println("VP: value set for Day, where activity not timeless, is ... 1");

            // store the current value for the month
            String initialMonthText;
            initialMonthText = calendarView.calendarModalCurrMonthValue.getAttribute("value");
            System.out.println("VP: initial value for Month, where activity not timeless, is ... " + initialMonthText);

            //Step: accept the date changes
            calendarView.calendarModalConfirm.click();

            Thread.sleep(1000);
            driver.switchTo().activeElement();
            commNav.waitForPage("Meeting");

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


            //Step: open the activity created in edit mode
            headerButton.clickHeaderButton("Edit");

            //Step: wait for page Activity
            commNav.waitForPage("Activity");

            //Step: toggle off the Timeless button
            activityEditView.activityEditViewTimelessTgl.click();
            System.out.println("VP: activity has been set to Timeless");

            //Step: Open Start Time calendar, and wait for page Calendar
            activityEditView.activityEditViewStartTimeFldBtn.click();
            Thread.sleep(1000);
            driver.switchTo().activeElement();

            //Calendar view should display at once, now activity is timeless
            calendarView = PageFactory.initElements(driver, CalendarViewsElements.class);
            //calendarView.calendarModalAdvanced.click();

            //Step: Verify that the correct month is displaying for the activity date
            calendarView = PageFactory.initElements(driver, CalendarViewsElements.class);
            String currentMonthText;
            currentMonthText = calendarView.calendarModalCurrMonthValue.getAttribute("value");
            System.out.println("VP: current value for Month, after activity set to timeless, is ... " + currentMonthText);
            AssertJUnit.assertEquals("VP: DateTimePicker Calendar month not off by a month when setting activity to be timeless on 1st day of the month - FAILED", initialMonthText, currentMonthText);
            System.out.println("VP: DateTimePicker Calendar month not off by a month when setting activity to be timeless on 1st day of the month - PASSED");

        }

        catch (Exception e) {
            verificationErrors.append(methodID + "(): " + e.toString());
            System.out.println("VP: DateTimePicker Calendar month not off by a month when setting activity to be timeless on 1st day of the month - FAILED");
            AssertJUnit.fail("test failed");
        }

        System.out.println(ENDLINE);
    }


    @Test(enabled = false)
    // INFORCRM-3906 ... Calendar - for the first day of the month, activity count may be wrong if there are All-Day activities ... not relevant for Mobile 3.4 upwards
    public void test03_INFORCRM3906() throws Exception {
        String methodID = "test03_INFORCRM3906";

        CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
        HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);
        MyActivityViewsElements activityEditView = PageFactory.initElements(driver, MyActivityViewsElements.class);
        CalendarViewsElements calendarView = PageFactory.initElements(driver, CalendarViewsElements.class);

        System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);


        try {


            //Step: logout & log back in (to clear cookies)
            LogOutThenLogBackIn(userName, userPwd);

            //Step: go to Calendar view ... wait for page Calendar, and press 'Month' button
            commNav.clickGlobalMenuItem("Calendar");
            commNav.waitForPage("Calendar");
            calendarView.calendarDayListToMonthBtn.click();

            //Step: retrieve value for activity count for first day of the month
            String activityCountInitial = calendarView.calendarMonthFirstDayMonthActivityCount.getText();
            System.out.println("VP: Initial value of activity count for first day of current month is - " + activityCountInitial);

            //Step: click on the first day of the month, then click the Add header button to open Activity schedule view
            calendarView.calendarMonthFirstDayMonth.click();
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

            //Step: set the activity to be Timeless
            activityEditView.activityEditViewTimelessTgl.click();
            System.out.println("VP: activity has been set to Timeless");

            //Step: save activity
            headerButton.clickHeaderButton("Save");

            //Step: wait for page Calendar ... should still be positioned on Month view
            commNav.waitForPage("Calendar");
            calendarView = PageFactory.initElements(driver, CalendarViewsElements.class);

            //Step: retrieve value for activity count for first day of the month
            String activityCountFinal = calendarView.calendarMonthFirstDayMonthActivityCount.getText();
            System.out.println("VP: Final value of activity count for first day of current month is - " + activityCountFinal);

            String expectedActivityCount = Integer.toString(Integer.parseInt(activityCountInitial) + 1);
            System.out.println("VP: Expected value of activity count for first day of current month is - " + expectedActivityCount);
            AssertJUnit.assertEquals("VP: after adding an All-Day activity on the first day of the month under Calendar Month view, activity count has been increased by 1 - FAILED",expectedActivityCount, activityCountFinal);
            System.out.println("VP: after adding an All-Day activity on the first day of the month under Calendar Month view, activity count has been increased by 1 - PASSED");

        }


        catch (Exception e) {
            verificationErrors.append(methodID + "(): " + e.toString());
            System.out.println("VP: after adding an All-Day activity on the first day of the month under Calendar Month view, activity count has been increased by 1 - FAILED");
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
