package user.UserKitap;

import user.UserIslemleri.UserLogin;

import java.sql.*;

import java.util.Scanner;

public class UserKitapDurumu extends KitapAl {

    public static void userKitapDurumuMethodu() throws InterruptedException, SQLException, ClassNotFoundException {
        String tercih;
        Scanner scan = new Scanner(System.in);
        do {
            System.out.println("Guncel kitap durumunuz :");
            System.out.printf("-------------------------------------------%n");
            System.out.printf("| %-10s | %-12s | %6s |%n", "Aldiginiz kitaplar", " Alinma tarihi", "  Teslim tarihi");

            alinmisKitap();
            System.out.printf("-------------------------------------------%n");
            System.out.print("Ust menuye gitmek icin 9'a basiniz :");
            tercih = scan.next();
        }while(!tercih.equals("9"));
        if (tercih.equals("9")){
            UserIslemMenusu.userKitapIslemMenusuMethodu();
        }else {
            System.out.println("Yanlis giris yaptiniz, Lutfen 9'a basiniz...");
            userKitapDurumuMethodu();
        }
    }
    public static void alinmisKitap() throws ClassNotFoundException, SQLException {

        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/LibraryOtomation", "postgres", "1234");
        Statement st = con.createStatement();

        PreparedStatement ps = con.prepareStatement("SELECT * FROM books WHERE alankisi=?");
        ps.setString(1, UserLogin.loginId);
        ResultSet kullaniciKitaplari =  ps.executeQuery();
        while (kullaniciKitaplari.next()) {
            System.out.println(kullaniciKitaplari.getString(2)+"              -"+
                    //todo db de iade tarihi tutmadan dtf ile yapılabilir mi
                    kullaniciKitaplari.getString(6)+"              -"+
                    kullaniciKitaplari.getString(7));
        }
        con.close();
        st.close();

    }

}