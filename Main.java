import java.util.*;

public class Main {
    static ArrayList<String> id = new ArrayList<>();
    static ArrayList<String> name = new ArrayList<>();
    static ArrayList<Double> price = new ArrayList<>();
    static ArrayList<String> category = new ArrayList<>();
    static ArrayList<Integer> stock_quantity = new ArrayList<>();

    public static void main(String[] args) {
        menu();

    }

    static void menu() {
        // ETO YUNG IDDISPLAY SA MAIN MENU
        System.out.println("====================================");
        System.out.println("            SUPER MARIKET           ");
        System.out.println("====================================");
        System.out.println("[1] View products ");
        System.out.println("[2] Add to cart ");
        System.out.println("[3] View cart");
        System.out.println("[4] check out");
        System.out.println("[5] View Inventory");
        System.out.println("[6] Exit");

    }

    static void product_Display() {

    }

    /*
     * product inventory :
     * Product id
     * product name
     * category
     * price
     * stock quantity
     * 
     * product display:
     * View all products
     * Show price and available stock
     * identify out-of-stock products
     * 
     * shopping cart:
     * add product
     * choose quantity
     * View cart
     * calculate each item subtotal
     * remove/cahnge items if you want
     * 
     * Checkout:
     * Calculate total
     * Optional discount
     * Optional tax
     * final amount
     * 
     * Payment:
     * Enter cash/payment
     * Check if payment is enough
     * Calculate change
     * 
     * Receipt:
     * Transaction number
     * Products
     * Quantity
     * Price
     * Subtotal
     * Total
     * Payment
     * Change
     * 
     * Inventory Update:
     * Subtract purchased quantity from stock
     * Prevent buying more than available stock
     * Prevent purchasing out-of-stock products
     * 
     * Multiple Customers:
     * Finish transaction
     * Clear cart
     * Start a new transaction
     * Keep inventory changes
     * 
     * Input Validation:
     * Invalid product ID
     * Invalid menu choice
     * Invalid quantity
     * Insufficient payment
     * Empty cart
     * Negative/zero quantities
     * 
     */

}
