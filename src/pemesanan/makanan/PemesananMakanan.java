/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pemesanan.makanan;

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

/**
 *
 * @author ACER
 */
public class PemesananMakanan extends Application {
    TableView tabel = new TableView();
    int count = 1;
    ObservableList<Pelanggan> data = FXCollections.observableArrayList();
    @Override
    public void start(Stage primaryStage) {
        //koneksi.koneksi();
        tabel.setEditable(true);
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
        
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
               
                if (cb.getValue() == "Burger"){
                   
                   data.add(new Pelanggan (count,
                       new Burger(count,
                           Integer.parseInt(
                           txt2.getText().toString()
                           )),txt.getText().toString()
                       ));
                   count = count+1;
               }
               else if (cb.getValue() == "Sandwich") {
                   data.add(new Pelanggan (count,
                       new Sandwich(count,
                           Integer.parseInt(
                           txt2.getText().toString()
                           )),txt.getText().toString()
                       )); 
                   count = count+1;
               }
               
                txt.clear();
                txt2.clear();
                cb.setValue(null);
            }
        });
//        x=x+1;
        Scene scene = new Scene(grid);
        vb.setStyle("-fx-background-color : CYAN ;");
        grid.setStyle("-fx-background-color : CYAN ;");
        grid.setStyle("-fx-padding: 10;");
        primaryStage.setTitle("Burger Sandwich ASEEK");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
