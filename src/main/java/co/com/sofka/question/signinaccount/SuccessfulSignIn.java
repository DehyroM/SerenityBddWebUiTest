package co.com.sofka.question.signinaccount;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.com.sofka.ui.automationpractice.AutomationPractice.REGISTER_LOGIN_VALIDATION;

public class SuccessfulSignIn implements Question<Boolean> {

    private String validationMessage;

    public SuccessfulSignIn wasValidatedWithSuccessfulMessage(String validationMessage) {
        this.validationMessage = validationMessage;
        return this;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return REGISTER_LOGIN_VALIDATION.resolveFor(actor).containsOnlyText(validationMessage);
    }

    public SuccessfulSignIn is(){
        return this;
    }

    public static SuccessfulSignIn signInAccount(){
        return new SuccessfulSignIn();
    }
}
