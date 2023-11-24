package data;

import models.Computer;
import models.Customer;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileComputer {

    public static void writeToFile(String path, List<Computer> computer) {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        String str = "ID, Giá Tiền\n";
        for (Computer s : computer) {
            str +=  s.getId()+ "," + s.getPrice()+"\n";
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
        List<Computer> listComputer = new ArrayList<>();
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
            double price=Double.parseDouble(value[1]);
            listComputer.add(new Computer(id,price));
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
        return listComputer;
    }
}
