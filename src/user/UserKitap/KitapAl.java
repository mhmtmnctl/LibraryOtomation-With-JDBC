package user.UserKitap;

import admin.KitapIslemleri.AlinabilirKitaplar;
import admin.KitapIslemleri.AlinmisKitaplar;
import admin.KitapIslemleri.KitapEkle;
import admin.KullaniciIslemleri.KullaniciEkle;
import genel.KitapConst;
import genel.KullaniciConst;

import java.util.Scanner;

public class KitapAl {
    /*
    alınabilir kitapları listeleriz
    buradan seçer.
    seçtiğini alınmışKitaplar listine atcaz.
    hangi kullanıcı aldıysa onun id sini ekleyelim.
    ve aldığı kitabı alınabilirListesinden silcez.

    dateTime almamız lazım. hangi tarihte aldıysa tutmamız lazım. biyerde tutmamız lazım

    eğer iade etmediği bir kitap varsa kitap alamasın.

    (1,java,ahmet,bilim,sezerID)
     */
   public static void userKitapAlMethodu(){

       System.out.println("Alabileceğiniz kitaplar aşağıdadır");
       System.out.println(KitapEkle.kitapList);
       System.out.println("İstediğiniz kitabın ID numarasının giriniz :");
       Scanner scan = new Scanner(System.in);
       int secim = scan.nextInt();

       int indexDegeri = 0;
       int alinacakKitap = 0;
      // AlinabilirKitaplar obj = new AlinabilirKitaplar();

       for (KitapConst each : KitapEkle.kitapList)
       {

           if (each.kitapId == secim) {
               alinacakKitap = indexDegeri;
           }
           indexDegeri++;
       }

       for (KitapConst each: KitapEkle.kitapList)//bu her kitap için çalıştığı için kaç kitap varsa o kadar
           //Şu Id numaralı kitabı şu tarihte aldınız yazdırıyor. burası hatalı
       {
           if (each.alinaBilirMi)//todo sadece  seçtiği kitabı  yazdırması lazım burası hatalı
           {

               //AlinmisKitaplar.alinmisKitapListesi.add(each.kitapId+" "+each.kitapAdi+" "+each.kitapYazari+" "+each.kitapTuru+" "+each.alinaBilirMi);
               AlinmisKitaplar.alinmisKitapListesi.add(each.toString());
               System.out.println("Şu Id numaralı kitabı şu tarihte aldınız");
               //burada kullanıcının aldığı kitaplar listesini gösterelim.
               // en son burda kaldık


           }
           else {
               System.out.println("Seçtiğiniz kitap alınmıştır, başka kitap seçiniz");
               userKitapAlMethodu();

           }
       }

       UserIslemMenusu.userKitapIslemMenusuMethodu();

   }
}
