package admin.KitapIslemleri;

import genel.KitapConst;

import java.sql.*;
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
        System.out.println("");

        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/LibraryOtomation", "postgres", "1234");
        Statement st = con.createStatement();


        PreparedStatement ps = con.prepareStatement("INSERT INTO books VALUES(DEFAULT,?, ?, ?,true,NULL,NULL,NULL)");

        ps.setString(1,kitapAdi);
        ps.setString(2,kitapYazari);
        ps.setString(3,kitapTuru);
        ps.executeUpdate();
        System.out.println("kitap eklendi");

        KitapMenusu.adminKitapMenusuMethodu();

        con.close();
        st.close();

    }

}
