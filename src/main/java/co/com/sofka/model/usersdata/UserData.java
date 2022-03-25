package co.com.sofka.model.usersdata;

import co.com.sofka.model.automationpractice.ContactUsModel;
import com.github.javafaker.Faker;

public class UserData {

    public static ContactUsModel userData(){

        Faker faker = new Faker();
        String name = faker.name().firstName();
        String email = name+"@gmail.com";
        String product = faker.commerce().productName();
        String order = "Query about "+product;
        String message = "I would like to know if you have this product: "+product;

        ContactUsModel data = new ContactUsModel();
        data.setEmailContactUs(email);
        data.setOrderReference(order);
        data.setMessageContactUs(message);

        return data;
    }

}
