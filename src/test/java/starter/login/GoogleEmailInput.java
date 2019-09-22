package starter.login;

import org.openqa.selenium.By;

public enum GoogleEmailInput {
    GOOGLE_EMAIL_INPUT(By.name("identifier"));

    private final By by;

    GoogleEmailInput(By by) {
        this.by = by;
    }

    public By getBy() {
        return this.by;
    }
}
