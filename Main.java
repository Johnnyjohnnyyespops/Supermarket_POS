
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {
    // Array list for the stocks
    static ArrayList<Integer> ID = new ArrayList<>(
            List.of(101, 102, 103, 104, 105, 106, 107, 108));
    static ArrayList<String> PRODUCT_NAME = new ArrayList<>(
            List.of(
                    "Jasmine Rice 5kg",
                    "Fresh Milk 1L",
                    "White Bread",
                    "Canned Sardines",
                    "Instant Noodles",
                    "Cooking Oil 1L",
                    "Laundry Detergent 1kg",
                    "Bottled Water 1L"));
    static ArrayList<Double> PRICE = new ArrayList<>(
            List.of(285.00, 95.00, 65.00, 32.00,
                    18.00, 85.00, 110.00, 25.00));
    static ArrayList<Integer> STOCK_QUANTITY = new ArrayList<>(
            List.of(50, 30, 40, 60, 100, 35, 25, 80));

    // Arraylist for the cart
    static ArrayList<String> cart_product = new ArrayList<>();
    static ArrayList<Integer> cart_quantity = new ArrayList<>();
    static ArrayList<Double> cart_price = new ArrayList<>();

    static Scanner sc = new Scanner(System.in);

    // MAIN METHOD IS HERE
    public static void main(String[] args) {
        int choice;

        do {
            displayMainMenu();
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    displayProducts();
                    break;
                case 2:
                    cart();
                    break;
                case 3:
                    displayCart();
                    break;
                case 4:
                    checkout();
                    break;
                case 5:
                    System.out.println("Thank you for shopping!");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 5);

        sc.close();
    }

    static void displayMainMenu() { // Responsible for displayiing the main menu choices
        System.out.println();

        System.out.println();
        System.out.println("\n====================================");
        System.out.println("            SUPER MARIKET           ");
        System.out.println("====================================");
        System.out.println("[1] View products");
        System.out.println("[2] Manage cart");
        System.out.println("[3] View cart");
        System.out.println("[4] Check out");
        System.out.println("[5] Exit");
        System.out.print("Enter choice: ");
    }

    static void clearConsole() { // clears the console
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    static void displayProducts() { // Displays the stocks, quantities, prices, and id of products in a table format
        clearConsole();

        System.out.println();
        System.out.println();
        System.out.println("===============================================================");
        System.out.println("||                        STOCK LIST                         ||");
        System.out.println("===============================================================");

        System.out.printf(
                "|| %-4s | %-25s | %-10s | %-9s ||%n",
                "ID", "NAME", "PRICE", "STOCK");

        System.out.println("---------------------------------------------------------------");
        for (int i = 0; i < ID.size(); i++) {
            System.out.printf("| %-5d | %-25s | ₱%-9.2f | %-9d |%n", ID.get(i), PRODUCT_NAME.get(i), PRICE.get(i),
                    STOCK_QUANTITY.get(i));
        }
        System.out.println("---------------------------------------------------------------");
    }

    static double calculateTotal() { // Calculates the total amount to be paid
        double total = 0;

        for (int i = 0; i < cart_product.size(); i++) {
            total += cart_price.get(i) * cart_quantity.get(i);
        }

        return total;
    }

    static void displayCart() { // This displays whats inside the cart

        System.out.println();
        System.out.println();
        System.out.println("\n================ SHOPPING CART ================");

        System.out.printf(
                "%-5s %-22s %-10s %-10s %-10s%n",
                "No.", "Product", "Price", "Quantity", "Subtotal");

        System.out.println("---------------------------------------------------------------");

        if (cart_product.isEmpty()) {
            System.out.println("Your cart is empty.");
        }

        for (int i = 0; i < cart_product.size(); i++) {
            double subtotal = cart_price.get(i) * cart_quantity.get(i);

            System.out.printf("%-5d %-22s ₱%-9.2f %-10d ₱%-10.2f%n", (i + 1), cart_product.get(i), cart_price.get(i),
                    cart_quantity.get(i), subtotal);
        }

        System.out.println("---------------------------------------------------------------");
        System.out.printf("TOTAL: ₱%.2f%n", calculateTotal());
        System.out.println("---------------------------------------------------------------");
    }

    static void cart() {
        int choice;

        do {
            displayCart();

            System.out.println("[1] Add item");
            System.out.println("[2] Remove item");
            System.out.println("[3] Replace quantity");
            System.out.println("[4] Back to main menu");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();

            if (choice >= 1 && choice <= 3) {
                cartFunctions(choice);
            } else if (choice != 4) {
                System.out.println("Invalid input. Try again.");
            }

        } while (choice != 4);
    }

    static void cartFunctions(int choice) {
        switch (choice) {
            case 1:
                addItem();
                break;
            case 2:
                removeItem();
                break;
            case 3:
                replaceQuantity();
                break;
            default:
                System.out.println("Invalid input.");
        }
    }

    // Methods that we used inside the cart

    static void clearCart() { // Empties the cart
        cart_product.clear();
        cart_quantity.clear();
        cart_price.clear();
    }

    // Adding item
    static void addItem() {
        System.out.print("Enter product ID: ");
        int productId = sc.nextInt();

        int inventoryIndex = ID.indexOf(productId);

        if (inventoryIndex == -1) {
            System.out.println("Invalid product ID.");
            return;
        }

        int cartIndex = cart_product.indexOf(
                PRODUCT_NAME.get(inventoryIndex));

        int quantityAlreadyInCart = 0;

        if (cartIndex != -1) {
            quantityAlreadyInCart = cart_quantity.get(cartIndex);
        }

        int availableStock = STOCK_QUANTITY.get(inventoryIndex) - quantityAlreadyInCart;

        if (availableStock <= 0) {
            System.out.println("No additional stock available.");
            return;
        }

        System.out.println("Product: " + PRODUCT_NAME.get(inventoryIndex));
        System.out.println("Available stock: " + availableStock);
        System.out.print("Enter quantity: ");

        int quantity = sc.nextInt();

        if (quantity <= 0 || quantity > availableStock) {
            System.out.println("Invalid quantity or insufficient stock.");
            return;
        }

        if (cartIndex != -1) {
            cart_quantity.set(
                    cartIndex, cart_quantity.get(cartIndex) + quantity);
        } else {
            cart_product.add(PRODUCT_NAME.get(inventoryIndex));
            cart_price.add(PRICE.get(inventoryIndex));
            cart_quantity.add(quantity);
        }

        System.out.println("Product successfully added!");
    }

    // Removing an item
    static void removeItem() {
        if (cart_product.isEmpty()) {
            System.out.println("Your cart is empty.");
            return;
        }

        System.out.print("Enter product ID to remove: ");
        int productId = sc.nextInt();

        int inventoryIndex = ID.indexOf(productId);

        if (inventoryIndex == -1) {
            System.out.println("Invalid product ID.");
            return;
        }

        int cartIndex = cart_product.indexOf(
                PRODUCT_NAME.get(inventoryIndex));

        if (cartIndex == -1) {
            System.out.println("Product not found in cart.");
            return;
        }

        System.out.print("Enter quantity to remove (0 = cancel, -1 = all): ");
        int quantity = sc.nextInt();

        if (quantity == -1) {
            cart_product.remove(cartIndex);
            cart_quantity.remove(cartIndex);
            cart_price.remove(cartIndex);

            System.out.println("Product removed from cart.");
        } else if (quantity == 0) {
            System.out.println("Removal cancelled.");
        } else if (quantity < 0) {
            System.out.println("Invalid quantity.");
        } else if (quantity > cart_quantity.get(cartIndex)) {
            System.out.println("You cannot remove more than you have.");
        } else {
            int remaining = cart_quantity.get(cartIndex) - quantity;

            if (remaining == 0) {
                cart_product.remove(cartIndex);
                cart_quantity.remove(cartIndex);
                cart_price.remove(cartIndex);
            } else {
                cart_quantity.set(cartIndex, remaining);
            }

            System.out.println("Quantity successfully removed.");
        }
    }

    // Replacing the quantity of an item inside the cart
    static void replaceQuantity() {
        if (cart_product.isEmpty()) {
            System.out.println("Your cart is empty.");
            return;
        }

        System.out.print("Enter product ID: ");
        int productId = sc.nextInt();

        int inventoryIndex = ID.indexOf(productId);

        if (inventoryIndex == -1) {
            System.out.println("Invalid product ID.");
            return;
        }

        int cartIndex = cart_product.indexOf(
                PRODUCT_NAME.get(inventoryIndex));

        if (cartIndex == -1) {
            System.out.println("Product not found in cart.");
            return;
        }

        System.out.println(
                "Current quantity: " + cart_quantity.get(cartIndex));

        System.out.print("Enter new quantity (0 = remove item): ");
        int newQuantity = sc.nextInt();

        int otherCartQuantity = 0;

        for (int i = 0; i < cart_product.size(); i++) {
            if (i != cartIndex && cart_product.get(i).equals(PRODUCT_NAME.get(inventoryIndex))) {

                otherCartQuantity += cart_quantity.get(i);

            }
        }

        int availableStock = STOCK_QUANTITY.get(inventoryIndex) - otherCartQuantity;

        if (newQuantity < 0 || newQuantity > availableStock) {
            System.out.println("Invalid quantity or insufficient stock.");
            return;
        }

        if (newQuantity == 0) {
            cart_product.remove(cartIndex);
            cart_quantity.remove(cartIndex);
            cart_price.remove(cartIndex);

            System.out.println("Product removed from cart.");
        } else {
            cart_quantity.set(cartIndex, newQuantity);
            System.out.println("Quantity successfully updated.");
        }
    }

    // CHECKOUT METHOD
    static void checkout() {
        if (cart_product.isEmpty()) {
            System.out.println("Cannot check out. Your cart is empty.");
            return;
        }

        displayCart();
        double total = calculateTotal();

        System.out.print("Enter payment amount: ₱");
        double payment = sc.nextDouble();

        if (payment < total) {
            System.out.printf("Insufficient payment. You need ₱" + (total - payment) + " more.");
        }

        // Deducts the purchased stock from the inventory
        for (int i = 0; i < cart_product.size(); i++) {

            int inventoryIndex = PRODUCT_NAME.indexOf(cart_product.get(i));
            cart_quantity.set(inventoryIndex, STOCK_QUANTITY.get(inventoryIndex) - cart_quantity.get(i));

        }
        System.out.println();
        System.out.println();
        System.out.println();

        printReceipt(payment);
    }

    static void printReceipt(double payment) { // How the receipt is printed

        double total = calculateTotal();
        double change = payment - total;

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy             hh:mm a");
        String dateTime = now.format(formatter);

        System.out.println("\n==============================================");
        System.out.println("                 SUPER MARIKET");
        System.out.println("               OFFICIAL RECEIPT");
        System.out.println("==============================================");

        System.out.println("Date & Time: " + dateTime);
        System.out.println("---------------------------------------------");
        System.out.printf("%-18s %5s %8s %9s%n", "PRODUCT", "QTY", "PRICE", "SUBTOTAL");
        System.out.println("----------------------------------------------");

        for (int i = 0; i < cart_product.size(); i++) {

            String product = cart_product.get(i);
            int quantity = cart_quantity.get(i);
            double price = cart_price.get(i);
            double subtotal = quantity * price;

            System.out.printf("%-18s %5d %8.2f %9.2f%n",
                    product, quantity, price, subtotal);
        }
        System.out.println("----------------------------------------------");
        System.out.printf("%-32s ₱%10.2f%n", "TOTAL:", total);
        System.out.printf("%-32s ₱%10.2f%n", "AMOUNT PAID:", payment);
        System.out.printf("%-32s ₱%10.2f%n", "CHANGE:", change);

        System.out.println("==============================================");
        System.out.println("          Thank you for shopping!");
        System.out.println("             Please come again.");
        System.out.println("==============================================");
        clearCart();

    }

}
