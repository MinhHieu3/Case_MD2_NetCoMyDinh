package models;
//Khách Hàng
public class Customer {
    private int id;
    private String name;
    private String userName;
    private String passWorld;
    private double money;
//    final String mk="admin";
//    final String ps="admin";
//
//    public String getMk() {
//        return mk;
//    }
//
//    public String getPs() {
//        return ps;
//    }

    public Customer(int id, String name, String userName, String passWorld, double money) {
        this.id = id;
        this.name = name;
        this.userName = userName;
        this.passWorld = passWorld;
        this.money = money;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWorld() {
        return passWorld;
    }

    public void setPassWorld(String passWorld) {
        this.passWorld = passWorld;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Người Chơi \n" +
                "ID : " + id + '\n'+
                "Tên Người Chơi : " + name +'\n'+
                "Số Tiền Nạp "+money+ "\n" ;
    }
}
