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


public class AccountViewsElements extends BrowserSetup {
	
	private WebDriver driver;

	public AccountViewsElements(WebDriver driver) {
		this.driver = driver;		
	}
	
	CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);

	//List View elements
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_SearchWidget_3']/div/div[1]/input")
	WebElement accountsSearchTxtBox;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_SearchWidget_3']/div/div[2]/button")
	WebElement accountsSearchClearBtn;
	
	@CacheLookup
	@FindBy(xpath = ".//*[@id='Sage_Platform_Mobile_SearchWidget_3']/div/div[3]/button")
	WebElement accountsSearchLookupBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='account_list']/ul")
	WebElement accountsListView;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='account_list']/ul/li[1]")
	WebElement topAccountsListItem;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='account_list']/ul/li[1]/button")
	WebElement topAccountsListItemIcon;	

	@CacheLookup
	@FindBy(xpath = "//*[@id='account_list']/ul/li[1]/div/h3")
	WebElement topAccountsListItemName;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='account_list']/ul/li[1]/div/h4[1]")
	WebElement topAccountsListItemLine2;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='account_list']/ul/li[1]/div/h4[2]")
	WebElement topAccountsListItemLine3;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='account_list']/ul/li[1]/div/h4[3]")
	WebElement topAccountsListItemLine4;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='account_list']/ul/li[1]/div/h4[4]")
	WebElement topAccountsListItemLine5;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='account_list']/ul/li[11]")
	WebElement eleventhAccountsListItem;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='account_list']/ul/li[21]")
	WebElement twentyfirstAccountsListItem;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='account_list']/ul/li[31]")
	WebElement thirtyfirstAccountsListItem;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='account_list']/div[2]")
	WebElement recordsRemainingListItem;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='account_list']/ul/li/h3")
	WebElement noRecordsListItem;
	
	//Context Menu elements
	@CacheLookup
	@FindBy(xpath = "//*[@id='right_drawer']/div[4]/h2[1]")
	WebElement accountHashTagsHdr;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='right_drawer']/div[4]/ul[1]")
	WebElement accountHashTagsPnl;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='right_drawer']/div[4]/h2[2]")
	WebElement accountKPIHdr;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='right_drawer']/div[4]/ul[2]")
	WebElement accountKPIPnl;
	
	//Detail View elements
	@CacheLookup
	@FindBy(xpath = "//*[@id='account_detail']")
	WebElement accountDetailView;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='account_detail']/div[2]/h2[1]")
	WebElement accountDetailViewQuickActionsHdr;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='account_detail']/div[2]/ul[1]/li[1]/a")
	WebElement accountDetailViewCallMainNumberLnk;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='account_detail']/div[2]/ul[1]/li[2]/a")
	WebElement accountDetailViewScheduleActivityLnk;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='account_detail']/div[2]/ul[1]/li[3]/a")
	WebElement accountDetailViewAddNoteLnk;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='account_detail']/div[2]/ul[1]/li[4]/a")
	WebElement accountDetailViewViewAddressLnk;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='account_detail']/div[2]/h2[2]")
	WebElement accountDetailViewDetailsHdr;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='account_detail']/div[2]/div[1]/div[1]")
	WebElement accountDetailViewAccountFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='account_detail']/div[2]/div[1]/div[2]")
	WebElement accountDetailViewWebFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='account_detail']/div[2]/div[1]/div[3]")
	WebElement accountDetailViewFaxFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='account_detail']/div[2]/div[1]/div[4]")
	WebElement accountDetailViewTypeFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='account_detail']/div[2]/div[1]/div[5]")
	WebElement accountDetailViewSubTypeFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='account_detail']/div[2]/div[1]/div[6]")
	WebElement accountDetailViewStatusFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='account_detail']/div[2]/h2[3]")
	WebElement accountDetailViewMoreDetailsHdr;
		
	@CacheLookup
	@FindBy(xpath = "//*[@id='account_detail']/div[2]/div[2]")
	WebElement accountDetailViewMoreDetailsFields;	
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='account_detail']/div[2]/div[2]/div[1]")
	WebElement accountDetailViewIndustryFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='account_detail']/div[2]/div[2]/div[2]")
	WebElement accountDetailViewBusDescFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='account_detail']/div[2]/div[2]/div[3]")
	WebElement accountDetailViewAcctMgrFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='account_detail']/div[2]/div[2]/div[4]")
	WebElement accountDetailViewOwnerFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='account_detail']/div[2]/div[2]/div[5]")
	WebElement accountDetailViewLeadSourceFld;

	@CacheLookup
	@FindBy(xpath = "//*[@id='account_detail']/div[2]/h2[4]")
	WebElement accountDetailViewRelatedItemsHdr;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='account_detail']/descendant::*[text() = 'Activities']")
	WebElement accountDetailViewActivitiesLnk;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='account_detail']/descendant::*[text() = 'Contacts']")
	WebElement accountDetailViewContactsLnk;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='account_detail']/descendant::*[text() = 'Opportunities']")
	WebElement accountDetailViewOpportunitiesLnk;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='account_detail']/descendant::*[text() = 'Tickets']")
	WebElement accountDetailViewTicketsLnk;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='account_detail']/descendant::*[text() = 'Notes/History']")
	WebElement accountDetailViewNotesHistoryLnk;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='account_detail']/descendant::*[text() = 'Addresses']")
	WebElement accountDetailViewAddressesLnk;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='account_detail']/descendant::*[text() = 'Attachments']")
	WebElement accountDetailViewAttachmentsLnk;
		
	//Edit View elements
	@CacheLookup
	@FindBy(xpath = ".//*[@id='account_edit']")
	WebElement accountEditView;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_TextField_14']/input")
	WebElement accountEditViewAccountInputFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_TextField_15']/input")
	WebElement accountEditViewWebInputFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_PhoneField_5']/input")
	WebElement accountEditViewPhoneInputFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Mobile_SalesLogix_Fields_AddressField_2']/div")
	WebElement accountEditViewAddressFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Mobile_SalesLogix_Fields_AddressField_2']/button")
	WebElement accountEditViewAddressFldBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_PhoneField_6']/input")
	WebElement accountEditViewFaxInputFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Mobile_SalesLogix_Fields_PicklistField_11']/input")
	WebElement accountEditViewTypeFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Mobile_SalesLogix_Fields_PicklistField_11']/button")
	WebElement accountEditViewTypeFldBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Mobile_SalesLogix_Fields_PicklistField_12']/input")
	WebElement accountEditViewSubTypeFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Mobile_SalesLogix_Fields_PicklistField_12']/button")
	WebElement accountEditViewSubTypeFldBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Mobile_SalesLogix_Fields_PicklistField_13']/input")
	WebElement accountEditViewStatusFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Mobile_SalesLogix_Fields_PicklistField_13']/button")
	WebElement accountEditViewStatusFldBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Mobile_SalesLogix_Fields_PicklistField_14']/input")
	WebElement accountEditViewIndustryFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Mobile_SalesLogix_Fields_PicklistField_14']/button")
	WebElement accountEditViewIndustryFldBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_NoteField_0']/div")
	WebElement accountEditViewBusDescFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_NoteField_0']/button")
	WebElement accountEditViewBusDescFldBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_LookupField_0']/input")
	WebElement accountEditViewAcctMgrFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_LookupField_0']/button")
	WebElement accountEditViewAcctMgrFldBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_LookupField_1']/input")
	WebElement accountEditViewOwnerFld;
	
	@CacheLookup
	@FindBy(xpath = ".//*[@id='Sage_Platform_Mobile_Fields_LookupField_1']/button")
	WebElement accountEditViewOwnerFldBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_LookupField_2']/input")
	WebElement accountEditViewLeadSourceFld;
	
	@CacheLookup
	@FindBy(xpath = ".//*[@id='Sage_Platform_Mobile_Fields_LookupField_2']/button")
	WebElement accountEditViewLeadSourceFldBtn;
	
	
	//Methods
	public String getAccountsListViewTxt() {
		String methodID = "getAccountsListViewTxt";
		
		WebElement accountsLisViewInfo = driver.findElement(By.xpath("//*[@id='account_list']"));
		
		return accountsLisViewInfo.getText();		
	}
	
	
	public boolean NoRecordsFound() {
		boolean result = false;
		
		return result;
	}
}
