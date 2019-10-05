package starter.navigation;

import net.serenitybdd.screenplay.*;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.pages.Pages;
import org.hamcrest.Matcher;

public class WaitUntilPageIsReady implements Interaction {
    private Class<SwitchablePageObject> targetPageClass;
    private SearchStrategy searchStrategy;
    private Matcher<? super PageState> expectedState;

    public WaitUntilPageIsReady(Class<SwitchablePageObject> targetPageClass, Matcher<? super PageState> expectedState) {
        this.targetPageClass = targetPageClass;
        this.expectedState = expectedState;
        this.searchStrategy = new DefaultSearchStrategy(expectedState);
    }

    public WaitUntilPageIsReady(Class<SwitchablePageObject> targetPageClass, SearchStrategy searchStrategy) {
        this.targetPageClass = targetPageClass;
        this.searchStrategy = searchStrategy;
    }

    @Override
    public <A extends Actor> void performAs(A actor) {
        SwitchablePageObject page = (new Pages(BrowseTheWeb.as(actor).getDriver())).getPage(this.targetPageClass);
        this.searchStrategy.search(actor, page);
    }

    public WaitUntilPageIsReadyBuilder forNoMoreThan(int amount) {
        return new WaitUntilPageIsReadyBuilder(this.targetPageClass, this.expectedState, amount);
    }

    public class WaitUntilPageIsReadyBuilder {
        private Class<SwitchablePageObject> targetPageClass;
        private Matcher<? super PageState> expectedState;
        private int amount;

        WaitUntilPageIsReadyBuilder(Class<SwitchablePageObject> targetPageClass, Matcher<? super PageState> expectedState, int amount) {
            this.targetPageClass = targetPageClass;
            this.expectedState = expectedState;
            this.amount = amount;
        }

        public WaitUntilPageIsReady seconds() {
            return new WaitUntilPageIsReady(this.targetPageClass, new CustomWaitInSecondsSearchStrategy(this.expectedState, this.amount));
        }

        public WaitUntilPageIsReady minutes() {
            return new WaitUntilPageIsReady(this.targetPageClass, new CustomWaitInMillisecondsSearchStrategy(this.expectedState, this.amount));
        }
    }

    private interface SearchStrategy {
        <A extends Actor> void search(A actor, SwitchablePageObject page);
    }

    private class DefaultSearchStrategy implements SearchStrategy {
        private Matcher<? super PageState> expectedState;

        DefaultSearchStrategy(Matcher<? super PageState> expectedState) {
            this.expectedState = expectedState;
        }

        @Override
        public <A extends Actor> void search(A actor, SwitchablePageObject page) {
            EventualConsequence<? super PageState> eventualConsequence = EventualConsequence.eventually(GivenWhenThen.seeThat(SwitchablePageQuestion.the(page), this.expectedState)).withNoReporting();
            actor.should(eventualConsequence);
        }
    }

    private class CustomWaitInSecondsSearchStrategy implements SearchStrategy {

        private Matcher<? super PageState> expectedState;
        private int amount;

        CustomWaitInSecondsSearchStrategy(Matcher<? super PageState> expectedState, int amount) {
            this.expectedState = expectedState;
            this.amount = amount;
        }

        @Override
        public <A extends Actor> void search(A actor, SwitchablePageObject page) {
            EventualConsequence<? super PageState> eventualConsequence = EventualConsequence.eventually(GivenWhenThen.seeThat(SwitchablePageQuestion.the(page), this.expectedState)).withNoReporting();
            actor.should(eventualConsequence.waitingForNoLongerThan(this.amount).seconds());
        }
    }

    private class CustomWaitInMillisecondsSearchStrategy implements SearchStrategy {

        private Matcher<? super PageState> expectedState;
        private int amount;

        CustomWaitInMillisecondsSearchStrategy(Matcher<? super PageState> expectedState, int amount) {
            this.expectedState = expectedState;
            this.amount = amount;
        }

        @Override
        public <A extends Actor> void search(A actor, SwitchablePageObject page) {
            EventualConsequence<? super PageState> eventualConsequence = EventualConsequence.eventually(GivenWhenThen.seeThat(SwitchablePageQuestion.the(page), this.expectedState)).withNoReporting();
            actor.should(eventualConsequence.waitingForNoLongerThan(this.amount).milliseconds());
        }
    }
}
