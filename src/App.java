// import java.io.Console;
import java.util.Scanner;
// import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Welcome to your shopping cart");

        Scanner scanner = new Scanner(System.in);
        ShoppingCart shoppingCart = new ShoppingCart();

        while (true) {
            String input = scanner.nextLine();

            // Splitting the user's input.
            String[] inputParts = input.split(" ");

            // Identifying the command given.
            String userCommand = inputParts[0].toLowerCase();

            // inputParts were stored as Strings, so here we convert them to ints for our delete method to work.
            int itemPosition = 0;
            if (inputParts.length > 1 && userCommand.equals("delete")) {
                itemPosition = Integer.parseInt(inputParts[1]);
            }

            switch (userCommand) {
                case "add" -> {
                    for (int i = 1; i < inputParts.length; i ++) {
                        shoppingCart.addItem(inputParts[i]);
                    }
                }
                case "delete" -> {
                    if (inputParts.length != 2) {
                        System.out.printf("Invalid input\n");
                    } else {
                        String itemToRemove = shoppingCart.getItem(itemPosition);
                        shoppingCart.deleteItem(itemPosition);
                        System.out.printf("%s removed from cart\n", itemToRemove);
                    }
                }
                case "list" -> {
                    shoppingCart.listItems();
                }
                case "stop" -> {
                    System.out.printf("Shopping cart is closed");
                    break;
                }
            }

            // scanner.close();
        }
        
        // Consider adding an "end" command.
    }
}
