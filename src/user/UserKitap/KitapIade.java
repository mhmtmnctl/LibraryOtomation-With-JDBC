package user.UserKitap;

import admin.KitapIslemleri.KitapEkle;
import genel.KitapConst;
import user.UserIslemleri.UserLogin;

import java.sql.*;
import java.util.Scanner;

public class KitapIade {

    static Scanner scan = new Scanner(System.in);

    public static void userKitapIadeMethodu() throws InterruptedException, SQLException, ClassNotFoundException {

        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/LibraryOtomation", "postgres", "1234");
        Statement st = con.createStatement();
      //  String sqlQuery="SELECT * FROM books WHERE kitapid=?";
        PreparedStatement ps = con.prepareStatement("SELECT * FROM books WHERE alankisi=?");
        ps.setString(1, UserLogin.loginId);
      //  ps.executeUpdate();
        ResultSet kullaniciKitaplari =  ps.executeQuery();
       // ResultSet alinabilirKitaplar =  st.executeQuery(alinabilirKitaplariGetir);
        System.out.println("***İade edebileceğiniz  Kitaplar***");
        while (kullaniciKitaplari.next()) {
            System.out.println(kullaniciKitaplari.getInt(1)+"-"+
                    kullaniciKitaplari.getString(2)+"-"+
                    kullaniciKitaplari.getString(3)+"-"+
                    kullaniciKitaplari.getString(4));

        }

            System.out.print("Iade etmek istediginiz kitabin ID numarasini giriniz : ");
            int secim = scan.nextInt();

        PreparedStatement ps2 = con.prepareStatement("UPDATE books SET alinabilirmi=true,alinmatarihi=null,iadetarihi=null,9alankisi=null WHERE kitapid=?");
        ps2.setInt(1,secim);
            ps2.executeUpdate();

            System.out.println("Tesekkurler, kitap basarili sekilde iade edildi");

        con.close();
        st.close();
//todo iade edeceği kitap yoksa kontrol et
            UserIslemMenusu.userKitapIslemMenusuMethodu();

    }
}
