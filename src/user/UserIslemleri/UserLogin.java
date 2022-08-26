package user.UserIslemleri;

import admin.KullaniciIslemleri.KullaniciEkle;
import genel.KullaniciConst;
import user.UserKitap.UserIslemMenusu;

import java.util.Scanner;

//import static admin.KullaniciIslemleri.KullaniciEkle.kullaniciList;

public class UserLogin {
    /*
daha önceden kayıt olmuş
login olcak kullanıcı adı şifresini gircek.

giriş yaptıktan sonra UserIslemMenusu açılsın.
yanlış giriş olursa tekrar girsin veya çıkış koyalım


 */


    public static String sifre;
    public static String mail;

   public static void userLoginMethodu() throws InterruptedException {
      // System.out.println("userLoginMethodu çalıştı");
       //burada if deyip eğer başarılı giriş yaptıysa UserIslemMenusu Açılsın
      // UserIslemMenusu.userKitapIslemMenusuMethodu();
       Scanner scan = new Scanner(System.in);
       System.out.print("Mail adresinizi giriniz : ");
        mail = scan.next();
       System.out.println();
       System.out.print("Şifrenizi giriniz : ");
        sifre = scan.next();

       for (KullaniciConst each: KullaniciEkle.kullaniciList) {

           if (each.kullaniciMail.equals(mail)&& (each.kullaniciSifre.equals(sifre)) ){

               System.out.println("Tebrikler giriş yaptınız... ");
               UserIslemMenusu.userKitapIslemMenusuMethodu();

           }
       }
       System.out.print("Kullanıcı adı veya şifreniz hatalı, \ntekrar denemek ister misiniz? (E / H): ");
               String secim = scan.next();
               if (secim.equalsIgnoreCase("E")){
                   UserLogin.userLoginMethodu();
               }else {
                   UserLoginMenusu.userLoginMenusuMethodu();
               }

    }

}


