package argos.saleslogix.selenium.test;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Properties;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


/**
 * CommonViewsElements class defines webelements and methods for any common List, Edit and Detail view
 * that can be invoked from any entity-based view (i.e. Address or Name fields).  
 * @author	mike.llena@swiftpage.com
 * @version	1.0
 * @see BrowserSetup
 */
public class CommonViewsElements extends BrowserSetup {
	
	private WebDriver driver;

	public CommonViewsElements(WebDriver driver) {
		this.driver = driver;		
	}
	
	CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);

	//Edit View elements
	//==================
	//Address input fields:
	@CacheLookup
	@FindBy(xpath = "//div[@id='Mobile_SalesLogix_Fields_PicklistField_4']/input")
	WebElement addressDescriptionInputFld;
	
	@CacheLookup
	@FindBy(xpath = "//div[@id='Mobile_SalesLogix_Fields_PicklistField_4']/button")
	WebElement addressDescriptionInputFldBtn;
	
	@CacheLookup
	@FindBy(xpath = "//div[@id='Sage_Platform_Mobile_Fields_BooleanField_1']/div/span")
	WebElement addressPrimaryTgl;
	
	@CacheLookup
	@FindBy(xpath = "//div[@id='Sage_Platform_Mobile_Fields_BooleanField_2']/div/span")
	WebElement addressShippingTgl;
	
	@CacheLookup
	@FindBy(css = "input[name='Address1']")
	WebElement addressLine1;
	
	@CacheLookup
	@FindBy(css = "input[name='Address2']")
	WebElement addressLine2;
	
	@CacheLookup
	@FindBy(css = "input[name='Address3']")
	WebElement addressLine3;
	
	@CacheLookup
	@FindBy(xpath = "//div[@id='Mobile_SalesLogix_Fields_PicklistField_5']/input")
	WebElement addressCityInputFld;
	
	@CacheLookup
	@FindBy(xpath = "//div[@id='Mobile_SalesLogix_Fields_PicklistField_5']/button")
	WebElement addressCityInputFldBtn;
	
	@CacheLookup
	@FindBy(xpath = "//div[@id='Mobile_SalesLogix_Fields_PicklistField_6']/input")
	WebElement addressStateInputFld;
	
	@CacheLookup
	@FindBy(xpath = "//div[@id='Mobile_SalesLogix_Fields_PicklistField_6']/button")
	WebElement addressStateInputFldBtn;
	
	@CacheLookup
	@FindBy(css = "input[name='PostalCode']")
	WebElement addressPostalInputFld;
	
	@CacheLookup
	@FindBy(xpath = "//div[@id='Mobile_SalesLogix_Fields_PicklistField_7']/input")
	WebElement addressCountryInputFld;
	
	@CacheLookup
	@FindBy(xpath = "//div[@id='Mobile_SalesLogix_Fields_PicklistField_7']/button")
	WebElement addressCountryInputFldBtn;
	
	@CacheLookup
	@FindBy(css = "input[name='Salutation']")
	WebElement addressAttentionInputFld;		
	
	//Edit Name input fields:
	//=======================
	@CacheLookup
	@FindBy(css = "input[type='text']")
	WebElement namePrefixInputFld;
	
	@CacheLookup
	@FindBy(xpath = "//div[@id='Mobile_SalesLogix_Fields_PicklistField_10']/button")
	WebElement namePrefixInputFldBtn;
	
	@CacheLookup
	@FindBy(css = "input[name='FirstName']")
	WebElement nameFirstInputFld;
	
	@CacheLookup
	@FindBy(css = "input[name='MiddleName']")
	WebElement nameMiddleInputFld;
	
	@CacheLookup
	@FindBy(css = "input[name='LastName']")
	WebElement nameLastInputFld;
	
	@CacheLookup
	@FindBy(xpath = "(//input[@type='text'])[5]")
	WebElement nameSuffixInputFld;
	
	@CacheLookup
	@FindBy(css = "#Mobile_SalesLogix_Fields_PicklistField_11 > button.button.simpleSubHeaderButton")
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
	@FindBy(xpath = ".//*[@id='Sage_Platform_Mobile_SearchWidget_43']/div/div[1]/input")
	WebElement descriptionLookupInputFld;
	
	@CacheLookup
	@FindBy(xpath = ".//*[@id='Sage_Platform_Mobile_SearchWidget_43']/div/div[3]/button")
	WebElement descriptionLookupBtn;
	
	@CacheLookup
	@FindBy(xpath = ".//*[@id='pick_list_0']/div[2]/button")
	WebElement descriptionSelectNoneBtn;
	
	//Industry selection:
	@CacheLookup
	@FindBy(xpath = ".//*[@id='Sage_Platform_Mobile_SearchWidget_49']/div/div[1]/input")
	WebElement industryLookupInputFld;
	
	@CacheLookup
	@FindBy(xpath = ".//*[@id='Sage_Platform_Mobile_SearchWidget_49']/div/div[3]/button")
	WebElement industryLookupBtn;
	
	@CacheLookup
	@FindBy(xpath = ".//*[@id='pick_list_6']/div[2]/button")
	WebElement industrySelectNoneBtn;
	
	//Lead Source selection:
	@CacheLookup
	@FindBy(xpath = ".//*[@id='Sage_Platform_Mobile_SearchWidget_33']/div/div[1]/input")
	WebElement leadSourceLookupInputFld;
	
	@CacheLookup
	@FindBy(xpath = ".//*[@id='Sage_Platform_Mobile_SearchWidget_33']/div/div[3]/button")
	WebElement leadSourceLookupBtn;	
	
	//Name Prefix selection:
	@CacheLookup
	@FindBy(xpath = ".//*[@id='Sage_Platform_Mobile_SearchWidget_43']/div/div[1]/input")
	WebElement namePrefixLookupInputFld;
	
	@CacheLookup
	@FindBy(xpath = ".//*[@id='Sage_Platform_Mobile_SearchWidget_43']/div/div[3]/button")
	WebElement namePrefixLookupBtn;
	
	//Name Suffix selection:
	@CacheLookup
	@FindBy(xpath = ".//*[@id='Sage_Platform_Mobile_SearchWidget_44']/div/div[1]/input")
	WebElement nameSuffixLookupInputFld;
	
	@CacheLookup
	@FindBy(xpath = ".//*[@id='Sage_Platform_Mobile_SearchWidget_44']/div/div[3]/button")
	WebElement nameSuffixLookupBtn;
	
	//Owner selection:
	@CacheLookup
	@FindBy(xpath = ".//*[@id='Sage_Platform_Mobile_SearchWidget_30']/div/div[1]/input")
	WebElement ownerLookupInputFld;
	
	@CacheLookup
	@FindBy(xpath = ".//*[@id='Sage_Platform_Mobile_SearchWidget_30']/div/div[3]/button")
	WebElement ownerLookupBtn;	
	
	//State selection:
	@CacheLookup
	@FindBy(css = "input[name='query']")
	WebElement stateLookupInputFld;
	
	@CacheLookup
	@FindBy(xpath = ".//*[@id='Sage_Platform_Mobile_SearchWidget_45']/div/div[3]/button")
	WebElement stateLookupBtn;
	
	@CacheLookup
	@FindBy(xpath = ".//*[@id='pick_list_2']/div[2]/button")
	WebElement stateSelectNoneBtn;
	
	//Account Status selection:
	@CacheLookup
	@FindBy(xpath = ".//*[@id='Sage_Platform_Mobile_SearchWidget_48']/div/div[1]/input")
	WebElement statusLookupInputFld;
	
	@CacheLookup
	@FindBy(xpath = ".//*[@id='Sage_Platform_Mobile_SearchWidget_48']/div/div[3]/button")
	WebElement statusLookupBtn;
	
	@CacheLookup
	@FindBy(xpath = ".//*[@id='pick_list_5']/div[2]/button")
	WebElement statusSelectNoneBtn;	
	
	//Account Subtype selection:
	@CacheLookup
	@FindBy(css = "input[name='query']")
	WebElement subtypeLookupInputFld;
	
	@CacheLookup
	@FindBy(xpath = ".//*[@id='Sage_Platform_Mobile_SearchWidget_43']/div/div[3]/button")
	WebElement subtypeLookupBtn;
	
	@CacheLookup
	@FindBy(xpath = ".//*[@id='pick_list_0']/div[2]/button")
	WebElement subtypeSelectNoneBtn;	
	
	//Title (name) selection:
	@CacheLookup
	@FindBy(xpath = ".//*[@id='Sage_Platform_Mobile_SearchWidget_45']/div/div[1]/input")
	WebElement titleLookupInputFld;
	
	@CacheLookup
	@FindBy(xpath = ".//*[@id='Sage_Platform_Mobile_SearchWidget_45']/div/div[1]/button")
	WebElement titleLookupBtn;
	
	@CacheLookup
	@FindBy(xpath = ".//*[@id='pick_list_2']/div[2]/button")
	WebElement titleSelectNoneBtn;
	
	//Users selection:
	@CacheLookup
	@FindBy(xpath = ".//*[@id='Sage_Platform_Mobile_SearchWidget_29']/div/div[1]/input")
	WebElement userLookupInputFld;
	
	@CacheLookup
	@FindBy(xpath = ".//*[@id='Sage_Platform_Mobile_SearchWidget_29']/div/div[3]/button")
	WebElement userLookupBtn;
	
	//Text Input view elements
	//========================	
	//Business Description
	@CacheLookup
	@FindBy(xpath = ".//*[@id='Sage_Platform_Mobile_Fields_TextAreaField_0']/textarea")
	WebElement busdescTxtArea;	
	
	
	//Detail View elements
	//====================
	//TODO: complete the common Detail View elements
	
		
	//Methods
	//=======
	/**
	 * The selectFieldValListItem method will search for and select an item from a field input list 
	 * view selection list (i.e. Account Type, City, Industry, etc.).  This method should be called
	 * immediately after clicking an input field button that invokes a list view selection.
	 * @author	mike.llena@swiftpage.com
	 * @version	1.0
	 * @param	strFieldName  	field value label name that invokes this list view selection
	 * @param	strSelectItem	target list item to search and select
	 * @exception InterruptedException
	 */
	public void selectFieldValListItem(String strFieldName, String strSelectItem) throws InterruptedException {
		String methodID = "selectFieldValListItem";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		
		//initialize/setup common elements
		String pageTitle = "";
		String pickListID = "";
		WebElement lookupFld = null;
		WebElement lookupBtn = null;
		String hdrCancelBtnXPath = ".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]";
		
		//setup common elements based on field name to set
		switch (strFieldName.toLowerCase()) {
		case "account type": case "type":
			pageTitle = "Account Type";
			lookupFld = accountTypeLookupInputFld;
			lookupBtn = accountTypeLookupBtn;
			pickListID = "pick_list_4";
			break;
		case "account subtype": case "subtype": case "sub type":
			pageTitle = "Account Subtype";
			lookupFld = subtypeLookupInputFld;
			lookupBtn = subtypeLookupBtn;			
			pickListID = "pick_list_0";
			break;
		case "city":
			pageTitle = "City";
			lookupFld = cityLookupInputFld;
			lookupBtn = cityLookupBtn;			
			pickListID = "pick_list_0";
			break;
		case "country":
			pageTitle = "Country";
			lookupFld = countryLookupInputFld;
			lookupBtn = countryLookupBtn;			
			pickListID = "pick_list_3";
			break;	
		case "cuisine":
			pageTitle = "Cuisine";
			lookupFld = cuisineLookupInputFld;
			lookupBtn = cuisineLookupBtn;			
			pickListID = "pick_list_3";
			break;			
		case "description":
			pageTitle = "Description";
			lookupFld = descriptionLookupInputFld;
			lookupBtn = descriptionLookupBtn;			
			pickListID = "pick_list_0";
			break;
		case "industry":
			pageTitle = "Industry";
			lookupFld = industryLookupInputFld;
			lookupBtn = industryLookupBtn;			
			pickListID = "pick_list_6";
			break;
		case "lead source":
			pageTitle = "Lead Source";
			lookupFld = leadSourceLookupInputFld;
			lookupBtn = leadSourceLookupBtn;			
			pickListID = "leadsource_list";
			break;
		case "name prefix": case "prefix":
			pageTitle = "Name Prefix";
			lookupFld = namePrefixLookupInputFld;
			lookupBtn = namePrefixLookupBtn;			
			pickListID = "pick_list_0";
			break;		
		case "name suffix": case "suffix":
			pageTitle = "Name Suffix";
			lookupFld = nameSuffixLookupInputFld;
			lookupBtn = nameSuffixLookupBtn;			
			pickListID = "pick_list_1";
			break;			
		case "owner":
			pageTitle = "Owner";
			lookupFld = ownerLookupInputFld;
			lookupBtn = ownerLookupBtn;			
			pickListID = "owner_list";
			break;			
		case "state":
			pageTitle = "State";
			lookupFld = stateLookupInputFld;
			lookupBtn = stateLookupBtn;			
			pickListID = "pick_list_2";
			break;
		case "status":
			pageTitle = "Account Status";
			lookupFld = statusLookupInputFld;
			lookupBtn = statusLookupBtn;			
			pickListID = "pick_list_5";
			break;
		case "title":
			pageTitle = "Title";
			lookupFld = titleLookupInputFld;
			lookupBtn = titleLookupBtn;			
			pickListID = "pick_list_2";
			break;			
		case "user": case "users": case "acct mgr":
			pageTitle = "Users";
			lookupFld = userLookupInputFld;
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
				lookupFld.sendKeys(Keys.ENTER);
				Thread.sleep(3000);			
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
					System.out.println(methodID + ":" + e.toString());
					System.out.println(methodID + ": " + strFieldName + " - " + strSelectItem + " was NOT found; selection skipped.");
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
				driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
			}
			else {
				accountTypeLookupInputFld.sendKeys(strAccType);
				accountTypeLookupBtn.click();
				Thread.sleep(2000);			
				try {
					commNav.clickListViewGridItem(By.xpath(".//*[@id='pick_list_4']/descendant::*[text() = '" + strAccType + "']"));
				}
				catch (Exception e){
					System.out.println(methodID + ":" + e.toString());
					driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
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
	 * @author	mike.llena@swiftpage.com
	 * @version	1.0
	 * @param	strBusDesc  text for the Business Description
	 * @exception InterruptedException
	 */	
	public void setBusDescription(String strBusDesc) throws InterruptedException {
		String methodID = "setBusDescription";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		
		commNav.waitForPage("Business Description");
		if (commNav.isPageDisplayed("Business Description")) {		
			//set Business Description text
			busdescTxtArea.sendKeys(strBusDesc);
			driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[2]")).click();
			
			System.out.println(methodID + ":" + "Business Description - " + strBusDesc + " was set.");
			commNav.waitForNotPage("Business Description");
			Thread.sleep(1000);
		}
		else {
			System.out.println(methodID + ": Business Description text area was not displayed; step skipped.");
		}
	}	
}
