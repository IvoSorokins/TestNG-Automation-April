package utils;


import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.util.List;
import java.util.stream.IntStream;

import static java.time.Duration.*;
import static org.openqa.selenium.interactions.PointerInput.Kind.TOUCH;
import static org.openqa.selenium.interactions.PointerInput.MouseButton.LEFT;
import static org.openqa.selenium.interactions.PointerInput.Origin.viewport;

/**
 * Utility class containing helper methods for interacting with elements
 */
public class Helpers {

    /**
     * Enumeration representing directions for swiping actions.
     */
    public enum Directions {
        UP,
        DOWN,
    }

    private final PointerInput FINGER = new PointerInput(TOUCH, "finger");

    /**
     * Performs a vertical swipe action on the iOS device
     *
     * @param driver    The iOS driver instance
     * @param direction The direction of the swipe (UP or DOWN)
     */
    public void swipeVertically(IOSDriver driver, Directions direction) {
        int startX = driver.manage().window().getSize().getWidth() / 2;
        int startY = driver.manage().window().getSize().getHeight() / 2;

        int endY;

        switch (direction) {
            case UP -> endY = (int) (driver.manage().window().getSize().getHeight() * 0.2);
            case DOWN -> endY = (int) (driver.manage().window().getSize().getHeight() * 0.8);
            default -> throw new IllegalArgumentException("Invalid direction selected: " + direction);
        }

        Sequence swipe = new Sequence(FINGER, 0);

        swipe.addAction(FINGER.createPointerMove(ZERO, viewport(), startX, startY));
        swipe.addAction(FINGER.createPointerDown(LEFT.asArg()));
        swipe.addAction(FINGER.createPointerMove(ofMillis(1000), viewport(), startX, endY));
        swipe.addAction(FINGER.createPointerUp(LEFT.asArg()));
        driver.perform(List.of(swipe));
    }

    /**
     * Scrolls to an element on the iOS device by performing vertical swipes
     *
     * @param driver     The iOS driver instance
     * @param el         The WebElement to scroll to
     * @param direction  The direction of the scroll (UP or DOWN)
     * @param swipeCount The number of swipes to perform
     */
    public void scrollTo(IOSDriver driver, WebElement el, Directions direction, int swipeCount) {
        IntStream.range(0, swipeCount).forEach(obj -> {
            if (!el.isDisplayed())
                swipeVertically(driver, direction);
        });
    }

    /**
     * Performs a long press action on an element on the iOS device
     *
     * @param driver The iOS driver instance
     * @param el     The WebElement to long press
     */
    public void longPress(IOSDriver driver, WebElement el) {
        Point location = getElementCenter(el);
        Sequence longPressAction = new Sequence(FINGER, 0);
        longPressAction.addAction(FINGER.createPointerMove(ZERO, viewport(), location.x, location.y));
        longPressAction.addAction(FINGER.createPointerDown(LEFT.asArg()));
        longPressAction.addAction(FINGER.createPointerMove(ofSeconds(1), viewport(), location.x, location.y));
        longPressAction.addAction(FINGER.createPointerUp(LEFT.asArg()));
        driver.perform(List.of(longPressAction));
    }

    /**
     * Calculates the center point of a WebElement
     *
     * @param el The WebElement
     * @return The center point of the WebElement
     */
    public Point getElementCenter(WebElement el) {
        Point location = el.getLocation();
        Dimension size = el.getSize();
        return new Point(location.x + size.getWidth() / 2, location.y + size.getHeight() / 2);
    }
}
