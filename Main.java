import java.util.*;

public class Main {

    // Pre loaded Inventory

    static ArrayList<Integer> id = new ArrayList<>(
            List.of(101, 102, 103, 104, 105, 106, 107, 108));

    static ArrayList<String> productName = new ArrayList<>(
            List.of(
                    "Jasmine Rice 5kg",
                    "Fresh Milk 1L",
                    "White Bread",
                    "Canned Sardines",
                    "Instant Noodles",
                    "Cooking Oil 1L",
                    "Laundry Detergent 1kg",
                    "Bottled Water 1L"));

    static ArrayList<Double> price = new ArrayList<>(
            List.of(285.00, 95.00, 65.00, 32.00, 18.00, 85.00, 110.00, 25.00));

    static ArrayList<Integer> stock_quantity = new ArrayList<>(
            List.of(50, 30, 40, 60, 100, 35, 25, 80));

    // CART

    static ArrayList<String> cartProduct = new ArrayList<>();
    static ArrayList<Integer> cartQuantity = new ArrayList<>();
    static ArrayList<Double> cartPrice = new ArrayList<>();

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int choice = 0;

        do {

            // ETO UNG MAIN METHOD PARE!

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
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    menu(choice);
                    break;

                case 2:
                    cart();
                    break;
                default:
                    break;
            }
        } while (choice != 6);

    }

    static void menu(int userChoice) {

        // DISPLAYS THE MENU

        switch (userChoice) {

            case 1:
                product_Display();
                break;

            case 2:
                cart();
                break;

            default:
                break;
        }
    }

    public static void clearConsole() {

        // This clears the terminal

        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    static void product_Display() {

        // Displays the products information in a table format

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

        for (int i = 0; i < id.size(); i++) {

            System.out.printf(
                    "| %-5s | %-25s | ₱%-10.2f | %-9d |%n",
                    id.get(i),
                    productName.get(i),
                    price.get(i),
                    stock_quantity.get(i));
        }

        System.out.println("---------------------------------------------------------------");
    }

    // Cart METHODS

    static void cart() { // THE ACTUAL CART
        int choice = 0;
        int items = 0;

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

            for (int i = 0; i < cartProduct.size(); i++) {

                double subtotal = cartPrice.get(i) * cartQuantity.get(i);

                total += subtotal;

                System.out.printf(
                        "%-5d %-20s ₱%-9.2f %-10d ₱%-10.2f%n",
                        i + 1,
                        cartProduct.get(i),
                        cartPrice.get(i),
                        cartQuantity.get(i),
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
            choice = sc.nextInt();

            cart_functions(choice);

        } while (choice != 4);

    }

    // HOW THE CART BEHAVES
    static void cart_functions(int choice) {
        switch (choice) {
            case 1:
                System.out.print("Enter product ID: ");
                int productID = sc.nextInt();
                sc.nextLine();

                if (id.contains(productID)) {
                    int index = id.indexOf(productID);
                    cartProduct.add(productName.get(index));
                    cartPrice.add(price.get(index));

                    System.out.print("Enter quantity: ");
                    int quantity = sc.nextInt();

                    cartQuantity.add(quantity);
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