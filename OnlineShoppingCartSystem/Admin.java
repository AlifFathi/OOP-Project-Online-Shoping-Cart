package OnlineShoppingCartSystem;

import java.util.*;

public class Admin extends User{
    public Admin(String name, String password) {
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
        while (!logout) {
            System.out.println("\n--- Admin Menu ---");
            System.out.println("1. View System Status");
            System.out.println("2. Logout");
            System.out.print("Choose option: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.println("System is running fine.");
                    break;
                case "2":
                    logout = true;
                    System.out.println("Admin logged out.");
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}
