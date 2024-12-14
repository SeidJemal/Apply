import java.util.Scanner;
/**
 * Class: CMSC203 
 * Program: Project 6
 * Instructor: Professor Gary Thai
 * Description:Demonstrates customer interactions with the shop.
 * Due: 12/13/2024 
 * Platform/compiler: Eclipse 
 * I pledge that I have completed the programming assignment independently. 
 * I have not copied the code from a student or any source. 
 * I have not given my code to any student. 
 * Print your Name here: Seid Jemal
 */
public class BevShopDriverApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BevShop shop = new BevShop();

        System.out.println("The current order in process can have at most " + shop.getMaxOrderForAlcohol() + " alcoholic beverages.");
        System.out.println("The minimum age to order alcohol drink is " + shop.getMinAgeForAlcohol());

        
        System.out.println("\nStart please a new order:");
        System.out.println("Your Total Order for now is 0.0");

        System.out.print("Would you please enter your name: ");
        String name1 = scanner.nextLine();

        System.out.print("Would you please enter your age: ");
        int age1 = scanner.nextInt();

        if (shop.isValidAge(age1)) {
            System.out.println("Your age is above 20 and you are eligible to order alcohol.");
            shop.startNewOrder(10, Day.FRIDAY, name1, age1);

       
            System.out.println("Would you please add an alcohol drink");
            shop.processAlcoholOrder("Alcohol 1", Size.SMALL);
            System.out.println("The current order of drinks is " + shop.getCurrentOrder().getTotalItems());
            System.out.println("The Total price on the Order is " + shop.getCurrentOrder().calcOrderTotal());

           
            System.out.println("Your current alcohol drink order is less than " + shop.getMaxOrderForAlcohol());
            System.out.println("Would you please add a second alcohol drink");
            shop.processAlcoholOrder("Alcohol 2", Size.SMALL);
            System.out.println("The current order of drinks is " + shop.getCurrentOrder().getTotalItems());
            System.out.println("The Total Price on the Order: " + shop.getCurrentOrder().calcOrderTotal());

           
            System.out.println("Your current alcohol drink order is less than " + shop.getMaxOrderForAlcohol());
            System.out.println("Add third alcohol drink");
            shop.processAlcoholOrder("Alcohol 3", Size.SMALL);
            System.out.println("The current order of drinks is " + shop.getCurrentOrder().getTotalItems());
            System.out.println("The Total Price on the Order: " + shop.getCurrentOrder().calcOrderTotal());

           
            System.out.println("You have a maximum alcohol drinks for this order.");
            System.out.println("Would you please add a COFFEE to your order:");
            shop.processCoffeeOrder("Latte", Size.MEDIUM, true, false);
            System.out.println("Total items on your order is " + shop.getCurrentOrder().getTotalItems());
            System.out.println("The Total Price on the Order: " + shop.getCurrentOrder().calcOrderTotal());
        } else {
            System.out.println("Your age is not eligible to order alcohol.");
        }

        
        System.out.println("\n#------------------------------------#");
        System.out.println("Would you please start a new order");

        scanner.nextLine(); 
        System.out.print("Would you please enter your name: ");
        String name2 = scanner.nextLine();

        System.out.print("Would you please enter your age: ");
        int age2 = scanner.nextInt();

        shop.startNewOrder(15, Day.SATURDAY, name2, age2);
        System.out.println("The Total Price on the Order: " + shop.getCurrentOrder().calcOrderTotal());

        
        System.out.println("Would you please add a SMOOTHIE to order");
        shop.processSmoothieOrder("Berry Blast", Size.LARGE, 5, true);
        System.out.println("The current order of drinks is " + shop.getCurrentOrder().getTotalItems());
        System.out.println("The Total Price on the Order: " + shop.getCurrentOrder().calcOrderTotal());

        
        System.out.println("Would you please add a SMOOTHIE to order");
        shop.processSmoothieOrder("Tropical Delight", Size.SMALL, 3, false);
        System.out.println("The current order of drinks is " + shop.getCurrentOrder().getTotalItems());
        System.out.println("The Total Price on the Order: " + shop.getCurrentOrder().calcOrderTotal());

       
        System.out.println("Would you please add a COFFEE to order");
        shop.processCoffeeOrder("Espresso", Size.SMALL, false, true);
        System.out.println("The current order of drinks is " + shop.getCurrentOrder().getTotalItems());
        System.out.println("The Total Price on the Order: " + shop.getCurrentOrder().calcOrderTotal());

       
        System.out.println("Would you please add a drink");
        if (!shop.isValidAge(age2)) {
            System.out.println("Your Age is not appropriate for alcohol drink!!");
        }

        
        System.out.println("The current order of drinks is " + shop.getCurrentOrder().getTotalItems());
        System.out.println("The Total price on the Order: " + shop.getCurrentOrder().calcOrderTotal());
        System.out.println(" The total number of fruits is " + shop.getMaxNumOfFruits());
        System.out.println("You reached a Maximum number of fruits");

       
        System.out.println("\nTotal price on the second Order: " + shop.totalOrderPrice(shop.getOrderAtIndex(1).getOrderNo()));
        System.out.println("Total amount for all Orders: " + shop.totalMonthlySale());

        scanner.close();
    }
}
