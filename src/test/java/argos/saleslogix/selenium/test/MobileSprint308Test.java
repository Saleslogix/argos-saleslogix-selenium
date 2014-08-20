package argos.saleslogix.selenium.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;


/**
 * Test class that defines test methods for the SLX Mobile Defect (v3.0.4 sprint 8) fixes.
 * 
 * @author kathleen.lockyer-bratton@swiftpage.com
 * @version	1.0
 */
public class MobileSprint308Test extends BaseTest {

    public String TEST_CONTACT_RECORD = "Abbott, John";
    public String TEST_TICKET_RECORD_NULL_CONTACT = "001-00-000002";

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

    @Test(enabled = true)
    // MBL-10408 ... Calendar - date time picker shows wrong 'day' for timeless activities (eg: Wednesday instead of Thursday)
    public void test01_MBL10408() throws Exception {
        String methodID = "test01_MBL10408";

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

            //Step: add an Activity record with a random value for 'regarding'
            String newActivityRegarding = "SeAutoTestActivity-" + new SimpleDateFormat("yyMMddHHmmss").format(new GregorianCalendar().getTime());
            System.out.println("Activity regarding field will be - " + newActivityRegarding);

            activityEditView.activityEditViewRegardingFld.sendKeys(newActivityRegarding);


            //Step: press the timeless toggle button to ON, then retrieve the value for MM/dd/yy
            activityEditView.activityEditViewTimelessTgl.click();
            String newActivityStartDate = activityEditView.activityEditViewStartTimeFld.getAttribute("value");
            System.out.println("Date/time value for Start Date is : " + newActivityStartDate);

            //Step: find the day of the week associated with newActivityStartDate
            SimpleDateFormat ft = new SimpleDateFormat("M/d/yyyy");
            Calendar dateTime1 = Calendar.getInstance();
            dateTime1.setTime(ft.parse(newActivityStartDate));
            ft = new SimpleDateFormat("EEEE");
            String dayOfWeek = ft.format(dateTime1.getTime()).toString();
            System.out.println("Timeless activity date and day of the week is  - " + newActivityStartDate + " : " + dayOfWeek);


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

            //Step: Open Start Time calendar, and wait for page Calendar
            activityEditView.activityEditViewStartTimeFldBtn.click();
            commNav.waitForPage("Calendar");

            //Step: Verify that the correct day of the week is displaying for the activity date
            String calendarDayOfWeek = driver.findElement(By.xpath("//*[@id='datetime-picker-date']/caption")).getText();
            System.out.println("Timeless activity day of the week on the Calendar screen is - " + calendarDayOfWeek);
            System.out.println("Timeless activity date and day of the week is  - " + newActivityStartDate + " : " + dayOfWeek);
            AssertJUnit.assertEquals("VP: Timeless activity day of the week on the Calendar screen is not as expected " + " - FAILED", dayOfWeek, calendarDayOfWeek);
            System.out.println("VP: Timeless activity day of the week on the Calendar screen is as expected " + " - PASSED");

        }

        catch (Exception e) {
            verificationErrors.append(methodID + "(): " + e.toString());
            System.out.println("VP: Timeless activity day of the week on the Calendar screen is not as expected " + " - FAILED");
            AssertJUnit.fail("test failed");
        }

