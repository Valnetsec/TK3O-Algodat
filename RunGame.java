
import java.util.Scanner;

public class RunGame{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Doublelist party = new Doublelist();

        int pilihan = 0;

        do {
            System.out.println("\n========= PARTY MANAGEMENT =========");
            System.out.println("Jumlah hero: " + party.getsize() + "/4");
            System.out.println("1. Tambah hero di depan");
            System.out.println("2. Tambah hero di belakang");
            System.out.println("3. Hapus hero");
            System.out.println("4. Tampilkan party");
            System.out.println("5. Toko senjata");
            System.out.println("0. Keluar");
            System.out.print("Pilihan: ");

            pilihan = input.nextInt();
            input.nextLine();

            switch (pilihan) {

                case 1: {
                    if (party.sudahpenuh()){
                        System.out.println("Party sudah penuh!");
                        break;
                    }

                    System.out.print("Nama hero: ");
                    String nama = input.nextLine();

                    Role hero = new Role(                   //BAGIAN SINI UBAH AJ
                        "Hero", "", "",
                        nama, 100, 1, "Sword"
                    );

                    party.tambahDiAwal(hero);
                    System.out.println("Hero ditambahkan di depan!");
                    break;
                }

                case 2: {
                    if (party.sudahpenuh()){
                        System.out.println("Party sudah penuh!");
                        break;
                    }

                    System.out.print("Nama hero: ");
                    String nama = input.nextLine();

                    Role hero = new Role(
                        "Hero", "", "",
                        nama, 100, 1, "Sword"
                    );

                    party.tambahDiAkhir(hero);
                    System.out.println("Hero ditambahkan di belakang!");
                    break;
                }

                case 3: {
                    if (party.isEmpty()){
                        System.out.println("Party masih kosong!");
                        break;
                    }

                    System.out.print("Nama hero yang dihapus: ");
                    String name = input.nextLine();

                    party.removehero(name);
                    break;
                }

                case 4: {
                    if (party.isEmpty()){
                        System.out.println("Party masih kosong!");
                    } else {
                        System.out.println("\n=== URUTAN PARTY ===");
                        party.transversalMaju();
                    }
                    break;
                }

                case 5: {
                    Circularlist circular = new Circularlist();
                    circular.tampilkanMenu(input);
                    break;

                }
                
                case 0:
                    System.out.println("Keluar dari game...");
                    break;

                default:
                    System.out.println("Pilihan tidak valid!");
            }

        } while (pilihan != 0);

        input.close();
    }
}