package controller;

import services.InputOutput;
import services.ManagerService;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Menu {
    MenuCustomer menuStore = new MenuCustomer();
    MenuService menuService = new MenuService();
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
            System.out.println("⎟5.Hiển Thị Danh Sách Máy           ⎟");
            System.out.println("⎟6.Hiển Thị Máy Còn Trống           ⎟");
            System.out.println("⎟7. Tính Tiền                       ⎟");
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

            }
        } while (choice != 0);
    }
}
