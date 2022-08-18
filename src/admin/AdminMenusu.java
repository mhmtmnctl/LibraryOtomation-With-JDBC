package admin;

import admin.KitapIslemleri.KitapMenusu;
import admin.KullaniciIslemleri.KullanıcıMenüsü;
import genel.Cıkıs;
import genel.IlkGiris;

import java.util.Scanner;

public class AdminMenusu {
    /*
        ***Admin Menüsü***
        1-Kullanıcı İşlemleri
        2-Kitap İşlemleri
        0-Çıkış
        *
         switch-case ile bakalım
         1 ise KullanıcıMenüsü ne gitsin
         2- ise KitapMenusune gitsin
         0- çıkış
         yanlış giriş yaparsa da uyarı verip tekrar admin menüsünü çağıralım.
     */
    public static void adminMenusuMethodu() throws InterruptedException {

        System.out.println("***Admin Menüsü***");
        System.out.println("1-Kullanıcı İşlemleri\n"+"2-Kitap İşlemleri\n"+"9-Üst Menü\n"+"0-Çıkış");

        Scanner scan = new Scanner(System.in);
        System.out.print("Gitmek istediğiniz menünün sıra numarasını giriniz :");
        String secim = scan.next();


        switch (secim){
            case "1":
                KullanıcıMenüsü.adminKullanıcıIslemleriMenusuMethodu();
                break;
            case "2":
                KitapMenusu.adminKitapMenusuMethodu();
                break;
            case "0": Cıkıs.cikisMethodu();
                break;
            case "9":
                IlkGiris.ilkGirisMethodu();
                break;

            default:
                System.out.println("Lütfen geçerli bir giriş yapınız!");
                adminMenusuMethodu();
                break;
        }


    }

}
