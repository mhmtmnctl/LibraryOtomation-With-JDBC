package admin.KitapIslemleri;

import genel.KitapConst;

import java.sql.*;


public class AlinmisKitaplar {
    public static void adminAlinmisKitaplarMethodu() throws InterruptedException, SQLException, ClassNotFoundException {


        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/LibraryOtomation", "postgres", "1234");
        Statement st = con.createStatement();

        String alinmisKitaplariGetir = "SELECT * FROM books WHERE alinabilirmi=false";
        ResultSet alinmisKitaplar =  st.executeQuery(alinmisKitaplariGetir);

        System.out.println("***Alınmış Kitaplar***");
        //todo alınmış kitap yoksa yok diye yazdır
        while (alinmisKitaplar.next()) {
            System.out.println(alinmisKitaplar.getInt(1)+"-"+
                    alinmisKitaplar.getString(2)+"-"+
                    alinmisKitaplar.getString(3)+"-"+
                    alinmisKitaplar.getString(4)+"-"+
                    alinmisKitaplar.getString(6)+"-"+
                    alinmisKitaplar.getString(7));

        }

        KitapMenusu.adminKitapMenusuMethodu();

        con.close();
        st.close();

        KitapMenusu.adminKitapMenusuMethodu();

    }
}
