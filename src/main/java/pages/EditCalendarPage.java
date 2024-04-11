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

public class EditCalendarPage {
    protected IOSDriver driver;

    @iOSXCUITFindBy(className = "XCUIElementTypeTextField")
    private RemoteWebElement calendarTitle;

    @iOSXCUITFindBy(accessibility = "Blue")
    private RemoteWebElement calendarColourBlue;

    @iOSXCUITFindBy(accessibility = "Delete Calendar")
    private RemoteWebElement deleteCalendarButton;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`name == \"Delete Calendar\"`]")
    private RemoteWebElement deleteCalendarOption;


    public EditCalendarPage(IOSDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    @Step("Edit Calendar page is loaded")
    public boolean EditCalendarPageLoaded() {
        WebDriverWait wait = new WebDriverWait(driver, GlobalVariables.globalTimeout);
        return  wait.until(ExpectedConditions.visibilityOf(calendarColourBlue)).isDisplayed() &&
                wait.until(ExpectedConditions.visibilityOf(calendarTitle)).isDisplayed() &&
                wait.until(ExpectedConditions.visibilityOf(deleteCalendarButton)).isDisplayed();
    }
    @Step("Clicked Delete Calendar")
    public void clickDeleteCalendar(){deleteCalendarButton.click();}

    @Step("Selected Delete Calendar option")
    public void selectDeleteCalendarOption(){deleteCalendarOption.click();}
}
