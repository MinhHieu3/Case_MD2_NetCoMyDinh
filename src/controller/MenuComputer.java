package controller;

import data.FileComputer;
import models.Computer;
import services.InputOutput;
import services.ManagerComputer;

public class MenuComputer {
    ManagerComputer managerComputer = new ManagerComputer();
    int choice;

    public void menuPC() {
        do {
            System.out.println("┌———————————————————————————————————┐");
            System.out.println("⎟          QUẢN LÝ MÁY TÍNH         ⎟");
            System.out.println("⎟———————————————————————————————————⎟");
            System.out.println("⎟1.Thêm Máy Mới                     ⎟");
            System.out.println("⎟2.Sửa Thông Tin Máy                ⎟");
            System.out.println("⎟3.Xóa Máy Hỏng                     ⎟");
            System.out.println("⎟4.Tìm Kiếm                         ⎟");
            System.out.println("⎟5.Danh Sách Máy Trống              ⎟");
            System.out.println("⎟6.Danh Sách Máy                    ⎟");
            System.out.println("⎟7.Tắt Máy Theo ID                  ⎟");
            System.out.println("⎟0. Quay lại                        ⎟");
            System.out.println("└———————————————————————————————————┘");
            System.out.println("Nhập lựa chọn :");
            choice = InputOutput.checkInputInt();
            switch (choice) {
                case 1:
                    System.out.println("   Nhập Thông Tin Máy Mới   ");
                    System.out.println("----------------------------");
                    System.out.println("Nhập ID Máy ");
                    int id = InputOutput.checkInputInt();
                    System.out.println("Nhập Giá Tiền");
                    double price = InputOutput.checkInputInt();
                    Computer computer = new Computer(id, price);
                    managerComputer.add(computer);
                    System.out.println("----------------------");
                    System.out.println("  Đã Tạo Thành Công ");
                    FileComputer.writeToFile("D:\\CodeGym_M2\\Case_MD2_NETCO\\src\\data\\dataComputer.csv", managerComputer.getComputerList());
                    break;
                case 2:
                    managerComputer.showAll();
                    System.out.println("Nhập ID Máy Muốn Sửa ");
                    int idComEdit = InputOutput.checkInputInt();
                    System.out.println("Nhập ID Máy ");
                    int idCom = InputOutput.checkInputInt();
                    System.out.println("Nhập Giá Tiền");
                    double prices = InputOutput.checkInputInt();
                    Computer computers = new Computer(idCom, prices);
                    managerComputer.edit(idComEdit, computers);
                    System.out.println("----------------------");
                    System.out.println("  Đã Sửa Thành Công ");
                    FileComputer.writeToFile("D:\\CodeGym_M2\\Case_MD2_NETCO\\src\\data\\dataComputer.csv", managerComputer.getComputerList());
                    break;
                case 3:
                    managerComputer.showAll();
                    System.out.println("Nhập ID Máy Muốn Xóa");
                    int idComDelete = InputOutput.checkInputInt();
                    managerComputer.delete(idComDelete);
                    System.out.println("----------------------");
                    System.out.println("  Đã Xóa Thành Công ");
                    FileComputer.writeToFile("D:\\CodeGym_M2\\Case_MD2_NETCO\\src\\data\\dataComputer.csv", managerComputer.getComputerList());
                    break;
                case 4:
                    System.out.println("Nhập ID Máy Muốn Tìm");
                    int idSearch = InputOutput.checkInputInt();
                    System.out.println(managerComputer.search(idSearch));
                    break;
                case 5:
                    managerComputer.show();
                    break;
                case 6:
                    managerComputer.showAll();
                    break;
                case 7:
                    managerComputer.showAll();
                    System.out.println("Nhập Vào ID Máy Muốn Tắt");
                    int idComOff = InputOutput.checkInputInt();
                    if (managerComputer.turnOffComputer(idComOff)) {
                        System.out.println(" Đã Tắt Thành Công ");
                        System.out.println("-------------------");
                    } else {
                        System.out.println("Máy Không Có Trong Hệ Thống Hoặc Đã Tắt");
                    }
                    break;

            }
        } while (choice != 0);
    }
}
