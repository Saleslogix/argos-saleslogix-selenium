package argos.saleslogix.selenium.pages;

import argos.saleslogix.selenium.test.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;


public class MyAttachmentsViewsElements extends BaseTest {

    //List View elements
    @CacheLookup
    @FindBy(xpath = "//*[@id='myattachment_list']//ul")
    public WebElement myAttachmentsListView;
    @CacheLookup
    @FindBy(xpath = "//*[@id='myattachment_list']//ul/li[1]")
    public WebElement topMyAttachmentsListItem;
    @CacheLookup
    @FindBy(xpath = "//*[@id='myattachment_list']//ul/li[1]/div[1]")
    public WebElement topMyAttachmentsListItemTab;
    @CacheLookup
    @FindBy(xpath = "//*[@id='myattachment_list']//ul/li[1]/button")
    public WebElement topMyAttachmentsListItemIcon;
    @CacheLookup
    @FindBy(xpath = ".//*[@id='myattachment_list']//ul/li[1]/div[2]/h3")
    public WebElement topMyAttachmentsListItemName;
    @CacheLookup
    @FindBy(xpath = "//*[@id='myattachment_list']//ul/li[1]/div[2]/h4[1]")
    public WebElement topMyAttachmentsListItemDateAndSize;
    @CacheLookup
    @FindBy(xpath = "//*[@id='myattachment_list']//ul/li[1]/div[2]/h4[2]")
    public WebElement topMyAttachmentsListItemFileExtension;
    @CacheLookup
    @FindBy(xpath = "//*[@id='myattachment_list']//ul/li/div[2]/h4[3]")
    public WebElement topMyAttachmentsListItemOwner;
    @CacheLookup
    @FindBy(xpath = "//div[@id='bottom_item_indicators']/span")
    public WebElement topMyAttachmentsListItemTouch;
    @CacheLookup
    @FindBy(xpath = "//div[@id='bottom_item_indicators']/span[2]/img")
    public WebElement topMyAttachmentsListItemAttachment;
    @CacheLookup
    @FindBy(xpath = "//*[@id='myattachment_list']//ul/li[11]")
    public WebElement eleventhMyAttachmentsListItem;
    @CacheLookup
    @FindBy(xpath = "//*[@id='myattachment_list']//ul/li[21]")
    public WebElement twentyfirstMyAttachmentsListItem;
    @CacheLookup
    @FindBy(xpath = "//*[@id='myattachment_list']//ul/li[31]")
    public WebElement thirtyfirstMyAttachmentsListItem;
    @CacheLookup
    @FindBy(xpath = "//*[@id='myattachment_list']/div[2]")
    public WebElement recordsRemainingListItem;
    @CacheLookup
    @FindBy(xpath = "//*[@id='myattachment_list']/div[3]/li/h3")
    public WebElement noRecordsListItem;
    //Context Menu elements
    @CacheLookup
    @FindBy(xpath = "//*[@selected='true']//input[@name='query']")
    public WebElement myAttachmentsSearchTxtBox;
    @CacheLookup
    @FindBy(xpath = "//*[@selected='true']//button[@class='clear-button']")
    public WebElement myAttachmentsSearchClearBtn;
    @CacheLookup
    @FindBy(xpath = "//*[@selected='true']//button[@class='subHeaderButton searchButton']")
    public WebElement myAttachmentsSearchLookupBtn;
    @CacheLookup
    @FindBy(xpath = "//*[@id='right_drawer']/div[3]/h2")
    public WebElement myAttachmentsHashTagsHdr;
    @CacheLookup
    @FindBy(xpath = "//*[@id='right_drawer']//ul[@data-group='view']")
    public WebElement myAttachmentsTagsPnl;
    @CacheLookup
    @FindBy(xpath = "//*[@id='attachment_Add']//div[@class='file-wrapper']")
    public WebElement myAttachmentsAddFile;
    private WebDriver driver;

    public MyAttachmentsViewsElements(WebDriver driver) {
        this.driver = driver;
    }

    //Methods
    //-------
    public String getMyAttachmentsListViewTxt() {
        String methodID = "getMyAttachmentsListViewTxt";

        WebElement myAttachmentsLisViewInfo = driver.findElement(By.xpath("//*[@id='myattachment_list']//ul"));

        return myAttachmentsLisViewInfo.getText();
    }


    public boolean NoRecordsFound() {
        boolean result = false;

        return result;
    }
}
