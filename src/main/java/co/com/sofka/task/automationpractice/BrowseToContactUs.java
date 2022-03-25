package co.com.sofka.task.automationpractice;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;

import static co.com.sofka.ui.automationpractice.AutomationPractice.CONTACT_US;

public class BrowseToContactUs implements Task {


    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Scroll.to(CONTACT_US),
                Click.on(CONTACT_US)
        );
    }

    public static BrowseToContactUs browseToContactUs(){
        return new BrowseToContactUs();
    }
}
