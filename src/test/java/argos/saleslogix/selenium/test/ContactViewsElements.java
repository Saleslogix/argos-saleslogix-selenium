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


public class ContactViewsElements extends BrowserSetup {
	
	private WebDriver driver;

	public ContactViewsElements(WebDriver driver) {
		this.driver = driver;		
	}
	
	CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);

	//List View elements
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_SearchWidget_6']/div/div[1]/input")
	WebElement contactsSearchTxtBox;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_SearchWidget_6']/div/div[2]/button")
	WebElement contactsSearchClearBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_SearchWidget_6']/div/div[3]/button")
	WebElement contactsSearchLookupBtn;

	@CacheLookup
	@FindBy(xpath = "//*[@id='contact_list']")
	WebElement contactsListViewPnl;

	@CacheLookup
	@FindBy(xpath = "//*[@id='contact_list']/ul")
	WebElement contactsListViewHdr;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Mobile_SalesLogix_Views_MetricWidget_1']/button")
	WebElement contactsListViewMetricsBox1;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='contact_list']/ul[2]")
	WebElement contactsListView;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='contact_list']/ul[2]/li[1]")
	WebElement topContactsListItem;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='contact_list']/ul[2]/li[1]/button")
	WebElement topContactsListItemIcon;	

	@CacheLookup
	@FindBy(xpath = "//*[@id='contact_list']/ul[2]/li[1]/div[3]/h3")
	WebElement topContactsListItemName;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='contact_list']/ul[2]/li[1]/div[3]/h4[1]")
	WebElement topContactsListItemLine2;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='contact_list']/ul[2]/li[1]/div[3]/h4[3]")
	WebElement topContactsListItemLine3;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='contact_list']/ul[2]/li[1]/div[3]/h4[4]")
	WebElement topContactsListItemLine4;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='contact_list']/ul[2]/li[1]/div[3]/h4[5]")
	WebElement topContactsListItemLine5;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='bottom_item_indicators']/span/img")
	WebElement topContactsListItemBtmIndicator;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='contact_list']/ul[2]/li[11]")
	WebElement eleventhContactsListItem;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='contact_list']/ul[2]/li[21]")
	WebElement twentyfirstContactsListItem;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='contact_list']/ul[2]/li[31]")
	WebElement thirtyfirstContactsListItem;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='contact_list']/div[2]/div/span")
	WebElement recordsRemainingListItem;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='contact_list']/ul[2]/li/h3")
	WebElement noRecordsListItem;
	
	//Context Menu elements
	@CacheLookup
	@FindBy(xpath = "//*[@id='right_drawer']/div[4]/h2[1]")
	WebElement contactsHashTagsHdr;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='right_drawer']/div[4]/ul[1]")
	WebElement contactsHashTagsPnl;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='right_drawer']/div[4]/h2[2]")
	WebElement contactsKPIHdr;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='right_drawer']/div[4]/ul[2]")
	WebElement contactsKPIPnl;
	
	//Detail View elements
	@CacheLookup
	@FindBy(xpath = "//*[@id='contact_detail']")
	WebElement contactsDetailView;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='contact_detail']/div[2]/h2[1]")
	WebElement contactsDetailViewQuickActionsHdr;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='contact_detail']/div[2]/ul[1]/li[1]/a")
	WebElement contactsDetailViewCallMainNumberLnk;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='contact_detail']/div[2]/ul[1]/li[2]/a")
	WebElement contactsDetailViewScheduleActivityLnk;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='contact_detail']/div[2]/ul[1]/li[3]/a")
	WebElement contactsDetailViewAddNoteLnk;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='contact_detail']/div[2]/ul[1]/li[4]/a")
	WebElement contactsDetailViewViewAddressLnk;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='contact_detail']/div[2]/h2[2]")
	WebElement contactsDetailViewDetailsHdr;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='contact_detail']/div[2]/div[1]/div[1]")
	WebElement contactsDetailViewContactFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='contact_detail']/div[2]/div[1]/div[2]")
	WebElement contactsDetailViewWebFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='contact_detail']/div[2]/div[1]/div[3]")
	WebElement contactsDetailViewFaxFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='contact_detail']/div[2]/div[1]/div[4]")
	WebElement contactsDetailViewTypeFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='contact_detail']/div[2]/div[1]/div[5]")
	WebElement contactsDetailViewSubTypeFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='contact_detail']/div[2]/div[1]/div[6]")
	WebElement contactsDetailViewStatusFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='contact_detail']/div[2]/h2[3]")
	WebElement contactsDetailViewMoreDetailsHdr;
		
	@CacheLookup
	@FindBy(xpath = "//*[@id='contact_detail']/div[2]/div[2]")
	WebElement contactsDetailViewMoreDetailsFields;	
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='contact_detail']/div[2]/div[2]/div[1]")
	WebElement contactsDetailViewIndustryFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='contact_detail']/div[2]/div[2]/div[2]")
	WebElement contactsDetailViewBusDescFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='contact_detail']/div[2]/div[2]/div[3]")
	WebElement contactsDetailViewAcctMgrFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='contact_detail']/div[2]/div[2]/div[4]")
	WebElement contactsDetailViewOwnerFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='contact_detail']/div[2]/div[2]/div[5]")
	WebElement contactsDetailViewLeadSourceFld;

	@CacheLookup
	@FindBy(xpath = "//*[@id='contact_detail']/div[2]/h2[4]")
	WebElement contactsDetailViewRelatedItemsHdr;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='contact_detail']/descendant::*[text() = 'Activities']")
	WebElement contactsDetailViewActivitiesLnk;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='contact_detail']/descendant::*[text() = 'Contacts']")
	WebElement contactsDetailViewContactsLnk;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='contact_detail']/descendant::*[text() = 'Opportunities']")
	WebElement contactsDetailViewOpportunitiesLnk;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='contact_detail']/descendant::*[text() = 'Tickets']")
	WebElement contactsDetailViewTicketsLnk;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='contact_detail']/descendant::*[text() = 'Notes/History']")
	WebElement contactsDetailViewNotesHistoryLnk;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='contact_detail']/descendant::*[text() = 'Addresses']")
	WebElement contactsDetailViewAddressesLnk;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='contact_detail']/descendant::*[text() = 'Attachments']")
	WebElement contactsDetailViewAttachmentsLnk;
		
	//Edit View elements
	//TODO: the Contact Edit fields need to be updated when needed
	@CacheLookup
	@FindBy(xpath = "//*[@id='contact_edit']")
	WebElement contactsEditView;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_TextField_14']/input")
	WebElement contactsEditViewContactInputFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_TextField_15']/input")
	WebElement contactsEditViewWebInputFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_PhoneField_5']/input")
	WebElement contactsEditViewPhoneInputFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Mobile_SalesLogix_Fields_AddressField_2']/div")
	WebElement contactsEditViewAddressFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Mobile_SalesLogix_Fields_AddressField_2']/button")
	WebElement contactsEditViewAddressFldBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_PhoneField_6']/input")
	WebElement contactsEditViewFaxInputFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Mobile_SalesLogix_Fields_PicklistField_11']/input")
	WebElement contactsEditViewTypeFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Mobile_SalesLogix_Fields_PicklistField_11']/button")
	WebElement contactsEditViewTypeFldBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Mobile_SalesLogix_Fields_PicklistField_12']/input")
	WebElement contactsEditViewSubTypeFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Mobile_SalesLogix_Fields_PicklistField_12']/button")
	WebElement contactsEditViewSubTypeFldBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Mobile_SalesLogix_Fields_PicklistField_13']/input")
	WebElement contactsEditViewStatusFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Mobile_SalesLogix_Fields_PicklistField_13']/button")
	WebElement contactsEditViewStatusFldBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Mobile_SalesLogix_Fields_PicklistField_14']/input")
	WebElement contactsEditViewIndustryFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Mobile_SalesLogix_Fields_PicklistField_14']/button")
	WebElement contactsEditViewIndustryFldBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_NoteField_0']/div")
	WebElement contactsEditViewBusDescFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_NoteField_0']/button")
	WebElement contactsEditViewBusDescFldBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_LookupField_0']/input")
	WebElement contactsEditViewAcctMgrFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_LookupField_0']/button")
	WebElement contactsEditViewAcctMgrFldBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_LookupField_1']/input")
	WebElement contactsEditViewOwnerFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_LookupField_1']/button")
	WebElement contactsEditViewOwnerFldBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_LookupField_2']/input")
	WebElement contactsEditViewLeadSourceFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_LookupField_2']/button")
	WebElement contactsEditViewLeadSourceFldBtn;
	
	
	//Methods
	public String getContactsListViewTxt() {
		String methodID = "getContactsListViewTxt";
		String listViewTxt = "";
		
		try {
			WebElement contactsLisViewInfo = driver.findElement(By.xpath("//*[@id='contact_list']"));
			listViewTxt = contactsLisViewInfo.getText();
		}
		catch (Exception excptn) {
			System.out.println(excptn.toString());
		}
		
		return listViewTxt;		
	}
	
	
	public boolean NoRecordsFound() {
		boolean result = false;
		
		return result;
	}
}
