package argos.saleslogix.selenium;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

import argos.saleslogix.selenium.CommonNavigation;
import argos.saleslogix.selenium.CommonViewsElements;
import argos.saleslogix.selenium.HeaderButton;
import org.openqa.selenium.*;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LeadViewsElements {
	
	private WebDriver driver;

	public LeadViewsElements(WebDriver driver) {
		this.driver = driver;		
	}
	
	CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);

	//List View elements
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_SearchWidget_16']/div/div[1]/input")
	public
    WebElement leadsSearchTxtBox;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_SearchWidget_16']/div/div[2]/button")
    public
    WebElement leadsSearchClearBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_SearchWidget_16']/div/div[3]/button")
    public
    WebElement leadsSearchLookupBtn;

	@CacheLookup
	@FindBy(xpath = "//*[@id='lead_list']")
	public
    WebElement leadsListViewPnl;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='itemsNode']")
	public
    WebElement leadsListViewNotesBox;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='itemsNode']/div[2]")
	public
    WebElement leadsListViewNotesBox1stItem;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='itemsNode']/div[2]/div/div[1]/div")
	public
    WebElement leadsListViewNotesBox1stItemInitialsBox;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='itemsNode']/div[2]/div/div[2]/h4[1]/strong")
	public
    WebElement leadsListViewNotesBox1stItemRegarding;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='itemsNode']/div[2]/div/div[2]/h4[2]")
	public
    WebElement leadsListViewNotesBox1stItemLastActivity;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='itemsNode']/div[2]/div/div[3]/div/h4")
	public
    WebElement leadsListViewNotesBox1stItemNotes;
	
	@CacheLookup
	@FindBy(xpath = "//div[2]/div[4]/div[2]")
	public
    WebElement leadsListViewNotesBoxSeeListLink;

	@CacheLookup
	@FindBy(xpath = "//*[@id='lead_list']/ul")
	public
    WebElement leadsListViewHdr;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='lead_list']/ul")
    public WebElement leadsListView;
	
	@CacheLookup
	@FindBy(xpath = "//div[6]/div[2]/div/button")
	public
    WebElement leadsListView1stKPICard;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='lead_list_search-expression']/div")
	public
    WebElement leadsListView1stHashTagFilter;

	
	@CacheLookup
	@FindBy(xpath = "//*[@id='lead_list']/ul/li[1]")
    public
    WebElement topLeadsListItem;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='lead_list']/ul/li[1]/div[1]")
    public
    WebElement topLeadsListItemTab;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='lead_list']/ul/li[1]/button")
    public
    WebElement topLeadsListItemIcon;

	@CacheLookup
	@FindBy(xpath = "//*[@id='lead_list']/ul/li[1]/div/h3")
    public
    WebElement topLeadsListItemName;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='lead_list']/ul/li[1]/div[3]/h4[1]")
    public
    WebElement topLeadsListItemLine2;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='lead_list']/ul/li[1]/div[3]/h4[2]")
    public
    WebElement topLeadsListItemLine3;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='lead_list']/ul/li[1]/div[3]/h4[3]")
    public
    WebElement topLeadsListItemLine4;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='lead_list']/ul/li[1]/div[3]/h4[4]")
    public
    WebElement topLeadsListItemLine5;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='bottom_item_indicators']/span/img")
	public
    WebElement topLeadsListItemBtmIndicator;
	
	@CacheLookup
	@FindBy(css = "#lead_list > ul.list-content > li > #bottom_item_indicators > span > img")
	public
    WebElement topLeadsListItemTouch;
	
	@CacheLookup
	@FindBy(css = "#lead_list > ul.list-content > li > #list-item-footer > div > button.footer-item-selector.button")
    public
    WebElement topLeadsListItemQuickActionsBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='lead_list']/ul/li[2]/button[7]")
    public
    WebElement topLeadsListItemQuickActionsAddAttachmentBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='lead_list']/ul/li[2]/button[6]")
    public
    WebElement topLeadsListItemQuickActionsAddActivityBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='lead_list']/ul/li[2]/button[5]")
    public
    WebElement topLeadsListItemQuickActionsAddNoteBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='lead_list']/ul/li[2]/button[4]")
    public
    WebElement topLeadsListItemQuickActionsEmailBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='lead_list']/ul/li[2]/button[3]")
    public
    WebElement topLeadsListItemQuickActionsCallMobileBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='lead_list']/ul/li[2]/button[2]")
    public
    WebElement topLeadsListItemQuickActionsCallWorkBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='lead_list']/ul/li[2]/button[1]")
    public
    WebElement topLeadsListItemQuickActionsEditBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='lead_list']/ul[2]/li[11]")
	public
    WebElement eleventhLeadsListItem;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='lead_list']/ul[2]/li[21]")
	public
    WebElement twentyfirstLeadsListItem;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='lead_list']/ul[2]/li[31]")
	public
    WebElement thirtyfirstLeadsListItem;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='lead_list']/div[2]/div/span")
	public
    WebElement recordsRemainingListItem;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='lead_list']/ul[2]/li/h3")
	public
    WebElement noRecordsListItem;
	
	//Context Menu elements
	@CacheLookup
	@FindBy(xpath = "//*[@id='right_drawer']/div[4]/h2[1]")
	public
    WebElement leadsHashTagsHdr;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='right_drawer']/div[4]/ul[1]")
	public
    WebElement leadsHashTagsPnl;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='right_drawer']/div[4]/h2[2]")
	public
    WebElement leadsKPIHdr;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='right_drawer']/div[4]/ul[2]")
	public
    WebElement leadsKPIPnl;
	
	//Detail View elements
	//TODO: the Lead Edit fields need to be updated when needed
	@CacheLookup
	@FindBy(xpath = "//*[@id='lead_detail']")
	public
    WebElement leadsDetailView;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='lead_detail']/div[2]/h2[1]")
    public
    WebElement leadsDetailViewQuickActionsHdr;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='lead_detail']/div[2]/ul[1]/li[1]/a")
    public
    WebElement leadsDetailViewCallMainNumberLnk;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='lead_detail']/div[2]/ul[1]/li[2]/a")
    public
    WebElement leadsDetailViewSendEmailLnk;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='lead_detail']/div[2]/ul[1]/li[3]/a")
    public
    WebElement leadsDetailViewScheduleActivityLnk;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='lead_detail']/div[2]/ul[1]/li[4]/a")
    public
    WebElement leadsDetailViewAddNoteLnk;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='lead_detail']/div[2]/ul[1]/li[5]/a")
    public
    WebElement leadsDetailViewViewAddressLnk;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='lead_detail']/div[2]/h2[2]")
    public
    WebElement leadsDetailViewDetailsHdr;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='lead_detail']/div[2]/div[1]/div[1]")
    public
    WebElement leadsDetailViewNameFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='lead_detail']/div[2]/div[1]/div[2]")
    public
    WebElement leadsDetailViewCompanyFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='lead_detail']/div[2]/div[1]/div[2]")
    public
    WebElement leadsDetailViewWebFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='lead_detail']/div[2]/div[1]/div[3]")
    public
    WebElement leadsDetailViewTitleFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='lead_detail']/div[2]/div[1]/div[4]")
    public
    WebElement leadsDetailViewWorkPhoneFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='lead_detail']/div[2]/div[1]/div[5]")
    public
    WebElement leadsDetailViewMobilePhoneFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='lead_detail']/div[2]/div[1]/div[6]")
    public
    WebElement leadsDetailViewTollFreeFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='lead_detail']/div[2]/div[1]/div[7]")
    public
    WebElement leadsDetailViewLeadSourceFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='lead_detail']/div[2]/h2[3]")
    public
    WebElement leadsDetailViewMoreDetailsHdr;
		
	@CacheLookup
	@FindBy(xpath = "//*[@id='lead_detail']/div[2]/div[2]")
    public
    WebElement leadsDetailViewMoreDetailsFields;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='lead_detail']/div[2]/div[2]/div[1]")
	WebElement leadsDetailViewInterestsFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='lead_detail']/div[2]/div[2]/div[2]")
    public
    WebElement leadsDetailViewIndustryFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='lead_detail']/div[2]/div[2]/div[3]")
    public
    WebElement leadsDetailViewSicCodeFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='lead_detail']/div[2]/div[2]/div[4]")
    public
    WebElement leadsDetailViewBusDescFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='lead_detail']/div[2]/div[2]/div[5]")
    public
    WebElement leadsDetailViewCommentsFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='lead_detail']/div[2]/div[2]/div[6]")
    public
    WebElement leadsDetailViewOwnerFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='lead_detail']/div[2]/h2[4]")
    public
    WebElement leadsDetailViewRelatedItemsHdr;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='lead_detail']/descendant::*[text() = 'Activities']")
    public
    WebElement leadsDetailViewActivitiesLnk;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='lead_detail']/descendant::*[text() = 'Notes/History']")
    public
    WebElement leadsDetailViewNotesHistoryLnk;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='lead_detail']/descendant::*[text() = 'Attachments']")
    public
    WebElement leadsDetailViewAttachmentsLnk;
		
	//Edit View elements
	//TODO: the Lead Edit fields need to be updated when needed
	@CacheLookup
	@FindBy(xpath = "//*[@id='lead_edit']")
	WebElement leadsEditView;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='lead_edit']/div[2]/h2")
    public
    WebElement leadsEditViewDetailsHdr;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Mobile_SalesLogix_Fields_NameField_0']/input")
	WebElement leadsEditViewNameInputFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Mobile_SalesLogix_Fields_NameField_0']/button")
    public
    WebElement leadsEditViewNameFldBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_TextField_2']/input")
    public
    WebElement leadsEditViewCompanyInputFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_TextField_3']/input")
    public
    WebElement leadsEditViewWebInputFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_PhoneField_0']/input")
    public
    WebElement leadsEditViewWorkPhoneInputFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_PhoneField_1']/input")
    public
	WebElement leadsEditViewMobilePhoneInputFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_PhoneField_2']/input")
	public
    WebElement leadsEditViewTollFreeInputFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_TextField_4']/input")
	public
    WebElement leadsEditViewEmailInputFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Mobile_SalesLogix_Fields_PicklistField_0']/input")
	public
    WebElement leadsEditViewTitleInputFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Mobile_SalesLogix_Fields_PicklistField_0']/button")
	public
    WebElement leadsEditViewTitleFldBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Mobile_SalesLogix_Fields_AddressField_0']/div")
	public
    WebElement leadsEditViewAddressInputFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Mobile_SalesLogix_Fields_AddressField_0']/button")
	public
    WebElement leadsEditViewAddressFldBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_LookupField_0']/input")
	public
    WebElement leadsEditViewLeadSourceInputFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_LookupField_0']/button")
	public
    WebElement leadsEditViewLeadSourceFldBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_TextField_5']/input")
	public
    WebElement leadsEditViewInterestsInputFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Mobile_SalesLogix_Fields_PicklistField_1']/input")
	public
    WebElement leadsEditViewIndustryInputFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Mobile_SalesLogix_Fields_PicklistField_1']/button")
	public
    WebElement leadsEditViewIndustryFldBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_TextField_6']/input")
	public
    WebElement leadsEditViewSicCodeInputFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_NoteField_0']/textarea")
	public
    WebElement leadsEditViewBusDescInputFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_NoteField_1']/textarea")
	public
    WebElement leadsEditViewCommentsInputFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_NoteField_1']/textarea")
	public
    WebElement leadsEditViewCommentsFldBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_LookupField_1']/input")
	public
    WebElement leadsEditViewOwnerInputFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_LookupField_1']/button")
	public
    WebElement leadsEditViewOwnerFldBtn;
	
		
	//Methods
	public String getLeadsListViewTxt() {
		String methodID = "getLeadsListViewTxt";
		String listViewTxt = "";
		
		try {
			WebElement leadsLisViewInfo = driver.findElement(By.xpath("//*[@id='lead_list']/ul"));
			listViewTxt = leadsLisViewInfo.getText();
		}
		catch (Exception e) {
			System.out.println(methodID + "(): " + e.toString());
		}
		
		return listViewTxt;		
	}
	
	
	public boolean NoRecordsFound() {
		boolean result = false;
		
		return result;
	}

	
	/**
	 * This method will add an auto-generated test Lead record by filling-in the Lead Edit input fields.
	 * The Lead will have a unique string appended to the Last Name in order to ensure uniqueness.
	 * @param	strLeadLastName	lead last name to set
	 * @param	strLeadFirstName	lead first name to set
	 * @param	strLeadCompany	company name for lead
	 * @throws Exception 
	 */
	public void doAddRandTestLead(String strLeadLastName, String strLeadFirstName, String strLeadCompany) throws Exception {
		String methodID = "doAddRandTestLead";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);
		CommonViewsElements commView = PageFactory.initElements(driver, CommonViewsElements.class);
		
	    //Step: navigate to Leads list view
		commNav.clickGlobalMenuItemLeads();
		
		//Step: click the Add header button to enter Lead edit view
		headerButton.clickAdd();
		
		//Step: setup new Lead field values
		//setup name fields		
		leadsEditViewNameFldBtn.click();
		try {
			//TEMP: disable Name Prefix selection in favor of direct input field value setting
			commView.namePrefixInputFld.sendKeys("Mr.");
			commView.nameFirstInputFld.sendKeys(strLeadFirstName);
			commView.nameMiddleInputFld.sendKeys("Neo");
			commView.nameLastInputFld.sendKeys(strLeadLastName);
			//commView.nameSuffixInputFld.sendKeys("Jr.");
			headerButton.clickCheck();
		}
		catch (Exception e0) {
			System.out.println(methodID + "(): " + e0.toString());
			headerButton.goBack();
		}
			
		//setup company field
		leadsEditViewCompanyInputFld.sendKeys(strLeadCompany);
		
		//setup web field
		leadsEditViewWebInputFld.sendKeys("www.saleslogix.com");
		
		//setup work phone field
		leadsEditViewWorkPhoneInputFld.sendKeys("888-867-5309");
		
		//setup mobile phone field
		leadsEditViewMobilePhoneInputFld.sendKeys("408-867-5309");
		
		//setup toll free field
		leadsEditViewMobilePhoneInputFld.sendKeys("800-867-5309");
		
		//setup email field
		leadsEditViewEmailInputFld.sendKeys("aturing@fakemail.com");
		
		//setup title field
		leadsEditViewTitleInputFld.sendKeys("CEO");
		
		//conditionally setup address fields
		if (leadsEditViewAddressInputFld.getText().equals("")) {
			leadsEditViewAddressFldBtn.click();
			try {
				//TEMP disable selection views (doesn't work on Jenkins server)
				commView.addressDescriptionInputFld.sendKeys("Mailing");
				commView.addressPrimaryTgl.click();
				commView.addressShippingTgl.click();
				commView.addressLine1.sendKeys("8800 Mobile St.");
				commView.addressLine2.sendKeys("Corporate Campus");
				commView.addressLine3.sendKeys("Suite 200");
				commView.addressCityInputFld.sendKeys("Phoenix");				
				commView.addressStateInputFld.sendKeys("AZ");				
				commView.addressPostalInputFld.sendKeys("85048");
				commView.addressCountryInputFld.sendKeys("USA");				
				commView.addressAttentionInputFld.sendKeys("Mrs. Rogers");
				headerButton.clickCheck();
			}
			catch (Exception e1) {
				System.out.println(methodID + "(): " + e1.toString());
				headerButton.goBack();
			}
		}				
		
		//setup lead source field
		leadsEditViewLeadSourceFldBtn.click();
			commView.lookupNSelectListItem("Lead Sources", "Web - General");
		
		//setup interests field
		leadsEditViewInterestsInputFld.sendKeys("automated test");
	
		//setup industry field
		leadsEditViewIndustryInputFld.sendKeys("Computers/Electronics/High Tech");
		//leadsEditViewIndustryFldBtn.click();
		//	commView.selectFieldValListItem("Industry", "Computers/Electronics/High Tech");
		//	headerButton.clickCheck();
		
		//setup sic code field
		leadsEditViewSicCodeInputFld.sendKeys("51CC0D3");			
		
		//setup business desc field
		leadsEditViewBusDescInputFld.sendKeys("automated test lead entity record");
		
		//setup comments field
		leadsEditViewCommentsInputFld.sendKeys("automated test lead entity record");
		
		//setup owner field
		leadsEditViewOwnerFldBtn.click();
			commView.lookupNSelectListItem("Owners", "Everyone");
		
		//Step: save the new Lead field values
		commNav.waitForPage("Lead");
		headerButton.clickSave();
		commNav.waitForNotPage("Lead");
		
		System.out.println(methodID + ": Auto-test Lead - " +  strLeadLastName + ", " + strLeadLastName + " record was created.");
	}


	public boolean doSearchLead(String strLeadName) throws InterruptedException, Exception {
		String methodID = "doSearchLead";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerbutton = PageFactory.initElements(driver, HeaderButton.class);
		CommonViewsElements commView = PageFactory.initElements(driver, CommonViewsElements.class);
			
	    //Step: search for then click to open Lead record detail view
		commNav.highlightNClick(commNav.entityListViewSearch("Leads", strLeadName));
		
		//Step: confirm Lead record detail view is displayed
		if (commNav.waitForNotPage("Leads")) {
			return true;
		}
		else {		
			return false;
		}
	}
}
