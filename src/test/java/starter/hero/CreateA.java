package starter.hero;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.SendKeys;

public class CreateA {
    public static Performable hero(String name) {
        return Task.where("{0} attempts to create a Hero",
                Click.on(AddHeroButton.ADD_HERO_BUTTON.getBy()),
                SendKeys.of(name).into(AddHeroForm.HERO_NAME_FIELD.getBy()),
                Click.on(AddHeroForm.OK_BUTTON.getBy()));
    }
}
