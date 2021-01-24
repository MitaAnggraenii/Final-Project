package pemesanan.makanan;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class PemesananMakananDataModel {

    public final Connection CONN;

    public PemesananMakananDataModel(String driver) throws SQLException {
        this.CONN = koneksi.koneksi(driver);
    }

    public void inputDataB(Pelanggan pelanggan) throws SQLException {
        String insertPelanggan = "INSERT INTO Pelanggan (ID,NamaPelanggan,IDMakanan)"
                + " VALUES (?,?,?)";
        String insertMakanan = "INSERT INTO Makanan (id,nama,jumlah)"
                + " VALUES (?,?,?)";
        String insertBurger = "INSERT INTO Burger (id,harga,totalharga)"
                + " VALUES (?,?,?)";

        PreparedStatement stmtPelanggan = CONN.prepareStatement(insertPelanggan);
        stmtPelanggan.setInt(1, pelanggan.getID());
        stmtPelanggan.setString(2, pelanggan.getNama());
        stmtPelanggan.setInt(3, pelanggan.getMakananID());
        stmtPelanggan.execute();
        
        PreparedStatement stmtBurger = CONN.prepareStatement(insertBurger);
        stmtBurger.setInt(1, pelanggan.getID());
        stmtBurger.setInt(2, pelanggan.makanan.getHarga());
        stmtBurger.setInt(3, pelanggan.makanan.getTotal());
        stmtBurger.execute();

        PreparedStatement stmtMakanan = CONN.prepareStatement(insertMakanan);
        stmtMakanan.setInt(1, pelanggan.makanan.getID());
        stmtMakanan.setString(2, pelanggan.makanan.getNama());
        stmtMakanan.setInt(3, pelanggan.makanan.getJumlah());
        stmtMakanan.execute();

    }
    public void inputDataS(Pelanggan pelanggan) throws SQLException {
        String insertPelanggan = "INSERT INTO Pelanggan (ID,NamaPelanggan,IDMakanan)"
                + " VALUES (?,?,?)";
        String insertMakanan = "INSERT INTO Makanan (id,nama,jumlah)"
                + " VALUES (?,?,?)";
        String insertBurger = "INSERT INTO Burger (id,harga,totalharga)"
                + " VALUES (?,?,?)";
        String insertSandwich = "INSERT INTO `sandwich` (id,harga,totalharga)"
                + " VALUES (?,?,?)";

        PreparedStatement stmtPelanggan = CONN.prepareStatement(insertPelanggan);
        stmtPelanggan.setInt(1, pelanggan.getID());
        stmtPelanggan.setString(2, pelanggan.getNama());
        stmtPelanggan.setInt(3, pelanggan.getMakananID());
        stmtPelanggan.execute();
        
        PreparedStatement stmtSandwich = CONN.prepareStatement(insertSandwich);
        stmtSandwich.setInt(1, pelanggan.getID());
        stmtSandwich.setInt(2, pelanggan.makanan.getHarga());
        stmtSandwich.setInt(3, pelanggan.makanan.getTotal());
        stmtSandwich.execute();

        PreparedStatement stmtMakanan = CONN.prepareStatement(insertMakanan);
        stmtMakanan.setInt(1, pelanggan.makanan.getID());
        stmtMakanan.setString(2, pelanggan.makanan.getNama());
        stmtMakanan.setInt(3, pelanggan.makanan.getJumlah());
        stmtMakanan.execute();

    }

    public ObservableList getData() throws SQLException {
        ObservableList<Pelanggan> data = FXCollections.observableArrayList();
        Burger burger;
        Sandwich sandwich;
        
        String sqlPelanggan = "SELECT * FROM `pelanggan`";
        String sqlMakanan = "SELECT * FROM `makanan`";
        String sqlBurger = "SELECT * FROM `burger`";
        String sqlSandwich = "SELECT * FROM `sandwich`";


        try {
            ResultSet rsPelanggan = CONN.createStatement().executeQuery(sqlPelanggan);
            ResultSet rsMakanan = CONN.createStatement().executeQuery(sqlMakanan);
            ResultSet rsBurger = CONN.createStatement().executeQuery(sqlBurger);
            ResultSet rsSandwich = CONN.createStatement().executeQuery(sqlSandwich);
            while (rsPelanggan.next() && rsMakanan.next()) {
                if (rsMakanan.getString("nama").equals("Burger")) {
                    rsBurger.next();
                    burger = new Burger(
                            rsBurger.getInt("ID"),
                            rsMakanan.getInt("jumlah"));
                    
                    data.add(new Pelanggan(rsPelanggan.getInt(1),
                            burger, rsPelanggan.getString("NamaPelanggan")));
                } else {
                    rsSandwich.next();
                    sandwich = new Sandwich(
                            rsBurger.getInt("ID"),
                            rsMakanan.getInt("jumlah"));
                    
                    data.add(new Pelanggan(rsPelanggan.getInt(1),
                            sandwich, rsPelanggan.getString("NamaPelanggan")));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(PemesananMakananDataModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }

    public int ID() throws SQLException {
        String sql = "SELECT MAX(ID) from pelanggan";
        ResultSet rs = CONN.createStatement().executeQuery(sql);
        while (rs.next()) {
            return rs.getInt(1) == 0 ? 101 : rs.getInt(1) + 1;
        }
        return 101;
    }
}

