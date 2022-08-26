package admin.KitapIslemleri;

import genel.KitapConst;


public class AlinabilirKitaplar {

    public static void adminAlinabilirKitaplarMethodu() throws InterruptedException {


        for (KitapConst each: KitapEkle.kitapList)
        {
            if (each.alinaBilirMi)
            {
                System.out.println(each);
            }
        }
        KitapMenusu.adminKitapMenusuMethodu();

    }

}
