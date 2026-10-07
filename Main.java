import java.util.*;

public class Main {

    // Pre loaded stock
    static ArrayList<Integer> id = new ArrayList<>(List.of(101, 102, 103, 104, 105, 106, 107, 108));
    static ArrayList<String> name = new ArrayList<>(List.of(
            "Jasmine Rice 5kg", "Fresh Milk 1L", "White Bread",
            "Canned Sardines", "Instant Noodles", "Cooking Oil 1L",
            "Laundry Detergent 1kg", "Bottled Water 1L"));
    static ArrayList<Double> price = new ArrayList<>(List.of(285.00, 95.00, 65.00, 32.00, 18.00, 85.00, 110.00, 25.00));

    static ArrayList<Integer> stock_quantity = new ArrayList<>(List.of(50, 30, 40, 60, 100, 35, 25, 80));

    // ETO UNG MAIN METHOD PARE!
    public static void main(String[] args) {
        menu();
        product_Display();

    }

    // DISPLAYS THE MENU
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

    // Displays the products information in a table format
    static void product_Display() {

        // Dinidisplay nya yung mga items in a table format
        System.out.println("===============================================================");
        System.out.println("||                        STOCK LIST                         ||");
        System.out.println("===============================================================");

        System.out.printf("|| %-4s | %-25s | %-10s | %-9s ||%n",
                "ID", "NAME", "PRICE", "STOCK");

        System.out.println("---------------------------------------------------------------");

        for (int i = 0; i < id.size(); i++) {
            System.out.printf("| %-5s | %-25s | ₱%-10.2f | %-10d |%n",
                    id.get(i),
                    name.get(i),
                    price.get(i),
                    stock_quantity.get(i));
        }
        System.out.println("---------------------------------------------------------------");
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
