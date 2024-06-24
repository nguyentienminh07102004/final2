import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import ExceptionHandler.DuplicateMedicalRecordException;
import Model.benhAn;
import Model.benhAnThuong;
import Model.benhAnVIP;
import Repository.IMPL.BenhAn;
import Validate.validate;

public class App {
    public static void main(String[] args) throws Exception {
        DateTimeFormatter dt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Scanner sc = new Scanner(System.in);
        BenhAn BA = new BenhAn();
        Integer choise = 1;
        do {
            System.out.println("1. Them moi");
            System.out.println("2. Xoa");
            System.out.println("3. Xem danh sach");
            System.out.println("4. Thoat");
            choise = Integer.parseInt(sc.nextLine());
            switch (choise) {
                case 3:
                    List<benhAn> list = BA.findAll();
                    for(benhAn ba : list) {
                        if(ba instanceof benhAnThuong) {
                            System.out.println(((benhAnThuong)ba).toString());
                        } else if(ba instanceof benhAnVIP) {
                            System.out.println(((benhAnVIP)ba).toString());
                        }
                    }
                    break;
                case 1:
                    String maBA = sc.nextLine();
                    try {
                        validate.checkMaBA(maBA);
                    } catch (DuplicateMedicalRecordException e) {
                        System.out.println(e.getMessage());
                        maBA = sc.nextLine();
                    }
                    String maBN = sc.nextLine();
                    if(!validate.checkMa(maBN)) {
                        System.out.println("Mã bệnh nhân không hợp lệ!");
                        continue;
                    }
                    String tenBN = sc.nextLine();
                    String ngayVao = sc.nextLine();
                    String ngayRa = sc.nextLine();
                    LocalDate localDate = LocalDate.parse(ngayRa);
                    ngayRa = dt.format(localDate);
                    localDate = LocalDate.parse(ngayVao);
                    ngayVao = dt.format(localDate);
                    String lyDo = sc.nextLine();
                    String type = sc.nextLine();
                    if(type.trim().startsWith("VIP")) {
                        String DateVIP = sc.nextLine();
                        benhAnVIP bav = new benhAnVIP();
                        bav.setMaBN(maBN);
                        bav.setTen(tenBN);
                        bav.setDateVIP(DateVIP);
                        bav.setLyDo(lyDo);
                        bav.setMaBA(maBA);
                        bav.setNgayRa(ngayRa);
                        bav.setNgayVao(ngayVao);
                        bav.setTypeVIP(type);
                        BA.insert(bav);
                    } else {
                        benhAnThuong bat = new benhAnThuong();
                        bat.setMaBN(maBN);
                        bat.setTen(tenBN);
                        bat.setLyDo(lyDo);
                        bat.setMaBA(maBA);
                        bat.setNgayRa(ngayRa);
                        bat.setNgayVao(ngayVao);
                        bat.setPhi(Double.parseDouble(type));
                        BA.insert(bat);
                    }
                    break;
                case 2:
                    String id = sc.nextLine();
                    System.out.println("Ban chac chan muon xoa ?");
                    String confirm = sc.nextLine();
                    if(confirm.toLowerCase().equals("yes")) {
                        BA.delete(id);
                    } 
                    break; 
                default:
                    System.out.println("Khong hop le");
                    break;
            }
        } while (choise < 4);

        sc.close();
    }
}
