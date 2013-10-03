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


public class AddAccountContactEditViewElements extends BrowserSetup {
	
	private WebDriver driver;

	public AddAccountContactEditViewElements(WebDriver driver) {
		this.driver = driver;		
	}
	
	CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
			
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
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_TextField_62']/input")
	WebElement addAcctCntctAccountInputFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_TextField_63']/input")
	WebElement addAcctCntctEMailInputFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_TextField_64']/input")
	WebElement addAcctCntctWebInputFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_PhoneField_0']/input")
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
	WebElement addAcctCntctFaxInputFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Mobile_SalesLogix_Fields_AddressField_0']/div")
	WebElement addAcctCntctAddressInputFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Mobile_SalesLogix_Fields_AddressField_0']/button")
	WebElement addAcctCntctAddressInputBtn;
	
	
	//Account Info section
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_PhoneField_4']/input")
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
	WebElement addAcctCntctStatusFldInput;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Mobile_SalesLogix_Fields_PicklistField_3']/button")
	WebElement addAcctCntctStatusFldBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Mobile_SalesLogix_Fields_PicklistField_4']/input")
	WebElement addAcctCntctIndustryFldInput;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Mobile_SalesLogix_Fields_PicklistField_4']/button")
	WebElement addAcctCntctIndustryFldBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_TextField_65']/input")
	WebElement addAcctCntctDescFldInput;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_LookupField_20']/input")
	WebElement addAcctCntctAcctMgrFldInput;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_LookupField_20']/button")
	WebElement addAcctCntctAcctMgrFldBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_LookupField_1']/input")
	WebElement addAcctCntctOwnerFldInput;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_LookupField_1']/button")
	WebElement addAcctCntctOwnerFldBtn;		
	
	//Methods
	//TBD
}
