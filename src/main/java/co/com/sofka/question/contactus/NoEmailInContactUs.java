package co.com.sofka.question.contactus;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.com.sofka.ui.automationpractice.AutomationPractice.NOT_EMAIL_IN_CONTACT_US;

public class NoEmailInContactUs implements Question<Boolean> {

    private String emailErrorMessage;

    public NoEmailInContactUs wasValidatedWithEmailErrorMessage(String emailErrorMessage) {
        this.emailErrorMessage = emailErrorMessage;
        return this;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return NOT_EMAIL_IN_CONTACT_US.resolveFor(actor).containsOnlyText(emailErrorMessage);
    }

    public NoEmailInContactUs is(){
            return this;
    }

    public static NoEmailInContactUs noEmailInContactUs(){
        return new NoEmailInContactUs();
    }

}
