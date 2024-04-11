package tests;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.DriverSetup;


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
        Assert.assertTrue(daysPage.DaysPageLoaded(), "Calendar Page is not loaded");

//      3. Click **+ New Event**.
        daysPage.clickAddButton();
        Assert.assertTrue(newEventPage.calendarPageLoaded(), "New Event Page is not loaded");

//      4. Add a name for the newly created event.
        newEventPage.enterTextTitleTextBar("Test Event2");

//      5. For Starts select Apr 24, 2024 for date and 11:10 AM.
        newEventPage.clickStartDateButton();
        newEventPage.selectDate("Wednesday, 24 April");

        newEventPage.clickStartTimeButton();
        newEventPage.selectHours("11");
        newEventPage.selectMinutes("10");

//      6. For Ends select Apr 25, 2024 for date and 12:25 PM.
        newEventPage.clickEndDateButton();
        newEventPage.selectDate("Thursday, 25 April");

        newEventPage.clickEndTimeButton();
        newEventPage.selectHours("12");
        newEventPage.selectMinutes("25");

//      7. Add travel time of 30 minutes.
        newEventPage.clickTravelTime();
        newEventPage.selectTravelTime("30 minutes");

//      8. Verify that when you enable All-day only date is visible in Starts and Ends.
        newEventPage.clickSwitchAllDay();
        Assert.assertTrue(newEventPage.verifyStartFieldDisplayedOnlyDays( "24 Apr 2024"),"When All-Day enabled date and time is visible for Start Field");
        Assert.assertTrue(newEventPage.verifyEndFieldDisplayedOnlyDays( "25 Apr 2024"),"When All-Day enabled date and time is visible for End Field");


//      9. Disable All-day button so the time is again visible next to dates in Starts and Ends.
        newEventPage.clickSwitchAllDay();
        Assert.assertTrue(newEventPage.verifyStartFieldDisplayedAll("24 Apr 2024"),"When All-Day disabled only date is visible");
        Assert.assertTrue(newEventPage.verifyEndFieldDisplayedAll("25 Apr 2024"),"When All-Day disabled only date is visible");


//      10. Click on Add button.
        newEventPage.clickAddButton();
        Assert.assertTrue(daysPage.DaysPageLoaded(), "Calendar Page is not loaded");

//      11. Switch to Month view (click back). Assuming start point is Daily
        daysPage.clickBackButton();
        Assert.assertTrue(monthsPage.MonthsLoaded(),"Months Page is not loaded");

//      12. Verify that event is added for April 24 and April 25.
        monthsPage.clickListButton();
        monthsPage.clickSpecificDay("Wednesday, 24 April");
        Assert.assertFalse(monthsPage.emptyEventListLoaded(),"Event List is empty");
        monthsPage.clickSpecificDay("Thursday, 25 April");
        Assert.assertFalse(monthsPage.emptyEventListLoaded(),"Event List is empty");

//      13. Click Today twice, List button once (Returning Start State)
        monthsPage.clickListButton();
        monthsPage.clickTodayButtonMultipleTimes(2);

    }
}
