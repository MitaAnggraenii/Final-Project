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

    
