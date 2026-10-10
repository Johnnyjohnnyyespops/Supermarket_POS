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
            List.of(285.00, 95.00, 65.00, 32.00, 18.00, 85.00, 110.00, 25.00));

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
            SCANNER.nextLine();

            switch (choice) {
                case 1:
                    displayProducts();
                    break;
                case 2:
                    cart();
                    break;
                default:
                    break;
            }
        } while (choice != 6);
    }

    private static void displayMainMenu() {
        System.out.println("====================================");
        System.out.println("            SUPER MARIKET           ");
        System.out.println("====================================");

        System.out.println("[1] View products");
        System.out.println("[2] Add to cart");
        System.out.println("[3] View cart");
        System.out.println("[4] Check out");
        System.out.println("[6] Exit");
        System.out.println();
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
                "ID",
                "NAME",
                "PRICE",
                "STOCK");

        System.out.println("---------------------------------------------------------------");

        for (int i = 0; i < ID.size(); i++) {
            System.out.printf(
                    "| %-5s | %-25s | ₱%-10.2f | %-9d |%n",
                    ID.get(i),
                    PRODUCT_NAME.get(i),
                    PRICE.get(i),
                    STOCK_QUANTITY.get(i));
        }

        System.out.println("---------------------------------------------------------------");
    }

    private static void cart() {
        int choice;

        do {
            System.out.println("\n================ SHOPPING CART ================");
            System.out.printf(
                    "%-5s %-20s %-10s %-10s %-10s%n",
                    "No.",
                    "Product",
                    "Price",
                    "Quantity",
                    "Subtotal");

            System.out.println("------------------------------------------------------------");

            double total = 0;

            for (int i = 0; i < CART_PRODUCT.size(); i++) {
                double subtotal = CART_PRICE.get(i) * CART_QUANTITY.get(i);
                total += subtotal;

                System.out.printf(
                        "%-5d %-20s ₱%-9.2f %-10d ₱%-10.2f%n",
                        i + 1,
                        CART_PRODUCT.get(i),
                        CART_PRICE.get(i),
                        CART_QUANTITY.get(i),
                        subtotal);
            }

            System.out.println("------------------------------------------------------------");
            System.out.printf("%-48s ₱%.2f%n", "TOTAL:", total);
            System.out.println("------------------------------------------------------------");
            System.out.println("============================================================");
            System.out.println("[1] Add item");
            System.out.println("[2] Remove item");
            System.out.println("[3] Replace item");
            System.out.print("Enter choice: ");
            choice = SCANNER.nextInt();

            cartFunctions(choice);
        } while (choice != 4);
    }

    private static void cartFunctions(int choice) {
        switch (choice) {
            case 1:
                System.out.print("Enter product ID: ");
                int productId = SCANNER.nextInt();
                SCANNER.nextLine();

                if (ID.contains(productId)) {
                    int index = ID.indexOf(productId);
                    CART_PRODUCT.add(PRODUCT_NAME.get(index));
                    CART_PRICE.add(PRICE.get(index));

                    System.out.print("Enter quantity: ");
                    int quantity = SCANNER.nextInt();
                    SCANNER.nextLine();

                    CART_QUANTITY.add(quantity);
                    System.out.println("Product added successfully!");
                } else {
                    System.out.println("Invalid Product");
                }
                break;
            default:
                break;
        }
    }
}