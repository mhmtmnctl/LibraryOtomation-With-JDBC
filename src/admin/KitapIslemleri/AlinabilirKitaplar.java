package admin.KitapIslemleri;

import genel.KitapConst;

import java.sql.*;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;


public class AlinabilirKitaplar {

    public static void adminAlinabilirKitaplarMethodu() throws InterruptedException, SQLException, ClassNotFoundException {


        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/LibraryOtomation", "postgres", "1234");
        Statement st = con.createStatement();

        String alinabilirKitaplariGetir = "SELECT * FROM books WHERE alinabilirmi=true";
        ResultSet alinabilirKitaplar =  st.executeQuery(alinabilirKitaplariGetir);

        System.out.println("***Alınabilir Kitaplar***");
        while (alinabilirKitaplar.next()) {
            System.out.println(alinabilirKitaplar.getInt(1)+"-"+
                                  alinabilirKitaplar.getString(2)+"-"+
                                  alinabilirKitaplar.getString(3)+"-"+
                                  alinabilirKitaplar.getString(4));

        }

        KitapMenusu.adminKitapMenusuMethodu();

        con.close();
        st.close();

    }

}
