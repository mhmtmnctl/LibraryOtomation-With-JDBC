package admin.KitapIslemleri;
import java.sql.*;
import java.util.Scanner;
import static genel.Renklendirme.ANSI_GREEN;
import static genel.Renklendirme.ANSI_RESET;
public class KitapEkle {

    public static String kitapAdi;
    public static String kitapYazari;
    public static String kitapTuru;

    public static void adminKitapEkleMethodu() throws InterruptedException, SQLException, ClassNotFoundException {

        Scanner scan = new Scanner(System.in);
        System.out.print("Kitap adini giriniz : ");
        kitapAdi = scan.nextLine().toUpperCase();

        System.out.print("\nKitap yazarini giriniz :");//todo int değer girilmesin yazar ve türüne... boş da girilmesin
        kitapYazari = scan.nextLine().toUpperCase();

        System.out.print("\nKitap turunu giriniz : ");
        kitapTuru = scan.nextLine().toUpperCase();
        System.out.println("");

        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/LibraryOtomation", "postgres", "1234");
        Statement st = con.createStatement();

        PreparedStatement ps = con.prepareStatement("INSERT INTO books VALUES(DEFAULT,?, ?, ?,true,NULL,NULL,NULL)");

        ps.setString(1,kitapAdi);
        ps.setString(2,kitapYazari);
        ps.setString(3,kitapTuru);
        if ( ps.executeUpdate()==1) {
            System.out.println(ANSI_GREEN +"Kitap başarıyla eklendi..."+ ANSI_RESET);
        }
        else System.err.println("Kitap ekleme başarısız...");

        KitapMenusu.adminKitapMenusuMethodu();

        con.close();
        st.close();

    }

}
