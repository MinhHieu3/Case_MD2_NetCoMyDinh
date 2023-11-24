package controller;

import services.InputOutput;
import services.ManagerCustomer;
import services.ManagerService;

import java.util.Scanner;

public class MenuUser {
    ManagerCustomer managerCustomer=new ManagerCustomer();
    ManagerService managerService=new ManagerService();

    Scanner inputString=new Scanner(System.in);
    int choice;
    public void showMenuUser(){
        do {
            System.out.println("---Người Dùng---\n"+
                    "1.Đăng Nhập \n"+
                    "2.Mua Đồ");
            System.out.println("Choice");
            choice= InputOutput.checkInputInt();
            switch (choice){
                case 1:
                    System.out.println("Nhập Tên Đăng Nhập");
                    String user=inputString.nextLine();
                    System.out.println("Nhập Mật Khẩu");
                    String pass=inputString.nextLine();
                    managerCustomer.check(user,pass);
                    break;
                case 2:
                    managerCustomer.showAll();
                    System.out.println("Chọn Sản Phẩm Mua ");
                    String sp=inputString.nextLine();


            }
        }while (choice!=0);
    }

}
