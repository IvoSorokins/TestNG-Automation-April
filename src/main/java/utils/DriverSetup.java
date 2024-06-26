package utils;


import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.qameta.allure.Step;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Listeners;
import pages.*;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;


import static utils.GlobalVariables.globalTimeout;

/**
 * Utility class for setting up the Appium driver
 */
@Listeners({ TestListener.class })
public class DriverSetup extends ConfigReader {

    /**
     * The instance of the Appium driver
     */
    public static IOSDriver driver;

    protected Helpers helpers;

    // Declaration of Page class objects
    protected WhatsNewPage whatsNewPage;
    protected DaysPage daysPage;
    protected NewEventPage newEventPage;
    protected MonthsPage monthsPage;
    protected CalendarsPage calendarsPage;
    protected AddCalendarPage addCalendarPage;
    protected AddCalendarColourPage addCalendarColourPage;
    protected EditCalendarPage editCalendarPage;

    /**
     * Sets up the Appium driver before each test method
     */
    @Step("Driver is started")
    @BeforeMethod
    public void setUp() {

        XCUITestOptions options = new XCUITestOptions();
        options
                .setPlatformName(getProperty("platformName"))
                .setDeviceName(getProperty("device.name"))
                .setPlatformVersion(getProperty("device.platform.version"))
                .setAutomationName(getProperty("automation.name"))
                .setUdid(getProperty("device.udid"))
                .setBundleId(getProperty("bundle.id"))
                .setNoReset(false)
                .setAutoAcceptAlerts(true);

        try {
            // Reinstall and reset the app on the device
            driver = new IOSDriver(new URI(GlobalVariables.localAppiumServerUrl).toURL(), options);
        } catch (MalformedURLException | URISyntaxException e) {
            throw new RuntimeException(e);
        }
        // Wait for specified amount of time when trying to find element
        driver.manage().timeouts().implicitlyWait(globalTimeout);

        helpers = new Helpers();
        // Initialize Pages here
        whatsNewPage = new WhatsNewPage(driver);
        daysPage = new DaysPage(driver);
        newEventPage = new NewEventPage(driver);
        monthsPage = new MonthsPage(driver);
        calendarsPage = new CalendarsPage(driver);
        addCalendarPage = new AddCalendarPage(driver);
        addCalendarColourPage = new AddCalendarColourPage(driver);
        editCalendarPage = new EditCalendarPage(driver);

    }

    /**
     * Tears down the Appium driver after each test method
     */
    @Step("Driver is closed, ")
    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}
