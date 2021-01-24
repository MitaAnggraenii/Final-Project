package pemesanan.makanan;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public abstract class Makanan {
    private StringProperty Nama;
    private IntegerProperty ID,jumlah,Harga,Total;
    
    public Makanan(int ID,int Jumlah){
        this.Nama = new SimpleStringProperty();
        this.jumlah = new SimpleIntegerProperty(Jumlah);
        this.Harga = new SimpleIntegerProperty();
        this.Total = new SimpleIntegerProperty();
        this.ID = new SimpleIntegerProperty();
    }
    
    
    
    public void TotalH(){
        this.Total.set(getJumlah() * getHarga());
    }
    
    public int getHarga(){
        return Harga.get();
    }
    
    
