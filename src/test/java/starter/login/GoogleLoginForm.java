package starter.login;

import org.openqa.selenium.By;

public enum GoogleLoginForm {
    GOOGLE_EMAIL_INPUT(By.name("identifier")),
    GOOGLE_NEXT_BUTTON(By.id("identifierNext")),
    GOOGLE_PASSWORD_INPUT(By.name("password")),
    GOOGLE_PASSWORD_BUTTON(By.id("passwordNext"));

    private final By by;

    GoogleLoginForm(By by) {
        this.by = by;
    }

    public By getBy() {
        return by;
    }
}
