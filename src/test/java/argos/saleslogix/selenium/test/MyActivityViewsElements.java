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


public class MyActivityViewsElements extends BrowserSetup {
	
	private WebDriver driver;

	public MyActivityViewsElements(WebDriver driver) {
		this.driver = driver;		
	}
	
	CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);

	//List View elements
	@CacheLookup
	@FindBy(xpath = "//*[@id='myactivity_list']/div[3]/h2[1]")
	WebElement myActivitiesListViewHeader;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='myactivity_list']")
	WebElement myActivitiesListView;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='myactivity_list']/div[3]/ul[1]/li[1]")
	WebElement topMyActivitiesListItem;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='myactivity_list']/div[3]/ul[1]/li[1]/div[1]")
	WebElement topMyActivitiesListItemTab;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='myactivity_list']/div[3]/ul[1]/li[1]/button")
	WebElement topMyActivitiesListItemIcon;

	@CacheLookup
	@FindBy(xpath = "//*[@id='myactivity_list']/div[3]/ul[1]/li[1]/div[3]/h3/span")
	WebElement topMyActivitiesListItemRegarding;
		
	@CacheLookup
	@FindBy(xpath = "//*[@id='myactivity_list']/div[3]/ul[1]/li/div[3]/h4[1]/strong")
	WebElement topMyActivitiesListItemStartTime;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='myactivity_list']/div[3]/ul[1]/li[1]/div[3]/h4[2]")
	WebElement topMyActivitiesListItemContactAccount;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='myactivity_list']/div[3]/ul[1]/li[1]/div[3]/h4[3]")
	WebElement topMyActivitiesListItemPhone;
	
	@CacheLookup
	@FindBy(xpath = "//div[@id='bottom_item_indicators']/span[1]/img")
	WebElement topMyActivitiesListItemAlarm;
	
	@CacheLookup
	@FindBy(xpath = "//div[@id='bottom_item_indicators']/span[2]/img")
	WebElement topMyActivitiesListItemTouch;
	
	@CacheLookup
	@FindBy(xpath = "//div[@id='bottom_item_indicators']/span[3]/img")
	WebElement topMyActivitiesListItemBang;
	
	@CacheLookup
	@FindBy(xpath = "//div[@id='bottom_item_indicators']/span[4]/img")
	WebElement topMyActivitiesListItemRecurring;

	@CacheLookup
	@FindBy(xpath = "//div[@id='bottom_item_indicators']/span[5]/img")
	WebElement topMyActivitiesListItemType;
	
	@CacheLookup
	@FindBy(css = "button.footer-item-selector.button")
	WebElement topMyActivitiesListItemQuickActionsBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='myactivity_list']/div[3]/ul[1]/li[2]/button[8]")
	WebElement topMyActivitiesListItemQuickActionsAddAttachmentBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='myactivity_list']/div[3]/ul[1]/li[2]/button[7]")
	WebElement topMyActivitiesListItemQuickActionsCallBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='myactivity_list']/div[3]/ul[1]/li[2]/button[6]")
	WebElement topMyActivitiesListItemQuickActionsDeclineBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='myactivity_list']/div[3]/ul[1]/li[2]/button[5]")
	WebElement topMyActivitiesListItemQuickActionsAcceptBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='myactivity_list']/div[3]/ul[1]/li[2]/button[4]")
	WebElement topMyActivitiesListItemQuickActionsCompleteBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='myactivity_list']/div[3]/ul[1]/li[2]/button[3]")
	WebElement topMyActivitiesListItemQuickActionsContactBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='myactivity_list']/div[3]/ul[1]/li[2]/button[2]")
	WebElement topMyActivitiesListItemQuickActionsOpportunityBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='myactivity_list']/div[3]/ul[1]/li[2]/button[1]")
	WebElement topMyActivitiesListItemQuickActionsAccountBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='myactivity_list']/ul/li[11]")
	WebElement eleventhMyActivitiesListItem;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='myactivity_list']/ul/li[21]")
	WebElement twentyfirstMyActivitiesListItem;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='myactivity_list']/ul/li[31]")
	WebElement thirtyfirstMyActivitiesListItem;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='myactivity_list']/div[2]")
	WebElement recordsRemainingListItem;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='myactivity_list']/div[3]/li/h3")
	WebElement noRecordsListItem;
	
	//Context Menu elements
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_SearchWidget_26']/div/div[1]/input")
	WebElement myActivitiesSearchTxtBox;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_SearchWidget_26']/div/div[2]/button")
	WebElement myActivitiesSearchClearBtn;
	
	@CacheLookup
	@FindBy(xpath = ".//*[@id='Sage_Platform_Mobile_SearchWidget_26']/div/div[3]/button")
	WebElement myActivitiesSearchLookupBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='right_drawer']/div[4]/h2[1]")
	WebElement myActivitiesHashTagsHdr;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='right_drawer']/div[4]/ul[1]")
	WebElement myActivitiesTagsPnl;
	
	//Detail View elements
	//TODO: update the Detail View elements
	@CacheLookup
	@FindBy(xpath = "//*[@id='activity_detail']")
	WebElement activityDetailView;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='activity_detail']/div[2]/h2[1]")
	WebElement activityDetailViewQuickActionsHdr;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='activity_detail']/div[2]/ul[1]/li[1]/a")
	WebElement activityDetailViewCallMainNumberLnk;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='activity_detail']/div[2]/ul[1]/li[2]/a")
	WebElement activityDetailViewScheduleActivityLnk;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='activity_detail']/div[2]/ul[1]/li[3]/a")
	WebElement activityDetailViewAddNoteLnk;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='activity_detail']/div[2]/ul[1]/li[4]/a")
	WebElement activityDetailViewViewAddressLnk;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='activity_detail']/div[2]/h2[2]")
	WebElement activityDetailViewDetailsHdr;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='activity_detail']/div[2]/div[1]/div[1]")
	WebElement activityDetailViewAccountFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='activity_detail']/div[2]/div[1]/div[2]")
	WebElement activityDetailViewWebFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='activity_detail']/div[2]/div[1]/div[3]")
	WebElement activityDetailViewFaxFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='activity_detail']/div[2]/div[1]/div[4]")
	WebElement activityDetailViewTypeFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='activity_detail']/div[2]/div[1]/div[5]")
	WebElement activityDetailViewSubTypeFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='activity_detail']/div[2]/div[1]/div[6]")
	WebElement activityDetailViewStatusFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='activity_detail']/div[2]/h2[3]")
	WebElement activityDetailViewMoreDetailsHdr;
		
	@CacheLookup
	@FindBy(xpath = "//*[@id='activity_detail']/div[2]/div[2]")
	WebElement activityDetailViewMoreDetailsFields;	
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='activity_detail']/div[2]/div[2]/div[1]")
	WebElement activityDetailViewIndustryFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='activity_detail']/div[2]/div[2]/div[2]")
	WebElement activityDetailViewBusDescFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='activity_detail']/div[2]/div[2]/div[3]")
	WebElement activityDetailViewAcctMgrFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='activity_detail']/div[2]/div[2]/div[4]")
	WebElement activityDetailViewOwnerFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='activity_detail']/div[2]/div[2]/div[5]")
	WebElement activityDetailViewLeadSourceFld;

	@CacheLookup
	@FindBy(xpath = "//*[@id='activity_detail']/div[2]/h2[4]")
	WebElement activityDetailViewRelatedItemsHdr;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='activity_detail']/descendant::*[text() = 'Activities']")
	WebElement activityDetailViewActivitiesLnk;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='activity_detail']/descendant::*[text() = 'Contacts']")
	WebElement activityDetailViewContactsLnk;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='activity_detail']/descendant::*[text() = 'Opportunities']")
	WebElement activityDetailViewOpportunitiesLnk;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='activity_detail']/descendant::*[text() = 'Tickets']")
	WebElement activityDetailViewTicketsLnk;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='activity_detail']/descendant::*[text() = 'Notes/History']")
	WebElement activityDetailViewNotesHistoryLnk;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='activity_detail']/descendant::*[text() = 'Addresses']")
	WebElement activityDetailViewAddressesLnk;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='activity_detail']/descendant::*[text() = 'Attachments']")
	WebElement activityDetailViewAttachmentsLnk;
		
	//Edit View elements
	//TODO: update the Edit View elements
	@CacheLookup
	@FindBy(xpath = ".//*[@id='activity_edit']")
	WebElement activityEditView;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_TextField_14']/input")
	WebElement activityEditViewAccountInputFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_TextField_15']/input")
	WebElement activityEditViewWebInputFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_PhoneField_5']/input")
	WebElement activityEditViewPhoneInputFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Mobile_SalesLogix_Fields_AddressField_2']/div")
	WebElement activityEditViewAddressFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Mobile_SalesLogix_Fields_AddressField_2']/button")
	WebElement activityEditViewAddressFldBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_PhoneField_6']/input")
	WebElement activityEditViewFaxInputFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Mobile_SalesLogix_Fields_PicklistField_11']/input")
	WebElement activityEditViewTypeFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Mobile_SalesLogix_Fields_PicklistField_11']/button")
	WebElement activityEditViewTypeFldBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Mobile_SalesLogix_Fields_PicklistField_12']/input")
	WebElement activityEditViewSubTypeFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Mobile_SalesLogix_Fields_PicklistField_12']/button")
	WebElement activityEditViewSubTypeFldBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Mobile_SalesLogix_Fields_PicklistField_13']/input")
	WebElement activityEditViewStatusFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Mobile_SalesLogix_Fields_PicklistField_13']/button")
	WebElement activityEditViewStatusFldBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Mobile_SalesLogix_Fields_PicklistField_14']/input")
	WebElement activityEditViewIndustryFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Mobile_SalesLogix_Fields_PicklistField_14']/button")
	WebElement activityEditViewIndustryFldBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_NoteField_0']/div")
	WebElement activityEditViewBusDescFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_NoteField_0']/button")
	WebElement activityEditViewBusDescFldBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_LookupField_0']/input")
	WebElement activityEditViewAcctMgrFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_LookupField_0']/button")
	WebElement activityEditViewAcctMgrFldBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_LookupField_1']/input")
	WebElement activityEditViewOwnerFld;
	
	@CacheLookup
	@FindBy(xpath = ".//*[@id='Sage_Platform_Mobile_Fields_LookupField_1']/button")
	WebElement activityEditViewOwnerFldBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_LookupField_2']/input")
	WebElement activityEditViewLeadSourceFld;
	
	@CacheLookup
	@FindBy(xpath = ".//*[@id='Sage_Platform_Mobile_Fields_LookupField_2']/button")
	WebElement activityEditViewLeadSourceFldBtn;
	
	
	//Methods
	//-------
	public String getMyActivitiesListViewTxt() {
		String methodID = "getMyActivitiesListViewTxt";
		
		WebElement myActivitiesLisViewInfo = driver.findElement(By.xpath("//*[@id='myactivity_list']/ul"));
		
		return myActivitiesLisViewInfo.getText();		
	}
	
	
	public boolean NoRecordsFound() {
		boolean result = false;
		
		return result;
	}
}
