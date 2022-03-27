package co.com.sofka.model.usersdata;

import co.com.sofka.model.automationpractice.RegistrationModel;
import co.com.sofka.util.Title;
import com.github.javafaker.Faker;

public class UserRegistrationData {

    private static Faker faker;
    private static Title title;
    private static String firstName;
    private static String lastName;
    private static String emailRegister;
    private static String passwordRegister;
    private static String day;
    private static int monthNumber;
    private static int titleNumber;
    private static String month;
    private static String year;
    private static String company;
    private static String address;
    private static String secondaryAddress;
    private static String city;
    private static String state;
    private static String zipCode;
    private static String information;
    private static String neighbourhood;
    private static String homePhone;
    private static String mobilePhone;
    private static String alias;

    private static RegistrationModel data;

    public static RegistrationModel userRegistrationData(){

        faker = new Faker();
        firstName = faker.name().firstName();
        titleNumber = faker.number().numberBetween(0,2);
        title = theTitle(titleNumber);
        lastName = faker.name().lastName();
        emailRegister = firstName+"_"+lastName+"@gmail.com";
        zipCode = String.valueOf(faker.number().numberBetween(10000,99999));
        passwordRegister = firstName+"."+zipCode;
        day = String.valueOf(faker.number().numberBetween(1,29));
        month = String.valueOf(faker.number().numberBetween(1,13));
        year = String.valueOf(faker.number().numberBetween(1900,2022));
        company = faker.company().name();
        address = faker.address().streetAddress();
        secondaryAddress = faker.address().secondaryAddress();
        city = faker.address().cityName();
        state = faker.address().state();
        neighbourhood = faker.address().streetName();
        information = "Neighbourhood "+neighbourhood;
        homePhone = String.valueOf(faker.number().numberBetween(10000,99999));
        mobilePhone = String.valueOf(faker.number().numberBetween(1000000,9999999));
        alias = faker.superhero().name()+" home";

        data = new RegistrationModel();
        data.setTitle(title);
        data.setFirstName(firstName);
        data.setLastName(lastName);
        data.setEmailRegister(emailRegister);
        data.setPasswordRegister(passwordRegister);
        data.setDay(day);
        data.setMonth(month);
        data.setYear(year);
        data.setCompany(company);
        data.setAddress(address);
        data.setSecondaryAddress(secondaryAddress);
        data.setCity(city);
        data.setState(state);
        data.setZipCode(zipCode);
        data.setInformation(information);
        data.setHomePhone(homePhone);
        data.setMobilePhone(mobilePhone);
        data.setAlias(alias);

        return data;
    }

    public static Title theTitle(int titleItem){
        Title[] titleNames = {Title.MR, Title.MRS};
        return titleNames[titleItem];
    }
}
