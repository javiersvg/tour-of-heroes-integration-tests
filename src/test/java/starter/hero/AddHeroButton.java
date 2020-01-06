package starter.hero;

import net.serenitybdd.core.annotations.findby.By;

public enum AddHeroButton {
    ADD_HERO_BUTTON(By.buttonText("add"));

    private By by;

    AddHeroButton(By by) {
        this.by = by;
    }

    public By getBy() {
        return by;
    }
}
