package argos.saleslogix.selenium.test;

import org.openqa.selenium.*;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


//TODO: incomplete; need to finalize when needed for a requested test
/**
 * Test class that defines WebElements and methods for the Calendar view based tests against the SLX Mobile Client.
 * 
 * @author	mike.llena@swiftpage.com
 * @version	1.0
 */
public class CalendarViewsElements extends BaseTest {
	
	private WebDriver driver;

	public CalendarViewsElements(WebDriver driver) {
		this.driver = driver;		
	}
	
	CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);

	//Header Navigation elements
	
	@CacheLookup
	@FindBy(xpath = "//button[@data-tool='today']")
	WebElement calendarTodayBtn;
	
	@CacheLookup
	@FindBy(xpath = "//button[@data-tool='day']")
	WebElement calendarDayBtn;
	
	@CacheLookup
	@FindBy(xpath = "//button[@data-tool='week']")
	WebElement calendarWeekBtn;

    @CacheLookup
    @FindBy(xpath = "//button[@data-tool='month']")
    WebElement calendarMonthBtn;

    @CacheLookup
    @FindBy(xpath = "//button[@data-action='goToNextMonth']")
    WebElement calendarNextMonthBtn;
	
	@CacheLookup
    @FindBy(xpath = "//*[@id='calendar_daylist']/div[2]/button[5]")
	WebElement calendarDayListToMonthBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='datetime-picker-time']//button[@data-action='incrementHour']")
	WebElement calendarIncrementHourBtn;


	@CacheLookup
	@FindBy(xpath = "//*[@id='datetime-picker-time']//button[@data-action='incrementMinute']")
	WebElement calendarIncrementMinuteBtn;

    @CacheLookup
    @FindBy(xpath = "//*[@id='datetime-picker-date']//button[@data-action='decrementMonth']")
    WebElement calendarDecrementMonthBtn;


    //Day View elements
	
	
	//Week View Elements
	
	
	//Month View Elements

    @CacheLookup
    @FindBy(xpath = "//*[@id='calendar_monthlist']/div[4]/div[2]/table/tbody/tr[3]/td[1]")
    WebElement calendarMonthFirstDaySecondRow;


    @CacheLookup
    @FindBy(xpath = "//*[@id='calendar_monthlist']/div[4]/div[2]/table/tbody/tr[5]/td[1]")
    WebElement calendarMonthFirstDayFourthRow;


    @CacheLookup
    @FindBy(xpath = "//*[@id='calendar_monthlist']//span[@class='p-time']")
    WebElement calendarMonthFirstActivityTime;


    @CacheLookup
    @FindBy(xpath = "//*[@id='calendar_monthlist']//h3[@class='p-description']")
    WebElement calendarMonthFirstActivityDescription ;


    //Methods
	//TODO: clickCalendarNavButton() - click a specific nav button by name
	public boolean clickCalendarNavButton(String buttonName) {
		String methodID = "clickCalendarNavButton";
		
		Boolean clickNavResult = false;
		
		return clickNavResult;	
	}
	
	//TODO: goToCalendarDate() - navigates to a specific Cal date
	public boolean goToCalendarDate(String mon, String dd, String yyyy) {
		String methodID = "goToCalDate";
		
		Boolean clickNavResult = false;
		
		return clickNavResult;
	}
	
	//TODO: findCalendarActivity() - navigates to a specific Cal date, then determines if an activity is scheduled
	public boolean findCalendarActivity(String mon, String dd, String yyyy, String actName) {
		String methodID = "findCalendarActivity";
		
		Boolean clickNavResult = false;
		
		return clickNavResult;
	}
	
	//TODO: openCalendarActivity() - navigates to a specific Cal date, then determines if an activity is scheduled, if true then clicks and opens the activity	
	public boolean openCalendarActivity(String mon, String dd, String yyyy, String actName) {
		String methodID = "openCalendarActivity";
		
		Boolean clickNavResult = false;
		
		return clickNavResult;
	}
}
