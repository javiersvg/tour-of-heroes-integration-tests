package starter.navigation;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.WhenPageOpens;

@DefaultUrl("https://tourfoheroes.com")
public class TourOfHeroesHomePage extends PageObject {

    @WhenPageOpens
    public void waitForTitle() {
        this.waitForTitleToAppear("AngularTourOfHeroes");
    }
}