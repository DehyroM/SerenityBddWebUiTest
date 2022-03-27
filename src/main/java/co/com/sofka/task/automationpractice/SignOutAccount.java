package co.com.sofka.task.automationpractice;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.sofka.ui.automationpractice.AutomationPractice.REGISTER_LOGIN_VALIDATION;
import static co.com.sofka.ui.automationpractice.AutomationPractice.SIGN_OUT;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class SignOutAccount implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(REGISTER_LOGIN_VALIDATION, isVisible()),

                Scroll.to(SIGN_OUT),
                Click.on(SIGN_OUT)
        );
    }

    public static SignOutAccount signOutAccount(){
        return new SignOutAccount();
    }
}
