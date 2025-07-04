package org.example.services;
import org.example.models.Cart;
import org.example.models.CartItem;
import org.example.models.Customer;

import java.util.List;

public class CheckoutService {
    public static void checkout(Customer customer, Cart cart){
        if (cart.isEmpty()) {
            throw new IllegalArgumentException("Cart is empty");
        }
        List<CartItem> products = cart.getProducts();

        double subTotal = cart.getSubTotal();
        double Shipping = ShippingService.CalculateShipment(cart.returnShippableProduct());
        double Total = subTotal + Shipping;

        customer.checkBalance(Total);

        System.out.println("** Checkout Receipt **");
        for(CartItem p : products){
            System.out.println(p.getQuantity() + "x " + p.getProduct().getName() + " : " + p.getQuantity()*p.getProduct().getPrice()  + " $");
        }
        System.out.println();
        System.out.println("Subtotal: " + subTotal + " $\n" + "Shipping: " + Shipping + " $\n" + "Amount: " + Total + " $");
        System.out.println("Customer current balance: " + customer.getBalance() + " $");

    }
}
