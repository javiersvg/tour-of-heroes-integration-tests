package starter.hero;


import org.openqa.selenium.By;

public enum AddHeroButton {
    ADD_HERO_BUTTON(By.className("mat-fab"));

    private By by;

    AddHeroButton(By by) {
        this.by = by;
    }

    public By getBy() {
        return by;
    }
}
