public class Weapon {
String nama;
int harga;

public Weapon(String nama, int harga) {
    this.nama = nama;
    this.harga = harga;
}

public void tampilkan() {
    System.out.println("Nama Senjata : " + nama);
    System.out.println("Harga        : " + harga);
}

}
