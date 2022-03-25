package co.com.sofka.task.automationpractice;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.actions.SelectFromOptions;

import static co.com.sofka.ui.automationpractice.AutomationPractice.*;

public class FillContactUs implements Task {

    private String emailAddress;
    private String orderReference;
    private String message;
    private String subject;

    public FillContactUs typingTheEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
        return this;
    }

    public FillContactUs typingTheOrderReference(String orderReference) {
        this.orderReference = orderReference;
        return this;
    }

    public FillContactUs typingTheMessage(String message) {
        this.message = message;
        return this;
    }

    public FillContactUs andEnteringSubject(String subject) {
        this.subject = subject;
        return this;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Scroll.to(EMAIl_CONTACT_US),
                Enter.theValue(emailAddress).into(EMAIl_CONTACT_US),

                Scroll.to(ORDER_REFERENCE),
                Enter.theValue(orderReference).into(ORDER_REFERENCE),

                Scroll.to(MESSAGE),
                Enter.theValue(message).into(MESSAGE),

                Scroll.to(SUBJECT_HEADING),
                SelectFromOptions.byVisibleText(subject).from(SUBJECT_HEADING),

                Scroll.to(SEND_CONTACT_US),
                Click.on(SEND_CONTACT_US)

        );

    }

    public static FillContactUs fillContactUs(){
        return new FillContactUs();
    }
}
