import java.io.Console;
// import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Welcome to your shopping cart");

        Console cons = System.console();

        //ArrayList<String> shoppingCart = new ArrayList<>();
        ShoppingCart shoppingCart = new ShoppingCart();

        // When taking the user's input, need to be able to distinguish between the command and the items.
        // Might need to separate based on the space.
        String input = cons.readLine();

        String[] inputParts = input.split(" ");

        String userCommand = inputParts[0].toLowerCase();
        int itemPosition = 0;


        if (inputParts.length > 1 && userCommand.equals("delete")) { // When the command is delete.
            itemPosition = Integer.parseInt(inputParts[1]);
        } else if (inputParts.length > 1) {
            
        }


        switch (userCommand) {
            // to put the different cases
            case "add" -> {

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

    }

    
}
