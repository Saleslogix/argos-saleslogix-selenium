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


public class OpportunityViewsElements extends BrowserSetup {
	
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
	@FindBy(xpath = "//*[@id='opportunity_list']/ul[2]")
	WebElement opportunityListViewRecords;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='opportunity_list']/ul/li[1]")
	WebElement topOpportunityListItem;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='opportunity_list']/ul/li[1]/button")
	WebElement topOpportunityListItemIcon;	

	@CacheLookup
	@FindBy(xpath = "//*[@id='opportunity_list']/ul/li[1]/div/h3")
	WebElement topOpportunityListItemName;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='opportunity_list']/ul/li[1]/div/h4[1]")
	WebElement topOpportunityListItemLine2;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='opportunity_list']/ul/li[1]/div/h4[2]")
	WebElement topOpportunityListItemLine3;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='opportunity_list']/ul/li[1]/div/h4[3]")
	WebElement topOpportunityListItemLine4;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='opportunity_list']/ul/li[1]/div/h4[4]")
	WebElement topOpportunityListItemLine5;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='opportunity_list']/ul/li[11]")
	WebElement eleventhOpportunityListItem;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='opportunity_list']/ul/li[21]")
	WebElement twentyfirstOpportunityListItem;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='opportunity_list']/ul/li[31]")
	WebElement thirtyfirstOpportunityListItem;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='opportunity_list']/div[2]")
	WebElement recordsRemainingListItem;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='opportunity_list']/ul/li/h3")
	WebElement noRecordsListItem;
	
	//Context Menu elements
	@CacheLookup
	@FindBy(xpath = "//*[@id='right_drawer']/div[4]/h2[1]")
	WebElement opportunityHashTagsHdr;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='right_drawer']/div[4]/ul[1]")
	WebElement opportunityHashTagsPnl;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='right_drawer']/div[4]/h2[2]")
	WebElement opportunityKPIHdr;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='right_drawer']/div[4]/ul[2]")
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
	WebElement opportunityDetailViewCallMainNumberLnk;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='opportunity_detail']/div[2]/ul[1]/li[2]/a")
	WebElement opportunityDetailViewScheduleActivityLnk;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='opportunity_detail']/div[2]/ul[1]/li[3]/a")
	WebElement opportunityDetailViewAddNoteLnk;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='opportunity_detail']/div[2]/ul[1]/li[4]/a")
	WebElement opportunityDetailViewViewAddressLnk;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='opportunity_detail']/div[2]/h2[2]")
	WebElement opportunityDetailViewDetailsHdr;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='opportunity_detail']/div[2]/div[1]/div[1]")
	WebElement opportunityDetailViewAccountFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='opportunity_detail']/div[2]/div[1]/div[2]")
	WebElement opportunityDetailViewWebFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='opportunity_detail']/div[2]/div[1]/div[3]")
	WebElement opportunityDetailViewFaxFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='opportunity_detail']/div[2]/div[1]/div[4]")
	WebElement opportunityDetailViewTypeFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='opportunity_detail']/div[2]/div[1]/div[5]")
	WebElement opportunityDetailViewSubTypeFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='opportunity_detail']/div[2]/div[1]/div[6]")
	WebElement opportunityDetailViewStatusFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='opportunity_detail']/div[2]/h2[3]")
	WebElement opportunityDetailViewMoreDetailsHdr;
		
	@CacheLookup
	@FindBy(xpath = "//*[@id='opportunity_detail']/div[2]/div[2]")
	WebElement opportunityDetailViewMoreDetailsFields;	
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='opportunity_detail']/div[2]/div[2]/div[1]")
	WebElement opportunityDetailViewIndustryFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='opportunity_detail']/div[2]/div[2]/div[2]")
	WebElement opportunityDetailViewBusDescFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='opportunity_detail']/div[2]/div[2]/div[3]")
	WebElement opportunityDetailViewAcctMgrFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='opportunity_detail']/div[2]/div[2]/div[4]")
	WebElement opportunityDetailViewOwnerFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='opportunity_detail']/div[2]/div[2]/div[5]")
	WebElement opportunityDetailViewLeadSourceFld;

	@CacheLookup
	@FindBy(xpath = "//*[@id='opportunity_detail']/div[2]/h2[4]")
	WebElement opportunityDetailViewRelatedItemsHdr;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='opportunity_detail']/descendant::*[text() = 'Activities']")
	WebElement opportunityDetailViewActivitiesLnk;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='opportunity_detail']/descendant::*[text() = 'Contacts']")
	WebElement opportunityDetailViewContactsLnk;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='opportunity_detail']/descendant::*[text() = 'Opportunities']")
	WebElement opportunityDetailViewOpportunitiesLnk;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='opportunity_detail']/descendant::*[text() = 'Tickets']")
	WebElement opportunityDetailViewTicketsLnk;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='opportunity_detail']/descendant::*[text() = 'Notes/History']")
	WebElement opportunityDetailViewOpportunityLnk;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='opportunity_detail']/descendant::*[text() = 'Addresses']")
	WebElement opportunityDetailViewAddressesLnk;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='opportunity_detail']/descendant::*[text() = 'Attachments']")
	WebElement opportunityDetailViewAttachmentsLnk;
		
	//Edit View elements
	@CacheLookup
	@FindBy(xpath = ".//*[@id='opportunity_edit']")
	WebElement opportunityEditView;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_TextField_14']/input")
	WebElement opportunityEditViewAccountInputFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_TextField_15']/input")
	WebElement opportunityEditViewWebInputFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_PhoneField_5']/input")
	WebElement opportunityEditViewPhoneInputFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Mobile_SalesLogix_Fields_AddressField_2']/div")
	WebElement opportunityEditViewAddressFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Mobile_SalesLogix_Fields_AddressField_2']/button")
	WebElement opportunityEditViewAddressFldBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_PhoneField_6']/input")
	WebElement opportunityEditViewFaxInputFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Mobile_SalesLogix_Fields_PicklistField_11']/input")
	WebElement opportunityEditViewTypeFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Mobile_SalesLogix_Fields_PicklistField_11']/button")
	WebElement opportunityEditViewTypeFldBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Mobile_SalesLogix_Fields_PicklistField_12']/input")
	WebElement opportunityEditViewSubTypeFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Mobile_SalesLogix_Fields_PicklistField_12']/button")
	WebElement opportunityEditViewSubTypeFldBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Mobile_SalesLogix_Fields_PicklistField_13']/input")
	WebElement opportunityEditViewStatusFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Mobile_SalesLogix_Fields_PicklistField_13']/button")
	WebElement opportunityEditViewStatusFldBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Mobile_SalesLogix_Fields_PicklistField_14']/input")
	WebElement opportunityEditViewIndustryFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Mobile_SalesLogix_Fields_PicklistField_14']/button")
	WebElement opportunityEditViewIndustryFldBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_NoteField_0']/div")
	WebElement opportunityEditViewBusDescFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_NoteField_0']/button")
	WebElement opportunityEditViewBusDescFldBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_LookupField_0']/input")
	WebElement opportunityEditViewAcctMgrFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_LookupField_0']/button")
	WebElement opportunityEditViewAcctMgrFldBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_LookupField_1']/input")
	WebElement opportunityEditViewOwnerFld;
	
	@CacheLookup
	@FindBy(xpath = ".//*[@id='Sage_Platform_Mobile_Fields_LookupField_1']/button")
	WebElement opportunityEditViewOwnerFldBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_LookupField_2']/input")
	WebElement opportunityEditViewLeadSourceFld;
	
	@CacheLookup
	@FindBy(xpath = ".//*[@id='Sage_Platform_Mobile_Fields_LookupField_2']/button")
	WebElement opportunityEditViewLeadSourceFldBtn;
	
	
	//Methods
	//-------
	public String getOpportunityListViewTxt() {
		String methodID = "getOpportunityListViewTxt";
		
		WebElement OpportunityLisViewInfo = driver.findElement(By.xpath("//*[@id='opportunity_list']/ul[2]"));
		
		return OpportunityLisViewInfo.getText();		
	}
	
	
	public boolean NoRecordsFound() {
		boolean result = false;
		
		return result;
	}
}
