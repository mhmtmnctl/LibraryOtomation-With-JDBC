package admin.KitapIslemleri;

import genel.KitapConst;

import java.sql.SQLException;


public class AlinabilirKitaplar {

    public static void adminAlinabilirKitaplarMethodu() throws InterruptedException, SQLException, ClassNotFoundException {


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
