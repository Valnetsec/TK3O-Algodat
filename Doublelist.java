
public class Doublelist{
    NodeDouble head;
    NodeDouble tail;

    private int size = 0;
    private final int MAX_TIMHERO = 4;

    // data hero statis
    private static final Hero POLLUX = new Hero("DPS", "Pollux", 1100, 70, "Unknown");
    private static final Hero CASTOR = new Hero("Shield", "Castor", 800, 66, "Unknown");
    private static final Hero RAMONA = new Hero("Support", "Ramona", 500, 50, "Unknown");
    private static final Hero OGIER = new Hero("DPS", "Ogier", 800, 66, "Sword");
    private static final Hero ERICA = new Hero("Support", "Erica", 700, 60, "Unknown");
    private static final Hero AVGUST = new Hero("DPS", "Avgust", 720, 62, "Unknown");
    
    // Membuat 4 slot party sejak awal
    public Doublelist() {
        head = null;
        tail = null;

        for (int i = 0; i < MAX_TIMHERO; i++){
            NodeDouble baru = new NodeDouble(null);

            if (head == null){
                head = baru;
                tail = baru;
            } else {
                tail.next = baru;
                baru.prev = tail;
                tail = baru;
            }
        }
    }

    // Menghitung hero yang terisi
    public int getsize(){
        return size;
    }

    // Mengecek apakah semua slot terisi
    public boolean sudahpenuh(){
        return size >= MAX_TIMHERO;
    }

    // Mengecek apakah party kosong
    public boolean isEmpty(){
        return size == 0;
    }

    // Mencari slot berdasarkan nomor posisi (1-4)
    private NodeDouble getSlot(int posisi){
        if (posisi < 1 || posisi > MAX_TIMHERO){
            return null;
        }

        NodeDouble current = head;

        for (int i = 1; i < posisi; i++){
            current = current.next;
        }

        return current;
    }

    // Mencegah hero yang sama masuk dua kali
    private boolean heroSudahAda(Hero player){
        if (player == null) {
            return false;
        }

        NodeDouble current = head;

        while (current != null) {
            if (current.player != null && current.player.getName().equalsIgnoreCase(player.getName())){
                return true;
            }

            current = current.next;
        }

        return false;
    }

    // Menghitung ulang jumlah hero yang terisi
    private void hitungSize(){
        size = 0;

        NodeDouble current = head;

        while (current != null) {
            if (current.player != null){
                size++;
            }

            current = current.next;
        }
    }

    // PREPEND: memasukkan hero ke posisi pertama
    
    public void tambahDiAwal(Hero player){
        if (player == null) {
            System.out.println("Hero tidak valid.");
            return;
        }

        if (heroSudahAda(player)){
            System.out.println("Hero " + player.getName() + " sudah ada di party.");
            return;
        }

        if (sudahpenuh()){
            System.out.println(
                "Tim hero sudah penuh, tidak bisa menambahkan hero baru."
            );
            return;
        }

        // Cari slot kosong paling depan
        NodeDouble current = head;

        while (current != null && current.player != null){
            current = current.next;
        }

        if (current == null){
            System.out.println("Tidak ada slot kosong.");
            return;
        }

        // Geser hero ke kanan sampai slot kosong
        while (current != head){
            current.player = current.prev.player;
            current = current.prev;
        }

        // Isi posisi pertama dengan hero baru
        head.player = player;

        hitungSize();

        System.out.println(
            "Hero " + player.getName() +
            " berhasil ditambahkan di depan."
        );
    }


    // APPEND: memasukkan hero setelah posisi terisi terakhir
    public void tambahDiAkhir(Hero player) {
        if (player == null) {
            System.out.println("Hero tidak valid.");
            return;
        }

        if (heroSudahAda(player)) {
            System.out.println("Hero " + player.getName() + " sudah ada di party.");
            return;
        }

        if (sudahpenuh()){
            System.out.println("Tim hero sudah penuh, tidak bisa menambahkan hero baru.");
            return;
        }

        // Cari posisi hero yang terisi paling akhir
        int posisiTerakhir = 0;
        int posisi = 1;

        NodeDouble current = head;

        while (current != null){
            if (current.player != null) {
                posisiTerakhir = posisi;
            }

            current = current.next;
            posisi++;
        }

        // Masukkan hero setelah hero terakhir
        int posisiBaru = posisiTerakhir + 1;

        NodeDouble slot = getSlot(posisiBaru);

        if (slot == null) {
            System.out.println("Tidak ada slot kosong.");
            return;
        }

        slot.player = player;
        hitungSize();

        System.out.println(
            "Hero " + player.getName() +
            " berhasil ditambahkan di belakang."
        );
    }

    // REMOVE: mengosongkan slot tanpa menghapus node
    public boolean removehero(String name){
        NodeDouble current = head;

        while (current != null){
            if (current.player != null &&
                current.player.getName().equalsIgnoreCase(name)){

                // Slot tetap ada, hanya hero-nya yang dihapus
                current.player = null;

                hitungSize();
                System.out.println("Hero " + name +" berhasil dihapus dari party.");

                return true;
            }

            current = current.next;
        }

        System.out.println("Hero tidak ditemukan.");
        return false;
    }

    // Menampilkan seluruh posisi, termasuk slot kosong
    public void transversalMaju() {
        NodeDouble current = head;
        int posisi = 1;

        while (current != null) {
            System.out.print("Posisi " + posisi + ": ");

            if (current.player == null) {
                System.out.println("[KOSONG]");
            } else {
                System.out.println(current.player.getName() + " | HP: " + current.player.getHp() +  " | Level: " + current.player.getLevel() + " | Weapon: " + current.player.getWeapon()
                );
            }
            current = current.next;
            posisi++;
        }
    }
}
