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
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_SearchWidget_27']/div/div[3]/button")
	WebElement notesHistorysSearchLookupBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='history_list']/ul")
	WebElement notesHistorysListView;
	
	@CacheLookup
	@FindBy(xpath = "//div[9]/div[2]/div/button")
	WebElement notesHistorysListView1stKPICard;
	
	@CacheLookup
	@FindBy(xpath = "//div[10]/div[2]/div/button")
	WebElement notesHistorysListView2ndKPICard;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='history_list_search-expression']/div")
	WebElement notesHistorysListView1stHashTagFilter;
	
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
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='history_detail']/div[2]/div[2]")
	WebElement notesHistoryDetailViewNotesFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='history_detail']/div[2]/h2[3]")
	WebElement notesHistoryDetailRelatedItems1Hdr;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='history_detail']/div[2]/div[3]/div[1]")
	WebElement notesHistoryDetailViewAccountFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='history_detail']/div[2]/div[3]/div[2]")
	WebElement notesHistoryDetailViewContactFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='history_detail']/div[2]/div[3]/div[3]")
	WebElement notesHistoryDetailViewOpportunityFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='history_detail']/div[2]/div[3]/div[4]")
	WebElement notesHistoryDetailViewTicketFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='history_detail']/div[2]/h2[4]")
	WebElement notesHistoryDetailRelatedItems2Hdr;
		
	@CacheLookup
	@FindBy(xpath = "//*[@id='history_detail']/div[2]/ul/li/a")
	WebElement notesHistoryDetailViewAttachmentsLnk;	
			
	//Edit View elements
	@CacheLookup
	@FindBy(xpath = ".//*[@id='history_edit']")
	WebElement notesHistoryEditView;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_DateField_0']/input")
	WebElement notesHistoryEditViewTimeInputFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_DateField_0']/button")
	WebElement notesHistoryEditViewTimeFldBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Mobile_SalesLogix_Fields_PicklistField_0']/input")
	WebElement notesHistoryEditViewRegardingInputFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Mobile_SalesLogix_Fields_PicklistField_0']/button")
	WebElement notesHistoryEditViewRegardingFldBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_TextAreaField_0']/textarea")
	WebElement notesHistoryEditViewNotesInputFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_BooleanField_1']/div/span[1]")
	WebElement notesHistoryEditViewForLeadToggleBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_LookupField_0']/input")
	WebElement notesHistoryEditViewAccountInputFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_LookupField_0']/button")
	WebElement notesHistoryEditViewAccountFldBtn;
	
	@CacheLookup
	@FindBy(xpath = ".//*[@id='Sage_Platform_Mobile_Fields_LookupField_1']/input")
	WebElement notesHistoryEditViewContactInputFld;
	
	@CacheLookup
	@FindBy(xpath = ".//*[@id='Sage_Platform_Mobile_Fields_LookupField_1']/button")
	WebElement notesHistoryEditViewContactFldBtn;
	
	@CacheLookup
	@FindBy(xpath = ".//*[@id='Sage_Platform_Mobile_Fields_LookupField_2']/input")
	WebElement notesHistoryEditViewOpportunityInputFld;
	
	@CacheLookup
	@FindBy(xpath = ".//*[@id='Sage_Platform_Mobile_Fields_LookupField_2']/button")
	WebElement notesHistoryEditViewOpportunityFldBtn;
	
	@CacheLookup
	@FindBy(xpath = ".//*[@id='Sage_Platform_Mobile_Fields_LookupField_3']/input")
	WebElement notesHistoryEditViewTicketInputFld;
	
	@CacheLookup
	@FindBy(xpath = ".//*[@id='Sage_Platform_Mobile_Fields_LookupField_3']/button")
	WebElement notesHistoryEditViewTicketFldBtn;
	
	
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
