package user.UserKitap;

import user.UserIslemleri.UserLogin;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class KitapIade {

    static Scanner scan = new Scanner(System.in);

    public static void userKitapIadeMethodu() throws InterruptedException, SQLException, ClassNotFoundException {

        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/LibraryOtomation", "postgres", "1234");
        Statement st = con.createStatement();

        PreparedStatement ps = con.prepareStatement("SELECT * FROM books WHERE alankisi=?");
        ps.setString(1, UserLogin.loginId);
        ResultSet kullaniciKitaplari =  ps.executeQuery();
        ArrayList<String> kitapIDList= new ArrayList<>();
        System.out.println("***İade edebileceğiniz  Kitaplar***");
        while (kullaniciKitaplari.next()) {
            System.out.println(kullaniciKitaplari.getInt(1)+"-"+
                    kullaniciKitaplari.getString(2)+"-"+
                    kullaniciKitaplari.getString(3)+"-"+
                    kullaniciKitaplari.getString(4));
            kitapIDList.add(String.valueOf((kullaniciKitaplari.getInt(1))));
        }
        if (kitapIDList.isEmpty()){
            System.out.println("İade edebileceğiniz kitap yoktur");
        }

        else {
            System.out.print("Iade etmek istediginiz kitabin ID numarasini giriniz : ");
            String secim = scan.next();
            if (kitapIDList.contains(secim)){
                PreparedStatement ps2 = con.prepareStatement("UPDATE books SET alinabilirmi=true,alinmatarihi=null,iadetarihi=null,alankisi=null WHERE kitapid=?");
                ps2.setInt(1, Integer.parseInt(secim));
                ps2.executeUpdate();

                System.out.println("Tesekkurler, kitap basarili sekilde iade edildi");

                con.close();
                st.close();
            }
            else {
                System.out.println("Hatalı giriş yaptınız");
                con.close();
                st.close();
                UserIslemMenusu.userKitapIslemMenusuMethodu();
            }
        }




            UserIslemMenusu.userKitapIslemMenusuMethodu();

    }
}
