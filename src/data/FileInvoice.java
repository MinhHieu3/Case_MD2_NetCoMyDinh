package data;

import models.Invoice;
import models.Service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FileInvoice {
    public static void writeToFile(String path, List<Invoice> invoices) {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        String str = "ID Hóa Đơn, ID Máy , Tên Khách Hàng Chơi , Doanh Số \n";
        for (Invoice s : invoices) {
            str +=  s.getId()+ "," +s.getIdCom() + ","  + s.getName()+","  + s.getBill()+"\n";
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
}
