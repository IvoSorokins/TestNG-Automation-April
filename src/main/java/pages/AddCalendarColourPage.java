package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.GlobalVariables;

public class AddCalendarColourPage  {
    protected IOSDriver driver;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`name == \"Add Calendar\"`][1]")
    private RemoteWebElement backButton;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`name == \"Calendar Colour\"`]")
    private RemoteWebElement calendarColourTitle;



    public AddCalendarColourPage(IOSDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    @Step("Calendar Colour page is loaded")
    public boolean AddCalendarColourPageLoaded() {
        WebDriverWait wait = new WebDriverWait(driver, GlobalVariables.globalTimeout);
        return  wait.until(ExpectedConditions.visibilityOf(backButton)).isDisplayed() &&
                wait.until(ExpectedConditions.visibilityOf(calendarColourTitle)).isDisplayed();
    }

    @Step("{Colour} selected")
    public void selectColour(String colour){
        WebDriverWait wait = new WebDriverWait(driver, GlobalVariables.globalTimeout);
        WebElement colourElement = wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.accessibilityId(colour)));

        colourElement.click();
    }

    @Step("Clicked Back")
    public void clickBackButton(){backButton.click();}


}
