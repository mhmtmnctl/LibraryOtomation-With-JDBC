package admin.KullaniciIslemleri;

import genel.KullaniciConst;

import java.util.Scanner;

public class KullaniciGuncelle {
    /*
             öncelikle kullanıcı listesini gösterelim
             oradan id seçsin
             Güncellemek istediğiniz kullanıcının ID numarasını gireniz:
             Listede olan ID seçmeli yoksa uyarı verelim
             seçip enter'a bastığında seçilen kullanıcı bilgilerini ekrana getirsin.
             Seçtiği ID'yi silsin.
             Onun yerine yeni kayıt eklesin.

             [{1,sezer,Can,@mail,1453,5456185290},{2,Ersin,Akun,@gmail,5555,554339},{3,ali,can,@hotmail,4444,553}]
             kullanıcı[0].

             List<Integer> l1 = new ArrayList<Integer>();

            // Adding elements to object of List interface
            // Custom inputs

            l1.add(0, 1);
            l1.add(1, 2);

            // Print the elements inside the object
            System.out.println(l1);


     */
    public static void adminKullaniciGuncelleMethodu() throws InterruptedException {
        System.out.println("Kullanici Guncelleme Islemleri");

        Scanner scan = new Scanner(System.in);
        System.out.println(KullaniciEkle.kullaniciList);
        System.out.print("Guncellemek istediğiniz kullanıcının  ID numarısını giriniz :");

        int secim = scan.nextInt();
        int indexDegeri = 0;
        int guncellenecekKisi = 0;

        for (KullaniciConst each : KullaniciEkle.kullaniciList) {

            if (each.kullaniciId == secim) {
                guncellenecekKisi = indexDegeri;
            }
            indexDegeri++;
        }
        // todo getter setter ile deneyelim

        if (secim == KullaniciEkle.kullaniciList.get(guncellenecekKisi).kullaniciId) {
            int SilinenenID = KullaniciEkle.kullaniciList.get(guncellenecekKisi).kullaniciId;
            // todo kesin silmek istiyor musunuz e/h
            KullaniciEkle.kullaniciList.remove(guncellenecekKisi);

            // version 2 de getter setter uygulanacak
            //Thread.sleep(3000);
        }
        KullaniciEkle.adminKullaniciEkleMethodu();



    }

}
