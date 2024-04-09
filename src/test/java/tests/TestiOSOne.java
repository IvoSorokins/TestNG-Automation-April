package tests;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.DriverSetup;
import utils.Helpers;


@Epic("iOS Tests")
@Feature("iOS Test 1")
public class TestiOSOne extends DriverSetup {


    @Severity(SeverityLevel.CRITICAL)
    @Description("TestiOSOne")
    @Test(testName = "iOSOne")
    public void testOne(){

//      1. Open the **Calendar** app (already installed on iOS simulators), validate the application is started.
        whatsNewPage.verifyOpenedFirstTime();

//      2. Deal with any pop-ups that may arise, the choice is yours which option to take here and reach the **Calendar** screen.
        /* In this case I can use capabilities:
            autoAcceptAlerts (I used this One)
            autoDismissAlerts
            autoGrantPermissions

            or
            By preventing Services Access manually in advance
         */
        Assert.assertTrue(calendarPage.calendarPageLoaded(), "Calendar Page is not loaded");


//      3. Click **+ New Event**.
        calendarPage.clickAddButton();
        newEventPage.calendarPageLoaded();

//      4. Add a name for the newly created event.
        newEventPage.enterTextTitleTextBar("Test Event");


//      5. For Starts select Apr 24, 2024 for date and 11:10 AM.

//      6. For Ends select Apr 25, 2024 for date and 12:25 PM.

//      7. Add travel time of 30 minutes.

//      8. Verify that when you enable All-day only date is visible in Starts and Ends.

//      9. Disable All-day button so the time is again visible next to dates in Starts and Ends.

//      10. Click on Add button.

//      11. Switch to Month view (click back).

//      12. Verify that event is added for April 24 and April 25.

    }
}
