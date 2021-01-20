package pemesanan.makanan;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Sandwich extends Makanan {
   private IntegerProperty jumlah;
   
     public Sandwich(int ID,int Jumlah) {
        super(ID,Jumlah);
