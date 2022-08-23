package user.UserIslemleri;

import admin.KullaniciIslemleri.KullaniciEkle;
import genel.KullaniciConst;
import genel.Renklendirme;

import java.util.Scanner;

import static admin.KullaniciIslemleri.KullaniciEkle.kullaniciList;

public class UserRegister {
    /*
    kayıtlı değilse önce kayıt olcak
      Kullanıcı ADı :  mail ile girsin. @gmail.com ile bitsin
      Şifre         :en az bir büyük harf,küçük harf,sayı ve noktalama işareti içersin

        List<String> K1okuduguKitaplar = new ArrayList<>();
        List<String> K1AldıgıKitaplar = new ArrayList<>();
     */
    public static int kullaniciId=(KullaniciEkle.kullaniciId++);
    public static String kullaniciAdi;
    public static String kullaniciSoyadi;
    public static String kullaniciMail;
    public static String kullaniciSifre;
    public static String kullaniciTelNo;
    public static int kullaniciPuan = 10;

   public static void userRegisterMethodu() throws InterruptedException {


           System.out.println(Renklendirme.ANSI_BLUE + "========================================" + Renklendirme.ANSI_RESET);
           System.out.println(Renklendirme.ANSI_GREEN + "-----Kayit Sayfasi-----" + Renklendirme.ANSI_RESET);
           System.out.println(Renklendirme.ANSI_RED + "Lutfen istenen bilgileri dogru giriniz" +Renklendirme.ANSI_RESET);
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
           kullaniciList.add(kullanici);
           kullaniciId++;
           System.out.println("Kayit İşlemi Başarili...\n");
           System.out.print("Üst menuye yonlendiriliyorunuz");
           for (int i = 3; i >= 1; i--) {
               System.out.print(".");
               Thread.sleep(1000);
           }
           System.out.println();
       System.out.println(kullaniciList);
           UserLoginMenusu.userLoginMenusuMethodu();

   }


}
