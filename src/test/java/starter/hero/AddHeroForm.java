package starter.hero;


import org.openqa.selenium.By;

import static net.serenitybdd.core.annotations.findby.By.buttonText;

public enum AddHeroForm {
    HERO_NAME_FIELD(By.className("mat-input-element")),
    OK_BUTTON(buttonText("Ok"));

    private By by;

    AddHeroForm(By by) {
        this.by = by;
    }

    public By getBy() {
        return by;
    }
}
