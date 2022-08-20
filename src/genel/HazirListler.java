package genel;



import admin.KullaniciIslemleri.KullaniciEkle;

import static admin.KitapIslemleri.KitapEkle.*;
import static admin.KullaniciIslemleri.KullaniciEkle.*;

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

        KitapConst kitap = new KitapConst(1, "hobbit", "Tolkien", "Fantastik",alinaBilirMi,alinmaTarihi,alanKisi);

        kitapList.add(kitap);
        KitapConst kitap2 = new KitapConst(2, "serenad", "Zülfü Livaneli", "Roman",alinaBilirMi,alinmaTarihi,alanKisi);

        kitapList.add(kitap2);


        //////////////////////////////

       /* KullaniciConst kullanici = new KullaniciConst(1,"Sezer","Ercan","sezer@gmail",
                "1453","0545",kullaniciPuan);


        //     System.out.println("Kullanici bilgileri : " + kullanici.toString());

        KullaniciEkle.kullaniciList.add(kullanici);
        KullaniciConst kullanici2 = new KullaniciConst(2,"Ersin","Akun","ersin@gmail",
                "1111","1111",kullaniciPuan);

        KullaniciEkle.kullaniciList.add(kullanici2);

        KullaniciConst kullanici3 = new KullaniciConst(3,"Mehmet","Emin","@techpro",
                "0001","0001",kullaniciPuan);

        kullaniciList.add(kullanici3);
        System.out.println("kullaniciList = " + kullaniciList);*/


    }


}
