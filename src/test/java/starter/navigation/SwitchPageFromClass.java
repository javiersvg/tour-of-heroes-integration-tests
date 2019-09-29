package starter.navigation;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.util.NameConverter;

public class SwitchPageFromClass implements Interaction {
    private String targetPageName;
    private final Class<SwitchablePageObject> targetPageClass;

    public SwitchPageFromClass(Class<SwitchablePageObject> targetPageClass) {
        this.targetPageClass = targetPageClass;
        this.targetPageName = NameConverter.humanize(targetPageClass.getSimpleName());
    }

    @Step("{0} opens the #targetPageName")
    @Override
    public <T extends Actor> void performAs(T theUser) {
        SwitchablePageObject targetPage = (new Pages(BrowseTheWeb.as(theUser).getDriver())).getPage(this.targetPageClass);
        targetPage.setDriver(BrowseTheWeb.as(theUser).getDriver());
        targetPage.switchToWindow();
    }
}
