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
import utils.Helpers;

public class AddCalendarPage extends Helpers{
    protected IOSDriver driver;

    @iOSXCUITFindBy(className = "XCUIElementTypeTextField")
    private RemoteWebElement calendarNameField;

    @iOSXCUITFindBy(accessibility = "chevron")
    private RemoteWebElement colourChevron;

    @iOSXCUITFindBy(accessibility = "Account")
    private RemoteWebElement accountButton;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name=\"Done\"])[2]")
    private RemoteWebElement doneButton;


    public AddCalendarPage(IOSDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    @Step("Add Calendars page is loaded")
    public boolean AddCalendarsPageLoaded() {
        WebDriverWait wait = new WebDriverWait(driver, GlobalVariables.globalTimeout);
        return  wait.until(ExpectedConditions.visibilityOf(calendarNameField)).isDisplayed() &&
                wait.until(ExpectedConditions.visibilityOf(colourChevron)).isDisplayed() &&
                wait.until(ExpectedConditions.visibilityOf(accountButton)).isDisplayed();
    }

    @Step("Clicked on Colour")
    public void clickColor(){colourChevron.click();}

    @Step("Named Calendar: {name}")
    public void nameCalendar(String name){calendarNameField.sendKeys(name);}

    @Step("Click Done")
    public void clickDone() {
        wait(1);
        doneButton.click();
    }
}
