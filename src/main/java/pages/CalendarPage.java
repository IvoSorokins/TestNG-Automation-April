package pages;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.GlobalVariables;


public class CalendarPage {

    protected IOSDriver driver;

    @iOSXCUITFindBy(accessibility = "Calendars")
    private RemoteWebElement calendarsButton;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`name == \"Inbox\"`]")
    private RemoteWebElement inboxButton;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`name == \"Today\"`]")
    private RemoteWebElement todayButton;

    @iOSXCUITFindBy(accessibility = "Add")
    private RemoteWebElement addButton;


    public CalendarPage(IOSDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @Step("Calendar page is loaded")
    public boolean calendarPageLoaded() {
        WebDriverWait wait = new WebDriverWait(driver, GlobalVariables.globalTimeout);
        return wait.until(ExpectedConditions.visibilityOf(calendarsButton)).isDisplayed() &&
                wait.until(ExpectedConditions.visibilityOf(inboxButton)).isDisplayed() &&
                wait.until(ExpectedConditions.visibilityOf(todayButton)).isDisplayed();
    }
    @Step("Clicked **+ New Event**")
    public void clickAddButton(){addButton.click();}

}
