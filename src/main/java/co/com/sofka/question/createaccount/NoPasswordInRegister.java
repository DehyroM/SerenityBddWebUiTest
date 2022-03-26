package co.com.sofka.question.createaccount;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.com.sofka.ui.automationpractice.AutomationPractice.NOT_PASS_IN_REGISTER;

public class NoPasswordInRegister implements Question<Boolean> {

    private String passwordErrorMessage;

    public NoPasswordInRegister wasValidatedWithPasswordErrorMessage(String passwordErrorMessage) {
        this.passwordErrorMessage = passwordErrorMessage;
        return this;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return NOT_PASS_IN_REGISTER.resolveFor(actor).containsOnlyText(passwordErrorMessage);
    }

    public NoPasswordInRegister is(){
            return this;
    }

    public static NoPasswordInRegister noPasswordInRegister(){
        return new NoPasswordInRegister();
    }

}
