package admin.KullaniciIslemleri.kullaniciGuncelleme;

import admin.KullaniciIslemleri.KullaniciGuncelle;
import admin.KullaniciIslemleri.KullaniciMenusu;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class SifreGuncelle {
    public static void sifreGuncelle() throws ClassNotFoundException, SQLException, InterruptedException {
        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/LibraryOtomation", "postgres", "1234");
        Statement st = con.createStatement();

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
            kullaniciIDList.add(String.valueOf(kullanicilar.getInt(1)));
        }

        Scanner scan = new Scanner(System.in);
        System.out.print("Guncellemek istediğiniz kullanıcının  ID numarısını giriniz :");

        String secilenId = scan.next().replaceAll("\\D", "x1");//rakam dışındaki herşey
        while (secilenId.contains("x1")) {
            System.out.println("Lütfen sadece rakam giriniz!");
            System.out.print("Guncellemek istediğiniz kullanıcının  ID numarısını giriniz :");
            secilenId = scan.next();
        }
        while (!kullaniciIDList.contains(secilenId)) {
            System.out.println(secilenId + " numaralı ID'li bir kullanıcı yoktur. Lütfen tekrar deneyin");
            System.out.print("Guncellemek istediğiniz kullanıcının  ID numarısını giriniz :");
            secilenId = scan.next();
        }

        System.out.print("\nKullanici sifre giriniz (sifre en az 4 karakter uzunlugunda olmalidir) : ");
      String  kullaniciSifre = scan.next();

        while(kullaniciSifre.length()<4 || kullaniciSifre.contains(" ")) {
            System.out.println("sifre en az 4 karakter uzunlugunda olmalidir ve bosluk icermemelidir");
            kullaniciSifre = scan.next();
        }
        PreparedStatement ps = con.prepareStatement("UPDATE kullanicilar SET kullaniciSifre=? WHERE kullaniciid=?");
        ps.setString(1, kullaniciSifre);
        ps.setInt(2, Integer.parseInt(secilenId));
        ps.executeUpdate();

        System.out.println("İşlem başarılı...\n");
        System.out.print("Devam etmek istiyor musunuz?(e/h):");
        String devamMi = scan.next().toLowerCase();
        while (devamMi.equals("e") || devamMi.equals("h"))
        {
            if (devamMi.equals("e")) {
                System.out.println(secilenId + " id numaralı kullanıcı güncellendi");
                KullaniciGuncelle.adminKullaniciGuncelleMethodu();

            } else  {
                System.out.println(secilenId + " id numaralı kullanıcı güncellendi");
                System.out.println("İşlem başarılı...\n");
                System.out.print("Üst menuye yonlendiriliyorunuz");
                for (int i = 3; i >= 1; i--) {
                    System.out.print(".");
                    Thread.sleep(1000);
                }
                System.out.println();
                KullaniciMenusu.adminKullaniciIslemleriMenusuMethodu();
            }

        }
        System.out.println("Hatalı giriş yaptınız...");
        con.close();
        st.close();
        KullaniciGuncelle.adminKullaniciGuncelleMethodu();



    }
}
