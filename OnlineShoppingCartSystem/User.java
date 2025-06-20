package OnlineShoppingCartSystem;

import java.util.*;


public abstract class User {
    private String name;
    private String password;
    public User(String name, String password)
    {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public abstract void showMenu(Scanner scanner, ArrayList<Product> products);

    public void viewProducts(ArrayList<Product> products) {
        OnlineShoppingCartSystem.clearScreen();
        System.out.println("\n--- Available Products ---");
        for (Product product : products) {
            System.out.println("Name: " + product.getName() + ", Price: " + product.getPrice() + ", Stock: " + product.getStock());
        }
        System.out.println("\n");
    }
}

