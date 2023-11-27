package services;

import data.FileComputer;
import data.FileCustomer;
import models.Computer;
import models.Customer;


import java.util.ArrayList;
import java.util.List;

public class ManagerCustomer implements IManager<Customer> {
    List<Customer> customerList = new ArrayList<>();
    Computer computer;

    public ManagerCustomer() {
        customerList = FileCustomer.readFromFile("D:\\CodeGym_M2\\Case_MD2_NETCO\\src\\data\\dataCustomer.csv");

    }

    @Override
    public void add(Customer add) {
        customerList.add(add);

    }

    public List<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }

    @Override
    public void edit(int n, Customer customer) {
        int index = -1;
        for (int i = 0; i < this.customerList.size(); i++) {
            if (n == this.customerList.get(i).getId()) {
                index = i;
            }
        }
        customerList.set(index, customer);
    }

    @Override
    public void delete(int n) {
        customerList.removeIf(p -> p.getId() == n);
    }

    @Override
    public Customer search(int n) {
        for (Customer p : customerList) {
            if (p.getId() == n) {
                return p;
            }
        }
        return null;
    }
    public Customer search2(String user ,String pass) {
        for (Customer p : customerList) {
            if (p.getUserName().equals(user)&&p.getPassWorld().equals(pass)) {
                return p;
            }
        }
        return null;
    }

    @Override
    public void showAll() {
        for (Customer p : customerList) {
            System.out.println(p);
        }
    }

    public void showMoney() {
        for (Customer s : customerList) {
            if (s.getMoney() > 0) {
                System.out.println(s);
            }
        }
    }
    public boolean check(String user,String pass) {
        for (Customer p : customerList) {
            if (p.getUserName().equals(user) && p.getPassWorld().equals(pass)) {
                System.out.println(" Đăng nhập Thành Công ");
                System.out.println("----------------------");
                if(p.getMoney()==0){
                    System.out.println("Số Dư Tài Khoản Không Đủ ");
                }else {
                    System.out.println("  Máy Đang Được Sử Dụng  ");
                }
                return true;

            }
        }
    return false;
    }
    //Kiểm tra tài khoản
    public void checkTk(String user){
        for (Customer p : customerList) {
            if (p.getUserName().equals(user) ) {
                System.out.println("-----------------------------------");
                System.out.println("Số Dư Tài Khoản Là : "+ p.getMoney());
            }
        }

    }



}
