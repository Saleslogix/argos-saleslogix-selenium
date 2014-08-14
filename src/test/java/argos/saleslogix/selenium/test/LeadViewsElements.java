package argos.saleslogix.selenium.test;

import org.openqa.selenium.*;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


/**
 * Test class that defines WebElements and methods for Lead entity based tests against the SLX Mobile Client.
 * 
 * @author	mike.llena@swiftpage.com
 * @version	1.0
 */
public class LeadViewsElements extends BaseTest {
	
	private WebDriver driver;

	public LeadViewsElements(WebDriver driver) {
		this.driver = driver;		
	}
	
	CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);

	//List View elements
	@CacheLookup
	@FindBy(xpath = "//*[@selected='true']//input[@name='query']")
	WebElement leadsSearchTxtBox;
	
	@CacheLookup
	@FindBy(xpath = "//*[@selected='true']//button[@class='clear-button']")
	WebElement leadsSearchClearBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@selected='true']//button[@class='subHeaderButton searchButton']")
	WebElement leadsSearchLookupBtn;

	@CacheLookup
	@FindBy(xpath = "//*[@id='lead_list']")
	WebElement leadsListViewPnl;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='itemsNode']")
	WebElement leadsListViewNotesBox;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='itemsNode']/div[2]")
	WebElement leadsListViewNotesBox1stItem;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='itemsNode']/div[2]/div/div[1]/div")
	WebElement leadsListViewNotesBox1stItemInitialsBox;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='itemsNode']/div[2]/div/div[2]/h4[1]/strong")
	WebElement leadsListViewNotesBox1stItemRegarding;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='itemsNode']/div[2]/div/div[2]/h4[2]")
	WebElement leadsListViewNotesBox1stItemLastActivity;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='itemsNode']/div[2]/div/div[3]/div/h4")
	WebElement leadsListViewNotesBox1stItemNotes;
	
	@CacheLookup
	@FindBy(xpath = "//div[2]/div[4]/div[2]")
	WebElement leadsListViewNotesBoxSeeListLink;

	@CacheLookup
	@FindBy(xpath = "//*[@id='lead_list']//ul")
	WebElement leadsListViewHdr;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='lead_list']//ul")
	WebElement leadsListView;
	
	@CacheLookup
	@FindBy(xpath = "//div[7]/div[2]/div/div/button")
	WebElement leadsListView1stKPICard;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='lead_list_search-expression']/div")
	WebElement leadsListView1stHashTagFilter;

	@CacheLookup
	@FindBy(xpath = "//*[@id='lead_list']//ul//li[1]")
	WebElement topLeadsListItem;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='lead_list']//ul/li[1]/div[1]")
	WebElement topLeadsListItemTab;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='lead_list']//ul/li[1]/button")
	WebElement topLeadsListItemIcon;

    @CacheLookup
    @FindBy(xpath = "//*[@id='lead_list']//ul/li[1]/div/h3[1]")
    WebElement topLeadsListItemName;

    @CacheLookup
    @FindBy(xpath = "//*[@id='lead_list']//ul/li[1]/div/h4[1]")
    WebElement topLeadsListItemLine2;

    @CacheLookup
    @FindBy(xpath = "//*[@id='lead_list']//ul/li[1]/div/h4[2]")
    WebElement topLeadsListItemLine3;

    @CacheLookup
    @FindBy(xpath = "//*[@id='lead_list']//ul/li[1]/div/h4[3]")
    WebElement topLeadsListItemLine4;

    @CacheLookup
    @FindBy(xpath = "//*[@id='lead_list']//ul/li[1]/div/h4[4]")
    WebElement topLeadsListItemLine5;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='bottom_item_indicators']/span/img")
	WebElement topLeadsListItemBtmIndicator;
	
	@CacheLookup
	//@FindBy(css = "#lead_list > ul.list-content > li > #bottom_item_indicators > span > img")
    @FindBy(xpath = "//*[@id='bottom_item_indicators']/span/img")
	WebElement topLeadsListItemTouch;
	
	@CacheLookup
	//@FindBy(css = "#lead_list > ul.list-content > li > #list-item-footer > div > button.footer-item-selector.button")
    @FindBy(xpath = "//*[@id='list-item-footer']/div/button")
	WebElement topLeadsListItemQuickActionsBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='lead_list']//ul/li[2]/button[7]")
	WebElement topLeadsListItemQuickActionsAddAttachmentBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='lead_list']//ul/li[2]/button[6]")
	WebElement topLeadsListItemQuickActionsAddActivityBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='lead_list']//ul/li[2]/button[5]")
	WebElement topLeadsListItemQuickActionsAddNoteBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='lead_list']//ul/li[2]/button[4]")
	WebElement topLeadsListItemQuickActionsEmailBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='lead_list']//ul/li[2]/button[3]")
	WebElement topLeadsListItemQuickActionsCallMobileBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='lead_list']//ul/li[2]/button[2]")
	WebElement topLeadsListItemQuickActionsCallWorkBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='lead_list']//ul/li[2]/button[1]")
	WebElement topLeadsListItemQuickActionsEditBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='lead_list']//ul[2]/li[11]")
	WebElement eleventhLeadsListItem;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='lead_list']//ul[2]/li[21]")
	WebElement twentyfirstLeadsListItem;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='lead_list']//ul[2]/li[31]")
	WebElement thirtyfirstLeadsListItem;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='lead_list']/div[2]/div/span")
	WebElement recordsRemainingListItem;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='lead_list']//ul[2]/li/h3")
	WebElement noRecordsListItem;
	
	//Context Menu elements
	@CacheLookup
	@FindBy(xpath = "//*[@id='right_drawer']/div[3]/h2[2]")
	WebElement leadsHashTagsHdr;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='right_drawer']//ul[@data-group='view']")
	WebElement leadsHashTagsPnl;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='right_drawer']/div[3]/h2[2]")
	WebElement leadsKPIHdr;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='right_drawer']//ul[@data-group='kpi']")
	WebElement leadsKPIPnl;
	
	//Detail View elements
	//TODO: the Lead Edit fields need to be updated when needed
	@CacheLookup
	@FindBy(xpath = "//*[@id='lead_detail']")
	WebElement leadsDetailView;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='lead_detail']/div[2]/h2[1]")
	WebElement leadsDetailViewQuickActionsHdr;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='lead_detail']/div[2]/ul[1]/li[1]/a")
	WebElement leadsDetailViewCallMainNumberLnk;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='lead_detail']/div[2]/ul[1]/li[2]/a")
	WebElement leadsDetailViewSendEmailLnk;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='lead_detail']/div[2]/ul[1]/li[3]/a")
	WebElement leadsDetailViewScheduleActivityLnk;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='lead_detail']/div[2]/ul[1]/li[4]/a")
	WebElement leadsDetailViewAddNoteLnk;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='lead_detail']/div[2]/ul[1]/li[5]/a")
	WebElement leadsDetailViewViewAddressLnk;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='lead_detail']/div[2]/h2[2]")
	WebElement leadsDetailViewDetailsHdr;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='lead_detail']/div[2]/div[1]/div[1]")
	WebElement leadsDetailViewNameFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='lead_detail']/div[2]/div[1]/div[2]")
	WebElement leadsDetailViewCompanyFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='lead_detail']/div[2]/div[1]/div[3]")
	WebElement leadsDetailViewWebFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='lead_detail']/div[2]/div[1]/div[4]")
	WebElement leadsDetailViewTitleFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='lead_detail']/div[2]/div[1]/div[5]")
	WebElement leadsDetailViewWorkPhoneFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='lead_detail']/div[2]/div[1]/div[6]")
	WebElement leadsDetailViewMobilePhoneFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='lead_detail']/div[2]/div[1]/div[7]")
	WebElement leadsDetailViewTollFreeFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='lead_detail']/div[2]/div[1]/div[8]")
	WebElement leadsDetailViewLeadSourceFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='lead_detail']/div[2]/h2[3]")
	WebElement leadsDetailViewMoreDetailsHdr;
		
	@CacheLookup
	@FindBy(xpath = "//*[@id='lead_detail']/div[2]/div[2]")
	WebElement leadsDetailViewMoreDetailsFields;	
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='lead_detail']/div[2]/div[2]/div[1]")
	WebElement leadsDetailViewInterestsFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='lead_detail']/div[2]/div[2]/div[2]")
	WebElement leadsDetailViewIndustryFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='lead_detail']/div[2]/div[2]/div[3]")
	WebElement leadsDetailViewSicCodeFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='lead_detail']/div[2]/div[2]/div[4]")
	WebElement leadsDetailViewBusDescFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='lead_detail']/div[2]/div[2]/div[5]")
	WebElement leadsDetailViewCommentsFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='lead_detail']/div[2]/div[2]/div[6]")
	WebElement leadsDetailViewOwnerFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='lead_detail']/div[2]/h2[4]")
	WebElement leadsDetailViewRelatedItemsHdr;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='lead_detail']/descendant::*[text() = 'Activities']")
	WebElement leadsDetailViewActivitiesLnk;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='lead_detail']/descendant::*[text() = 'Notes/History']")
	WebElement leadsDetailViewNotesHistoryLnk;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='lead_detail']/descendant::*[text() = 'Attachments']")
	WebElement leadsDetailViewAttachmentsLnk;
		
	//Edit View elements
	//TODO: the Lead Edit fields need to be updated when needed
	@CacheLookup
	@FindBy(xpath = "//*[@id='lead_edit']")
	WebElement leadsEditView;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='lead_edit']/div[2]/h2")
	WebElement leadsEditViewDetailsHdr;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Mobile_SalesLogix_Fields_NameField_0']/input")
	WebElement leadsEditViewNameInputFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Mobile_SalesLogix_Fields_NameField_0']/button")
	WebElement leadsEditViewNameFldBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_TextField_2']/input")
	WebElement leadsEditViewCompanyInputFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_TextField_3']/input")
	WebElement leadsEditViewWebInputFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_PhoneField_0']/input")
	WebElement leadsEditViewWorkPhoneInputFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_PhoneField_1']/input")
	WebElement leadsEditViewMobilePhoneInputFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_PhoneField_2']/input")
	WebElement leadsEditViewTollFreeInputFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_TextField_4']/input")
	WebElement leadsEditViewEmailInputFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Mobile_SalesLogix_Fields_PicklistField_0']/input")
	WebElement leadsEditViewTitleInputFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Mobile_SalesLogix_Fields_PicklistField_0']/button")
	WebElement leadsEditViewTitleFldBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Mobile_SalesLogix_Fields_AddressField_0']/div")
	WebElement leadsEditViewAddressInputFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Mobile_SalesLogix_Fields_AddressField_0']/button")
	WebElement leadsEditViewAddressFldBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_LookupField_0']/input")
	WebElement leadsEditViewLeadSourceInputFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_LookupField_0']/button")
	WebElement leadsEditViewLeadSourceFldBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_TextField_5']/input")
	WebElement leadsEditViewInterestsInputFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Mobile_SalesLogix_Fields_PicklistField_1']/input")
	WebElement leadsEditViewIndustryInputFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Mobile_SalesLogix_Fields_PicklistField_1']/button")
	WebElement leadsEditViewIndustryFldBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_TextField_6']/input")
	WebElement leadsEditViewSicCodeInputFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_NoteField_0']/textarea")
	WebElement leadsEditViewBusDescInputFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_NoteField_1']/textarea")
	WebElement leadsEditViewCommentsInputFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_NoteField_1']/textarea")
	WebElement leadsEditViewCommentsFldBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_LookupField_1']/input")
	WebElement leadsEditViewOwnerInputFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_LookupField_1']/button")
	WebElement leadsEditViewOwnerFldBtn;


		
	//Methods
	//=======
	/**
	 * This method will return a String that represents the contents of the Leads list view. 
	 * 
	 * @param N/A
	 * @throws InterruptedException, Exception 
	 */
	public String getLeadsListViewTxt() {
		String methodID = "getLeadsListViewTxt";
		String listViewTxt = "";
		
		try {
			WebElement leadsLisViewInfo = driver.findElement(By.xpath("//*[@id='lead_list']//ul"));
			listViewTxt = leadsLisViewInfo.getText();
		}
		catch (Exception e) {
			System.out.println(methodID + "(): " + e.toString());
		}
		
		return listViewTxt;		
	}

	
	/**
	 * This method will add an auto-generated test Lead record by filling-in the Lead Edit input fields.
	 * The Lead will have a unique string appended to the Last Name in order to ensure uniqueness.
	 * 
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
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
		
	    //Step: navigate to Leads list view
		commNav.clickGlobalMenuItem("Leads");
		
		//Step: click the Add header button to enter Lead edit view
		headerButton.clickHeaderButton("Add");
		
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
			headerButton.clickHeaderButton("check");
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
				headerButton.clickHeaderButton("check");
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
		//	headerButton.clickHeaderButton("check");
		
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
		headerButton.clickHeaderButton("save");
		commNav.waitForNotPage("Lead");
		
		System.out.println(methodID + ": Auto-test Lead - " +  strLeadLastName + ", " + strLeadLastName + " record was created.");
	}


	/**
	 * This method will return a boolean value if a search for a specific Lead record from the Leads 
	 * list view.  
	 * 
	 * @param strLeadName	lead name to search for
	 * @throws InterruptedException, Exception 
	 */
	public boolean doSearchLead(String strLeadName) throws InterruptedException, Exception {
		String methodID = "doSearchLead";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
			
	    //Step: search for then click to open Lead record detail view
		try {
			commNav.highlightNClick(commNav.entityListViewSearch("Leads", strLeadName));
			
			//Step: confirm Lead record detail view is displayed
			if (commNav.waitForNotPage("Leads")) {
				return true;
			}
			else {		
				return false;
			}
		}
		catch (Exception e) {
			System.out.println(methodID + ": " + e.toString());
			return false;
		}
	}
}
