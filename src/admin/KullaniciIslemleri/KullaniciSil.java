package admin.KullaniciIslemleri;

import admin.KitapIslemleri.KitapMenusu;
import genel.KullaniciConst;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class KullaniciSil {

    /*
         öncelikle kullanıcı listesini gösterelim
         oradan id seçsin
         Silmek istediğiniz kullanıcının ID numarasını gireniz:
         Listede olan ID seçmeli yoksa uyarı verelim
         seçip enter'a bastığında seçilen kullanıcı bilgilerini ekrana getirsin.
         sout(Seçilen kullanıcıyı silmek istediğinize emin misiniz e/h)
        e derse listten silsin  silmeden önce Silinenler listesi olsun. oraya ekleyelim
        sildikten sonra da  kullanıcıMenüsüne gitsin
         h derse silmeden kullanıcıMenüsüne gitsin.
         //kullanıcı yoksa kontrol edelim. önce ekletelim

     */
    public static List<Object> silinenlerListesi = new ArrayList<>(); //todo Listler classına taşımaya çalışalım
    public static void adminKullaniciSilMethodu() throws InterruptedException, SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/LibraryOtomation", "postgres", "1234");
        Statement st = con.createStatement();

        System.out.println("Kullanici Silme Islemleri");
        String sqlKullanicilar = "SELECT * FROM kullanicilar";
        ResultSet kullanicilar =  st.executeQuery(sqlKullanicilar);
        //1	"Ersin"	"AKUN"	"ersinakun34@gmail.com"	"1234"	"2126140853"	10
        while (kullanicilar.next()) {
            System.out.println(kullanicilar.getInt(1)+"-"+ //id
                    kullanicilar.getString(2)+"-"+//ad
                    kullanicilar.getString(3)+"-"+//soyad
                    kullanicilar.getString(4)+"-"+//mail
                    kullanicilar.getString(5)+"-"+//şifre
                    kullanicilar.getString(6)+"-"+//tel
                    kullanicilar.getInt(7));//puan
        }
        Scanner scan = new Scanner(System.in);
       // System.out.println(KullaniciEkle.kullaniciList);
        System.out.print("Silmek istediğiniz kullanıcının  ID numarısını giriniz :");
        int secilenId = scan.nextInt();



        String sqlKullaniciSilQuery = "DELETE FROM kullanicilar WHERE kullaniciid = ?";
        PreparedStatement ps = con.prepareStatement(sqlKullaniciSilQuery);

        ps.setInt(1,secilenId);
        //  System.out.println();
        ps.executeUpdate();
        System.out.println(secilenId+ " id numaralı kullanıcı silindi");


        con.close();
        st.close();

            KullaniciMenusu.adminKullaniciIslemleriMenusuMethodu();

        }

    }

