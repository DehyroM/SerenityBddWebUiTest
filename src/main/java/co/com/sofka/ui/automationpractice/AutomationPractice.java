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

    public static final Target EMAIL_CREATE_ACCOUNT = Target
            .the("Email Address for Register")
            .located(xpath("//*[@id=\"email_create\"]"));

    public static final Target CREATE_AN_ACCOUNT_BTN = Target
            .the("Create an account button")
            .located(xpath("//*[@id=\"SubmitCreate\"]"));

    public static final Target MR_OPTION = Target
            .the("Mr. Option")
            .located(xpath("//*[@id=\"account-creation_form\"]/div[1]/div[1]/div[1]/label"));

    public static final Target MRS_OPTION = Target
            .the("Mrs. Option")
            .located(xpath("//*[@id=\"account-creation_form\"]/div[1]/div[1]/div[2]/label"));

    public static final Target FIRST_NAME = Target
            .the("Customer First Name")
            .located(xpath("//*[@id=\"customer_firstname\"]"));

    public static final Target LAST_NAME = Target
            .the("Customer Last Name")
            .located(xpath("//*[@id=\"customer_lastname\"]"));

    public static final Target CUSTOMER_PASSWD = Target
            .the("Customer Password")
            .located(xpath("//*[@id=\"passwd\"]"));

    public static final Target DAY = Target
            .the("Day")
            .located(xpath("//*[@id=\"days\"]"));

    public static final Target MONTH = Target
            .the("Month")
            .located(xpath("//*[@id=\"months\"]"));

    public static final Target YEAR = Target
            .the("Year")
            .located(xpath("//*[@id=\"years\"]"));

    public static final Target NEWSLETTER_OPTION = Target
            .the("Newsletter Option")
            .located(xpath("//*[@id=\"newsletter\"]"));

    public static final Target OFFER_OPTION = Target
            .the("Offer Option")
            .located(xpath("//*[@id=\"optin\"]"));

    public static final Target COMPANY = Target
            .the("Company")
            .located(xpath("//*[@id=\"company\"]"));

    public static final Target FIRST_ADDRESS = Target
            .the("First Address")
            .located(xpath("//*[@id=\"address1\"]"));

    public static final Target SECONDARY_ADDRESS = Target
            .the("Secondary Address")
            .located(xpath("//*[@id=\"address2\"]"));

    public static final Target CITY = Target
            .the("City")
            .located(xpath("//*[@id=\"city\"]"));

    public static final Target STATE = Target
            .the("State")
            .located(xpath("//*[@id=\"id_state\"]"));

    public static final Target ZIP_CODE = Target
            .the("Zip Code")
            .located(xpath("//*[@id=\"postcode\"]"));

    public static final Target ADD_INFO = Target
            .the("Additional Information")
            .located(xpath("//*[@id=\"other\"]"));

    public static final Target HOME_PHONE = Target
            .the("Home Phone")
            .located(xpath("//*[@id=\"phone\"]"));

    public static final Target MOBILE_PHONE = Target
            .the("Mobile Phone")
            .located(xpath("//*[@id=\"phone_mobile\"]"));

    public static final Target ADDRESS_ALIAS = Target
            .the("Address Alias")
            .located(xpath("//*[@id=\"alias\"]"));

    public static final Target REGISTER_BTN = Target
            .the("Register Button")
            .located(xpath("//*[@id=\"submitAccount\"]/span"));

    // For fill elements in "Log in"

    public static final Target SIGN_OUT = Target
            .the("Sign Out")
            .located(xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[2]/a"));



    // For validations in "Contact Us"

    public static final Target CONTACT_US_VALIDATION = Target
            .the("Customer Service Validation")
            .located(xpath("//*[@id=\"center_column\"]/p"));

    public static final Target NOT_EMAIL_IN_CONTACT_US= Target
            .the("Invalid email address")
            .located(xpath("//*[@id=\"center_column\"]/div/ol/li"));

    // For validations in "Create an Account"

    public static final Target REGISTER_VALIDATION = Target
            .the("Welcome message")
            .located(xpath("//*[@id=\"center_column\"]/h1")); //*[@id="center_column"]/h1
    //*[@id="center_column"]/p/text()

    public static final Target NOT_PASS_IN_REGISTER= Target
            .the("Password is required")
            .located(xpath("//*[@id=\"center_column\"]/div/ol/li"));

    // For validations in "Log in"



}
