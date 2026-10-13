
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
            tampilkanSenjata();

            System.out.println();
            System.out.println("1. Beli");
            System.out.println("0. Kembali ke Menu Utama");
            System.out.println();
            System.out.println(
                "Senjata berganti otomatis setiap 10 detik."
            );
            System.out.print(
                "Pilihan (tekan Enter untuk menunggu): "
            );

            long mulai = System.currentTimeMillis();
            long durasi = 10_000;
            boolean selesai = false;

            while (!selesai) {
                long sisa = durasi -
                    (System.currentTimeMillis() - mulai);

                if (sisa <= 0) {
                    current = current.next;
                    break;
                }

                try {
                    if (System.in.available() > 0) {
                        String pilihan = input.nextLine().trim();

                        if (pilihan.equals("0")) {
                            berjalan = false;
                            selesai = true;
                        } else if (pilihan.equals("1")) {
                            System.out.println(
                                "Fitur beli belum tersedia."
                            );
                            System.out.println(
                                "Menunggu pergantian senjata..."
                            );
                        } else if (!pilihan.isEmpty()) {
                            System.out.println(
                                "Pilihan tidak valid."
                            );
                        }
                    }

                    Thread.sleep(100);
                } catch (Exception e) {
                    berjalan = false;
                    selesai = true;
                }
            }
        }

        System.out.println("Kembali ke menu utama...");
        return;
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
}