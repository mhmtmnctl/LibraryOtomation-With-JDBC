package admin.KitapIslemleri;

import genel.KitapConst;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AlinmisKitaplar {

    /*
    alınmışKitaplar listini göster
    ////////////
    (1,java,ahmet,bilim,sezerID,tarih)
     */
    public static List<Object> alinmisKitapListesi = new ArrayList<>();
    public static void adminAlinmisKitaplarMethodu(){

        //önce kullanıcının alması lazım

        for (KitapConst each:KitapEkle.kitapList) {
            if (!each.alinaBilirMi)
            {
                alinmisKitapListesi.add(each);
            }

        }
        System.out.println(alinmisKitapListesi);


    }
}
