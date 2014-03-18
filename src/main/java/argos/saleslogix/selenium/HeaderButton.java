package argos.saleslogix.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HeaderButton {

    @FindBy(xpath = "//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[@data-tool='toggleLeftDrawer']")
    public WebElement globalMenuButton;

    @FindBy(xpath = "//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[@data-tool='toggleRightDrawer']")
    public WebElement rightCntxtMnuButton;

    @FindBy(xpath = "//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[@data-tool='new']")
    public WebElement addButton;

    @FindBy(xpath = "//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[@data-tool='edit']")
    public WebElement editButton;

    @FindBy(xpath = "//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[@data-tool='save']")
    public WebElement saveButton;

    @FindBy(xpath = "//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[@data-tool='complete']")
    public WebElement checkButton;

    @FindBy(xpath = "//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[@data-tool='delete']")
    public WebElement deleteButton;

    @FindBy(xpath = "//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[@data-tool='cancel']")
    public WebElement cancelButton;

    @FindBy(xpath = "//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[@data-tool='back']")
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
    public HeaderButton showGlobalMenu() {
        String methodID = "showGlobalMenu";
        String leftDrawerId = "left_drawer";

        WebDriverWait wait = new WebDriverWait(driver, 5);

        //conditionally click the GlobalMenu button to reveal panel
        WebElement glblMenuPnl = driver.findElement(By.id(leftDrawerId));

        if (!glblMenuPnl.isDisplayed()) {
            wait.until(ExpectedConditions.elementToBeClickable(globalMenuButton));
            globalMenuButton.click();
        }

        wait.until(ExpectedConditions.visibilityOf(glblMenuPnl));

        // Verify the 'Global Menu' left-screen displays...
        try {
            System.out.println("VP: Global Menu was accessed successfully on header button click.");
        } catch (Error e) {
            System.out.println("Error: Global Menu failed to display on header button click.");
            System.out.println(methodID + "(): " + e.toString());
        }

        return this;
    }

    public boolean showRightContextMenu() throws InterruptedException {
        String methodID = "showRightContextMenu";

        // Verify the 'Right-Context Menu' left-screen displays...
        try {
            // Click Header Right-Context Menu button...
            WebDriverWait wait = new WebDriverWait(driver, 2);
            wait.until(ExpectedConditions.visibilityOf(rightCntxtMnuButton));
            rightCntxtMnuButton.click();

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("right_drawer")));
            System.out.println(methodID + ": Right-Context Menu was accessed successfully on header button click.");
            return true;
        } catch (Error e) {
            System.out.println(methodID + ": Right-Context Menu failed to display on header button click.");
            System.out.println(methodID + "(): " + e.toString());
            return false;
        }
    }

    public HeaderButton goBack() throws InterruptedException {
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
        driver.findElement(By.xpath(xpath));

        return this;
    }

    public void clickCheck() {
        clickHeaderButton(checkButton);
    }

    public void clickSave() {
        clickHeaderButton(saveButton);
    }

    public void clickCancel() {
        clickHeaderButton(cancelButton);
    }

    public void clickAdd() {
        clickHeaderButton(addButton);
    }

    public void clickBack() {
        clickHeaderButton(backButton);
    }

    public void clickEdit() {
        clickHeaderButton(editButton);
    }

    public void clickRightMenu() {
        clickHeaderButton(rightCntxtMnuButton);
    }

    public void clickGlobalMenu() {
        clickHeaderButton(globalMenuButton);
    }

    private void clickHeaderButton(WebElement buttonToClick) {
        WebDriverWait wait = new WebDriverWait(driver, 3);

        if (buttonToClick != null) {
            wait.until(ExpectedConditions.elementToBeClickable(buttonToClick));
            buttonToClick.click();
        }
    }

    public boolean closeRightContextMenu() throws InterruptedException {
        //conditionally close the Right-Context menu...
        if (driver.findElement(By.xpath(".//*[@id='right_drawer']")).isDisplayed()) {
            // Click Header Right-Context Menu button...
            clickRightMenu();
        }

        return true;
    }
}
