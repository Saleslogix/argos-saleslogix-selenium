package argos.saleslogix.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

//TODO: partially completed; need to finalize
public class CalendarViewsElements {

    private WebDriver driver;
    CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);

    public CalendarViewsElements(WebDriver driver) {
        this.driver = driver;
    }

    //Header Navigation elements


    //Day View elements


    //Week View Elements


    //Month View Elements

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
