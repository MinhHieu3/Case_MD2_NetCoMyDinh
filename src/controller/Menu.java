package controller;

import services.InputOutput;
import services.ManagerRevenue;
import services.ManagerService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Menu {

    MenuCustomer menuStore = new MenuCustomer();
    MenuService menuService = new MenuService();
    MenuRevenue menuRevenue = new MenuRevenue();
    MenuPC menuPC = new MenuPC();
    int choice;


    public void showMenu() {
        do {
            System.out.println("┌———————————————————————————————————┐");
            System.out.println("⎟               QUẢN LÝ             ⎟");
            System.out.println("⎟———————————————————————————————————⎟");
            System.out.println("⎟1.Quản Lý Khách Hàng               ⎟");
            System.out.println("⎟2.Quản Lý Máy                      ⎟");
            System.out.println("⎟3.Quản Lý Dịch Vụ                  ⎟");
            System.out.println("⎟4.Quản Lý Doanh Thu                ⎟");
            System.out.println("⎟5.Thông Báo Tin Nhắn Từ Khách      ⎟");
            System.out.println("└———————————————————————————————————┘");
            System.out.println("Nhập lựa chọn :");
            choice = InputOutput.checkInputInt();
            switch (choice) {
                case 1:
                    menuStore.menuCustormer();
                    break;
                case 2:
                    menuPC.menuPC();
                    break;
                case 3:
                    menuService.menuService();
                    break;
                case 4:
                    menuRevenue.menuRevenue();
                    break;
                case 5:
                    int port = 8081;
                    try {
                        System.out.println("Nói Đi Những Anh Khách Khó Tính ");
                        ServerSocket serverSocket = new ServerSocket(port);
                        Socket clienSocket = serverSocket.accept();
                        BufferedReader reader = new BufferedReader(new InputStreamReader(clienSocket.getInputStream()));
                        PrintWriter writer = new PrintWriter(clienSocket.getOutputStream());
                        Scanner sc = new Scanner(System.in);
                        String message;
                        while (true) {
                            //Nhận tin Nhắn
                            message = reader.readLine();
                            if (message.equals("quit")) {
                                writer.close();
                                reader.close();
                                serverSocket.close();
                                break;
                            }
                            System.out.println("Khách Hàng :  " + message);
                            //gửi tin nhắn
                            System.out.println("Trả Lời Khách Hàng : ");
                            message = sc.nextLine();
                            writer.println(message);
                            writer.flush();
                            if (message.equals("quit")) {
                                writer.close();
                                reader.close();
                                serverSocket.close();
                                break;
                            }


                        }
                    } catch (IOException e) {
                        System.out.println("Lỗi Máy Chủ ");
                    }
            }
        }
        while (choice != 0);

    }
}
