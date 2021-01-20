package pemesanan.makanan;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Sandwich extends Makanan {
   private IntegerProperty jumlah;
   
     public Sandwich(int ID,int Jumlah) {
        super(ID,Jumlah);
        this.jumlah = new SimpleIntegerProperty(Jumlah);
        super.setNama("Sandwich");
        super.setHarga(15000);
        super.TotalH();
    }
}

