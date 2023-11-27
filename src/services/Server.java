package services;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

        public static void sever(){
            int portNumber = 2001;
            boolean check = true;
            try (ServerSocket serverSocket = new ServerSocket(portNumber)) {
                System.out.println("Chat với Như Anh " );
                System.out.println("-------------------");

                while (check) {
                    try (Socket clientSocket = serverSocket.accept();
                         InputStream input = clientSocket.getInputStream();
                         OutputStream output = clientSocket.getOutputStream()) {
                        System.out.println("Như Anh  đã kết nối!!! ");

                        new Thread(() -> {
                            Scanner scanner = new Scanner(input);
                            while (scanner.hasNextLine()) {
                                String clientMessage = scanner.nextLine();
                                System.out.println("Như Anh : " + clientMessage);
                            }
                        }).start();

                        Scanner consoleScanner = new Scanner(System.in);
                        while (check) {
                            String serverMessage = consoleScanner.nextLine();
                            if(serverMessage.equals("quit")){
                                check = false;

                            }
                            output.write((serverMessage + "\n").getBytes());
                        }

                    } catch (IOException e) {
                        System.out.println("Như Anh Chưa Kết Nối");
                    }
                }
            } catch (IOException e) {
                System.out.println("Như Anh Chưa Kết Nối");
            }
        }




        public static void client(){
            String serverAddress = "localhost";
            int serverPort = 2001;

            try (Socket socket = new Socket(serverAddress, serverPort);
                 InputStream input = socket.getInputStream();
                 OutputStream output = socket.getOutputStream()) {
                new Thread(() -> {
                    Scanner scanner = new Scanner(input);
                    while (scanner.hasNextLine()) {
                        String serverMessage = scanner.nextLine();
                        if(!serverMessage.equals("quit")){
                            System.out.println("Như Anh : " + serverMessage);
                        }
                    }
                }).start();

                Scanner consoleScanner = new Scanner(System.in);
                System.out.println("Chat với Admin\n" +
                        "(Nhập 'bye' để thoát.)");
                while (true) {
                    String clientMessage = consoleScanner.nextLine();
                    if(clientMessage.equals("bye")){
                        break;
                    }
                    output.write((clientMessage + "\n").getBytes());
                }

            } catch (IOException e) {
                System.out.println("Sever đang không có người trực. Mời ra quầy!!!");
            }
        }


}
