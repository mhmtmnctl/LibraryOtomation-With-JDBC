package admin.KitapIslemleri;

import genel.KitapConst;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class KitapEkle {

    public static List<KitapConst> kitapList = new ArrayList<>();

    public static int kitapId;
    public static String kitapAdi;
    public static String kitapYazari;
    public static String kitapTuru;
    public static boolean alinaBilirMi=true;
    public static String alinmaTarihi;
    public static String alanKisi="-";

    public static void adminKitapEkleMethodu() throws InterruptedException, SQLException, ClassNotFoundException {

        Scanner scan = new Scanner(System.in);
        System.out.print("Kitap adini giriniz : ");
        kitapAdi = scan.nextLine();

        System.out.print("\nKitap yazarini giriniz :");
        kitapYazari = scan.nextLine();
        System.out.print("\nKitap turunu giriniz : ");
        kitapTuru = scan.nextLine();

        KitapConst kitap = new KitapConst(kitapId, kitapAdi, kitapYazari, kitapTuru,alinaBilirMi,alinmaTarihi,alanKisi);


       // kitapList.add(kitap);
      //  System.out.println(kitapList);
    //    kitapId++;
        System.out.println("Kitap başarılı şekilde eklendi...\n");
        System.out.println("Kitap Islemleri Menusune Yonlendiriliyorunuz ");
        for (int i = 3; i >= 1; i--) {
            System.out.print(i + " ");
            Thread.sleep(1000);
        }
        System.out.println("");

        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/LibraryOtomation", "postgres", "1234");
        Statement st = con.createStatement();
//todo prepared statement ile yapalım
        /*
        PreparedStatement ps = con.prepareStatement("INSERT INTO ogrenciler VALUES(?, ?, ?, ?)");
        ps.setInt(1, 200);
        ps.setString(2,"Veli Can");
        ps.setString(3,"12");
        ps.setString(4,"E");
         */
        String sqlQueryKitapEkle="INSERT INTO books (kitapId,kitapAdi,kitapYazari,kitapTuru,alinaBilirMi,alinmaTarihi,alanKisi) VALUES (DEFAULT,"+kitapAdi+","+kitapYazari+",'deneme',true,NULL,NULL)";
        st.execute(sqlQueryKitapEkle);

        KitapMenusu.adminKitapMenusuMethodu();



        con.close();
        st.close();

    }
}
