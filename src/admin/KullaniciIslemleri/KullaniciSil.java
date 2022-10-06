package admin.KullaniciIslemleri;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class KullaniciSil {

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
        System.out.print("Silmek istediğiniz kullanıcının  ID numarısını giriniz :");
        int secilenId = scan.nextInt();


        //todo olmayan bir id seçerse kontrol et, id dışında string girerse kontrol et. boşluk vs
        String sqlKullaniciSilQuery = "DELETE FROM kullanicilar WHERE kullaniciid = ?";
        PreparedStatement ps = con.prepareStatement(sqlKullaniciSilQuery);

        ps.setInt(1,secilenId);
        ps.executeUpdate();
        System.out.println(secilenId+ " id numaralı kullanıcı silindi");


        con.close();
        st.close();

            KullaniciMenusu.adminKullaniciIslemleriMenusuMethodu();

        }
    }

