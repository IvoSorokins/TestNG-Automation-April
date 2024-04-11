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
import utils.Helpers;

public class NewEventPage extends Helpers {
    protected IOSDriver driver;

    @iOSXCUITFindBy(accessibility = "Title")
    private RemoteWebElement titleTextBar;

    @iOSXCUITFindBy(accessibility = "Location or Video Call")
    private RemoteWebElement locationVideoButton;

    @iOSXCUITFindBy(accessibility = "Starts")
    private RemoteWebElement startsFieldName;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton/XCUIElementTypeButton[1])[1]")
    private RemoteWebElement startDateButton;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton/XCUIElementTypeButton)[1]")
    private RemoteWebElement endDateButton;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[2]/XCUIElementTypeButton)[2]")
    private RemoteWebElement startTimeButton;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypePickerWheel[1]")
    private RemoteWebElement hourPickerWheel;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypePickerWheel[2]")
    private RemoteWebElement minutesPickerWheel;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeCell[`name == \"Travel Time\"`]")
    private RemoteWebElement travelTime;

    @iOSXCUITFindBy(accessibility = "30 minutes")
    private RemoteWebElement travelTimeOption30min;

    @iOSXCUITFindBy(className = "XCUIElementTypeSwitch")
    private RemoteWebElement allDaySwitch;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`name == \"Add\"`][1]")
    private RemoteWebElement addButton;


    public NewEventPage(IOSDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @Step("New Event Page is loaded")
    public boolean calendarPageLoaded() {
        WebDriverWait wait = new WebDriverWait(driver, GlobalVariables.globalTimeout);
        return wait.until(ExpectedConditions.visibilityOf(titleTextBar)).isDisplayed() &&
                wait.until(ExpectedConditions.visibilityOf(locationVideoButton)).isDisplayed() &&
                wait.until(ExpectedConditions.visibilityOf(startsFieldName)).isDisplayed();
    }

    @Step("Entered New Event Name: {text}")
    public void enterTextTitleTextBar(String text) {
        titleTextBar.sendKeys(text);
    }

    @Step("Clicked Start Date Button")
    public void clickStartDateButton() {
        startDateButton.click();
    }

    @Step("Selected {date} ")
    public void selectDate(String date) {
        String dateLocator = String.format("**/XCUIElementTypeButton[`name == \"%s\"`]", date);

        WebElement selectedDateElement = driver.findElement(AppiumBy.iOSClassChain(dateLocator));

        selectedDateElement.click();
    }

    @Step("Clicked Start Time Button")
    public void clickStartTimeButton() {
        startTimeButton.click();
    }

    @Step("Clicked End Date Button")
    public void clickEndDateButton() {
        endDateButton.click();
    }

    @Step("Clicked End Time Button")
    public void clickEndTimeButton() {
        startTimeButton.click();
    }

    @Step("Selected {hours] from Hour Picker Wheel")
    public void selectHours(String hours) {
        hourPickerWheel.sendKeys(hours);
    }

    @Step("Selected {minutes} from Minutes Picker Wheel")
    public void selectMinutes(String minutes) {
        minutesPickerWheel.sendKeys(minutes);
    }

    @Step("Clicked Travel Time")
    public void clickTravelTime() {
        travelTime.click();
    }

    @Step("Selected {time] Travel Time")
    public void selectTravelTime(String travelTime) {
        WebElement selectedTravelTimeElement = driver.findElement(AppiumBy.accessibilityId(travelTime));

        selectedTravelTimeElement.click();
    }

    @Step("Switched All-Day on")
    public void clickSwitchAllDay() {
        allDaySwitch.click();
    }

    @Step("Verified Start Field displayed only with Days")
    public boolean verifyStartFieldDisplayedOnlyDays(String Day) {
        WebDriverWait wait = new WebDriverWait(driver, GlobalVariables.globalTimeout);
        WebElement startField = driver.findElement(AppiumBy.iOSClassChain(String.format("**/XCUIElementTypeCell[`name == \"Starts, %s\"`]", Day)));

        return wait.until(ExpectedConditions.visibilityOf(startField)).isDisplayed();
    }

    @Step("Verified End Field displayed only with Days")
    public boolean verifyEndFieldDisplayedOnlyDays(String Day) {
        WebDriverWait wait = new WebDriverWait(driver, GlobalVariables.globalTimeout);
        WebElement endField = driver.findElement(AppiumBy.iOSClassChain(String.format("**/XCUIElementTypeCell[`name == \"Ends, %s\"`]", Day)));

        return wait.until(ExpectedConditions.visibilityOf(endField)).isDisplayed();
    }

    @Step("Verified Start Field displayed with Days and Time")
    public boolean verifyStartFieldDisplayedAll(String Day){
        WebDriverWait wait = new WebDriverWait(driver, GlobalVariables.globalTimeout);
        String smallHour= String.valueOf(roundTimeToHour(1));
        WebElement startField = driver.findElement(AppiumBy.iOSClassChain(String.format("**/XCUIElementTypeCell[`name == \"Starts, %s, %s\"`]", smallHour, Day)));

        return wait.until(ExpectedConditions.visibilityOf(startField)).isDisplayed();
    }

    @Step("Verified Start Field displayed with Days and Time")
    public boolean verifyEndFieldDisplayedAll(String Day){
        WebDriverWait wait = new WebDriverWait(driver, GlobalVariables.globalTimeout);
        String smallHour= String.valueOf(roundTimeToHour(2));
        WebElement startField = driver.findElement(AppiumBy.iOSClassChain(String.format("**/XCUIElementTypeCell[`name == \"Ends, %s, %s\"`]", smallHour, Day)));

        return wait.until(ExpectedConditions.visibilityOf(startField)).isDisplayed();
    }

    @Step("Clicked Add Button")
    public void clickAddButton(){addButton.click();}
}
