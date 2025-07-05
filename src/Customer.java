public class Customer {
    private String name;
    private double money;
    public Customer(String name, double money) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Customer name cannot be null or empty");
        }
        if (money <= 0) {
            throw new IllegalArgumentException("Customer money cannot be negative or zero");
        }
        this.name = name;
        this.money = money;
    }
    public int getMoney() {
        return (int) money;
    }
    public String getName() {return name;}
}
