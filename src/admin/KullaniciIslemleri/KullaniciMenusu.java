package admin.KullaniciIslemleri;
import admin.AdminMenusu;
import genel.Cikis;
import genel.Renklendirme;
import java.sql.SQLException;
import java.util.Scanner;
public class KullaniciMenusu {

    public static void adminKullaniciIslemleriMenusuMethodu() throws InterruptedException, SQLException, ClassNotFoundException {

        System.out.println(Renklendirme.ANSI_BLUE + "========================================" + Renklendirme.ANSI_RESET);
        System.out.println(Renklendirme.ANSI_GREEN + "-----Admin Kullanıcı İşlemleri Menüsü-----" + Renklendirme.ANSI_RESET);
        System.out.println("1-->Kullanıcı Ekle\n"+"2-->Kullanıcı Sil\n"+"3-->Kullanıcı Güncelle\n"+"9-->Üst Menü\n"+"0-->Çıkış");

        Scanner scan = new Scanner(System.in);
        System.out.print("Gitmek istediğiniz menünün sıra numarasını giriniz :");
        String secim = scan.next();

        switch (secim){
            case "1": KullaniciEkle.adminKullaniciEkleMethodu();
                break;
            case "2":KullaniciSil.adminKullaniciSilMethodu();
                break;
            case "3":KullaniciGuncelle.adminKullaniciGuncelleMethodu();
                break;
            case "9":
                AdminMenusu.adminMenusuMethodu();
                break;
            case "0": Cikis.cikisMethodu();
                break;
            default:
                System.out.println("Lütfen geçerli bir giriş yapınız!");
                adminKullaniciIslemleriMenusuMethodu();
                break;
        }


    }
}
