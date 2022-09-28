package user.UserIslemleri;

import admin.KullaniciIslemleri.KullaniciEkle;
import genel.KullaniciConst;
import genel.OpenConnection;
import user.UserKitap.UserIslemMenusu;

import java.sql.*;
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

    public static String loginId;

    public UserLogin() throws SQLException {
    }

    public static void userLoginMethodu() throws InterruptedException, SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/LibraryOtomation", "postgres", "1234");
        Statement st = con.createStatement();

       Scanner scan = new Scanner(System.in);
       System.out.print("Mail adresinizi giriniz : ");
        mail = scan.next();
       System.out.println();
       System.out.print("Şifrenizi giriniz : ");
        sifre = scan.next();

 //      for (KullaniciConst each: KullaniciEkle.kullaniciList) {
//
 //          if (each.kullaniciMail.equals(mail)&& (each.kullaniciSifre.equals(sifre)) ){
 //              loginId= String.valueOf(each.kullaniciId);
//
 //              System.out.println("Tebrikler giriş yaptınız... ");
 //              UserIslemMenusu.userKitapIslemMenusuMethodu();
//
 //          }
 //      }
        String sqlKullanicilariGetir = "SELECT * FROM kullanicilar";
        ResultSet users = st.executeQuery(sqlKullanicilariGetir);
        while (users.next()){

            if(mail.equals(users.getString(4)) && sifre.equals(users.getString(5))){
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


