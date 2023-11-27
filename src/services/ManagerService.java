package services;

import data.FileSevices;
import models.Customer;
import models.Service;

import java.util.ArrayList;
import java.util.List;

public class ManagerService implements IManager<Service>{
    List<Service>serviceList=new ArrayList<>();

    public ManagerService() {
       serviceList = FileSevices.readFromFile("D:\\CodeGym_M2\\Case_MD2_NETCO\\src\\data\\dataServices.csv");
    }

    @Override
    public void add(Service add) {
            serviceList.add(add);
    }

    public List<Service> getServiceList() {
        return serviceList;
    }

    public void setServiceList(List<Service> serviceList) {
        this.serviceList = serviceList;
    }

    @Override
    public void edit(int n, Service service) {
        int index=-1;
        for (int i = 0; i < this.serviceList.size(); i++) {
            if (n==this.serviceList.get(i).getId()){
                index=i;
            }
        }
        serviceList.set(index,service);
    }

    @Override
    public void delete(int n) {
        for (Service p:serviceList) {
            if (p.getId()==n){
                serviceList.remove(p);
            }
        }
    }

    @Override
    public Service search(int n) {
        for (Service p:serviceList) {
            if (p.getId()==n){
                return p;
            }
        }
        return null;
    }

    @Override
    public void showAll() {
        for (Service p:serviceList) {
            System.out.println(p);
        }

    }
    public void show(){
        for (Service p:serviceList) {
            if(p.getQuantity()>0){
                System.out.println(p);
            }
        }
    }
    public void   buy(String name ,int n){
        for (Service p:serviceList) {
            if(p.getQuantity()>0&&p.getNameProduct().equals(name)&&p.getQuantity()>n){
                System.out.println( p.getPrice()*n);
            }
        }
    }
}
