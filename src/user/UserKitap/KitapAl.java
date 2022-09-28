package user.UserKitap;

import admin.KitapIslemleri.AlinabilirKitaplar;
import admin.KitapIslemleri.AlinmisKitaplar;
import admin.KitapIslemleri.KitapEkle;
import genel.KitapConst;
import genel.KullaniciConst;
import user.UserIslemleri.UserLogin;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class KitapAl {

    public static void userKitapAlMethodu() throws InterruptedException, SQLException, ClassNotFoundException {

       // System.out.println("mail adresi "+UserLogin.mail);
       // AlinabilirKitaplar.adminAlinabilirKitaplarMethodu();
       // System.out.println("AlinabilirKitaplar.alinabilirKitapListesi = " + AlinabilirKitaplar.alinabilirKitapListesi);
        System.out.println("Alabileceğiniz kitaplar aşağıdadır");
        System.out.println(KitapEkle.kitapList);
        System.out.print("İstediğiniz kitabın ID numarasının giriniz :");
        Scanner scan = new Scanner(System.in);
        int secim = scan.nextInt();

        int indexDegeri = 0;
        int alinacakKitap = 0;

        for (KitapConst each : KitapEkle.kitapList) {

            if (each.kitapId == secim) {
                alinacakKitap = indexDegeri;
            }
            indexDegeri++;
        }

        if (KitapEkle.kitapList.get(alinacakKitap).alinaBilirMi) {
           // AlinmisKitaplar.alinmisKitapListesi.add(KitapEkle.kitapList.get(alinacakKitap));
          //  AlinabilirKitaplar.alinabilirKitapListesi.remove(alinacakKitap);

            //todo iade zamani==> kitaplist'e alinmis kitabi ekleyecegiz


            LocalDateTime trh = LocalDateTime.now();

            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MMM/yyyy");
           // System.out.println(dtf.format(trh));  // 25/Tem/2022

            System.out.println(secim+" Id Numarali Kitabi "+dtf.format(trh)+" Tarihinde aldiniz" +
                    "\nTeslim Tarihiniz : "+dtf.format(trh.plusDays(14))+" dir");
            KitapEkle.kitapList.get(alinacakKitap).alinmaTarihi = (dtf.format(trh));
            KitapEkle.kitapList.get(alinacakKitap).alinaBilirMi=false;
           // KitapEkle.kitapList.remove(alinacakKitap);
            KitapEkle.kitapList.get(alinacakKitap).alanKisi=UserLogin.loginId;
           // KitapEkle.kitapList.get(alinacakKitap).alanKisi=UserLogin.mail
            System.out.println("kitapList = " + KitapEkle.kitapList);
            //todo alt satir=> user login olacak bilgileri yerlestirecegiz




            UserIslemMenusu.userKitapIslemMenusuMethodu();
        } else
        {
            System.out.println("Seçtiğiniz kitap alınmıştır, başka kitap seçiniz");
            userKitapAlMethodu();

        }

        UserIslemMenusu .userKitapIslemMenusuMethodu();
    }
}

