package org.example.services;
import org.example.models.CartItem;

import java.util.List;

public class ShippingService {

    private static final double SHIPPING_RATE_PER_KG = 10.0;

    public static double CalculateShipment(List<CartItem> products){

        if(products.isEmpty())return 0.0;

        double totalWeight = 0;

        System.out.println("\n** Shipment Notice **");
        for(CartItem p : products){
            double itemWeight = p.getQuantity() * p.getProduct().getWeight();
            totalWeight += itemWeight;
            System.out.println(p.getQuantity() + "x " + p.getProduct().getName() + " : " + itemWeight + " g");
        }

        double totalShipment = totalWeight * 0.001 * SHIPPING_RATE_PER_KG;
        System.out.println("Total package weight " + totalWeight/1000 + " kg\n");

        return totalShipment;
    }
}
