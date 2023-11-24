package controller;

import data.FileComputer;
import data.FileCustomer;
import models.Computer;
import models.Customer;
import services.InputOutput;
import services.ManagerComputer;

import java.util.Scanner;

public class MenuPC {
    ManagerComputer managerComputer=new ManagerComputer();
    Scanner inputString = new Scanner(System.in);
    int choice;

    public void menuPC(){
        do {
            System.out.println("┌———————————————————————————————————┐");
            System.out.println("⎟          QUẢN LÝ MÁY TÍNH         ⎟");
            System.out.println("⎟———————————————————————————————————⎟");
            System.out.println("⎟1.Thêm Máy Mới                     ⎟");
            System.out.println("⎟2.Sửa Thông Tin Máy                ⎟");
            System.out.println("⎟3.Xóa Máy Hỏng                     ⎟");
            System.out.println("⎟4.Tìm Kiếm                         ⎟");
            System.out.println("⎟5.Danh Sách Máy Trống              ⎟");
            System.out.println("⎟4.Danh Sách Máy                    ⎟");
            System.out.println("⎟0. Quay lại                        ⎟");
            System.out.println("└———————————————————————————————————┘");
            System.out.println("Nhập lựa chọn :");
            choice = InputOutput.checkInputInt();
            switch (choice) {
                case 1:
                    System.out.println("Nhập ID Máy ");
                    int id=InputOutput.checkInputInt();
                    System.out.println("Nhập Giá Tiền");
                    double price =InputOutput.checkInputInt();
                    Computer computer=new Computer(id,price);
                    managerComputer.add(computer);
                    FileComputer.writeToFile("dataPc.csv",managerComputer.getComputerList());
                    break;
                case 2:
                    managerComputer.showAll();
                    System.out.println("Nhập ID Máy Muốn Sửa ");
                    int idds=InputOutput.checkInputInt();
                    System.out.println("Nhập ID Máy ");
                    int idd=InputOutput.checkInputInt();
                    System.out.println("Nhập Giá Tiền");
                    double prices =InputOutput.checkInputInt();
                    Computer computers=new Computer(idd,prices);
                    managerComputer.edit(idds,computers);
                    FileComputer.writeToFile("dataPc.csv",managerComputer.getComputerList());
                    break;
                case 3:
                    System.out.println("Nhập ID Máy Muốn Xóa");
                    int ida=InputOutput.checkInputInt();
                    managerComputer.delete(ida);
                    FileComputer.writeToFile("dataPc.csv",managerComputer.getComputerList());
                    break;
                case 4:
                    System.out.println("Nhập ID Máy Muốn Tìm");
                    int idSearch=InputOutput.checkInputInt();
                    System.out.println(managerComputer.search(idSearch));
                    break;
                case 5:
                    managerComputer.show();
                    break;
                case 6:
                    managerComputer.showAll();
                    break;
            }
        } while (choice != 0);
    }
}
