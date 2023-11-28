package controller;

import services.InputOutput;
import services.Server;

public class Menu {

    MenuCustomer menuStore = new MenuCustomer();
    MenuService menuService = new MenuService();
    MenuRevenue menuRevenue = new MenuRevenue();
    MenuComputer menuPC = new MenuComputer();
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
            System.out.println("⎟5.Lắng Nghe Đào Như Anh Lói        ⎟");
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
                    Server.sever();
            }
        }
        while (choice != 0);

    }
}
