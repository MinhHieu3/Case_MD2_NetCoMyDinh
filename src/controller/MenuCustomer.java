package controller;

import data.FileCustomer;
import models.Customer;
import services.*;

import java.util.Scanner;

public class MenuCustomer {
    ManagerCustomer managerCustomer = new ManagerCustomer();
    Scanner inputString = new Scanner(System.in);
    int choice;

    public void menuCustormer() {
        do {
            System.out.println("┌———————————————————————————————————┐");
            System.out.println("⎟             KHÁCH HÀNG            ⎟");
            System.out.println("⎟———————————————————————————————————⎟");
            System.out.println("⎟1.Tạo Tài Khoản Mới                ⎟");
            System.out.println("⎟2.Sửa Thông Tin Khách              ⎟");
            System.out.println("⎟3.Xóa Tài Khoản Khách Hàng         ⎟");
            System.out.println("⎟4.Tìm Kiếm Tài Khoản Khách Hàng    ⎟");
            System.out.println("⎟5.Danh Sách Tài Khoản Còn Tiền     ⎟");
            System.out.println("⎟6.Hiển THị Danh Sách Tài Khoản     ⎟");
            System.out.println("⎟0. Quay lại                        ⎟");
            System.out.println("└———————————————————————————————————┘");
            System.out.println("Nhập lựa chọn :");
            choice = InputOutput.checkInputInt();
            switch (choice) {
                case 1:
                    System.out.println("Nhập ID Khách Hàng ");
                    int id = InputOutput.checkInputInt();
                    System.out.println("Nhập Tên Khách Hàng");
                    String name = inputString.nextLine();
                    System.out.println("Nhập Tên Đăng Nhập Cấp Cho Khách");
                    String userName = inputString.nextLine();
                    System.out.println("Nhập Mật Khẩu Cấp Cho Khách");
                    String pass = inputString.nextLine();
                    System.out.println("Nhập Số Tiền khách Muốn Nạp");
                    double money = InputOutput.checkInputInt();
                    Customer customer1 = new Customer(id, name, userName, pass, money);
                    managerCustomer.add(customer1);
                    FileCustomer.writeToFile("dataCustomer.csv", managerCustomer.getCustomerList());
                    break;
                case 2:
                    managerCustomer.showAll();
                    System.out.println("Nhập Vào ID Khách Hàng Muốn Sửa");
                    int ids = InputOutput.checkInputInt();
                    System.out.println("Nhập ID Khách Hàng ");
                    int idEdit = InputOutput.checkInputInt();
                    System.out.println("Nhập Tên Khách Hàng");
                    String nameEdit = inputString.nextLine();
                    System.out.println("Nhập Tên Đăng Nhập Cấp Cho Khách");
                    String userNameEdit = inputString.nextLine();
                    System.out.println("Nhập Mật Khẩu Cấp Cho  Khách");
                    String passEdit = inputString.nextLine();
                    System.out.println("Nhập Số Tiền khách Muốn Nạp");
                    double moneyEdit = InputOutput.checkInputInt();
                    Customer customer = new Customer(idEdit, nameEdit, userNameEdit, passEdit, moneyEdit);
                    managerCustomer.edit(ids, customer);
                    FileCustomer.writeToFile("dataCustomer.csv", managerCustomer.getCustomerList());
                    break;
                case 3:
                    managerCustomer.showAll();
                    System.out.println("Nhập ID Khách Muốn Xóa");
                    int idd = InputOutput.checkInputInt();
                    System.out.println(managerCustomer.search(idd));
                    managerCustomer.delete(idd);
                    FileCustomer.writeToFile("dataCustomer.csv", managerCustomer.getCustomerList());
                    break;
                case 4:
                    System.out.println("Nhập ID Khách Muốn Tìm");
                    int idSearch = InputOutput.checkInputInt();
                    System.out.println(managerCustomer.search(idSearch));
                    break;
                case 5:
                    managerCustomer.showMoney();
                    break;
                case 6:
                    managerCustomer.showAll();
                    break;
            }
        } while (choice != 0);
    }
}
