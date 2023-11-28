package controller;

import services.InputOutput;
import services.Server;

public class Menu {

    MenuCustomer menuStore = new MenuCustomer();
    MenuService menuService = new MenuService();
    MenuRevenue menuRevenue = new MenuRevenue();
    MenuComputer menuPC = new MenuComputer();
    int choice;


    public void showMenu() {
        do {
            System.out.println("┌———————————————————————————————————┐");
            System.out.println("⎟               QUẢN LÝ             ⎟");
            System.out.println("⎟———————————————————————————————————⎟");
            System.out.println("⎟1.Quản Lý Khách Hàng               ⎟");
            System.out.println("⎟2.Quản Lý Máy                      ⎟");
            System.out.println("⎟3.Quản Lý Dịch Vụ                  ⎟");
            System.out.println("⎟4.Quản Lý Doanh Thu                ⎟");
            System.out.println("⎟5.Lắng Nghe Đào Như Anh Lói        ⎟");
            System.out.println("└———————————————————————————————————┘");
            System.out.println("Nhập lựa chọn :");
            choice = InputOutput.checkInputInt();
            switch (choice) {
                case 1:
                    menuStore.menuCustormer();
                    break;
                case 2:
                    menuPC.menuPC();
                    break;
                case 3:
                    menuService.menuService();
                    break;
                case 4:
                    menuRevenue.menuRevenue();
                    break;
                case 5:
//                    boolean check=true;
//                    int port = 8081;
//                    try {
//                        System.out.println("Nói Đi Những Anh Khách Khó Tính "+"\n"+"Muốn Thoát Hãy Gõ  : " + " quit");
//                        ServerSocket serverSocket = new ServerSocket(port);
//                        Socket clienSocket = serverSocket.accept();
//                        BufferedReader reader = new BufferedReader(new InputStreamReader(clienSocket.getInputStream()));
//                        PrintWriter writer = new PrintWriter(clienSocket.getOutputStream());
//                        Scanner sc = new Scanner(System.in);
//                        String message;
//                        while (check) {
//                            //Nhận tin Nhắn
//                            message = reader.readLine();
//                            System.out.println("Khách Hàng :  " + message);
//                            System.out.println("Trả Lời Khách Hàng : ");
//                            message = sc.nextLine();
//                            if (message.equals("quit")) {
//                                check=false;
//                            }
//                            writer.println(message);
//                            writer.flush();
//                        }
//                    } catch (IOException e) {
//                        System.out.println("Lỗi Máy Chủ ");
//                    }
                    Server.sever();
            }
        }
        while (choice != 0);

    }
}
