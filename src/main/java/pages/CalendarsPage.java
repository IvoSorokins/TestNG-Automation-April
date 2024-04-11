package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.GlobalVariables;
import utils.Helpers;

public class CalendarsPage extends Helpers {
    protected IOSDriver driver;

    @iOSXCUITFindBy(accessibility = "Add Calendar")
    private RemoteWebElement addCalendarButton;

    @iOSXCUITFindBy(accessibility = " Birthdays")
    private RemoteWebElement birthDaysOption;

    @iOSXCUITFindBy(accessibility = "Siri Suggestions")
    private RemoteWebElement siriSuggestionsOption;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`name == \"Add Calendar\"`][1]")
    private RemoteWebElement addCalendarOption;

    @iOSXCUITFindBy(accessibility = "Hide All")
    private RemoteWebElement hideAllButton;

    @iOSXCUITFindBy(accessibility = "Show All")
    private RemoteWebElement showAllButton;

    @iOSXCUITFindBy(accessibility = "Done")
    private RemoteWebElement doneButton;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeImage)[1]")
    private RemoteWebElement defaultCalendarCircle;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeImage)[2]")
    private RemoteWebElement createdCalendarCircle;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`name == \"More Info\"`][2]")
    private RemoteWebElement secondIButton;



    public CalendarsPage(IOSDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    @Step("Calendars page is loaded")
    public boolean CalendarsPageLoaded() {
        WebDriverWait wait = new WebDriverWait(driver, GlobalVariables.globalTimeout);
        return  wait.until(ExpectedConditions.visibilityOf(addCalendarButton)).isDisplayed() &&
                wait.until(ExpectedConditions.visibilityOf(birthDaysOption)).isDisplayed() &&
                wait.until(ExpectedConditions.visibilityOf(siriSuggestionsOption)).isDisplayed();
    }
    @Step("Clicked Add Calendar button")
    public void clickAddCalendar(){addCalendarButton.click();}

    @Step("Selected Add Calendar Option")
    public void selectAddCalendarOption(){addCalendarOption.click();}

    @Step("Verified Newly Created Calendar")
    public boolean verifyNewlyCreatedCalendar(String newCalendarName){
        try {
            new WebDriverWait(driver, GlobalVariables.globalTimeout)
                    .until(ExpectedConditions.visibilityOf(driver.findElement(AppiumBy.accessibilityId((newCalendarName)))));

            return true; // Element found, list is not empty

        } catch (NoSuchElementException | TimeoutException e) {
            return false; // Element not found, list is empty
        }

    }

    @Step("Clicked Show All")
    public void clickShowAll(){showAllButton.click();}

    @Step("Clicked Hide All")
    public void clickHideAll(){hideAllButton.click();}


    @Step("Verified Default Calendar is not Selected")
    public String isDefaultCalendarSelected(){
        return String.valueOf(defaultCalendarCircle.getAttribute("label"));
    }
    @Step("Verified Freshly created Calendar is not selected")
    public String isFreshlyCreatedCalendarSelected(){
        return String.valueOf(createdCalendarCircle.getAttribute("label"));
    }

    @Step("Clicked Done")
    public void clickDone(){doneButton.click();}

    @Step("Clicked Second I button")
    public void clickSecondIButton(){secondIButton.click();}
}
