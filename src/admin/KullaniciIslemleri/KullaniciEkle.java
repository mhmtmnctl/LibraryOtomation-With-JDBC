package admin.KullaniciIslemleri;
import genel.Renklendirme;
import java.sql.*;
import java.util.Scanner;
public class KullaniciEkle {

   public static int kullaniciId;
   public static String kullaniciAdi;
   public static String kullaniciSoyadi;
   public static String kullaniciMail;
   public static String kullaniciSifre;
   public static String kullaniciTelNo;
   public static int kullaniciPuan = 10;

    public static void adminKullaniciEkleMethodu() throws InterruptedException, SQLException, ClassNotFoundException {

        //todo KullanıcıIslemleri altında kayıtlı kullanıcılar diye bi class oluşturabiliriz. kullanıcıları listelemek için
        System.out.println(Renklendirme.ANSI_BLUE + "========================================" + Renklendirme.ANSI_RESET);
        System.out.println(Renklendirme.ANSI_GREEN + "-----Kullanıcı Ekleme İşlemi-----" + Renklendirme.ANSI_RESET);
        System.out.println(Renklendirme.ANSI_RED + "Eklemek istediğiniz kullanıcının bilgilerini eksiksiz giriniz" +Renklendirme.ANSI_RESET);
        Scanner scan = new Scanner(System.in);
        System.out.print("Kullanici adini giriniz : ");

        kullaniciAdi = scan.nextLine().toUpperCase().replaceAll("\\d","x1");

        while (kullaniciAdi.isEmpty() || kullaniciAdi.contains("x1")){
            System.out.println("Kullanıcı adı boş olamaz ve rakam içeremez");
            System.out.print("Kullanici adini giriniz : ");
            kullaniciAdi = scan.nextLine().toUpperCase().replaceAll("\\d","x1");
        }

        System.out.print("Kullanici Soyadini giriniz :");
        kullaniciSoyadi =  scan.nextLine().toUpperCase().replaceAll("\\d","x1").replaceAll("\\s","");
        while (kullaniciSoyadi.isEmpty() || kullaniciSoyadi.contains("x1")){
            System.out.println("Kullanıcı soyadı boş olamaz ve rakam içeremez");
            System.out.print("Kullanici Soyadini giriniz :");
            kullaniciSoyadi = scan.nextLine().toUpperCase().replaceAll("\\d","x1").replaceAll("\\s","");
        }
        System.out.print("Kullanici mail adresini giriniz : ");
        kullaniciMail = scan.next();

        while (!(kullaniciMail.contains("@") && kullaniciMail.contains(".")))
        {
            System.out.println("Lutfen gecerli bir mail adresi giriniz ...");
            System.out.print("Kullanici mail adresini giriniz : ");
            kullaniciMail=scan.next();
        }

        System.out.print("Kullanici sifre giriniz (sifre en az 4 karakter uzunlugunda olmalidir) : ");
        kullaniciSifre = scan.next();
        while(kullaniciSifre.length()<4 || kullaniciSifre.contains(" ")){
            System.out.println("sifre en az 4 karakter uzunlugunda olmalidir ve bosluk icermemelidir");
            System.out.print("Kullanici sifre giriniz (sifre en az 4 karakter uzunlugunda olmalidir) : ");
            kullaniciSifre = scan.next();
        }

        System.out.print("Telefon numarasinı 10 haneli olarak giriniz : ");
        kullaniciTelNo = scan.next().replaceAll("\\s","").replaceAll("\\D","x1");
        while (!(kullaniciTelNo.length()==10) || kullaniciTelNo.isEmpty() || kullaniciTelNo.contains("x1")){
            System.out.println(kullaniciTelNo);
            System.out.println("telefon numarası 10 haneli olmalı ve boş olmamalı!");
            System.out.print("Telefon numarasinı 10 haneli olarak giriniz : ");
            kullaniciTelNo = scan.next().replaceAll("\\s","").replaceAll("\\D","x1");
        }

        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/LibraryOtomation", "postgres", "1234");
        Statement st = con.createStatement();

        PreparedStatement ps = con.prepareStatement("INSERT INTO kullanicilar VALUES(DEFAULT,?, ?, ?,?,?,10)");
        ps.setString(1,kullaniciAdi);
        ps.setString(2,kullaniciSoyadi);
        ps.setString(3,kullaniciMail);
        ps.setString(4,kullaniciSifre);
        ps.setString(5,kullaniciTelNo);
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
