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
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        String str = "ID, Tên Khách , Tên Đăng Nhập , Mật Khẩu, Số Tiền Nạp\n";
        for (Customer s : customer) {
            str +=  s.getId()+ ","+s.getName()+"," + s.getUserName()+","+s.getPassWorld()+","+s.getMoney()+ "\n";
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

    public static List<Customer> readFromFile(String path) {
        List<Customer> listCustomer = new ArrayList<>();
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
            int id=Integer.parseInt(value[0]);
            String name = value[1];
            String user = value[2];
            String pass = value[3];
            Double money = Double.parseDouble(value[4]);

            listCustomer.add(new Customer(id,name,user,pass,money));
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
        return listCustomer;
    }
}
