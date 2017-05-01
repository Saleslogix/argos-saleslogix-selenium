package argos.saleslogix.selenium.pages;

import argos.saleslogix.selenium.test.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;


public class MyBriefcaseViewsElements extends BaseTest {

    //List View elements
    @CacheLookup
    @FindBy(xpath = "(//*[@id='briefcase_list']//h2[@class='widget-title'])[1]")
    public WebElement myBriefcaseDescriptionItem1;
    @CacheLookup
    @FindBy(xpath = "(//*[@id='briefcase_list']//h2[@class='widget-title'])[2]")
    public WebElement myBriefcaseDescriptionItem2;
    @CacheLookup
    @FindBy(xpath = "(//*[@id='briefcase_list']//h2[@class='widget-title'])[3]")
    public WebElement myBriefcaseDescriptionItem3;
    @CacheLookup
    @FindBy(xpath = "(//*[@id='briefcase_list']//h2[@class='widget-title'])[4]")
    public WebElement myBriefcaseDescriptionItem4;
    @CacheLookup
    @FindBy(xpath = "(//*[@id='briefcase_list']//h2[@class='widget-title'])[5]")
    public WebElement myBriefcaseDescriptionItem5;
    @CacheLookup
    @FindBy(xpath = "(//*[@id='briefcase_list']//h2[@class='widget-title'])[6]")
    public WebElement myBriefcaseDescriptionItem6;
    @CacheLookup
    @FindBy(xpath = "//*[@id='briefcase_list']//div[@class='no-data']")
    public WebElement briefcaseNoRecords;
    private WebDriver driver;

    public MyBriefcaseViewsElements(WebDriver driver) {
        this.driver = driver;
    }


}
