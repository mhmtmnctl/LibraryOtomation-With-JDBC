package admin.KullaniciIslemleri;
import genel.KullaniciKontrol;
import genel.Renklendirme;
import java.sql.*;
public class KullaniciEkle {
   public static int kullaniciId;
   public static String kullaniciAdi;
   public static String kullaniciSoyadi;
   public static String kullaniciMail;
   public static String kullaniciSifre;
   public static String kullaniciTelNo;
   public static int kullaniciPuan = 10;

    public static void adminKullaniciEkleMethodu() throws InterruptedException, SQLException, ClassNotFoundException {

        System.out.println(Renklendirme.ANSI_BLUE + "========================================" + Renklendirme.ANSI_RESET);
        System.out.println(Renklendirme.ANSI_GREEN + "-----Kullanıcı Ekleme İşlemi-----" + Renklendirme.ANSI_RESET);
        System.out.println(Renklendirme.ANSI_RED + "Eklemek istediğiniz kullanıcının bilgilerini eksiksiz giriniz" +Renklendirme.ANSI_RESET);

        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/LibraryOtomation", "postgres", "1234");
        Statement st = con.createStatement();

        PreparedStatement ps = con.prepareStatement("INSERT INTO kullanicilar VALUES(DEFAULT,?, ?, ?,?,?,10)");
        ps.setString(1, KullaniciKontrol.IsimKontrol());
        ps.setString(2, KullaniciKontrol.soyIsimKontrol());
        ps.setString(3, KullaniciKontrol.mailKontrol());
        ps.setString(4, KullaniciKontrol.sifreKontrol());
        ps.setString(5, KullaniciKontrol.telNoKontrol());
        ps.executeUpdate();

        con.close();
        st.close();

        System.out.println("İşlem başarılı...\n");
        System.out.print("Üst menuye yonlendiriliyorunuz");
        for (int i = 3; i >= 1; i--) {
            System.out.print(".");
            Thread.sleep(1000);
        }
        KullaniciMenusu.adminKullaniciIslemleriMenusuMethodu();
        System.out.println();
    }
}