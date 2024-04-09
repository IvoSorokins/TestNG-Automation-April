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

import java.rmi.Remote;

public class NewEventPage {
    protected IOSDriver driver;

    @iOSXCUITFindBy(accessibility = "Title")
    private RemoteWebElement titleTextBar;

    @iOSXCUITFindBy(accessibility = "Location or Video Call")
    private RemoteWebElement locationVideoButton;

    @iOSXCUITFindBy(accessibility = "Starts")
    private RemoteWebElement startsFieldName;






    public NewEventPage(IOSDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @Step("Calendar page is loaded")
    public boolean calendarPageLoaded() {
        WebDriverWait wait = new WebDriverWait(driver, GlobalVariables.globalTimeout);
        return wait.until(ExpectedConditions.visibilityOf(titleTextBar)).isDisplayed() &&
                wait.until(ExpectedConditions.visibilityOf(locationVideoButton)).isDisplayed() &&
                wait.until(ExpectedConditions.visibilityOf(startsFieldName)).isDisplayed();
    }
    @Step("Entered New Event Name: {text}")
    public void enterTextTitleTextBar(String text){titleTextBar.sendKeys(text);}
}
