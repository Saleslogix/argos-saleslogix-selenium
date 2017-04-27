package argos.saleslogix.selenium.pages;

import argos.saleslogix.selenium.test.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


//TODO: incomplete; need to finalize when needed for a requested test

/**
 * Test class that defines WebElements and methods for the Calendar view based tests against the SLX Mobile Client.
 *
 * @author mike.llena@swiftpage.com
 * @version 1.0
 */
public class CalendarViewsElements extends BaseTest {

    @CacheLookup
    @FindBy(xpath = "//div[@data-action='goToToday']")
    public WebElement calendarTodayBtn;
    @CacheLookup
    @FindBy(xpath = "//div[@class='toggle toggle-horizontal calendar__weekToggle']")
    public WebElement calendarWeekToggle;
    @CacheLookup
    @FindBy(xpath = "//button[@data-tool='day']")
    public WebElement calendarDayBtn;

    //Header Navigation elements
    @CacheLookup
    @FindBy(xpath = "//button[@data-tool='week']")
    public WebElement calendarWeekBtn;
    @CacheLookup
    @FindBy(xpath = "//button[@data-tool='month']")
    public WebElement calendarMonthBtn;
    @CacheLookup
    @FindBy(xpath = "//button[@data-action='goToNextMonth']")
    public WebElement calendarNextMonthBtn;
    @CacheLookup
    @FindBy(xpath = "//*[@id='calendar_daylist']/div[2]/button[5]")
    public WebElement calendarDayListToMonthBtn;
    @CacheLookup
    @FindBy(xpath = "//*[@id='day-field']")
    public WebElement calendarDayField;
    // CalendarYearField ... use this for the Calendar screen (not calendar control)
    @CacheLookup
    @FindBy(xpath = "//div[contains(@id,'calendar-view__calendar')]//div[@class='year']//input")
    public WebElement calendarYearField;
    @CacheLookup
    @FindBy(xpath = "//div[contains(@id,'year-dropdown datetime-calendar')]/ul/li[1]")
    public WebElement calendarModalYearTopItem;

    // Date Time Picker Calendar fields
    @CacheLookup
    @FindBy(xpath = "//div[contains(@id,'year-dropdown datetime-calendar')]/ul/li[10]")
    public WebElement calendarModalYearTen;
    @CacheLookup
    @FindBy(xpath = "//div[contains(@id,'year-dropdown datetime-calendar')]/ul/li[11]")
    public WebElement calendarModalYearEleven;

    // Calendar/ time control introduced in Mobile 3.4 :
    // - for the calendar screen use calendarYearxxx Item
    // - for the modal calendar control use calendarModalYearxxx Item
    @CacheLookup
    @FindBy(xpath = "//div[contains(@id,'year-dropdown datetime-calendar')]/ul/li[21]")
    public WebElement calendarModalYearBottomItem;
    @CacheLookup
    @FindBy(xpath = "//div[contains(@id,'year-dropdown datetime-calendar')]/ul//li[contains(@class, 'item--selected')]/following-sibling::*[1]")
    public WebElement calendarModalYearFollowingSelectedYear;
    @CacheLookup
    @FindBy(xpath = "//div[contains(@id,'year-dropdown calendar-view__calendar')]/ul/li[1]")
    public WebElement calendarYearTopItem;
    @CacheLookup
    @FindBy(xpath = "//div[contains(@id,'year-dropdown calendar-view__calendar')]/ul/li[10]")
    public WebElement calendarYearTen;
    @CacheLookup
    @FindBy(xpath = "//div[contains(@id,'year-dropdown calendar-view__calendar')]/ul/li[11]")
    public WebElement calendarYearEleven;
    @CacheLookup
    @FindBy(xpath = "//div[contains(@id,'year-dropdown calendar-view__calendar')]/ul/li[21]")
    public WebElement calendarYearBottomItem;
    @CacheLookup
    @FindBy(xpath = "//div[contains(@id,'year-dropdown calendar-view__calendar')]/ul//li[contains(@class, 'item--selected')]/following-sibling::*[1]")
    public WebElement calendarYearFollowingSelectedYear;
    // CalendarMonthField ... use this for the Calendar screen (not calendar control)
    @CacheLookup
    @FindBy(xpath = "//div[contains(@id,'calendar-view__calendar')]//div[@class='month']//input")
    public WebElement calendarMonthField;
    @CacheLookup
    @FindBy(xpath = "//div[contains(@id,'month-dropdown calendar-view__calendar')]//ul/li[1]")
    public WebElement calendarMonthJan;
    @CacheLookup
    @FindBy(xpath = "//div[contains(@id,'month-dropdown datetime-calendar')]//ul/li[1]")
    public WebElement calendarModalMonthJan;
    @CacheLookup
    @FindBy(xpath = "//div[contains(@id,'month-dropdown calendar-view__calendar')]//ul/li[2]")
    public WebElement calendarMonthFeb;

