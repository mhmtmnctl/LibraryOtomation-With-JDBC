package admin.KitapIslemleri;

import genel.KitapConst;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class KitapSil {
    /*
    Kitapları listeleyelim.
    Oradan ID numarası ile seçsin
    Lİst yapıp silinen kitaplar listesine ekleyelim
    Seçilen kitabı simek istiyor musunuz : e/h
    e derse listten silsin üst menü
    h derse üst menü
     */
    public static List<Object> silinenKitapListesi = new ArrayList<>();
    public static void adminKitapSilMethodu() throws InterruptedException {

            System.out.println("Kitap Silme Islemleri");
            Scanner scan = new Scanner(System.in);
            System.out.println(KitapEkle.kitapList);
            System.out.print("Silmek istediğiniz kitabin ID numarısını giriniz :");
            int secim = scan.nextInt();
            int indexDegeri = 0;
            int silinecekKitap=0;

            for (KitapConst each:KitapEkle.kitapList) {
                if(each.kitapId==secim)
                {
                    silinecekKitap=indexDegeri;
                }
                indexDegeri++;
            }
            if(secim == KitapEkle.kitapList.get(silinecekKitap).kitapId)
            {
                int SilinenenID = KitapEkle.kitapList.get(silinecekKitap).kitapId;
                //todo kesin silmek istiyor musunuz e/h
                silinenKitapListesi.add(KitapEkle.kitapList.get(silinecekKitap));
                KitapEkle.kitapList.remove(silinecekKitap);

                System.out.println(SilinenenID+" ID numaralı kitap başarı ile silindi.");
                System.out.println("Silindikten sonra kitap listesi : "+KitapEkle.kitapList);
                Thread.sleep(3000);


                System.out.println("silinenlerListesi = " + silinenKitapListesi);
                KitapMenusu.adminKitapMenusuMethodu();

            }
            else
            {
                System.out.println("Seçtiğiniz ID de bir kitap yoktur. Geçerli bir seçim yapınız :");
                adminKitapSilMethodu();
            }
    }
}
