package org.example.models;
import java.time.LocalDate;

public class ExpirableShippableProduct extends ShippableProduct{
    private LocalDate expirationDate;

    public ExpirableShippableProduct(String name, double price, int quantity, double weight, LocalDate expirationDate) {
        super(name, price, quantity, weight);
        this.expirationDate = expirationDate;
    }

    @Override
    public boolean isExpired() {
        return expirationDate.isBefore(LocalDate.now());
    }

}
