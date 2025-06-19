package OnlineShoppingCartSystem;
import java.util.ArrayList;

public class Cart {
    private ArrayList<Item> items;
    private int itemCount;

    
    public Cart(){
        this.items = new ArrayList<>();
        this.itemCount = 0;
    }
    public void addItem(Product product, int quantity){
        Item cartItem = new Item(product, quantity);
        items.add(cartItem);
        itemCount += quantity;
    }

    public int getItemCount(){
        return itemCount;
    }

    public void removeItem(String name){
        for (Item item : items) {
            if (item.itemName().equals(name)) {
                item.reduceQuantity(item.getQuantity());
                items.remove(item);
            }
        }
        itemCount = items.size();
    }

    public double getTotalPrice(){
        double totalPrice = 0;
        for (Item item : items) {
            totalPrice += item.getTotalPrice();
        }
        return totalPrice;
    }


}
