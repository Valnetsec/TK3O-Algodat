import java.util.Scanner;

public class Singlelist {
    NodeBoss head;

    public Singlelist() {
        tambahBoss(new BossFight(
            "Voldemort", 10000,1, "Wand (Yew)",
            10, "Nagini"
        ));

        tambahBoss(new BossFight(
            "Gellert Grindelwald", 20000,1, "The Elder Wand",
            30, "Qilin"
        ));

        tambahBoss(new BossFight(
            "Salazar Slytherin", 30000,1, "Wand (snakewood)",
            50, "Basilisk"
        ));
    }

    private void tambahBoss(BossFight boss) {
        NodeBoss nodeBaru = new NodeBoss(boss);

        if (head == null) {
            head = nodeBaru;
        } else {
            NodeBoss checkNode = head;

            while (checkNode.next != null) {
                checkNode = checkNode.next;
            }

            checkNode.next = nodeBaru;
        }
    }

    public void showChar(Scanner input) {
        boolean berjalan = true;

        while (berjalan) {
            bersihkanLayar();

            System.out.println("================================");
            System.out.println("           BOSS FIGHT");
            System.out.println("================================");
            System.out.println("1. Voldemort");
            System.out.println("2. Gellert Grindelwald");
            System.out.println("3. Salazar Slytherin");
            System.out.println("0. Kembali ke Menu Utama");
            System.out.println("================================");
            System.out.print("Pilih Boss: ");

            String pilihan = input.nextLine();

            switch (pilihan) {
                case "1":
                    berjalan = tampilkanBoss(1, input);
                    break;

                case "2":
                    berjalan = tampilkanBoss(2, input);
                    break;

                case "3":
                    berjalan = tampilkanBoss(3, input);
                    break;

                case "0":
                    berjalan = false;
                    break;

                default:
                    System.out.println("Pilihan tidak valid!");
                    System.out.println("Tekan Enter untuk lanjut...");
                    input.nextLine();
            }
        }

        bersihkanLayar();
        System.out.println("Kembali ke menu utama...");
    }

    private boolean tampilkanBoss(int nomor, Scanner input) {
        NodeBoss checkNode = head;

        for (int i = 1; i < nomor; i++) {
            checkNode = checkNode.next;
        }

        BossFight boss = checkNode.player;

        bersihkanLayar();

        System.out.println("================================");
        System.out.println("         DESKRIPSI BOSS");
        System.out.println("================================");
        System.out.println("Nama       : " + boss.getName());
        System.out.println("HP         : " + boss.getHp());
        System.out.println("Weapon     : " + boss.getWeapon());
        System.out.println("Domain     : " + boss.getDomain() + " km");
        System.out.println("Peliharaan : " + boss.getPeliharaanMonster());
        System.out.println("================================");

        System.out.println();
        System.out.println("1. Kembali ke Menu Boss");
        System.out.println("0. Kembali ke Menu Utama");
        System.out.print("Pilihan: ");

        String pilihan = input.nextLine();

        bersihkanLayar();

        if (pilihan.equals("1")) {
            return true;
        } else if (pilihan.equals("0")) {
            return false;
        } else {
            System.out.println("Pilihan tidak valid!");
            System.out.println("Kembali ke Menu Boss...");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            return true;
        }
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