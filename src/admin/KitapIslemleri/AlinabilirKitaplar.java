package admin.KitapIslemleri;

import genel.KitapConst;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

public class AlinabilirKitaplar {

    public static List<KitapConst> alinabilirKitapListesi = new ArrayList<>();
    public static void adminAlinabilirKitaplarMethodu(){


        for (KitapConst each: KitapEkle.kitapList)
        {
            if (each.alinaBilirMi)
            {
                alinabilirKitapListesi.add(each);
            }
        }
        System.out.println(alinabilirKitapListesi);
    }

}
