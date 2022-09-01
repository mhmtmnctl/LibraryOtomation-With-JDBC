package genel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Sql_Default_Veriler {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("org.postgresql.Driver");

        // 2. Adim: Daatabase' e baglan
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/library", "postgres", "62191775");

        // 3. Adim: Statement olustur
        Statement st = con.createStatement();

        // 4. Adim: Query calistir

        //1.Örnek: "workers" adında bir table oluşturup "worker_id,worker_name, worker_salary" sütunlarını ekleyin.
        String sql1 = "CREATE TABLE books(kitapId INT PRIMARY KEY,kitapAdi VARCHAR(50), kitapYazari VARCHAR(50),kitapTuru VARCHAR(20),alinaBilirMi boolean,alinmaTarihi VARCHAR(12),alanKisi VARCHAR(40))";
        st.execute(sql1);

        st.execute("INSERT INTO books (kitapId,kitapAdi,kitapYazari,kitapTuru,alinaBilirMi,alinmaTarihi,alanKisi) VALUES (1,'Hobbit','Tolkien','Fantastik',true,NULL,NULL)");
        st.execute("INSERT INTO books (kitapId,kitapAdi,kitapYazari,kitapTuru,alinaBilirMi,alinmaTarihi,alanKisi) VALUES (2,'Sefiller','Victor Hugo','Klasik',true,NULL,NULL)");
        st.execute("INSERT INTO books (kitapId,kitapAdi,kitapYazari,kitapTuru,alinaBilirMi,alinmaTarihi,alanKisi) VALUES (3,'Kelebek','Henry Carriere','Otobiyografi',true,NULL,NULL)");
        st.execute("INSERT INTO books (kitapId,kitapAdi,kitapYazari,kitapTuru,alinaBilirMi,alinmaTarihi,alanKisi) VALUES (4,'Kar','Orhan Pamuk','Roman',true,NULL,NULL)");
        st.execute("INSERT INTO books (kitapId,kitapAdi,kitapYazari,kitapTuru,alinaBilirMi,alinmaTarihi,alanKisi) VALUES (5,'Kirlangic Cigligi','Ahmet Umit','Polisiye',true,NULL,NULL)");

        String sql2 = "CREATE TABLE kullanicilar(kullaniciId INT PRIMARY KEY,kullaniciAdi VARCHAR(15), kullaniciSoyadi VARCHAR(15),kullaniciMail VARCHAR(40),kullaniciSifre VARCHAR(12),kullaniciTelNo VARCHAR(12),kullaniciPuan INT)";
        st.execute(sql2);

        st.execute("INSERT INTO kullanicilar(kullaniciId,kullaniciAdi,kullaniciSoyadi,kullaniciMail,kullaniciSifre,kullaniciTelNo,kullaniciPuan) VALUES (1,'Ersin','AKUN','ersinakun34@gmail.com','1234','2126140853',10)");
        st.execute("INSERT INTO kullanicilar(kullaniciId,kullaniciAdi,kullaniciSoyadi,kullaniciMail,kullaniciSifre,kullaniciTelNo,kullaniciPuan) VALUES (2,'Sezer','ERCAN','sercan@gmail.com','4321','2121231212',10)");
        st.execute("INSERT INTO kullanicilar(kullaniciId,kullaniciAdi,kullaniciSoyadi,kullaniciMail,kullaniciSifre,kullaniciTelNo,kullaniciPuan) VALUES (3,'Emin','CATAL','ecatal@gmail.com','1111','2581231223',10)");


        con.close();
        st.close();

    }
}
