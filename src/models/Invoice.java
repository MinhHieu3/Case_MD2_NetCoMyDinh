package models;

import data.FileSevices;

import java.util.ArrayList;
import java.util.List;

public class Invoice {
    List<Service> services;
    List<Service>list=new ArrayList<>();
    public Invoice() {
        services = FileSevices.readFromFile("dataServices.csv");
    }

    public List<Service> getServices() {
        return services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }
    public void purchase(String nameProduct,int n){

        for (Service s:services) {
            if (s.getNameProduct().equals(nameProduct)&&s.getQuantity()>n){
                double a=n*s.getPrice();
            }
        }

    }
}
