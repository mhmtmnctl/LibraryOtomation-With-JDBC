package admin.KullaniciIslemleri;

import admin.AdminMenusu;
import genel.Cıkıs;

import java.util.Scanner;

public class KullanıcıMenüsü {
    /*
    Kullanıcı İşlemleri
    1-Kullanıcı ekle
    2-Kullanıcı Sil
    3-Kullanıcı Güncelle
    9-Üst Menü
    0-Çıkış

    Burda seçim yaptıralım. Hatalı girişleri kontrol edelim


     */
    public static void adminKullanıcıIslemleriMenusuMethodu() throws InterruptedException {

        System.out.println("***Admin Kullanıcı İşlemleri***");
        System.out.println("1-Kullanıcı Ekle\n"+"2-Kullanıcı Sil\n"+"3-Kullanıcı Güncelle\n"+"9-Üst Menü\n"+"0-Çıkış");

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
            case "0": Cıkıs.cikisMethodu();
                break;
            default:
                System.out.println("Lütfen geçerli bir giriş yapınız!");
                adminKullanıcıIslemleriMenusuMethodu();
                break;
        }


    }
}
