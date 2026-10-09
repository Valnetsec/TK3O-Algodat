
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Membuat list karakter
        Doublelist daftarCharacter = new Doublelist();

        // Menambahkan data karakter
        daftarCharacter.tambahDiAkhir(
            new Atribut("Sword", "Pyro", "Mondstadt", "Diluc", 12000, 90)
        );

        daftarCharacter.tambahDiAkhir(
            new Atribut("Bow", "Cryo", "Mondstadt", "Diona", 8000, 80)
        );

        daftarCharacter.tambahDiAkhir(
            new Atribut("Polearm", "Hydro", "Liyue", "Xiao", 10000, 90)
        );

        MaterialShop shop = new MaterialShop();

        System.out.println("\n=== TOWER BASE CARD GAME ===");
        System.out.println("1. Lihat Character");
        System.out.println("2. Lihat Senjata");
        System.out.println("3. Store");
        System.out.println("0. Exit");

        System.out.print("Choose: ");
        int choice = input.nextInt();

        if (choice == 1) {
            System.out.println("\n=== CHARACTER ROSTER ===");
            daftarCharacter.transversalMaju();

        } else if (choice == 2) {
            System.out.println("\n=== SENJATA ===");
            daftarCharacter.transversalMaju();

        } else if (choice == 3) {
            shop.tampilkan();

        } else if (choice == 0) {
            System.out.println("Keluar dari game...");

        } else {
            System.out.println("Pilihan tidak valid!");
        }

        input.close();
    }
}
