package controller;

import services.InputOutput;
import services.ManagerService;

import java.util.Scanner;

public class Menu {
    MenuCustomer menuStore = new MenuCustomer();
    MenuService menuService = new MenuService();
    MenuPC menuPC=new MenuPC();
    int choice;

    public void showMenu() {
        do {
            System.out.println("---Quản Lí Quán NET Cỏ Mỹ Đình---\n" +
                    "1.Quản Lí Khách Hàng \n" +
                    "2.Quản Lí Máy \n" +
                    "3.Quản Lí Dịch Vụ \n" +
                    "4.Quản Lí Doanh Thu  \n");
            System.out.println("Choice");
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
