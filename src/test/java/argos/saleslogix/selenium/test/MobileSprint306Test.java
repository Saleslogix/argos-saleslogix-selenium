package argos.saleslogix.selenium.test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;


/**
 * Test class that defines test methods for the SLX Mobile Defect (v3.06) fixes.
 * 
 * @author kathleen.lockyer-bratton@swiftpage.com
 * @version	1.0
 */
public class MobileSprint306Test extends BaseTest {
	
	public String TEST_CONTACT_RECORD = "Abbott, John";

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
	// MBL-10319 ... Can't remove items from multi-select picklist
	public void test01_MBL10319() throws Exception {
		String methodID = "test01_MBL10319";
		
		//Test Parameters:
		String entityType = "Contact";
		String contactRecord = TEST_CONTACT_RECORD;
		String viewName = "Contact Detail view";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
		
		try {
			//Step: search for Contact entity record, then open it's Edit view
			AssertJUnit.assertTrue(commNav.entityRecordEditView(entityType, contactRecord));
			
			//Step: ContactViewsElements class			
			ContactViewsElements contactEditView = PageFactory.initElements(driver, ContactViewsElements.class);
	
			
			//Step: click cuisine button on Contact edit view
			contactEditView.contactsEditViewCuisineInputFldBtn.click();
			
			//Step: wait for page Cuisine to open
			commNav.waitForPage("Cuisine");
			
			//Step: select 1st 4 cuisine items from Cuisine page and press check to accept values
			driver.findElement(By.xpath("//div[@id='pick_list_0']/ul/li[1]/div")).click();
			driver.findElement(By.xpath("//div[@id='pick_list_0']/ul/li[2]/div")).click();
			driver.findElement(By.xpath("//div[@id='pick_list_0']/ul/li[3]/div")).click();
			driver.findElement(By.xpath("//div[@id='pick_list_0']/ul/li[4]/div")).click();
			
			headerButton.clickHeaderButton("check");
			
		
			//Step: wait for page Contact (edit view) to open, then save changes
			commNav.waitForPage(entityType);
			headerButton.clickHeaderButton("save");
			
			//Step: wait for page Contact detail to open
			commNav.waitForPage(contactRecord);
			
			//Step: expand the More Details section if necessary ... in order to see cuisine values
			ContactViewsElements contactDetailView = PageFactory.initElements(driver, ContactViewsElements.class);
			
			commNav.isWebElementPresent(viewName + ", 'More Details' section header", contactDetailView.contactsDetailViewMoreDetailsHdr);
			//SubStep: conditionally expand the More Details section
			if (contactDetailView.contactsDetailViewMoreDetailsFields.getSize().height < 1) {
				contactDetailView.contactsDetailViewMoreDetailsHdr.click();
				Thread.sleep(1000);
			}
			
			//Step: save initial values in cuisine field, and verify expected values; if step fails, flags test as failing (red)
			String cuisineValInitial = contactEditView.contactsDetailViewCuisineFld.getText();
			System.out.println("Initial cuisine values are ... " + cuisineValInitial);
			try {
				AssertJUnit.assertEquals("Not seeing expected 4 cuisine values ... ", "cuisineAmerican Grill, Chinese, French, German", cuisineValInitial);
				System.out.println("VP: Seeing expected 4 cuisine values " + " - PASSED");
			}
			catch (Error e) {
				System.out.println(e.toString());
				System.out.println("VP: Not seeing expected 4 cuisine values - FAILED");
				AssertJUnit.fail("test failed");
			}
			
			//Step: re-open the Contact edit view
			headerButton.clickHeaderButton("edit");
			
			//Step: refresh ContactViewsElements class and click cuisine button on Contact edit view
			contactEditView = PageFactory.initElements(driver, ContactViewsElements.class);
			contactEditView.contactsEditViewCuisineInputFldBtn.click();
			
			//Step: wait for page Cuisine to open
			commNav.waitForPage("Cuisine");
			
			//Step: select 1st 4 cuisine items ... to uncheck items, and press check to accept values
			driver.findElement(By.xpath("//div[@id='pick_list_0']/ul/li[1]/div")).click();
			driver.findElement(By.xpath("//div[@id='pick_list_0']/ul/li[2]/div")).click();
			driver.findElement(By.xpath("//div[@id='pick_list_0']/ul/li[3]/div")).click();
			driver.findElement(By.xpath("//div[@id='pick_list_0']/ul/li[4]/div")).click();
						
			headerButton.clickHeaderButton("check");
			
			//Step: wait for page Contact (edit view) to open, then save
			commNav.waitForPage(entityType);
			headerButton.clickHeaderButton("save");
						
			//Step: wait for page Contact detail to open
			commNav.waitForPage(contactRecord);
			
			//Step: refresh ContactViewsElements class and expand the More Details section if necessary ... in order to see cuisine values
			contactDetailView = PageFactory.initElements(driver, ContactViewsElements.class);
			
			commNav.isWebElementPresent(viewName + ", 'More Details' section header", contactDetailView.contactsDetailViewMoreDetailsHdr);
			//SubStep: conditionally expand the More Details section
			if (contactDetailView.contactsDetailViewMoreDetailsFields.getSize().height < 1) {
				contactDetailView.contactsDetailViewMoreDetailsHdr.click();
				Thread.sleep(1000);
			}
			
			//Step: save modified values in cuisine field, and verify expected values; if step fails, flags test as failing (red)
			String cuisineValModified = contactEditView.contactsDetailViewCuisineFld.getText();
			System.out.println("Modified cuisine values are ... " + cuisineValModified);
			try {
				AssertJUnit.assertEquals("Not seeing expected no cuisine values ... ", "cuisine", cuisineValModified);
				System.out.println("VP: Able to remove multiple cuisine values when editing a contact record " + " - PASSED");
			}
			catch (Error e) {
				System.out.println(e.toString());
				System.out.println("VP: Not seeing expected no cuisine values - FAILED");
				AssertJUnit.fail("test failed");
			}
			
			
			
		}
		catch (Exception e) {
			verificationErrors.append(methodID + "(): " + e.toString());
			System.out.println("VP: able to remove multiple cuisine values when editing a contact record " + " - FAILED");
			AssertJUnit.fail("test failed");
		}
		
		System.out.println(ENDLINE);
	}

	
	@Test(enabled = true)
	// MBL-10280 ... Editing records is cumbersome when editing original information
	public void test02_MBL10280() throws Exception {
	    String methodID = "test02_MBL10280";
			
	    CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
	    HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);
	    AddAccountContactEditViewElements accountcontactEditView = PageFactory.initElements(driver, AddAccountContactEditViewElements.class);
	    CommonViewsElements commView = PageFactory.initElements(driver, CommonViewsElements.class);
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
		
