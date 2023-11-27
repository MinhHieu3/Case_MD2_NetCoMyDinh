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
            System.out.println("Chọn ID Máy");
            int a = InputOutput.checkInputInt();
            Computer computer = managerComputer.search(a);
            Revenue revenue = new Revenue();
            if (managerComputer.checkPc(a)) {
                LocalDateTime start = LocalDateTime.now();
                System.out.print("Tên Đăng Nhập");
                String user = inputString.nextLine();
                System.out.print("Mật Khẩu" );
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
                                computer.setPayment(sl * service.getPrice());
                                System.out.println("Số Tiền Bạn Phải Trả Là : " + computer.getPayment());
                                revenue.setPrice(sl*service.getPrice());
                                revenue.setQuantily(sl);


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
                                int times= (int) duration.getSeconds();
                                double money = computer.getPrice() * duration.getSeconds();
                                System.out.println("Bạn Đã Chơi Hết " + duration.getSeconds() + " Phút " + " Số Tiền Là : " + money);
                                computer.setPayment(money + computer.getPayment());
                                double b = computer.getPayment();
                                System.out.println("Số Tiền Bạn Mua Đồ Là : " + computer.getPayment());
                                double score = customer.getMoney() - computer.getPayment();
                                String names=customer.getName();
                                double priceCom=computer.getPrice();
                                double c=revenue.getPrice();
                                int d=revenue.getQuantily();
                                if (score > 0) {
                                    System.out.println("Số Dư Tài Khoản Là : " + score+"\n");
                                    Revenue revenue1 = new Revenue(a,names,times,priceCom,d,c,score);
                                    managerRevenue.add(revenue1);
                                    System.out.println(revenue1);
                                    FileRevenue.writeToFile("D:\\CodeGym_M2\\Case_MD2_NETCO\\src\\data\\dataRevenue.csv",managerRevenue.getRevenueList());
                                    showMenuUser();
                                } else System.out.println("Số Dư Không Đủ Cần Nạp Thêm Tiền");
                                showMenuUser();
                                break;
                            case 4:
//                                boolean checkRun=true;
//                                int port = 8081;
//                                try {
//                                    Socket socket = new Socket("localhost", port);
//                                    System.out.println("---Đã Kết Nối Thành Công--- ");
//                                    BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//                                    PrintWriter writer = new PrintWriter(socket.getOutputStream());
//                                    Scanner sc = new Scanner(System.in);
//                                    String message;
//                                    System.out.println("--Nhắn Tin--");
//                                    System.out.println("Muốn Thoát Hãy Gõ  :  "+ "  quit" );
//                                    while (checkRun) {
//                                        String messages = sc.nextLine();
//                                        writer.println(messages);
//                                        writer.flush();
//                                        if (messages.equals("quit")) {
//                                            checkRun = false;
//                                        }
//                                        message = reader.readLine();
//                                        System.out.println("Admin : " + message);
//                                    }
//                                    writer.close();
//                                    reader.close();
//                                } catch (IOException e) {
//                                    System.out.println("-----------------------------------------------");
//                                    System.out.println("Máy Chủ Đang Bận - Liên Hệ Bằng Mồm Được Không ?? ");
//                                }
                                Server.client();

                        }
                    } while (choice != 0) ;
                    }else{
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
