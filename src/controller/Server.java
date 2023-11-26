package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Server extends Thread{
    private Socket socket;

    public Server(Socket socket) {
        this.socket = socket;
    }
    @Override
    public void run() {
        try {
            BufferedReader reader=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writer=new PrintWriter(socket.getOutputStream());
            Scanner sc=new Scanner(System.in);
            String message;
            while (true){
                //Nhận tin Nhắn
                message=reader.readLine();
                    System.out.println("Client "+message);

                //gửi tin nhắn
                System.out.println("Server");
                message=sc.nextLine();
                writer.println(message);
                writer.flush();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
