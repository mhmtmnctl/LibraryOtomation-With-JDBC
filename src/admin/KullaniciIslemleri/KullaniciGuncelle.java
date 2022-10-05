package admin.KullaniciIslemleri;
import java.sql.*;
import java.util.*;
public class KullaniciGuncelle {
    public static void adminKullaniciGuncelleMethodu() throws InterruptedException, SQLException, ClassNotFoundException {
        System.out.println("Kullanici Guncelleme Islemleri");

        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/LibraryOtomation", "postgres", "1234");
        Statement st = con.createStatement();
        String sqlKullanicilar = "SELECT * FROM kullanicilar";
        ResultSet kullanicilar =  st.executeQuery(sqlKullanicilar);
        ArrayList<String> kullaniciIDList= new ArrayList<>();
        //todo printf ile düzenli şekilde gösterilsin
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
        System.out.println(kullaniciIDList);
        Scanner scan = new Scanner(System.in);
        System.out.print("Guncellemek istediğiniz kullanıcının  ID numarısını giriniz :");

        String secilenId = scan.next().replaceAll("\\D", "x1");//rakam dışındaki herşey
        System.out.println(secilenId);
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

     scan.nextLine();
        System.out.print("Kullanici adini giriniz : ");
       String kullaniciAdi = scan.nextLine().toUpperCase();
        System.out.print("\nKullanici Soyadini giriniz :");
      String  kullaniciSoyadi = scan.next().toUpperCase();
        System.out.print("\nKullanici mail adresini giriniz : ");
      String  kullaniciMail = scan.next();
        while (!(kullaniciMail.contains("@") && kullaniciMail.contains(".")))
        {
            System.out.println("Lutfen gecerli bir mail adresi giriniz ...");
            kullaniciMail=scan.next();
        }

        System.out.print("\nKullanici sifre giriniz (sifre en az 4 karakter uzunlugunda olmalidir) : ");
      String  kullaniciSifre = scan.next();
        while(kullaniciSifre.length()<4 || kullaniciSifre.contains(" ")){
            System.out.println("sifre en az 4 karakter uzunlugunda olmalidir ve bosluk icermemelidir");
            kullaniciSifre = scan.next();
        }

        System.out.print("\nKullanici telefon numarasi giriniz : ");
        String kullaniciTelNo = scan.next();

        //todo tek tek hangisi güncellenmek isteniyorsa switch case ile kontrol edilip sadece o alan da güncellenebilir.
        // şimdilik hepsini güncelliyoruz
        //hangi bilgiyi güncellemek istyorsunuz?
        //1-tel no  2-isim.....
        //çoklu güncelleme istiyorsa bittikten sonra e/h

        PreparedStatement ps = con.prepareStatement("UPDATE kullanicilar SET kullaniciadi=?,kullanicisoyadi=?,kullanicimail=?,kullanicisifre=?,kullanicitelno=? WHERE kullaniciid=?");
        ps.setString(1,kullaniciAdi);
        ps.setString(2,kullaniciSoyadi);
        ps.setString(3,kullaniciMail);
        ps.setString(4,kullaniciSifre);
        ps.setString(5,kullaniciTelNo);
        ps.setInt(6, Integer.parseInt(secilenId));
        ps.executeUpdate();

        con.close();
        st.close();
        System.out.println(secilenId +" id numaralı kullanıcı güncellendi");
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
