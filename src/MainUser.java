import controller.MenuUser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class MainUser {
    public static void main(String[] args) {
        int port = 8081;
        try {
            Socket socket = new Socket("localhost", port);
            System.out.println("Đã Kê Nối Thành Công ");
//            MenuUser menuUser = new MenuUser();
//            menuUser.showMenuUser();
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter writer = new PrintWriter(socket.getOutputStream());
                Scanner sc = new Scanner(System.in);
                String message;
                System.out.println("Server");
                while (true) {
                    //gửi
                    System.out.println("Chat với máy chủ");
                    message = sc.nextLine();
                    writer.println(message);
                    writer.flush();
// Nhận tin
                    message = reader.readLine();
                    System.out.println("Server" + message);

                }

            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        } catch (IOException e) {
            System.out.println("Không thể kết nối");
        }
    }
}
