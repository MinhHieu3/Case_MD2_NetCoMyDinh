package services;

import models.Revenue;

import java.util.ArrayList;
import java.util.List;

public class ManagerRevenue implements IManager<Revenue>{
    List<Revenue>revenueList=new ArrayList<>();
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
