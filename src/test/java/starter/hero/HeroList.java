package starter.hero;

import org.openqa.selenium.By;

public enum HeroList {
    HEROES(By.className("mat-list-item-content"));

    private By by;

    HeroList(By by) {
        this.by = by;
    }

    public By getBy() {
        return by;
    }
}
