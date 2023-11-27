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
        computerList = FileComputer.readFromFile("D:\\CodeGym_M2\\Case_MD2_NETCO\\src\\data\\dataPc.csv");
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
            System.out.println(p);
        }
    }

    public void show() {
        for (Computer p : computerList) {
            if (p.getCustomer() == null) {
                System.out.println(p);
            }
        }
    }
    public boolean checkPc(int a){
        for (Computer s:computerList) {
            if (s.getId()==a){
                return true;
            }
        }
        return false;
    }
}