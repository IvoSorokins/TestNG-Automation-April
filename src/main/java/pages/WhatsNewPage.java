package pages;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.GlobalVariables;

public class WhatsNewPage {
    protected IOSDriver driver;

    @iOSXCUITFindBy(accessibility = "What’s New in Calendar")
    private RemoteWebElement whatsNewInCalendarTitle;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`name == \"Continue\"`]")
    private RemoteWebElement continueButton;

    public WhatsNewPage(IOSDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    public void verifyOpenedFirstTime(){
        try {
            // Check if What's New page is displayed
            if(whatsNewInCalendarTitle.isDisplayed()){
                // If true, continue through What's New Page
                newEventPageLoaded();
                clickContinueButton();
            }
        } catch (NoSuchElementException e) {
            // If What's New page is not displayed, continue with other actions
            notFirstTime();
        }
    }
    @Step("Verified app not opened for the first Time")
    public void notFirstTime(){}

    @Step("What's New in Calendar page is loaded")
    public boolean newEventPageLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(whatsNewInCalendarTitle)).isDisplayed();
    }

    @Step("Clicked Continue button")
    public void clickContinueButton(){continueButton.click();}



}
