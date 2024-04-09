package tests;

import io.qameta.allure.*;
import org.testng.annotations.Test;
import utils.DriverSetup;

@Epic("iOS Tests")
@Feature("iOS Test 2")
public class TestiOSTwo extends DriverSetup {

    @Severity(SeverityLevel.CRITICAL)
    @Description("TestiOSTwo")
    @Test(testName = "iOSTwo")
    public void testTwo(){
//        1. Open the **Calendar** app (already installed on iOS simulators), validate the application is started.
//        2. Deal with any pop-ups that may arise, the choice is yours which option to take here and reach the **Calendar** screen.
//        3. Click Calendars.
//        4. Click on Add Calendar and select Add Calendar.
//        5. Add name for Calendar and change colour to Blue.
//        6. Click on Done button.
//        7. Validate that newly created calendar is displayed in Calendars.
//        8. Click on Hide all and validate that Calendar and newly created calendar are not selected. (tip - use getAttribute)
//        9. Click on (i) button next to newly created calendar and delete the calendar.
//        10. Validate only Calendar is displayed now.
//        11. Click on Done.
//        12. Validate Calendar screen is loaded.
    }
}
