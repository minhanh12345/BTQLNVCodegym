import java.util.ArrayList;
import java.util.Scanner;

public class Manager {
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<NhanVien> list = new ArrayList<>();


    public static NhanVien create(String typeNV) {
        System.out.println("Nhap name");
        String name = scanner.next();
        System.out.println("Nhap age");
        int age;
        while (true) {
            try {
                age =Integer.parseInt( scanner.next());
                if (age > 18) {
                    break;
                } else {
                    throw new Exception();
                }
            } catch (Exception AgeEX) {
                System.out.println("Age >18");
                System.out.println("Nhap lai");

            }
        }

        System.out.println("Nhap gender");
        String gender;
        while (true) {
            try {
                gender = scanner.next();
                if (gender.equals("nam") || gender.equals("nu")) {
                    break;
                } else {
                    throw new Exception();
                }
            } catch (Exception A) {
                System.out.println("Phai la nam or nu");
                System.out.println("Nhap lai");
            }

        }
        System.out.println("Nhap phone");
        String phone = scanner.next();
        System.out.println("Nhap email");
        String email ;
        while (true){
            try {
                email=scanner.next();
                boolean check=true;
                for (int i=0;i<list.size();i++){
                    if(list.get(i).getEmail().equals(email)){check=false;
                        throw new Exception();
                    }
                }
                if(check){break;}
            }catch (Exception E){
                System.out.println("Bi trung .Nhap Lai");
            }
        }
        System.out.println("Nhap luong");
        float luong;
        while (true) {
            try {
                luong =  Float.parseFloat(scanner.next());
                break;
            } catch (Exception E) {
                System.out.println("Nhap lai");
            }
        }
        if (typeNV == "PartTime") {
            System.out.println("Nhap timeWork");
            int timeWork = scanner.nextInt();
            System.out.println("nhap nganh");
            String nganhPart = scanner.next();
            return new NVPartTime(name, age, gender, phone, email, luong, nganhPart, timeWork);
        } else if (typeNV == "FullTime") {
            System.out.println("nhap nganh");
            String nganhFull = scanner.next();
            return new NVFullTime(name, age, gender, phone, email, luong, nganhFull);
        } else {
            System.out.println("Nhap number");
            int number = scanner.nextInt();
            return new NVTuyenSinh(name, age, gender, phone, email, luong, number);
        }

    }

    public static void add() {
        System.out.println("1.Them NV Dao Tao");
        System.out.println("2.Them NV tuyen sinh");
        int choose = scanner.nextInt();
        switch (choose) {
            case 1:
                System.out.println("1.Them NV FullTime");
                System.out.println("2.Them NV Parttime");
                int chooseNVFullPart = scanner.nextInt();
                switch (chooseNVFullPart) {
                    case 1:
                        list.add(create("FullTime"));
                        break;
                    case 2:
                        list.add(create("PartTime"));
                        break;

                }
                break;
            case 2:
                list.add(create("NVTuyenSinh"));
                break;
        }
    }

    public static void remove() {
        System.out.println("1.Nhan vien Dao tao");
        System.out.println("2.Nhan vien Tuyen Sinh");
        int choose = scanner.nextInt();
        switch (choose) {
            case 1:
                System.out.println("Nhap ten");
                String name1 = scanner.next();
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i) instanceof NhanVienDaoTao) {
                        if (list.get(i).getName().equals(name1)) {
                            list.remove(i);
                            i--;
                        }
                    }
                }
                break;
            case 2:
                System.out.println("Nhap ten");
                String name2 = scanner.next();
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i) instanceof NVTuyenSinh) {
                        if (list.get(i).getName().equals(name2)) {
                            list.remove(i);
                            i--;
                        }
                    }
                }
                break;

        }
    }

    public static void showLuongByName() {
        System.out.println("Nhap name");
        String name = scanner.next();
        int check = -1;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getName().equals(name)) {
                check = i;
            }
        }
        if (check < 0) {
            System.out.println("ko co");
        } else {
            System.out.println("luong cua " + name + " : " + list.get(check).getLuong());
        }
    }

    public static void findByName() {
        System.out.println("Nhap Name");
        String name = scanner.next();
        int check = -1;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getName().equals(name)) {
                check = i;
            }
        }
        if (check < 0) {
            System.out.println("ko co");
        } else {
            System.out.println(list.get(check));
        }

    }

    public static void Sort() {
        SortByName sortByName = new SortByName();
        list.sort(sortByName);
    }

    public static void show() {
        for (NhanVien s : list) {
            System.out.println(s);
        }
    }

}
