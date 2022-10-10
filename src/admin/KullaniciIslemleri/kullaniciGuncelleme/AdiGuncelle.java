package admin.KullaniciIslemleri.kullaniciGuncelleme;
import admin.KullaniciIslemleri.KullaniciGuncelle;
import admin.KullaniciIslemleri.KullaniciMenusu;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class AdiGuncelle {
    public static void adiGuncelle() throws SQLException, ClassNotFoundException, InterruptedException {

        //todo tekrar eden kodlar bir metoddan çağırılabilir. parametre ile gerekli bilgileri gönderebiliriz
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

        PreparedStatement ps = con.prepareStatement("UPDATE kullanicilar SET kullaniciadi=? WHERE kullaniciid=?");
        System.out.print("Kullanici adini giriniz : ");
        String kullaniciAdi = scan.nextLine().toUpperCase().replaceAll("\\d", "x1");
        while (kullaniciAdi.isEmpty() || kullaniciAdi.contains("x1")) {
            System.out.println("Kullanıcı adı boş olamaz ve rakam içeremez");
            System.out.print("Kullanici adini giriniz : ");
            kullaniciAdi = scan.nextLine().toUpperCase().replaceAll("\\d", "x1");
        }

        ps.setString(1, kullaniciAdi);
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
        //todo liste tekrar tekrar doluyor mu? öyleyse metod sonunda listeyi temizle


    }
}
