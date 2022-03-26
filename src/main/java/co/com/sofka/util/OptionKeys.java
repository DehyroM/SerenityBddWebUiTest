package co.com.sofka.util;

public enum OptionKeys {
    CUSTOMER_SERVICE("Customer service"),
    WEBMASTER("Webmaster"),
    SUCCESSFUL_CONTACT_US("Your message has been successfully sent to our team."),
    FAIL_CONTACT_US("Invalid email address."),
    SUCCESSFUL_REGISTER("MY ACCOUNT"),
    //Welcome to your account. Here you can manage all of your personal information and orders.
    FAIL_PASS_REGISTER("passwd is required.");

    private final String value;

    OptionKeys(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
