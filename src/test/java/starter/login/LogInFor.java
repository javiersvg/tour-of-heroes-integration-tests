package starter.login;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.SendKeys;

public class LogInFor {

    public static Performable actor() {
        return Task.where("{0} attempts to log in",
                SendKeys.of("tourofheroustest").into(GoogleEmailInput.GOOGLE_EMAIL_INPUT.getBy()),
                Click.on(GoogleNextButton.GOOGLE_NEXT_BUTTON.getBy())
        );
    }

    public static Performable oauth() {
        return Task.where("{0} starts oauth login",
                Click.on(LoginButton.LOGIN_BUTTON.getBy())
        );
    }
}
