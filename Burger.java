package pemesanan.makanan;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Burger extends Makanan {
    private IntegerProperty jumlah;
    public Burger(int ID, int Jumlah) {
        super(ID,Jumlah);
        this.jumlah = new SimpleIntegerProperty(Jumlah);
        super.setNama("Burger");
        super.setHarga(20000);
        super.TotalH();
    }
        
}
