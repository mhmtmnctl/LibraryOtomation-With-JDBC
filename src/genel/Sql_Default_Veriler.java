package genel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Sql_Default_Veriler {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("org.postgresql.Driver");

        // 2. Adim: Daatabase' e baglan
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/LibraryOtomation", "postgres", "1234");

        // 3. Adim: Statement olustur
        Statement st = con.createStatement();

        // 4. Adim: Query calistir

        //1.Örnek: "workers" adında bir table oluşturup "worker_id,worker_name, worker_salary" sütunlarını ekleyin.
        String sql1 = "CREATE TABLE books(kitapId SERIAL PRIMARY KEY,kitapAdi VARCHAR(50), kitapYazari VARCHAR(50),kitapTuru VARCHAR(20),alinaBilirMi boolean,alinmaTarihi VARCHAR(20),iadeTarihi VARCHAR(20),alanKisi VARCHAR(60))";
        st.execute(sql1);

        st.execute("INSERT INTO books (kitapId,kitapAdi,kitapYazari,kitapTuru,alinaBilirMi,alinmaTarihi,alanKisi) VALUES (DEFAULT,'Hobbit','Tolkien','Fantastik',true,NULL,NULL)");
        st.execute("INSERT INTO books (kitapId,kitapAdi,kitapYazari,kitapTuru,alinaBilirMi,alinmaTarihi,alanKisi) VALUES (DEFAULT,'Sefiller','Victor Hugo','Klasik',true,NULL,NULL)");
        st.execute("INSERT INTO books (kitapId,kitapAdi,kitapYazari,kitapTuru,alinaBilirMi,alinmaTarihi,alanKisi) VALUES (DEFAULT,'Kelebek','Henry Carriere','Otobiyografi',true,NULL,NULL)");
        st.execute("INSERT INTO books (kitapId,kitapAdi,kitapYazari,kitapTuru,alinaBilirMi,alinmaTarihi,alanKisi) VALUES (DEFAULT,'Kar','Orhan Pamuk','Roman',true,NULL,NULL)");
        st.execute("INSERT INTO books (kitapId,kitapAdi,kitapYazari,kitapTuru,alinaBilirMi,alinmaTarihi,alanKisi) VALUES (DEFAULT,'Kirlangic Cigligi','Ahmet Umit','Polisiye',true,NULL,NULL)");

        String sql2 = "CREATE TABLE kullanicilar(kullaniciId SERIAL PRIMARY KEY,kullaniciAdi VARCHAR(20), kullaniciSoyadi VARCHAR(20),kullaniciMail VARCHAR(40),kullaniciSifre VARCHAR(12),kullaniciTelNo VARCHAR(12),kullaniciPuan INT)";
        st.execute(sql2);
        //todo girilen veriler formata uygun şekilde girilmesi lazım(büyük harf, telno 10 karakter gibi)
        st.execute("INSERT INTO kullanicilar(kullaniciId,kullaniciAdi,kullaniciSoyadi,kullaniciMail,kullaniciSifre,kullaniciTelNo,kullaniciPuan) VALUES (DEFAULT,'Ersin','AKUN','ersinakun34@gmail.com','1111','2126140853',10)");
        st.execute("INSERT INTO kullanicilar(kullaniciId,kullaniciAdi,kullaniciSoyadi,kullaniciMail,kullaniciSifre,kullaniciTelNo,kullaniciPuan) VALUES (DEFAULT,'Sezer','ERCAN','sercan@gmail.com','1111','2121231212',10)");
        st.execute("INSERT INTO kullanicilar(kullaniciId,kullaniciAdi,kullaniciSoyadi,kullaniciMail,kullaniciSifre,kullaniciTelNo,kullaniciPuan) VALUES (DEFAULT,'Emin','CATAL','ecatal@gmail.com','1111','2581231223',10)");
        st.execute("INSERT INTO kullanicilar(kullaniciId,kullaniciAdi,kullaniciSoyadi,kullaniciMail,kullaniciSifre,kullaniciTelNo,kullaniciPuan) VALUES (DEFAULT,'Emrullah','Celebi','celebi@gmail.com','1111','2581231223',10)");
        st.execute("INSERT INTO kullanicilar(kullaniciId,kullaniciAdi,kullaniciSoyadi,kullaniciMail,kullaniciSifre,kullaniciTelNo,kullaniciPuan) VALUES (DEFAULT,'Fatih','Polat','fatih@gmail.com','1111','2581231223',10)");


        con.close();
        st.close();
        //bağlantı kapatıldı

    }
}
