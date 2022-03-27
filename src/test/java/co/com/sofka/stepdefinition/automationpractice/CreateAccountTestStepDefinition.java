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
import static co.com.sofka.util.OptionKeys.*;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.equalTo;

public class CreateAccountTestStepDefinition extends Setup {

    private static final Logger LOGGER = Logger.getLogger(CreateAccountTestStepDefinition.class);
    private final RegistrationModel userRegistration = userRegistrationData();
    private static final String CREATE_ACCOUNT_PAGE_ERROR = "UNABLE TO OPEN CREATE ACCOUNT PAGE";
    private static final String FILL_CREATE_ACCOUNT_PAGE_ERROR = "UNABLE TO FILL USER DATA IN CREATE ACCOUNT PAGE";
    private static final String CREATE_ACCOUNT_VALIDATION_ERROR = "WRONG VALIDATION FOR SUCCESSFUL SUBMIT IN CREATE ACCOUNT PAGE";
    private static final String CREATE_ACCOUNT_FAIL_VALIDATION_ERROR = "WRONG VALIDATION FOR FAIL SUBMIT IN CREATE ACCOUNT PAGE";
    private static final String CREATE_ACCOUNT_DONE = "CREATE ACCOUNT SUBMIT DONE SUCCESSFULLY";
    private static final String CREATE_ACCOUNT_FAIL = "CREATE ACCOUNT SUBMIT FAIL CORRECTLY CHECKED";

    @When("el cliente entra en la seccion Sign in del sitio Web, ingresa un correo y clickea en Create an account")
    public void elClienteEntraEnLaSeccionSignInDelSitioWebIngresaUnCorreoYClickeaEnCreateAnAccount() {

        try {
            theActorInTheSpotlight().attemptsTo(
                    browseToCreateAnAccount()
                            .typingTheEmailAccount(userRegistration.getEmailRegister())
            );
        }catch (Exception e){
            LOGGER.error(e.getMessage(), e);
            LOGGER.warn(CREATE_ACCOUNT_PAGE_ERROR);
        }
    }

    @When("el cliente ingresa sus datos personales y clickea el boton Register")
    public void elClienteIngresaSusDatosPersonalesYClickeaElBotonRegister() {

        try {
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
        }catch (Exception e){
            LOGGER.error(e.getMessage(), e);
            LOGGER.warn(FILL_CREATE_ACCOUNT_PAGE_ERROR);
        }
    }

    @Then("recibira un mensaje de confirmacion exitoso")
    public void recibiraUnMensajeDeConfirmacionExitoso() {

        try {
            theActorInTheSpotlight().should(
                    seeThat(
                            createAccount()
                                    .wasValidatedWithSuccessfulMessage(SUCCESSFUL_REGISTER_LOGIN.getValue())
                                    .is(), equalTo(true)
                    )
            );
        }catch (Exception e){
            LOGGER.error(e.getMessage(), e);
            LOGGER.warn(CREATE_ACCOUNT_VALIDATION_ERROR);
        }
        LOGGER.info(CREATE_ACCOUNT_DONE);
    }

    @When("el cliente ingresa sus datos personales sin ingresar el campo password y clickea en Register")
    public void elClienteIngresaSusDatosPersonalesSinIngresarElNumeroDeTelefonoYClickeaEnRegister() {

        try {
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
        }catch (Exception e){
            LOGGER.error(e.getMessage(), e);
            LOGGER.warn(FILL_CREATE_ACCOUNT_PAGE_ERROR);
        }
    }

    @Then("recibira un mensaje de error indicando que se requiere el campo de password")
    public void recibiraUnMensajeDeErrorIndicandoQueSeRequiereElCampoDeTelefono() {
        try {
            theActorInTheSpotlight().should(
                    seeThat(
                            noPasswordInRegister()
                                    .wasValidatedWithPasswordErrorMessage(FAIL_PASS_REGISTER.getValue())
                                    .is(), equalTo(true)
                    )
            );
        }catch (Exception e){
            LOGGER.error(e.getMessage(), e);
            LOGGER.warn(CREATE_ACCOUNT_FAIL_VALIDATION_ERROR);
        }
        LOGGER.info(CREATE_ACCOUNT_FAIL);
    }
}
