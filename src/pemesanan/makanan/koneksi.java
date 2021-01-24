import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class koneksi {
        
        public static String MYSQLhost = "jdbc:mysql://localhost/pemesananmakanan";
        public static String user = "root";
        public static String pass = "";
        public static Connection koneksi(String driver)throws SQLException {
                Connection conn = null;
                if ("MYSQL".equals(driver)){
                        try {
                                Class.forName("com.mysql.jdbc.Driver");
                                conn = DriverManager.getConnection(MYSQLhost,user,pass);
                                System.out.println("Koneksi Berhasil");
                                return conn;
                        }
                
