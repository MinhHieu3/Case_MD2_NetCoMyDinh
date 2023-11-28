package data;

import models.Customer;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileCustomer {
    public static void writeToFile(String path, List<Customer> customer) {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(path);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            String str = "ID, Tên Khách , Tên Đăng Nhập , Mật Khẩu, Số Tiền Nạp\n";
            for (Customer s : customer) {
                str += s.getId() + "," + s.getName() + "," + s.getUserName() + "," + s.getPassWorld() + "," + s.getMoney() + "\n";
            }
            bufferedWriter.write(str);
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Customer> readFromFile(String path) {
        List<Customer> listCustomer = new ArrayList<>();
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(path);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String contenn = bufferedReader.readLine();
        while (null != (contenn = bufferedReader.readLine())){
            String[] value = contenn.split(",");
            int id = Integer.parseInt(value[0]);
            String name = value[1];
            String user = value[2];
            String pass = value[3];
            Double money = Double.parseDouble(value[4]);
            listCustomer.add(new Customer(id, name, user, pass, money));
        }
            bufferedReader.close();
            fileReader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return listCustomer;
    }
}
