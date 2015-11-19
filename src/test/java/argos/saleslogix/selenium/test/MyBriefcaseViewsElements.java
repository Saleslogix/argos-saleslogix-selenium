package argos.saleslogix.selenium.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;


public class MyBriefcaseViewsElements extends BaseTest {

	private WebDriver driver;

	public MyBriefcaseViewsElements(WebDriver driver) {
		this.driver = driver;		
	}
	
	//List View elements	
	@CacheLookup
	@FindBy(xpath = "//*[@id='briefcase_list']//ul/li[1]//h3")
	WebElement myBriefcaseDescriptionItem1;

    @CacheLookup
    @FindBy(xpath = "//*[@id='briefcase_list']//ul/li[2]//h3")
    WebElement myBriefcaseDescriptionItem2;

    @CacheLookup
    @FindBy(xpath = "//*[@id='briefcase_list']//ul/li[3]//h3")
    WebElement myBriefcaseDescriptionItem3;

    @CacheLookup
    @FindBy(xpath = "//*[@id='briefcase_list']//ul/li[4]//h3")
    WebElement myBriefcaseDescriptionItem4;

    @CacheLookup
    @FindBy(xpath = "//*[@id='briefcase_list']//ul/li[5]//h3")
    WebElement myBriefcaseDescriptionItem5;

    @CacheLookup
    @FindBy(xpath = "//*[@id='briefcase_list']//ul/li[6]//h3")
    WebElement myBriefcaseDescriptionItem6;

    @CacheLookup
    @FindBy(xpath = "//*[@id='briefcase_list']//li/h2")
    WebElement briefcaseNoRecords;
	

				

}
