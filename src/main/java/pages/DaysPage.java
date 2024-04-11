package pages;

import components.BottomNavigationBar;
import components.TopNavigationBar;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.GlobalVariables;


public class DaysPage {

    protected IOSDriver driver;
    protected BottomNavigationBar bottomNavigationBar;
    protected TopNavigationBar topNavigationBar;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther)[2]")
    private RemoteWebElement dayScrollBar;


    public DaysPage(IOSDriver driver) {
        this.driver = driver;
        this.bottomNavigationBar = new BottomNavigationBar(driver);
        this.topNavigationBar = new TopNavigationBar(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @Step("Days page is loaded")
    public boolean DaysPageLoaded() {
        WebDriverWait wait = new WebDriverWait(driver, GlobalVariables.globalTimeout);
        return  wait.until(ExpectedConditions.visibilityOf(bottomNavigationBar.getCalendarsButton())).isDisplayed() &&
                wait.until(ExpectedConditions.visibilityOf(dayScrollBar)).isDisplayed() &&
                wait.until(ExpectedConditions.visibilityOf(topNavigationBar.getListButton())).isDisplayed();
    }
    @Step("Clicked ''+ New Event'' from Days Page ")
    public void clickAddButton(){topNavigationBar.getAddButton().click();}

    @Step("Clicked Back Button from Days Page")
    public void clickBackButton(){topNavigationBar.getBackButton().click();}

    @Step("Clicked Calendars from Days Page")
    public void clickCalendars(){bottomNavigationBar.getCalendarsButton().click();}
}
