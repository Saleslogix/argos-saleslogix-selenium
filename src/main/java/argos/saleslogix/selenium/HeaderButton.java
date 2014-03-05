package argos.saleslogix.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.AssertJUnit;

import java.io.IOException;

public class HeaderButton {

    //@CacheLookup
    @FindBy(xpath = "//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']//descendant::*[@aria-label='toggleLeftDrawer']")
    public WebElement globalMenuButton;
    //@CacheLookup
    @FindBy(xpath = "//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']//descendant::*[@aria-label='toggleRightDrawer']")
    public WebElement rightCntxtMnuButton;
    //@CacheLookup
    @FindBy(xpath = "//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']//descendant::*[@aria-label='new']")
    public WebElement addButton;
    //@CacheLookup
    @FindBy(xpath = "//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']//descendant::*[@aria-label='edit']")
    public WebElement editButton;
    //@CacheLookup
    @FindBy(xpath = "//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']//descendant::*[@aria-label='save']")
    public WebElement saveButton;
    //@CacheLookup
    @FindBy(xpath = "//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']//descendant::*[@aria-label='complete']")
    public WebElement checkButton;
    //@CacheLookup
    @FindBy(xpath = "//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']//descendant::*[@aria-label='delete']")
    public WebElement deleteButton;
    //@CacheLookup
    @FindBy(xpath = "//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']//descendant::*[@aria-label='cancel']")
    public WebElement cancelButton;
    //@CacheLookup
    @FindBy(xpath = "//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']//descendant::*[@aria-label='back']")
    public WebElement backButton;
    private WebDriver driver;

    public HeaderButton(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * This method will click the header Global Menu button to display the Global Menu items.
     *
     * @throws InterruptedException
     */
    public HeaderButton showGlobalMenu() throws InterruptedException {
        String methodID = "showGlobalMenu";

        //click the Page Title (forces closure of any blocking panels)
        driver.findElement(By.id("pageTitle")).click();
        WebDriverWait wait = new WebDriverWait(driver, 1);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id='left_drawer']")));

        // Click Header Global Menu button...
        clickHeaderButton("global");

        // Verify the 'Global Menu' left-screen displays...
        try {
            AssertJUnit.assertTrue(driver.findElement(By.xpath("//*[@id='left_drawer']")).isDisplayed());
            System.out.println("VP: Global Menu was accessed successfully on header button click.");
        } catch (Error e) {
            System.out.println("Error: Global Menu failed to display on header button click.");
            System.out.println(methodID + "(): " + e.toString());
        }

        return this;
    }

    public boolean showRightContextMenu() throws InterruptedException {
        String methodID = "showRightContextMenu";

        // Click Header Right-Context Menu button...
        clickHeaderButton("right context menu");

        // Verify the 'Right-Context Menu' left-screen displays...
        try {
            AssertJUnit.assertTrue(driver.findElement(By.xpath(".//*[@id='right_drawer']/div")).isDisplayed());
            System.out.println(methodID + ": Right-Context Menu was accessed successfully on header button click.");
            return true;
        } catch (Error e) {
            System.out.println(methodID + ": Right-Context Menu failed to display on header button click.");
            System.out.println(methodID + "(): " + e.toString());
            return false;
        }
    }

    public HeaderButton goBack() throws InterruptedException {
        String methodID = "goBack";
        String xpath = ".//*[@id='pageTitle']";

        WebElement pgTitleBar = driver.findElement(By.xpath(xpath));
        String oldPgTitle = driver.findElement(By.xpath(xpath)).getText();

        //conditionally close the Right Context Menu panel (if blocking the Global Menu button)
        closeRightContextMenu();

        try {
            //click the Header Back button
            backButton.click();
        } catch (Exception e) {
            //revert to Backspace key-press if Back button click fails
            pgTitleBar.click();
            pgTitleBar.sendKeys(Keys.BACK_SPACE);
        }

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.not(ExpectedConditions.textToBePresentInElementLocated(By.xpath(xpath), oldPgTitle)));
        String newPgTitle = driver.findElement(By.xpath(xpath)).getText();

