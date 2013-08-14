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


public class NotesHistoryViewsElements extends BrowserSetup {
	
	private WebDriver driver;

	public NotesHistoryViewsElements(WebDriver driver) {
		this.driver = driver;		
	}
	
	CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);

	//List View elements
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_SearchWidget_27']/div/div[1]/input")
	WebElement notesHistorysSearchTxtBox;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_SearchWidget_27']/div/div[2]/button")
	WebElement notesHistorysSearchClearBtn;
	
	@CacheLookup
	@FindBy(xpath = ".//*[@id='Sage_Platform_Mobile_SearchWidget_27']/div/div[3]/button")
	WebElement notesHistorysSearchLookupBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='history_list']/ul")
	WebElement notesHistorysListView;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='history_list']/ul/li[1]")
	WebElement topNotesHistoryListItem;

	@CacheLookup
	@FindBy(xpath = "//*[@id='history_list']/ul/li[1]/div[1]")
	WebElement topNotesHistoryListItemTab;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='history_list']/ul/li[1]/button")
	WebElement topNotesHistoryListItemIcon;	

	@CacheLookup
	@FindBy(xpath = "//*[@id='history_list']/ul/li[1]/div/h3")
	WebElement topNotesHistoryListItemScheduledTime;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='history_list']/ul/li[1]/div[3]/h4[1]")
	WebElement topNotesHistoryListItemContactAccount;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='history_list']/ul/li[1]/div[3]/h4[2]")
	WebElement topNotesHistoryListItemRegarding;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='history_list']/ul/li[1]/div[3]/div/div")
	WebElement topNotesHistoryListItemNotes;
	
	@CacheLookup
	@FindBy(css = "#history_list > ul.list-content > li > #bottom_item_indicators > span > img")
	WebElement topNotesHistoryListItemTouch;
	
	//TODO: figure out the css identifier for the ToDo icon that is right of the touch icon
	/*
	@CacheLookup
	@FindBy(css = "#history_list > ul.list-content > li > #bottom_item_indicators > span > img")
	WebElement topNotesHistoryListItemTouch;
	*/
	
	@CacheLookup
	@FindBy(css = "#history_list > ul.list-content > li > #list-item-footer > div > button.footer-item-selector.button")
	WebElement topNotesHistoryListItemQuickActionsBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='history_list']/ul/li[2]/button[4]")
	WebElement topNotesHistoryListItemQuickActionsAddAttachmentBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='history_list']/ul/li[2]/button[3]")
	WebElement topNotesHistoryListItemQuickActionsContactsBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='history_list']/ul/li[2]/button[2]")
	WebElement topNotesHistoryListItemQuickActionsOpportunityBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='history_list']/ul/li[2]/button[1]")
	WebElement topNotesHistoryListItemQuickActionsAccountBtn;	
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='history_list']/ul/li[11]")
	WebElement eleventhNotesHistoryListItem;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='history_list']/ul/li[21]")
	WebElement twentyfirstNotesHistoryListItem;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='history_list']/ul/li[31]")
	WebElement thirtyfirstNotesHistoryListItem;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='history_list']/div[2]")
	WebElement recordsRemainingListItem;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='history_list']/ul/li/h3")
	WebElement noRecordsListItem;
	
	//Context Menu elements
	@CacheLookup
	@FindBy(xpath = "//*[@id='right_drawer']/div[4]/h2[1]")
	WebElement notesHistoryHashTagsHdr;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='right_drawer']/div[4]/ul[1]")
	WebElement notesHistoryHashTagsPnl;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='right_drawer']/div[4]/h2[2]")
	WebElement notesHistoryKPIHdr;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='right_drawer']/div[4]/ul[2]")
	WebElement notesHistoryKPIPnl;
	
	//Detail View elements
	@CacheLookup
	@FindBy(xpath = "//*[@id='history_detail']")
	WebElement notesHistoryDetailView;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='history_detail']/div[2]/h2[1]")
	WebElement notesHistoryDetailViewDetailsHdr;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='history_detail']/div[2]/div[1]/div[1]")
	WebElement notesHistoryDetailViewScheduledFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='history_detail']/div[2]/div[1]/div[2]")
	WebElement notesHistoryDetailViewCompletedFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='history_detail']/div[2]/div[1]/div[3]")
	WebElement notesHistoryDetailViewRegardingFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='history_detail']/div[2]/div[1]/div[4]")
	WebElement notesHistoryDetailViewCompletedByFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='history_detail']/div[2]/h2[2]")
	WebElement notesHistoryDetailViewNotesHdr;
	
	//TODO: Left-off element updates here; continue updates when needed
	@CacheLookup
	@FindBy(xpath = "//*[@id='history_detail']/div[2]/div[1]/div[1]")
	WebElement notesHistoryDetailViewAccountFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='history_detail']/div[2]/div[1]/div[2]")
	WebElement notesHistoryDetailViewWebFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='history_detail']/div[2]/div[1]/div[3]")
	WebElement notesHistoryDetailViewFaxFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='history_detail']/div[2]/div[1]/div[4]")
	WebElement notesHistoryDetailViewTypeFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='history_detail']/div[2]/div[1]/div[5]")
	WebElement notesHistoryDetailViewSubTypeFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='history_detail']/div[2]/div[1]/div[6]")
	WebElement notesHistoryDetailViewStatusFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='history_detail']/div[2]/h2[3]")
	WebElement notesHistoryDetailViewMoreDetailsHdr;
		
	@CacheLookup
	@FindBy(xpath = "//*[@id='history_detail']/div[2]/div[2]")
	WebElement notesHistoryDetailViewMoreDetailsFields;	
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='history_detail']/div[2]/div[2]/div[1]")
	WebElement notesHistoryDetailViewIndustryFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='history_detail']/div[2]/div[2]/div[2]")
	WebElement notesHistoryDetailViewBusDescFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='history_detail']/div[2]/div[2]/div[3]")
	WebElement notesHistoryDetailViewAcctMgrFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='history_detail']/div[2]/div[2]/div[4]")
	WebElement notesHistoryDetailViewOwnerFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='history_detail']/div[2]/div[2]/div[5]")
	WebElement notesHistoryDetailViewLeadSourceFld;

	@CacheLookup
	@FindBy(xpath = "//*[@id='history_detail']/div[2]/h2[4]")
	WebElement notesHistoryDetailViewRelatedItemsHdr;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='history_detail']/descendant::*[text() = 'Activities']")
	WebElement notesHistoryDetailViewActivitiesLnk;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='history_detail']/descendant::*[text() = 'Contacts']")
	WebElement notesHistoryDetailViewContactsLnk;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='history_detail']/descendant::*[text() = 'Opportunities']")
	WebElement notesHistoryDetailViewOpportunitiesLnk;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='history_detail']/descendant::*[text() = 'Tickets']")
	WebElement notesHistoryDetailViewTicketsLnk;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='history_detail']/descendant::*[text() = 'Notes/History']")
	WebElement notesHistoryDetailViewNotesHistoryLnk;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='history_detail']/descendant::*[text() = 'Addresses']")
	WebElement notesHistoryDetailViewAddressesLnk;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='history_detail']/descendant::*[text() = 'Attachments']")
	WebElement notesHistoryDetailViewAttachmentsLnk;
		
	//Edit View elements
	@CacheLookup
	@FindBy(xpath = ".//*[@id='history_edit']")
	WebElement notesHistoryEditView;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_TextField_14']/input")
	WebElement notesHistoryEditViewAccountInputFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_TextField_15']/input")
	WebElement notesHistoryEditViewWebInputFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_PhoneField_5']/input")
	WebElement notesHistoryEditViewPhoneInputFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Mobile_SalesLogix_Fields_AddressField_2']/div")
	WebElement notesHistoryEditViewAddressFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Mobile_SalesLogix_Fields_AddressField_2']/button")
	WebElement notesHistoryEditViewAddressFldBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_PhoneField_6']/input")
	WebElement notesHistoryEditViewFaxInputFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Mobile_SalesLogix_Fields_PicklistField_11']/input")
	WebElement notesHistoryEditViewTypeFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Mobile_SalesLogix_Fields_PicklistField_11']/button")
	WebElement notesHistoryEditViewTypeFldBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Mobile_SalesLogix_Fields_PicklistField_12']/input")
	WebElement notesHistoryEditViewSubTypeFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Mobile_SalesLogix_Fields_PicklistField_12']/button")
	WebElement notesHistoryEditViewSubTypeFldBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Mobile_SalesLogix_Fields_PicklistField_13']/input")
	WebElement notesHistoryEditViewStatusFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Mobile_SalesLogix_Fields_PicklistField_13']/button")
	WebElement notesHistoryEditViewStatusFldBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Mobile_SalesLogix_Fields_PicklistField_14']/input")
	WebElement notesHistoryEditViewIndustryFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Mobile_SalesLogix_Fields_PicklistField_14']/button")
	WebElement notesHistoryEditViewIndustryFldBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_NoteField_0']/div")
	WebElement notesHistoryEditViewBusDescFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_NoteField_0']/button")
	WebElement notesHistoryEditViewBusDescFldBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_LookupField_0']/input")
	WebElement notesHistoryEditViewAcctMgrFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_LookupField_0']/button")
	WebElement notesHistoryEditViewAcctMgrFldBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_LookupField_1']/input")
	WebElement notesHistoryEditViewOwnerFld;
	
	@CacheLookup
	@FindBy(xpath = ".//*[@id='Sage_Platform_Mobile_Fields_LookupField_1']/button")
	WebElement notesHistoryEditViewOwnerFldBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_LookupField_2']/input")
	WebElement notesHistoryEditViewLeadSourceFld;
	
	@CacheLookup
	@FindBy(xpath = ".//*[@id='Sage_Platform_Mobile_Fields_LookupField_2']/button")
	WebElement notesHistoryEditViewLeadSourceFldBtn;
	
	
	//Methods
	//-------
	public String getNotesHistoryListViewTxt() {
		String methodID = "getNotesHistoryListViewTxt";
		
		WebElement notesHistoryLisViewInfo = driver.findElement(By.xpath("//*[@id='history_list']/ul"));
		
		return notesHistoryLisViewInfo.getText();		
	}
	
	
	public boolean NoRecordsFound() {
		boolean result = false;
		
		return result;
	}
}
