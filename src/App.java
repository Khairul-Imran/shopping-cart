import java.io.Console;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Welcome to your shopping cart");

        Console cons = System.console();

        String name = cons.readLine("What is your name?");

        System.out.printf("Hello %s. Pleased to meet you.\n", name);
    }
}
