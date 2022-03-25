package co.com.sofka.stepdefinition.automationpractice;

import co.com.sofka.model.automationpractice.ContactUsModel;
import co.com.sofka.stepdefinition.Setup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;

import static co.com.sofka.model.usersdata.UserData.userData;
import static co.com.sofka.question.contactus.ContactUs.contactUs;
import static co.com.sofka.question.contactus.NoEmailInContactUs.noEmailInContactUs;
import static co.com.sofka.task.automationpractice.BrowseToContactUs.browseToContactUs;
import static co.com.sofka.task.automationpractice.FillContactUs.fillContactUs;
import static co.com.sofka.task.landingpage.OpenLandingPage.openLandingPage;
import static co.com.sofka.util.OptionsKeys.CUSTOMER_SERVICE;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.equalTo;

public class ContactUsTestStepDefinition extends Setup {

    private static final Logger LOGGER = Logger.getLogger(ContactUsTestStepDefinition.class);
    private static final String ACTOR_NAME = "Student";
    private static final String MESSAGE = "LOGGER WORKING";
    private final ContactUsModel userContactUs = userData();

    @Given("el cliente se encuentra en el Home del sitio Web de Automation Practice")
    public void elClienteSeEncuentraEnElHomeDelSitioWebDeAutomationPractice() {

        actorSetupTheBrowser(ACTOR_NAME);
        theActorInTheSpotlight().wasAbleTo(
                openLandingPage()
        );
        LOGGER.info(MESSAGE);

    }

    @When("el cliente entra en la seccion Contact Us del sitio Web de Automation Practice")
    public void elClienteEntraEnLaSeccionContactUsDelSitioWebDeAutomationPractice() {

        theActorInTheSpotlight().attemptsTo(
                browseToContactUs()
        );

    }

    @When("el cliente ingresa la informacion de contacto requerida y clickea el boton Send")
    public void elClienteIngresaLaInformacionDeContactoRequeridaYClickeaElBotonSend() {

        theActorInTheSpotlight().attemptsTo(
                fillContactUs()
                        .typingTheEmailAddress(userContactUs.getEmailContactUs())
                        .typingTheOrderReference(userContactUs.getOrderReference())
                        .typingTheMessage(userContactUs.getMessageContactUs())
                        .andEnteringSubject(CUSTOMER_SERVICE.getValue())
        );

    }

    @Then("recibira un mensaje de confirmacion por diligenciar la peticion")
    public void recibiraUnMensajeDeConfirmacionPorDiligenciarLaPeticion() {

        theActorInTheSpotlight().should(
                seeThat(
                        contactUs()
                                .wasValidatedWithSuccessfulMessage("Your message has been successfully sent to our team.")
                                .is(), equalTo(true)
                )
        );

    }

    @When("el cliente ingresa una informacion de contacto pero sin ingresar el email y clickea el boton Send")
    public void elClienteIngresaUnaInformacionDeContactoPeroSinIngresarElEmailYClickeaElBotonSend() {

        theActorInTheSpotlight().attemptsTo(
                fillContactUs()
                        .typingTheEmailAddress("")
                        .typingTheOrderReference(userContactUs.getOrderReference())
                        .typingTheMessage(userContactUs.getMessageContactUs())
                        .andEnteringSubject(CUSTOMER_SERVICE.getValue())
        );

    }

    @Then("recibira un mensaje de error indicando que se requiere el email para enviar la peticion")
    public void recibiraUnMensajeDeErrorIndicandoQueSeRequiereElEmailParaEnviarLaPeticion() {

        theActorInTheSpotlight().should(
                seeThat(
                        noEmailInContactUs()
                                .wasValidatedWithEmailErrorMessage("Invalid email address.")
                                .is(), equalTo(true)
                )
        );

    }

}
