package OnlineShoppingCartSystem;

import java.util.*;


public class OnlineShoppingCartSystem {
    public static void main(String[] args) {
        // Create an admin user

        Admin admin = new Admin("admin", "admin123");
        Customer customer = new Customer("ali", "ali123");
        ArrayList<Product> products = new ArrayList<>();
        // Sample products
        products.add(new Product("Laptop", 1500.00, 10));
        products.add(new Product("Smartphone", 800.00, 20));
        products.add(new Product("Headphones", 150.00, 50));
        products.add(new Product("Smartwatch", 200.00, 30));
        products.add(new Product("Tablet", 300.00, 15));

        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\n--- Login Lu ---");
            System.out.print("Username: ");
            String username = scanner.nextLine();

            System.out.print("Password: ");
            String password = scanner.nextLine();

            User currentUser = null;

            if (username.equals(admin.getName()) && password.equals(admin.getPassword())) {
                currentUser = admin;
            } else if (username.equals(customer.getName()) && password.equals(customer.getPassword())) {
                currentUser = customer;
            } else {
                clearScreen();
                System.out.println("Invalid username or password. Please try again.");
                continue;
            }

            currentUser.showMenu(scanner, products);
            clearScreen();
            System.out.print("\nDo you want to exit the system? (yes/no): ");
            String response = scanner.nextLine().toLowerCase();
            if (response.equals("yes")) {
                exit = true;
            }
        }

        System.out.println("Goodbye!");
        scanner.close();
    }

    public static void clearScreen(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}