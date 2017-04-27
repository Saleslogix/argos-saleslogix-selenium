package argos.saleslogix.selenium.pages;

import argos.saleslogix.selenium.test.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


/**
 * CommonViewsElements class defines webelements and methods for any common List, Edit and Detail view
 * that can be invoked from any entity-based view (i.e. Address or Name fields).
 *
 * @author mike.llena@swiftpage.com
 * @version 1.0
 * @see BaseTest
 */
public class CommonViewsElements extends BaseTest {

    //Main lookup field seen at top of screen all throughout Mobile
    @CacheLookup
    @FindBy(xpath = "//*[@selected='selected']//input[@name='query']")
    public WebElement lookupTxtBox;
    //Address input fields:
    @FindBy(xpath = "//*[@id='address_edit']/descendant::*[@type='text'][1]")
    public WebElement addressDescriptionInputFld;
    @FindBy(xpath = "//*[@id='address_edit']/descendant::*[@aria-label='lookup'][1]")
    public WebElement addressDescriptionInputFldBtn;

    //Edit View elements
    //==================
    @FindBy(xpath = "//div[@selected='selected']//div[@data-field='IsPrimary']")
    public WebElement addressPrimaryTgl;
    @FindBy(xpath = "//div[@selected='selected']//div[@data-field='IsMailing']")
    public WebElement addressShippingTgl;
    @FindBy(css = "input[name='Address1']")
    public WebElement addressLine1;
    @FindBy(css = "input[name='Address2']")
    public WebElement addressLine2;
    @FindBy(css = "input[name='Address3']")
    public WebElement addressLine3;
    @FindBy(xpath = "//*[@id='address_edit']/descendant::*[@type='text'][5]")
    public WebElement addressCityInputFld;
    @FindBy(xpath = "//*[@id='address_edit']/descendant::*[@aria-label='lookup'][5]")
    public WebElement addressCityInputFldBtn;
    @FindBy(xpath = "//*[@id='address_edit']/descendant::*[@type='text'][6]")
    public WebElement addressStateInputFld;
    @FindBy(xpath = "//*[@id='address_edit']/descendant::*[@aria-label='lookup'][6]")
    public WebElement addressStateInputFldBtn;
    @FindBy(css = "input[name='PostalCode']")
    public WebElement addressPostalInputFld;
    @FindBy(xpath = "//*[@id='address_edit']/descendant::*[@type='text'][8]")
    public WebElement addressCountryInputFld;
    @FindBy(xpath = "//*[@id='address_edit']/descendant::*[@aria-label='lookup'][8]")
    public WebElement addressCountryInputFldBtn;
    @FindBy(css = "input[name='Salutation']")
    public WebElement addressAttentionInputFld;
    //Edit Name input fields:
    //=======================
    @FindBy(xpath = "//*[@id='name_edit']/descendant::*[@type='text'][1]")
    public WebElement namePrefixInputFld;
    @FindBy(xpath = "//*[@id='crm_Fields_PicklistField_5']/button")
    public WebElement namePrefixInputFldBtn;
    @FindBy(css = "input[name='FirstName']")
    public WebElement nameFirstInputFld;
    @FindBy(css = "input[name='MiddleName']")
    public WebElement nameMiddleInputFld;
    @FindBy(css = "input[name='LastName']")
    public WebElement nameLastInputFld;
    @FindBy(xpath = "//*[@id='name_edit']/descendant::*[@type='text'][5]")
    public WebElement nameSuffixInputFld;
    @FindBy(xpath = "//*[@id='crm_Fields_PicklistField_6']/button")
    public WebElement nameSuffixInputFldBtn;
    //List View selection elements
    //============================
    //Account Type selection:
    @CacheLookup
    @FindBy(css = "input[name='query']")
    public WebElement accountTypeLookupInputFld;
    @CacheLookup
    @FindBy(xpath = "//div[3]/button")
    public WebElement accountTypeLookupBtn;
    //City selection:
    @CacheLookup
    @FindBy(css = "input[name='query']")
    public WebElement cityLookupInputFld;
    @CacheLookup
    @FindBy(xpath = "//div[3]/button")
    public WebElement cityLookupBtn;
    @CacheLookup
    @FindBy(xpath = ".//*[@id='pick_list_4']/div[2]/button")
    public WebElement citySelectNoneBtn;
    //Country selection:
    @CacheLookup
    @FindBy(css = "input[name='query']")
    public WebElement countryLookupInputFld;
    @CacheLookup
    @FindBy(xpath = "//div[3]/button")
    public WebElement countryLookupBtn;
    @CacheLookup
    @FindBy(xpath = ".//*[@id='pick_list_3']/div[2]/button")
    public WebElement countrySelectNoneBtn;
    //Cuisine selection:
    @CacheLookup
    @FindBy(css = "input[name='query']")
    public WebElement cuisineLookupInputFld;
    @CacheLookup
    @FindBy(xpath = "//div[3]/button")
    public WebElement cuisineLookupBtn;
    @CacheLookup
    @FindBy(xpath = ".//*[@id='pick_list_3']/div[2]/button")
    public WebElement cuisineSelectNoneBtn;
    //Description selection:
    @CacheLookup
    @FindBy(xpath = ".//*[@id='argos_SearchWidget_43']/div/div[1]/input")
    public WebElement descriptionLookupInputFld;
    @CacheLookup
    @FindBy(xpath = ".//*[@id='argos_SearchWidget_43']/div/div[3]/button")
    public WebElement descriptionLookupBtn;
    @CacheLookup
    @FindBy(xpath = ".//*[@id='pick_list_0']/div[2]/button")
    public WebElement descriptionSelectNoneBtn;
    //Industry selection:
    @CacheLookup
    @FindBy(xpath = ".//*[@id='argos_SearchWidget_49']/div/div[1]/input")
    public WebElement industryLookupInputFld;
    @CacheLookup
    @FindBy(xpath = ".//*[@id='argos_SearchWidget_49']/div/div[3]/button")
    public WebElement industryLookupBtn;
    @CacheLookup
    @FindBy(xpath = ".//*[@id='pick_list_6']/div[2]/button")
    public WebElement industrySelectNoneBtn;
    //General List View search field:
    @CacheLookup
    @FindBy(css = "input[name='query']")
    public WebElement listViewSearchInputFld;
    //Lead Source selection:
    @CacheLookup
    @FindBy(xpath = ".//*[@id='argos_SearchWidget_33']/div/div[1]/input")
    public WebElement leadSourceLookupInputFld;
    @CacheLookup
    @FindBy(xpath = ".//*[@id='argos_SearchWidget_33']/div/div[3]/button")
    public WebElement leadSourceLookupBtn;
    //Name Prefix selection:
    @CacheLookup
    @FindBy(xpath = ".//*[@id='argos_SearchWidget_43']/div/div[1]/input")
    public WebElement namePrefixLookupInputFld;
    @CacheLookup
    @FindBy(xpath = ".//*[@id='argos_SearchWidget_43']/div/div[3]/button")
    public WebElement namePrefixLookupBtn;
    //Name Suffix selection:
    @CacheLookup
    @FindBy(xpath = ".//*[@id='argos_SearchWidget_44']/div/div[1]/input")
    public WebElement nameSuffixLookupInputFld;
    @CacheLookup
    @FindBy(xpath = ".//*[@id='argos_SearchWidget_44']/div/div[3]/button")
    public WebElement nameSuffixLookupBtn;
    //Owner selection:
    @CacheLookup
    @FindBy(xpath = ".//*[@id='argos_SearchWidget_30']/div/div[1]/input")
    public WebElement ownerLookupInputFld;
    @CacheLookup
    @FindBy(xpath = ".//*[@id='argos_SearchWidget_30']/div/div[3]/button")
    public WebElement ownerLookupBtn;
    //State selection:
    @CacheLookup
    @FindBy(css = "input[name='query']")
    public WebElement stateLookupInputFld;
    @CacheLookup
    @FindBy(xpath = ".//*[@id='argos_SearchWidget_45']/div/div[3]/button")
    public WebElement stateLookupBtn;
    @CacheLookup
    @FindBy(xpath = ".//*[@id='pick_list_2']/div[2]/button")
    public WebElement stateSelectNoneBtn;
    //Account Status selection:
    @CacheLookup
    @FindBy(xpath = ".//*[@id='argos_SearchWidget_48']/div/div[1]/input")
    public WebElement statusLookupInputFld;
    @CacheLookup
    @FindBy(xpath = ".//*[@id='argos_SearchWidget_48']/div/div[3]/button")
    public WebElement statusLookupBtn;
    @CacheLookup
    @FindBy(xpath = ".//*[@id='pick_list_5']/div[2]/button")
    public WebElement statusSelectNoneBtn;
    //Account Subtype selection:
    @CacheLookup
    @FindBy(css = "input[name='query']")
    public WebElement subtypeLookupInputFld;
    @CacheLookup
    @FindBy(xpath = ".//*[@id='argos_SearchWidget_43']/div/div[3]/button")
    public WebElement subtypeLookupBtn;
    @CacheLookup
    @FindBy(xpath = ".//*[@id='pick_list_0']/div[2]/button")
    public WebElement subtypeSelectNoneBtn;
    //Title (name) selection:
    @CacheLookup
    @FindBy(xpath = ".//*[@id='argos_SearchWidget_45']/div/div[1]/input")
    public WebElement titleLookupInputFld;
    @CacheLookup
    @FindBy(xpath = ".//*[@id='argos_SearchWidget_45']/div/div[1]/button")
    public WebElement titleLookupBtn;
    @CacheLookup
    @FindBy(xpath = ".//*[@id='pick_list_2']/div[2]/button")
    public WebElement titleSelectNoneBtn;
    //Users selection:
    @CacheLookup
    @FindBy(xpath = ".//*[@id='argos_SearchWidget_29']/div/div[1]/input")
    public WebElement userLookupInputFld;
    @CacheLookup
    @FindBy(xpath = ".//*[@id='argos_SearchWidget_29']/div/div[3]/button")
    public WebElement userLookupBtn;
    //Briefcase Complete toast elements
    @CacheLookup
    @FindBy(xpath = ".//*[@id='modal-template']//div[contains(text(), 'Okay')]")
    public WebElement briefcaseCompleteOkayBtn;
    @CacheLookup
    @FindBy(xpath = ".//*[@id='modal-template']//div[contains(text(), 'Cancel')]")
    public WebElement briefcaseCompleteCancelBtn;
    //Offline Options under Settings
    @CacheLookup
    @FindBy(xpath = ".//*[@id='settings']//li[@data-action='viewOfflineOptions']")
    public WebElement settingsOfflineOptions;
    //Use 24 hour clock under Settings
    @CacheLookup
    @FindBy(xpath = ".//*[@id='settings']//li[@data-action='use24HourClock']")
    public WebElement settingsUse24HourClock;
    //Offline Options elements
    @CacheLookup
    @FindBy(xpath = "//*[@id='olderThan-dropdown offline_usage_widget_undefined']/input")
    public WebElement offlineDataOlderField;
    @CacheLookup
    @FindBy(xpath = "//ul/li[@data-value='0']")
    public WebElement offlineDataOlderZeroDays;
    @CacheLookup
    @FindBy(xpath = "//*[@id='offline_usage_widget_undefined']//button[@data-dojo-attach-event='onclick:onClearAllData']")
    public WebElement offlineDataClearBtn;
    @CacheLookup
    @FindBy(xpath = "//*[@id='offline_usage_widget_undefined']//button[@data-dojo-attach-event='onclick:onClearBriefcasedData']")
    public WebElement offlineDataClearBriefcaseBtn;
    @CacheLookup
    @FindBy(xpath = "//*[@id='offline_usage_widget_undefined']//button[@data-dojo-attach-event='onclick:onClearRecentData']")
    public WebElement offlineDataClearRecViewedBtn;
    @CacheLookup
    @FindBy(id = "toast-container")
    public WebElement toastContainer;
    //Text Input view elements
    //========================
    //Business Description
    @CacheLookup
    @FindBy(xpath = ".//*[@id='argos_Fields_TextAreaField_0']/textarea")
    public WebElement busdescTxtArea;
    private WebDriver driver;
    CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);

    public CommonViewsElements(WebDriver driver) {
        this.driver = driver;
    }

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
     * @throws InterruptedException
     * @param    strFieldName field value label name that invokes this list view selection
     * @param    strSelectItem    target list item to search and select
     */
    public void lookupNSelectListItem(String strFieldName, String strSelectItem) throws InterruptedException {
        String methodID = "lookupNSelectListItem";

        String listXPathSubStr = "";
        String listItemXPath = "";
        //.//*[@id='owner_list']
        //setup common elements based on field name to set
        switch (strFieldName.toLowerCase()) {
            case "lead source":
            case "lead sources":
                listXPathSubStr = "//*[@id='leadsource_list']";
                break;
            case "owners":
            case "owner":
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
        } catch (Exception e) {
            System.out.println(methodID + "(): " + e.toString());
        }

    }


    /**
     * The selectFieldValListItem method will search for and select an item from a field input list
     * view selection list (i.e. Account Type, City, Industry, etc.).  This method should be called
     * immediately after clicking an input field button that invokes a list view selection.
     *
     * @throws InterruptedException
     * @param    strFieldName field value label name that invokes this list view selection
     * @param    strSelectItem    target list item to search and select
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
            case "account type":
            case "type":
                pageTitle = "Account Type";
                lookupBtn = accountTypeLookupBtn;
                pickListID = "pick_list_4";
                break;
            case "account subtype":
            case "subtype":
            case "sub type":
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
            case "name prefix":
            case "prefix":
                pageTitle = "Name Prefix";
                lookupBtn = namePrefixLookupBtn;
                pickListID = "pick_list_0";
                break;
            case "name suffix":
            case "suffix":
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
            case "user":
            case "users":
            case "acct mgr":
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
                    } else {
                        commNav.clickListViewGridItem(By.xpath("//li[1]/div/h3"));
                    }
                    System.out.println(methodID + ": " + strFieldName + " - " + strSelectItem + " was selected.");
                } catch (Exception e) {
                    System.out.println(methodID + "():" + e.toString());
                    System.out.println(methodID + "(): " + strFieldName + " - " + strSelectItem + " was NOT found; selection skipped.");
                    driver.findElement(By.xpath(hdrCancelBtnXPath)).click();
                }
            }

            Thread.sleep(1000);
            commNav.waitForNotPage(pageTitle);
        } else {
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
            } else {
                accountTypeLookupInputFld.sendKeys(strAccType);
                accountTypeLookupBtn.click();
                Thread.sleep(2000);
                try {
                    commNav.clickListViewGridItem(By.xpath(".//*[@id='pick_list_4']/descendant::*[text() = '" + strAccType + "']"));
                } catch (Exception e) {
                    System.out.println(methodID + "():" + e.toString());
                    driver.findElement(By.xpath(".//*[@id='crm_Views_MainToolbar_0']/button[3]")).click();
                }
            }

            System.out.println(methodID + ":" + "Account Type - " + strAccType + " was selected.");
            commNav.waitForNotPage("Account Type");
        } else {
            System.out.println(methodID + ": Account Type list view was not displayed; selection step skipped.");
        }
    }


    /**
     * This method will enter text for the Business Description.
     *
     * @throws InterruptedException
     * @param    strBusDesc text for the Business Description
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
        } else {
            System.out.println(methodID + ": Business Description text area was not displayed; step skipped.");
        }
    }
}
