package argos.saleslogix.selenium.pages;

import argos.saleslogix.selenium.test.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;


public class RecentlyViewedViewsElements extends BaseTest {

    //List View elements
    @CacheLookup
    @FindBy(xpath = "//*[@id='recently_viewed_list']//ul/li[1]//h3")
    public WebElement recentlyViewedDescriptionItem1;
    @CacheLookup
    @FindBy(xpath = "//*[@id='recently_viewed_list']//ul/li[2]//h3")
    public WebElement recentlyViewedDescriptionItem2;
    @CacheLookup
    @FindBy(xpath = "//*[@id='recently_viewed_list']//ul/li[3]//h3")
    public WebElement recentlyViewedDescriptionItem3;
    @CacheLookup
    @FindBy(xpath = "//*[@id='recently_viewed_list']//ul/li[4]//h3")
    public WebElement recentlyViewedDescriptionItem4;
    @CacheLookup
    @FindBy(xpath = "//*[@id='recently_viewed_list']//ul/li[5]//h3")
    public WebElement recentlyViewedDescriptionItem5;
    @CacheLookup
    @FindBy(xpath = "//*[@id='recently_viewed_list']//ul/li[6]//h3")
    public WebElement recentlyViewedDescriptionItem6;
    @CacheLookup
    @FindBy(xpath = "//*[@id='recently_viewed_list']//li/h2")
    public WebElement recentlyViewedNoRecords;
    private WebDriver driver;

    public RecentlyViewedViewsElements(WebDriver driver) {
        this.driver = driver;
    }


}
