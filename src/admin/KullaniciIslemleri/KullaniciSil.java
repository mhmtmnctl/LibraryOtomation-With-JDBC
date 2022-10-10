package admin.KullaniciIslemleri;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;
public class KullaniciSil {


    public static void adminKullaniciSilMethodu() throws InterruptedException, SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/LibraryOtomation", "postgres", "1234");
        Statement st = con.createStatement();

        System.out.println("Kullanici Silme Islemleri");
        String sqlKullanicilar = "SELECT * FROM kullanicilar";
        ResultSet kullanicilar =  st.executeQuery(sqlKullanicilar);
        ArrayList<String> kullaniciIDList= new ArrayList<>();
        while (kullanicilar.next()) {
            System.out.println(kullanicilar.getInt(1)+"-"+ //id
                    kullanicilar.getString(2)+"-"+//ad
                    kullanicilar.getString(3)+"-"+//soyad
                    kullanicilar.getString(4)+"-"+//mail
                    kullanicilar.getString(5)+"-"+//şifre
                    kullanicilar.getString(6)+"-"+//tel
                    kullanicilar.getInt(7));//puan
                    kullaniciIDList.add(String.valueOf((kullanicilar.getInt(1))));
        }

        Scanner scan = new Scanner(System.in);
        System.out.print("Silmek istediğiniz kullanıcının  ID numarısını giriniz :");
        String secilenId = scan.next();

       if (kullaniciIDList.contains(secilenId)){

           String sqlKullaniciSilQuery = "DELETE FROM kullanicilar WHERE kullaniciid = ?";
           PreparedStatement ps = con.prepareStatement(sqlKullaniciSilQuery);
           ps.setInt(1, Integer.parseInt(secilenId));
           ps.executeUpdate();
           System.out.println(secilenId+ " id numaralı kullanıcı silindi");

       }
       else {
           System.out.println("Kayıt silinemedi/bulunamadı,lütfen tekrar deneyin!");
            KullaniciMenusu.adminKullaniciIslemleriMenusuMethodu();
       }

        con.close();
        st.close();

            KullaniciMenusu.adminKullaniciIslemleriMenusuMethodu();
        }
    }

