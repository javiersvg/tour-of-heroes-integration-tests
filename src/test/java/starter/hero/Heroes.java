package starter.hero;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.TextContent;

import java.util.List;

public class Heroes {
    public static Question<List<String>> names() {
        return actor -> TextContent.of(HeroList.HEROES.getBy()).viewedBy(actor).asList();
    }
}
