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
	@FindBy(xpath = "//div[@data-action='goToToday']")
	WebElement calendarTodayBtn;

    @CacheLookup
    @FindBy(xpath = "//div[@class='toggle toggle-horizontal calendar__weekToggle']")
    WebElement calendarWeekToggle;

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

    // CalendarYearField ... use this for the Calendar screen (not calendar control)
    @CacheLookup
    @FindBy(xpath = "//div[contains(@id,'calendar-view__calendar')]//div[@class='year']//input")
    WebElement calendarYearField;

    // Calendar/ time control introduced in Mobile 3.4 :
    // - for the calendar screen use calendarYearxxx Item
    // - for the modal calendar control use calendarModalYearxxx Item

    @CacheLookup
    @FindBy(xpath = "//div[contains(@id,'year-dropdown datetime-calendar')]/ul/li[1]")
    WebElement calendarModalYearTopItem;

    @CacheLookup
    @FindBy(xpath = "//div[contains(@id,'year-dropdown datetime-calendar')]/ul/li[10]")
    WebElement calendarModalYearTen;

    @CacheLookup
    @FindBy(xpath = "//div[contains(@id,'year-dropdown datetime-calendar')]/ul/li[11]")
    WebElement calendarModalYearEleven;

    @CacheLookup
    @FindBy(xpath = "//div[contains(@id,'year-dropdown datetime-calendar')]/ul/li[21]")
    WebElement calendarModalYearBottomItem;

    @CacheLookup
    @FindBy(xpath = "//div[contains(@id,'year-dropdown datetime-calendar')]/ul//li[contains(@class, 'item--selected')]/following-sibling::*[1]")
    WebElement calendarModalYearFollowingSelectedYear;
    @CacheLookup
    @FindBy(xpath = "//div[contains(@id,'year-dropdown calendar-view__calendar')]/ul/li[1]")
    WebElement calendarYearTopItem;

    @CacheLookup
    @FindBy(xpath = "//div[contains(@id,'year-dropdown calendar-view__calendar')]/ul/li[10]")
    WebElement calendarYearTen;

    @CacheLookup
    @FindBy(xpath = "//div[contains(@id,'year-dropdown calendar-view__calendar')]/ul/li[11]")
    WebElement calendarYearEleven;

    @CacheLookup
    @FindBy(xpath = "//div[contains(@id,'year-dropdown calendar-view__calendar')]/ul/li[21]")
    WebElement calendarYearBottomItem;

    @CacheLookup
    @FindBy(xpath = "//div[contains(@id,'year-dropdown calendar-view__calendar')]/ul//li[contains(@class, 'item--selected')]/following-sibling::*[1]")
    WebElement calendarYearFollowingSelectedYear;

    // CalendarMonthField ... use this for the Calendar screen (not calendar control)
    @CacheLookup
    @FindBy(xpath = "//div[contains(@id,'calendar-view__calendar')]//div[@class='month']//input")
    WebElement calendarMonthField;

    // Calendar/ time control introduced in Mobile 3.4 ... month dropdown :
    // - for the calendar screen use calendarMonthxxx
    // - for the modal calendar control use calendarModalMonthxxx

    @CacheLookup
    @FindBy(xpath = "//div[contains(@id,'month-dropdown calendar-view__calendar')]//ul/li[1]")
    WebElement calendarMonthJan;

    @CacheLookup
    @FindBy(xpath = "//div[contains(@id,'month-dropdown datetime-calendar')]//ul/li[1]")
    WebElement calendarModalMonthJan;

    @CacheLookup
    @FindBy(xpath = "//div[contains(@id,'month-dropdown calendar-view__calendar')]//ul/li[2]")
    WebElement calendarMonthFeb;

    @CacheLookup
    @FindBy(xpath = "//div[contains(@id,'month-dropdown datetime-calendar')]//ul/li[2]")
    WebElement calendarModalMonthFeb;

    @CacheLookup
    @FindBy(xpath = "//div[contains(@id,'month-dropdown calendar-view__calendar')]//ul/li[3]")
    WebElement calendarMonthMar;

    @CacheLookup
    @FindBy(xpath = "//div[contains(@id,'month-dropdown datetime-calendar')]//ul/li[3]")
    WebElement calendarModalMonthMar;

    @CacheLookup
    @FindBy(xpath = "//div[contains(@id,'month-dropdown calendar-view__calendar')]//ul/li[4]")
    WebElement calendarMonthApr;

    @CacheLookup
    @FindBy(xpath = "//div[contains(@id,'month-dropdown datetime-calendar')]//ul/li[4]")
    WebElement calendarModalMonthApr;

    @CacheLookup
    @FindBy(xpath = "//div[contains(@id,'month-dropdown calendar-view__calendar')]//ul/li[5]")
    WebElement calendarMonthMay;

    @CacheLookup
    @FindBy(xpath = "//div[contains(@id,'month-dropdown datetime-calendar')]//ul/li[5]")
    WebElement calendarModalMonthMay;

    @CacheLookup
    @FindBy(xpath = "//div[contains(@id,'month-dropdown calendar-view__calendar')]//ul/li[6]")
    WebElement calendarMonthJun;

    @CacheLookup
    @FindBy(xpath = "//div[contains(@id,'month-dropdown datetime-calendar')]//ul/li[6]")
    WebElement calendarModalMonthJun;

    @CacheLookup
    @FindBy(xpath = "//div[contains(@id,'month-dropdown calendar-view__calendar')]//ul/li[7]")
    WebElement calendarMonthJul;

    @CacheLookup
    @FindBy(xpath = "//div[contains(@id,'month-dropdown datetime-calendar')]//ul/li[7]")
    WebElement calendarModalMonthJul;

    @CacheLookup
    @FindBy(xpath = "//div[contains(@id,'month-dropdown calendar-view__calendar')]//ul/li[8]")
    WebElement calendarMonthAug;

    @CacheLookup
    @FindBy(xpath = "//div[contains(@id,'month-dropdown datetime-calendar')]//ul/li[8]")
    WebElement calendarModalMonthAug;

    @CacheLookup
    @FindBy(xpath = "//div[contains(@id,'month-dropdown calendar-view__calendar')]//ul/li[9]")
    WebElement calendarMonthSep;

    @CacheLookup
    @FindBy(xpath = "//div[contains(@id,'month-dropdown datetime-calendar')]//ul/li[9]")
    WebElement calendarModalMonthSep;

    @CacheLookup
    @FindBy(xpath = "//div[contains(@id,'month-dropdown calendar-view__calendar')]//ul/li[10]")
    WebElement calendarMonthOct;

    @CacheLookup
    @FindBy(xpath = "//div[contains(@id,'month-dropdown datetime-calendar')]//ul/li[10]")
    WebElement calendarModalMonthOct;

    @CacheLookup
    @FindBy(xpath = "//div[contains(@id,'month-dropdown calendar-view__calendar')]//ul/li[11]")
    WebElement calendarMonthNov;

    @CacheLookup
    @FindBy(xpath = "//div[contains(@id,'month-dropdown datetime-calendar')]//ul/li[11]")
    WebElement calendarModalMonthNov;

    @CacheLookup
    @FindBy(xpath = "//div[contains(@id,'month-dropdown calendar-view__calendar')]//ul/li[12]")
    WebElement calendarMonthDec;

    @CacheLookup
    @FindBy(xpath = "//div[contains(@id,'month-dropdown datetime-calendar')]//ul/li[12]")
    WebElement calendarModalMonthDec;

    @FindBy(xpath = "//*[@id='hour-dropdown']//div[@role='combobox']")
    WebElement calendarHourField;

    @FindBy(xpath = "//*[@id='hour-dropdown']//select")
    WebElement calendarHourSelect;

    @FindBy(xpath = "//div[@id='dropdown-list']//ul/li[1]")
    WebElement calendarHourOne;

    @FindBy(xpath = "//div[@id='dropdown-list']//ul/li[2]")
    WebElement calendarHourTwo;

    @FindBy(xpath = "//div[@id='dropdown-list']//ul/li[3]")
    WebElement calendarHourThree;

    @FindBy(xpath = "//div[@id='dropdown-list']//ul/li[4]")
    WebElement calendarHourFour;

    @FindBy(xpath = "//div[@id='dropdown-list']//ul/li[5]")
    WebElement calendarHourFive;

    @FindBy(xpath = "//div[@id='dropdown-list']//ul/li[6]")
    WebElement calendarHourSix;

    @FindBy(xpath = "//div[@id='dropdown-list']//ul/li[7]")
    WebElement calendarHourSeven;

    @FindBy(xpath = "//div[@id='dropdown-list']//ul/li[8]")
    WebElement calendarHourEight;

    @FindBy(xpath = "//div[@id='dropdown-list']//ul/li[9]")
    WebElement calendarHourNine;

    @FindBy(xpath = "//div[@id='dropdown-list']//ul/li[10]")
    WebElement calendarHourTen;

    @FindBy(xpath = "//div[@id='dropdown-list']//ul/li[11]")
    WebElement calendarHourEleven;

    @FindBy(xpath = "//div[@id='dropdown-list']//ul/li[12]")
    WebElement calendarHourTwelve;

    @FindBy(xpath = "//div[@id='dropdown-list']//ul/li[13]")
    WebElement calendarHourThirteen;

    @FindBy(xpath = "//div[@id='dropdown-list']//ul/li[14]")
    WebElement calendarHourFourteen;

    @FindBy(xpath = "//div[@id='dropdown-list']//ul/li[15]")
    WebElement calendarHourFifteen;

    @FindBy(xpath = "//div[@id='dropdown-list']//ul/li[16]")
    WebElement calendarHourSixteen;

    @FindBy(xpath = "//div[@id='dropdown-list']//ul/li[17]")
    WebElement calendarHourSeventeen;

    @FindBy(xpath = "//div[@id='dropdown-list']//ul/li[18]")
    WebElement calendarHourEighteen;

    @FindBy(xpath = "//div[@id='dropdown-list']//ul/li[19]")
    WebElement calendarHourNineteen;

    @FindBy(xpath = "//div[@id='dropdown-list']//ul/li[20]")
    WebElement calendarHourTwenty;

    @FindBy(xpath = "//div[@id='dropdown-list']//ul/li[21]")
    WebElement calendarHourTwentyOne;

    @FindBy(xpath = "//div[@id='dropdown-list']//ul/li[22]")
    WebElement calendarHourTwentyTwo;

    @FindBy(xpath = "//div[@id='dropdown-list']//ul/li[23]")
    WebElement calendarHourTwentyThree;

    @FindBy(xpath = "//div[@id='dropdown-list']//ul/li[24]")
    WebElement calendarHourTwentyFour;

    @FindBy(xpath = "//*[@id='minute-modal']//select")
    WebElement calendarMinuteSelect;

    @FindBy(xpath = "//*[@id='minute-modal']//div[@role='combobox']")
    WebElement calendarMinuteField;

    @FindBy(xpath = "//div[@id='dropdown-list']//ul/li[1]")
    WebElement calendarMinute00;

    @FindBy(xpath = "//div[@id='dropdown-list']//ul/li[2]")
    WebElement calendarMinute05;

    @FindBy(xpath = "//div[@id='dropdown-list']//ul/li[3]")
    WebElement calendarMinute10;

    @FindBy(xpath = "//div[@id='dropdown-list']//ul/li[4]")
    WebElement calendarMinute15;

    @FindBy(xpath = "//div[@id='dropdown-list']//ul/li[5]")
    WebElement calendarMinute20;

    @FindBy(xpath = "//div[@id='dropdown-list']//ul/li[6]")
    WebElement calendarMinute25;

    @FindBy(xpath = "//div[@id='dropdown-list']//ul/li[7]")
    WebElement calendarMinute30;

    @FindBy(xpath = "//div[@id='dropdown-list']//ul/li[8]")
    WebElement calendarMinute35;

    @FindBy(xpath = "//div[@id='dropdown-list']//ul/li[9]")
    WebElement calendarMinute40;

    @FindBy(xpath = "//div[@id='dropdown-list']//ul/li[10]")
    WebElement calendarMinute45;

    @FindBy(xpath = "//div[@id='dropdown-list']//ul/li[11]")
    WebElement calendarMinute50;

    @FindBy(xpath = "//div[@id='dropdown-list']//ul/li[12]")
    WebElement calendarMinute55;

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
    @FindBy(xpath = "//span[@data-action='decrementMonth']")
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
    @FindBy(xpath = "(//div[contains(@id,'datetime-calendar')]//td[text()='1'])[1]")
    WebElement calendarModalDayOneCurrMonth;

    @CacheLookup
    @FindBy(xpath = "(//div[contains(@id,'calendar-view__calendar')]//td[text()='1'])[1]")
    WebElement calendarDayOneCurrMonth;

    @CacheLookup
    @FindBy(xpath = "(//div[contains(@id,'datetime-calendar')]//td[text()='16'])[1]")
    WebElement calendarModalDay16CurrMonth;

    @CacheLookup
    @FindBy(xpath = "(//div[contains(@id,'calendar-view__calendar')]//td[text()='16'])[1]")
    WebElement calendarDay16CurrMonth;

    @CacheLookup
    @FindBy(xpath = "(//div[contains(@id,'datetime-calendar')]//td[text()='18'])[1]")
    WebElement calendarModalDay18CurrMonth;

    @CacheLookup
    @FindBy(xpath = "(//div[contains(@id,'calendar-view__calendar')]//td[text()='18'])[1]")
    WebElement calendarDay18CurrMonth;

    @CacheLookup
    @FindBy(xpath = "//div[contains(@id,'datetime-calendar')]//td[contains(@class, 'selected')]")
    WebElement calendarModalDaySelected;

    @CacheLookup
    @FindBy(xpath = "//div[contains(@id,'calendar-view__calendar')]//td[contains(@class, 'selected')]")
    WebElement calendarDaySelected;

    // CalendarModalCurrMonthValue ... use this for the Calendar control (not calendar screen)
    @CacheLookup
    @FindBy(xpath = "//div[contains(@id,'datetime-calendar')]//div[@class='month']//input")
    WebElement calendarModalCurrMonthValue;

    // CalendarModalCurrYearValue ... use this for the Calendar control (not calendar screen)
    @CacheLookup
    @FindBy(xpath = "//div[contains(@id,'datetime-calendar')]//div[@class='year']//input")
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
    @FindBy(xpath = "//div[contains(@id,'datetime-calendar')]//th[contains(text(),'Su')]")
    WebElement calendarModalDayOfWeekSunday;

    @CacheLookup
    @FindBy(xpath = "//div[contains(@id,'datetime-calendar')]//th[contains(text(),'Mo')]")
    WebElement calendarModalDayOfWeekMonday;

    @CacheLookup
    @FindBy(xpath = "//div[contains(@id,'datetime-calendar')]//th[contains(text(),'Tu')]")
    WebElement calendarModalDayOfWeekTuesday;

    @CacheLookup
    @FindBy(xpath = "//div[contains(@id,'datetime-calendar')]//th[contains(text(),'We')]")
    WebElement calendarModalDayOfWeekWednesday;

    @CacheLookup
    @FindBy(xpath = "//div[contains(@id,'datetime-calendar')]//th[contains(text(),'Th')]")
    WebElement calendarModalDayOfWeekThursday;

    @CacheLookup
    @FindBy(xpath = "//div[contains(@id,'datetime-calendar')]//th[contains(text(),'Fr')]")
    WebElement calendarModalDayOfWeekFriday;

    @CacheLookup
    @FindBy(xpath = "//div[contains(@id,'datetime-calendar')]//th[contains(text(),'Sa')]")
    WebElement calendarModalDayOfWeekSaturday;

    @CacheLookup
    @FindBy(xpath = "//div[contains(@id,'calendar-view')]//th[contains(text(),'Su')]")
    WebElement calendarDayOfWeekSunday;

    @CacheLookup
    @FindBy(xpath = "//div[contains(@id,'calendar-view')]//th[contains(text(),'Mo')]")
    WebElement calendarDayOfWeekMonday;

    @CacheLookup
    @FindBy(xpath = "//div[contains(@id,'calendar-view')]//th[contains(text(),'Tu')]")
    WebElement calendarDayOfWeekTuesday;

    @CacheLookup
    @FindBy(xpath = "//div[contains(@id,'calendar-view')]//th[contains(text(),'We')]")
    WebElement calendarDayOfWeekWednesday;

    @CacheLookup
    @FindBy(xpath = "//div[contains(@id,'calendar-view')]//th[contains(text(),'Th')]")
    WebElement calendarDayOfWeekThursday;

    @CacheLookup
    @FindBy(xpath = "//div[contains(@id,'calendar-view')]//th[contains(text(),'Fr')]")
    WebElement calendarDayOfWeekFriday;

    @CacheLookup
    @FindBy(xpath = "//div[contains(@id,'calendar-view')]//th[contains(text(),'Sa')]")
    WebElement calendarDayOfWeekSaturday;

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
