package admin.KullaniciIslemleri;

import admin.KitapIslemleri.KitapMenusu;
import genel.KullaniciConst;
import genel.Renklendirme;

import java.sql.*;
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

    public static void adminKullaniciEkleMethodu() throws InterruptedException, SQLException, ClassNotFoundException {
       // System.out.println("KullaniciEkle.lastId() = " + KullaniciEkle.lastIdMethodu());


        System.out.println(Renklendirme.ANSI_BLUE + "========================================" + Renklendirme.ANSI_RESET);
        System.out.println(Renklendirme.ANSI_GREEN + "-----Kullanıcı Ekleme İşlemi-----" + Renklendirme.ANSI_RESET);
        System.out.println(Renklendirme.ANSI_RED + "Eklemek istediğiniz kullanıcının bilgilerini eksiksiz giriniz" +Renklendirme.ANSI_RESET);
        Scanner scan = new Scanner(System.in);
        System.out.print("Kullanici adini giriniz : ");
        //todo isimde harf ve boşluk dışında başka karakter olamaz
        kullaniciAdi = scan.nextLine().toUpperCase();

        //todo soyisimde harf ve boşluk dışında başka karakter olam
        System.out.print("\nKullanici Soyadini giriniz :");
        kullaniciSoyadi = scan.next().toUpperCase();
        System.out.print("\nKullanici mail adresini giriniz : ");
        kullaniciMail = scan.next();

        while (!(kullaniciMail.contains("@") && kullaniciMail.contains(".")))
        {
            System.out.println("Lutfen gecerli bir mail adresi giriniz ...");
            kullaniciMail=scan.next();
        }

        System.out.print("\nKullanici sifre giriniz (sifre en az 4 karakter uzunlugunda olmalidir) : ");
        kullaniciSifre = scan.next();
        while(kullaniciSifre.length()<4 || kullaniciSifre.contains(" ")){
            System.out.println("sifre en az 4 karakter uzunlugunda olmalidir ve bosluk icermemelidir");
            kullaniciSifre = scan.next();
        }
//        //todo telefon no kontrol edilecek, 10 haneli olmalı, başında 0 olmasın, sadece numara içermeli
        System.out.print("\nKullanici telefon numarasi giriniz : ");
        kullaniciTelNo = scan.next();
//
   //   KullaniciConst kullanici = new KullaniciConst(lastIdMethodu(),kullaniciAdi,kullaniciSoyadi,kullaniciMail,
//                                                      kullaniciSifre,kullaniciTelNo,kullaniciPuan);


//         kullaniciList.add(kullanici);
        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/LibraryOtomation", "postgres", "1234");
        Statement st = con.createStatement();

//todo kullanıcı eklede kaldık
        /*

        PreparedStatement ps = con.prepareStatement("INSERT INTO books VALUES(DEFAULT,?, ?, ?,true,NULL,NULL)");

        ps.setString(1,kitapAdi);
        ps.setString(2,kitapYazari);
        ps.setString(3,kitapTuru);
        ps.executeUpdate();
        System.out.println("kitap eklendi");
         */
        //1	"Ersin"	"AKUN"	"ersinakun34@gmail.com"	"1234"	"2126140853"	10


        PreparedStatement ps = con.prepareStatement("INSERT INTO kullanicilar VALUES(DEFAULT,?, ?, ?,?,?,10)");
        ps.setString(1,kullaniciAdi);
        ps.setString(2,kullaniciSoyadi);
        ps.setString(3,kullaniciMail);
        ps.setString(4,kullaniciSifre);
        ps.setString(5,kullaniciTelNo);
        ps.executeUpdate();

        con.close();
        st.close();


        System.out.println("İşlem başarılı...\n");
        System.out.print("Üst menuye yonlendiriliyorunuz");
        for (int i = 3; i >= 1; i--) {
            System.out.print(".");
            Thread.sleep(1000);
        }
        System.out.println();
     //   System.out.println(kullaniciList);

        KullaniciMenusu.adminKullaniciIslemleriMenusuMethodu();

    }




}
