package argos.saleslogix.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Iterator;
import java.util.Set;

public class SLXMobileLogin {

    public final String id = "login";
    @FindBy(how = How.CLASS_NAME, using = "logo")
    @CacheLookup
    WebElement logo;
    @FindBy(how = How.ID, using = "pageTitle")
    @CacheLookup
    WebElement title;
    @FindBy(how = How.XPATH, using = "//*[@id=\"login\"]/span[1]")
    @CacheLookup
    WebElement copyright;
    @FindBy(how = How.XPATH, using = "//*[@id=\"login\"]/span[2]")
    @CacheLookup
    WebElement version;
    @FindBy(how = How.ID, using = id)
    @CacheLookup
    WebElement domNode;
    @CacheLookup
    @FindBy(xpath = ".//*[@id='Sage_Platform_Mobile_Fields_TextField_0']/input")
    WebElement userNameTextbox;
    @CacheLookup
    @FindBy(xpath = ".//*[@id='Sage_Platform_Mobile_Fields_TextField_1']/input")
    WebElement passwordTextbox;
    @CacheLookup
    @FindBy(css = "#Sage_Platform_Mobile_Fields_BooleanField_0 > div.toggle > span.thumb")
    WebElement rememberToggle;
    @FindBy(how = How.XPATH, using = "//*[@id=\"Sage_Platform_Mobile_Fields_BooleanField_0\"]/div")
    @CacheLookup
    WebElement rememberMeToggle;
    @FindBy(how = How.XPATH, using = "//*[@id=\"login\"]/button")
    @CacheLookup
    WebElement loginButton;
    private WebDriver driver;

    public SLXMobileLogin(WebDriver driver) {
        this.driver = driver;
    }

    public SLXMobileLogin enterUserName(String userName) throws InterruptedException {
        userNameTextbox.clear();
        userNameTextbox.sendKeys(userName);
        return this;
    }

    public SLXMobileLogin enterPassword(String password) {
        passwordTextbox.clear();
        passwordTextbox.sendKeys(password);
        return this;
    }

    public SLXMobileLogin toggleRemember() throws InterruptedException {
        rememberToggle.click();
        return this;
    }

    public SLXMobileLogin logonButton() throws InterruptedException {
        loginButton.click();
        return this;
    }

    public boolean isLogoDisplayed() {
        return logo.isDisplayed();
    }

    public String getCopyright() {
        return copyright.getText();
    }

    public String getAppVersion() {
        return version.getText();
    }


    /**
     * Assuming that the Mobile Client login page is displayed, this method will enter a username,
     * password and optionally check the Remember Me box then click the Login button.
     *
     * @author mike.llena@swiftpage.com
     * @version 1.0
     * @param    userName    username to login as
     * @param    passWord    password of username to use for login
     * @param    rememberMe    if true, then the Remember Me check box will be checked; if false, then
     * the check box will be left un-checked
     * @return boolean        true - if Mobile Client login is successful
     * false - otherwise
     */
    public boolean doLogin(String userName, String passWord, Boolean rememberMe) throws InterruptedException {

        //Step: enter username
        enterUserName(userName);

        //Step: enter password
        enterPassword(passWord);

        //Step: conditionally set the remember option
        if (rememberMe) {
            toggleRemember();
        }

        //Step: click the Log On button
        logonButton();

        // Confirm login by nav away from page
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id(id)));

        domNode = driver.findElement(By.id(id));

        if (domNode.isDisplayed()) {
            closeModal();
            return false;
        } else {
            return true;
        }
    }

    public void closeModal() {
        Set<String> windowids = driver.getWindowHandles();
        Iterator<String> iter = windowids.iterator();
        String popupWindowId = iter.next();
        driver.switchTo().window(popupWindowId);
    }
}
