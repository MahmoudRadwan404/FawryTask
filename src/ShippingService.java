import java.util.List;

public class ShippingService implements ShippingData{
   private List<Product>shoppingList;

   ShippingService(List<Product> shoppingList){
       this.shoppingList = shoppingList;
   }

    @Override
    public String getName() {
       StringBuilder data = new StringBuilder();
       Double sumWeight=getWeight();
       for(Product p : shoppingList){
           data.append(p.getProductQuantity()).append("X ").append(p.getProductName())
                   .append(" ").append(p.getWeight()).append("g").append("\n");
       }
       data.append("Total Weight: ").append(sumWeight).append("kg\n");

       return data.toString();
    }

    @Override
    public Double getWeight() {
       Double sumWeight=0.0;
        for(Product p : shoppingList){
            sumWeight += p.getWeight();
        }
        return sumWeight/1000;
    }
}
