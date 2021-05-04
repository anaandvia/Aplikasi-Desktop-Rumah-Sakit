package program.rumahsakit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class KoneksiDatabase {
    private static Connection koneksi;
    public static Connection getKoneksi() {
        //cek apakah koneksi null 
        if (koneksi == null){
            try {
                String url = "jdbc:mysql://localhost:3306/dbrumahsakit";
                String user = "root";
                String password = "";
                
                DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                
                koneksi = DriverManager.getConnection(url, user, password);
            } catch (SQLException e){
                System.out.println("Eror Membuat Koneksi");
            }
        }
        return koneksi;
    }
}

