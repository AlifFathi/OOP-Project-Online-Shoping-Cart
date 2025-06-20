package OnlineShoppingCartSystem;

import java.util.*;

public class Customer extends User{
    private ArrayList<Order> orders;
    private Cart cart;
    public Customer(String name, String password) {
        super(name, password);
    }

    public String getName() {
        return super.getName();
    }

    public String getPassword() {
        return super.getPassword();
    }

    public void showMenu(Scanner scanner, ArrayList<Product> products) {
        boolean logout = false;
        Cart cart = new Cart();
        while (!logout) {
            OnlineShoppingCartSystem.clearScreen();
            System.out.println("\n--- Customer Menu ---");
            System.out.println("1. View Products");
            System.out.println("2. Add to Cart");
            System.out.println("3. Remove from Cart");
            System.out.println("4. View Cart");
            System.out.println("5. Checkout");
            System.out.print("Choose option: ");
            String choice = scanner.nextLine();
            
            switch (choice) {
                case "1":
                    this.viewProducts(products);
                    break;
                case "2":
                    this.viewProducts(products);

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
                    break;
                case "4":
                    cart.displayCart();
                    break;
            }
        }
    }
}
