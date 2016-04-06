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
    @FindBy(xpath = "//span[@class='toggleOn weekToggle__on']")
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
    // - for the calendar screen use calendarYearxxxItem
    // - for the modal calendar control use calendarYearxxxItem if the Calendar screen has not been opened
    // - for the modal calendar control use calendarModalYearxxxItem if the Calendar screen has been opened

    @CacheLookup
    @FindBy(xpath = "//div[8]/ul/li[1]")
    WebElement calendarModalYearTopItem;

    @CacheLookup
    @FindBy(xpath = "//div[8]/ul/li[10]")
    WebElement calendarModalYearTen;

    @CacheLookup
    @FindBy(xpath = "//div[8]/ul/li[11]")
    WebElement calendarModalYearEleven;

    @CacheLookup
    @FindBy(xpath = "//div[8]/ul/li[21]")
    WebElement calendarModalYearBottomItem;

    @CacheLookup
    @FindBy(xpath = "//div[8]/ul//li[contains(@class, 'item--selected')]/following-sibling::*[1]")
    WebElement calendarModalYearFollowingSelectedYear;
    @CacheLookup
    @FindBy(xpath = "//div[6]/ul/li[1]")
    WebElement calendarYearTopItem;

    @CacheLookup
    @FindBy(xpath = "//div[6]/ul/li[10]")
    WebElement calendarYearTen;

    @CacheLookup
    @FindBy(xpath = "//div[6]/ul/li[11]")
    WebElement calendarYearEleven;

    @CacheLookup
    @FindBy(xpath = "//div[6]/ul/li[21]")
    WebElement calendarYearBottomItem;

    @CacheLookup
    @FindBy(xpath = "//div[6]/ul//li[contains(@class, 'item--selected')]/following-sibling::*[1]")
    WebElement calendarYearFollowingSelectedYear;

    // CalendarMonthField ... use this for the Calendar screen (not calendar control)
    @CacheLookup
    @FindBy(xpath = "//div[contains(@id,'calendar-view__calendar')]//div[@class='month']//input")
    WebElement calendarMonthField;

    // Calendar/ time control introduced in Mobile 3.4 :
    // - for the calendar screen use calendarMonthxxx
    // - for the modal calendar control use calendarMonthxxx if the Calendar screen has not been opened
    // - for the modal calendar control use calendarModalMonthxxx if the Calendar screen has been opened

    @CacheLookup
    @FindBy(xpath = "//ul/li[@data-value='January']")
    WebElement calendarMonthJan;

    @CacheLookup
    @FindBy(xpath = "//div[7]//ul/li[@data-value='January']")
    WebElement calendarModalMonthJan;

    @CacheLookup
    @FindBy(xpath = "//ul/li[@data-value='February']")
    WebElement calendarMonthFeb;

    @CacheLookup
    @FindBy(xpath = "//div[7]//ul/li[@data-value='February']")
    WebElement calendarModalMonthFeb;

    @CacheLookup
    @FindBy(xpath = "//ul/li[@data-value='March']")
    WebElement calendarMonthMar;

    @CacheLookup
    @FindBy(xpath = "//div[7]//ul/li[@data-value='March']")
    WebElement calendarModalMonthMar;

    @CacheLookup
    @FindBy(xpath = "//ul/li[@data-value='April']")
    WebElement calendarMonthApr;

    @CacheLookup
    @FindBy(xpath = "//div[7]//ul/li[@data-value='April']")
    WebElement calendarModalMonthApr;

    @CacheLookup
    @FindBy(xpath = "//ul/li[@data-value='May']")
    WebElement calendarMonthMay;

    @CacheLookup
    @FindBy(xpath = "//div[7]//ul/li[@data-value='May']")
    WebElement calendarModalMonthMay;

    @CacheLookup
    @FindBy(xpath = "//ul/li[@data-value='June']")
    WebElement calendarMonthJun;

    @CacheLookup
    @FindBy(xpath = "//div[7]//ul/li[@data-value='June']")
    WebElement calendarModalMonthJun;

    @CacheLookup
    @FindBy(xpath = "//ul/li[@data-value='July']")
    WebElement calendarMonthJul;

    @CacheLookup
    @FindBy(xpath = "//div[7]//ul/li[@data-value='July']")
    WebElement calendarModalMonthJul;

    @CacheLookup
    @FindBy(xpath = "//ul/li[@data-value='August']")
    WebElement calendarMonthAug;

    @CacheLookup
    @FindBy(xpath = "//div[7]//ul/li[@data-value='August']")
    WebElement calendarModalMonthAug;

    @CacheLookup
    @FindBy(xpath = "//ul/li[@data-value='September']")
    WebElement calendarMonthSep;

    @CacheLookup
    @FindBy(xpath = "//div[7]//ul/li[@data-value='September']")
    WebElement calendarModalMonthSep;

    @CacheLookup
    @FindBy(xpath = "//ul/li[@data-value='October']")
    WebElement calendarMonthOct;

    @CacheLookup
    @FindBy(xpath = "//div[7]//ul/li[@data-value='October']")
    WebElement calendarModalMonthOct;

    @CacheLookup
    @FindBy(xpath = "//ul/li[@data-value='November']")
    WebElement calendarMonthNov;

    @CacheLookup
    @FindBy(xpath = "//div[7]//ul/li[@data-value='November']")
    WebElement calendarModalMonthNov;

    @CacheLookup
    @FindBy(xpath = "//ul/li[@data-value='December']")
    WebElement calendarMonthDec;

    @CacheLookup
    @FindBy(xpath = "//div[7]//ul/li[@data-value='December']")
    WebElement calendarModalMonthDec;

    @CacheLookup
    @FindBy(xpath = "//*[@id='hour-dropdown']/input")
    WebElement calendarHourField;

    @CacheLookup
    @FindBy(xpath = "//ul/li[@data-value='1']")
    WebElement calendarHourOne;

    @CacheLookup
    @FindBy(xpath = "//ul/li[@data-value='2']")
    WebElement calendarHourTwo;

    @CacheLookup
    @FindBy(xpath = "//ul/li[@data-value='3']")
    WebElement calendarHourThree;

    @CacheLookup
    @FindBy(xpath = "//ul/li[@data-value='4']")
    WebElement calendarHourFour;

    @CacheLookup
    @FindBy(xpath = "//ul/li[@data-value='5']")
    WebElement calendarHourFive;

    @CacheLookup
    @FindBy(xpath = "//ul/li[@data-value='6']")
    WebElement calendarHourSix;

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
    @FindBy(xpath = "//ul/li[@data-value='9']/following-sibling::*[1]")
    WebElement calendarHourTen;

    @CacheLookup
    @FindBy(xpath = "//ul/li[@data-value='11']")
    WebElement calendarHourEleven;

    @CacheLookup
    @FindBy(xpath = "//ul/li[@data-value='12']")
    WebElement calendarHourTwelve;

    @CacheLookup
    @FindBy(xpath = "//*[@id='minute-modal']/input")
    WebElement calendarMinuteField;

    @CacheLookup
    @FindBy(xpath = "//ul/li[@data-value='00']")
    WebElement calendarMinute00;

    @CacheLookup
    @FindBy(xpath = "//ul/li[@data-value='05']")
    WebElement calendarMinute05;

    @CacheLookup
    @FindBy(xpath = "//ul/li[@data-value='05']/following-sibling::*[1]")
    WebElement calendarMinute10;

    @CacheLookup
    @FindBy(xpath = "//ul/li[@data-value='15']")
    WebElement calendarMinute15;

    @CacheLookup
    @FindBy(xpath = "//ul/li[@data-value='20']")
    WebElement calendarMinute20;

    @CacheLookup
    @FindBy(xpath = "//ul/li[@data-value='25']")
    WebElement calendarMinute25;

    @CacheLookup
    @FindBy(xpath = "//ul/li[@data-value='30']")
    WebElement calendarMinute30;

    @CacheLookup
    @FindBy(xpath = "//ul/li[@data-value='35']")
    WebElement calendarMinute35;

    @CacheLookup
    @FindBy(xpath = "//ul/li[@data-value='40']")
    WebElement calendarMinute40;

    @CacheLookup
    @FindBy(xpath = "//ul/li[@data-value='45']")
    WebElement calendarMinute45;

    @CacheLookup
    @FindBy(xpath = "//ul/li[@data-value='50']")
    WebElement calendarMinute50;

    @CacheLookup
    @FindBy(xpath = "//ul/li[@data-value='55']")
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
