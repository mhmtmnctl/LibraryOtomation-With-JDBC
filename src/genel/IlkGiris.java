package genel;
import admin.AdminLogin;
import user.UserIslemleri.UserLoginMenusu;
import java.sql.SQLException;
import java.util.Scanner;
public class IlkGiris {

    public static void ilkGirisMethodu() throws InterruptedException, SQLException, ClassNotFoundException {

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
           case "0": Cikis.cikisMethodu();
           break;
           default:
               System.out.println("Lütfen geçerli bir giriş yapınız!");
               ilkGirisMethodu();
               break;
       }
    }
}
