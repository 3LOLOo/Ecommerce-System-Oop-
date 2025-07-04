package org.example;
import org.example.services.CheckoutService;
import org.example.models.*;

import java.time.LocalDate;


public class Main {
    public static void main(String[] args) {

        Product cheese = new ExpirableShippableProduct("Cheese", 100, 5, 500, LocalDate.now().plusDays(7));
        Product tv = new ShippableProduct("TV", 1000, 2, 10000);
        Product scratchCard = new Product("Mobile Scratch Card", 50, 10);
        Product softwareLicense = new ExpirableProduct("Software License", 200, 5, LocalDate.now().plusDays(365));

        Customer customer1 = new Customer("Mohamed", 2500);
        Cart cart1 = new Cart();
        cart1.add(cheese, 2);
        cart1.add(tv, 1);
        cart1.add(scratchCard, 1);
        cart1.add(softwareLicense, 1);
        CheckoutService.checkout(customer1, cart1);


    }
}