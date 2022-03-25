package co.com.sofka.ui.automationpractice;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;

import static org.openqa.selenium.By.xpath;

public class AutomationPractice extends PageObject {

    public static final Target CONTACT_US = Target
            .the("Contact Us")
            .located(xpath("//*[@id=\"contact-link\"]/a"));

    public static final Target SIGN_IN = Target
            .the("Sign in")
            .located(xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a"));

    //For fill elements in "Contact Us"

    public static final Target MESSAGE = Target
            .the("message")
            .located(xpath("//*[@id='message']"));

    public static final Target EMAIl_CONTACT_US = Target
            .the("Email Contact Us")
            .located(xpath("//*[@id=\"email\"]"));

    public static final Target ORDER_REFERENCE = Target
            .the("Order Reference")
            .located(xpath("//*[@id=\"id_order\"]"));

    public static final Target SUBJECT_HEADING = Target
            .the("Subject Heading")
            .located(xpath("//*[@id=\"id_contact\"]"));

    public static final Target ATTACH_FILE = Target
            .the("Attach_File")
            .located(xpath("//*[@id=\"fileUpload\"]"));

    public static final Target SEND_CONTACT_US = Target
            .the("Send Contact Us")
            .located(xpath("//*[@id=\"submitMessage\"]"));

    // For fill elements in "Create an Account"




    // For fill elements in "Log in"




    // For validations in "Contact Us"

    public static final Target CONTACT_US_VALIDATION = Target
            .the("Customer Service Validation")
            .located(xpath("//*[@id=\"center_column\"]/p"));

    public static final Target NOT_EMAIL_IN_CONTACT_US= Target
            .the("Invalid email address")
            .located(xpath("//*[@id=\"center_column\"]/div/ol/li"));

    // For validations in "Create an Account"





    // For validations in "Log in"



}
