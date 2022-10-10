package admin.KullaniciIslemleri;
import admin.KullaniciIslemleri.kullaniciGuncelleme.*;

import java.sql.*;
import java.util.*;

public class KullaniciGuncelle {
    public static void adminKullaniciGuncelleMethodu() throws InterruptedException, SQLException, ClassNotFoundException {
        System.out.println("Kullanici Guncelleme Islemleri");
        System.out.println("-----------------");
        Scanner scan = new Scanner(System.in);
        System.out.println("1-Kullanıcı Adı\n2-Kullanıcı Soyadı\n3-Kullanıcı Maili\n4-Kullanıcı Şifresi\n5-Kullanıcı Tel No");
        System.out.print("Güncellemek istediğiniz alanın sıra numarasını giriniz : ");
        int siraNo= scan.nextInt();

        switch (siraNo){
            case 1:  AdiGuncelle.adiGuncelle(); break;
            case 2:  SoyadiGuncelle.soyadiGuncelle(); break;
            case 3:  MailGuncelle.mailGuncelle(); break;
            case 4:  SifreGuncelle.sifreGuncelle(); break;
            case 5:  TelefonGuncelle.telefonuGuncelle(); break;
            default:
                System.out.println("Lütfen geçerli bir giriş yapınız!");
                adminKullaniciGuncelleMethodu();

        }

    }

}
