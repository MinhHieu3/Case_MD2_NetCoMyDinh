package controller;

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
    ManagerRevenue managerRevenue=new ManagerRevenue();
    Scanner inputString = new Scanner(System.in);
    int choice;

    public void showMenuUser() {
            System.out.println("┌———————————————————————————————————┐");
            System.out.println("⎟   CHÀO MỪNG BẠN ĐẾN NET CỎ MĐ     ⎟");
            System.out.println("└———————————————————————————————————┘");
            managerComputer.showAll();
            System.out.println("Nhập ID Máy");
            int a = InputOutput.checkInputInt();
            Computer computer = managerComputer.search(a);
            if (managerComputer.checkPc(a)) {
                LocalDateTime start = LocalDateTime.now();
                System.out.println("Nhập Tên Đăng Nhập");
                String user = inputString.nextLine();
                System.out.println("Nhập Mật Khẩu");
                String pass = inputString.nextLine();
                if (managerCustomer.check(user, pass)) {
                    Customer customer = managerCustomer.search2(user, pass);
                    computer.setCustomer(customer);
                    String name = customer.getName();
                    do {
                        System.out.println("┌———————————————————————————————————┐");
                        System.out.println("⎟         NET CỎ MỸ ĐÌNH            ⎟");
                        System.out.println("⎟———————————————————————————————————⎟");
                        System.out.println("⎟1.Mua Hàng                         ⎟");
                        System.out.println("⎟2.Check Số Dư Tài Khoản            ⎟");
                        System.out.println("⎟3.Tắt Máy                          ⎟");
                        System.out.println("⎟4.Nhắn Tin Cho Chủ Quán            ⎟");
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
                                double money = computer.getPrice() * duration.getSeconds();
                                System.out.println("Bạn Đã Chơi Hết " + duration.getSeconds() + " Phút " + " Số Tiền Là : " + money);
                                computer.setPayment(money + computer.getPayment());
                                double b = computer.getPayment();
                                System.out.println("Số Tiền Bạn Mua Đồ Là : " + computer.getPayment());
                                double score = customer.getMoney() - computer.getPayment();
                                String names=customer.getName();

                                if (score > 0) {
                                    System.out.println("Số Dư Tài Khoản Là : " + score+"\n");
                                    Revenue revenue = new Revenue(a,names,b,end);
                                    managerRevenue.add(revenue);
                                    System.out.println(revenue);
                                    FileRevenue.writeToFile("D:\\CodeGym_M2\\Case_MD2_NETCO\\src\\data\\dataRevenue.csv",managerRevenue.getRevenueList());
                                    showMenuUser();
                                } else System.out.println("Số Dư Đủ Cần Nạp Thêm Tiền");
                                showMenuUser();
                                break;
                            case 4:
                                int port = 8081;
                                try {
                                    Socket socket = new Socket("localhost", port);
                                    System.out.println("---Đã Kết Nối Thành Công--- ");
                                    BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                                    PrintWriter writer = new PrintWriter(socket.getOutputStream());
                                    Scanner sc = new Scanner(System.in);
                                    String message;
                                    System.out.println("------------");
                                    System.out.println("--Nhắn Tin--");
                                    while (true) {
                                        String messages = sc.nextLine();
                                        writer.println(messages);
                                        writer.flush();
                                        // Nhận tin
                                        message = reader.readLine();
                                        if (messages.equals("q")) {
                                            break;
                                        }
                                        System.out.println("Admin : " + message);
                                    }
                                } catch (IOException e) {
                                    System.out.println("-----------------------------------------------");
                                    System.out.println("Máy Chủ Đang Bận - Liên Hệ Bằng Mồm Được Không ");
                                }

                        }
                    } while (choice != 0) ;
                    }else{
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
