import org.example.models.*;
import org.example.services.CheckoutService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

public class CheckoutScenariosTest {

    private Cart cart;
    private Customer customer;

    @BeforeEach
    public void setup() {
        cart = new Cart();
        customer = new Customer("Mohamed", 2000);
    }

    @Test
    public void testEmptyCart_ThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> CheckoutService.checkout(customer, cart));
    }

    @Test
    public void testNotEnoughBalance_ThrowsException() {
        Customer poorCustomer = new Customer("Ali", 10);
        Product tv = new ShippableProduct("TV", 1000, 2, 10000);
        cart.add(tv, 1);

        assertThrows(IllegalArgumentException.class, () -> CheckoutService.checkout(poorCustomer, cart));
    }

    @Test
    public void testAddExpiredProduct_ThrowsException() {
        Product expiredProduct = new ExpirableShippableProduct("Cheese", 100, 5, 500, LocalDate.now().minusDays(1));

        assertThrows(IllegalArgumentException.class, () -> cart.add(expiredProduct, 1));
    }

    @Test
    public void testOutOfStock_ThrowsException() {
        Product limitedStockProduct = new Product("Iphone", 200, 1);

        assertThrows(IllegalArgumentException.class, () -> cart.add(limitedStockProduct, 2));
    }

    @Test
    public void testValidCheckout_Success() {
        Product cheese = new ExpirableShippableProduct("Cheese", 100, 10, 500, LocalDate.now().plusDays(5));
        Product tv = new ShippableProduct("TV", 1000, 2, 10000);

        cart.add(cheese, 1);
        cart.add(tv, 1);

        assertDoesNotThrow(() -> CheckoutService.checkout(customer, cart));
    }
}
