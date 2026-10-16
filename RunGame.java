
import java.util.Scanner;

public class RunGame {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Doublelist party = new Doublelist();
        Circularlist circular = new Circularlist();
        Singlelist bossFight = new Singlelist();

        int pilihan = 0;

        do {
            System.out.println("\n========== MAIN MENU ==========");
            System.out.println("1. Hero Management");
            System.out.println("2. Boss Fight");
            System.out.println("3. Material Shop");
            System.out.println("0. Keluar");
            System.out.print("Pilihan: ");

            pilihan = input.nextInt();
            input.nextLine();

            switch (pilihan) {

                // HERO MANAGEMENT
                case 1: {
                    int menuHero = 0;

                    do {
                        System.out.println("\n====== HERO MANAGEMENT ======");
                        
                        System.out.println("Jumlah hero: " + party.getSize() + "/4");

                        System.out.println("1. Lihat semua hero");
                        System.out.println("2. Atur party");
                        System.out.println("3. Hapus hero");
                        System.out.println("4. Lihat party saat ini");
                        System.out.println("0. Kembali");
                        System.out.print("Pilihan: ");

                        menuHero = input.nextInt();
                        input.nextLine();

                        switch(menuHero){

                            case 1:
                                party.tampilkanSemuaHero();
                                break;

                            // ATUR PARTY
                            case 2: {
                                int menuAtur = 0;

                                do {
                                    System.out.println("\n====== ATUR PARTY ======");
                                    System.out.println("1. Tambah di depan");
                                    System.out.println("2. Tambah di belakang");
                                    System.out.println("0. Kembali");
                                    System.out.print("Pilihan: ");

                                    menuAtur = input.nextInt();
                                    input.nextLine();

                                    
                                    switch (menuAtur){

                                        case 1: {
                                            if (party.sudahPenuh()){
                                                System.out.println("Party sudah penuh!");
                                                break;
                                            }

                                            party.tampilkanSemuaHero();

                                            System.out.print("Nama hero yang dipilih: ");
                                            String nama = input.nextLine();

                                            Hero hero = party.pilihHero(nama);

                                            if (hero != null){
                                                party.tambahDiAwal(hero);
                                            }

                                            break;
                                        }

                                        case 2: {
                                            if (party.sudahPenuh()){
                                                System.out.println("Party sudah penuh!");
                                                break;
                                            }

                                            party.tampilkanSemuaHero();

                                            System.out.print("Nama hero yang dipilih: ");
                                            String nama = input.nextLine();

                                            Hero hero = party.pilihHero(nama);

                                            if (hero != null) {
                                                party.tambahDiAkhir(hero);
                                            }

                                            break;
                                        }

                                        case 0:
                                            break;

                                        default:
                                            System.out.println("Pilihan tidak valid!");
                                    }


                                }while (menuAtur != 0);

                                break;
                            }

                            case 3: {
                                if (party.isEmpty()){
                                    System.out.println(
                                        "Party masih kosong!"
                                    );
                                    break;
                                }

                                party.transversalMaju();

                                System.out.print("Nama hero yang ingin dihapus: ");
                                String nama = input.nextLine();

                                party.removehero(nama);
                                break;
                            }

                            case 4:
                                System.out.println("\n=============== PARTY SAAT INI ===============");
                                party.transversalMaju();
                                break;

                            case 0:
                                break;

                            default:
                                System.out.println(
                                    "Pilihan tidak valid!"
                                );
                        }

                    } while (menuHero != 0);

                    break;
                }

                case 2:
                    bossFight.showChar(input);
                    break;

                case 3:
                    circular.tampilkanMenu(input); 

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
