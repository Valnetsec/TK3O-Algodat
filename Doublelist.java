
public class Doublelist {
    NodeDouble head;
    NodeDouble tail;

    // Membuat list kosong
    public Doublelist() {
        head = null;
        tail = null;
    }

    // Append: tambah di akhir
    public void tambahDiAkhir(Atribut player) {
        NodeDouble baru = new NodeDouble(player);

        if (head == null) {
            head = baru;
            tail = baru;
            return;
        }

        tail.next = baru;
        baru.prev = tail;
        tail = baru;
    }

    // Prepend: tambah di awal
    public void tambahDiAwal(Atribut player) {
        NodeDouble baru = new NodeDouble(player);

        if (head == null) {
            head = baru;
            tail = baru;
            return;
        }

        baru.next = head;
        head.prev = baru;
        head = baru;
    }

    // Traversal maju
    public void transversalMaju() {
        NodeDouble current = head;

        while (current != null) {
            Atribut player = current.player;

            System.out.println(
                player.getName()
                + " - Lv." + player.getLevel()
                + " - HP: " + player.getHp()
            );

            current = current.next;
        }
    }

    // Traversal mundur
    public void transversalMundur() {
        NodeDouble current = tail;

        while (current != null) {
            Atribut player = current.player;

            System.out.println(
                player.getName()
                + " - Lv." + player.getLevel()
            );

            current = current.prev;
        }
    }

    // Memeriksa apakah list kosong
    public boolean isEmpty() {
        return head == null;
    }
}
