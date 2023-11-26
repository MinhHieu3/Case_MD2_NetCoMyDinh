import controller.Menu;
import controller.MenuCustomer;
import controller.Server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int port = 8081;
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            //chấp nhận nhiều kết nối
            while (true) {
                Socket clienSocket = serverSocket.accept();
                Server sv=new Server(clienSocket);
                sv.start();
////                Menu menu = new Menu();
////                menu.showMenu();

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

}