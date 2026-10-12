import java.util.Scanner;

public class credit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Kindly follow this format: xxxx-xxxx-xxxx-xxxx");
        System.out.print("Enter credit card number: ");
        String creditcard = sc.nextLine();

        boolean validCardNumber = true;

        if (creditcard.length() != 19) {
            // check length
            validCardNumber = false;

        } else {
            // check format
            if (!creditcard.substring(4, 5).equals("-") || !creditcard.substring(9, 10).equals("-")
                    || !creditcard.substring(14, 15).equals("-")) {
                validCardNumber = false;
            }
        }

        // Check if the characters are valid
        for (int i = 0; i < creditcard.length(); i++) {
            if (i == 4 || i == 9 || i == 14) {
                continue;
            }
            if (!Character.isDigit(creditcard.charAt(i))) {
                validCardNumber = false;
                break;
            }
        }

        if (!validCardNumber) {
            System.out.println("Print ");
        } else {
            System.out.println("Invalid credit card number");
        }

    }
}
