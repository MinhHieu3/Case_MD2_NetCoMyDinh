package services;

import java.util.Scanner;

public class InputOutput {
    public static int checkInputInt() {
        Scanner scanner = new Scanner(System.in);
        int choice = -1;
        while (choice == -1) {
            try {
                choice = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Bạn phải nhập vào số");
                scanner.nextLine();
            }
        }
        return choice;
    }
}
