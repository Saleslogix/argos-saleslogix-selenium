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

    // Date Time Picker Calendar fields

    @CacheLookup
    @FindBy(xpath = "//*[@id='day-field']")
    WebElement calendarDayField;

    @CacheLookup
    @FindBy(xpath = "//div[@class='year']//input")
    WebElement calendarYearField;

    @CacheLookup
    @FindBy(xpath = "//div[8]/ul/li[1]")
    WebElement calendarYearTopItem;

    @CacheLookup
    @FindBy(xpath = "//div[8]/ul/li[21]")
    WebElement calendarYearBottomItem;

    @CacheLookup
    @FindBy(xpath = "//div[@class='month']//input")
    WebElement calendarMonthField;

    @CacheLookup
    @FindBy(xpath = "//ul/li[@data-value='January']")
    WebElement calendarMonthJan;

    @CacheLookup
    @FindBy(xpath = "//ul/li[@data-value='February']")
    WebElement calendarMonthFeb;

    @CacheLookup
    @FindBy(xpath = "//ul/li[@data-value='March']")
    WebElement calendarMonthMar;

    @CacheLookup
    @FindBy(xpath = "//ul/li[@data-value='April']")
    WebElement calendarMonthApr;

    @CacheLookup
    @FindBy(xpath = "//ul/li[@data-value='May']")
    WebElement calendarMonthMay;

    @CacheLookup
    @FindBy(xpath = "//ul/li[@data-value='June']")
    WebElement calendarMonthJun;

    @CacheLookup
    @FindBy(xpath = "//ul/li[@data-value='July']")
    WebElement calendarMonthJul;

    @CacheLookup
    @FindBy(xpath = "//ul/li[@data-value='August']")
    WebElement calendarMonthAug;

    @CacheLookup
    @FindBy(xpath = "//ul/li[@data-value='September']")
    WebElement calendarMonthSep;

    @CacheLookup
    @FindBy(xpath = "//ul/li[@data-value='October']")
    WebElement calendarMonthOct;

    @CacheLookup
    @FindBy(xpath = "//ul/li[@data-value='November']")
    WebElement calendarMonthNov;

    @CacheLookup
    @FindBy(xpath = "//ul/li[@data-value='December']")
    WebElement calendarMonthDec;

    @CacheLookup
    @FindBy(xpath = "//*[@id='hour-dropdown']/input")
    WebElement calendarHourField;

    @CacheLookup
    @FindBy(xpath = "//ul/li[@data-value='1']")
    WebElement calendarHourOne;

    @CacheLookup
    @FindBy(xpath = "//ul/li[@data-value='5']")
    WebElement calendarHourFive;

    @CacheLookup
    @FindBy(xpath = "//ul/li[@data-value='7']")
    WebElement calendarHourSeven;

    @CacheLookup
    @FindBy(xpath = "//ul/li[@data-value='8']")
    WebElement calendarHourEight;

    @CacheLookup
    @FindBy(xpath = "//ul/li[@data-value='9']")
    WebElement calendarHourNine;

    @CacheLookup
    @FindBy(xpath = "//*[@id='minute-modal']/input")
    WebElement calendarMinuteField;

    @CacheLookup
    @FindBy(xpath = "//ul/li[@data-value='00']")
    WebElement calendarMinute00;

    @CacheLookup
    @FindBy(xpath = "//ul/li[@data-value='15']")
    WebElement calendarMinute15;

    @CacheLookup
    @FindBy(xpath = "//span[@class='toggleOn']")
    WebElement calendarAM;

    @CacheLookup
    @FindBy(xpath = "//span[@class='toggleOff']")
    WebElement calendarPM;

	@CacheLookup
	@FindBy(xpath = "//span[@data-action='incrementMonth']")
	WebElement calendarIncrementMonthBtn;

    @CacheLookup
    @FindBy(xpath = "//*[@id='datetime-picker-time']//button[@data-action='incrementHour']")
    WebElement calendarIncrementHourBtn;

    @CacheLookup
    @FindBy(xpath = "//*[@id='datetime-picker-time']//button[@data-action='decrementHour']")
    WebElement calendarDecrementHourBtn;


	@CacheLookup
	@FindBy(xpath = "//*[@id='datetime-picker-time']//button[@data-action='incrementMinute']")
	WebElement calendarIncrementMinuteBtn;

    @CacheLookup
    @FindBy(xpath = "//*[@id='datetime-picker-date']//button[@data-action='decrementMonth']")
    WebElement calendarDecrementMonthBtn;

    @CacheLookup
    @FindBy(xpath = "//*[@id='datetime-picker-date']//button[@data-action='incrementYear']")
    WebElement calendarIncrementYearBtn;


    //Day View elements
	
	
	//Week View Elements
	
	
	//Month View Elements

    @CacheLookup
    @FindBy(xpath = "//*[@id='calendar-view__calendar']//tr[2]/td[1]")
    WebElement calendarMonthFirstDaySecondRow;


    @CacheLookup
    @FindBy(xpath = "//*[@id='calendar-view__calendar']//tr[3]/td[1]")
    WebElement calendarMonthFirstDayThirdRow;


    @CacheLookup
    @FindBy(xpath = "//*[@id='calendar-view__calendar']//tr[4]/td[1]")
    WebElement calendarMonthFirstDayFourthRow;


    @CacheLookup
    @FindBy(xpath = "//span[@class='timeStamp__time']")
    WebElement calendarMonthFirstActivityTime;


    @CacheLookup
    @FindBy(xpath = "//h3[@class='header__title']")
    WebElement calendarMonthFirstActivityDescription ;

    @CacheLookup
    @FindBy(xpath = "//*[@id='calendar_monthlist']//td[contains(@data-date, '-01')]")
    WebElement calendarMonthFirstDayMonth;

    @CacheLookup
    @FindBy(xpath = "//*[@id='calendar_monthlist']//td[contains(@data-date, '-01')]//span[@class='activity-count']")
    WebElement calendarMonthFirstDayMonthActivityCount;

    @CacheLookup
    @FindBy(xpath = "(.//td[text()='1'])[1]")
    WebElement calendarModalDayOneCurrMonth;

    @CacheLookup
    @FindBy(xpath = "//div[@id='modal-template']//div[@class='month']//input")
    WebElement calendarModalCurrMonthValue;

    @CacheLookup
    @FindBy(xpath = "//div[@id='modal-template']//div[@class='year']//input")
    WebElement calendarModalCurrYearValue;

    @CacheLookup
    @FindBy(xpath = "//div[@id='modal-template']//span[@data-action='incrementMonth']")
    WebElement calendarModalIncrMonth;

    @CacheLookup
    @FindBy(xpath = "//div[@id='modal-template']//span[@data-action='decrementMonth']")
    WebElement calendarModalDecrMonth;

    @CacheLookup
    @FindBy(xpath = "//div[contains(text(),'Confirm')]")
    WebElement calendarModalConfirm;

    @CacheLookup
    @FindBy(xpath = "//div[contains(text(),'Cancel')]")
    WebElement calendarModalCancel;

    @CacheLookup
    @FindBy(xpath = "//div[contains(text(),'Advanced')]")
    WebElement calendarModalAdvanced;

    @CacheLookup
    @FindBy(xpath = "//div[@id='modal-template']//div[@data-action='goToToday']")
    WebElement calendarModalTodayBtn;

    @CacheLookup
    @FindBy(xpath = "//th[contains(text(),'Su')]")
    WebElement calendarModalDayOfWeekSunday;

    @CacheLookup
    @FindBy(xpath = "//th[contains(text(),'Mo')]")
    WebElement calendarModalDayOfWeekMonday;

    @CacheLookup
    @FindBy(xpath = "//th[contains(text(),'Tu')]")
    WebElement calendarModalDayOfWeekTuesday;

    @CacheLookup
    @FindBy(xpath = "//th[contains(text(),'We')]")
    WebElement calendarModalDayOfWeekWednesday;

    @CacheLookup
    @FindBy(xpath = "//th[contains(text(),'Th')]")
    WebElement calendarModalDayOfWeekThursday;

    @CacheLookup
    @FindBy(xpath = "//th[contains(text(),'Fr')]")
    WebElement calendarModalDayOfWeekFriday;

    @CacheLookup
    @FindBy(xpath = "//th[contains(text(),'Sa')]")
    WebElement calendarModalDayOfWeekSaturday;

    @CacheLookup
    @FindBy(xpath = "//div[@class='relative-datetime-select__title']")
    WebElement calendarModalRelativeDateTitle;

    @CacheLookup
    @FindBy(xpath = "//ul//li//div[contains(., 'This Evening')]")
    WebElement calendarModalThisEveningTitle;

    @CacheLookup
    @FindBy(xpath = "//ul//li//div[contains(., 'This Evening')]/following::div[1]")
    WebElement calendarModalThisEveningValue;

    @CacheLookup
    @FindBy(xpath = "//ul//li//div[contains(., 'Tomorrow Morning')]")
    WebElement calendarModalTomorrowMorningTitle;

    @CacheLookup
    @FindBy(xpath = "//ul//li//div[contains(., 'Tomorrow Morning')]/following::div[1]")
    WebElement calendarModalTomorrowMorningValue;

    @CacheLookup
    @FindBy(xpath = "//ul//li//div[contains(., 'Tomorrow Evening')]")
    WebElement calendarModalTomorrowEveningTitle;

    @CacheLookup
    @FindBy(xpath = "//ul//li//div[contains(., 'Tomorrow Evening')]/following::div[1]")
    WebElement calendarModalTomorrowEveningValue;

    @CacheLookup
    @FindBy(xpath = "//ul//li//div[contains(., 'Next Week')]")
    WebElement calendarModalNextWeekTitle;

    @CacheLookup
    @FindBy(xpath = "//ul//li//div[contains(., 'Next Week')]/following::div[1]")
    WebElement calendarModalNextWeekValue;

    @CacheLookup
    @FindBy(xpath = "//ul//li//div[contains(., 'Next Month')]")
    WebElement calendarModalNextMonthTitle;

    @CacheLookup
    @FindBy(xpath = "//ul//li//div[contains(., 'Next Month')]/following::div[1]")
    WebElement calendarModalNextMonthValue;



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
