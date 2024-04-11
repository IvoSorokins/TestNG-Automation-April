package components;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;

public class TopNavigationBar {
    protected IOSDriver driver;

    @iOSXCUITFindBy(accessibility = "Add")
    private RemoteWebElement addButton;

    @iOSXCUITFindBy(accessibility = "Search")
    private RemoteWebElement searchButton;

    @iOSXCUITFindBy(accessibility = "List")
    private RemoteWebElement listButton;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeNavigationBar/XCUIElementTypeButton[1]")
    private RemoteWebElement backButton;

    public TopNavigationBar(IOSDriver driver){
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }
    public RemoteWebElement getAddButton(){return addButton;}
    public RemoteWebElement getSearchButton(){return searchButton;}
    public RemoteWebElement getListButton(){return listButton;}

    public RemoteWebElement getBackButton(){return backButton;}

}
