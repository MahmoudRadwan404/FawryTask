import java.util.ArrayList;
import java.util.List;

public class Cart {
    private Shop shop;
    private List<Product> items = new ArrayList<>();

    Cart(Shop shop) {
        this.shop = shop;
    }
    void addItem(String name, int quantity) {
        List<Product> current = shop.getProducts();
        boolean found = false;

        for (Product p : current) {
            if (p.getProductName().equals(name) &&
                    p.getProductQuantity() >= quantity &&
                    p.getExpiryType() == ExpiryType.unExpirable) {

                Product cartItem = new Product(p.getProductName(), (int) p.getProductPrice(), quantity, p.getShippingType(), p.getExpiryType(), p.getWeight());
                p.setProductQuantity(p.getProductQuantity() - quantity);
                items.add(cartItem);
                found = true;
                break;
            }
        }

        if (!found) {
            throw new Error("product is out of stock or expired");
        }
    }

    List<Product> getItems() {
        return items;
    }
}
