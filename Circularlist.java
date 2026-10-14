import java.util.Scanner;
public class Circularlist {
    NodeSingleCircular head;
    NodeSingleCircular current;
    public Circularlist() {
        buatCircularList();
    }
    private void buatCircularList() {
        tambahSenjata(new Role(
            "Hero", "Boss", "NPC",
            "PEDANG", 100, 1, "Sword"
        ));
        tambahSenjata(new Role(
            "Hero", "Boss", "NPC",
            "PANAH", 100, 1, "Bow"
        ));
        tambahSenjata(new Role(
            "Hero", "Boss", "NPC",
            "TOMBAK", 100, 1, "Polearm"
        ));
        tambahSenjata(new Role(
            "Hero", "Boss", "NPC",
            "PERISAI", 100, 1, "Shield"
        ));
        current = head;
    }
    private void tambahSenjata(Role senjata) {
        NodeSingleCircular baru =
            new NodeSingleCircular(senjata);
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
            System.out.println("1. Beli");
            System.out.println("0. Kembali ke Menu Utama");
            System.out.println();
            System.out.println("Senjata berganti otomatis setiap 10 detik.");
            System.out.println(
                "Tekan Enter untuk tetap menunggu."
            );
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
                            System.out.println("Maaf, fitur pembelian belum tersedia (masih coming soon >_<)");
                            System.out.println();
                            System.out.println("1. Lanjut melihat toko");
                            System.out.println("0. Kembali ke Menu Utama");
                            System.out.print("Pilihan: ");
                            String keputusan = input.nextLine().trim();
                            if (keputusan.equals("1")) {
                                // Tetap pada senjata saat ini.kayak jeda ges nanti kalo lanjut loop luar akan memulai hitungan 10 detik dari awal.
                            } else if (keputusan.equals("0")) {
                                berjalan = false;
                            } else {
                                System.out.println(
                                    "Pilihan tidak valid."
                                );
                                System.out.println(
                                    "Kembali ke menu utama..."
                                );
                                berjalan = false;
                            }
                        } else if (!pilihan.isEmpty()) {
                            System.out.println("Pilihan tidak valid.");
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
        System.out.println("             WEAPON SHOP");
        System.out.println("====================================");
        System.out.println(
            "Nama  : " + current.player.getName()
        );
        System.out.println(
            "Tipe  : " + current.player.getWeapon()
        );
        System.out.println("Level : Legendaris");
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