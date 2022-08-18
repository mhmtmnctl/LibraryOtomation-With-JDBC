package admin.KitapIslemleri;

import admin.AdminMenusu;
import genel.Cıkıs;

import java.util.Scanner;

public class KitapMenusu {
    /*
    Kitap İşlemleri
    1-Kitap Ekle
    2-Kitap Sil
    3-Alınabilir Kitaplar
    4-Alınmış Kİtaplar
    9-Üst menü(AdminMenusu ne gitsin)
    0-Çıkış

    kontrol et yanlış girişler için



     */
    public static void adminKitapMenusuMethodu() throws InterruptedException {

        System.out.println("***Admin Kitap İşlemleri Menüsü***");
        System.out.println("1-Kitap Ekle\n"+"2-Kitap Sil\n"+"3-Alınabilir Kitaplar\n"+"4-Alınmış Kitaplar\n"+"9-Üst Menü\n"+"0-Çıkış");

        Scanner scan = new Scanner(System.in);
        System.out.print("Gitmek istediğiniz menünün sıra numarasını giriniz :");
        String secim = scan.next();


        switch (secim){
            case "1": KitapEkle.adminKitapEkleMethodu();
                break;
            case "2":
                KitapSil.adminKitapSilMethodu();
                break;
            case "3":
               AlinabilirKitaplar.adminAlinabilirKitaplarMethodu();
                break;
            case "4":
                AlinmisKitaplar.adminAlinmisKitaplarMethodu();
                break;
            case "9":
                AdminMenusu.adminMenusuMethodu();
                break;
            case "0": Cıkıs.cikisMethodu();
                break;
            default:
                System.out.println("Lütfen geçerli bir giriş yapınız!");
                adminKitapMenusuMethodu();
                break;
        }


    }


}
