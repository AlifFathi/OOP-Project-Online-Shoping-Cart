package OnlineShoppingCartSystem;

public class Order {
    private Customer customer;
    private Cart cart;
    private double totalPrice;
    private String orderDate;

    public Order(Cart cart, double totalPrice, String orderDate) {
        this.cart = cart;
        this.totalPrice = totalPrice;
        this.orderDate = orderDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Cart getCart() {
        return cart;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void displayOrderDetails() {
        System.out.println("Order Date: " + this.orderDate);
        System.out.println("Total Price: " + this.totalPrice);
        cart.displayCart();
    }
}
