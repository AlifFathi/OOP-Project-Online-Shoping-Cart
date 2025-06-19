package OnlineShoppingCartSystem;

import java.util.Scanner;

public class OnlineShoppingCartSystem {
    public static void main(String[] args) {
        // Create an admin user
        Admin admin = new Admin("admin", "admin123");
        Customer customer = new Customer("ali", "ali123");

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
                System.out.println("Invalid username or password. Please try again.");
                continue;
            }

            currentUser.showMenu(scanner);

            System.out.print("\nDo you want to exit the system? (yes/no): ");
            String response = scanner.nextLine().toLowerCase();
            if (response.equals("yes")) {
                exit = true;
            }
        }

        System.out.println("Goodbye!");
        scanner.close();
    }
}