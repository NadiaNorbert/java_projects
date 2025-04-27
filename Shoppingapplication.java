import java.util.*;
class Shoppingapplication
{
        
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to the Shopping Application!");
        System.out.println("Please enter your username :");
        String username = sc.nextLine();
        System.out.println("Products available for purchase:");
        System.out.println("1. Product A - 10");
        System.out.println("2. Product B - 20");
        System.out.println("3. Product C - 30");
        System.out.println("4. Product D - 40");
        System.out.println("5. Product E - 50");
        double discount =0.0;
        double price = 0.0;
        double totalPrice = 0.0;
        while (true) 
        {
            System.out.println("Please enter the product number you want to purchase or enter 0 to finish:");
            int productNumber = sc.nextInt();
            if (productNumber == 0) {
                break;
            }
            System.out.println("Please enter the quantity you want to purchase:");
            int quantity = sc.nextInt();
        
       
        switch (productNumber) {
            case 1:
                price = 10.00;
                totalPrice += price * quantity;
                break;
            case 2:
                price = 20.00;
                totalPrice += price * quantity;
                break;
            case 3:
                price = 30.00;
                totalPrice += price * quantity;
                break;
            case 4:
                price = 40.00;
                totalPrice += price * quantity;
                break;
            case 5:
                price = 50.00;
                totalPrice += price * quantity;
                break;
            default:
                System.out.println("Invalid product number! Please try again.");
                continue;
        }

    }
        discount = totalPrice * 0.5;
        double finalPrice = totalPrice - discount;
        System.out.println("Total price after discount: " + finalPrice);
        System.out.println("Thank you for shopping with us, " + username + "!");
        sc.close();
        System.out.println("Exiting the application...");
    } 
}