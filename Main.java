
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final ArrayList<Integer> ID = new ArrayList<>(
            List.of(101, 102, 103, 104, 105, 106, 107, 108));

    private static final ArrayList<String> PRODUCT_NAME = new ArrayList<>(
            List.of(
                    "Jasmine Rice 5kg",
                    "Fresh Milk 1L",
                    "White Bread",
                    "Canned Sardines",
                    "Instant Noodles",
                    "Cooking Oil 1L",
                    "Laundry Detergent 1kg",
                    "Bottled Water 1L"));

    private static final ArrayList<Double> PRICE = new ArrayList<>(
            List.of(285.00, 95.00, 65.00, 32.00,
                    18.00, 85.00, 110.00, 25.00));

    private static final ArrayList<Integer> STOCK_QUANTITY = new ArrayList<>(
            List.of(50, 30, 40, 60, 100, 35, 25, 80));

    private static final ArrayList<String> CART_PRODUCT = new ArrayList<>();
    private static final ArrayList<Integer> CART_QUANTITY = new ArrayList<>();
    private static final ArrayList<Double> CART_PRICE = new ArrayList<>();

    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do {
            displayMainMenu();
            choice = SCANNER.nextInt();

            switch (choice) {
                case 1:
                    displayProducts();
                    break;
                case 2:
                case 3:
                    cart();
                    break;
                case 4:
                    checkout();
                    break;
                case 6:
                    System.out.println("Thank you for shopping!");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 6);

        SCANNER.close();
    }

    private static void displayMainMenu() {
        System.out.println("\n====================================");
        System.out.println("            SUPER MARIKET           ");
        System.out.println("====================================");
        System.out.println("[1] View products");
        System.out.println("[2] Manage cart");
        System.out.println("[3] View cart");
        System.out.println("[4] Check out");
        System.out.println("[6] Exit");
        System.out.print("Enter choice: ");
    }

    private static void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    private static void displayProducts() {
        clearConsole();

        System.out.println("===============================================================");
        System.out.println("||                        STOCK LIST                         ||");
        System.out.println("===============================================================");

        System.out.printf(
                "|| %-4s | %-25s | %-10s | %-9s ||%n",
                "ID", "NAME", "PRICE", "STOCK");

        System.out.println("---------------------------------------------------------------");

        for (int i = 0; i < ID.size(); i++) {
            System.out.printf(
                    "| %-5d | %-25s | ₱%-9.2f | %-9d |%n",
                    ID.get(i),
                    PRODUCT_NAME.get(i),
                    PRICE.get(i),
                    STOCK_QUANTITY.get(i));
        }

        System.out.println("---------------------------------------------------------------");
    }

    private static void clearCart() {
        CART_PRODUCT.clear();
        CART_QUANTITY.clear();
        CART_PRICE.clear();
    }

    private static double calculateTotal() {
        double total = 0;

        for (int i = 0; i < CART_PRODUCT.size(); i++) {
            total += CART_PRICE.get(i) * CART_QUANTITY.get(i);
        }

        return total;
    }

    private static void displayCart() {
        System.out.println("\n================ SHOPPING CART ================");

        System.out.printf(
                "%-5s %-22s %-10s %-10s %-10s%n",
                "No.", "Product", "Price", "Quantity", "Subtotal");

        System.out.println("---------------------------------------------------------------");

        if (CART_PRODUCT.isEmpty()) {
            System.out.println("Your cart is empty.");
        }

        for (int i = 0; i < CART_PRODUCT.size(); i++) {
            double subtotal = CART_PRICE.get(i) * CART_QUANTITY.get(i);

            System.out.printf(
                    "%-5d %-22s ₱%-9.2f %-10d ₱%-10.2f%n",
                    i + 1,
                    CART_PRODUCT.get(i),
                    CART_PRICE.get(i),
                    CART_QUANTITY.get(i),
                    subtotal);
        }

        System.out.println("---------------------------------------------------------------");
        System.out.printf("TOTAL: ₱%.2f%n", calculateTotal());
        System.out.println("---------------------------------------------------------------");
    }

    private static void cart() {
        int choice;

        do {
            displayCart();

            System.out.println("[1] Add item");
            System.out.println("[2] Remove item");
            System.out.println("[3] Replace quantity");
            System.out.println("[4] Back to main menu");
            System.out.print("Enter choice: ");

            choice = SCANNER.nextInt();

            if (choice >= 1 && choice <= 3) {
                cartFunctions(choice);
            } else if (choice != 4) {
                System.out.println("Invalid input. Try again.");
            }

        } while (choice != 4);
    }

    private static void cartFunctions(int choice) {
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

    private static void addItem() {
        System.out.print("Enter product ID: ");
        int productId = SCANNER.nextInt();

        int inventoryIndex = ID.indexOf(productId);

        if (inventoryIndex == -1) {
            System.out.println("Invalid product ID.");
            return;
        }

        int cartIndex = CART_PRODUCT.indexOf(
                PRODUCT_NAME.get(inventoryIndex));

        int quantityAlreadyInCart = 0;

        if (cartIndex != -1) {
            quantityAlreadyInCart = CART_QUANTITY.get(cartIndex);
        }

        int availableStock = STOCK_QUANTITY.get(inventoryIndex) - quantityAlreadyInCart;

        if (availableStock <= 0) {
            System.out.println("No additional stock available.");
            return;
        }

        System.out.println("Product: " + PRODUCT_NAME.get(inventoryIndex));
        System.out.println("Available stock: " + availableStock);
        System.out.print("Enter quantity: ");

        int quantity = SCANNER.nextInt();

        if (quantity <= 0 || quantity > availableStock) {
            System.out.println("Invalid quantity or insufficient stock.");
            return;
        }

        if (cartIndex != -1) {
            CART_QUANTITY.set(
                    cartIndex, CART_QUANTITY.get(cartIndex) + quantity);
        } else {
            CART_PRODUCT.add(PRODUCT_NAME.get(inventoryIndex));
            CART_PRICE.add(PRICE.get(inventoryIndex));
            CART_QUANTITY.add(quantity);
        }

        System.out.println("Product successfully added!");
    }

    private static void removeItem() {
        if (CART_PRODUCT.isEmpty()) {
            System.out.println("Your cart is empty.");
            return;
        }

        System.out.print("Enter product ID to remove: ");
        int productId = SCANNER.nextInt();

        int inventoryIndex = ID.indexOf(productId);

        if (inventoryIndex == -1) {
            System.out.println("Invalid product ID.");
            return;
        }

        int cartIndex = CART_PRODUCT.indexOf(
                PRODUCT_NAME.get(inventoryIndex));

        if (cartIndex == -1) {
            System.out.println("Product not found in cart.");
            return;
        }

        System.out.print("Enter quantity to remove (0 = cancel, -1 = all): ");
        int quantity = SCANNER.nextInt();

        if (quantity == -1) {
            CART_PRODUCT.remove(cartIndex);
            CART_QUANTITY.remove(cartIndex);
            CART_PRICE.remove(cartIndex);

            System.out.println("Product removed from cart.");
        } else if (quantity == 0) {
            System.out.println("Removal cancelled.");
        } else if (quantity < 0) {
            System.out.println("Invalid quantity.");
        } else if (quantity > CART_QUANTITY.get(cartIndex)) {
            System.out.println("You cannot remove more than you have.");
        } else {
            int remaining = CART_QUANTITY.get(cartIndex) - quantity;

            if (remaining == 0) {
                CART_PRODUCT.remove(cartIndex);
                CART_QUANTITY.remove(cartIndex);
                CART_PRICE.remove(cartIndex);
            } else {
                CART_QUANTITY.set(cartIndex, remaining);
            }

            System.out.println("Quantity successfully removed.");
        }
    }

    private static void replaceQuantity() {
        if (CART_PRODUCT.isEmpty()) {
            System.out.println("Your cart is empty.");
            return;
        }

        System.out.print("Enter product ID: ");
        int productId = SCANNER.nextInt();

        int inventoryIndex = ID.indexOf(productId);

        if (inventoryIndex == -1) {
            System.out.println("Invalid product ID.");
            return;
        }

        int cartIndex = CART_PRODUCT.indexOf(
                PRODUCT_NAME.get(inventoryIndex));

        if (cartIndex == -1) {
            System.out.println("Product not found in cart.");
            return;
        }

        System.out.println(
                "Current quantity: " + CART_QUANTITY.get(cartIndex));

        System.out.print("Enter new quantity (0 = remove item): ");
        int newQuantity = SCANNER.nextInt();

        int otherCartQuantity = 0;

        for (int i = 0; i < CART_PRODUCT.size(); i++) {
            if (i != cartIndex
                    && CART_PRODUCT.get(i).equals(
                            PRODUCT_NAME.get(inventoryIndex))) {
                otherCartQuantity += CART_QUANTITY.get(i);
            }
        }

        int availableStock = STOCK_QUANTITY.get(inventoryIndex) - otherCartQuantity;

        if (newQuantity < 0 || newQuantity > availableStock) {
            System.out.println("Invalid quantity or insufficient stock.");
            return;
        }

        if (newQuantity == 0) {
            CART_PRODUCT.remove(cartIndex);
            CART_QUANTITY.remove(cartIndex);
            CART_PRICE.remove(cartIndex);

            System.out.println("Product removed from cart.");
        } else {
            CART_QUANTITY.set(cartIndex, newQuantity);
            System.out.println("Quantity successfully updated.");
        }
    }

    private static void checkout() {
        if (CART_PRODUCT.isEmpty()) {
            System.out.println("Cannot check out. Your cart is empty.");
            return;
        }

        displayCart();

        double total = calculateTotal();

        System.out.print("Enter payment amount: ₱");
        double payment = SCANNER.nextDouble();

        if (payment < total) {
            System.out.printf(
                    "Insufficient payment. You need ₱%.2f more.%n",
                    total - payment);
            return;
        }

        // Deduct purchased quantities from inventory.
        for (int i = 0; i < CART_PRODUCT.size(); i++) {
            int inventoryIndex = PRODUCT_NAME.indexOf(
                    CART_PRODUCT.get(i));

            STOCK_QUANTITY.set(
                    inventoryIndex,
                    STOCK_QUANTITY.get(inventoryIndex)
                            - CART_QUANTITY.get(i));
        }

        System.out.println("\n================ RECEIPT ================");
        displayCart();
        System.out.printf("Payment: ₱%.2f%n", payment);
        System.out.printf("Change:  ₱%.2f%n", payment - total);
        System.out.println("==========================================");
        System.out.println("Purchase successful. Thank you!");

        clearCart();
    }
}
