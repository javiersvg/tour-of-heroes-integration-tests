package starter.navigation;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.DriverTask;
import net.thucydides.core.scheduling.SerenityFluentWait;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriverException;

import java.util.List;
import java.util.stream.Collectors;

public class Switch {

    private static final String WINDOW_NOT_FOUND_MESSAGE = "Window by title: %1$s not found. Windows available: %2$s";

    public static Performable toWindow(String windowTitle) {
        return new DriverTask((driver) -> {
            try {
                new SerenityFluentWait(driver)
                        .withTimeoutOf(5)
                        .seconds()
                        .until(webDriver ->
                                driver.getWindowHandles()
                                        .stream()
                                        .anyMatch(s -> windowTitle.equals(driver.switchTo().window(s).getTitle()))
                        );
            } catch (WebDriverException e) {
                List<String> availableWindows = driver.getWindowHandles()
                        .stream()
                        .map(s -> driver.switchTo().window(s).getTitle())
                        .collect(Collectors.toList());
                String reason = String.format(WINDOW_NOT_FOUND_MESSAGE, windowTitle, availableWindows.toString());
                throw new NoSuchWindowException(reason);
            }
        });
    }
}
