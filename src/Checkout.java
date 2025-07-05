import java.util.ArrayList;
import java.util.List;
public class Checkout {
    private  Customer customer;
    private  Cart cart;
    private Double SubTotal;
    int shipping;
    Checkout(Customer customer, Cart cart) {
        this.customer = customer;
        this.cart = cart;
        shipping =0;
        SubTotal = 0.0;
    }
    String checkoutProducts() {
        if (cart.getItems().isEmpty()) {
            throw new IllegalArgumentException("No items in shop");
        }
        List<Product> myCart;
        List<Product> myShippableProducts = new ArrayList<>();
        myCart = cart.getItems();
        for (Product product : myCart) {
            SubTotal += product.getProductPrice() * product.getProductQuantity();
            if (product.getShippingType().equals(ShippingType.shippable)) {
                myShippableProducts.add(product);
            }
        }
        if (!myShippableProducts.isEmpty()&&shipping==0){
            shipping = 30;
        }
        if (customer.getMoney() > SubTotal + shipping) {
            PrintReceipt printReceipt = new PrintReceipt(cart.getItems());
            return printReceipt.printProductsDetails(customer.getMoney(), SubTotal, shipping);
        } else throw new IllegalArgumentException("Customer Balance is insufficient");
    }
    void setShipping(int shipping) {
        this.shipping = shipping;
    }
    int getShipping() {
        return shipping;
    }
}


