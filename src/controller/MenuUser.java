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
            System.out.println("┌———————————————————————————————————┐");
            System.out.println("⎟   CHÀO MỪNG BẠN ĐẾN NET CỎ MĐ     ⎟");
            System.out.println("⎟———————————————————————————————————⎟");
            System.out.println("⎟1.Đăng Nhập Tài Khoản              ⎟");
            System.out.println("⎟2.Mua Hàng                         ⎟");
            System.out.println("⎟3.Kiểm Tra Tiền Trong Tài Khoản    ⎟");
            System.out.println("└———————————————————————————————————┘");
            System.out.println("Nhập lựa chọn : ");
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
                        System.out.println("--------------------------");
                        System.out.println("Nhấn " + " 1 " + " Để Tắt Máy");
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
                    System.out.println("-----------------");
                    System.out.println("Chọn Sản Phẩm Mua");
                    String sp = inputString.nextLine();
                    break;
                case 3:
                    System.out.println("------------------");
                    System.out.println("Nhập Tên Đăng Nhập");
                    String check = inputString.nextLine();
                    managerCustomer.checkTk(check);
                    break;


            }
        } while (choice != 0);
    }

}
