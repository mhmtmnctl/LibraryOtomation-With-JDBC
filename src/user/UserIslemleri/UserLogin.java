package user.UserIslemleri;
import user.UserKitap.UserIslemMenusu;
import java.sql.*;
import java.util.Scanner;


public class UserLogin {

    public static String sifre;
    public static String mail;

    public static String loginId;

    public UserLogin() throws SQLException {
    }

    public static void userLoginMethodu() throws InterruptedException, SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/LibraryOtomation", "postgres", "1234");
        Statement st = con.createStatement();

       Scanner scan = new Scanner(System.in);
       System.out.print("Mail adresinizi giriniz : ");
        mail = scan.next();
       System.out.println();
       System.out.print("Şifrenizi giriniz : ");
        sifre = scan.next();
        String sqlKullanicilariGetir = "SELECT * FROM kullanicilar";
        ResultSet users = st.executeQuery(sqlKullanicilariGetir);
        while (users.next()){

            if(mail.equals(users.getString(4)) && sifre.equals(users.getString(5))){
                System.out.println("Tebrikler giriş yaptınız... ");
                loginId=users.getString(1).toString();
                UserIslemMenusu.userKitapIslemMenusuMethodu();
            }

        }

       System.out.print("Kullanıcı adı veya şifreniz hatalı, \ntekrar denemek ister misiniz? (E / H): ");
               String secim = scan.next();
               if (secim.equalsIgnoreCase("E")){
                   UserLogin.userLoginMethodu();
               }else {
                   UserLoginMenusu.userLoginMenusuMethodu();
               }

        con.close();
        st.close();

    }

}


