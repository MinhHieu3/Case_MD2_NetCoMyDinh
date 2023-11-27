package models;

import java.time.LocalDateTime;
import java.time.LocalTime;

//Doanh Thu
public class Revenue {
    private int id;
    private int idCom;
    private String name;
    private double money;
    private int time;
    private int quantily;
    private double price;
    private double priceCom;
    private static int ids = 1;

    public Revenue(int idCom, String name, int time,double priceCom,int quantily,double price,double money) {
        this.id = ids;
        this.idCom = idCom;
        this.name = name;
        this.time = time;
        this.priceCom=priceCom;
        this.quantily=quantily;
        this.price=price;
        this.money = money;
        ids++;
    }

    public Revenue() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCom() {
        return idCom;
    }

    public void setIdCom(int idCom) {
        this.idCom = idCom;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getQuantily() {
        return quantily;
    }

    public void setQuantily(int quantily) {
        this.quantily = quantily;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPriceCom() {
        return priceCom;
    }

    public void setPriceCom(double priceCom) {
        this.priceCom = priceCom;
    }

    @Override
    public String toString() {
        return "Hóa Đơn : " + id + "\n" +
                "ID Máy Tính : " + idCom + "\n" +
                "Tên Khách : " + name + "\n" +
                "Thời Gian Chơi :  " + time + "\n" +
                "Giá Tiền Thời Gian Chơi : " + priceCom+ "\n" +
                "Số Lượng Mua Hàng : " + quantily + "\n" +
                "Giá Tiền Sản Phẩm Mua : " + quantily + "\n" +
                "Tổng Tiền : " + money + "\n" ;
    }
}
