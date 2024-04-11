package pages;

import components.BottomNavigationBar;
import components.TopNavigationBar;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.GlobalVariables;
import utils.Helpers;

public class MonthsPage extends Helpers {
    protected IOSDriver driver;
    protected BottomNavigationBar bottomNavigationBar;
    protected TopNavigationBar topNavigationBar;


    @iOSXCUITFindBy(accessibility = "Months")
    private RemoteWebElement monthsScrollBar;

    @iOSXCUITFindBy(accessibility = "Empty list")
    private RemoteWebElement emptyEventList;

    public MonthsPage(IOSDriver driver) {
        this.driver = driver;
        this.topNavigationBar = new TopNavigationBar(driver);
        this.bottomNavigationBar = new BottomNavigationBar(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @Step("Months page is loaded")
    public boolean MonthsLoaded() {
        WebDriverWait wait = new WebDriverWait(driver, GlobalVariables.globalTimeout);
        return  wait.until(ExpectedConditions.visibilityOf(bottomNavigationBar.getCalendarsButton())).isDisplayed() &&
                wait.until(ExpectedConditions.visibilityOf(monthsScrollBar)).isDisplayed() &&
                wait.until(ExpectedConditions.visibilityOf(topNavigationBar.getListButton())).isDisplayed();
    }

    @Step("Clicked on List Button from Months Page")
    public void clickListButton(){topNavigationBar.getListButton().click();}

    @Step("Clicked {Day} ")
    public void clickSpecificDay(String Day){
        WebElement selectedDayElement = driver.findElement(AppiumBy.accessibilityId(Day));

        selectedDayElement.click();
    }

    @Step("Verify Event List is not empty")
    public boolean emptyEventListLoaded(){
        try {
            new WebDriverWait(driver, GlobalVariables.globalTimeout)
                    .until(ExpectedConditions.visibilityOf(emptyEventList));
            return true; // Element found, list is not empty
        } catch (NoSuchElementException | TimeoutException e) {
            return false; // Element not found, list is empty
        }
    }


    @Step("Clicked Today button")
    public void clickTodayButtonMultipleTimes(int clickCount){clickElementMultipleTimes(bottomNavigationBar.getTodayButton(),clickCount);}


}
