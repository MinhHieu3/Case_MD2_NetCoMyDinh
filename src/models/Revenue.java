package models;

import java.time.LocalDateTime;
import java.time.LocalTime;

//Doanh Thu
public class Revenue {
    private int id;
    private int idCom;
    private String name;

    private double money;
    LocalDateTime time;
    private static int ids = 1;

    public Revenue(int idCom, String name, double money, LocalDateTime time) {
        this.id = ids;
        this.idCom = idCom;
        this.name = name;

        this.money = money;
        this.time = time;
        ids++;
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

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Hóa Đơn : " + id + "\n" +
                "ID Máy Tính : " + idCom + "\n" +
                "Tên Khách : " + name + "\n" +
                "Tổng Tiền : " + money + "\n" +
                "Thời Gian Mua " + time + "\n";
    }
}
