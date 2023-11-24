package models;

import java.util.Date;

public class Computer {
    private int id ;
    private double price;
    private Customer customer=null;
    private boolean isRunning;
    private Date startTime;
    private Date endTime;

    public Computer(int id, double price, Customer customer, boolean isRunning, Date startTime, Date endTime) {
        this.id = id;
        this.price = price;
        this.customer = null;
        this.isRunning = false;
        this.startTime = null;
        this.endTime = null;
    }

    public boolean isRunning() {
        return isRunning;
    }

    public Date setRunning(boolean running) {
        if (this.customer!=null){
        isRunning = true;
        }
        return null;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
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

    @Override
    public String toString() {
        return "Computer " +
                "ID : " + id +"\n"+
                "Giá Tiền : " + price +"\n";
    }
}
