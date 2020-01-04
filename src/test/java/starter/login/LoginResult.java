package starter.login;

import net.serenitybdd.core.pages.WebElementState;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.WebElementQuestion;
import net.serenitybdd.screenplay.questions.targets.TheTarget;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.targets.TargetBuilder;
import org.openqa.selenium.By;

public class LoginResult {

    public static Question<String> userIconSrc() {
        return actor ->TheTarget.attributeNamed("src").forTarget(Target.the(UserBadge.USER_ICON.getBy().toString()).located(UserBadge.USER_ICON.getBy())).answeredBy(actor);
    }
}
