package genel;

import admin.KitapIslemleri.KitapMenusu;
import admin.KullaniciIslemleri.KullaniciEkle;
import user.UserIslemleri.UserLogin;
import user.UserKitap.UserKitapDurumu;

import javax.swing.*;
import java.sql.*;

public class DemoRunner {
    public static void main(String[] args) throws InterruptedException, ClassNotFoundException, SQLException {

        Class.forName("org.postgresql.Driver");

        // 2. Adim: Daatabase' e baglan
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/LibraryOtomation", "postgres", "1234");

        // 3. Adim: Statement olustur
        Statement st = con.createStatement();

        //  OpenConnection.openConnection();
        String sqlKullanicilariGetir = "SELECT * FROM kullanicilar";
       /*
        ResultSet result1= st.executeQuery(sql1);
        while (result1.next()){
            System.out.println(result1.getString(1)+"-->"+  result1.getInt(2));
        }
        */
        ResultSet users = st.executeQuery(sqlKullanicilariGetir);
        while (users.next()){

            System.out.println(users.getString(4)+"-->"+  users.getString(5));
        }
    }

}
