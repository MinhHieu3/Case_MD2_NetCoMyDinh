package controller;

import data.FileRevenue;
import services.InputOutput;
import services.ManagerRevenue;
public class MenuRevenue {
    ManagerRevenue managerRevenue = new ManagerRevenue();
    int choice;

    public void menuRevenue() {
        do {
            System.out.println("┌———————————————————————————————————┐");
            System.out.println("⎟          QUẢN LÝ DOANH SỐ         ⎟");
            System.out.println("⎟———————————————————————————————————⎟");
            System.out.println("⎟1.Hiển Thị Danh Sách Hóa Đơn       ⎟");
            System.out.println("⎟2.Xóa Hóa Đơn                      ⎟");
            System.out.println("⎟3.Tìm Kiếm                         ⎟");
            System.out.println("⎟4.Tổng Doanh Thu                   ⎟");
            System.out.println("⎟0. Quay lại                        ⎟");
            System.out.println("└———————————————————————————————————┘");
            System.out.println("Nhập lựa chọn :");
            choice = InputOutput.checkInputInt();
            switch (choice) {
                case 1:
                    managerRevenue.showAll();
                    break;
                case 2:
                    System.out.println("Nhập ID Máy Muốn Xóa");
                    int ida = InputOutput.checkInputInt();
                    managerRevenue.delete(ida);
                    System.out.println("----------------------");
                    System.out.println("  Đã Xóa Thành Công ");
                    FileRevenue.writeToFile("dataInvoice.csv",managerRevenue.getRevenueList());
                    break;
                case 3:
                    System.out.println("Nhập ID Máy Muốn Tìm");
                    int idSearch = InputOutput.checkInputInt();
                    System.out.println(managerRevenue.search(idSearch));
                    break;
                case 4:
                    managerRevenue.showAll();
                    System.out.println("Tổng Doanh Thu Là : " +managerRevenue.showBill());
                    break;

            }
        } while (choice != 0);
    }
}
