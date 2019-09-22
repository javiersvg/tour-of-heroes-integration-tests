package starter.login;

import org.openqa.selenium.By;

public enum GoogleNextButton {
    GOOGLE_NEXT_BUTTON(By.id("identifierNext"));

    private final By by;

    GoogleNextButton(By by) {
        this.by = by;
    }

    public By getBy() {
        return by;
    }
}
