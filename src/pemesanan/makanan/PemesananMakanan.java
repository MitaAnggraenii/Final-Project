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
        
        final TextField txt = new TextField();
        txt.setPromptText("Nama");
        final ComboBox cb = new ComboBox();
        cb.setPromptText("Makanan");
        cb.getItems().add("Burger");
        cb.getItems().add("Sandwich");
        final TextField txt2 = new TextField();
        txt2.setPromptText("Jumlah");
        Button btn = new Button();
        btn.setText("Input");
        Label label = new Label("PROGRAM PEMESANAN MAKANAN");
        label.setMinHeight(5);
        label.setStyle("-fx-font-size: 20px;");
        GridPane grid = new GridPane();
        VBox vb = new VBox(10);
        vb.setStyle("-fx-padding: 5;");
        VBox vb1 = new VBox(1);
        grid.add(vb1,  0, 0,1,1);
        grid.add(vb, 1, 0,1,1);
        vb.getChildren().addAll(label,txt,cb,txt2,btn);
        vb1.getChildren().addAll(tabel);
        TableColumn column = new TableColumn("ID");
        column.setCellValueFactory(new PropertyValueFactory<Pelanggan,String> ("ID"));
        column.setMinWidth(50);
        TableColumn column1 = new TableColumn("Nama");
        column1.setCellValueFactory(new PropertyValueFactory<Pelanggan,String> ("NamaPelanggan"));
        column1.setMinWidth(100);
        TableColumn column2 = new TableColumn("Pesanan");
        column2.setCellValueFactory(new PropertyValueFactory<Pelanggan,String> ("NamaMakanan"));
        column2.setMinWidth(100);
        TableColumn column3 = new TableColumn("Jumlah");
        column3.setCellValueFactory(new PropertyValueFactory<Pelanggan,String> ("Jumlah"));
        column3.setMinWidth(100);
        TableColumn column4 = new TableColumn("Harga");
        column4.setCellValueFactory(new PropertyValueFactory<Pelanggan,String> ("Harga"));
        column4.setMinWidth(100);
        TableColumn column5 = new TableColumn("Total");
        column5.setCellValueFactory(new PropertyValueFactory<Pelanggan,String> ("Total"));
        column5.setMinWidth(100);
        tabel.setItems(data);
        tabel.getColumns().setAll(column,column1,column2,column3,column4,column5);
