package starter.navigation;

import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.WhenPageOpens;

@DefaultUrl("https://accounts.google.com")
public class GoogleAccountsPage extends SwitchablePageObject {

    @WhenPageOpens
    public void waitForTitle() {
        this.waitForTitleToAppear("Sign in - Google Accounts");
    }
}
