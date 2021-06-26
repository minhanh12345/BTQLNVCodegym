import java.util.Scanner;

public class Main {
    public static void main(String[] args)  {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1.Them NV");
            System.out.println("2.Xoa NV");
            System.out.println("3.Hien thi luong theo name");
            System.out.println("4.Tim Kiem NV theo name");
            System.out.println("5.Sap xep theo ten");
            System.out.println("6.Show");
            System.out.println("7.Exit");
            int choose = scanner.nextInt();
            switch (choose) {
                case 1:
                    Manager.add();
                    break;
                case 2:
                    Manager.remove();
                    break;
                case 3:
                    Manager.showLuongByName();
                    break;
                case 4:
                    Manager.findByName();
                    break;
                case 5:
                    Manager.Sort();
                    break;
                case 6:
                    Manager.show();
                    break;
                case 7:
                    System.exit(0);

            }
        }
    }
}
