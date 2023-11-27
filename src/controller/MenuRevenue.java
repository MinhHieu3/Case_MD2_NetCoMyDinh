package controller;

import data.FileRevenue;
import models.Revenue;
import services.InputOutput;
import services.ManagerComputer;
import services.ManagerRevenue;

import java.time.LocalDateTime;
import java.util.Scanner;

public class MenuRevenue {
    ManagerRevenue managerRevenue = new ManagerRevenue();
    Scanner inputString = new Scanner(System.in);
    ManagerComputer managerComputer = new ManagerComputer();
    int choice;

    public void menuRevenue() {
        do {
            System.out.println("┌———————————————————————————————————┐");
            System.out.println("⎟          QUẢN LÝ DOANH SỐ         ⎟");
            System.out.println("⎟———————————————————————————————————⎟");
            System.out.println("⎟1.Hiển Thị Danh Sách Hóa Đơn       ⎟");
            System.out.println("⎟2.Sửa Thông Tin Hóa Đơn            ⎟");
            System.out.println("⎟3.Xóa Máy Hỏng                     ⎟");
            System.out.println("⎟4.Tìm Kiếm                         ⎟");
            System.out.println("⎟5.Tổng Doanh Thu                   ⎟");
            System.out.println("⎟0. Quay lại                        ⎟");
            System.out.println("└———————————————————————————————————┘");
            System.out.println("Nhập lựa chọn :");
            choice = InputOutput.checkInputInt();
            switch (choice) {
                case 1:
                    managerRevenue.showAll();
                    break;
                case 2:
                   managerRevenue.showAll();
                    System.out.println("Nhập ID Hóa Đơn  Muốn Sửa ");
                    int idds = InputOutput.checkInputInt();
                    System.out.println("Nhập ID Máy ");
                    int idd = InputOutput.checkInputInt();
                    System.out.println("Nhập Tên Khách Hàng ");
                    String name=inputString.nextLine();
                    System.out.println("Nhập Số Tiền");
                    double prices = InputOutput.checkInputInt();
                    LocalDateTime time=LocalDateTime.now();
                    Revenue revenue=new Revenue(idd,name,prices,time);
                    managerRevenue.edit(idds, revenue);
                    System.out.println("----------------------");
                    System.out.println("  Đã Sửa Thành Công ");
                    FileRevenue.writeToFile("dataInvoice.csv",managerRevenue.getRevenueList());
                    break;
                case 3:
                    System.out.println("Nhập ID Máy Muốn Xóa");
                    int ida = InputOutput.checkInputInt();
                    managerRevenue.delete(ida);
                    System.out.println("----------------------");
                    System.out.println("  Đã Xóa Thành Công ");
                    FileRevenue.writeToFile("dataInvoice.csv",managerRevenue.getRevenueList());
                    break;
                case 4:
                    System.out.println("Nhập ID Máy Muốn Tìm");
                    int idSearch = InputOutput.checkInputInt();
                    System.out.println(managerRevenue.search(idSearch));
                    break;
                case 5:
                    managerRevenue.showAll();
                    System.out.println("Tổng Doanh Thu Là : " +managerRevenue.showBill());
                    break;

            }
        } while (choice != 0);
    }
}
