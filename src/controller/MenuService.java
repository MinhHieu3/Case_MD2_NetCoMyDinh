package controller;

import data.FileCustomer;
import data.FileSevices;
import models.Customer;
import models.Service;
import services.InputOutput;
import services.ManagerComputer;
import services.ManagerRevenue;
import services.ManagerService;

import java.util.Scanner;

public class MenuService {
    ManagerService managerService = new ManagerService();
    Scanner inputString = new Scanner(System.in);
    int choice;

    public void menuService() {
        do {
            System.out.println("┌———————————————————————————————————┐");
            System.out.println("⎟               DịCH VỤ             ⎟");
            System.out.println("⎟———————————————————————————————————⎟");
            System.out.println("⎟1.Thêm Sản Phẩm                    ⎟");
            System.out.println("⎟2.Sửa Sản Phẩm                     ⎟");
            System.out.println("⎟3.Xóa Sản Phẩm                     ⎟");
            System.out.println("⎟4.Tìm Kiếm Sản Phẩm                ⎟");
            System.out.println("⎟5.Danh Sách Sản Phầm Còn Hàng      ⎟");
            System.out.println("⎟6.Hiển THị Danh Sách Sản Phẩm      ⎟");
            System.out.println("⎟0. Quay lại                        ⎟");
            System.out.println("└———————————————————————————————————┘");
            System.out.println("Nhập lựa chọn :");
            choice = InputOutput.checkInputInt();
            switch (choice) {
                case 1:
                    System.out.println("Nhập Tên Sản Phẩm ");
                    String name = inputString.nextLine();
                    System.out.println("Nhập Giá Tiền");
                    double money = InputOutput.checkInputInt();
                    System.out.println("Nhập Số Lượng");
                    int quantily1 = InputOutput.checkInputInt();
                    Service service = new Service(name, money, quantily1);
                    managerService.add(service);
                    FileSevices.writeToFile("D:\\CodeGym_M2\\Case_MD2_NETCO\\src\\data\\dataServices.csv", managerService.getServiceList());
                    break;
                case 2:
                    managerService.showAll();
                    System.out.println("Nhập Vào ID Sản Phẩm Muốn Sửa");
                    int ids = InputOutput.checkInputInt();
                    System.out.println("Nhập Tên Sản Phẩm ");
                    String name1 = inputString.nextLine();
                    System.out.println("Nhập Giá Tiền");
                    double money1 = InputOutput.checkInputInt();
                    System.out.println("Nhập Số Lượng");
                    int quantily = InputOutput.checkInputInt();
                    Service service1 = new Service(name1, money1, quantily);
                    managerService.add(service1);
                    managerService.edit(ids, service1);
                    FileSevices.writeToFile("D:\\CodeGym_M2\\Case_MD2_NETCO\\src\\data\\dataServices.csv", managerService.getServiceList());
                    break;
                case 3:
                    managerService.showAll();
                    System.out.println("Nhập ID Sản Phẩm Muốn Xóa");
                    int idd = InputOutput.checkInputInt();
                    managerService.delete(idd);
                    FileSevices.writeToFile("D:\\CodeGym_M2\\Case_MD2_NETCO\\src\\data\\dataServices.csv", managerService.getServiceList());
                    break;
                case 4:
                    System.out.println("Nhập ID Sản Phẩm Muốn Tìm");
                    int idSearch = InputOutput.checkInputInt();
                    System.out.println(managerService.search(idSearch));
                    break;
                case 5:
                    managerService.show();
                    break;
                case 6:
                    managerService.showAll();
                    break;
            }
        } while (choice != 0);
    }
}
