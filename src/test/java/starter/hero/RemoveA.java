package starter.hero;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.targets.Target;

import static net.serenitybdd.core.annotations.findby.By.buttonText;

public class RemoveA {
    public static Performable hero(String name) {
        return new Performable() {
            @Override
            public <T extends Actor> void performAs(T actor) {
                Target.the("Element list")
                        .located(HeroList.HEROES.getBy())
                        .resolveAllFor(actor)
                        .stream()
                        .filter(webElementFacade -> webElementFacade.containsText(name))
                        .findFirst()
                        .<WebElementFacade>map(webElementFacade -> webElementFacade.findBy(buttonText("delete")))
                        .ifPresent(WebElementFacade::click);
            }
        };
    }
}
