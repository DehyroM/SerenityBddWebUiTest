package co.com.sofka.stepdefinition.automationpractice;

import co.com.sofka.model.automationpractice.RegistrationModel;
import co.com.sofka.stepdefinition.Setup;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;

import static co.com.sofka.model.usersdata.UserRegistrationData.userRegistrationData;
import static co.com.sofka.question.signinaccount.NoEmailInSignIn.noEmailInSignIn;
import static co.com.sofka.question.signinaccount.SuccessfulSignIn.signInAccount;
import static co.com.sofka.task.automationpractice.BrowseToCreateAnAccount.browseToCreateAnAccount;
import static co.com.sofka.task.automationpractice.FillCreateAnAccount.fillCreateAnAccount;
import static co.com.sofka.task.automationpractice.FillSignInAccount.fillSignInAccount;
import static co.com.sofka.task.automationpractice.SignOutAccount.signOutAccount;
import static co.com.sofka.util.OptionKeys.*;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.equalTo;

public class SignInTestStepDefinition extends Setup {

    private static final Logger LOGGER = Logger.getLogger(SignInTestStepDefinition.class);
    private final RegistrationModel userRegistration = userRegistrationData();
    private static final String SIGN_IN_PAGE_ERROR = "UNABLE TO OPEN SIGN IN PAGE";
    private static final String FILL_SIGN_IN_PAGE_ERROR = "UNABLE TO FILL USER DATA IN SIGN IN PAGE";
    private static final String SIGN_IN_VALIDATION_ERROR = "WRONG VALIDATION FOR SUCCESSFUL LOGIN IN SIGN IN PAGE";
    private static final String SIGN_IN_FAIL_VALIDATION_ERROR = "WRONG VALIDATION FOR FAIL LOGIN IN SIGN IN PAGE";
    private static final String SIGN_IN_DONE = "SIGN IN DONE SUCCESSFULLY";
    private static final String SIGN_IN_FAIL = "SIGN IN FAIL CORRECTLY CHECKED";

    @When("el cliente entra en la seccion Sign in del sitio Web")
    public void elClienteEntraEnLaSeccionSignInDelSitioWeb() {

        try {
            theActorInTheSpotlight().attemptsTo(
                    browseToCreateAnAccount()
                            .typingTheEmailAccount(userRegistration.getEmailRegister()),
                    fillCreateAnAccount()
                            .selectingTheTitle(userRegistration.getTitle())
                            .typingTheFirstName(userRegistration.getFirstName())
                            .typingTheLastName(userRegistration.getLastName())
                            .typingThePasswordRegister(userRegistration.getPasswordRegister())
                            .settingTheDay(userRegistration.getDay())
                            .settingTheMonth(userRegistration.getMonth())
                            .settingTheYear(userRegistration.getYear())
                            .typingTheCompanyName(userRegistration.getCompany())
                            .typingTheAddress(userRegistration.getAddress())
                            .typingTheSecondaryAddress(userRegistration.getSecondaryAddress())
                            .typingTheCity(userRegistration.getCity())
                            .settingTheState(userRegistration.getState())
                            .typingTheZipCode(userRegistration.getZipCode())
                            .typingAdditionalInformation(userRegistration.getInformation())
                            .typingTheHomePhone(userRegistration.getHomePhone())
                            .typingTheMobilePhone(userRegistration.getMobilePhone())
                            .typingTheAddressAlias(userRegistration.getAlias()),
                    signOutAccount()
            );
        }catch (Exception e){
            LOGGER.error(e.getMessage(), e);
            LOGGER.warn(SIGN_IN_PAGE_ERROR);
        }
    }

    @When("el cliente ingresa sus datos personales y clickea el boton Sign in")
    public void elClienteIngresaSusDatosPersonalesYClickeaElBotonSignIn() {

        try {
            theActorInTheSpotlight().attemptsTo(
                    fillSignInAccount()
                            .typingTheEmailSignIn(userRegistration.getEmailRegister())
                            .typingThePasswordSignIn(userRegistration.getPasswordRegister())
            );
        }catch (Exception e){
            LOGGER.error(e.getMessage(), e);
            LOGGER.warn(FILL_SIGN_IN_PAGE_ERROR);
        }
    }

    @Then("debera aparecer la seccion MY ACCOUNT del usuario logueado")
    public void deberaAparecerLaSeccionMYACCOUNTDelUsuarioLogueado() {

        try {
            theActorInTheSpotlight().should(
                    seeThat(
                            signInAccount()
                                    .wasValidatedWithSuccessfulMessage(SUCCESSFUL_REGISTER_LOGIN.getValue()).is(), equalTo(true)
                    )
            );
        }catch (Exception e){
            LOGGER.error(e.getMessage(), e);
            LOGGER.warn(SIGN_IN_VALIDATION_ERROR);
        }
        LOGGER.info(SIGN_IN_DONE);
    }

    @When("el cliente ingresa un password sin ingresar el campo email y clickea en Sign in")
    public void elClienteIngresaUnPasswordSinIngresarElCampoEmailYClickeaEnSignIn() {

        try {
            theActorInTheSpotlight().attemptsTo(
                    fillSignInAccount()
                            .typingTheEmailSignIn("")
                            .typingThePasswordSignIn(userRegistration.getPasswordRegister())
            );
        }catch (Exception e){
            LOGGER.error(e.getMessage(), e);
            LOGGER.warn(FILL_SIGN_IN_PAGE_ERROR);
        }
    }

    @Then("recibira un mensaje de error indicando que se requiere el campo email")
    public void recibiraUnMensajeDeErrorIndicandoQueSeRequiereElCampoEmail() {

        try {
            theActorInTheSpotlight().should(
                    seeThat(
                            noEmailInSignIn()
                                    .wasValidatedWithEmailErrorMessage(FAIL_EMAIL_LOGIN.getValue()).is(), equalTo(true)
                    )
            );
        }catch (Exception e){
            LOGGER.error(e.getMessage(), e);
            LOGGER.warn(SIGN_IN_FAIL_VALIDATION_ERROR);
        }
        LOGGER.info(SIGN_IN_FAIL);
    }
}
