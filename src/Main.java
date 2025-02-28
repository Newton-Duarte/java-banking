import java.util.Scanner;

public class Main {
    static double amount = 0;
    static String name;
    static boolean isRunning = true;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("What's your name?: ");
        name = scanner.nextLine();

        while (isRunning) {
            System.out.println("**************");
            System.out.println("Java Banking");
            System.out.println("**************");

            showMenu();
            System.out.printf("\nHello %s, what you want to do?: ", name);
            int option;
            option = scanner.nextInt();

            switch (option) {
                case 1 -> showBalance();
                case 2 -> deposit();
                case 3 -> withdraw();
                case 4 -> exit();
                default -> System.out.println("Invalid option");
            }
        }

        scanner.close();
    }

    private static void exit() {
        System.out.println("Thank you for using our bank!");
        isRunning = false;
    }

    private static void withdraw() {
        System.out.print("\nHow much do you want to withdraw? ");
        double withdrawAmount = scanner.nextDouble();

        if (withdrawAmount > amount) {
            System.out.println("Invalid withdraw. The withdraw amount is greater than your balance.");
            return;
        }

        amount -= withdrawAmount;
    }

    private static void deposit() {
        System.out.print("\nHow much do you want to deposit? ");
        double depositAmount = scanner.nextDouble();

        if (depositAmount <= 0) {
            System.out.println("Invalid deposit amount");
            return;
        }

        amount += depositAmount;
    }

    static void showBalance() {
        System.out.printf("\nYour current balance is $%.2f\n", amount);
    }

    static void showMenu() {
        System.out.println("1. Show Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
    }
}
