import java.util.ArrayList;
import java.util.List;

public class Main {

    static String checkout(Customer customer, Cart cart) {
        List<Product> myCart ;
        List<Product> myShippableProducts = new ArrayList<>();
        ShippingService shippingService;

        myCart = cart.getItems();
        Double SubTotal = 0.0;
        int shipping = 0;
        StringBuilder details = new StringBuilder();
        for (int i = 0; i < myCart.size(); i++) {
            details.append(myCart.get(i).getProductQuantity()).append("X ").
                    append(myCart.get(i).getProductName()).append(" ").append(myCart.get(i).getProductPrice())
                    .append("\n");
            SubTotal += myCart.get(i).getProductPrice() * myCart.get(i).getProductQuantity();
            if (myCart.get(i).getShippingType().equals(ShippingType.shippable)) {
                myShippableProducts.add(myCart.get(i));
            }
        }
        if (!myShippableProducts.isEmpty()) {
            shippingService = new ShippingService(myShippableProducts);
            details.append("** shipment notice** \n").append("Shipping Details : ");
            details.append(shippingService.getName());  // ✅ Append the returned string
            shipping = 30;
        }
        if (customer.getMoney() > SubTotal + shipping) {
            details.append("------------------- \n").append("SubTotal Price: ").append(SubTotal).append("\n").append("shipping ").append(shipping).append("\n");
            details.append("Amount: ").append(SubTotal + shipping).append("\n");
            details.append("Customer Balance ").append(customer.getMoney() - (SubTotal + shipping)).append("\n");
            return details.toString();
        } else throw new Error("Customer Balance is insufficient");
    }

    public static void main(String[] args) {
        Shop shop = new Shop();
        shop.createProduct(new Product("Cheese", 25, 10, ShippingType.shippable, ExpiryType.Expirable, 200));
        shop.createProduct(new Product("TV", 3000, 5, ShippingType.shippable, ExpiryType.unExpirable, 15000));
        shop.createProduct(new Product("Mobile Card", 5, 100, ExpiryType.unExpirable));
        Customer customer = new Customer("Mahmoud", 5000);
        Cart cart = new Cart(shop);
        cart.addItem("TV", 1);
        cart.addItem("Mobile Card", 2);
        String result = checkout(customer, cart);
        System.out.println(result);

    }
}