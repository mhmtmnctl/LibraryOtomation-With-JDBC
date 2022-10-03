package user.UserKitap;

import admin.KitapIslemleri.AlinabilirKitaplar;
import admin.KitapIslemleri.AlinmisKitaplar;
import admin.KitapIslemleri.KitapEkle;
import genel.KitapConst;
import genel.KullaniciConst;
import user.UserIslemleri.UserLogin;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class KitapAl {

    public static void userKitapAlMethodu() throws InterruptedException, SQLException, ClassNotFoundException {


       // System.out.println("mail adresi "+UserLogin.mail);
       // AlinabilirKitaplar.adminAlinabilirKitaplarMethodu();
       // System.out.println("AlinabilirKitaplar.alinabilirKitapListesi = " + AlinabilirKitaplar.alinabilirKitapListesi);


       // System.out.println(KitapEkle.kitapList);
        System.out.println("Alabileceğiniz kitaplar aşağıdadır");
        AlinabilirKitaplar.kitaplariListele();

        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/LibraryOtomation", "postgres", "1234");
        Statement st = con.createStatement();

        System.out.print("İstediğiniz kitabın ID numarasının giriniz :");
        Scanner scan = new Scanner(System.in);
        int secim = scan.nextInt();

            LocalDateTime trh = LocalDateTime.now();
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MMM/yyyy");

        PreparedStatement ps = con.prepareStatement("UPDATE books SET alinabilirmi=false,alankisi=?,alinmatarihi=? WHERE kitapid=?");
        ps.setString(1, UserLogin.loginId);
        ps.setString(2, dtf.format(trh));
        ps.setInt(3,secim);
        ps.executeUpdate();

            System.out.println(secim+" Id Numarali Kitabi "+dtf.format(trh)+" Tarihinde aldiniz" +
                    "\nTeslim Tarihiniz : "+dtf.format(trh.plusDays(14))+" dir");

        con.close();
        st.close();

        UserIslemMenusu.userKitapIslemMenusuMethodu();



    }
}

