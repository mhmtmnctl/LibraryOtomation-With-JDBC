package user.UserIslemleri;

import genel.Cıkıs;
import genel.IlkGiris;

import java.sql.SQLException;
import java.util.Scanner;

public class UserLoginMenusu {
    /*
    Kullanıcı Giriş Ekranı
    1-Login  -->UserLogine göndercez
    2-Register --> UserRegister'a göndercez
    9-Ust Menü IlkGirişe gönderelim
    0-çıkış

     */
    public static void userLoginMenusuMethodu() throws InterruptedException, SQLException, ClassNotFoundException {

        System.out.println("***Kullanıcı Menüsü***");
        System.out.println("1-Login\n"+"2-Register\n"+"9-Üst Menü\n"+"0-Çıkış");

        Scanner scan = new Scanner(System.in);
        System.out.print("Gitmek istediğiniz menünün sıra numarasını giriniz :");
        String secim = scan.next();


        switch (secim){
            case "1":
                UserLogin.userLoginMethodu();
                break;
            case "2":UserRegister.userRegisterMethodu();
                break;
            case "9":
                IlkGiris.ilkGirisMethodu();
                break;
            case "0": Cıkıs.cikisMethodu();
                break;
            default:
                System.out.println("Lütfen geçerli bir giriş yapınız!");
                userLoginMenusuMethodu();
                break;
        }


    }

}
