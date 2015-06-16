package argos.saleslogix.selenium.test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;
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


            //Step: go to Calendar view ... wait for page Calendar, and press 'Month' button
            commNav.clickGlobalMenuItem("Calendar");
            commNav.waitForPage("Calendar");
            calendarView.calendarDayListToMonthBtn.click();


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
