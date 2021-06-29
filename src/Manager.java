import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Manager {
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<NhanVien> list = read();

    //    static {
//        try {
//            list = read();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//    }
    public static void save() throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("nhanVien.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fileOutputStream);
        oos.writeObject(list);
    }

    public static ArrayList<NhanVien> read() {
        ArrayList<NhanVien> list = new ArrayList<>();
        try {
            FileInputStream fileInputStream = new FileInputStream("nhanVien.txt");
            ObjectInputStream ois = new ObjectInputStream(fileInputStream);
            list = (ArrayList<NhanVien>) ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }


    public static NhanVien create(String typeNV) {
        System.out.println("Nhap name");
        String name = scanner.nextLine();
        System.out.println("Nhap age");
        int age;
        while (true) {
            try {
                age = Integer.parseInt(scanner.nextLine());
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
                gender = scanner.nextLine();
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
        String phone = scanner.nextLine();
        System.out.println("Nhap email");
        String email;
        while (true) {
            try {
                email = scanner.nextLine();
                for (NhanVien nhanVien : list) {
                    if (nhanVien.getEmail().equals(email)) {
                        throw new DaCoEmail();
                    }
                }
                break;
            } catch (Exception E) {
                System.out.println("Bi trung .Nhap Lai");
            }
        }
        System.out.println("Nhap luong");
        float luong;
        while (true) {
            try {
                luong = Float.parseFloat(scanner.next());
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


    public static void add() throws IOException {
        System.out.println("1.Them NV Dao Tao");
        System.out.println("2.Them NV tuyen sinh");
        int choose = Integer.parseInt(scanner.nextLine());
        switch (choose) {
            case 1:
                System.out.println("1.Them NV FullTime");
                System.out.println("2.Them NV Parttime");
                int chooseNVFullPart = Integer.parseInt(scanner.nextLine());
                switch (chooseNVFullPart) {
                    case 1:
                        list.add(create("FullTime"));
                        save();
                        break;
                    case 2:
                        list.add(create("PartTime"));
                        save();
                        break;

                }
                break;
            case 2:
                list.add(create("NVTuyenSinh"));
                save();
                break;
        }
    }

    public static void remove() throws IOException, ClassNotFoundException {

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
                save();
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
                save();
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

    public static void Sort() throws IOException {
        SortByName sortByName = new SortByName();
        list.sort(sortByName);
        save();
    }

    public static void show() {
        for (NhanVien s : list) {
            System.out.println(s);
        }
    }

}
