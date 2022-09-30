package admin.KitapIslemleri;

import genel.KitapConst;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class KitapSil {

    //todo silinen kitapları göstermek için ayrı bir class yapılabilir. silinen kitap listesini gösterebiliriz.
    public static List<Object> silinenKitapListesi = new ArrayList<>();
    public static void adminKitapSilMethodu() throws InterruptedException, SQLException, ClassNotFoundException {



            System.out.println("Kitap Silme Islemleri");
            Scanner scan = new Scanner(System.in);

            AlinabilirKitaplar.kitaplariListele();
            System.out.print("Silmek istediğiniz kitabin ID numarısını giriniz :");
            int secim = scan.nextInt();

        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/LibraryOtomation", "postgres", "1234");
        Statement st = con.createStatement();

        String sqlKitapSilQuery = "DELETE FROM books WHERE kitapid = ?";
        PreparedStatement ps = con.prepareStatement(sqlKitapSilQuery);

        ps.setInt(1,secim);
      //  System.out.println();
        ps.executeUpdate();//todo bize int dönüyo 1den büyükse silindi,değilse silinmedi. if else yap
        System.out.println(secim+ " id numaralı kitap silindi");

          KitapMenusu.adminKitapMenusuMethodu();

        con.close();
        st.close();

    }
}
