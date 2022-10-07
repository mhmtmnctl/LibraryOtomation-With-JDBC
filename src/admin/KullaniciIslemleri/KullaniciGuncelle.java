package admin.KullaniciIslemleri;
import admin.KullaniciIslemleri.kullaniciGuncelleme.AdiGuncelle;
import admin.KullaniciIslemleri.kullaniciGuncelleme.SoyadiGuncelle;
import java.sql.*;
import java.util.*;

public class KullaniciGuncelle {
    public static void adminKullaniciGuncelleMethodu() throws InterruptedException, SQLException, ClassNotFoundException {
        System.out.println("Kullanici Guncelleme Islemleri");

//        Class.forName("org.postgresql.Driver");
//        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/LibraryOtomation", "postgres", "1234");
//        Statement st = con.createStatement();
//        String sqlKullanicilar = "SELECT * FROM kullanicilar";
//        ResultSet kullanicilar =  st.executeQuery(sqlKullanicilar);
//        ArrayList<String> kullaniciIDList= new ArrayList<>();
//        //todo printf ile düzenli şekilde gösterilsin
//        while (kullanicilar.next()) {
//            System.out.println(kullanicilar.getInt(1)+"-"+ //id
//                    kullanicilar.getString(2)+"-"+//ad
//                    kullanicilar.getString(3)+"-"+//soyad
//                    kullanicilar.getString(4)+"-"+//mail
//                    kullanicilar.getString(5)+"-"+//şifre
//                    kullanicilar.getString(6)+"-"+//tel
//                    kullanicilar.getInt(7));//puan
//                    kullaniciIDList.add(String.valueOf(kullanicilar.getInt(1)));
//
//        }
//        Scanner scan = new Scanner(System.in);
//        System.out.print("Guncellemek istediğiniz kullanıcının  ID numarısını giriniz :");
//
//        String secilenId = scan.next().replaceAll("\\D", "x1");//rakam dışındaki herşey
//        while (secilenId.contains("x1")) {
//            System.out.println("Lütfen sadece rakam giriniz!");
//            System.out.print("Guncellemek istediğiniz kullanıcının  ID numarısını giriniz :");
//            secilenId = scan.next();
//        }
//        while (!kullaniciIDList.contains(secilenId)) {
//            System.out.println(secilenId + " numaralı ID'li bir kullanıcı yoktur. Lütfen tekrar deneyin");
//            System.out.print("Guncellemek istediğiniz kullanıcının  ID numarısını giriniz :");
//            secilenId = scan.next();
//        }




//        System.out.print("\nKullanici mail adresini giriniz : ");
//      String  kullaniciMail = scan.next();
//        while (!(kullaniciMail.contains("@") && kullaniciMail.contains(".")))
//        {
//            System.out.println("Lutfen gecerli bir mail adresi giriniz ...");
//            kullaniciMail=scan.next();
//        }
//
//        System.out.print("\nKullanici sifre giriniz (sifre en az 4 karakter uzunlugunda olmalidir) : ");
//      String  kullaniciSifre = scan.next();
//        while(kullaniciSifre.length()<4 || kullaniciSifre.contains(" ")){
//            System.out.println("sifre en az 4 karakter uzunlugunda olmalidir ve bosluk icermemelidir");
//            kullaniciSifre = scan.next();
//        }
//
//        System.out.print("\nKullanici telefon numarasi giriniz : ");
//        String kullaniciTelNo = scan.next().replaceAll("\\s","").replaceAll("\\D","x1");
//        while (!(kullaniciTelNo.length()==10) || kullaniciTelNo.isEmpty() || kullaniciTelNo.contains("x1")){
//            System.out.println(kullaniciTelNo);
//            System.out.println("telefon numarası 10 haneli olmalı ve boş olmamalı ve sadece rakam içermeli!");
//            System.out.print("Telefon numarasinı 10 haneli olarak giriniz : ");
//            kullaniciTelNo = scan.next().replaceAll("\\s","").replaceAll("\\D","x1");
        Scanner scan = new Scanner(System.in);
        System.out.println("1-Kullanıcı Adı\n2-Kullanıcı Soyadı\n3-Kullanıcı Maili\n4-Kullanıcı Şifresi\n5-Kullanıcı Tel No");
        System.out.println("Güncellemek istediğiniz alanın sıra numarasını giriniz : ");
        int siraNo= scan.nextInt();

        switch (siraNo){
            case 1:  AdiGuncelle.adiGuncelle(); break;
            case 2:  SoyadiGuncelle.soyadiGuncelle(); break;



        }


    }


}
