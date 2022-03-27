package co.com.sofka.stepdefinition.automationpractice;

import co.com.sofka.stepdefinition.Setup;
import io.cucumber.java.en.Given;
import org.apache.log4j.Logger;

import static co.com.sofka.task.landingpage.OpenLandingPage.openLandingPage;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class CommonStepDefinition extends Setup {

    private static final Logger LOGGER = Logger.getLogger(CommonStepDefinition.class);
    private static final String ACTOR_NAME = "Cliente";
    private static final String LANDING_PAGE_ERROR = "UNABLE TO OPEN LANDING PAGE";

    @Given("el cliente se encuentra en el Home del sitio Web de Automation Practice")
    public void elClienteSeEncuentraEnElHomeDelSitioWebDeAutomationPractice() {

        try{
            actorSetupTheBrowser(ACTOR_NAME);
            theActorInTheSpotlight().wasAbleTo(
                    openLandingPage()
            );
        }catch (Exception e){
            LOGGER.error(e.getMessage(), e);
            LOGGER.warn(LANDING_PAGE_ERROR);
        }
    }
}
