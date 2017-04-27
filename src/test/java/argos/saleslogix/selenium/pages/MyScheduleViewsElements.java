package argos.saleslogix.selenium.pages;

import argos.saleslogix.selenium.test.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;


public class MyScheduleViewsElements extends BaseTest {

	private WebDriver driver;

	public MyScheduleViewsElements(WebDriver driver) {
		this.driver = driver;		
	}
	
	//List View elements	
	@CacheLookup
	@FindBy(xpath = "//*[@id='myday_list']//ul/li[1]")
	public WebElement myScheduleListItem1;


    @CacheLookup
    @FindBy(xpath = "//*[@id='myday_list']//button[@aria-label = 'viewAccount']")
    public WebElement myScheduleQuickActionAccount;

    @CacheLookup
    @FindBy(xpath = "//*[@id='myday_list']//button[@aria-label = 'viewContact']")
    public WebElement myScheduleQuickActionContact;

    @CacheLookup
    @FindBy(xpath = "//*[@id='myday_list']//button[@aria-label = 'viewOpportunity']")
    public WebElement myScheduleQuickActionOpportunity;

    @CacheLookup
    @FindBy(xpath = "//*[@id='myday_list']//button[@aria-label = 'call']")
    public WebElement myScheduleQuickActionCall;



}
