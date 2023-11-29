package services;

import data.FileComputer;
import models.Computer;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ManagerComputer implements IManager<Computer> {
    List<Computer> computerList = new ArrayList<>();
    Date currentTime = new Date();

    public ManagerComputer() {
        computerList = FileComputer.readFromFile("D:\\CodeGym_M2\\Case_MD2_NETCO\\src\\data\\dataComputer.csv");
    }


    public List<Computer> getComputerList() {
        return computerList;
    }

    public void setComputerList(List<Computer> computerList) {
        this.computerList = computerList;
    }

    @Override
    public void add(Computer computer) {

        computerList.add(computer);
    }

    @Override
    public void edit(int n, Computer computer) {
        int index = -1;
        for (int i = 0; i < this.computerList.size(); i++) {
            if (n == this.computerList.get(i).getId()) {
                index = i;
            }
        }
        computerList.set(index, computer);
    }

    @Override
    public void delete(int n) {
        computerList.removeIf(p -> p.getId() == n);
    }

    @Override
    public Computer search(int n) {
        for (Computer p : computerList) {
            if (p.getId() == n) {
                return p;
            }
        }
        return null;
    }

    @Override
    public void showAll() {
        for (Computer p : computerList) {
            if (p.isStatus()) {
                System.out.println(" Máy Số : " + p.getId() + " Giá Tiền : " + p.getPrice() + " K/phút " + " Trạng Thái : Đã Có Người Dùng");
            } else
                System.out.println(" Máy Số : " + p.getId() + " Giá Tiền : " + p.getPrice() + " K/phút " + " Trạng Thái : Chưa Có Người Dùng");
        }
    }

    public void show() {
        computerList = FileComputer.readFromFile("D:\\CodeGym_M2\\Case_MD2_NETCO\\src\\data\\dataComputer.csv");
        for (Computer p : computerList) {
            if (!p.isStatus()) {
                System.out.println(p);
            }
        }
    }

    public boolean checkPc(int a) {
        for (Computer s : computerList) {
            if (s.getId() == a) {
                return true;
            }
        }
        return false;
    }

    public boolean turnOffComputer(int n) {
        boolean a = false;
        for (Computer s : computerList) {
            if (s.getId() == n && s.isStatus()) {
                s.setStatus(false);
                a = true;
            }
        }
        FileComputer.writeToFile("D:\\CodeGym_M2\\Case_MD2_NETCO\\src\\data\\dataComputer.csv", getComputerList());
        return a;
    }
}