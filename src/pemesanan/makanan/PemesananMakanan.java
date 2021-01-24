package pemesanan.makanan;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PemesananMakanan extends Application {
    TableView tabel = new TableView();
    int count = 1;
    ObservableList<Pelanggan> data = FXCollections.observableArrayList();
    PemesananMakananDataModel PMDM;
    Pelanggan pgn;
    @Override
    public void start(Stage primaryStage) {
        try {
            PMDM = new PemesananMakananDataModel ("MYSQL");
            data = PMDM.getData();
        } catch (SQLException ex) {
            Logger.getLogger(PemesananMakanan.class.getName()).log(Level.SEVERE, null, ex);
        }
