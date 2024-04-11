package tests;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.DriverSetup;


@Epic("iOS Tests")
@Feature("iOS Test 2")
public class TestiOSTwo extends DriverSetup {

    @Severity(SeverityLevel.CRITICAL)
    @Description("TestiOSTwo")
    @Test(testName = "iOSTwo")
    public void testTwo(){

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
        Assert.assertTrue(daysPage.DaysPageLoaded(), "Days Page is not loaded");

//      3. Click Calendars.
        daysPage.clickCalendars();
        Assert.assertTrue(calendarsPage.CalendarsPageLoaded(),"Calendar Page is not loaded");

//      4. Click on Add Calendar and select Add Calendar.
        calendarsPage.clickAddCalendar();
        calendarsPage.selectAddCalendarOption();
        Assert.assertTrue(addCalendarPage.AddCalendarsPageLoaded(),"Add Calendar Page is not loaded");

//      5. Add name for Calendar and change colour to Blue.
        addCalendarPage.nameCalendar("Test Calendar");
        addCalendarPage.clickColor();
        Assert.assertTrue(addCalendarColourPage.AddCalendarColourPageLoaded(),"Add Calendar Colour Page is not loaded");

        addCalendarColourPage.selectColour("Blue");
        addCalendarColourPage.clickBackButton();
        Assert.assertTrue(addCalendarPage.AddCalendarsPageLoaded(),"Add Calendar Page is not loaded");

//      6. Click on Done button.
        addCalendarPage.clickDone();
        Assert.assertTrue(calendarsPage.CalendarsPageLoaded(),"Calendar Page is not loaded");

//      7. Validate that newly created calendar is displayed in Calendars.
        calendarsPage.verifyNewlyCreatedCalendar("Test Calendar");

//      8. Click on Hide all and validate that Calendar and newly created calendar are not selected. (tip - use getAttribute)
        calendarsPage.clickHideAll();
        Assert.assertEquals(calendarsPage.isDefaultCalendarSelected(),"circle"); // circle - not Selected
        Assert.assertEquals(calendarsPage.isFreshlyCreatedCalendarSelected(),"circle");

//      9. Click on (i) button next to newly created calendar and delete the calendar.
        calendarsPage.clickSecondIButton();
        Assert.assertTrue(editCalendarPage.EditCalendarPageLoaded(),"Edit Calendar Page is not loaded");

        editCalendarPage.clickDeleteCalendar();
        editCalendarPage.selectDeleteCalendarOption();

//      10. Validate only Calendar is displayed now.
        Assert.assertTrue(calendarsPage.CalendarsPageLoaded(),"Calendar Page is not loaded");
        Assert.assertFalse(calendarsPage.verifyNewlyCreatedCalendar("Test Calendar"),"Newly created Calendar is not deleted");

//      11. Click on Done.
        calendarsPage.clickShowAll(); // For Setting up clear state
        calendarsPage.clickDone();

//      12. Validate Calendar screen is loaded.
        Assert.assertTrue(daysPage.DaysPageLoaded(),"Days Page is not loaded");
    }
}
