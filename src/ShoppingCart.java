import java.util.ArrayList;

public class ShoppingCart {
  private ArrayList<String> cart;

  // Constructor.
  public ShoppingCart() {
    cart = new ArrayList<>();
  }

  // Returns us the name of the item given its position in the list.
  public String getItem(int itemPosition) {
    return this.cart.get(itemPosition - 1);
  }

  // Adding item to shopping cart.
  public void addItem(String item) {
    String updatedItem = item.replace(",", ""); // Removes the commas.
    if (cart.contains(updatedItem)) {
      System.out.printf("You already have %s in your cart\n", updatedItem);
    } else {
      cart.add(updatedItem);
      System.out.printf("%s added to cart\n", updatedItem);
    }
  }

  // Deletes item based on its position on the list.
  public void deleteItem(int itemPosition) {
    if (itemPosition > cart.size() || itemPosition == 0) {
      System.out.printf("Incorrect item index\n");
    } else {
      cart.remove(itemPosition - 1);
    }
  }

  // Listing contents of shopping cart.
  public void listItems() {
    if (cart.isEmpty()) {
      System.out.printf("Your cart is empty\n");
    } else {
      for (int i = 0; i < cart.size(); i ++) {
        System.out.printf("%d. %s\n", i + 1, cart.get(i));
      }
    }
  }
}