        System.out.println(ENDLINE);
    }


    @Test(enabled = true)
    // MBL-10428 ... for default HashTag testing (Lookup control again above listview covered in MobileDefectTest - test66)
    public void test02_MBL10428() throws Exception {
        String methodID = "test02_MBL10428";


        CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
        HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);


        System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);


        try {
            //Step: logout & log back in (to clear cookies)
            LogOutThenLogBackIn(userName, userPwd);


            commNav.clickGlobalMenuItem("My Activities");
            MyActivityViewsElements myActivitiesListView = PageFactory.initElements(driver, MyActivityViewsElements.class);
            String resultsMsg = "VP: My Activities default hash tag is #this-week";


            String currHashTag = myActivitiesListView.myActivitiesSearchTxtBox.getAttribute("value");
            AssertJUnit.assertEquals(resultsMsg + " - FAILED","#this-week",currHashTag);
            System.out.println(resultsMsg + " - PASSED");


            commNav.clickGlobalMenuItem("Notes/History");
            NotesHistoryViewsElements notesHistoryListView = PageFactory.initElements(driver, NotesHistoryViewsElements.class);
            resultsMsg = "VP: Notes/History default hash tag is blank";


            currHashTag = notesHistoryListView.notesHistorysSearchTxtBox.getAttribute("value");
            AssertJUnit.assertEquals(resultsMsg + " - FAILED","",currHashTag);
            System.out.println(resultsMsg + " - PASSED");


            commNav.clickGlobalMenuItem("Accounts");
            AccountViewsElements accountsListView = PageFactory.initElements(driver, AccountViewsElements.class);
            resultsMsg = "VP: Accounts default hash tag is blank";


            currHashTag = accountsListView.accountsSearchTxtBox.getAttribute("value");
            AssertJUnit.assertEquals(resultsMsg + " - FAILED","",currHashTag);
            System.out.println(resultsMsg + " - PASSED");


            commNav.clickGlobalMenuItem("Contacts");
            ContactViewsElements contactsListView = PageFactory.initElements(driver, ContactViewsElements.class);
            resultsMsg = "VP: Contacts default hash tag is blank";


            currHashTag = contactsListView.contactsSearchTxtBox.getAttribute("value");
            AssertJUnit.assertEquals(resultsMsg + " - FAILED","",currHashTag);
            System.out.println(resultsMsg + " - PASSED");


            commNav.clickGlobalMenuItem("Leads");
            LeadViewsElements leadsListView = PageFactory.initElements(driver, LeadViewsElements.class);
            resultsMsg = "VP: Leads default hash tag is blank";


            currHashTag = leadsListView.leadsSearchTxtBox.getAttribute("value");
            AssertJUnit.assertEquals(resultsMsg + " - FAILED","",currHashTag);
            System.out.println(resultsMsg + " - PASSED");


            commNav.clickGlobalMenuItem("Opportunities");
            OpportunityViewsElements opportunityListView = PageFactory.initElements(driver, OpportunityViewsElements.class);
            resultsMsg = "VP: Opportunities default hash tag is blank";


            currHashTag = opportunityListView.opportunitySearchTxtBox.getAttribute("value");
            AssertJUnit.assertEquals(resultsMsg + " - FAILED","",currHashTag);
            System.out.println(resultsMsg + " - PASSED");


            commNav.clickGlobalMenuItem("Tickets");
            TicketViewsElements ticketListView = PageFactory.initElements(driver, TicketViewsElements.class);
            resultsMsg = "VP: Tickets default hash tag is blank";


            currHashTag = ticketListView.ticketsSearchTxtBox.getAttribute("value");
            AssertJUnit.assertEquals(resultsMsg + " - FAILED","",currHashTag);
            System.out.println(resultsMsg + " - PASSED");


            commNav.clickGlobalMenuItem("My Attachments");
            MyAttachmentsViewsElements myAttachmentsListView = PageFactory.initElements(driver, MyAttachmentsViewsElements.class);
            resultsMsg = "VP: My Attachments default hash tag is blank";


            currHashTag = myAttachmentsListView.myAttachmentsSearchTxtBox.getAttribute("value");
            AssertJUnit.assertEquals(resultsMsg + " - FAILED","",currHashTag);
            System.out.println(resultsMsg + " - PASSED");


        }


        catch (Exception e) {
            verificationErrors.append(methodID + "(): " + e.toString());
            System.out.println("VP: Default hash tags not as expected " + " - FAILED");
            AssertJUnit.fail("test failed");
        }


        System.out.println(ENDLINE);
    }




    @Test(enabled = true)
    // MBL-10433 ... Calendar Month view : timeless activity displays under previous day
    //               Assumes eval data contains no activities for the Sunday at the start of the second row for the month
    public void test03_MBL10433() throws Exception {
        String methodID = "test03_MBL10433";


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


            //Step: click on the Sunday at the start of the 2nd row of days for the month
            calendarView.calendarMonthFirstDaySecondRow.click();


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




            //Step: press the timeless toggle button to ON, then retrieve the value for MM/dd/yy
            activityEditView.activityEditViewTimelessTgl.click();
            String newActivityStartDate = activityEditView.activityEditViewStartTimeFld.getAttribute("value");
            System.out.println("Date/time value for Start Date is : " + newActivityStartDate);


            //Step: save activity
            headerButton.clickHeaderButton("Save");


            //Step: wait for page Calendar ... should still be positioned on Month view
            commNav.waitForPage("Calendar");
            calendarView = PageFactory.initElements(driver, CalendarViewsElements.class);


            //Step: click on the Sunday at the start of the 2nd row of days for the month and verify that activity just created appears for this day
            calendarView.calendarMonthFirstDaySecondRow.click();
            AssertJUnit.assertEquals("VP: A timeless activity is not displaying under the expected day in Calendar Month view " + " - FAILED", "All-Day", calendarView.calendarMonthFirstActivityTime.getText());
            System.out.println("VP: A timeless activity is displaying under the expected day in Calendar Month view " + " - PASSED");
            AssertJUnit.assertEquals("VP: Timeless activity created is not displaying under the expected day in Calendar Month view " + " - FAILED", newActivityRegarding, calendarView.calendarMonthFirstActivityDescription.getText());
            System.out.println("VP: Timeless activity created is displaying under the expected day in Calendar Month view " + " - PASSED");


        }


        catch (Exception e) {
            verificationErrors.append(methodID + "(): " + e.toString());
            System.out.println("VP: Timeless activity created is not displaying under the expected day in Calendar Month view " + " - FAILED");
            AssertJUnit.fail("test failed");
        }


        System.out.println(ENDLINE);
    }




    @Test(enabled = true)
    // MBL-10427 ... Calendar Day view : problems loading activities, don't all display
    //               Assumes eval data contains no activities for the Sunday at the start of the fourth row for the month
    public void test04_MBL10427() throws Exception {
        String methodID = "test04_MBL10427";


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


            //Step: click on the Sunday at the start of the 4th row of days for the month
            calendarView.calendarMonthFirstDayFourthRow.click();


            //Step: click the Add header button to open Activity schedule view (will use date selected) ... 1st activity (meeting)  ****
            headerButton.clickHeaderButton("Add");


            //Step: wait for page Schedule... to open
            commNav.waitForPage("Schedule...");


            //Step: select Meeting for activity type
            activityEditView.activityScheduleMeetingBtn.click();


            //Step: wait for page Meeting to open
            commNav.waitForPage("Meeting");


            //Step: add an Activity record with a random value for 'regarding'
            String newActivityRegarding = "SeAutoTestActivity-1-" + new SimpleDateFormat("yyMMddHHmmss").format(new GregorianCalendar().getTime());
            System.out.println("1st Activity regarding field will be - " + newActivityRegarding);


            activityEditView.activityEditViewRegardingFld.sendKeys(newActivityRegarding);


            //Step: retrieve the value for MM/dd/yy
            String newActivityStartDate = activityEditView.activityEditViewStartTimeFld.getAttribute("value");
            System.out.println("Date/time value for Start Date is : " + newActivityStartDate);


            //Step: save activity
            headerButton.clickHeaderButton("Save");


            //Step: wait for page Calendar ... should still be positioned on Month view
            commNav.waitForPage("Calendar");
            calendarView = PageFactory.initElements(driver, CalendarViewsElements.class);




            //Step: add a 2nd activity (recurring Meeting for 3 days) ... by default the same date will be used as for the previous activity ****
            headerButton.clickHeaderButton("Add");


            //Step: wait for page Schedule... to open
            commNav.waitForPage("Schedule...");


            //Step: select Meeting for activity type
            activityEditView = PageFactory.initElements(driver, MyActivityViewsElements.class);
            activityEditView.activityScheduleMeetingBtn.click();


            //Step: wait for page Meeting to open
            commNav.waitForPage("Meeting");


            //Step: add an Activity record with a random value for 'regarding'
            newActivityRegarding = "SeAutoTestActivity-2-" + new SimpleDateFormat("yyMMddHHmmss").format(new GregorianCalendar().getTime());
            System.out.println("2nd Activity regarding field will be - " + newActivityRegarding);


            activityEditView.activityEditViewRegardingFld.sendKeys(newActivityRegarding);




            //Step: set meeting to be recurring for 3 days, then retrieve the value for MM/dd/yy
            activityEditView.activityEditViewRepeatsFldBtn.click();
            commNav.waitForPage("Recurring");
            activityEditView.activityRecurringDailyFld.click();
            commNav.waitForPage("Meeting");


            activityEditView.activityEditViewRecurringFldBtn.click();
            commNav.waitForPage("Recurrence");
            activityEditView.activityRecurrenceOccurencesFld.clear();
            activityEditView.activityRecurrenceOccurencesFld.sendKeys("3");
            headerButton.checkButton.click();
            commNav.waitForPage("Meeting");


            newActivityStartDate = activityEditView.activityEditViewStartTimeFld.getAttribute("value");
            System.out.println("Date/time value for Start Date is : " + newActivityStartDate);


            //Step: save activity
            headerButton.clickHeaderButton("Save");


            //Step: wait for page Calendar ... should still be positioned on Month view
            commNav.waitForPage("Calendar");
            calendarView = PageFactory.initElements(driver, CalendarViewsElements.class);




            //Step: add a 3rd activity (timeless Phone Call)... by default the same date will be used as for the previous activity  ****
            headerButton.clickHeaderButton("Add");


            //Step: wait for page Schedule... to open
            commNav.waitForPage("Schedule...");


            //Step: select Meeting for activity type
            activityEditView = PageFactory.initElements(driver, MyActivityViewsElements.class);
            activityEditView.activitySchedulePhoneCallBtn.click();


            //Step: wait for page Phone Call to open
            commNav.waitForPage("Phone Call");


            //Step: add an Activity record with a random value for 'regarding'
            newActivityRegarding = "SeAutoTestActivity-3-" + new SimpleDateFormat("yyMMddHHmmss").format(new GregorianCalendar().getTime());
            System.out.println("3rd Activity regarding field will be - " + newActivityRegarding);


            activityEditView.activityEditViewRegardingFld.sendKeys(newActivityRegarding);




            //Step: set phone call to be timeless, then retrieve the value for MM/dd/yy
            activityEditView.activityEditViewTimelessTgl.click();


            newActivityStartDate = activityEditView.activityEditViewStartTimeFld.getAttribute("value");
            System.out.println("Date/time value for Start Date is : " + newActivityStartDate);


            //Step: save activity
            headerButton.clickHeaderButton("Save");


            //Step: wait for page Calendar ... should still be positioned on Month view
            commNav.waitForPage("Calendar");
            calendarView = PageFactory.initElements(driver, CalendarViewsElements.class);




            //Step: add a 4th activity (To-Do) ... by default the same date will be used as for the previous activity  ****
            headerButton.clickHeaderButton("Add");


            //Step: wait for page Schedule... to open
            commNav.waitForPage("Schedule...");


            //Step: select To-Do for activity type
            activityEditView = PageFactory.initElements(driver, MyActivityViewsElements.class);
            activityEditView.activityScheduleToDoBtn.click();


            //Step: wait for page To-Do to open
            commNav.waitForPage("To-Do");


            //Step: add an Activity record with a random value for 'regarding'
            newActivityRegarding = "SeAutoTestActivity-4-" + new SimpleDateFormat("yyMMddHHmmss").format(new GregorianCalendar().getTime());
            System.out.println("4th Activity regarding field will be - " + newActivityRegarding);


            activityEditView.activityEditViewRegardingFld.sendKeys(newActivityRegarding);




            //Step: retrieve the value for MM/dd/yy
            newActivityStartDate = activityEditView.activityEditViewStartTimeFld.getAttribute("value");
            System.out.println("Date/time value for Start Date is : " + newActivityStartDate);


            //Step: save activity
            headerButton.clickHeaderButton("Save");


            //Step: wait for page Calendar ... should still be positioned on Month view
            commNav.waitForPage("Calendar");
            calendarView = PageFactory.initElements(driver, CalendarViewsElements.class);




            //Step: add a 5th activity (Meeting) ... by default the same date will be used as for the previous activity  ****
            headerButton.clickHeaderButton("Add");


            //Step: wait for page Schedule... to open
            commNav.waitForPage("Schedule...");


            //Step: select Meeting for activity type
            activityEditView = PageFactory.initElements(driver, MyActivityViewsElements.class);
            activityEditView.activityScheduleMeetingBtn.click();


            //Step: wait for page Meeting to open
            commNav.waitForPage("Meeting");


            //Step: add an Activity record with a random value for 'regarding'
            newActivityRegarding = "SeAutoTestActivity-5-" + new SimpleDateFormat("yyMMddHHmmss").format(new GregorianCalendar().getTime());
            System.out.println("5th Activity regarding field will be - " + newActivityRegarding);


            activityEditView.activityEditViewRegardingFld.sendKeys(newActivityRegarding);




            //Step: retrieve the value for MM/dd/yy
            newActivityStartDate = activityEditView.activityEditViewStartTimeFld.getAttribute("value");
            System.out.println("Date/time value for Start Date is : " + newActivityStartDate);


            //Step: save activity
            headerButton.clickHeaderButton("Save");


            //Step: wait for page Calendar ... should still be positioned on Month view
            commNav.waitForPage("Calendar");
            calendarView = PageFactory.initElements(driver, CalendarViewsElements.class);




            //Step: add a 6th activity (Meeting) ... by default the same date will be used as for the previous activity  ****
            headerButton.clickHeaderButton("Add");


            //Step: wait for page Schedule... to open
            commNav.waitForPage("Schedule...");


            //Step: select Meeting for activity type
            activityEditView = PageFactory.initElements(driver, MyActivityViewsElements.class);
            activityEditView.activityScheduleMeetingBtn.click();


            //Step: wait for page Meeting to open
            commNav.waitForPage("Meeting");


            //Step: add an Activity record with a random value for 'regarding'
            newActivityRegarding = "SeAutoTestActivity-6-" + new SimpleDateFormat("yyMMddHHmmss").format(new GregorianCalendar().getTime());
            System.out.println("6th Activity regarding field will be - " + newActivityRegarding);


            activityEditView.activityEditViewRegardingFld.sendKeys(newActivityRegarding);




            //Step: retrieve the value for MM/dd/yy
            newActivityStartDate = activityEditView.activityEditViewStartTimeFld.getAttribute("value");
            System.out.println("Date/time value for Start Date is : " + newActivityStartDate);


            //Step: save activity
            headerButton.clickHeaderButton("Save");


            //Step: wait for page Calendar ... should still be positioned on Month view
            commNav.waitForPage("Calendar");
            calendarView = PageFactory.initElements(driver, CalendarViewsElements.class);




            //Step: add a 7th activity (timeless recurring Phone Call for 3 days) ... by default the same date will be used as for the previous activity  ****
            headerButton.clickHeaderButton("Add");


            //Step: wait for page Schedule... to open
            commNav.waitForPage("Schedule...");


            //Step: select Phone Call for activity type
            activityEditView = PageFactory.initElements(driver, MyActivityViewsElements.class);
            activityEditView.activitySchedulePhoneCallBtn.click();


            //Step: wait for page Phone Call to open
            commNav.waitForPage("Phone Call");


            //Step: add an Activity record with a random value for 'regarding'
            newActivityRegarding = "SeAutoTestActivity-7-" + new SimpleDateFormat("yyMMddHHmmss").format(new GregorianCalendar().getTime());
            System.out.println("7th Activity regarding field will be - " + newActivityRegarding);


            activityEditView.activityEditViewRegardingFld.sendKeys(newActivityRegarding);




            //Step: set phone call to be timeless, recurring for 3 days, then retrieve the value for MM/dd/yy
            activityEditView.activityEditViewTimelessTgl.click();


            activityEditView.activityEditViewRepeatsFldBtn.click();
            commNav.waitForPage("Recurring");
            activityEditView.activityRecurringDailyFld.click();
            commNav.waitForPage("Phone Call");


            activityEditView.activityEditViewRecurringFldBtn.click();
            commNav.waitForPage("Recurrence");
            activityEditView.activityRecurrenceOccurencesFld.clear();
            activityEditView.activityRecurrenceOccurencesFld.sendKeys("3");
            headerButton.checkButton.click();
            commNav.waitForPage("Phone Call");


            newActivityStartDate = activityEditView.activityEditViewStartTimeFld.getAttribute("value");
            System.out.println("Date/time value for Start Date is : " + newActivityStartDate);


            //Step: save activity
            headerButton.clickHeaderButton("Save");


            //Step: wait for page Calendar ... should still be positioned on Month view
            commNav.waitForPage("Calendar");
            calendarView = PageFactory.initElements(driver, CalendarViewsElements.class);




            //Step: add a 8th activity (Meeting) ... by default the same date will be used as for the previous activity  ****
            headerButton.clickHeaderButton("Add");


            //Step: wait for page Schedule... to open
            commNav.waitForPage("Schedule...");


            //Step: select Meeting for activity type
            activityEditView = PageFactory.initElements(driver, MyActivityViewsElements.class);
            activityEditView.activityScheduleMeetingBtn.click();


            //Step: wait for page Meeting to open
            commNav.waitForPage("Meeting");


            //Step: add an Activity record with a random value for 'regarding'
            newActivityRegarding = "SeAutoTestActivity-8-" + new SimpleDateFormat("yyMMddHHmmss").format(new GregorianCalendar().getTime());
            System.out.println("8th Activity regarding field will be - " + newActivityRegarding);


            activityEditView.activityEditViewRegardingFld.sendKeys(newActivityRegarding);




            //Step: retrieve the value for MM/dd/yy
            newActivityStartDate = activityEditView.activityEditViewStartTimeFld.getAttribute("value");
            System.out.println("Date/time value for Start Date is : " + newActivityStartDate);


            //Step: save activity
            headerButton.clickHeaderButton("Save");


            //Step: wait for page Calendar ... should still be positioned on Month view
            commNav.waitForPage("Calendar");
            calendarView = PageFactory.initElements(driver, CalendarViewsElements.class);




            //Step: add a 9th activity (recurring To-Do for 3 days) ... by default the same date will be used as for the previous activity  ****
            headerButton.clickHeaderButton("Add");


            //Step: wait for page Schedule... to open
            commNav.waitForPage("Schedule...");


            //Step: select To-Do for activity type
            activityEditView = PageFactory.initElements(driver, MyActivityViewsElements.class);
            activityEditView.activityScheduleToDoBtn.click();


            //Step: wait for page To-Do to open
            commNav.waitForPage("To-Do");


            //Step: add an Activity record with a random value for 'regarding'
            newActivityRegarding = "SeAutoTestActivity-9-" + new SimpleDateFormat("yyMMddHHmmss").format(new GregorianCalendar().getTime());
            System.out.println("9th Activity regarding field will be - " + newActivityRegarding);


            activityEditView.activityEditViewRegardingFld.sendKeys(newActivityRegarding);




            //Step: set to-do to be recurring for 3 days, then retrieve the value for MM/dd/yy
            activityEditView.activityEditViewRepeatsFldBtn.click();
            commNav.waitForPage("Recurring");
            activityEditView.activityRecurringDailyFld.click();
            commNav.waitForPage("To-Do");


            activityEditView.activityEditViewRecurringFldBtn.click();
            commNav.waitForPage("Recurrence");
            activityEditView.activityRecurrenceOccurencesFld.clear();
            activityEditView.activityRecurrenceOccurencesFld.sendKeys("3");
            headerButton.checkButton.click();
            commNav.waitForPage("To-Do");


            newActivityStartDate = activityEditView.activityEditViewStartTimeFld.getAttribute("value");
            System.out.println("Date/time value for Start Date is : " + newActivityStartDate);


            //Step: save activity
            headerButton.clickHeaderButton("Save");


            //Step: wait for page Calendar ... should still be positioned on Month view
            commNav.waitForPage("Calendar");
            calendarView = PageFactory.initElements(driver, CalendarViewsElements.class);




            //Step: add a 10th activity (Meeting) ... by default the same date will be used as for the previous activity  ****
            headerButton.clickHeaderButton("Add");


            //Step: wait for page Schedule... to open
            commNav.waitForPage("Schedule...");


            //Step: select Meeting for activity type
            activityEditView = PageFactory.initElements(driver, MyActivityViewsElements.class);
            activityEditView.activityScheduleMeetingBtn.click();


            //Step: wait for page Meeting to open
            commNav.waitForPage("Meeting");


            //Step: add an Activity record with a random value for 'regarding'
            newActivityRegarding = "SeAutoTestActivity-10-" + new SimpleDateFormat("yyMMddHHmmss").format(new GregorianCalendar().getTime());
            System.out.println("10th Activity regarding field will be - " + newActivityRegarding);


            activityEditView.activityEditViewRegardingFld.sendKeys(newActivityRegarding);




            //Step: retrieve the value for MM/dd/yy
            newActivityStartDate = activityEditView.activityEditViewStartTimeFld.getAttribute("value");
            System.out.println("Date/time value for Start Date is : " + newActivityStartDate);


            //Step: save activity
            headerButton.clickHeaderButton("Save");


            //Step: wait for page Calendar ... should still be positioned on Month view
            commNav.waitForPage("Calendar");
            calendarView = PageFactory.initElements(driver, CalendarViewsElements.class);




            //Step: add an 11th activity (timeless recurring Meeting for 5 days) ... by default the same date will be used as for the previous activity ****
            headerButton.clickHeaderButton("Add");


            //Step: wait for page Schedule... to open
            commNav.waitForPage("Schedule...");


            //Step: select Meeting for activity type
            activityEditView = PageFactory.initElements(driver, MyActivityViewsElements.class);
            activityEditView.activityScheduleMeetingBtn.click();


            //Step: wait for page Meeting to open
            commNav.waitForPage("Meeting");


            //Step: add an Activity record with a random value for 'regarding'
            newActivityRegarding = "SeAutoTestActivity-11-" + new SimpleDateFormat("yyMMddHHmmss").format(new GregorianCalendar().getTime());
            System.out.println("11th Activity regarding field will be - " + newActivityRegarding);


            activityEditView.activityEditViewRegardingFld.sendKeys(newActivityRegarding);




            //Step: set meeting to be timeless, recurring for 5 days, then retrieve the value for MM/dd/yy
            activityEditView.activityEditViewTimelessTgl.click();


            activityEditView.activityEditViewRepeatsFldBtn.click();
            commNav.waitForPage("Recurring");
            activityEditView.activityRecurringDailyFld.click();
            commNav.waitForPage("Meeting");


            activityEditView.activityEditViewRecurringFldBtn.click();
            commNav.waitForPage("Recurrence");
            activityEditView.activityRecurrenceOccurencesFld.clear();
            activityEditView.activityRecurrenceOccurencesFld.sendKeys("5");
            headerButton.checkButton.click();
            commNav.waitForPage("Meeting");


            newActivityStartDate = activityEditView.activityEditViewStartTimeFld.getAttribute("value");
            System.out.println("Date/time value for Start Date is : " + newActivityStartDate);


            //Step: save activity
            headerButton.clickHeaderButton("Save");


            //Step: wait for page Calendar ... should still be positioned on Month view
            commNav.waitForPage("Calendar");
            calendarView = PageFactory.initElements(driver, CalendarViewsElements.class);




            //Step: add a 12th activity (Meeting) ... by default the same date will be used as for the previous activity  ****
            headerButton.clickHeaderButton("Add");


            //Step: wait for page Schedule... to open
            commNav.waitForPage("Schedule...");


            //Step: select Meeting for activity type
            activityEditView = PageFactory.initElements(driver, MyActivityViewsElements.class);
            activityEditView.activityScheduleMeetingBtn.click();


            //Step: wait for page Meeting to open
            commNav.waitForPage("Meeting");


            //Step: add an Activity record with a random value for 'regarding'
            newActivityRegarding = "SeAutoTestActivity-12-" + new SimpleDateFormat("yyMMddHHmmss").format(new GregorianCalendar().getTime());
            System.out.println("12th Activity regarding field will be - " + newActivityRegarding);


            activityEditView.activityEditViewRegardingFld.sendKeys(newActivityRegarding);




            //Step: retrieve the value for MM/dd/yy
            newActivityStartDate = activityEditView.activityEditViewStartTimeFld.getAttribute("value");
            System.out.println("Date/time value for Start Date is : " + newActivityStartDate);


            //Step: save activity
            headerButton.clickHeaderButton("Save");


            //Step: wait for page Calendar ... should still be positioned on Month view
            commNav.waitForPage("Calendar");
            calendarView = PageFactory.initElements(driver, CalendarViewsElements.class);




            //Step: add a 13th activity (timeless Meeting) ... by default the same date will be used as for the previous activity  ****
            headerButton.clickHeaderButton("Add");


            //Step: wait for page Schedule... to open
            commNav.waitForPage("Schedule...");


            //Step: select Meeting for activity type
            activityEditView = PageFactory.initElements(driver, MyActivityViewsElements.class);
            activityEditView.activityScheduleMeetingBtn.click();


            //Step: wait for page Meeting to open
            commNav.waitForPage("Meeting");


            //Step: add an Activity record with a random value for 'regarding'
            newActivityRegarding = "SeAutoTestActivity-13-" + new SimpleDateFormat("yyMMddHHmmss").format(new GregorianCalendar().getTime());
            System.out.println("13th Activity regarding field will be - " + newActivityRegarding);


            activityEditView.activityEditViewRegardingFld.sendKeys(newActivityRegarding);




            //Step: set meeting to timeless, then retrieve the value for MM/dd/yy
            activityEditView.activityEditViewTimelessTgl.click();


            newActivityStartDate = activityEditView.activityEditViewStartTimeFld.getAttribute("value");
            System.out.println("Date/time value for Start Date is : " + newActivityStartDate);


            //Step: save activity
            headerButton.clickHeaderButton("Save");


            //Step: wait for page Calendar ... should still be positioned on Month view
            commNav.waitForPage("Calendar");
            calendarView = PageFactory.initElements(driver, CalendarViewsElements.class);




            //Step: add an 14th activity (recurring Meeting for 5 days) ... by default the same date will be used as for the previous activity ****
            headerButton.clickHeaderButton("Add");


            //Step: wait for page Schedule... to open
            commNav.waitForPage("Schedule...");


            //Step: select Meeting for activity type
            activityEditView = PageFactory.initElements(driver, MyActivityViewsElements.class);
            activityEditView.activityScheduleMeetingBtn.click();


            //Step: wait for page Meeting to open
            commNav.waitForPage("Meeting");


            //Step: add an Activity record with a random value for 'regarding'
            newActivityRegarding = "SeAutoTestActivity-14-" + new SimpleDateFormat("yyMMddHHmmss").format(new GregorianCalendar().getTime());
            System.out.println("14th Activity regarding field will be - " + newActivityRegarding);


            activityEditView.activityEditViewRegardingFld.sendKeys(newActivityRegarding);




            //Step: set meeting to be recurring for 5 days, then retrieve the value for MM/dd/yy
            activityEditView.activityEditViewRepeatsFldBtn.click();
            commNav.waitForPage("Recurring");
            activityEditView.activityRecurringDailyFld.click();
            commNav.waitForPage("Meeting");


            activityEditView.activityEditViewRecurringFldBtn.click();
            commNav.waitForPage("Recurrence");
            activityEditView.activityRecurrenceOccurencesFld.clear();
            activityEditView.activityRecurrenceOccurencesFld.sendKeys("5");
            headerButton.checkButton.click();
            commNav.waitForPage("Meeting");


            newActivityStartDate = activityEditView.activityEditViewStartTimeFld.getAttribute("value");
            System.out.println("Date/time value for Start Date is : " + newActivityStartDate);


            //Step: save activity
            headerButton.clickHeaderButton("Save");


            //Step: wait for page Calendar ... should still be positioned on Month view
            commNav.waitForPage("Calendar");
            calendarView = PageFactory.initElements(driver, CalendarViewsElements.class);




            //Step: add a 15th activity (recurring Phone Call for 4 days) ... by default the same date will be used as for the previous activity  ****
            headerButton.clickHeaderButton("Add");


            //Step: wait for page Schedule... to open
            commNav.waitForPage("Schedule...");


            //Step: select Phone Call for activity type
            activityEditView = PageFactory.initElements(driver, MyActivityViewsElements.class);
            activityEditView.activitySchedulePhoneCallBtn.click();


            //Step: wait for page Phone Call to open
            commNav.waitForPage("Phone Call");


            //Step: add an Activity record with a random value for 'regarding'
            newActivityRegarding = "SeAutoTestActivity-15-" + new SimpleDateFormat("yyMMddHHmmss").format(new GregorianCalendar().getTime());
            System.out.println("15th Activity regarding field will be - " + newActivityRegarding);


            activityEditView.activityEditViewRegardingFld.sendKeys(newActivityRegarding);




            //Step: set phone call to be recurring for 4 days, then retrieve the value for MM/dd/yy
            activityEditView.activityEditViewRepeatsFldBtn.click();
            commNav.waitForPage("Recurring");
            activityEditView.activityRecurringDailyFld.click();
            commNav.waitForPage("Phone Call");


            activityEditView.activityEditViewRecurringFldBtn.click();
            commNav.waitForPage("Recurrence");
            activityEditView.activityRecurrenceOccurencesFld.clear();
            activityEditView.activityRecurrenceOccurencesFld.sendKeys("4");
            headerButton.checkButton.click();
            commNav.waitForPage("Phone Call");


            newActivityStartDate = activityEditView.activityEditViewStartTimeFld.getAttribute("value");
            System.out.println("Date/time value for Start Date is : " + newActivityStartDate);


            //Step: save activity
            headerButton.clickHeaderButton("Save");


            //Step: wait for page Calendar ... should still be positioned on Month view
            commNav.waitForPage("Calendar");
            calendarView = PageFactory.initElements(driver, CalendarViewsElements.class);




            //Step: add a 16th activity (Phone Call)... by default the same date will be used as for the previous activity  ****
            headerButton.clickHeaderButton("Add");


            //Step: wait for page Schedule... to open
            commNav.waitForPage("Schedule...");


            //Step: select Meeting for activity type
            activityEditView = PageFactory.initElements(driver, MyActivityViewsElements.class);
            activityEditView.activitySchedulePhoneCallBtn.click();


            //Step: wait for page Phone Call to open
            commNav.waitForPage("Phone Call");


            //Step: add an Activity record with a random value for 'regarding'
            newActivityRegarding = "SeAutoTestActivity-16-" + new SimpleDateFormat("yyMMddHHmmss").format(new GregorianCalendar().getTime());
            System.out.println("16th Activity regarding field will be - " + newActivityRegarding);


            activityEditView.activityEditViewRegardingFld.sendKeys(newActivityRegarding);




            //Step: retrieve the value for MM/dd/yy
            newActivityStartDate = activityEditView.activityEditViewStartTimeFld.getAttribute("value");
            System.out.println("Date/time value for Start Date is : " + newActivityStartDate);


            //Step: save activity
            headerButton.clickHeaderButton("Save");


            //Step: wait for page Calendar ... should still be positioned on Month view
            commNav.waitForPage("Calendar");
            calendarView = PageFactory.initElements(driver, CalendarViewsElements.class);




            //Step: add a 17th activity (Meeting) ... by default the same date will be used as for the previous activity  ****
            headerButton.clickHeaderButton("Add");


            //Step: wait for page Schedule... to open
            commNav.waitForPage("Schedule...");


            //Step: select Meeting for activity type
            activityEditView = PageFactory.initElements(driver, MyActivityViewsElements.class);
            activityEditView.activityScheduleMeetingBtn.click();


            //Step: wait for page Meeting to open
            commNav.waitForPage("Meeting");


            //Step: add an Activity record with a random value for 'regarding'
            newActivityRegarding = "SeAutoTestActivity-17-" + new SimpleDateFormat("yyMMddHHmmss").format(new GregorianCalendar().getTime());
            System.out.println("17th Activity regarding field will be - " + newActivityRegarding);


            activityEditView.activityEditViewRegardingFld.sendKeys(newActivityRegarding);




            //Step: retrieve the value for MM/dd/yy
            newActivityStartDate = activityEditView.activityEditViewStartTimeFld.getAttribute("value");
            System.out.println("Date/time value for Start Date is : " + newActivityStartDate);


            //Step: save activity
            headerButton.clickHeaderButton("Save");


            //Step: wait for page Calendar ... should still be positioned on Month view
            commNav.waitForPage("Calendar");
            calendarView = PageFactory.initElements(driver, CalendarViewsElements.class);




            //Step: add an 18th activity (recurring Meeting for 2 weeks) ... by default the same date will be used as for the previous activity ****
            headerButton.clickHeaderButton("Add");


            //Step: wait for page Schedule... to open
            commNav.waitForPage("Schedule...");


            //Step: select Meeting for activity type
            activityEditView = PageFactory.initElements(driver, MyActivityViewsElements.class);
            activityEditView.activityScheduleMeetingBtn.click();


            //Step: wait for page Meeting to open
            commNav.waitForPage("Meeting");


            //Step: add an Activity record with a random value for 'regarding'
            newActivityRegarding = "SeAutoTestActivity-18-" + new SimpleDateFormat("yyMMddHHmmss").format(new GregorianCalendar().getTime());
            System.out.println("18th Activity regarding field will be - " + newActivityRegarding);


            activityEditView.activityEditViewRegardingFld.sendKeys(newActivityRegarding);




            //Step: set meeting to be recurring for 2 weeks, then retrieve the value for MM/dd/yy
            activityEditView.activityEditViewRepeatsFldBtn.click();
            commNav.waitForPage("Recurring");
            activityEditView.activityRecurringWeeklyFld.click();
            commNav.waitForPage("Meeting");


            activityEditView.activityEditViewRecurringFldBtn.click();
            commNav.waitForPage("Recurrence");
            activityEditView.activityRecurrenceOccurencesFld.clear();
            activityEditView.activityRecurrenceOccurencesFld.sendKeys("2");
            headerButton.checkButton.click();
            commNav.waitForPage("Meeting");


            newActivityStartDate = activityEditView.activityEditViewStartTimeFld.getAttribute("value");
            System.out.println("Date/time value for Start Date is : " + newActivityStartDate);


            //Step: save activity
            headerButton.clickHeaderButton("Save");


            //Step: wait for page Calendar ... should still be positioned on Month view
            commNav.waitForPage("Calendar");
            calendarView = PageFactory.initElements(driver, CalendarViewsElements.class);




            //Step: add a 19th activity (Meeting) ... by default the same date will be used as for the previous activity  ****
            headerButton.clickHeaderButton("Add");


            //Step: wait for page Schedule... to open
            commNav.waitForPage("Schedule...");


            //Step: select Meeting for activity type
            activityEditView = PageFactory.initElements(driver, MyActivityViewsElements.class);
            activityEditView.activityScheduleMeetingBtn.click();


            //Step: wait for page Meeting to open
            commNav.waitForPage("Meeting");


            //Step: add an Activity record with a random value for 'regarding'
            newActivityRegarding = "SeAutoTestActivity-19-" + new SimpleDateFormat("yyMMddHHmmss").format(new GregorianCalendar().getTime());
            System.out.println("19th Activity regarding field will be - " + newActivityRegarding);


            activityEditView.activityEditViewRegardingFld.sendKeys(newActivityRegarding);




            //Step: retrieve the value for MM/dd/yy
            newActivityStartDate = activityEditView.activityEditViewStartTimeFld.getAttribute("value");
            System.out.println("Date/time value for Start Date is : " + newActivityStartDate);


            //Step: save activity
            headerButton.clickHeaderButton("Save");


            //Step: wait for page Calendar ... should still be positioned on Month view
            commNav.waitForPage("Calendar");
            calendarView = PageFactory.initElements(driver, CalendarViewsElements.class);




            //Step: add a 20th activity (Meeting) ... by default the same date will be used as for the previous activity  ****
            headerButton.clickHeaderButton("Add");


            //Step: wait for page Schedule... to open
            commNav.waitForPage("Schedule...");


            //Step: select Meeting for activity type
            activityEditView = PageFactory.initElements(driver, MyActivityViewsElements.class);
            activityEditView.activityScheduleMeetingBtn.click();


            //Step: wait for page Meeting to open
            commNav.waitForPage("Meeting");


            //Step: add an Activity record with a random value for 'regarding'
            newActivityRegarding = "SeAutoTestActivity-20-" + new SimpleDateFormat("yyMMddHHmmss").format(new GregorianCalendar().getTime());
            System.out.println("20th Activity regarding field will be - " + newActivityRegarding);


            activityEditView.activityEditViewRegardingFld.sendKeys(newActivityRegarding);




            //Step: retrieve the value for MM/dd/yy
            newActivityStartDate = activityEditView.activityEditViewStartTimeFld.getAttribute("value");
            System.out.println("Date/time value for Start Date is : " + newActivityStartDate);


            //Step: save activity
            headerButton.clickHeaderButton("Save");


            //Step: wait for page Calendar ... should still be positioned on Month view
            commNav.waitForPage("Calendar");
            calendarView = PageFactory.initElements(driver, CalendarViewsElements.class);




            //Step: open Day view for date to which all activities were assigned, and check that all 20 records display in calendar Day view
            calendarView.calendarMonthFirstDayFourthRow.click();
            calendarView.calendarDayBtn.click();


            int n=2;
            int i;
            WebElement activityElement = driver.findElement(By.xpath("(//div[@id='calendar_daylist']/ul/li)[" + n + "]"));
            while (n <=21)    {
                i = n - 1;
                activityElement = driver.findElement(By.xpath("(//div[@id='calendar_daylist']/ul/li)[" + n + "]"));
                AssertJUnit.assertTrue("FAILED : Activity - " + i + " is not present under Calendar Day view", commNav.isWebElementPresent("PASSED : Activity - " + i, activityElement));
                n=n+1;
            }


        }


        catch (Exception e) {
            verificationErrors.append(methodID + "(): " + e.toString());
            System.out.println("VP: Calendar activities not displaying in Day view as expected " + " - FAILED");
            AssertJUnit.fail("test failed");
        }


        System.out.println(ENDLINE);
    }


    @Test(enabled = true)
    // MBL-10473 ... mobile picklists should be ordered by text (check contact Title picklist, not ordered before fixed in 3.0.4)
    public void test05_MBL10473() throws Exception {
        String methodID = "test05_MBL10473";

        //Test Parameters:
        String entityType = "Contact";
        String contactRecord = TEST_CONTACT_RECORD;

        CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
        HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);
        ContactViewsElements contactEditView = PageFactory.initElements(driver, ContactViewsElements.class);

        System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);

        //Step: logout & log back in (to clear cookies)
        LogOutThenLogBackIn(userName, userPwd);

        try {
            //Step: search for Contact entity, then open it's Detail view
            AssertJUnit.assertTrue(commNav.entityRecordEditView(entityType, contactRecord));


            //Step: open the contact 'title' picklist
            contactEditView.contactsEditViewTitleInputFldBtn.click();
            commNav.waitForPage("Title");

            //Step: Verify that the first 5 items on the Title view are sorted by text (prior to this 3.0.4 fix, they were not appearing in this order)
            AssertJUnit.assertEquals("Title value 1 not as expected ... " + contactEditView.contactsEditViewTitleValue1.getText() + " - FAILED", "Assistant", contactEditView.contactsEditViewTitleValue1.getText());
            System.out.println("Title value 1 as expected ... " + contactEditView.contactsEditViewTitleValue1.getText() + " - PASSED");
            AssertJUnit.assertEquals("Title value 2 not as expected ... " + contactEditView.contactsEditViewTitleValue2.getText() + " - FAILED", "CEO", contactEditView.contactsEditViewTitleValue2.getText());
            System.out.println("Title value 2 as expected ... " + contactEditView.contactsEditViewTitleValue2.getText() + " - PASSED");
            AssertJUnit.assertEquals("Title value 3 not as expected ... " + contactEditView.contactsEditViewTitleValue3.getText() + " - FAILED", "CFO", contactEditView.contactsEditViewTitleValue3.getText());
            System.out.println("Title value 3 as expected ... " + contactEditView.contactsEditViewTitleValue3.getText() + " - PASSED");
            AssertJUnit.assertEquals("Title value 4 not as expected ... " + contactEditView.contactsEditViewTitleValue4.getText() + " - FAILED", "Director of Cust Service", contactEditView.contactsEditViewTitleValue4.getText());
            System.out.println("Title value 4 as expected ... " + contactEditView.contactsEditViewTitleValue4.getText() + " - PASSED");
            AssertJUnit.assertEquals("Title value 5 not as expected ... " + contactEditView.contactsEditViewTitleValue5.getText() + " - FAILED", "Director of Finance", contactEditView.contactsEditViewTitleValue5.getText());
            System.out.println("Title value 5 as expected ... " + contactEditView.contactsEditViewTitleValue5.getText() + " - PASSED");

            System.out.println("VP: Title values in picklist sorted by text " + " - PASSED");
        }
        catch (Exception e) {
            verificationErrors.append(methodID + "(): " + e.toString());
            System.out.println("VP: Title values in picklist sorted by text " + " - FAILED");
            AssertJUnit.fail("test failed");
        }

        System.out.println(ENDLINE);
    }


    @Test(enabled = true)
    // MBL-10474 ... in ticket listview should not see 'Error rendering row template' if contactid is null
    // for 10.4.10.102 (8.1) and 10.4.10.101 (8.0) databases, for ticket 001-00-000002, the contactid has been permanently set to null
    public void test06_MBL10474() throws Exception {
        String methodID = "test06_MBL10474";

        // Test Params:
        String entityType = "Tickets";
        String entityRecord = TEST_TICKET_RECORD_NULL_CONTACT;

        CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
        HeaderButton headerbutton = PageFactory.initElements(driver, HeaderButton.class);
        TicketViewsElements ticketListView = PageFactory.initElements(driver, TicketViewsElements.class);

        System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);

        //Step: logout & log back in (to clear cookies)
        LogOutThenLogBackIn(userName, userPwd);

        //Step: click Top-Left button to reveal Global Menu...
        headerbutton.showGlobalMenu();

        //Step: navigate to entity list view...
        commNav.clickGlobalMenuItem(entityType);
        commNav.waitForPage("Tickets");

        //Step: search for an existing Ticket record ... 001-00-000002, that has a null value for contact on 10.4.10.210 (8.1) and 10.4.10.242 (8.0) databases
        ticketListView.ticketsSearchTxtBox.sendKeys("001-00-000002");
        ticketListView.ticketsSearchLookupBtn.click();
        Thread.sleep(500);

        AssertJUnit.assertTrue("VP: for ticket 001-00-000002 with null contact, ticket not displaying as expected in listview - FAILED", ticketListView.topTicketsListItemNumber.isDisplayed());
        System.out.println("VP: for ticket 001-00-000002 with null contact, ticket is displaying as expected in listview - PASSED");
        AssertJUnit.assertEquals("VP: ticket number 001-00-000002 is not displaying - FAILED", "001-00-000002", ticketListView.topTicketsListItemNumber.getText());
        System.out.println("VP: ticket number 001-00-000002 is displaying - PASSED");

        System.out.println(ENDLINE);
    }

}
