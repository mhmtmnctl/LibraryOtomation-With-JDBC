package admin.KullaniciIslemleri;

import genel.KullaniciConst;

import java.sql.*;
import java.util.Scanner;

public class KullaniciGuncelle {
    /*
             öncelikle kullanıcı listesini gösterelim
             oradan id seçsin
             Güncellemek istediğiniz kullanıcının ID numarasını gireniz:
             Listede olan ID seçmeli yoksa uyarı verelim
             seçip enter'a bastığında seçilen kullanıcı bilgilerini ekrana getirsin.
             Seçtiği ID'yi silsin.
             Onun yerine yeni kayıt eklesin.

             [{1,sezer,Can,@mail,1453,5456185290},{2,Ersin,Akun,@gmail,5555,554339},{3,ali,can,@hotmail,4444,553}]
             kullanıcı[0].

             List<Integer> l1 = new ArrayList<Integer>();

            // Adding elements to object of List interface
            // Custom inputs

            l1.add(0, 1);
            l1.add(1, 2);

            // Print the elements inside the object
            System.out.println(l1);


     */
    public static void adminKullaniciGuncelleMethodu() throws InterruptedException, SQLException, ClassNotFoundException {
        System.out.println("Kullanici Guncelleme Islemleri");

        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/LibraryOtomation", "postgres", "1234");
        Statement st = con.createStatement();
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
        System.out.print("Guncellemek istediğiniz kullanıcının  ID numarısını giriniz :");
        int secilenId = scan.nextInt();
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
        //todo şimdilik hepsini güncelliyoruz



/*
UPDATE tedarikciler
SET firma_ismi = 'Vestel' WHERE vergi_no=102

PreparedStatement ps = con.prepareStatement("INSERT INTO kullanicilar VALUES(DEFAULT,?, ?, ?,?,?,10)");
        ps.setString(1,kullaniciAdi);
 */

        PreparedStatement ps = con.prepareStatement("UPDATE kullanicilar SET kullaniciadi=?,kullanicisoyadi=?,kullanicimail=?,kullanicisifre=?,kullanicitelno=? WHERE kullaniciid=?");
        ps.setString(1,kullaniciAdi);
        ps.setString(2,kullaniciSoyadi);
        ps.setString(3,kullaniciMail);
        ps.setString(4,kullaniciSifre);
        ps.setString(5,kullaniciTelNo);
        ps.setInt(6,secilenId);
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
        //   System.out.println(kullaniciList);

        KullaniciMenusu.adminKullaniciIslemleriMenusuMethodu();
        //KullaniciEkle.adminKullaniciEkleMethodu();



    }

}
