public class Product {
    private final String productName;
    private final int productPrice;
    private int productQuantity;
    private final ExpiryType expiryType;
    private final ShippingType shippingType;
    private final double weight;

    public Product(String productName, int productPrice, int productQuantity,
                   ShippingType shippingType, ExpiryType expiryType, double weight) {
        if (productName == null || productName.isEmpty()) {
            throw new IllegalArgumentException("Product name cannot be null or Empty");
        }
        if (productPrice < 0) {
            throw new IllegalArgumentException("Product price cannot be negative");
        }
        if (productQuantity < 0) {
            throw new IllegalArgumentException("Product quantity cannot be negative");
        }
        this.productName = productName;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
        if (expiryType == null) {
            this.expiryType = ExpiryType.unExpirable;
        } else {
            this.expiryType = expiryType;
        }

        if (shippingType == null) {
            this.shippingType = ShippingType.unShippable;
            this.weight = -1;
        } else {
            this.shippingType = shippingType;
            this.weight = weight;
        }
    }

    public Product(String productName, int productPrice, int productQuantity, ExpiryType expiryType) {
        if (productName == null || productName.isEmpty()) {
            throw new IllegalArgumentException("Product name cannot be null or Empty");
        }
        if (productPrice < 0) {
            throw new IllegalArgumentException("Product price cannot be negative");
        }
        if (productQuantity < 0) {
            throw new IllegalArgumentException("Product quantity cannot be negative");
        }
        this.productName = productName;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;

        if (expiryType == null) {
            this.expiryType = ExpiryType.unExpirable;
        } else {
            this.expiryType = expiryType;
        }

        this.shippingType = ShippingType.unShippable;
        this.weight = -1;
    }

    public Product(String productName, int productPrice, int productQuantity) {
        if (productName == null || productName.isEmpty()) {
            throw new IllegalArgumentException("Product name cannot be null or Empty");
        }
        if (productPrice < 0) {
            throw new IllegalArgumentException("Product price cannot be negative");
        }
        if (productQuantity < 0) {
            throw new IllegalArgumentException("Product quantity cannot be negative");
        }
        this.productName = productName;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;

        this.expiryType = ExpiryType.unExpirable;
        this.shippingType = ShippingType.unShippable;
        this.weight = -1;
    }
    public String getProductName() {
        return productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public ExpiryType getExpiryType() {
        return expiryType;
    }

    public ShippingType getShippingType() {
        return shippingType;
    }

    public double getWeight() {
        return weight;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

}
