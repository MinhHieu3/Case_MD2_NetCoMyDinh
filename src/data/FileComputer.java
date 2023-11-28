package data;

import models.Computer;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileComputer {
    public static void writeToFile(String path, List<Computer> computers) {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        String str = "ID Máy, Giá Tiền Của Máy, Trạng Thái Người Dùng\n";
        for (Computer s : computers) {
            str +=  s.getId()+ ","+s.getPrice()+","+s.isStatus()+ "\n";
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

    public static List<Computer> readFromFile(String path) {
        List<Computer> list = new ArrayList<>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
            String content = bufferedReader.readLine();
            while ((content = bufferedReader.readLine()) != null) {
                String[] value = content.split(",");
                int id = Integer.parseInt(value[0]);
                double price = Double.parseDouble(value[1]);
                boolean status = Boolean.parseBoolean(value[2]);
                Computer computer = new Computer(id, price);
                computer.setStatus(status);
                list.add(computer);
            }
            bufferedReader.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }
}
