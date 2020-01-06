package starter.login;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.TextContent;
import net.serenitybdd.screenplay.questions.targets.TheTarget;
import net.serenitybdd.screenplay.targets.Target;

public class LoginResult {

    public static Question<String> userIconSrc() {
        return actor -> TheTarget.attributeNamed("src").forTarget(Target.the(UserBadge.USER_ICON.getBy().toString()).located(UserBadge.USER_ICON.getBy())).answeredBy(actor);
    }

    public static Question<String> userName() {
        return actor -> TextContent.of(UserBadge.USER_NAME.getBy()).viewedBy(actor).asString();
    }
}
