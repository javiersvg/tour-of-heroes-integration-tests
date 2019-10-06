package starter.login;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.SendKeys;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.jetbrains.annotations.NotNull;
import starter.navigation.GoogleAccountsPage;
import starter.navigation.PageState;
import starter.navigation.WaitUntilPage;

public class LogInTo {

    public static Performable google() {
        return Task.where("{0} attempts to log in",
                SendKeys.of("tourofheroestest").into(GoogleLoginForm.GOOGLE_EMAIL_INPUT.getBy()),
                Click.on(GoogleLoginForm.GOOGLE_NEXT_BUTTON.getBy()),
                WaitUntil.the(GoogleLoginForm.GOOGLE_PASSWORD_INPUT.getBy(), WebElementStateMatchers.isEnabled()),
                SendKeys.of("*********").into(GoogleLoginForm.GOOGLE_PASSWORD_INPUT.getBy()),
                Click.on(GoogleLoginForm.GOOGLE_PASSWORD_BUTTON.getBy()),
                WaitUntilPage.the(GoogleAccountsPage.class, getIsPageAvailableMatcher()).forNoMoreThan(10).seconds()
        );
    }

    @NotNull
    static Matcher<PageState> getIsPageAvailableMatcher() {
        return Matchers.hasProperty("available", Matchers.is(false));
    }

    public static Performable oauth() {
        return Task.where("{0} starts oauth login",
                Click.on(LoginButton.LOGIN_BUTTON.getBy())
        );
    }
}
