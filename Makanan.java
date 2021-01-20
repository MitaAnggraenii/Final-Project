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
    
    public String getNama(){
        return Nama.get();
    }
    
    public int getJumlah(){
        return jumlah.get();
    }
    public double getTotal(){
        return Total.get();
    }
    
    
    public void setNama(String Name){
        this.Nama.set(Name);
    }
    
    public void setHarga(int harga){
        this.Harga.set(harga);
    }

     public void setJumlah(int jumlah){
        this.jumlah.set(jumlah);
    }
    
    public StringProperty NamaProperty(){
        return Nama;
    }
    
    public IntegerProperty HargaProperty(){
        return Harga;
    }
    
    public IntegerProperty JumlahProperty(){
        return jumlah;
    }
    
    public IntegerProperty TotalProperty(){
        return Total;
    }
    public IntegerProperty IDProperty(){
        return ID;
    }
}
