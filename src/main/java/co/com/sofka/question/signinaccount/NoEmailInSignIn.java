package co.com.sofka.question.signinaccount;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.com.sofka.ui.automationpractice.AutomationPractice.NOT_EMAIL_IN_LOGIN;

public class NoEmailInSignIn implements Question<Boolean> {

    private String emailErrorMessage;

    public NoEmailInSignIn wasValidatedWithEmailErrorMessage(String emailErrorMessage) {
        this.emailErrorMessage = emailErrorMessage;
        return this;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return NOT_EMAIL_IN_LOGIN.resolveFor(actor).containsOnlyText(emailErrorMessage);
    }

    public NoEmailInSignIn is(){
        return this;
    }

    public static NoEmailInSignIn noEmailInSignIn(){
        return new NoEmailInSignIn();
    }
}
