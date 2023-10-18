import java.util.ArrayList;

public class ShoppingCart {
  private ArrayList<String> cart;

  public ShoppingCart() {
    cart = new ArrayList<>();
  }

  // Adding item to shopping cart.
  // Don't allow duplicate items. Print appropriate response for duplicates.
  // Also need to allow multiple items adding in.
  public void addItem(String item) {
    if (cart.contains(item)) {
      System.out.printf("You already have %s in your cart", item);
    }
    cart.add(item);
  }

  // Removes item based on it's position on the list.
  public void removeItem(int itemPosition) {
    if (itemPosition > cart.size()) {
      System.out.printf("Incorrect item index");
    } else {
      cart.remove(itemPosition - 1);
    }
  }

  // Listing contents of shopping cart.
  public void listItems() {
    if (cart.isEmpty()) {
      System.out.printf("Your cart is empty");
    } else {
      for (int i = 0; i < cart.size(); i ++) {
        System.out.printf("%d. %s", i + 1, cart.get(i));
      }
    }
  }
}
