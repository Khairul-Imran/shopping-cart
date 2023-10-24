import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        // Finding out what directory to use to store shopping cart.
        String cartDirectoryName;
        if (args.length > 0) {
            cartDirectoryName = args[0];
        } else {
            cartDirectoryName = "db"; // If no directory name was specified by user.
        }

        Path cartDirectoryPath = Paths.get(cartDirectoryName);
        File directory = cartDirectoryPath.toFile();

        if (!directory.exists()) {
            if (directory.mkdir()) {
                System.out.println("Using cart directory: " + cartDirectoryPath.toString());
            } else {
                System.err.println("Failed to create directory: " + cartDirectoryPath.toString());
                System.exit(1);
            }
        }

        



        System.out.println("Welcome to your shopping cart");

        Scanner scanner = new Scanner(System.in);
        ShoppingCart shoppingCart = new ShoppingCart();

        while (true) {
            String input = scanner.nextLine();

            // Splitting the user's input. Placing them into an array of Strings.
            String[] inputParts = input.split(" ");

            // Identifying the command given.
            String userCommand = inputParts[0].toLowerCase(); // use scanner.next(), and scanner.nextLine() for this. Refer to slides.

            // inputParts were stored as Strings, now we convert the relevant input into ints for our delete method.
            int itemPosition = 0;
            if (inputParts.length > 1 && userCommand.equals("delete")) {
                itemPosition = Integer.parseInt(inputParts[1]);
            }

            switch (userCommand) { // Need to try put breaks at the end of each case. Also follow normal conventions. Try to simplify the program.
                case "add" -> {
                    for (int i = 1; i < inputParts.length; i ++) {
                        shoppingCart.addItem(inputParts[i]);
                    }
                }
                case "delete" -> {
                    if (inputParts.length != 2) {
                        System.out.printf("Invalid input\n");
                    } else if (itemPosition > shoppingCart.getSize() || itemPosition == 0) {
                        System.out.printf("Incorrect item index\n");
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
                    System.out.printf("Shopping cart is closed\n");
                    scanner.close();
                    return; // Exits program
                }
                default -> {
                    System.out.printf("Invalid command. Available commands: add, delete, list, stop\n");
                }
            }
        }
    }
}
