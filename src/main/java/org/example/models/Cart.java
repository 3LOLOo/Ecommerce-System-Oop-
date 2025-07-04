package org.example.models;
import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<CartItem> products;
    private double subTotal = 0;

    public Cart() {
        this.products = new ArrayList<>();
    }

    public boolean isEmpty(){
        return products.isEmpty();
    }

    public List<CartItem> getProducts() {
        return products;
    }

    public void add(Product p, int quantity)
    {
        p.checkQuantity(quantity);
        if(p.isExpired()){
            throw new IllegalArgumentException("This item is expired");
        }
        products.add(new CartItem(p,quantity));
        subTotal += (p.getPrice())*quantity;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public List<CartItem> returnShippableProduct()
    {
        List<CartItem> shippableProducts = new ArrayList<>();
        for(CartItem cartItem : products)
        {
            if(cartItem.getProduct() instanceof ShippableProduct)
            {
                shippableProducts.add(cartItem);
            }
        }
        return shippableProducts;
    }
}
