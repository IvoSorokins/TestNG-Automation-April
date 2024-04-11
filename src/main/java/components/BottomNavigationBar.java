package components;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;

public class BottomNavigationBar {
    protected IOSDriver driver;

    @iOSXCUITFindBy(accessibility = "Calendars")
    private RemoteWebElement calendarsButton;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`name == \"Inbox\"`]")
    private RemoteWebElement inboxButton;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`name == \"Today\"`]")
    private RemoteWebElement todayButton;

    public BottomNavigationBar(IOSDriver driver){
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }
    // Element Getters
    public RemoteWebElement getCalendarsButton(){return calendarsButton;}
    public RemoteWebElement getInboxButton(){return inboxButton;}
    public RemoteWebElement getTodayButton(){return todayButton;}
}
