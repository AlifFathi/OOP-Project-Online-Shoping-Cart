package OnlineShoppingCartSystem;

import java.util.*;

public class Admin extends User{
    public Admin(String name, String userID, String password) {
        super(name, userID, password);
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
            OnlineShoppingCartSystem.clearScreen();
            System.out.println("\n--- Admin Menu ---");
            System.out.println("1. View Products");
            System.out.println("2. Restock Products");
            System.out.println("3. Manage Orders");
            System.out.println("4. Logout");
            System.out.print("Choose option: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    boolean exit = false;
                    while (!exit) {
                        this.viewProducts(products);
                        System.out.print("Do you want to exit? (yes/no): ");
                        String response = scanner.nextLine().toLowerCase();
                        if (response.equals("yes")) {
                            exit = true;
                        }
                        else if (response.equals("no")) {
                            exit = false;
                        }
                    }
                    break;
                case "2":
                    this.restockProducts(scanner, products);
                    break;
                case "4":
                    logout = true;
                    System.out.println("Admin logged out.");
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }
    public void restockProducts(Scanner scanner, ArrayList<Product> products){
        this.viewProducts(products);
        System.out.print("Enter product name restock: ");
        String productName = scanner.nextLine();
        System.out.print("Enter quantity: ");
        int quantity = Integer.parseInt(scanner.nextLine());

        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(productName)) {
                product.reStock(quantity);
                System.out.println("Added " + quantity + " of " + productName + " to cart.");
                break;
            }
            else {
                System.out.println("Product not found.");
                break;
            }
        }
    }

}
