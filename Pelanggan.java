package pemesanan.makanan;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


public class Pelanggan {
    private IntegerProperty ID;
    private StringProperty NamaPelanggan;
    private Makanan makanan;
    
    
    public Pelanggan(int id, Makanan makanan,String Nama) {
        this.makanan = makanan;
        this.ID = new SimpleIntegerProperty (id); 
        this.NamaPelanggan = new SimpleStringProperty(Nama);
    }
    
    
    public StringProperty NamaPelangganProperty(){
        return NamaPelanggan;
    }
    
    public IntegerProperty IDProperty(){
        return ID;
    }
