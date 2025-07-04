import java.util.ArrayList;
import java.util.List;

public class Shop {
    List<Product> products;

    public Shop() {
        products = new ArrayList<Product>();
    }
    void createProduct(Product product) {
        for (int i = 0; i < products.size(); i++) {
            if (product.getProductName() == products.get(i).getProductName()) {
                products.get(i).
                        setProductQuantity
                                (product.getProductQuantity() + products.get(i).getProductQuantity());
                return;
            }
        }
            products.add(product);
    }

    List<Product> getProducts() {
        return products;
    }

}
