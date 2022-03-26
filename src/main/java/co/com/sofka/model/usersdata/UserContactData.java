package co.com.sofka.model.usersdata;

import co.com.sofka.model.automationpractice.ContactUsModel;
import com.github.javafaker.Faker;

public class UserContactData {

    private static Faker faker;
    private static String name;
    private static String email;
    private static String product;
    private static String order;
    private static String message;
    private static ContactUsModel data;

    public static ContactUsModel userContactData(){

        faker = new Faker();
        name = faker.name().firstName();
        email = name+"@gmail.com";
        product = faker.commerce().productName();
        order = "Query about "+product;
        message = "I would like to know if you have this product: "+product;

        data = new ContactUsModel();
        data.setEmailContactUs(email);
        data.setOrderReference(order);
        data.setMessageContactUs(message);

        return data;
    }

}
