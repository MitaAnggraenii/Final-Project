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
    public Makanan makanan;
    public Burger burger;
    public Sandwich sandwich;
    
    
    public Pelanggan(int id, Makanan makanan,String Nama) {
        if("Burger".equals(makanan.getNama())){
            this.burger = (Burger) makanan;
            this.makanan = this.burger;
        }
        else{
            this.sandwich = (Sandwich) makanan;
            this.makanan = this.sandwich;
        }
        
        this.ID = new SimpleIntegerProperty (id); 
        this.NamaPelanggan = new SimpleStringProperty(Nama);
    }
    
