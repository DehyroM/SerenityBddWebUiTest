package co.com.sofka.stepdefinition.automationpractice;

import co.com.sofka.model.automationpractice.ContactUsModel;
import co.com.sofka.stepdefinition.Setup;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;

import static co.com.sofka.model.usersdata.UserContactData.userContactData;
import static co.com.sofka.question.contactus.SuccessfulContactUs.contactUs;
import static co.com.sofka.question.contactus.NoEmailInContactUs.noEmailInContactUs;
import static co.com.sofka.task.automationpractice.BrowseToContactUs.browseToContactUs;
import static co.com.sofka.task.automationpractice.FillContactUs.fillContactUs;
import static co.com.sofka.util.OptionKeys.*;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.equalTo;

public class ContactUsTestStepDefinition extends Setup {

    private static final Logger LOGGER = Logger.getLogger(ContactUsTestStepDefinition.class);
    private final ContactUsModel userContactUs = userContactData();
    private static final String CONTACT_US_PAGE_ERROR = "UNABLE TO OPEN CONTACT US PAGE";
    private static final String FILL_CONTACT_US_PAGE_ERROR = "UNABLE TO FILL USER DATA IN CONTACT US PAGE";
    private static final String CONTACT_US_SUBMIT_VALIDATION_ERROR = "WRONG VALIDATION FOR SUCCESSFUL SUBMIT IN CONTACT US PAGE";
    private static final String CONTACT_US_FAIL_VALIDATION_ERROR = "WRONG VALIDATION FOR FAIL SUBMIT IN CONTACT US PAGE";
    private static final String CONTACT_US_DONE = "CONTACT US SUBMIT DONE SUCCESSFULLY";
    private static final String CONTACT_US_FAIL = "CONTACT US SUBMIT FAIL CORRECTLY CHECKED";

    @When("el cliente entra en la seccion Contact Us del sitio Web de Automation Practice")
    public void elClienteEntraEnLaSeccionContactUsDelSitioWebDeAutomationPractice() {

        try{
            theActorInTheSpotlight().attemptsTo(
                    browseToContactUs()
            );
        }catch (Exception e){
            LOGGER.error(e.getMessage(), e);
            LOGGER.warn(CONTACT_US_PAGE_ERROR);
        }
    }

    @When("el cliente ingresa la informacion de contacto requerida y clickea el boton Send")
    public void elClienteIngresaLaInformacionDeContactoRequeridaYClickeaElBotonSend() {

        try{
            theActorInTheSpotlight().attemptsTo(
                    fillContactUs()
                            .typingTheEmailAddress(userContactUs.getEmailContactUs())
                            .typingTheOrderReference(userContactUs.getOrderReference())
                            .typingTheMessage(userContactUs.getMessageContactUs())
                            .andEnteringSubject(CUSTOMER_SERVICE.getValue())
            );
        }catch (Exception e){
            LOGGER.error(e.getMessage(), e);
            LOGGER.warn(FILL_CONTACT_US_PAGE_ERROR);
        }
    }

    @Then("recibira un mensaje de confirmacion por diligenciar la peticion")
    public void recibiraUnMensajeDeConfirmacionPorDiligenciarLaPeticion() {

        try{
            theActorInTheSpotlight().should(
                    seeThat(
                            contactUs()
                                    .wasValidatedWithSuccessfulMessage(SUCCESSFUL_CONTACT_US.getValue())
                                    .is(), equalTo(true)
                    )
            );
        }catch (Exception e){
            LOGGER.error(e.getMessage(), e);
            LOGGER.warn(CONTACT_US_SUBMIT_VALIDATION_ERROR);
        }
        LOGGER.info(CONTACT_US_DONE);
    }

    @When("el cliente ingresa una informacion de contacto pero sin ingresar el email y clickea el boton Send")
    public void elClienteIngresaUnaInformacionDeContactoPeroSinIngresarElEmailYClickeaElBotonSend() {

        try{
            theActorInTheSpotlight().attemptsTo(
                    fillContactUs()
                            .typingTheEmailAddress("")
                            .typingTheOrderReference(userContactUs.getOrderReference())
                            .typingTheMessage(userContactUs.getMessageContactUs())
                            .andEnteringSubject(CUSTOMER_SERVICE.getValue())
            );
        }catch (Exception e){
            LOGGER.error(e.getMessage(), e);
            LOGGER.warn(FILL_CONTACT_US_PAGE_ERROR);
        }
    }

    @Then("recibira un mensaje de error indicando que se requiere el email para enviar la peticion")
    public void recibiraUnMensajeDeErrorIndicandoQueSeRequiereElEmailParaEnviarLaPeticion() {

        try {
            theActorInTheSpotlight().should(
                    seeThat(
                            noEmailInContactUs()
                                    .wasValidatedWithEmailErrorMessage(FAIL_CONTACT_US.getValue())
                                    .is(), equalTo(true)
                    )
            );
        }catch (Exception e){
            LOGGER.error(e.getMessage(), e);
            LOGGER.warn(CONTACT_US_FAIL_VALIDATION_ERROR);
        }
        LOGGER.info(CONTACT_US_FAIL);
    }
}
