package models;

public class Invoice {

    private  int id;
    private int idCom;
    private String name;
    private double bill;
    private  static int a=1;

    public Invoice( int idCom, String name, double bill) {
        this.id = a;
        this.idCom = idCom;
        this.name = name;
        this.bill = bill;
        a++;
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

    public double getBill() {
        return bill;
    }

    public void setBill(double bill) {
        this.bill = bill;
    }
}
