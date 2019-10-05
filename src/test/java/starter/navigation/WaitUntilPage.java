package starter.navigation;

import net.serenitybdd.screenplay.Tasks;
import org.hamcrest.Matcher;

public class WaitUntilPage {
    public static WaitUntilPageIsReady the(Class<? extends SwitchablePageObject> targetPageClass, Matcher<PageState> expectedState) {
        return Tasks.instrumented(WaitUntilPageIsReady.class, targetPageClass, expectedState);
    }
}
