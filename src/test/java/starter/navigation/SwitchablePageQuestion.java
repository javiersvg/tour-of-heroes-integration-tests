package starter.navigation;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import org.openqa.selenium.NoSuchWindowException;

public class SwitchablePageQuestion implements Question<PageState> {
    private SwitchablePageObject page;

    private SwitchablePageQuestion(SwitchablePageObject page) {
        this.page = page;
    }

    public static SwitchablePageQuestion the(SwitchablePageObject page) {
        return new SwitchablePageQuestion(page);
    }

    @Override
    public PageState answeredBy(Actor actor) {
        try {
            this.page.switchToWindow();
            return new PageState(this.page.getDriver().getCurrentUrl(), this.page.getDriver().getTitle(), true);
        } catch (NoSuchWindowException e) {
            return new PageState(this.page.getDeclaredDefaultUrl().get(), "", false);
        }
    }
}
