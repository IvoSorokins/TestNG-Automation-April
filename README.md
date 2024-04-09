# TestNG Automation Project

This README file provides a description of the TestNG automation project for both iOS and Android tests.

## iOS Tests:
### Test iOS 1:
1. Open the **Calendar** app (already installed on iOS simulators), validate the application is started.
2. Deal with any pop-ups that may arise, the choice is yours which option to take here and reach the **Calendar** screen.
3. Click **+ New Event**.
4. Add a name for the newly created event.
5. For Starts select Apr 24, 2024 for date and 11:10 AM.
6. For Ends select Apr 25, 2024 for date and 12:25 PM.
7. Add travel time of 30 minutes.
8. Verify that when you enable All-day only date is visible in Starts and Ends.
9. Disable All-day button so the time is again visible next to dates in Starts and Ends.
10. Click on Add button.
11. Switch to Month view (click back).
12. Verify that event is added for April 24 and April 25.

<br>

### Test iOS 2:
1. Open the **Calendar** app (already installed on iOS simulators), validate the application is started.
2. Deal with any pop-ups that may arise, the choice is yours which option to take here and reach the **Calendar** screen.
3. Click Calendars.
4. Click on Add Calendar and select Add Calendar.
5. Add name for Calendar and change colour to Blue.
6. Click on Done button.
7. Validate that newly created calendar is displayed in Calendars.
8. Click on Hide all and validate that Calendar and newly created calendar are not selected. (tip - use getAttribute)
9. Click on (i) button next to newly created calendar and delete the calendar.
10. Validate only Calendar is displayed now.
11. Click on Done.
12. Validate Calendar screen is loaded.

## Utils:

### ScreenshotUtil:
- Utility class for capturing screenshots.
- Provides a method for capturing screenshots based on tests.testOne status.

### TestListener
- TestNG listener class responsible for capturing screenshots on tests.testOne success and failure.
- Implements ITestListener interface.

### Helpers
- Utility class containing helper methods for actions with elements.

### DriverSetup
- Utility class for setting up and tearing down the Appium Driver before and after tests.testOne execution.
- Initializes the driver and performs necessary configurations.

### Global Variables
- Contains global variables used across the project.

### ConfigReader
- Utility class for reading configuration properties.
- Provides a method for retrieving properties from config.properties.
