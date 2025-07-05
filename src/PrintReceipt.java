import java.util.ArrayList;
import java.util.List;

public class PrintReceipt {
    List<Product> myCart;
    List<Product> myShippableProducts;
    PrintReceipt(List<Product> myCart) {
        this.myCart = myCart;
        this.myShippableProducts = new ArrayList<>();
    }
    String printProductsDetails(int customerMoney, Double subtotal, int shippingMoney) {
        StringBuilder details = new StringBuilder();
        for (int i = 0; i < myCart.size(); i++) {
            details.append(myCart.get(i).getProductQuantity()).append("X ").
                    append(myCart.get(i).getProductName()).append(" ").append(myCart.get(i).getProductPrice())
                    .append("\n");
            if (myCart.get(i).getShippingType().equals(ShippingType.shippable)) {
                myShippableProducts.add(myCart.get(i));
            }
        }
        if (!myShippableProducts.isEmpty()) {
            ShippingService shippingService = new ShippingService(myShippableProducts);
            details.append("** shipment notice ** \n").append("Shipping Details : ");
            details.append(shippingService.getName());
        }
        details.append("------------------- \n").append("SubTotal Price: ").append(subtotal).append("\n").append("shipping ").append(shippingMoney).append("\n");
        details.append("Amount: ").append(subtotal + shippingMoney).append("\n");
        details.append("Customer Balance ").append(customerMoney - (subtotal + shippingMoney)).append("\n");
        return details.toString();
    }

}