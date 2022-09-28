package genel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class OpenConnection {

    public static void openConnection() throws ClassNotFoundException, SQLException {
        //1.adım driver yükle
        Class.forName("org.postgresql.Driver");

        // 2. Adim: Daatabase' e baglan
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/LibraryOtomation", "postgres", "1234");

        // 3. Adim: Statement olustur
        Statement st = con.createStatement();

    }

}
