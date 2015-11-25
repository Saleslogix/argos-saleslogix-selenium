package argos.saleslogix.selenium.test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;


/**
 * Test class that defines test methods for the SLX Mobile Defect (v3.3.0) fixes.
 * 
 * @author kathleen.lockyer-bratton@infor.com
 * @version	1.0
 */
public class MobileSprint330 extends BaseTest {

    public String TEST_OPPORTUNITY_RECORD = "Vegas Vision-Phase1";
    public String TEST_CONTACT_RECORD = "Abbott, John";
    public String TEST_ACCOUNT_RECORD = "Abbott Ltd.";

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
    // MBL-10793 ... Opportunity - an edit to the 'est close' is setting the date to a day ahead of what was chosen

    public void test01_MBL10793() throws Exception {
        String methodID = "test01_MBL10793";

        // Test Params:
        String entityType = "Opportunities";
        String entityRecord = TEST_OPPORTUNITY_RECORD;

        CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
        HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);
        OpportunityViewsElements oppsListView = PageFactory.initElements(driver, OpportunityViewsElements.class);
        CalendarViewsElements calendarEditView = PageFactory.initElements(driver, CalendarViewsElements.class);

        System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);

        //Step: login & log back in (to clear cookies)
        LogOutThenLogBackIn(userName, userPwd);

        //Step: search for Opportunity entity, open Detail view, and edit est close value
        try {
            //Step: search for Opportunity entity, then open it's Detail view
            commNav.entityRecordOpenDetailView(entityType, entityRecord);

            //Step: edit the opportunity, save the original 'est close' value
            headerButton.editButton.click();
            commNav.waitForPage("Opportunity");
            Thread.sleep(3000);
            String estCloseDateOriginal = oppsListView.opportunityEditViewEstCloseInputFld.getAttribute("value");
            String[] dateValues = estCloseDateOriginal.split("/");
            System.out.println("Original opportunity 'est close' date has a month of : " + dateValues[0] + ", a day of : " + dateValues[1] + ", and year of : " + dateValues[2]);

            //Step: open calendar for 'est close', and choose 1 month earlier
            oppsListView.opportunityEditViewEstCloseFldBtn.click();
            Thread.sleep(1000);
            driver.switchTo().activeElement();

            //Press Advanced button to open Calendar view, press button to go back one month
            calendarEditView.calendarModalAdvanced.click();
            calendarEditView.calendarModalDecrMonth.click();
            calendarEditView.calendarModalConfirm.click();

            Thread.sleep(1000);
            driver.switchTo().activeElement();
            commNav.waitForPage("Opportunity");

            //Step: retrieve the revised 'est close' date
            oppsListView = PageFactory.initElements(driver, OpportunityViewsElements.class);
            String estCloseDateModified = oppsListView.opportunityEditViewEstCloseInputFld.getAttribute("value");
            String[] dateValuesNew = estCloseDateModified.split("/");
            System.out.println("Modified opportunity 'est close' date has a month of : " + dateValuesNew[0] + ", a day of : " + dateValuesNew[1] + ", and year of : " + dateValuesNew[2]);


            //Step: verify that revised 'est close' date, is one month earlier, but has the same value for day
            String expectedDay = dateValues[1];
            String expectedMonth;
            String expectedYear;
            //  remove any leading zeroes from the revised 'month' ... for comparison with expectedMonth, which has no leading zeroes
            dateValuesNew[0] = dateValuesNew[0].replaceFirst("^0+(?!$)", "");

            //  if original month is 01, then expected month should be 12, and the expected year should be 1 less than the original year
            if (Integer.valueOf(dateValues[0]) == 1) {
                expectedMonth =  "12";
                expectedYear = Integer.toString(Integer.valueOf(dateValues[2]) - 1);
            }
            else {
                expectedMonth = Integer.toString(Integer.valueOf(dateValues[0]) - 1);
                expectedYear = dateValues[2];
            }

            System.out.println("Expected Day : " + expectedDay + " Expected Month : " + expectedMonth + " Expected Year : " + expectedYear);
            AssertJUnit.assertEquals("VP: revised date does not have the expected month of ... " + expectedMonth + " - FAILED", expectedMonth, dateValuesNew[0]);
            System.out.println("VP: revised date does have the expected month of ... " + expectedMonth + " - PASSED");
            AssertJUnit.assertEquals("VP: revised date does not have the expected day of ... " + expectedDay + " - FAILED", expectedDay, dateValuesNew[1]);
            System.out.println("VP: revised date does have the expected day of ... " + expectedDay + " - PASSED");
            AssertJUnit.assertEquals("VP: revised date does not have the expected year of ... " + expectedYear + " - FAILED", expectedYear, dateValuesNew[2]);
            System.out.println("VP: revised date does have the expected year of ... " + expectedYear + " - PASSED");



        }
        catch (Exception e) {
            verificationErrors.append(methodID + "(): " + e.toString());
            AssertJUnit.fail("test failed");
        }

        System.out.println(ENDLINE);
    }


    @Test(enabled = true)
    // MBL-10838 ... 8.1 Update 05 Activity Endpoint Changes : changing timeless activity start date should not save activitiy as not timeless

    public void test02_MBL10838() throws Exception {
        String methodID = "test02_MBL10838";

        CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
        HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);
        CommonViewsElements commView = PageFactory.initElements(driver, CommonViewsElements.class);
        CalendarViewsElements calendarView = PageFactory.initElements(driver, CalendarViewsElements.class);
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

            //Step: set activity to be timeless
            activityEditView.activityEditViewTimelessTgl.click();
            String newActivityStartDate = activityEditView.activityEditViewStartTimeFld.getAttribute("value");
            System.out.println("Date/time value for Start Date is : " + newActivityStartDate);

            //Step: save activity
            headerButton.clickHeaderButton("Save");

            //Step: wait for page My Activities
            commNav.waitForPage("My Activities");

            //Step: search for activity created ... and re-open
            activityEditView.performMyActivitiesSearch(newActivityRegarding);
            WebElement activityItemLnk = driver.findElement(By.xpath("//*[@id='myactivity_list']//ul/li[1]/descendant::*[text() = '" + newActivityRegarding + "']"));
            commNav.highlightNClick(activityItemLnk);
            commNav.waitForPage("Meeting - Regarding: " + newActivityRegarding);


            //Step: open the activity created in edit mode
            headerButton = PageFactory.initElements(driver, HeaderButton.class);
            headerButton.clickHeaderButton("Edit");

            //Step: wait for page Activity
            commNav.waitForPage("Meeting");

            //Step: edit the start date and re-save activity
            activityEditView = PageFactory.initElements(driver, MyActivityViewsElements.class);
            activityEditView.activityEditViewStartTimeFldBtn.click();

            Thread.sleep(1000);
            driver.switchTo().activeElement();

            //Press Advanced button to open Calendar view, press button to go back one month
            calendarView.calendarModalAdvanced.click();
            calendarView.calendarModalDecrMonth.click();
            calendarView.calendarModalConfirm.click();

            Thread.sleep(1000);
            driver.switchTo().activeElement();
            commNav.waitForPage("Meeting");

            String editedActivityStartDate = activityEditView.activityEditViewStartTimeFld.getAttribute("value");
            System.out.println("Date/time value for Start Date changed to : " + editedActivityStartDate);
            headerButton.clickHeaderButton("Save");
            commNav.waitForPage("Meeting - Regarding: " + newActivityRegarding);

            //Step: re-edit activity, retrieve edited start date
            headerButton = PageFactory.initElements(driver, HeaderButton.class);
            headerButton.clickHeaderButton("Edit");
            commNav.waitForPage("Meeting");

            activityEditView = PageFactory.initElements(driver, MyActivityViewsElements.class);
            String edited2ActivityStartDate = activityEditView.activityEditViewStartTimeFld.getAttribute("value");
            System.out.println("Date/time value for Start Date after re-save is : " + edited2ActivityStartDate);
            AssertJUnit.assertEquals("VP: after editing start date and re-saving timeless activity, activity is no longer timeless - FAILED", editedActivityStartDate, edited2ActivityStartDate);
            System.out.println("VP: after editing start date and re-saving timeless activity, activity remains timeless - PASSED");

        }

        catch (Exception e) {
            verificationErrors.append(methodID + "(): " + e.toString());
            System.out.println("VP: changing timeless activity start date and saving should keep activity as timeless " + " - FAILED");
            AssertJUnit.fail("test failed");
        }

        System.out.println(ENDLINE);
    }


    @Test(enabled = true)
    // MBL-10659 ... for Firefox, the Contact detail 'View address' quick action does nothing

    public void test03_MBL10659() throws Exception {
        String methodID = "test03_MBL10659";

        // Test Params:
        String entityType = "Contact";
        String entityRecord = TEST_CONTACT_RECORD;
        String viewName = "Contact Edit view";

        CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
        HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);

        System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);

        //Step: logout & log back in (to clear cookies)
        LogOutThenLogBackIn(userName, userPwd);

        try {
            //Step: search for Contact entity, then open it's Detail view
            AssertJUnit.assertTrue(commNav.entityRecordOpenDetailView(entityType, entityRecord));

            ContactViewsElements contactDetailView = PageFactory.initElements(driver, ContactViewsElements.class);

            commNav.isWebElementPresent(viewName + ", 'View address'", contactDetailView.contactsDetailViewViewAddressLnk);

            //Store the current window handle for the mobile window
            String winHandleBefore = driver.getWindowHandle();

            //Step: click on the contact detail view 'View Address' link ... should open map with address
            contactDetailView.contactsDetailViewViewAddressLnk.click();
            Thread.sleep(7000);

            //Switch to new window opened for the contact address
            for(String winHandle : driver.getWindowHandles()){
                driver.switchTo().window(winHandle);
            }

            AssertJUnit.assertTrue("VP: View Address action for contact has opened a map with address - FAILED", driver.getPageSource().contains("Google Maps"));
            System.out.println("VP: View Address action for contact has opened a map with address - PASSED");

            //Close the new window (address map)
            driver.close();

            //Switch back to original browser (first window - mobile)
            driver.switchTo().window(winHandleBefore);

        } catch (Exception e) {
            verificationErrors.append(methodID + "(): " + e.toString());
            System.out.println("VP: View Address action for contact has opened a map with address - FAILED");
            AssertJUnit.fail("test failed");
        }

        System.out.println(ENDLINE);
    }


    @Test(enabled = true)
    // MBL-10675 ... Lookup functionality is invalid in the Ticket Urgency


    public void test04_MBL10675() throws Exception {
        String methodID = "test04_MBL10675";

        // Test Params:
        String entityType = "ticket";
        String viewName = "Ticket Add Edit view";

        CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
        HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);
        CommonViewsElements commView = PageFactory.initElements(driver, CommonViewsElements.class);

        System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);

        //Step: logout & log back in (to clear cookies)
        LogOutThenLogBackIn(userName, userPwd);

        try {
            //Step: enter the Ticket Add Edit view...
            commNav.entityRecordAdd(entityType);

            TicketViewsElements ticketEditView = PageFactory.initElements(driver, TicketViewsElements.class);

            //Step: open the Ticket Urgency lookup
            ticketEditView.ticketsEditViewUrgencyFldBtn.click();
            commNav.waitForPage("Ticket Urgency");

            //Step: search for urgency values with 'high'
            System.out.println("VP: search for urgency values containing 'high' ");
            commView.lookupTxtBox.sendKeys("high");
            commView.lookupTxtBox.sendKeys(Keys.RETURN);
            Thread.sleep(3000);

            //Step: check the values of the top 2 items ... should only see values that include 'high'
            String urgencyItem1 = ticketEditView.ticketUrgency1stItem.getText();
            String urgencyItem2 = ticketEditView.ticketUrgency2ndItem.getText();
            AssertJUnit.assertEquals("VP: 1st item in Urgency list is not 'Med-High'  - FAILED", "Med-High", urgencyItem1);
            System.out.println("VP: 1st item in Urgency list is 'Med-High'  - PASSED");
            AssertJUnit.assertEquals("VP: 2nd item in Urgency list is not 'High'  - FAILED", "High", urgencyItem2);
            System.out.println("VP: 2nd item in Urgency list is 'High'  - PASSED");


        }
        catch (Exception e) {
            verificationErrors.append(e.toString());
            System.out.println(methodID + ": ticket urgency lookup failed");
            AssertJUnit.fail("test failed");
        }

        System.out.println(ENDLINE);
    }


    @Test(enabled = true)
    // MBL-10853 ... New Activities opened from Calendar view in Mobile do not auto populate cached Account, Contact, or Lead information (Unifirst 15097946)

    public void test05_MBL10853() throws Exception {
        String methodID = "test05_MBL10853";

        // Test Params:
        String entityType = "Accounts";
        String entityRecord = TEST_ACCOUNT_RECORD;
        String viewName = "Account Detail view";

        CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
        HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);
        MyActivityViewsElements activityEditView = PageFactory.initElements(driver, MyActivityViewsElements.class);

        System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);

        //Step: login & log back in (to clear cookies)
        LogOutThenLogBackIn(userName, userPwd);

        try {
            //Step: search for Account entity, then open it's Detail view
            commNav.entityRecordOpenDetailView(entityType, entityRecord);

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

            //Step: retrieve value for activity Account
            String newActivityAccount = activityEditView.activityEditViewAccountFld.getAttribute("value");
            System.out.println("VP: Calendar activity Account field has been pre-populated with a value of ... " + newActivityAccount);

            //Step: verify that activity is pre-populated with Abbott Ltd.
            AssertJUnit.assertEquals("VP: Activity created from Calendar has been pre-populated with previous Account value of ... " + TEST_ACCOUNT_RECORD + " - FAILED", TEST_ACCOUNT_RECORD, newActivityAccount);
            System.out.println("VP: Activity created from Calendar has been pre-populated with previous Account value of ... " + TEST_ACCOUNT_RECORD + " - PASSED");

        }
        catch (Exception e) {
            verificationErrors.append(e.toString());
            System.out.println(methodID + ": auto-population of calendar activity failed");
            AssertJUnit.fail("test failed");
        }


        System.out.println(ENDLINE);
    }


    @Test(enabled = true)
    // MBL-10402 ... Activities - timeless activities in listview displaying unexpected timeframe

    public void test06_MBL10402() throws Exception {
        String methodID = "test06_MBL10402";

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

            //Step: save activity
            headerButton.clickHeaderButton("Save");

            //Step: wait for page My Activities
            commNav.waitForPage("My Activities");

            //Step: search for activity created ... and verify that 'Timeless' displays in the listview
            activityEditView = PageFactory.initElements(driver, MyActivityViewsElements.class);
            activityEditView.performMyActivitiesSearch(newActivityRegarding);
            //WebElement activityItemLnk = driver.findElement(By.xpath("//*[@id='myactivity_list']//ul/li[1]/descendant::*[text() = '" + newActivityRegarding + "']"));
            String activityTime = activityEditView.topMyActivitiesListItemStartTime.getText();
            System.out.println("VP: Timeless activity displays in listview with a timeframe of ... " + activityTime);

            AssertJUnit.assertEquals("VP: Timeless activity displays in listview with a timeframe of 'Timeless' - FAILED", "Timeless", activityTime);
            System.out.println("VP: Timeless activity displays in listview with a timeframe of 'Timeless' - PASSED");

        }

        catch (Exception e) {
            verificationErrors.append(methodID + "(): " + e.toString());
            System.out.println("VP: Timeless activities in listview displaying unexpected timeframe " + " - FAILED");
            AssertJUnit.fail("test failed");
        }

        System.out.println(ENDLINE);
    }



    @Test(enabled = true)
    //MBL-10749 ... Opportunity listview : when adding a product via Products quick action, the Opportunity field does not populate by default [DTS 14097414]

    public void test07_MBL10749() throws Exception {

        String methodID = "test07_MBL10749";

        // Test Params:
        String entityType = "Opportunities";
        String expEntityPgTitle = "Opportunities";
        String oppRecord = TEST_OPPORTUNITY_RECORD;

        CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
        HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);

        System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
        //Step: click Top-Left button to reveal Global Menu...
        headerButton.showGlobalMenu();

        //Step: navigate to Opportunity list view ... search for Vegas Vision-Phase1
        commNav.entityListViewSearch(entityType, oppRecord);

        OpportunityViewsElements opportunitiesListView = PageFactory.initElements(driver, OpportunityViewsElements.class);


        //Step: display the Quick Action buttons, press products, '+' to open Opportunity Product form
        try {
            //click list item icon to reveal Quick Action items
            opportunitiesListView.topOpportunityListItemIcon.click();

            //click the Products Quick Action button
            opportunitiesListView.topOpportunityListItemQuickActionsProductsBtn.click();
            commNav.waitForPage("Products");
            headerButton.clickHeaderButton("Add");
            commNav.waitForPage("Opportunity Product");

            //Step: verify that the value for 'opportunity' is populated with the opportunity name
            String opportunityName = opportunitiesListView.opportunityProductOpportunityText.getAttribute("value");
            System.out.println("VP: Product opportunity value has been pre-populated as ... " + opportunityName);
            //Step: verify that Product opportunity is pre-populated with the associated opportunity
            AssertJUnit.assertEquals("VP: When added via listview quick action, Product opportunity value has been pre-populated with associated opportunity of ... " + TEST_OPPORTUNITY_RECORD + " - FAILED", TEST_OPPORTUNITY_RECORD, opportunityName);
            System.out.println("VP: When added via listview quick action, Product opportunity value has been pre-populated with associated opportunity of ... " + TEST_OPPORTUNITY_RECORD + " - PASSED");


        }
        catch (Exception e) {
            verificationErrors.append(methodID + "(): " + e.toString());
            System.out.println("VP: Opportunity populated when adding product via listview quick action " + " - FAILED");
            AssertJUnit.fail("test failed");
        }



        System.out.println(ENDLINE);
    }


    @Test(enabled = true)
    // MBL-10893/ MBL-10894 ... new activities added default to a time within the next 15 minutes

    public void test08_MBL10894() throws Exception {
        String methodID = "test08_MBL10894";

        CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
        CalendarViewsElements calendarView = PageFactory.initElements(driver, CalendarViewsElements.class);
        HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);
        MyActivityViewsElements activityEditView = PageFactory.initElements(driver, MyActivityViewsElements.class);

        System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);

        //Step: login & log back in (to clear cookies)
        LogOutThenLogBackIn(userName, userPwd);

        try {

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

            //Step: retrieve value for start time ... creating an activity for "today"
            String strDateTime = activityEditView.activityEditViewStartTimeFld.getAttribute("value");
            System.out.println("VP: 'Today' activity date/ time is ... " + strDateTime);
            String activityTime = strDateTime.substring(strDateTime.indexOf(' ')+1);
            System.out.println("VP: Activity time has a value of ... " + activityTime);


            //Step: convert activity string date representation to calendar date format
            SimpleDateFormat ft = new SimpleDateFormat("hh:mm a");
            Calendar activityDateTime1 = Calendar.getInstance();
            activityDateTime1.setTime(ft.parse(activityTime));



            //Step: convert current date/ time to date format of "hh:mm a", then convert time portion back to calendar date format
            Calendar todayDate = Calendar.getInstance();
            String todayString = ft.format(todayDate.getTime()).toString();
            System.out.println("VP: Today's date in hh:mm a format is - " + todayString);
            Calendar todayDateTime2 = Calendar.getInstance();
            todayDateTime2.setTime(ft.parse(todayString));

            //Step: calculate the number of minutes between activity date/time and current date/time
            long activityDateTime1InMillis = activityDateTime1.getTimeInMillis();
            long todayDateTime2InMillis = todayDateTime2.getTimeInMillis();
            long diffInMillis = activityDateTime1InMillis - todayDateTime2InMillis;
            System.out.println("VP: difference in milliseconds between activity date/time and current date/time is ... " + diffInMillis);
            long diffInMinutes = diffInMillis / (60 * 1000);
            System.out.println("VP: difference in minutes between activity date/time and current date/time is ... " + diffInMinutes);

            //Step: check that the number of minutes between activity date/time and current date is between 1 and 15
            if (diffInMinutes >= 1 && diffInMinutes <= 15) {
                System.out.println("VP: new activity added today is defaulting to a time within the next 15 minutes ... " + diffInMinutes + " - PASSED");
            }
            else {
                System.out.println("VP: new activity added today is defaulting to a time within the next 15 minutes ... " + diffInMinutes + " - FAILED");
                AssertJUnit.fail("test failed");
            }

            //Step: cancel out of activity, press Month button, scroll to next month
            headerButton.clickHeaderButton("cancel");

            calendarView.calendarIncrementMonthBtn.click();
            calendarView.calendarMonthFirstDayFourthRow.click();


            //Step: click the Add header button to open Activity schedule view
            headerButton.clickHeaderButton("Add");


            //Step: wait for page Schedule... to open
            commNav.waitForPage("Schedule...");

            //Step: select Meeting for activity type
            activityEditView = PageFactory.initElements(driver, MyActivityViewsElements.class);
            activityEditView.activityScheduleMeetingBtn.click();


            //Step: wait for page Meeting to open
            commNav.waitForPage("Meeting");

            //Step: retrieve value for start time ... creating an activity that is "not for today"
            strDateTime = activityEditView.activityEditViewStartTimeFld.getAttribute("value");
            System.out.println("VP: 'Not for Today' activity date/ time is ... " + strDateTime);
            activityTime = strDateTime.substring(strDateTime.indexOf(' ')+1);
            System.out.println("VP: Activity time has a value of ... " + activityTime);


            //Step: convert activity string date representation to calendar date format
            ft = new SimpleDateFormat("hh:mm a");
            activityDateTime1 = Calendar.getInstance();
            activityDateTime1.setTime(ft.parse(activityTime));



            //Step: convert current date/ time to date format of "hh:mm a", then convert time portion back to calendar date format
            todayDate = Calendar.getInstance();
            todayString = ft.format(todayDate.getTime()).toString();
            System.out.println("VP: Today's date in hh:mm a format is - " + todayString);
            todayDateTime2 = Calendar.getInstance();
            todayDateTime2.setTime(ft.parse(todayString));

            //Step: calculate the number of minutes between activity date/time and current date/time
            activityDateTime1InMillis = activityDateTime1.getTimeInMillis();
            todayDateTime2InMillis = todayDateTime2.getTimeInMillis();
            diffInMillis = activityDateTime1InMillis - todayDateTime2InMillis;
            System.out.println("VP: difference in milliseconds between activity date/time and current date/time is ... " + diffInMillis);
            diffInMinutes = diffInMillis / (60 * 1000);
            System.out.println("VP: difference in minutes between activity date/time and current date/time is ... " + diffInMinutes);

            //Step: check that the number of minutes between activity date/time and current date/time is between 1 and 15
            if (diffInMinutes >= 1 && diffInMinutes <= 15) {
                System.out.println("VP: new activity added not for today is defaulting to a time within the next 15 minutes ... " + diffInMinutes + " - PASSED");
            }
            else {
                System.out.println("VP: new activity added not for today is defaulting to a time within the next 15 minutes ... " + diffInMinutes + " - FAILED");
                AssertJUnit.fail("test failed");
            }

        }
        catch (Exception e) {
            verificationErrors.append(e.toString());
            System.out.println(methodID + ": new activities added default to a time within the next 15 minutes failed");
            AssertJUnit.fail("test failed");
        }


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
