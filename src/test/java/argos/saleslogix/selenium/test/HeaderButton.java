package argos.saleslogix.selenium.test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.AssertJUnit;

public class HeaderButton {

    //@CacheLookup
    @FindBy(xpath = "//div[@class='buttonset']/button[@data-tool='toggleLeftDrawer']")
    WebElement globalMenuButton;
    //@CacheLookup
    @FindBy(xpath = "//div[@selected='selected']//div[@class='buttonset']/button[@data-action='openSettings']")
    WebElement rightCntxtMnuButton; // TODO: This is no longer a header item, move it to common nav.
    //@CacheLookup
    @FindBy(xpath = "//div[@class='buttonset']/button[@data-tool='new']")
    WebElement addButton;
    //@CacheLookup
    @FindBy(xpath = "//div[@class='buttonset']/button[@data-tool='briefCase']")
    WebElement briefcaseButton;
    //@CacheLookup
    @FindBy(xpath = "//div[@class='buttonset']/button[@data-tool='edit']")
    WebElement editButton;
    //@CacheLookup
    @FindBy(xpath = "//div[@class='buttonset']/button[@data-tool='save']")
    WebElement saveButton;
    //@CacheLookup
    @FindBy(xpath = "//div[@class='buttonset']/button[@data-tool='refresh']")
    WebElement refreshButton;
    //@CacheLookup
    @FindBy(xpath = "//div[@class='buttonset']/button[@data-tool='complete']")
    WebElement checkButton;
    //@CacheLookup
    @FindBy(xpath = "//div[@class='buttonset']/button[@data-tool='delete']")
    WebElement deleteButton;
    //@CacheLookup
    @FindBy(xpath = "//div[@class='buttonset']/button[@data-tool='cancel']")
    WebElement cancelButton;
    //@CacheLookup
    @FindBy(xpath = "//div[@class='buttonset']/button[@data-tool='back']")
    WebElement backButton;
    private WebDriver driver;

    public HeaderButton(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getSafeElement(By locator) throws InterruptedException {
        int i = 0;
        WebElement element = null;
        while (i < 5) {
            try {
                element = driver.findElement(locator);
                element.click();
                break;
            } catch (Exception e) {
                Thread.sleep(1000);
                element = driver.findElement(locator);
                element.click();
            }
        }
        return element;
    }


    /**
     * This method will click the header Global Menu button to display the Global Menu items.
     *
     * @throws InterruptedException
     * @author mike.llena@swiftpage.com
     * @version 1.0
     * @param    N/A
     */
    public HeaderButton showGlobalMenu() throws InterruptedException {
        String methodID = "showGlobalMenu";

        //click the Page Title (forces closure of any blocking panels)
        driver.findElement(By.id("pageTitle")).click();
        Thread.sleep(1000);

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
        Thread.sleep(1000);
        return this;
    }

    public boolean showRightContextMenu() throws InterruptedException {
        String methodID = "showRightContextMenu";

        // Click Header Right-Context Menu button...
        clickHeaderButton("right context menu");

        // Verify the 'Right-Context Menu' left-screen displays...
        try {
            AssertJUnit.assertTrue(driver.findElement(By.xpath(".//*[@id='right_drawer']")).isDisplayed());
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

        WebElement pgTitleBar = driver.findElement(By.xpath(".//*[@id='pageTitle']"));
        String oldPgTitle = driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText();

        //conditionally close the Right Context Menu panel (if blocking the Global Menu button)
        closeRightContextMenu();

        try {
            //click the Header Back button
            backButton.click();
            Thread.sleep(1500);
        } catch (Exception e) {
            //revert to Backspace key-press if Back button click fails
            pgTitleBar.click();
            pgTitleBar.sendKeys(Keys.BACK_SPACE);
            Thread.sleep(1500);
        }

        String newPgTitle = driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText();

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

        Thread.sleep(1000);
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
            case "briefcase":
                briefcaseButton.click();
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
        Thread.sleep(1500);
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
}
