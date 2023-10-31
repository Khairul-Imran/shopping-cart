import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCartDB {
  private Path shoppingCartDBDirectory;
  private String currentLoggedInUser = null;
  // private ShoppingCart shoppingCart;

  // Constructor.
  public ShoppingCartDB(String cartDirectoryName) {
    
    shoppingCartDBDirectory = Paths.get(cartDirectoryName);
    if (!Files.exists(shoppingCartDBDirectory)) {
      try {
        Files.createDirectories(shoppingCartDBDirectory);
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }

  public void login(String username) {
    if (currentLoggedInUser == username) { // If the user is logged in already.
      System.out.println(currentLoggedInUser + ", you are already logged in!");
      Path userPath = shoppingCartDBDirectory.resolve(username + ".txt");
      getCartItems(userPath);
      return;
    }

    // If the user is not logged in yet (for new or existing users).
    Path userPath = shoppingCartDBDirectory.resolve(username + ".txt");
    if(Files.notExists(userPath)) { // New users.
      try {
        Files.createFile(userPath);
        Files.write(userPath, (shoppingCartDBDirectory + "/" + username + ".db").getBytes()); // For the first line.
        currentLoggedInUser = username;
        getCartItems(userPath);
      } catch (IOException e) {
        e.printStackTrace();
      }
    } else { // Existing users (who are now logging in).
      currentLoggedInUser = username;
      getCartItems(userPath);
    }
  }

  public void getCartItems(Path userPath) {
    try {
      List<String> cartItems = Files.readAllLines(userPath, StandardCharsets.UTF_8);
      if (cartItems.size() > 1) {
        System.out.println(currentLoggedInUser + ", your cart contains the following items: ");
        for (int i = 1; i < cartItems.size(); i ++) {
          System.out.println(cartItems.get(i));
        }
      } else {
        System.out.println(currentLoggedInUser + ", your cart is empty.");
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void saveCartItems(String username, List<String> shoppingCart) { // Stopped here.
    Path userPath = shoppingCartDBDirectory.resolve(username + ".txt");
    try {
      Files.write(userPath, shoppingCart, StandardCharsets.UTF_8, StandardOpenOption.TRUNCATE_EXISTING);
      System.out.println("Your cart has been saved.");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void getUsers() {
    
  }

  public void saveCart(String username) {

  }

}