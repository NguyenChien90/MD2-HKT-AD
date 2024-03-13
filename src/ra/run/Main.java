package ra.run;

import ra.model.Singer;
import ra.model.Song;

import java.util.Date;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    private static Singer[] singers = new Singer[100];
    private static int countSinger = 5;// bien de kiem soat so luong ca sy da tao va nhap thong tin

    // taoj cac
    static {
        singers[0] = new Singer(1, "Dan Truong", 20, "Viet nam", true, "Nhac Tre, Nhac Vang");
        singers[1] = new Singer(2, "Cam LY", 218, "Viet nam", true, "Nhac cach man");
        singers[2] = new Singer(3, "Quynh Anh", 19, "Viet nam", true, "Nhac dam ma");
        singers[3] = new Singer(4, "ABC", 19, "Viet nam", true, "Nhac dam ma");
        singers[4] = new Singer(5, "QWE", 19, "Viet nam", true, "Nhac dam ma");
    }


    private static Song[] songs = new Song[100];
    private static int countSong = 5;// bien de kiem soat so luong bai hat da tao va nhap thong tin

    static {
        songs[0] = new Song("S001", "Tinh khuc vang", singers[0], "Tac gia", new Date(), true);
        songs[1] = new Song("S002", "Tinh Don Phuong", singers[0], "Tac gia", new Date(), true);
        songs[2] = new Song("S003", "Mot con vit", singers[2], "Tac gia", new Date(), true);
        songs[3] = new Song("S004", "Hai con than lan con", singers[2], "Tac gia", new Date(), true);
        songs[4] = new Song("S005", "Chim trang mo coi", singers[1], "Tac gia", new Date(), true);
    }


    public static void main(String[] args) {

        int choice;
        do {
            System.out.println("**********************QUẢN LÝ THƯ VIỆN ************************");
            System.out.println("1. QUẢN LÝ CA SY");
            System.out.println("2. QUẢN LÝ BAI HAT");
            System.out.println("3. QUẢN LÝ TIM KIEM");
            System.out.println("0. Thoát");
            System.out.print("Mời lựa chọn (0/1/2/3): ");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    menuSinger(scanner);
                    break;
                case 2:
                    menuSong(scanner);
                    break;
                case 3:
                    menuSearch(scanner);
                    break;

                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
                    break;
            }
        } while (true);
    }

    public static void menuSinger(Scanner scanner) {
        int choice;
        do {
            System.out.println("**********************SINGER-MANAGEMENT************************");
            System.out.println("1. Nhập vào số lượng ca sĩ cần thêm và nhập thông tin cần thêm mới (có validate dữ liệu nhập vào)");
            System.out.println("2. Hiển thị danh sách tất cả ca sĩ đã lưu trữ");
            System.out.println("3.Thay đổi thông tin ca sĩ theo mã id");
            System.out.println("4.Xóa ca sĩ theo mã id (kiểm tra xem nếu ca sĩ có bài hát thì không xóa được)");
            System.out.println("0. Thoat");
            System.out.print("Mời lựa chọn (0/1/2/3/4): ");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    addSinger(scanner);
                    break;
                case 2:
                    showListSinger(scanner);
                    break;
                case 3:
                    editSinger(scanner);
                    break;
                case 4:
                    deleteSinger(scanner);
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
                    break;
            }
        } while (true);
    }

    private static void addSinger(Scanner scanner) {
        System.out.println("Nhap so luong ca sy can nhap");
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            System.out.println("Ca sy thu" + (i + 1) + " : ");
            singers[countSinger] = new Singer();
            singers[countSinger].inputData(scanner,singers,countSinger);
            countSinger++;
        }
    }

    private static void deleteSinger(Scanner scanner) {
        System.out.println("Moi nhap id ca sy muon xoa");
        int idDelete = Integer.parseInt(scanner.nextLine());
        // kiem tra ca sy co bai hat theo idDelete cua singer vua nhap khong
        for (int i = 0; i < countSong; i++) {
            if (idDelete == songs[i].getSinger().getSingerId()) {
                System.out.println("Ca sy ton tai bai hat khong xoa duoc");
                return;
            }
        }
        // kiem tra id vua nhap de xoa ca sy
        boolean check = false;
        for (int i = 0; i < countSinger; i++) {
            if (idDelete == singers[i].getSingerId()) {
                check = true;
                for (int j = i; j < countSinger - 1; j++) {
                    singers[j] = singers[j + 1];
                }
                countSinger--;
                System.out.println("Da xoa ca sy thanh cong");
                break;
            }
        }
        if (!check) {
            System.out.println("Khong tim thay ca sy theo id vua nhap");
        }
    }


    private static void editSinger(Scanner scanner) {
        System.out.println("Nhap ID ca sy muon sua: ");
        boolean check = true;
        int idEdit = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < countSinger; i++) {
            if (singers[i].getSingerId() == idEdit) {
                singers[i].inputData(scanner, singers, countSinger);
                System.out.println("Sua thanh cong");
                check = false;
                break;
            }
        }
        if (check) {
            System.out.println("Khong tim thay theo id vua nhap");
        }
    }

    private static void showListSinger(Scanner scanner) {
        System.out.println("DANH SACH CA SY");
        for (int i = 0; i < countSinger; i++) {
            System.out.println(singers[i]);
        }
    }

    public static void menuSong(Scanner scanner) {
        int choice;
        do {
            System.out.println("**********************SONG-MANAGEMENT************************");
            System.out.println("1.Nhập vào số lượng bài hát cần thêm và nhập thông tin cần thêm mới");
            System.out.println("2.Hiển thị danh sách tất cả bài hát đã lưu trữ");
            System.out.println("3. Thay đổi thông tin bài hát theo mã id");
            System.out.println("4.Xóa bài hát theo mã id ");
            System.out.println("0. Quay lai");
            System.out.print("Mời lựa chọn (0/1/2/3/4): ");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    addSong(scanner);
                    break;
                case 2:
                    showListSong(scanner);
                    break;
                case 3:
                    // tu lam
                    break;
                case 4:
                    // tu lam
                    break;

                case 0:
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
                    break;
            }
        } while (true);
    }

    private static void showListSong(Scanner scanner) {
        System.out.println("DANH SACH BAI HAT");
        for (int i = 0; i < countSong; i++) {
            System.out.println(songs[i]);
        }
    }

    private static void addSong(Scanner scanner) {
        System.out.println("Moi nhap so luong bai hat can them moi: ");
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            System.out.println("Bai hat thu" + (i + 1) + " : ");
//            Song song = new Song();
//            song.inputData(scanner,singers,countSinger);
//            songs[i] = song;
            songs[countSong] = new Song();
            songs[countSong].inputData(scanner, singers, countSinger);
            countSong++;
        }


    }

    public static void menuSearch(Scanner scanner) {
        int choice;
        do {
            System.out.println("**********************QUẢN LÝ SÁCH************************");

            System.out.println("1.Tìm kiếm bài hát theo tên ca sĩ hoặc thể loại");
            System.out.println("2.Tìm kiếm ca sĩ theo tên hoặc thể loại");
            System.out.println("3.Hiển thị danh sách bài hát theo thứ tự tên tăng dần");
            System.out.println("4.Hiển thị 10 bài hát được đăng mới nhất");
            System.out.println("0. Quay lai");
            System.out.print("Mời lựa chọn (0/1/2/3/4/5): ");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    searchSong(scanner);
                    break;
                case 2:
                    // tu lam
                    break;
                case 3:
                    sortSongByName(scanner);
                    break;
                case 4:
                    top10NewSong(scanner);
                    break;
                case 5:
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
                    break;
            }
        } while (true);
    }

    private static void top10NewSong(Scanner scanner) {
        for (int i = 0; i < countSong - 1; i++) {
            for (int j = i + 1; j < countSong; j++) {
                if (songs[i].getCreatedDate().compareTo(songs[j].getCreatedDate()) < 0) {
                    Song temp = songs[i];
                    songs[i] = songs[j];
                    songs[j] = temp;
                }
            }
        }
        // hien thi 10 bia hat moi nhat
        System.out.println("Danh sach bai hat sau khi sap xep theo ten");
        for (int i = 0; i < 3; i++) {
            if (songs[i] != null) {
                System.out.println(songs[i]);
            }
        }
    }

    private static void sortSongByName(Scanner scanner) {
        for (int i = 0; i < countSong - 1; i++) {
            for (int j = i + 1; j < countSong; j++) {
                if (songs[i].getSongName().compareTo(songs[j].getSongName()) > 0) {
                    Song temp = songs[i];
                    songs[i] = songs[j];
                    songs[j] = temp;
                }
            }
        }
        System.out.println("Danh sach bai hat sau khi sap xep theo ten");
        for (int i = 0; i < countSong; i++) {
            System.out.println(songs[i]);
        }
    }

    private static void searchSong(Scanner scanner) {
        // tim kiem bai hat - theo ten ca sy hoac the loai
        System.out.println("Moi nhap tu khoa tim kiem");
        String searchSong = scanner.nextLine();
        System.out.println("DANH SACH TIM KIEM THEO TU KHOA: " + searchSong);
        int n = 0;
        for (int i = 0; i < countSong; i++) {
            if (singers[i].getSingerName().toLowerCase().contains(searchSong.toLowerCase()) ||
                    singers[i].getGenre().toLowerCase().contains(searchSong.toLowerCase())) {
                System.out.println(songs[i]);
                n = 1;
            }
        }
        if (n == 0) {
            System.out.println("Khong ton tai bai hat theo ye cau can tim kiem");
        }

    }
}




