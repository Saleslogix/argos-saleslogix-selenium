package argos.saleslogix.selenium.test;

import org.openqa.selenium.*;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.util.Iterator;
import java.util.Set;

import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static java.util.concurrent.TimeUnit.SECONDS;

public class SLXMobileLogin {

    @CacheLookup
    @FindBy(xpath = ".//*[@id='argos_Fields_TextField_0']/input")
    WebElement userNameTextbox;
    @CacheLookup
    @FindBy(xpath = ".//*[@id='argos_Fields_TextField_1']/input")
    WebElement passwordTextbox;
    @CacheLookup
    @FindBy(xpath = ".//*[@id='argos_Fields_TextField_2']/input")
    WebElement sdataEndpointTextbox;
    @CacheLookup
    @FindBy(id = "argos_Fields_BooleanField_0")
    WebElement rememberToggle;
    @CacheLookup
    @FindBy(css = "#login .btn-primary")
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

    public SLXMobileLogin waitForLoad() {
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(10, SECONDS)
                .pollingEvery(250, MILLISECONDS);
        wait.until((driver) -> this.userNameTextbox.isEnabled());
        return this;
    }

    public SLXMobileLogin waitForAuth() {
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(10, SECONDS)
                .pollingEvery(250, MILLISECONDS);
        wait.until((driver) -> driver.findElement(By.xpath("//div[@id='login' and not(@selected)]")));
        return this;
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
        System.out.println("doLogin: username = " + userName + ", password = " + passWord + ", remember? = " + rememberMe);

        this.waitForLoad();

        this.enterUserName(userName);

        if (passWord != null && !passWord.isEmpty()) {
            this.enterPassword(passWord);
        }

        if (rememberMe) {
            this.toggleRemember();
        }

        //Step: click the Log On button
        this.logonButton();

        try {
            this.waitForAuth();
        } catch (WebDriverException wex) {
            System.out.println(wex.getMessage());
            closeModal();
            return false;
        }

        return true;
    }

    public void closeModal() {
        Set<String> windowIds = driver.getWindowHandles();
        Iterator<String> windowIter = windowIds.iterator();
        String popupWindowId = windowIter.next();
        driver.switchTo().window(popupWindowId);
    }
}
