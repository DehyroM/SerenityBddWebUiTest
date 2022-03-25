package co.com.sofka.util;

public enum OptionsKeys {
    CUSTOMER_SERVICE("Customer service"),
    USERNAME("Webmaster");

    private final String value;

    OptionsKeys(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
