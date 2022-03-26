package co.com.sofka.question.createaccount;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.com.sofka.ui.automationpractice.AutomationPractice.REGISTER_VALIDATION;

public class SuccessfulRegistration implements Question<Boolean> {

    private String validationMessage;

    public SuccessfulRegistration wasValidatedWithSuccessfulMessage(String validationMessage) {
        this.validationMessage = validationMessage;
        return this;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return REGISTER_VALIDATION.resolveFor(actor).containsOnlyText(validationMessage);
    }

    public SuccessfulRegistration is(){
        return this;
    }

    public static SuccessfulRegistration createAccount(){
        return new SuccessfulRegistration();
    }
}
