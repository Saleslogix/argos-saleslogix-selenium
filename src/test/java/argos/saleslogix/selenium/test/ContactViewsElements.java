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
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_SearchWidget_3']/div/div[1]/input")
	WebElement contactsSearchTxtBox;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_SearchWidget_3']/div/div[2]/button")
	WebElement contactsSearchClearBtn;
	
	@CacheLookup
	@FindBy(xpath = ".//*[@id='Sage_Platform_Mobile_SearchWidget_3']/div/div[3]/button")
	WebElement contactsSearchLookupBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='contact_list']/ul")
	WebElement contactsListView;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='contact_list']/ul/li[1]")
	WebElement topcontactsListItem;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='contact_list']/ul/li[1]/button")
	WebElement topcontactsListItemIcon;	

	@CacheLookup
	@FindBy(xpath = "//*[@id='contact_list']/ul/li[1]/div/h3")
	WebElement topcontactsListItemName;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='contact_list']/ul/li[1]/div/h4[1]")
	WebElement topcontactsListItemLine2;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='contact_list']/ul/li[1]/div/h4[2]")
	WebElement topcontactsListItemLine3;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='contact_list']/ul/li[1]/div/h4[3]")
	WebElement topcontactsListItemLine4;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='contact_list']/ul/li[1]/div/h4[4]")
	WebElement topcontactsListItemLine5;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='contact_list']/ul/li[11]")
	WebElement eleventhcontactsListItem;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='contact_list']/ul/li[21]")
	WebElement twentyfirstcontactsListItem;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='contact_list']/ul/li[31]")
	WebElement thirtyfirstcontactsListItem;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='contact_list']/div[3]")
	WebElement recordsRemainingListItem;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='contact_list']/ul/li/h3")
	WebElement noRecordsListItem;
	
	//Detail View elements
	@CacheLookup
	@FindBy(xpath = "//*[@id='contact_detail']")
	WebElement countactDetailView;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='contact_detail']/div[2]/h2[1]")
	WebElement contactDetailViewQuickActionsHdr;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='contact_detail']/div[2]/ul[1]/li[1]/a")
	WebElement contactDetailViewCallMainNumberLnk;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='contact_detail']/div[2]/ul[1]/li[2]/a")
	WebElement contactDetailViewCallMobileLnk;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='contact_detail']/div[2]/ul[1]/li[3]/a")
	WebElement contactDetailViewSendEmailLnk;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='contact_detail']/div[2]/ul[1]/li[4]/a")
	WebElement contactDetailViewScheduleActivityLnk;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='contact_detail']/div[2]/ul[1]/li[5]/a")
	WebElement contactDetailViewAddNoteLnk;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='contact_detail']/div[2]/ul[1]/li[6]/a")
	WebElement contactDetailViewViewAddressLnk;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='contact_detail']/div[2]/h2[2]")
	WebElement contactDetailViewDetailsHdr;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='contact_detail']/div[2]/div[1]/div[1]")
	WebElement contactDetailViewContactFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='contact_detail']/div[2]/div[1]/div[2]")
	WebElement contactDetailViewAccountFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='contact_detail']/div[2]/div[1]/div[3]")
	WebElement contactDetailViewWebFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='contact_detail']/div[2]/div[1]/div[4]")
	WebElement contactDetailViewTitleFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='contact_detail']/div[2]/h2[3]")
	WebElement contactDetailViewMoreDetailsHdr;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='contact_detail']/div[2]/div[2]/div[1]")
	WebElement contactDetailViewHomePhoneFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='contact_detail']/div[2]/div[2]/div[2]")
	WebElement contactDetailViewFaxFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='contact_detail']/div[2]/div[2]/div[3]")
	WebElement contactDetailViewAcctMgrFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='contact_detail']/div[2]/div[2]/div[4]")
	WebElement contactDetailViewOwnerFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='contact_detail']/div[2]/div[2]/div[5]")
	WebElement contactDetailViewCuisineFld;

	@CacheLookup
	@FindBy(xpath = "//*[@id='contact_detail']/div[2]/h2[4]")
	WebElement contactDetailViewRelatedItemsHdr;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='contact_detail']/descendant::*[text() = 'Activities']")
	WebElement contactDetailViewActivitiesLnk;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='contact_detail']/descendant::*[text() = 'Contacts']")
	WebElement contactDetailViewContactsLnk;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='contact_detail']/descendant::*[text() = 'Opportunities']")
	WebElement contactDetailViewOpportunitiesLnk;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='contact_detail']/descendant::*[text() = 'Tickets']")
	WebElement contactDetailViewTicketsLnk;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='contact_detail']/descendant::*[text() = 'Notes/History']")
	WebElement contactDetailViewNotesHistoryLnk;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='contact_detail']/descendant::*[text() = 'Addresses']")
	WebElement contactDetailViewNotesAddressesLnk;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='contact_detail']/descendant::*[text() = 'Attachments']")
	WebElement contactDetailViewNotesAttachmentsLnk;
	
	
	//Edit View elements

	
	//Methods
	public boolean NoRecordsFound() {
		boolean result = false;
		
		return result;
	}
}
