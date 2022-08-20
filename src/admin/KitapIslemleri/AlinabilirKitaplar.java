package admin.KitapIslemleri;

import genel.KitapConst;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

public class AlinabilirKitaplar {

  //  public static List<KitapConst> alinabilirKitapListesi = new ArrayList<>();
    public static void adminAlinabilirKitaplarMethodu() throws InterruptedException {


        for (KitapConst each: KitapEkle.kitapList)
        {
            if (each.alinaBilirMi)
            {
                System.out.println(each);
            }
        }
        KitapMenusu.adminKitapMenusuMethodu();
        //System.out.println(alinabilirKitapListesi);
    }

}
