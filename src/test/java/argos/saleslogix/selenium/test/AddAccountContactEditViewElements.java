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


public class AddAccountContactEditViewElements extends BaseTest {
	
	private WebDriver driver;

	public AddAccountContactEditViewElements(WebDriver driver) {
		this.driver = driver;		
	}
	
	CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
	
	//WebElements
	//-----------
	//Contact/Account Info section
	@CacheLookup
	@FindBy(xpath = "//*[@id='add_account_contact']")
	WebElement addAcctCntctEditView;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='add_account_contact']/div[2]/h2[1]")
	WebElement addAcctCntctContactAccountInfoHdr;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Mobile_SalesLogix_Fields_NameField_0']/input")
	WebElement addAcctCntctNameInputFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Mobile_SalesLogix_Fields_NameField_0']/button")
	WebElement addAcctCntctNameInputBtn;
	
	@CacheLookup
	@FindBy(css = "input[name='AccountName']")
	WebElement addAcctCntctAccountInputFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_TextField_3']/input")
	WebElement addAcctCntctEMailInputFld;
	
	@CacheLookup
	@FindBy(css = "input[name='WebAddress']")
	WebElement addAcctCntctWebInputFld;
	
	@CacheLookup
	@FindBy(css = "input[name='MainPhone']")
	WebElement addAcctCntctWorkPhoneInputFld;
	
	//Contact Info section
	@CacheLookup
	@FindBy(xpath = "//*[@id='add_account_contact']/div[2]/h2[2]")
	WebElement addAcctCntctContactInfoHdr;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Mobile_SalesLogix_Fields_PicklistField_0']/input")
	WebElement addAcctCntctTitleInputFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Mobile_SalesLogix_Fields_PicklistField_0']/button")
	WebElement addAcctCntctTitleInputBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_PhoneField_1']/input")
	WebElement addAcctCntctHomePhoneInputFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_PhoneField_2']/input")
	WebElement addAcctCntctMobileInputFld;

    @CacheLookup
    @FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_PhoneField_3']/input")
    WebElement addAcctCntContactWorkPhoneInputFld;

	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_PhoneField_4']/input")
	WebElement addAcctCntctFaxInputFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Mobile_SalesLogix_Fields_AddressField_0']/div")
	WebElement addAcctCntctAddressInputFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Mobile_SalesLogix_Fields_AddressField_0']/button")
	WebElement addAcctCntctAddressInputBtn;
	
	//Account Info section
	@CacheLookup
	@FindBy(css = "input[name='Fax']")
	WebElement addAcctCntctAcctFaxInputFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Mobile_SalesLogix_Fields_PicklistField_1']/input")
	WebElement addAcctCntctTypeInputFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Mobile_SalesLogix_Fields_PicklistField_1']/button")
	WebElement addAcctCntctTypeInputBtn;	
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Mobile_SalesLogix_Fields_PicklistField_2']/input")
	WebElement addAcctCntctSubTypeInputFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Mobile_SalesLogix_Fields_PicklistField_2']/button")
	WebElement addAcctCntctSubTypeInputBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Mobile_SalesLogix_Fields_PicklistField_3']/input")
	WebElement addAcctCntctStatusInputFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Mobile_SalesLogix_Fields_PicklistField_3']/button")
	WebElement addAcctCntctStatusFldBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Mobile_SalesLogix_Fields_PicklistField_4']/input")
	WebElement addAcctCntctIndustryInputFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Mobile_SalesLogix_Fields_PicklistField_4']/button")
	WebElement addAcctCntctIndustryFldBtn;
	
	@CacheLookup
	@FindBy(css = "input[name='BusinessDescription']")
	WebElement addAcctCntctDescInputFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_LookupField_0']/input")
	WebElement addAcctCntctAcctMgrInputFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_LookupField_0']/button")
	WebElement addAcctCntctAcctMgrFldBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_LookupField_1']/input")
	WebElement addAcctCntctOwnerInputFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_LookupField_1']/button")
	WebElement addAcctCntctOwnerFldBtn;		
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Mobile_SalesLogix_Fields_AddressField_1']/div")
	WebElement addAcctCntctAcctAddressInputFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Mobile_SalesLogix_Fields_AddressField_1']/button")
	WebElement addAcctCntctAcctAddressInputBtn;
	
	//Methods
	//-------
	public void doAddRandAccountContact(String strNewName, String strNewAccount) throws InterruptedException, IOException {
		String methodID = "doAddRandAccountContact";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);
		CommonViewsElements commView = PageFactory.initElements(driver, CommonViewsElements.class);
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
		
	    //Step: navigate to Accounts list view
		commNav.clickGlobalMenuItem("Add Account/Contact");
		
		try {
			//Setup the Contact/Account Info section fields:
			//set the name field
			addAcctCntctNameInputBtn.click();
			try {
				//commView.namePrefixInputFldBtn.click();
				//commView.selectFieldValListItem("prefix", "Mr.");
				commView.nameFirstInputFld.sendKeys("A.");
				commView.nameMiddleInputFld.sendKeys("Neo");
				commView.nameLastInputFld.sendKeys(strNewName);
				commView.nameSuffixInputFldBtn.sendKeys("Sr.");
				headerButton.clickHeaderButton("check");
			}
			catch (Exception e0) {
				System.out.println(methodID + "(): " + e0.toString());
				headerButton.goBack();
			}
			
			//set the account field
			addAcctCntctAccountInputFld.sendKeys(strNewAccount);
			
			//set the email field
			addAcctCntctEMailInputFld.sendKeys("add.account.contact.test@boguscompany.com");
			
			//set the web field
			addAcctCntctWebInputFld.sendKeys("www.saleslogix.com");
			
			//set the work phone field
			addAcctCntctWorkPhoneInputFld.sendKeys("800-867-5309");
			
			//Setup the Contact Info section:
			//set the title field
			addAcctCntctTitleInputFld.sendKeys("Assistant");
			
			//set the home phone field
			addAcctCntctHomePhoneInputFld.sendKeys("602.867.5309");
			
			//set the mobile field
			addAcctCntctMobileInputFld.sendKeys("(480)867-5309");
			
			//set the fax field
			addAcctCntctFaxInputFld.sendKeys("888-867-5309");
			
			//set the address field
			addAcctCntctAddressInputBtn.click();
			commView = PageFactory.initElements(driver, CommonViewsElements.class);
			try {
				commView.addressDescriptionInputFld.click();
				commView.addressDescriptionInputFld.sendKeys("Mailing");
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
			catch (Exception e1) {
				System.out.println(methodID + "(): " + e1.toString());
				headerButton.goBack();
			}
			
			//Setup the Account Info section:
			//set the fax field (skip - already set)
			
			//set the type field (leave as-is - Prospect)
				
			//set the sub-type field
			addAcctCntctSubTypeInputFld.sendKeys("Software");
			
			//set the status field (leave as-is - Active)
			
			//set the industry field
			addAcctCntctIndustryInputFld.sendKeys("Computers/Electronics/High Tech");
			
			//set the description field
			addAcctCntctDescInputFld.sendKeys("auto-test new Account & Contact");
			
			//set the acct mgr field (leave as-is)
			
			//set the owner field (leave as-is)
			
			//set the address field (skip - address already set earlier)			
		}
		catch (Exception e) {
			System.out.println(methodID + "(): " + e.toString());
		}
		
		//Step: save the new Account/Contact field values
		headerButton.clickHeaderButton("save");
		commNav.waitForNotPage("Add Account / Contact");
		
		System.out.println(methodID + ": Auto-test new Account - " +  strNewAccount + " with new Contact - " + strNewName + "records were created.");
	}


	public void doAddRandAccountOnly(String strNewName, String strNewAccount) throws InterruptedException, IOException {
		String methodID = "doAddRandAccountOnly";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);
		CommonViewsElements commView = PageFactory.initElements(driver, CommonViewsElements.class);
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
		
	    //Step: navigate to Accounts list view
		commNav.clickGlobalMenuItem("Add Account/Contact");
		
		try {
			//Setup the Contact/Account Info section fields:
			//set the name field
			addAcctCntctNameInputBtn.click();
			try {
				//commView.namePrefixInputFldBtn.click();
				//commView.selectFieldValListItem("prefix", "Mr.");
				commView.nameFirstInputFld.sendKeys("A.");
				commView.nameMiddleInputFld.sendKeys("Neo");
				commView.nameLastInputFld.sendKeys(strNewName);
				commView.nameSuffixInputFld.sendKeys("Sr.");
				headerButton.clickHeaderButton("check");
			}
			catch (Exception e0) {
				System.out.println(methodID + "(): " + e0.toString());
				headerButton.goBack();
			}
			
			//set the account field
			addAcctCntctAccountInputFld.sendKeys(strNewAccount);
			
			//set the email field
			addAcctCntctEMailInputFld.sendKeys("add.account.contact.test@boguscompany.com");
			
			//set the web field
			addAcctCntctWebInputFld.sendKeys("www.saleslogix.com");
			
			//set the work phone field
			addAcctCntctWorkPhoneInputFld.sendKeys("800-867-5309");
						
			//Setup the Account Info section:
			//set the fax field
			addAcctCntctAcctFaxInputFld.sendKeys("888-867-5309");
			
			//set the type field (leave as-is - Prospect)
				
			//set the sub-type field
			addAcctCntctSubTypeInputFld.sendKeys("Software");
			
			//set the status field (leave as-is - Active)
			
			//set the industry field
			addAcctCntctIndustryInputFld.sendKeys("Computers/Electronics/High Tech");
			
			//set the description field
			addAcctCntctDescInputFld.sendKeys("auto-test new Account & Contact");
			
			//set the acct mgr field (leave as-is)
			
			//set the owner field (leave as-is)
			
			//set the address field
			addAcctCntctAcctAddressInputBtn.click();
			try {
				commView.addressDescriptionInputFldBtn.click();
				commView.selectFieldValListItem("description", "Mailing");
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
			catch (Exception e1) {
				System.out.println(methodID + "(): " + e1.toString());
				headerButton.goBack();
			}
		}
		catch (Exception e) {
			System.out.println(methodID + "(): " + e.toString());
		}
		
		//Step: save the new Account/Contact field values
		headerButton.clickHeaderButton("save");
		commNav.waitForNotPage("Add Account / Contact");
		
		System.out.println(methodID + ": Auto-test new Account - " +  strNewAccount + " with new Contact - " + strNewName + "records were created.");
	}


	public void doAddRandContactOnly(String strNewName, String strNewAccount) throws InterruptedException, IOException {
		String methodID = "doAddRandContactOnly";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);
		CommonViewsElements commView = PageFactory.initElements(driver, CommonViewsElements.class);
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
		
	    //Step: navigate to Accounts list view
		commNav.clickGlobalMenuItem("Add Account/Contact");
		
		try {
			//Setup the Contact/Account Info section fields:
			//set the name field
			addAcctCntctNameInputBtn.click();
			try {
				//commView.namePrefixInputFldBtn.click();
				//commView.selectFieldValListItem("prefix", "Mr.");
				commView.nameFirstInputFld.sendKeys("A.");
				commView.nameMiddleInputFld.sendKeys("Neo");
				commView.nameLastInputFld.sendKeys(strNewName);
				//commView.nameSuffixInputFld.sendKeys("Sr.");
				headerButton.clickHeaderButton("check");
			}
			catch (Exception e0) {
				System.out.println(methodID + "(): " + e0.toString());
				headerButton.goBack();
			}
			
			//set the account field
			addAcctCntctAccountInputFld.sendKeys(strNewAccount);
			
			//set the email field
			addAcctCntctEMailInputFld.sendKeys("add.account.contact.test@boguscompany.com");
			
			//set the web field
			addAcctCntctWebInputFld.sendKeys("www.saleslogix.com");
			
			//set the work phone field
			addAcctCntctWorkPhoneInputFld.sendKeys("800-867-5309");
			
			//Setup the Contact Info section:
			//set the title field
			addAcctCntctTitleInputFld.sendKeys("Assistant");
			
			//set the home phone field
			addAcctCntctHomePhoneInputFld.sendKeys("602.867.5309");
			
			//set the mobile field
			addAcctCntctMobileInputFld.sendKeys("(480)867-5309");
			
			//set the fax field
			addAcctCntctFaxInputFld.sendKeys("888-867-5309");
			
			//set the address field
			addAcctCntctAddressInputBtn.click();
			try {
				commView.addressDescriptionInputFld.sendKeys("Mailing");
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
			catch (Exception e1) {
				System.out.println(methodID + "(): " + e1.toString());
				headerButton.goBack();
			}
						
		}
		catch (Exception e) {
			System.out.println(methodID + "(): " + e.toString());
		}
		
		//Step: save the new Account/Contact field values
		headerButton.clickHeaderButton("save");
		commNav.waitForNotPage("Add Account / Contact");
		
		System.out.println(methodID + ": Auto-test new Contact only - " +  strNewName + " with new Account - " + strNewAccount + "records were created.");
	}
}
