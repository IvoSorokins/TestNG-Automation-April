package utils;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.qameta.allure.Step;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Listeners;

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

    /**
     * Sets up the Appium driver before each test method
     */
    @Step("Driver is started")
    @BeforeMethod
    public void setUp() {

        XCUITestOptions options = new XCUITestOptions();
        options
                .setDeviceName(getProperty("device.name"))
                .setPlatformName(getProperty("platformName"))
                .setPlatformVersion(getProperty("platform.version"))
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

        // Initialize Pages here

    }

    /**
     * Tears down the Appium driver after each test method
     */
    @Step("Driver is closed")
    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}
