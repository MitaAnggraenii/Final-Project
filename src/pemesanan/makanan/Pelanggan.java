/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pemesanan.makanan;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author ACER
 */
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

    public void setNama(String Nama){
        this.NamaPelanggan.set(Nama);
    }
    
    public void setID(int id){
        this.ID.set(id);
    }
    
    public int getID(){
        return ID.get();
    }
    
    public String getNama(){
        return NamaPelanggan.get();
    }
    
    public Makanan getMakanan(){
        return makanan;
    }
    
     public StringProperty NamaMakananProperty(){
        return makanan.NamaProperty();
    }
    
    public IntegerProperty HargaProperty(){
        return makanan.HargaProperty();
    }
    
    public IntegerProperty JumlahProperty(){
        return makanan.JumlahProperty();
    }
    
    public IntegerProperty TotalProperty(){
        return makanan.TotalProperty();
    }
    
    
}
