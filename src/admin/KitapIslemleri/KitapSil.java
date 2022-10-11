package admin.KitapIslemleri;
import java.sql.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
public class KitapSil {
    public static void adminKitapSilMethodu() throws InterruptedException, SQLException, ClassNotFoundException {

            System.out.println("***Kitap Silme Islemleri***");
            Scanner scan = new Scanner(System.in);
            //todo düzenli olması için kitapid----kitap adı--- şeklinde printf ile düzenle boşluk kontrol et
        //todo olmayan id girildiğinde kontrol et
        //AlinabilirKitaplar.kitaplariListele();
        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/LibraryOtomation", "postgres", "1234");
        Statement st = con.createStatement();

        String alinabilirKitaplariGetir = "SELECT * FROM books WHERE alinabilirmi=true";
        ResultSet alinabilirKitaplar =  st.executeQuery(alinabilirKitaplariGetir);

        ArrayList<String> kitapIDList= new ArrayList<>();
        while (alinabilirKitaplar.next()) {
            System.out.println(alinabilirKitaplar.getInt(1)+"-"+
                    alinabilirKitaplar.getString(2)+"-"+
                    alinabilirKitaplar.getString(3)+"-"+
                    alinabilirKitaplar.getString(4));
            kitapIDList.add(String.valueOf((alinabilirKitaplar.getInt(1))));
        }

            System.out.print("Silmek istediğiniz kitabin ID numarısını giriniz :");

                String  secim = scan.next();

                if (kitapIDList.contains(secim)){
                    String sqlKitapSilQuery = "DELETE FROM books WHERE kitapid = ?";
                    PreparedStatement ps = con.prepareStatement(sqlKitapSilQuery);

                    ps.setInt(1, Integer.parseInt(secim));
                    ps.executeUpdate();
                    System.out.println(secim+ " id numaralı kitap silindi");
                }
                else {
                    System.out.println("Lütfen doğru giriş yapınız!!!");
                    KitapMenusu.adminKitapMenusuMethodu();
                }

                con.close();
                st.close();

          KitapMenusu.adminKitapMenusuMethodu();
    }
}
