package admin.KullaniciIslemleri;

import genel.KullaniciConst;
import genel.Renklendirme;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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


   public static int kullaniciId=1;
   public static String kullaniciAdi;
   public static String kullaniciSoyadi;
   public static String kullaniciMail;
   public static String kullaniciSifre;
   public static String kullaniciTelNo;
   public static int kullaniciPuan = 10;

    public static void adminKullaniciEkleMethodu() throws InterruptedException {


        System.out.println(Renklendirme.ANSI_BLUE + "========================================" + Renklendirme.ANSI_RESET);
        System.out.println(Renklendirme.ANSI_GREEN + "-----Kullanıcı Ekleme İşlemi-----" + Renklendirme.ANSI_RESET);
        System.out.println(Renklendirme.ANSI_RED + "Eklemek istediğiniz kullanıcının bilgilerini eksiksiz giriniz" +Renklendirme.ANSI_RESET);
        Scanner scan = new Scanner(System.in);
        System.out.print("Kullanici adini giriniz : ");
        kullaniciAdi = scan.nextLine();

        System.out.print("\nKullanici Soyadini giriniz :");
        kullaniciSoyadi = scan.next();
        System.out.print("\nKullanici mail adresini giriniz : ");
        kullaniciMail = scan.next();
        System.out.print("\nKullanici sifre giriniz : ");
        kullaniciSifre = scan.next();
        System.out.print("\nKullanici telefon numarasi giriniz : ");
        kullaniciTelNo = scan.next();

        KullaniciConst kullanici = new KullaniciConst(kullaniciId,kullaniciAdi,kullaniciSoyadi,kullaniciMail,
                                                      kullaniciSifre,kullaniciTelNo,kullaniciPuan);


    //     System.out.println("Kullanici bilgileri : " + kullanici.toString());

         kullaniciList.add(kullanici);
       // System.out.println(kullaniciList);
        kullaniciId++;
        System.out.println("İşlem başarılı...\n");
        System.out.print("Üst menuye yonlendiriliyorunuz");
        for (int i = 3; i >= 1; i--) {
            System.out.print(".");
            Thread.sleep(1000);
        }
        System.out.println();
        System.out.println(kullaniciList);

        KullaniciMenusu.adminKullaniciIslemleriMenusuMethodu();
//todo REGISTER -KULLANICI EKLE ARASI GECISLERDE ** ID ARTIRAMIYORUZ ???


    }


}
