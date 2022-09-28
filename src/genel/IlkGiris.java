package genel;

import admin.AdminLogin;
import user.UserIslemleri.UserLoginMenusu;

import java.sql.SQLException;
import java.util.Scanner;

public class IlkGiris {

    //----HOSGELDINIZ--- olsun
    /*

    1-Admin işlemleri
    2-Kullanıcı işlemleri
    0-Çıkış
    Scanner ile alalım
     İşlem yapmak istediğiniz menünün sıra numarasını giriniz:
     1 ise Admin logine, 2 ise UserLoginMenusu'ne gitsin 3 ise çıkış olsun.
     1, 2,0 dışında bir giriş yaparsa uyarı verip tekrar IlkGiriş'i çalıştırsın.
     switch-case ile yapalım.
     * Kullanıcı adını şifresini girdiğinde sistemde yoksa kayıt ekranına yönlendirelim

     çıkış yapılırsa çıkış yaptınız tarzı birşey yazalım

     */
    public static void ilkGirisMethodu() throws InterruptedException, SQLException, ClassNotFoundException {

       // System.out.println("===HOŞGELDİNİZ===");
        System.out.println(Renklendirme.ANSI_BLUE + "========================================" + Renklendirme.ANSI_RESET);
        System.out.println(Renklendirme.ANSI_YELLOW_BACKGROUND + Renklendirme.ANSI_BLACK+ "======== HOŞGELDİNİZ =========" + Renklendirme.ANSI_RESET);
        System.out.println(Renklendirme.ANSI_BLUE + "========================================" + Renklendirme.ANSI_RESET);
        System.out.println("1-->Admin İşlemleri\n"+"2-->Kullanıcı İşlemleri\n"+"0-->Çıkış");

        Scanner scan = new Scanner(System.in);
        System.out.print("Gitmek istediğiniz menünün sıra numarasını giriniz :");
        String secim = scan.next();


       switch (secim){
           case "1":
               AdminLogin.adminLoginMethodu();
               break;
           case "2":
               UserLoginMenusu.userLoginMenusuMethodu();
               break;
           case "0": Cıkıs.cikisMethodu();
           break;
           default:
               System.out.println("Lütfen geçerli bir giriş yapınız!");
               ilkGirisMethodu();
               break;
       }


    }



}
