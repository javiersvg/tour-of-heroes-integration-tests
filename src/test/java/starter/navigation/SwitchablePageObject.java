package starter.navigation;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.PageUrls;
import net.thucydides.core.guice.Injectors;
import net.thucydides.core.scheduling.SerenityFluentWait;
import net.thucydides.core.util.EnvironmentVariables;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public abstract class SwitchablePageObject extends PageObject {
    private static final String WINDOW_NOT_FOUND_MESSAGE = "Window identifier: %1$s not found. Windows available: %2$s";

    private PageUrls pageUrls;

    protected SwitchablePageObject() {
        EnvironmentVariables environmentVariables = Injectors.getInjector().getProvider(EnvironmentVariables.class).get();
        this.pageUrls = new PageUrls(this, environmentVariables);
    }

    public void switchToWindow(){
        String startingUrl = getDeclaredDefaultUrl().get();
        this.switchToOpenWindow(startingUrl, WebDriver::getCurrentUrl);
        this.addJQuerySupport();
        this.callWhenPageOpensMethods();
    }

    Optional<String> getDeclaredDefaultUrl() {
        return this.pageUrls.getDeclaredDefaultUrl();
    }

    public void switchToOpenWindow(String identifier, Function<WebDriver, String> getIdentifier) {
        WebDriver driver = this.getDriver();
        try {
            new SerenityFluentWait(driver)
                    .withTimeoutOf(5)
                    .seconds()
                    .until(webDriver ->
                            driver.getWindowHandles()
                                    .stream()
                                    .map(s -> driver.switchTo().window(s))
                                    .map(getIdentifier)
                                    .anyMatch(contains(identifier))
                    );
        } catch (WebDriverException e) {
            List<String> availableWindows = driver.getWindowHandles()
                    .stream()
                    .map(s -> driver.switchTo().window(s))
                    .map(getIdentifier)
                    .collect(Collectors.toList());
            String reason = String.format(WINDOW_NOT_FOUND_MESSAGE, identifier, availableWindows.toString());
            throw new NoSuchWindowException(reason);
        }
    }

    private Predicate<String> contains(String identifier) {
        return identifierContainer -> identifierContainer != null && identifierContainer.contains(identifier);
    }
}
