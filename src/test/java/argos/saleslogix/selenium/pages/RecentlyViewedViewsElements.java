package argos.saleslogix.selenium.pages;

import argos.saleslogix.selenium.test.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;


public class RecentlyViewedViewsElements extends BaseTest {

    //List View elements
    @CacheLookup
    @FindBy(xpath = "(//*[@id='recently_viewed_list']//h2[@class='widget-title'])[1]")
    public WebElement recentlyViewedDescriptionItem1;
    @CacheLookup
    @FindBy(xpath = "(//*[@id='recently_viewed_list']//h2[@class='widget-title'])[2]")
    public WebElement recentlyViewedDescriptionItem2;
    @CacheLookup
    @FindBy(xpath = "(//*[@id='recently_viewed_list']//h2[@class='widget-title'])[3]")
    public WebElement recentlyViewedDescriptionItem3;
    @CacheLookup
    @FindBy(xpath = "(//*[@id='recently_viewed_list']//h2[@class='widget-title'])[4]")
    public WebElement recentlyViewedDescriptionItem4;
    @CacheLookup
    @FindBy(xpath = "(//*[@id='recently_viewed_list']//h2[@class='widget-title'])[5]")
    public WebElement recentlyViewedDescriptionItem5;
    @CacheLookup
    @FindBy(xpath = "(//*[@id='recently_viewed_list']//h2[@class='widget-title'])[6]")
    public WebElement recentlyViewedDescriptionItem6;
    @CacheLookup
    @FindBy(xpath = "//*[@id='recently_viewed_list']//div[@class='no-data']")
    public WebElement recentlyViewedNoRecords;
    private WebDriver driver;

    public RecentlyViewedViewsElements(WebDriver driver) {
        this.driver = driver;
    }


}
