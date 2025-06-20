package OnlineShoppingCartSystem;

public class Order {
    private int orderId;
    private Customer customer;
    private Cart cart;
    private double totalPrice;
    private String orderDate;
    private String orderStatus;
    

    public Order(int orderId, Customer customer, Cart cart, double totalPrice, String orderDate, String orderStatus) {
        this.orderId = orderId;
        this.customer = customer;
        this.cart = cart;
        this.totalPrice = totalPrice;
        this.orderDate = orderDate;
        this.orderStatus = orderStatus;
    }

    public int getOrderId() {
        return orderId;
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
    public String getOrderStatus() {
        return orderStatus;
    }
    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }
    public void displayOrderDetails() {
        System.out.println("Order ID: " + orderId);
        System.out.println("Customer: " + customer.getName());
        System.out.println("Order Date: " + orderDate);
        System.out.println("Order Status: " + orderStatus);
        System.out.println("Total Price: " + totalPrice);
        System.out.println("Items in the order:");
        cart.displayCart();
    }

}
