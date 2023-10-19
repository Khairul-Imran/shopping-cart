// import java.io.Console;
import java.util.Scanner;
// import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Welcome to your shopping cart");

        // Console cons = System.console();
        Scanner scanner = new Scanner(System.in);

        ShoppingCart shoppingCart = new ShoppingCart();

        //String input = cons.readLine();
        String input = scanner.nextLine();

        String[] inputParts = input.split(" ");

        String userCommand = inputParts[0].toLowerCase();
        int itemPosition = 0;
        int numberOfItems = 0; // Might be unnecessary. 

        if (inputParts.length > 1 && userCommand.equals("delete")) { // When the command is delete.
            itemPosition = Integer.parseInt(inputParts[1]);
        } else if (inputParts.length > 1 && userCommand.equals("add")) { // When the command is add.
            numberOfItems = inputParts.length - 1; // This too 
        }


        switch (userCommand) {
            // to put the different cases
            case "add" -> {
                for (int i = 1; i < inputParts.length; i ++) {
                    shoppingCart.addItem(inputParts[i]);
                }
            }
            case "delete" -> {
                if (inputParts.length != 2) {
                    System.out.printf("Invalid input");
                } else {
                    shoppingCart.removeItem(itemPosition);
                }
            }
            case "list" -> {
                shoppingCart.listItems();
            }
        }

        // Consider adding an "end" command.
        scanner.close();
    }
}
