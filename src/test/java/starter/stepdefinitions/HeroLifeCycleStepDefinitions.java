package starter.stepdefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import starter.hero.CreateA;
import starter.hero.Heroes;
import starter.hero.RemoveA;
import starter.navigation.NavigateTo;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.*;
import static org.hamcrest.Matchers.*;

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
                        Heroes.names(), hasItem(containsString("Antman")))
        );
    }

    @Given("he has a Hero")
    public void he_has_a_Hero() {
        theActorInTheSpotlight().should(
                seeThat("hero name list",
                        Heroes.names(), hasItem(containsString("Antman")))
        );
    }

    @When("he removes the Hero")
    public void he_removes_the_Hero() {
        withCurrentActor(RemoveA.hero("Antman"));
    }

    @Then("the Hero can no longer be seen")
    public void the_Hero_can_no_longer_be_seen() {
        theActorInTheSpotlight().should(
                seeThat("hero name list",
                        Heroes.names(), empty())
        );
    }
}
