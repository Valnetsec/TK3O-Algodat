
public class Doublelist{
    NodeDouble head;
    NodeDouble tail;
    private int size = 0;
    private final int MAX_TIMHERO = 4;

    public int getsize(){
        return size;
    }
    public boolean sudahpenuh(){
        return size >= MAX_TIMHERO;
    }
    
    // Membuat list kosong
    public Doublelist(){
        head = null;
        tail = null;
    }

    // Append: tambah di akhir
    public void tambahDiAkhir(Role player){
        if(sudahpenuh()){
            System.out.println("Tim hero sudah penuh, tidak bisa menambahkan hero baru.");
            return;
        }
        NodeDouble baru = new NodeDouble(player);

        if (head == null){
            head = baru;
            tail = baru;
            size++;
            return;
        }

        tail.next = baru;
        baru.prev = tail;
        tail = baru;
        size++;
    }

    // Prepend: tambah di awal
    public void tambahDiAwal(Role player){
        if(sudahpenuh()){
            System.out.println("Tim hero sudah penuh, tidak bisa menambahkan hero baru.");
            return;
        }
        NodeDouble baru = new NodeDouble(player);

        if (head == null) {
            head = baru;
            tail = baru;
            size++;
            return;
        }

        baru.next = head;
        head.prev = baru;
        head = baru;

        size++;
    }

    // Traversal maju
    public void transversalMaju(){
        NodeDouble current = head;

        while (current != null) {
            Role player = current.player;

            System.out.println(player.getName() + " - Lv. " + player.getLevel() + " - HP: " + player.getHp() + " - Weapon: " + player.getWeapon());

            current = current.next;
        }
    }

    // Traversal mundur
    public void transversalMundur(){
        NodeDouble current = tail;

        while (current != null) {
            Role player = current.player;

            System.out.println(player.getName() + " - Lv. " + player.getLevel() + " - HP: " + player.getHp() + " - Weapon: " + player.getWeapon());

            current = current.prev;
        }
    }

    // Memeriksa apakah list kosong
    public boolean isEmpty(){
        return head == null;
    }

    //bagian remove
    public boolean removehero(String name){
        NodeDouble current = head;

        while(current != null && !current.player.getName().equalsIgnoreCase(name)){
            current = current.next;
        }
        if(current == null){
            System.out.println("Hero tidak ditemukan");
            return false;
        }

        //semisal node = head
        if(current == head){
            head = current.next;
            if(head != null){
                head.prev = null;
            }else{
                tail = null;
            }
        }
        //semisal node = tail
        else if(current == tail){
            tail = current.prev;
            if(tail != null){
                tail.next = null;
            }
        }
        //semisal case nya tuh nodenya di tengah
        else{
            current.prev.next = current.next;
            current.next.prev = current.prev;
        }

        size--;   //ntar deh
        System.out.println("Hero " + name + " berhasil dihapus");
        return true;
    }
}
