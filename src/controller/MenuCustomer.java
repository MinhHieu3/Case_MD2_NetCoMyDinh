package controller;

import data.FileCustomer;
import models.Customer;
import services.*;

import java.util.Scanner;

public class MenuCustomer {
    ManagerCustomer managerCustomer=new ManagerCustomer();
    Scanner inputString = new Scanner(System.in);
    int choice;

    public void menuCustormer(){
        do {
            System.out.println("---Danh Sách Khách Hàng---\n" +
                    "1.Thêm Khách  \n" +
                    "2.Sửa Thông Tin Khách \n" +
                    "3.Xóa Khách Hàng\n" +
                    "4.Tìm Kiếm Khách Hàng\n" +
                    "5.Danh Sách Khách Hàng Nạp Tiền \n" +
                    "6. Hiển THị Danh Sách Khách Hàng \n");
            System.out.println("Choice");
            choice = InputOutput.checkInputInt();
            switch (choice) {
                case 1:
                    System.out.println("Nhập ID Khách Hàng ");
                    int id=InputOutput.checkInputInt();
                    System.out.println("Nhập Tên Khách Hàng");
                    String name =inputString.nextLine();
                    System.out.println("Nhập Tên Đăng Nhập Cấp Cho Khách");
                    String userName=inputString.nextLine();
                    System.out.println("Nhập Mật Khẩu Cấp Cho  Khách");
                    String pass=inputString.nextLine();
                    System.out.println("Nhập Số Tiền khách Muốn Nạp");
                    double money=InputOutput.checkInputInt();
                    Customer customer1=new Customer(id,name,userName,pass,money);
                    managerCustomer.add(customer1);
                    FileCustomer.writeToFile("dataCustomer.csv",managerCustomer.getCustomerList());
                    break;
                case 2:
                    managerCustomer.showAll();
                    System.out.println("Nhập Vào ID Khách Hàng Muốn Sửa");
                    int ids=InputOutput.checkInputInt();
                    System.out.println("Nhập ID Khách Hàng ");
                    int idEdit=InputOutput.checkInputInt();
                    System.out.println("Nhập Tên Khách Hàng");
                    String nameEdit =inputString.nextLine();
                    System.out.println("Nhập Tên Đăng Nhập Cấp Cho Khách");
                    String userNameEdit=inputString.nextLine();
                    System.out.println("Nhập Mật Khẩu Cấp Cho  Khách");
                    String passEdit=inputString.nextLine();
                    System.out.println("Nhập Số Tiền khách Muốn Nạp");
                    double moneyEdit=InputOutput.checkInputInt();
                    Customer customer =new Customer(idEdit,nameEdit,userNameEdit,passEdit,moneyEdit);
                    managerCustomer.edit(ids,customer);
                    FileCustomer.writeToFile("dataCustomer.csv",managerCustomer.getCustomerList());
                    break;
                case 3:
                    System.out.println("Nhập ID Khách Muốn Xóa");
                    int idd=InputOutput.checkInputInt();
                    System.out.println(managerCustomer.search(idd));
                    managerCustomer.delete(idd);
                    FileCustomer.writeToFile("dataCustomer.csv",managerCustomer.getCustomerList());
                    break;
                case 4:
                    System.out.println("Nhập ID Khách Muốn Tìm");
                    int idSearch=InputOutput.checkInputInt();
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
