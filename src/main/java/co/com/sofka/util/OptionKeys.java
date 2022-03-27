package co.com.sofka.util;

public enum OptionKeys {
    CUSTOMER_SERVICE("Customer service"),
    WEBMASTER("Webmaster"),
    SUCCESSFUL_CONTACT_US("Your message has been successfully sent to our team."),
    FAIL_CONTACT_US("Invalid email address."),
    SUCCESSFUL_REGISTER_LOGIN("MY ACCOUNT"),
    FAIL_PASS_REGISTER("passwd is required."),
    FAIL_EMAIL_LOGIN("An email address required.");

    private final String value;

    OptionKeys(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
