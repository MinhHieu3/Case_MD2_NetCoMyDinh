package models;

public class Computer {
    private int id;
    private double price;
    private double payment;
    private boolean status;

    public Computer(int id, double price) {
        this.id = id;
        this.price = price;
        this.status = false;
    }

    public double getPayment() {
        return payment;
    }

    public double setPayment(double payment) {
        this.payment = payment;
        return payment;
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


    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;

    }


    @Override
    public String toString() {
        return "Computer " +
                "ID : " + id + "\n" +
                "Giá Tiền : " + price + "\n" +
                "Trạng Thái Người Dùng : " + status + "\n";
    }
}
