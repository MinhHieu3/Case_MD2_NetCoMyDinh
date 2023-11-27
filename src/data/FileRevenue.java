package data;

import models.Computer;
import models.Revenue;

import java.io.*;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class FileRevenue {
    public static void writeToFile(String path, List<Revenue> revenues) {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        String str = "ID Hóa Đơn ,ID Máy , Tên Người Chơi ,Số Tiền,Thời Gian Thanh Toán \n";
        for (Revenue s : revenues) {
            str +=  s.getId()+ "," +s.getIdCom()+","+s.getName()+","+s.getMoney()+","+s.getTime()+"\n";
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

    public static List<Revenue> readFromFile(String path) {
        List<Revenue> listRevenue = new ArrayList<>();
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
            int IDcomputer=Integer.parseInt( value[1]);
            String name=value[2];
            Double price=Double.parseDouble(value[3]);
            LocalDateTime time= LocalDateTime.parse(value[4]);
            listRevenue.add(new Revenue(IDcomputer,name,price,time));

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
        return listRevenue;
    }
}
