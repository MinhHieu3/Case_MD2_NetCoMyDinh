package controller;

import data.FileComputer;
import data.FileCustomer;
import data.FileRevenue;
import models.Computer;
import models.Customer;
import models.Revenue;
import models.Service;
import services.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuUser {
    ManagerCustomer managerCustomer = new ManagerCustomer();
    ManagerService managerService = new ManagerService();
    ManagerComputer managerComputer = new ManagerComputer();
    ManagerRevenue managerRevenue = new ManagerRevenue();
    Scanner inputString = new Scanner(System.in);
    int choice;

    public void showMenuUser() {
        System.out.println("┌———————————————————————————————————┐");
        System.out.println("⎟   CHÀO MỪNG BẠN ĐẾN NET CỎ MĐ     ⎟");
        System.out.println("└———————————————————————————————————┘");
        managerComputer.showAll();
        System.out.println("Chọn ID Máy");
        int idCom = InputOutput.checkInputInt();
        Computer computer = managerComputer.search(idCom);
        Revenue revenue = new Revenue();
        if (managerComputer.checkPc(idCom) && !computer.isStatus()) {
            LocalDateTime start = LocalDateTime.now();
            System.out.print("Tên Đăng Nhập  ");
            String user = inputString.nextLine();
            System.out.print("Mật Khẩu  ");
            String pass = inputString.nextLine();
            if (managerCustomer.check(user, pass)) {
                Customer customer = managerCustomer.search2(user, pass);
                computer.setStatus(true);
                FileComputer.writeToFile("D:\\CodeGym_M2\\Case_MD2_NETCO\\src\\data\\dataComputer.csv", managerComputer.getComputerList());
                do {
                    System.out.println("┌———————————————————————————————————┐");
                    System.out.println("⎟         NET CỎ MỸ ĐÌNH            ⎟");
                    System.out.println("⎟———————————————————————————————————⎟");
                    System.out.println("⎟1.Mua Hàng                         ⎟");
                    System.out.println("⎟2.Check Số Dư Tài Khoản            ⎟");
                    System.out.println("⎟3.Tắt Máy                          ⎟");
                    System.out.println("⎟4.Tâm Sự Cùng Anh Zai Đào Như Anh  ⎟");
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
                                int sl = InputOutput.checkInputInt();
                                Service service = managerService.search(sp);
                                try {
                                    computer.setPayment(sl * service.getPrice());
                                    System.out.println("Số Tiền Bạn Phải Trả Là : " + computer.getPayment());
                                    revenue.setPrice(service.getPrice());
                                    revenue.setQuantily(sl);
                                }catch (Exception e){
                                    System.out.println("Sản Phẩm Bạn Tìm Không Có ");
                                }
                                break;
                            case 2:
                                managerCustomer.checkTk(user);
                                break;
                            case 3:
                                double payment = computer.getPayment();
                                LocalDateTime end = LocalDateTime.now();
                                Duration duration = Duration.between(start, end);
                                int times = (int) duration.getSeconds();
                                double money = computer.getPrice() * duration.getSeconds();
                                double total = computer.setPayment(money + computer.getPayment());
                                double score = customer.getMoney() - computer.getPayment();
                                customer.setMoney(score);
                                FileCustomer.writeToFile("D:\\CodeGym_M2\\Case_MD2_NETCO\\src\\data\\dataCustomer.csv", managerCustomer.getCustomerList());
                                String names = customer.getName();
                                double priceCom = computer.getPrice();
                                int quantily = revenue.getQuantily();
                                if (score > 0) {
                                    Revenue revenue1 = new Revenue(idCom, names, times, priceCom, quantily, payment, total);
                                    managerRevenue.add(revenue1);
                                    System.out.println(revenue1);
                                    System.out.println("Số Dư Tài Khoản Là : " + score + " K" + "\n");
                                    FileRevenue.writeToFile("D:\\CodeGym_M2\\Case_MD2_NETCO\\src\\data\\dataRevenue.csv", managerRevenue.getRevenueList());
                                    computer.setStatus(false);
                                    FileComputer.writeToFile("D:\\CodeGym_M2\\Case_MD2_NETCO\\src\\data\\dataComputer.csv", managerComputer.getComputerList());
                                    showMenuUser();
                                } else System.out.println("Số Dư Không Đủ Cần Nạp Thêm Tiền");
                                showMenuUser();
                                break;
                            case 4:
                                Server.client();

                        }

                } while (choice != 0);
            } else {
                System.out.println("       --------------------------       ");
                System.out.println("Tài Khoản Hoặc Mật khẩu Của Bạn Sai ");
                showMenuUser();
            }
        } else {
            System.out.println("         ------------            ");
            System.out.println("Máy Hỏng Hoặc Đang Có Người Dùng ");
            System.out.println("        Chọn Máy Khác            ");
            System.out.println("---------------------------------");
            showMenuUser();
        }

    }
}
