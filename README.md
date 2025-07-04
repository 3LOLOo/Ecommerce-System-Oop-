# Ecommerce-OOP-Project

A simple object-oriented e-commerce simulation system written in Java.

---

## Features

### Product Management
- Products are defined by name, price, and available quantity.
- Some products are **expirable** (e.g., Cheese, Biscuits), while others are not (e.g., TV, Mobile Scratch Card).
- Some products require **shipping** (e.g., TV, Cheese), while others do not.
- Every shippable product provides its **weight in grams** for shipping fee calculation.

### Cart & Checkout
- Customers can add products to their cart with a specific quantity, limited by available stock.
- Expired products cannot be added.
- During checkout:
  - A receipt is printed showing each item and its total price.
  - The subtotal (sum of item prices) is calculated.
  - Shipping fees are calculated based on total weight.
  - The total amount (subtotal + shipping) is deducted from the customer’s balance.
  - The customer’s updated balance is shown.

### Error Handling
- Checkout is **not allowed** if:
  - The cart is empty.
  - The customer has **insufficient balance**.
  - One or more products are **expired**.
  - Requested quantity **exceeds stock**.

---

## Project Structure
```text
ecommerce-oop/
├── src/
│   └── org/example/
│       ├── Main.java
│       ├── models/
│       │   ├── Product.java
│       │   ├── Cart.java
│       │   ├── CartItem.java
│       │   ├── Customer.java
│       │   ├── Shippable.java
│       │   ├── ShippableProduct.java
│       │   ├── ExpirableProduct.java
│       │   └── ExpirableShippableProduct.java
│       └── services/
│           ├── CheckoutService.java
│           └── ShippingService.java
├── test/
│   └── org/example/CheckoutScenariosTest.java
└── README.md
```
