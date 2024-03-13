package ra.model;

import java.util.Scanner;

public class Singer {

    private int singerId;
    private String singerName;
    private int age;
    private String nationality;
    private boolean gender;
    private String genre;

    public Singer() {

    }

    public Singer(int singerId, String singerName, int age, String nationality, boolean gender, String genre) {
        this.singerId = singerId;
        this.singerName = singerName;
        this.age = age;
        this.nationality = nationality;
        this.gender = gender;
        this.genre = genre;
    }

    public int getSingerId() {
        return singerId;
    }

    public void setSingerId(int singerId) {
        this.singerId = singerId;
    }


    public String getSingerName() {
        return singerName;
    }

    public void setSingerName(String singerName) {
        this.singerName = singerName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void inputData(Scanner scanner, Singer[] singers , int countSinger){
        // Id tự tăng bằng cách gọi phương thức getNewId()
        this.singerId = getNewId(singers,countSinger);

        System.out.println("Nhap ten: ");
        this.singerName = scanner.nextLine();
        System.out.println("Nhap tuoi: ");
        this.age = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhap quoc tich: ");
        this.nationality = scanner.nextLine();
        System.out.println("Nhap Gio tinh: ");
        this.gender = Boolean.parseBoolean(scanner.nextLine());
        System.out.println("Nhap The loai: ");
        this.genre = scanner.nextLine();


    }

    @Override
    public String toString() {
        return  "SingerId: " + singerId +
                " - SingerName: " + singerName + '\'' +
                " - Age: " + age +
                " - Nationality: " + nationality + '\'' +
                " - Gender: " + gender +
                " -  Genre: " + genre ;
    }

    // Phương thức trả về 1 số nguyên = singerId max + 1
    public int getNewId(Singer[] singers, int countSinger){
        if (countSinger == 0 ){
            return 1;
        }else {
            int max = singers[0].singerId;
            for (int i = 0; i < countSinger; i++) {
                if (max < singers[i].singerId){
                    max = singers[i].singerId;
                }
            }
            return max + 1;
        }
    }
}
