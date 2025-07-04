package org.example.models;

public class Product {
    private String name;
    private double price;
    private int quantity;

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public void checkQuantity(int q){
        if(q > quantity){
            throw new IllegalArgumentException("Not enough quantity in stock");
        }
        else{
            this.quantity -= q;
        }
    }
    public boolean isExpired(){
        return false;
    }

    public double getWeight(){
        return 0;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
