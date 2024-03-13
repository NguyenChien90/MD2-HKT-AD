package ra.model;

import java.util.Date;
import java.util.Scanner;

public class Song {
    private String songId;
    private String songName;
    private Singer singer;
    private String songWriter;
    private Date createdDate ;
    private boolean songStatus;

    public Song() {
        // khi tạo 1 đối tượng không tham số thuộc tính createdDate sẽ được gán mặc định là thời gian hiện tai
        this.createdDate = new Date();
    }

    public Song(String songId, String songName, Singer singer, String songWriter, Date createdDate, boolean songStatus) {
        this.songId = songId;
        this.songName = songName;
        this.singer = singer;
        this.songWriter = songWriter;
        this.createdDate = createdDate;
        this.songStatus = songStatus;
    }

    public String getSongId() {
        return songId;
    }

    public void setSongId(String songId) {
        this.songId = songId;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public Singer getSinger() {
        return singer;
    }

    public void setSinger(Singer singer) {
        this.singer = singer;
    }

    public String getSongWriter() {
        return songWriter;
    }

    public void setSongWriter(String songWriter) {
        this.songWriter = songWriter;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public boolean isSongStatus() {
        return songStatus;
    }

    public void setSongStatus(boolean songStatus) {
        this.songStatus = songStatus;
    }

    public void inputData(Scanner scanner,Singer[] singers, int coutSinger ){
        System.out.println("Nhap id bai hat");
        this.songId = scanner.nextLine();
        System.out.println("Nhap ten bai hat");
        this.songName = scanner.nextLine();

        // Chon singer cho song
        // kiểm tra danh sách ca sỹ có ca sỹ ko ,
        // nếu trống thì phải nhập 1 ca sỹ trước khi chọn singer cho song
        if (coutSinger == 0){
            System.out.println("Danh sach ca sy trong moi nhap ca sy: ");
            Singer singer1 = new Singer();
            singer1.inputData(scanner,singers,coutSinger);
            singers[coutSinger] = singer1;
            coutSinger++;
        }
        System.out.println("Danh sach Singer mom");
        for (int i = 0; i < coutSinger; i++) {
            System.out.println("ID: "+ singers[i].getSingerId()+" - Name: "+ singers[i].getSingerName());
        }
        System.out.println("Moi nhap ID singer can chon");
        while (true){
            int id = Integer.parseInt(scanner.nextLine());
            boolean isExist = false;
            for (int i = 0; i < coutSinger; i++) {
                if (id == singers[i].getSingerId()){
                    this.singer = singers[i];
                    isExist = true;
                    break;
                }
            }
            if (!isExist){
                System.out.println("Id ca sy khong co trong danh sach, moi nhap lai");
            }else {
                // khi da nhap singer va thoat while
                break;
            }
        }
        System.out.println("Nhap ten tac gia");
        this.songWriter = scanner.nextLine();
        System.out.println("Nhap trang thai bai hat");
        this.songStatus = Boolean.parseBoolean(scanner.nextLine());


    }

    @Override
    public String toString() {
        return "SongId: " + songId + '\'' +
                " - SongName: " + songName + '\'' +
                " - Singer: " + singer.getSingerName() +
                " - songWriter: " + songWriter + '\'' +
                " - CreatedDate: " + createdDate +
                " - SongStatus: " + songStatus;
    }
}
