package OnlineShoppingCartSystem;

import java.util.*;

public class Customer extends User{
    private Cart cart;
    private ArrayList<Order> orders;
    public Customer(String name, String userID, String password) {
        super(name, userID, password);
        this.orders = new ArrayList<>();
        this.cart = new Cart();
    }

    public String getName() {
        return super.getName();
    }

    public String getID() {
        return super.getID();
    }

    public String getPassword() {
        return super.getPassword();
    }

    public void showMenu(Scanner scanner, ArrayList<Product> products) {
        boolean logout = false;
        while (!logout) {
            //OnlineShoppingCartSystem.clearScreen();  
            System.out.println("\n--- Customer Menu ---");
            System.out.println("1. View Products");
            System.out.println("2. Add to Cart");
            System.out.println("3. Remove from Cart");
            System.out.println("4. View Cart");
            System.out.println("5. Checkout");
            System.out.println("6. View Orders");
            System.out.println("7. Logout");
            System.out.print("Choose option: ");
            String choice = scanner.nextLine();
            
            switch (choice) {
                case "1":
                    boolean exit = false;
                    while (!exit) {
                        this.viewProducts(products);
                        System.out.print("Press enter to continue: ");
                        String response = scanner.nextLine().toLowerCase();
                        if (response.equals("")) {
                            exit = true;
                        } else {
                            exit = false;
                        }
                    }
                    break;
                case "2":
                    viewProducts(products);
                    System.out.print("Enter product name to add: ");
                    String productName = scanner.nextLine();
                    System.out.print("Enter quantity: ");
                    int quantity = Integer.parseInt(scanner.nextLine());

                    for (Product product : products) {
                        if (product.getName().equalsIgnoreCase(productName)) {
                            cart.addItem(product, quantity);
                            System.out.println("Added " + quantity + " of " + productName + " to cart.");
                            break;
                        }
                    }
                    break;
                case "3":
                    cart.displayCart();
                    System.out.print("Enter product name to remove: ");
                    String removeProductName = scanner.nextLine();
                    if (cart.isEmpty()) {
                        System.out.println("Cart is empty. Nothing to remove.");
                    } else {
                        System.out.print("Enter quantity to remove: ");
                        int removeQuantity = Integer.parseInt(scanner.nextLine());
                        for (Item item : cart.getItems()) {
                            if (item.itemName().equalsIgnoreCase(removeProductName)) {
                                if (removeQuantity >= item.getQuantity()) {
                                    cart.removeItem(removeProductName);
                                    System.out.println("Removed all " + removeProductName + " from cart.");
                                } else {
                                    item.reduceQuantity(removeQuantity);
                                    System.out.println("Removed " + removeQuantity + " of " + removeProductName + " from cart.");
                                }
                                break;
                            }
                        }
                        System.out.println("Removed " + removeProductName + " from cart.");
                    }
                    break;
                case "4":
                    this.cart.displayCart();
                    break;
                case "5":
                    double totalPrice = cart.getTotalPrice();
                    System.out.println("Total price: " + totalPrice);
                    System.out.print("Do you want to proceed with checkout? (yes/no): ");
                    String response = scanner.nextLine().toLowerCase();
                    if (response.equals("yes")) {
                        System.out.println("Checkout successful. Thank you for your purchase!");
                        //update stock
                        for (Item item : cart.getItems()) {
                            for (Product product : products) {
                                if (product.getName().equalsIgnoreCase(item.itemName())) {
                                    product.reduceStock(item.getQuantity());
                                }
                            }
                        }
                        // Create an order
                        Order order = new Order(this, cart, totalPrice, new Date().toString());
                        this.orders.add(order);
                        //admin.addOrders(order);
                        // Clear the cart after checkout
                        cart = new Cart();
                    } else {
                        System.out.println("Checkout cancelled.");
                    }
                    break;
                case "6":
                    this.showOrders();
                    break;
                case "7":
                    logout = true;
                    System.out.println("Customer logged out.");
                    break;
            }
        }
    }

    public void showOrders(){
        if (this.orders.isEmpty()) {
            System.out.println("No orders found.");
        } else {
            System.out.println("Your Orders:");
            for (Order order : this.orders) {
                order.displayOrderDetails();
            }
        }
    }
}
