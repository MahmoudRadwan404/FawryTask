import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Shop {
    List<Product> products;
    public Shop() {
        products = new ArrayList<>();
    }
    void createProduct(Product product) {
        for (Product value : products) {
            if (Objects.equals(product.getProductName(), value.getProductName())) {
                value.
                        setProductQuantity
                                (product.getProductQuantity() + value.getProductQuantity());
                return;
            }
        }
            products.add(product);
    }

    List<Product> getProducts() {
        return products;
    }

}
