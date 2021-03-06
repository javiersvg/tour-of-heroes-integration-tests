package starter.navigation;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

public class NavigateTo  {

    public static Performable theDuckDuckGoHomePage() {
        return Task.where("{0} opens the DuckDuckGo home page",
                Open.browserOn().the(DuckDuckGoHomePage.class)
        );
    }

    public static Performable theTourOfHeroesHomePage() {
        return Task.where("{0} opens the tour of heroes home page",
                Open.browserOn().the(TourOfHeroesHomePage.class)
        );
    }

    public static Performable theGoogleLoginPage() {
        return Task.where("{0} switches to the google login page",
                Switch.browserTo().the(GoogleAccountsPage.class));
    }

    public static Performable theTourOfHeroesLifeCyclePage() {
        return Task.where("{0} opens the Tour of heroes life cycle page",
                Open.browserOn().the(TourOfHeroesLifeCyclePage.class));
    }
}