		try {
			
			
	        //Step: logout & log back in (to clear cookies)
	        LogOutThenLogBackIn(userName, userPwd);
					
	                   
	        //Step: go to Add "Account/Contact" view
	        commNav.clickGlobalMenuItem("Add Account/Contact");
	
	        //Step: wait for page Add Account/Contact to open
		    commNav.waitForPage("Add Account / Contact");
		    
		    //Step: click on name button to open Edit Name screen
		    accountcontactEditView.addAcctCntctNameInputBtn.click();
		    
		    //Step: wait for page Edit Name 
		    commNav.waitForPage("Edit Name"); 
		    
		    //Step: enter values for first, middle and last names
		    commView.nameFirstInputFld.sendKeys("John");
		    commView.nameMiddleInputFld.sendKeys("Neo");
		    commView.nameLastInputFld.sendKeys("Smith");
		    
		    //Step: retrieve values for first, middle and last names ... print those values, and check to accept values
		    String firstName = commView.nameFirstInputFld.getAttribute("value");
		    String middleName = commView.nameMiddleInputFld.getAttribute("value");
		    String lastName = commView.nameLastInputFld.getAttribute("value");
		    System.out.println("VP: first name entered as - " + firstName );
		    System.out.println("VP: middle name entered as - " + middleName );
		    System.out.println("VP: last name entered as - " + lastName );
		    	    
		    headerButton.clickHeaderButton("check");
		    
		    
		    //Step: wait for page Add Account/Contact to open
		    commNav.waitForPage("Add Account / Contact");
		    
		    //Step: refresh class and then click on name button to re-open Edit Name screen
		    accountcontactEditView = PageFactory.initElements(driver, AddAccountContactEditViewElements.class);
		    accountcontactEditView.addAcctCntctNameInputBtn.click();
		    
		    //Step: wait for page Edit Name and refresh class
		    commNav.waitForPage("Edit Name"); 
		    commView = PageFactory.initElements(driver, CommonViewsElements.class);
		    
		    //Step: retrieve the values for first, middle and last names ... and print those values
		    firstName = commView.nameFirstInputFld.getAttribute("value");
		    middleName = commView.nameMiddleInputFld.getAttribute("value");
		    lastName = commView.nameLastInputFld.getAttribute("value");
		    System.out.println("VP: first name retained as - " + firstName );
		    System.out.println("VP: middle name retained as - " + middleName );
		    System.out.println("VP: last name retained as - " + lastName );
		    
		    //Step: validate that the values for first, middle and last names have been retained
		    AssertJUnit.assertEquals("First Name has not retained the value of John ", "John", firstName);
		    AssertJUnit.assertEquals("Middle Name has not retained the value of Neo ", "Neo", middleName);
		    AssertJUnit.assertEquals("Last Name has not retained the value of Smith ", "Smith", lastName);
		    System.out.println("VP: Editing records is cumbersome when editing original information " + " - PASSED");
		}
		catch (Exception e) {
			verificationErrors.append(methodID + "(): " + e.toString());
			System.out.println("VP: Editing records is cumbersome when editing original information " + " - FAILED");
			AssertJUnit.fail("test failed");		
		}
		
