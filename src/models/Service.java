package models;

public class Service {
    private int id;
    private String nameProduct;
    private double price;
    private int quantity;
    private static int ids=0;

    public Service(String nameProduct, double price,int quantity) {
        this.id = ids;
        this.nameProduct = nameProduct;
        this.price = price;
        this.quantity=quantity;
        ids++;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getIds() {
        return ids;
    }

    public void setIds(int ids) {
        this.ids = ids;
    }

    @Override
    public String toString() {
        return "Mã Sản Phẩm  : " + id +'\n'+
                "Tên Sản Phẩm : " + nameProduct + '\n' +
                "Giá Tiền : " + price +"\n"+
                "Số LƯợng: " + quantity +"\n";
    }
}
