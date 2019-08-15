package starter.login;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.DriverTask;
import org.openqa.selenium.WebDriver;

import java.util.Iterator;
import java.util.function.Consumer;

public class LogInFor {

    private static final String SIGN_IN_GOOGLE_ACCOUNTS_WINDOW_TITLE = "Log in page";
    private static final Consumer<WebDriver> webDriverConsumer = webDriver -> {
        Iterator<String> iterator = webDriver.getWindowHandles().iterator();
        do {
            webDriver.switchTo().window(iterator.next());
        } while (!SIGN_IN_GOOGLE_ACCOUNTS_WINDOW_TITLE.equals(webDriver.getTitle()) && iterator.hasNext());
        if (!SIGN_IN_GOOGLE_ACCOUNTS_WINDOW_TITLE.equals(webDriver.getTitle())) {
            webDriver.switchTo().window(SIGN_IN_GOOGLE_ACCOUNTS_WINDOW_TITLE);
        }
    };

    public static Performable actor() {
        return Task.where("{0} attempts to log in",
                Click.on(LoginButton.LOGIN_BUTTON.getBy()),
                new DriverTask(webDriverConsumer),
                Click.on(By.tagName("input"))
        );
    }
}
