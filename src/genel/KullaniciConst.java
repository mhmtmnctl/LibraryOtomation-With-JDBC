package genel;

public class KullaniciConst {
    /*
    Kullanıcı ID: ama bunu biz otomatik atıyalım.                                               int
    Kullanıcı adı:                                                                              String
    Kullanıcı soyad:       uppercase yapabiliriz.                                               String
    Kullanıcı mail:         .com ile bitsin                                                     String
    Kullanıcı şifresi:     en az bir büyük harf,küçük harf,sayı ve noktalama işareti içersin.   String
    Kullanıcı Tel:        5456185290   başında 0 olmadan 10 haneli girsin                       String
    Kullanıcı Puanı: buda default 10 puan.                                                      int

    contructor'a göndercez.
    String metodu olcak.

    atıyorum maili girerken yanlış girerse hemen uyaralım. diğerleri için de aynı şekilde.
    burda list oluşturcaz.
    en son liste atalım.

    en son entera bastığında kullanıcı başarıyla eklendi
    sonra KullanıcıMenusune atalım.

     */
    public int kullaniciId;
    public String kullaniciAdi;
    public String kullaniciSoyadi;
    public String kullaniciMail;
    public String kullaniciSifre;
    public String kullaniciTelNo;
    public int kullaniciPuan = 10;

    public KullaniciConst(int kullaniciId, String kullaniciAdi, String kullaniciSoyadi, String kullaniciMail,
                          String kullaniciSifre, String kullaniciTelNo, int kullaniciPuan) {
        this.kullaniciId = kullaniciId;
        this.kullaniciAdi = kullaniciAdi;
        this.kullaniciSoyadi = kullaniciSoyadi;
        this.kullaniciMail = kullaniciMail;
        this.kullaniciSifre = kullaniciSifre;
        this.kullaniciTelNo = kullaniciTelNo;
        this.kullaniciPuan = kullaniciPuan;

    }

    public KullaniciConst() {
    }

    @Override
    public String toString() {
        return "\n" + kullaniciId + " " +
                kullaniciAdi + " " +
                kullaniciSoyadi + " " +
                kullaniciMail + " " +
                kullaniciSifre + " " +
                kullaniciTelNo + " " +
                kullaniciPuan;

    }

}
