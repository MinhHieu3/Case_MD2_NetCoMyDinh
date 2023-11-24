package models;

import java.util.Date;

public class Computer {
    private int id ;
    private double price;
    private Customer customer=null;

    public Computer(int id, double price) {
        this.id = id;
        this.price = price;
        this.customer = null;

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }


    @Override
    public String toString() {
        return "Computer " +
                "ID : " + id +"\n"+
                "Giá Tiền : " + price +"\n";
    }
}
