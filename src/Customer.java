public class Customer {
    private String name;
    private double money;
    public Customer(String name, double money) {
        this.name = name;
        this.money = money;
    }
    public int getMoney() {
        return (int) money;
    }
}
