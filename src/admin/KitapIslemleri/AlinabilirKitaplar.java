package admin.KitapIslemleri;

import genel.OpenConnection;

import java.sql.*;



public class AlinabilirKitaplar {

    public static void adminAlinabilirKitaplarMethodu() throws InterruptedException, SQLException, ClassNotFoundException {
        System.out.println("***Alınabilir Kitaplar***");
       kitaplariListele();
        KitapMenusu.adminKitapMenusuMethodu();

    }

    public static void kitaplariListele() throws ClassNotFoundException, SQLException {
       Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/LibraryOtomation", "postgres", "1234");
        Statement st = con.createStatement();
        String alinabilirKitaplariGetir = "SELECT * FROM books WHERE alinabilirmi=true";
        ResultSet alinabilirKitaplar =  st.executeQuery(alinabilirKitaplariGetir);
        while (alinabilirKitaplar.next()) {
            System.out.println(alinabilirKitaplar.getInt(1)+"-"+
                    alinabilirKitaplar.getString(2)+"-"+
                    alinabilirKitaplar.getString(3)+"-"+
                    alinabilirKitaplar.getString(4));
        }
        con.close();
        st.close();

    }

}
