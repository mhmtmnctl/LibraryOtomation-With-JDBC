package admin.KitapIslemleri;

import genel.KitapConst;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class KitapEkle {
    /*
    Kitap Ekleme Sayfası

    Int kitapID;   otomatik ID
    String kitapAdı;
    String Yazarı;
    String Tur;

    ekleyince başarılı diye msj verelim bi üst menüye gitsin (KitapMenu)
    (1,java,ahmet,bilim) 4 elemalı liste
     */
    public static List<KitapConst> kitapList = new ArrayList<>();


    public static int kitapId = 1;
    public static String kitapAdi;
    public static String kitapYazari;
    public static String kitapTuru;
    public static boolean alinaBilirMi=true;


    public static void adminKitapEkleMethodu() throws InterruptedException {

        Scanner scan = new Scanner(System.in);
        System.out.print("Kitap adini giriniz : ");
        kitapAdi = scan.nextLine();

        System.out.print("\nKitap yazarini giriniz :");
        kitapYazari = scan.nextLine();
        System.out.print("\nKitap turunu giriniz : ");
        kitapTuru = scan.nextLine();

        KitapConst kitap = new KitapConst(kitapId, kitapAdi, kitapYazari, kitapTuru,alinaBilirMi);

        //     System.out.println("Kullanici bilgileri : " + kullanici.toString());

        kitapList.add(kitap);
        System.out.println(kitapList);
        kitapId++;
        System.out.println("Kitap başarılı şekilde eklendi...\n");
        System.out.println("Kitap Islemleri Menusune Yonlendiriliyorunuz ");
        for (int i = 3; i >= 1; i--) {
            System.out.print(i + " ");
            Thread.sleep(1000);
        }
        System.out.println("");
        KitapMenusu.adminKitapMenusuMethodu();

    }
}
