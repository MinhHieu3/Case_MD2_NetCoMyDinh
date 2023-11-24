package controller;

import services.InputOutput;
import services.ManagerComputer;
import services.ManagerCustomer;
import services.ManagerService;

import java.util.Date;
import java.util.Scanner;

public class MenuUser {
    ManagerCustomer managerCustomer = new ManagerCustomer();
    ManagerService managerService = new ManagerService();
    ManagerComputer managerComputer = new ManagerComputer();
    Date currentTimes = new Date();

    Scanner inputString = new Scanner(System.in);
    int choice;

    public void showMenuUser() {
        do {
            System.out.println("---Người Dùng---\n" +
                    "1.Đăng Nhập \n" +
                    "2.Mua Đồ");
            System.out.println("Choice");
            choice = InputOutput.checkInputInt();
            switch (choice) {
                case 1:
                    System.out.println("Nhập Tên Đăng Nhập");
                    String user = inputString.nextLine();
                    System.out.println("Nhập Mật Khẩu");
                    String pass = inputString.nextLine();
                    if (managerCustomer.check(user, pass)) {
                        managerComputer.showAll();
                        System.out.println("Chọn Máy Muốn Dùng");
                        int a = InputOutput.checkInputInt();
//                        managerComputer.bill(a);
                        System.out.println("1.Tôi Muốn Tắt Máy");
                        int choise1 = InputOutput.checkInputInt();
                        switch (choise1) {
                            case 1:

                                System.out.println();
                                break;
                        }
                    }
                    break;
                case 2:
                    managerCustomer.showAll();
                    System.out.println("Chọn Sản Phẩm Mua ");
                    String sp = inputString.nextLine();


            }
        } while (choice != 0);
    }

}
