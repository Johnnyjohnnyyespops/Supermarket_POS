import java.util.*;

public class Main {

    // Pre loaded Inventory
    static ArrayList<Integer> id = new ArrayList<>(List.of(101, 102, 103, 104, 105, 106, 107, 108));
    static ArrayList<String> name = new ArrayList<>(List.of(
            "Jasmine Rice 5kg", "Fresh Milk 1L", "White Bread",
            "Canned Sardines", "Instant Noodles", "Cooking Oil 1L",
            "Laundry Detergent 1kg", "Bottled Water 1L"));
    static ArrayList<Double> price = new ArrayList<>(List.of(285.00, 95.00, 65.00, 32.00, 18.00, 85.00, 110.00, 25.00));
    static ArrayList<Integer> stock_quantity = new ArrayList<>(List.of(50, 30, 40, 60, 100, 35, 25, 80));

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) { // ETO UNG MAIN METHOD PARE!
        menu();
    }

    static void menu() { // DISPLAYS THE MENU
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

        System.out.print("Enter choice: ");
        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                product_Display();
                break;

            default:
                break;
        }

    }

    public static void clearConsole() { // This clears the terminal
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    static void product_Display() { // Displays the products information in a table format
        // Dinidisplay nya yung mga items in a table format
        clearConsole();
        System.out.println("===============================================================");
        System.out.println("||                        STOCK LIST                         ||");
        System.out.println("===============================================================");

        System.out.printf("|| %-4s | %-25s | %-10s | %-9s ||%n",
                "ID", "NAME", "PRICE", "STOCK");

        System.out.println("---------------------------------------------------------------");

        for (int i = 0; i < id.size(); i++) {
            System.out.printf("| %-5s | %-25s | ₱%-10.2f | %-9d |%n",
                    id.get(i),
                    name.get(i),
                    price.get(i),
                    stock_quantity.get(i));
        }
        System.out.println("---------------------------------------------------------------");
    }

}
