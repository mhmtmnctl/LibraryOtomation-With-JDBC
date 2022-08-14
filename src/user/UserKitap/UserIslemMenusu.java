package user.UserKitap;

import genel.Cıkıs;

import java.util.Scanner;

public class UserIslemMenusu {
    /*
    Kullanıcı İşlemleri
    1-Kitap Al
    2-Kitap İade
    3-Kitaplarım(özet)
    0-çıkış

     */

    public static void userKitapIslemMenusuMethodu(){

        System.out.println("***Kitap İşlemleri Menüsü***");
        System.out.println("1-Kitap Al\n"+"2-Kitap İade\n"+"3-Kitap Durumlarım"+"0-Çıkış");

        Scanner scan = new Scanner(System.in);
        System.out.print("Gitmek istediğiniz menünün sıra numarasını giriniz :");
        String secim = scan.next();


        switch (secim){
            case "1": KitapAl.userKitapAlMethodu();
                break;
            case "2":KitapIade.userKitapIadeMethodu();
                break;
            case "3": UserKitapDurumu.userKitapDurumuMethodu();
                break;
            case "0": Cıkıs.cikisMethodu();
                break;
            default:
                System.out.println("Lütfen geçerli bir giriş yapınız!");
                userKitapIslemMenusuMethodu();
                break;
        }


    }
}
