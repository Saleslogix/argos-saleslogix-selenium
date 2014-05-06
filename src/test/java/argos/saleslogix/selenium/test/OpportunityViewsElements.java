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


public class OpportunityViewsElements extends BaseTest {
	
	private WebDriver driver;

	public OpportunityViewsElements(WebDriver driver) {
		this.driver = driver;		
	}
	
	CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);

	//List View elements
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_SearchWidget_11']/div/div[1]/input")
	WebElement opportunitySearchTxtBox;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_SearchWidget_11']/div/div[2]/button")
	WebElement opportunitySearchClearBtn;
	
	@CacheLookup
	@FindBy(xpath = ".//*[@id='Sage_Platform_Mobile_SearchWidget_11']/div/div[3]/button")
	WebElement opportunitySearchLookupBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='opportunity_list']//ul")
	WebElement opportunityListViewRecords;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='opportunity_list']//ul/li[1]")
	WebElement topOpportunityListItem;
	
	@CacheLookup
	@FindBy(xpath = "//div[5]/div[2]/div[1]/div/button")
	WebElement opportunityListView1stKPICard;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='opportunity_list_search-expression']/div")
	WebElement opportunityListView1stHashTagFilter;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='opportunity_list']//ul/li[1]/div[1]")
	WebElement topOpportunityListItemTab;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='opportunity_list']//ul/li[1]/button")
	WebElement topOpportunityListItemIcon;	

	@CacheLookup
	@FindBy(xpath = "//*[@id='opportunity_list']//ul/li[1]/div/h3")
	WebElement topOpportunityListItemName;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='opportunity_list']//ul/li[1]/div[3]/h4[1]")
	WebElement topOpportunityListItemAccount;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='opportunity_list']//ul/li[1]/div[3]/h4[2]")
	WebElement topOpportunityListItemAcctMgrInfo;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='opportunity_list']//ul/li[1]/div[3]/h4[3]")
	WebElement topOpportunityListItemStatusInfo;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='opportunity_list']//ul/li[1]/div[3]/h4[4]/strong")
	WebElement topOpportunityListItemSalesPotOppRate;
	
	@CacheLookup
	//@FindBy(css = "#opportunity_list > ul.list-content > li > #bottom_item_indicators > span > img")
    @FindBy(xpath = "//*[@id='bottom_item_indicators']/span/img")
	WebElement topOpportunityListItemTouch;
	
	@CacheLookup
	//@FindBy(css = "#opportunity_list > ul.list-content > li > #list-item-footer > div > button.footer-item-selector.button")
    @FindBy(xpath = "//*[@id='list-item-footer']/div/button")
	WebElement topOpportunityListItemQuickActionsBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='opportunity_list']//ul/li[2]/button[7]")
	WebElement topOpportunityListItemQuickActionsAddAttachmentBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='opportunity_list']//ul/li[2]/button[6]")
	WebElement topOpportunityListItemQuickActionsAddActivityBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='opportunity_list']//ul/li[2]/button[5]")
	WebElement topOpportunityListItemQuickActionsAddNoteBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='opportunity_list']//ul/li[2]/button[4]")
	WebElement topOpportunityListItemQuickActionsProductsBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='opportunity_list']//ul/li[2]/button[3]")
	WebElement topOpportunityListItemQuickActionsContactsBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='opportunity_list']//ul/li[2]/button[2]")
	WebElement topOpportunityListItemQuickActionsAccountBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='opportunity_list']//ul/li[2]/button[1]")
	WebElement topOpportunityListItemQuickActionsEditBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='opportunity_list']//ul/li[11]")
	WebElement eleventhOpportunityListItem;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='opportunity_list']//ul/li[21]")
	WebElement twentyfirstOpportunityListItem;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='opportunity_list']//ul/li[31]")
	WebElement thirtyfirstOpportunityListItem;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='opportunity_list']/div[2]")
	WebElement recordsRemainingListItem;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='opportunity_list']//ul/li/h3")
	WebElement noRecordsListItem;
	
	//Context Menu elements
	@CacheLookup
	@FindBy(xpath = "//*[@id='right_drawer']/div[3]/h2[1]")
	WebElement opportunityHashTagsHdr;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='right_drawer']/div[3]/ul[1]")
	WebElement opportunityHashTagsPnl;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='opportunity_list']")
	WebElement opportunityListViewPnl;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='itemsNode']")
	WebElement opportunityListViewNotesBox;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='itemsNode']/div[2]")
	WebElement opportunityListViewNotesBox1stItem;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='itemsNode']/div[2]/div/div[1]/div")
	WebElement opportunityListViewNotesBox1stItemInitialsBox;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='itemsNode']/div[2]/div/div[2]/h4[1]/strong")
	WebElement opportunityListViewNotesBox1stItemRegarding;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='itemsNode']/div[2]/div/div[2]/h4[2]")
	WebElement opportunityListViewNotesBox1stItemLastActivity;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='itemsNode']/div[2]/div/div[3]/div/h4")
	WebElement opportunityListViewNotesBox1stItemNotes;
	
	@CacheLookup
	@FindBy(xpath = "//div[2]/div[4]/div[2]")
	WebElement opportunityListViewNotesBoxSeeListLink;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='right_drawer']/div[3]/h2[2]")
	WebElement opportunityKPIHdr;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='right_drawer']/div[3]/ul[2]")
	WebElement opportunityKPIPnl;
	
	//Detail View elements
	@CacheLookup
	@FindBy(xpath = "//*[@id='opportunity_detail']")
	WebElement opportunityDetailView;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='opportunity_detail']/div[2]/h2[1]")
	WebElement opportunityDetailViewQuickActionsHdr;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='opportunity_detail']/div[2]/ul[1]/li[1]/a")
	WebElement opportunityDetailViewScheduleActivityLnk;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='opportunity_detail']/div[2]/ul[1]/li[2]/a")
	WebElement opportunityDetailViewAddNoteLnk;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='opportunity_detail']/div[2]/h2[2]")
	WebElement opportunityDetailViewDetailsHdr;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='opportunity_detail']/div[2]/div[1]/div[1]")
	WebElement opportunityDetailViewOpportunityFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='opportunity_detail']/div[2]/div[1]/div[2]")
	WebElement opportunityDetailViewAcctFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='opportunity_detail']/div[2]/div[1]/div[3]")
	WebElement opportunityDetailViewResellerFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='opportunity_detail']/div[2]/div[1]/div[4]")
	WebElement opportunityDetailViewEstCloseFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='opportunity_detail']/div[2]/div[1]/div[5]")
	WebElement opportunityDetailViewStatusFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='opportunity_detail']/div[2]/div[1]/div[6]")
	WebElement opportunityDetailViewTypeFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='opportunity_detail']/div[2]/div[1]/div[7]")
	WebElement opportunityDetailViewCloseProbFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='opportunity_detail']/div[2]/div[1]/div[8]")
	WebElement opportunityDetailViewSalesPotentialBaseRateFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='opportunity_detail']/div[2]/div[1]/div[9]")
	WebElement opportunityDetailViewSalesPotentialMyRateFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='opportunity_detail']/div[2]/div[1]/div[10]")
	WebElement opportunityDetailViewSalesPotentialOppRateFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='opportunity_detail']/div[2]/h2[2]")
	WebElement opportunityDetailViewMultiCurrencyHdr;
		
	@CacheLookup
	@FindBy(xpath = "//*[@id='opportunity_detail']/div[2]/div[2]")
	WebElement opportunityDetailViewMultiCurrencyFields;	
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='opportunity_detail']/div[2]/div[2]/div[1]")
	WebElement opportunityDetailViewExchangeRateFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='opportunity_detail']/div[2]/div[2]/div[2]")
	WebElement opportunityDetailViewCodeFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='opportunity_detail']/div[2]/div[2]/div[3]")
	WebElement opportunityDetailViewRateDateFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='opportunity_detail']/div[2]/div[2]/div[4]")
	WebElement opportunityDetailViewRateLockedFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='opportunity_detail']/div[2]/h2[3]")
	WebElement opportunityDetailViewMoreDetailsHdr;
		
	@CacheLookup
	@FindBy(xpath = "//*[@id='opportunity_detail']/div[2]/div[2]")
	WebElement opportunityDetailViewMoreDetailsFields;	
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='opportunity_detail']/div[2]/div[2]/div[1]")
	WebElement opportunityDetailViewAcctMgrFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='opportunity_detail']/div[2]/div[2]/div[2]")
	WebElement opportunityDetailViewLeadSourceFld;

	@CacheLookup
	@FindBy(xpath = "//*[@id='opportunity_detail']/div[2]/h2[4]")
	WebElement opportunityDetailViewRelatedItemsHdr;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='opportunity_detail']/descendant::*[text() = 'Products']")
	WebElement opportunityDetailViewProductsLnk;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='opportunity_detail']/descendant::*[text() = 'Activities']")
	WebElement opportunityDetailViewActivitiesLnk;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='opportunity_detail']/descendant::*[text() = 'Opportunity Contacts']")
	WebElement opportunityDetailViewOpportunityContactsLnk;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='opportunity_detail']/descendant::*[text() = 'Notes/History']")
	WebElement opportunityDetailViewNotesHistoryLnk;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='opportunity_detail']/descendant::*[text() = 'Attachments']")
	WebElement opportunityDetailViewAttachmentsLnk;
		
	//Edit View elements
	@CacheLookup
	@FindBy(xpath = ".//*[@id='opportunity_edit']")
	WebElement opportunityEditView;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='opportunity_edit']/descendant::*[@name='Description'][2]")
	WebElement opportunityEditViewOpportunityInputFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_LookupField_0']/input")
	WebElement opportunityEditViewAccountInputFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_LookupField_0']/input")
	WebElement opportunityEditViewAcctInputFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_LookupField_0']/button")
	WebElement opportunityEditViewAcctFldBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_LookupField_1']/input")
	WebElement opportunityEditViewAcctMgrInputFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_LookupField_1']/button")
	WebElement opportunityEditViewAcctMgrFldBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_LookupField_2']/input")
	WebElement opportunityEditViewResellerInputFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_LookupField_2']/button")
	WebElement opportunityEditViewResellerFldBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_DateField_0']/input")
	WebElement opportunityEditViewEstCloseInputFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_DateField_0']/button")
	WebElement opportunityEditViewEstCloseFldBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Mobile_SalesLogix_Fields_MultiCurrencyField_0']/input")
	WebElement opportunityEditViewSalesPotentialInputFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Mobile_SalesLogix_Fields_MultiCurrencyField_0']/span")
	WebElement opportunityEditViewSalesPotentialCurrencyFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Mobile_SalesLogix_Fields_PicklistField_0']/input")
	WebElement opportunityEditViewTypeInputFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Mobile_SalesLogix_Fields_PicklistField_0']/button")
	WebElement opportunityEditViewTypeFldBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Mobile_SalesLogix_Fields_PicklistField_1']/input")
	WebElement opportunityEditViewStatusInputFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Mobile_SalesLogix_Fields_PicklistField_1']/button")
	WebElement opportunityEditViewStatusFldBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_LookupField_3']/input")
	WebElement opportunityEditViewLeadSourceInputFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_LookupField_3']/button")
	WebElement opportunityEditViewLeadSourceFldBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_LookupField_4']/input")
	WebElement opportunityEditViewOwnerInputFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_LookupField_4']/button")
	WebElement opportunityEditViewOwnerFldBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Mobile_SalesLogix_Fields_PicklistField_2']/input")
	WebElement opportunityEditViewCloseProbInputFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Mobile_SalesLogix_Fields_PicklistField_2']/button")
	WebElement opportunityEditViewCloseProbFldBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='opportunity_edit']/div[2]/fieldset[2]/div[1]")
	WebElement opportunityEditViewExchangeRateFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_TextField_2']/input")
	WebElement opportunityEditViewExchangeRateInputFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='opportunity_edit']/div[2]/fieldset[2]/div[2]")
	WebElement opportunityEditViewCodeFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_LookupField_5']/input")
	WebElement opportunityEditViewCodeInputFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_LookupField_5']/button")
	WebElement opportunityEditViewCodeFldBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='opportunity_edit']/div[2]/fieldset[2]/div[3]")
	WebElement opportunityEditViewRateLockedFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_BooleanField_1']/div/span[2]")
	WebElement opportunityEditViewRateLockedToggle;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='opportunity_edit']/div[2]/fieldset[2]/div[4]")
	WebElement opportunityEditViewRateDateFld;
	
	//Methods
	//-------
	public String getOpportunityListViewTxt() {
		String methodID = "getOpportunityListViewTxt";
		
		WebElement OpportunityLisViewInfo = driver.findElement(By.xpath("//*[@id='opportunity_list']//ul"));
		
		return OpportunityLisViewInfo.getText();		
	}
	
	
	public boolean NoRecordsFound() {
		boolean result = false;
		
		return result;
	}


	/**
	 * This method will add an auto-generated test Opportunity record by filling-in the Opportunity Edit input fields.
	 * The Opportunity will have a unique string appended to the Opportunity Name in order to ensure uniqueness.
	 * @author	mike.llena@swiftpage.com
	 * @version	1.0
	 * @param	strOppName	lead last name to set
	 * @param	strOppAccount	lead first name to set
	 * @throws Exception 
	 */
	public void doAddRandTestOpportunity(String strOppName, String strOppAccount) throws Exception {
		String methodID = "doAddRandTestOpportunity";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);
		CommonViewsElements commView = PageFactory.initElements(driver, CommonViewsElements.class);
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
		
	    //Step: navigate to Opportunity list view
		commNav.clickGlobalMenuItem("Opportunities");
		
		//Step: click the Add header button to enter Opportunity edit view
		headerButton.clickHeaderButton("Add");
		
		//Step: setup new Opportunity field values
		//setup Opportunity fields		
		opportunityEditViewOpportunityInputFld.sendKeys(strOppName);
			
		//setup acct field
		opportunityEditViewAcctFldBtn.click();
			commNav.highlightNClick(commNav.entityListViewSelect("Accounts", strOppAccount));
	
		//TO-DO: complete selection of remaining non-required fields
		
		//Step: save the new Opportunity field values
		headerButton.clickHeaderButton("save");
		commNav.waitForNotPage("Opportunity");
		
		System.out.println(methodID + ": Auto-test Opportunity - " +  strOppName + " record was created.");
	}


	public boolean doSearchOpportunity(String strOppName) throws InterruptedException, Exception {
		String methodID = "doSearchOpportunity";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerbutton = PageFactory.initElements(driver, HeaderButton.class);
		CommonViewsElements commView = PageFactory.initElements(driver, CommonViewsElements.class);
			
	    //Step: search for then click to open Opportunity record detail view
		commNav.highlightNClick(commNav.entityListViewSearch("Opportunities", strOppName));
		
		//Step: confirm Opportunity record detail view is displayed
		if (commNav.waitForNotPage("Opportunities")) {
			return true;
		}
		else {		
			return false;
		}
	}


	//Methods
	public String getOpportunitiesListViewTxt() {
		String methodID = "getOpportunitiesListViewTxt";
		String listViewTxt = "";
		
		try {
			WebElement oppsLisViewInfo = driver.findElement(By.xpath("//*[@id='opportunity_list']//ul"));
			listViewTxt = oppsLisViewInfo.getText();
		}
		catch (Exception e) {
			System.out.println(methodID + "(): " + e.toString());
		}
		
		return listViewTxt;		
	}
}
