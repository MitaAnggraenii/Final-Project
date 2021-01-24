import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class koneksi {
        
        public static String MYSQLhost = "jdbc:mysql://localhost/pemesananmakanan";
        public static String user = "root";
        public static String pass = "";
        public static Connection koneksi(String driver)throws SQLException {
        Connection conn = null;
