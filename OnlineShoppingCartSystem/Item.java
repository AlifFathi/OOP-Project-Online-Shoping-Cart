package OnlineShoppingCartSystem;

public class Item {
    private Product product;
    private int quantity;
    private double totalPrice;

    public Item(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }
    
    public int getQuantity(){
        return quantity;
    }

    public void addQuantity(int quantity) {
        this.quantity += quantity;
    }

    public void reduceQuantity(int quantity) {
        this.quantity -= quantity;
    }

    public String itemName(){
        return product.getName();
    }

    public Product getItem(){
        return product;
    }

    public double getTotalPrice() {
        totalPrice = product.getPrice() * quantity;
        return totalPrice;
    }



}
