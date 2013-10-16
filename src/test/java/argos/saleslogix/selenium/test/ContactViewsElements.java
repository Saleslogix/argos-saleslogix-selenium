package argos.saleslogix.selenium.test;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

import java.io.IOException;

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
	//------------------
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
	@FindBy(xpath = "//*[@id='contact_list']/ul")
	WebElement contactsListView;
	
	@CacheLookup
	@FindBy(xpath = "//div[7]/div[2]/div/button")
	WebElement contactsListView1stKPICard;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='contact_list_search-expression']/div")
	WebElement contactsListView1stHashTagFilter;
	
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='contact_list']/ul/li[1]")
	WebElement topContactsListItem;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='contact_list']/ul/li[1]/button")
	WebElement topContactsListItemIcon;	

	@CacheLookup
	@FindBy(xpath = "//*[@id='contact_list']/ul/li[1]/div[3]/h3")
	WebElement topContactsListItemName;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='contact_list']/ul/li[1]/div[3]/h4[1]")
	WebElement topContactsListItemLine2;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='contact_list']/ul/li[1]/div[3]/h4[3]")
	WebElement topContactsListItemLine3;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='contact_list']/ul/li[1]/div[3]/h4[4]")
	WebElement topContactsListItemLine4;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='contact_list']/ul/li[1]/div[3]/h4[5]")
	WebElement topContactsListItemLine5;
	
	@CacheLookup
	@FindBy(css = "#contact_list > ul.list-content > li > #bottom_item_indicators > span > img")
	WebElement topContactsListItemTouch;
	
	@CacheLookup
	@FindBy(css = "#contact_list > ul.list-content > li > #list-item-footer > div > button.footer-item-selector.button")
	WebElement topContactsListItemQuickActionsBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='contact_list']/ul/li[2]/button[8]")
	WebElement topContactsListItemQuickActionsAddAttachmentBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='contact_list']/ul/li[2]/button[7]")
	WebElement topContactsListItemQuickActionsAddActivityBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='contact_list']/ul/li[2]/button[6]")
	WebElement topContactsListItemQuickActionsAddNoteBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='contact_list']/ul/li[2]/button[5]")
	WebElement topContactsListItemQuickActionsEmailBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='contact_list']/ul/li[2]/button[4]")
	WebElement topContactsListItemQuickActionsAccountBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='contact_list']/ul/li[2]/button[3]")
	WebElement topContactsListItemQuickActionsCallMobileBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='contact_list']/ul/li[2]/button[2]")
	WebElement topContactsListItemQuickActionsCallWorkBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='contact_list']/ul/li[2]/button[1]")
	WebElement topContactsListItemQuickActionsEditBtn;
	
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
	@FindBy(xpath = "//*[@id='contact_list']/ul/li/h3")
	WebElement noRecordsListItem;
	
	//Context Menu elements
	//---------------------
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
	//------------------
	//TODO: the Contact Edit fields need to be updated when needed
	@CacheLookup
	@FindBy(xpath = "//*[@id='contact_edit']")
	WebElement contactsEditView;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Mobile_SalesLogix_Fields_PicklistField_16']/input")
	WebElement contactsEditViewCuisineFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Mobile_SalesLogix_Fields_PicklistField_16']/button")
	WebElement contactsEditViewCuisineFldBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_TextField_56']/input")
	WebElement contactsEditViewWebFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_PhoneField_7']/input")
	WebElement contactsEditViewPhoneFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Mobile_SalesLogix_Fields_AddressField_3']/div")
	WebElement contactsEditViewAddressFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Mobile_SalesLogix_Fields_AddressField_3']/button")
	WebElement contactsEditViewAddressFldBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_TextField_57']/input")
	WebElement contactsEditViewEmailFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_PhoneField_10']/input")
	WebElement contactsEditViewFaxFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Mobile_SalesLogix_Fields_PicklistField_15']/input")
	WebElement contactsEditViewTitleFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Mobile_SalesLogix_Fields_PicklistField_15']/button")
	WebElement contactsEditViewTitleFldBtn;
	
	@CacheLookup
	@FindBy(xpath = ".//*[@id='Sage_Platform_Mobile_Fields_PhoneField_8']/input")
	WebElement contactsEditViewHomePhoneFld;
	
	@CacheLookup
	@FindBy(xpath = ".//*[@id='Sage_Platform_Mobile_Fields_LookupField_25']/input")
	WebElement contactsEditViewAccountFld;
	
	@CacheLookup
	@FindBy(xpath = ".//*[@id='Sage_Platform_Mobile_Fields_LookupField_25']/button")
	WebElement contactsEditViewAccountFldBtn;
	
	@CacheLookup
	@FindBy(xpath = ".//*[@id='Sage_Platform_Mobile_Fields_LookupField_26']/input")
	WebElement contactsEditViewAcctMgrFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_LookupField_26']/button")
	WebElement contactsEditViewAcctMgrFldBtn;
	
	@CacheLookup
	@FindBy(xpath = ".//*[@id='Sage_Platform_Mobile_Fields_PhoneField_9']/input")
	WebElement contactsEditViewMobileFld;
	
	@CacheLookup
	@FindBy(xpath = ".//*[@id='Mobile_SalesLogix_Fields_NameField_1']/input")
	WebElement contactsEditViewNameFld;
	
	@CacheLookup
	@FindBy(xpath = ".//*[@id='Mobile_SalesLogix_Fields_NameField_1']/button")
	WebElement contactsEditViewNameFldBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_LookupField_27']/input")
	WebElement contactsEditViewOwnerFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_LookupField_27']/button")
	WebElement contactsEditViewOwnerFldBtn;
	
	//Methods
	//-------
	public String getContactsListViewTxt() {
		String methodID = "getContactsListViewTxt";
		String listViewTxt = "";
		
		try {
			WebElement contactsLisViewInfo = driver.findElement(By.xpath("//*[@id='contact_list']/ul"));
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


	//Methods
		//=======
		/**
		 * This method will add an auto-generated test Contact record by filling-in the Contact Edit input fields.
		 * The Contact will have a unique string appended to the Last Name in order to ensure uniqueness.
		 * @author	mike.llena@swiftpage.com
		 * @version	1.0
		 * @param	strContactLastName	contact last name to set
		 * @param	strContactFirstName	contact first name to set
		 * @param	strContactAccount	account record to associate this contact with
		 * @throws Exception 
		 */
		public void doAddRandTestContact(String strContactLastName, String strContactFirstName, String strContactAccount) throws Exception {
			String methodID = "doAddRandTestContact";
			
			CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
			HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);
			CommonViewsElements commView = PageFactory.initElements(driver, CommonViewsElements.class);
			
			System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
			
		    //Step: navigate to Contacts list view
			commNav.clickGlobalMenuItem("Contacts");
			
			//Step: click the Add header button to enter Contact edit view
			headerButton.clickHeaderButton("Add");
			
			//Step: setup new Contact field values
			//setup name fields		
			contactsEditViewNameFldBtn.click();
				//TEMP: disable Name Prefix selection in favor of direct input field value setting
				commView.namePrefixInputFld.sendKeys("Mr.");
				commView.nameFirstInputFld.sendKeys(strContactFirstName);
				commView.nameMiddleInputFld.sendKeys("Neo");
				commView.nameLastInputFld.sendKeys(strContactLastName);
				commView.nameSuffixInputFld.sendKeys("Sr.");
				headerButton.clickHeaderButton("check");
				
			//setup account field
			contactsEditViewAccountFldBtn.click();
				commNav.highlightNClick(commNav.entityListViewSelect("Accounts", strContactAccount));
			
			//conditionaly setup web field	
			if (commNav.isFieldValueEmpty("Web", contactsEditViewWebFld)) {
				contactsEditViewWebFld.sendKeys("www.saleslogix.com");
			}
			
			//conditionally setup phone field
			if (commNav.isFieldValueEmpty("Phone", contactsEditViewPhoneFld)) {
				contactsEditViewPhoneFld.sendKeys("888-867-5309");
			}
			
			//setup email field
			contactsEditViewEmailFld.sendKeys("theone@boguscompany.com");
			
			//setup title field
			contactsEditViewTitleFld.sendKeys("Principal");
			
			//conditionally setup address fields
			if (contactsEditViewAddressFld.getText().equals("")) {
				contactsEditViewAddressFldBtn.click();
				//TEMP disable selection views (doesn't work on Jenkins server)				
				commView.addressPrimaryTgl.click();
				commView.addressShippingTgl.click();
				commView.addressLine1.sendKeys("8800 Mobile St.");
				commView.addressLine2.sendKeys("Corporate Campus");
				commView.addressLine3.sendKeys("Suite 100");
				commView.addressCityInputFld.sendKeys("Phoenix");				
				commView.addressStateInputFld.sendKeys("AZ");				
				commView.addressPostalInputFld.sendKeys("85048");
				commView.addressCountryInputFld.sendKeys("USA");				
				commView.addressAttentionInputFld.sendKeys("Mr. Rogers");
				headerButton.clickHeaderButton("check");
			}				
			
			//setup home phone field
			contactsEditViewHomePhoneFld.sendKeys("(480)-867-5309");
			
			//setup mobile field
			contactsEditViewMobileFld.sendKeys("(602)-867-5309");

			//setup fax field
			contactsEditViewFaxFld.sendKeys("(866)-867-5309");
			
			//conditionally setup acct mgr field
			if (commNav.isFieldValueEmpty("Acct Mgr", contactsEditViewAcctMgrFld)) {
				contactsEditViewAcctMgrFldBtn.click();
				commNav.highlightNClick(commNav.entityListViewSearch("Users", "Hogan"));				
			}
			
			//conditionally setup owner field
			if (commNav.isFieldValueEmpty("Owner", contactsEditViewOwnerFld)) {
				//TEMP disable - doesn't work for Trinity DB
				contactsEditViewOwnerFld.sendKeys("Midwest");
			}
			
			//setup cuisine field
			contactsEditViewCuisineFldBtn.click();
				commView.selectFieldValListItem("Cuisine", "Chinese");
				headerButton.clickHeaderButton("check");
			
			//Step: save the new Contact field values
			commNav.waitForPage("Contact");
			headerButton.clickHeaderButton("save");
			commNav.waitForNotPage("Contact");
			
			System.out.println(methodID + ": Auto-test Contact - " +  strContactLastName + ", " + strContactLastName + " record was created under the '" + strContactAccount + "' Account.");
		}


		//TODO: finish doSearchAccount() method
		public boolean doSearchContact(String strContactName) throws InterruptedException, Exception {
			String methodID = "doSearchContact";
			
			CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
			HeaderButton headerbutton = PageFactory.initElements(driver, HeaderButton.class);
			CommonViewsElements commView = PageFactory.initElements(driver, CommonViewsElements.class);
				
		    //Step: search for then click to open Contact record detail view
			commNav.highlightNClick(commNav.entityListViewSearch("Contacts", strContactName));
			
			//Step: confirm Account record detail view is displayed
			if (commNav.waitForNotPage("Contacts")) {
				return true;
			}
			else {		
				return false;
			}
		}
}
