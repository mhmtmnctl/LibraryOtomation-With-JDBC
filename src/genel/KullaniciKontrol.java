package genel;

import java.util.Scanner;

public class KullaniciKontrol {
   static Scanner scan = new Scanner(System.in);

        public static String IsimKontrol(){
            System.out.print("Kullanici adini giriniz : ");

            String kullaniciAdi = scan.nextLine().toUpperCase().replaceAll("\\d","x1");
            while (kullaniciAdi.isEmpty() || kullaniciAdi.contains("x1")){
                System.err.println("Kullanıcı boş olamaz ve rakam içeremez");
                System.out.print("Kullanici adini giriniz : ");
                kullaniciAdi = scan.nextLine().toUpperCase().replaceAll("\\d","x1");
            }
            return kullaniciAdi;
        }

    public static String soyIsimKontrol(){
        System.out.print("Kullanici soyadını giriniz : ");

        String kullaniciSoyAdi = scan.nextLine().toUpperCase().replaceAll("\\d","x1");
        while (kullaniciSoyAdi.isEmpty() || kullaniciSoyAdi.contains("x1")){
            System.err.println("Kullanıcı soyadı boş olamaz ve rakam içeremez");
            System.out.print("Kullanici adini giriniz : ");
            kullaniciSoyAdi = scan.nextLine().toUpperCase().replaceAll("\\d","x1");
        }
        return kullaniciSoyAdi;
    }


    public static String mailKontrol(){
        System.out.print("Kullanici mail adresini giriniz : ");
      String kullaniciMail = scan.next();

        while (!(kullaniciMail.contains("@") && kullaniciMail.contains(".")))
        {
            System.err.println("Lutfen gecerli bir mail adresi giriniz!");
            System.out.print("Kullanici mail adresini giriniz : ");
            kullaniciMail=scan.next();
        }
        return kullaniciMail;
    }

    public static String sifreKontrol(){
        System.out.print("Kullanici sifre giriniz (sifre en az 4 karakter uzunlugunda olmalidir) : ");
       String kullaniciSifre = scan.next();
        while(kullaniciSifre.length()<4 || kullaniciSifre.contains(" ")){
            System.err.println("sifre en az 4 karakter uzunlugunda olmalidir ve bosluk icermemelidir");
            System.out.print("Kullanici sifre giriniz : ");
            kullaniciSifre = scan.next();
        }
        return kullaniciSifre;
    }

    public static String telNoKontrol(){
        System.out.print("Telefon numarasinı 10 haneli olarak giriniz : ");
       String kullaniciTelNo = scan.next().replaceAll("\\s","").replaceAll("\\D","x1");
        while (!(kullaniciTelNo.length()==10) || kullaniciTelNo.isEmpty() || kullaniciTelNo.contains("x1")){
            System.out.println(kullaniciTelNo);
            System.err.println("telefon numarası 10 haneli olmalı ve boş olmamalı ve sadece rakam içermeli!");
            System.out.print("Telefon numarasinı 10 haneli olarak giriniz : ");
            kullaniciTelNo = scan.next().replaceAll("\\s","").replaceAll("\\D","x1");
        }
        return kullaniciTelNo;
    }

}
