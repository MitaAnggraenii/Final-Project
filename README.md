# Final-Project
### Nama Anggota :
1. Mita Anggraeni - 1917051040
2. Della Hayu Enggarini - 1917051056
3. Fista Dwi Septiana - 1917051066


### Pembagian Tugas
1. Menyusun README.md (Diskusi melalui Google Meet : Mita, Della, Fista)
2. Membuat Design Database di php myadmin (Mita)
3. Membuat Class Diagram di mermaid live editor (Fista)
4. Membuat ER Diagram di mermaid live editor (Della)
5. Membuat kode program OOP di netbeans (Diskusi melalui Google Meet : Mita, Della, Fista)
6. Membuat kode program koneksi di netbeans (Diskusi melalui Google Meet : Mita, Della, Fista)
7. Membuat desain GUI di scene builder (Diskusi melalui Google Meet : Mita, Della, Fista)


# Sistem Informasi Pemesanan Makanan
'SI Pemesanan Makanan' merupakan Sistem Informasi yang dapat digunakan untuk menginput data Pemesanan Makanan yang dikhususkan untuk Booth Penjualan Burger dan Sandwich.

# Desain
Untuk melihat diagram di bawah ini, instal plugin mermaid-diagram di https://github.com/Redisrupt/mermaid-diagrams

### Class Diagram
Pada Class Diagram Sistem Pemesanan Makanan, terdapat 4 class yaitu : Pelanggan, Makanan, Burger, dan Sandwich.
- Di dalam class Pelanggan terdapat beberapa atribut ID, NamaPelanggan, Makanan (merupakan atribut dari class Makanan), Burger (aribut dari class Burger), dan Sandwich (atribut dari class Sandwich). Di dalamnya juga terdapat beberapa method yaitu setNama, setID, getID, getNama, getMakanan.
- Class Makanan. Class Makanan merupakan sebuah class abstract dan juga Superclass dari class Burger dan Sandwich. Di dalam class Makanan terdapat beberapa atribut, diantaranya : Nama, ID, Jumlah, Harga, dan Total. Dan juga terdapat beberapa method yaitu : Constructor Makanan, TotalH, getHarga, getNama, getTotal, getJumlah, setNama, setHarga, setJumlah, dan getID.
- Class Burger dan Class Sandwich. Class Burger dan class Sandwich merupakan subclass dari class Makanan. Di dalamnya terdapat atribut Jumlah dan method TotalH.

Untuk menentukan visibilitas anggota class (atribut dan method), notasi yang ditempatkan sebelum nama anggota yaitu :
Public : +
Private : -
Protected : #

Setiap class berelasi dengan class lain, diantaranya :
- Class Pelanggan dengan Class Makanan : Asosiasi, yang merupakan relasi antar class dengan makna umum.
- Class Burger ke class Makanan : Inheritance, yang merupakan relasi untuk class pewarisan atau relasi dari subclass ke superclass.
- Class Sandwich ke class Makanan :  Inheritance, yang merupakan relasi untuk class pewarisan atau relasi dari subclass ke superclass.

```mermaid
classDiagram
    Makanan <|-- Burger
    Makanan <|-- Sandwich
    Pelanggan -- Makanan
    

    class Makanan{
    <<abstract>>
        +Makanan(int ID,int Jumlah)
        -String Nama
        -int ID
        -int jumlah
        -int Harga
        -int Total
        +TotalH()*
        +getHarga() int
        +getNama() String
        +getTotal() int
        +getJumlah() int
        +setNama()
        +setHarga()
        +setJumlah()
        +getID() int
    }
    
    class Pelanggan{
        -int ID
        -String NamaPelanggan
        +Makanan makanan
        +Burger burger
        Sandwich sandwich
        +setNama(String nama)
        +SetID (int id) 
        +getID() int
        +getnama() String
        +getMakananID() int
    }

    class Burger{
        -int Jumlah
        +TotalH()
    }

    class Sandwich{
        -int Jumlah
        +TotalH()
    }
 ```   


### ER Diagram
```mermaid
erDiagram
    Pelanggan ||..|| Makanan : order
    Makanan ||--|| Burger : is
    Makanan || -- || Sandwich : is

    Makanan{
        String Nama
        int ID
        int jumlah
        int Harga
        int Total
    }
    Burger{
        int jumlah
    }
    Sandwich{
        int jumlah
    }
    Pelanggan{
        int ID
        String NamaPelanggan
    }
```

### Design Class Diagram for JavaFX and Database
```mermaid
classDiagram
    Makanan <|-- Burger
    Makanan <|-- Sandwich
    Pelanggan "*".."*" Makanan : order
    Pelanggan o-- PemesananMakananDataModel : Data Modeling
    PemesananMakananDataModel --> koneksi : DB Connection

    class Makanan{
      <<abstract>>
        -StringProperty Nama
        -IntegerProperty ID
        -IntegerProperty jumlah
        -IntegerProperty Harga
        -IntegerProperty Total
        
    }
    
    class Burger{
      -IntegerProperty jumlah
    }
    class Sandwich{
      -IntegerProperty jumlah
    }
    class Pelanggan{
        -StringProperty NamaPelanggan
        -IntegerProperty ID
        +Makanan makanan
        +Burger burger
        +Sandwich sandwich
    }

    class PemesananMakananDataModel{
        Connection CONN
        inputDataB(Pelanggan pelanggan)
        inputDataS(Pelanggan pelanggan)
        getData()
        ID()
    }

    class koneksi{
        - String user
        - String pass
        - String MYSQLhost
        koneksi(String driver)
    }
```
