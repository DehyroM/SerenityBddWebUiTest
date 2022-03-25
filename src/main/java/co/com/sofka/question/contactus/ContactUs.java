package co.com.sofka.question.contactus;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.com.sofka.ui.automationpractice.AutomationPractice.CONTACT_US_VALIDATION;

public class ContactUs implements Question<Boolean> {

    private String validationMessage;

    public ContactUs wasValidatedWithSuccessfulMessage(String validationMessage) {
        this.validationMessage = validationMessage;
        return this;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return CONTACT_US_VALIDATION.resolveFor(actor).containsOnlyText(validationMessage);
    }

    public ContactUs is(){
        return this;
    }

    public static ContactUs contactUs(){
        return new ContactUs();
    }
}
