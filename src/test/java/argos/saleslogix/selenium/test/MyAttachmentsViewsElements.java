package argos.saleslogix.selenium.test;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class MyAttachmentsViewsElements extends BrowserSetup {
	
	private WebDriver driver;

	public MyAttachmentsViewsElements(WebDriver driver) {
		this.driver = driver;		
	}
	
	//List View elements	
	@CacheLookup
	@FindBy(xpath = "//*[@id='myattachment_list']/ul")
	WebElement myAttachmentsListView;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='myattachment_list']/ul/li[1]")
	WebElement topMyAttachmentsListItem;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='myattachment_list']/ul/li[1]/div[1]")
	WebElement topMyAttachmentsListItemTab;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='myattachment_list']/ul/li[1]/button")
	WebElement topMyAttachmentsListItemIcon;

	@CacheLookup
	@FindBy(xpath = ".//*[@id='myattachment_list']/ul/li[1]/div[3]/h3/span")
	WebElement topMyAttachmentsListItemName;
		
	@CacheLookup
	@FindBy(xpath = "//*[@id='myattachment_list']/ul/li[1]/div[3]/h4[1]")
	WebElement topMyAttachmentsListItemDateAndSize;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='myattachment_list']/ul/li[1]/div[3]/h4[2]/span")
	WebElement topMyAttachmentsListItemFileExtension;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='myattachment_list']/ul/li/div[3]/h4[3]")
	WebElement topMyAttachmentsListItemOwner;
	
	@CacheLookup
	@FindBy(xpath = "//div[@id='bottom_item_indicators']/span[1]/img")
	WebElement topMyAttachmentsListItemTouch;
	
	@CacheLookup
	@FindBy(xpath = "//div[@id='bottom_item_indicators']/span[2]/img")
	WebElement topMyAttachmentsListItemAttachment;
		
	@CacheLookup
	@FindBy(xpath = "//*[@id='myattachment_list']/ul/li[11]")
	WebElement eleventhMyAttachmentsListItem;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='myattachment_list']/ul/li[21]")
	WebElement twentyfirstMyAttachmentsListItem;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='myattachment_list']/ul/li[31]")
	WebElement thirtyfirstMyAttachmentsListItem;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='myattachment_list']/div[2]")
	WebElement recordsRemainingListItem;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='myattachment_list']/div[3]/li/h3")
	WebElement noRecordsListItem;
	
	//Context Menu elements
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_SearchWidget_35']/div/div[1]/input")
	WebElement myAttachmentsSearchTxtBox;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_SearchWidget_35']/div/div[2]/button")
	WebElement myAttachmentsSearchClearBtn;
	
	@CacheLookup
	@FindBy(xpath = ".//*[@id='Sage_Platform_Mobile_SearchWidget_35']/div/div[3]/button")
	WebElement myAttachmentsSearchLookupBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='right_drawer']/div[4]/h2")
	WebElement myAttachmentsHashTagsHdr;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='right_drawer']/div[4]/ul")
	WebElement myAttachmentsTagsPnl;
				
	//Methods
	//-------
	public String getMyAttachmentsListViewTxt() {
		String methodID = "getMyAttachmentsListViewTxt";
		
		WebElement myAttachmentsLisViewInfo = driver.findElement(By.xpath("//*[@id='myattachment_list']/ul"));
		
		return myAttachmentsLisViewInfo.getText();		
	}
	
	
	public boolean NoRecordsFound() {
		boolean result = false;
		
		return result;
	}
}
