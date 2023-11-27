package services;

import data.FileRevenue;
import models.Revenue;

import java.util.ArrayList;
import java.util.List;

public class ManagerRevenue implements IManager<Revenue>{
    List<Revenue>revenueList=new ArrayList<>();

    public ManagerRevenue() {
        this.revenueList = FileRevenue.readFromFile("D:\\CodeGym_M2\\Case_MD2_NETCO\\src\\data\\dataRevenue.csv");
    }

    public List<Revenue> getRevenueList() {
        return revenueList;
    }

    public void setRevenueList(List<Revenue> revenueList) {
        this.revenueList = revenueList;
    }

    @Override
    public void add(Revenue add) {
            revenueList.add(add);


    }

    @Override
    public void edit(int n, Revenue revenue) {
        int index=-1;
        for (int i = 0; i < this.revenueList.size(); i++) {
            if (n==this.revenueList.get(i).getId()){
                index=i;
            }
        }
        revenueList.set(index,revenue);
    }

    @Override
    public void delete(int n) {
        revenueList.removeIf(p -> p.getId() == n);

    }

    @Override
    public Revenue search(int n) {
        for (Revenue p:revenueList) {
            if (p.getId()==n){
                return p;
            }
        }
        return null;
    }

    @Override
    public void showAll() {
        for (Revenue p:revenueList) {
            System.out.println(p);
        }
    }

}