		System.out.println(ENDLINE);
	}

	@Test(enabled = true)
	// MBL-10397 ... Activity Start Date is wrong when toggling timeless (not retaining the same date)
	public void test03_MBL10397() throws Exception {
	    String methodID = "test03_MBL10397";
				
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
			driver.findElement(By.xpath("//*[@id='activity_types_list']/ul/li[1]/div[4]")).click();
			
			//Step: wait for page Meeting to open
			commNav.waitForPage("Meeting");
			
			//Step: add an Activity record with a random value for 'regarding' 
			String newActivityRegarding = "SeAutoTestActivity-" + new SimpleDateFormat("yyMMddHHmm").format(new GregorianCalendar().getTime());
			System.out.println("Activity regarding field will be - " + newActivityRegarding);
			
			activityEditView.activityEditViewRegardingFld.sendKeys(newActivityRegarding);
	
	        
			//Step: press the timeless toggle button to ON, then retrieve the value for MM/dd/yy
			activityEditView.activityEditViewTimelessTgl.click();
			String newActivityStartDate = activityEditView.activityEditViewStartTimeFld.getAttribute("value");
			System.out.println("Date/time value for Start Date is : " + newActivityStartDate);
			
	        
	        //Step: save activity
	        headerButton.clickHeaderButton("Save");
	        
	        //Step: wait for page My Activities
	        commNav.waitForPage("My Activities");
	        
	        //Step: search for activity created ... and re-open
	        activityEditView.performMyActivitiesSearch(newActivityRegarding);
	        WebElement activityItemLnk = driver.findElement(By.xpath("//*[@id='myactivity_list']/ul/li[1]/descendant::*[text() = '" + newActivityRegarding + "']"));
			commNav.highlightNClick(activityItemLnk);
			commNav.waitForPage("Activity");
	        
	        
	        //Step: open the activity created in edit mode
	        headerButton.clickHeaderButton("Edit");
	        
	        //Step: wait for page Activity
	        commNav.waitForPage("Activity");
	        
	        //Step: toggle timeless Off, then ON, then check that date is unchanged
	        activityEditView.activityEditViewTimelessTgl.click();
	        activityEditView.activityEditViewTimelessTgl.click();
			String secondActivityStartDate = activityEditView.activityEditViewStartTimeFld.getAttribute("value");
			System.out.println("Date/time value for Start Date before toggling was : " + newActivityStartDate);
			System.out.println("Date/time value for Start Date after toggling is : " + secondActivityStartDate);
			AssertJUnit.assertEquals("VP: Activity start date is wrong when toggling timeless - FAILED", newActivityStartDate, secondActivityStartDate);
			System.out.println("VP: Activity Start Date has remained the same when toggling timeless " + " - PASSED");
			      
			
		}
	
		 catch (Exception e) {
			 verificationErrors.append(methodID + "(): " + e.toString());
			 System.out.println("VP: Activity Start Date is wrong when toggling timeless " + " - FAILED");
			 AssertJUnit.fail("test failed");		
		 }
			
			System.out.println(ENDLINE);
		}

	@Test(enabled = true)
	// MBL-10193 ... Calendar - in Week and Day view a couple of activities are not appearing in time order for the day 
	public void test04_MBL10193() throws Exception {
	    String methodID = "test04_MBL10193";
				
	    CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
	    HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);
	    CalendarViewsElements calendarView = PageFactory.initElements(driver, CalendarViewsElements.class);
	    MyActivityViewsElements activityEditView = PageFactory.initElements(driver, MyActivityViewsElements.class);
	       
			
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
			
		try {
				
				
		    //Step: logout & log back in (to clear cookies)
		    LogOutThenLogBackIn(userName, userPwd);
						
		                   
		    //Step: go to "Calendar" view 
		    commNav.clickGlobalMenuItem("Calendar");
	
	        //Step: wait for page Calendar
		    commNav.waitForPage("Calendar");
		       	
			
		    //Step: ensure focus is on Today, then the Day view
		    calendarView.calendarTodayBtn.click();
		    calendarView.calendarDayBtn.click();
	         
		    
			//Step: Add 1st activity
	        //Step: click the Add header button to open Activity schedule view for 1st activity 
	        headerButton.clickHeaderButton("Add");
	        
	        //Step: wait for page Schedule... to open
			commNav.waitForPage("Schedule...");
			
			//Step: select Meeting for activity type
			activityEditView.activityScheduleMeetingBtn.click();
			
			//Step: wait for page Meeting to open
			commNav.waitForPage("Meeting");
			
			
			//Step: set 1st Activity record with 'regarding' value of Demonstration, date of today, and time 2 1/4 hours ahead of default 
			activityEditView.activityEditViewRegardingFld.sendKeys("Demonstration");
			activityEditView.activityEditViewStartTimeFldBtn.click();
			commNav.waitForPage("Calendar");
			calendarView.calendarIncrementHourBtn.click();
			calendarView.calendarIncrementHourBtn.click();
			calendarView.calendarIncrementMinuteBtn.click();
			headerButton.clickHeaderButton("check");
			commNav.waitForPage("Meeting");
			System.out.println("1st activity Date/time value for Start Date is : " + activityEditView.activityEditViewStartTimeFld.getAttribute("value"));
			
			//Step: save 1st activity
	        headerButton.clickHeaderButton("Save");
	
	        //Step: wait for page Calendar
	        commNav.waitForPage("Calendar");
			
		
			//Step: Add 2nd activity
	        //Step: click the Add header button to open Activity schedule view for 2nd activity 
	        headerButton.clickHeaderButton("Add");
	        
	        //Step: wait for page Schedule... to open
			commNav.waitForPage("Schedule...");
			
			//Step: select Meeting for activity type
			activityEditView = PageFactory.initElements(driver, MyActivityViewsElements.class);
			activityEditView.activityScheduleMeetingBtn.click();
			
			//Step: wait for page Meeting to open
			commNav.waitForPage("Meeting");
			
			
			//Step: set 2nd Activity record with 'regarding' value of Presentation, date of today, and time 3 hours ahead of default
			activityEditView = PageFactory.initElements(driver, MyActivityViewsElements.class);
			activityEditView.activityEditViewRegardingFld.sendKeys("Presentation");
			activityEditView.activityEditViewStartTimeFldBtn.click();
			commNav.waitForPage("Calendar");
			calendarView = PageFactory.initElements(driver, CalendarViewsElements.class);
			calendarView.calendarIncrementHourBtn.click();
			calendarView.calendarIncrementHourBtn.click();
			calendarView.calendarIncrementHourBtn.click();
			headerButton.clickHeaderButton("check");
			commNav.waitForPage("Meeting");
			System.out.println("2nd activity Date/time value for Start Date is : " + activityEditView.activityEditViewStartTimeFld.getAttribute("value"));
			
			//Step: save 2nd activity
	        headerButton.clickHeaderButton("Save");
	
	        //Step: wait for page Calendar
		    commNav.waitForPage("Calendar");
		    
		   
			//Step: Add 3rd activity
	        //Step: click the Add header button to open Activity schedule view for 3rd activity 
	        headerButton.clickHeaderButton("Add");
	        
	        //Step: wait for page Schedule... to open
			commNav.waitForPage("Schedule...");
			
			//Step: select Meeting for activity type
			activityEditView = PageFactory.initElements(driver, MyActivityViewsElements.class);
			activityEditView.activityScheduleMeetingBtn.click();
			
			//Step: wait for page Meeting to open
			commNav.waitForPage("Meeting");
			
			
			//Step: set 3rd Activity record with 'regarding' value of Review proposal, date of today, and time 1 1/2 hours ahead of default
			activityEditView = PageFactory.initElements(driver, MyActivityViewsElements.class);
			activityEditView.activityEditViewRegardingFld.sendKeys("Review proposal");
			activityEditView.activityEditViewStartTimeFldBtn.click();
			commNav.waitForPage("Calendar");
			calendarView = PageFactory.initElements(driver, CalendarViewsElements.class);
			calendarView.calendarIncrementHourBtn.click();
			calendarView.calendarIncrementMinuteBtn.click();
			calendarView.calendarIncrementMinuteBtn.click();
			headerButton.clickHeaderButton("check");
			commNav.waitForPage("Meeting");
			System.out.println("3rd activity Date/time value for Start Date is : " + activityEditView.activityEditViewStartTimeFld.getAttribute("value"));
			
			//Step: save 3rd activity
	        headerButton.clickHeaderButton("Save");
	
	        //Step: wait for page Calendar
		    commNav.waitForPage("Calendar");
		    
	        
		
			//Step: Add 4th activity  (All-Day)
	        //Step: click the Add header button to open Activity schedule view for 4th activity 
	        headerButton.clickHeaderButton("Add");
	        
	        //Step: wait for page Schedule... to open
			commNav.waitForPage("Schedule...");
			
			//Step: select Meeting for activity type
			activityEditView = PageFactory.initElements(driver, MyActivityViewsElements.class);
			activityEditView.activityScheduleMeetingBtn.click();
			
			//Step: wait for page Meeting to open
			commNav.waitForPage("Meeting");
			
			
			//Step: set 4th Activity record with 'regarding' value of Training, date of today, and timeless
			activityEditView = PageFactory.initElements(driver, MyActivityViewsElements.class);
			activityEditView.activityEditViewRegardingFld.sendKeys("Training");
			activityEditView.activityEditViewTimelessTgl.click();
			System.out.println("4th activity Date/time value for Start Date is : " + activityEditView.activityEditViewStartTimeFld.getAttribute("value"));
			
			//Step: save 4th activity
	        headerButton.clickHeaderButton("Save");
	
	        //Step: wait for page Calendar
		    commNav.waitForPage("Calendar");
		    
	        	    
	        //Calendar DAY VIEW
	        //Step: loop through any 'All-Day' events in Day view
		    int n=1;
		    while (driver.findElement(By.xpath("(//div[@id='calendar_daylist']//span[@class='p-time'])[" + n + "]")).getText().equals("All-Day"))  {
		    	n=n+1;	   
	        }
	
		    //Step: retrieve time for first non "All-Day" event in Day view
		    String strTime1 = driver.findElement(By.xpath("(//div[@id='calendar_daylist']//span[@class='p-time'])[" + n + "]")).getText();
		    n=n+1;
		    
		    //Step: loop through any 'All-Day' events in Day view
		    while (driver.findElement(By.xpath("(//div[@id='calendar_daylist']//span[@class='p-time'])[" + n + "]")).getText().equals("All-Day"))  {
		    	n=n+1;	   
	        }
		    
		    //Step: retrieve time for second non "All-Day" event in Day view
		    String strTime2 = driver.findElement(By.xpath("(//div[@id='calendar_daylist']//span[@class='p-time'])[" + n + "]")).getText();
		    n=n+1;
		    
		    //Step: loop through any 'All-Day' events in Day view
		    while (driver.findElement(By.xpath("(//div[@id='calendar_daylist']//span[@class='p-time'])[" + n + "]")).getText().equals("All-Day"))  {
		    	n=n+1;	   
	        }
		    
		    //Step: retrieve time for third non "All-Day" event in Day view
		    String strTime3 = driver.findElement(By.xpath("(//div[@id='calendar_daylist']//span[@class='p-time'])[" + n + "]")).getText();
		   	
		    //Step: print out activity times for first 3 activities under Day view
		    System.out.println("Day view today's date : 1st activity time has a value of - " + strTime1);
		    System.out.println("Day view today's date : 2nd activity time has a value of - " + strTime2);
		    System.out.println("Day view today's date : 3rd activity time has a value of - " + strTime3);
		    
		    //Step: convert string date representation to calendar date format
		    SimpleDateFormat ft = new SimpleDateFormat("hh:mm a");
		    Calendar dateTime1 = Calendar.getInstance();
		    Calendar dateTime2 = Calendar.getInstance();
		    Calendar dateTime3 = Calendar.getInstance();
	        dateTime1.setTime(ft.parse(strTime1));
	        dateTime2.setTime(ft.parse(strTime2));
	        dateTime3.setTime(ft.parse(strTime3));
	       
	        
	        //Step: check that Day view activities are appearing in descending date order
	        if ((!dateTime2.after(dateTime1)) && (!dateTime3.after(dateTime2))) {
	        	System.out.println("VP: Day view calendar activities are appearing in descending time order " + " - PASSED"); 	
	        } else {
	        	System.out.println("VP: Day view calendar activities not appearing in descending time order " + " - FAILED");
	        	AssertJUnit.fail("test failed");
	        }
	        
	        
	        //Calendar WEEK VIEW
	        //Step: switch focus to Week view
		    calendarView.calendarWeekBtn.click();
		    
		    //Step: convert today's date to string of format "MMM d,yyyy"
		    ft = new SimpleDateFormat("MMM d, yyyy");
		    Calendar todayDate = Calendar.getInstance();
		    String todayString = ft.format(todayDate.getTime()).toString();
		    System.out.println("Today's date in MMM d, yyyy format is - " + todayString);
	        
	        //Step: loop through days of the week until find section for today's date
	        int x=1;
	        while (!driver.findElement(By.xpath("(//div[@id='calendar_weeklist']//span[@class='dayHeaderRight'])[" + x + "]")).getText().equals(todayString))  {
		    	x=x+1;	   
	        }
	        
	        System.out.println("Week view: section found for today - " + driver.findElement(By.xpath("(//div[@id='calendar_weeklist']//span[@class='dayHeaderRight'])[" + x + "]")).getText());
	        
	        //Step: loop through any 'All Day' events in Week view section for today's date
		    n=1;
		    while (driver.findElement(By.xpath("(//div[@id='calendar_weeklist']//ul[" + x + "]//span[@class='p-time'])[" + n + "]")).getText().equals("All Day"))  {
		    	n=n+1;	   
	        }
	
		    //Step: retrieve time for first non "All Day" event in Week view section for today's date
		    strTime1 = driver.findElement(By.xpath("(//div[@id='calendar_weeklist']//ul[" + x + "]//span[@class='p-time'])[" + n + "]")).getText();
		    n=n+1;
		    
		    //Step: loop through any 'All Day' events in Week view section for today's date
		    while (driver.findElement(By.xpath("(//div[@id='calendar_weeklist']//ul[" + x + "]//span[@class='p-time'])[" + n + "]")).getText().equals("All Day"))  {
		    	n=n+1;	   
	        }
		    
		    //Step: retrieve time for second non "All Day" event in Week view section for today's date
		    strTime2 = driver.findElement(By.xpath("(//div[@id='calendar_weeklist']//ul[" + x + "]//span[@class='p-time'])[" + n + "]")).getText();
		    n=n+1;
		    
		    //Step: loop through any 'All Day' events in Week view section for today's date
		    while (driver.findElement(By.xpath("(//div[@id='calendar_weeklist']//ul[" + x + "]//span[@class='p-time'])[" + n + "]")).getText().equals("All Day"))  {
		    	n=n+1;   
	        }
		    
		    //Step: retrieve time for third non "All Day" event in Week view section for today's date
		    strTime3 = driver.findElement(By.xpath("(//div[@id='calendar_weeklist']//ul[" + x + "]//span[@class='p-time'])[" + n + "]")).getText();
		   	
		    //Step: print out activity times for first 3 activities under Day view
		    System.out.println("Week view today's date : 1st activity time has a value of - " + strTime1);
		    System.out.println("Week view today's date : 2nd activity time has a value of - " + strTime2);
		    System.out.println("Week view today's date : 3rd activity time has a value of - " + strTime3);
		    
		    //Step: convert string date representation to calendar date format
		    ft = new SimpleDateFormat("hh:mm a");
		    dateTime1 = Calendar.getInstance();
		    dateTime2 = Calendar.getInstance();
		    dateTime3 = Calendar.getInstance();
	        dateTime1.setTime(ft.parse(strTime1));
	        dateTime2.setTime(ft.parse(strTime2));
	        dateTime3.setTime(ft.parse(strTime3));
	       
	        
	        //Step: check that Week view activities for today's date are appearing in descending date order
	        if ((!dateTime2.after(dateTime1)) && (!dateTime3.after(dateTime2))) {
	        	System.out.println("VP: Week view calendar activities are appearing in descending time order " + " - PASSED"); 	
	        } else {
	        	System.out.println("VP: Week view calendar activities not appearing in descending time order " + " - FAILED");
	        	AssertJUnit.fail("test failed");
	        }
	        
	        
	        //Calendar MONTH VIEW
	        //Step: switch focus to Month view ... by default, today's activities display
		    calendarView.calendarMonthBtn.click();
		    
		    
		    //Step: loop through any 'All-Day' events in Month view
		    n=1;
		    while (driver.findElement(By.xpath("(//div[@id='calendar_monthlist']//span[@class='p-time'])[" + n + "]")).getText().equals("All-Day"))  {
		    	n=n+1;	   
	        }
	
		    //Step: retrieve time for first non "All-Day" event in Month view
		    strTime1 = driver.findElement(By.xpath("(//div[@id='calendar_monthlist']//span[@class='p-time'])[" + n + "]")).getText();
		    n=n+1;
		    
		    //Step: loop through any 'All-Day' events in Month view
		    while (driver.findElement(By.xpath("(//div[@id='calendar_monthlist']//span[@class='p-time'])[" + n + "]")).getText().equals("All-Day"))  {
		    	n=n+1;	   
	        }
		    
		    //Step: retrieve time for second non "All-Day" event in Month view
		    strTime2 = driver.findElement(By.xpath("(//div[@id='calendar_monthlist']//span[@class='p-time'])[" + n + "]")).getText();
		    n=n+1;
		    
		    //Step: loop through any 'All-Day' events in Month view
		    while (driver.findElement(By.xpath("(//div[@id='calendar_monthlist']//span[@class='p-time'])[" + n + "]")).getText().equals("All-Day"))  {
		    	n=n+1;	   
	        }
		    
		    //Step: retrieve time for third non "All-Day" event in Month view
		    strTime3 = driver.findElement(By.xpath("(//div[@id='calendar_monthlist']//span[@class='p-time'])[" + n + "]")).getText();
		   	
		    //Step: print out activity times for first 3 activities under Month view
		    System.out.println("Month view today's date : 1st activity time has a value of - " + strTime1);
		    System.out.println("Month view today's date : 2nd activity time has a value of - " + strTime2);
		    System.out.println("Month view today's date : 3rd activity time has a value of - " + strTime3);
		    
		    //Step: convert string date representation to calendar date format
		    ft = new SimpleDateFormat("hh:mm a");
		    dateTime1 = Calendar.getInstance();
		    dateTime2 = Calendar.getInstance();
		    dateTime3 = Calendar.getInstance();
	        dateTime1.setTime(ft.parse(strTime1));
	        dateTime2.setTime(ft.parse(strTime2));
	        dateTime3.setTime(ft.parse(strTime3));
	       
	        
	        //Step: check that Month view activities are appearing in descending date order
	        if ((!dateTime2.after(dateTime1)) && (!dateTime3.after(dateTime2))) {
	        	System.out.println("VP: Month view calendar activities are appearing in descending time order " + " - PASSED"); 	
	        } else {
	        	System.out.println("VP: Month view calendar activities not appearing in descending time order " + " - FAILED");
	        	AssertJUnit.fail("test failed");
	        }
	        
	        
		    
	             }
	
		 catch (Exception e) {
			 verificationErrors.append(methodID + "(): " + e.toString());
			 System.out.println("VP: calendar activities not appearing in descending time order " + " - FAILED");
			 AssertJUnit.fail("test failed");		
		 }
			
			System.out.println(ENDLINE);
		}
}
