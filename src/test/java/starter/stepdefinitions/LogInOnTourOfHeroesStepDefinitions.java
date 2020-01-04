package starter.stepdefinitions;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import starter.login.LogInTo;
import starter.login.LoginResult;
import starter.navigation.NavigateTo;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.*;
import static org.hamcrest.Matchers.is;

public class LogInOnTourOfHeroesStepDefinitions {

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("^(.*) is on the tour of heroes home page")
    public void is_on_the_tour_of_heroes_home_page(String actor) {
        theActorCalled(actor).attemptsTo(NavigateTo.theTourOfHeroesHomePage());
    }

    @When("she/he logs in")
    public void logs_in() {
        withCurrentActor(LogInTo.oauth());
        withCurrentActor(NavigateTo.theGoogleLoginPage());
        withCurrentActor(LogInTo.google());
    }

    @Then("the profile picture can be seen")
    public void the_profile_picture_can_be_seen() {
        theActorInTheSpotlight().should(
                seeThat("user icon source",
                        LoginResult.userIconSrc(), is("https://via.placeholder.com/40"))
        );
    }
}
