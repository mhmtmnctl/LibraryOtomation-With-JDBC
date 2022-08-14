package genel;

public class KitapConst {

    public int kitapId;
    public String kitapAdi;
    public String kitapYazari;
    public String kitapTuru;
public boolean alinaBilirMi = true;
    public KitapConst() {

    }

    public KitapConst(int kitapId, String kitapAdi, String kitapYazari, String kitapTuru,boolean alinaBilirMi) {
        this.kitapId = kitapId;
        this.kitapAdi = kitapAdi;
        this.kitapYazari = kitapYazari;
        this.kitapTuru = kitapTuru;
        this.alinaBilirMi =alinaBilirMi;
    }

    @Override
    public String toString() {
        return
                "\n" + kitapId + " " + kitapAdi + " " + kitapYazari + " " + kitapTuru;

    }
}
