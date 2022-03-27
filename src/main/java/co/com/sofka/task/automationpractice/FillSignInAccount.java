package co.com.sofka.task.automationpractice;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;

import static co.com.sofka.ui.automationpractice.AutomationPractice.*;

public class FillSignInAccount implements Task {

    private String emailSignIn;
    private String passwordSignIn;

    public FillSignInAccount typingTheEmailSignIn(String emailSignIn) {
        this.emailSignIn = emailSignIn;
        return this;
    }

    public FillSignInAccount typingThePasswordSignIn(String passwordSignIn) {
        this.passwordSignIn = passwordSignIn;
        return this;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Scroll.to(EMAIL_LOGIN),
                Enter.theValue(emailSignIn).into(EMAIL_LOGIN),

                Scroll.to(PASS_LOGIN),
                Enter.theValue(passwordSignIn).into(PASS_LOGIN),

                Scroll.to(SIGN_IN_BTN),
                Click.on(SIGN_IN_BTN)
        );
    }

    public static FillSignInAccount fillSignInAccount(){
        return new FillSignInAccount();
    }
}
