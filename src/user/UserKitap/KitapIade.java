package user.UserKitap;

import admin.KitapIslemleri.KitapEkle;
import genel.KitapConst;
import user.UserIslemleri.UserLogin;

import java.util.Scanner;

public class KitapIade {
    /*
    hiç kitap almamışsa iade edebileceğiniz bir kitap yok
    üst menüye git

    alınmışkitapListte login olan kullanıcının ID'si varsa(son indexte) o kitapları gösterelim.

    daha sonra o kitabı alınmışKitap listesinden silip, alınabilirKitap listesine ekliycez ama sondaki ID'yi yazmıcaz
     */
    static Scanner scan = new Scanner(System.in);

    public static void userKitapIadeMethodu() throws InterruptedException {
        int sayac = 0;
        for (KitapConst each : KitapEkle.kitapList) {
            if (each.alanKisi.contains(UserLogin.loginId)) {
                System.out.println(each);
                sayac++;
            }
        }
        if (sayac > 0) {
            System.out.print("Iade etmek istediginiz kitabin ID numarasini giriniz : ");
            int secim = scan.nextInt();
            int indexDegeri = 0;
            int iadeEdilecekKitap = 0;

            for (KitapConst each : KitapEkle.kitapList) {

                if (each.kitapId == secim) {
                    iadeEdilecekKitap = indexDegeri;
                }
                indexDegeri++;
            }
            KitapEkle.kitapList.get(iadeEdilecekKitap).alanKisi = "-";
            KitapEkle.kitapList.get(iadeEdilecekKitap).alinaBilirMi = true;
            KitapEkle.kitapList.get(iadeEdilecekKitap).alinmaTarihi = "-";
            System.out.println("Tesekkurler, kitap basarili sekilde iade edildi");
            UserIslemMenusu.userKitapIslemMenusuMethodu();

        }else {
            System.out.println("Iade edebileceginiz kitap yoktur");
            UserIslemMenusu.userKitapIslemMenusuMethodu();
        }


    }

}
