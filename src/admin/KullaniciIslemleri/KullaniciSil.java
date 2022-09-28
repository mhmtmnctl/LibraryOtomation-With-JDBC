package admin.KullaniciIslemleri;

import genel.KullaniciConst;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class KullaniciSil {

    /*
         öncelikle kullanıcı listesini gösterelim
         oradan id seçsin
         Silmek istediğiniz kullanıcının ID numarasını gireniz:
         Listede olan ID seçmeli yoksa uyarı verelim
         seçip enter'a bastığında seçilen kullanıcı bilgilerini ekrana getirsin.
         sout(Seçilen kullanıcıyı silmek istediğinize emin misiniz e/h)
        e derse listten silsin  silmeden önce Silinenler listesi olsun. oraya ekleyelim
        sildikten sonra da  kullanıcıMenüsüne gitsin
         h derse silmeden kullanıcıMenüsüne gitsin.
         //kullanıcı yoksa kontrol edelim. önce ekletelim

     */
    public static List<Object> silinenlerListesi = new ArrayList<>(); //todo Listler classına taşımaya çalışalım
    public static void adminKullaniciSilMethodu() throws InterruptedException, SQLException, ClassNotFoundException {
        System.out.println("Kullanici Silme Islemleri");
        Scanner scan = new Scanner(System.in);
        System.out.println(KullaniciEkle.kullaniciList);
        System.out.print("Silmek istediğiniz kullanıcının  ID numarısını giriniz :");
        int secim = scan.nextInt();
        int indexDegeri = 0;
        int SilinecekKisi=0;

        for (KullaniciConst each:KullaniciEkle.kullaniciList) {

            if(each.kullaniciId==secim)
            {
                 SilinecekKisi=indexDegeri;
            }
            indexDegeri++;
            
        }
        if(secim == KullaniciEkle.kullaniciList.get(SilinecekKisi).kullaniciId)
        {
            int SilinenenID = KullaniciEkle.kullaniciList.get(SilinecekKisi).kullaniciId;
            //todo kesin silmek istiyor musunuz e/h
            silinenlerListesi.add(KullaniciEkle.kullaniciList.get(SilinecekKisi));
            KullaniciEkle.kullaniciList.remove(SilinecekKisi);
            System.out.println(SilinenenID+" ID numaralı kişi başarı ile silindi.");
            System.out.println("Silindikten sonra :"+KullaniciEkle.kullaniciList);
            Thread.sleep(3000);


            System.out.println("silinenlerListesi = " + silinenlerListesi);
            KullaniciMenusu.adminKullaniciIslemleriMenusuMethodu();

        }
        else
        {
            System.out.println("Seçtiğiniz ID de bir kişi yoktur. Geçerli bir seçim yapınız :");
            adminKullaniciSilMethodu();
        }
    }
}