    // Calendar/ time control introduced in Mobile 3.4 ... month dropdown :
    // - for the calendar screen use calendarMonthxxx
    // - for the modal calendar control use calendarModalMonthxxx
    @CacheLookup
    @FindBy(xpath = "//div[contains(@id,'month-dropdown datetime-calendar')]//ul/li[2]")
    public WebElement calendarModalMonthFeb;
    @CacheLookup
    @FindBy(xpath = "//div[contains(@id,'month-dropdown calendar-view__calendar')]//ul/li[3]")
    public WebElement calendarMonthMar;
    @CacheLookup
    @FindBy(xpath = "//div[contains(@id,'month-dropdown datetime-calendar')]//ul/li[3]")
    public WebElement calendarModalMonthMar;
    @CacheLookup
    @FindBy(xpath = "//div[contains(@id,'month-dropdown calendar-view__calendar')]//ul/li[4]")
    public WebElement calendarMonthApr;
    @CacheLookup
    @FindBy(xpath = "//div[contains(@id,'month-dropdown datetime-calendar')]//ul/li[4]")
    public WebElement calendarModalMonthApr;
    @CacheLookup
    @FindBy(xpath = "//div[contains(@id,'month-dropdown calendar-view__calendar')]//ul/li[5]")
    public WebElement calendarMonthMay;
    @CacheLookup
    @FindBy(xpath = "//div[contains(@id,'month-dropdown datetime-calendar')]//ul/li[5]")
    public WebElement calendarModalMonthMay;
    @CacheLookup
    @FindBy(xpath = "//div[contains(@id,'month-dropdown calendar-view__calendar')]//ul/li[6]")
    public WebElement calendarMonthJun;
    @CacheLookup
    @FindBy(xpath = "//div[contains(@id,'month-dropdown datetime-calendar')]//ul/li[6]")
    public WebElement calendarModalMonthJun;
    @CacheLookup
    @FindBy(xpath = "//div[contains(@id,'month-dropdown calendar-view__calendar')]//ul/li[7]")
    public WebElement calendarMonthJul;
    @CacheLookup
    @FindBy(xpath = "//div[contains(@id,'month-dropdown datetime-calendar')]//ul/li[7]")
    public WebElement calendarModalMonthJul;
    @CacheLookup
    @FindBy(xpath = "//div[contains(@id,'month-dropdown calendar-view__calendar')]//ul/li[8]")
    public WebElement calendarMonthAug;
    @CacheLookup
    @FindBy(xpath = "//div[contains(@id,'month-dropdown datetime-calendar')]//ul/li[8]")
    public WebElement calendarModalMonthAug;
    @CacheLookup
    @FindBy(xpath = "//div[contains(@id,'month-dropdown calendar-view__calendar')]//ul/li[9]")
    public WebElement calendarMonthSep;
    @CacheLookup
    @FindBy(xpath = "//div[contains(@id,'month-dropdown datetime-calendar')]//ul/li[9]")
    public WebElement calendarModalMonthSep;
    @CacheLookup
    @FindBy(xpath = "//div[contains(@id,'month-dropdown calendar-view__calendar')]//ul/li[10]")
    public WebElement calendarMonthOct;
    @CacheLookup
    @FindBy(xpath = "//div[contains(@id,'month-dropdown datetime-calendar')]//ul/li[10]")
    public WebElement calendarModalMonthOct;
    @CacheLookup
    @FindBy(xpath = "//div[contains(@id,'month-dropdown calendar-view__calendar')]//ul/li[11]")
    public WebElement calendarMonthNov;
    @CacheLookup
    @FindBy(xpath = "//div[contains(@id,'month-dropdown datetime-calendar')]//ul/li[11]")
    public WebElement calendarModalMonthNov;
    @CacheLookup
    @FindBy(xpath = "//div[contains(@id,'month-dropdown calendar-view__calendar')]//ul/li[12]")
    public WebElement calendarMonthDec;
    @CacheLookup
    @FindBy(xpath = "//div[contains(@id,'month-dropdown datetime-calendar')]//ul/li[12]")
    public WebElement calendarModalMonthDec;
    @FindBy(xpath = "//*[@id='hour-dropdown']//div[@role='combobox']")
    public WebElement calendarHourField;
    @FindBy(xpath = "//*[@id='hour-dropdown']//select")
    public WebElement calendarHourSelect;
    @FindBy(xpath = "//div[@id='dropdown-list']//ul/li[1]")
    public WebElement calendarHourOne;
    @FindBy(xpath = "//div[@id='dropdown-list']//ul/li[2]")
    public WebElement calendarHourTwo;
    @FindBy(xpath = "//div[@id='dropdown-list']//ul/li[3]")
    public WebElement calendarHourThree;
    @FindBy(xpath = "//div[@id='dropdown-list']//ul/li[4]")
    public WebElement calendarHourFour;
    @FindBy(xpath = "//div[@id='dropdown-list']//ul/li[5]")
    public WebElement calendarHourFive;
    @FindBy(xpath = "//div[@id='dropdown-list']//ul/li[6]")
    public WebElement calendarHourSix;
    @FindBy(xpath = "//div[@id='dropdown-list']//ul/li[7]")
    public WebElement calendarHourSeven;
    @FindBy(xpath = "//div[@id='dropdown-list']//ul/li[8]")
    public WebElement calendarHourEight;
    @FindBy(xpath = "//div[@id='dropdown-list']//ul/li[9]")
    public WebElement calendarHourNine;
    @FindBy(xpath = "//div[@id='dropdown-list']//ul/li[10]")
    public WebElement calendarHourTen;
    @FindBy(xpath = "//div[@id='dropdown-list']//ul/li[11]")
    public WebElement calendarHourEleven;
    @FindBy(xpath = "//div[@id='dropdown-list']//ul/li[12]")
    public WebElement calendarHourTwelve;
    @FindBy(xpath = "//div[@id='dropdown-list']//ul/li[13]")
    public WebElement calendarHourThirteen;
    @FindBy(xpath = "//div[@id='dropdown-list']//ul/li[14]")
    public WebElement calendarHourFourteen;
    @FindBy(xpath = "//div[@id='dropdown-list']//ul/li[15]")
    public WebElement calendarHourFifteen;
    @FindBy(xpath = "//div[@id='dropdown-list']//ul/li[16]")
    public WebElement calendarHourSixteen;
    @FindBy(xpath = "//div[@id='dropdown-list']//ul/li[17]")
    public WebElement calendarHourSeventeen;
    @FindBy(xpath = "//div[@id='dropdown-list']//ul/li[18]")
    public WebElement calendarHourEighteen;
    @FindBy(xpath = "//div[@id='dropdown-list']//ul/li[19]")
    public WebElement calendarHourNineteen;
    @FindBy(xpath = "//div[@id='dropdown-list']//ul/li[20]")
    public WebElement calendarHourTwenty;
    @FindBy(xpath = "//div[@id='dropdown-list']//ul/li[21]")
    public WebElement calendarHourTwentyOne;
    @FindBy(xpath = "//div[@id='dropdown-list']//ul/li[22]")
    public WebElement calendarHourTwentyTwo;
    @FindBy(xpath = "//div[@id='dropdown-list']//ul/li[23]")
    public WebElement calendarHourTwentyThree;
    @FindBy(xpath = "//div[@id='dropdown-list']//ul/li[24]")
    public WebElement calendarHourTwentyFour;
    @FindBy(xpath = "//*[@id='minute-modal']//select")
    public WebElement calendarMinuteSelect;
    @FindBy(xpath = "//*[@id='minute-modal']//div[@role='combobox']")
    public WebElement calendarMinuteField;
    @FindBy(xpath = "//div[@id='dropdown-list']//ul/li[1]")
    public WebElement calendarMinute00;
    @FindBy(xpath = "//div[@id='dropdown-list']//ul/li[2]")
    public WebElement calendarMinute05;
    @FindBy(xpath = "//div[@id='dropdown-list']//ul/li[3]")
    public WebElement calendarMinute10;
    @FindBy(xpath = "//div[@id='dropdown-list']//ul/li[4]")
    public WebElement calendarMinute15;
    @FindBy(xpath = "//div[@id='dropdown-list']//ul/li[5]")
    public WebElement calendarMinute20;
    @FindBy(xpath = "//div[@id='dropdown-list']//ul/li[6]")
    public WebElement calendarMinute25;
    @FindBy(xpath = "//div[@id='dropdown-list']//ul/li[7]")
    public WebElement calendarMinute30;
    @FindBy(xpath = "//div[@id='dropdown-list']//ul/li[8]")
    public WebElement calendarMinute35;
    @FindBy(xpath = "//div[@id='dropdown-list']//ul/li[9]")
    public WebElement calendarMinute40;
    @FindBy(xpath = "//div[@id='dropdown-list']//ul/li[10]")
    public WebElement calendarMinute45;
    @FindBy(xpath = "//div[@id='dropdown-list']//ul/li[11]")
    public WebElement calendarMinute50;
    @FindBy(xpath = "//div[@id='dropdown-list']//ul/li[12]")
    public WebElement calendarMinute55;
    @CacheLookup
    @FindBy(xpath = "//span[@class='toggleOn']")
    public WebElement calendarAM;
    @CacheLookup
    @FindBy(xpath = "//span[@class='toggleOff']")
    public WebElement calendarPM;
    @CacheLookup
    @FindBy(xpath = "//span[@data-action='incrementMonth']")
    public WebElement calendarIncrementMonthBtn;
    @CacheLookup
    @FindBy(xpath = "//*[@id='datetime-picker-time']//button[@data-action='incrementHour']")
    public WebElement calendarIncrementHourBtn;
    @CacheLookup
    @FindBy(xpath = "//*[@id='datetime-picker-time']//button[@data-action='decrementHour']")
    public WebElement calendarDecrementHourBtn;
    @CacheLookup
    @FindBy(xpath = "//*[@id='datetime-picker-time']//button[@data-action='incrementMinute']")
    public WebElement calendarIncrementMinuteBtn;
    @CacheLookup
    @FindBy(xpath = "//span[@data-action='decrementMonth']")
    public WebElement calendarDecrementMonthBtn;
    @CacheLookup
    @FindBy(xpath = "//*[@id='datetime-picker-date']//button[@data-action='incrementYear']")
    public WebElement calendarIncrementYearBtn;
    @CacheLookup
    @FindBy(xpath = "//*[@id='calendar-view__calendar']//tr[2]/td[1]")
    public WebElement calendarMonthFirstDaySecondRow;
    @CacheLookup
    @FindBy(xpath = "//*[@id='calendar-view__calendar']//tr[3]/td[1]")
    public WebElement calendarMonthFirstDayThirdRow;
    @CacheLookup
    @FindBy(xpath = "//*[@id='calendar-view__calendar']//tr[4]/td[1]")
    public WebElement calendarMonthFirstDayFourthRow;


