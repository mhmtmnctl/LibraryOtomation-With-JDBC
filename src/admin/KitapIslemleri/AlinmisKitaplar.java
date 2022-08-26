package admin.KitapIslemleri;

import genel.KitapConst;


public class AlinmisKitaplar {
    public static void adminAlinmisKitaplarMethodu() throws InterruptedException {
        //önce kullanıcının alması lazım
        for (KitapConst each:KitapEkle.kitapList) {
            if (!each.alinaBilirMi)
            {
                System.out.println(each);
            }
        }
        KitapMenusu.adminKitapMenusuMethodu();

    }
}
