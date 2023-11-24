package data;

import models.Customer;
import models.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileSevices {
    public static void writeToFile(String path, List<Service> services) {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        String str = "ID, Tên Sản Phẩm , Giá Tiền,Số Lượng\n";
        for (Service s : services) {
            str +=  s.getId()+ "," +s.getNameProduct() + ","  + s.getPrice()+","  + s.getQuantity()+"\n";
        }
        try {
            bufferedWriter.write(str);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            bufferedWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Service> readFromFile(String path) {
        List<Service> listServices = new ArrayList<>();
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(path);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String contenn = null;
        try {
            contenn = bufferedReader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        while (true) {
            try {
                if (!(null != (contenn = bufferedReader.readLine()))) break;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            String[] value = contenn.split(",");
            String name = value[1];
            Double money = Double.parseDouble(value[2]);
            int quantily=Integer.parseInt(value[3]);
            listServices.add(new Service(name,money,quantily));
        }
        try {
            bufferedReader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            fileReader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return listServices;
    }
}
