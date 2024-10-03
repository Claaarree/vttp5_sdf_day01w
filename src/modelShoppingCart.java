package src;
import java.io.Console;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;


public class modelShoppingCart {
    public static void main(String[] args) {
        userInput();
    }
    
    public static void menu() {
        System.out.println("Welcome to your shopping cart");
        System.out.println("==============================");
        System.out.println();
        System.out.println("To list items in your cart, type list");
        System.out.println("To add item(s) to the cart, type 'add abc, def, ghi,...'");
        System.out.println("To delete an item, type 'delete 1'");
        System.out.println("To exit/terminate the program, type 'quit'");
    }

    public static void userInput() {
        Console console = System.console();
        String keyboardInput = "";
        List<String> cartItems = new ArrayList<>();


        while (!keyboardInput.equals("quit")) {
            menu();

            keyboardInput = console.readLine(">>> ");
            keyboardInput = keyboardInput.toLowerCase();

            if (keyboardInput.equals("list")) {
                if (cartItems.size() > 0) {
                    for (String itm : cartItems) {
                        System.out.println("Items: " + itm);
                    }

                } else {
                    System.out.println("Nothing in cart...");
                }
            }
            if (keyboardInput.startsWith("add")) {
                keyboardInput = keyboardInput.replace(',', ' ');

                Scanner scan = new Scanner(keyboardInput.substring(4));
                String tempStorage= "";
                while (scan.hasNext()) {
                    tempStorage= scan.next();
                    cartItems.add(tempStorage);
                }
                scan.close();

            }
            if (keyboardInput.startsWith("delete")) {
                keyboardInput = keyboardInput.replace(',', ' ');

                Scanner scan = new Scanner(keyboardInput.substring(6));
                String deleteIndex= scan.next();
                scan.close();
                Integer indexToDelete = Integer.parseInt(deleteIndex) - 1;

                if (indexToDelete <= cartItems.size()) {
                    if (indexToDelete< 0) {
                        System.out.println("negative index position. Delete operation cancelled");
                    } else {
                        cartItems.remove(indexToDelete);
                    }
                } else {
                    System.out.println("Index out of bound. Delete operation cancelled.");
                }


        }
        
    }

    System.out.println("See you again...");
    }    

}
