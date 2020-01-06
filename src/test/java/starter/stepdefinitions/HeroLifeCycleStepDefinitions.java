package starter.stepdefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import starter.hero.CreateA;
import starter.hero.Heroes;
import starter.navigation.NavigateTo;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.*;
import static org.hamcrest.Matchers.hasItem;

public class HeroLifeCycleStepDefinitions {
    @Given("^(.*) is on the tour of heroes life cycle page")
    public void is_on_the_tour_of_heroes_life_cycle_page(String actor) {
        theActorCalled(actor).attemptsTo(NavigateTo.theTourOfHeroesLifeCyclePage());
    }

    @When("she/he adds a Hero")
    public void heAddsAHero() {
        withCurrentActor(CreateA.hero("Antman"));
    }

    @Then("the hero can be seen")
    public void theHeroCanBeSeen() {
        theActorInTheSpotlight().should(
                seeThat("hero name list",
                        Heroes.names(), hasItem("Antman"))
        );
    }
}
