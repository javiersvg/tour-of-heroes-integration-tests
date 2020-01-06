package starter.hero;

import org.openqa.selenium.By;

public enum HeroList {
    HERO_NAMES(By.className("mat-list-text"));

    private By by;

    HeroList(By by) {
        this.by = by;
    }

    public By getBy() {
        return by;
    }
}
