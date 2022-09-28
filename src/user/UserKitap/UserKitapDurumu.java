package user.UserKitap;

import admin.KitapIslemleri.KitapEkle;
import genel.KitapConst;
import user.UserIslemleri.UserLogin;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class UserKitapDurumu extends KitapAl {
    /*
                 Kitap Durumları

    Alınmış Kitaplar    Alınma Tarihi   İade Durumu
       JavaBook         01.08.2022      İade edildi/edilmediyse iade edilmesine kaç gün kaldı/süresi geçtiyse Acil teslim edin

   //    eskiyi gösteremiyoruz çünkü database yok.
       şuan okuduğu kitabı gösterelim.

       çıkış/üstmenü için 0'a basınız.

     */
    public static void userKitapDurumuMethodu() throws InterruptedException, SQLException, ClassNotFoundException {
        String tercih;
        Scanner scan = new Scanner(System.in);
        do {
            System.out.println("Guncel kitap durumunuz :");
            System.out.printf("-------------------------------------------%n");
            System.out.printf("| %-10s | %-12s | %6s |%n", "Aldiginiz kitaplar", " Alinma tarihi", "  Iade durumu");
            System.out.printf(alinmisKitap());
            System.out.printf("-------------------------------------------%n");
            System.out.print("Ust menuye gitmek icin 9'a basiniz :");
            tercih = scan.next();
        }while(!tercih.equals("9"));
        if (tercih.equals("9")){
            UserIslemMenusu.userKitapIslemMenusuMethodu();
        }else {
            System.out.println("Yanlis giris yaptiniz, Lutfen 9'a basiniz...");
            userKitapDurumuMethodu();
        }
    }
    public static String alinmisKitap() {

        String iadeDurumu = "";
        String alinanKitaplar = "";
        for (KitapConst each : KitapEkle.kitapList) {

//todo TESLIMINE KAC GUN KALDI KISMI YAPILACAK   ** puan ekleme durumunu da yapalim

            if (each.alanKisi.contains(UserLogin.loginId)) {
                if (each.alinaBilirMi == false) {
                    iadeDurumu = "Iade edilmedi ";
                }
                alinanKitaplar += "  "+each.kitapAdi + "              " + each.alinmaTarihi + "        " + iadeDurumu +  "\n";

            }
        }

        return alinanKitaplar;
    }
}