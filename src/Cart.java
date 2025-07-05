import java.util.ArrayList;
import java.util.List;

public class Cart {
    private final Shop shop;
    private List<Product> items ;

    Cart(Shop shop) {
        this.shop = shop;
        this.items = new ArrayList<Product>();
    }
    void addItem(String name, int quantity) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Product name cannot be null or Empty");
        }
        if (quantity <= 0) {
            throw new IllegalArgumentException("You have to take at least 1 quantity");
        }
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
            throw new IllegalArgumentException("product is out of stock or expired");
        }
    }

    List<Product> getItems() {
        return items;
    }

}
