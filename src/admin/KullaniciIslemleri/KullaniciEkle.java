package admin.KullaniciIslemleri;

import genel.KullaniciConst;
import genel.Renklendirme;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
//import static admin.KullaniciIslemleri.KullaniciEkle.kullaniciList;


public class KullaniciEkle {
    /*
    Kullanıcı ID: ama bunu biz otomatik atıyalım.                                               int
    Kullanıcı adı:                                                                              String
    Kullanıcı soyad:       uppercase yapabiliriz.                                               String
    Kullanıcı mail:         .com ile bitsin                                                     String
    Kullanıcı şifresi:     en az bir büyük harf,küçük harf,sayı ve noktalama işareti içersin.   String
    Kullanıcı Tel:        5456185290   başında 0 olmadan 10 haneli girsin                       String
    Kullanıcı Puanı: buda default 10 puan.                                                      int

    contructor'a göndercez.
    String metodu olcak.

    atıyorum maili girerken yanlış girerse hemen uyaralım. diğerleri için de aynı şekilde.
    burda list oluşturcaz.
    en son liste atalım.

    en son entera bastığında kullanıcı başarıyla eklendi
    sonra KullanıcıMenusune atalım.
     */
   public static List<KullaniciConst> kullaniciList = new ArrayList<>();

   public static int kullaniciId;
   public static String kullaniciAdi;
   public static String kullaniciSoyadi;
   public static String kullaniciMail;
   public static String kullaniciSifre;
   public static String kullaniciTelNo;
   public static int kullaniciPuan = 10;

    public static void adminKullaniciEkleMethodu() throws InterruptedException {
        System.out.println("KullaniciEkle.lastId() = " + KullaniciEkle.lastIdMethodu());


        System.out.println(Renklendirme.ANSI_BLUE + "========================================" + Renklendirme.ANSI_RESET);
        System.out.println(Renklendirme.ANSI_GREEN + "-----Kullanıcı Ekleme İşlemi-----" + Renklendirme.ANSI_RESET);
        System.out.println(Renklendirme.ANSI_RED + "Eklemek istediğiniz kullanıcının bilgilerini eksiksiz giriniz" +Renklendirme.ANSI_RESET);
        Scanner scan = new Scanner(System.in);
        System.out.print("Kullanici adini giriniz : ");
        kullaniciAdi = scan.nextLine().toUpperCase();

        System.out.print("\nKullanici Soyadini giriniz :");
        kullaniciSoyadi = scan.next().toUpperCase();
        System.out.print("\nKullanici mail adresini giriniz : ");
        kullaniciMail = scan.next();

        while (!(kullaniciMail.contains("@") && kullaniciMail.contains("."))){
            System.out.println("Lutfen gecerli bir mail adresi giriniz ...");
            kullaniciMail=scan.next();
        }

        System.out.print("\nKullanici sifre giriniz (sifre en az 4 karakter uzunlugunda olmalidir) : ");
        kullaniciSifre = scan.next();
        while(kullaniciSifre.length()<4 || kullaniciSifre.contains(" ")){
            System.out.println("sifre en az 4 karakter uzunlugunda olmalidir ve bosluk icermemelidir");
            kullaniciSifre = scan.next();
        }

        System.out.print("\nKullanici telefon numarasi giriniz : ");
        kullaniciTelNo = scan.next();
//todo telefon no kontrol edilecek
        KullaniciConst kullanici = new KullaniciConst(lastIdMethodu(),kullaniciAdi,kullaniciSoyadi,kullaniciMail,
                                                      kullaniciSifre,kullaniciTelNo,kullaniciPuan);


    //     System.out.println("Kullanici bilgileri : " + kullanici.toString());

         kullaniciList.add(kullanici);
       // System.out.println(kullaniciList);
       // kullaniciId++;
        System.out.println("İşlem başarılı...\n");
        System.out.print("Üst menuye yonlendiriliyorunuz");
        for (int i = 3; i >= 1; i--) {
            System.out.print(".");
            Thread.sleep(1000);
        }
        System.out.println();
        System.out.println(kullaniciList);

        KullaniciMenusu.adminKullaniciIslemleriMenusuMethodu();

    }

    public static int lastIdMethodu (){
        int temp = 0;
        int lastId = 0;

        for (KullaniciConst each:kullaniciList)
        {
            if (each.kullaniciId > temp)
            {
               lastId=each.kullaniciId+1;
            }
        }
        return lastId;
    }


}
