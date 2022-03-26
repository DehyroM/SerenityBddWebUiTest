package co.com.sofka.question.contactus;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.com.sofka.ui.automationpractice.AutomationPractice.CONTACT_US_VALIDATION;

public class SuccessfulContactUs implements Question<Boolean> {

    private String validationMessage;

    public SuccessfulContactUs wasValidatedWithSuccessfulMessage(String validationMessage) {
        this.validationMessage = validationMessage;
        return this;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return CONTACT_US_VALIDATION.resolveFor(actor).containsOnlyText(validationMessage);
    }

    public SuccessfulContactUs is(){
        return this;
    }

    public static SuccessfulContactUs contactUs(){
        return new SuccessfulContactUs();
    }
}
