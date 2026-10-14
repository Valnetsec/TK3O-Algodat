
import java.util.Scanner;

public class Circularlist {
    NodeSingleCircular head;
    NodeSingleCircular current;

    public Circularlist() {
        buatCircularList();
    }

    private void buatCircularList() {
        tambahSenjata("Gladius Aeternum", "Sword", "S");
        tambahSenjata("Arcus Caelestis", "Bow", "SS");
        tambahSenjata("Hasta Invicta", "Polearm", "SS+");
        tambahSenjata("Scutum Divinum", "Shield", "L");

        current = head;
    }

    private void tambahSenjata(String nama, String tipe, String level) {
        NodeSingleCircular baru = new NodeSingleCircular(nama, tipe, level);

        if (head == null) {
            head = baru;
            head.next = head;
        } else {
            NodeSingleCircular tail = head;

            while (tail.next != head) {
                tail = tail.next;
            }

            tail.next = baru;
            baru.next = head;
        }
    }

    public void tampilkanMenu(Scanner input) {
        boolean berjalan = true;

        while (berjalan) {
            bersihkanLayar();
            tampilkanSenjata();

            System.out.println();
            System.out.println("1. Claim senjata ini");
            System.out.println("0. Kembali ke Menu Utama");
            System.out.println();
            System.out.println(
                "Senjata berganti otomatis setiap 10 detik ^_^."
            );
            System.out.println("Tekan Enter untuk tetap menunggu.");

            long mulai = System.currentTimeMillis();
            long durasi = 10_000;
            boolean selesai = false;

            while (!selesai) {
                long sisa = durasi -
                    (System.currentTimeMillis() - mulai);

                if (sisa <= 0) {
                    current = current.next;
                    selesai = true;
                    break;
                }

                try {
                    if (System.in.available() > 0) {
                        String pilihan = input.nextLine().trim();

                        if (pilihan.equals("0")) {
                            berjalan = false;
                            selesai = true;

                        } else if (pilihan.equals("1")) {
                            selesai = true;
                            bersihkanLayar();

                            System.out.println(
                                "Maaf, item coming soon hhe."
                            );
                            System.out.println();
                            System.out.println("1. Lanjut melihat toko");
                            System.out.println("0. Kembali ke Menu Utama");
                            System.out.print("Pilihan: ");

                            String keputusan = input.nextLine().trim();

                            if (keputusan.equals("1")) {
                                // Lanjut melihat senjata saat ini
                            } else if (keputusan.equals("0")) {
                                berjalan = false;
                            } else {
                                System.out.println("Pilihan tidak valid.");
                                berjalan = false;
                            }
                        }
                    }

                    Thread.sleep(100);

                } catch (Exception e) {
                    berjalan = false;
                    selesai = true;
                }
            }
        }

        bersihkanLayar();
        System.out.println("Kembali ke menu utama...");
    }

    private void tampilkanSenjata() {
        System.out.println();
        System.out.println("====================================");
        System.out.println("             Weakly Event");
        System.out.println("====================================");
        System.out.println("Nama  : " + current.nama);
        System.out.println("Tipe  : " + current.tipe);
        System.out.println("Greade : " + current.level);
        System.out.println("====================================");
    }

    private void bersihkanLayar() {
        try {
            new ProcessBuilder("cmd", "/c", "cls")
                .inheritIO()
                .start()
                .waitFor();
        } catch (Exception e) {
            System.out.println("\n".repeat(30));
        }
    }
}
