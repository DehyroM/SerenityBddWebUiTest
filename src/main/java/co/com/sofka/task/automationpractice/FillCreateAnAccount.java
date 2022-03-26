package co.com.sofka.task.automationpractice;

import co.com.sofka.util.Title;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.conditions.Check;

import static co.com.sofka.ui.automationpractice.AutomationPractice.*;
import static co.com.sofka.util.Title.MR;
import static co.com.sofka.util.Title.MRS;

public class FillCreateAnAccount implements Task {

    private Title title;
    private String firstName;
    private String lastName;
    private String emailRegister;
    private String passwordRegister;
    private String day;
    private String month;
    private String year;
    private String company;
    private String address;
    private String secondaryAddress;
    private String city;
    private String state;
    private String zipCode;
    private String information;
    private String homePhone;
    private String mobilePhone;
    private String alias;

    public FillCreateAnAccount selectingTheTitle(Title title) {
        this.title = title;
        return this;
    }

    public FillCreateAnAccount typingTheFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public FillCreateAnAccount typingTheLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public FillCreateAnAccount typingTheEmailRegister(String emailRegister) {
        this.emailRegister = emailRegister;
        return this;
    }

    public FillCreateAnAccount typingThePasswordRegister(String passwordRegister) {
        this.passwordRegister = passwordRegister;
        return this;
    }

    public FillCreateAnAccount settingTheDay(String day) {
        this.day = day;
        return this;
    }

    public FillCreateAnAccount settingTheMonth(String month) {
        this.month = month;
        return this;
    }

    public FillCreateAnAccount settingTheYear(String year) {
        this.year = year;
        return this;
    }

    public FillCreateAnAccount typingTheCompanyName(String company) {
        this.company = company;
        return this;
    }

    public FillCreateAnAccount typingTheAddress(String address) {
        this.address = address;
        return this;
    }

    public FillCreateAnAccount typingTheSecondaryAddress(String secondaryAddress) {
        this.secondaryAddress = secondaryAddress;
        return this;
    }

    public FillCreateAnAccount typingTheCity(String city) {
        this.city = city;
        return this;
    }

    public FillCreateAnAccount settingTheState(String state) {
        this.state = state;
        return this;
    }

    public FillCreateAnAccount typingTheZipCode(String zipCode) {
        this.zipCode = zipCode;
        return this;
    }

    public FillCreateAnAccount typingAdditionalInformation(String information) {
        this.information = information;
        return this;
    }

    public FillCreateAnAccount typingTheHomePhone(String homePhone) {
        this.homePhone = homePhone;
        return this;
    }

    public FillCreateAnAccount typingTheMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
        return this;
    }

    public FillCreateAnAccount typingTheAddressAlias(String alias) {
        this.alias = alias;
        return this;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Check.whether(MR.equals(title))
                        .andIfSo(
                                Scroll.to(MR_OPTION),
                                Click.on(MR_OPTION)
                        ).otherwise(
                                Check.whether(MRS.equals(title))
                                        .andIfSo(
                                                Scroll.to(MRS_OPTION),
                                                Click.on(MRS_OPTION)
                                        )
                        ),
                Scroll.to(FIRST_NAME),
                Enter.theValue(firstName).into(FIRST_NAME),

                Scroll.to(LAST_NAME),
                Enter.theValue(lastName).into(LAST_NAME),

                Scroll.to(CUSTOMER_PASSWD),
                Enter.theValue(passwordRegister).into(CUSTOMER_PASSWD),

                Scroll.to(DAY),
                SelectFromOptions.byValue(day).from(DAY),

                Scroll.to(MONTH),
                SelectFromOptions.byValue(month).from(MONTH),

                Scroll.to(YEAR),
                SelectFromOptions.byValue(year).from(YEAR),

                Scroll.to(NEWSLETTER_OPTION),
                Click.on(NEWSLETTER_OPTION),

                Scroll.to(OFFER_OPTION),
                Click.on(OFFER_OPTION),

                Scroll.to(COMPANY),
                Enter.theValue(company).into(COMPANY),

                Scroll.to(FIRST_ADDRESS),
                Enter.theValue(address).into(FIRST_ADDRESS),

                Scroll.to(SECONDARY_ADDRESS),
                Enter.theValue(secondaryAddress).into(SECONDARY_ADDRESS),

                Scroll.to(CITY),
                Enter.theValue(city).into(CITY),

                Scroll.to(STATE),
                SelectFromOptions.byVisibleText(state).from(STATE),

                Scroll.to(ZIP_CODE),
                Enter.keyValues(zipCode).into(ZIP_CODE),

                Scroll.to(ADD_INFO),
                Enter.keyValues(information).into(ADD_INFO),

                Scroll.to(HOME_PHONE),
                Enter.keyValues(homePhone).into(HOME_PHONE),

                Scroll.to(MOBILE_PHONE),
                Enter.keyValues(mobilePhone).into(MOBILE_PHONE),

                Scroll.to(ADDRESS_ALIAS),
                Clear.field(ADDRESS_ALIAS),
                Enter.keyValues(alias).into(ADDRESS_ALIAS),

                Scroll.to(REGISTER_BTN),
                Click.on(REGISTER_BTN)
        );
    }

    public static FillCreateAnAccount fillCreateAnAccount(){
        return new FillCreateAnAccount();
    }

}
