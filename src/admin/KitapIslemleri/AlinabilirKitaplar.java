package admin.KitapIslemleri;

import genel.KitapConst;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

public class AlinabilirKitaplar {
    /*
            kitap listesini görcek. yani kitapList çağırcaz
            üst menüye döndür.
     */

    public static List<Object> alinabilirKitapListesi = new ArrayList<>();
    public static void adminAlinabilirKitaplarMethodu(){


        for (KitapConst each: KitapEkle.kitapList)
        {
            if (KitapEkle.alinaBilirMi)
            {
                alinabilirKitapListesi.add(each);
            }
        }
        System.out.println(alinabilirKitapListesi);
    }

}
