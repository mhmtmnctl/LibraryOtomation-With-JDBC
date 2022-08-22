package user.UserKitap;

import admin.KitapIslemleri.KitapEkle;
import genel.KitapConst;
import user.UserIslemleri.UserLogin;

public class UserKitapDurumu {
    /*
                 Kitap Durumları

    Alınmış Kitaplar    Alınma Tarihi   İade Durumu
       JavaBook         01.08.2022      İade edildi/edilmediyse iade edilmesine kaç gün kaldı/süresi geçtiyse Acil teslim edin

   //    eskiyi gösteremiyoruz çünkü database yok.
       şuan okuduğu kitabı gösterelim.

       çıkış/üstmenü için 0'a basınız.

     */
    public static void userKitapDurumuMethodu() {
        System.out.println("Guncel kitap durumunuz :");
        System.out.printf("-------------------------------------------%n");
        System.out.printf("| %-10s | %-12s | %6s |%n", "Alinmis kitaplar", " Alinma tarihi", "  Iade durumu");


        System.out.printf(alinmisKitap());
        System.out.printf("-------------------------------------------%n");
    }

    public static String alinmisKitap() {
        String iadeDurumu="";
        String alinanKitaplar="";
        for (KitapConst each : KitapEkle.kitapList) {
            if (each.alanKisi.contains(UserLogin.mail)) {
                if (each.alinaBilirMi==false){
                    iadeDurumu = "Iade edilmedi";
                }
               alinanKitaplar+=each.kitapAdi+"              "+each.alinmaTarihi+"         "+iadeDurumu+"\n";

            }
        }

        return alinanKitaplar;
    }
}