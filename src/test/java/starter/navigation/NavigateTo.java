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
        return Task.where("AngularTourOfHeroes",
                Open.browserOn().the(TourOfHeroesHomePage.class)
        );
    }

    public static Performable theGoogleLoginPage() {
        return Switch.toWindow("Sign in - Google Accounts");
    }
}