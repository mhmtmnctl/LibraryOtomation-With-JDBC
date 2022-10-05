package admin.KitapIslemleri;
import java.sql.*;
import java.util.InputMismatchException;
import java.util.Scanner;
public class KitapSil {
    public static void adminKitapSilMethodu() throws InterruptedException, SQLException, ClassNotFoundException {

            System.out.println("***Kitap Silme Islemleri***");
            Scanner scan = new Scanner(System.in);
            //todo düzenli olması için kitapid----kitap adı--- şeklinde printf ile düzenle boşluk kontrol et
            AlinabilirKitaplar.kitaplariListele();
            System.out.print("Silmek istediğiniz kitabin ID numarısını giriniz :");
            try {
                int  secim = scan.nextInt();
                Class.forName("org.postgresql.Driver");
                Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/LibraryOtomation", "postgres", "1234");
                Statement st = con.createStatement();

                String sqlKitapSilQuery = "DELETE FROM books WHERE kitapid = ?";
                PreparedStatement ps = con.prepareStatement(sqlKitapSilQuery);

                ps.setInt(1,secim);
                ps.executeUpdate();
                System.out.println(secim+ " id numaralı kitap silindi");
                con.close();
                st.close();
            }
            catch (InputMismatchException e)
            {
                e.getMessage();
                System.out.println("Lütfen doğru giriş yapınız!!!");
                adminKitapSilMethodu();
            }
          KitapMenusu.adminKitapMenusuMethodu();
    }
}
