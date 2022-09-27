package genel;

public class KitapConst {

    public int kitapId;
    public String kitapAdi;
    public String kitapYazari;
    public String kitapTuru;
    public boolean alinaBilirMi;
    public String alinmaTarihi;
    public String alanKisi;
    public KitapConst() {

    }

    public KitapConst(int kitapId, String kitapAdi, String kitapYazari, String kitapTuru,boolean alinaBilirMi,String alinmaTarihi,String alanKisi) {
        this.kitapId = kitapId;
        this.kitapAdi = kitapAdi;
        this.kitapYazari = kitapYazari;
        this.kitapTuru = kitapTuru;
        this.alinaBilirMi =alinaBilirMi;
        this.alinmaTarihi =alinmaTarihi;
        this.alanKisi =alanKisi;
    }

    @Override
    public String toString() {
        return "KitapConst{" +
                "Id=" + kitapId +
                ", Adi='" + kitapAdi + '\'' +
                ", Yazari='" + kitapYazari + '\'' +
                ", Turu='" + kitapTuru + '\'' +
                ", alinaBilirMi=" + alinaBilirMi +
                ", alinmaTarihi='" + alinmaTarihi + '\'' +
                ", alanKisi='" + alanKisi + '\'' +
                '}';
    }
}
