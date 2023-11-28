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
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            String str = "ID, Tên Sản Phẩm , Giá Tiền,Số Lượng\n";
            for (Service s : services) {
                str += s.getId() + "," + s.getNameProduct() + "," + s.getPrice() + "," + s.getQuantity() + "\n";
            }
            bufferedWriter.write(str);
            bufferedWriter.close();
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
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String contenn = bufferedReader.readLine();
            while (null != (contenn = bufferedReader.readLine())) {
                String[] value = contenn.split(",");
                String name = value[1];
                Double money = Double.parseDouble(value[2]);
                int quantily = Integer.parseInt(value[3]);
                listServices.add(new Service(name, money, quantily));
            }
            bufferedReader.close();
            fileReader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return listServices;
    }
}
