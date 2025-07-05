import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Shop shop = new Shop();
        shop.createProduct(new Product("Cheese", 25, 10, ShippingType.shippable, ExpiryType.Expirable, 200));
        shop.createProduct(new Product("TV", 3000, 5, ShippingType.shippable, ExpiryType.unExpirable, 15000));
        shop.createProduct(new Product("Mobile Card", 5, 100, ExpiryType.unExpirable));
        Customer customer = new Customer("Mahmoud", 5000);
        Cart cart = new Cart(shop);
        cart.addItem("TV", 1);
        cart.addItem("Mobile Card", 2);
        Checkout checkout=new Checkout(customer,cart);
        String result = checkout.checkoutProducts();
        System.out.println(result);

    }
}