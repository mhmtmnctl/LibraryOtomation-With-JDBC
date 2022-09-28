package admin.KitapIslemleri;

import genel.KitapConst;

import java.sql.SQLException;


public class AlinmisKitaplar {
    public static void adminAlinmisKitaplarMethodu() throws InterruptedException, SQLException, ClassNotFoundException {
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
