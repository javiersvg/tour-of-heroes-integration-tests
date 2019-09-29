package starter.navigation;

import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;

public class Switch {
    public static Switch browserTo() {
        return new Switch();
    }

    public Interaction the(Class<? extends SwitchablePageObject> targetPageClass) {
        return Tasks.instrumented(SwitchPageFromClass.class, targetPageClass);
    }
}
