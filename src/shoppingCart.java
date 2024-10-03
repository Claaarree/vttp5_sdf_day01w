package src;
import java.util.Scanner;
import java.util.ArrayList;



public class shoppingCart{



    public static void main(String[] args) {
        System.out.println("Welcome to your shopping cart");
        Scanner input = new Scanner(System.in);
       
        ArrayList<String> cart = new ArrayList<>();
       
        String lowerAction = "";
        while (!lowerAction.equals("quit")) {
         String action = input.next();
        lowerAction = action.toLowerCase();    
        String itemString = input.nextLine();
        String[] items = itemString.split(",");
        // String [] cartAction = lowerAction.split(" ", 2);
        // String [] items = cartAction[1].split(",");


        if (lowerAction.equals("list") && cart.isEmpty()) {
            System.out.println("Your cart is empty! Add items to your cart!");
        } else if (lowerAction.contains("add")) {
           for (int i = 0; i < items.length; i++) {
            if (cart.contains(items[i].trim())) {
                System.out.println(items[i].trim() + " already in cart");
                continue;
                } else {
                cart.add(items[i].trim());
                System.out.println(items[i].trim() + " added to cart");
            } }
            

        } else if (lowerAction.equals("list") && !cart.isEmpty()) {
            for (int j= 0; j < cart.size(); j++ ) {
                System.out.println(j+1 + ". " + cart.get(j)); 
            
        } }else if (lowerAction.contains("delete")) { 
           // for (int i = 0; i < items.length; i++) {
                int itemNum = Integer.parseInt(itemString.trim());
                 if (itemNum <0 || itemNum > cart.size()) {
                     System.out.println("That is not a valid list number");
                } else { System.out.println(cart.get(itemNum -1) + " removed from cart");
                 cart.remove(itemNum -1);
            }
            
          //  }
            

            
        } else if (lowerAction.equals("quit")) {
            System.out.println("Bye bye");
        } 
        else System.out.println("Sorry, I don't understand. Please try again.");
        } 
 
          input.close();
}
}