    //Day View elements


    //Week View Elements


    //Month View Elements
    @CacheLookup
    @FindBy(xpath = "//span[@class='timeStamp__time']")
    public WebElement calendarMonthFirstActivityTime;
    @CacheLookup
    @FindBy(xpath = "//h3[@class='header__title']")
    public WebElement calendarMonthFirstActivityDescription;
    @CacheLookup
    @FindBy(xpath = "//*[@id='calendar_monthlist']//td[contains(@data-date, '-01')]")
    public WebElement calendarMonthFirstDayMonth;
    @CacheLookup
    @FindBy(xpath = "//*[@id='calendar_monthlist']//td[contains(@data-date, '-01')]//span[@class='activity-count']")
    public WebElement calendarMonthFirstDayMonthActivityCount;
    @CacheLookup
    @FindBy(xpath = "(//div[contains(@id,'datetime-calendar')]//td[text()='1'])[1]")
    public WebElement calendarModalDayOneCurrMonth;
    @CacheLookup
    @FindBy(xpath = "(//div[contains(@id,'calendar-view__calendar')]//td[text()='1'])[1]")
    public WebElement calendarDayOneCurrMonth;
    @CacheLookup
    @FindBy(xpath = "(//div[contains(@id,'datetime-calendar')]//td[text()='16'])[1]")
    public WebElement calendarModalDay16CurrMonth;
    @CacheLookup
    @FindBy(xpath = "(//div[contains(@id,'calendar-view__calendar')]//td[text()='16'])[1]")
    public WebElement calendarDay16CurrMonth;
    @CacheLookup
    @FindBy(xpath = "(//div[contains(@id,'datetime-calendar')]//td[text()='18'])[1]")
    public WebElement calendarModalDay18CurrMonth;
    @CacheLookup
    @FindBy(xpath = "(//div[contains(@id,'calendar-view__calendar')]//td[text()='18'])[1]")
    public WebElement calendarDay18CurrMonth;
    @CacheLookup
    @FindBy(xpath = "//div[contains(@id,'datetime-calendar')]//td[contains(@class, 'selected')]")
    public WebElement calendarModalDaySelected;
    @CacheLookup
    @FindBy(xpath = "//div[contains(@id,'calendar-view__calendar')]//td[contains(@class, 'selected')]")
    public WebElement calendarDaySelected;
    // CalendarModalCurrMonthValue ... use this for the Calendar control (not calendar screen)
    @CacheLookup
    @FindBy(xpath = "//div[contains(@id,'datetime-calendar')]//div[@class='month']//input")
    public WebElement calendarModalCurrMonthValue;
    // CalendarModalCurrYearValue ... use this for the Calendar control (not calendar screen)
    @CacheLookup
    @FindBy(xpath = "//div[contains(@id,'datetime-calendar')]//div[@class='year']//input")
    public WebElement calendarModalCurrYearValue;
    @CacheLookup
    @FindBy(xpath = "//div[@id='modal-template']//span[@data-action='incrementMonth']")
    public WebElement calendarModalIncrMonth;
    @CacheLookup
    @FindBy(xpath = "//div[@id='modal-template']//span[@data-action='decrementMonth']")
    public WebElement calendarModalDecrMonth;
    @CacheLookup
    @FindBy(xpath = "//div[contains(text(),'Confirm')]")
    public WebElement calendarModalConfirm;
    @CacheLookup
    @FindBy(xpath = "//div[contains(text(),'Cancel')]")
    public WebElement calendarModalCancel;
    @CacheLookup
    @FindBy(xpath = "//div[contains(text(),'Advanced')]")
    public WebElement calendarModalAdvanced;
    @CacheLookup
    @FindBy(xpath = "//div[@id='modal-template']//div[@data-action='goToToday']")
    public WebElement calendarModalTodayBtn;
    @CacheLookup
    @FindBy(xpath = "//div[contains(@id,'datetime-calendar')]//th[contains(text(),'Su')]")
    public WebElement calendarModalDayOfWeekSunday;
    @CacheLookup
    @FindBy(xpath = "//div[contains(@id,'datetime-calendar')]//th[contains(text(),'Mo')]")
    public WebElement calendarModalDayOfWeekMonday;
    @CacheLookup
    @FindBy(xpath = "//div[contains(@id,'datetime-calendar')]//th[contains(text(),'Tu')]")
    public WebElement calendarModalDayOfWeekTuesday;
    @CacheLookup
    @FindBy(xpath = "//div[contains(@id,'datetime-calendar')]//th[contains(text(),'We')]")
    public WebElement calendarModalDayOfWeekWednesday;
    @CacheLookup
    @FindBy(xpath = "//div[contains(@id,'datetime-calendar')]//th[contains(text(),'Th')]")
    public WebElement calendarModalDayOfWeekThursday;
    @CacheLookup
    @FindBy(xpath = "//div[contains(@id,'datetime-calendar')]//th[contains(text(),'Fr')]")
    public WebElement calendarModalDayOfWeekFriday;
    @CacheLookup
    @FindBy(xpath = "//div[contains(@id,'datetime-calendar')]//th[contains(text(),'Sa')]")
    public WebElement calendarModalDayOfWeekSaturday;
    @CacheLookup
    @FindBy(xpath = "//div[contains(@id,'calendar-view')]//th[contains(text(),'Su')]")
    public WebElement calendarDayOfWeekSunday;
    @CacheLookup
    @FindBy(xpath = "//div[contains(@id,'calendar-view')]//th[contains(text(),'Mo')]")
    public WebElement calendarDayOfWeekMonday;
    @CacheLookup
    @FindBy(xpath = "//div[contains(@id,'calendar-view')]//th[contains(text(),'Tu')]")
    public WebElement calendarDayOfWeekTuesday;
    @CacheLookup
    @FindBy(xpath = "//div[contains(@id,'calendar-view')]//th[contains(text(),'We')]")
    public WebElement calendarDayOfWeekWednesday;
    @CacheLookup
    @FindBy(xpath = "//div[contains(@id,'calendar-view')]//th[contains(text(),'Th')]")
    public WebElement calendarDayOfWeekThursday;
    @CacheLookup
    @FindBy(xpath = "//div[contains(@id,'calendar-view')]//th[contains(text(),'Fr')]")
    public WebElement calendarDayOfWeekFriday;
    @CacheLookup
    @FindBy(xpath = "//div[contains(@id,'calendar-view')]//th[contains(text(),'Sa')]")
    public WebElement calendarDayOfWeekSaturday;
    @CacheLookup
    @FindBy(xpath = "//div[@class='relative-datetime-select__title']")
    public WebElement calendarModalRelativeDateTitle;
    @CacheLookup
    @FindBy(xpath = "//ul//li//div[contains(., 'This Evening')]")
    public WebElement calendarModalThisEveningTitle;
    @CacheLookup
    @FindBy(xpath = "//ul//li//div[contains(., 'This Evening')]/following::div[1]")
    public WebElement calendarModalThisEveningValue;
    @CacheLookup
    @FindBy(xpath = "//ul//li//div[contains(., 'Tomorrow Morning')]")
    public WebElement calendarModalTomorrowMorningTitle;
    @CacheLookup
    @FindBy(xpath = "//ul//li//div[contains(., 'Tomorrow Morning')]/following::div[1]")
    public WebElement calendarModalTomorrowMorningValue;
    @CacheLookup
    @FindBy(xpath = "//ul//li//div[contains(., 'Tomorrow Evening')]")
    public WebElement calendarModalTomorrowEveningTitle;
    @CacheLookup
    @FindBy(xpath = "//ul//li//div[contains(., 'Tomorrow Evening')]/following::div[1]")
    public WebElement calendarModalTomorrowEveningValue;
    @CacheLookup
    @FindBy(xpath = "//ul//li//div[contains(., 'Next Week')]")
    public WebElement calendarModalNextWeekTitle;
    @CacheLookup
    @FindBy(xpath = "//ul//li//div[contains(., 'Next Week')]/following::div[1]")
    public WebElement calendarModalNextWeekValue;
    @CacheLookup
    @FindBy(xpath = "//ul//li//div[contains(., 'Next Month')]")
    public WebElement calendarModalNextMonthTitle;
    @CacheLookup
    @FindBy(xpath = "//ul//li//div[contains(., 'Next Month')]/following::div[1]")
    public WebElement calendarModalNextMonthValue;
    private WebDriver driver;
    CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);

    public CalendarViewsElements(WebDriver driver) {
        this.driver = driver;
    }

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
