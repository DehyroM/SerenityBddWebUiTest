package co.com.sofka.task.automationpractice;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.sofka.ui.automationpractice.AutomationPractice.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class BrowseToCreateAnAccount implements Task {

    private String emailAccount;

    public BrowseToCreateAnAccount typingTheEmailAccount(String emailAccount) {
        this.emailAccount = emailAccount;
        return this;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Scroll.to(SIGN_IN),
                Click.on(SIGN_IN),

                WaitUntil.the(EMAIL_CREATE_ACCOUNT, isVisible()),
                Scroll.to(EMAIL_CREATE_ACCOUNT),
                Enter.theValue(emailAccount).into(EMAIL_CREATE_ACCOUNT),

                Scroll.to(CREATE_AN_ACCOUNT_BTN),
                Click.on(CREATE_AN_ACCOUNT_BTN)
        );
    }

    public static BrowseToCreateAnAccount browseToCreateAnAccount(){
        return new BrowseToCreateAnAccount();
    }
}
