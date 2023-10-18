import java.io.Console;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Welcome to your shopping cart");

        Console cons = System.console();

        ArrayList<String> shoppingCart = new ArrayList<>();

        // When taking the user's input, need to be able to distinguish between the command and the items.
        // Might need to separate based on the space.
        String input = cons.readLine();




    }

    
}
