package genel;

import admin.KitapIslemleri.KitapEkle;

import static admin.KitapIslemleri.KitapEkle.kitapList;
import static admin.KullaniciIslemleri.KullaniciEkle.kullaniciList;

public class HazirListler {
    public static int kitapId = 1;
    public static String kitapAdi;
    public static String kitapYazari;
    public static String kitapTuru;
    ////////////////////////////////
    public static int kullaniciId=1;
    public static String kullaniciAdi;
    public static String kullaniciSoyadi;
    public static String kullaniciMail;
    public static String kullaniciSifre;
    public static String kullaniciTelNo;
    public static int kullaniciPuan = 10;
    ////////////////////////////////////
    public static boolean alinaBilirMi=true;

    public  static void hazirListlerMetodu(){

        KitapConst kitap = new KitapConst(1, "hobbit", "Tolkien", "Fantastik",alinaBilirMi);

        kitapList.add(kitap);
        KitapConst kitap2 = new KitapConst(2, "serenad", "Zülfü Livaneli", "Roman",alinaBilirMi);

        kitapList.add(kitap2);


        //////////////////////////////

        KullaniciConst kullanici = new KullaniciConst(1,"Sezer","Ercan","@gmail",
                "1453","0545",kullaniciPuan);


        //     System.out.println("Kullanici bilgileri : " + kullanici.toString());

        kullaniciList.add(kullanici);
        KullaniciConst kullanici2 = new KullaniciConst(1,"Ersin","Akun","@gmail",
                "1111","1111",kullaniciPuan);

        kullaniciList.add(kullanici2);

            /*
            bu kisim ersin yokken yapildi
             */





    }


}
