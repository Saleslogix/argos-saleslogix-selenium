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


public class TicketViewsElements extends BrowserSetup {
	
	private WebDriver driver;

	public TicketViewsElements(WebDriver driver) {
		this.driver = driver;		
	}
	
	CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);

	//List View elements
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_SearchWidget_18']/div/div[1]/input")
	WebElement ticketsSearchTxtBox;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_SearchWidget_18']/div/div[2]/button")
	WebElement ticketsSearchClearBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_SearchWidget_18']/div/div[3]/button")
	WebElement ticketsSearchLookupBtn;

	@CacheLookup
	@FindBy(xpath = "//*[@id='ticket_list']")
	WebElement ticketsListViewPnl;

	@CacheLookup
	@FindBy(xpath = "//*[@id='ticket_list']/ul")
	WebElement ticketsListViewHdr;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='ticket_list']/ul")
	WebElement ticketsListView;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='ticket_list']/ul/li[1]")
	WebElement topTicketsListItem;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='ticket_list']/ul/li[1]/div[1]")
	WebElement topTicketsListItemTab;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='ticket_list']/ul/li[1]/button")
	WebElement topTicketsListItemIcon;	

	@CacheLookup
	@FindBy(xpath = "//*[@id='ticket_list']/ul/li[1]/div[3]/h3")
	WebElement topTicketsListItemNumber;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='ticket_list']/ul/li[1]/div[3]/h4[2]")
	WebElement topTicketsListItemLine2;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='ticket_list']/ul/li[1]/div[3]/h4[3]")
	WebElement topTicketsListItemLine3;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='ticket_list']/ul/li[1]/div[3]/h4[4]")
	WebElement topTicketsListItemLine4;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='ticket_list']/ul/li[1]/div[3]/h4[5]")
	WebElement topTicketsListItemLine5;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='bottom_item_indicators']/span/img")
	WebElement topTicketsListItemBtmIndicator;
	
	@CacheLookup
	@FindBy(css = "#ticket_list > ul.list-content > li > #bottom_item_indicators > span > img")
	WebElement topTicketsListItemTouch;
	
	@CacheLookup
	@FindBy(css = "#ticket_list > ul.list-content > li > #list-item-footer > div > button.footer-item-selector.button")
	WebElement topTicketsListItemQuickActionsBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='ticket_list']/ul/li[2]/button[6]")
	WebElement topTicketsListItemQuickActionsAddAttachmentBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='ticket_list']/ul/li[2]/button[5]")
	WebElement topTicketsListItemQuickActionsAddActivityBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='ticket_list']/ul/li[2]/button[4]")
	WebElement topTicketsListItemQuickActionsAddNoteBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='ticket_list']/ul/li[2]/button[3]")
	WebElement topTicketsListItemQuickActionsContactBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='ticket_list']/ul/li[2]/button[2]")
	WebElement topTicketsListItemQuickActionsAccountBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='ticket_list']/ul/li[2]/button[1]")
	WebElement topTicketsListItemQuickActionsEditBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='ticket_list']/ul[2]/li[11]")
	WebElement eleventhLeadsListItem;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='ticket_list']/ul[2]/li[21]")
	WebElement twentyfirstLeadsListItem;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='ticket_list']/ul[2]/li[31]")
	WebElement thirtyfirstLeadsListItem;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='ticket_list']/div[2]/div/span")
	WebElement recordsRemainingListItem;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='ticket_list']/ul[2]/li/h3")
	WebElement noRecordsListItem;
	
	//Context Menu elements
	@CacheLookup
	@FindBy(xpath = "//*[@id='right_drawer']/div[4]/h2[1]")
	WebElement ticketsHashTagsHdr;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='right_drawer']/div[4]/ul[1]")
	WebElement ticketsHashTagsPnl;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='right_drawer']/div[4]/h2[2]")
	WebElement ticketsKPIHdr;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='right_drawer']/div[4]/ul[2]")
	WebElement ticketsKPIPnl;
	
	//Detail View elements
	//TODO: the Ticket Edit fields need to be updated when needed
	@CacheLookup
	@FindBy(xpath = "//*[@id='ticket_detail']")
	WebElement ticketsDetailView;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='ticket_detail']/div[2]/h2[1]")
	WebElement ticketsDetailViewQuickActionsHdr;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='ticket_detail']/div[2]/ul[1]/li[1]/a")
	WebElement ticketsDetailViewCallMainNumberLnk;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='ticket_detail']/div[2]/ul[1]/li[2]/a")
	WebElement ticketsDetailViewScheduleActivityLnk;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='ticket_detail']/div[2]/ul[1]/li[3]/a")
	WebElement ticketsDetailViewAddNoteLnk;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='ticket_detail']/div[2]/ul[1]/li[4]/a")
	WebElement ticketsDetailViewViewAddressLnk;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='ticket_detail']/div[2]/h2[2]")
	WebElement ticketsDetailViewDetailsHdr;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='ticket_detail']/div[2]/div[1]/div[1]")
	WebElement ticketsDetailViewContactFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='ticket_detail']/div[2]/div[1]/div[2]")
	WebElement ticketsDetailViewWebFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='ticket_detail']/div[2]/div[1]/div[3]")
	WebElement ticketsDetailViewFaxFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='ticket_detail']/div[2]/div[1]/div[4]")
	WebElement ticketsDetailViewTypeFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='ticket_detail']/div[2]/div[1]/div[5]")
	WebElement ticketsDetailViewSubTypeFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='ticket_detail']/div[2]/div[1]/div[6]")
	WebElement ticketsDetailViewStatusFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='ticket_detail']/div[2]/h2[3]")
	WebElement ticketsDetailViewMoreDetailsHdr;
		
	@CacheLookup
	@FindBy(xpath = "//*[@id='ticket_detail']/div[2]/div[2]")
	WebElement ticketsDetailViewMoreDetailsFields;	
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='ticket_detail']/div[2]/div[2]/div[1]")
	WebElement ticketsDetailViewIndustryFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='ticket_detail']/div[2]/div[2]/div[2]")
	WebElement ticketsDetailViewBusDescFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='ticket_detail']/div[2]/div[2]/div[3]")
	WebElement ticketsDetailViewAcctMgrFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='ticket_detail']/div[2]/div[2]/div[4]")
	WebElement ticketsDetailViewOwnerFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='ticket_detail']/div[2]/div[2]/div[5]")
	WebElement ticketsDetailViewLeadSourceFld;

	@CacheLookup
	@FindBy(xpath = "//*[@id='ticket_detail']/div[2]/h2[4]")
	WebElement ticketsDetailViewRelatedItemsHdr;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='ticket_detail']/descendant::*[text() = 'Activities']")
	WebElement ticketsDetailViewActivitiesLnk;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='ticket_detail']/descendant::*[text() = 'Ticket Activities']")
	WebElement ticketsDetailViewTicketsActivitiesLnk;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='ticket_detail']/descendant::*[text() = 'Contacts']")
	WebElement ticketsDetailViewContactsLnk;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='ticket_detail']/descendant::*[text() = 'Opportunities']")
	WebElement ticketsDetailViewOpportunitiesLnk;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='ticket_detail']/descendant::*[text() = 'Tickets']")
	WebElement ticketsDetailViewTicketsLnk;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='ticket_detail']/descendant::*[text() = 'Notes/History']")
	WebElement ticketsDetailViewNotesHistoryLnk;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='ticket_detail']/descendant::*[text() = 'Addresses']")
	WebElement ticketsDetailViewAddressesLnk;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='ticket_detail']/descendant::*[text() = 'Attachments']")
	WebElement ticketsDetailViewAttachmentsLnk;
		
	//Edit View elements
	//TODO: the Lead Edit fields need to be updated when needed
	@CacheLookup
	@FindBy(xpath = "//*[@id='ticket_edit']")
	WebElement ticketsEditView;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_TextField_14']/input")
	WebElement ticketsEditViewContactInputFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_TextField_15']/input")
	WebElement ticketsEditViewWebInputFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_PhoneField_5']/input")
	WebElement ticketsEditViewPhoneInputFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Mobile_SalesLogix_Fields_AddressField_2']/div")
	WebElement ticketsEditViewAddressFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Mobile_SalesLogix_Fields_AddressField_2']/button")
	WebElement ticketsEditViewAddressFldBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_PhoneField_6']/input")
	WebElement ticketsEditViewFaxInputFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Mobile_SalesLogix_Fields_PicklistField_11']/input")
	WebElement ticketsEditViewTypeFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Mobile_SalesLogix_Fields_PicklistField_11']/button")
	WebElement ticketsEditViewTypeFldBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Mobile_SalesLogix_Fields_PicklistField_12']/input")
	WebElement ticketsEditViewSubTypeFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Mobile_SalesLogix_Fields_PicklistField_12']/button")
	WebElement ticketsEditViewSubTypeFldBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Mobile_SalesLogix_Fields_PicklistField_13']/input")
	WebElement ticketsEditViewStatusFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Mobile_SalesLogix_Fields_PicklistField_13']/button")
	WebElement ticketsEditViewStatusFldBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Mobile_SalesLogix_Fields_PicklistField_14']/input")
	WebElement ticketsEditViewIndustryFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Mobile_SalesLogix_Fields_PicklistField_14']/button")
	WebElement ticketsEditViewIndustryFldBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_NoteField_0']/div")
	WebElement ticketsEditViewBusDescFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_NoteField_0']/button")
	WebElement ticketsEditViewBusDescFldBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_LookupField_0']/input")
	WebElement ticketsEditViewAcctMgrFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_LookupField_0']/button")
	WebElement ticketsEditViewAcctMgrFldBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_LookupField_1']/input")
	WebElement ticketsEditViewOwnerFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_LookupField_1']/button")
	WebElement ticketsEditViewOwnerFldBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_LookupField_2']/input")
	WebElement ticketsEditViewLeadSourceFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_LookupField_2']/button")
	WebElement ticketsEditViewLeadSourceFldBtn;
	
	
	//Methods
	public String getTicketsListViewTxt() {
		String methodID = "getTicketsListViewTxt";
		String listViewTxt = "";
		
		try {
			WebElement ticketsListViewInfo = driver.findElement(By.xpath("//*[@id='ticket_list/ul']"));
			listViewTxt = ticketsListViewInfo.getText();
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
