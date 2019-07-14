package starter.login;

import org.openqa.selenium.By;

public enum LoginButton {
    LOGIN_BUTTON(By.id("my-signin2"));

    private By by;

    LoginButton(By by) {
        this.by = by;
    }

    public By getBy() {
        return by;
    }
}
