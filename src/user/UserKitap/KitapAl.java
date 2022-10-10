package user.UserKitap;
import admin.KitapIslemleri.AlinabilirKitaplar;
import user.UserIslemleri.UserLogin;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class KitapAl {
   public static String iadeTarihi;

    public static void userKitapAlMethodu() throws InterruptedException, SQLException, ClassNotFoundException {

        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/LibraryOtomation", "postgres", "1234");
        Statement st = con.createStatement();

        System.out.println("Alabileceğiniz kitaplar aşağıdadır");
        ArrayList<String> kitapIDList= new ArrayList<>();

        String alinabilirKitaplariGetir = "SELECT * FROM books WHERE alinabilirmi=true";
        ResultSet alinabilirKitaplar =  st.executeQuery(alinabilirKitaplariGetir);
        while (alinabilirKitaplar.next()) {
            System.out.println(alinabilirKitaplar.getInt(1)+"-"+
                    alinabilirKitaplar.getString(2)+"-"+
                    alinabilirKitaplar.getString(3)+"-"+
                    alinabilirKitaplar.getString(4));
            kitapIDList.add(String.valueOf((alinabilirKitaplar.getInt(1))));
        }


        System.out.print("İstediğiniz kitabın ID numarasının giriniz :");
        Scanner scan = new Scanner(System.in);
        String secim = scan.next();

        if (kitapIDList.contains(secim)){
            LocalDateTime trh = LocalDateTime.now();
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MMM/yyyy");

            PreparedStatement ps = con.prepareStatement("UPDATE books SET alinabilirmi=false,alankisi=?,alinmatarihi=?,iadetarihi=? WHERE kitapid=?");
            ps.setString(1, UserLogin.loginId);
            ps.setString(2, dtf.format(trh));
            ps.setString(3, dtf.format(trh.plusDays(14)));
            ps.setInt(4, Integer.parseInt(secim));
            ps.executeUpdate();
            iadeTarihi = dtf.format(trh.plusDays(14));
            System.out.println(secim+" Id Numarali Kitabi "+dtf.format(trh)+" Tarihinde aldiniz" +
                    "\nTeslim Tarihiniz : "+dtf.format(trh.plusDays(14))+" dir");
            con.close();
            st.close();
        }
        else {
            System.out.println(secim+" id'li bir kitap yoktur");
            con.close();
            st.close();
            UserIslemMenusu.userKitapIslemMenusuMethodu();
        }

        UserIslemMenusu.userKitapIslemMenusuMethodu();

    }
}

