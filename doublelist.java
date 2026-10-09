class Node{
    String nama;
    int level;
    Node next;
    Node prev;

    Node(String nama, int level){
        this.nama = nama;
        this.level = level;
        this.next = null;
        this.prev = null;
    }
}

class DoubleList{
    Node head;
    Node tail;

    DoubleList(){
        head = null;
        tail = null;
    }

    void tambahDiAkhir(String nama, int level){
        Node baru = new Node(nama, level);
        if (head == null) {
            head = baru;
            tail = baru;
            return;
        }

        tail.next = baru;
        baru.prev = tail;

        tail = baru;
    }

    //kali ini prepand
    void tambahDiAwal(String nama, int level){
        Node baru = new Node(nama, level);

        if (head == null){
            head = baru;
            tail = baru;
            return;
        }

        baru.next = head;
        head.prev = baru;

        head = baru;
    }

    //transversal
    void transversalMaju(){
        Node current = head;

        while (current != null){
            System.out.println(current.nama + " - Lv." + current.level);
            current = current.next;
        }
    }

    void transversalMundur(){
        Node current = tail;

        while (current != null){
            System.out.println(current.nama + " - Lv." + current.level);
            current = current.prev;
        }
    }
}
