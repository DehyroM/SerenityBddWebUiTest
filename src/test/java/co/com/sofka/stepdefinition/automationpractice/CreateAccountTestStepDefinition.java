package co.com.sofka.stepdefinition.automationpractice;

import co.com.sofka.model.automationpractice.RegistrationModel;
import co.com.sofka.stepdefinition.Setup;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;

import static co.com.sofka.model.usersdata.UserRegistrationData.userRegistrationData;
import static co.com.sofka.question.createaccount.NoPasswordInRegister.noPasswordInRegister;
import static co.com.sofka.question.createaccount.SuccessfulRegistration.createAccount;
import static co.com.sofka.task.automationpractice.BrowseToCreateAnAccount.browseToCreateAnAccount;
import static co.com.sofka.task.automationpractice.FillCreateAnAccount.fillCreateAnAccount;
import static co.com.sofka.util.OptionKeys.FAIL_PASS_REGISTER;
import static co.com.sofka.util.OptionKeys.SUCCESSFUL_REGISTER;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.equalTo;

public class CreateAccountTestStepDefinition extends Setup {

    private static final Logger LOGGER = Logger.getLogger(CreateAccountTestStepDefinition.class);
    private static final String REGISTER_MESSAGE = "LOGGER IN REGISTER MESSAGE";
    private final RegistrationModel userRegistration = userRegistrationData();

    @When("el cliente entra en la seccion Sign in del sitio Web, ingresa un correo y clickea en Create an account")
    public void elClienteEntraEnLaSeccionSignInDelSitioWebIngresaUnCorreoYClickeaEnCreateAnAccount() {

        theActorInTheSpotlight().attemptsTo(
                browseToCreateAnAccount()
                        .typingTheEmailAccount(userRegistration.getEmailRegister())
        );
        LOGGER.info(REGISTER_MESSAGE);

    }

    @When("el cliente ingresa sus datos personales y clickea el boton Register")
    public void elClienteIngresaSusDatosPersonalesYClickeaElBotonRegister() {

        theActorInTheSpotlight().attemptsTo(
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
                        .typingTheAddressAlias(userRegistration.getAlias())
        );
    }

    @Then("recibira un mensaje de confirmacion exitoso")
    public void recibiraUnMensajeDeConfirmacionExitoso() {

        theActorInTheSpotlight().should(
                seeThat(
                        createAccount()
                                .wasValidatedWithSuccessfulMessage(SUCCESSFUL_REGISTER.getValue())
                                .is(), equalTo(true)
                )
        );
    }

    @When("el cliente ingresa sus datos personales sin ingresar el campo password y clickea en Register")
    public void elClienteIngresaSusDatosPersonalesSinIngresarElNumeroDeTelefonoYClickeaEnRegister() {

        theActorInTheSpotlight().attemptsTo(
                fillCreateAnAccount()
                        .selectingTheTitle(userRegistration.getTitle())
                        .typingTheFirstName(userRegistration.getFirstName())
                        .typingTheLastName(userRegistration.getLastName())
                        .typingThePasswordRegister("")
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
                        .typingTheAddressAlias(userRegistration.getAlias())
        );

    }

    @Then("recibira un mensaje de error indicando que se requiere el campo de password")
    public void recibiraUnMensajeDeErrorIndicandoQueSeRequiereElCampoDeTelefono() {

        theActorInTheSpotlight().should(
                seeThat(
                        noPasswordInRegister()
                                .wasValidatedWithPasswordErrorMessage(FAIL_PASS_REGISTER.getValue())
                                .is(), equalTo(true)
                )
        );

    }

}
