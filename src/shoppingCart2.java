package src;

import java.util.Scanner;
import java.util.ArrayList;


public class shoppingCart2 {

    public static void main(String[] args) {
        System.out.println("Welcome to your shopping cart");
        Scanner scan = new Scanner(System.in);
       
        ArrayList<String> cart = new ArrayList<>();
       
        String inputStr = "";

        

      
        while (!inputStr.equals("quit")) {
        inputStr = scan.nextLine();
        inputStr.toLowerCase();    
        String [] paramStrings = inputStr.split(" ",2);
        String command = paramStrings[0];
        String optionString = "";
        
        if (paramStrings.length >1){
            optionString = paramStrings[1];
        }
        String [] items;

        switch (command) {
            case "list":
                if (cart.isEmpty()){
                    System.out.println("Your cart is empty! Add items to your cart!");
                }
                else{
                    for (int i= 0; i < cart.size(); i++ ) {
                        System.out.println(i+1 + ". " + cart.get(i)); 
                    }
                }
                break;
            case "add":
                items = optionString.split(",");
                for (int i = 0; i < items.length; i++) {
                    if (cart.contains(items[i])) {
                        continue;
                    } else {
                        String cleanItem = items[i].trim();
                        cart.add(cleanItem);
                        System.out.println(cleanItem + " added to cart");
                    } }
                break;
            case "delete":
                int itemNum = Integer.parseInt(optionString);
                int itemIdx = itemNum-1;
                if (itemIdx < 0 || itemIdx>=cart.size()){
                    System.out.println(itemNum +" is not a valid index.");
                }
                else{
                    System.out.println(cart.remove(itemIdx) + " removed from cart");
                }
                break;
            default:
                System.out.println("Sorry, I don't understand. Please try again.");
                break;
        }
        // if (inputStr.equals("list") && cart.isEmpty()) {
        //     System.out.println("Your cart is empty! Add items to your cart!");
        // } else if (inputStr.contains("add")) {
        //    for (int i = 1; i < cartAction.length; i++) {
        //     if (cart.contains(cartAction[i])) {
        //         continue;
        //     } else {
        //         cart.add(cartAction[i]);
        //         System.out.println(cartAction[i] + " added to cart");
        //     } }
            

        // } else if (inputStr.equals("list") && !cart.isEmpty()) {
        //     for (int j= 0; j < cart.size() -1; j++ ) {
        //         System.out.println(j+1 + ". " + cart.get(j)); 
            
        // } }else if (inputStr.contains("delete")) { 
        //     for (int i = 1; i < cartAction.length; i++) {
        //         int itemNum = Integer.parseInt(cartAction[i]);
        //         System.out.println(cart.get(itemNum -1) + " removed from cart");
        //         cart.remove(itemNum -1);
                
            
        //     }
            
            
        // } else System.out.println("Sorry, I don't understand. Please try again.");
        } 
 
        scan.close();  
}
}