        // Verify that previous page is displayed (new title not equal to old)
        try {
            AssertJUnit.assertFalse(oldPgTitle == newPgTitle);
        } catch (Error e) {
            System.out.println(methodID + "(): " + e.toString());
        }
        return this;
    }

    public HeaderButton clickHeaderButton(String buttonName) throws InterruptedException {
        String methodID = "clickHeaderButton";

        switch (buttonName.toLowerCase()) {
            case "global menu":
            case "global":
                globalMenuButton.click();
                break;
            case "right context menu":
            case "right menu":
            case "right":
                rightCntxtMnuButton.click();
                break;
            case "back":
            case "go back":
                backButton.click();
                break;
            case "cancel":
                cancelButton.click();
                break;
            case "add":
            case "add new":
                addButton.click();
                break;
            case "edit":
                editButton.click();
                break;
            case "check":
            case "accept":
                checkButton.click();
                break;
            case "delete":
                deleteButton.click();
                break;
            case "save":
                saveButton.click();
                break;
        }

        System.out.println(methodID + ": header button - '" + buttonName + "' was clicked.");
        return this;
    }

    public boolean closeRightContextMenu() throws InterruptedException {
        String methodID = "closeRightContextMenu";

        //conditionally close the Right-Context menu...
        if (driver.findElement(By.xpath(".//*[@id='right_drawer']")).isDisplayed()) {
            // Click Header Right-Context Menu button...
            clickHeaderButton("right context menu");
        }
        return true;
    }

    public static class AddAccountContactEditViewElements {

        //WebElements
        //-----------
        //Contact/Account Info section
        @CacheLookup
        @FindBy(xpath = "//*[@id='add_account_contact']")
        public WebElement addAcctCntctEditView;
        @CacheLookup
        @FindBy(xpath = "//*[@id='add_account_contact']/div[2]/h2[1]")
        public WebElement addAcctCntctContactAccountInfoHdr;
        @CacheLookup
        @FindBy(xpath = "//*[@id='Mobile_SalesLogix_Fields_NameField_0']/input")
        public WebElement addAcctCntctNameInputFld;
        @CacheLookup
        @FindBy(xpath = "//*[@id='Mobile_SalesLogix_Fields_NameField_0']/button")
        public WebElement addAcctCntctNameInputBtn;
        @CacheLookup
        @FindBy(css = "input[name='AccountName']")
        public WebElement addAcctCntctAccountInputFld;
        @CacheLookup
        @FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_TextField_3']/input")
        public WebElement addAcctCntctEMailInputFld;
        @CacheLookup
        @FindBy(css = "input[name='WebAddress']")
        public WebElement addAcctCntctWebInputFld;
        @CacheLookup
        @FindBy(css = "input[name='MainPhone']")
        public WebElement addAcctCntctWorkPhoneInputFld;
        //Contact Info section
        @CacheLookup
        @FindBy(xpath = "//*[@id='add_account_contact']/div[2]/h2[2]")
        public WebElement addAcctCntctContactInfoHdr;
        @CacheLookup
        @FindBy(xpath = "//*[@id='Mobile_SalesLogix_Fields_PicklistField_0']/input")
        public WebElement addAcctCntctTitleInputFld;
        @CacheLookup
        @FindBy(xpath = "//*[@id='Mobile_SalesLogix_Fields_PicklistField_0']/button")
        public WebElement addAcctCntctTitleInputBtn;
        @CacheLookup
        @FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_PhoneField_1']/input")
        public WebElement addAcctCntctHomePhoneInputFld;
        @CacheLookup
        @FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_PhoneField_2']/input")
        public WebElement addAcctCntctMobileInputFld;
        @CacheLookup
        @FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_PhoneField_3']/input")
        public WebElement addAcctCntctFaxInputFld;
        @CacheLookup
        @FindBy(xpath = "//*[@id='Mobile_SalesLogix_Fields_AddressField_0']/div")
        public WebElement addAcctCntctAddressInputFld;
        @CacheLookup
        @FindBy(xpath = "//*[@id='Mobile_SalesLogix_Fields_AddressField_0']/button")
        public WebElement addAcctCntctAddressInputBtn;
        //Account Info section
        @CacheLookup
        @FindBy(css = "input[name='Fax']")
        public WebElement addAcctCntctAcctFaxInputFld;
        @CacheLookup
        @FindBy(xpath = "//*[@id='Mobile_SalesLogix_Fields_PicklistField_1']/input")
        public WebElement addAcctCntctTypeInputFld;
        @CacheLookup
        @FindBy(xpath = "//*[@id='Mobile_SalesLogix_Fields_PicklistField_1']/button")
        public WebElement addAcctCntctTypeInputBtn;
        @CacheLookup
        @FindBy(xpath = "//*[@id='Mobile_SalesLogix_Fields_PicklistField_2']/input")
        public WebElement addAcctCntctSubTypeInputFld;
        @CacheLookup
        @FindBy(xpath = "//*[@id='Mobile_SalesLogix_Fields_PicklistField_2']/button")
        public WebElement addAcctCntctSubTypeInputBtn;
        @CacheLookup
        @FindBy(xpath = "//*[@id='Mobile_SalesLogix_Fields_PicklistField_3']/input")
        public WebElement addAcctCntctStatusInputFld;
        @CacheLookup
        @FindBy(xpath = "//*[@id='Mobile_SalesLogix_Fields_PicklistField_3']/button")
        public WebElement addAcctCntctStatusFldBtn;
        @CacheLookup
        @FindBy(xpath = "//*[@id='Mobile_SalesLogix_Fields_PicklistField_4']/input")
        public WebElement addAcctCntctIndustryInputFld;
        @CacheLookup
        @FindBy(xpath = "//*[@id='Mobile_SalesLogix_Fields_PicklistField_4']/button")
        public WebElement addAcctCntctIndustryFldBtn;
        @CacheLookup
        @FindBy(css = "input[name='BusinessDescription']")
        public WebElement addAcctCntctDescInputFld;
        @CacheLookup
        @FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_LookupField_0']/input")
        public WebElement addAcctCntctAcctMgrInputFld;
        @CacheLookup
        @FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_LookupField_0']/button")
        public WebElement addAcctCntctAcctMgrFldBtn;
        @CacheLookup
        @FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_LookupField_1']/input")
        public WebElement addAcctCntctOwnerInputFld;
        @CacheLookup
        @FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_LookupField_1']/button")
        public WebElement addAcctCntctOwnerFldBtn;
        @CacheLookup
        @FindBy(xpath = "//*[@id='Mobile_SalesLogix_Fields_AddressField_1']/div")
        public WebElement addAcctCntctAcctAddressInputFld;
        @CacheLookup
        @FindBy(xpath = "//*[@id='Mobile_SalesLogix_Fields_AddressField_1']/button")
        public WebElement addAcctCntctAcctAddressInputBtn;
        private WebDriver driver;
        CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);

        public AddAccountContactEditViewElements(WebDriver driver) {
            this.driver = driver;
        }

        //Methods
        //-------
        public void doAddRandAccountContact(String strNewName, String strNewAccount) throws InterruptedException, IOException {
            String methodID = "doAddRandAccountContact";

            CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
            HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);
            CommonViewsElements commView = PageFactory.initElements(driver, CommonViewsElements.class);

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
                } catch (Exception e0) {
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
                } catch (Exception e1) {
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
            } catch (Exception e) {
                System.out.println(methodID + "(): " + e.toString());
            }

            //Step: save the new Account/Contact field values
            headerButton.clickHeaderButton("save");
            commNav.waitForNotPage("Add Account / Contact");

            System.out.println(methodID + ": Auto-test new Account - " + strNewAccount + " with new Contact - " + strNewName + "records were created.");
        }


        public void doAddRandAccountOnly(String strNewName, String strNewAccount) throws InterruptedException, IOException {
            String methodID = "doAddRandAccountOnly";

            CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
            HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);
            CommonViewsElements commView = PageFactory.initElements(driver, CommonViewsElements.class);

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
                } catch (Exception e0) {
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
                } catch (Exception e1) {
                    System.out.println(methodID + "(): " + e1.toString());
                    headerButton.goBack();
                }
            } catch (Exception e) {
                System.out.println(methodID + "(): " + e.toString());
            }

            //Step: save the new Account/Contact field values
            headerButton.clickHeaderButton("save");
            commNav.waitForNotPage("Add Account / Contact");

            System.out.println(methodID + ": Auto-test new Account - " + strNewAccount + " with new Contact - " + strNewName + "records were created.");
        }


        public void doAddRandContactOnly(String strNewName, String strNewAccount) throws InterruptedException, IOException {
            String methodID = "doAddRandContactOnly";

            CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
            HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);
            CommonViewsElements commView = PageFactory.initElements(driver, CommonViewsElements.class);

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
                } catch (Exception e0) {
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
                } catch (Exception e1) {
                    System.out.println(methodID + "(): " + e1.toString());
                    headerButton.goBack();
                }

            } catch (Exception e) {
                System.out.println(methodID + "(): " + e.toString());
            }

            //Step: save the new Account/Contact field values
            headerButton.clickHeaderButton("save");
            commNav.waitForNotPage("Add Account / Contact");

            System.out.println(methodID + ": Auto-test new Contact only - " + strNewName + " with new Account - " + strNewAccount + "records were created.");
        }
    }
}
