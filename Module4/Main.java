package Module4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            printMenu();
            int choice = scanner.nextInt();
            System.out.println();

            switch (choice) {
                case 1:
                    DeadlockExample.run();
                    break;
                case 2:
                    LivelockExample.run();
                    break;
                case 3:
                    System.out.print("Count of thread: ");
                    int n = scanner.nextInt();
                    if (n <= 0) {
                        System.out.println("Count must be more than 0. Start standart count (2).");
                        n = 2;
                    }
                    new OrderPrinter(n).start();
                    break;
                case 0:
                    System.out.println("Exit...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option");
                    break;
            }
        }
    }

    private static void printMenu() {
        System.out.println("1. Example Deadlock");
        System.out.println("2. Example Livelock");
        System.out.println("3. Printer 1 2 order");
        System.out.println("0. Exit");
        System.out.print("> ");
    }
}