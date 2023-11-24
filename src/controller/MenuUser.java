package controller;

import models.Computer;
import models.Service;
import services.InputOutput;
import services.ManagerComputer;
import services.ManagerCustomer;
import services.ManagerService;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class MenuUser {
    ManagerCustomer managerCustomer = new ManagerCustomer();
    ManagerService managerService = new ManagerService();
    ManagerComputer managerComputer = new ManagerComputer();
    List<String>list=new ArrayList<>();

    Scanner inputString = new Scanner(System.in);
    int choice;

    public void showMenuUser() {

        System.out.println("┌———————————————————————————————————┐");
        System.out.println("⎟   CHÀO MỪNG BẠN ĐẾN NET CỎ MĐ     ⎟");
        System.out.println("└———————————————————————————————————┘");
        managerComputer.showAll();
        System.out.println("Nhập ID Máy");
        int a = InputOutput.checkInputInt();
        Computer computer=managerComputer.search(a);
        if (managerComputer.checkPc(a)) {
            LocalDateTime start = LocalDateTime.now();
            System.out.println("Nhập Tên Đăng Nhập");
            String user = inputString.nextLine();
            System.out.println("Nhập Mật Khẩu");
            String pass = inputString.nextLine();
            if (managerCustomer.check(user, pass)) {
                do {
                    System.out.println("┌———————————————————————————————————┐");
                    System.out.println("⎟         NET CỎ MỸ ĐÌNH            ⎟");
                    System.out.println("⎟———————————————————————————————————⎟");
                    System.out.println("⎟1.Mua Hàng                         ⎟");
                    System.out.println("⎟2.Check Số Dư Tài Khoản            ⎟");
                    System.out.println("⎟3.Tắt Máy                          ⎟");
                    System.out.println("└———————————————————————————————————┘");
                    System.out.println("Nhập lựa chọn :");
                    choice = InputOutput.checkInputInt();

                    switch (choice) {
                        case 1:
                            managerService.showAll();
                            System.out.println("-----------------");
                            System.out.println("Chọn Sản Phẩm Mua");
                            int sp = InputOutput.checkInputInt();
                            System.out.println("Số Lượng Mua");
                            int sl=InputOutput.checkInputInt();
                            Service service = managerService.search(sp);
                            computer.setPayment(sl * service.getPrice());
                            System.out.println("Số Tiền Bạn Phải Trả Là : " + computer.getPayment());

                            break;
                        case 2:
                            System.out.println("------------------");
                            System.out.println("Nhập Tên Đăng Nhập");
                            String check = inputString.nextLine();
                            managerCustomer.checkTk(check);
                            break;
                        case 3:
                            LocalDateTime end = LocalDateTime.now();
                            Duration duration = Duration.between(start, end);
//                            managerComputer.billPc(a, (double) duration.getSeconds());
                            double money  =computer.getPrice()*duration.getSeconds();
                            System.out.println("Khoảng thời gian (giây): " + money);
                            computer.setPayment(money + computer.getPayment());
                            System.out.println(computer.getPayment());
//                          System.out.println("Khoảng thời gian (phút): " + duration.toMinutes());
//                          System.out.println("Khoảng thời gian (giờ): " + duration.toHours());
//                          System.out.println("Khoảng thời gian (ngày): " + duration.toDays());
                            showMenuUser();
                            break;
                    }
                } while (choice != 0);
            }
        }
        else {
            System.out.println("         ------------            ");
            System.out.println("Máy Hỏng Hoặc Đang Có Người Dùng ");
            System.out.println("        Chọn Máy Khác            ");
            System.out.println("---------------------------------");
            showMenuUser();
        }

    }

}
