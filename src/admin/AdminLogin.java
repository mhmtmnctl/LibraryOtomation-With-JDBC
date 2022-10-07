package admin;
import genel.Renklendirme;
import java.sql.SQLException;
import java.util.Scanner;
public class AdminLogin {

    public static void adminLoginMethodu() throws InterruptedException, SQLException, ClassNotFoundException {

        String adminAdi = "1";
        String adminSifre = "1";
        Scanner scan = new Scanner(System.in);
        System.out.println(Renklendirme.ANSI_BLUE + "========================================" + Renklendirme.ANSI_RESET);
        System.out.println(Renklendirme.ANSI_GREEN + "-----Admin Login Ekranı-----  " + Renklendirme.ANSI_RESET);
        System.out.print("Kullanıcı Adı :");
        String giris1 = scan.nextLine();
        System.out.print("Kullanıcı şifresi :");
        String giris2 = scan.next();

        if (adminAdi.equals(giris1) && adminSifre.equals(giris2))
        {
           AdminMenusu.adminMenusuMethodu();
        }
        else
        {
            System.out.println("Şifre veya kullanıcı adı hatalı,tekrar deneyiniz");
            adminLoginMethodu();
        }
    }
}
