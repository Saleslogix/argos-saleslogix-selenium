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


public class MiscEntityItemViewsElements extends BrowserSetup {
	
	private WebDriver driver;

	public MiscEntityItemViewsElements(WebDriver driver) {
		this.driver = driver;		
	}
	
	CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
	
	//Address Edit view elements
	@CacheLookup
	@FindBy(xpath = "//*[@id='address_edit']")
	WebElement addressEditView;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='address_edit']/div[2]/h2")
	WebElement addressEditHdr;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Mobile_SalesLogix_Fields_PicklistField_7']/input")
	WebElement addressEditDescriptionInputFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Mobile_SalesLogix_Fields_PicklistField_7']/button")
	WebElement addressEditDescriptionInputBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_BooleanField_1']/div/span[1]")
	WebElement addressEditPrimaryTglBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_BooleanField_2']/div/span[1]")
	WebElement addressEditShippingTglBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_TextField_69']/input")
	WebElement addressEditAddress1InputFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_TextField_70']/input")
	WebElement addressEditAddress2InputFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_TextField_71']/input")
	WebElement addressEditAddress3InputFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Mobile_SalesLogix_Fields_PicklistField_8']/input")
	WebElement addressEditCityInputFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Mobile_SalesLogix_Fields_PicklistField_8']/button")
	WebElement addressEditCityInputBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Mobile_SalesLogix_Fields_PicklistField_9']/input")
	WebElement addressEditStateInputFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Mobile_SalesLogix_Fields_PicklistField_9']/button")
	WebElement addressEditStateInputBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_TextField_72']/input")
	WebElement addressEditPostalInputFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Mobile_SalesLogix_Fields_PicklistField_10']/input")
	WebElement addressEditCountryInputFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Mobile_SalesLogix_Fields_PicklistField_10']/button")
	WebElement addressEditCountryInputBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_TextField_73']/input")
	WebElement addressEditAttentionInputFld;
	
	
	//Name Edit view elements
	@CacheLookup
	@FindBy(xpath = "//*[@id='name_edit']")
	WebElement nameEditView;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='name_edit']/div[2]/h2")
	WebElement nameEditHdr;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Mobile_SalesLogix_Fields_PicklistField_5']/input")
	WebElement nameEditPrefixInputFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Mobile_SalesLogix_Fields_PicklistField_5']/button")
	WebElement nameEditPrefixInputBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_TextField_66']/input")
	WebElement nameEditFirstInputFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_TextField_67']/input")
	WebElement nameEditMiddleInputFld;

	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_TextField_68']/input")
	WebElement nameEditLastInputFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Mobile_SalesLogix_Fields_PicklistField_6']/input")
	WebElement nameEditSuffixInputFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Mobile_SalesLogix_Fields_PicklistField_6']/button")
	WebElement nameEditSuffixInputBtn;
	
		
	//Methods
	//TODO: create a setupNameFields() method that sets and saves the Name input fields with given values
	
	//TODO: create a new setupAddressFields() method that sets and saves the Address input fields with given values
}
