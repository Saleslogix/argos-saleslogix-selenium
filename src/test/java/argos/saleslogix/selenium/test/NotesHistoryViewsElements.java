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


public class NotesHistoryViewsElements extends BaseTest {
	
	private WebDriver driver;

	public NotesHistoryViewsElements(WebDriver driver) {
		this.driver = driver;		
	}
	
	CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);

	//List View elements
	@CacheLookup
	@FindBy(xpath = "//*[@selected='true']//input[@name='query']")
	WebElement notesHistorysSearchTxtBox;
	
	@CacheLookup
	@FindBy(xpath = "//*[@selected='true']//button[@class='clear-button']")
	WebElement notesHistorysSearchClearBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@selected='true']//button[@class='subHeaderButton searchButton']")
	WebElement notesHistorysSearchLookupBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='history_list']//ul")
	WebElement notesHistorysListView;
	
	@CacheLookup
	@FindBy(xpath = "//div[10]/div[2]/div/div/div/button")
	WebElement notesHistorysListView1stKPICard;
	
	@CacheLookup
	@FindBy(xpath = "//div[10]/div[2]/div/button")
	WebElement notesHistorysListView2ndKPICard;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='history_list_search-expression']/div")
	WebElement notesHistorysListView1stHashTagFilter;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='history_list']//ul/li[1]")
	WebElement topNotesHistoryListItem;

	@CacheLookup
	@FindBy(xpath = "//*[@id='history_list']//ul/li[1]/div[1]")
	WebElement topNotesHistoryListItemTab;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='history_list']//ul/li[1]/button")
	WebElement topNotesHistoryListItemIcon;	

	@CacheLookup
	@FindBy(xpath = "//*[@id='history_list']//ul/li[1]/div/h3")
	WebElement topNotesHistoryListItemScheduledTime;

    @CacheLookup
    @FindBy(xpath = "//*[@id='history_list']//ul/li[1]/div[2]/h4[1]")
    WebElement topNotesHistoryListItemContactAccount;

    @CacheLookup
    @FindBy(xpath = "//*[@id='history_list']//ul/li[1]/div[2]/h4[2]")
    WebElement topNotesHistoryListItemRegarding;

    @CacheLookup
    @FindBy(xpath = "//*[@id='history_list']//ul/li[1]/div[2]/div/div")
    WebElement topNotesHistoryListItemNotes;

    @CacheLookup
    @FindBy(xpath = "//*[@id='bottom_item_indicators']/span[1]")
    WebElement topNotesHistoryListItemTouch;

    @CacheLookup
    @FindBy(xpath = "//*[@id='bottom_item_indicators']/span[2]/img")
    WebElement topNotesHistoryListItemType;
	
	//TODO: figure out the css identifier for the ToDo icon that is right of the touch icon
	/*
	@CacheLookup
	@FindBy(css = "#history_list > ul.list-content > li > #bottom_item_indicators > span > img")
	WebElement topNotesHistoryListItemTouch;
	*/
	
	@CacheLookup
	//@FindBy(css = "#history_list > ul.list-content > li > #list-item-footer > div > button.footer-item-selector.button")
    @FindBy(xpath = "//*[@id='list-item-footer']/div/button")
	WebElement topNotesHistoryListItemQuickActionsBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='history_list']//ul/li[2]/button[4]")
	WebElement topNotesHistoryListItemQuickActionsAddAttachmentBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='history_list']//ul/li[2]/button[3]")
	WebElement topNotesHistoryListItemQuickActionsContactsBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='history_list']//ul/li[2]/button[2]")
	WebElement topNotesHistoryListItemQuickActionsOpportunityBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='history_list']//ul/li[2]/button[1]")
	WebElement topNotesHistoryListItemQuickActionsAccountBtn;	
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='history_list']//ul/li[11]")
	WebElement eleventhNotesHistoryListItem;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='history_list']//ul/li[21]")
	WebElement twentyfirstNotesHistoryListItem;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='history_list']//ul/li[31]")
	WebElement thirtyfirstNotesHistoryListItem;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='history_list']/div[2]")
	WebElement recordsRemainingListItem;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='history_list']//ul/li/h3")
	WebElement noRecordsListItem;
	
	//Context Menu elements
	@CacheLookup
	@FindBy(xpath = "//*[@id='right_drawer']/div[3]/h2[1]")
	WebElement notesHistoryHashTagsHdr;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='right_drawer']//ul[@data-group='view']")
	WebElement notesHistoryHashTagsPnl;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='right_drawer']/div[3]/h2[2]")
	WebElement notesHistoryKPIHdr;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='right_drawer']//ul[@data-group='kpi']")
	WebElement notesHistoryKPIPnl;
	
	//Detail View elements
	@CacheLookup
	@FindBy(xpath = "//*[@id='history_detail']")
	WebElement notesHistoryDetailView;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='history_detail']/div[2]/h2[2]")
	WebElement notesHistoryDetailViewDetailsHdr;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='history_detail']/div[2]/div[2]/div[1]/span")
	WebElement notesHistoryDetailViewScheduledFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='history_detail']/div[2]/div[2]/div[2]/span")
	WebElement notesHistoryDetailViewCompletedFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='history_detail']/div[2]/div[2]/div[3]/span")
	WebElement notesHistoryDetailViewRegardingFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='history_detail']/div[2]/div[2]/div[4]/span")
	WebElement notesHistoryDetailViewCompletedByFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='history_detail']/div[2]/h2[1]")
	WebElement notesHistoryDetailViewNotesHdr;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='history_detail']/div[2]/div[1]/div/pre")
	WebElement notesHistoryDetailViewNotesFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='history_detail']/div[2]/h2[3]")
	WebElement notesHistoryDetailRelatedItems1Hdr;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='history_detail']/div[2]/div[2]/div[5]/span")
	WebElement notesHistoryDetailViewAccountFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='history_detail']/div[2]/div[2]/div[6]/span")
	WebElement notesHistoryDetailViewContactFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='history_detail']/div[2]/div[2]/div[7]/span")
	WebElement notesHistoryDetailViewOpportunityFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='history_detail']/div[2]/div[2]/div[8]/span")
	WebElement notesHistoryDetailViewTicketFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='history_detail']/div[2]/h2[3]")
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
	
	//@CacheLookup
	//@FindBy(xpath = "//*[@id='Mobile_SalesLogix_Fields_PicklistField_0']/input")
    @FindBy(xpath = "//*[@data-field='Description']//input")
	WebElement notesHistoryEditViewRegardingInputFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Mobile_SalesLogix_Fields_PicklistField_0']/button")
	WebElement notesHistoryEditViewRegardingFldBtn;
	
	//@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_TextAreaField_0']/textarea")
	WebElement notesHistoryEditViewNotesInputFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_BooleanField_1']/div/span[1]")
	WebElement notesHistoryEditViewForLeadToggleBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_LookupField_0']/input")
	WebElement notesHistoryEditViewAccountInputFld;
	
	@CacheLookup
	//@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_LookupField_0']/button")
    @FindBy(xpath = "//*[@data-field='Account']//button")
	WebElement notesHistoryEditViewAccountFldBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_LookupField_1']/input")
	WebElement notesHistoryEditViewContactInputFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_LookupField_1']/button")
	WebElement notesHistoryEditViewContactFldBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_LookupField_2']/input")
	WebElement notesHistoryEditViewOpportunityInputFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_LookupField_2']/button")
	WebElement notesHistoryEditViewOpportunityFldBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_LookupField_3']/input")
	WebElement notesHistoryEditViewTicketInputFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_LookupField_3']/button")
	WebElement notesHistoryEditViewTicketFldBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_LookupField_4']/input")
	WebElement notesHistoryEditViewLeadInputFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_LookupField_4']/button")
	WebElement notesHistoryEditViewLeadFldBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_TextField_2']/input")
	WebElement notesHistoryEditViewCompanyInputFld;

    @CacheLookup
    @FindBy(xpath = ".//*[@id='history_edit']/div[1]//h2")
    WebElement notesHistoryEditViewValSummTitle;

    @CacheLookup
    @FindBy(xpath = ".//*[@id='history_edit']/div[1]//h3")
    WebElement notesHistoryEditViewValSummMessage;

    @CacheLookup
    @FindBy(xpath = ".//*[@id='history_edit']/div[1]//h4")
    WebElement notesHistoryEditViewValSummField;
	
	//Methods
	//-------
	public String getNotesHistoryListViewTxt() {
		String methodID = "getNotesHistoryListViewTxt";
		
		WebElement notesHistoryLisViewInfo = driver.findElement(By.xpath("//*[@id='history_list']//ul"));
		
		return notesHistoryLisViewInfo.getText();		
	}
	
	
	public boolean NoRecordsFound() {
		boolean result = false;
		
		return result;
	}


	/**
	 * This method will add an auto-generated test Note record by filling-in the Note Edit input fields.
	 * The Note will have a unique string appended to the Note Regarding field in order to ensure uniqueness.
	 * @author	mike.llena@swiftpage.com
	 * @version	1.0
	 * @param strRegarding	regarding value
	 * @param strNotes	notes to identify the record
	 * @param blnForLead	if true then for lead, false otherwise
	 * @param strLeadOrAccount	lead or account record
	 * @throws Exception 
	 */
	public void doAddRandTestNote(String strRegarding, String strNotes, boolean blnForLead, String strLeadOrAccount) throws Exception {
		String methodID = "doAddRandTestNote";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);
		CommonViewsElements commView = PageFactory.initElements(driver, CommonViewsElements.class);
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
		
	    //Step: navigate to Notes/History list view
		commNav.clickGlobalMenuItem("Notes/History");
		
		//Step: click the Add header button to enter Notes/History edit view
		headerButton.clickHeaderButton("Add");
		
		//Step: setup new Note field values
		//setup Time field (leave as-is)
		
		//setup Regarding fields		
		notesHistoryEditViewRegardingInputFld.sendKeys(strRegarding);
			
		//setup Notes field
		notesHistoryEditViewNotesInputFld.sendKeys(strNotes);
		
		//set For Lead toggle
		if (blnForLead) {
			//set Lead field
			notesHistoryEditViewLeadFldBtn.click();
				commNav.highlightNClick(commNav.entityListViewSelect("Leads", strLeadOrAccount));
		}
		else {
			//set Account field
			notesHistoryEditViewAccountFldBtn.click();
				commNav.highlightNClick(commNav.entityListViewSelect("Accounts", strLeadOrAccount));
		}
		//TO-DO: complete selection of remaining non-required fields
		
		//Step: save the new Note field values
		headerButton.clickHeaderButton("save");
		commNav.waitForNotPage("Note");
		
		System.out.println(methodID + ": Auto-test Note/History - " +  strNotes + " record was created.");
	}


	public boolean doSearchNote(String strNoteInfo) throws InterruptedException, Exception {
		String methodID = "doSearchNote";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerbutton = PageFactory.initElements(driver, HeaderButton.class);
		CommonViewsElements commView = PageFactory.initElements(driver, CommonViewsElements.class);
			
	    //Step: search for then click to open Opportunity record detail view
		commNav.highlightNClick(commNav.entityListViewSearch("Notes/History", strNoteInfo));
		
		//Step: confirm Note record detail view is displayed
		if (commNav.waitForNotPage("Notes/History")) {
			return true;
		}
		else {		
			return false;
		}
	}
}
