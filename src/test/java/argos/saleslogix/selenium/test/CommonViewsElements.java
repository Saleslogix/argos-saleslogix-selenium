package argos.saleslogix.selenium.test;

import org.openqa.selenium.*;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


/**
 * CommonViewsElements class defines webelements and methods for any common List, Edit and Detail view
 * that can be invoked from any entity-based view (i.e. Address or Name fields).
 *   
 * @author	mike.llena@swiftpage.com
 * @version	1.0
 * @see BaseTest
 */
public class CommonViewsElements extends BaseTest {
	
	private WebDriver driver;

	public CommonViewsElements(WebDriver driver) {
		this.driver = driver;		
	}
	
	CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);

	//Edit View elements
	//==================

    //Main lookup field seen at top of screen all throughout Mobile
    @CacheLookup
    @FindBy(xpath = "//*[@selected='selected']//input[@name='query']")
    WebElement lookupTxtBox;

	//Address input fields:
	@FindBy(xpath = "//*[@id='address_edit']/descendant::*[@type='text'][1]")
	WebElement addressDescriptionInputFld;

	@FindBy(xpath = "//*[@id='address_edit']/descendant::*[@aria-label='lookup'][1]")
	WebElement addressDescriptionInputFldBtn;

	@FindBy(xpath = "//div[@selected='selected']//div[@data-field='IsPrimary']")
	WebElement addressPrimaryTgl;

	@FindBy(xpath = "//div[@selected='selected']//div[@data-field='IsMailing']")
	WebElement addressShippingTgl;

	@FindBy(css = "input[name='Address1']")
	WebElement addressLine1;

	@FindBy(css = "input[name='Address2']")
	WebElement addressLine2;

	@FindBy(css = "input[name='Address3']")
	WebElement addressLine3;

	@FindBy(xpath = "//*[@id='address_edit']/descendant::*[@type='text'][5]")
	WebElement addressCityInputFld;

	@FindBy(xpath = "//*[@id='address_edit']/descendant::*[@aria-label='lookup'][5]")
	WebElement addressCityInputFldBtn;

	@FindBy(xpath = "//*[@id='address_edit']/descendant::*[@type='text'][6]")
	WebElement addressStateInputFld;

	@FindBy(xpath = "//*[@id='address_edit']/descendant::*[@aria-label='lookup'][6]")
	WebElement addressStateInputFldBtn;

	@FindBy(css = "input[name='PostalCode']")
	WebElement addressPostalInputFld;

	@FindBy(xpath = "//*[@id='address_edit']/descendant::*[@type='text'][8]")
	WebElement addressCountryInputFld;

	@FindBy(xpath = "//*[@id='address_edit']/descendant::*[@aria-label='lookup'][8]")
	WebElement addressCountryInputFldBtn;

	@FindBy(css = "input[name='Salutation']")
	WebElement addressAttentionInputFld;		
	
	//Edit Name input fields:
	//=======================
	@FindBy(xpath = "//*[@id='name_edit']/descendant::*[@type='text'][1]")
	WebElement namePrefixInputFld;

	@FindBy(xpath = "//*[@id='crm_Fields_PicklistField_5']/button")
	WebElement namePrefixInputFldBtn;

	@FindBy(css = "input[name='FirstName']")
	WebElement nameFirstInputFld;

	@FindBy(css = "input[name='MiddleName']")
	WebElement nameMiddleInputFld;

	@FindBy(css = "input[name='LastName']")
	WebElement nameLastInputFld;

	@FindBy(xpath = "//*[@id='name_edit']/descendant::*[@type='text'][5]")
	WebElement nameSuffixInputFld;

	@FindBy(xpath = "//*[@id='crm_Fields_PicklistField_6']/button")
	WebElement nameSuffixInputFldBtn;
	
	//List View selection elements
	//============================
	//Account Type selection:
	@CacheLookup
	@FindBy(css = "input[name='query']")
	WebElement accountTypeLookupInputFld;
	
	@CacheLookup
	@FindBy(xpath = "//div[3]/button")
	WebElement accountTypeLookupBtn;
	
	//City selection:
	@CacheLookup
	@FindBy(css = "input[name='query']")
	WebElement cityLookupInputFld;
	
	@CacheLookup
	@FindBy(xpath = "//div[3]/button")
	WebElement cityLookupBtn;
	
	@CacheLookup
	@FindBy(xpath = ".//*[@id='pick_list_4']/div[2]/button")
	WebElement citySelectNoneBtn;
	
	//Country selection:
	@CacheLookup
	@FindBy(css = "input[name='query']")
	WebElement countryLookupInputFld;
	
	@CacheLookup
	@FindBy(xpath = "//div[3]/button")
	WebElement countryLookupBtn;
	
	@CacheLookup
	@FindBy(xpath = ".//*[@id='pick_list_3']/div[2]/button")
	WebElement countrySelectNoneBtn;
	
	//Cuisine selection:
	@CacheLookup
	@FindBy(css = "input[name='query']")
	WebElement cuisineLookupInputFld;
	
	@CacheLookup
	@FindBy(xpath = "//div[3]/button")
	WebElement cuisineLookupBtn;
	
	@CacheLookup
	@FindBy(xpath = ".//*[@id='pick_list_3']/div[2]/button")
	WebElement cuisineSelectNoneBtn;		
	
	//Description selection:
	@CacheLookup
	@FindBy(xpath = ".//*[@id='argos_SearchWidget_43']/div/div[1]/input")
	WebElement descriptionLookupInputFld;
	
	@CacheLookup
	@FindBy(xpath = ".//*[@id='argos_SearchWidget_43']/div/div[3]/button")
	WebElement descriptionLookupBtn;
	
	@CacheLookup
	@FindBy(xpath = ".//*[@id='pick_list_0']/div[2]/button")
	WebElement descriptionSelectNoneBtn;
	
	//Industry selection:
	@CacheLookup
	@FindBy(xpath = ".//*[@id='argos_SearchWidget_49']/div/div[1]/input")
	WebElement industryLookupInputFld;
	
	@CacheLookup
	@FindBy(xpath = ".//*[@id='argos_SearchWidget_49']/div/div[3]/button")
	WebElement industryLookupBtn;
	
	@CacheLookup
	@FindBy(xpath = ".//*[@id='pick_list_6']/div[2]/button")
	WebElement industrySelectNoneBtn;
	
	//General List View search field:
	@CacheLookup
	@FindBy(css = "input[name='query']")
	WebElement listViewSearchInputFld;
	
	//Lead Source selection:
	@CacheLookup
	@FindBy(xpath = ".//*[@id='argos_SearchWidget_33']/div/div[1]/input")
	WebElement leadSourceLookupInputFld;
	
	@CacheLookup
	@FindBy(xpath = ".//*[@id='argos_SearchWidget_33']/div/div[3]/button")
	WebElement leadSourceLookupBtn;	
	
	//Name Prefix selection:
	@CacheLookup
	@FindBy(xpath = ".//*[@id='argos_SearchWidget_43']/div/div[1]/input")
	WebElement namePrefixLookupInputFld;
	
	@CacheLookup
	@FindBy(xpath = ".//*[@id='argos_SearchWidget_43']/div/div[3]/button")
	WebElement namePrefixLookupBtn;
	
	//Name Suffix selection:
	@CacheLookup
	@FindBy(xpath = ".//*[@id='argos_SearchWidget_44']/div/div[1]/input")
	WebElement nameSuffixLookupInputFld;
	
	@CacheLookup
	@FindBy(xpath = ".//*[@id='argos_SearchWidget_44']/div/div[3]/button")
	WebElement nameSuffixLookupBtn;
	
	//Owner selection:
	@CacheLookup
	@FindBy(xpath = ".//*[@id='argos_SearchWidget_30']/div/div[1]/input")
	WebElement ownerLookupInputFld;
	
	@CacheLookup
	@FindBy(xpath = ".//*[@id='argos_SearchWidget_30']/div/div[3]/button")
	WebElement ownerLookupBtn;	
	
	//State selection:
	@CacheLookup
	@FindBy(css = "input[name='query']")
	WebElement stateLookupInputFld;
	
	@CacheLookup
	@FindBy(xpath = ".//*[@id='argos_SearchWidget_45']/div/div[3]/button")
	WebElement stateLookupBtn;
	
	@CacheLookup
	@FindBy(xpath = ".//*[@id='pick_list_2']/div[2]/button")
	WebElement stateSelectNoneBtn;
	
	//Account Status selection:
	@CacheLookup
	@FindBy(xpath = ".//*[@id='argos_SearchWidget_48']/div/div[1]/input")
	WebElement statusLookupInputFld;
	
	@CacheLookup
	@FindBy(xpath = ".//*[@id='argos_SearchWidget_48']/div/div[3]/button")
	WebElement statusLookupBtn;
	
	@CacheLookup
	@FindBy(xpath = ".//*[@id='pick_list_5']/div[2]/button")
	WebElement statusSelectNoneBtn;	
	
	//Account Subtype selection:
	@CacheLookup
	@FindBy(css = "input[name='query']")
	WebElement subtypeLookupInputFld;
	
	@CacheLookup
	@FindBy(xpath = ".//*[@id='argos_SearchWidget_43']/div/div[3]/button")
	WebElement subtypeLookupBtn;
	
	@CacheLookup
	@FindBy(xpath = ".//*[@id='pick_list_0']/div[2]/button")
	WebElement subtypeSelectNoneBtn;	
	
	//Title (name) selection:
	@CacheLookup
	@FindBy(xpath = ".//*[@id='argos_SearchWidget_45']/div/div[1]/input")
	WebElement titleLookupInputFld;
	
	@CacheLookup
	@FindBy(xpath = ".//*[@id='argos_SearchWidget_45']/div/div[1]/button")
	WebElement titleLookupBtn;
	
	@CacheLookup
	@FindBy(xpath = ".//*[@id='pick_list_2']/div[2]/button")
	WebElement titleSelectNoneBtn;
	
	//Users selection:
	@CacheLookup
	@FindBy(xpath = ".//*[@id='argos_SearchWidget_29']/div/div[1]/input")
	WebElement userLookupInputFld;
	
	@CacheLookup
	@FindBy(xpath = ".//*[@id='argos_SearchWidget_29']/div/div[3]/button")
	WebElement userLookupBtn;

    //Briefcase Complete toast elements
    @CacheLookup
    @FindBy(xpath = ".//*[@id='modal-template']//div[contains(text(), 'Okay')]")
    WebElement briefcaseCompleteOkayBtn;

    @CacheLookup
    @FindBy(xpath = ".//*[@id='modal-template']//div[contains(text(), 'Cancel')]")
    WebElement briefcaseCompleteCancelBtn;

    //Offline Options under Settings
    @CacheLookup
    @FindBy(xpath = ".//*[@id='settings']//li[@data-action='viewOfflineOptions']")
    WebElement settingsOfflineOptions;

    //Use 24 hour clock under Settings
    @CacheLookup
    @FindBy(xpath = ".//*[@id='settings']//li[@data-action='use24HourClock']")
    WebElement settingsUse24HourClock;

    //Offline Options elements
    @CacheLookup
    @FindBy(xpath = "//*[@id='olderThan-dropdown offline_usage_widget_undefined']/input")
    WebElement offlineDataOlderField;

    @CacheLookup
    @FindBy(xpath = "//ul/li[@data-value='0']")
    WebElement offlineDataOlderZeroDays;

    @CacheLookup
    @FindBy(xpath = "//*[@id='offline_usage_widget_undefined']//button[@data-dojo-attach-event='onclick:onClearAllData']")
    WebElement offlineDataClearBtn;

    @CacheLookup
    @FindBy(xpath = "//*[@id='offline_usage_widget_undefined']//button[@data-dojo-attach-event='onclick:onClearBriefcasedData']")
    WebElement offlineDataClearBriefcaseBtn;


    @CacheLookup
    @FindBy(xpath = "//*[@id='offline_usage_widget_undefined']//button[@data-dojo-attach-event='onclick:onClearRecentData']")
    WebElement offlineDataClearRecViewedBtn;

    @CacheLookup
	@FindBy( id = "toast-container")
    WebElement toastContainer;

	//Text Input view elements
	//========================	
	//Business Description
	@CacheLookup
	@FindBy(xpath = ".//*[@id='argos_Fields_TextAreaField_0']/textarea")
	WebElement busdescTxtArea;
	
	public void clearToast() {
        if (toastContainer.isDisplayed()) {
            toastContainer.click();
        }
	}
	/**
	 * The lookupNSelectListItem method will lookup then select an item from a field input list 
	 * view selection list (i.e. Account Type, City, Industry, etc.).  This method should be called
	 * immediately after clicking an input field button that invokes a list view selection.
	 * 
	 * @param	strFieldName  	field value label name that invokes this list view selection
	 * @param	strSelectItem	target list item to search and select
	 * @throws InterruptedException
	 */
	public void lookupNSelectListItem(String strFieldName, String strSelectItem) throws InterruptedException {
		String methodID = "lookupNSelectListItem";
		
		String listXPathSubStr = "";
		String listItemXPath = "";
		//.//*[@id='owner_list']
		//setup common elements based on field name to set
		switch (strFieldName.toLowerCase()) {
		case "lead source": case "lead sources":
			listXPathSubStr = "//*[@id='leadsource_list']";
			break;
		case "owners": case "owner":
			listXPathSubStr = "//*[@id='owner_list']";
			break;		
		}
		
		try {
			WebElement lookupFld = driver.findElement(By.name("query"));
			//WebElement lookupBtn = driver.findElement(By.cssSelector("button.subHeaderButton.searchButton"));
			
			//enter the lookup item into the query field
			lookupFld.sendKeys(strSelectItem);
			
			//click the Lookup button to find the item .... lookup btn has been removed, so just press enter from the lookup field
			//lookupBtn.click();
            lookupFld.sendKeys(Keys.RETURN);
			Thread.sleep(3000);
			
			//click to select the lookup item
			listItemXPath = listXPathSubStr + "//descendant::*[text()='" + strSelectItem + "']";
			driver.findElement(By.xpath(listItemXPath)).click();
			Thread.sleep(3000);
		}
		catch (Exception e) {
			System.out.println(methodID + "(): " + e.toString());
		}
		
	}
	
	
	/**
	 * The selectFieldValListItem method will search for and select an item from a field input list 
	 * view selection list (i.e. Account Type, City, Industry, etc.).  This method should be called
	 * immediately after clicking an input field button that invokes a list view selection.
	 * 
	 * @param	strFieldName  	field value label name that invokes this list view selection
	 * @param	strSelectItem	target list item to search and select
	 * @throws InterruptedException
	 */
	public void selectFieldValListItem(String strFieldName, String strSelectItem) throws InterruptedException {
		String methodID = "selectFieldValListItem";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		
		//initialize/setup common elements
		String pageTitle = "";
		String pickListID = "";
		WebElement lookupFld = listViewSearchInputFld;
		WebElement lookupBtn = null;
		String hdrCancelBtnXPath = ".//*[@id='crm_Views_MainToolbar_0']/button[3]";
		
		//setup common elements based on field name to set
		switch (strFieldName.toLowerCase()) {
		case "account type": case "type":
			pageTitle = "Account Type";
			lookupBtn = accountTypeLookupBtn;
			pickListID = "pick_list_4";
			break;
		case "account subtype": case "subtype": case "sub type":
			pageTitle = "Account Subtype";
			lookupBtn = subtypeLookupBtn;			
			pickListID = "pick_list_0";
			break;
		case "city":
			pageTitle = "City";
			lookupBtn = cityLookupBtn;			
			pickListID = "pick_list_0";
			break;
		case "country":
			pageTitle = "Country";
			lookupBtn = countryLookupBtn;			
			pickListID = "pick_list_3";
			break;	
		case "cuisine":
			pageTitle = "Cuisine";
			lookupBtn = cuisineLookupBtn;			
			pickListID = "pick_list_3";
			break;			
		case "description":
			pageTitle = "Description";
			lookupBtn = descriptionLookupBtn;			
			pickListID = "pick_list_0";
			break;
		case "industry":
			pageTitle = "Industry";
			lookupBtn = industryLookupBtn;			
			pickListID = "pick_list_6";
			break;
		case "lead source":
			pageTitle = "Lead Sources";
			lookupBtn = leadSourceLookupBtn;			
			pickListID = "leadsource_list";
			break;
		case "name prefix": case "prefix":
			pageTitle = "Name Prefix";
			lookupBtn = namePrefixLookupBtn;			
			pickListID = "pick_list_0";
			break;		
		case "name suffix": case "suffix":
			pageTitle = "Name Suffix";
			lookupBtn = nameSuffixLookupBtn;			
			pickListID = "pick_list_0";
			break;			
		case "owner":
			pageTitle = "Owner";
			lookupBtn = ownerLookupBtn;			
			pickListID = "owner_list";
			break;			
		case "state":
			pageTitle = "State";
			lookupBtn = stateLookupBtn;			
			pickListID = "pick_list_2";
			break;
		case "status":
			pageTitle = "Account Status";
			lookupBtn = statusLookupBtn;			
			pickListID = "pick_list_5";
			break;
		case "title":
			pageTitle = "Title";
			lookupBtn = titleLookupBtn;			
			pickListID = "pick_list_2";
			break;			
		case "user": case "users": case "acct mgr":
			pageTitle = "Users";
			lookupBtn = userLookupBtn;			
			pickListID = "user_list";
			break;			
		}
		
		//process the list item selection
		if (commNav.isPageDisplayed(pageTitle)) { 		
			//cancel selection for 'none'
			if (strSelectItem.toUpperCase().equals("NONE")) {
				driver.findElement(By.xpath(hdrCancelBtnXPath)).click();
			}
			//perform item search and selection
			else {
				lookupFld.click();
				lookupFld.sendKeys(strSelectItem);
				Thread.sleep(100);
				//TO DO: define a new framework WebElement for the Lookup button using the xpath below ... lookup button removed, just press enter in lookup field
				//driver.findElement(By.xpath("//*[@id='viewContainer']/descendant::*[@class='subHeaderButton searchButton']")).click();
                lookupFld.sendKeys(Keys.RETURN);

				Thread.sleep(2000);			
				try {
					if (pageTitle.toLowerCase().equals("users")) {
						//commNav.clickListViewGridItem(By.xpath(".//*[@id='" + pickListID + "']/descendant::*[text() = '" + strSelectItem + "']"));
						commNav.clickListViewGridItem(By.xpath(".//*[@id='user_list']/ul/li/div[1]/h3"));
					}
					else {
						commNav.clickListViewGridItem(By.xpath("//li[1]/div/h3"));
					}
					System.out.println(methodID + ": " + strFieldName + " - " + strSelectItem + " was selected.");
				}
				catch (Exception e){
					System.out.println(methodID + "():" + e.toString());
					System.out.println(methodID + "(): " + strFieldName + " - " + strSelectItem + " was NOT found; selection skipped.");
					driver.findElement(By.xpath(hdrCancelBtnXPath)).click();
				}
			}
			
			Thread.sleep(1000);
			commNav.waitForNotPage(pageTitle);
		}
		else {
			System.out.println(methodID + ": " + strFieldName + " list view was not displayed; selection step skipped.");
		}		
	}
	
	
	/**
	 * @deprecated use @link selectFieldValListItem() instead.
	 */
	@Deprecated
	public void selectAccountType(String strAccType) throws InterruptedException {
		String methodID = "selectAccountType";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		
		if (commNav.isPageDisplayed("Account Type")) { 		
			//make Type selection
			if (strAccType.toUpperCase().equals("NONE")) {
				driver.findElement(By.xpath("//*[@id='pick_list_0']/div[2]/button]")).click();
			}
			else {
				accountTypeLookupInputFld.sendKeys(strAccType);
				accountTypeLookupBtn.click();
				Thread.sleep(2000);			
				try {
					commNav.clickListViewGridItem(By.xpath(".//*[@id='pick_list_4']/descendant::*[text() = '" + strAccType + "']"));
				}
				catch (Exception e){
					System.out.println(methodID + "():" + e.toString());
					driver.findElement(By.xpath(".//*[@id='crm_Views_MainToolbar_0']/button[3]")).click();
				}
			}
			
			System.out.println(methodID + ":" + "Account Type - " + strAccType + " was selected.");
			commNav.waitForNotPage("Account Type");
		}
		else {
			System.out.println(methodID + ": Account Type list view was not displayed; selection step skipped.");
		}		
	}
	
	
	/**
	 * This method will enter text for the Business Description.
	 * 
	 * @param	strBusDesc  text for the Business Description
	 * @throws InterruptedException
	 */	
	public void setBusDescription(String strBusDesc) throws InterruptedException {
		String methodID = "setBusDescription";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		
		commNav.waitForPage("Business Description");
		if (commNav.isPageDisplayed("Business Description")) {		
			//set Business Description text
			busdescTxtArea.sendKeys(strBusDesc);
			driver.findElement(By.xpath(".//*[@id='crm_Views_MainToolbar_0']/button[2]")).click();
			
			System.out.println(methodID + ":" + "Business Description - " + strBusDesc + " was set.");
			commNav.waitForNotPage("Business Description");
			Thread.sleep(1000);
		}
		else {
			System.out.println(methodID + ": Business Description text area was not displayed; step skipped.");
		}
	}	
}
