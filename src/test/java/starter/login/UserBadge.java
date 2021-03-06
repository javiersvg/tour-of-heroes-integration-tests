package starter.login;

import org.openqa.selenium.By;

public enum UserBadge {
    USER_ICON(By.tagName("img")),
    USER_NAME(By.className("mat-button-wrapper"));

    private final By by;

    UserBadge(By by) {
        this.by = by;
    }

    public By getBy() {
        return by;
    }
}
