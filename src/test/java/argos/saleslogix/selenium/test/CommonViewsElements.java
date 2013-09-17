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
	@FindBy(xpath = ".//*[@id='Mobile_SalesLogix_Fields_PicklistField_7']/input")
	WebElement addressDescriptionInputFld;
	
	@CacheLookup
	@FindBy(xpath = ".//*[@id='Mobile_SalesLogix_Fields_PicklistField_7']/button")
	WebElement addressDescriptionInputFldBtn;
	
	@CacheLookup
	@FindBy(xpath = ".//*[@id='Sage_Platform_Mobile_Fields_BooleanField_1']/div/span[1]")
	WebElement addressPrimaryTgl;
	
	@CacheLookup
	@FindBy(xpath = ".//*[@id='Sage_Platform_Mobile_Fields_BooleanField_2']/div/span[1]")
	WebElement addressShippingTgl;
	
	@CacheLookup
	@FindBy(xpath = ".//*[@id='Sage_Platform_Mobile_Fields_TextField_49']/input")
	WebElement addressLine1;
	
	@CacheLookup
	@FindBy(xpath = ".//*[@id='Sage_Platform_Mobile_Fields_TextField_50']/input")
	WebElement addressLine2;
	
	@CacheLookup
	@FindBy(xpath = ".//*[@id='Sage_Platform_Mobile_Fields_TextField_51']/input")
	WebElement addressLine3;
	
	@CacheLookup
	@FindBy(xpath = ".//*[@id='Mobile_SalesLogix_Fields_PicklistField_8']/input")
	WebElement addressCityInputFld;
	
	@CacheLookup
	@FindBy(xpath = ".//*[@id='Mobile_SalesLogix_Fields_PicklistField_8']/button")
	WebElement addressCityInputFldBtn;
	
	@CacheLookup
	@FindBy(xpath = ".//*[@id='Mobile_SalesLogix_Fields_PicklistField_9']/input")
	WebElement addressStateInputFld;
	
	@CacheLookup
	@FindBy(xpath = ".//*[@id='Mobile_SalesLogix_Fields_PicklistField_9']/button")
	WebElement addressStateInputFldBtn;
	
	@CacheLookup
	@FindBy(xpath = ".//*[@id='Sage_Platform_Mobile_Fields_TextField_52']/input")
	WebElement addressPostalInputFld;
	
	@CacheLookup
	@FindBy(xpath = ".//*[@id='Mobile_SalesLogix_Fields_PicklistField_10']/input")
	WebElement addressCountryInputFld;
	
	@CacheLookup
	@FindBy(xpath = ".//*[@id='Mobile_SalesLogix_Fields_PicklistField_10']/button")
	WebElement addressCountryInputFldBtn;
	
	@CacheLookup
	@FindBy(xpath = ".//*[@id='Sage_Platform_Mobile_Fields_TextField_53']/input")
	WebElement addressAttentionInputFld;	
	
	
	//List View selection elements
	//============================
	//Account Type selection:
	@CacheLookup
	@FindBy(xpath = ".//*[@id='Sage_Platform_Mobile_SearchWidget_47']/div/div[1]/input")
	WebElement accountTypeLookupInputFld;
	
	@CacheLookup
	@FindBy(xpath = ".//*[@id='Sage_Platform_Mobile_SearchWidget_47']/div/div[3]/button")
	WebElement accountTypeLookupBtn;
	
	//City selection:
	@CacheLookup
	@FindBy(xpath = ".//*[@id='Sage_Platform_Mobile_SearchWidget_44']/div/div[1]/input")
	WebElement cityLookupInputFld;
	
	@CacheLookup
	@FindBy(xpath = ".//*[@id='Sage_Platform_Mobile_SearchWidget_44']/div/div[3]/button")
	WebElement cityLookupBtn;
	
	@CacheLookup
	@FindBy(xpath = ".//*[@id='pick_list_1']/div[2]/button")
	WebElement citySelectNoneBtn;
	
	//Country selection:
	@CacheLookup
	@FindBy(xpath = ".//*[@id='Sage_Platform_Mobile_SearchWidget_46']/div/div[1]/input")
	WebElement countryLookupInputFld;
	
	@CacheLookup
	@FindBy(xpath = ".//*[@id='Sage_Platform_Mobile_SearchWidget_46']/div/div[3]/button")
	WebElement countryLookupBtn;
	
	@CacheLookup
	@FindBy(xpath = ".//*[@id='pick_list_3']/div[2]/button")
	WebElement countrySelectNoneBtn;	
	
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
	
	//Owner selection:
	@CacheLookup
	@FindBy(xpath = ".//*[@id='Sage_Platform_Mobile_SearchWidget_30']/div/div[1]/input")
	WebElement ownerLookupInputFld;
	
	@CacheLookup
	@FindBy(xpath = ".//*[@id='Sage_Platform_Mobile_SearchWidget_30']/div/div[3]/button")
	WebElement ownerLookupBtn;	
	
	//State selection:
	@CacheLookup
	@FindBy(xpath = ".//*[@id='Sage_Platform_Mobile_SearchWidget_45']/div/div[1]/input")
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
	@FindBy(xpath = ".//*[@id='Sage_Platform_Mobile_SearchWidget_43']/div/div[1]/input")
	WebElement subtypeLookupInputFld;
	
	@CacheLookup
	@FindBy(xpath = ".//*[@id='Sage_Platform_Mobile_SearchWidget_43']/div/div[3]/button")
	WebElement subtypeLookupBtn;
	
	@CacheLookup
	@FindBy(xpath = ".//*[@id='pick_list_0']/div[2]/button")
	WebElement subtypeSelectNoneBtn;	
	
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
			pickListID = "pick_list_1";
			break;
		case "country":
			pageTitle = "Country";
			lookupFld = countryLookupInputFld;
			lookupBtn = countryLookupBtn;			
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
		case "user": case "acct mgr":
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
				lookupFld.sendKeys(strSelectItem);
				Thread.sleep(1000);	
				lookupBtn.click();
				Thread.sleep(3000);			
				try {
					commNav.clickListViewGridItem(By.xpath(".//*[@id='" + pickListID + "']/descendant::*[text() = '" + strSelectItem + "']"));
					System.out.println(methodID + ": " + strFieldName + " - " + strSelectItem + " was selected.");
				}
				catch (Exception e){
					System.out.println(methodID + ":" + e.toString());
					System.out.println(methodID + ": " + strFieldName + " - " + strSelectItem + " was NOT found; selection skipped.");
					driver.findElement(By.xpath(hdrCancelBtnXPath)).click();
				}
			}
			
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
	 * @deprecated use @link selectFieldValListItem() instead.
	 */
	@Deprecated
	public void selectCity(String strCity) throws InterruptedException {
		String methodID = "selectCity";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		
		if (commNav.isPageDisplayed("City")) {		
			//make City selection
			if (strCity.toUpperCase().equals("NONE")) {
				citySelectNoneBtn.click();
			}
			else {
				cityLookupInputFld.sendKeys(strCity);
				cityLookupBtn.click();
				Thread.sleep(2000);			
				try {
					commNav.clickListViewGridItem(By.xpath(".//*[@id='pick_list_1']/descendant::*[text() = '" + strCity + "']"));
				}
				catch (Exception e){
					System.out.println(methodID + ":" + e.toString());
					citySelectNoneBtn.click();
				}
			}
			
			System.out.println(methodID + ":" + "City - " + strCity + " was selected.");
			commNav.waitForNotPage("City");
		}
		else {
			System.out.println(methodID + ": City list view was not displayed; selection step skipped.");
		}	
	}
	
	
	/**
	 * @deprecated use @link selectFieldValListItem() instead.
	 */
	@Deprecated
	public void selectCountry(String strCountry) throws InterruptedException {
		String methodID = "selectCountry";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		
		if (commNav.isPageDisplayed("Country")) {		
			//make Country selection
			if (strCountry.toUpperCase().equals("NONE")) {
				countrySelectNoneBtn.click();
			}
			else {
				countryLookupInputFld.sendKeys(strCountry);
				countryLookupBtn.click();
				Thread.sleep(2000);			
				try {
					commNav.clickListViewGridItem(By.xpath(".//*[@id='pick_list_3']/descendant::*[text() = '" + strCountry + "']"));
				}
				catch (Exception e){
					System.out.println(methodID + ":" + e.toString());
					countrySelectNoneBtn.click();
				}
			}
			
			System.out.println(methodID + ":" + "Country - " + strCountry + " was selected.");
			commNav.waitForNotPage("Country");
		}
		else {
			System.out.println(methodID + ": City list view was not displayed; selection step skipped.");
		}			
	}		
	
	
	/**
	 * @deprecated use @link selectFieldValListItem() instead.
	 */
	@Deprecated
	public void selectDescription(String strDescription) throws InterruptedException {
		String methodID = "selectDescription";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		
		if (commNav.isPageDisplayed("Description")) {			
			//make Description selection
			if (strDescription.toUpperCase().equals("NONE")) {
				descriptionSelectNoneBtn.click();
			}
			else {
				descriptionLookupInputFld.sendKeys(strDescription);
				descriptionLookupBtn.click();
				Thread.sleep(2000);			
				try {
					commNav.clickListViewGridItem(By.xpath(".//*[@id='pick_list_0']/descendant::*[text() = '" + strDescription + "']"));
				}
				catch (Exception e){
					System.out.println(methodID + ":" + e.toString());
					descriptionSelectNoneBtn.click();
				}
			}
			
			System.out.println(methodID + ":" + "Description - " + strDescription + " was selected.");
			commNav.waitForNotPage("Description");
		}
		else {
			System.out.println(methodID + ": Description list view was not displayed; selection step skipped.");
		}		
	}
	
	
	/**
	 * @deprecated use @link selectFieldValListItem() instead.
	 */
	@Deprecated
	public void selectIndustry(String strIndustry) throws InterruptedException {
		String methodID = "selectIndustry";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		
		if (commNav.isPageDisplayed("Industry")) {			
			//make Industry selection
			if (strIndustry.toUpperCase().equals("NONE")) {
				industrySelectNoneBtn.click();
			}
			else {
				industryLookupInputFld.sendKeys(strIndustry);
				industryLookupBtn.click();
				Thread.sleep(2000);			
				try {
					commNav.clickListViewGridItem(By.xpath(".//*[@id='pick_list_6']/descendant::*[text() = '" + strIndustry + "']"));
				}
				catch (Exception e){
					System.out.println(methodID + ":" + e.toString());
					industrySelectNoneBtn.click();
				}
			}
			
			System.out.println(methodID + ":" + "Industry - " + strIndustry + " was selected.");
			commNav.waitForNotPage("Industry");
		}
		else {
			System.out.println(methodID + ": Industry list view was not displayed; selection step skipped.");
		}		
	}	

	
	/**
	 * @deprecated use @link selectFieldValListItem() instead.
	 */
	@Deprecated
	public void selectLeadSource(String strLeadSrc) throws InterruptedException {
		String methodID = "selectLeadSource";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		
		if (commNav.isPageDisplayed("Lead Sources")) { 		
			//make Owner selection
			if (strLeadSrc.toUpperCase().equals("NONE")) {
				driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
			}
			else {
				leadSourceLookupInputFld.sendKeys(strLeadSrc);
				leadSourceLookupBtn.click();
				Thread.sleep(2000);			
				try {
					commNav.clickListViewGridItem(By.xpath(".//*[@id='owner_list']/descendant::*[text() = '" + strLeadSrc + "']"));
				}
				catch (Exception e){
					System.out.println(methodID + ":" + e.toString());
					driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
				}
			}
			
			System.out.println(methodID + ":" + "Lead Source - " + strLeadSrc + " was selected.");
			commNav.waitForNotPage("Lead Sources");
		}
		else {
			System.out.println(methodID + ": Lead Sources list view was not displayed; selection step skipped.");
		}		
	}
	
	
	/**
	 * @deprecated use @link selectFieldValListItem() instead.
	 */
	@Deprecated
	public void selectOwner(String strOwner) throws InterruptedException {
		String methodID = "selectOwner";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		
		if (commNav.isPageDisplayed("Owners")) { 		
			//make Owner selection
			if (strOwner.toUpperCase().equals("NONE")) {
				driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
			}
			else {
				ownerLookupInputFld.sendKeys(strOwner);
				ownerLookupBtn.click();
				Thread.sleep(2000);			
				try {
					commNav.clickListViewGridItem(By.xpath(".//*[@id='owner_list']/descendant::*[text() = '" + strOwner + "']"));
				}
				catch (Exception e){
					System.out.println(methodID + ":" + e.toString());
					driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
				}
			}
			
			System.out.println(methodID + ":" + "Owner - " + strOwner + " was selected.");
			commNav.waitForNotPage("Owners");
		}
		else {
			System.out.println(methodID + ": Owners list view was not displayed; selection step skipped.");
		}		
	}
	
	
	/**
	 * @deprecated use @link selectFieldValListItem() instead.
	 */
	@Deprecated
	public void selectState(String strState) throws InterruptedException {
		String methodID = "selectState";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		
		if (commNav.isPageDisplayed("State")) {	
			//make State selection
			if (strState.toUpperCase().equals("NONE")) {
				stateSelectNoneBtn.click();
			}
			else {
				stateLookupInputFld.sendKeys(strState);
				stateLookupBtn.click();
				Thread.sleep(2000);			
				try {
					commNav.clickListViewGridItem(By.xpath(".//*[@id='pick_list_2']/descendant::*[text() = '" + strState.toUpperCase() + "']"));
				}
				catch (Exception e){
					System.out.println(methodID + ":" + e.toString());
					stateSelectNoneBtn.click();
				}
			}
			
			System.out.println(methodID + ":" + "State - " + strState + " was selected.");
			commNav.waitForNotPage("State");
		}
		else {
			System.out.println(methodID + ": State list view was not displayed; selection step skipped.");
		}		
	}
	
	
	/**
	 * @deprecated use @link selectFieldValListItem() instead.
	 */
	@Deprecated
	public void selectStatus(String strStatus) throws InterruptedException {
		String methodID = "selectStatus";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		
		if (commNav.isPageDisplayed("Account Status")) { 
			//make Status selection
			if (strStatus.toUpperCase().equals("NONE")) {
				statusSelectNoneBtn.click();
			}
			else {
				statusLookupInputFld.sendKeys(strStatus);
				statusLookupBtn.click();
				Thread.sleep(2000);			
				try {
					commNav.clickListViewGridItem(By.xpath(".//*[@id='pick_list_5']/descendant::*[text() = '" + strStatus + "']"));
				}
				catch (Exception e){
					System.out.println(methodID + ":" + e.toString());
					statusSelectNoneBtn.click();
				}
			}
			
			System.out.println(methodID + ":" + "Account Status - " + strStatus + " was selected.");
			commNav.waitForNotPage("Account Status");
		}
		else {
			System.out.println(methodID + ": Account Status list view was not displayed; selection step skipped.");
		}
	}
	
	
	/**
	 * @deprecated use @link selectFieldValListItem() instead.
	 */
	@Deprecated
	public void selectSubtype(String strSubtype) throws InterruptedException {
		String methodID = "selectSubtype";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		
		if (commNav.isPageDisplayed("Account Subtype")) {		
			//make Subtype selection
			if (strSubtype.toUpperCase().equals("NONE")) {
				subtypeSelectNoneBtn.click();
			}
			else {
				subtypeLookupInputFld.sendKeys(strSubtype);
				subtypeLookupBtn.click();
				Thread.sleep(2000);			
				try {
					commNav.clickListViewGridItem(By.xpath(".//*[@id='pick_list_0']/descendant::*[text() = '" + strSubtype + "']"));
				}
				catch (Exception e){
					System.out.println(methodID + ":" + e.toString());
					subtypeSelectNoneBtn.click();
				}
			}
			
			System.out.println(methodID + ":" + "Account Subtype - " + strSubtype + " was selected.");
			commNav.waitForNotPage("Account Subtype");
		}
		else {
			System.out.println(methodID + ": Account Subtype list view was not displayed; selection step skipped.");
		}
	}
	
	
	/**
	 * @deprecated use @link selectFieldValListItem() instead.
	 */
	@Deprecated
	public void selectUser(String strUser) throws InterruptedException {
		String methodID = "selectUser";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		
		if (commNav.isPageDisplayed("Users")) { 		
			//make User selection
			if (strUser.toUpperCase().equals("NONE")) {
				driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
			}
			else {
				userLookupInputFld.sendKeys(strUser);
				userLookupBtn.click();
				Thread.sleep(2000);			
				try {
					commNav.clickListViewGridItem(By.xpath(".//*[@id='pick_list_4']/descendant::*[text() = '" + strUser + "']"));
				}
				catch (Exception e){
					System.out.println(methodID + ":" + e.toString());
					driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
				}
			}
			
			System.out.println(methodID + ":" + "User - " + strUser + " was selected.");
			commNav.waitForNotPage("Users");
		}
		else {
			System.out.println(methodID + ": Users list view was not displayed; selection step skipped.");
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
		
		if (commNav.isPageDisplayed("Business Description")) {		
			//set Business Description text
			busdescTxtArea.sendKeys(strBusDesc);
			driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[2]")).click();
			
			System.out.println(methodID + ":" + "Business Description - " + strBusDesc + " was set.");
			commNav.waitForNotPage("Business Description");
		}
		else {
			System.out.println(methodID + ": Business Description text area was not displayed; step skipped.");
		}
	}	
}
